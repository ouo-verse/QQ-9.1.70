package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: i, reason: collision with root package name */
    private static final String f37886i = SecureApacheSSLSocketFactory.class.getSimpleName();

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureApacheSSLSocketFactory f37887j = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f37888a;

    /* renamed from: b, reason: collision with root package name */
    private SSLSocket f37889b;

    /* renamed from: c, reason: collision with root package name */
    private Context f37890c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f37891d;

    /* renamed from: e, reason: collision with root package name */
    private X509TrustManager f37892e;

    /* renamed from: f, reason: collision with root package name */
    private String[] f37893f;

    /* renamed from: g, reason: collision with root package name */
    private String[] f37894g;

    /* renamed from: h, reason: collision with root package name */
    private String[] f37895h;

    SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f37889b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(X509TrustManager x509TrustManager) {
        g.c(f37886i, "sasf update socket factory trust manager");
        try {
            f37887j = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager);
        } catch (IOException unused) {
            g.b(f37886i, "IOException");
        } catch (KeyManagementException unused2) {
            g.b(f37886i, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            g.b(f37886i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            g.b(f37886i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            g.b(f37886i, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            g.b(f37886i, "CertificateException");
        }
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (f37887j == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (f37887j == null) {
                    f37887j = new SecureApacheSSLSocketFactory(keyStore, context);
                }
            }
        }
        return f37887j;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        g.c(f37886i, "createSocket: socket host port autoClose");
        Socket createSocket = this.f37888a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37889b = sSLSocket;
            this.f37891d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f37893f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f37892e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f37890c;
    }

    public String[] getProtocols() {
        return this.f37895h;
    }

    public SSLContext getSslContext() {
        return this.f37888a;
    }

    public SSLSocket getSslSocket() {
        return this.f37889b;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f37891d;
        if (strArr != null) {
            return strArr;
        }
        return new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f37894g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f37892e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f37893f = strArr;
    }

    public void setContext(Context context) {
        this.f37890c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f37895h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f37888a = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.f37889b = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f37894g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f37892e = x509TrustManager;
    }

    SecureApacheSSLSocketFactory(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f37889b = null;
        if (context == null) {
            g.b(f37886i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f37892e = secureX509SingleInstance;
        this.f37888a.init(null, new X509TrustManager[]{secureX509SingleInstance}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.c(f37886i, "createSocket: ");
        Socket createSocket = this.f37888a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37889b = sSLSocket;
            this.f37891d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    private void a(Socket socket) {
        boolean z16;
        boolean z17 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37895h)) {
            z16 = false;
        } else {
            g.c(f37886i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f37895h);
            z16 = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37894g) && com.huawei.secure.android.common.ssl.util.a.a(this.f37893f)) {
            z17 = false;
        } else {
            g.c(f37886i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37894g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f37894g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f37893f);
            }
        }
        if (!z16) {
            g.c(f37886i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z17) {
            return;
        }
        g.c(f37886i, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f37889b = null;
        this.f37888a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f37888a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.f37889b = null;
        this.f37888a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f37888a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
