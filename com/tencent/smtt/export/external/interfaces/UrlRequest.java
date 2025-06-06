package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class UrlRequest {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Builder {
        public static final int REQUEST_PRIORITY_HIGHEST = 4;
        public static final int REQUEST_PRIORITY_IDLE = 0;
        public static final int REQUEST_PRIORITY_LOW = 2;
        public static final int REQUEST_PRIORITY_LOWEST = 1;
        public static final int REQUEST_PRIORITY_MEDIUM = 3;

        public abstract Builder addHeader(String str, String str2);

        public abstract UrlRequest build();

        public abstract Builder disableCache();

        public abstract Builder setDns(String str, String str2);

        public abstract Builder setHttpMethod(String str);

        public abstract Builder setPriority(int i3);

        public abstract Builder setRequestBody(String str);

        public abstract Builder setRequestBodyBytes(byte[] bArr);
    }

    public abstract void cancel();

    public abstract void followRedirect();

    public abstract boolean isDone();

    public abstract void read(ByteBuffer byteBuffer);

    public abstract void start();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class Callback {
        public abstract void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, X5netException x5netException);

        public abstract void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

        public abstract void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception;

        public abstract void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception;

        public abstract void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo);

        public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        }

        public void shouldInterceptResponseHeader(UrlRequest urlRequest, HashMap<String, String> hashMap) {
        }
    }
}
