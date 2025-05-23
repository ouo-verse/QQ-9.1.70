package org.apache.http;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface StatusLine {
    ProtocolVersion getProtocolVersion();

    String getReasonPhrase();

    int getStatusCode();
}
