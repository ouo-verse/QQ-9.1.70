package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleSwitch$SetCirclePopupReq;
import qqcircle.QQCircleSwitch$SetCirclePopupRsp;

/* loaded from: classes5.dex */
public class QCircleTabPopWindowSetRequest extends QCircleBaseRequest {
    private final QQCircleSwitch$SetCirclePopupReq mRequest;

    public QCircleTabPopWindowSetRequest(String str, int i3, int i16) {
        QQCircleSwitch$SetCirclePopupReq qQCircleSwitch$SetCirclePopupReq = new QQCircleSwitch$SetCirclePopupReq();
        this.mRequest = qQCircleSwitch$SetCirclePopupReq;
        if (str != null) {
            qQCircleSwitch$SetCirclePopupReq.key.set(str);
            qQCircleSwitch$SetCirclePopupReq.type.set(i3);
            qQCircleSwitch$SetCirclePopupReq.action.set(i16);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetCirclePopup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleSwitch$SetCirclePopupRsp> messageMicro = new MessageMicro<QQCircleSwitch$SetCirclePopupRsp>() { // from class: qqcircle.QQCircleSwitch$SetCirclePopupRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleSwitch$SetCirclePopupRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
