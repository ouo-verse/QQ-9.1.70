package com.tencent.richframework.sender.interceptor;

import com.tencent.richframework.sender.chain.SenderChain;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ReqInterceptor<T, E extends SenderChain> {
    void interceptAddReq(T t16, E e16);
}
