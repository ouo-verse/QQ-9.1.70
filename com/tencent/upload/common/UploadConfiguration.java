package com.tencent.upload.common;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.upload.network.route.IUploadRouteStrategy;
import com.tencent.upload.network.route.RecentRouteRecord;
import com.tencent.upload.network.route.RecentRouteRecordStorage;
import com.tencent.upload.network.route.ServerRouteTable;
import com.tencent.upload.network.route.UploadRoute;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.utils.UploadLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadConfiguration {
    static IPatchRedirector $redirector_ = null;
    private static final int CONNECTION_TIMEOUT_MS = 20000;
    private static final int DATA_TIMEOUT_MS = 60000;
    private static final int[] DEFAULT_MAS_SEGMENT_SIZE_ARRAY;
    public static final List DEF_PORTS;
    private static final int DOMAIN_NAME_PARSE_TIMEOUT_MS = 20000;
    private static final int MAX_SESSION_PACKET_SIZE_BYTE = 2097152;
    private static final String TAG = "Configuration";

    @Deprecated
    public static final HashMap<String, Integer> UPLOAD_IP_TIMEOUT_MAP;
    private static volatile long[] sServerTimePair;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class NetworkCategory {
        static IPatchRedirector $redirector_ = null;
        public static final int MOBILE_2G = 3;
        public static final int MOBILE_3G = 2;
        public static final int MOBILE_4G = 6;
        public static final int MOBILE_5G = 7;
        public static final int UNKNOWN = 0;
        public static final int WIFI = 1;

        public NetworkCategory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface NetworkStateObserver {
        void onStateChanged(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class OperatorCategory {
        static IPatchRedirector $redirector_ = null;
        public static final int CMCC = 1;
        public static final int CMCT = 3;
        public static final int UNICOM = 2;
        public static final int UNKNOW = 0;
        public static final int WIFI = 4;

        public OperatorCategory() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9950);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DEFAULT_MAS_SEGMENT_SIZE_ARRAY = new int[]{1440, 1200, 700};
        UPLOAD_IP_TIMEOUT_MAP = new HashMap<>();
        DEF_PORTS = Arrays.asList(80, Integer.valueOf(WebSocketImpl.DEFAULT_WSS_PORT), 8080, Integer.valueOf(TVKEventId.PLAYER_STATE_SPEED_RATIO_CHANGED));
    }

    public UploadConfiguration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final void checkVaildConnection(Context context, Long l3, String str) {
        Utility.keepLongConnection(context, l3, str);
    }

    public static final String getChangeRouteRetCode() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config != null) {
            return config.getChangeRouteRetCodes();
        }
        return null;
    }

    public static final int getConnectionTimeout() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config != null) {
            return config.getConnectTimeout() * 1000;
        }
        return 20000;
    }

    public static final String getCurrentApn() {
        return UploadGlobalConfig.getUploadEnv().getApnName();
    }

    public static int getCurrentNetworkCategory() {
        return UploadGlobalConfig.getUploadEnv().getCurrentNetworkCategory();
    }

    public static final int getCurrentOperatorCategory() {
        IUploadEnv uploadEnv = UploadGlobalConfig.getUploadEnv();
        if (uploadEnv == null) {
            return 0;
        }
        if (uploadEnv.isMobile()) {
            return uploadEnv.getMobileOperatorCategory();
        }
        if (!uploadEnv.isWifi()) {
            return 0;
        }
        return getWifiOperatorCategory();
    }

    public static final int getDataTimeout() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config != null) {
            return config.getDataTimeout() * 1000;
        }
        return 60000;
    }

    public static final int getDoNotFragment() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return 1;
        }
        return config.getDoNotFragment();
    }

    public static final int getDomainNameParseTimeout() {
        return 20000;
    }

    public static final String getExifTagCode(String str) {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return null;
        }
        return config.getExifTagCode(str);
    }

    public static int getGifUploadLimit(int i3) {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return 5242880;
        }
        return config.getGifUploadLimit(i3);
    }

    public static final int getMaxSegmentSize(String str) {
        Integer num;
        if (!isWifiSetting()) {
            return -1;
        }
        HashMap<String, Integer> hashMap = UPLOAD_IP_TIMEOUT_MAP;
        synchronized (hashMap) {
            num = hashMap.get(str);
        }
        if (num == null) {
            num = 0;
        }
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            int[] iArr = DEFAULT_MAS_SEGMENT_SIZE_ARRAY;
            return iArr[num.intValue() % iArr.length];
        }
        String[] strArr = null;
        try {
            String maxSegmentSizeArray = config.getMaxSegmentSizeArray();
            if (maxSegmentSizeArray != null && maxSegmentSizeArray.length() > 0) {
                strArr = maxSegmentSizeArray.split("\\|");
            }
        } catch (PatternSyntaxException e16) {
            UploadLog.w(TAG, e16.toString());
        }
        if (strArr != null && strArr.length != 0) {
            try {
                return Math.max(Integer.parseInt(strArr[num.intValue() % strArr.length]), 64);
            } catch (NumberFormatException e17) {
                UploadLog.w(TAG, e17.toString());
                int[] iArr2 = DEFAULT_MAS_SEGMENT_SIZE_ARRAY;
                return iArr2[num.intValue() % iArr2.length];
            }
        }
        int[] iArr3 = DEFAULT_MAS_SEGMENT_SIZE_ARRAY;
        return iArr3[num.intValue() % iArr3.length];
    }

    public static final int getMaxSessionPacketSize() {
        return 2097152;
    }

    public static final String getNetworkUnavailableRetCode() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config != null) {
            return config.getNetworkUnavailableRetCodes();
        }
        return null;
    }

    public static final int getPictureQuality(String str) {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return 0;
        }
        return (int) config.getPictureQuality(str);
    }

    public static final String getProviderName() {
        return UploadGlobalConfig.getUploadEnv().getProviderName();
    }

    public static final String getRecentRouteApnKey() {
        IUploadEnv uploadEnv = UploadGlobalConfig.getUploadEnv();
        if (uploadEnv == null || !uploadEnv.isMobile()) {
            return null;
        }
        return uploadEnv.getApnName();
    }

    public static final long getRecentRouteExpire() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return 604800000L;
        }
        return config.getRecentRouteExpire();
    }

    public static final long[] getUploadServerTimePair() {
        return sServerTimePair;
    }

    public static final int getWifiOperatorCategory() {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return 0;
        }
        int wifiOperator = config.getWifiOperator();
        int i3 = 3;
        if (wifiOperator != 3) {
            i3 = 4;
            if (wifiOperator != 4) {
                if (wifiOperator != 5) {
                    if (wifiOperator != 8) {
                        return 0;
                    }
                    return 1;
                }
                return 2;
            }
        }
        return i3;
    }

    public static final boolean isMobileSetting() {
        return UploadGlobalConfig.getUploadEnv().isMobile();
    }

    public static final boolean isNetworkAvailable() {
        return UploadGlobalConfig.getUploadEnv().isAvailable();
    }

    public static boolean isPictureNeedToCompress(String str) {
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config == null) {
            return true;
        }
        return config.isPictureNeedToCompress(str);
    }

    public static final boolean isWapSetting() {
        return UploadGlobalConfig.getUploadEnv().isWap();
    }

    public static final boolean isWifiSetting() {
        return UploadGlobalConfig.getUploadEnv().isWifi();
    }

    public static final void registerNetworkStateObserver(NetworkStateObserver networkStateObserver) {
        IUploadEnv uploadEnv = UploadGlobalConfig.getUploadEnv();
        if (networkStateObserver != null && uploadEnv != null) {
            uploadEnv.registerNetworkStateObserver(networkStateObserver);
            return;
        }
        UploadLog.d(TAG, "observer:" + networkStateObserver + " env:" + uploadEnv);
    }

    public static final RecentRouteRecord saveAsRecentIp(ServerRouteTable serverRouteTable, String str, UploadRoute uploadRoute) {
        RecentRouteRecordStorage recentRouteRecordStorage = new RecentRouteRecordStorage(serverRouteTable);
        RecentRouteRecord data = recentRouteRecordStorage.getData(str);
        if (data == null) {
            data = new RecentRouteRecord();
            data.setTimeStamp(System.currentTimeMillis());
        }
        UploadRoute m286clone = uploadRoute.m286clone();
        m286clone.setRouteCategory(IUploadRouteStrategy.RouteCategoryType.RECENT);
        data.setRecentRoute(m286clone);
        recentRouteRecordStorage.setData(str, data);
        return data;
    }
}
