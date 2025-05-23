package com.tencent.superplayer.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.tvkplayer.api.ITVKLogListener;
import com.tencent.qqlive.tvkplayer.api.TVKSDKMgr;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;
import com.tencent.superplayer.api.SPDeinitManager;
import com.tencent.superplayer.bandwidth.SPBandwidthPredictor;
import com.tencent.superplayer.bandwidth.a;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.superplayer.datatransport.SPProxyConfig;
import com.tencent.superplayer.player.SuperPlayerPool;
import com.tencent.superplayer.report.SPBeaconReporter;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.superplayer.utils.CodecReuseHelper;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.superplayer.utils.HardwareUtil;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.common.ITPLogListener;
import com.tencent.thumbplayer.api.common.ITPModuleLoader;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.manager.TPMgrConfig;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportEnum;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.core.datatransport.apiinner.TPDataTransportTaskListenerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.report.reportv1.BeaconAdapter;
import com.tencent.tmediacodec.TCodecManager;
import com.tencent.tmediacodec.util.ILogProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import tt3.a;

/* loaded from: classes26.dex */
public class SuperPlayerSDKMgr {
    private static final int DEINIT_MIN_VERSION = 2100030;
    private static final String SCEENID_SPLIT = "\\|";
    private static final String SDK_Version = "1.1.0";
    private static final String TAG = "SuperPlayerSDKMgr";
    private static volatile String appKeyForTVK;
    private static Context sAppContext;
    private static String sDataCacheFolder;
    private static final DeinitDownloadProxyTask sDeinitDownloadProxyTask;
    private static String sDeviceId;
    private static Map<String, String> sGlobalReportMap;
    private static final InnerLibLoader sInnerLibLoader;
    private static final InnerLogListener sInnerLogListener;
    private static volatile ILogListener sLogListener;
    private static int sPlatform;
    private static final QuickDeinitPlayerTask sQuickDeinitPlayerTask;
    private static volatile ISuperModuleLoader sSuperLidLoader;
    private static final ITPLogListener sTPLogListener;
    private static String sUid;
    private static volatile String uinForTVK;
    private static AtomicBoolean sIsSuperInit = new AtomicBoolean(false);
    private static AtomicBoolean sIsTPPlayerInit = new AtomicBoolean(false);
    private static AtomicBoolean sIsTVideoInit = new AtomicBoolean(false);
    private static AtomicBoolean sIsTPDownloadInit = new AtomicBoolean(false);
    private static AtomicBoolean sIsTVKInit = new AtomicBoolean(false);
    private static SuperPlayerSdkOption sSdkOption = SuperPlayerSdkOption.option();
    private static final ISuperPlayerPool sPlayerRunningPool = new SuperPlayerPool();
    private static final SPDeinitManager sDeinitManager = new SPDeinitManager();
    private static boolean sShowPlayerDebugView = false;
    private static boolean sAllowP2PUploadDefault = true;
    private static double sTPCoreSampleRate = 1.0d;
    private static int downloadProxyVersion = 0;
    private static int tpcoreVersion = 0;
    private static volatile boolean hadSetLibLoader = false;
    private static volatile boolean needInitTVK = false;
    private static final List<Integer> sCurrentP2PScene = new ArrayList();

    /* loaded from: classes26.dex */
    private static class DeinitDownloadProxyTask implements Runnable {
        DeinitDownloadProxyTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            LogUtil.d(SuperPlayerSDKMgr.TAG, "DeinitDownloadProxyTask: time end, start deinit, size=" + SuperPlayerSDKMgr.sPlayerRunningPool.size());
            if (SuperPlayerSDKMgr.access$800()) {
                LogUtil.d(SuperPlayerSDKMgr.TAG, "DeinitDownloadProxyTask: still has player active, can't deinit downloadProxy");
                return;
            }
            if (SuperPlayerSDKMgr.sPlayerRunningPool.size() > 0) {
                z16 = SuperPlayerSDKMgr.sDeinitManager.deinitAllRunningPlayer(SuperPlayerSDKMgr.sPlayerRunningPool, false);
            } else {
                z16 = true;
            }
            LogUtil.d(SuperPlayerSDKMgr.TAG, "DeinitDownloadProxyTask: deInitDownloadProxy allDeinit=" + z16);
            if (SuperPlayerSDKMgr.getDownloadProxyVersionInt() >= 2100030 && z16) {
                SuperPlayerSDKMgr.deInitDownloadProxy();
            }
        }
    }

    /* loaded from: classes26.dex */
    public interface ILogListener {
        int d(String str, String str2);

        int e(String str, String str2);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class InnerLibLoader implements ITPModuleLoader, ITPDLProxyNativeLibLoader {
        InnerLibLoader() {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader
        public boolean loadLib(String str, String str2) {
            if (SuperPlayerSDKMgr.sSuperLidLoader != null) {
                SuperPlayerSDKMgr.sSuperLidLoader.loadLibrary(str, str2);
                return true;
            }
            System.loadLibrary(str);
            return true;
        }

        @Override // com.tencent.thumbplayer.api.common.ITPModuleLoader
        public void loadLibrary(@NonNull String str) throws Exception {
            if (SuperPlayerSDKMgr.sSuperLidLoader != null) {
                SuperPlayerSDKMgr.sSuperLidLoader.loadLibrary(str, "");
            } else {
                System.loadLibrary(str);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class InnerTPLogListener implements ITPLogListener {
        InnerTPLogListener() {
        }

        @Override // com.tencent.thumbplayer.api.common.ITPLogListener
        public void d(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                SuperPlayerSDKMgr.sLogListener.d(str, str2);
            }
        }

        @Override // com.tencent.thumbplayer.api.common.ITPLogListener
        public void e(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                SuperPlayerSDKMgr.sLogListener.e(str, str2);
            }
        }

        @Override // com.tencent.thumbplayer.api.common.ITPLogListener
        public void i(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                SuperPlayerSDKMgr.sLogListener.i(str, str2);
            }
        }

        @Override // com.tencent.thumbplayer.api.common.ITPLogListener
        public void v(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                SuperPlayerSDKMgr.sLogListener.v(str, str2);
            }
        }

        @Override // com.tencent.thumbplayer.api.common.ITPLogListener
        public void w(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                SuperPlayerSDKMgr.sLogListener.w(str, str2);
            }
        }
    }

    /* loaded from: classes26.dex */
    private static class QuickDeinitPlayerTask implements Runnable {
        QuickDeinitPlayerTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.d(SuperPlayerSDKMgr.TAG, "QuickDeinitPlayerTask: time end, start deinit, size=" + SuperPlayerSDKMgr.sPlayerRunningPool.size());
            if (SuperPlayerSDKMgr.access$800()) {
                LogUtil.d(SuperPlayerSDKMgr.TAG, "QuickDeinitPlayerTask: still has player active, can't deinit downloadProxy");
            } else if (SuperPlayerSDKMgr.sPlayerRunningPool.size() > 0) {
                SuperPlayerSDKMgr.sDeinitManager.deinitAllRunningPlayer(SuperPlayerSDKMgr.sPlayerRunningPool, true);
            }
        }
    }

    static {
        sInnerLogListener = new InnerLogListener();
        sTPLogListener = new InnerTPLogListener();
        sDeinitDownloadProxyTask = new DeinitDownloadProxyTask();
        sQuickDeinitPlayerTask = new QuickDeinitPlayerTask();
        sInnerLibLoader = new InnerLibLoader();
    }

    static /* synthetic */ boolean access$800() {
        return checkAnyPlayerPlaying();
    }

    public static void addVideoHwCodecBlackList(final int i3) {
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            LogUtil.d(TAG, "addVideoHwCodecBlackList, codecId=" + i3);
            return;
        }
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TPDecoderCapability.addCustomizedVideoMediaCodecCapability(i3, 0);
                } catch (TPLoadLibraryException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    private static boolean checkAnyPlayerPlaying() {
        ISuperPlayerPool iSuperPlayerPool = sPlayerRunningPool;
        if (iSuperPlayerPool.size() > 0) {
            for (Map.Entry<String, ISuperPlayer> entry : iSuperPlayerPool.getAllPlayer().entrySet()) {
                ISuperPlayer value = entry.getValue();
                if (value == null) {
                    LogUtil.e(TAG, "checkAnyPlayerPlaying error player null token=" + entry.getKey());
                } else if (value.isPlaying()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void clearCache(int i3, String str) {
        if (TextUtils.isEmpty(getDataCacheFolder())) {
            LogUtil.e(TAG, "deleteCache: faile, data cahce folder null");
            return;
        }
        int i16 = CommonUtil.i(i3);
        ITPDownloadProxy tPDownloadPoxy = getTPDownloadPoxy(i3);
        if (tPDownloadPoxy != null) {
            tPDownloadPoxy.clearCache(CommonUtil.h(i16), str, 4);
        }
    }

    public static void clearMemoryCache(int i3) {
        ITPDownloadProxy tPDownloadPoxy = getTPDownloadPoxy(i3);
        if (tPDownloadPoxy != null) {
            tPDownloadPoxy.clearCache("", "", 16);
        }
    }

    public static void clearVideoHwCodecBlackList(final int i3) {
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            LogUtil.d(TAG, "clearVideoHwCodecBlackList, codecId=" + i3);
            return;
        }
        ThreadUtil.runOnThreadPool(new Runnable() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TPDecoderCapability.addCustomizedVideoMediaCodecCapability(i3, 1);
                } catch (TPLoadLibraryException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    public static void deInitDownloadProxy() {
        TPDownloadProxyFactory.deInitAllProxy();
    }

    public static String getAllPlayerInfo() {
        ISuperPlayerPool iSuperPlayerPool = sPlayerRunningPool;
        if (iSuperPlayerPool.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            Iterator<Map.Entry<String, ISuperPlayer>> it = iSuperPlayerPool.getAllPlayer().entrySet().iterator();
            while (it.hasNext()) {
                SPDeinitManager.DeinitPlayerInfo deinitPlayerInfo = SPDeinitManager.getDeinitPlayerInfo(it.next().getValue());
                sb5.append("{");
                sb5.append(deinitPlayerInfo.serviceType);
                sb5.append("-");
                sb5.append(deinitPlayerInfo.playerTag);
                sb5.append("}");
                sb5.append(", ");
            }
            sb5.append("]");
            return sb5.toString();
        }
        return null;
    }

    private static String getAllPlayingPlayerInfo() {
        ISuperPlayerPool iSuperPlayerPool = sPlayerRunningPool;
        if (iSuperPlayerPool.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[");
            for (Map.Entry<String, ISuperPlayer> entry : iSuperPlayerPool.getAllPlayer().entrySet()) {
                if (entry.getValue().isPlaying()) {
                    SPDeinitManager.DeinitPlayerInfo deinitPlayerInfo = SPDeinitManager.getDeinitPlayerInfo(entry.getValue());
                    sb5.append("{");
                    sb5.append(deinitPlayerInfo.serviceType);
                    sb5.append("-");
                    sb5.append(deinitPlayerInfo.playerTag);
                    sb5.append("}");
                    sb5.append(", ");
                }
            }
            sb5.append("]");
            return sb5.toString();
        }
        return null;
    }

    public static Context getContext() {
        return sAppContext;
    }

    public static String getDataCacheFolder() {
        return sDataCacheFolder;
    }

    public static SPDeinitManager getDeinitManager() {
        return sDeinitManager;
    }

    public static String getDeviceId() {
        return sDeviceId;
    }

    public static long getDownloadProxyTotalMemorySizeKB() {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return TPDownloadProxyNative.getInstance().GetTotalMemorySizeKB();
        }
        return 0L;
    }

    public static long getDownloadProxyVersionInt() {
        int i3;
        int i16 = downloadProxyVersion;
        if (i16 > 0) {
            return i16;
        }
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return 0L;
        }
        try {
            i3 = Integer.parseInt(TPDownloadProxyHelper.getNativeLibVersion().replace("full", "").replace(Element.ELEMENT_NAME_MIN, "").replace(".", ""));
        } catch (NumberFormatException e16) {
            LogUtil.e(TAG, "getDownloadProxyVersionInt error = " + e16);
            i3 = 0;
        }
        downloadProxyVersion = i3;
        LogUtil.d(TAG, "getDownloadProxyVersionInt " + downloadProxyVersion);
        return i3;
    }

    public static Map<String, String> getGlobalReportMap() {
        return sGlobalReportMap;
    }

    public static ILogListener getLogListener() {
        return sLogListener;
    }

    public static int getPlatform() {
        return sPlatform;
    }

    public static ISuperPlayerPool getPlayerPool() {
        return sPlayerRunningPool;
    }

    public static String getSDKVersion() {
        return SDK_Version;
    }

    public static SuperPlayerSdkOption getSdkOption() {
        return sSdkOption;
    }

    public static double getTPCoreSampleRate() {
        return sTPCoreSampleRate;
    }

    public static long getTPCoreVersionInt() {
        int i3;
        int i16 = tpcoreVersion;
        if (i16 > 0) {
            return i16;
        }
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return 0L;
        }
        try {
            i3 = Integer.parseInt(TPVersion.getSelfDevPlayerVersion().replace("full", "").replace(Element.ELEMENT_NAME_MIN, "").replace(".", ""));
        } catch (NumberFormatException e16) {
            LogUtil.e(TAG, "getTPCoreVersionInt error = " + e16);
            i3 = 0;
        }
        tpcoreVersion = i3;
        LogUtil.d(TAG, "getTPCoreVersionInt " + tpcoreVersion);
        return i3;
    }

    private static ITPDownloadProxy getTPDownloadPoxy(int i3) {
        CommonUtil.j(CommonUtil.i(i3));
        return TPDownloadProxyFactory.getTPDownloadProxy(CommonUtil.i(i3));
    }

    public static String getUid() {
        return sUid;
    }

    public static boolean hasDeviceId() {
        String str = sDeviceId;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean hasSuperInit() {
        return sIsSuperInit.get();
    }

    private static void initConfigComponent() {
        ConfigManager.get().init();
        ConfigManager.get().setCallback(new ConfigManager.OnConfigCallback() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.2
            @Override // com.tencent.superplayer.config.ConfigManager.OnConfigCallback
            public void onConfigPulled() {
                TCodecManager.getInstance().getReusePolicy().eraseType = CodecReuseHelper.get().getEraseType();
            }
        });
    }

    private static void initDeviceInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            str = DeviceInfoMonitor.getModel();
            sSdkOption.deviceModel = str;
        }
        HardwareUtil.setDeviceName(str);
        TPSystemInfo.setDeviceName(str);
        if (CommonUtil.n()) {
            TVKVcSystemInfo.setDeviceModel(str);
        }
    }

    private static void initGlobalDownloadProxyInfo() {
        SPProxyConfig.init(sSdkOption);
        TPDataTransportMgr.setGlobalOptionalConfigParam("platform", String.valueOf(getPlatform()));
        TPDataTransportMgr.setGlobalOptionalConfigParam("guid", sDeviceId);
        TPDataTransportMgr.setGlobalOptionalConfigParam("device_model", sSdkOption.deviceModel);
    }

    private static synchronized void initLib() {
        synchronized (SuperPlayerSDKMgr.class) {
            if (!hadSetLibLoader) {
                return;
            }
            try {
                TPLibraryLoader.loadAllLibraries(getContext());
                TPDownloadProxyNative.getInstance().isNativeLoaded();
            } catch (Throwable th5) {
                LogUtil.e(TAG, "initLib error, " + th5.toString());
            }
        }
    }

    public static void initSDK(Context context, int i3, String str) {
        initSDK(context, i3, str, SuperPlayerSdkOption.option());
    }

    public static void initSDKForDownload(Context context, int i3, String str, SuperPlayerSdkOption superPlayerSdkOption) {
        initSuper(context, i3, str, superPlayerSdkOption);
        initTPDownload();
    }

    public static void initSDKForSystemPlayer(Context context, int i3, String str, SuperPlayerSdkOption superPlayerSdkOption) {
        initSuper(context, i3, str, superPlayerSdkOption);
        initTPPlayer();
    }

    public static synchronized void initSDKForTVK(Context context, String str, String str2) {
        synchronized (SuperPlayerSDKMgr.class) {
            if (sIsTVKInit.get()) {
                return;
            }
            appKeyForTVK = str;
            uinForTVK = str2;
            needInitTVK = true;
            if (!sIsTVideoInit.get()) {
                LogUtil.w(TAG, "initSDKForTVK, need wait super init");
                return;
            }
            TVKSDKMgr.setDebugEnable(true);
            TVKSDKMgr.setOnLogListener(new ITVKLogListener() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.7
                @Override // com.tencent.qqlive.tvkplayer.api.ITVKLogListener
                public int d(String str3, String str4) {
                    if (SuperPlayerSDKMgr.sLogListener != null) {
                        return SuperPlayerSDKMgr.sLogListener.d(str3, str4);
                    }
                    return 0;
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKLogListener
                public int e(String str3, String str4) {
                    if (SuperPlayerSDKMgr.sLogListener != null) {
                        return SuperPlayerSDKMgr.sLogListener.e(str3, str4);
                    }
                    return 0;
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKLogListener
                public int i(String str3, String str4) {
                    if (SuperPlayerSDKMgr.sLogListener != null) {
                        return SuperPlayerSDKMgr.sLogListener.i(str3, str4);
                    }
                    return 0;
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKLogListener
                public int v(String str3, String str4) {
                    if (SuperPlayerSDKMgr.sLogListener != null) {
                        return SuperPlayerSDKMgr.sLogListener.v(str3, str4);
                    }
                    return 0;
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKLogListener
                public int w(String str3, String str4) {
                    if (SuperPlayerSDKMgr.sLogListener != null) {
                        return SuperPlayerSDKMgr.sLogListener.w(str3, str4);
                    }
                    return 0;
                }
            });
            TVKSDKMgr.initSdk(context, str, str2);
            TPDataTransportMgr.setGlobalOptionalConfigParam("proxy_config", sSdkOption.getDownloadProxyConfig());
            SuperPlayerSdkOption superPlayerSdkOption = sSdkOption;
            if (superPlayerSdkOption != null) {
                TVKSDKMgr.setTVKHTTPClientOption(superPlayerSdkOption.tvideoThreadSize, superPlayerSdkOption.tvideoUseResidentThread, superPlayerSdkOption.tvideoThreadAliveTimeSecond);
            }
            sIsTVKInit.set(true);
        }
    }

    private static synchronized void initSuper(Context context, int i3, String str, SuperPlayerSdkOption superPlayerSdkOption) {
        String str2;
        synchronized (SuperPlayerSDKMgr.class) {
            if (sIsSuperInit.get()) {
                return;
            }
            sAppContext = context.getApplicationContext();
            sPlatform = i3;
            sDataCacheFolder = str;
            if (superPlayerSdkOption == null) {
                superPlayerSdkOption = SuperPlayerSdkOption.option();
            }
            sSdkOption = superPlayerSdkOption;
            ThreadUtil.setCustomThread(superPlayerSdkOption.subThread, superPlayerSdkOption.threadPool);
            BeaconAdapter.setQIMEI(sSdkOption.beaconQimei36);
            initDeviceInfo(sSdkOption.deviceModel);
            SuperPlayerSdkOption superPlayerSdkOption2 = sSdkOption;
            sUid = superPlayerSdkOption2.uid;
            if (superPlayerSdkOption2.deviceId.isEmpty()) {
                str2 = BeaconAdapter.getQIMEI();
            } else {
                str2 = sSdkOption.deviceId;
            }
            sDeviceId = str2;
            a.f373903d = sSdkOption.bandwidthReportSceneId;
            a.f373902c = sSdkOption.bandwidthReportIntervalMs;
            SPReportHelper.dropFrameReportSceneId = sSdkOption.dropFrameReportSceneId;
            SuperPlayerSdkOption superPlayerSdkOption3 = sSdkOption;
            sAllowP2PUploadDefault = superPlayerSdkOption3.allowP2PUploadDefault;
            sTPCoreSampleRate = superPlayerSdkOption3.tpCoreSampleRate;
            superPlayerSdkOption3.loadConfigFromConfigManager();
            SPBeaconReporter.init(sSdkOption);
            initGlobalDownloadProxyInfo();
            sIsSuperInit.set(true);
        }
    }

    private static void initTMediaCodecComponent() {
        TCodecManager.getInstance().setGlobalReuseEnable(true);
        TCodecManager.getInstance().setLogLevel(2);
        TCodecManager.getInstance().setLogProxy(new ILogProxy() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.1
            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void d(String str, String str2) {
                if (SuperPlayerSDKMgr.sLogListener != null) {
                    SuperPlayerSDKMgr.sLogListener.d(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void e(String str, String str2, Throwable th5) {
                if (SuperPlayerSDKMgr.sLogListener != null) {
                    SuperPlayerSDKMgr.sLogListener.e(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void i(String str, String str2) {
                if (SuperPlayerSDKMgr.sLogListener != null) {
                    SuperPlayerSDKMgr.sLogListener.i(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void v(String str, String str2) {
                if (SuperPlayerSDKMgr.sLogListener != null) {
                    SuperPlayerSDKMgr.sLogListener.v(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void w(String str, String str2, Throwable th5) {
                if (SuperPlayerSDKMgr.sLogListener != null) {
                    SuperPlayerSDKMgr.sLogListener.w(str, str2);
                }
            }
        });
    }

    private static synchronized void initTPDownload() {
        synchronized (SuperPlayerSDKMgr.class) {
            if (sIsTPDownloadInit.get()) {
                return;
            }
            TPMgr.setLogListener(sTPLogListener);
            Context context = sAppContext;
            InnerLibLoader innerLibLoader = sInnerLibLoader;
            TPMgr.initThumbPlayer(context, innerLibLoader);
            TPDLProxyLog.setLogListener(0, sInnerLogListener);
            TPDownloadProxyHelper.setNativeLibLoader(innerLibLoader);
            TPDownloadProxyNative.getInstance().loadLibrary();
            sIsTPDownloadInit.set(true);
        }
    }

    private static synchronized void initTPPlayer() {
        synchronized (SuperPlayerSDKMgr.class) {
            if (sIsTPPlayerInit.get()) {
                return;
            }
            innerInitTPPlayerMgr();
            initTMediaCodecComponent();
            sIsTPPlayerInit.set(true);
        }
    }

    public static void initTPPlayerBackUp(Context context) {
        if (context != null) {
            context.getApplicationContext();
            initTpConfig();
            TPMgr.setLogListener(sTPLogListener);
            TPMgr.initThumbPlayer(context.getApplicationContext(), sInnerLibLoader);
        }
    }

    private static synchronized void initTVideo() {
        synchronized (SuperPlayerSDKMgr.class) {
            if (sIsTVideoInit.get()) {
                return;
            }
            innerInitTVideoMgr();
            sIsTVideoInit.set(true);
        }
    }

    private static void initTpConfig() {
        if (sSdkOption.mediaCodecStuckCheckEnable) {
            TPMgr.addOptionalParam(TPOptionalParam.buildInt(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_INT_MEDIACODEC_STUCK_MAX_CNT, 2));
        }
        if (sSdkOption.demuxerReadPacketErrorCheckEof) {
            TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_DEMUXER_READ_PACKET_ERROR_CHECK_AVIO_EOF, true));
        }
    }

    private static void innerInitTPPlayerMgr() {
        initTpConfig();
        TPMgr.setLogListener(sTPLogListener);
        TPMgr.initThumbPlayer(sAppContext, sInnerLibLoader);
    }

    private static void innerInitTVideoMgr() {
        try {
            tt3.a.i(sAppContext, getPlatform(), BeaconAdapter.getQIMEI());
        } catch (Throwable th5) {
            LogUtil.e(TAG, "innerInitTVideoMgr error, " + th5.toString());
        }
        tt3.a.l(sInnerLogListener);
        SuperPlayerSdkOption superPlayerSdkOption = sSdkOption;
        tt3.a.m(superPlayerSdkOption.tvideoThreadSize, superPlayerSdkOption.tvideoUseResidentThread, superPlayerSdkOption.tvideoThreadAliveTimeSecond);
    }

    public static boolean isP2PActive() {
        if (sCurrentP2PScene.isEmpty() && !sAllowP2PUploadDefault) {
            return false;
        }
        return true;
    }

    public static boolean isShowPlayerDebugView() {
        return sShowPlayerDebugView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitSceneId(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            return Arrays.asList(str2.split(SCEENID_SPLIT)).contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void notifyAppBackground() {
        LogUtil.d(TAG, "notifyAppBackground");
        if (!sIsSuperInit.get()) {
            return;
        }
        SPBandwidthPredictor.sIsAppForeground = false;
        TVKSDKMgr.isAppForground = false;
        ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.3
            @Override // java.lang.Runnable
            public void run() {
                TPDownloadProxyFactory.pushEvent(13);
            }
        });
        ThreadUtil.getSubThreadHandler().postDelayed(sQuickDeinitPlayerTask, sSdkOption.quickDeinitTime * 1000);
        ThreadUtil.getSubThreadHandler().postDelayed(sDeinitDownloadProxyTask, sSdkOption.backgroundAliveTime * 1000);
        if (checkAnyPlayerPlaying()) {
            LogUtil.e(TAG, "notifyAppBackground, still have some player active! maybe cause memory leak or high cpu usage");
            LogUtil.e(TAG, "notifyAppBackground, playing player=" + getAllPlayingPlayerInfo());
        }
    }

    public static void notifyAppForeground() {
        LogUtil.d(TAG, "notifyAppForeground");
        if (!sIsSuperInit.get()) {
            return;
        }
        SPBandwidthPredictor.sIsAppForeground = true;
        TVKSDKMgr.isAppForground = true;
        ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.4
            @Override // java.lang.Runnable
            public void run() {
                TPDownloadProxyFactory.pushEvent(14);
            }
        });
        ThreadUtil.getSubThreadHandler().removeCallbacks(sQuickDeinitPlayerTask);
        ThreadUtil.getSubThreadHandler().removeCallbacks(sDeinitDownloadProxyTask);
    }

    public static void notifyEnterP2PScene(int i3) {
        Integer valueOf = Integer.valueOf(i3);
        List<Integer> list = sCurrentP2PScene;
        if (!list.contains(valueOf)) {
            list.add(valueOf);
            ITPDownloadProxy tPDownloadPoxy = getTPDownloadPoxy(i3);
            if (tPDownloadPoxy != null) {
                tPDownloadPoxy.pushEvent(17);
            }
        }
    }

    public static void notifyExitP2PScene(int i3) {
        ITPDownloadProxy tPDownloadPoxy;
        Integer valueOf = Integer.valueOf(i3);
        List<Integer> list = sCurrentP2PScene;
        if (list.contains(valueOf)) {
            list.remove(valueOf);
        }
        if (list.isEmpty() && (tPDownloadPoxy = getTPDownloadPoxy(i3)) != null) {
            tPDownloadPoxy.pushEvent(18);
        }
    }

    public static boolean registerTVideoPlatformInfo(TVideoPlatformInfo tVideoPlatformInfo) {
        return tt3.a.j(TVideoPlatformInfo.convert(tVideoPlatformInfo));
    }

    public static void releaseOtherScened(final String str) {
        try {
            ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.api.SuperPlayerSDKMgr.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String str2 = SuperPlayerSDKMgr.sSdkOption.sceneReleaseWhiteString;
                        Map<String, ISuperPlayer> allPlayer = SuperPlayerSDKMgr.sPlayerRunningPool.getAllPlayer();
                        if (allPlayer != null && allPlayer.size() != 0) {
                            for (Map.Entry entry : new HashMap(allPlayer).entrySet()) {
                                ISuperPlayer iSuperPlayer = (ISuperPlayer) entry.getValue();
                                String valueOf = String.valueOf(iSuperPlayer.getSceneId());
                                SPDeinitManager.DeinitPlayerInfo deinitPlayerInfo = SPDeinitManager.getDeinitPlayerInfo((ISuperPlayer) entry.getValue());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(deinitPlayerInfo.serviceType);
                                sb5.append("-");
                                sb5.append(deinitPlayerInfo.playerTag);
                                if (SuperPlayerSDKMgr.isWhitSceneId(valueOf, str2)) {
                                    LogUtil.i(SuperPlayerSDKMgr.TAG, "is white sceneId player:" + sb5.toString());
                                } else if (TextUtils.equals(valueOf, str)) {
                                    LogUtil.i(SuperPlayerSDKMgr.TAG, "is current sceneId player:" + sb5.toString());
                                } else {
                                    iSuperPlayer.release();
                                    LogUtil.i(SuperPlayerSDKMgr.TAG, "release player by sceneId:" + valueOf + "|" + sb5.toString());
                                }
                            }
                        }
                    } catch (Exception e16) {
                        LogUtil.e(SuperPlayerSDKMgr.TAG, e16);
                    }
                }
            });
        } catch (Exception e16) {
            LogUtil.e(LogUtil.TAG, e16);
        }
    }

    public static void setDataReportEnable(boolean z16) {
        TPMgr.addOptionalParam(TPOptionalParam.buildBoolean(TPMgrConfig.TP_MGR_CONFIG_KEY_GLOBAL_BOOL_ENABLE_PLAYING_QUALITY_REPORT, z16));
    }

    public static void setDeviceId(String str) {
        sDeviceId = str;
        TPDataTransportMgr.setGlobalOptionalConfigParam("guid", str);
    }

    public static void setGlobalReportMap(Map<String, String> map) {
        sGlobalReportMap = map;
    }

    public static void setHttpProxyInfo(String str, String str2) {
        TPDataTransportMgr.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_HTTP_PROXY_HOST, str);
        TPDataTransportMgr.setGlobalOptionalConfigParam(TPDataTransportEnum.GLOBAL_OPTIONAL_CONFIG_PARAM_INT_HTTP_PROXY_PORT, str2);
    }

    public static void setLibLoader(ISuperModuleLoader iSuperModuleLoader) {
        sSuperLidLoader = iSuperModuleLoader;
        tt3.a.k(sInnerLibLoader);
        hadSetLibLoader = true;
    }

    public static void setOnLogListener(ILogListener iLogListener) {
        sLogListener = iLogListener;
    }

    public static void setProxyMaxUseMemoryMB(int i3) {
        TPDataTransportMgr.setGlobalOptionalConfigParam("max_use_memory", String.valueOf(i3));
    }

    public static void setShowPlayerDebugView(boolean z16) {
        sShowPlayerDebugView = z16;
    }

    @Deprecated
    public static void setThreadPoolExecutor(Executor executor) {
        ThreadUtil.setCustomThread(null, executor);
    }

    public static void setUpcInfo(String str, int i3) {
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_code", str);
        TPDataTransportMgr.setGlobalOptionalConfigParam("carrier_pesudo_state", String.valueOf(i3));
        TVKSDKMgr.setUpc(str);
        TVKSDKMgr.setUpcState(i3);
    }

    public static void setUpdatePlayerInfoInterval(int i3) {
        TPDataTransportTaskListenerMgr.getInstance().setUpdatePlayerInfoInterval(i3);
    }

    public static void setsUid(String str) {
        sUid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class InnerLogListener implements a.c, ITPDLProxyLogListener {
        InnerLogListener() {
        }

        @Override // tt3.a.c
        public int d(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.d(str, str2);
            }
            return 0;
        }

        @Override // tt3.a.c
        public int e(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.e(str, str2);
            }
            return 0;
        }

        @Override // tt3.a.c
        public int i(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.i(str, str2);
            }
            return 0;
        }

        @Override // tt3.a.c
        public int v(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.v(str, str2);
            }
            return 0;
        }

        @Override // tt3.a.c
        public int w(String str, String str2) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.w(str, str2);
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int d(String str, int i3, String str2, String str3) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.d(str2, str3);
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int e(String str, int i3, String str2, String str3) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.e(str2, str3);
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int i(String str, int i3, String str2, String str3) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.i(str2, str3);
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int w(String str, int i3, String str2, String str3) {
            if (SuperPlayerSDKMgr.sLogListener != null) {
                return SuperPlayerSDKMgr.sLogListener.w(str2, str3);
            }
            return 0;
        }
    }

    public static void initSDK(Context context, int i3, String str, SuperPlayerSdkOption superPlayerSdkOption) {
        initSuper(context, i3, str, superPlayerSdkOption);
        initTVideo();
        initTPPlayer();
        initTPDownload();
        if (needInitTVK) {
            initSDKForTVK(getContext(), appKeyForTVK, uinForTVK);
        }
        initLib();
    }
}
