package com.tencent.component.network.module.base;

import com.tencent.component.network.module.base.inter.IDownloadConfig;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Config {
    public static final boolean DEFAULT_ENABLE_DNS114 = true;
    public static final int DEFAULT_HTTP2_LIVE_TIME = 120;
    public static final int DEFAULT_HTTP2_THREAD_POOLSIZE = 2;
    public static final int DEFAULT_HTTP_LIVE_TIME = 120;
    public static final int DEFAULT_KP_CONFIG = -1;
    public static final int DEFAULT_KP_PROXY_CONFIG = -1;
    public static final String DEFAULT_QUA = "";
    public static final String DEFAULT_REFER = "tencent";
    public static final int DEFAULT_REPORT_PERCENT = 5;
    public static final String DEFAULT_TERMINAL = "android";
    public static final int DEFAULT_THREAD_POOLSIZE = 2;
    public static final String DEFAULT_USER_AGENT = "android-tencent";
    public static final String DEFAULT_VALUE_DEFAULT_REFER = "http://user.qzone.qq.com";
    public static final long DEFAULT_VALUE_ENABLE_GLOBAL_LISTENER = 1;
    public static final long DEFAULT_VALUE_ENABLE_MAX_DOWNLOAD_SIZE_LIMIT = 1;
    public static final long DEFAULT_VALUE_MAX_DOWNLOAD_SIZE = 1073741824;
    public static final String DEFAULT_VERSION = "1.0";
    public static final String MAIN_KEY_PHOTO_SVRLIST = "PhotoSvrList";
    public static final String MAIN_KEY_QZONE_SETTING = "QZoneSetting";
    public static final String SECONDARY_KEY_DEFAULT_REFER = "secondary_key_default_refer";
    public static final String SECONDARY_KEY_ENABLE_CACHE_WIFI_BSSID = "enable_cache_wifi_bssid";
    public static final long SECONDARY_KEY_ENABLE_CACHE_WIFI_BSSID_DEFAULT = 1;
    public static final String SECONDARY_KEY_ENABLE_FILTER_IPV6_LOCAL_BACK_ADDR = "enable_filter_ipv6_local_back_addr";
    public static final long SECONDARY_KEY_ENABLE_FILTER_IPV6_LOCAL_BACK_ADDR_DEFAULT = 1;
    public static final String SECONDARY_KEY_ENABLE_GLOBAL_LISTENER = "enable_global_listener";
    public static final String SECONDARY_KEY_ENABLE_MAX_DOWNLOAD_SIZE_LIMIT = "enable_max_download_size_limit";
    public static final String SECONDARY_KEY_FORCE_DNS_FIRST = "force_dns_first";
    public static final long SECONDARY_KEY_FORCE_DNS_FIRST_DEFAULT = 0;
    public static final String SECONDARY_KEY_HTTPS_DIS_VALID_TIME = "disable_https_time";
    public static final long SECONDARY_KEY_HTTPS_DIS_VALID_TIME_DEFAULT = 86400;
    public static final String SECONDARY_KEY_HTTPS_FAILCOUNT = "disable_https_failcount";
    public static final long SECONDARY_KEY_HTTPS_FAILCOUNT_DEFAULT = 6;
    public static final String SECONDARY_KEY_MAX_DOWNLOAD_SIZE = "max_download_size";
    public static final String SECONDARY_KEY_USE_SMART_IP_STACK_STRATEGY = "use_smart_ip_stack_strategy";
    public static final long SECONDARY_KEY_USE_SMART_IP_STACK_STRATEGY_DEFAULT = 1;
    private static String mDefaultRefer;
    private static String mReferPrefix;
    private static IDownloadConfig sRealConfig;

    public static boolean canRetCodeRetry(int i3) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.canRetCodeRetry(i3);
        }
        return false;
    }

    public static boolean disableBssid() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.disableBssid();
        }
        return false;
    }

    public static boolean enableDns114() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.enableDns114();
        }
        return true;
    }

    public static boolean enbaleGlobalListener() {
        if (getConfig("QZoneSetting", SECONDARY_KEY_ENABLE_GLOBAL_LISTENER, 1L) == 1) {
            return true;
        }
        return false;
    }

    public static long getConfig(String str, String str2, long j3) {
        try {
            IDownloadConfig iDownloadConfig = sRealConfig;
            if (iDownloadConfig != null) {
                return ((Long) iDownloadConfig.getConfig(str, str2, Long.valueOf(j3))).longValue();
            }
            return j3;
        } catch (Exception unused) {
            return j3;
        }
    }

    public static long getCurrentUin() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getCurrentUin();
        }
        return 0L;
    }

    public static long getDefaultHttp2LiveTime() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null && iDownloadConfig.getDefaultHttp2LiveTime() > 0) {
            return sRealConfig.getDefaultHttp2LiveTime();
        }
        return 120L;
    }

    public static int getDefaultHttp2ThreadPoolSize() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null && iDownloadConfig.getDefaultHttp2ThreadPoolSize() > 0) {
            return sRealConfig.getDefaultHttp2ThreadPoolSize();
        }
        return 2;
    }

    public static long getDefaultHttpLiveTime() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null && iDownloadConfig.getDefaultHttpLiveTime() > 0) {
            return sRealConfig.getDefaultHttpLiveTime();
        }
        return 120L;
    }

    public static long getDefaultMaxDownloadSize() {
        return getConfig("QZoneSetting", SECONDARY_KEY_MAX_DOWNLOAD_SIZE, 1073741824L);
    }

    public static String getDefaultRefer() {
        if (!getStringConfig("QZoneSetting", SECONDARY_KEY_DEFAULT_REFER, DEFAULT_VALUE_DEFAULT_REFER).equals(mReferPrefix)) {
            setDefaultRefer();
        }
        return mDefaultRefer;
    }

    public static int getDefaultThreadPoolSize() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null && iDownloadConfig.getDefaultThreadPoolSize() > 0) {
            return sRealConfig.getDefaultThreadPoolSize();
        }
        return 2;
    }

    public static int getNetworkStackType() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getNetworkStackType();
        }
        return 0;
    }

    public static int getOperator() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getOperator();
        }
        return 0;
    }

    public static String getQUA() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getQUA();
        }
        return "";
    }

    public static String getRefer() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getRefer();
        }
        return "tencent";
    }

    public static int getReportPercent() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getReportPercent();
        }
        return 5;
    }

    public static String getStringConfig(String str, String str2, String str3) {
        try {
            IDownloadConfig iDownloadConfig = sRealConfig;
            if (iDownloadConfig != null) {
                return (String) iDownloadConfig.getConfig(str, str2, str3);
            }
            return str3;
        } catch (Exception unused) {
            return str3;
        }
    }

    public static String getTerminal() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getTerminal();
        }
        return "android";
    }

    public static String getUserAgent() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getUserAgent();
        }
        return "android-tencent";
    }

    public static String getVersion() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.getVersion();
        }
        return "1.0";
    }

    public static boolean isEnableCacheWifiBSSID() {
        if (getConfig("QZoneSetting", SECONDARY_KEY_ENABLE_CACHE_WIFI_BSSID, 1L) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isEnableMaxDownloadSizeLimit() {
        if (getConfig("QZoneSetting", SECONDARY_KEY_ENABLE_MAX_DOWNLOAD_SIZE_LIMIT, 1L) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isForceDNSFirst() {
        if (getConfig("PhotoSvrList", SECONDARY_KEY_FORCE_DNS_FIRST, 0L) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFromQzoneAlbum(String str) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.isFromQzoneAlbum(str);
        }
        return false;
    }

    public static boolean isIpV6Stack() {
        if (getNetworkStackType() != 2 && getNetworkStackType() != 3) {
            return false;
        }
        return true;
    }

    public static boolean isUseSmartIpStackStrategy() {
        if (getConfig("QZoneSetting", SECONDARY_KEY_USE_SMART_IP_STACK_STRATEGY, 1L) != 0) {
            return true;
        }
        return false;
    }

    public static int photoDownloadKeepAliveConfig() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.photoDownloadKeepAliveConfig();
        }
        return -1;
    }

    public static int photoDownloadKeepAliveProxyConfig() {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.photoDownloadKeepAliveProxyConfig();
        }
        return -1;
    }

    public static void reportToBeacon(String str, boolean z16, HashMap<String, String> hashMap, long j3) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            iDownloadConfig.reportToBeacon(str, z16, hashMap, j3);
        }
    }

    public static void reportToLp(int i3, boolean z16, String str, int i16, String str2) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            iDownloadConfig.reportToLp(i3, z16, str, i16, str2);
        }
    }

    public static void reportToMta(String str, Properties properties) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            iDownloadConfig.reportToMta(str, properties);
        }
    }

    public static void setConfig(IDownloadConfig iDownloadConfig) {
        sRealConfig = iDownloadConfig;
        setDefaultRefer();
    }

    private static void setDefaultRefer() {
        mReferPrefix = getStringConfig("QZoneSetting", SECONDARY_KEY_DEFAULT_REFER, DEFAULT_VALUE_DEFAULT_REFER);
        mDefaultRefer = mReferPrefix + "/?qua=" + getQUA();
    }

    public static boolean shouldUseHttp2(String str) {
        IDownloadConfig iDownloadConfig = sRealConfig;
        if (iDownloadConfig != null) {
            return iDownloadConfig.shouldUseHttp2(str);
        }
        return false;
    }
}
