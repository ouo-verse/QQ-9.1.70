package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleClient$TaskInfosReq;
import qqcircle.QQCircleClient$TaskInfosRsp;

/* loaded from: classes5.dex */
public class QFSPushGetTaskInfoRequest extends QCircleBaseRequest {
    private QQCircleClient$TaskInfosReq mRequest;

    public QFSPushGetTaskInfoRequest(int i3) {
        QQCircleClient$TaskInfosReq qQCircleClient$TaskInfosReq = new QQCircleClient$TaskInfosReq();
        this.mRequest = qQCircleClient$TaskInfosReq;
        qQCircleClient$TaskInfosReq.group.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.task_center_client.TaskCenterClient.GetTaskInfos";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleClient$TaskInfosRsp qQCircleClient$TaskInfosRsp = new QQCircleClient$TaskInfosRsp();
        try {
            qQCircleClient$TaskInfosRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleClient$TaskInfosRsp;
    }
}
