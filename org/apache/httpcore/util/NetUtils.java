package org.apache.httpcore.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NetUtils {
    public static void formatAddress(StringBuilder sb5, SocketAddress socketAddress) {
        Args.notNull(sb5, "Buffer");
        Args.notNull(socketAddress, "Socket address");
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            String str = address;
            if (address != null) {
                str = address.getHostAddress();
            }
            sb5.append((Object) str);
            sb5.append(':');
            sb5.append(inetSocketAddress.getPort());
            return;
        }
        sb5.append(socketAddress);
    }
}
