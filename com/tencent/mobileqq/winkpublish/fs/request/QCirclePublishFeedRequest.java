package com.tencent.mobileqq.winkpublish.fs.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StPublishFeedReq;
import feedcloud.FeedCloudWrite$StPublishFeedRsp;

/* loaded from: classes35.dex */
public class QCirclePublishFeedRequest extends QCircleBaseRequest {
    public static final String TAG = "QCirclePublishFeedRequest";
    FeedCloudWrite$StPublishFeedReq mReq;

    public QCirclePublishFeedRequest(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudWrite$StPublishFeedReq feedCloudWrite$StPublishFeedReq = new FeedCloudWrite$StPublishFeedReq();
        this.mReq = feedCloudWrite$StPublishFeedReq;
        feedCloudWrite$StPublishFeedReq.feed.set(feedCloudMeta$StFeed);
        this.mReq.extInfo.set(feedCloudCommon$StCommonExt);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PublishFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StPublishFeedRsp feedCloudWrite$StPublishFeedRsp = new FeedCloudWrite$StPublishFeedRsp();
        try {
            feedCloudWrite$StPublishFeedRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StPublishFeedRsp;
    }
}
