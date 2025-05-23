package com.tencent.mobileqq.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: P */
/* loaded from: classes20.dex */
public class av {
    public static String a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                    try {
                        Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
                        while (networkInterfaces.hasMoreElements()) {
                            Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                            while (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement = inetAddresses.nextElement();
                                if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                                    return nextElement.getHostAddress();
                                }
                            }
                        }
                        return null;
                    } catch (SocketException e16) {
                        e16.printStackTrace();
                        return null;
                    }
                }
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return c(NetworkMonitor.getIpAddress(LocationMonitor.getConnectionInfo((WifiManager) context.getSystemService("wifi"))));
                }
                if (NetworkMonitor.getType(activeNetworkInfo) == 9) {
                    return b();
                }
                return null;
            }
            return null;
        } catch (Exception e17) {
            QLog.d("IPUtils", 1, e17.getMessage());
            return null;
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (SocketException unused) {
            return "0.0.0.0";
        }
    }

    public static String c(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }
}
