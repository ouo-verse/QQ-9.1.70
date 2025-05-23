package com.tencent.luggage.wxa.h6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.luggage.wxa.t9.u;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {
    public static String a() {
        int i3;
        try {
            i3 = u.a();
        } catch (Exception e16) {
            w.b("Luggage.LuggageNetUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e16);
            i3 = 0;
        }
        if (i3 == 0) {
            return "127.0.0.1";
        }
        if (i3 == 1) {
            return b();
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                            return w0.c(nextElement2.getHostAddress()) ? "127.0.0.1" : nextElement2.getHostAddress();
                        }
                    }
                }
            }
            return "127.0.0.1";
        } catch (Exception unused) {
            return "127.0.0.1";
        }
    }

    public static String b() {
        int f16 = com.tencent.luggage.wxa.tn.j.f141599a.f();
        if (f16 == 0) {
            return "127.0.0.1";
        }
        return String.format("%d.%d.%d.%d", Integer.valueOf(f16 & 255), Integer.valueOf((f16 >> 8) & 255), Integer.valueOf((f16 >> 16) & 255), Integer.valueOf((f16 >> 24) & 255));
    }

    public static boolean a(Context context) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isConnected();
    }
}
