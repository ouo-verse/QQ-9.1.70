package com.tencent.mobileqq.tianshu.impl.qboss;

import NS_MOBILE_QBOSS_PROTO.MobileQbossReportReq;
import NS_MOBILE_QBOSS_PROTO.MobileQbossReportRsp;
import NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JceStruct f293079d;

    public d(ArrayList<tMobileQbossFeedBackInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) arrayList);
            return;
        }
        MobileQbossReportReq mobileQbossReportReq = new MobileQbossReportReq();
        mobileQbossReportReq.vecMobileQbossFeedBackInfo = arrayList;
        this.f293079d = mobileQbossReportReq;
    }

    public static MobileQbossReportRsp a(byte[] bArr) {
        MobileQbossReportRsp mobileQbossReportRsp;
        if (bArr == null || (mobileQbossReportRsp = (MobileQbossReportRsp) QzoneExternalRequest.decode(bArr, "report")) == null) {
            return null;
        }
        return mobileQbossReportRsp;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QzoneNewService.mobileqboss.report";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JceStruct) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f293079d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "report";
    }
}
