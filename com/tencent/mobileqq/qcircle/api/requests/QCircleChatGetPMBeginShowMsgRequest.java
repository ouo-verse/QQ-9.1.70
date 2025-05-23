package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq;
import qqcircle.QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp;

/* loaded from: classes16.dex */
public class QCircleChatGetPMBeginShowMsgRequest extends QCircleBaseRequest {
    private QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq mReq;

    public QCircleChatGetPMBeginShowMsgRequest(String str) {
        QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq qQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq = new QQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq();
        this.mReq = qQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq;
        qQCirclePrivateMsgAIO$StGetPMBeginShowMsgReq.userId.set(str);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprivatemsgaio.CirclePrivateMsgAio.GetPMBeginShowMsgReq";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp = new QQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp();
        try {
            qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCirclePrivateMsgAIO$StGetPMBeginShowMsgRsp;
    }
}
