package com.tencent.turingcam;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class yMdp8 {
    public static boolean a(Context context) {
        List<WifiConfiguration> list;
        if (!TextUtils.isEmpty(System.getProperty("http.proxyHost")) && !TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            return true;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (d5HOq.a(context, "android.permission.ACCESS_WIFI_STATE") != 0) {
            return false;
        }
        try {
            WifiInfo connectionInfo = LocationMonitor.getConnectionInfo(wifiManager);
            if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
                Object obj = null;
                try {
                    list = NetworkMonitor.getConfigureNetworks(wifiManager);
                } catch (Throwable unused) {
                    list = null;
                }
                if (list == null) {
                    return false;
                }
                int networkId = connectionInfo.getNetworkId();
                Iterator<WifiConfiguration> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (next.networkId == networkId) {
                        try {
                            Method a16 = rBDKv.a((Class<?>) WifiConfiguration.class, "getProxySettings", (Class<?>[]) new Class[0]);
                            if (a16 != null) {
                                obj = a16.invoke(next, new Object[0]);
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        Object a17 = rBDKv.a("android.net.IpConfiguration$ProxySettings", "STATIC");
                        if (a17 != null && a17 == obj) {
                            return true;
                        }
                        Object a18 = rBDKv.a("android.net.IpConfiguration$ProxySettings", "PAC");
                        if (a18 == null || a18 != obj) {
                            break;
                        }
                        return true;
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
