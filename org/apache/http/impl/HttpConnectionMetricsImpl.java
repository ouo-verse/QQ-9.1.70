package org.apache.http.impl;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.io.HttpTransportMetrics;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class HttpConnectionMetricsImpl implements HttpConnectionMetrics {
    public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
    public static final String REQUEST_COUNT = "http.request-count";
    public static final String RESPONSE_COUNT = "http.response-count";
    public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";

    public HttpConnectionMetricsImpl(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public Object getMetric(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getReceivedBytesCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getRequestCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getResponseCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public long getSentBytesCount() {
        throw new RuntimeException("Stub!");
    }

    public void incrementRequestCount() {
        throw new RuntimeException("Stub!");
    }

    public void incrementResponseCount() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.HttpConnectionMetrics
    public void reset() {
        throw new RuntimeException("Stub!");
    }

    public void setMetric(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }
}
