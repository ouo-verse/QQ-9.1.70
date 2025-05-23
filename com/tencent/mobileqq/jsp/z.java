package com.tencent.mobileqq.jsp;

import NS_MOBILE_EXTRA.mobile_get_urlinfo_req;
import QMF_PROTOCAL.RetryInfo;
import com.qq.taf.jce.JceStruct;
import com.qzone.publish.business.protocol.QZoneGetUrlInfoRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;

/* compiled from: P */
/* loaded from: classes15.dex */
public class z extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private JceStruct f238921d;

    public z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        mobile_get_urlinfo_req mobile_get_urlinfo_reqVar = new mobile_get_urlinfo_req();
        mobile_get_urlinfo_reqVar.url = str;
        this.f238921d = mobile_get_urlinfo_reqVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QzoneNewService.getUrlInfo";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JceStruct) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f238921d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public Object getRetryInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new RetryInfo((short) 0, 0, System.currentTimeMillis());
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return QZoneGetUrlInfoRequest.CMD_STRING;
    }
}
