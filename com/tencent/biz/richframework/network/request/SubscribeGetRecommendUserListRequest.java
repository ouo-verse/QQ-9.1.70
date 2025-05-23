package com.tencent.biz.richframework.network.request;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetRecommendUserListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetRecommendUserListRsp;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeGetRecommendUserListRequest extends VSBaseRequest {
    private CertifiedAccountRead$StGetRecommendUserListReq req;

    public SubscribeGetRecommendUserListRequest(String str, COMM.StCommonExt stCommonExt, int i3, int i16) {
        CertifiedAccountRead$StGetRecommendUserListReq certifiedAccountRead$StGetRecommendUserListReq = new CertifiedAccountRead$StGetRecommendUserListReq();
        this.req = certifiedAccountRead$StGetRecommendUserListReq;
        certifiedAccountRead$StGetRecommendUserListReq.userId.set(str);
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt);
        }
        this.req.listNum.set(i3);
        this.req.from.set(i16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "CertifiedAccountSvc.certified_account_read.GetRecommendUserList";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetRecommendUserListRsp certifiedAccountRead$StGetRecommendUserListRsp = new CertifiedAccountRead$StGetRecommendUserListRsp();
        try {
            certifiedAccountRead$StGetRecommendUserListRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetRecommendUserListRsp;
    }
}
