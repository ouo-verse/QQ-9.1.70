package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.util.CommonUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;

/* loaded from: classes33.dex */
public class CrashProtectInterceptor extends BaseInterceptor {
    private static final String TAG = "MiniGameVACrashProtectInterceptor";
    private static final String TEXT_CONFIG_INTERCEPT_CRASH_BLOCK = "\u62e6\u622a\u5931\u8d25\uff0ccrash\u6b62\u8840";
    private final AtomicBoolean needCrashIntercept = new AtomicBoolean(false);

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
        if (isCrashProtectBlock(BaseApplication.getContext(), interceptRequest.appId, true)) {
            boolean isAppInstalled = interceptRequest.canJumpApp() ? PackageUtil.isAppInstalled(interceptRequest.getContext(), appConfig.getGameAppPkgName()) : false;
            QLog.d(TAG, 1, "interceptLaunch isCrashProtectBlock isAppInstalled:" + isAppInstalled);
            if (isAppInstalled) {
                MiniGameVAUtil.launchGameApp(interceptRequest.getContext(), appConfig, interceptRequest.gameData, interceptRequest.getCallback(), interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
                return;
            }
            interceptRequest.getCallback().onInterceptResult(false, false);
            MiniGameVAUtil.showDebugToast(TEXT_CONFIG_INTERCEPT_CRASH_BLOCK);
            MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "3", "6", "", System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleIntercept not crash block.");
        }
        BaseInterceptor baseInterceptor = this.nextInterceptor;
        if (baseInterceptor != null) {
            baseInterceptor.handleIntercept(interceptRequest);
        }
    }

    public boolean isCrashProtectBlock(final Context context, final String str, boolean z16) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig;
        if (this.needCrashIntercept.get()) {
            QLog.d(TAG, 1, "crashProtectBlock needCrashIntercept appId:" + str);
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 2, "crashProtectBlock ignore because appId invalid");
            return false;
        }
        final Pair<Boolean, String> isDexBlockApp = ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isDexBlockApp(str);
        QLog.i(TAG, 2, "crashProtectBlock localCrashDexRecord:" + isDexBlockApp);
        if (isDexBlockApp.getFirst().booleanValue()) {
            QLog.i(TAG, 1, "crashProtectBlock appId:" + str + ", local crash times limit: " + isDexBlockApp + ", needCheckLastedDex:" + z16);
            if (z16) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.intercept.interceptor.CrashProtectInterceptor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).checkAndClearDexCrashRecord(context, str, (String) isDexBlockApp.getSecond());
                    }
                }, 128, null, false);
            }
            return true;
        }
        if (CommonUtil.isMountServiceHookFailed()) {
            return true;
        }
        if (!CommonUtil.isFenShenApp(context) || (miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID)) == null || !miniGameVAInterceptConfig.getIsDisableVAOnFenShenApp()) {
            return false;
        }
        QLog.i(TAG, 1, "crashProtectBlock interceptConfig.isDisableVAOnFenShenApp is true");
        return true;
    }

    public void updateCrashIntercept(boolean z16) {
        this.needCrashIntercept.set(z16);
        QLog.i(TAG, 1, "updateCrashIntercept crashIntercept:" + z16);
    }
}
