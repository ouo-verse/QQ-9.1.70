package cooperation.qqcircle.utils;

import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.PlatformInfor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class NetworkState {
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 4;
    public static final int NET_TYPE_5G = 5;
    public static final int NET_TYPE_UNKNOWN = 0;
    public static final int NET_TYPE_WIFI = 1;
    public static final String SP_KEY_FLAG_FORCE_WIFI_TO_4G = "key_force_wifi_to_4g";
    private static final String TAG = "NetworkState";
    public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_DEFAULT = 0;
    public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_NO = 0;
    public static final int VALUE_FLAG_FORCE_WIFI_TO_4G_YES = 1;
    private static Map<String, Integer> mApnMap = new HashMap();
    private static Map<Long, Boolean> map = new HashMap();
    public static long uin = -1;
    private static String providerName = null;
    private static List<NetworkStateListener> observers = new ArrayList();
    private static INetEventHandler netEventHandler = new INetEventHandler() { // from class: cooperation.qqcircle.utils.NetworkState.1
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
        public void onNetChangeEvent(boolean z16) {
            QLog.i(NetworkState.TAG, 1, "--onNetChangeEvent isNetEffective:" + z16);
            NetworkState.notifyObservers(z16);
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface NetworkStateListener {
        void onNetworkConnect(boolean z16);
    }

    static {
        mApnMap.put("unknown", 0);
        mApnMap.put("cmnet", 1);
        mApnMap.put("cmwap", 2);
        mApnMap.put("3gnet", 3);
        mApnMap.put("3gwap", 4);
        mApnMap.put("uninet", 5);
        mApnMap.put("uniwap", 6);
        mApnMap.put("wifi", 7);
        mApnMap.put("ctwap", 8);
        mApnMap.put("ctnet", 9);
        mApnMap.put("cmcc", 10);
        mApnMap.put("unicom", 11);
        mApnMap.put("cmct", 12);
        registerReceiver();
    }

    public static void addListener(NetworkStateListener networkStateListener) {
        if (networkStateListener == null) {
            return;
        }
        synchronized (observers) {
            if (!observers.contains(networkStateListener)) {
                observers.add(networkStateListener);
            }
        }
    }

    public static void clearConfigCache() {
        Map<Long, Boolean> map2 = map;
        if (map2 != null) {
            map2.clear();
        }
    }

    @Deprecated
    public static void forceNotifyNetworkChangeForDebugVersion() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            boolean isNetSupport = isNetSupport();
            QLog.i(TAG, 4, "forceNotifyNetworkChangeForDebugVersion \u5f3a\u5236\u901a\u77e5\u7f51\u7edc\u72b6\u6001\u6709\u53d8\u5316\uff0c\u4ec5debug\u7248\u672c\u53ef\u7528 hasNet=" + isNetSupport);
            netEventHandler.onNetChangeEvent(isNetSupport);
        }
    }

    public static String getAPN() {
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        String currentAPN = AppNetConnInfo.getCurrentAPN();
        if (TextUtils.isEmpty(currentAPN)) {
            return "unknown";
        }
        return currentAPN;
    }

    public static int getApnValue() {
        NetworkInfo recentNetworkInfo;
        int i3;
        if (!AppNetConnInfo.isNetSupport() || (recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo()) == null || !recentNetworkInfo.isConnectedOrConnecting()) {
            return 0;
        }
        if (1 == NetworkMonitor.getType(recentNetworkInfo)) {
            return 4;
        }
        if (mApnMap.get(NetworkMonitor.netGetExInfo(recentNetworkInfo)) != null) {
            i3 = mApnMap.get(NetworkMonitor.netGetExInfo(recentNetworkInfo)).intValue();
        } else {
            i3 = 5;
        }
        switch (i3) {
            case 1:
            case 2:
            case 10:
                return 1;
            case 3:
            case 4:
            case 5:
            case 6:
            case 11:
                return 2;
            case 7:
                return 4;
            case 8:
            case 9:
            case 12:
                return 3;
            default:
                return 0;
        }
    }

    public static boolean getConfigIsForceWifiTo4g() {
        long longAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
        uin = longAccountUin;
        if (map.get(Long.valueOf(longAccountUin)) != null) {
            return map.get(Long.valueOf(uin)).booleanValue();
        }
        boolean z16 = false;
        if (1 == LocalMultiProcConfig.getInt4Uin("key_force_wifi_to_4g", 0, uin)) {
            z16 = true;
        }
        map.put(Long.valueOf(uin), Boolean.valueOf(z16));
        return z16;
    }

    private static boolean getIsMobileForDebugVersion() {
        try {
            if (!isNetSupport()) {
                return false;
            }
            if (!AppNetConnInfo.isWifiConn()) {
                return true;
            }
            if (getConfigIsForceWifiTo4g()) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getIsMobileForDebugVersion error", e16);
            return AppNetConnInfo.isMobileConn();
        }
    }

    public static boolean getIsUnicomNetWork() {
        String apn = getAPN();
        if (TextUtils.isEmpty(apn)) {
            return false;
        }
        if (!apn.equalsIgnoreCase("UNIWAP") && !apn.equalsIgnoreCase("UNINET") && !apn.equalsIgnoreCase("3GWAP") && !apn.equalsIgnoreCase("3GNET") && !apn.equalsIgnoreCase("WONET")) {
            return false;
        }
        return true;
    }

    private static boolean getIsWifiForDebugVersion() {
        if (!isNetSupport() || getIsMobileForDebugVersion()) {
            return false;
        }
        return true;
    }

    public static int getNetworkType() {
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn()) {
            int mobileInfo = AppNetConnInfo.getMobileInfo();
            int i3 = 2;
            if (mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                i3 = 4;
                if (mobileInfo != 3) {
                    if (mobileInfo == 4) {
                        return 5;
                    }
                }
            }
            return i3;
        }
        return 0;
    }

    public static String getProviderName() {
        if (TextUtils.isEmpty(providerName)) {
            String imsi = PlatformInfor.g().getIMSI();
            if (imsi != null && !"".equals(imsi)) {
                if (!imsi.startsWith("46000") && !imsi.startsWith("46002")) {
                    if (imsi.startsWith("46001")) {
                        providerName = "ChinaUnicom";
                    } else if (imsi.startsWith("46003")) {
                        providerName = "ChinaTelecom";
                    } else {
                        providerName = "unknown";
                    }
                } else {
                    providerName = "ChinaMobile";
                }
            } else {
                providerName = "unknown";
            }
        }
        return providerName;
    }

    public static String intAddr2Ip(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3 & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 8) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 16) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i3 >> 24) & 255);
        return stringBuffer.toString();
    }

    public static boolean isMobile() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return getIsMobileForDebugVersion();
        }
        return AppNetConnInfo.isMobileConn();
    }

    public static boolean isNetSupport() {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean isWap() {
        int i3;
        if (!AppNetConnInfo.isMobileConn()) {
            return false;
        }
        try {
            i3 = mApnMap.get(AppNetConnInfo.getCurrentAPN()).intValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            i3 = 5;
        }
        if (i3 != 2 && i3 != 4 && i3 != 6 && i3 != 8) {
            return false;
        }
        return true;
    }

    public static boolean isWifiConn() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return getIsWifiForDebugVersion();
        }
        return AppNetConnInfo.isWifiConn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyObservers(boolean z16) {
        int size;
        NetworkStateListener[] networkStateListenerArr;
        synchronized (observers) {
            size = observers.size();
            networkStateListenerArr = new NetworkStateListener[size];
            observers.toArray(networkStateListenerArr);
        }
        for (int i3 = 0; i3 < size; i3++) {
            networkStateListenerArr[i3].onNetworkConnect(z16);
        }
    }

    public static void registerReceiver() {
        try {
            AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), netEventHandler);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void removeListener(NetworkStateListener networkStateListener) {
        synchronized (observers) {
            observers.remove(networkStateListener);
        }
    }
}
