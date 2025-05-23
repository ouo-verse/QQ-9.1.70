package com.tencent.hippykotlin.demo.pages.qwallet.base.http.interceptor;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface IQWalletInterceptor {
    void onAfterSend(InterceptorData interceptorData);

    Object onBeforeSend(InterceptorData interceptorData);
}
