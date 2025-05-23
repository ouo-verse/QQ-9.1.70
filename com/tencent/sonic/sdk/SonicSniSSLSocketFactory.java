package com.tencent.sonic.sdk;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes25.dex */
class SonicSniSSLSocketFactory extends SSLSocketFactory {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "sonic_SonicSniSSLSocketFactory";
    private final SSLCertificateSocketFactory sslSocketFactory;
    private final String targetHostName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SonicSniSSLSocketFactory(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        } else {
            this.targetHostName = str;
            this.sslSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0, new SSLSessionCache(context));
        }
    }

    public static void verifyHostname(Socket socket, String str) throws IOException {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            if (session != null) {
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
                    return;
                }
                SonicUtils.log(TAG, 6, "sonic SSL error:Cannot verify hostname" + str + ")!");
                throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
            }
            throw new SSLException("Cannot verify SSL socket without session");
        }
        throw new IllegalArgumentException("Attempt to verify non-SSL socket");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.sslSocketFactory.createSocket(socket, this.targetHostName, i3, z16) : (Socket) iPatchRedirector.redirect((short) 4, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sslSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.sslSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Socket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        Socket createSocket = createSocket();
        createSocket.connect(new InetSocketAddress(str, i3));
        verifyHostname(createSocket, this.targetHostName);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.sslSocketFactory.createSocket() : (Socket) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Socket) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
        }
        Socket createSocket = createSocket();
        createSocket.bind(new InetSocketAddress(inetAddress, i16));
        createSocket.connect(new InetSocketAddress(str, i3));
        verifyHostname(createSocket, this.targetHostName);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.sslSocketFactory.createSocket(inetAddress, i3) : (Socket) iPatchRedirector.redirect((short) 8, (Object) this, (Object) inetAddress, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.sslSocketFactory.createSocket(inetAddress, i3, inetAddress2, i16) : (Socket) iPatchRedirector.redirect((short) 9, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
    }
}
