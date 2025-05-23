package com.qzone.reborn.qzmoment.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentWriter$StDoReplyReq;
import qzonemoment.QZMomentWriter$StDoReplyRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMDoReplyRequest extends QZMBaseRequest {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_DELETE = 0;
    public static final int TYPE_OWNER_DELETE = 2;
    public QZMomentWriter$StDoReplyReq mRequest;

    public QZMDoReplyRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, int i3) {
        if (qZMomentMeta$StFeed == null) {
            QLog.e("QZMDoReplyRequest", 1, "feed is null");
            return;
        }
        QZMomentWriter$StDoReplyReq qZMomentWriter$StDoReplyReq = new QZMomentWriter$StDoReplyReq();
        this.mRequest = qZMomentWriter$StDoReplyReq;
        qZMomentWriter$StDoReplyReq.feed.setHasFlag(true);
        this.mRequest.feed.f430362id.set(qZMomentMeta$StFeed.f430362id.get());
        this.mRequest.feed.poster.f430367id.set(qZMomentMeta$StFeed.poster.f430367id.get());
        this.mRequest.feed.poster.setHasFlag(true);
        this.mRequest.feed.createTime.set(qZMomentMeta$StFeed.createTime.get());
        this.mRequest.comment.set(qZMomentMeta$StComment);
        this.mRequest.comment.f430361id.set(qZMomentMeta$StComment.f430361id.get());
        this.mRequest.comment.postUser.f430367id.set(qZMomentMeta$StComment.postUser.f430367id.get());
        this.mRequest.comment.postUser.setHasFlag(true);
        this.mRequest.comment.setHasFlag(true);
        this.mRequest.reply.set(qZMomentMeta$StReply);
        this.mRequest.reply.postUser.clear();
        this.mRequest.reply.postUser.f430367id.set(qZMomentMeta$StReply.postUser.f430367id.get());
        this.mRequest.reply.postUser.setHasFlag(true);
        this.mRequest.replyType.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commwriter.ComWriter.DoReply";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentWriter$StDoReplyRsp qZMomentWriter$StDoReplyRsp = new QZMomentWriter$StDoReplyRsp();
        try {
            qZMomentWriter$StDoReplyRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMDoReplyRequest", 1, e16, new Object[0]);
        }
        return qZMomentWriter$StDoReplyRsp;
    }
}
