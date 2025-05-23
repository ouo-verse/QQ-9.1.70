package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NetworkUtil {
    public static final String APN_UNKNOWN = "unknown";
    public static final String APN_WIFI = "wifi";

    public static String getApn(Context context) {
        if (AppNetConnInfo.isWifiConn()) {
            return "wifi";
        }
        String currentAPN = AppNetConnInfo.getCurrentAPN();
        if (TextUtils.isEmpty(currentAPN)) {
            return "unknown";
        }
        return currentAPN;
    }

    public static int getConnRetryTimes(int i3) {
        if (i3 != 1) {
            if (i3 == 3) {
                return 3;
            }
            if (i3 != 4 && i3 != 5) {
                return 2;
            }
        }
        return 4;
    }

    public static String getCurrentWifiSSID(Context context) {
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo((WifiManager) context.getSystemService("wifi"));
            if (connectionInfo != null && NetworkMonitor.getSSID(connectionInfo) != null) {
                String replaceAll = NetworkMonitor.getSSID(connectionInfo).replaceAll("\"", "");
                if (replaceAll.equals(BaseConstants.UNKNOWN_SSID_STRING)) {
                    return null;
                }
                return replaceAll;
            }
            return null;
        } catch (Throwable th5) {
            QLog.e(com.tencent.qqmini.sdk.core.utils.NetworkUtil.TAG, 1, "fail to get active network info", th5);
            return null;
        }
    }

    public static int getNetWorkType() {
        int mobileInfo;
        int i3 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (AppNetConnInfo.isMobileConn() && (mobileInfo = AppNetConnInfo.getMobileInfo()) != -1) {
            i3 = 2;
            if (mobileInfo != 0 && mobileInfo != 1) {
                if (mobileInfo == 2) {
                    return 3;
                }
                if (mobileInfo != 3 && mobileInfo != 4) {
                    return -1;
                }
                return 4;
            }
        }
        return i3;
    }

    public static int getNetworkType(Context context) {
        NetworkInfo recentNetworkInfo;
        if (AppNetConnInfo.isNetSupport() && (recentNetworkInfo = AppNetConnInfo.getRecentNetworkInfo()) != null) {
            return NetworkMonitor.getType(recentNetworkInfo);
        }
        return -1;
    }

    public static int getSystemNetwork(Context context) {
        int netWorkType = getNetWorkType();
        if (netWorkType == -1) {
            return 2;
        }
        return netWorkType;
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

    public static boolean is3Gor4G(Context context) {
        int netWorkType = getNetWorkType();
        if (netWorkType != 4 && netWorkType != 3) {
            return false;
        }
        return true;
    }

    public static boolean is4G(Context context) {
        if (getNetWorkType() == 4) {
            return true;
        }
        return false;
    }

    public static boolean is5G(Context context) {
        if (getNetWorkType() == 4) {
            return true;
        }
        return false;
    }

    public static boolean isAirplaneModeOn(Context context) {
        return HwNetworkUtil.isAirplaneModeOn(context);
    }

    @TargetApi(13)
    public static boolean isBluetoothSharedNetwork(Context context) {
        if (getNetworkType(context) == 7) {
            return true;
        }
        return false;
    }

    public static boolean isMobileNetWork(Context context) {
        return AppNetConnInfo.isMobileConn();
    }

    public static boolean isMobileNetworkInfo(NetworkInfo networkInfo) {
        return HwNetworkUtil.isMobileNetworkInfo(networkInfo);
    }

    public static boolean isNetSupport(Context context) {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean isNetSupportHw(Context context) {
        return HwNetworkUtil.isNetSupport(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        return AppNetConnInfo.isNetSupport();
    }

    public static boolean isWifiConnected(Context context) {
        return AppNetConnInfo.isWifiConn();
    }

    public static boolean isWifiEnabled(Context context) {
        return AppNetConnInfo.isWifiConn();
    }

    public static boolean isNetworkAvailable() {
        return AppNetConnInfo.isNetSupport();
    }
}
