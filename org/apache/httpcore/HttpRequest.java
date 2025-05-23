package org.apache.httpcore;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpRequest extends HttpMessage {
    String getLocalAddr();

    String getLocalName();

    int getLocalPort();

    String getRemoteAddr();

    String getRemoteHost();

    int getRemotePort();

    RequestLine getRequestLine();
}
