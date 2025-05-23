package com.tencent.rfix.loader.tls;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Tls12SocketFactory extends SSLSocketFactory {
    private static final String TAG = "RFix.Tls12SocketFactory";
    private static final String[] TLS_V12_ONLY = {"TLSv1.2"};
    private final SSLSocketFactory delegate;

    public Tls12SocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    private Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_V12_ONLY);
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
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        return patch(this.delegate.createSocket(str, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
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

    public static void enableTls12OnPreKitkat(HttpURLConnection httpURLConnection) {
    }
}
