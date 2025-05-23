package com.tencent.mobileqq.facetoface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public String f205748c;

    /* renamed from: d, reason: collision with root package name */
    public String f205749d;

    /* renamed from: e, reason: collision with root package name */
    public String f205750e;

    /* renamed from: f, reason: collision with root package name */
    public String f205751f;

    public c(String str, String str2, String str3, String str4, String str5) {
        super(2, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5);
            return;
        }
        this.f205748c = str2;
        this.f205749d = str3;
        this.f205750e = str4;
        this.f205751f = str5;
        if (str3 == null) {
            this.f205749d = "";
        }
        if (this.f205754b == null) {
            this.f205754b = "";
        }
    }

    @Override // com.tencent.mobileqq.facetoface.e
    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f205749d.equals(cVar.f205749d) || !this.f205754b.equals(cVar.f205754b)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.facetoface.e
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f205754b + "_" + this.f205749d;
    }
}
