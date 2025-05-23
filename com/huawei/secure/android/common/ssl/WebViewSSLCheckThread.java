package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes2.dex */
public class WebViewSSLCheckThread extends BaseThread {

    /* renamed from: i, reason: collision with root package name */
    private static final String f37927i = "WebViewSSLCheckThread";

    /* renamed from: a, reason: collision with root package name */
    private SSLSocketFactory f37928a;

    /* renamed from: b, reason: collision with root package name */
    private HostnameVerifier f37929b;

    /* renamed from: c, reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f37930c;

    /* renamed from: d, reason: collision with root package name */
    private X509HostnameVerifier f37931d;

    /* renamed from: e, reason: collision with root package name */
    private SslErrorHandler f37932e;

    /* renamed from: f, reason: collision with root package name */
    private String f37933f;

    /* renamed from: g, reason: collision with root package name */
    private Callback f37934g;

    /* renamed from: h, reason: collision with root package name */
    private Context f37935h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements okhttp3.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Callback f37936a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f37937b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f37938c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SslErrorHandler f37939d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.f37936a = callback;
            this.f37937b = context;
            this.f37938c = str;
            this.f37939d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            g.b(WebViewSSLCheckThread.f37927i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.f37936a;
            if (callback != null) {
                callback.onCancel(this.f37937b, this.f37938c);
            } else {
                this.f37939d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            g.b(WebViewSSLCheckThread.f37927i, "onResponse . proceed");
            Callback callback = this.f37936a;
            if (callback != null) {
                callback.onProceed(this.f37937b, this.f37938c);
            } else {
                this.f37939d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        String str = f37927i;
        g.c(str, "callbackCancel: ");
        Callback callback = this.f37934g;
        if (callback != null) {
            callback.onCancel(this.f37935h, this.f37933f);
        } else if (this.f37932e != null) {
            g.c(str, "callbackCancel 2: ");
            this.f37932e.cancel();
        }
    }

    private void c() {
        g.c(f37927i, "callbackProceed: ");
        Callback callback = this.f37934g;
        if (callback != null) {
            callback.onProceed(this.f37935h, this.f37933f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f37932e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.f37931d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.f37930c;
    }

    public Callback getCallback() {
        return this.f37934g;
    }

    public Context getContext() {
        return this.f37935h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f37929b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.f37932e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f37928a;
    }

    public String getUrl() {
        return this.f37933f;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x014b  */
    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th5;
        HttpsURLConnection httpsURLConnection;
        Exception e16;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        if (this.f37930c != null && this.f37931d != null) {
            if (this.f37932e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f37933f)) {
                        try {
                            this.f37930c.setHostnameVerifier(this.f37931d);
                            org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.f37930c;
                            if (sSLSocketFactory instanceof SecureApacheSSLSocketFactory) {
                                ((SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.f37935h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme("https", this.f37930c, WebSocketImpl.DEFAULT_WSS_PORT));
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f37933f));
                            HttpResponse execute = defaultHttpClient.execute(httpGet);
                            g.c(f37927i, "status code is : " + execute.getStatusLine().getStatusCode());
                            f.a((Reader) null);
                            c();
                            return;
                        } catch (Exception e17) {
                            g.b(f37927i, "run: exception : " + e17.getMessage());
                            b();
                            f.a((Reader) null);
                            return;
                        }
                    }
                } catch (Throwable th6) {
                    f.a((Reader) null);
                    throw th6;
                }
            }
            g.b(f37927i, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.f37928a != null && this.f37929b != null) {
            try {
                URLConnection openConnection = new URL(this.f37933f).openConnection();
                if (openConnection instanceof HttpsURLConnection) {
                    httpsURLConnection = (HttpsURLConnection) openConnection;
                    try {
                        try {
                            httpsURLConnection.setSSLSocketFactory(this.f37928a);
                            httpsURLConnection.setHostnameVerifier(this.f37929b);
                            httpsURLConnection.setRequestMethod("GET");
                            httpsURLConnection.setConnectTimeout(10000);
                            httpsURLConnection.setReadTimeout(20000);
                            httpsURLConnection.connect();
                            httpsURLConnection2 = httpsURLConnection;
                        } catch (Throwable th7) {
                            th5 = th7;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th5;
                        }
                    } catch (Exception e18) {
                        e16 = e18;
                        g.b(f37927i, "exception : " + e16.getMessage());
                        b();
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                            return;
                        }
                        return;
                    }
                }
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                c();
            } catch (Exception e19) {
                e16 = e19;
                httpsURLConnection = null;
            } catch (Throwable th8) {
                th5 = th8;
                httpsURLConnection = null;
                if (httpsURLConnection != null) {
                }
                throw th5;
            }
        } else {
            b();
        }
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.f37931d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f37930c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.f37934g = callback;
    }

    public void setContext(Context context) {
        this.f37935h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.f37929b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.f37932e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f37928a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f37933f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew(new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, new c(context)));
        } catch (UnrecoverableKeyException e16) {
            g.b(f37927i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e16.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler != null && !TextUtils.isEmpty(str) && context != null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew(new c(context));
                secureSSLSocketFactoryNew.setContext(context);
                builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
                builder.hostnameVerifier(new StrictHostnameVerifier());
                builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
                return;
            } catch (Exception e16) {
                g.b(f37927i, "checkServerCertificateWithOK: exception : " + e16.getMessage());
                sslErrorHandler.cancel();
                return;
            }
        }
        g.b(f37927i, "checkServerCertificateWithOK: handler or url or context is null");
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.f37932e = sslErrorHandler;
        this.f37933f = str;
        this.f37930c = sSLSocketFactory;
        this.f37931d = x509HostnameVerifier;
        this.f37934g = callback;
        this.f37935h = context;
    }
}
