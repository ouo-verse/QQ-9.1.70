package com.tencent.ams.dsdk.core;

import android.text.TextUtils;
import com.tencent.ams.dsdk.fodder.BundleEventListener;
import com.tencent.ams.dsdk.fodder.SoConfigManager;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.ams.dsdk.monitor.metric.core.MetricReportConfig;
import com.tencent.ams.dsdk.utils.DKURLConnectionCreator;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKVideoPlayer;
import com.tencent.ams.dsdk.view.video.DKVideoPlayerCreator;
import com.tencent.ams.dsdk.view.video.glvideo.DKGLVideoPlayer;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKConfiguration {
    static IPatchRedirector $redirector_ = null;
    private static final String DEFAULT_BUNDLE_CONFIG_URL = "https://xsweb.gdt.qq.com/api/hippy/tenvideo-android-sdkconfig.json";
    private static final long DEFAULT_BUNDLE_EXPIRE_TIME = 604800000;
    private static final int DEFAULT_BUNDLE_LOAD_TIMEOUT = 3000;
    private static final long DEFAULT_BUNDLE_MAX_SIZE = 524288000;
    private static final String DEFAULT_DES_IV = "41012202";
    private static final String DEFAULT_DES_KEY = "@MOSAIC!";
    private static final int DEFAULT_ENGINE_INSTANCE_LIMIT = 3;
    public static final String DEFAULT_OS_ANDROID = "2";
    private static final long DEFAULT_PRELOAD_EXPIRE_TIME = 604800000;
    private static final long DEFAULT_PRELOAD_MAX_SIZE = 52428800;
    private static final int DEFAULT_RESOURCE_LOAD_TIMEOUT = 30000;
    private static final String DEFAULT_SO_CONFIG_SERVICE_URL = "https://xs.gdt.qq.com/style_factory/lib_list";
    private static final long DEFAULT_TEMPLATE_MAX_SIZE = 20971520;
    private static final String DEFAULT_TEMPLATE_SERVICE_CONFIG_URL = "https://xs.gdt.qq.com/style_factory";
    private static final String SERVICE_MODULE_LIST = "module_list";
    private static final String SERVICE_TEMPLATE = "template";
    private static final String SERVICE_TEMPLATE_LIST = "template_list";
    private static String sBundleConfigUrl;
    private static BundleEventListener sBundleEventListener;
    private static long sBundleExpireTime;
    private static int sBundleLoadTimeout;
    private static long sBundleMaxSize;
    private static boolean sCheckAllEncryptTypeModuleBundleMD5;
    private static DKURLConnectionCreator sConnectionCreator;
    private static String sDesIv;
    private static String sDesKey;
    private static boolean sEnableEnginePreWarm;
    private static boolean sEnableMetricReport;
    private static boolean sEnableOrganizeThreads;
    private static boolean sEnablePreloadResource;
    private static boolean sEnableResourcePreload;
    private static long sEngineInstanceLimit;
    private static Class<? extends DKGLVideoPlayer> sGLPlayerClass;
    private static Class<? extends DKWebView> sHippyWebViewClass;
    private static boolean sIgnoreImageLoaderLog;
    private static DLog.LogSupport sLogSupport;
    private static MetricReportConfig sMetricReportConfig;
    private static String sMosaicSoConfig;
    private static SoConfigManager.OnSoDownloadListener sOnSoDownloadListener;
    private static String sPlatform;
    private static Class<? extends DKVideoPlayer> sPlayerClass;
    private static DKVideoPlayerCreator sPlayerCreator;
    private static long sPreloadExpireTime;
    private static long sPreloadMaxSize;
    private static int sResourceLoadTimeout;
    private static String sSoConfigUrl;
    private static String sTemplateConfigUrl;
    private static long sTemplateMaxSize;
    private static TemplateManager.UpdateTemplateListenerV2 sUpdateTemplateListener;
    private static boolean sUseNewSoLoader;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Directory {
        public static final String BUSINESS = "business";
        public static final String RESOURCES = "resources";
        public static final String TEMPLATES = "templates";
        public static final String VENDOR = "vendor";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface PreloadKeys {
        public static final String KEY_MATERIAL_ID = "materialId";
        public static final String KEY_MD5 = "md5";
        public static final String KEY_PRELOAD = "preload";
        public static final String KEY_SIZE = "size";
        public static final String KEY_TYPE = "type";
        public static final String KEY_URL = "url";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface RequestKeys {
        public static final String KEY_AD_SDK_VERSION = "ad_sdk_version";
        public static final String KEY_APP = "app";
        public static final String KEY_APP_NAME = "app_name";
        public static final String KEY_EXT = "ext";
        public static final String KEY_GUID = "guid";
        public static final String KEY_OAID = "oaid";
        public static final String KEY_OS = "os";
        public static final String KEY_PACKAGE_NAME = "package_name";
        public static final String KEY_PLATFORM = "platform";
        public static final String KEY_QIMEI36 = "qimei36";
        public static final String KEY_SDK_VERSION = "sdk_version";
        public static final String KEY_TAID = "taid";
        public static final String KEY_TEMPLATE_ID = "template_id";
        public static final String KEY_VERSION = "version";
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14205);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sBundleConfigUrl = null;
        sBundleExpireTime = 0L;
        sPreloadExpireTime = 0L;
        sBundleMaxSize = 0L;
        sBundleLoadTimeout = 3000;
        sResourceLoadTimeout = 30000;
        sEnableEnginePreWarm = false;
        sEnableResourcePreload = true;
        sEngineInstanceLimit = 3L;
        sTemplateConfigUrl = null;
        sTemplateMaxSize = 0L;
        sPreloadMaxSize = 0L;
        sEnableMetricReport = false;
        sEnablePreloadResource = true;
        sUseNewSoLoader = false;
    }

    public DKConfiguration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getBundleConfigUrl() {
        if (!TextUtils.isEmpty(sBundleConfigUrl)) {
            return sBundleConfigUrl;
        }
        return "https://xs.gdt.qq.com/style_factory/module_list";
    }

    public static BundleEventListener getBundleEventListener() {
        return sBundleEventListener;
    }

    public static long getBundleExpireTime() {
        long j3 = sBundleExpireTime;
        if (j3 <= 0) {
            return 604800000L;
        }
        return j3;
    }

    public static int getBundleLoadTimeout() {
        int i3 = sBundleLoadTimeout;
        if (i3 <= 0) {
            return 3000;
        }
        return i3;
    }

    public static long getBundleMaxSize() {
        long j3 = sBundleMaxSize;
        if (j3 <= 0) {
            return 524288000L;
        }
        return j3;
    }

    public static DKURLConnectionCreator getConnectionCreator() {
        return sConnectionCreator;
    }

    public static Class<? extends DKWebView> getDKWebView() {
        return sHippyWebViewClass;
    }

    public static String getDesIv() {
        if (TextUtils.isEmpty(sDesIv)) {
            return DEFAULT_DES_IV;
        }
        return sDesIv;
    }

    public static String getDesKey() {
        if (TextUtils.isEmpty(sDesKey)) {
            return DEFAULT_DES_KEY;
        }
        return sDesKey;
    }

    public static long getEngineInstanceLimit() {
        return sEngineInstanceLimit;
    }

    public static Class<? extends DKGLVideoPlayer> getGLPlayerClass() {
        return sGLPlayerClass;
    }

    public static DLog.LogSupport getLogSupport() {
        return sLogSupport;
    }

    public static MetricReportConfig getMetricReportConfig() {
        MetricReportConfig metricReportConfig = sMetricReportConfig;
        if (metricReportConfig == null) {
            return MetricReportConfig.DEFAULT;
        }
        return metricReportConfig;
    }

    public static SoConfigManager.OnSoDownloadListener getOnSoDownloadListener() {
        return sOnSoDownloadListener;
    }

    public static String getPlatform() {
        return sPlatform;
    }

    public static Class<? extends DKVideoPlayer> getPlayerClass() {
        return sPlayerClass;
    }

    public static DKVideoPlayerCreator getPlayerCreator() {
        return sPlayerCreator;
    }

    public static long getPreloadExpireTime() {
        long j3 = sPreloadExpireTime;
        if (j3 <= 0) {
            return 604800000L;
        }
        return j3;
    }

    public static long getPreloadMaxSize() {
        long j3 = sPreloadMaxSize;
        if (j3 <= 0) {
            return 52428800L;
        }
        return j3;
    }

    public static int getResourceLoadTimeout() {
        int i3 = sResourceLoadTimeout;
        if (i3 <= 0) {
            return 30000;
        }
        return i3;
    }

    public static String getSoConfigServiceUrl() {
        if (TextUtils.isEmpty(sSoConfigUrl)) {
            return DEFAULT_SO_CONFIG_SERVICE_URL;
        }
        return sSoConfigUrl;
    }

    public static String getTemplateListUrl() {
        return getTemplateServiceConfigUrl() + "/" + SERVICE_TEMPLATE_LIST;
    }

    public static long getTemplateMaxSize() {
        long j3 = sTemplateMaxSize;
        if (j3 <= 0) {
            return 20971520L;
        }
        return j3;
    }

    private static String getTemplateServiceConfigUrl() {
        String str = sTemplateConfigUrl;
        if (TextUtils.isEmpty(str)) {
            return DEFAULT_TEMPLATE_SERVICE_CONFIG_URL;
        }
        return str;
    }

    public static String getTemplateUrl() {
        return getTemplateServiceConfigUrl() + "/template";
    }

    public static TemplateManager.UpdateTemplateListenerV2 getUpdateTemplateListener() {
        return sUpdateTemplateListener;
    }

    public static boolean isCheckAllEncryptTypeModuleBundleMD5() {
        return sCheckAllEncryptTypeModuleBundleMD5;
    }

    public static boolean isEnableEnginePreWarm() {
        return sEnableEnginePreWarm;
    }

    public static boolean isEnableMetricReport() {
        return sEnableMetricReport;
    }

    public static boolean isEnableOrganizeThreads() {
        return sEnableOrganizeThreads;
    }

    public static boolean isEnablePreloadResource() {
        return sEnablePreloadResource;
    }

    public static boolean isEnableResourcePreload() {
        return sEnableResourcePreload;
    }

    public static boolean isIgnoreImageLoaderLog() {
        return sIgnoreImageLoaderLog;
    }

    public static boolean isUseNewSoLoader() {
        return sUseNewSoLoader;
    }

    public static void setBundleConfigUrl(String str) {
        sBundleConfigUrl = str;
    }

    public static void setBundleEventListener(BundleEventListener bundleEventListener) {
        sBundleEventListener = bundleEventListener;
    }

    public static void setBundleExpireTime(long j3) {
        sBundleExpireTime = j3;
    }

    public static void setBundleLoadTimeout(int i3) {
        sBundleLoadTimeout = i3;
    }

    public static void setBundleMaxSize(long j3) {
        sBundleMaxSize = j3;
    }

    public static void setCheckAllEncryptTypeModuleBundleMD5(boolean z16) {
        sCheckAllEncryptTypeModuleBundleMD5 = z16;
    }

    public static void setConnectionCreator(DKURLConnectionCreator dKURLConnectionCreator) {
        sConnectionCreator = dKURLConnectionCreator;
    }

    public static void setDKWebView(Class<? extends DKWebView> cls) {
        sHippyWebViewClass = cls;
    }

    public static void setDesIv(String str) {
        sDesIv = str;
    }

    public static void setDesKey(String str) {
        sDesKey = str;
    }

    public static void setEnableEnginePreWarm(boolean z16) {
        sEnableEnginePreWarm = z16;
    }

    public static void setEnableMetricReport(boolean z16) {
        sEnableMetricReport = z16;
    }

    public static void setEnableOrganizeThreads(boolean z16) {
        sEnableOrganizeThreads = z16;
    }

    public static void setEnablePreloadResource(boolean z16) {
        sEnablePreloadResource = z16;
    }

    public static void setEnableResourcePreload(boolean z16) {
        sEnableResourcePreload = z16;
    }

    public static void setEngineInstanceLimit(long j3) {
        sEngineInstanceLimit = j3;
    }

    public static void setGLPlayerClass(Class<? extends DKGLVideoPlayer> cls) {
        sGLPlayerClass = cls;
    }

    public static void setIgnoreImageLoaderLog(boolean z16) {
        sIgnoreImageLoaderLog = z16;
    }

    public static void setLogSupport(DLog.LogSupport logSupport) {
        sLogSupport = logSupport;
    }

    public static void setMetricReportConfig(MetricReportConfig metricReportConfig) {
        sMetricReportConfig = metricReportConfig;
    }

    public static void setOnSoDownloadListener(SoConfigManager.OnSoDownloadListener onSoDownloadListener) {
        sOnSoDownloadListener = onSoDownloadListener;
    }

    public static void setPlatform(String str) {
        sPlatform = str;
    }

    @Deprecated
    public static void setPlayerClass(Class<? extends DKVideoPlayer> cls) {
        sPlayerClass = cls;
    }

    public static void setPlayerCreator(DKVideoPlayerCreator dKVideoPlayerCreator) {
        sPlayerCreator = dKVideoPlayerCreator;
    }

    public static void setPreloadExpireTIme(long j3) {
        sPreloadExpireTime = j3;
    }

    public static void setPreloadMaxSize(long j3) {
        sPreloadMaxSize = j3;
    }

    public static void setSoConfigServiceUrl(String str) {
        sSoConfigUrl = str;
    }

    public static void setTemplateMaxSize(long j3) {
        sTemplateMaxSize = j3;
    }

    public static void setTemplateServiceConfigUrl(String str) {
        sTemplateConfigUrl = str;
    }

    public static void setUpdateTemplateListener(TemplateManager.UpdateTemplateListenerV2 updateTemplateListenerV2) {
        sUpdateTemplateListener = updateTemplateListenerV2;
    }

    public static void setUseNewSoLoader(boolean z16) {
        sUseNewSoLoader = z16;
    }
}
