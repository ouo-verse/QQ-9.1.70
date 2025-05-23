package com.tencent.upgrade.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.upgrade.core.j;

/* compiled from: P */
/* loaded from: classes27.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003f, code lost:
    
        if (r0.equalsIgnoreCase("CDMA2000") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(NetworkInfo networkInfo) {
        String subtypeName = networkInfo.getSubtypeName();
        Log.e("NetworkTypeUtil", "Network getSubtypeName : " + subtypeName);
        int subtype = NetworkMonitor.getSubtype(networkInfo);
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                subtypeName = "2";
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
                subtypeName = "3";
                break;
            case 13:
                subtypeName = "4";
                break;
            default:
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA")) {
                    if (!subtypeName.equalsIgnoreCase("WCDMA")) {
                        break;
                    }
                }
                subtypeName = "3";
                break;
        }
        Log.e("NetworkTypeUtil", "Network getSubtype : " + Integer.valueOf(subtype).toString());
        return subtypeName;
    }

    public static String b() {
        NetworkInfo networkInfo;
        String str;
        try {
            networkInfo = ((ConnectivityManager) j.l().i().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e16) {
            d.c("NetworkTypeUtil", "getNetworkType exception" + e16.getMessage());
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            if (NetworkMonitor.getType(networkInfo) == 1) {
                return "1";
            }
            if (NetworkMonitor.getType(networkInfo) == 0) {
                str = a(networkInfo);
            } else {
                str = "";
            }
            Log.e("NetworkTypeUtil", "Network Type : " + str);
            return str;
        }
        return "0";
    }
}
