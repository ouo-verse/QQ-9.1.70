package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

/* compiled from: P */
/* loaded from: classes.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static d0 f29852a;

    public static d0 a() {
        return a(o0.a());
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static d0 a(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) o0.a().getApplicationContext().getSystemService("wifi");
            ConnectivityManager connectivityManager = context == null ? null : (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager != null && connectivityManager != null) {
                d0 d0Var = f29852a;
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (d0Var != null && networkInfo != null && networkInfo.isConnected()) {
                    d0Var.a();
                    throw null;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
