package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qqcircle.QQCircleRight$GetCircleUnCareListReq;
import qqcircle.QQCircleRight$GetCircleUnCareListRsp;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleGetCircleUnCareListRequest extends QCircleBaseRequest {
    public static final int MAX_NUM = c.r2();
    private final QQCircleRight$GetCircleUnCareListReq mRequest;

    public QCircleGetCircleUnCareListRequest(int i3) {
        QQCircleRight$GetCircleUnCareListReq qQCircleRight$GetCircleUnCareListReq = new QQCircleRight$GetCircleUnCareListReq();
        this.mRequest = qQCircleRight$GetCircleUnCareListReq;
        qQCircleRight$GetCircleUnCareListReq.rightType.set(i3);
        qQCircleRight$GetCircleUnCareListReq.num.set(MAX_NUM);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleright.CircleRight.GetCircleUnCareList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleRight$GetCircleUnCareListRsp qQCircleRight$GetCircleUnCareListRsp = new QQCircleRight$GetCircleUnCareListRsp();
        try {
            qQCircleRight$GetCircleUnCareListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleRight$GetCircleUnCareListRsp;
    }
}
