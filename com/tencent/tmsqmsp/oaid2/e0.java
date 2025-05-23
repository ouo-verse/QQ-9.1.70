package com.tencent.tmsqmsp.oaid2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e0 {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f380795a;

    /* renamed from: b, reason: collision with root package name */
    public long f380796b;

    /* renamed from: c, reason: collision with root package name */
    public String f380797c;

    /* renamed from: d, reason: collision with root package name */
    public String f380798d;

    public e0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f380797c = str;
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f380796b = j3;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f380796b = 0L;
        }
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f380798d = str;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f380796b > System.currentTimeMillis() : ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f380795a = i3;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }
}
