package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadReq;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetFeedDetailSecondaryLoadRequest extends QCircleBaseRequest {
    protected final FeedCloudRead$StFeedDeatilSecondaryLoadReq mRequest;

    public QFSGetFeedDetailSecondaryLoadRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudRead$StFeedDeatilSecondaryLoadReq feedCloudRead$StFeedDeatilSecondaryLoadReq = new FeedCloudRead$StFeedDeatilSecondaryLoadReq();
        this.mRequest = feedCloudRead$StFeedDeatilSecondaryLoadReq;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSGetFeedDetailSecondaryLoadRequest", 1, "[QFSGetFeedDetailSecondaryLoadRequest] sourceFeed is null");
            return;
        }
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.createTime.set(feedCloudMeta$StFeed.createTime.get());
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.poster.set(feedCloudMeta$StFeed.poster.get());
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.setHasFlag(true);
        feedCloudRead$StFeedDeatilSecondaryLoadReq.feed.poster.setHasFlag(true);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader_feeds.ComReader.FeedDeatilSecondaryLoad";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public byte[] getRequestByteKey() {
        return getRequestByteData();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StFeedDeatilSecondaryLoadRsp feedCloudRead$StFeedDeatilSecondaryLoadRsp = new FeedCloudRead$StFeedDeatilSecondaryLoadRsp();
        try {
            feedCloudRead$StFeedDeatilSecondaryLoadRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StFeedDeatilSecondaryLoadRsp;
    }
}
