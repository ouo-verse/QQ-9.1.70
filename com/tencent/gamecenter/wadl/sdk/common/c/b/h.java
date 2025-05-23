package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private String f107117a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f107118b = false;

    public h(String str) {
        this.f107117a = str;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return null;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f107117a) || !(obj instanceof h)) {
            return false;
        }
        String str = ((h) obj).f107117a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f107117a.equals(str);
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
    public Socket createSocket(String str, int i3) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) {
        if (TextUtils.isEmpty(this.f107117a)) {
            throw new IOException("set empty bizHost");
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("SNISocketFactory", "customized createSocket. host: " + this.f107117a);
        try {
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(com.tencent.gamecenter.wadl.sdk.common.a.b()));
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.f107117a, i3, z16);
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, true);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.f107117a);
            sSLSocket.startHandshake();
            return sSLSocket;
        } catch (Throwable th5) {
            this.f107118b = true;
            if (th5 instanceof IOException) {
                throw th5;
            }
            throw new IOException("HalleySNI exception: " + th5);
        }
    }
}
