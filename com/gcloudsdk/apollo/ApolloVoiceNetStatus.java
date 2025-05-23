package com.gcloudsdk.apollo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceNetStatus {
    private static String UNKNOWN = "Unknown";
    private static Context mainContext;

    public static String Net() {
        String str = UNKNOWN;
        Context context = mainContext;
        if (context == null) {
            ApolloVoiceLog.LogE("mainContext is null. May init java first");
            return str;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return UNKNOWN;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = UNKNOWN;
        } else if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            str = "WiFi";
        } else if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
            int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
            if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 1) {
                if (subtype != 3 && subtype != 8 && subtype != 6 && subtype != 5 && subtype != 12) {
                    if (subtype == 13) {
                        str = "4G";
                    }
                } else {
                    str = "3G";
                }
            } else {
                str = "2G";
            }
        }
        ApolloVoiceLog.LogI("Android Java Get Net status: " + str);
        return str;
    }

    public static void SetContext(Context context) {
        mainContext = context;
    }
}
