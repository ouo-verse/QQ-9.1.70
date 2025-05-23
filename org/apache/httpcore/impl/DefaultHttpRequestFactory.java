package org.apache.httpcore.impl;

import java.net.Socket;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestFactory;
import org.apache.httpcore.MethodNotSupportedException;
import org.apache.httpcore.RequestLine;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.message.BasicHttpEntityEnclosingRequest;
import org.apache.httpcore.message.BasicHttpRequest;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
    private static final String[] URL_METHODS = {"GET", "HEAD", HttpOptions.METHOD_NAME, "TRACE", "CONNECT"};
    private static final String[] BODY_METHODS = {"POST", HttpPut.METHOD_NAME, "DELETE", "PATCH"};

    private static boolean isOneOf(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.httpcore.HttpRequestFactory
    public HttpRequest newHttpRequest(Socket socket, RequestLine requestLine) throws MethodNotSupportedException {
        Args.notNull(requestLine, "Request line");
        String method = requestLine.getMethod();
        if (isOneOf(URL_METHODS, method)) {
            return new BasicHttpRequest(socket, requestLine);
        }
        if (isOneOf(BODY_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(socket, requestLine);
        }
        throw new MethodNotSupportedException(method + " method not supported");
    }

    @Override // org.apache.httpcore.HttpRequestFactory
    public HttpRequest newHttpRequest(Socket socket, String str, String str2) throws MethodNotSupportedException {
        if (isOneOf(URL_METHODS, str)) {
            return new BasicHttpRequest(socket, str, str2);
        }
        if (isOneOf(BODY_METHODS, str)) {
            return new BasicHttpEntityEnclosingRequest(socket, str, str2);
        }
        throw new MethodNotSupportedException(str + " method not supported");
    }
}
