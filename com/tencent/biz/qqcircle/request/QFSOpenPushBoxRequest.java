package com.tencent.biz.qqcircle.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import feedcloud.FeedCloudWrite$PushBoxDrawRocketReq;
import feedcloud.FeedCloudWrite$PushBoxDrawRocketRsp;

/* loaded from: classes5.dex */
public class QFSOpenPushBoxRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$PushBoxDrawRocketReq mRequest;

    public QFSOpenPushBoxRequest(FeedCloudWrite$PushBoxBasic feedCloudWrite$PushBoxBasic) {
        FeedCloudWrite$PushBoxDrawRocketReq feedCloudWrite$PushBoxDrawRocketReq = new FeedCloudWrite$PushBoxDrawRocketReq();
        this.mRequest = feedCloudWrite$PushBoxDrawRocketReq;
        feedCloudWrite$PushBoxDrawRocketReq.drawBox.set(feedCloudWrite$PushBoxBasic);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PushBoxDrawRocket";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$PushBoxDrawRocketRsp decode(byte[] bArr) {
        FeedCloudWrite$PushBoxDrawRocketRsp feedCloudWrite$PushBoxDrawRocketRsp = new FeedCloudWrite$PushBoxDrawRocketRsp();
        try {
            feedCloudWrite$PushBoxDrawRocketRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$PushBoxDrawRocketRsp;
    }
}
