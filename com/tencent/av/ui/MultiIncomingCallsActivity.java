package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MultiIncomingCallsActivity extends BaseFragmentActivity {

    /* renamed from: a0, reason: collision with root package name */
    INTGaInviteFragmentPluginHelperApi f74889a0;

    public static boolean isShowing() {
        return ((INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class)).isShowing();
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public void init() {
        boolean z16;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.f74889a0 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = (INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class);
        this.f74889a0 = iNTGaInviteFragmentPluginHelperApi;
        Fragment init = iNTGaInviteFragmentPluginHelperApi.init(true);
        QLog.d("MultiIncomingCallsActivity", 1, "onCreate fragment=" + init + " needReplace=" + z16);
        beginTransaction.replace(R.id.cks, init);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f74889a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            iNTGaInviteFragmentPluginHelperApi.onBackPressed();
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fu9);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f74889a0 = null;
        QLog.d("MultiIncomingCallsActivity", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f74889a0;
        if (iNTGaInviteFragmentPluginHelperApi != null && iNTGaInviteFragmentPluginHelperApi.onKeyDown(i3, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f74889a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            iNTGaInviteFragmentPluginHelperApi.onNewIntent(intent);
        }
    }
}
