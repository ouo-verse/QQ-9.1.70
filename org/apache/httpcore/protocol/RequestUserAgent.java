package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class RequestUserAgent implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent(String str) {
        this.userAgent = str;
    }

    @Override // org.apache.httpcore.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        String str;
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader("User-Agent")) {
            HttpParams params = httpRequest.getParams();
            if (params != null) {
                str = (String) params.getParameter("http.useragent");
            } else {
                str = null;
            }
            if (str == null) {
                str = this.userAgent;
            }
            if (str != null) {
                httpRequest.addHeader("User-Agent", str);
            }
        }
    }

    public RequestUserAgent() {
        this(null);
    }
}
