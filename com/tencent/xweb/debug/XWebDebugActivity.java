package com.tencent.xweb.debug;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.debug.b;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebDebugActivity extends AppCompatActivity {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // com.tencent.xweb.debug.b.a
        public void a() {
            XWebDebugActivity.this.finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebDebugCfg.getInst().load(this);
        if (!WebDebugCfg.getInst().getEnableLocalDebug()) {
            x0.c("XWebDebugActivity", "local debug is disabled, finish");
            finish();
        }
        setContentView(R.layout.i8h);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        new c(this, (FrameLayout) findViewById(R.id.uet)).a(new a());
    }
}
