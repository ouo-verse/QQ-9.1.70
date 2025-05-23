package org.apache.http.client;

import java.io.IOException;
import org.apache.http.protocol.HttpContext;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpRequestRetryHandler {
    boolean retryRequest(IOException iOException, int i3, HttpContext httpContext);
}
