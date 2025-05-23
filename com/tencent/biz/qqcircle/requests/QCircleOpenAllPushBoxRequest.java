package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudWrite$PushBoxDrawAllReq;
import feedcloud.FeedCloudWrite$PushBoxDrawAllRsp;

/* loaded from: classes5.dex */
public class QCircleOpenAllPushBoxRequest extends QCircleBaseRequest {
    private final FeedCloudWrite$PushBoxDrawAllReq mRequest = new FeedCloudWrite$PushBoxDrawAllReq();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PushBoxDrawAll";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public FeedCloudWrite$PushBoxDrawAllRsp decode(byte[] bArr) {
        FeedCloudWrite$PushBoxDrawAllRsp feedCloudWrite$PushBoxDrawAllRsp = new FeedCloudWrite$PushBoxDrawAllRsp();
        try {
            feedCloudWrite$PushBoxDrawAllRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudWrite$PushBoxDrawAllRsp;
    }
}
