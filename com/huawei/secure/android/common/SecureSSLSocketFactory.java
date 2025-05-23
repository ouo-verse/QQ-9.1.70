package com.huawei.secure.android.common;

import android.content.Context;
import com.huawei.secure.android.common.ssl.SSLUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
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
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();

    /* renamed from: c, reason: collision with root package name */
    private static volatile SecureSSLSocketFactory f37737c = null;

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f37738a;

    /* renamed from: b, reason: collision with root package name */
    private Context f37739b;

    SecureSSLSocketFactory(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalAccessException {
        this.f37738a = null;
        this.f37739b = context;
        this.f37738a = SSLUtil.setSSLContext();
        this.f37738a.init(null, new X509TrustManager[]{new SecureX509TrustManager(this.f37739b)}, null);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        SSLUtil.setEnabledProtocols(sSLSocket);
        SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Deprecated
    public static SecureSSLSocketFactory getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f37737c == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (f37737c == null) {
                    f37737c = new SecureSSLSocketFactory(context);
                }
            }
        }
        return f37737c;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3) throws IOException, UnknownHostException {
        Socket createSocket = this.f37738a.getSocketFactory().createSocket(str, i3);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) throws IOException, UnknownHostException {
        return createSocket(str, i3);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i3);
    }

    @Deprecated
    public SecureSSLSocketFactory(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.f37738a = null;
        this.f37738a = SSLUtil.setSSLContext();
        this.f37738a.init(null, new X509TrustManager[]{new HiCloudX509TrustManager(inputStream, str)}, null);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i3, boolean z16) throws IOException {
        Socket createSocket = this.f37738a.getSocketFactory().createSocket(socket, str, i3, z16);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }
}
