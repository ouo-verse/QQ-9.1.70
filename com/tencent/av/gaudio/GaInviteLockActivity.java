package com.tencent.av.gaudio;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.ui.fragment.api.INTGaInviteFragmentPluginHelperApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import mqq.app.BaseFragmentActivity;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GaInviteLockActivity extends BaseFragmentActivity {

    /* renamed from: a0, reason: collision with root package name */
    INTGaInviteFragmentPluginHelperApi f73823a0;

    public void BtnOnClick(View view) {
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            iNTGaInviteFragmentPluginHelperApi.btnOnClick(view);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        QLog.d("GaInviteLockActivity", 1, "finish", new Throwable());
    }

    public long getGroupId() {
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            return iNTGaInviteFragmentPluginHelperApi.getGroupId();
        }
        return 0L;
    }

    public int getUinType() {
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            return iNTGaInviteFragmentPluginHelperApi.getUinType();
        }
        return 0;
    }

    public void init() {
        boolean z16;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (this.f73823a0 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = (INTGaInviteFragmentPluginHelperApi) QRoute.api(INTGaInviteFragmentPluginHelperApi.class);
        this.f73823a0 = iNTGaInviteFragmentPluginHelperApi;
        Fragment init = iNTGaInviteFragmentPluginHelperApi.init(false);
        QLog.d("GaInviteLockActivity", 1, "onCreate fragment=" + init + " needReplace=" + z16);
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
            QLog.w("GaInviteLockActivity", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
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
        this.f73823a0 = null;
        QLog.d("GaInviteLockActivity", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
        if (iNTGaInviteFragmentPluginHelperApi != null && iNTGaInviteFragmentPluginHelperApi.onKeyDown(i3, keyEvent)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        INTGaInviteFragmentPluginHelperApi iNTGaInviteFragmentPluginHelperApi = this.f73823a0;
        if (iNTGaInviteFragmentPluginHelperApi != null) {
            iNTGaInviteFragmentPluginHelperApi.onNewIntent(intent);
        }
    }
}
