package org.apache.http.conn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes29.dex */
public final class MultihomePlainSocketFactory implements SocketFactory {
    MultihomePlainSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    public static MultihomePlainSocketFactory getSocketFactory() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i3, InetAddress inetAddress, int i16, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object obj) {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        throw new RuntimeException("Stub!");
    }
}
