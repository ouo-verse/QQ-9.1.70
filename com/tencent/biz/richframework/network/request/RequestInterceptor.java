package com.tencent.biz.richframework.network.request;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface RequestInterceptor {
    void interceptRequest(BaseRequest baseRequest);

    void interceptResponse(Object[] objArr);
}
