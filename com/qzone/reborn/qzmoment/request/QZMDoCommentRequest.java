package com.qzone.reborn.qzmoment.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentWriter$StDoCommentReq;
import qzonemoment.QZMomentWriter$StDoCommentRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMDoCommentRequest extends QZMBaseRequest {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_DELETE = 0;
    public static final int TYPE_OWNER_DELETE = 2;
    public QZMomentWriter$StDoCommentReq mRequest;

    public QZMDoCommentRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, int i3) {
        if (qZMomentMeta$StFeed == null) {
            QLog.w("QZMDoCommentRequest", 1, "feed is null");
            return;
        }
        if (qZMomentMeta$StComment == null) {
            QLog.e("QZMDoCommentRequest", 1, "comment is null");
            return;
        }
        QZMomentWriter$StDoCommentReq qZMomentWriter$StDoCommentReq = new QZMomentWriter$StDoCommentReq();
        this.mRequest = qZMomentWriter$StDoCommentReq;
        qZMomentWriter$StDoCommentReq.feed.setHasFlag(true);
        this.mRequest.feed.f430362id.set(qZMomentMeta$StFeed.f430362id.get());
        this.mRequest.feed.poster.setHasFlag(true);
        this.mRequest.feed.poster.f430367id.set(qZMomentMeta$StFeed.poster.f430367id.get());
        this.mRequest.feed.createTime.set(qZMomentMeta$StFeed.createTime.get());
        this.mRequest.comment.set(qZMomentMeta$StComment);
        this.mRequest.comment.postUser.clear();
        this.mRequest.comment.postUser.setHasFlag(true);
        this.mRequest.comment.postUser.f430367id.set(qZMomentMeta$StComment.postUser.f430367id.get());
        this.mRequest.commentType.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commwriter.ComWriter.DoComment";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentWriter$StDoCommentRsp qZMomentWriter$StDoCommentRsp = new QZMomentWriter$StDoCommentRsp();
        try {
            qZMomentWriter$StDoCommentRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qZMomentWriter$StDoCommentRsp;
    }
}
