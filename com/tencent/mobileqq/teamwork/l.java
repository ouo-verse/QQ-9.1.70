package com.tencent.mobileqq.teamwork;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes18.dex */
public class l extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f292146a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends SSLSocket {

        /* renamed from: d, reason: collision with root package name */
        protected final SSLSocket f292147d;

        b(SSLSocket sSLSocket) {
            this.f292147d = sSLSocket;
        }

        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f292147d.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // java.net.Socket
        public void bind(SocketAddress socketAddress) throws IOException {
            this.f292147d.bind(socketAddress);
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f292147d.close();
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress) throws IOException {
            this.f292147d.connect(socketAddress);
        }

        public boolean equals(Object obj) {
            return this.f292147d.equals(obj);
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            return this.f292147d.getChannel();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            return this.f292147d.getEnableSessionCreation();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            return this.f292147d.getEnabledCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            return this.f292147d.getEnabledProtocols();
        }

        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            return this.f292147d.getInetAddress();
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return this.f292147d.getInputStream();
        }

        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            return this.f292147d.getKeepAlive();
        }

        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            return this.f292147d.getLocalAddress();
        }

        @Override // java.net.Socket
        public int getLocalPort() {
            return this.f292147d.getLocalPort();
        }

        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            return this.f292147d.getLocalSocketAddress();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            return this.f292147d.getNeedClientAuth();
        }

        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            return this.f292147d.getOOBInline();
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return this.f292147d.getOutputStream();
        }

        @Override // java.net.Socket
        public int getPort() {
            return this.f292147d.getPort();
        }

        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.f292147d.getReceiveBufferSize();
        }

        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            return this.f292147d.getRemoteSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            return this.f292147d.getReuseAddress();
        }

        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            return this.f292147d.getSendBufferSize();
        }

        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            return this.f292147d.getSession();
        }

        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            return this.f292147d.getSoLinger();
        }

        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            return this.f292147d.getSoTimeout();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            return this.f292147d.getSupportedCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            return this.f292147d.getSupportedProtocols();
        }

        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            return this.f292147d.getTcpNoDelay();
        }

        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            return this.f292147d.getTrafficClass();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            return this.f292147d.getUseClientMode();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            return this.f292147d.getWantClientAuth();
        }

        @Override // java.net.Socket
        public boolean isBound() {
            return this.f292147d.isBound();
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            return this.f292147d.isClosed();
        }

        @Override // java.net.Socket
        public boolean isConnected() {
            return this.f292147d.isConnected();
        }

        @Override // java.net.Socket
        public boolean isInputShutdown() {
            return this.f292147d.isInputShutdown();
        }

        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            return this.f292147d.isOutputShutdown();
        }

        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f292147d.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // java.net.Socket
        public void sendUrgentData(int i3) throws IOException {
            this.f292147d.sendUrgentData(i3);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean z16) {
            this.f292147d.setEnableSessionCreation(z16);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] strArr) {
            this.f292147d.setEnabledCipherSuites(strArr);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            this.f292147d.setEnabledProtocols(strArr);
        }

        @Override // java.net.Socket
        public void setKeepAlive(boolean z16) throws SocketException {
            this.f292147d.setKeepAlive(z16);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean z16) {
            this.f292147d.setNeedClientAuth(z16);
        }

        @Override // java.net.Socket
        public void setOOBInline(boolean z16) throws SocketException {
            this.f292147d.setOOBInline(z16);
        }

        @Override // java.net.Socket
        public void setPerformancePreferences(int i3, int i16, int i17) {
            this.f292147d.setPerformancePreferences(i3, i16, i17);
        }

        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int i3) throws SocketException {
            this.f292147d.setReceiveBufferSize(i3);
        }

        @Override // java.net.Socket
        public void setReuseAddress(boolean z16) throws SocketException {
            this.f292147d.setReuseAddress(z16);
        }

        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int i3) throws SocketException {
            this.f292147d.setSendBufferSize(i3);
        }

        @Override // java.net.Socket
        public void setSoLinger(boolean z16, int i3) throws SocketException {
            this.f292147d.setSoLinger(z16, i3);
        }

        @Override // java.net.Socket
        public synchronized void setSoTimeout(int i3) throws SocketException {
            this.f292147d.setSoTimeout(i3);
        }

        @Override // java.net.Socket
        public void setTcpNoDelay(boolean z16) throws SocketException {
            this.f292147d.setTcpNoDelay(z16);
        }

        @Override // java.net.Socket
        public void setTrafficClass(int i3) throws SocketException {
            this.f292147d.setTrafficClass(i3);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean z16) {
            this.f292147d.setUseClientMode(z16);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean z16) {
            this.f292147d.setWantClientAuth(z16);
        }

        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            this.f292147d.shutdownInput();
        }

        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            this.f292147d.shutdownOutput();
        }

        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            this.f292147d.startHandshake();
        }

        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            return this.f292147d.toString();
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress, int i3) throws IOException {
            this.f292147d.connect(socketAddress, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c extends b {
        @Override // com.tencent.mobileqq.teamwork.l.b, javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f292147d.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                    QLog.i("setEnabledProtocols", 1, "Removed SSLv3 from enabled protocols");
                } else {
                    QLog.i("setEnabledProtocols", 1, "SSL stuck with protocol available for " + String.valueOf(arrayList));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (strArr != null) {
                super.setEnabledProtocols(strArr);
            }
        }

        c(SSLSocket sSLSocket) {
            super(sSLSocket);
        }
    }

    public l(SSLSocketFactory sSLSocketFactory) {
        this.f292146a = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            c cVar = new c((SSLSocket) socket);
            cVar.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
            return cVar;
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        return a(this.f292146a.createSocket(socket, str, i3, z16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f292146a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f292146a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        return a(this.f292146a.createSocket(str, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException {
        return a(this.f292146a.createSocket(str, i3, inetAddress, i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return a(this.f292146a.createSocket(inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return a(this.f292146a.createSocket(inetAddress, i3, inetAddress2, i16));
    }
}
