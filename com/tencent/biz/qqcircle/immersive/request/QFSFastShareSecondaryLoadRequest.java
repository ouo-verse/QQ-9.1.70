package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadReq;
import feedcloud.FeedCloudRead$StFeedDeatilSecondaryLoadRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFastShareSecondaryLoadRequest extends QCircleBaseRequest {
    protected final FeedCloudRead$StFeedDeatilSecondaryLoadReq mRequest;

    public QFSFastShareSecondaryLoadRequest() {
        FeedCloudRead$StFeedDeatilSecondaryLoadReq feedCloudRead$StFeedDeatilSecondaryLoadReq = new FeedCloudRead$StFeedDeatilSecondaryLoadReq();
        this.mRequest = feedCloudRead$StFeedDeatilSecondaryLoadReq;
        feedCloudRead$StFeedDeatilSecondaryLoadReq.mask.add(6);
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
