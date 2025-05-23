package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.List;
import qqcircle.QQCircleProfile$CheckBindGroupReq;
import qqcircle.QQCircleProfile$CheckBindGroupRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleCheckBindGroupRequest extends QCircleBaseRequest {
    private QQCircleProfile$CheckBindGroupReq mReq;

    public QCircleCheckBindGroupRequest() {
        this.mReq = new QQCircleProfile$CheckBindGroupReq();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.CheckBindGroup";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleProfile$CheckBindGroupRsp qQCircleProfile$CheckBindGroupRsp = new QQCircleProfile$CheckBindGroupRsp();
        try {
            qQCircleProfile$CheckBindGroupRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleProfile$CheckBindGroupRsp;
    }

    public QCircleCheckBindGroupRequest(List<Long> list, int i3) {
        QQCircleProfile$CheckBindGroupReq qQCircleProfile$CheckBindGroupReq = new QQCircleProfile$CheckBindGroupReq();
        this.mReq = qQCircleProfile$CheckBindGroupReq;
        qQCircleProfile$CheckBindGroupReq.groupIDList.set(list);
        this.mReq.source.set(i3);
    }
}
