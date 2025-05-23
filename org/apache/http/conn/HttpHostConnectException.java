package org.apache.http.conn;

import java.net.ConnectException;
import org.apache.http.HttpHost;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class HttpHostConnectException extends ConnectException {
    public HttpHostConnectException(HttpHost httpHost, ConnectException connectException) {
        throw new RuntimeException("Stub!");
    }

    public HttpHost getHost() {
        throw new RuntimeException("Stub!");
    }
}
