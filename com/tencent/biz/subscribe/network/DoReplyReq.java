package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoReplyReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoReplyRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DoReplyReq extends VSBaseRequest {
    public static final int OPER_TYPE_ADD = 1;
    public static final int OPER_TYPE_DELETE = 0;
    CertifiedAccountWrite$StDoReplyReq req;

    public DoReplyReq(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, CertifiedAccountMeta$StComment certifiedAccountMeta$StComment, CertifiedAccountMeta$StReply certifiedAccountMeta$StReply, int i3) {
        CertifiedAccountWrite$StDoReplyReq certifiedAccountWrite$StDoReplyReq = new CertifiedAccountWrite$StDoReplyReq();
        this.req = certifiedAccountWrite$StDoReplyReq;
        certifiedAccountWrite$StDoReplyReq.feed.set(certifiedAccountMeta$StFeed);
        this.req.comment.set(certifiedAccountMeta$StComment);
        this.req.reply.set(certifiedAccountMeta$StReply);
        this.req.replyType.set(i3);
        if (i3 == 1) {
            this.req.reply.f24928id.set("");
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_write.DoReply";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountWrite$StDoReplyRsp certifiedAccountWrite$StDoReplyRsp = new CertifiedAccountWrite$StDoReplyRsp();
        try {
            certifiedAccountWrite$StDoReplyRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountWrite$StDoReplyRsp;
    }
}
