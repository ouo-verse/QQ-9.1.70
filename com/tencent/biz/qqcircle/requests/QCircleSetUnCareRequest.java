package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;
import qqcircle.QQCircleRight$SetCircleUnCareReq;
import qqcircle.QQCircleRight$SetCircleUnCareRsp;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleSetUnCareRequest extends QCircleBaseRequest {
    private QQCircleRight$SetCircleUnCareReq mRequest;

    public QCircleSetUnCareRequest(String str, int i3, int i16, FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt) {
        QQCircleRight$SetCircleUnCareReq qQCircleRight$SetCircleUnCareReq = new QQCircleRight$SetCircleUnCareReq();
        this.mRequest = qQCircleRight$SetCircleUnCareReq;
        qQCircleRight$SetCircleUnCareReq.strUid.set(str);
        this.mRequest.operType.set(i3);
        this.mRequest.rightType.set(i16);
        if (feedCloudCommon$StCommonExt != null) {
            this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleright.CircleRight.SetCircleUnCare";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleRight$SetCircleUnCareRsp> messageMicro = new MessageMicro<QQCircleRight$SetCircleUnCareRsp>() { // from class: qqcircle.QQCircleRight$SetCircleUnCareRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "result"}, new Object[]{null, 0}, QQCircleRight$SetCircleUnCareRsp.class);
            public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
            public final PBInt32Field result = PBField.initInt32(0);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
