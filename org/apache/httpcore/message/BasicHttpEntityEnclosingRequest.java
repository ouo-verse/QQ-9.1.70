package org.apache.httpcore.message;

import java.net.Socket;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.RequestLine;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(Socket socket, String str, String str2) {
        super(socket, str, str2);
    }

    @Override // org.apache.httpcore.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header firstHeader = getFirstHeader("Expect");
        if (firstHeader != null && "100-continue".equalsIgnoreCase(firstHeader.getValue())) {
            return true;
        }
        return false;
    }

    @Override // org.apache.httpcore.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.httpcore.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
    }

    public BasicHttpEntityEnclosingRequest(Socket socket, String str, String str2, ProtocolVersion protocolVersion) {
        super(socket, str, str2, protocolVersion);
    }

    public BasicHttpEntityEnclosingRequest(Socket socket, RequestLine requestLine) {
        super(socket, requestLine);
    }
}
