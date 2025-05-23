package com.tencent.luggage.wxa.nd;

import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f135681a = "i";

    /* renamed from: b, reason: collision with root package name */
    public static List f135682b = new ArrayList();

    public static void a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return;
            }
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                Iterator it5 = Collections.list(NetworkMonitor.getInetAddresses(networkInterface)).iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    } else if (((InetAddress) it5.next()).getHostAddress().startsWith("192.168")) {
                        f135682b.add(networkInterface);
                        break;
                    }
                }
            }
        } catch (SocketException e16) {
            e16.printStackTrace();
        }
    }

    public static String b() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address)) {
                            String hostAddress = nextElement.getHostAddress();
                            if (!"127.0.0.1".equals(hostAddress)) {
                                str = hostAddress;
                                break;
                            }
                        }
                    }
                }
            }
        } catch (SocketException e16) {
            Log.e(f135681a, "can not get host ip : " + e16.getCause());
            e16.printStackTrace();
        }
        return str;
    }

    public static List c() {
        f135682b.clear();
        a();
        return f135682b;
    }

    public static String a(String str, int i3, String str2) {
        if (str2.startsWith("/")) {
            return "http://" + str + ":" + i3 + str2;
        }
        return "http://" + str + ":" + i3 + "/" + str2;
    }
}
