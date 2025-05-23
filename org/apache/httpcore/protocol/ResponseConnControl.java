package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseInterceptor;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class ResponseConnControl implements HttpResponseInterceptor {
    @Override // org.apache.httpcore.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode != 400 && statusCode != 408 && statusCode != 411 && statusCode != 413 && statusCode != 414 && statusCode != 503 && statusCode != 501) {
            Header firstHeader = httpResponse.getFirstHeader("Connection");
            if (firstHeader != null && "Close".equalsIgnoreCase(firstHeader.getValue())) {
                return;
            }
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                    httpResponse.setHeader("Connection", "Close");
                    return;
                }
            }
            HttpRequest request = adapt.getRequest();
            if (request != null) {
                Header firstHeader2 = request.getFirstHeader("Connection");
                if (firstHeader2 != null) {
                    httpResponse.setHeader("Connection", firstHeader2.getValue());
                    return;
                } else {
                    if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                        httpResponse.setHeader("Connection", "Close");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        httpResponse.setHeader("Connection", "Close");
    }
}
