package com.tenpay.sdk.download;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExtTlsFactory extends SSLSocketFactory {
    private static final String[] TLS_SUPPORT_VERSION = {"TLSv1", "TLSv1.1", "TLSv1.2"};
    private static ExtTlsFactory instance = null;
    final SSLSocketFactory delegate;

    public ExtTlsFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    public static ExtTlsFactory getInstance(SSLSocketFactory sSLSocketFactory) {
        if (instance == null) {
            instance = new ExtTlsFactory(sSLSocketFactory);
        }
        return instance;
    }

    private Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_SUPPORT_VERSION);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        return patch(this.delegate.createSocket(socket, str, i3, z16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        return patch(this.delegate.createSocket(str, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException {
        return patch(this.delegate.createSocket(str, i3, inetAddress, i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i3, inetAddress2, i16));
    }
}
