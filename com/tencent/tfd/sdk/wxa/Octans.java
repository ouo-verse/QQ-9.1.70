package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Octans {
    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && NetworkMonitor.getInterfaceAddresses(networkInterface).size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            Virgo.a();
            if (TextUtils.isEmpty(System.getProperty("http.proxyHost"))) {
                return false;
            }
            return !TextUtils.equals(System.getProperty("http.proxyPort"), "-1");
        } catch (Throwable unused) {
            return false;
        }
    }
}
