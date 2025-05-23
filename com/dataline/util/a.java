package com.dataline.util;

import android.annotation.TargetApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {
    public static String a(boolean z16) {
        if (NetConnInfoCenter.getActiveNetIpFamily(true) == 2) {
            return b(z16, true);
        }
        return b(z16, false);
    }

    private static String b(boolean z16, boolean z17) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null && (!z16 || (nextElement.getName() != null && nextElement.getName().contains("wlan")))) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && !nextElement2.isLoopbackAddress() && !nextElement2.isAnyLocalAddress() && !nextElement2.isLinkLocalAddress()) {
                            if (z17) {
                                if (nextElement2 instanceof Inet6Address) {
                                    return nextElement2.getHostAddress();
                                }
                            } else if (nextElement2 instanceof Inet4Address) {
                                return nextElement2.getHostAddress();
                            }
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    @TargetApi(11)
    @Deprecated
    public static String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().contains("wlan")) {
                    Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(nextElement);
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress() && nextElement2.getAddress().length == 4) {
                            return nextElement2.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
