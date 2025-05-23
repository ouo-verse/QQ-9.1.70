package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f37856i = "SASFCompatiableSystemCA";

    /* renamed from: j, reason: collision with root package name */
    private static volatile SASFCompatiableSystemCA f37857j;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f37858a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f37859b;

    /* renamed from: c, reason: collision with root package name */
    private Context f37860c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f37861d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f37862e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f37863f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f37864g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f37865h;

    SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f37859b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(X509TrustManager x509TrustManager) {
        g.c(f37856i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f37857j = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager);
        } catch (KeyManagementException unused) {
            g.b(f37856i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            g.b(f37856i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            g.b(f37856i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            g.b(f37856i, "UnrecoverableKeyException");
        }
        g.a(f37856i, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (f37857j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f37857j == null) {
                    f37857j = new SASFCompatiableSystemCA(keyStore, context);
                }
            }
        }
        return f37857j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        g.c(f37856i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f37858a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37859b = sSLSocket;
            this.f37861d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f37863f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f37862e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f37860c;
    }

    public String[] getProtocols() {
        return this.f37865h;
    }

    public SSLContext getSslContext() {
        return this.f37858a;
    }

    public SSLSocket getSslSocket() {
        return this.f37859b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f37861d;
        if (strArr != null) {
            return strArr;
        }
        return new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f37864g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f37862e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f37863f = strArr;
    }

    public void setContext(Context context) {
        this.f37860c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f37865h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f37858a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f37859b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f37864g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f37862e = x509TrustManager;
    }

    SASFCompatiableSystemCA(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f37859b = null;
        if (context == null) {
            g.b(f37856i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.f37862e = sSFSecureX509SingleInstance;
        this.f37858a.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.c(f37856i, "createSocket: ");
        Socket createSocket = this.f37858a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37859b = sSLSocket;
            this.f37861d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void a(Socket socket) {
        boolean z16;
        boolean z17 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37865h)) {
            z16 = false;
        } else {
            g.c(f37856i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f37865h);
            z16 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37864g) && com.huawei.secure.android.common.ssl.util.a.a(this.f37863f)) {
            z17 = false;
        } else {
            g.c(f37856i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37864g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f37864g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f37863f);
            }
        }
        if (!z16) {
            g.c(f37856i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z17) {
            return;
        }
        g.c(f37856i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.f37859b = null;
        this.f37858a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f37858a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
