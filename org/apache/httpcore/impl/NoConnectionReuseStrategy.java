package org.apache.httpcore.impl;

import org.apache.httpcore.ConnectionReuseStrategy;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.protocol.HttpContext;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class NoConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final NoConnectionReuseStrategy INSTANCE = new NoConnectionReuseStrategy();

    @Override // org.apache.httpcore.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}
