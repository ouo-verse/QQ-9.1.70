package cooperation.qzone.util;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQZoneApiProxy;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WiFiDash {
    public static final String EMPTY = "";
    public static final String NOT_AVALIBLE = "N/A";
    static volatile String currBSSID;

    public static String getBSSID() {
        if (currBSSID == null) {
            synchronized (WiFiDash.class) {
                if (currBSSID == null) {
                    updateBSSID();
                }
            }
        }
        if (!NOT_AVALIBLE.equals(currBSSID) && !"00:00:00:00:00:00".equals(currBSSID) && !"FF:FF:FF:FF:FF:FF".equalsIgnoreCase(currBSSID)) {
            return currBSSID;
        }
        return null;
    }

    private static Object queryWifiInfo(Object obj) {
        WifiInfo wifiInfo;
        WifiManager wifiManager = (WifiManager) BaseApplication.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            return obj;
        }
        try {
            wifiInfo = LocationMonitor.getConnectionInfo(wifiManager);
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return obj;
        }
        return wifiInfo;
    }

    public static String updateBSSID() {
        String str;
        synchronized (WiFiDash.class) {
            if (((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).disableBssid()) {
                currBSSID = NOT_AVALIBLE;
                return currBSSID;
            }
            Object queryWifiInfo = queryWifiInfo(NOT_AVALIBLE);
            if (queryWifiInfo != NOT_AVALIBLE) {
                str = NetworkMonitor.getBSSID((WifiInfo) queryWifiInfo);
                if (str == null) {
                    str = NOT_AVALIBLE;
                }
            } else {
                str = null;
            }
            currBSSID = str;
            return str;
        }
    }
}
