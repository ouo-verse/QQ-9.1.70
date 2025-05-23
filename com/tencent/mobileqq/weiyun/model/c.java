package com.tencent.mobileqq.weiyun.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c implements Cloneable {
    static IPatchRedirector $redirector_;
    public String C;
    public String D;
    public b E;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f315182d;

    /* renamed from: e, reason: collision with root package name */
    public int f315183e;

    /* renamed from: f, reason: collision with root package name */
    public String f315184f;

    /* renamed from: h, reason: collision with root package name */
    public long f315185h;

    /* renamed from: i, reason: collision with root package name */
    public long f315186i;

    /* renamed from: m, reason: collision with root package name */
    public String f315187m;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f315182d = 0;
        this.f315183e = 0;
        this.f315184f = "";
        this.f315185h = 0L;
        this.f315186i = 0L;
        this.f315187m = "";
        this.C = "";
        this.D = "";
    }

    public boolean a() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f315182d == 0 || this.f315182d == 5 || this.f315182d == 3) {
            return true;
        }
        if (this.f315182d == 1 && ((i3 = this.f315183e) == 1810003 || i3 == 1810004)) {
            return true;
        }
        return false;
    }

    public boolean b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f315182d == 1 && (i3 = this.f315183e) != 1810003 && i3 != 1810004) {
            return true;
        }
        return false;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f315182d == 0 || this.f315182d == 1 || this.f315182d == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (c) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean e() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.f315182d == 1 && ((i3 = this.f315183e) == 1810003 || i3 == 1810004)) {
            return true;
        }
        return false;
    }
}
