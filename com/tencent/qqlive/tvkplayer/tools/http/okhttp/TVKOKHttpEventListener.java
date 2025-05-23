package com.tencent.qqlive.tvkplayer.tools.http.okhttp;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes23.dex */
public final class TVKOKHttpEventListener extends EventListener {
    private static final String TAG = "TVKOKHttpEventListener";
    private InetAddress mConnectHostIp;
    private List<InetAddress> mDnsResult;
    private int mPort;
    private String mRequestTag;
    private String mRequestUrl;
    private final TimeRecorder mTimeRecorder = new TimeRecorder();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static class TimeRecorder {
        private long mCallStartTimeMs;
        private long mConnectCostTimeMs;
        private long mConnectStartTimeMs;
        private long mDnsCostTimeMs;
        private long mDnsStartTimeMs;
        private long mRequestBodyCostTimeMs;
        private long mRequestBodyStartTimeMs;
        private long mRequestHeaderCostTimeMs;
        private long mRequestHeaderStartTimeMs;
        private long mResponseBodyCostTimeMs;
        private long mResponseBodyStartTimeMs;
        private long mResponseHeaderCostTimeMs;
        private long mResponseHeaderStartTimeMs;

        TimeRecorder() {
            this.mCallStartTimeMs = 0L;
            this.mDnsStartTimeMs = 0L;
            this.mConnectStartTimeMs = 0L;
            this.mRequestHeaderStartTimeMs = 0L;
            this.mRequestBodyStartTimeMs = 0L;
            this.mResponseHeaderStartTimeMs = 0L;
            this.mResponseBodyStartTimeMs = 0L;
            this.mDnsCostTimeMs = 0L;
            this.mConnectCostTimeMs = 0L;
            this.mRequestHeaderCostTimeMs = 0L;
            this.mRequestBodyCostTimeMs = 0L;
            this.mResponseHeaderCostTimeMs = 0L;
            this.mResponseBodyCostTimeMs = 0L;
        }

        public long getCallStartTimeMs() {
            return this.mCallStartTimeMs;
        }

        public long getConnectCostTimeMs() {
            return this.mConnectCostTimeMs;
        }

        public long getConnectStartTimeMs() {
            return this.mConnectStartTimeMs;
        }

        public long getDnsCostTimeMs() {
            return this.mDnsCostTimeMs;
        }

        public long getDnsStartTimeMs() {
            return this.mDnsStartTimeMs;
        }

        public long getRequestBodyCostTimeMs() {
            return this.mRequestBodyCostTimeMs;
        }

        public long getRequestBodyStartTimeMs() {
            return this.mRequestBodyStartTimeMs;
        }

        public long getRequestHeaderCostTimeMs() {
            return this.mRequestHeaderCostTimeMs;
        }

        public long getRequestHeaderStartTimeMs() {
            return this.mRequestHeaderStartTimeMs;
        }

        public long getResponseBodyCostTimeMs() {
            return this.mResponseBodyCostTimeMs;
        }

        public long getResponseBodyStartTimeMs() {
            return this.mResponseBodyStartTimeMs;
        }

        public long getResponseHeaderCostTimeMs() {
            return this.mResponseHeaderCostTimeMs;
        }

        public long getResponseHeaderStartTimeMs() {
            return this.mResponseHeaderStartTimeMs;
        }

        public void setCallStartTimeMs(long j3) {
            this.mCallStartTimeMs = j3;
        }

        public void setConnectCostTimeMs(long j3) {
            this.mConnectCostTimeMs = j3;
        }

        public void setConnectStartTimeMs(long j3) {
            this.mConnectStartTimeMs = j3;
        }

        public void setDnsCostTimeMs(long j3) {
            this.mDnsCostTimeMs = j3;
        }

        public void setDnsStartTimeMs(long j3) {
            this.mDnsStartTimeMs = j3;
        }

        public void setRequestBodyCostTimeMs(long j3) {
            this.mRequestBodyCostTimeMs = j3;
        }

        public void setRequestBodyStartTimeMs(long j3) {
            this.mRequestBodyStartTimeMs = j3;
        }

        public void setRequestHeaderCostTimeMs(long j3) {
            this.mRequestHeaderCostTimeMs = j3;
        }

        public void setRequestHeaderStartTimeMs(long j3) {
            this.mRequestHeaderStartTimeMs = j3;
        }

        public void setResponseBodyCostTimeMs(long j3) {
            this.mResponseBodyCostTimeMs = j3;
        }

        public void setResponseBodyStartTimeMs(long j3) {
            this.mResponseBodyStartTimeMs = j3;
        }

        public void setResponseHeaderCostTimeMs(long j3) {
            this.mResponseHeaderCostTimeMs = j3;
        }

        public void setResponseHeaderStartTimeMs(long j3) {
            this.mResponseHeaderStartTimeMs = j3;
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(@NonNull Call call) {
        TVKLogUtil.i(this.mRequestTag, "callEnd, request url=" + this.mRequestUrl + ", dnsResult=" + this.mDnsResult + ", dnsCostMs=" + this.mTimeRecorder.getDnsCostTimeMs() + ", connectHostIp=" + this.mConnectHostIp + ", usePort=" + this.mPort + ", connectCostMs=" + this.mTimeRecorder.getConnectCostTimeMs() + ", requestCostMs=" + (this.mTimeRecorder.getRequestHeaderCostTimeMs() + this.mTimeRecorder.getRequestBodyCostTimeMs()) + ", responseCostMs=" + (this.mTimeRecorder.getResponseHeaderCostTimeMs() + this.mTimeRecorder.getResponseBodyCostTimeMs()) + ", callCostMs=" + (System.currentTimeMillis() - this.mTimeRecorder.getCallStartTimeMs()));
    }

    @Override // okhttp3.EventListener
    public void callFailed(@NonNull Call call, @NonNull IOException iOException) {
        TVKLogUtil.e(this.mRequestTag, iOException, "callFailed, request url=" + this.mRequestUrl + ", dnsResult=" + this.mDnsResult + ", dnsCostMs=" + this.mTimeRecorder.getDnsCostTimeMs() + ", connectHostIp=" + this.mConnectHostIp + ", usePort=" + this.mPort + ", connectCostMs=" + this.mTimeRecorder.getConnectCostTimeMs() + ", callCostMs=" + (System.currentTimeMillis() - this.mTimeRecorder.getCallStartTimeMs()));
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        this.mRequestTag = "TVKOKHttpEventListener[" + call.request().tag() + "]";
        this.mRequestUrl = call.request().url().getUrl();
        this.mTimeRecorder.setCallStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void canceled(@NonNull Call call) {
        TVKLogUtil.w(this.mRequestTag, "request has been canceled manually");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, Protocol protocol2) {
        this.mConnectHostIp = inetSocketAddress.getAddress();
        this.mPort = inetSocketAddress.getPort();
        this.mTimeRecorder.setConnectCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getConnectStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void connectFailed(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy, Protocol protocol2, @NonNull IOException iOException) {
        this.mConnectHostIp = inetSocketAddress.getAddress();
        this.mPort = inetSocketAddress.getPort();
        this.mTimeRecorder.setConnectCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getConnectStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void connectStart(@NonNull Call call, @NonNull InetSocketAddress inetSocketAddress, @NonNull Proxy proxy) {
        this.mTimeRecorder.setConnectStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(@NonNull Call call, @NonNull String str, @NonNull List<InetAddress> list) {
        this.mDnsResult = list;
        this.mTimeRecorder.setDnsCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getDnsStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void dnsStart(@NonNull Call call, @NonNull String str) {
        this.mTimeRecorder.setDnsStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(@NonNull Call call, long j3) {
        this.mTimeRecorder.setRequestBodyCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getRequestBodyStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(@NonNull Call call) {
        this.mTimeRecorder.setRequestBodyStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(@NonNull Call call, @NonNull Request request) {
        this.mTimeRecorder.setRequestHeaderCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getRequestHeaderStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(@NonNull Call call) {
        this.mTimeRecorder.setRequestHeaderStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(@NonNull Call call, long j3) {
        this.mTimeRecorder.setResponseBodyCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getResponseBodyStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(@NonNull Call call) {
        this.mTimeRecorder.setResponseBodyStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(@NonNull Call call, @NonNull Response response) {
        this.mTimeRecorder.setResponseHeaderCostTimeMs(System.currentTimeMillis() - this.mTimeRecorder.getResponseHeaderStartTimeMs());
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(@NonNull Call call) {
        this.mTimeRecorder.setResponseHeaderStartTimeMs(System.currentTimeMillis());
    }

    @Override // okhttp3.EventListener
    public void requestFailed(@NonNull Call call, @NonNull IOException iOException) {
    }

    @Override // okhttp3.EventListener
    public void responseFailed(@NonNull Call call, @NonNull IOException iOException) {
    }
}
