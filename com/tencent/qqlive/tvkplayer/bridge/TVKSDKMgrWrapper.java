package com.tencent.qqlive.tvkplayer.bridge;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqlive.tvkplayer.ad.api.TVKAdFactory;
import com.tencent.qqlive.tvkplayer.api.ITVKBeaconDataReporter;
import com.tencent.qqlive.tvkplayer.api.ITVKCustomizedCapability;
import com.tencent.qqlive.tvkplayer.api.ITVKHttpDnsResolver;
import com.tencent.qqlive.tvkplayer.api.ITVKLogListener;
import com.tencent.qqlive.tvkplayer.api.ITVKLogReportListener;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import com.tencent.qqlive.tvkplayer.capability.TVKCapabilityMgr;
import com.tencent.qqlive.tvkplayer.config.TVKConfigChangedListener;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManager;
import com.tencent.qqlive.tvkplayer.logic.TVKThreadAnnotations;
import com.tencent.qqlive.tvkplayer.moduleupdate.api.ITVKModuleUpdaterMgrPrivate;
import com.tencent.qqlive.tvkplayer.moduleupdate.api.TVKModuleUpdaterFactory;
import com.tencent.qqlive.tvkplayer.postprocess.api.TVKPostProcessResourceMgr;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKAssetPlayerMsgMap;
import com.tencent.qqlive.tvkplayer.report.api.ITVKReportFactory;
import com.tencent.qqlive.tvkplayer.report.api.TVKBeaconReport;
import com.tencent.qqlive.tvkplayer.report.api.TVKReportFactoryCreator;
import com.tencent.qqlive.tvkplayer.tools.auth.TVKAppKeyManager;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKVersion;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.qqlive.tvkplayer.tools.config.TVKDVMAConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsResolverFactory;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKApplicationLifecycleObserver;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKAudioSpatializer;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKElapsedTimeStatistics;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogReporter;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKPlayerBroadcastReceiver;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIFactory;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade;
import com.tencent.thumbplayer.api.common.ITPLogListener;
import com.tencent.thumbplayer.api.common.ITPModuleLoader;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.report.ITPBeaconDataReporter;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSDKMgrWrapper implements ITVKSDKInitBridge {
    private static final String TAG = "TVKPlayer[TVKSDKMgrWrapper]";
    private static volatile TVKSDKMgrWrapper sInstance = null;
    private static final int sTimerInterMs = 1800000;
    private String mHostConfig;
    private boolean mIsHostSet = false;
    private boolean mIsInit = false;
    private String mVsAppKey;
    private String mVvAppkey;

    TVKSDKMgrWrapper() {
    }

    private void configTPMgr() {
        boolean z16;
        boolean z17 = true;
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.media_codec_multi_instance_black_list)) {
            TPMgr.addOptionalParam(TPOptionalParam.buildInt(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_INT_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT, 1));
        }
        if (!TVKCommParams.isPreviewMode() && TVKMediaPlayerConfig.PlayerConfig.tp_player_report_enable) {
            z16 = true;
        } else {
            z16 = false;
        }
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT, z16));
        if (TVKCommParams.isPreviewMode() || !TVKMediaPlayerConfig.PlayerConfig.is_thumbplayer_reportv2_on) {
            z17 = false;
        }
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT, z17));
        TPMgr.addOptionalParam(TPOptionalParam.buildLong(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_LONG_VIDEO_MEDIACODEC_STUCK_TIMEOUT_MS, TVKMediaPlayerConfig.PlayerConfig.mediacodec_stuck_timeout_ms));
        TPMgr.addOptionalParam(TPOptionalParam.buildString(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_GUID, TVKCommParams.getStaGuid()));
        TPMgr.addOptionalParam(TPOptionalParam.buildString(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_DEVICE_NAME, TVKVcSystemInfo.getDeviceModel()));
        TPMgr.addOptionalParam(TPOptionalParam.buildInt(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_INT_PLATFORM, TVKVersion.getPlatformInteger()));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_FFMPEG_LOG_PTHREAD_LOCAL_STORAGE, TVKMediaPlayerConfig.PlayerConfig.enable_ffmpeg_log_pthread_local_storage));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDR_DOWNWARD_COMPATIBILITY, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_downward_compatibility));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_SOFT_DYNAMIC_MAPPING, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_software_dynamic_mapping));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_HDRVIVID_HARD_DYNAMIC_MAPPING, TVKMediaPlayerConfig.PlayerConfig.enable_hdr_vivid_hardware_dynamic_mapping));
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_CAPABILITY_MODEL, TVKMediaPlayerConfig.PlayerConfig.enable_new_capability));
    }

    public static TVKSDKMgrWrapper getSdkMgrWrapperInstance() {
        if (sInstance == null) {
            synchronized (TVKSDKMgrWrapper.class) {
                if (sInstance == null) {
                    sInstance = new TVKSDKMgrWrapper();
                }
            }
        }
        return sInstance;
    }

    private static void getServerTimeAsync() {
        TVKCGIFactory.getServerTimeInstance().setServerTimeCompleteListener(new ITVKServerTimeGetter.ITVKServerTimeCompleteListener() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.6
            @Override // com.tencent.qqlive.tvkplayer.vinfo.api.ITVKServerTimeGetter.ITVKServerTimeCompleteListener
            public void onComplete(String str) {
                TPDataTransportMgr.setGlobalOptionalConfigParam("external_network_ip", str);
            }
        });
        TVKThreadPool.getInstance().obtainScheduledExecutorService().scheduleAtFixedRate(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.7
            @Override // java.lang.Runnable
            public void run() {
                TVKCGIFactory.getServerTimeInstance().execute();
            }
        }, 0L, 1800000L, TimeUnit.MILLISECONDS);
    }

    private void initAnnotations() {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        TVKThreadAnnotations.register(TVKPlayerManager.class, 0);
        TVKLogUtil.i(TAG, "initSdk, TVKThreadAnnotations annotations, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
    }

    private Future<Boolean> initAsyncWithWait(final Context context) {
        return TVKThreadPool.getInstance().obtainHighPriorityExecutor().submit(new Callable<Boolean>() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                TVKSDKMgrWrapper.this.initInAsyncThread(context);
                return Boolean.TRUE;
            }
        });
    }

    private void initAsyncWithoutWait() {
        TVKThreadPool.getInstance().obtainHighPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
                tVKElapsedTimeStatistics.startPoint();
                TVKAssetPlayerMsgMap.init();
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, TVKAssetPlayerMsgMap annotations, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
                TVKSDKMgrWrapper.this.initCommonParams();
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, initAsyncWithoutWait, initCommonParams, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
                TVKPlayerBroadcastReceiver.getInstance().initReceivers();
                TVKTPCapability.init();
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, initAsyncWithoutWait TVKCodecUtils.init, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
                TVKApplicationLifecycleObserver.registerObserverOnUIThread();
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, initAsyncWithoutWait register lifecycleObserver, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
                TVKDVMAConfig.loadAndApplyConfig();
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, initAsyncWithoutWait TVKDVMAConfig.loadAndApplyConfig, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
                TVKPostProcessResourceMgr.updateResourceAsyncWithDelay(TVKMediaPlayerConfig.PlayerConfig.post_process_resource_update_delay_ms);
                TVKAudioSpatializer.getInstance().init(TVKCommParams.getApplicationContext());
                ITVKReportFactory reportFactory = TVKReportFactoryCreator.getReportFactory();
                if (reportFactory != null) {
                    reportFactory.createDeviceCapabilityReport().onTVKInitialized();
                }
                if (!TVKCommParams.isDebug() && TVKMediaPlayerConfig.PlayerConfig.qm_enable_pt) {
                    CKeyFacade.qm_enable_pt(TVKCommParams.getApplicationContext());
                }
                TVKLogUtil.i(TVKSDKMgrWrapper.TAG, "initSdk, initAsyncWithoutWait all times: " + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
            }
        });
    }

    private void initCKey(Context context, String str) {
        CKeyFacade.setInterface(TVKVcSystemInfo.getAppVersionName(context), TVKAppKeyManager.getChannelId(), new BeaconInterface() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.3
            @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
            public String getQIMEI() {
                return TVKCommParams.getQimei36();
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
            public Properties getRequiredReportValue() {
                return new Properties();
            }

            @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.BeaconInterface
            public boolean trackCustomKVEvent(String str2, Map<String, String> map) {
                return true;
            }
        }, null);
        CKeyFacade.instance().initAsync(context, str, TVKCommParams.getStaGuid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCommonParams() {
        try {
            if (TVKCommParams.getApplicationContext() != null && TVKCommParams.getApplicationContext().getCacheDir() != null) {
                TVKUtils.copyAssetsToDst(TVKCommParams.getApplicationContext(), "tvk_filterres", TVKCommParams.getApplicationContext().getCacheDir().getAbsolutePath());
                TVKCommParams.setAssetCacheFilePath(TVKCommParams.getApplicationContext().getCacheDir().getAbsolutePath());
            }
        } catch (NullPointerException e16) {
            TVKLogUtil.e(TAG, e16);
        } catch (Exception e17) {
            TVKLogUtil.e(TAG, e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInAsyncThread(Context context) {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        initCKey(context, this.mVsAppKey);
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait, ckey, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
        getServerTimeAsync();
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait getServerTimeAsync, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
        TVKConfigSystem.getInstance().requestOnlineConfigAsync(new TVKConfigChangedListener());
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait, requestOnlineConfigAsync times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
        if (TVKAdFactory.getAdInit() != null) {
            TVKAdFactory.getAdInit().init();
        }
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait, ad init, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
        initAnnotations();
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait, Annotations, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPointAndPoint());
        TVKLogUtil.i(TAG, "initSdk, initAsyncWithWait all times: " + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
    }

    private void initModuleUpdate(Context context) {
        try {
            if (TVKModuleUpdaterFactory.getModuleUpdaterMgr(context) instanceof ITVKModuleUpdaterMgrPrivate) {
                ((ITVKModuleUpdaterMgrPrivate) TVKModuleUpdaterFactory.getModuleUpdaterMgr(context)).init();
            }
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
        }
    }

    private void initSync(Context context) {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        initTPMgr(context);
        TVKLogUtil.i(TAG, "initSdk, initSync initTPMgr, times: " + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
    }

    private void initTPMgr(Context context) {
        ITPModuleLoader iTPModuleLoader;
        TPMgr.setLogListener(new ITPLogListener() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.4
            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void d(String str, String str2) {
                TVKLogUtil.d(str, str2);
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void e(String str, String str2) {
                TVKLogUtil.e(str, str2);
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void i(String str, String str2) {
                TVKLogUtil.i(str, str2);
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void v(String str, String str2) {
                TVKLogUtil.v(str, str2);
            }

            @Override // com.tencent.thumbplayer.api.common.ITPLogListener
            public void w(String str, String str2) {
                TVKLogUtil.w(str, str2);
            }
        });
        if (TVKModuleUpdaterFactory.getModuleLibraryLoader() != null) {
            iTPModuleLoader = TVKModuleUpdaterFactory.getModuleLibraryLoader().getModuleLoader();
        } else {
            iTPModuleLoader = null;
        }
        configTPMgr();
        TPMgr.initThumbPlayer(context, iTPModuleLoader);
        TVKCommParams.setSelfPlayerAvailable(TPMgr.isSelfDevPlayerAvailable());
    }

    private boolean isValidAppKey(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKLogUtil.e(TAG, "tvkAppKey is empty");
            return false;
        }
        String[] split = str.split("\\|");
        if (split != null && split.length >= 2) {
            return true;
        }
        TVKLogUtil.e(TAG, "tvkAppKey is invalid");
        return false;
    }

    private void parseAppKey(String str) {
        String[] split = str.split("\\|");
        this.mVvAppkey = split[0];
        this.mVsAppKey = split[1];
    }

    private void preInitSync(Context context, String str) {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        TVKCommParams.init(context, str);
        TVKLogUtil.i(TAG, "initSdk, preInitSync, initCommParams times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
        tVKElapsedTimeStatistics.point();
        initModuleUpdate(context);
        TVKLogUtil.i(TAG, "initSdk, preInitSync, initModuleUpdate times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
        TVKLogUtil.i(TAG, "initSdk, preInitSync all, times: " + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
    }

    private boolean verifyAppkey(Context context, String str) {
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        if (!isValidAppKey(str)) {
            TVKLogUtil.e(TAG, "initSdk failed, tvkAppKey is invalid, return false");
            return false;
        }
        parseAppKey(str);
        TVKAppKeyManager.init(context, this.mVvAppkey);
        if (!TVKAppKeyManager.isAuthorized()) {
            TVKLogUtil.e(TAG, "initSdk failed, appKey verify failed, return false");
            return false;
        }
        TVKLogUtil.i(TAG, "initSdk, appKey verify success, cost times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getAdChid() {
        return TVKVersion.getAdChId();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public int getCellularDataCost() {
        if (!this.mIsInit) {
            return -1;
        }
        try {
            return Integer.parseInt(TPDataTransportMgr.getGlobalAccessibleNativeInfo(2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getChannelId() {
        return TVKVersion.getChannelId();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public long getCurrentServerTimeSec() {
        return TVKCGIFactory.getServerTimeInstance().calculateCurrentServerTimeSec();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getPlatform() {
        return TVKVersion.getPlatform();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getPlayerCoreModuleName() {
        return "TPCore";
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public int getPlayerCoreType() {
        String str;
        try {
            str = TPMgr.getLibVersion("TPCore");
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.contains(Element.ELEMENT_NAME_MIN)) {
            return 2;
        }
        if (str.contains("full")) {
            return 3;
        }
        if (!str.contains("lite")) {
            return 1;
        }
        return 4;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getPlayerCoreVersion() {
        String str;
        int lastIndexOf;
        try {
            str = TPMgr.getLibVersion("TPCore");
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, e16);
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) >= 0) {
            return str.substring(0, lastIndexOf + 1);
        }
        return str;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getSdkVersion() {
        return TVKVersion.getPlayerVersion();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public String getSdtfrom() {
        return TVKVersion.getSdtfrom();
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public synchronized boolean initSdk(@NonNull Context context, String str, String str2) {
        if (this.mIsInit) {
            TVKLogUtil.w(TAG, "initSdk has already been initialized");
            return true;
        }
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        if (!verifyAppkey(context, str)) {
            TVKLogUtil.i(TAG, "initSdk failed, Auth failed");
            return false;
        }
        preInitSync(context, str2);
        Future<Boolean> initAsyncWithWait = initAsyncWithWait(context);
        initSync(context);
        initAsyncWithoutWait();
        tVKElapsedTimeStatistics.point();
        try {
            if (initAsyncWithWait.get().booleanValue()) {
                TVKLogUtil.i(TAG, "initSdk, wait initThread finish, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
            }
        } catch (InterruptedException unused) {
            TVKLogUtil.i(TAG, "initSdk, wait initThread InterruptedException, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
        } catch (ExecutionException unused2) {
            TVKLogUtil.i(TAG, "initSdk, wait initThread ExecutionException, times: " + tVKElapsedTimeStatistics.costTimeMsFromLastPoint());
        }
        this.mIsInit = true;
        TVKLogUtil.i(TAG, "initSdk total cost: " + tVKElapsedTimeStatistics.costTimeMsFromStartPoint());
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public boolean isSelfPlayerAvailable(Context context) {
        return TVKPlayerStrategy.isSelfPlayerAvailable(context);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public synchronized void setAbUserId(String str) {
        TVKCommParams.setAbUserId(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setBeaconDataReporterBeforeInit(final ITVKBeaconDataReporter iTVKBeaconDataReporter) {
        ITPBeaconDataReporter iTPBeaconDataReporter;
        TVKBeaconReport.setBeaconDataReporter(iTVKBeaconDataReporter);
        if (iTVKBeaconDataReporter == null) {
            iTPBeaconDataReporter = null;
        } else {
            iTPBeaconDataReporter = new ITPBeaconDataReporter() { // from class: com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrWrapper.5
                @Override // com.tencent.thumbplayer.api.report.ITPBeaconDataReporter
                public void trackCustomKVEvent(String str, String str2, Map<String, String> map) {
                    iTVKBeaconDataReporter.trackCustomKVEvent(str, str2, map);
                }
            };
        }
        TPMgr.setBeaconDataReporterBeforeInit(iTPBeaconDataReporter);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setCustomizedCapability(ITVKCustomizedCapability iTVKCustomizedCapability) {
        TVKCapabilityMgr.getInstance().setCustomizedCapability(iTVKCustomizedCapability);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setDebugEnable(boolean z16) {
        TVKCommParams.isDebug(z16);
        TVKLogUtil.setDebugEnable(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public synchronized void setGuid(String str) {
        TVKCommParams.setStaGuid(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setHostConfigBeforeInitSDK(String str) {
        if (!this.mIsHostSet) {
            this.mIsHostSet = true;
            this.mHostConfig = str;
            TVKLogUtil.i(TAG, "TVKSDKMgrWrapper, setHostConfigBeforeInitSDK:" + this.mHostConfig);
            TVKUrlConfig.applyUrlConfig(this.mHostConfig);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setHttpDnsResolver(ITVKHttpDnsResolver iTVKHttpDnsResolver) {
        TVKHttpDnsResolverFactory.setExternalHttpDnsResolver(iTVKHttpDnsResolver);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setOnLogListener(ITVKLogListener iTVKLogListener) {
        TVKLogUtil.setOnLogListener(iTVKLogListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setOnLogReportListener(ITVKLogReportListener iTVKLogReportListener) {
        TVKLogReporter.setOnLogReportListener(iTVKLogReportListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setQQ(String str) {
        TVKCommParams.setQQ(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setSDKProperty(String str, String str2) {
        String str3;
        boolean z16;
        if (TVKSDKMgr.PROPERTY_BEFORE_INIT_DEVICE_NAME.equals(str)) {
            TVKVcSystemInfo.setDeviceModel(str2);
            return;
        }
        if (TVKSDKMgr.PROPERTY_BEFORE_INIT_ENABLE_PREVIEW_MODE.equals(str)) {
            TVKCommParams.isPreviewMode(Boolean.parseBoolean(str2));
            boolean z17 = false;
            if (!TVKCommParams.isPreviewMode() && TVKMediaPlayerConfig.PlayerConfig.tp_player_report_enable) {
                z16 = true;
            } else {
                z16 = false;
            }
            TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT, z16));
            if (!TVKCommParams.isPreviewMode() && TVKMediaPlayerConfig.PlayerConfig.is_thumbplayer_reportv2_on) {
                z17 = true;
            }
            TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_NEW_PLAYING_QUALITY_REPORT, z17));
            CKeyFacade.setPrivacy(!TVKCommParams.isPreviewMode());
            return;
        }
        if (TVKSDKMgr.PROPERTY_BEFORE_INIT_QIMEI36.equals(str)) {
            TVKCommParams.setQimei36(str2);
            return;
        }
        if (TVKSDKMgr.PROPERTY_GLOBAL_ENABLE_TEXTURE_VIEW_DESTROYED_ASYNC.equals(str)) {
            TVKCommParams.setTextureViewDestroyedAsyncEnabled(Boolean.parseBoolean(str2));
            return;
        }
        if (TVKSDKMgr.PROPERTY_GLOBAL_ENABLE_SURFACE_VIEW_DESTROYED_ASYNC.equals(str)) {
            TVKCommParams.setSurfaceViewDestroyedAsyncEnabled(Boolean.parseBoolean(str2));
        } else if (TVKSDKMgr.PROPERTY_GLOBAL_ENABLE_MULTI_NETWORK_DOWNLOAD.equals(str)) {
            if (Boolean.parseBoolean(str2)) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            TPDataTransportMgr.setGlobalOptionalConfigParam("use_multi_network", str3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setSdkConfig(String str) {
        TVKLogUtil.i(TAG, "App set config content:" + str);
        TVKConfigSystem.getInstance().updateConfigFromLocal(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public synchronized void setUpc(String str) {
        if (TextUtils.isEmpty(str)) {
            TVKCommParams.setFreeNetFlowRequestMap(null);
            TVKCommParams.setOriginalUpc("");
            TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_code", TVKCommParams.getOriginalUpc());
            TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_state", String.valueOf(TVKCommParams.getUpcState()));
            return;
        }
        TVKCommParams.setOriginalUpc(str);
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split.length > 0) {
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            TVKCommParams.setFreeNetFlowRequestMap(hashMap);
        }
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_code", TVKCommParams.getOriginalUpc());
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_state", String.valueOf(TVKCommParams.getUpcState()));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setUpcState(int i3) {
        TVKCommParams.setUpcState(i3);
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_code", TVKCommParams.getOriginalUpc());
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_state", String.valueOf(i3));
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setUrlEnvironment(int i3) {
        TVKUrlConfig.setCurrentEnv(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.bridge.ITVKSDKInitBridge
    public void setHttpClientOption(int i3, boolean z16, int i16) {
    }
}
