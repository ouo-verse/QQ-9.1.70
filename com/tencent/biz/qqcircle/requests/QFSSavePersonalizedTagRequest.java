package com.tencent.biz.qqcircle.requests;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.List;
import qqcircle.QQCircleProfile$ContentFirstClass;
import qqcircle.QQCircleProfile$SavePersonalizedTagReq;
import qqcircle.QQCircleProfile$SavePersonalizedTagRsp;

/* loaded from: classes5.dex */
public class QFSSavePersonalizedTagRequest extends QCircleBaseRequest {
    private final QQCircleProfile$SavePersonalizedTagReq mReq;

    public QFSSavePersonalizedTagRequest(@NonNull List<QQCircleProfile$ContentFirstClass> list) {
        QQCircleProfile$SavePersonalizedTagReq qQCircleProfile$SavePersonalizedTagReq = new QQCircleProfile$SavePersonalizedTagReq();
        this.mReq = qQCircleProfile$SavePersonalizedTagReq;
        qQCircleProfile$SavePersonalizedTagReq.scene.set(1);
        qQCircleProfile$SavePersonalizedTagReq.tags.set(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.videocircle.circleprofile.CircleProfile.SavePersonalizedTag";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleProfile$SavePersonalizedTagRsp> messageMicro = new MessageMicro<QQCircleProfile$SavePersonalizedTagRsp>() { // from class: qqcircle.QQCircleProfile$SavePersonalizedTagRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QQCircleProfile$SavePersonalizedTagRsp.class);
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
