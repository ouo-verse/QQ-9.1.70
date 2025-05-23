package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f37866i = "SSFCompatiableSystemCA";

    /* renamed from: j, reason: collision with root package name */
    private static volatile SSFCompatiableSystemCA f37867j;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f37868a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f37869b;

    /* renamed from: c, reason: collision with root package name */
    private Context f37870c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f37871d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f37872e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f37873f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f37874g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f37875h;

    SSFCompatiableSystemCA(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f37868a = null;
        this.f37869b = null;
        if (context == null) {
            g.b(f37866i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f37872e = sSFSecureX509SingleInstance;
        this.f37868a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(X509TrustManager x509TrustManager) {
        g.c(f37866i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f37867j = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            g.b(f37866i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            g.b(f37866i, "NoSuchAlgorithmException");
        }
        g.a(f37866i, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (f37867j == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (f37867j == null) {
                    f37867j = new SSFCompatiableSystemCA(context);
                }
            }
        }
        if (f37867j.f37870c == null && context != null) {
            f37867j.setContext(context);
        }
        return f37867j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        g.c(f37866i, "createSocket: host , port");
        Socket createSocket = this.f37868a.getSocketFactory().createSocket(str, i3);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37869b = sSLSocket;
            this.f37871d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f37873f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f37872e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f37870c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f37875h;
    }

    public SSLContext getSslContext() {
        return this.f37868a;
    }

    public SSLSocket getSslSocket() {
        return this.f37869b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f37871d;
        if (strArr != null) {
            return strArr;
        }
        return new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f37874g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f37872e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f37873f = strArr;
    }

    public void setContext(Context context) {
        this.f37870c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f37875h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f37868a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f37874g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f37872e = x509TrustManager;
    }

    private void a(Socket socket) {
        boolean z16;
        boolean z17 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37875h)) {
            z16 = false;
        } else {
            g.c(f37866i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f37875h);
            z16 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37874g) && com.huawei.secure.android.common.ssl.util.a.a(this.f37873f)) {
            z17 = false;
        } else {
            g.c(f37866i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37874g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f37874g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f37873f);
            }
        }
        if (!z16) {
            g.c(f37866i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z17) {
            return;
        }
        g.c(f37866i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        return createSocket(str, i3);
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f37868a = null;
        this.f37869b = null;
        this.f37868a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f37868a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        g.c(f37866i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.f37868a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37869b = sSLSocket;
            this.f37871d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}
