package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudRead$StGetSessionInfoReq;
import feedcloud.FeedCloudRead$StGetSessionInfoRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleGetSessionInfoRequest extends QCircleBaseRequest {
    private FeedCloudRead$StGetSessionInfoReq mReq;

    public QCircleGetSessionInfoRequest(FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt, int i3) {
        setRetryCount(2);
        FeedCloudRead$StGetSessionInfoReq feedCloudRead$StGetSessionInfoReq = new FeedCloudRead$StGetSessionInfoReq();
        this.mReq = feedCloudRead$StGetSessionInfoReq;
        if (feedCloudCommon$StCommonExt != null) {
            feedCloudRead$StGetSessionInfoReq.extInfo.set(feedCloudCommon$StCommonExt);
        }
        this.mReq.scene.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetSessionInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public boolean isNeedRetry(long j3) {
        QLog.d(BaseRequest.TAG, 1, "CmdName:", getCmdName(), ",retCode:", Long.valueOf(j3), "isNeedRetry:true");
        return true;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudRead$StGetSessionInfoRsp feedCloudRead$StGetSessionInfoRsp = new FeedCloudRead$StGetSessionInfoRsp();
        try {
            feedCloudRead$StGetSessionInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudRead$StGetSessionInfoRsp;
    }
}
