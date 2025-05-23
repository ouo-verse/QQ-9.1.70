package com.tencent.turingfd.sdk.xq;

import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Sapodilla extends SSLSocketFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f383060a;

    /* renamed from: b, reason: collision with root package name */
    public final String f383061b;

    public Sapodilla(HttpsURLConnection httpsURLConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) httpsURLConnection);
        } else {
            this.f383060a = httpsURLConnection.getSSLSocketFactory();
            this.f383061b = httpsURLConnection.getRequestProperty("Host");
        }
    }

    public final Socket a(Socket socket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Socket) iPatchRedirector.redirect((short) 10, (Object) this, (Object) socket);
        }
        if (!(socket instanceof SSLSocket)) {
            return socket;
        }
        if (this.f383061b == null) {
            return socket;
        }
        ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0)).setHostname((SSLSocket) socket, this.f383061b);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Socket) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        if (sSLSocketFactory == null) {
            return null;
        }
        return sSLSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        if (sSLSocketFactory == null) {
            return null;
        }
        return sSLSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Socket) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket(str, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Socket) iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16));
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket(str, i3, inetAddress, i16));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Socket) iPatchRedirector.redirect((short) 5, (Object) this, (Object) inetAddress, i3);
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket(inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Socket) iPatchRedirector.redirect((short) 6, this, inetAddress, Integer.valueOf(i3), inetAddress2, Integer.valueOf(i16));
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket(inetAddress, i3, inetAddress2, i16));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Socket) iPatchRedirector.redirect((short) 9, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        SSLSocketFactory sSLSocketFactory = this.f383060a;
        return a(sSLSocketFactory == null ? null : sSLSocketFactory.createSocket(socket, str, i3, z16));
    }
}
