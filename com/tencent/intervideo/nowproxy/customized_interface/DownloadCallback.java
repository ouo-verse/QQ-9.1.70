package com.tencent.intervideo.nowproxy.customized_interface;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface DownloadCallback {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ErrorCode {
        public static final int CODE_ERR_EXEPTION = -102;
        public static final int CODE_ERR_INSUFFICENT_SPACE = -101;
        public static final int CODE_ERR_NETWORK_NOT_AVALIBLE = -100;
        public static final int CODE_ERR_OTHER = -103;
        public static final int CODE_SUCCESS = 0;
    }

    void onDownloadCancel();

    void onDownloadError(int i3, int i16, String str);

    void onDownloadSuccess(String str);

    void onProgress(int i3, int i16);
}
