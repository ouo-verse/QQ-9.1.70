package com.tencent.mobileqq.apollo.store;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloStoreActivity extends QQBrowserActivity {

    /* renamed from: a0, reason: collision with root package name */
    private boolean f194388a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f194389b0 = 2.0f;

    /* renamed from: c0, reason: collision with root package name */
    private float f194390c0 = 1.0f;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f194391d0 = true;

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity start create!");
        G2(super.getIntent());
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity end create! use:" + (System.currentTimeMillis() - currentTimeMillis));
        return false;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f194388a0 = true;
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        QLog.d("ApolloStoreActivity", 2, "onConfigurationChanged orientation:" + configuration.orientation);
    }

    @Override // com.tencent.mobileqq.activity.QQBrowserActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16 && this.f194391d0) {
            this.f194391d0 = false;
        }
    }

    @Override // mqq.app.AppActivity
    public boolean showPreview() {
        super.showPreview();
        SystemBarActivityModule.setImmersiveStatus(this);
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp == null) {
            return true;
        }
        systemBarComp.init();
        int color = super.getResources().getColor(R.color.skin_color_title_immersive_bar);
        systemBarComp.setStatusColor(color);
        systemBarComp.setStatusBarColor(color);
        return true;
    }

    void G2(Intent intent) {
        if (intent == null) {
            return;
        }
        float fontLevel = FontSettingManager.getFontLevel() / 16.0f;
        this.f194390c0 = fontLevel;
        if (fontLevel != 0.0f) {
            this.f194389b0 = ah.q() / this.f194390c0;
        }
        if (this.f194389b0 == 0.0f) {
            this.f194389b0 = ah.q();
        }
    }
}
