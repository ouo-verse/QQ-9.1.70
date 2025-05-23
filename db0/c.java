package db0;

import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.MergeReqInterceptor;
import feedcloud.FeedCloudWrite$StDoPushReq;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends MergeReqInterceptor<QCircleDoRecommendRequest, BaseSenderChain> {

    /* renamed from: a, reason: collision with root package name */
    private int f393490a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f393491b = false;

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getMergeInterval(QCircleDoRecommendRequest qCircleDoRecommendRequest) {
        return 1500L;
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getMergeKey(QCircleDoRecommendRequest qCircleDoRecommendRequest) {
        return qCircleDoRecommendRequest.get$cmd() + qCircleDoRecommendRequest.getReq().feed.f398449id.get();
    }

    @Override // com.tencent.richframework.sender.interceptor.MergeReqInterceptor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public QCircleDoRecommendRequest mergeReq(QCircleDoRecommendRequest qCircleDoRecommendRequest, QCircleDoRecommendRequest qCircleDoRecommendRequest2) {
        if (this.f393491b) {
            return null;
        }
        FeedCloudWrite$StDoPushReq req = qCircleDoRecommendRequest.getReq();
        FeedCloudWrite$StDoPushReq req2 = qCircleDoRecommendRequest2.getReq();
        int i3 = this.f393490a;
        if (i3 != 0) {
            req.comboCount.set(i3);
        } else {
            req.comboCount.set(req.comboCount.get() + req2.comboCount.get());
        }
        qCircleDoRecommendRequest.setReq(req);
        return qCircleDoRecommendRequest;
    }

    public void d(boolean z16) {
        this.f393491b = z16;
    }

    public void e(int i3) {
        this.f393490a = i3;
    }
}
