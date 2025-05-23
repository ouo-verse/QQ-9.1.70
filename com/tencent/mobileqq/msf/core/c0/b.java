package com.tencent.mobileqq.msf.core.c0;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;
    public static final int A = 10;
    public static final int B = 1000;
    public static final int C = 10;
    public static final int D = 1000;
    private static b E = null;

    /* renamed from: d, reason: collision with root package name */
    public static final int f247564d = 50;

    /* renamed from: e, reason: collision with root package name */
    public static final int f247565e = 5000;

    /* renamed from: f, reason: collision with root package name */
    public static final int f247566f = 50;

    /* renamed from: g, reason: collision with root package name */
    public static final int f247567g = 5000;

    /* renamed from: h, reason: collision with root package name */
    public static final int f247568h = 10;

    /* renamed from: i, reason: collision with root package name */
    public static final int f247569i = 1000;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247570j = 10;

    /* renamed from: k, reason: collision with root package name */
    public static final int f247571k = 1000;

    /* renamed from: l, reason: collision with root package name */
    public static final int f247572l = 10;

    /* renamed from: m, reason: collision with root package name */
    public static final int f247573m = 1000;

    /* renamed from: n, reason: collision with root package name */
    public static final int f247574n = 10;

    /* renamed from: o, reason: collision with root package name */
    public static final int f247575o = 1000;

    /* renamed from: p, reason: collision with root package name */
    public static final int f247576p = 10;

    /* renamed from: q, reason: collision with root package name */
    public static final int f247577q = 1000;

    /* renamed from: r, reason: collision with root package name */
    public static final int f247578r = 10;

    /* renamed from: s, reason: collision with root package name */
    public static final int f247579s = 1000;

    /* renamed from: t, reason: collision with root package name */
    public static final int f247580t = 10;

    /* renamed from: u, reason: collision with root package name */
    public static final int f247581u = 1000;

    /* renamed from: v, reason: collision with root package name */
    public static final int f247582v = 10;

    /* renamed from: w, reason: collision with root package name */
    public static final int f247583w = 100;

    /* renamed from: x, reason: collision with root package name */
    public static final int f247584x = 10000;

    /* renamed from: y, reason: collision with root package name */
    public static final int f247585y = 10;

    /* renamed from: z, reason: collision with root package name */
    public static final int f247586z = 1000;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f247587a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f247588b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Integer> f247589c;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f247587a = new ConcurrentHashMap<>();
        this.f247588b = new ConcurrentHashMap<>();
        this.f247589c = new ConcurrentHashMap<>();
    }

    public static b a() {
        if (E == null) {
            synchronized (b.class) {
                E = new b();
            }
        }
        return E;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f247587a.put(g.F3, 10);
        this.f247588b.put(g.f247699i, 50);
        this.f247588b.put(g.f247770x3, 50);
        this.f247588b.put(g.n3, 10);
        this.f247588b.put(g.f247775y3, 10);
        this.f247588b.put(g.m3, 10);
        this.f247588b.put(g.f247780z3, 10);
        this.f247588b.put(g.D0, 10);
        this.f247588b.put(g.f247727o3, 10);
        this.f247588b.put(g.A3, 10);
        this.f247588b.put(g.F3, 100);
        this.f247588b.put(g.G3, 10);
        this.f247588b.put(g.H3, 10);
        this.f247588b.put(g.I3, 10);
        this.f247589c.put(g.f247699i, 5000);
        this.f247589c.put(g.f247770x3, 5000);
        this.f247589c.put(g.n3, 1000);
        this.f247589c.put(g.f247775y3, 1000);
        this.f247589c.put(g.m3, 1000);
        this.f247589c.put(g.f247780z3, 1000);
        this.f247589c.put(g.D0, 1000);
        this.f247589c.put(g.f247727o3, 1000);
        this.f247589c.put(g.A3, 1000);
        this.f247589c.put(g.F3, 10000);
        this.f247589c.put(g.G3, 1000);
        this.f247589c.put(g.H3, 1000);
        this.f247589c.put(g.I3, 1000);
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if ((!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !this.f247587a.containsKey(str)) || ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !this.f247588b.containsKey(str)) || (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !this.f247589c.containsKey(str)))) {
            return true;
        }
        Integer num = 1;
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            num = this.f247587a.get(str);
        } else if (BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion()) {
            num = this.f247588b.get(str);
        } else if (BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) {
            num = this.f247589c.get(str);
        }
        return num == null || com.tencent.mobileqq.msf.core.net.utils.e.a(0, num.intValue()) < 1;
    }
}
