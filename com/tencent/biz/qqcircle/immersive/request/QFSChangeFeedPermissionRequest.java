package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$RightInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StRight;
import feedcloud.FeedCloudWrite$StDoTopProfileFeedReq;
import feedcloud.FeedCloudWrite$StModifyUgcRightReq;

/* loaded from: classes4.dex */
public class QFSChangeFeedPermissionRequest extends QCircleBaseRequest {
    private FeedCloudWrite$StModifyUgcRightReq mReq;

    public QFSChangeFeedPermissionRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16) {
        int i3;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        FeedCloudMeta$StRight feedCloudMeta$StRight = new FeedCloudMeta$StRight();
        FeedCloudMeta$RightInfo feedCloudMeta$RightInfo = new FeedCloudMeta$RightInfo();
        feedCloudMeta$RightInfo.rightFlag.set(i3);
        feedCloudMeta$StRight.ugcRight.set(feedCloudMeta$RightInfo);
        feedCloudMeta$StFeed.right.set(feedCloudMeta$StRight);
        FeedCloudWrite$StModifyUgcRightReq feedCloudWrite$StModifyUgcRightReq = new FeedCloudWrite$StModifyUgcRightReq();
        this.mReq = feedCloudWrite$StModifyUgcRightReq;
        feedCloudWrite$StModifyUgcRightReq.feed.set(feedCloudMeta$StFeed);
        QLog.d("QFSChangeFeedPermissionRequest", 2, "create feed permission request: " + i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.ModifyUgcRight";
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
