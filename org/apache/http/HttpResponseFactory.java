package org.apache.http;

import org.apache.http.protocol.HttpContext;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i3, HttpContext httpContext);

    HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext);
}
