package com.tencent.biz;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletToolFragmentActivity;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TenpayActivity extends QWalletToolFragmentActivity {
    @Override // cooperation.qwallet.plugin.QWalletToolFragmentActivity, com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // cooperation.qwallet.plugin.QWalletToolFragmentActivity, com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivityForTool, com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
