package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDelFeedReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDelFeedRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeDeleteFeedRequest extends VSBaseRequest {
    private CertifiedAccountWrite$StDelFeedReq req;

    public SubscribeDeleteFeedRequest(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed == null) {
            QLog.w(BaseRequest.TAG, 1, "stfeed is null");
            return;
        }
        CertifiedAccountWrite$StDelFeedReq certifiedAccountWrite$StDelFeedReq = new CertifiedAccountWrite$StDelFeedReq();
        this.req = certifiedAccountWrite$StDelFeedReq;
        certifiedAccountWrite$StDelFeedReq.from.set(0);
        this.req.feed.set(certifiedAccountMeta$StFeed);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_write.DelFeed";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<CertifiedAccountWrite$StDelFeedRsp> messageMicro = new MessageMicro<CertifiedAccountWrite$StDelFeedRsp>() { // from class: NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDelFeedRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CertifiedAccountWrite$StDelFeedRsp.class);
            public COMM.StCommonExt extInfo = new COMM.StCommonExt();
        };
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
