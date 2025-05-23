package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public JceStruct f279328d;

    public a(long j3, operation_red_touch_req operation_red_touch_reqVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), operation_red_touch_reqVar);
            return;
        }
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.f279328d = operation_red_touch_reqVar;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "QzoneNewService.asy_photo.OperationRedTouch";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (JceStruct) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f279328d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "OperationRedTouch";
    }
}
