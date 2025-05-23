package org.apache.http;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpRequestFactory {
    HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException;

    HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException;
}
