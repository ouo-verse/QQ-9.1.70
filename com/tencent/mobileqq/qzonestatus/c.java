package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public JceStruct f280140d;

    public c(newest_feeds_req newest_feeds_reqVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) newest_feeds_reqVar);
            return;
        }
        super.setHostUin(newest_feeds_reqVar.login_uin);
        super.setLoginUserId(newest_feeds_reqVar.login_uin);
        this.f280140d = newest_feeds_reqVar;
    }

    public static newest_feeds_rsp a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (newest_feeds_rsp) QzoneExternalRequest.decode(bArr, "getAIONewestFeeds");
    }

    public static newest_feeds_rsp b(byte[] bArr, int[] iArr) {
        if (bArr == null) {
            return null;
        }
        return (newest_feeds_rsp) QzoneExternalRequest.decode(bArr, "getAIONewestFeeds", iArr);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QzoneNewService.getAIONewestFeeds";
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JceStruct) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f280140d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "getAIONewestFeeds";
    }
}
