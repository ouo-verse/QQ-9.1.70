package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoLikeReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoLikeRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DoLikeRequest extends VSBaseRequest {
    public static final int OPER_TYPE_CANCELL = 0;
    public static final int OPER_TYPE_PRAISED = 1;
    CertifiedAccountWrite$StDoLikeReq req;

    public DoLikeRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        int i3;
        CertifiedAccountWrite$StDoLikeReq certifiedAccountWrite$StDoLikeReq = new CertifiedAccountWrite$StDoLikeReq();
        this.req = certifiedAccountWrite$StDoLikeReq;
        if (certifiedAccountMeta$StFeed == null) {
            return;
        }
        PBUInt32Field pBUInt32Field = certifiedAccountWrite$StDoLikeReq.likeType;
        if (certifiedAccountMeta$StFeed.likeInfo.status.get() == 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        pBUInt32Field.set(i3);
        this.req.like.set(certifiedAccountMeta$StFeed.likeInfo);
        this.req.feed.set(certifiedAccountMeta$StFeed);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "CertifiedAccountSvc.certified_account_write.DoLike";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountWrite$StDoLikeRsp certifiedAccountWrite$StDoLikeRsp = new CertifiedAccountWrite$StDoLikeRsp();
        try {
            certifiedAccountWrite$StDoLikeRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountWrite$StDoLikeRsp;
    }
}
