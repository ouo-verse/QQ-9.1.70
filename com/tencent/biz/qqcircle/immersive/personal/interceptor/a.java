package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import com.tencent.biz.qqcircle.immersive.personal.request.QFSDoCollectRequest;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.MergeReqInterceptor;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends MergeReqInterceptor<QFSDoCollectRequest, BaseSenderChain> {
    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getMergeInterval(QFSDoCollectRequest qFSDoCollectRequest) {
        return 500L;
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getMergeKey(QFSDoCollectRequest qFSDoCollectRequest) {
        return qFSDoCollectRequest.getKey();
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public QFSDoCollectRequest mergeReq(QFSDoCollectRequest qFSDoCollectRequest, QFSDoCollectRequest qFSDoCollectRequest2) {
        return null;
    }
}
