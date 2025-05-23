package com.tencent.mobileqq.transfile;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UtilApi;
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
/* loaded from: classes19.dex */
public class TlsSniSocketFactory implements LayeredSocketFactory {
    static IPatchRedirector $redirector_ = null;
    static final HostnameVerifier HOSTNAME_VERIFIER;
    private static final int REFLECT_FAILED = 30;
    private static final String TAG = "SNISocketFactory";
    private static final int USE_REFLECT_SET_HOST = 20;
    private static final int USE_SSL_SOCKET = 10;
    private static final int VERIFIY_EXCEPTION = 4;
    private String mBusiness;
    SSLCertificateSocketFactory sslSocketFactory;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            HOSTNAME_VERIFIER = new StrictHostnameVerifier();
        }
    }

    public TlsSniSocketFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.sslSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(0, null);
            this.mBusiness = str;
        }
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i3, InetAddress inetAddress, int i16, HttpParams httpParams) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Socket) iPatchRedirector.redirect((short) 2, this, socket, str, Integer.valueOf(i3), inetAddress, Integer.valueOf(i16), httpParams);
        }
        socket.connect(new InetSocketAddress(str, i3));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new Socket() : (Socket) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) socket)).booleanValue();
        }
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Socket) iPatchRedirector.redirect((short) 5, this, socket, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "createSocket " + socket.toString() + " host:" + str + " port:" + i3 + " autoClose:" + z16);
        }
        SSLSocket sSLSocket = (SSLSocket) this.sslSocketFactory.createSocket(socket, str, i3, z16);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Setting SNI hostname");
        }
        this.sslSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (HOSTNAME_VERIFIER.verify(str, session)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
            }
            UtilApi.util.reportHttpsSniMethod(10, str, i3, this.mBusiness);
            return sSLSocket;
        }
        UtilApi.util.reportHttpsSniMethod(10 + 4, str, i3, this.mBusiness);
        sSLSocket.close();
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
