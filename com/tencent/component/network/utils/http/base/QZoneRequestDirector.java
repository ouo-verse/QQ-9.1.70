package com.tencent.component.network.utils.http.base;

import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultRequestDirector;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.client.RoutedRequest;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QZoneRequestDirector extends DefaultRequestDirector {
    private boolean mDirected;
    private String mHost;

    public QZoneRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        super(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
        this.mHost = null;
        this.mDirected = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultRequestDirector
    public RoutedRequest handleResponse(RoutedRequest routedRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        RoutedRequest handleResponse = super.handleResponse(routedRequest, httpResponse, httpContext);
        if (handleResponse != null && HttpClientParams.isRedirecting(this.params)) {
            try {
                this.mDirected = true;
                RequestWrapper request = handleResponse.getRequest();
                if (request != null && request.getURI() != null) {
                    httpContext.setAttribute("RedirectURI", request.getURI().toString());
                    String authority = request.getURI().getAuthority();
                    this.mHost = authority;
                    Header[] allHeaders = request.getAllHeaders();
                    if (allHeaders == null) {
                        return handleResponse;
                    }
                    int length = allHeaders.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        if ("Host".equals(allHeaders[i3].getName())) {
                            request.removeHeader(allHeaders[i3]);
                            if (!TextUtils.isEmpty(authority)) {
                                request.addHeader("Host", authority);
                            }
                            if (QDLog.isInfoEnable()) {
                                QDLog.i("http", "download redirect orig host:" + allHeaders[i3].getValue() + " new host:" + authority);
                            }
                        }
                        if ("x-online-host".equals(allHeaders[i3].getName())) {
                            request.removeHeader(allHeaders[i3]);
                            if (!TextUtils.isEmpty(authority)) {
                                request.addHeader("x-online-host", authority);
                            }
                            if (QDLog.isInfoEnable()) {
                                QDLog.i("http", "download redirect orig x-online-host:" + allHeaders[i3].getValue() + " new x-online-host:" + authority);
                            }
                        }
                    }
                }
                return handleResponse;
            } catch (Throwable th5) {
                QDLog.e("http", "handleResponse error", th5);
            }
        }
        return handleResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultRequestDirector
    public void rewriteRequestURI(RequestWrapper requestWrapper, HttpRoute httpRoute) throws ProtocolException {
        super.rewriteRequestURI(requestWrapper, httpRoute);
        if (!this.mDirected || requestWrapper == null) {
            return;
        }
        requestWrapper.removeHeaders("Host");
        requestWrapper.removeHeaders("x-online-host");
        if (!TextUtils.isEmpty(this.mHost)) {
            requestWrapper.addHeader("Host", this.mHost);
            requestWrapper.addHeader("x-online-host", this.mHost);
        }
    }
}
