package org.apache.http.protocol;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String str);

    Object removeAttribute(String str);

    void setAttribute(String str, Object obj);
}
