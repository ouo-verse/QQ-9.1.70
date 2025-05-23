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

/* compiled from: P */
/* loaded from: classes2.dex */
public class SecureSSLSocketFactoryNew extends SSLSocketFactory {

    /* renamed from: i, reason: collision with root package name */
    private static final String f37906i = "SecureSSLSocketFactoryNew";

    /* renamed from: j, reason: collision with root package name */
    private static volatile SecureSSLSocketFactoryNew f37907j;

    /* renamed from: a, reason: collision with root package name */
    protected SSLContext f37908a;

    /* renamed from: b, reason: collision with root package name */
    protected SSLSocket f37909b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f37910c;

    /* renamed from: d, reason: collision with root package name */
    protected String[] f37911d;

    /* renamed from: e, reason: collision with root package name */
    protected X509TrustManager f37912e;

    /* renamed from: f, reason: collision with root package name */
    protected String[] f37913f;

    /* renamed from: g, reason: collision with root package name */
    protected String[] f37914g;

    /* renamed from: h, reason: collision with root package name */
    protected String[] f37915h;

    public SecureSSLSocketFactoryNew(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.f37908a = null;
        this.f37909b = null;
        this.f37908a = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.f37908a.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    private void a(Socket socket) {
        boolean z16;
        boolean z17 = true;
        if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37915h)) {
            g.c(f37906i, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.f37915h);
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.f37914g) && com.huawei.secure.android.common.ssl.util.a.a(this.f37913f)) {
            z17 = false;
        } else {
            g.c(f37906i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!com.huawei.secure.android.common.ssl.util.a.a(this.f37914g)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.f37914g);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.f37913f);
            }
        }
        if (!z16) {
            g.c(f37906i, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z17) {
            g.c(f37906i, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }

    public static SecureSSLSocketFactoryNew getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (f37907j == null) {
            synchronized (SecureSSLSocketFactoryNew.class) {
                if (f37907j == null) {
                    f37907j = new SecureSSLSocketFactoryNew(context);
                }
            }
        }
        if (f37907j.f37910c == null && context != null) {
            f37907j.setContext(context);
        }
        g.a(f37906i, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f37907j;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException {
        g.c(f37906i, "createSocket: host , port");
        Socket createSocket = this.f37908a.getSocketFactory().createSocket(str, i3);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37909b = sSLSocket;
            this.f37911d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] getBlackCiphers() {
        return this.f37913f;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.f37912e;
        if (x509TrustManager instanceof SecureX509TrustManager) {
            return ((SecureX509TrustManager) x509TrustManager).getChain();
        }
        return new X509Certificate[0];
    }

    public Context getContext() {
        return this.f37910c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.f37915h;
    }

    public SSLContext getSslContext() {
        return this.f37908a;
    }

    public SSLSocket getSslSocket() {
        return this.f37909b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f37911d;
        if (strArr != null) {
            return strArr;
        }
        return new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.f37914g;
    }

    public X509TrustManager getX509TrustManager() {
        return this.f37912e;
    }

    public void setBlackCiphers(String[] strArr) {
        this.f37913f = strArr;
    }

    public void setContext(Context context) {
        this.f37910c = context.getApplicationContext();
    }

    public void setProtocols(String[] strArr) {
        this.f37915h = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.f37908a = sSLContext;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.f37914g = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.f37912e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    SecureSSLSocketFactoryNew(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.f37908a = null;
        this.f37909b = null;
        if (context == null) {
            g.b(f37906i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.f37912e = secureX509SingleInstance;
        this.f37908a.init(null, new X509TrustManager[]{secureX509SingleInstance}, null);
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
        g.c(f37906i, "createSocket s host port autoClose");
        Socket createSocket = this.f37908a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.f37909b = sSLSocket;
            this.f37911d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public SecureSSLSocketFactoryNew(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.f37908a = null;
        this.f37909b = null;
        this.f37908a = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.f37908a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
