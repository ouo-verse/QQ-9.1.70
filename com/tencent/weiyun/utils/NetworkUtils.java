package com.tencent.weiyun.utils;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NetworkUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NETWORK_TYPE_WIFI = 3;
    private static final String TAG = "NetworkUtils";
    private static INetworkInfoProvider sNetworkInfoProvider;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface INetworkInfoProvider {
        NetworkInfo getNetworkInfo(Context context);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class IspType {
        static IPatchRedirector $redirector_ = null;
        public static final int ISP_TYPE_CMCC = 1;
        public static final int ISP_TYPE_CMCT = 3;
        public static final int ISP_TYPE_UNICOM = 2;
        public static final int ISP_TYPE_UNKNOWN = 0;
        public static final int ISP_TYPE_WIFI = 4;

        public IspType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class NetworkType {
        static IPatchRedirector $redirector_ = null;
        public static final int MOBILE_2G = 2;
        public static final int MOBILE_3G = 3;
        public static final int MOBILE_4G = 4;
        public static final int NONE = 0;
        public static final int WIFI = 1;

        public NetworkType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public NetworkUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String convert2IP(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3 & 255);
        stringBuffer.append('.');
        int i16 = i3 >>> 8;
        stringBuffer.append(i16 & 255);
        stringBuffer.append('.');
        int i17 = i16 >>> 8;
        stringBuffer.append(i17 & 255);
        stringBuffer.append('.');
        stringBuffer.append((i17 >>> 8) & 255);
        return stringBuffer.toString();
    }

    private static int convertNetworkType(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3 || i3 == 4) {
            return 2;
        }
        return 0;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        INetworkInfoProvider iNetworkInfoProvider = sNetworkInfoProvider;
        if (iNetworkInfoProvider == null) {
            return null;
        }
        return iNetworkInfoProvider.getNetworkInfo(context);
    }

    public static String getDnsInfo(Context context) {
        if (context == null) {
            return null;
        }
        DhcpInfo dhcpInfo = NetworkMonitor.getDhcpInfo((WifiManager) context.getSystemService("wifi"));
        if (dhcpInfo == null) {
            return "none";
        }
        return convert2IP(dhcpInfo.dns1) + ';' + convert2IP(dhcpInfo.dns2);
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        return convertNetworkType(getNetworkType(activeNetworkInfo));
    }

    public static int getNetworkTypeDiff4G(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return getNetworkType(activeNetworkInfo);
        }
        return 0;
    }

    public static String getWifiBSSID(Context context) {
        return "";
    }

    public static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiManager;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return null;
        }
        return LocationMonitor.getConnectionInfo(wifiManager);
    }

    public static String getWifiMacAddress(Context context) {
        if (context == null) {
            return null;
        }
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            String macAddress = NetworkMonitor.getMacAddress(wifiInfo);
            if (macAddress != null) {
                return macAddress.toLowerCase().replaceAll(":", "-");
            }
            Log.w(TAG, "mac address is null!");
        } else {
            Log.w(TAG, "can *NOT* get connect info when get mac address!");
        }
        return null;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return true;
        }
        return false;
    }

    public static void setNetworkInfoProvider(INetworkInfoProvider iNetworkInfoProvider) {
        if (sNetworkInfoProvider == null && iNetworkInfoProvider != null) {
            sNetworkInfoProvider = iNetworkInfoProvider;
        }
    }

    private static int getNetworkType(NetworkInfo networkInfo) {
        int type = NetworkMonitor.getType(networkInfo);
        if (type != 0) {
            return type != 1 ? 0 : 1;
        }
        switch (NetworkMonitor.getSubtype(networkInfo)) {
            case 0:
            default:
                return 0;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
        }
    }
}
