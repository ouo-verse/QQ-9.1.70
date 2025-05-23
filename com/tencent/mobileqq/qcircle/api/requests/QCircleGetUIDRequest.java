package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetUIDReq;
import feedcloud.FeedCloudRead$StGetUIDRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleGetUIDRequest extends QCircleBaseRequest {
    private final FeedCloudRead$StGetUIDReq mReq;

    public QCircleGetUIDRequest(int i3, String str) {
        FeedCloudRead$StGetUIDReq feedCloudRead$StGetUIDReq = new FeedCloudRead$StGetUIDReq();
        this.mReq = feedCloudRead$StGetUIDReq;
        feedCloudRead$StGetUIDReq.uidScence.set(i3);
        feedCloudRead$StGetUIDReq.userId.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetUID";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetUIDRsp feedCloudRead$StGetUIDRsp = new FeedCloudRead$StGetUIDRsp();
        try {
            feedCloudRead$StGetUIDRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetUIDRsp;
    }
}
