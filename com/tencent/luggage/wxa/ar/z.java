package com.tencent.luggage.wxa.ar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class z {
    public static int a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
            return 1;
        }
        if (NetworkMonitor.getSubtype(activeNetworkInfo) >= 13) {
            return 3;
        }
        return (NetworkMonitor.getSubtype(activeNetworkInfo) < 5 || NetworkMonitor.getSubtype(activeNetworkInfo) >= 13) ? 4 : 2;
    }

    public static boolean b() {
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        if (applicationContext == null) {
            x0.f(NetworkUtil.TAG, "context is null");
            return false;
        }
        if (a(applicationContext) != 1) {
            return false;
        }
        return true;
    }

    public static boolean a() {
        Context applicationContext = XWalkEnvironment.getApplicationContext();
        if (applicationContext == null) {
            x0.f(NetworkUtil.TAG, "context is null");
            return false;
        }
        if (a(applicationContext) != 0) {
            return true;
        }
        x0.f(NetworkUtil.TAG, RaffleJsPlugin.ERROR_REPORT_NO_NETWORK);
        return false;
    }
}
