package com.tencent.qimei.as;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qimei.z.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final a f343106a;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.as.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public @interface InterfaceC9310a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: e, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343107e;

        /* renamed from: f, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343108f;

        /* renamed from: g, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343109g;

        /* renamed from: h, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343110h;

        /* renamed from: i, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343111i;

        /* renamed from: j, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343112j;

        /* renamed from: k, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343113k;

        /* renamed from: l, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343114l;

        /* renamed from: m, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343115m;

        /* renamed from: n, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343116n;

        /* renamed from: o, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343117o;

        /* renamed from: p, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343118p;

        /* renamed from: q, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343119q;

        /* renamed from: r, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343120r;

        /* renamed from: s, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343121s;

        /* renamed from: t, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343122t;

        /* renamed from: u, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343123u;

        /* renamed from: v, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343124v;

        /* renamed from: w, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343125w;

        /* renamed from: x, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343126x;

        /* renamed from: y, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343127y;

        /* renamed from: z, reason: collision with root package name */
        public static final com.tencent.qimei.z.b f343128z;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(20065), (Class<?>) InterfaceC9310a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            f343107e = new com.tencent.qimei.z.b("2", true);
            f343108f = new com.tencent.qimei.z.b("3", true);
            f343109g = new com.tencent.qimei.z.b("4", true);
            f343110h = new com.tencent.qimei.z.b("5", true);
            f343111i = new com.tencent.qimei.z.b("6", true);
            f343112j = new com.tencent.qimei.z.b("7", false);
            f343113k = new com.tencent.qimei.z.b("8", true);
            f343114l = new com.tencent.qimei.z.b("9", true);
            f343115m = new com.tencent.qimei.z.b("15", true);
            f343116n = new com.tencent.qimei.z.b("25", true);
            f343117o = new com.tencent.qimei.z.b(com.tencent.qimei.r.a.a(6), true);
            f343118p = new com.tencent.qimei.z.b(com.tencent.qimei.r.a.a(7), true);
            f343119q = new com.tencent.qimei.z.b(com.tencent.qimei.r.a.a(8), true);
            f343120r = new com.tencent.qimei.z.b(com.tencent.qimei.r.a.a(9), true);
            f343121s = new com.tencent.qimei.z.b("processInfo", true);
            f343122t = new com.tencent.qimei.z.b("10", true);
            f343123u = new com.tencent.qimei.z.b("26", false);
            f343124v = new com.tencent.qimei.z.b("21", true);
            f343125w = new com.tencent.qimei.z.b("22", true);
            f343126x = new com.tencent.qimei.z.b("18", false);
            f343127y = new com.tencent.qimei.z.b("20", true);
            f343128z = new com.tencent.qimei.z.b("27", false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface b {
        public static final IPatchRedirector $redirector_ = null;
        public static final com.tencent.qimei.z.c A;
        public static final com.tencent.qimei.z.c B;
        public static final com.tencent.qimei.z.c C;
        public static final com.tencent.qimei.z.c D;
        public static final com.tencent.qimei.z.c E;
        public static final com.tencent.qimei.z.c F;
        public static final com.tencent.qimei.z.c G;
        public static final com.tencent.qimei.z.c H;
        public static final com.tencent.qimei.z.c I;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(14860), (Class<?>) b.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            A = new com.tencent.qimei.z.c("11", 10);
            B = new com.tencent.qimei.z.c("14", 0);
            C = new com.tencent.qimei.z.c("17", 0);
            D = new com.tencent.qimei.z.c("16", 4);
            E = new com.tencent.qimei.z.c("19", 24);
            F = new com.tencent.qimei.z.c("23", 30);
            G = new com.tencent.qimei.z.c("24", 0);
            H = new com.tencent.qimei.z.c("minHr", 30);
            I = new com.tencent.qimei.z.c("28", 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface c {
        public static final IPatchRedirector $redirector_ = null;
        public static final d J;
        public static final d K;
        public static final d L;

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(20582), (Class<?>) c.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
                return;
            }
            J = new d("1", "");
            K = new d("12", "");
            L = new d("13", "23:50-00:10-60");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19522);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343106a = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Boolean a(com.tencent.qimei.z.b bVar, String str) {
        boolean z16;
        String a16 = bVar.a(com.tencent.qimei.ar.d.a(str), bVar.f343435a);
        if (a16 != null && !a16.isEmpty()) {
            z16 = "1".equals(a16);
        } else {
            z16 = bVar.f343436b;
        }
        return Boolean.valueOf(z16);
    }
}
