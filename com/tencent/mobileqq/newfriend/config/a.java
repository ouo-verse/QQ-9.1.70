package com.tencent.mobileqq.newfriend.config;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static final String f253983i;

    /* renamed from: j, reason: collision with root package name */
    private static final String f253984j;

    /* renamed from: k, reason: collision with root package name */
    private static final String f253985k;

    /* renamed from: l, reason: collision with root package name */
    private static final String f253986l;

    /* renamed from: m, reason: collision with root package name */
    private static final String f253987m;

    /* renamed from: n, reason: collision with root package name */
    private static final String f253988n;

    /* renamed from: o, reason: collision with root package name */
    private static final String f253989o;

    /* renamed from: p, reason: collision with root package name */
    private static final String f253990p;

    /* renamed from: q, reason: collision with root package name */
    private static final String f253991q;

    /* renamed from: r, reason: collision with root package name */
    private static final String f253992r;

    /* renamed from: s, reason: collision with root package name */
    private static final String f253993s;

    /* renamed from: t, reason: collision with root package name */
    private static final String f253994t;

    /* renamed from: u, reason: collision with root package name */
    private static final String f253995u;

    /* renamed from: v, reason: collision with root package name */
    private static final String f253996v;

    /* renamed from: a, reason: collision with root package name */
    public boolean f253997a;

    /* renamed from: b, reason: collision with root package name */
    public int f253998b;

    /* renamed from: c, reason: collision with root package name */
    public final C8157a f253999c;

    /* renamed from: d, reason: collision with root package name */
    public final C8157a f254000d;

    /* renamed from: e, reason: collision with root package name */
    public final C8157a f254001e;

    /* renamed from: f, reason: collision with root package name */
    public final C8157a f254002f;

    /* renamed from: g, reason: collision with root package name */
    public final C8157a f254003g;

    /* renamed from: h, reason: collision with root package name */
    public final C8157a f254004h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.newfriend.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8157a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f254005a;

        /* renamed from: b, reason: collision with root package name */
        public String f254006b;

        /* renamed from: c, reason: collision with root package name */
        public String f254007c;

        C8157a(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
                return;
            }
            this.f254005a = str;
            this.f254006b = str2;
            this.f254007c = str3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "UIElement(" + this.f254005a + ", " + this.f254006b + ", " + this.f254007c + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f253983i = HardCodeUtil.qqStr(R.string.f173932uh);
        f253984j = HardCodeUtil.qqStr(R.string.f173922ug);
        f253985k = HardCodeUtil.qqStr(R.string.f173892ud);
        f253986l = HardCodeUtil.qqStr(R.string.f173982um);
        f253987m = HardCodeUtil.qqStr(R.string.f173972ul);
        f253988n = HardCodeUtil.qqStr(R.string.f173952uj);
        f253989o = HardCodeUtil.qqStr(R.string.f173942ui);
        f253990p = HardCodeUtil.qqStr(R.string.f173902ue);
        f253991q = HardCodeUtil.qqStr(R.string.f173992un);
        f253992r = HardCodeUtil.qqStr(R.string.f173962uk);
        f253993s = HardCodeUtil.qqStr(R.string.f173882uc);
        f253994t = HardCodeUtil.qqStr(R.string.f173872ub);
        f253995u = HardCodeUtil.qqStr(R.string.f174012up);
        f253996v = HardCodeUtil.qqStr(R.string.f174002uo);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f253997a = true;
        this.f253998b = 3;
        this.f253999c = new C8157a(f253983i, f253984j, f253985k);
        this.f254000d = new C8157a(f253986l, f253987m, f253988n);
        this.f254001e = new C8157a(f253989o, "", f253990p);
        this.f254002f = new C8157a(f253991q, "", f253992r);
        this.f254003g = new C8157a(f253993s, "", f253994t);
        this.f254004h = new C8157a(f253995u, "", f253996v);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "NewFriendContactGuideConfBean(" + this.f253997a + ", " + this.f253998b + ", " + this.f253999c + ", " + this.f254000d + ", " + this.f254001e + ", " + this.f254002f + ", " + this.f254003g + ", " + this.f254004h + ")";
    }
}
