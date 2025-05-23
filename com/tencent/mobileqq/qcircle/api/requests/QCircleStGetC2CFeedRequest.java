package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import feedcloud.FeedCloudRead$StGetC2CFeedReq;
import feedcloud.FeedCloudRead$StGetC2CFeedRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleStGetC2CFeedRequest extends QCircleBaseRequest {
    public FeedCloudRead$StGetC2CFeedReq mReq;

    public QCircleStGetC2CFeedRequest(String str) {
        FeedCloudRead$StGetC2CFeedReq feedCloudRead$StGetC2CFeedReq = new FeedCloudRead$StGetC2CFeedReq();
        this.mReq = feedCloudRead$StGetC2CFeedReq;
        feedCloudRead$StGetC2CFeedReq.userId.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetC2CFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetC2CFeedRsp feedCloudRead$StGetC2CFeedRsp = new FeedCloudRead$StGetC2CFeedRsp();
        try {
            feedCloudRead$StGetC2CFeedRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetC2CFeedRsp;
    }
}
