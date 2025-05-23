package com.tencent.mobileqq.minigame.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.minigame.va.MiniGameVALaunchCache;
import com.tencent.mobileqq.minigame.va.downloadui.MiniGameVAStartData;
import com.tencent.mobileqq.minigame.va.downloadui.VAInstallAppLoadingFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import cs3.MetaDreamAppExtraInfo;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameVALaunchApiImpl implements IMiniGameVALaunchApi {
    private static final String TAG = "minibox_MiniGameVALaunchApiImpl";

    private String getMiniGameAppId(String str) {
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null) {
            for (MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig : miniGameVAInterceptConfig.getInterceptConfigMap().values()) {
                if (TextUtils.equals(str, vAInterceptConfig.getGameAppPkgName())) {
                    return vAInterceptConfig.getMiniGameId();
                }
            }
            return "";
        }
        return "";
    }

    private IMiniGameVAService getVAService() {
        return (IMiniGameVAService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi
    public void reportDc87(final int i3, final String str, final String str2, final String str3) {
        QLog.i(TAG, 1, "reportDc87 reportType:" + i3 + " currentVersionName:" + str2 + " extraReportData:" + str3);
        ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).getExtraInfo(new cs3.c() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVALaunchApiImpl.3
            @Override // cs3.c
            public void onExtraRsp(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
                if (metaDreamAppExtraInfo != null && metaDreamAppExtraInfo.getApkInfo() != null) {
                    MiniGameVALaunchApiImpl.report87(i3, str, str2, metaDreamAppExtraInfo.getApkInfo().getVersionName(), str3);
                } else {
                    QLog.i(MiniGameVALaunchApiImpl.TAG, 1, "reportDc87 onExtraRsp fail");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi
    public void reportToServerRealTime(String str, String str2, String str3, String str4) {
        QLog.i(TAG, 1, "reportToServerRealTime reportEventName:" + str);
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi
    public void restartApp(String str) {
        MiniGameVAStartData miniGameStartData = MiniGameVALaunchCache.INSTANCE.getMiniGameStartData(str);
        if (miniGameStartData != null) {
            QLog.i(TAG, 1, "restartApp found startData:" + miniGameStartData);
            VAInstallAppLoadingFragment.INSTANCE.startVA(BaseApplication.getContext(), miniGameStartData, null);
            return;
        }
        QLog.i(TAG, 1, "restartApp not found startData, launch from IMiniGameVAService");
        String miniGameAppId = getMiniGameAppId(str);
        if (TextUtils.isEmpty(miniGameAppId)) {
            QLog.i(TAG, 1, "restartApp not found miniGameId pkgName:" + str);
            return;
        }
        final IMiniGameVAService vAService = getVAService();
        vAService.queryVAInfo(miniGameAppId, new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVALaunchApiImpl.1
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                if (bool.booleanValue() && miniGameDownloadDataWrapper != null) {
                    vAService.launchVA(miniGameDownloadDataWrapper, null);
                    QLog.i(MiniGameVALaunchApiImpl.TAG, 1, "restartApp launchVA dataWrapper:" + miniGameDownloadDataWrapper);
                }
                return null;
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.api.IMiniGameVALaunchApi
    public void startYunGame(String str) {
        QLog.i(TAG, 1, "startYunGame startYunGame pkgName:" + str);
        String miniGameAppId = getMiniGameAppId(str);
        if (TextUtils.isEmpty(miniGameAppId)) {
            QLog.i(TAG, 1, "startYunGame not found miniGameId pkgName:" + str);
            return;
        }
        LaunchParam launchParam = new LaunchParam();
        launchParam.miniAppId = miniGameAppId;
        launchParam.isPreIntercept = true;
        launchParam.scene = 1037;
        MiniAppLauncher.launchMiniAppById(BaseApplication.getContext(), launchParam, new MiniAppLauncher.MiniAppLaunchListener() { // from class: com.tencent.mobileqq.minigame.api.impl.MiniGameVALaunchApiImpl.2
            @Override // com.tencent.mobileqq.mini.sdk.MiniAppLauncher.MiniAppLaunchListener
            public void onLaunchResult(boolean z16, Bundle bundle) {
                QLog.i(MiniGameVALaunchApiImpl.TAG, 1, "startYunGame onLaunchResult isSuc:" + z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void report87(int i3, String str, String str2, String str3, String str4) {
        if (i3 == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext7", str2);
            hashMap.put("ext6", str4);
            hashMap.put("ext8", str3);
            hashMap.put("ext46", str);
            ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989454", "8", "", hashMap);
            return;
        }
        if (i3 == 1) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ext7", str2);
            hashMap2.put("ext6", str4);
            hashMap2.put("ext8", str3);
            hashMap2.put("ext46", str);
            ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989455", "8", "", hashMap2);
        }
    }
}
