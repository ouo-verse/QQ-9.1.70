package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleSwitch$GetCirclePopupReq;
import qqcircle.QQCircleSwitch$GetCirclePopupRsp;

/* loaded from: classes5.dex */
public class QCircleTabPopWindowGetRequest extends QCircleBaseRequest {
    private final QQCircleSwitch$GetCirclePopupReq mRequest = new MessageMicro<QQCircleSwitch$GetCirclePopupReq>() { // from class: qqcircle.QQCircleSwitch$GetCirclePopupReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleSwitch$GetCirclePopupReq.class);
    };

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.GetCirclePopup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSwitch$GetCirclePopupRsp qQCircleSwitch$GetCirclePopupRsp = new QQCircleSwitch$GetCirclePopupRsp();
        try {
            qQCircleSwitch$GetCirclePopupRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSwitch$GetCirclePopupRsp;
    }
}
