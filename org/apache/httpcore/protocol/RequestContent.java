package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class RequestContent implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    @Override // org.apache.httpcore.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            if (this.overwrite) {
                httpRequest.removeHeaders("Transfer-Encoding");
                httpRequest.removeHeaders("Content-Length");
            } else if (!httpRequest.containsHeader("Transfer-Encoding")) {
                if (httpRequest.containsHeader("Content-Length")) {
                    throw new ProtocolException("Content-Length header already present");
                }
            } else {
                throw new ProtocolException("Transfer-encoding header already present");
            }
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity == null) {
                httpRequest.addHeader("Content-Length", "0");
                return;
            }
            if (!entity.isChunked() && entity.getContentLength() >= 0) {
                httpRequest.addHeader("Content-Length", Long.toString(entity.getContentLength()));
            } else if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpRequest.addHeader("Transfer-Encoding", "chunked");
            } else {
                throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
            }
            if (entity.getContentType() != null && !httpRequest.containsHeader("Content-Type")) {
                httpRequest.addHeader(entity.getContentType());
            }
            if (entity.getContentEncoding() != null && !httpRequest.containsHeader("Content-Encoding")) {
                httpRequest.addHeader(entity.getContentEncoding());
            }
        }
    }

    public RequestContent(boolean z16) {
        this.overwrite = z16;
    }
}
