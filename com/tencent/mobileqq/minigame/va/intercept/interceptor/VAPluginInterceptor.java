package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import android.text.TextUtils;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes33.dex */
public class VAPluginInterceptor extends BaseInterceptor {
    private static final String TAG = "MiniGameVAVAPluginInterceptor";
    public static final String TEXT_CONFIG_INTERCEPT_NOT_INSTALL = "\u62e6\u622a\u5931\u8d25\uff0c\u672a\u5b89\u88c5va\u3001app";

    private boolean hasVaApkInstall(String str) {
        if (TextUtils.isEmpty(MiniBoxSDK.getDexVersion(BaseApplication.getContext()))) {
            return false;
        }
        return q.p(MiniBoxSDK.getApkPath(BaseApplication.getContext(), str));
    }

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
        if (!TextUtils.isEmpty(appConfig.getGameAppPkgName()) && !hasVaApkInstall(appConfig.getGameAppPkgName())) {
            QLog.i(TAG, 1, "handleIntercept hasVaApkInstall is false");
            boolean isAppInstalled = interceptRequest.canJumpApp() ? PackageUtil.isAppInstalled(BaseApplication.getContext(), appConfig.getGameAppPkgName()) : false;
            QLog.i(TAG, 1, "handleIntercept hasVaApkInstall is false isAppInstalled:" + isAppInstalled);
            if (isAppInstalled) {
                MiniGameVAUtil.launchGameApp(interceptRequest.getContext(), appConfig, interceptRequest.gameData, interceptRequest.getCallback(), interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
                return;
            }
            interceptRequest.getCallback().onInterceptResult(false, false);
            MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "3", "7", "", System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
            MiniGameVAUtil.showDebugToast(TEXT_CONFIG_INTERCEPT_NOT_INSTALL);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "va plugin is ok, next interceptor handle it");
        }
        BaseInterceptor baseInterceptor = this.nextInterceptor;
        if (baseInterceptor != null) {
            baseInterceptor.handleIntercept(interceptRequest);
        }
    }
}
