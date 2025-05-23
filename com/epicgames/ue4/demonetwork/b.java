package com.epicgames.ue4.demonetwork;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RequiresPermission;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    private static NetworkInfo a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static NetworkType b(Context context) {
        NetworkType networkType;
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        NetworkInfo a16 = a(context);
        if (a16 != null && a16.isAvailable()) {
            if (NetworkMonitor.getType(a16) == 1) {
                return NetworkType.NETWORK_WIFI;
            }
            if (NetworkMonitor.getType(a16) == 0) {
                switch (NetworkMonitor.getSubtype(a16)) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        networkType = NetworkType.NETWORK_2G;
                        break;
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
                        networkType = NetworkType.NETWORK_3G;
                        break;
                    case 13:
                    case 18:
                        networkType = NetworkType.NETWORK_4G;
                        break;
                    default:
                        String subtypeName = a16.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            networkType = NetworkType.NETWORK_UNKNOWN;
                            break;
                        } else {
                            networkType = NetworkType.NETWORK_3G;
                            break;
                        }
                        break;
                }
                return networkType;
            }
            return NetworkType.NETWORK_UNKNOWN;
        }
        return networkType2;
    }
}
