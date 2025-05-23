package com.tencent.biz.subscribe.network;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoTipOffReq;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoTipOffRsp;
import NS_COMM.COMM;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DoTipOffRequest extends VSBaseRequest {
    private CertifiedAccountWrite$StDoTipOffReq req;

    public DoTipOffRequest(int i3, CertifiedAccountMeta$StUser certifiedAccountMeta$StUser, CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed, int i16) {
        CertifiedAccountWrite$StDoTipOffReq certifiedAccountWrite$StDoTipOffReq = new CertifiedAccountWrite$StDoTipOffReq();
        this.req = certifiedAccountWrite$StDoTipOffReq;
        certifiedAccountWrite$StDoTipOffReq.tipOffType.set(i3);
        if (certifiedAccountMeta$StUser != null) {
            this.req.user.set(certifiedAccountMeta$StUser);
        }
        if (certifiedAccountMeta$StFeed != null) {
            this.req.feed.set(certifiedAccountMeta$StFeed);
        }
        this.req.feedbackType.set(i16);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        return "CertifiedAccountSvc.certified_account_write.DoTipOff";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        return this.req.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<CertifiedAccountWrite$StDoTipOffRsp> messageMicro = new MessageMicro<CertifiedAccountWrite$StDoTipOffRsp>() { // from class: NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite$StDoTipOffRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, CertifiedAccountWrite$StDoTipOffRsp.class);
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
