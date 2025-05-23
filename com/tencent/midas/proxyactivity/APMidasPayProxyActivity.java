package com.tencent.midas.proxyactivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.plugin.APPluginProxyActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class APMidasPayProxyActivity extends APPluginProxyActivity {
    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        APLog.i("APMidasPayProxyActivity", "onActivityResult requestCode:" + i3 + " resultCode:" + i16);
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
