package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class r0 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(int i3, String str) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return str;
                }
                break;
        }
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            v.f("hmsSdk", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return Global.TRACKING_WIFI;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            v.c("hmsSdk", "Network getSubtypeName : " + subtypeName);
            return a(NetworkMonitor.getSubtype(activeNetworkInfo), subtypeName);
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 16) {
            v.f("hmsSdk", "type name = COMPANION_PROXY");
            return "COMPANION_PROXY";
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 9) {
            v.c("hmsSdk", "type name = ETHERNET");
            return "ETHERNET";
        }
        v.c("hmsSdk", "type name = " + NetworkMonitor.getType(activeNetworkInfo));
        return "OTHER_NETWORK_TYPE";
    }
}
