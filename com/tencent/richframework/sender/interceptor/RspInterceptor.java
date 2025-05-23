package com.tencent.richframework.sender.interceptor;

import com.tencent.richframework.sender.chain.SenderChain;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface RspInterceptor<Q, E extends SenderChain> {
    void interceptReturnRsp(boolean z16, long j3, String str, Q q16, Object obj, E e16);
}
