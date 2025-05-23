package com.tencent.biz.richframework.activity;

import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.biz.richframework.compat.util.RFWCompactUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.preload.activity.ArgusFragmentActivity;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ComponentBaseActivity extends ArgusFragmentActivity {
    private static final String TAG = "ComponentBaseActivity";
    private boolean mNeedCheckBatchInput;

    private void setInnerFlag() {
        this.mNeedCheckBatchInput = true;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        RFWLog.i(TAG, RFWLog.USR, "onPause " + this);
        setInnerFlag();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        RFWLog.i(TAG, RFWLog.USR, "onResume :" + this.mNeedCheckBatchInput + this);
        if (this.mNeedCheckBatchInput) {
            this.mNeedCheckBatchInput = false;
            RFWCompactUtil.recoveryConsumeBatchedInputInAndroidR(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        setInnerFlag();
    }
}
