package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private String f305394g;

    /* renamed from: h, reason: collision with root package name */
    private String f305395h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.mobileqq.uftransfer.proto.f f305396i;

    public g(com.tencent.mobileqq.uftransfer.proto.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f305396i = fVar;
        }
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.f fVar = this.f305396i;
        if (fVar != null) {
            return fVar.a();
        }
        return "";
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305394g;
    }

    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305395h;
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.f fVar = this.f305396i;
        if (fVar != null) {
            return fVar.e();
        }
        return null;
    }

    public void q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f305394g = str;
        }
    }

    public void r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f305395h = str;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.task.taskinfo.e
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DiscUploadSrvBusiProp{");
        sb5.append(super.toString());
        sb5.append("strCheckSum='");
        sb5.append(this.f305394g);
        sb5.append('\'');
        sb5.append(", strSHA='");
        sb5.append(this.f305395h);
        sb5.append('\'');
        sb5.append(", uploadRsp=");
        com.tencent.mobileqq.uftransfer.proto.f fVar = this.f305396i;
        if (fVar != null) {
            str = fVar.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
