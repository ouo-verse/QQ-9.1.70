package com.tencent.mobileqq.ad.report;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.report;

/* loaded from: classes10.dex */
public class SsoPushReportRequest extends VSBaseRequest {
    static IPatchRedirector $redirector_;
    private final report.SsoPushReportReq mPushReportReq;

    public SsoPushReportRequest(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        report.SsoPushReportReq ssoPushReportReq = new report.SsoPushReportReq();
        this.mPushReportReq = ssoPushReportReq;
        ssoPushReportReq.account_type.set(aVar.f186909a);
        ssoPushReportReq.platform.set(aVar.f186910b);
        ssoPushReportReq.qimei36.set(aVar.f186911c);
        ssoPushReportReq.province.set(aVar.f186912d);
        ssoPushReportReq.operator.set(aVar.f186913e);
        ssoPushReportReq.app_version.set(aVar.f186914f);
        ssoPushReportReq.model.set(aVar.f186915g);
        ssoPushReportReq.os_version.set(aVar.f186916h);
        ssoPushReportReq.event_code.set(aVar.f186917i);
        ssoPushReportReq.oper_name.set(aVar.f186918j);
        ssoPushReportReq.module.set(aVar.f186919k);
        ssoPushReportReq.action.set(aVar.f186920l);
        ssoPushReportReq.ext1.set(aVar.f186921m);
        ssoPushReportReq.ext2.set(aVar.f186922n);
        ssoPushReportReq.ext3.set(aVar.f186923o);
        ssoPushReportReq.ext4.set(aVar.f186924p);
        ssoPushReportReq.ext5.set(aVar.f186925q);
        ssoPushReportReq.ext6.set(aVar.f186926r);
        ssoPushReportReq.ext7.set(aVar.f186927s);
        ssoPushReportReq.ext8.set(aVar.f186928t);
        ssoPushReportReq.ext9.set(aVar.f186929u);
        ssoPushReportReq.ext10.set(aVar.f186930v);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getCmdName */
    public String get$cmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "trpc.commercial.dataworks.UserActionReport_sso.SsoPushReport";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    /* renamed from: getRequestByteData */
    protected byte[] get$pbReqBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mPushReportReq.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public byte[] getRequestWrapper(ByteStringMicro byteStringMicro) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) byteStringMicro);
        }
        return this.mPushReportReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    public Object[] parseResponseHeadInfo(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Object[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr);
        }
        return new Object[]{0L, "", fh.a(bArr)};
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageMicro) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
        }
        report.SsoPushReportRsp ssoPushReportRsp = new report.SsoPushReportRsp();
        try {
            ssoPushReportRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("SsoPushReportRequest", 1, "decode error:", e16);
        }
        return ssoPushReportRsp;
    }
}
