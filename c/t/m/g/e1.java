package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public class e1 {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum a {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public static a a() {
        return a(o0.a());
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static a a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) l1.a("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return connectivityManager.isActiveNetworkMetered() ? a.NETWORK_MOBILE : a.NETWORK_WIFI;
            }
            return a.NETWORK_NONE;
        } catch (Throwable unused) {
            return a.NETWORK_NONE;
        }
    }
}
