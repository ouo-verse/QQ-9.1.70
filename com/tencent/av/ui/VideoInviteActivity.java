package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.av.ui.fragment.api.INTInviteFragmentPluginHelperApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoInviteActivity extends BaseFragmentActivity {

    /* renamed from: a0, reason: collision with root package name */
    INTInviteFragmentPluginHelperApi f75175a0;

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
        if (this.f75175a0 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f75175a0 = (INTInviteFragmentPluginHelperApi) QRoute.api(INTInviteFragmentPluginHelperApi.class);
        Fragment init = this.f75175a0.init(this, com.tencent.av.r.g1(this));
        QLog.d("VideoInviteActivity", 1, "onCreate fragment=" + init + " needReplace=" + z16);
        if (z16) {
            beginTransaction.replace(R.id.cks, init);
        } else {
            beginTransaction.add(R.id.cks, init);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiuHaiUtils.initLiuHaiProperty(this);
        if (LiuHaiUtils.isLiuHaiUseValid() && LiuHaiUtils.enableNotch(this) && QLog.isDevelopLevel()) {
            QLog.w("VideoInviteActivity", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        INTInviteFragmentPluginHelperApi iNTInviteFragmentPluginHelperApi = this.f75175a0;
        if (iNTInviteFragmentPluginHelperApi != null) {
            iNTInviteFragmentPluginHelperApi.onBackPressed();
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
        this.f75175a0 = null;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        INTInviteFragmentPluginHelperApi iNTInviteFragmentPluginHelperApi = this.f75175a0;
        if (iNTInviteFragmentPluginHelperApi != null && iNTInviteFragmentPluginHelperApi.onKeyDown(i3, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        INTInviteFragmentPluginHelperApi iNTInviteFragmentPluginHelperApi = this.f75175a0;
        if (iNTInviteFragmentPluginHelperApi != null) {
            iNTInviteFragmentPluginHelperApi.onNewIntent(intent);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        ChatActivityUtils.R(this, i3, strArr, iArr);
    }
}
