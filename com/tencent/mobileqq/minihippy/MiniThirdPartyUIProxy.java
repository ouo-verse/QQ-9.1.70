package com.tencent.mobileqq.minihippy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.DefaultNavigationBar;
import com.tencent.qqmini.sdk.widget.MiniLoadingUI;
import common.config.service.QzoneConfig;
import mu3.b;

/* loaded from: classes33.dex */
public class MiniThirdPartyUIProxy implements IUIProxy {
    private static final String TAG = "MiniHippyUIProxy";
    private boolean mIsDestroyed = false;
    private MiniLoadingUI mMiniLoadingUI;
    private final boolean mNeedLoading;
    private ViewGroup mRootLayout;
    private final b mRuntime;

    /* loaded from: classes33.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f247108d;

        a(Activity activity) {
            this.f247108d = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.btn_close) {
                this.f247108d.finish();
            }
        }
    }

    public MiniThirdPartyUIProxy(int i3) {
        this.mNeedLoading = i3 != 2;
        this.mRuntime = new b(i3);
    }

    private void a(Context context, ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        DefaultNavigationBar defaultNavigationBar = new DefaultNavigationBar(context, this.mRuntime);
        defaultNavigationBar.setContentDescription(QzoneConfig.MAIN_KEY_NAVIGATOR_BAR);
        defaultNavigationBar.getCapsuleButton().setListener(new d92.b(this.mRuntime));
        defaultNavigationBar.setId(mu3.a.f417630a);
        viewGroup.addView(defaultNavigationBar);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        ActivityResultManager.g().notifyActivityResultListener(i3, i16, intent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onAttachActivity(Activity activity, Bundle bundle, ViewGroup viewGroup) {
        QMLog.d(TAG, "onAttachActivity call.");
        MiniAppInfo miniAppInfo = bundle != null ? (MiniAppInfo) bundle.getParcelable(IPCConst.KEY_APPINFO) : null;
        this.mRootLayout = viewGroup;
        a(activity, (ViewGroup) viewGroup.findViewWithTag(ThirdPartyMiniPageProxy.TAG_HIPPY_NAVIGATION));
        if (this.mNeedLoading) {
            MiniLoadingUI miniLoadingUI = new MiniLoadingUI(activity);
            this.mMiniLoadingUI = miniLoadingUI;
            miniLoadingUI.h(miniAppInfo);
            this.mMiniLoadingUI.setMaskContainerShow();
            this.mMiniLoadingUI.setCustomClickListener(new a(activity));
            viewGroup.addView(this.mMiniLoadingUI);
        }
        this.mRuntime.onRuntimeCreate();
        this.mRuntime.onRuntimeAttachActivity(activity, viewGroup);
        this.mRuntime.loadMiniApp(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean onBackPressed(Activity activity) {
        return this.mRuntime.onBackPress();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniPause() {
        this.mRuntime.onRuntimePause();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        this.mRuntime.onRuntimeResume();
        MiniLoadingUI miniLoadingUI = this.mMiniLoadingUI;
        if (miniLoadingUI != null) {
            miniLoadingUI.m();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStart() {
        this.mRuntime.onRuntimeStart();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStop() {
        this.mRuntime.onRuntimeStop();
        MiniLoadingUI miniLoadingUI = this.mMiniLoadingUI;
        if (miniLoadingUI != null) {
            miniLoadingUI.n();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onDetachActivity(Activity activity) {
        this.mIsDestroyed = true;
        this.mRuntime.onRuntimeDetachActivity(activity);
        this.mRuntime.onRuntimeDestroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onIntentUpdate(Intent intent) {
        ViewGroup viewGroup;
        MiniLoadingUI miniLoadingUI;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.hashCode();
        if (!action.equals(ThirdPartyMiniPageProxy.ACTION_UPDATE_APP_INFO)) {
            if (action.equals(ThirdPartyMiniPageProxy.ACTION_HIPPY_LOAD_SUCCESS) && (viewGroup = this.mRootLayout) != null && (miniLoadingUI = this.mMiniLoadingUI) != null) {
                viewGroup.removeView(miniLoadingUI);
                this.mMiniLoadingUI.setCustomClickListener(null);
                this.mMiniLoadingUI = null;
            }
        } else {
            this.mRuntime.loadMiniApp((MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO));
        }
        QMLog.i(TAG, "onIntentUpdate: action=" + action);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void handleRestart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onRefreshMiniBadge(Activity activity, Bundle bundle) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void notifyExit(boolean z16, boolean z17, boolean z18) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onRequestPermissionsResult(Activity activity, int i3, String[] strArr, int[] iArr) {
    }
}
