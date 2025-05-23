package com.qzone.reborn.qzmoment.request;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StLike;
import qzonemoment.QZMomentWriter$StDoLikeReq;
import qzonemoment.QZMomentWriter$StDoLikeRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMDoLikeRequest extends QZMBaseRequest {
    public QZMomentWriter$StDoLikeReq mRequest;

    public QZMDoLikeRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StLike qZMomentMeta$StLike, int i3) {
        if (qZMomentMeta$StFeed == null) {
            QLog.w("QZMDoLikeRequest", 1, "feed is null");
            return;
        }
        if (qZMomentMeta$StLike == null) {
            QLog.e("QZMDoLikeRequest", 1, "like is null");
            return;
        }
        QZMomentWriter$StDoLikeReq qZMomentWriter$StDoLikeReq = new QZMomentWriter$StDoLikeReq();
        this.mRequest = qZMomentWriter$StDoLikeReq;
        qZMomentWriter$StDoLikeReq.likeType.set(i3);
        this.mRequest.like.set(qZMomentMeta$StFeed.likeInfo);
        this.mRequest.like.postUser.clear();
        this.mRequest.like.postUser.setHasFlag(true);
        this.mRequest.like.postUser.f430367id.set(LoginData.getInstance().getUinString());
        this.mRequest.feed.setHasFlag(true);
        this.mRequest.feed.f430362id.set(qZMomentMeta$StFeed.f430362id.get());
        this.mRequest.feed.poster.setHasFlag(true);
        this.mRequest.feed.poster.f430367id.set(qZMomentMeta$StFeed.poster.f430367id.get());
        this.mRequest.feed.createTime.set(qZMomentMeta$StFeed.createTime.get());
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commwriter.ComWriter.DoLike";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentWriter$StDoLikeRsp qZMomentWriter$StDoLikeRsp = new QZMomentWriter$StDoLikeRsp();
        try {
            qZMomentWriter$StDoLikeRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMDoLikeRequest", 1, "decode error: ", e16);
        }
        return qZMomentWriter$StDoLikeRsp;
    }
}
