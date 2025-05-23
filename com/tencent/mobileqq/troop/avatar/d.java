package com.tencent.mobileqq.troop.avatar;

import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.cert.X509Certificate;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends SSLSocketFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f294543a;

    /* renamed from: b, reason: collision with root package name */
    HostnameVerifier f294544b;

    /* renamed from: c, reason: collision with root package name */
    private HttpsURLConnection f294545c;

    public d(HttpsURLConnection httpsURLConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) httpsURLConnection);
            return;
        }
        this.f294543a = d.class.getSimpleName();
        this.f294544b = HttpsURLConnection.getDefaultHostnameVerifier();
        this.f294545c = httpsURLConnection;
    }

    private void a(SSLSession sSLSession) {
        try {
            QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,PeerCertificates ---------------------");
            Certificate[] peerCertificates = sSLSession.getPeerCertificates();
            if (peerCertificates != null) {
                for (Certificate certificate : peerCertificates) {
                    QLog.e("httpsSSLProcess,HostnameVerifier", 1, certificate.toString());
                }
            }
            QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,LocalCertificates ---------------------");
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            if (localCertificates != null) {
                for (Certificate certificate2 : localCertificates) {
                    QLog.e("httpsSSLProcess,HostnameVerifier", 1, certificate2.toString());
                }
            }
            QLog.e("httpsSSLProcess,HostnameVerifier", 1, "httpsSSLProcess,PeerCertificateChain ---------------------");
            X509Certificate[] peerCertificateChain = sSLSession.getPeerCertificateChain();
            if (peerCertificateChain != null) {
                for (X509Certificate x509Certificate : peerCertificateChain) {
                    QLog.e("httpsSSLProcess,HostnameVerifier", 1, x509Certificate.toString());
                }
            }
            QLog.e("httpsSSLProcess,HostnameVerifier", 1, "--------------------- end ---------------------");
        } catch (SSLPeerUnverifiedException e16) {
            e16.printStackTrace();
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inetAddress, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 6, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Socket) iPatchRedirector.redirect((short) 9, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        String requestProperty = this.f294545c.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f294543a, 2, "customized createSocket. host: " + str);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z16) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i3);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (QLog.isColorLevel()) {
            QLog.d(this.f294543a, 2, "Setting SNI hostname");
        }
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (!this.f294544b.verify(str, session)) {
            if (session == null) {
                QLog.e("httpsSSLProcess,HostnameVerifier", 1, "!!!session null!!!");
            } else {
                a(session);
            }
            sSLSocket.close();
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f294543a, 2, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
        }
        return sSLSocket;
    }
}
