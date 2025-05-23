package com.tencent.mobileqq.transfile.http2;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.http2.internal.OkHttpURLConnection;
import com.tencent.mobileqq.transfile.http2.internal.OkHttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.OkHttpClient;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    static IPatchRedirector $redirector_;
    private OkHttpClient client;

    public OkUrlFactory(OkHttpClient okHttpClient) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) okHttpClient);
        } else {
            this.client = okHttpClient;
        }
    }

    public OkHttpClient client() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OkHttpClient) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.client;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (URLStreamHandler) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (!str.equals("http") && !str.equals("https")) {
            return null;
        }
        return new URLStreamHandler(str) { // from class: com.tencent.mobileqq.transfile.http2.OkUrlFactory.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$protocol;

            {
                this.val$protocol = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OkUrlFactory.this, (Object) str);
                }
            }

            @Override // java.net.URLStreamHandler
            protected int getDefaultPort() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 4, (Object) this)).intValue();
                }
                if (this.val$protocol.equals("http")) {
                    return 80;
                }
                if (this.val$protocol.equals("https")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
                throw new AssertionError();
            }

            @Override // java.net.URLStreamHandler
            protected URLConnection openConnection(URL url) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? OkUrlFactory.this.open(url) : (URLConnection) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) url);
            }

            @Override // java.net.URLStreamHandler
            protected URLConnection openConnection(URL url, Proxy proxy) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) ? OkUrlFactory.this.open(url, proxy) : (URLConnection) iPatchRedirector2.redirect((short) 3, (Object) this, (Object) url, (Object) proxy);
            }
        };
    }

    public HttpURLConnection open(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? open(url, null) : (HttpURLConnection) iPatchRedirector.redirect((short) 5, (Object) this, (Object) url);
    }

    public OkUrlFactory setClient(OkHttpClient okHttpClient) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OkUrlFactory) iPatchRedirector.redirect((short) 3, (Object) this, (Object) okHttpClient);
        }
        this.client = okHttpClient;
        return this;
    }

    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public OkUrlFactory m224clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new OkUrlFactory(this.client) : (OkUrlFactory) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    public HttpURLConnection open(URL url, Proxy proxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HttpURLConnection) iPatchRedirector.redirect((short) 6, (Object) this, (Object) url, (Object) proxy);
        }
        String protocol2 = url.getProtocol();
        OkHttpClient build = this.client.newBuilder().proxy(proxy).build();
        if (protocol2.equals("http")) {
            return new OkHttpURLConnection(url, build);
        }
        if (protocol2.equals("https")) {
            return new OkHttpsURLConnection(url, build);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol2);
    }
}
