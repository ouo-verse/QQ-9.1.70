package com.tencent.mobileqq.qqlive.report.tianjige;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f271444a;

    /* renamed from: b, reason: collision with root package name */
    private double f271445b;

    /* renamed from: c, reason: collision with root package name */
    private String f271446c;

    /* renamed from: d, reason: collision with root package name */
    private String f271447d;

    /* renamed from: e, reason: collision with root package name */
    private String f271448e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f271449f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f271450g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f271451a;

        /* renamed from: b, reason: collision with root package name */
        private double f271452b;

        /* renamed from: c, reason: collision with root package name */
        private String f271453c;

        /* renamed from: d, reason: collision with root package name */
        private String f271454d;

        /* renamed from: e, reason: collision with root package name */
        private String f271455e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f271456f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f271457g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public c h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (c) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return new c(this);
        }

        public a i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.f271455e = str;
            return this;
        }

        public a j(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (a) iPatchRedirector.redirect((short) 7, (Object) this, z16);
            }
            this.f271456f = z16;
            return this;
        }

        public a k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (a) iPatchRedirector.redirect((short) 8, (Object) this, z16);
            }
            this.f271457g = z16;
            return this;
        }

        public a l(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
            }
            this.f271452b = d16;
            return this;
        }

        public a m(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.f271451a = str;
            return this;
        }

        public a n(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.f271453c = str;
            return this;
        }
    }

    public c(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f271444a = aVar.f271451a;
        this.f271445b = aVar.f271452b;
        this.f271446c = aVar.f271453c;
        this.f271447d = aVar.f271455e;
        this.f271448e = aVar.f271454d;
        this.f271449f = aVar.f271456f;
        this.f271450g = aVar.f271457g;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (TextUtils.isEmpty(this.f271447d)) {
            return "";
        }
        return this.f271447d;
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Double) iPatchRedirector.redirect((short) 3, (Object) this)).doubleValue();
        }
        return this.f271445b;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271444a;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (TextUtils.isEmpty(this.f271448e)) {
            return "";
        }
        return this.f271448e;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(this.f271446c)) {
            return "";
        }
        return this.f271446c;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f271449f;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.f271450g;
    }
}
