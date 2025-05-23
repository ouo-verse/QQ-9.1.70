package com.tencent.mobileqq.uftransfer.task.taskinfo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305389g;

    /* renamed from: h, reason: collision with root package name */
    private String f305390h;

    /* renamed from: i, reason: collision with root package name */
    private String f305391i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f305392j;

    /* renamed from: k, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.proto.d f305393k;

    public f(com.tencent.mobileqq.uftransfer.proto.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            return;
        }
        this.f305389g = false;
        this.f305392j = false;
        this.f305393k = dVar;
        if (dVar != null) {
            this.f305389g = dVar.p();
            this.f305392j = dVar.q();
            if (dVar.k() != null && dVar.k().length > 0) {
                this.f305391i = com.tencent.mobileqq.uftransfer.depend.a.z(dVar.k());
            }
        }
    }

    public void A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.f305390h = str;
        }
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f305391i = str;
        }
    }

    public byte[] m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public byte[] n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    public byte[] o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.o();
        }
        return null;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.d();
        }
        return 0;
    }

    public byte[] q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    public byte[] r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.g();
        }
        return null;
    }

    public String s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f305390h;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.l();
        }
        return "";
    }

    @Override // com.tencent.mobileqq.uftransfer.task.taskinfo.e
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("C2CUploadSrvBusiProp{");
        sb5.append(super.toString());
        sb5.append("fileExist=");
        sb5.append(this.f305389g);
        sb5.append(", strCheckSum='");
        sb5.append(this.f305390h);
        sb5.append('\'');
        sb5.append(", strSHA='");
        sb5.append(this.f305391i);
        sb5.append('\'');
        sb5.append(", useMediaPlatform=");
        sb5.append(this.f305392j);
        sb5.append(", uploadRsp=");
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            str = dVar.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305391i;
    }

    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        com.tencent.mobileqq.uftransfer.proto.d dVar = this.f305393k;
        if (dVar != null) {
            return dVar.j();
        }
        return null;
    }

    public com.tencent.mobileqq.uftransfer.proto.d w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.uftransfer.proto.d) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f305393k;
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f305389g;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f305392j;
    }

    public void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f305389g = z16;
        }
    }
}
