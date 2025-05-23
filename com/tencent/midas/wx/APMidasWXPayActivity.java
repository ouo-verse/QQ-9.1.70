package com.tencent.midas.wx;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class APMidasWXPayActivity extends Activity {
    private static final String TAG = "APMidasWXPayActivity";

    private void handleIntent(Intent intent) {
        APLog.d(TAG, "handleIntent get called!");
        try {
            APPluginInterfaceManager.initPluginInterface(this, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_HANDLE_WX_INTENT, new Object[]{this, intent});
        } catch (Exception e16) {
            APLog.e(TAG, "handleIntent got exception = " + e16.toString());
            e16.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getIntent().getStringExtra("wxpay");
            try {
                requestWindowFeature(1);
                handleIntent(getIntent());
                finish();
            } catch (Throwable th5) {
                th5.printStackTrace();
                finish();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            finish();
        }
    }
}
