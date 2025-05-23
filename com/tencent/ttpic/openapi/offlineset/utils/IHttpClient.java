package com.tencent.ttpic.openapi.offlineset.utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IHttpClient {
    void download(int i3, String str, String str2, String str3);

    void get(int i3, String str, String str2);

    void post(int i3, String str, String str2);

    void setResponseListener(IResponseListener iResponseListener);
}
