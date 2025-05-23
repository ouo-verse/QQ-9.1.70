package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleCountergroup$GetGroupCountReq;
import qqcircle.QQCircleCountergroup$GetGroupCountRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQCircleGetGroupCountRequest extends QCircleBaseRequest {
    private QQCircleCountergroup$GetGroupCountReq mReq;

    public QQCircleGetGroupCountRequest(long j3) {
        QQCircleCountergroup$GetGroupCountReq qQCircleCountergroup$GetGroupCountReq = new QQCircleCountergroup$GetGroupCountReq();
        this.mReq = qQCircleCountergroup$GetGroupCountReq;
        qQCircleCountergroup$GetGroupCountReq.gid.set(j3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlecountergroup.CircleCounterGroup.GetGroupCount";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleCountergroup$GetGroupCountRsp qQCircleCountergroup$GetGroupCountRsp = new QQCircleCountergroup$GetGroupCountRsp();
        try {
            qQCircleCountergroup$GetGroupCountRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleCountergroup$GetGroupCountRsp;
    }
}
