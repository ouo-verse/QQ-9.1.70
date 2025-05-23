package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudWrite$StDoBarrageReq;
import feedcloud.FeedCloudWrite$StDoBarrageRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSDoBarrageRequest extends QCircleBaseRequest {
    public static final int OPER_TYPE_ADD = 1;
    public static final int OPER_TYPE_DELETE = 0;
    public static final String TAG = "QDM-QFSDoBarrageRequest";
    private FeedCloudWrite$StDoBarrageReq mReq;

    public QFSDoBarrageRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
        if (feedCloudMeta$StFeed == null) {
            QLog.w(TAG, 1, "stfeed is null");
            return;
        }
        FeedCloudWrite$StDoBarrageReq feedCloudWrite$StDoBarrageReq = new FeedCloudWrite$StDoBarrageReq();
        this.mReq = feedCloudWrite$StDoBarrageReq;
        feedCloudWrite$StDoBarrageReq.feed.set(QCirclePluginUtil.getSimpleFeed(feedCloudMeta$StFeed));
        this.mReq.barrage.set(feedCloudMeta$StBarrage);
        this.mReq.barrageType.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoBarrage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudWrite$StDoBarrageRsp feedCloudWrite$StDoBarrageRsp = new FeedCloudWrite$StDoBarrageRsp();
        try {
            feedCloudWrite$StDoBarrageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$StDoBarrageRsp;
    }
}
