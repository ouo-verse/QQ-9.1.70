package org.apache.http.conn.scheme;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface SocketFactory {
    Socket connectSocket(Socket socket, String str, int i3, InetAddress inetAddress, int i16, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException;

    Socket createSocket() throws IOException;

    boolean isSecure(Socket socket) throws IllegalArgumentException;
}
