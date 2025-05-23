package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;
import qqcircle.QQCircleLightinteract$StBatchDoUrgeReq;
import qqcircle.QQCircleLightinteract$StBatchDoUrgeRsp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBatchDoUrgeRequest extends QCircleBaseRequest {
    private QQCircleLightinteract$StBatchDoUrgeReq mBatchDoUrgeReq;

    public QFSBatchDoUrgeRequest(List<String> list) {
        QQCircleLightinteract$StBatchDoUrgeReq qQCircleLightinteract$StBatchDoUrgeReq = new QQCircleLightinteract$StBatchDoUrgeReq();
        this.mBatchDoUrgeReq = qQCircleLightinteract$StBatchDoUrgeReq;
        if (list != null) {
            qQCircleLightinteract$StBatchDoUrgeReq.userIDs.set(list);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circlelightinteract.CircleLightInteract.BatchDoUrge";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mBatchDoUrgeReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleLightinteract$StBatchDoUrgeRsp> messageMicro = new MessageMicro<QQCircleLightinteract$StBatchDoUrgeRsp>() { // from class: qqcircle.QQCircleLightinteract$StBatchDoUrgeRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"urgeTimes"}, new Object[]{null}, QQCircleLightinteract$StBatchDoUrgeRsp.class);
            public final PBRepeatMessageField<QQCircleLightinteract$StDoUrgeTimeInfo> urgeTimes = PBField.initRepeatMessage(QQCircleLightinteract$StDoUrgeTimeInfo.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
