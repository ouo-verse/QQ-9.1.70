package org.apache.http;

import java.net.InetAddress;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpInetConnection extends HttpConnection {
    InetAddress getLocalAddress();

    int getLocalPort();

    InetAddress getRemoteAddress();

    int getRemotePort();
}
