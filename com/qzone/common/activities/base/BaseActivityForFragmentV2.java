package com.qzone.common.activities.base;

import android.content.Intent;
import android.content.res.QUIProfileLayoutInflater;
import android.content.res.QZoneQUIProfileResources;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.util.QUIProfileConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseActivityForFragmentV2 extends BaseActivity implements FragmentRequestInterface {
    private ArrayList<WeakReference<ActivityCallBackInterface>> activityCallBackInterfaces;
    private Resources mQuiProfileResources = null;
    private LayoutInflater mQuiProfileLayoutInflater = null;

    private void handleAttachFragment(Object obj) {
        if (obj instanceof ActivityCallBackInterface) {
            if (this.activityCallBackInterfaces == null) {
                this.activityCallBackInterfaces = new ArrayList<>(2);
            }
            this.activityCallBackInterfaces.add(new WeakReference<>((ActivityCallBackInterface) obj));
        }
    }

    protected void dispatchOnActivityResult(int i3, int i16, Intent intent) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(getMainFragmentId());
        if (findFragmentById != null) {
            findFragmentById.onActivityResult(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        dispatchOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(getMainFragmentId());
        if (findFragmentById == null || !(findFragmentById instanceof BaseFragment)) {
            return;
        }
        ((BaseFragment) findFragmentById).onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableUseQUIProfileForQZone() {
        return com.qzone.reborn.feedx.util.ae.a();
    }

    public int getMainFragmentId() {
        return R.id.elo;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (enableUseQUIProfileForQZone()) {
            if (this.mQuiProfileResources == null) {
                this.mQuiProfileResources = new QZoneQUIProfileResources(super.getResources(), this, "qzone");
                be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
            }
            return this.mQuiProfileResources;
        }
        return super.getResources();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if ((systemService instanceof LayoutInflater) && enableUseQUIProfileForQZone()) {
                if (this.mQuiProfileLayoutInflater == null) {
                    this.mQuiProfileLayoutInflater = new QUIProfileLayoutInflater((LayoutInflater) systemService, this, "qzone");
                    be0.a.b("qzone").c(QUIProfileConstants.DEFAULT_COLOR_PALETTE);
                }
                return this.mQuiProfileLayoutInflater;
            }
        }
        return super.getSystemService(str);
    }

    @Override // com.qzone.common.activities.base.FragmentRequestInterface
    public boolean isAppInterfaceReady() {
        return super.isRumtimeReady();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof BaseFragment) {
            ((BaseFragment) fragment).setFragmentRequestInterface(this);
        }
        handleAttachFragment(fragment);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ActivityCallBackInterface activityCallBackInterface;
        ArrayList<WeakReference<ActivityCallBackInterface>> arrayList = this.activityCallBackInterfaces;
        if (arrayList != null) {
            Iterator<WeakReference<ActivityCallBackInterface>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<ActivityCallBackInterface> next = it.next();
                if (next != null && (activityCallBackInterface = next.get()) != null) {
                    activityCallBackInterface.onBackPressed();
                }
            }
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        ActivityCallBackInterface activityCallBackInterface;
        ArrayList<WeakReference<ActivityCallBackInterface>> arrayList = this.activityCallBackInterfaces;
        if (arrayList != null) {
            Iterator<WeakReference<ActivityCallBackInterface>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<ActivityCallBackInterface> next = it.next();
                if (next != null && (activityCallBackInterface = next.get()) != null && activityCallBackInterface.onKeyDown(i3, keyEvent)) {
                    return true;
                }
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity
    public void onUserLeaveHint() {
        ActivityCallBackInterface activityCallBackInterface;
        super.onUserLeaveHint();
        ArrayList<WeakReference<ActivityCallBackInterface>> arrayList = this.activityCallBackInterfaces;
        if (arrayList != null) {
            Iterator<WeakReference<ActivityCallBackInterface>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<ActivityCallBackInterface> next = it.next();
                if (next != null && (activityCallBackInterface = next.get()) != null) {
                    activityCallBackInterface.onUserLeaveHint();
                }
            }
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        ActivityCallBackInterface activityCallBackInterface;
        super.onWindowFocusChanged(z16);
        ArrayList<WeakReference<ActivityCallBackInterface>> arrayList = this.activityCallBackInterfaces;
        if (arrayList != null) {
            Iterator<WeakReference<ActivityCallBackInterface>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<ActivityCallBackInterface> next = it.next();
                if (next != null && (activityCallBackInterface = next.get()) != null) {
                    activityCallBackInterface.onWindowFocusChanged(z16);
                }
            }
        }
    }

    @Override // com.qzone.common.activities.base.FragmentRequestInterface
    public AppRuntime waitAppInterface() {
        return super.waitAppRuntime();
    }
}
