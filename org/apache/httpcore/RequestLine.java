package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface RequestLine {
    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
}
