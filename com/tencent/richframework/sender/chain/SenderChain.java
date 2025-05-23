package com.tencent.richframework.sender.chain;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface SenderChain<Q> {
    void addRequest(Q q16);

    void handleRsp(boolean z16, long j3, String str, Q q16, Object obj);
}
