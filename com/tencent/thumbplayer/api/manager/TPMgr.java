package com.tencent.thumbplayer.api.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.common.ITPLogListener;
import com.tencent.thumbplayer.api.common.ITPModuleLoader;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.report.ITPBeaconDataReporter;
import com.tencent.thumbplayer.capability.TPDrmCapabilityImpl;
import com.tencent.thumbplayer.common.TPElapsedTimePointer;
import com.tencent.thumbplayer.common.TPHost;
import com.tencent.thumbplayer.common.TPVersion;
import com.tencent.thumbplayer.common.config.TPConfig;
import com.tencent.thumbplayer.common.log.TPDataTransportLogImpl;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.common.log.TPPlayerCoreLogImpl;
import com.tencent.thumbplayer.common.thread.TPThreadPool;
import com.tencent.thumbplayer.core.codec.capability.TPMediaCodecDecoderCapability;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportNativeLibLoader;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.core.utils.TPApplicationContext;
import com.tencent.thumbplayer.core.utils.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.utils.TPAudioSpatializerDetector;
import com.tencent.thumbplayer.core.utils.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.report.TPBeaconReportWrapper;

/* loaded from: classes26.dex */
public class TPMgr {
    private static final String KEY_BUGLY_SDK_INFO = "BuglySdkInfos";
    private static final String TAG = "TPMgr";
    private static final String TP_BUGLY_APPID = "ce2851f253";
    public static final String TP_MODULE_NAME_DOWNLOAD_PROXY = "DownloadProxy";
    public static final String TP_MODULE_NAME_PLAYERCORE = "TPCore";
    private static boolean sIsInitialized = false;
    private static int sMinLogLevel = 2;

    public static synchronized void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) {
        synchronized (TPMgr.class) {
            TPConfig.addConfig(tPOptionalParam);
        }
    }

    public static String getLibVersion(String str) throws IllegalStateException, IllegalArgumentException {
        if (sIsInitialized) {
            if (!TextUtils.isEmpty(str)) {
                if ("TPCore".equals(str)) {
                    return TPVersion.getSelfDevPlayerVersion();
                }
                if ("DownloadProxy".equals(str)) {
                    return TPVersion.getDataTransportVersion();
                }
                throw new IllegalArgumentException("getLibVersion failed, libName:" + str + " is invalid, either TPCore or DownloadProxy");
            }
            throw new IllegalArgumentException("getLibVersion failed, libName is null");
        }
        throw new IllegalStateException("getLibVersion failed, only work after thumbPlayer init");
    }

    public static String getThumbPlayerVersion() {
        return TPVersion.getVersion();
    }

    private static void initBuglySdkInfo(@NonNull Context context) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        edit.putString(TP_BUGLY_APPID, getThumbPlayerVersion());
        edit.apply();
    }

    private static void initDataTransport(@NonNull Context context, final ITPModuleLoader iTPModuleLoader) {
        TPDataTransportMgr.setLogListener(new TPDataTransportLogImpl());
        if (iTPModuleLoader != null) {
            TPDataTransportMgr.setThirdNativeLibLoader(new ITPDataTransportNativeLibLoader() { // from class: xe4.a
                @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportNativeLibLoader
                public final boolean loadLib(String str) {
                    boolean lambda$initDataTransport$1;
                    lambda$initDataTransport$1 = TPMgr.lambda$initDataTransport$1(ITPModuleLoader.this, str);
                    return lambda$initDataTransport$1;
                }
            });
        }
        TPDataTransportMgr.setGlobalOptionalConfigParam("device_model", (String) TPConfig.getConfig(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_DEVICE_NAME).getValue());
        if (!TextUtils.isEmpty(TPHost.getDownloadProxyHost())) {
            TPDataTransportMgr.setGlobalOptionalConfigParam("proxy_config", TPHost.getDownloadProxyHost());
        }
        TPDataTransportMgr.init(context.getApplicationContext());
    }

    private static void initModulesAsync() {
        TPThreadPool.getInstance().obtainSharedThreadPoolExecutor().execute(new Runnable() { // from class: xe4.b
            @Override // java.lang.Runnable
            public final void run() {
                TPMgr.lambda$initModulesAsync$0();
            }
        });
    }

    public static synchronized void initThumbPlayer(@NonNull Context context) {
        synchronized (TPMgr.class) {
            initThumbPlayer(context, null);
        }
    }

    public static boolean isInitialized() {
        return sIsInitialized;
    }

    public static boolean isSelfDevPlayerAvailable() {
        return TPLibraryLoader.isAllLibrariesSuccessfullyLoaded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initDataTransport$1(ITPModuleLoader iTPModuleLoader, String str) {
        try {
            iTPModuleLoader.loadLibrary(str);
            return true;
        } catch (Exception e16) {
            TPLogUtil.e(TAG, "load data transport occur exception : " + e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initModulesAsync$0() {
        TPElapsedTimePointer tPElapsedTimePointer = new TPElapsedTimePointer();
        tPElapsedTimePointer.start();
        initBuglySdkInfo(TPApplicationContext.getContext());
        TPBeaconReportWrapper.init(TPApplicationContext.getContext());
        TPLogUtil.i(TAG, "Init SDK, initModuleAsync TPBeaconReportWrapper init, timeMs: " + tPElapsedTimePointer.costTimeMsFromLastPointAndPoint());
        TPDrmCapabilityImpl.preloadDrmCapability();
        TPMediaCodecDecoderCapability.preloadMediaCodecInfo();
        TPHeadsetPluginDetector.init(TPApplicationContext.getContext());
        TPAudioPassThroughPluginDetector.init(TPApplicationContext.getContext());
        TPAudioSpatializerDetector.init(TPApplicationContext.getContext());
        TPScreenRefreshRateDetector.init(TPApplicationContext.getContext());
        TPSystemInfo.initAudioBestSettings(TPApplicationContext.getContext());
        TPLogUtil.i(TAG, "Init SDK, initModuleAsync all timeMs: " + tPElapsedTimePointer.costTimeMsFromStartPoint());
    }

    public static void setBeaconDataReporterBeforeInit(ITPBeaconDataReporter iTPBeaconDataReporter) {
        if (sIsInitialized) {
            TPLogUtil.w(TAG, "setBeaconDataReporterBeforeInit failed, only work before thumbPlayer init");
        } else {
            TPBeaconReportWrapper.setBeaconDataReporter(iTPBeaconDataReporter);
        }
    }

    public static void setLogLevel(int i3) {
        sMinLogLevel = i3;
        TPLogUtil.setMinPrintLevel(i3);
    }

    public static void setLogListener(ITPLogListener iTPLogListener) {
        TPLogUtil.setLogListener(iTPLogListener);
    }

    public static synchronized void initThumbPlayer(@NonNull Context context, ITPModuleLoader iTPModuleLoader) {
        synchronized (TPMgr.class) {
            if (sIsInitialized) {
                return;
            }
            if (context == null) {
                TPLogUtil.e(TAG, "Init SDK failed, context is null");
                return;
            }
            TPApplicationContext.setContext(context.getApplicationContext());
            TPLibraryLoader.setModuleLoader(iTPModuleLoader);
            TPNativeLog.setLogCallback(new TPPlayerCoreLogImpl());
            TPSystemInfo.setDeviceName((String) TPConfig.getConfig(TPMgrConfig.TP_MGR_CONFIG_KEY_BEFORE_STRING_DEVICE_NAME).getValue());
            TPElapsedTimePointer tPElapsedTimePointer = new TPElapsedTimePointer();
            tPElapsedTimePointer.start();
            initDataTransport(context.getApplicationContext(), iTPModuleLoader);
            try {
                TPLibraryLoader.loadAllLibraries(context.getApplicationContext());
            } catch (UnsupportedOperationException e16) {
                TPLogUtil.e(TAG, e16);
            }
            TPLogUtil.i(TAG, "Init SDK, loadAllLibraries timeMs: " + tPElapsedTimePointer.costTimeMsFromStartPoint());
            TPConfig.initConfigs();
            initModulesAsync();
            TPLogUtil.setMinPrintLevel(sMinLogLevel);
            sIsInitialized = true;
        }
    }
}
