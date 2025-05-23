package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Cherry {
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
        List<WifiConfiguration> list;
        if (!TextUtils.isEmpty(System.getProperty("http.proxyHost")) && !TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            return true;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (Bryony.a(context, "android.permission.ACCESS_WIFI_STATE") != 0) {
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
                if (list != null) {
                    int networkId = connectionInfo.getNetworkId();
                    Iterator<WifiConfiguration> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WifiConfiguration next = it.next();
                        if (next.networkId == networkId) {
                            try {
                                Method a16 = Coconut.a((Class<?>) WifiConfiguration.class, "getProxySettings", (Class<?>[]) new Class[0]);
                                if (a16 != null) {
                                    obj = a16.invoke(next, new Object[0]);
                                }
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                            Object a17 = Coconut.a("android.net.IpConfiguration$ProxySettings", "STATIC");
                            if (a17 != null && a17 == obj) {
                                return true;
                            }
                            Object a18 = Coconut.a("android.net.IpConfiguration$ProxySettings", "PAC");
                            if (a18 == null || a18 != obj) {
                                break;
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
