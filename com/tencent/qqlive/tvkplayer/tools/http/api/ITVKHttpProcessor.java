package com.tencent.qqlive.tvkplayer.tools.http.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public interface ITVKHttpProcessor {
    public static final long DEFAULT_DNS_TIMEOUT_MS = 2000;
    public static final long DEFAULT_HTTP_CALL_TIMEOUT_MS = 5000;
    public static final long DEFAULT_HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static final String DEFAULT_NETWORK_INTERFACE = "0";
    public static final String DEFAULT_PARAM_ENCODING_FORMAT = "UTF-8";
    public static final String HTTP_REQUEST_CONTENT_TYPE_VALUE_FORM = "application/x-www-form-urlencoded; charset=utf-8";
    public static final String HTTP_REQUEST_CONTENT_TYPE_VALUE_JSON = "application/json";
    public static final String HTTP_REQUEST_CONTENT_TYPE_VALUE_OCTET = "application/octet-stream";
    public static final String HTTP_REQUEST_CONTENT_TYPE_VALUE_XML = "application/xml; charset=utf-8";
    public static final String HTTP_REQUEST_HEADER_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_REQUEST_HOST = "host";
    public static final String HTTP_REQUEST_NETWORK_INTERFACE_SPECIFIER = "Http-Nic-Specifier";
    public static final String MULTI_NIC_CELLULAR_NETWORK = "1";

    /* loaded from: classes23.dex */
    public interface ITVKHttpCallback {
        void onFailure(@NonNull IOException iOException);

        void onSuccess(@NonNull TVKHttpResponse tVKHttpResponse);
    }

    /* loaded from: classes23.dex */
    public static final class InvalidResponseCodeException extends IOException {
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        public InvalidResponseCodeException(int i3, @Nullable String str) {
            super("Response code: " + i3 + ", Response message: " + str);
            this.responseCode = i3;
            this.responseMessage = str;
        }
    }

    /* loaded from: classes23.dex */
    public static class TVKHttpRequest {

        @NonNull
        private final List<String> mBackHosts;

        @Nullable
        private byte[] mBody;
        private long mCallTimeoutMs;
        private long mConnectTimeoutMs;
        private long mDnsTimeoutMs;

        @Nullable
        private Map<String, String> mHeaders;

        @NonNull
        private final HttpMethod mHttpMethod;

        @NonNull
        private String mReqTag;
        private boolean mRetryCellularOnWifiFailure;

        @NonNull
        private String mUrl;
        private boolean mUseHttpDns;

        /* loaded from: classes23.dex */
        public static class Builder {
            private final TVKHttpRequest request;

            public Builder(@NonNull HttpMethod httpMethod, @NonNull String str) {
                TVKHttpRequest tVKHttpRequest = new TVKHttpRequest(httpMethod);
                this.request = tVKHttpRequest;
                tVKHttpRequest.mUrl = TextUtils.isEmpty(str) ? "" : str;
            }

            public Builder addBackupHost(@NonNull String str) {
                this.request.mBackHosts.add(str);
                return this;
            }

            public Builder addBackupHosts(@NonNull List<String> list) {
                this.request.mBackHosts.addAll(list);
                return this;
            }

            public Builder body(@Nullable byte[] bArr) {
                this.request.mBody = bArr;
                return this;
            }

            public TVKHttpRequest build() {
                return this.request;
            }

            public Builder callTimeoutMs(long j3) {
                this.request.mCallTimeoutMs = j3;
                return this;
            }

            public Builder connectTimeoutMs(long j3) {
                this.request.mConnectTimeoutMs = j3;
                return this;
            }

            public Builder dnsTimeoutMs(long j3) {
                this.request.mDnsTimeoutMs = j3;
                return this;
            }

            public Builder headers(@Nullable Map<String, String> map) {
                this.request.mHeaders = map;
                return this;
            }

            public Builder httpDns(boolean z16) {
                this.request.mUseHttpDns = z16;
                return this;
            }

            public Builder reqTag(@Nullable String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.request.mReqTag = str;
                    return this;
                }
                return this;
            }

            public Builder retryCellularOnWifiFailure(boolean z16) {
                this.request.mRetryCellularOnWifiFailure = z16;
                return this;
            }
        }

        /* loaded from: classes23.dex */
        public enum HttpMethod {
            GET,
            POST,
            PUT,
            DELETE
        }

        @NonNull
        public List<String> getBackHosts() {
            return this.mBackHosts;
        }

        @Nullable
        public byte[] getBody() {
            return this.mBody;
        }

        public long getCallTimeoutMs() {
            return this.mCallTimeoutMs;
        }

        public long getConnectTimeoutMs() {
            return this.mConnectTimeoutMs;
        }

        public long getDnsTimeoutMs() {
            return this.mDnsTimeoutMs;
        }

        @Nullable
        public Map<String, String> getHeaders() {
            return this.mHeaders;
        }

        @NonNull
        public HttpMethod getHttpMethod() {
            return this.mHttpMethod;
        }

        @NonNull
        public String getReqTag() {
            return this.mReqTag;
        }

        @NonNull
        public String getUrl() {
            return this.mUrl;
        }

        public boolean retryCellularOnWifiFailure() {
            return this.mRetryCellularOnWifiFailure;
        }

        public boolean useHttpDns() {
            return this.mUseHttpDns;
        }

        TVKHttpRequest(@NonNull HttpMethod httpMethod) {
            this.mReqTag = "";
            this.mUrl = "";
            this.mBody = null;
            this.mHeaders = null;
            this.mBackHosts = new ArrayList();
            this.mUseHttpDns = false;
            this.mRetryCellularOnWifiFailure = false;
            this.mDnsTimeoutMs = 2000L;
            this.mConnectTimeoutMs = 5000L;
            this.mCallTimeoutMs = 5000L;
            this.mHttpMethod = httpMethod;
        }
    }

    /* loaded from: classes23.dex */
    public static class TVKHttpResponse {
        private final byte[] mData;
        private final Map<String, List<String>> mHeaders;

        public TVKHttpResponse(Map<String, List<String>> map, byte[] bArr) {
            this.mHeaders = map;
            this.mData = bArr;
        }

        public byte[] getData() {
            return this.mData;
        }

        public Map<String, List<String>> getHeaders() {
            return this.mHeaders;
        }
    }

    void cancelRequest(String str);

    TVKHttpResponse execute(@NonNull TVKHttpRequest tVKHttpRequest) throws IOException;

    void executeAsync(@NonNull TVKHttpRequest tVKHttpRequest, @NonNull ITVKHttpCallback iTVKHttpCallback);
}
