package com.tencent.mobileqq.weiyun.api.impl;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weiyun.channel.d;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$MsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$ReqMsgBody;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$RspMsgBody;
import com.tencent.mobileqq.weiyun.utils.g;
import com.tencent.weiyun.transmission.ErrorCode;

/* compiled from: P */
/* loaded from: classes20.dex */
class a<T> implements d.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final String f315137c;

    /* renamed from: a, reason: collision with root package name */
    private final int f315138a;

    /* renamed from: b, reason: collision with root package name */
    private final x43.a<T> f315139b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f315137c = HardCodeUtil.qqStr(R.string.jww);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i3, x43.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aVar);
        } else {
            this.f315138a = i3;
            this.f315139b = aVar;
        }
    }

    @Override // com.tencent.mobileqq.weiyun.channel.d.b
    public void a(int i3, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bArr);
            return;
        }
        x43.a<T> aVar = this.f315139b;
        if (aVar == null) {
            return;
        }
        if (i3 == 0 && bArr != null) {
            try {
                WeiyunPB$RspMsgBody weiyunPB$RspMsgBody = new WeiyunPB$MsgBody().mergeFrom(bArr).RspMsg_body.get();
                if (weiyunPB$RspMsgBody == null) {
                    g.a().w("BaseCallback", "rspMsgBody is null.");
                    this.f315139b.onError(ErrorCode.CMD_RECV_INVALID_BUFFER, f315137c, null);
                    return;
                }
                switch (this.f315138a) {
                    case 2402:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.DiskFileBatchDownloadMsgRsp_body);
                        return;
                    case 2414:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.DiskFileDocDownloadAbsMsgRsp_body);
                        return;
                    case 2509:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.DiskDirFileBatchDeleteExMsgRsp_body);
                        return;
                    case 2803:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.DiskPicBackupRsp_body);
                        return;
                    case 2804:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.DiskAlbumStatusReportRsp_body);
                        return;
                    case 11001:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.PwdQueryMsgRsp_body);
                        return;
                    case 11005:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.PwdVerifyMsgRsp_body);
                        return;
                    case WeiyunPB$ReqMsgBody.WEIYUNSHAREADDFROMMOBILEQQMSGREQ_BODY_FIELD_NUMBER /* 12102 */:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.WeiyunShareAddFromMobileQQMsgRsp_body);
                        return;
                    case 26113:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.LibInfoListGetMsgRsp_body);
                        return;
                    case 245700:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.CrossBidProxyCopyFileToOtherBidMsgRsp_body);
                        return;
                    case 245706:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.CrossBidProxyOfflineFileGetListMsgRsp_body);
                        return;
                    case 246000:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.QqSdkFileUploadMsgRsp_body);
                        return;
                    case 246001:
                        this.f315139b.onSuccess(weiyunPB$RspMsgBody.AioPicAndVideoCopyToWeiyunMsgRsp_body);
                        return;
                    default:
                        this.f315139b.onError(ErrorCode.CMD_INVALID_CMD, f315137c, null);
                        return;
                }
            } catch (Throwable th5) {
                g.a().w("BaseCallback", "decode Rsp Body failed.", th5);
                this.f315139b.onError(ErrorCode.CMD_RECV_INVALID_BUFFER, f315137c, null);
                return;
            }
        }
        aVar.onError(i3, str, null);
    }
}
