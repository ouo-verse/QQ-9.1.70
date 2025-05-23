package com.tencent.gamecenter.common.util;

import com.tencent.open.appcommon.Common;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends Common {

    /* renamed from: b, reason: collision with root package name */
    private static final String f106556b = Common.q();

    public static String I() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String J() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(f106556b);
        String str = File.separator;
        sb5.append(str);
        sb5.append(".GameCenterWebBuffer");
        sb5.append(str);
        sb5.append("Images/games");
        return sb5.toString();
    }
}
