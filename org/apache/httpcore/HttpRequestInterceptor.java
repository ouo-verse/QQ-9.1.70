package org.apache.httpcore;

import java.io.IOException;
import org.apache.httpcore.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpRequestInterceptor {
    void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException;
}
