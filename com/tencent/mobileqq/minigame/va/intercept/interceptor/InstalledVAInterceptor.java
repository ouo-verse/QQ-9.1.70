package com.tencent.mobileqq.minigame.va.intercept.interceptor;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.downloadui.MiniGameVAStartData;
import com.tencent.mobileqq.minigame.va.downloadui.VAInstallAppLoadingFragment;
import com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor;
import com.tencent.mobileqq.minigame.va.intercept.InterceptRequest;
import com.tencent.mobileqq.minigame.va.util.CommonUtil;
import com.tencent.mobileqq.minigame.va.util.DiffPatchHandler;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxService;
import fs3.MiniBoxInfo;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InstalledVAInterceptor extends BaseInterceptor {
    public static final String REPORT_SOURCE_FROM_VA_INSTALLED = "2";
    public static final String REPORT_SOURCE_FROM_VA_MMKV = "8";
    private static final String TAG = "MiniGameVAInstalledVAInterceptor";
    private volatile InterceptRequest interceptRequest;
    private long queryStartTime;
    private String reportSource = "";
    private AsyncCallback<MiniBoxAppInfo> installedCallBack = new AsyncCallback<MiniBoxAppInfo>() { // from class: com.tencent.mobileqq.minigame.va.intercept.interceptor.InstalledVAInterceptor.1
        @Override // com.tencent.minibox.business.api.AsyncCallback
        public void onResult(MiniBoxAppInfo miniBoxAppInfo) {
            try {
                InstalledVAInterceptor.this.onStartVA(miniBoxAppInfo);
            } catch (Exception e16) {
                QLog.e(InstalledVAInterceptor.TAG, 1, e16, new Object[0]);
            }
        }
    };

    private boolean checkLastUpdateVAToLaunch(int i3) {
        int parseIntSafety;
        InterceptRequest interceptRequest = this.interceptRequest;
        if (interceptRequest == null) {
            return false;
        }
        MiniGameDownloadDataWrapper lastUpdateVA = ((IMiniGameVAService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "")).getLastUpdateVA();
        if (lastUpdateVA == null) {
            lastUpdateVA = new MiniGameDownloadDataWrapper();
            MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
            miniGameDownloadData.setGameId(interceptRequest.getAppConfig().getMiniGameId());
            miniGameDownloadData.setVersionCode(String.valueOf(i3));
            miniGameDownloadData.setPkgName(interceptRequest.getAppConfig().getGameAppPkgName());
            lastUpdateVA.setData(miniGameDownloadData);
        }
        String versionCode = lastUpdateVA.getData().getVersionCode();
        if (TextUtils.isEmpty(versionCode) || (parseIntSafety = CommonUtil.parseIntSafety(versionCode)) <= i3) {
            return false;
        }
        QLog.d(TAG, 1, "interceptLaunch install loading, updateVersionCode:" + parseIntSafety + ", oldVersion:" + i3);
        MiniGameVAStartData miniGameVAStartData = new MiniGameVAStartData(interceptRequest.getAppConfig(), lastUpdateVA);
        miniGameVAStartData.setNeedInstall(true);
        launchVALoadingFragment(miniGameVAStartData, System.currentTimeMillis());
        MiniGameVAUtil.reportLaunch(interceptRequest.getAppConfig().getGameAppId(), "2", "5", versionCode, System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
        return true;
    }

    private void handleOnNotFound(Context context) {
        String str;
        InterceptRequest interceptRequest = this.interceptRequest;
        if (interceptRequest == null) {
            return;
        }
        MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
        if (interceptRequest.canJumpApp() ? PackageUtil.isAppInstalled(context, appConfig.getGameAppPkgName()) : false) {
            QLog.d(TAG, 1, "interceptLaunch no va launch game app");
            MiniGameVAUtil.launchGameApp(context, appConfig, interceptRequest.gameData, interceptRequest.getCallback(), interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
        } else {
            if (!checkLastUpdateVAToLaunch(0)) {
                QLog.d(TAG, 1, "interceptLaunch install loading, checkLastUpdateVAToLaunch failed");
                interceptRequest.getCallback().onInterceptResult(false, false);
                if (!TextUtils.isEmpty(this.reportSource)) {
                    str = this.reportSource;
                } else {
                    str = "2";
                }
                MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "3", str, "", System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
                return;
            }
            QLog.d(TAG, 1, "interceptLaunch install loading, checkLastUpdateVAToLaunch success");
        }
    }

    private void launchVALoadingFragment(MiniGameVAStartData miniGameVAStartData, final long j3) {
        if (this.interceptRequest == null) {
            return;
        }
        VAInstallAppLoadingFragment.INSTANCE.startVA(this.interceptRequest.getContext(), miniGameVAStartData, new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: com.tencent.mobileqq.minigame.va.intercept.interceptor.InstalledVAInterceptor.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                if (InstalledVAInterceptor.this.interceptRequest == null) {
                    return;
                }
                super.onReceiveResult(i3, bundle);
                QLog.d(InstalledVAInterceptor.TAG, 1, "interceptLaunch install result:" + i3, " duration:" + (System.currentTimeMillis() - j3));
                InstalledVAInterceptor.this.interceptRequest.getCallback().onInterceptResult(i3 == 0, false);
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.va.intercept.BaseInterceptor
    public void handleIntercept(InterceptRequest interceptRequest) {
        this.interceptRequest = interceptRequest;
        ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).checkUpdateVAPlugin(interceptRequest.appId, interceptRequest.getGlobalConfig().getPreLaunchProcess());
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).init(BaseApplication.getContext());
        MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
        MiniBoxInfo cacheMiniBoxAppInfo = ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).getCacheMiniBoxAppInfo(appConfig.getGameAppPkgName());
        this.queryStartTime = System.currentTimeMillis();
        if (cacheMiniBoxAppInfo != null) {
            MiniBoxAppInfo miniBoxAppInfo = new MiniBoxAppInfo();
            miniBoxAppInfo.setAppName(cacheMiniBoxAppInfo.getAppName());
            miniBoxAppInfo.setPkgName(cacheMiniBoxAppInfo.getPkgName());
            miniBoxAppInfo.setVersionName(cacheMiniBoxAppInfo.getVersionName());
            miniBoxAppInfo.setVersionCode(cacheMiniBoxAppInfo.getVersionCode());
            miniBoxAppInfo.setIconFilePath(cacheMiniBoxAppInfo.getIconFilePath());
            this.reportSource = "8";
            QLog.i(TAG, 1, "interceptLaunch find miniBoxInfo from cache miniBoxInfo:" + cacheMiniBoxAppInfo);
            this.installedCallBack.onResult(miniBoxAppInfo);
            return;
        }
        this.reportSource = "2";
        MiniBoxSDK.getInstalledAppInfo(appConfig.getGameAppPkgName(), this.installedCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartVA(MiniBoxAppInfo miniBoxAppInfo) {
        InterceptRequest interceptRequest = this.interceptRequest;
        if (interceptRequest == null) {
            return;
        }
        QLog.d(TAG, 1, "interceptLaunch getInstalledAppInfo miniBoxAppInfo:" + miniBoxAppInfo + ", queryTimeUse:" + (System.currentTimeMillis() - this.queryStartTime));
        if (miniBoxAppInfo == null) {
            handleOnNotFound(BaseApplication.getContext());
            BaseInterceptor baseInterceptor = this.nextInterceptor;
            if (baseInterceptor != null) {
                baseInterceptor.handleIntercept(interceptRequest);
            }
            this.interceptRequest = null;
            return;
        }
        if (checkLastUpdateVAToLaunch(miniBoxAppInfo.getVersionCode())) {
            QLog.d(TAG, 1, "interceptLaunch install loading, checkLastUpdateVAToLaunch success");
            this.interceptRequest = null;
            return;
        }
        IMiniGameVAService iMiniGameVAService = (IMiniGameVAService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
        boolean isForceLaunchLocal = ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).isForceLaunchLocal();
        MiniGameVAInterceptConfig.VAInterceptConfig appConfig = interceptRequest.getAppConfig();
        if (!isForceLaunchLocal && miniBoxAppInfo.getVersionCode() < appConfig.getGameAppMinVersionCode()) {
            boolean isAppInstalled = interceptRequest.canJumpApp() ? PackageUtil.isAppInstalled(interceptRequest.getContext(), appConfig.getGameAppPkgName()) : false;
            QLog.d(TAG, 1, "interceptLaunch va version low, versionCode:" + miniBoxAppInfo.getVersionCode() + ", minVersionCode:" + appConfig.getGameAppMinVersionCode());
            if (isAppInstalled) {
                QLog.d(TAG, 1, "interceptLaunch va version low, launch game app");
                MiniGameVAUtil.launchGameApp(interceptRequest.getContext(), appConfig, interceptRequest.gameData, interceptRequest.getCallback(), interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
            } else {
                interceptRequest.getCallback().onInterceptResult(false, false);
                MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "3", "3", String.valueOf(miniBoxAppInfo.getVersionCode()), System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
            }
            DiffPatchHandler.handleMiniBoxLowVersion(miniBoxAppInfo);
        } else {
            MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = new MiniGameDownloadDataWrapper();
            miniGameDownloadDataWrapper.setLaunchScene(interceptRequest.scene);
            if (!TextUtils.isEmpty(interceptRequest.via)) {
                miniGameDownloadDataWrapper.setLaunchVia(interceptRequest.via);
            }
            MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
            miniGameDownloadData.setGameId(appConfig.getMiniGameId());
            miniGameDownloadData.setVersionCode(String.valueOf(miniBoxAppInfo.getVersionCode()));
            miniGameDownloadData.setPkgName(appConfig.getGameAppPkgName());
            miniGameDownloadDataWrapper.setData(miniGameDownloadData);
            String deepLinkFromData = CommonUtil.getDeepLinkFromData(interceptRequest.gameData);
            QLog.i(TAG, 1, "launchVA scheme:" + deepLinkFromData);
            iMiniGameVAService.launchVA(miniGameDownloadDataWrapper, deepLinkFromData);
            interceptRequest.getCallback().onInterceptResult(true, false);
            MiniGameVAUtil.reportLaunch(appConfig.getGameAppId(), "2", "4", String.valueOf(miniBoxAppInfo.getVersionCode()), System.currentTimeMillis() - interceptRequest.startInterceptTime, interceptRequest.scene, interceptRequest.via);
        }
        this.interceptRequest = null;
    }
}
