package com.qzone.reborn.qzmoment.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentWriter$StDeleteFeedReq;
import qzonemoment.QZMomentWriter$StDeleteFeedRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMDeleteFeedRequest extends QZMBaseRequest {
    private QZMomentWriter$StDeleteFeedReq mDeleteFeedReq;

    public QZMDeleteFeedRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed) {
        QZMomentWriter$StDeleteFeedReq qZMomentWriter$StDeleteFeedReq = new QZMomentWriter$StDeleteFeedReq();
        this.mDeleteFeedReq = qZMomentWriter$StDeleteFeedReq;
        qZMomentWriter$StDeleteFeedReq.from.set(0);
        if (qZMomentMeta$StFeed != null) {
            this.mDeleteFeedReq.feed.set(qZMomentMeta$StFeed);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "QzoneV3Service.trpc.qz_moment.commwriter.ComWriter.DeleteFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mDeleteFeedReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentWriter$StDeleteFeedRsp qZMomentWriter$StDeleteFeedRsp = new QZMomentWriter$StDeleteFeedRsp();
        try {
            qZMomentWriter$StDeleteFeedRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qZMomentWriter$StDeleteFeedRsp;
    }
}
