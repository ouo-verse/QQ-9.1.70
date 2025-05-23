package com.tencent.mobileqq.qqvideoedit.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQVideoEditActivity extends CompatPublicActivity {
    private void G2(@NonNull Configuration configuration) {
        boolean J2 = J2();
        if (QLog.isDevelopLevel()) {
            QLog.d("QQVideoEditActivity", 2, "checkEscapeMultiLandscapeWindow shouldEscape:" + J2 + ", ori: " + configuration.orientation + configuration);
        }
        if (J2) {
            setRequestedOrientation(0);
        }
    }

    private boolean I2(Context context) {
        if (context == null) {
            return false;
        }
        String configuration = context.getResources().getConfiguration().toString();
        if (!configuration.contains("hw-magic-windows") && !configuration.contains("hwMultiwindow-magic") && !configuration.contains("miui-magic-windows") && !configuration.contains("multi-landscape")) {
            return false;
        }
        return true;
    }

    private boolean J2() {
        int i3 = getResources().getConfiguration().orientation;
        DeviceType a16 = PadUtil.a(this);
        boolean I2 = I2(this);
        if (QLog.isDevelopLevel()) {
            QLog.i("QQVideoEditActivity", 1, "isSysInMagicWindowState : " + I2 + "; getDeviceType : " + a16 + "; orientation : " + i3);
        }
        if (I2 && i3 == 1 && a16 == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, com.tencent.biz.richframework.activity.ComponentBaseActivity, com.tencent.richframework.preload.activity.ArgusFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        G2(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        super.onCreate(bundle);
        F2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        H2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.activity.ComponentBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        G2(getResources().getConfiguration());
    }

    private void F2() {
    }

    private void H2() {
    }
}
