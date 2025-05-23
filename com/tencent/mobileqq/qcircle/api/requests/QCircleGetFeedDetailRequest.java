package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedDetailReq;
import feedcloud.FeedCloudRead$StGetFeedDetailRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleGetFeedDetailRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetFeedDetailReq mRequest;

    public QCircleGetFeedDetailRequest(String str, String str2, long j3, boolean z16) {
        this(str, str2, j3, z16, 0, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    public QCircleGetFeedDetailRequest(String str, String str2, long j3, boolean z16, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StFeed simpleFeed;
        FeedCloudRead$StGetFeedDetailReq feedCloudRead$StGetFeedDetailReq = new FeedCloudRead$StGetFeedDetailReq();
        this.mRequest = feedCloudRead$StGetFeedDetailReq;
        feedCloudRead$StGetFeedDetailReq.feedId.set(str);
        this.mRequest.userId.set(str2);
        this.mRequest.createTime.set(j3);
        this.mRequest.useUGCStore.set(z16);
        this.mRequest.from.set(i3);
        if (feedCloudMeta$StFeed == null || (simpleFeed = QCircleHostUtil.getSimpleFeed(feedCloudMeta$StFeed)) == null) {
            return;
        }
        simpleFeed.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
        this.mRequest.entryFeed.set(simpleFeed);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetFeedDetailRsp feedCloudRead$StGetFeedDetailRsp = new FeedCloudRead$StGetFeedDetailRsp();
        try {
            feedCloudRead$StGetFeedDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetFeedDetailRsp;
    }
}
