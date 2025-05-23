package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import NS_MOBILE_QBOSS_PROTO.ReportExceptionInfo;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JceStruct f293077d;

    public a(long j3, int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        ReportExceptionInfo reportExceptionInfo = new ReportExceptionInfo();
        reportExceptionInfo.iCode = i17;
        reportExceptionInfo.iAppid = i3;
        reportExceptionInfo.iTaskId = i16;
        reportExceptionInfo.strMsg = str;
        arrayList.add(reportExceptionInfo);
        this.f293077d = new MobileQbossReportExceptionReq(j3, arrayList);
    }

    public static MobileQbossReportExceptionRsp a(byte[] bArr) {
        MobileQbossReportExceptionRsp mobileQbossReportExceptionRsp;
        if (bArr == null || (mobileQbossReportExceptionRsp = (MobileQbossReportExceptionRsp) QzoneExternalRequest.decode(bArr, "reportException")) == null) {
            return null;
        }
        return mobileQbossReportExceptionRsp;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QzoneNewService.mobileqboss.reportException";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JceStruct) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f293077d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "reportException";
    }
}
