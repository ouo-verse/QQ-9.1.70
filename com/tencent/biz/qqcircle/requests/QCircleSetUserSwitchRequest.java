package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import qqcircle.QQCircleProfile$SetUserSwitchReq;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSetUserSwitchRequest extends QCircleBaseRequest {
    private QQCircleProfile$SetUserSwitchReq mReq;

    public QCircleSetUserSwitchRequest(int i3, int i16) {
        QQCircleProfile$SetUserSwitchReq qQCircleProfile$SetUserSwitchReq = new QQCircleProfile$SetUserSwitchReq();
        this.mReq = qQCircleProfile$SetUserSwitchReq;
        qQCircleProfile$SetUserSwitchReq.switchType.set(i3);
        this.mReq.value.set(i16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SetUserSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleProfile$SetUserSwitchRsp> messageMicro = new MessageMicro<QQCircleProfile$SetUserSwitchRsp>() { // from class: qqcircle.QQCircleProfile$SetUserSwitchRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"value"}, new Object[]{0}, QQCircleProfile$SetUserSwitchRsp.class);
            public final PBInt32Field value = PBField.initInt32(0);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
