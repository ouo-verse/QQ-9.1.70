package org.apache.httpcore;

import java.net.Socket;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(Socket socket, String str, String str2) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(Socket socket, RequestLine requestLine) throws MethodNotSupportedException;
}
