package org.apache.http.message;

import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class BasicStatusLine implements StatusLine {
    public BasicStatusLine(ProtocolVersion protocolVersion, int i3, String str) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() throws CloneNotSupportedException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public ProtocolVersion getProtocolVersion() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public String getReasonPhrase() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.StatusLine
    public int getStatusCode() {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }
}
