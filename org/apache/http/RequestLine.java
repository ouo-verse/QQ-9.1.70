package org.apache.http;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
