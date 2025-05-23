package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFollowFeedsReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFollowFeedsRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeGetFollowFeedsRequest extends VSBaseRequest {
    private CertifiedAccountRead$StGetFollowFeedsReq mReq;

    public SubscribeGetFollowFeedsRequest(COMM.StCommonExt stCommonExt) {
        CertifiedAccountRead$StGetFollowFeedsReq certifiedAccountRead$StGetFollowFeedsReq = new CertifiedAccountRead$StGetFollowFeedsReq();
        this.mReq = certifiedAccountRead$StGetFollowFeedsReq;
        if (stCommonExt != null) {
            certifiedAccountRead$StGetFollowFeedsReq.extInfo.set(stCommonExt);
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "CertifiedAccountSvc.certified_account_read.GetFollowFeeds";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        CertifiedAccountRead$StGetFollowFeedsRsp certifiedAccountRead$StGetFollowFeedsRsp = new CertifiedAccountRead$StGetFollowFeedsRsp();
        try {
            certifiedAccountRead$StGetFollowFeedsRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return certifiedAccountRead$StGetFollowFeedsRsp;
    }

    public SubscribeGetFollowFeedsRequest(COMM.StCommonExt stCommonExt, String str) {
        CertifiedAccountRead$StGetFollowFeedsReq certifiedAccountRead$StGetFollowFeedsReq = new CertifiedAccountRead$StGetFollowFeedsReq();
        this.mReq = certifiedAccountRead$StGetFollowFeedsReq;
        certifiedAccountRead$StGetFollowFeedsReq.livePageInfo.set(str);
        if (stCommonExt != null) {
            this.mReq.extInfo.set(stCommonExt);
        }
    }
}
