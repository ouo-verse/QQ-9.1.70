package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleSwitch$SetCircleSwitchReq;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;
import qqcircle.QQCircleSwitch$StSwitch;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSetCircleSwitchRequest extends QCircleBaseRequest {
    private QQCircleSwitch$SetCircleSwitchReq mReq = new QQCircleSwitch$SetCircleSwitchReq();

    public QCircleSetCircleSwitchRequest(String str, String str2, String str3) {
        QQCircleSwitch$StSwitch qQCircleSwitch$StSwitch = new QQCircleSwitch$StSwitch();
        qQCircleSwitch$StSwitch.key.set(str + "." + str2);
        qQCircleSwitch$StSwitch.value.set(str3);
        this.mReq.f429316sw.set(qQCircleSwitch$StSwitch);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetCircleSwitch";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp = new QQCircleSwitch$SetCircleSwitchRsp();
        try {
            qQCircleSwitch$SetCircleSwitchRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleSwitch$SetCircleSwitchRsp;
    }
}
