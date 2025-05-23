package com.tencent.qqmini.sdk.action;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class RestartAction implements Action<Boolean> {
    private static final String TAG = "RestartAction";
    private String path = null;

    private void finishActivity(BaseRuntime baseRuntime) {
        if (baseRuntime != null) {
            com.tencent.qqmini.sdk.utils.a.b(baseRuntime, MiniAppConst.RuntimeCloseType.RESTART_ACTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchNewMiniGame(MiniAppInfo miniAppInfo) {
        if (!TextUtils.isEmpty(this.path)) {
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            firstPageInfo.pagePath = this.path;
            miniAppInfo.firstPage = firstPageInfo;
        } else {
            FirstPageInfo firstPageInfo2 = new FirstPageInfo();
            firstPageInfo2.pagePath = miniAppInfo.launchParam.entryPath;
            miniAppInfo.firstPage = firstPageInfo2;
        }
        miniAppInfo.launchParam.forceReload = 7;
        MiniAppLauncher.launchMiniApp((Activity) null, miniAppInfo, (Bundle) null, (ResultReceiver) null);
        QMLog.i(TAG, "miniGame do restart.");
    }

    public static RestartAction obtain() {
        return new RestartAction();
    }

    private void resetMiniAppInfo(MiniAppInfo miniAppInfo) {
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            miniAppInfo.firstPage.pagePath = "";
        }
        if (!TextUtils.isEmpty(miniAppInfo.launchParam.entryPath)) {
            miniAppInfo.launchParam.entryPath = "";
        }
    }

    public static void restart(IMiniAppContext iMiniAppContext) {
        iMiniAppContext.performAction(new RestartAction());
    }

    private boolean restartMiniGame(Activity activity, BaseRuntime baseRuntime, MiniAppInfo miniAppInfo) {
        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
        if (jsPluginEngine instanceof JsPluginEngine) {
            ((JsPluginEngine) jsPluginEngine).onRestart();
        }
        boolean z16 = false;
        if (WnsConfig.getConfig("qqtriton", WnsConfig.MINI_GAME_CAPSULE_RESTART_FREE_CACHE, 0) == 1) {
            z16 = true;
        }
        if (z16) {
            QMLog.i(TAG, "restartAction clearGameCache");
            baseRuntime.setRuntimeLifecycleListener(new IRuntimeLifecycleListener() { // from class: com.tencent.qqmini.sdk.action.RestartAction.1
                @Override // com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener
                public void onDestroy(Context context, final MiniAppInfo miniAppInfo2) {
                    MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), miniAppInfo2, false, new Runnable() { // from class: com.tencent.qqmini.sdk.action.RestartAction.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RestartAction.this.launchNewMiniGame(miniAppInfo2);
                        }
                    });
                    QMLog.i(RestartAction.TAG, "restartAction freeCache");
                }
            });
            finishActivity(baseRuntime);
        } else {
            finishActivity(baseRuntime);
            launchNewMiniGame(miniAppInfo);
        }
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        if (baseRuntime == null) {
            QMLog.w(TAG, "restart perform runtime is null");
            return Boolean.FALSE;
        }
        MiniAppInfo miniAppInfo = baseRuntime.getMiniAppInfo();
        if (miniAppInfo == null) {
            QMLog.w(TAG, "restart perform miniAppInfo is null");
            return Boolean.FALSE;
        }
        QMLog.i(TAG, "restart " + miniAppInfo);
        Activity attachedActivity = baseRuntime.getAttachedActivity();
        if (baseRuntime.isMiniGame()) {
            return Boolean.valueOf(restartMiniGame(attachedActivity, baseRuntime, miniAppInfo));
        }
        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
        if (jsPluginEngine instanceof JsPluginEngine) {
            ((JsPluginEngine) jsPluginEngine).onRestart();
        }
        miniAppInfo.launchParam.forceReload = 7;
        resetMiniAppInfo(miniAppInfo);
        MiniAppLauncher.launchMiniApp(attachedActivity, miniAppInfo, (Bundle) null, (ResultReceiver) null);
        return Boolean.TRUE;
    }

    public static boolean restart(IMiniAppContext iMiniAppContext, String str) {
        RestartAction restartAction = new RestartAction();
        restartAction.path = str;
        return ((Boolean) iMiniAppContext.performAction(restartAction)).booleanValue();
    }
}
