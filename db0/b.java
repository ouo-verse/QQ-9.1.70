package db0;

import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.MergeReqInterceptor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends MergeReqInterceptor<QCircleDoLikeRequest, BaseSenderChain> {
    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getMergeInterval(QCircleDoLikeRequest qCircleDoLikeRequest) {
        return 500L;
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getMergeKey(QCircleDoLikeRequest qCircleDoLikeRequest) {
        return qCircleDoLikeRequest.getStFeed().f398449id.get();
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public QCircleDoLikeRequest mergeReq(QCircleDoLikeRequest qCircleDoLikeRequest, QCircleDoLikeRequest qCircleDoLikeRequest2) {
        return null;
    }
}
