package org.apache.http.protocol;

import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    public HttpRequestHandlerRegistry() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.protocol.HttpRequestHandlerResolver
    public HttpRequestHandler lookup(String str) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean matchUriRequestPattern(String str, String str2) {
        throw new RuntimeException("Stub!");
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        throw new RuntimeException("Stub!");
    }

    public void setHandlers(Map map) {
        throw new RuntimeException("Stub!");
    }

    public void unregister(String str) {
        throw new RuntimeException("Stub!");
    }
}
