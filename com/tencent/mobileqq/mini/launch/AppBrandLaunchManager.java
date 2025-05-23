package com.tencent.mobileqq.mini.launch;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StBatchQueryAppInfoRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.app.AppBrandContant;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04746;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.minigame.publicaccount.config.MiniGameConfigProcessor;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.utils.CPUUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.aq;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.WiFiDash;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppBrandLaunchManager implements IAppLaunch {
    private static final int KILL_MODE_PID = 0;
    private static final String TAG = "miniapp-process_AppBrandLaunchManager";
    private static AppBrandLaunchManager instance;
    private int hardCoderTimeout;
    private int mKillProcessMode;
    private long mLastPreloadDetectTime;
    private long mMiniAppLastUseTimeStamp;
    private static final long MINI_APP_USED_DURATION_MS = TimeUnit.HOURS.toMillis(36);
    private static byte[] lock = new byte[0];
    protected Handler mHandler = new Handler(ThreadManager.getSubThreadHandler().getLooper());
    private final Runnable mCheckPreloadRunnable = new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.11
        @Override // java.lang.Runnable
        public void run() {
            AppBrandLaunchManager.this.checkPreload();
        }
    };
    private Context mContext = BaseApplicationImpl.getApplication();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class StartMiniAppReceiver extends BroadcastReceiver {
        StartMiniAppReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            String stringExtra = intent.getStringExtra("opType");
            final String stringExtra2 = intent.getStringExtra("appid");
            String stringExtra3 = intent.getStringExtra("fakeUrl");
            QLog.i(AppBrandLaunchManager.TAG, 1, "miniapp.debugger receiver opType:" + stringExtra + " appid:" + stringExtra2 + " fakeUrl:" + stringExtra3);
            if ("op-clear".equals(stringExtra)) {
                if (TextUtils.isEmpty(stringExtra2)) {
                    QLog.e(AppBrandLaunchManager.TAG, 2, "appid is null, return.");
                    return;
                } else {
                    final String stringExtra4 = intent.getStringExtra("uin");
                    ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str = AppLoaderFactory.PATH_WXAPKG_ROOT + stringExtra2 + "_debug";
                            if (new File(str).exists()) {
                                FileUtils.delete(str, false);
                            }
                            String str2 = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(stringExtra2);
                            if (new File(str2).exists()) {
                                FileUtils.delete(str2, false);
                            }
                            String cacheDir = Storage.getCacheDir(context.getCacheDir().getAbsolutePath(), stringExtra4, stringExtra2);
                            if (cacheDir != null && new File(cacheDir).exists()) {
                                FileUtils.delete(cacheDir, false);
                            }
                            QLog.e("debug", 1, "clear miniapp");
                        }
                    });
                    return;
                }
            }
            if ("op-miniapp".equals(stringExtra)) {
                final int intExtra = intent.getIntExtra("scene", 0);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(stringExtra2);
                    MiniAppCmdUtil.getInstance().getBatchQueryAppInfo(null, arrayList, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.2
                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                        public void onCmdListener(boolean z16, JSONObject jSONObject) {
                            if (z16) {
                                Object opt = jSONObject.opt("batch_query_app_info");
                                if (opt != null) {
                                    INTERFACE$StBatchQueryAppInfoRsp iNTERFACE$StBatchQueryAppInfoRsp = (INTERFACE$StBatchQueryAppInfoRsp) opt;
                                    iNTERFACE$StBatchQueryAppInfoRsp.extInfo.get();
                                    Iterator<INTERFACE$StApiAppInfo> it = iNTERFACE$StBatchQueryAppInfoRsp.appInfos.get().iterator();
                                    while (it.hasNext()) {
                                        AppBrandLaunchManager.handleStartMiniappByBroadcast(MiniAppInfo.from(it.next()), intExtra, "");
                                    }
                                    return;
                                }
                                return;
                            }
                            QLog.e(AppBrandLaunchManager.TAG, 2, "StartMiniAppReceiver onReceive, onCmdListener, isSuc = " + z16);
                        }
                    });
                } else {
                    if (TextUtils.isEmpty(stringExtra3)) {
                        return;
                    }
                    MiniAppCmdUtil.getInstance().getAppInfoByLink(stringExtra3, 0, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.3
                        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                        public void onCmdListener(boolean z16, JSONObject jSONObject) {
                            if (z16) {
                                AppBrandLaunchManager.handleStartMiniappByBroadcast((MiniAppInfo) jSONObject.opt("appInfo"), intExtra, jSONObject.optString("shareTicket", ""));
                            }
                        }
                    });
                }
            }
        }
    }

    AppBrandLaunchManager() {
        this.mKillProcessMode = 0;
        this.hardCoderTimeout = 0;
        try {
            this.mKillProcessMode = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_PROCESS_KILL_MODE, 0);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "get config StartTimeInterval exception!", th5);
        }
        this.mMiniAppLastUseTimeStamp = MiniAppLauncher.getLastMiniAppUsedTime();
        getHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.1
            @Override // java.lang.Runnable
            public void run() {
                AppBrandLaunchManager appBrandLaunchManager = AppBrandLaunchManager.this;
                appBrandLaunchManager.registerStartMiniAppReceiver(appBrandLaunchManager.mContext);
            }
        }, 10000L);
        MiniGameBeaconReport.init();
        this.hardCoderTimeout = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_HARD_CODER_TIMEOUT, 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPreload() {
        QLog.i(TAG, 1, "checkPreload MiniAppUsed:" + isMiniAppUsed());
        try {
            if (isMiniAppUsed()) {
                this.mLastPreloadDetectTime = System.currentTimeMillis();
                preloadMiniGameSync();
            }
            MiniSdkLauncher.preloadMiniApp(this.mContext, true);
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).preloadProcessEnv(true);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    private void doFetchPeriodicCache() {
        List<? extends Entity> queryEntity;
        QLog.i(TAG, 1, "start update periodicCache.");
        try {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if ((runtime instanceof QQAppInterface) && (queryEntity = ((MiniAppEntityManager) runtime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER)).queryEntity(MiniAppInfoEntity.class, false, null, null, null, null, null, null)) != null && queryEntity.size() > 0) {
                Iterator<? extends Entity> it = queryEntity.iterator();
                while (it.hasNext()) {
                    MiniAppInfoEntity miniAppInfoEntity = (MiniAppInfoEntity) it.next();
                    INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
                    iNTERFACE$StApiAppInfo.mergeFrom(miniAppInfoEntity.appInfo);
                    MiniAppInfo from = MiniAppInfo.from(iNTERFACE$StApiAppInfo);
                    new MiniAppConfig(from).isEngineTypeMiniGame();
                    com.tencent.qqmini.sdk.launcher.model.MiniAppInfo convert = MiniSdkLauncher.convert(from);
                    MiniSDK.init(this.mContext);
                    com.tencent.qqmini.sdk.launcher.AppLoaderFactory.g().getCommonManager().fetchPeriodicCacheIfNeed(convert);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchPeriodicCache() {
        doFetchPeriodicCache();
        getHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.2
            @Override // java.lang.Runnable
            public void run() {
                AppBrandLaunchManager.this.fetchPeriodicCache();
            }
        }, 7200000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadMiniGameSync() {
        if (aq.l(BaseApplication.getContext())) {
            return;
        }
        MiniSdkLauncher.preloadMiniApp(this.mContext, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerStartMiniAppReceiver(Context context) {
        if (this.mContext == null) {
            QLog.e(TAG, 1, "registerStartMiniAppReceiver, context = " + context);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.miniapp.debugger");
        context.registerReceiver(new StartMiniAppReceiver(), intentFilter);
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public boolean isMiniAppUsed() {
        return System.currentTimeMillis() - this.mMiniAppLastUseTimeStamp < MINI_APP_USED_DURATION_MS;
    }

    public void markMiniAppUsed() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mMiniAppLastUseTimeStamp = currentTimeMillis;
        MiniAppLauncher.markMiniAppUsed(currentTimeMillis);
    }

    public void onMiniAppUIOpen() {
        if (System.currentTimeMillis() - this.mLastPreloadDetectTime > 10000) {
            getHandler().removeCallbacks(this.mCheckPreloadRunnable);
            getHandler().post(this.mCheckPreloadRunnable);
        }
    }

    public void preDownloadPkg(String str, String str2, final IMiniCallback iMiniCallback) {
        MiniAppCmdUtil.getInstance().getAppInfoById(null, str, "", str2, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.8
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (jSONObject == null) {
                    AppBrandLaunchManager.this.preDownloadPkgCallback(-1, "request MiniAppInfo error! ret is null.", iMiniCallback);
                    return;
                }
                if (z16) {
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    if (miniAppInfo == null) {
                        AppBrandLaunchManager.this.preDownloadPkgCallback(-1, "request MiniAppInfo error! appInfo is null.", iMiniCallback);
                        return;
                    } else {
                        MiniSdkLauncher.preDownloadPkg(BaseApplication.getContext(), new MiniAppConfig(miniAppInfo), iMiniCallback);
                        return;
                    }
                }
                AppBrandLaunchManager.this.preDownloadPkgCallback((int) jSONObject.optLong("retCode"), jSONObject.optString("errMsg"), iMiniCallback);
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.launch.IAppLaunch
    public synchronized void preloadMiniApp() {
        if (CPUUtil.sIsX86Emulator) {
            return;
        }
        updateBaseLib();
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.3
            @Override // java.lang.Runnable
            public void run() {
                AppBrandLaunchManager.this.fetchPeriodicCache();
            }
        });
        if (SplashMiniGameStarter.hasPreloaded && SplashMiniGameStarter.curData != null) {
            if (SplashMiniGameStarter.hasClickJumpBtn) {
                SplashMiniGameData splashMiniGameData = SplashMiniGameStarter.curData;
                MiniProgramLpReportDC04746.report(splashMiniGameData.appId, splashMiniGameData.version, 1, 1);
            } else {
                SplashMiniGameData splashMiniGameData2 = SplashMiniGameStarter.curData;
                MiniProgramLpReportDC04746.report(splashMiniGameData2.appId, splashMiniGameData2.version, 1, 0);
            }
        }
    }

    public void preloadMiniGame() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            preloadMiniGameSync();
        } else {
            getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.10
                @Override // java.lang.Runnable
                public void run() {
                    AppBrandLaunchManager.this.preloadMiniGameSync();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.mini.launch.IAppLaunch
    public void sendCmd(String str, Bundle bundle, CmdCallback cmdCallback) {
        MiniAppCmdServlet.g().onMiniAppCmd(str, bundle, cmdCallback);
    }

    @Override // com.tencent.mobileqq.mini.launch.IAppLaunch
    public void startMiniApp(final Activity activity, final MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) {
        String str;
        String str2;
        if (miniAppConfig == null) {
            QLog.e(TAG, 1, "startMiniApp params is empty! ,appConfig=" + miniAppConfig + " Activity=" + activity);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[MiniEng]startMiniApp. " + miniAppConfig.config.name + ",size=" + miniAppConfig.config.fileSize + ", link = " + miniAppConfig.link + ", versionId:" + miniAppConfig.config.versionId + ", versionUpdateTime:" + miniAppConfig.config.versionUpdateTime + " fromProcess=" + BaseApplicationImpl.getApplication().getQQProcessName());
        }
        MiniAppInfo miniAppInfo = miniAppConfig.config;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            LaunchParam launchParam = miniAppConfig.launchParam;
            if (launchParam != null && launchParam.scene != 9999) {
                setScreenRecordEnabledParam(miniAppConfig);
                MiniAppInfo miniAppInfo2 = miniAppConfig.config;
                if (miniAppInfo2.verType != 3) {
                    if (!TextUtils.isEmpty(miniAppInfo2.ide_scene)) {
                        try {
                            miniAppConfig.launchParam.scene = Integer.parseInt(miniAppConfig.config.ide_scene);
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "parse ide scene fail", e16);
                        }
                    }
                    if (!TextUtils.isEmpty(miniAppConfig.config.ide_extraAppid)) {
                        miniAppConfig.launchParam.fromMiniAppId = miniAppConfig.config.ide_extraAppid;
                    }
                    if (!TextUtils.isEmpty(miniAppConfig.config.ide_extraData)) {
                        miniAppConfig.launchParam.navigateExtData = miniAppConfig.config.ide_extraData;
                    }
                }
                markMiniAppUsed();
                FirstPageInfo firstPageInfo = miniAppConfig.config.firstPage;
                if (firstPageInfo != null && miniAppConfig.launchParam != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
                    if (miniAppConfig.config.firstPage.pagePath.startsWith("/")) {
                        FirstPageInfo firstPageInfo2 = miniAppConfig.config.firstPage;
                        firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
                    }
                    if (miniAppConfig.config.firstPage.pagePath.contains(".html")) {
                        miniAppConfig.launchParam.entryPath = miniAppConfig.config.firstPage.pagePath;
                    } else if (miniAppConfig.config.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        miniAppConfig.launchParam.entryPath = miniAppConfig.config.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
                    } else {
                        miniAppConfig.launchParam.entryPath = miniAppConfig.config.firstPage.pagePath + ".html";
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("---startApp----");
                LaunchParam launchParam2 = miniAppConfig.launchParam;
                if (launchParam2 != null) {
                    str = launchParam2.entryPath;
                } else {
                    str = WiFiDash.NOT_AVALIBLE;
                }
                sb5.append(str);
                QLog.i("miniapp-start", 1, sb5.toString());
                if (QLog.isDevelopLevel()) {
                    QLog.i("miniapp-start", 4, "---startApp---- appid:" + miniAppConfig.config.appId + " appName:" + miniAppConfig.config.name);
                }
                doStartMiniApp(activity, miniAppConfig, resultReceiver);
                MiniAppUtils.preFetchAppCacheData(activity, miniAppConfig.config);
                LaunchParam launchParam3 = miniAppConfig.launchParam;
                if (launchParam3 != null) {
                    str2 = String.valueOf(launchParam3.scene);
                } else {
                    str2 = "";
                }
                if (!TextUtils.isEmpty(miniAppConfig.config.bindingAppId) || MiniAppStartUtils.shouldInterceptStartMiniApp(miniAppConfig.config.appId, str2) || miniAppConfig.isFromShowInfo() || miniAppConfig.isShortcutFakeApp()) {
                    return;
                }
                MiniAppUtils.updatePullDownEntryListData(miniAppConfig);
                return;
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.6
                @Override // java.lang.Runnable
                public void run() {
                    QLog.e(AppBrandLaunchManager.TAG, 1, "\u542f\u52a8\u5931\u8d25, scene\u672a\u77e5" + miniAppConfig.toString());
                    QQToast.makeText(AppBrandLaunchManager.this.mContext, HardCodeUtil.qqStr(R.string.jnd), 2000).show();
                }
            });
            return;
        }
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (miniAppConfig.config == null) {
                    QLog.e(AppBrandLaunchManager.TAG, 1, "\u542f\u52a8\u5931\u8d25, Appid \u4e3a\u7a7a appConfig.config==null Activity=" + activity);
                } else {
                    QLog.e(AppBrandLaunchManager.TAG, 1, "\u542f\u52a8\u5931\u8d25, Appid \u4e3a\u7a7a" + miniAppConfig.config.toString() + " Activity=" + activity);
                }
                QQToast.makeText(AppBrandLaunchManager.this.mContext, HardCodeUtil.qqStr(R.string.jne), 2000).show();
            }
        });
    }

    public synchronized void updateBaseLib() {
        try {
            BaseLibManager.g().updateBaseLib(new BaseLibManager.UpdateListener() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.9
                @Override // com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener
                public void onUpdateResult(int i3) {
                    QLog.w(AppBrandLaunchManager.TAG, 1, "updateBaseLib ret=" + i3);
                    if (i3 == 0) {
                        return;
                    }
                    if (i3 == 1) {
                        QLog.w(AppBrandLaunchManager.TAG, 1, HardCodeUtil.qqStr(R.string.jn_));
                        return;
                    }
                    String qqStr = HardCodeUtil.qqStr(R.string.jn7);
                    if (i3 == 1100) {
                        qqStr = HardCodeUtil.qqStr(R.string.jnc);
                    } else if (i3 == 1101) {
                        qqStr = HardCodeUtil.qqStr(R.string.jnf);
                    }
                    QLog.w(AppBrandLaunchManager.TAG, 1, qqStr);
                }
            });
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "updateBaseLib failed ", th5);
        }
    }

    public static AppBrandLaunchManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new AppBrandLaunchManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleStartMiniappByBroadcast(MiniAppInfo miniAppInfo, int i3, String str) {
        if (miniAppInfo != null) {
            try {
                MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                LaunchParam launchParam = new LaunchParam();
                miniAppConfig.launchParam = launchParam;
                launchParam.miniAppId = miniAppInfo.appId;
                launchParam.scene = 2016;
                launchParam.shareTicket = str;
                if (i3 != 1 && i3 == 3) {
                    launchParam.forceReload = 3;
                }
                MiniAppLauncher.launchAppByAppConfig(null, miniAppConfig, null);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preDownloadPkgCallback(int i3, String str, IMiniCallback iMiniCallback) {
        if (iMiniCallback == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("retCode", i3);
        bundle.putString("errMsg", str);
        iMiniCallback.onCallbackResult(i3 == 0, bundle);
    }

    private void setScreenRecordEnabledParam(MiniAppConfig miniAppConfig) {
        if (miniAppConfig != null && miniAppConfig.isEngineTypeMiniGame()) {
            miniAppConfig.launchParam.isScreenRecordEnabled = MiniGameConfigProcessor.loadConfig().getScreenRecordEnabled();
        }
    }

    public void preLaunchMiniApp(Context context, MiniAppConfig miniAppConfig) {
        if (miniAppConfig != null && (!miniAppConfig.isEngineTypeMiniGame())) {
            MiniSdkLauncher.preLaunchMiniApp(context, miniAppConfig);
        }
    }

    private void doStartMiniApp(Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) {
        Bundle bundle;
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_HARD_CODER_ENABLED, true)) {
            QMLog.w(TAG, "hard coder started, reqId: " + HardCoderManager.getInstance().start(0, 1, 0, 1, new int[]{Process.myTid()}, this.hardCoderTimeout, 601, 1L, Process.myTid(), "miniLaunch", true));
        } else {
            QMLog.w(TAG, "hard coder disabled");
        }
        if (!miniAppConfig.isEngineTypeMiniGame()) {
            bundle = new Bundle();
            bundle.putBoolean(AppBrandContant.LAUNCH_SDK_MODE, true);
        } else {
            bundle = null;
        }
        miniAppConfig.isSdkMode = true;
        MiniSdkLauncher.startMiniApp(activity, miniAppConfig, bundle, resultReceiver);
        getHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.4
            @Override // java.lang.Runnable
            public void run() {
                MiniAppUtils.updateMiniAppList(6);
            }
        }, 1000L);
    }
}
