package org.apache.http.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.protocol.HttpContext;

@Deprecated
/* loaded from: classes29.dex */
public class ProxySelectorRoutePlanner implements HttpRoutePlanner {
    protected ProxySelector proxySelector;
    protected SchemeRegistry schemeRegistry;

    public ProxySelectorRoutePlanner(SchemeRegistry schemeRegistry, ProxySelector proxySelector) {
        throw new RuntimeException("Stub!");
    }

    protected Proxy chooseProxy(List<Proxy> list, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    protected HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        throw new RuntimeException("Stub!");
    }

    protected String getHost(InetSocketAddress inetSocketAddress) {
        throw new RuntimeException("Stub!");
    }

    public ProxySelector getProxySelector() {
        throw new RuntimeException("Stub!");
    }

    public void setProxySelector(ProxySelector proxySelector) {
        throw new RuntimeException("Stub!");
    }
}
