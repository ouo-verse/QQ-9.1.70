package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final f f312798b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f312799c;

    /* renamed from: d, reason: collision with root package name */
    public static final f f312800d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f312801e;

    /* renamed from: f, reason: collision with root package name */
    public static final f f312802f;

    /* renamed from: g, reason: collision with root package name */
    public static final f f312803g;

    /* renamed from: h, reason: collision with root package name */
    public static final f f312804h;

    /* renamed from: a, reason: collision with root package name */
    public final int f312805a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f312798b = new f(0);
        f312799c = new f(1);
        f312800d = new f(257);
        f312801e = new f(2);
        f312802f = new f(258);
        f312803g = new f(3);
        f312804h = new f(259);
    }

    public f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.f312805a = i3;
        }
    }

    public static f b(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    switch (i3) {
                        case 257:
                            return f312800d;
                        case 258:
                            return f312802f;
                        case 259:
                            return f312804h;
                        default:
                            return f312798b;
                    }
                }
                return f312803g;
            }
            return f312801e;
        }
        return f312799c;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ((this.f312805a & 15) > 1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if ((this.f312805a & 15) == 3) {
            return true;
        }
        return false;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if ((this.f312805a & 15) == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if ((this.f312805a & 15) == 2) {
            return true;
        }
        return false;
    }
}
