package com.tencent.biz.qqcircle.requests;

import java.io.IOException;
import trpcprotocol.feedcloud.comment.SimpleComment;
import trpcprotocol.feedcloud.comment.SubmitCommentForRanCommentReviewReq;
import trpcprotocol.feedcloud.comment.SubmitCommentForRanCommentReviewRsp;

/* loaded from: classes5.dex */
public class QFSPushRanCommentRequest extends QCircleBaseRequest {
    private final SimpleComment mSimpleComment;
    private final int mSubmitTouchType;

    public QFSPushRanCommentRequest(String str, String str2, int i3) {
        this.mSimpleComment = new SimpleComment.a().c(str).b(str2).build();
        this.mSubmitTouchType = i3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "FeedCloudSvr.trpc.feedcloud.comment.WriterAccess.SubmitCommentForRanCommentReview";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        SubmitCommentForRanCommentReviewReq.a aVar = new SubmitCommentForRanCommentReviewReq.a();
        aVar.b(this.mSimpleComment).c(this.mSubmitTouchType);
        return aVar.build().encode();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public SubmitCommentForRanCommentReviewRsp decode(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return SubmitCommentForRanCommentReviewRsp.ADAPTER.decode(bArr);
        } catch (IOException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
