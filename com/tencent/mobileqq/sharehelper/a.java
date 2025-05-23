package com.tencent.mobileqq.sharehelper;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    String f287085a;

    /* renamed from: b, reason: collision with root package name */
    String f287086b;

    /* renamed from: c, reason: collision with root package name */
    String f287087c;

    /* renamed from: d, reason: collision with root package name */
    String f287088d;

    /* renamed from: e, reason: collision with root package name */
    String f287089e;

    /* renamed from: f, reason: collision with root package name */
    String f287090f;

    /* renamed from: g, reason: collision with root package name */
    Bundle f287091g;

    /* renamed from: h, reason: collision with root package name */
    String f287092h;

    /* renamed from: i, reason: collision with root package name */
    int f287093i;

    public a(String str, String str2, String str3, String str4, String str5, Bundle bundle, String str6, int i3, String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, bundle, str6, Integer.valueOf(i3), str7);
            return;
        }
        this.f287085a = str;
        this.f287086b = str2;
        this.f287087c = str3;
        this.f287088d = str4;
        this.f287089e = str5;
        this.f287091g = bundle;
        this.f287092h = str6;
        this.f287093i = i3;
        this.f287090f = str7;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f287085a;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f287087c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f287086b;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f287090f;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f287092h;
    }

    public Bundle f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Bundle) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f287091g;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f287093i;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f287089e;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f287088d;
    }
}
