package okhttp3;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import okhttp3.internal.URLFilter;
import okhttp3.internal.huc.OkHttpURLConnection;
import okhttp3.internal.huc.OkHttpsURLConnection;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class OkUrlFactory implements URLStreamHandlerFactory, Cloneable {
    private OkHttpClient client;
    private URLFilter urlFilter;

    public OkUrlFactory(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    public OkHttpClient client() {
        return this.client;
    }

    @Override // java.net.URLStreamHandlerFactory
    public URLStreamHandler createURLStreamHandler(final String str) {
        if (!str.equals("http") && !str.equals("https")) {
            return null;
        }
        return new URLStreamHandler() { // from class: okhttp3.OkUrlFactory.1
            @Override // java.net.URLStreamHandler
            protected int getDefaultPort() {
                if (str.equals("http")) {
                    return 80;
                }
                if (str.equals("https")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
                throw new AssertionError();
            }

            @Override // java.net.URLStreamHandler
            protected URLConnection openConnection(URL url) {
                return OkUrlFactory.this.open(url);
            }

            @Override // java.net.URLStreamHandler
            protected URLConnection openConnection(URL url, Proxy proxy) {
                return OkUrlFactory.this.open(url, proxy);
            }
        };
    }

    public HttpURLConnection open(URL url) {
        return open(url, this.client.proxy());
    }

    public OkUrlFactory setClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
        return this;
    }

    void setUrlFilter(URLFilter uRLFilter) {
        this.urlFilter = uRLFilter;
    }

    public OkUrlFactory clone() {
        return new OkUrlFactory(this.client);
    }

    HttpURLConnection open(URL url, Proxy proxy) {
        String protocol2 = url.getProtocol();
        OkHttpClient build = this.client.newBuilder().proxy(proxy).build();
        if (protocol2.equals("http")) {
            return new OkHttpURLConnection(url, build, this.urlFilter);
        }
        if (protocol2.equals("https")) {
            return new OkHttpsURLConnection(url, build, this.urlFilter);
        }
        throw new IllegalArgumentException("Unexpected protocol: " + protocol2);
    }
}
