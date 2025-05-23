package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GalacticCore {
    public static int a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return 0;
                }
                if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                    if (Proxy.getDefaultHost() == null) {
                        if (Proxy.getHost(context) == null) {
                            return 1;
                        }
                        return 2;
                    }
                    return 2;
                }
            }
            return -1;
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                return -2;
            }
            return -3;
        }
    }

    public static boolean b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                return true;
            }
            return false;
        }
    }
}
