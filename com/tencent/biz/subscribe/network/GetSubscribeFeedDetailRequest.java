package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFeedDetailRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GetSubscribeFeedDetailRequest extends VSBaseRequest {
    private CertifiedAccountRead$StGetFeedDetailReq req;

    public GetSubscribeFeedDetailRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        this(certifiedAccountMeta$StFeed, null, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_read.GetFeedDetail";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    public GetSubscribeFeedDetailRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, COMM.StCommonExt stCommonExt) {
        this(certifiedAccountMeta$StFeed, stCommonExt, null);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetFeedDetailRsp certifiedAccountRead$StGetFeedDetailRsp = new CertifiedAccountRead$StGetFeedDetailRsp();
        try {
            certifiedAccountRead$StGetFeedDetailRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetFeedDetailRsp;
    }

    public GetSubscribeFeedDetailRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, COMM.StCommonExt stCommonExt, String str) {
        if (certifiedAccountMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        CertifiedAccountRead$StGetFeedDetailReq certifiedAccountRead$StGetFeedDetailReq = new CertifiedAccountRead$StGetFeedDetailReq();
        this.req = certifiedAccountRead$StGetFeedDetailReq;
        certifiedAccountRead$StGetFeedDetailReq.from.set(0);
        this.req.userId.set(certifiedAccountMeta$StFeed.poster.f24929id.get());
        this.req.feedId.set(certifiedAccountMeta$StFeed.f24925id.get());
        this.req.createTime.set(certifiedAccountMeta$StFeed.createTime.get());
        if (stCommonExt != null) {
            this.req.extInfo.set(stCommonExt.get());
        }
    }
}
