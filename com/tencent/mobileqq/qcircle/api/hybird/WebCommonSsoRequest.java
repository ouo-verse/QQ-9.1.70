package com.tencent.mobileqq.qcircle.api.hybird;

import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StWebCommJsonReq;
import feedcloud.FeedCloudCommon$StWebCommJsonRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class WebCommonSsoRequest extends QCircleBaseRequest {
    private final String mCmdName;
    private final FeedCloudCommon$StWebCommJsonReq mRequest;

    public WebCommonSsoRequest(String str, String str2) {
        this.mCmdName = str;
        FeedCloudCommon$StWebCommJsonReq feedCloudCommon$StWebCommJsonReq = new FeedCloudCommon$StWebCommJsonReq();
        this.mRequest = feedCloudCommon$StWebCommJsonReq;
        feedCloudCommon$StWebCommJsonReq.data.set(ByteStringMicro.copyFromUtf8(str2));
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return this.mCmdName;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        FeedCloudCommon$StWebCommJsonRsp feedCloudCommon$StWebCommJsonRsp = new FeedCloudCommon$StWebCommJsonRsp();
        try {
            feedCloudCommon$StWebCommJsonRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(BaseRequest.TAG, 1, "StWebCommJsonRsp parse error: ", e16);
        }
        return feedCloudCommon$StWebCommJsonRsp;
    }
}
