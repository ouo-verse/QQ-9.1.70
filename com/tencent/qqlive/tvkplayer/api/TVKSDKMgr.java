package com.tencent.qqlive.tvkplayer.api;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.bridge.ITVKProxyFactory;
import com.tencent.qqlive.tvkplayer.bridge.ITVKSDKMgrFactory;
import com.tencent.qqlive.tvkplayer.bridge.TVKMediaPlayerFactory;
import com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrFactory;
import com.tencent.qqlive.tvkplayer.dex.dexloader.TVKDexloader;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKSDKUpdate;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateInfo;
import com.tencent.qqlive.tvkplayer.dex.sdkupdate.TVKUpdateUtils;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKSDKMgr {
    public static final int ERROR_FACTORY_NULL = 106;
    public static final int ERROR_INVALID_FILE = 104;
    public static final int ERROR_IO = 105;
    public static final int ERROR_NETWORK = 102;
    public static final int ERROR_OTHERS = 101;
    public static final int ERROR_SERVER_RESPONSE = 103;
    public static final int PLAYER_TYPE_SELFDEV_FULL = 3;
    public static final int PLAYER_TYPE_SELFDEV_LITE = 4;
    public static final int PLAYER_TYPE_SELFDEV_MIN = 2;
    public static final int PLAYER_TYPE_UNKNOWN = 1;
    public static final String PROPERTY_BEFORE_INIT_DEVICE_NAME = "PROPERTY_DEVICE_NAME";
    public static final String PROPERTY_BEFORE_INIT_ENABLE_PREVIEW_MODE = "PROPERTY_PREVIEW_MODE";
    public static final String PROPERTY_BEFORE_INIT_QIMEI36 = "PROPERTY_QIMEI36";
    public static final String PROPERTY_GLOBAL_ENABLE_MULTI_NETWORK_DOWNLOAD = "PROPERTY_MULTI_NETWORK_DOWNLOAD";
    public static final String PROPERTY_GLOBAL_ENABLE_SURFACE_VIEW_DESTROYED_ASYNC = "PROPERTY_SURFACE_VIEW_DESTROYED_ASYNC";
    public static final String PROPERTY_GLOBAL_ENABLE_TEXTURE_VIEW_DESTROYED_ASYNC = "PROPERTY_TEXTURE_VIEW_DESTROYED_ASYNC";
    private static final String SDK_VERSION = "V10.20.000.1248";
    private static final String TAG = "TVKPlayer[TVKSDKMgr]";
    public static boolean isAppForground = true;
    private static String sAbUserId = "";
    private static Context sAppContext = null;
    private static String sAppKey = "";
    private static ITVKBeaconDataReporter sBeaconDataReporter = null;
    private static ITVKCustomizedCapability sCustomizedCapability = null;
    private static ClassLoader sDexClassloader = null;
    private static String sGuid = "";
    private static String sHostConfig = null;
    private static ITVKHttpDnsResolver sHttpDnsResolver = null;
    private static boolean sIsDebug = false;
    private static boolean sIsDexClassLoaded = false;
    private static boolean sIsPlayerCoreInit = false;
    private static boolean sIsPluginMode = false;
    private static boolean sIsSDKInit = false;
    private static ITVKLogListener sOnLogListener = null;
    private static ITVKLogReportListener sOnLogReportListener = null;
    private static PluginInstallListener sPluginInstallListener = null;
    private static ITVKProxyFactory sProxyFactory = null;
    private static ITVKSDKMgrFactory sSDKMgrFactory = null;
    private static final Map<String, String> sSDKPropertyMap = new ConcurrentHashMap();
    private static final PluginInstallListener sSDKUpdateListener = new PluginInstallListener() { // from class: com.tencent.qqlive.tvkplayer.api.TVKSDKMgr.1
        @Override // com.tencent.qqlive.tvkplayer.api.TVKSDKMgr.PluginInstallListener
        public void onInstallFailure(int i3) {
            TVKUpdateUtils.e(TVKSDKMgr.TAG, "plugin install failed, error code: " + i3);
            if (TVKSDKMgr.sPluginInstallListener != null) {
                TVKSDKMgr.sPluginInstallListener.onInstallFailure(i3);
                PluginInstallListener unused = TVKSDKMgr.sPluginInstallListener = null;
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKSDKMgr.PluginInstallListener
        public void onInstallProgress(float f16) {
            if (TVKSDKMgr.sPluginInstallListener != null) {
                TVKSDKMgr.sPluginInstallListener.onInstallProgress(f16);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKSDKMgr.PluginInstallListener
        public void onInstallSuccess() {
            if (TVKSDKMgr.loadDexFile(TVKSDKMgr.sAppContext)) {
                TVKSDKMgr.initPlayerCore();
                if (TVKSDKMgr.getProxyFactory() == null) {
                    TVKUpdateUtils.e(TVKSDKMgr.TAG, "loadDexFile success, but factory is null");
                    if (TVKSDKMgr.sPluginInstallListener != null) {
                        TVKSDKMgr.sPluginInstallListener.onInstallFailure(106);
                        PluginInstallListener unused = TVKSDKMgr.sPluginInstallListener = null;
                        return;
                    }
                    return;
                }
                TVKUpdateUtils.i(TVKSDKMgr.TAG, "plugin install success");
                if (TVKSDKMgr.sPluginInstallListener != null) {
                    TVKSDKMgr.sPluginInstallListener.onInstallSuccess();
                    PluginInstallListener unused2 = TVKSDKMgr.sPluginInstallListener = null;
                    return;
                }
                return;
            }
            TVKUpdateUtils.e(TVKSDKMgr.TAG, "loadDexFile failed");
            if (TVKSDKMgr.sPluginInstallListener != null) {
                TVKSDKMgr.sPluginInstallListener.onInstallFailure(101);
                PluginInstallListener unused3 = TVKSDKMgr.sPluginInstallListener = null;
            }
        }
    };
    private static String sSdkAppConfig = "";
    private static String sUin = "";
    private static String sUpc = "";
    private static int sUpcState;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface PlayerCoreType {
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface PluginInstallListener {
        void onInstallFailure(int i3);

        void onInstallProgress(float f16);

        void onInstallSuccess();
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface SdkUpdateErrorCode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TVKSDKProperty {
    }

    private static boolean checkPlayerCoreVersion() {
        String[] split = sSDKMgrFactory.getSdkMgrInstance().getSdkVersion().split("\\.");
        String[] split2 = "V10.20.000.1248".split("\\.");
        if (split2.length > 1 && split.length > 1 && split2[0].equalsIgnoreCase(split[0]) && split2[1].equalsIgnoreCase(split[1])) {
            return true;
        }
        sIsDexClassLoaded = false;
        sDexClassloader = null;
        return false;
    }

    public static boolean checkSdkPluginMode() {
        try {
            int i3 = TVKMediaPlayerFactory.f345785a;
            boolean z16 = false;
            Method method = TVKMediaPlayerFactory.class.getMethod("getProxyFactoryInstance", new Class[0]);
            method.setAccessible(true);
            if (((ITVKProxyFactory) method.invoke(null, new Object[0])) == null) {
                z16 = true;
            }
            sIsPluginMode = z16;
        } catch (Throwable unused) {
            sIsPluginMode = true;
        }
        return sIsPluginMode;
    }

    private static boolean checkVersion() {
        if (sIsPluginMode && !checkPlayerCoreVersion()) {
            sSDKMgrFactory = null;
            if (sIsPluginMode && TVKSDKUpdate.getInstance(sAppContext) != null) {
                TVKSDKUpdate.getInstance(sAppContext).update();
                return false;
            }
            return false;
        }
        return true;
    }

    private static void createProxyFactory() {
        if (sIsPluginMode) {
            try {
                Method method = sDexClassloader.loadClass("com.tencent.qqlive.tvkplayer.bridge.TVKMediaPlayerFactory").getMethod("getProxyFactoryInstance", new Class[0]);
                method.setAccessible(true);
                ITVKProxyFactory iTVKProxyFactory = (ITVKProxyFactory) method.invoke(null, new Object[0]);
                sProxyFactory = iTVKProxyFactory;
                if (iTVKProxyFactory == null) {
                    TVKUpdateUtils.e(TAG, "createProxyFactory, invoke get failed! ");
                    return;
                }
                return;
            } catch (Throwable unused) {
                TVKUpdateUtils.e(TAG, "createProxyFactory, exception failed! ");
                return;
            }
        }
        try {
            int i3 = TVKMediaPlayerFactory.f345785a;
            Method method2 = TVKMediaPlayerFactory.class.getMethod("getProxyFactoryInstance", new Class[0]);
            method2.setAccessible(true);
            sProxyFactory = (ITVKProxyFactory) method2.invoke(null, new Object[0]);
        } catch (Throwable th5) {
            TVKUpdateUtils.e(TAG, "reflect sdkMgrFactory failed: " + th5.toString());
        }
    }

    private static void createSDKMgrFactory() {
        if (sIsPluginMode) {
            try {
                Method method = sDexClassloader.loadClass("com.tencent.qqlive.tvkplayer.bridge.TVKSDKMgrFactory").getMethod("getSDKMgrFactoryInstance", new Class[0]);
                method.setAccessible(true);
                ITVKSDKMgrFactory iTVKSDKMgrFactory = (ITVKSDKMgrFactory) method.invoke(null, new Object[0]);
                sSDKMgrFactory = iTVKSDKMgrFactory;
                if (iTVKSDKMgrFactory == null) {
                    TVKUpdateUtils.e(TAG, "[createSDKMgrFactory] invoking failed! sIsPluginMode=" + sIsPluginMode);
                    return;
                }
                return;
            } catch (Throwable unused) {
                TVKUpdateUtils.e(TAG, "createSDKMgrFactory, exception failed! ");
                return;
            }
        }
        try {
            int i3 = TVKSDKMgrFactory.f345786a;
            Method method2 = TVKSDKMgrFactory.class.getMethod("getSDKMgrFactoryInstance", new Class[0]);
            method2.setAccessible(true);
            ITVKSDKMgrFactory iTVKSDKMgrFactory2 = (ITVKSDKMgrFactory) method2.invoke(null, new Object[0]);
            sSDKMgrFactory = iTVKSDKMgrFactory2;
            if (iTVKSDKMgrFactory2 == null) {
                TVKUpdateUtils.e(TAG, "[createSDKMgrFactory] invoking failed! sIsPluginMode=" + sIsPluginMode);
            }
        } catch (Throwable th5) {
            TVKUpdateUtils.e(TAG, "reflect sdkMgrFactory reflect failed: " + th5.toString());
        }
    }

    private static void dealSDKUpdate() {
        if (sIsPluginMode && TVKSDKUpdate.getInstance(sAppContext) != null) {
            String jar = TVKSDKUpdate.getInstance(sAppContext).getJar();
            if (!TextUtils.isEmpty(jar)) {
                TVKUpdateUtils.i(TAG, "Init AssetPath Success, assetPath: " + jar);
            } else {
                TVKUpdateUtils.i(TAG, "Init AssetPath Failed : assets file do not exist");
            }
            TVKSDKUpdate.getInstance(sAppContext).update();
        }
    }

    public static String getAdChid() {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().getAdChid();
        }
        return "";
    }

    public static int getCellularDataCost() {
        if (isSdkAvailable()) {
            return getSDKMgrFactory().getSdkMgrInstance().getCellularDataCost();
        }
        return -1;
    }

    public static String getChannelId() {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().getChannelId();
        }
        return TVKUpdateInfo.APP_ID;
    }

    public static long getCurrentServerTimeSec() {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().getCurrentServerTimeSec();
        }
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static String getHostConfig() {
        return sHostConfig;
    }

    public static String getPlatform() {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().getPlatform();
        }
        return "";
    }

    public static int getPlayerCoreType() {
        if (isSdkAvailable()) {
            return getSDKMgrFactory().getSdkMgrInstance().getPlayerCoreType();
        }
        return 1;
    }

    @Nullable
    public static ITVKProxyFactory getProxyFactory() {
        if (sIsSDKInit && sIsPlayerCoreInit) {
            if (sProxyFactory == null) {
                createProxyFactory();
            }
            return sProxyFactory;
        }
        return null;
    }

    @Nullable
    private static ITVKSDKMgrFactory getSDKMgrFactory() {
        if (sIsSDKInit && sIsPlayerCoreInit) {
            if (sSDKMgrFactory == null) {
                createSDKMgrFactory();
            }
            return sSDKMgrFactory;
        }
        return null;
    }

    public static String getSdkVersion() {
        if (isSdkAvailable()) {
            return getSDKMgrFactory().getSdkMgrInstance().getSdkVersion();
        }
        return "V10.20.000.1248";
    }

    public static String getSdtfrom() {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().getSdtfrom();
        }
        return "";
    }

    public static Object getValueByPlayerConfigKey(String str) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            TVKUpdateUtils.e(TAG, "getValueByPlayerConfigKey, key is null");
            return null;
        }
        try {
            if (sIsPluginMode) {
                cls = sDexClassloader.loadClass("com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig$PlayerConfig");
            } else {
                cls = TVKMediaPlayerConfig.PlayerConfig.class;
                String str2 = TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_AUTO;
            }
            Field field = cls.getField(str);
            field.setAccessible(true);
            return field.get(null);
        } catch (Throwable th5) {
            TVKUpdateUtils.e(TAG, "getValueByPlayerConfigKey, reflect failed: " + th5.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initPlayerCore() {
        if (sIsPlayerCoreInit) {
            TVKUpdateUtils.i(TAG, "initPlayerCore has already been initialized");
            return;
        }
        createProxyFactory();
        createSDKMgrFactory();
        ITVKSDKMgrFactory iTVKSDKMgrFactory = sSDKMgrFactory;
        if (iTVKSDKMgrFactory != null && iTVKSDKMgrFactory.getSdkMgrInstance() != null) {
            if (!checkVersion()) {
                sIsSDKInit = false;
                TVKUpdateUtils.e(TAG, "initPlayerCore failed, check sdk version failed");
                return;
            }
            setConfig();
            if (!sSDKMgrFactory.getSdkMgrInstance().initSdk(sAppContext, sAppKey, sUin)) {
                sIsSDKInit = false;
                TVKUpdateUtils.e(TAG, "initPlayerCore failed, TVKSDKMgrWrapper initSDK failed");
                return;
            } else {
                dealSDKUpdate();
                sIsPlayerCoreInit = true;
                sIsSDKInit = true;
                TVKUpdateUtils.i(TAG, "initSdk success");
                return;
            }
        }
        TVKUpdateUtils.e(TAG, "initPlayerCore failed, can't getSdkMgrInstance");
        sSDKMgrFactory = null;
        if (sIsPluginMode && TVKSDKUpdate.getInstance(sAppContext) != null) {
            TVKSDKUpdate.getInstance(sAppContext).update();
        }
        sIsSDKInit = false;
    }

    public static void initSdk(Context context, String str, String str2) {
        if (sIsSDKInit) {
            TVKUpdateUtils.i(TAG, "InitSDK... already been initialized, no need to init again. ver: V10.20.000.1248");
            return;
        }
        TVKUpdateUtils.i(TAG, "initSdk start... ver: V10.20.000.1248");
        checkSdkPluginMode();
        Context applicationContext = context.getApplicationContext();
        sAppContext = applicationContext;
        sAppKey = str;
        sUin = str2;
        if (!sIsPluginMode) {
            initPlayerCore();
            return;
        }
        if (TVKSDKUpdate.getInstance(applicationContext).check() && loadDexFile(sAppContext)) {
            initPlayerCore();
        } else {
            TVKSDKUpdate.getInstance(sAppContext).setOnSDKUpdateListener(sSDKUpdateListener);
            TVKSDKUpdate.getInstance(sAppContext).startWithForceAndSilent(true);
        }
        sIsSDKInit = true;
    }

    public static void initSdkConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sSdkAppConfig = str;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setSdkConfig(str);
        }
    }

    public static void initSdkWithGuid(Context context, String str, String str2, String str3) {
        if (sIsSDKInit) {
            TVKUpdateUtils.i(TAG, "InitSDK... already been initialized, no need to init again. ver: V10.20.000.1248");
        } else {
            sGuid = str3;
            initSdk(context, str, str2);
        }
    }

    public static void installPlugin(Context context, @NonNull PluginInstallListener pluginInstallListener) throws IllegalArgumentException {
        sAppContext = context.getApplicationContext();
        sPluginInstallListener = pluginInstallListener;
        if (pluginInstallListener != null) {
            if (getProxyFactory() != null) {
                sPluginInstallListener.onInstallSuccess();
                sPluginInstallListener = null;
                return;
            }
            if (!sIsPluginMode) {
                if (getProxyFactory() == null) {
                    sPluginInstallListener.onInstallFailure(106);
                } else {
                    sPluginInstallListener.onInstallSuccess();
                }
                sPluginInstallListener = null;
                return;
            }
            if (TVKSDKUpdate.getInstance(sAppContext).check() && loadDexFile(sAppContext)) {
                initPlayerCore();
                sPluginInstallListener.onInstallProgress(1.0f);
                if (getProxyFactory() == null) {
                    sPluginInstallListener.onInstallFailure(106);
                } else {
                    sPluginInstallListener.onInstallSuccess();
                }
                sPluginInstallListener = null;
                return;
            }
            TVKSDKUpdate.getInstance(sAppContext).setOnSDKUpdateListener(sSDKUpdateListener);
            TVKSDKUpdate.getInstance(sAppContext).start();
            return;
        }
        throw new IllegalArgumentException("Install listener can not be null");
    }

    public static boolean isPluginInstalled() {
        if (!sIsSDKInit || !sIsPlayerCoreInit || getProxyFactory() == null) {
            return false;
        }
        return true;
    }

    private static boolean isSdkAvailable() {
        ITVKSDKMgrFactory iTVKSDKMgrFactory;
        if ((!sIsPluginMode || sIsDexClassLoaded) && (iTVKSDKMgrFactory = sSDKMgrFactory) != null && iTVKSDKMgrFactory.getSdkMgrInstance() != null) {
            return true;
        }
        return false;
    }

    public static boolean isSdkInit() {
        return sIsSDKInit;
    }

    public static boolean isSelfPlayerAvailable(Context context) {
        if (isSdkAvailable()) {
            return sSDKMgrFactory.getSdkMgrInstance().isSelfPlayerAvailable(context);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean loadDexFile(Context context) {
        boolean z16;
        synchronized (TVKSDKMgr.class) {
            if (!sIsDexClassLoaded) {
                ClassLoader classLoader = TVKDexloader.getClassLoader(context, TVKSDKUpdate.getInstance(sAppContext).getJar(), TVKSDKUpdate.getInstance(sAppContext).getLibs());
                sDexClassloader = classLoader;
                if (classLoader != null) {
                    sIsDexClassLoaded = true;
                    TVKUpdateUtils.i(TAG, "Get dexClassloader success");
                } else {
                    TVKUpdateUtils.e(TAG, "loadDexFile failed");
                }
            }
            z16 = sIsDexClassLoaded;
        }
        return z16;
    }

    public static void setAbUserId(String str) {
        TVKUpdateUtils.i(TAG, "setAbUserId: " + str);
        sAbUserId = str;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setAbUserId(str);
        }
    }

    public static void setBeaconDataReporterBeforeInit(ITVKBeaconDataReporter iTVKBeaconDataReporter) {
        if (sIsSDKInit) {
            TVKUpdateUtils.w(TAG, "setBeaconDataReporter failed, only work before initSdk");
            return;
        }
        sBeaconDataReporter = iTVKBeaconDataReporter;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setBeaconDataReporterBeforeInit(iTVKBeaconDataReporter);
        }
    }

    private static void setConfig() {
        sSDKMgrFactory.getSdkMgrInstance().setGuid(sGuid);
        sSDKMgrFactory.getSdkMgrInstance().setAbUserId(sAbUserId);
        sSDKMgrFactory.getSdkMgrInstance().setUpc(sUpc);
        sSDKMgrFactory.getSdkMgrInstance().setUpcState(sUpcState);
        sSDKMgrFactory.getSdkMgrInstance().setDebugEnable(sIsDebug);
        sSDKMgrFactory.getSdkMgrInstance().setHostConfigBeforeInitSDK(sHostConfig);
        sSDKMgrFactory.getSdkMgrInstance().setOnLogListener(sOnLogListener);
        sSDKMgrFactory.getSdkMgrInstance().setOnLogReportListener(sOnLogReportListener);
        sSDKMgrFactory.getSdkMgrInstance().setHttpDnsResolver(sHttpDnsResolver);
        sSDKMgrFactory.getSdkMgrInstance().setCustomizedCapability(sCustomizedCapability);
        sSDKMgrFactory.getSdkMgrInstance().setBeaconDataReporterBeforeInit(sBeaconDataReporter);
        sSDKMgrFactory.getSdkMgrInstance().setSdkConfig(sSdkAppConfig);
        for (Map.Entry<String, String> entry : sSDKPropertyMap.entrySet()) {
            sSDKMgrFactory.getSdkMgrInstance().setSDKProperty(entry.getKey(), entry.getValue());
        }
    }

    public static void setCustomizedCapability(ITVKCustomizedCapability iTVKCustomizedCapability) {
        TVKUpdateUtils.i(TAG, "setCustomizedCapability: " + iTVKCustomizedCapability);
        sCustomizedCapability = iTVKCustomizedCapability;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setCustomizedCapability(iTVKCustomizedCapability);
        }
    }

    public static void setDebugEnable(boolean z16) {
        TVKUpdateUtils.i(TAG, "setDebugEnable : " + z16);
        sIsDebug = z16;
        TVKUpdateUtils.setDebugMode(z16);
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setDebugEnable(z16);
        }
    }

    public static void setHostConfigBeforeInitSDK(String str) {
        sHostConfig = str;
    }

    public static void setHttpDnsResolver(ITVKHttpDnsResolver iTVKHttpDnsResolver) {
        sHttpDnsResolver = iTVKHttpDnsResolver;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setHttpDnsResolver(iTVKHttpDnsResolver);
        }
    }

    public static void setOnLogListener(ITVKLogListener iTVKLogListener) {
        sOnLogListener = iTVKLogListener;
        TVKUpdateUtils.setOnLogListener(iTVKLogListener);
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setOnLogListener(iTVKLogListener);
        }
    }

    public static void setOnLogReportListener(ITVKLogReportListener iTVKLogReportListener) {
        sOnLogReportListener = iTVKLogReportListener;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setOnLogReportListener(iTVKLogReportListener);
        }
    }

    public static void setQQ(String str) {
        TVKUpdateUtils.i(TAG, "setQQ: " + str);
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setQQ(str);
        }
    }

    public static void setSDKProperty(@NonNull String str, @NonNull String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            TVKUpdateUtils.i(TAG, "setSDKProperty: propertyName=" + str + " propertyValue=" + str2);
            sSDKPropertyMap.put(str, str2);
            if (isSdkAvailable()) {
                sSDKMgrFactory.getSdkMgrInstance().setSDKProperty(str, str2);
                return;
            }
            return;
        }
        TVKUpdateUtils.w(TAG, "setSDKProperty: propertyName=" + str + ", propertyValue=" + str2 + ", parameter invalid ignore!");
    }

    public static void setTVKHTTPClientOption(int i3, boolean z16, int i16) {
        if (getSDKMgrFactory() != null && getSDKMgrFactory().getSdkMgrInstance() != null) {
            getSDKMgrFactory().getSdkMgrInstance().setHttpClientOption(i3, z16, i16);
        }
    }

    public static void setUpc(String str) {
        TVKUpdateUtils.i(TAG, "setUpc: " + str);
        sUpc = str;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setUpc(str);
        }
    }

    public static void setUpcState(int i3) {
        TVKUpdateUtils.i(TAG, "setUpcState: " + i3);
        sUpcState = i3;
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setUpcState(i3);
        }
    }

    public static void setUrlEnvironment(int i3) {
        TVKUpdateUtils.i(TAG, "setUrlEnvironment: " + i3);
        if (isSdkAvailable()) {
            sSDKMgrFactory.getSdkMgrInstance().setUrlEnvironment(i3);
        }
    }

    public static void setValueByPlayerConfigKey(String str, Object obj) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            TVKUpdateUtils.e(TAG, "setValueByPlayerConfigKey, key is null");
            return;
        }
        try {
            if (sIsPluginMode) {
                cls = sDexClassloader.loadClass("com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig$PlayerConfig");
            } else {
                cls = TVKMediaPlayerConfig.PlayerConfig.class;
                String str2 = TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_AUTO;
            }
            Field field = cls.getField(str);
            field.setAccessible(true);
            field.set(null, obj);
        } catch (Throwable th5) {
            TVKUpdateUtils.e(TAG, "setValueByPlayerConfigKey, reflect failed: " + th5.toString());
        }
    }
}
