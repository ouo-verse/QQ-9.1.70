package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.ApiScopeEntry;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.apkg.SecondApiRightInfo;
import com.tencent.mobileqq.mini.apkg.SubPkgInfo;
import com.tencent.mobileqq.mini.apkg.UserAuthScope;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.ui.QQMiniAppMigrateDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniDynamicManager;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.RenderInfo;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniSdkLauncher {
    private static final String TAG = "MiniSdkLauncher";
    private static volatile boolean sIsMiniAppCheckinPreLaunched = false;
    private static volatile boolean sSdkInited = false;

    public static MiniAppInfo convert(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return null;
        }
        QLog.e(TAG, 1, "convert link " + miniAppConfig.link);
        MiniAppInfo convert = convert(miniAppConfig.config);
        if (convert != null) {
            convert.baseLibInfo = convertBaselibInfo(miniAppConfig.baseLibInfo);
            LaunchParam launchParam = miniAppConfig.launchParam;
            if (launchParam != null) {
                int i3 = launchParam.tianshuAdId;
                if (i3 != 0) {
                    convert.tianshuAdId = i3;
                }
                if (!TextUtils.isEmpty(launchParam.via)) {
                    convert.via = miniAppConfig.launchParam.via;
                }
                com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam2 = convert.launchParam;
                LaunchParam launchParam3 = miniAppConfig.launchParam;
                launchParam2.scene = launchParam3.scene;
                launchParam2.isFakeAppInfo = miniAppConfig.isFromShowInfo;
                launchParam2.miniAppId = launchParam3.miniAppId;
                launchParam2.extraKey = launchParam3.extraKey;
                launchParam2.entryPath = launchParam3.entryPath;
                launchParam2.extendData = launchParam3.extendData;
                launchParam2.navigateExtData = launchParam3.navigateExtData;
                launchParam2.fromMiniAppId = launchParam3.fromMiniAppId;
                launchParam2.fakeUrl = launchParam3.fakeUrl;
                launchParam2.timestamp = launchParam3.timestamp;
                launchParam2.launchClickTimeMillis = launchParam3.launchClickTimeMillis;
                launchParam2.shareTicket = launchParam3.shareTicket;
                launchParam2.envVersion = launchParam3.envVersion;
                launchParam2.reportData = launchParam3.reportData;
                launchParam2.entryModel = convertEntryModel(launchParam3.entryModel);
                com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam4 = convert.launchParam;
                LaunchParam launchParam5 = miniAppConfig.launchParam;
                launchParam4.fromBackToMiniApp = launchParam5.fromBackToMiniApp;
                launchParam4.fromEnvVersion = launchParam5.fromEnvVersion;
                launchParam4.fromMiniAppInfo = convert(launchParam5.fromMiniAppInfo);
                com.tencent.qqmini.sdk.launcher.model.LaunchParam launchParam6 = convert.launchParam;
                LaunchParam launchParam7 = miniAppConfig.launchParam;
                launchParam6.tempState = launchParam7.tempState;
                launchParam6.privateExtraData = launchParam7.privateExtraData;
                launchParam6.fileMaterialInfoList = launchParam7.fileMaterialInfoList;
                launchParam6.forceReload = launchParam7.forceReload;
                launchParam6.skipHotReload = launchParam7.skipHotReload;
                launchParam6.isScreenRecordEnabled = launchParam7.isScreenRecordEnabled;
                launchParam6.spkTaskKey = launchParam7.spkTaskKey;
                launchParam6.taskType = launchParam7.taskType;
                launchParam6.taskAppId = launchParam7.taskAppId;
                launchParam6.taskId = launchParam7.taskId;
                launchParam6.isCloseGameBox = launchParam7.isCloseGameBox;
                launchParam6.startupReportData = launchParam7.startupReportData;
                if (!TextUtils.isEmpty(miniAppConfig.link)) {
                    convert.link = miniAppConfig.link;
                }
                convert.launchParam.slotId = miniAppConfig.launchParam.slotId;
            }
            if (miniAppConfig.isFromShowInfo) {
                convert.link = miniAppConfig.link;
                convert.linkType = miniAppConfig.linkType;
                convert.firstPath = miniAppConfig.entryPath;
            }
        }
        return convert;
    }

    public static void initSDK(Context context) {
        if (sSdkInited) {
            return;
        }
        if (context == null) {
            context = BaseApplicationImpl.getApplication().getApplicationContext();
        }
        sSdkInited = true;
        MiniSDK.init(context);
    }

    public static void onDexConfigUpdate(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            QLog.i(TAG, 1, "onDexConfigUpdate:" + str);
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ver");
            String optString2 = jSONObject.optString("minjs");
            if (!TextUtils.isEmpty(optString)) {
                jSONObject.putOpt("app_version", AppSetting.f99551k + "." + AppSetting.f99542b);
            }
            MiniDynamicManager.g().updateDexConfig(jSONObject.toString());
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            BaseLibManager.g().forceUpdateBaseLib(null);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    public static void preDownloadPkg(Context context, MiniAppConfig miniAppConfig, final IMiniCallback iMiniCallback) {
        initSDK(context);
        MiniSDK.preDownloadPkg(context, convert(miniAppConfig), new ResultReceiver(ThreadManagerV2.getUIHandlerV2()) { // from class: com.tencent.mobileqq.mini.launch.MiniSdkLauncher.3
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                IMiniCallback iMiniCallback2 = iMiniCallback;
                if (iMiniCallback2 != null) {
                    iMiniCallback2.onCallbackResult(i3 == 0, bundle);
                }
                QLog.d(MiniSdkLauncher.TAG, 2, "resultCode=" + i3 + " resultData=" + bundle);
            }
        });
    }

    public static void preLaunchMiniApp(Context context, MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        try {
            if (!(MiniAppConfProcessor.f(QzoneConfig.MINI_SDK_PRELAUNCH_ENABLE, 1) == 1)) {
                QLog.i(TAG, 1, "preLaunchMiniApp disable");
                return;
            }
            initSDK(context);
            QLog.i(TAG, 1, "preLaunchMiniApp " + miniAppConfig.config.appId);
            if (!miniAppConfig.isEngineTypeMiniGame()) {
                Bundle bundle = new Bundle();
                bundle.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_APP);
                bundle.putParcelable(MiniAppConst.MINI_KEY_APPINFO, convert(miniAppConfig));
                bundle.putBoolean(AppBrandContant.LAUNCH_SDK_MODE, true);
                MiniSDK.preloadMiniApp(context, bundle);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "startMiniApp exception!", th5);
        }
    }

    public static void preLaunchMiniAppCheckinFromLeba() {
        try {
            boolean z16 = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_FLUTTER_PRELAUNCH_CHECKIN_ENABLE, 1) == 1;
            QLog.d(TAG, 1, "preLaunchMiniAppCheckinFromLeba " + sIsMiniAppCheckinPreLaunched + ", " + z16);
            if (!sIsMiniAppCheckinPreLaunched && z16 && !shouldForbidLowPerf()) {
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniSdkLauncher.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppCmdUtil.getInstance().getAppInfoById(null, "1108164955", null, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.launch.MiniSdkLauncher.2.1
                            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                                try {
                                    QLog.d(MiniSdkLauncher.TAG, 1, "preLaunchMiniAppCheckinFromLeba onCmdListener" + MiniSdkLauncher.sIsMiniAppCheckinPreLaunched);
                                    if (z17) {
                                        QLog.i(MiniSdkLauncher.TAG, 1, "preLaunchMiniAppCheckinFromLeba, retCode = " + jSONObject.optLong("retCode") + ",errMsg = " + jSONObject.optString("errMsg"));
                                        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo = (com.tencent.mobileqq.mini.apkg.MiniAppInfo) jSONObject.opt("mini_app_info_data");
                                        if (miniAppInfo != null) {
                                            MiniSdkLauncher.sIsMiniAppCheckinPreLaunched = true;
                                            AppBrandLaunchManager.g().preLaunchMiniApp(BaseApplication.getContext(), new MiniAppConfig(miniAppInfo));
                                        }
                                    }
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    QLog.i(MiniSdkLauncher.TAG, 1, "preLaunchMiniAppCheckinFromLeba", e16);
                                }
                            }
                        });
                    }
                });
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.i(TAG, 1, "preLaunchMiniAppCheckinFromLeba", e16);
        }
    }

    public static synchronized void preloadMiniApp(Context context, boolean z16) {
        synchronized (MiniSdkLauncher.class) {
            try {
                initSDK(context);
                if (z16) {
                    Bundle bundle = new Bundle();
                    bundle.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_APP);
                    bundle.putBoolean(AppBrandContant.LAUNCH_SDK_MODE, true);
                    MiniSDK.preloadMiniApp(context, bundle);
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_GAME);
                    MiniSDK.preloadMiniApp(context, bundle2);
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "startMiniApp exception!", th5);
            }
        }
    }

    private static boolean shouldForbidLowPerf() {
        int perfLevel = DeviceInfoUtils.getPerfLevel();
        QLog.d(TAG, 1, "shouldForbidLowPerf " + perfLevel);
        return perfLevel == 3;
    }

    public static void startMiniApp(Activity activity, MiniAppConfig miniAppConfig, Bundle bundle, ResultReceiver resultReceiver) {
        String str;
        Context application;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        LaunchParam launchParam = miniAppConfig.launchParam;
        if (launchParam != null) {
            str = String.valueOf(launchParam.scene);
        } else {
            str = "";
        }
        if (MiniAppStartUtils.shouldInterceptStartMiniApp(miniAppConfig.config.appId, str)) {
            QLog.i(TAG, 1, "study mode, can't start in current scene = " + str);
            if (Looper.getMainLooper() == Looper.myLooper()) {
                QQToastUtil.showQQToast(0, R.string.f167672dk);
                return;
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.MiniSdkLauncher.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToastUtil.showQQToast(0, R.string.f167672dk);
                    }
                });
                return;
            }
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("is_qq_migrate_info_show", true);
        if (isSwitchOn && !TextUtils.isEmpty(miniAppConfig.config.bindingAppId)) {
            QQMiniAppMigrateDialog.INSTANCE.showMiniAppMigrateDialog(activity, miniAppConfig.config);
            return;
        }
        QLog.i(TAG, 1, "bindingAppId:" + miniAppConfig.config.bindingAppId + " isShowMigrateDialog:" + isSwitchOn);
        try {
            if (activity != null) {
                application = activity.getApplicationContext();
            } else {
                application = BaseApplicationImpl.getApplication();
            }
            initSDK(application);
            MiniSDK.startMiniApp(activity, convert(miniAppConfig), bundle, resultReceiver);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "startMiniApp exception!", th5);
        }
    }

    public static BaseLibInfo convertBaselibInfo(com.tencent.mobileqq.mini.sdk.BaseLibInfo baseLibInfo) {
        if (baseLibInfo == null) {
            return null;
        }
        BaseLibInfo baseLibInfo2 = new BaseLibInfo();
        baseLibInfo2.baseLibUrl = baseLibInfo.baseLibUrl;
        baseLibInfo2.baseLibKey = baseLibInfo.baseLibKey;
        baseLibInfo2.baseLibVersion = baseLibInfo.baseLibVersion;
        baseLibInfo2.baseLibDesc = baseLibInfo.baseLibDesc;
        baseLibInfo2.baseLibType = baseLibInfo.baseLibType;
        return baseLibInfo2;
    }

    public static EntryModel convertEntryModel(com.tencent.mobileqq.mini.sdk.EntryModel entryModel) {
        if (entryModel == null) {
            return null;
        }
        EntryModel entryModel2 = new EntryModel(entryModel.type, entryModel.uin, entryModel.name, entryModel.isAdmin, entryModel.dwGroupClassExt, entryModel.reportData);
        entryModel2.reportData = entryModel.reportData;
        entryModel2.titlebarIconUrl = entryModel.titlebarIconUrl;
        entryModel2.titleBarClassName = entryModel.titleBarClassName;
        entryModel2.mArguments = entryModel.mArguments;
        return entryModel2;
    }

    public static MiniAppInfo convert(com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        MiniAppInfo miniAppInfo2 = new MiniAppInfo();
        miniAppInfo2.appId = miniAppInfo.appId;
        miniAppInfo2.name = miniAppInfo.name;
        miniAppInfo2.iconUrl = miniAppInfo.iconUrl;
        miniAppInfo2.downloadUrl = miniAppInfo.downloadUrl;
        miniAppInfo2.topType = miniAppInfo.topType;
        miniAppInfo2.version = miniAppInfo.version;
        miniAppInfo2.versionId = miniAppInfo.versionId;
        miniAppInfo2.desc = miniAppInfo.desc;
        miniAppInfo2.verType = miniAppInfo.verType;
        miniAppInfo2.timestamp = miniAppInfo.timestamp;
        miniAppInfo2.baselibMiniVersion = miniAppInfo.baselibMiniVersion;
        if (miniAppInfo.subpkgs != null) {
            miniAppInfo2.subpkgs = new ArrayList();
            for (SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                com.tencent.qqmini.sdk.launcher.model.SubPkgInfo subPkgInfo2 = new com.tencent.qqmini.sdk.launcher.model.SubPkgInfo();
                subPkgInfo2.subPkgName = subPkgInfo.subPkgName;
                subPkgInfo2.downloadUrl = subPkgInfo.downloadUrl;
                subPkgInfo2.independent = subPkgInfo.independent;
                subPkgInfo2.fileSize = subPkgInfo.fileSize;
                miniAppInfo2.subpkgs.add(subPkgInfo2);
            }
        }
        if (miniAppInfo.firstPage != null) {
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            miniAppInfo2.firstPage = firstPageInfo;
            com.tencent.mobileqq.mini.apkg.FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
            firstPageInfo.pagePath = firstPageInfo2.pagePath;
            firstPageInfo.subPkgName = firstPageInfo2.subPkgName;
        }
        miniAppInfo2.appType = miniAppInfo.getReportType();
        miniAppInfo2.engineType = miniAppInfo.engineType;
        miniAppInfo2.setReportType(miniAppInfo.getReportType());
        miniAppInfo2.whiteList = miniAppInfo.whiteList;
        miniAppInfo2.blackList = miniAppInfo.blackList;
        if (miniAppInfo.secondApiRightInfoList != null) {
            miniAppInfo2.secondApiRightInfoList = new ArrayList();
            for (SecondApiRightInfo secondApiRightInfo : miniAppInfo.secondApiRightInfoList) {
                com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo secondApiRightInfo2 = new com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo();
                secondApiRightInfo2.apiName = secondApiRightInfo.apiName;
                secondApiRightInfo2.secondName = secondApiRightInfo.secondName;
                secondApiRightInfo2.right = secondApiRightInfo.right;
                miniAppInfo2.secondApiRightInfoList.add(secondApiRightInfo2);
            }
        }
        if (miniAppInfo.debugInfo != null) {
            DebugInfo debugInfo = new DebugInfo();
            miniAppInfo2.debugInfo = debugInfo;
            com.tencent.mobileqq.mini.apkg.DebugInfo debugInfo2 = miniAppInfo.debugInfo;
            debugInfo.roomId = debugInfo2.roomId;
            debugInfo.wsUrl = debugInfo2.wsUrl;
        }
        miniAppInfo2.requestDomainList = miniAppInfo.requestDomainList;
        miniAppInfo2.socketDomainList = miniAppInfo.socketDomainList;
        miniAppInfo2.uploadFileDomainList = miniAppInfo.uploadFileDomainList;
        miniAppInfo2.downloadFileDomainList = miniAppInfo.downloadFileDomainList;
        miniAppInfo2.businessDomainList = miniAppInfo.businessDomainList;
        miniAppInfo2.udpIpList = miniAppInfo.udpIpList;
        miniAppInfo2.fileSize = miniAppInfo.fileSize;
        miniAppInfo2.developerDesc = miniAppInfo.developerDesc;
        miniAppInfo2.extraData = miniAppInfo.extraData;
        miniAppInfo2.recommend = miniAppInfo.recommend;
        miniAppInfo2.isSupportOffline = miniAppInfo.isSupportOffline;
        miniAppInfo2.openId = miniAppInfo.openId;
        miniAppInfo2.tinyId = miniAppInfo.tinyId;
        miniAppInfo2.reportData = miniAppInfo.reportData;
        if (miniAppInfo.appMode != null) {
            AppMode appMode = new AppMode();
            miniAppInfo2.appMode = appMode;
            com.tencent.mobileqq.mini.apkg.AppMode appMode2 = miniAppInfo.appMode;
            appMode.interMode = appMode2.interMode;
            appMode.authoritySilent = appMode2.authoritySilent;
            appMode.keepOffPullList = appMode2.keepOffPullList;
            appMode.closeTopRightCapsule = appMode2.closeTopRightCapsule;
            appMode.openNativeApi = appMode2.openNativeApi;
            appMode.hideAppSearch = appMode2.hideAppSearch;
            appMode.isAppStore = appMode2.isAppStore;
            appMode.isWangKa = appMode2.isWangKa;
            appMode.interLoading = appMode2.isInterLoading;
            appMode.isLimitedAccess = appMode2.isLimitedAccess;
            appMode.isPayForFriend = appMode2.isPayForFriend;
            appMode.useAppInfoWhenNavigate = appMode2.useAppInfoWhenNavigate;
            appMode.disableAddToMyApp = appMode2.disableAddToMyApp;
            appMode.disableAddToMyFavor = appMode2.disableAddToMyFavor;
            appMode.reloadWithFirstPageChange = appMode2.reloadWithFirstPageChange;
            appMode.unlimitedApiRight = appMode2.unlimitedApiRight;
            appMode.disableShareToAIO = appMode2.disableShareToAIO;
            appMode.disableShareToQZone = appMode2.disableShareToQZone;
            appMode.disableShareToWeChat = appMode2.disableShareToWeChat;
        }
        miniAppInfo2.skipDomainCheck = miniAppInfo.skipDomainCheck;
        miniAppInfo2.position = miniAppInfo.position;
        miniAppInfo2.isSupportBlueBar = miniAppInfo.isSupportBlueBar;
        miniAppInfo2.recommendAppIconUrl = miniAppInfo.recommendAppIconUrl;
        miniAppInfo2.extendData = miniAppInfo.extendData;
        miniAppInfo2.clearAuths = miniAppInfo.clearAuths;
        miniAppInfo2.prepayId = miniAppInfo.prepayId;
        miniAppInfo2.commonExt = miniAppInfo.commonExt;
        if (miniAppInfo.extConfigInfoList != null) {
            miniAppInfo2.extConfigInfoList = new ArrayList<>();
            miniAppInfo2.extConfigInfoList = new ArrayList<>();
            Iterator<ExtConfigInfo> it = miniAppInfo.extConfigInfoList.iterator();
            while (it.hasNext()) {
                miniAppInfo2.extConfigInfoList.add(convert(it.next()));
            }
        }
        miniAppInfo2.appStoreAnimPicUrl = miniAppInfo.appStoreAnimPicUrl;
        miniAppInfo2.motionPics = miniAppInfo.motionPics;
        miniAppInfo2.usrFileSizeLimit = miniAppInfo.usrFileSizeLimit;
        if (miniAppInfo.preCacheList != null) {
            miniAppInfo2.preCacheList = new ArrayList<>();
            Iterator<PreCacheInfo> it5 = miniAppInfo.preCacheList.iterator();
            while (it5.hasNext()) {
                PreCacheInfo next = it5.next();
                miniAppInfo2.preCacheList.add(new com.tencent.qqmini.sdk.launcher.model.PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime, next.cacheType, next.useProxy));
            }
        }
        if (miniAppInfo.resourcePreCacheInfo != null) {
            miniAppInfo2.resourcePreCacheInfo = new ArrayList<>();
            Iterator<ResourcePreCacheInfo> it6 = miniAppInfo.resourcePreCacheInfo.iterator();
            while (it6.hasNext()) {
                miniAppInfo2.resourcePreCacheInfo.add(new ResourcePreCacheInfo(it6.next().getDataUrl));
            }
        }
        miniAppInfo2.versionUpdateTime = miniAppInfo.versionUpdateTime;
        miniAppInfo2.noNeedRealRecommend = miniAppInfo.noNeedRealRecommend;
        if (miniAppInfo.miniGamePluginInfo != null) {
            MiniGamePluginInfo miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
            miniAppInfo2.miniGamePluginInfo = new com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo(miniGamePluginInfo.name, miniGamePluginInfo.f246320id, miniGamePluginInfo.version, miniGamePluginInfo.url, miniGamePluginInfo.packageSize);
        }
        if (miniAppInfo.renderInfo != null) {
            RenderInfo renderInfo = new RenderInfo();
            miniAppInfo2.renderInfo = renderInfo;
            com.tencent.mobileqq.mini.apkg.RenderInfo renderInfo2 = miniAppInfo.renderInfo;
            renderInfo.renderMode = renderInfo2.renderMode;
            Map<Integer, String> map = renderInfo2.renderMaterialMap;
            if (map != null) {
                renderInfo.renderMaterialMap.putAll(map);
            }
        }
        miniAppInfo2.qualifications = miniAppInfo.qualifications;
        miniAppInfo2.gameCopyrightInfo = miniAppInfo.gameCopyrightInfo;
        String str = miniAppInfo.gamePublicationCompany;
        miniAppInfo2.gamePublicationNumber = str;
        miniAppInfo2.gamePublicationCompany = str;
        miniAppInfo2.gameApprovalNumber = miniAppInfo.gameApprovalNumber;
        miniAppInfo2.gameOperatingCompany = miniAppInfo.gameOperatingCompany;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        miniAppInfo2.amsAdInfo = miniAppInfo.amsAdInfo;
        miniAppInfo2.enableLoadingAd = miniAppInfo.enableLoadingAd;
        miniAppInfo2.friendMessageQuery = miniAppInfo.friendMessageQuery;
        miniAppInfo2.apngUrl = miniAppInfo.apngUrl;
        miniAppInfo2.ideScene = miniAppInfo.ide_scene;
        miniAppInfo2.ideExtraAppid = miniAppInfo.ide_extraAppid;
        miniAppInfo2.ideExtraData = miniAppInfo.ide_extraData;
        miniAppInfo2.tianshuAdId = miniAppInfo.tianshuAdId;
        miniAppInfo2.deviceOrientation = miniAppInfo.deviceOrientation;
        miniAppInfo2.showStatusBar = miniAppInfo.showStatusBar;
        miniAppInfo2.extInfo = miniAppInfo.extInfo;
        return miniAppInfo2;
    }

    public static com.tencent.mobileqq.mini.apkg.MiniAppInfo convert(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        com.tencent.mobileqq.mini.apkg.MiniAppInfo miniAppInfo2 = new com.tencent.mobileqq.mini.apkg.MiniAppInfo();
        miniAppInfo2.appId = miniAppInfo.appId;
        miniAppInfo2.name = miniAppInfo.name;
        miniAppInfo2.iconUrl = miniAppInfo.iconUrl;
        miniAppInfo2.downloadUrl = miniAppInfo.downloadUrl;
        miniAppInfo2.setReportType(miniAppInfo.getReportType());
        miniAppInfo2.version = miniAppInfo.version;
        miniAppInfo2.versionId = miniAppInfo.versionId;
        miniAppInfo2.desc = miniAppInfo.desc;
        miniAppInfo2.verType = miniAppInfo.verType;
        miniAppInfo2.timestamp = miniAppInfo.timestamp;
        miniAppInfo2.baselibMiniVersion = miniAppInfo.baselibMiniVersion;
        com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        if (miniGamePluginInfo != null) {
            miniAppInfo2.miniGamePluginInfo = new MiniGamePluginInfo(miniGamePluginInfo.name, miniGamePluginInfo.f348088id, miniGamePluginInfo.version, miniGamePluginInfo.url, miniGamePluginInfo.packageSize);
        }
        if (miniAppInfo.subpkgs != null) {
            miniAppInfo2.subpkgs = new ArrayList();
            for (com.tencent.qqmini.sdk.launcher.model.SubPkgInfo subPkgInfo : miniAppInfo.subpkgs) {
                SubPkgInfo subPkgInfo2 = new SubPkgInfo();
                subPkgInfo2.subPkgName = subPkgInfo.subPkgName;
                subPkgInfo2.downloadUrl = subPkgInfo.downloadUrl;
                subPkgInfo2.independent = subPkgInfo.independent;
                subPkgInfo2.fileSize = subPkgInfo.fileSize;
                miniAppInfo2.subpkgs.add(subPkgInfo2);
            }
        }
        if (miniAppInfo.firstPage != null) {
            com.tencent.mobileqq.mini.apkg.FirstPageInfo firstPageInfo = new com.tencent.mobileqq.mini.apkg.FirstPageInfo();
            miniAppInfo2.firstPage = firstPageInfo;
            FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
            firstPageInfo.pagePath = firstPageInfo2.pagePath;
            firstPageInfo.subPkgName = firstPageInfo2.subPkgName;
        }
        if (miniAppInfo.preCacheList != null) {
            miniAppInfo2.preCacheList = new ArrayList<>();
            Iterator<com.tencent.qqmini.sdk.launcher.model.PreCacheInfo> it = miniAppInfo.preCacheList.iterator();
            while (it.hasNext()) {
                com.tencent.qqmini.sdk.launcher.model.PreCacheInfo next = it.next();
                if (next != null) {
                    miniAppInfo2.preCacheList.add(new PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime, next.cacheType, next.useProxy));
                }
            }
        }
        if (miniAppInfo.resourcePreCacheInfo != null) {
            miniAppInfo2.resourcePreCacheInfo = new ArrayList<>();
            Iterator<ResourcePreCacheInfo> it5 = miniAppInfo.resourcePreCacheInfo.iterator();
            while (it5.hasNext()) {
                ResourcePreCacheInfo next2 = it5.next();
                if (next2 != null) {
                    miniAppInfo2.resourcePreCacheInfo.add(new ResourcePreCacheInfo(next2.getDataUrl));
                }
            }
        }
        miniAppInfo2.whiteList = miniAppInfo.whiteList;
        miniAppInfo2.blackList = miniAppInfo.blackList;
        if (miniAppInfo.secondApiRightInfoList != null) {
            miniAppInfo2.secondApiRightInfoList = new ArrayList();
            for (com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo secondApiRightInfo : miniAppInfo.secondApiRightInfoList) {
                SecondApiRightInfo secondApiRightInfo2 = new SecondApiRightInfo();
                secondApiRightInfo2.apiName = secondApiRightInfo.apiName;
                secondApiRightInfo2.secondName = secondApiRightInfo.secondName;
                secondApiRightInfo2.right = secondApiRightInfo.right;
                miniAppInfo2.secondApiRightInfoList.add(secondApiRightInfo2);
            }
        }
        if (miniAppInfo.debugInfo != null) {
            com.tencent.mobileqq.mini.apkg.DebugInfo debugInfo = new com.tencent.mobileqq.mini.apkg.DebugInfo();
            miniAppInfo2.debugInfo = debugInfo;
            DebugInfo debugInfo2 = miniAppInfo.debugInfo;
            debugInfo.roomId = debugInfo2.roomId;
            debugInfo.wsUrl = debugInfo2.wsUrl;
        }
        miniAppInfo2.requestDomainList = miniAppInfo.requestDomainList;
        miniAppInfo2.socketDomainList = miniAppInfo.socketDomainList;
        miniAppInfo2.uploadFileDomainList = miniAppInfo.uploadFileDomainList;
        miniAppInfo2.downloadFileDomainList = miniAppInfo.downloadFileDomainList;
        miniAppInfo2.businessDomainList = miniAppInfo.businessDomainList;
        List<String> list = miniAppInfo.udpIpList;
        if (list != null) {
            miniAppInfo2.udpIpList.addAll(list);
        }
        miniAppInfo2.fileSize = miniAppInfo.fileSize;
        miniAppInfo2.developerDesc = miniAppInfo.developerDesc;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppInfo2.skipDomainCheck = miniAppInfo.skipDomainCheck;
        miniAppInfo2.usrFileSizeLimit = miniAppInfo.usrFileSizeLimit;
        miniAppInfo2.noNeedRealRecommend = miniAppInfo.noNeedRealRecommend;
        miniAppInfo2.versionUpdateTime = miniAppInfo.versionUpdateTime;
        miniAppInfo2.engineType = miniAppInfo.engineType;
        if (miniAppInfo.renderInfo != null) {
            com.tencent.mobileqq.mini.apkg.RenderInfo renderInfo = new com.tencent.mobileqq.mini.apkg.RenderInfo();
            miniAppInfo2.renderInfo = renderInfo;
            RenderInfo renderInfo2 = miniAppInfo.renderInfo;
            renderInfo.renderMode = renderInfo2.renderMode;
            Map<Integer, String> map = renderInfo2.renderMaterialMap;
            if (map != null) {
                renderInfo.renderMaterialMap.putAll(map);
            }
        }
        if (miniAppInfo.appMode != null) {
            com.tencent.mobileqq.mini.apkg.AppMode appMode = new com.tencent.mobileqq.mini.apkg.AppMode();
            miniAppInfo2.appMode = appMode;
            AppMode appMode2 = miniAppInfo.appMode;
            appMode.interMode = appMode2.interMode;
            appMode.authoritySilent = appMode2.authoritySilent;
            appMode.keepOffPullList = appMode2.keepOffPullList;
            appMode.closeTopRightCapsule = appMode2.closeTopRightCapsule;
            appMode.openNativeApi = appMode2.openNativeApi;
            appMode.hideAppSearch = appMode2.hideAppSearch;
            appMode.isAppStore = appMode2.isAppStore;
            appMode.isWangKa = appMode2.isWangKa;
            appMode.isInterLoading = appMode2.interLoading;
            appMode.isLimitedAccess = appMode2.isLimitedAccess;
            appMode.isPayForFriend = appMode2.isPayForFriend;
            appMode.useAppInfoWhenNavigate = appMode2.useAppInfoWhenNavigate;
            appMode.disableAddToMyApp = appMode2.disableAddToMyApp;
            appMode.disableAddToMyFavor = appMode2.disableAddToMyFavor;
            appMode.reloadWithFirstPageChange = appMode2.reloadWithFirstPageChange;
            appMode.unlimitedApiRight = appMode2.unlimitedApiRight;
            appMode.disableShareToAIO = appMode2.disableShareToAIO;
            appMode.disableShareToQZone = appMode2.disableShareToQZone;
            appMode.disableShareToWeChat = appMode2.disableShareToWeChat;
        }
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        miniAppInfo2.gameCopyrightInfo = miniAppInfo.gameCopyrightInfo;
        miniAppInfo2.gamePublicationNumber = miniAppInfo.gamePublicationNumber;
        miniAppInfo2.gamePublicationCompany = miniAppInfo.gamePublicationCompany;
        miniAppInfo2.gameApprovalNumber = miniAppInfo.gameApprovalNumber;
        miniAppInfo2.gameOperatingCompany = miniAppInfo.gameOperatingCompany;
        miniAppInfo2.extInfo = miniAppInfo.extInfo;
        return miniAppInfo2;
    }

    public static com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo convert(ExtConfigInfo extConfigInfo) {
        if (extConfigInfo == null) {
            return null;
        }
        com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo extConfigInfo2 = new com.tencent.qqmini.sdk.launcher.model.ExtConfigInfo();
        extConfigInfo2.configKey = extConfigInfo.configKey;
        extConfigInfo2.configVersion = extConfigInfo.configVersion;
        if (extConfigInfo.userAuthScopes != null) {
            extConfigInfo2.userAuthScopes = new ArrayList<>();
            Iterator<UserAuthScope> it = extConfigInfo.userAuthScopes.iterator();
            while (it.hasNext()) {
                UserAuthScope next = it.next();
                if (next != null) {
                    com.tencent.qqmini.sdk.launcher.model.UserAuthScope userAuthScope = new com.tencent.qqmini.sdk.launcher.model.UserAuthScope();
                    extConfigInfo2.userAuthScopes.add(userAuthScope);
                    userAuthScope.scope = next.scope;
                    userAuthScope.authType = next.authType;
                    userAuthScope.desc = next.desc;
                    userAuthScope.settingPageTitle = next.settingPageTitle;
                }
            }
        }
        if (extConfigInfo.apiScopeEntries != null) {
            extConfigInfo2.apiScopeEntries = new ArrayList<>();
            Iterator<ApiScopeEntry> it5 = extConfigInfo.apiScopeEntries.iterator();
            while (it5.hasNext()) {
                ApiScopeEntry next2 = it5.next();
                if (next2 != null) {
                    com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry apiScopeEntry = new com.tencent.qqmini.sdk.launcher.model.ApiScopeEntry();
                    extConfigInfo2.apiScopeEntries.add(apiScopeEntry);
                    apiScopeEntry.scope = next2.scope;
                    apiScopeEntry.eventName = next2.eventName;
                    apiScopeEntry.apiName = next2.apiName;
                }
            }
        }
        return extConfigInfo2;
    }
}
