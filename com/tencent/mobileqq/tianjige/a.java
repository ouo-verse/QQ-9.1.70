package com.tencent.mobileqq.tianjige;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f292901a;

    /* renamed from: b, reason: collision with root package name */
    private String f292902b;

    /* renamed from: c, reason: collision with root package name */
    private double f292903c;

    /* renamed from: d, reason: collision with root package name */
    private String f292904d;

    /* renamed from: e, reason: collision with root package name */
    private String f292905e;

    /* renamed from: f, reason: collision with root package name */
    private String f292906f;

    /* renamed from: g, reason: collision with root package name */
    private String f292907g;

    /* renamed from: h, reason: collision with root package name */
    private String f292908h;

    /* renamed from: i, reason: collision with root package name */
    private String f292909i;

    /* renamed from: j, reason: collision with root package name */
    private String f292910j;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tianjige.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C8649a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f292911a;

        /* renamed from: b, reason: collision with root package name */
        private String f292912b;

        /* renamed from: c, reason: collision with root package name */
        private double f292913c;

        /* renamed from: d, reason: collision with root package name */
        private String f292914d;

        /* renamed from: e, reason: collision with root package name */
        private String f292915e;

        /* renamed from: f, reason: collision with root package name */
        private String f292916f;

        /* renamed from: g, reason: collision with root package name */
        private String f292917g;

        /* renamed from: h, reason: collision with root package name */
        private String f292918h;

        /* renamed from: i, reason: collision with root package name */
        private String f292919i;

        /* renamed from: j, reason: collision with root package name */
        private String f292920j;

        public C8649a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public a k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return new a(this);
        }

        public C8649a l(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C8649a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.f292916f = str;
            return this;
        }

        public C8649a m(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8649a) iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
            }
            this.f292913c = d16;
            return this;
        }

        public C8649a n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C8649a) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.f292911a = z16;
            return this;
        }

        public C8649a o(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C8649a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.f292912b = str;
            return this;
        }

        public C8649a p(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C8649a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.f292914d = str;
            return this;
        }
    }

    public a(C8649a c8649a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c8649a);
            return;
        }
        this.f292901a = c8649a.f292911a;
        this.f292902b = c8649a.f292912b;
        this.f292903c = c8649a.f292913c;
        this.f292904d = c8649a.f292914d;
        this.f292905e = c8649a.f292916f;
        this.f292906f = c8649a.f292915e;
        if (TextUtils.isEmpty(this.f292905e)) {
            this.f292905e = AppSetting.f99551k + "." + AppSetting.f99542b;
        }
        this.f292907g = c8649a.f292917g;
        this.f292908h = c8649a.f292918h;
        this.f292909i = c8649a.f292919i;
        this.f292910j = c8649a.f292920j;
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (TextUtils.isEmpty(this.f292905e)) {
            return "";
        }
        return this.f292905e;
    }

    public double b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Double) iPatchRedirector.redirect((short) 8, (Object) this)).doubleValue();
        }
        return this.f292903c;
    }

    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f292902b;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        if (TextUtils.isEmpty(this.f292906f)) {
            return "";
        }
        return this.f292906f;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (TextUtils.isEmpty(this.f292904d)) {
            return "";
        }
        return this.f292904d;
    }

    public boolean f() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (AppSetting.u()) {
            return this.f292901a;
        }
        if (this.f292901a && (i3 = Build.VERSION.SDK_INT) >= 26 && i3 != 27) {
            return true;
        }
        return false;
    }
}
