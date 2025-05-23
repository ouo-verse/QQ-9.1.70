package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleClient$ReceiveAwardReq;
import qqcircle.QQCircleClient$ReceiveAwardRsp;

/* loaded from: classes5.dex */
public class QFSPushTaskReceiveAwardRequest extends QCircleBaseRequest {
    private QQCircleClient$ReceiveAwardReq mRequest;

    public QFSPushTaskReceiveAwardRequest(int i3) {
        QQCircleClient$ReceiveAwardReq qQCircleClient$ReceiveAwardReq = new QQCircleClient$ReceiveAwardReq();
        this.mRequest = qQCircleClient$ReceiveAwardReq;
        qQCircleClient$ReceiveAwardReq.f429294id.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.task_center_client.TaskCenterClient.ReceiveAward";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleClient$ReceiveAwardRsp> messageMicro = new MessageMicro<QQCircleClient$ReceiveAwardRsp>() { // from class: qqcircle.QQCircleClient$ReceiveAwardRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleClient$ReceiveAwardRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
