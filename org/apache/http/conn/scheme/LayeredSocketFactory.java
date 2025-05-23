package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface LayeredSocketFactory extends SocketFactory {
    Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException, UnknownHostException;
}
