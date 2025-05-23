package org.apache.httpcore.impl;

import java.util.Locale;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseFactory;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.ReasonPhraseCatalog;
import org.apache.httpcore.StatusLine;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.message.BasicHttpResponse;
import org.apache.httpcore.message.BasicStatusLine;
import org.apache.httpcore.protocol.HttpContext;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes29.dex */
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
    protected final ReasonPhraseCatalog reasonCatalog;

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    protected Locale determineLocale(HttpContext httpContext) {
        return Locale.getDefault();
    }

    @Override // org.apache.httpcore.HttpResponseFactory
    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i3, HttpContext httpContext) {
        Args.notNull(protocolVersion, "HTTP version");
        Locale determineLocale = determineLocale(httpContext);
        return new BasicHttpResponse(new BasicStatusLine(protocolVersion, i3, this.reasonCatalog.getReason(i3, determineLocale)), this.reasonCatalog, determineLocale);
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    @Override // org.apache.httpcore.HttpResponseFactory
    public HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext) {
        Args.notNull(statusLine, "Status line");
        return new BasicHttpResponse(statusLine, this.reasonCatalog, determineLocale(httpContext));
    }
}
