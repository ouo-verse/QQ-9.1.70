package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoCommentReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoCommentRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DoCommentRequest extends VSBaseRequest {
    public static final int OPER_TYPE_ADD = 1;
    public static final int OPER_TYPE_DELETE = 0;
    CertifiedAccountWrite$StDoCommentReq req;

    public DoCommentRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, int i3) {
        CertifiedAccountWrite$StDoCommentReq certifiedAccountWrite$StDoCommentReq = new CertifiedAccountWrite$StDoCommentReq();
        this.req = certifiedAccountWrite$StDoCommentReq;
        certifiedAccountWrite$StDoCommentReq.feed.set(certifiedAccountMeta$StFeed);
        this.req.comment.set(certifiedAccountMeta$StComment);
        this.req.commentType.set(i3);
        if (i3 == 1) {
            this.req.comment.f24924id.set("");
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_write.DoComment";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountWrite$StDoCommentRsp certifiedAccountWrite$StDoCommentRsp = new CertifiedAccountWrite$StDoCommentRsp();
        try {
            certifiedAccountWrite$StDoCommentRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountWrite$StDoCommentRsp;
    }
}
