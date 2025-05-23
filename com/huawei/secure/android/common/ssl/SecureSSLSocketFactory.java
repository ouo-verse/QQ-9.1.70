package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i, reason: collision with root package name */
    private static final String f37896i = SecureSSLSocketFactory.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f37897j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f37898a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f37899b;

    /* renamed from: c, reason: collision with root package name */
    private Context f37900c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f37901d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f37902e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f37903f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f37904g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f37905h;

    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f37898a = null;
        this.f37899b = null;
        this.f37898a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f37898a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(X509TrustManager x509TrustManager) {
        g.c(f37896i, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f37897j = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            g.b(f37896i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            g.b(f37896i, "NoSuchAlgorithmException");
        }
        g.a(f37896i, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (f37897j == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f37897j == null) {
                    f37897j = new SecureSSLSocketFactory(context);
                }
            }
        }
        if (f37897j.f37900c == null && context != null) {
            f37897j.setContext(context);
        }
        g.a(f37896i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f37897j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        g.c(f37896i, "createSocket: host , port");
        Socket createSocket = this.f37898a.getSocketFactory().createSocket(str, i3);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37899b = sSLSocket;
            this.f37901d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f37903f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f37902e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f37900c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f37905h;
    }

    public SSLContext getSslContext() {
        return this.f37898a;
    }

    public SSLSocket getSslSocket() {
        return this.f37899b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f37901d;
        if (strArr != null) {
            return strArr;
        }
        return new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f37904g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f37902e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f37903f = strArr;
    }

    public void setContext(Context context) {
        this.f37900c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f37905h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f37898a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f37904g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f37902e = x509TrustManager;
    }

    private void a(Socket socket) {
        boolean z16;
        boolean z17 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37905h)) {
            z16 = false;
        } else {
            g.c(f37896i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f37905h);
            z16 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37904g) && com.huawei.secure.android.common.ssl.util.a.a(this.f37903f)) {
            z17 = false;
        } else {
            g.c(f37896i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37904g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f37904g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f37903f);
            }
        }
        if (!z16) {
            g.c(f37896i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z17) {
            return;
        }
        g.c(f37896i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    SecureSSLSocketFactory(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f37898a = null;
        this.f37899b = null;
        if (context == null) {
            g.b(f37896i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f37902e = secureX509SingleInstance;
        this.f37898a.init(null, new X509TrustManager[]{secureX509SingleInstance}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        return createSocket(str, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        g.c(f37896i, "createSocket s host port autoClose");
        Socket createSocket = this.f37898a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37899b = sSLSocket;
            this.f37901d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f37898a = null;
        this.f37899b = null;
        this.f37898a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f37898a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
