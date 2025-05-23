package org.apache.httpcore.protocol;

import org.apache.httpcore.HttpConnection;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpCoreContext implements HttpContext {
    public static final String HTTP_CONNECTION = "http.connection";
    public static final String HTTP_REQUEST = "http.request";
    public static final String HTTP_REQ_SENT = "http.request_sent";
    public static final String HTTP_RESPONSE = "http.response";
    public static final String HTTP_TARGET_HOST = "http.target_host";
    private final HttpContext context;

    public HttpCoreContext(HttpContext httpContext) {
        this.context = httpContext;
    }

    public static HttpCoreContext adapt(HttpContext httpContext) {
        Args.notNull(httpContext, "HTTP context");
        if (httpContext instanceof HttpCoreContext) {
            return (HttpCoreContext) httpContext;
        }
        return new HttpCoreContext(httpContext);
    }

    public static HttpCoreContext create() {
        return new HttpCoreContext(new BasicHttpContext());
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public Object getAttribute(String str) {
        return this.context.getAttribute(str);
    }

    public <T extends HttpConnection> T getConnection(Class<T> cls) {
        return (T) getAttribute("http.connection", cls);
    }

    public HttpRequest getRequest() {
        return (HttpRequest) getAttribute("http.request", HttpRequest.class);
    }

    public HttpResponse getResponse() {
        return (HttpResponse) getAttribute("http.response", HttpResponse.class);
    }

    public HttpHost getTargetHost() {
        return (HttpHost) getAttribute("http.target_host", HttpHost.class);
    }

    public boolean isRequestSent() {
        Boolean bool = (Boolean) getAttribute("http.request_sent", Boolean.class);
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public Object removeAttribute(String str) {
        return this.context.removeAttribute(str);
    }

    @Override // org.apache.httpcore.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        this.context.setAttribute(str, obj);
    }

    public void setTargetHost(HttpHost httpHost) {
        setAttribute("http.target_host", httpHost);
    }

    public <T> T getAttribute(String str, Class<T> cls) {
        Args.notNull(cls, "Attribute class");
        Object attribute = getAttribute(str);
        if (attribute == null) {
            return null;
        }
        return cls.cast(attribute);
    }

    public HttpConnection getConnection() {
        return (HttpConnection) getAttribute("http.connection", HttpConnection.class);
    }

    public HttpCoreContext() {
        this.context = new BasicHttpContext();
    }
}
