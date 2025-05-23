package org.apache.httpcore.protocol;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
