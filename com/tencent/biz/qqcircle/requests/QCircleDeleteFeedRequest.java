package com.tencent.biz.qqcircle.requests;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDelFeedReq;
import feedcloud.FeedCloudWrite$StDelFeedRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleDeleteFeedRequest extends QCircleBaseRequest {
    private FeedCloudMeta$StFeed mStFeed;
    private FeedCloudWrite$StDelFeedReq req;

    public QCircleDeleteFeedRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDelFeedReq feedCloudWrite$StDelFeedReq = new FeedCloudWrite$StDelFeedReq();
        this.req = feedCloudWrite$StDelFeedReq;
        feedCloudWrite$StDelFeedReq.from.set(0);
        this.req.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mStFeed = feedCloudMeta$StFeed;
        addRequestInterceptor(new va0.a());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DelFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    public FeedCloudMeta$StFeed getStFeed() {
        return this.mStFeed;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<FeedCloudWrite$StDelFeedRsp> messageMicro = new MessageMicro<FeedCloudWrite$StDelFeedRsp>() { // from class: feedcloud.FeedCloudWrite$StDelFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, FeedCloudWrite$StDelFeedRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
