package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseInterceptor;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class ResponseServer implements HttpResponseInterceptor {
    private final String originServer;

    public ResponseServer(String str) {
        this.originServer = str;
    }

    @Override // org.apache.httpcore.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        String str;
        Args.notNull(httpResponse, "HTTP response");
        if (!httpResponse.containsHeader("Server") && (str = this.originServer) != null) {
            httpResponse.addHeader("Server", str);
        }
    }

    public ResponseServer() {
        this(null);
    }
}
