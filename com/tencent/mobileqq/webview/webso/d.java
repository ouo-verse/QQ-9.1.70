package com.tencent.mobileqq.webview.webso;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QzoneExternalRequest;
import wns_proxy.HttpReq;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d extends QzoneExternalRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f315026d;

    /* renamed from: e, reason: collision with root package name */
    private String f315027e;

    /* renamed from: f, reason: collision with root package name */
    private JceStruct f315028f;

    public d(String str, long j3, HttpReq httpReq, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3), httpReq, str2);
            return;
        }
        super.setRefer(str2);
        super.setHostUin(j3);
        super.setLoginUserId(j3);
        this.f315028f = httpReq;
        this.f315026d = str;
        this.needCompress = false;
        this.f315027e = e.q(str);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f315026d;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public JceStruct getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (JceStruct) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f315028f;
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f315027e;
    }
}
