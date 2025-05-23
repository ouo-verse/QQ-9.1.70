package com.tencent.biz.richframework.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWNetworkUtils {
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private static NetworkInfo getActiveNetworkInfo() {
        String networkInfo;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) RFWApplication.getApplication().getSystemService("connectivity")).getActiveNetworkInfo();
            int i3 = RFWLog.DEV;
            Object[] objArr = new Object[1];
            if (activeNetworkInfo == null) {
                networkInfo = "getActiveNetworkInfo null";
            } else {
                networkInfo = activeNetworkInfo.toString();
            }
            objArr[0] = networkInfo;
            RFWLog.d("RFWNetworkUtils", i3, objArr);
            return activeNetworkInfo;
        } catch (Throwable th5) {
            RFWLog.d("RFWNetworkUtils", RFWLog.USR, "fail to get active network info " + th5.toString());
            return null;
        }
    }

    public static String getNetworkType(Network network) {
        NetworkCapabilities networkCapabilities = ((ConnectivityManager) RFWApplication.getApplication().getSystemService("connectivity")).getNetworkCapabilities(network);
        if (networkCapabilities == null) {
            return "No Network";
        }
        if (NetworkMonitor.hasTransport(networkCapabilities, 1)) {
            return "WiFi";
        }
        if (NetworkMonitor.hasTransport(networkCapabilities, 0)) {
            return "Cellular";
        }
        if (NetworkMonitor.hasTransport(networkCapabilities, 3)) {
            return "Ethernet";
        }
        if (NetworkMonitor.hasTransport(networkCapabilities, 2)) {
            return "Bluetooth";
        }
        return "Unknown";
    }

    public static String getPhoneCarrierName() {
        if (ContextCompat.checkSelfPermission(RFWApplication.getApplication(), DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
            RFWLog.i("RFWNetworkUtils", RFWLog.USR, "no phone state permission");
            return "Cellular";
        }
        TelephonyManager telephonyManager = (TelephonyManager) RFWApplication.getApplication().getSystemService("phone");
        if (telephonyManager == null) {
            return "Cellular";
        }
        String str = "Cellular_" + telephonyManager.getNetworkOperatorName();
        RFWLog.i("RFWNetworkUtils", RFWLog.CLR, "final wifi info is " + str);
        return str;
    }

    public static String getWifiInfoName() {
        if (ContextCompat.checkSelfPermission(RFWApplication.getApplication(), "android.permission.ACCESS_WIFI_STATE") == 0 && ContextCompat.checkSelfPermission(RFWApplication.getApplication(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            WifiManager wifiManager = (WifiManager) RFWApplication.getApplication().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || LocationMonitor.getConnectionInfo(wifiManager) == null) {
                return "WiFi";
            }
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo(wifiManager);
            String ssid = NetworkMonitor.getSSID(connectionInfo);
            String str = "WiFi_" + NetworkMonitor.getBSSID(connectionInfo) + "_" + ssid;
            RFWLog.i("RFWNetworkUtils", RFWLog.CLR, "final wifi info is " + str);
            return str;
        }
        RFWLog.i("RFWNetworkUtils", RFWLog.USR, "no wifi permission");
        return "WiFi";
    }

    public static boolean isCellularNetwork(String str) {
        return TextUtils.equals("Cellular", str);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiNetwork(String str) {
        return TextUtils.equals("WiFi", str);
    }
}
