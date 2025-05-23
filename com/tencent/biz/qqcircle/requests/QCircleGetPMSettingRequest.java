package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCirclePrivateMsgShow$StGetPMSettingReq;
import qqcircle.QQCirclePrivateMsgShow$StGetPMSettingRsp;

/* loaded from: classes5.dex */
public class QCircleGetPMSettingRequest extends QCircleBaseRequest {
    private QQCirclePrivateMsgShow$StGetPMSettingReq mReq;

    public QCircleGetPMSettingRequest(String str) {
        QQCirclePrivateMsgShow$StGetPMSettingReq qQCirclePrivateMsgShow$StGetPMSettingReq = new QQCirclePrivateMsgShow$StGetPMSettingReq();
        this.mReq = qQCirclePrivateMsgShow$StGetPMSettingReq;
        qQCirclePrivateMsgShow$StGetPMSettingReq.uid.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.GetPMSetting";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCirclePrivateMsgShow$StGetPMSettingRsp qQCirclePrivateMsgShow$StGetPMSettingRsp = new QQCirclePrivateMsgShow$StGetPMSettingRsp();
        try {
            qQCirclePrivateMsgShow$StGetPMSettingRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCirclePrivateMsgShow$StGetPMSettingRsp;
    }
}
