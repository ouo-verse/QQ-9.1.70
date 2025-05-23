package com.tencent.qimei.ae;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f342956a;

    /* renamed from: b, reason: collision with root package name */
    public String f342957b;

    /* renamed from: c, reason: collision with root package name */
    public String f342958c;

    /* renamed from: d, reason: collision with root package name */
    public String f342959d;

    /* renamed from: e, reason: collision with root package name */
    public String f342960e;

    /* renamed from: f, reason: collision with root package name */
    public String f342961f;

    /* renamed from: g, reason: collision with root package name */
    public String f342962g;

    /* renamed from: h, reason: collision with root package name */
    public String f342963h;

    /* renamed from: i, reason: collision with root package name */
    public String f342964i;

    /* renamed from: j, reason: collision with root package name */
    public String f342965j;

    /* renamed from: k, reason: collision with root package name */
    public String f342966k;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final boolean a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? str2 == null ? str == null : str2.equals(str) : ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).booleanValue();
    }

    public final boolean b(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (str2 == null) {
            return true;
        }
        if (str != null && !str2.equals(str)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (a(this.f342956a, lVar.f342956a) && a(this.f342957b, lVar.f342957b) && a(this.f342958c, lVar.f342958c) && a(this.f342959d, lVar.f342959d) && a(this.f342960e, lVar.f342960e) && a(this.f342961f, lVar.f342961f) && a(this.f342962g, lVar.f342962g) && a(this.f342963h, lVar.f342963h) && a(this.f342964i, lVar.f342964i) && a(this.f342965j, lVar.f342965j) && a(this.f342966k, lVar.f342966k)) {
            return true;
        }
        return false;
    }

    public String a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        switch (i3) {
            case 1:
                return this.f342956a;
            case 2:
                return this.f342957b;
            case 3:
                return this.f342958c;
            case 4:
                return this.f342959d;
            case 5:
                return this.f342960e;
            case 6:
                return this.f342961f;
            case 7:
                return this.f342962g;
            case 8:
                return this.f342963h;
            case 9:
                return this.f342964i;
            case 10:
                return this.f342965j;
            case 11:
                return this.f342966k;
            default:
                return null;
        }
    }

    public boolean a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str)).booleanValue();
        }
        switch (i3) {
            case 1:
                if (!b(this.f342956a, str)) {
                    this.f342956a = str;
                    break;
                } else {
                    return false;
                }
            case 2:
                if (!b(this.f342957b, str)) {
                    this.f342957b = str;
                    break;
                } else {
                    return false;
                }
            case 3:
                if (!b(this.f342958c, str)) {
                    this.f342958c = str;
                    break;
                } else {
                    return false;
                }
            case 4:
                if (!b(this.f342959d, str)) {
                    this.f342959d = str;
                    break;
                } else {
                    return false;
                }
            case 5:
                if (!b(this.f342960e, str)) {
                    this.f342960e = str;
                    break;
                } else {
                    return false;
                }
            case 6:
                if (!b(this.f342961f, str)) {
                    this.f342961f = str;
                    break;
                } else {
                    return false;
                }
            case 7:
                if (!b(this.f342962g, str)) {
                    this.f342962g = str;
                    break;
                } else {
                    return false;
                }
            case 8:
                if (!b(this.f342963h, str)) {
                    this.f342963h = str;
                    break;
                } else {
                    return false;
                }
            case 9:
                if (!b(this.f342964i, str)) {
                    this.f342964i = str;
                    break;
                } else {
                    return false;
                }
            case 10:
                if (!b(this.f342965j, str)) {
                    this.f342965j = str;
                    break;
                } else {
                    return false;
                }
            case 11:
                if (!b(this.f342966k, str)) {
                    this.f342966k = str;
                    break;
                } else {
                    return false;
                }
            default:
                return false;
        }
        return true;
    }
}
