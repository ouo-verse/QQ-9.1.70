package com.tencent.gamematrix.gmcg.base.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNetworkUtil {
    public static final int NETWORK_TYPE_2G = 3;
    public static final int NETWORK_TYPE_3G = 4;
    public static final int NETWORK_TYPE_4G = 5;
    public static final int NETWORK_TYPE_5G = 6;
    public static final int NETWORK_TYPE_NONE = -1;
    public static final int NETWORK_TYPE_UNKNOWN = 1;
    public static final int NETWORK_TYPE_UNKNOWN_MOBILE = 2;
    public static final int NETWORK_TYPE_WIFI = 10;

    CGNetworkUtil() {
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getActiveNetworkType(Context context) {
        return getNetworkType(getActiveNetworkInfo(context));
    }

    public static int getNetworkType(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (NetworkMonitor.getType(networkInfo) == 1) {
                return 10;
            }
            if (NetworkMonitor.getType(networkInfo) != 0) {
                return 1;
            }
            int subtype = NetworkMonitor.getSubtype(networkInfo);
            if (subtype != 20) {
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 3;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 15:
                        return 4;
                    case 13:
                    case 14:
                        return 5;
                    default:
                        return 2;
                }
            }
            return 6;
        }
        return -1;
    }

    public static String getNetworkTypeSymbol(Context context) {
        int activeNetworkType = getActiveNetworkType(context);
        if (activeNetworkType != -1) {
            if (activeNetworkType != 10) {
                if (activeNetworkType != 2) {
                    if (activeNetworkType != 3) {
                        if (activeNetworkType != 4) {
                            if (activeNetworkType != 5) {
                                if (activeNetworkType != 6) {
                                    return "unknown";
                                }
                                return "mobile_5g";
                            }
                            return "mobile_4g";
                        }
                        return "mobile_3g";
                    }
                    return "mobile_2g";
                }
                return "mobile_unknown";
            }
            return "wifi";
        }
        return "none";
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || NetworkMonitor.getType(activeNetworkInfo) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = getActiveNetworkInfo(context)) == null || NetworkMonitor.getType(activeNetworkInfo) != 1) {
            return false;
        }
        return true;
    }
}
