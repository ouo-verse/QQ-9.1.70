package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCirclePrivateMsgShow$StChangePMSettingReq;
import qqcircle.QQCirclePrivateMsgShow$StChangePMSettingRsp;
import qqcircle.QQCirclePrivateMsgShow$StPMSettingData;

/* loaded from: classes5.dex */
public class QCircleChangePMSettingRequest extends QCircleBaseRequest {
    private QQCirclePrivateMsgShow$StChangePMSettingReq mReq;

    public QCircleChangePMSettingRequest(QQCirclePrivateMsgShow$StPMSettingData qQCirclePrivateMsgShow$StPMSettingData) {
        QQCirclePrivateMsgShow$StChangePMSettingReq qQCirclePrivateMsgShow$StChangePMSettingReq = new QQCirclePrivateMsgShow$StChangePMSettingReq();
        this.mReq = qQCirclePrivateMsgShow$StChangePMSettingReq;
        if (qQCirclePrivateMsgShow$StPMSettingData != null) {
            qQCirclePrivateMsgShow$StChangePMSettingReq.setting.set(qQCirclePrivateMsgShow$StPMSettingData);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprivatemsgshow.CirclePrivateMsgShow.ChangePMSetting";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCirclePrivateMsgShow$StChangePMSettingRsp qQCirclePrivateMsgShow$StChangePMSettingRsp = new QQCirclePrivateMsgShow$StChangePMSettingRsp();
        try {
            qQCirclePrivateMsgShow$StChangePMSettingRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCirclePrivateMsgShow$StChangePMSettingRsp;
    }
}
