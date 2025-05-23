package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.final, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cfinal extends Taurus {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Integer, byte[]> f383336i;

    /* renamed from: j, reason: collision with root package name */
    public static Nucleus f383337j;

    /* renamed from: k, reason: collision with root package name */
    public static Cascara f383338k;

    /* renamed from: l, reason: collision with root package name */
    public static Pomelo f383339l;

    /* renamed from: m, reason: collision with root package name */
    public static Map<Integer, String> f383340m;

    /* renamed from: n, reason: collision with root package name */
    public static Map<Integer, String> f383341n;

    /* renamed from: a, reason: collision with root package name */
    public long f383342a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, byte[]> f383343b;

    /* renamed from: c, reason: collision with root package name */
    public int f383344c;

    /* renamed from: d, reason: collision with root package name */
    public Nucleus f383345d;

    /* renamed from: e, reason: collision with root package name */
    public Cascara f383346e;

    /* renamed from: f, reason: collision with root package name */
    public Pomelo f383347f;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, String> f383348g;

    /* renamed from: h, reason: collision with root package name */
    public Map<Integer, String> f383349h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383336i = new HashMap();
        ((HashMap) f383336i).put(0, new byte[]{0});
        f383337j = new Nucleus();
        f383338k = new Cascara();
        f383339l = new Pomelo();
        f383340m = new HashMap();
        ((HashMap) f383340m).put(0, "");
        f383341n = new HashMap();
        ((HashMap) f383341n).put(0, "");
    }

    public Cfinal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383342a = 0L;
        this.f383343b = null;
        this.f383344c = 0;
        this.f383345d = null;
        this.f383346e = null;
        this.f383347f = null;
        this.f383348g = null;
        this.f383349h = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383342a, 0);
        solar.a((Map) this.f383343b, 1);
        solar.a(this.f383344c, 2);
        solar.a((Taurus) this.f383345d, 3);
        solar.a((Taurus) this.f383346e, 4);
        Pomelo pomelo = this.f383347f;
        if (pomelo != null) {
            solar.a((Taurus) pomelo, 5);
        }
        Map<Integer, String> map = this.f383348g;
        if (map != null) {
            solar.a((Map) map, 6);
        }
        Map<Integer, String> map2 = this.f383349h;
        if (map2 != null) {
            solar.a((Map) map2, 7);
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serpens);
            return;
        }
        this.f383342a = serpens.a(this.f383342a, 0, true);
        this.f383343b = (Map) serpens.a((Serpens) f383336i, 1, true);
        this.f383344c = serpens.a(this.f383344c, 2, true);
        this.f383345d = (Nucleus) serpens.a((Taurus) f383337j, 3, true);
        this.f383346e = (Cascara) serpens.a((Taurus) f383338k, 4, true);
        this.f383347f = (Pomelo) serpens.a((Taurus) f383339l, 5, false);
        this.f383348g = (Map) serpens.a((Serpens) f383340m, 6, false);
        this.f383349h = (Map) serpens.a((Serpens) f383341n, 7, false);
    }
}
