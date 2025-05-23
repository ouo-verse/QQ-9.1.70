package com.tencent.luggage.wxa.t9;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {
    public static int a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.tencent.luggage.wxa.tn.z.c().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return 1;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 7:
            case 11:
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
            case 12:
            case 17:
                return 3;
            case 8:
            case 9:
            case 10:
            case 16:
            default:
                if (subtype < 20) {
                    return 0;
                }
                return 5;
            case 13:
            case 14:
            case 15:
                return 4;
        }
    }
}
