package org.apache.httpcore;

import org.apache.httpcore.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i3, HttpContext httpContext);

    HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext);
}
