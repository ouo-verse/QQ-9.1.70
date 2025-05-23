package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Apn {
    public static final int APN_2G = 1;
    public static final int APN_3G = 2;
    public static final int APN_4G = 4;
    public static final int APN_CELLULAR = 5;
    public static final int APN_ETHERNET = 6;
    public static final int APN_UNKNOWN = 0;
    public static final int APN_WIFI = 3;

    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            return 0;
        }
        int type = NetworkMonitor.getType(networkInfo);
        if (type == 0) {
            switch (NetworkMonitor.getSubtype(networkInfo)) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        if (type != 1) {
            return 0;
        }
        return 3;
    }

    @Deprecated
    public static String getApnInfo(Context context) {
        return "unknown";
    }

    public static int getApnType(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT > 28) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            if (NetworkMonitor.hasTransport(networkCapabilities, 1)) {
                return 3;
            }
            if (NetworkMonitor.hasTransport(networkCapabilities, 0)) {
                return 5;
            }
            if (!NetworkMonitor.hasTransport(networkCapabilities, 3)) {
                return 0;
            }
            return 6;
        }
        return a(connectivityManager.getActiveNetworkInfo());
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        if (!activeNetworkInfo.isConnected() && !activeNetworkInfo.isAvailable()) {
            return false;
        }
        return true;
    }
}
