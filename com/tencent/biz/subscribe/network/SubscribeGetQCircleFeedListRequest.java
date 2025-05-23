package com.tencent.biz.subscribe.network;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeGetQCircleFeedListRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetFeedListReq mRequest;

    public SubscribeGetQCircleFeedListRequest(int i3) {
        FeedCloudRead$StGetFeedListReq feedCloudRead$StGetFeedListReq = new FeedCloudRead$StGetFeedListReq();
        this.mRequest = feedCloudRead$StGetFeedListReq;
        feedCloudRead$StGetFeedListReq.source.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        if (this.mRequest.source.get() == 46) {
            return "FeedCloudSvr.trpc.feedcloud.commreader.QQSubscription.GetFeedListDiscovery";
        }
        return "FeedCloudSvr.trpc.feedcloud.commreader.QQSubscription.GetFeedListSubscription";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp = new FeedCloudRead$StGetFeedListRsp();
        try {
            feedCloudRead$StGetFeedListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedListRsp;
    }
}
