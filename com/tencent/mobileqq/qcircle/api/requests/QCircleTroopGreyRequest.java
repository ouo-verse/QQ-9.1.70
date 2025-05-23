package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter$GroupInfoReq;
import qqcircle.QQCircleCounter$GroupInfoRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleTroopGreyRequest extends QCircleBaseRequest {
    private QQCircleCounter$GroupInfoReq mReq = new QQCircleCounter$GroupInfoReq();

    public QCircleTroopGreyRequest(List<Long> list) {
        if (list != null) {
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                this.mReq.groupid.add(String.valueOf(it.next().longValue()));
            }
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlecounter.CircleCounter.GetGroupInfo";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QQCircleCounter$GroupInfoRsp qQCircleCounter$GroupInfoRsp = new QQCircleCounter$GroupInfoRsp();
        try {
            qQCircleCounter$GroupInfoRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleCounter$GroupInfoRsp;
    }
}
