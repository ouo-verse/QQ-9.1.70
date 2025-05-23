package com.tencent.tfd.sdk.wxa;

import com.tencent.component.network.module.common.dns.DnsConstants;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.util.Enumeration;
import java.util.List;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.interface, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cinterface {
    /* JADX WARN: Removed duplicated region for block: B:63:0x0098 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a() {
        boolean z16;
        boolean z17;
        List<InterfaceAddress> interfaceAddresses;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            boolean z18 = false;
            boolean z19 = false;
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp() && (interfaceAddresses = NetworkMonitor.getInterfaceAddresses(nextElement)) != null && interfaceAddresses.size() != 0) {
                    nextElement.getDisplayName();
                    for (int i3 = 0; i3 < interfaceAddresses.size(); i3++) {
                        InetAddress address = interfaceAddresses.get(i3).getAddress();
                        if (!address.isLoopbackAddress()) {
                            if (address instanceof Inet4Address) {
                                z18 = true;
                            } else if ((address instanceof Inet6Address) && !address.isAnyLocalAddress() && !address.isLoopbackAddress() && !address.isLinkLocalAddress()) {
                                z19 = true;
                            }
                        }
                    }
                }
            }
            if (!(z18 && z19) && (z18 || z19)) {
                if (!z18) {
                    return z19 ? 2 : 0;
                }
                return 1;
            }
            try {
                z16 = a(InetAddress.getByName(DnsConstants.DNS_SERVER_ADDRESS_8));
            } catch (Throwable unused) {
                z16 = false;
            }
            try {
                z17 = a(InetAddress.getByName("2000::0"));
            } catch (Throwable unused2) {
                z17 = false;
            }
            if (z16 && z17) {
                return 3;
            }
            if (!z16) {
                if (!z17) {
                    return 0;
                }
            }
            return 1;
        } catch (Throwable unused3) {
            return 0;
        }
    }

    public static boolean a(InetAddress inetAddress) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            datagramSocket.send(new DatagramPacket(new byte[0], 0, inetAddress, 65535));
            datagramSocket.close();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
