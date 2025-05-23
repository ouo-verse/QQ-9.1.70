package com.pay.http;

/* loaded from: classes2.dex */
public interface IAPHttpAns {
    void onError(APBaseHttpReq aPBaseHttpReq, int i3, String str);

    void onFinish(APBaseHttpReq aPBaseHttpReq);

    void onReceive(byte[] bArr, int i3, long j3, APBaseHttpReq aPBaseHttpReq);

    void onStart(APBaseHttpReq aPBaseHttpReq);

    void onStop(APBaseHttpReq aPBaseHttpReq);
}
