package org.apache.http.message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    public BasicHttpEntityEnclosingRequest(String str, String str2) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(String str, String str2, ProtocolVersion protocolVersion) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntityEnclosingRequest(RequestLine requestLine) {
        super(null);
        throw new RuntimeException("Stub!");
    }
}
