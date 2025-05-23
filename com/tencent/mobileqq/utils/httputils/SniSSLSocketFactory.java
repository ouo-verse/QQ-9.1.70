package com.tencent.mobileqq.utils.httputils;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SniSSLSocketFactory extends SSLSocketFactory {
    private static final String TAG = "SniSSLSocketFactory";
    private HttpsURLConnection conn;
    HostnameVerifier mHostnameVerifier;
    private String mReqHost;

    public SniSSLSocketFactory(String str, HostnameVerifier hostnameVerifier) {
        this.mReqHost = str;
        this.mHostnameVerifier = hostnameVerifier;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    @TargetApi(17)
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        InetAddress inetAddress = socket.getInetAddress();
        if (z16) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i3);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLCertificateSocketFactory.setHostname(sSLSocket, this.mReqHost);
        SSLSession session = sSLSocket.getSession();
        if (this.mHostnameVerifier == null) {
            this.mHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        }
        if (this.mHostnameVerifier.verify(this.mReqHost, session)) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + this.mReqHost);
    }
}
