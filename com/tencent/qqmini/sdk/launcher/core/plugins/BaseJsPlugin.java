package com.tencent.qqmini.sdk.launcher.core.plugins;

import android.content.Context;
import androidx.annotation.CallSuper;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* loaded from: classes23.dex */
public abstract class BaseJsPlugin implements IJsPlugin {
    public static final String EMPTY_RESULT = "{}";
    protected ApkgInfo mApkgInfo;
    protected Context mContext;
    protected boolean mIsContainer;
    protected boolean mIsDestroyed;
    protected boolean mIsMiniGame;
    protected IMiniAppContext mMiniAppContext;
    protected MiniAppInfo mMiniAppInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRuntimeForeground() {
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext instanceof BaseRuntime) {
            return ((BaseRuntime) iMiniAppContext).isForeground();
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
        this.mContext = iMiniAppContext.getContext();
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        this.mMiniAppInfo = miniAppInfo;
        this.mApkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
        this.mIsMiniGame = iMiniAppContext.isMiniGame();
        this.mIsContainer = iMiniAppContext.isContainer();
        this.mIsDestroyed = false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    @CallSuper
    public void onDestroy() {
        this.mIsDestroyed = true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendNativeViewEvent(RequestEvent requestEvent, int i3) {
        if (!this.mIsDestroyed) {
            this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void sendSubscribeEvent(String str, String str2) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, 0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendSubscribeEvent(String str, String str2, int i3, IJsService iJsService) {
        if (this.mIsDestroyed) {
            return;
        }
        this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, i3, iJsService));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onRestart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onStop() {
    }
}
