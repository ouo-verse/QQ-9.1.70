package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305397g;

    /* renamed from: h, reason: collision with root package name */
    private String f305398h;

    /* renamed from: i, reason: collision with root package name */
    private String f305399i;

    /* renamed from: j, reason: collision with root package name */
    private j f305400j;

    public h(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jVar);
        } else {
            this.f305397g = false;
            this.f305400j = jVar;
        }
    }

    public byte[] m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    public byte[] n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    public byte[] o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (byte[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null && !TextUtils.isEmpty(jVar.c())) {
            return this.f305400j.c().getBytes();
        }
        return null;
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.c();
        }
        return "";
    }

    public List<String> q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    public List<String> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.e();
        }
        return null;
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.f();
        }
        return 0;
    }

    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.i();
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
        sb5.append("TroopUploadSrvBusiProp{");
        sb5.append(super.toString());
        sb5.append("fileExist=");
        sb5.append(this.f305397g);
        sb5.append(", strCheckSum='");
        sb5.append(this.f305398h);
        sb5.append('\'');
        sb5.append(", strSHA='");
        sb5.append(this.f305399i);
        sb5.append('\'');
        sb5.append(", uploadRsp=");
        j jVar = this.f305400j;
        if (jVar != null) {
            str = jVar.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305398h;
    }

    public String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305399i;
    }

    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        j jVar = this.f305400j;
        if (jVar != null) {
            return jVar.j();
        }
        return "";
    }

    public j x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (j) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f305400j;
    }

    public void y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f305398h = str;
        }
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f305399i = str;
        }
    }
}
