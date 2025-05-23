package com.tencent.ams.dsdk.fodder;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface BundleEventListener {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface ErrorCode {
        public static final int CANCEL = 3;
        public static final int IO_ERROR = 2;
        public static final int NETWORK_ERROR = 5;
        public static final int OK = 0;
        public static final int OTHER = 6;
        public static final int PARAMS_ERROR = 1;
        public static final int REDIRECT_LIMIT_ERROR = 4;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface StatusCode {
        public static final int NETWORK_ERROR = 1;
        public static final int OK = 0;
        public static final int PARSE_ERROR = 2;
    }

    void onDownloadFinish(String str, @ErrorCode int i3, long j3);

    void onDownloadStart(String str);

    void onRequestBundleConfigFinish(int i3, long j3);

    void onRequestBundleConfigStart();
}
