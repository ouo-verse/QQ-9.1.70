package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l extends m implements t {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public boolean f258730e;

    /* renamed from: f, reason: collision with root package name */
    public v f258731f;

    /* renamed from: h, reason: collision with root package name */
    public k f258732h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f258733i;

    /* renamed from: m, reason: collision with root package name */
    public int f258734m;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f258733i = true;
        this.f258734m = -1;
        this.f258731f = new v();
        this.f258732h = new k();
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        v vVar = this.f258731f;
        if (vVar == null) {
            a("PicFowardInfo.check", "upInfo == null");
            return false;
        }
        int i3 = vVar.f258713h;
        if ((i3 == 1000 || i3 == 1020 || i3 == 1004) && vVar.C == null) {
            a("PicFowardInfo.check", "secondId invalid,uinType:" + this.f258731f.f258713h + ",secondId:" + this.f258731f.C);
            return false;
        }
        if (vVar.Q == -1) {
            a("PicFowardInfo.check", "protocolType invalid,protocolType:" + this.f258731f.Q);
            return false;
        }
        if (!FileUtils.fileExistsAndNotEmpty(vVar.K)) {
            k kVar = this.f258732h;
            if (kVar == null) {
                a("PicFowardInfo.check", "downInfo == null");
                return false;
            }
            if (!kVar.b()) {
                this.f258735d = this.f258732h.f258735d;
                return false;
            }
            return true;
        }
        return true;
    }

    public String c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\nPicFowardInfo");
        v vVar = this.f258731f;
        if (vVar != null) {
            str = vVar.k();
        } else {
            str = "\n |-upInfo=null";
        }
        sb5.append(str);
        sb5.append(this.f258732h);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.pic.t
    public k getPicDownloadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (k) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f258732h;
    }

    @Override // com.tencent.mobileqq.pic.t
    public v getPicUploadInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (v) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f258731f;
    }

    @Override // com.tencent.mobileqq.pic.t
    public boolean isSendFromLocal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.f258733i;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c();
    }
}
