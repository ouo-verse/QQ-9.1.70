package org.apache.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpInetConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class SocketHttpServerConnection extends AbstractHttpServerConnection implements HttpInetConnection {
    public SocketHttpServerConnection() {
        throw new RuntimeException("Stub!");
    }

    protected void assertNotOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.impl.AbstractHttpServerConnection
    protected void assertOpen() {
        throw new RuntimeException("Stub!");
    }

    protected void bind(Socket socket, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void close() throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected SessionInputBuffer createHttpDataReceiver(Socket socket, int i3, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    protected SessionOutputBuffer createHttpDataTransmitter(Socket socket, int i3, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getLocalAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getLocalPort() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public InetAddress getRemoteAddress() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpInetConnection
    public int getRemotePort() {
        throw new RuntimeException("Stub!");
    }

    protected Socket getSocket() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public int getSocketTimeout() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public boolean isOpen() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void setSocketTimeout(int i3) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnection
    public void shutdown() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
