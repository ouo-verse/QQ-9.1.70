package org.apache.http.impl.client;

import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    public DefaultHttpRequestRetryHandler(int i3, boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public int getRetryCount() {
        throw new RuntimeException("Stub!");
    }

    public boolean isRequestSentRetryEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException iOException, int i3, HttpContext httpContext) {
        throw new RuntimeException("Stub!");
    }

    public DefaultHttpRequestRetryHandler() {
        throw new RuntimeException("Stub!");
    }
}
