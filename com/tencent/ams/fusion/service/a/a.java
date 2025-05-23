package com.tencent.ams.fusion.service.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface a extends com.tencent.ams.fusion.service.a {

    /* compiled from: P */
    /* renamed from: com.tencent.ams.fusion.service.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0673a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f70238a;

        /* renamed from: b, reason: collision with root package name */
        private String f70239b;

        /* renamed from: c, reason: collision with root package name */
        private int f70240c;

        /* renamed from: d, reason: collision with root package name */
        private String f70241d;

        public C0673a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static C0673a a(String str, int i3) {
            C0673a c0673a = new C0673a();
            c0673a.f70238a = str;
            c0673a.f70240c = i3;
            return c0673a;
        }

        public static C0673a b(String str, String str2) {
            C0673a c0673a = new C0673a();
            c0673a.f70238a = str;
            c0673a.f70239b = str2;
            return c0673a;
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f70238a;
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f70241d;
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f70239b;
        }

        public int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f70240c;
        }
    }

    int a(C0673a c0673a);

    String b(C0673a c0673a);
}
