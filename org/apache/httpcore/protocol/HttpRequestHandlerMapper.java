package org.apache.httpcore.protocol;

import org.apache.httpcore.HttpRequest;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpRequestHandlerMapper {
    HttpRequestHandler lookup(HttpRequest httpRequest);
}
