package org.apache.http;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpResponseInterceptor {
    void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
