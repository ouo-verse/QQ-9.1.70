package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$GetDecorationReq;
import feedcloud.FeedCloudRead$GetDecorationRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSGetDecorationRequest extends QCircleBaseRequest {
    private final FeedCloudRead$GetDecorationReq mRequest;

    public QFSGetDecorationRequest(String str) {
        FeedCloudRead$GetDecorationReq feedCloudRead$GetDecorationReq = new FeedCloudRead$GetDecorationReq();
        this.mRequest = feedCloudRead$GetDecorationReq;
        feedCloudRead$GetDecorationReq.decoration_id.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetDecoration";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$GetDecorationRsp feedCloudRead$GetDecorationRsp = new FeedCloudRead$GetDecorationRsp();
        try {
            feedCloudRead$GetDecorationRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$GetDecorationRsp;
    }
}
