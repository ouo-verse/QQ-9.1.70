package com.tencent.mobileqq.msf.core.net.patch;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes15.dex */
public class b implements LayeredSocketFactory {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f248919c = "SNISocketFactory";

    /* renamed from: d, reason: collision with root package name */
    static final HostnameVerifier f248920d;

    /* renamed from: a, reason: collision with root package name */
    private String f248921a;

    /* renamed from: b, reason: collision with root package name */
    SSLCertificateSocketFactory f248922b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17774);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f248920d = new StrictHostnameVerifier();
        }
    }

    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f248922b = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(0, null);
            this.f248921a = str;
        }
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i3, InetAddress inetAddress, int i16, HttpParams httpParams) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Socket) iPatchRedirector.redirect((short) 3, this, socket, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16), httpParams);
        }
        socket.connect(new InetSocketAddress(str, i3));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new Socket() : (Socket) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) socket)).booleanValue();
        }
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Socket) iPatchRedirector.redirect((short) 6, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.i(f248919c, 2, "createSocket " + socket.toString() + " host:" + str + " port:" + i3 + " autoClose:" + z16);
        }
        SSLSocket sSLSocket = (SSLSocket) this.f248922b.createSocket(socket, str, i3, z16);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (QLog.isColorLevel()) {
            QLog.i(f248919c, 2, "Setting SNI hostname");
        }
        this.f248922b.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (f248920d.verify(str, session)) {
            if (QLog.isColorLevel()) {
                QLog.i(f248919c, 2, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
            }
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
