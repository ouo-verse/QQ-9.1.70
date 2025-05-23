package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class RequestConnControl implements HttpRequestInterceptor {
    @Override // org.apache.httpcore.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && !httpRequest.containsHeader("Connection")) {
            httpRequest.addHeader("Connection", "Keep-Alive");
        }
    }
}
