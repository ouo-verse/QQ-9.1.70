package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoTopProfileFeedReq;

/* loaded from: classes4.dex */
public class QFSDoTopProfileFeedRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$StDoTopProfileFeedReq mReq;

    public QFSDoTopProfileFeedRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        FeedCloudWrite$StDoTopProfileFeedReq feedCloudWrite$StDoTopProfileFeedReq = new FeedCloudWrite$StDoTopProfileFeedReq();
        this.mReq = feedCloudWrite$StDoTopProfileFeedReq;
        feedCloudWrite$StDoTopProfileFeedReq.feed.set(feedCloudMeta$StFeed);
        feedCloudWrite$StDoTopProfileFeedReq.topFeedType.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoTopProfileFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StDoTopProfileFeedReq feedCloudWrite$StDoTopProfileFeedReq = new FeedCloudWrite$StDoTopProfileFeedReq();
        try {
            feedCloudWrite$StDoTopProfileFeedReq.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoTopProfileFeedReq;
    }
}
