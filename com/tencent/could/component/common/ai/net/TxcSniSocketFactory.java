package com.tencent.could.component.common.ai.net;

import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TxcSniSocketFactory extends SSLSocketFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public HostnameVerifier f100018a;

    /* renamed from: b, reason: collision with root package name */
    public HttpsURLConnection f100019b;

    public TxcSniSocketFactory(HttpsURLConnection httpsURLConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) httpsURLConnection);
        } else {
            this.f100018a = HttpsURLConnection.getDefaultHostnameVerifier();
            this.f100019b = httpsURLConnection;
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
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
    public Socket createSocket(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inetAddress, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return null;
        }
        return (Socket) iPatchRedirector.redirect((short) 6, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Socket) iPatchRedirector.redirect((short) 9, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        String requestProperty = this.f100019b.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        TxNetWorkHelper.getInstance().logError("TxcSniSocketFactory", "customized peerHost host: " + str);
        InetAddress inetAddress = socket.getInetAddress();
        if (z16) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i3);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        HostnameVerifier hostnameVerifier = this.f100019b.getHostnameVerifier();
        if (hostnameVerifier == null) {
            TxNetWorkHelper.getInstance().logError("TxcSniSocketFactory", "current verifier is null, use default verifier.");
            hostnameVerifier = this.f100018a;
        }
        if (hostnameVerifier.verify(str, session)) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
