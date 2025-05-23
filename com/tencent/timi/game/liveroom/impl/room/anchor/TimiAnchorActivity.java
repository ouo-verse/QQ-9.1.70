package com.tencent.timi.game.liveroom.impl.room.anchor;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.dz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiAnchorActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private IAegisLogApi f377377a0 = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: b0, reason: collision with root package name */
    private QPublicBaseFragment f377378b0;

    private QPublicBaseFragment F2(Bundle bundle) {
        TimiAnchorFragment timiAnchorFragment = new TimiAnchorFragment();
        timiAnchorFragment.setArguments(bundle);
        return timiAnchorFragment;
    }

    public static void G2(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setClass(context, TimiAnchorActivity.class);
        intent.putExtra("public_fragment_class", TimiAnchorFragment.class.getName());
        context.startActivity(intent);
    }

    public static Intent insertJumpDestination(Context context, Intent intent) {
        if (intent == null) {
            return new Intent();
        }
        intent.setClass(context, TimiAnchorActivity.class);
        intent.putExtra("public_fragment_class", TimiAnchorFragment.class.getName());
        return intent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16 = true;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment == null || !qPublicBaseFragment.needDispatchTouchEvent() || !this.f377378b0.dispatchTouchEvent(motionEvent)) {
            z16 = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onActivityResult(i3 & 65535, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        QPublicBaseFragment F2 = F2(getIntent().getExtras());
        this.f377378b0 = F2;
        if (F2 != null) {
            this.mNeedStatusTrans = F2.needStatusTrans();
            this.mActNeedImmersive = this.f377378b0.needImmersive();
            this.f377378b0.initWindowStyleAndAnimation(this);
        }
        if (bundle != null) {
            if (QLog.isColorLevel()) {
                this.f377377a0.i(" TimiAnchorActivity", 1, "Activity restored, set classloader.");
            }
            dz.a(bundle, getClass().getClassLoader());
        }
        super.doOnCreate(bundle);
        setContentView(R.layout.f167552aj);
        if (this.f377378b0 == null) {
            finish();
            return false;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, this.f377378b0);
        beginTransaction.commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null && qPublicBaseFragment.doOnKeyDown(i3, keyEvent)) {
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment == null || !qPublicBaseFragment.overrideFinish()) {
            superFinish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getCIOPageName() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.getCIOPageName();
        }
        return super.getCIOPageName();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        resources.updateConfiguration(resources.getConfiguration(), GlobalDisplayMetricsManager.sQQDisplayMetrics);
        return resources;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isSupportScreenShot() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null && !qPublicBaseFragment.isSupportScreenShot()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            return qPublicBaseFragment.isWrapContent();
        }
        return super.getNeedGestureBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        super.onAccountChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onAccountChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment == null) {
            return super.onBackEvent();
        }
        return qPublicBaseFragment.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean z16) {
        super.onMultiWindowModeChanged(z16);
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onMultiWindowModeChanged(z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPreThemeChanged() {
        super.onPreThemeChanged();
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onPreThemeChanged();
        }
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.onWindowFocusChanged(z16);
        }
    }

    @Override // mqq.app.AppActivity
    public void superFinish() {
        QPublicBaseFragment qPublicBaseFragment = this.f377378b0;
        if (qPublicBaseFragment != null) {
            qPublicBaseFragment.beforeFinish();
        }
        super.finish();
        QPublicBaseFragment qPublicBaseFragment2 = this.f377378b0;
        if (qPublicBaseFragment2 != null) {
            qPublicBaseFragment2.onFinish();
        }
    }

    public String toString() {
        String obj = super.toString();
        if (this.f377378b0 != null) {
            String str = obj + "#" + this.f377378b0.getClass().getName() + "@" + Integer.toHexString(this.f377378b0.hashCode());
            String businessDescription = this.f377378b0.getBusinessDescription();
            if (!TextUtils.isEmpty(businessDescription)) {
                String trim = businessDescription.trim();
                if (trim.length() > 50) {
                    trim = trim.substring(0, 50);
                }
                return str + "{" + trim + "}";
            }
            return str;
        }
        if (getIntent() != null && getIntent().getStringExtra("public_fragment_class") != null) {
            return obj + "#" + getIntent().getStringExtra("public_fragment_class");
        }
        return obj;
    }
}
