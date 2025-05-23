package com.qzone.reborn.qzmoment.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StLike;
import qzonemoment.QZMomentReader$StGetCommentListReq;
import qzonemoment.QZMomentReader$StGetCommentListRsp;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMGetCommentListRequest extends QZMBaseRequest {
    public QZMomentReader$StGetCommentListReq mRequest;

    public QZMGetCommentListRequest(QZMomentMeta$StFeed qZMomentMeta$StFeed, String str) {
        QZMomentReader$StGetCommentListReq qZMomentReader$StGetCommentListReq = new QZMomentReader$StGetCommentListReq();
        this.mRequest = qZMomentReader$StGetCommentListReq;
        if (qZMomentMeta$StFeed != null) {
            qZMomentReader$StGetCommentListReq.feedUserID.set(qZMomentMeta$StFeed.poster.f430367id.get());
            this.mRequest.feedID.set(qZMomentMeta$StFeed.f430362id.get());
            this.mRequest.commentCount.set(qZMomentMeta$StFeed.commentCount.get());
            QZMomentMeta$StLike qZMomentMeta$StLike = qZMomentMeta$StFeed.likeInfo;
            if (qZMomentMeta$StLike != null) {
                this.mRequest.likeKey.set(qZMomentMeta$StLike.f430363id.get());
            }
            this.mRequest.listNum.set(10);
        }
        if (str != null) {
            this.mRequest.feedAttchInfo.set(str);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "QzoneV3Service.trpc.qz_moment.commreader.ComReader.GetCommentList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.mRequest.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        QZMomentReader$StGetCommentListRsp qZMomentReader$StGetCommentListRsp = new QZMomentReader$StGetCommentListRsp();
        try {
            qZMomentReader$StGetCommentListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QZMGetCommentListRequest", 1, e16, new Object[0]);
        }
        return qZMomentReader$StGetCommentListRsp;
    }
}
