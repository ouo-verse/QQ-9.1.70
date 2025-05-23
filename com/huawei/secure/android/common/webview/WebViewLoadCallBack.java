package com.huawei.secure.android.common.webview;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface WebViewLoadCallBack {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum ErrorCode {
        HTTP_URL,
        URL_NOT_IN_WHITE_LIST,
        OTHER
    }

    void onCheckError(String str, ErrorCode errorCode);
}
