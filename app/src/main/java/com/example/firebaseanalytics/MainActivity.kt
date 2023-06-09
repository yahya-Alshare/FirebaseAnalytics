package com.example.firebaseanalytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ktx.Firebase
import java.util.*
class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = Firebase.analytics
        button.setOnClickListener {
            SelectContentEvent("image1","ImageView","image")
        }

       button2.setOnClickListener {
            trakScreenEvent()
        }
    }
    fun SelectContentEvent(id:String,name:String,contentType:String){
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID,id)
            param(FirebaseAnalytics.Param.ITEM_NAME,name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,contentType)
        }


    }
    fun trakScreenEvent(){
        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(FirebaseAnalytics.Param.SCREEN_NAME,"main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"MainActivity")
        }

    }
}