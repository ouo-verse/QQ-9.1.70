package com.tencent.component.network.utils.http.base;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZoneHttpClient extends DefaultHttpClient {
    public QZoneHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public AuthSchemeRegistry createAuthSchemeRegistry() {
        return super.createAuthSchemeRegistry();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public ClientConnectionManager createClientConnectionManager() {
        return super.createClientConnectionManager();
    }

    @Override // org.apache.http.impl.client.AbstractHttpClient
    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new QZoneRequestDirector(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return super.createConnectionKeepAliveStrategy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        return super.createConnectionReuseStrategy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public CookieSpecRegistry createCookieSpecRegistry() {
        return super.createCookieSpecRegistry();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public CookieStore createCookieStore() {
        return super.createCookieStore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public CredentialsProvider createCredentialsProvider() {
        return super.createCredentialsProvider();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpContext createHttpContext() {
        return super.createHttpContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpParams createHttpParams() {
        return super.createHttpParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public BasicHttpProcessor createHttpProcessor() {
        return super.createHttpProcessor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return super.createHttpRequestRetryHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpRoutePlanner createHttpRoutePlanner() {
        return super.createHttpRoutePlanner();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public AuthenticationHandler createProxyAuthenticationHandler() {
        return super.createProxyAuthenticationHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public RedirectHandler createRedirectHandler() {
        return super.createRedirectHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpRequestExecutor createRequestExecutor() {
        return super.createRequestExecutor();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public AuthenticationHandler createTargetAuthenticationHandler() {
        return super.createTargetAuthenticationHandler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public UserTokenHandler createUserTokenHandler() {
        return super.createUserTokenHandler();
    }
}
