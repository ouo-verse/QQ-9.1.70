package com.tencent.biz.qqcircle.rerank.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailReq;
import feedcloud.FeedCloudRead$StBatchGetFeedDetailRsp;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRankEdgeGetDetailsReq extends QCircleBaseRequest {
    public FeedCloudRead$StBatchGetFeedDetailReq mRequest;

    public QFSRankEdgeGetDetailsReq(List<FeedCloudMeta$StFeed> list) {
        FeedCloudRead$StBatchGetFeedDetailReq feedCloudRead$StBatchGetFeedDetailReq = new FeedCloudRead$StBatchGetFeedDetailReq();
        this.mRequest = feedCloudRead$StBatchGetFeedDetailReq;
        feedCloudRead$StBatchGetFeedDetailReq.from.set(0);
        this.mRequest.feedIndex.set(list);
        this.mRequest.source.set(10);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.BatchGetFeedDetail";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StBatchGetFeedDetailRsp feedCloudRead$StBatchGetFeedDetailRsp = new FeedCloudRead$StBatchGetFeedDetailRsp();
        try {
            feedCloudRead$StBatchGetFeedDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StBatchGetFeedDetailRsp;
    }

    public QFSRankEdgeGetDetailsReq(List<FeedCloudMeta$StFeed> list, int i3) {
        FeedCloudRead$StBatchGetFeedDetailReq feedCloudRead$StBatchGetFeedDetailReq = new FeedCloudRead$StBatchGetFeedDetailReq();
        this.mRequest = feedCloudRead$StBatchGetFeedDetailReq;
        feedCloudRead$StBatchGetFeedDetailReq.from.set(0);
        this.mRequest.feedIndex.set(list);
        this.mRequest.source.set(i3);
    }
}
