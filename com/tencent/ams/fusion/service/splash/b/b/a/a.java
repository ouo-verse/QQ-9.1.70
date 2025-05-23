package com.tencent.ams.fusion.service.splash.b.b.a;

import com.tencent.ams.fusion.a.f;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class a implements nt.a {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    private static final int[] f70321p;

    /* renamed from: a, reason: collision with root package name */
    private final String f70322a;

    /* renamed from: b, reason: collision with root package name */
    private final String f70323b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f70324c;

    /* renamed from: d, reason: collision with root package name */
    private final String f70325d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f70326e;

    /* renamed from: f, reason: collision with root package name */
    private final String f70327f;

    /* renamed from: g, reason: collision with root package name */
    private final String f70328g;

    /* renamed from: h, reason: collision with root package name */
    private SplashOrder f70329h;

    /* renamed from: i, reason: collision with root package name */
    private int f70330i;

    /* renamed from: j, reason: collision with root package name */
    private String f70331j;

    /* renamed from: k, reason: collision with root package name */
    private String f70332k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f70333l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f70334m;

    /* renamed from: n, reason: collision with root package name */
    private String f70335n;

    /* renamed from: o, reason: collision with root package name */
    private int f70336o;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f70321p = new int[]{0, 0, 0, 0, 0, 0, 2, 3, 0, 1};
        }
    }

    public a(SplashOrder splashOrder, String str, String str2, int i3, String str3, String str4, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, splashOrder, str, str2, Integer.valueOf(i3), str3, str4, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f70325d = str;
        this.f70322a = str2;
        this.f70323b = str3;
        this.f70328g = str4;
        this.f70324c = z17;
        this.f70326e = z16;
        this.f70330i = i3;
        if (splashOrder != null) {
            this.f70334m = splashOrder.az() == 0;
            this.f70331j = splashOrder.y();
            this.f70332k = splashOrder.f();
            this.f70333l = splashOrder.ax();
            this.f70335n = splashOrder.au();
            this.f70329h = splashOrder;
        }
        this.f70327f = com.tencent.ams.fusion.a.a.c();
        this.f70336o = o();
    }

    private int a(String str) {
        try {
            Date parse = com.tencent.ams.fusion.a.a.b().parse(str);
            Date parse2 = com.tencent.ams.fusion.a.a.b().parse(this.f70327f);
            if (parse != null && parse2 != null) {
                long convert = TimeUnit.DAYS.convert(parse.getTime() - parse2.getTime(), TimeUnit.MILLISECONDS);
                if (convert >= 0 && convert <= 50) {
                    return 50 - ((int) convert);
                }
            }
            return 0;
        } catch (Exception e16) {
            f.c("DownloadTaskModelWithPriority", "date convert exception", e16);
            return 0;
        }
    }

    private int c(int i3) {
        if (i3 >= 0 && i3 <= 9) {
            int i16 = 0;
            while (true) {
                int[] iArr = f70321p;
                if (i16 >= iArr.length) {
                    break;
                }
                if (i3 == iArr[i16]) {
                    return i16;
                }
                i16++;
            }
        }
        return 0;
    }

    private int o() {
        int i3;
        int i16 = k();
        if (m()) {
            i16 = 5;
        }
        int p16 = (i16 * 10000000) + 0 + (p() * 10000);
        if (l()) {
            i3 = 6;
        } else {
            i3 = 3;
        }
        return p16 + (i3 * 1000) + (c(c()) * 100);
    }

    private int p() {
        int a16 = a(g()) * 10;
        if (!j()) {
            return 495;
        }
        return a16;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.f70336o = i3;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // nt.a
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f70328g;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f70336o;
    }

    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f70335n;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f70322a;
    }

    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f70331j;
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f70332k;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f70334m;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.f70324c;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.f70326e;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.f70333l;
    }

    public SplashOrder n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (SplashOrder) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.f70329h;
    }

    @Override // nt.a
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.f70325d : (String) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // nt.a
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this.f70330i : ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
    }

    @Override // nt.a
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f70323b : (String) iPatchRedirector.redirect((short) 7, (Object) this);
    }
}
