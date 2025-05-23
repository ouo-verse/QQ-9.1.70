package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetCommentListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetCommentListRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GetCommentListRequest extends VSBaseRequest {
    CertifiedAccountRead$StGetCommentListReq req;

    public GetCommentListRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, COMM.StCommonExt stCommonExt, int i3) {
        CertifiedAccountRead$StGetCommentListReq certifiedAccountRead$StGetCommentListReq = new CertifiedAccountRead$StGetCommentListReq();
        this.req = certifiedAccountRead$StGetCommentListReq;
        certifiedAccountRead$StGetCommentListReq.feedId.set(certifiedAccountMeta$StFeed.f24925id.get());
        this.req.userId.set(certifiedAccountMeta$StFeed.poster.f24929id.get());
        this.req.extInfo.set(stCommonExt);
        this.req.listNum.set(i3);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_read.GetCommentList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetCommentListRsp certifiedAccountRead$StGetCommentListRsp = new CertifiedAccountRead$StGetCommentListRsp();
        try {
            certifiedAccountRead$StGetCommentListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetCommentListRsp;
    }
}
