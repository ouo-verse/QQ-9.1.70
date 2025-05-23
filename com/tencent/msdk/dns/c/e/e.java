package com.tencent.msdk.dns.c.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class e {
    private static int a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return 0;
        }
        switch (NetworkMonitor.getSubtype(networkInfo)) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
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
            case 17:
                return 2;
            case 13:
            default:
                return 3;
        }
    }

    public static String b(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "unknown";
                        }
                        return "ethernet";
                    }
                    return "wifi";
                }
                return "4G";
            }
            return "3G";
        }
        return "2G";
    }

    public static String c(Context context) {
        return b(d(context));
    }

    public static int d(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 0;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            int type = NetworkMonitor.getType(activeNetworkInfo);
            if (type != 0) {
                if (type != 1) {
                    if (type != 9) {
                        return 0;
                    }
                    return 5;
                }
                return 4;
            }
            return a(activeNetworkInfo);
        } catch (Exception unused) {
            return 0;
        }
    }
}
