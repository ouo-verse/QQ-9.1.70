package com.tencent.biz.richframework.network.request;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes5.dex */
public class SubscribePersonalDetailRequest extends VSBaseRequest {
    private CertifiedAccountRead$StGetMainPageReq req;

    public SubscribePersonalDetailRequest(String str, COMM.StCommonExt stCommonExt) {
        CertifiedAccountRead$StGetMainPageReq certifiedAccountRead$StGetMainPageReq = new CertifiedAccountRead$StGetMainPageReq();
        this.req = certifiedAccountRead$StGetMainPageReq;
        if (str != null) {
            certifiedAccountRead$StGetMainPageReq.userId.set(str);
        }
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "CertifiedAccountSvc.certified_account_read.GetMainPage";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = new CertifiedAccountRead$StGetMainPageRsp();
        try {
            certifiedAccountRead$StGetMainPageRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetMainPageRsp;
    }
}
