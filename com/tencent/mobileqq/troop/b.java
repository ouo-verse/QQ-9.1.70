package com.tencent.mobileqq.troop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f294565a;

    /* renamed from: b, reason: collision with root package name */
    public String f294566b;

    /* renamed from: c, reason: collision with root package name */
    public int f294567c;

    /* renamed from: d, reason: collision with root package name */
    public int f294568d;

    /* renamed from: e, reason: collision with root package name */
    public String f294569e;

    /* renamed from: f, reason: collision with root package name */
    public String f294570f;

    /* renamed from: g, reason: collision with root package name */
    public long f294571g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f294572h;

    /* renamed from: i, reason: collision with root package name */
    public String f294573i;

    public b(String str, String str2, int i3, int i16, String str3, String str4, long j3, boolean z16, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3, str4, Long.valueOf(j3), Boolean.valueOf(z16), str5);
            return;
        }
        this.f294565a = str;
        this.f294566b = str2;
        this.f294567c = i3;
        this.f294568d = i16;
        this.f294569e = str3;
        this.f294570f = str4;
        this.f294571g = j3;
        this.f294572h = z16;
        this.f294573i = str5;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f294568d = -1;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
