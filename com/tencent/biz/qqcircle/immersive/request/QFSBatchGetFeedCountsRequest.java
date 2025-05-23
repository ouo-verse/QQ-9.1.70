package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedCountsReq;
import feedcloud.FeedCloudRead$StBatchGetFeedCountsRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBatchGetFeedCountsRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StBatchGetFeedCountsReq mRequest;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends QCircleBaseRequest.a<QFSBatchGetFeedCountsRequest> {

        /* renamed from: c, reason: collision with root package name */
        private final FeedCloudRead$StBatchGetFeedCountsReq f89833c;

        public a() {
            FeedCloudRead$StBatchGetFeedCountsReq feedCloudRead$StBatchGetFeedCountsReq = new FeedCloudRead$StBatchGetFeedCountsReq();
            this.f89833c = feedCloudRead$StBatchGetFeedCountsReq;
            feedCloudRead$StBatchGetFeedCountsReq.filterFeed.set(true);
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleBaseRequest.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public QFSBatchGetFeedCountsRequest b() {
            QFSBatchGetFeedCountsRequest qFSBatchGetFeedCountsRequest = new QFSBatchGetFeedCountsRequest(this.f89833c);
            this.f91858a = qFSBatchGetFeedCountsRequest;
            return qFSBatchGetFeedCountsRequest;
        }

        public a f(List<FeedCloudMeta$StFeed> list) {
            this.f89833c.vecFeed.set(list);
            return this;
        }
    }

    QFSBatchGetFeedCountsRequest(FeedCloudRead$StBatchGetFeedCountsReq feedCloudRead$StBatchGetFeedCountsReq) {
        this.mRequest = feedCloudRead$StBatchGetFeedCountsReq;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.BatchGetFeedCounts";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StBatchGetFeedCountsRsp feedCloudRead$StBatchGetFeedCountsRsp = new FeedCloudRead$StBatchGetFeedCountsRsp();
        try {
            feedCloudRead$StBatchGetFeedCountsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StBatchGetFeedCountsRsp;
    }
}
