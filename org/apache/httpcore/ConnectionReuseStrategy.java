package org.apache.httpcore;

import org.apache.httpcore.protocol.HttpContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
