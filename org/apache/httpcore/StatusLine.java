package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
