package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.protected, reason: invalid class name */
/* loaded from: classes27.dex */
public final class Cprotected extends Taurus implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Map<String, String> f383416h;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Integer, Integer> f383417i;

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f383418j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ boolean f383419k;

    /* renamed from: a, reason: collision with root package name */
    public long f383420a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f383421b;

    /* renamed from: c, reason: collision with root package name */
    public long f383422c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f383423d;

    /* renamed from: e, reason: collision with root package name */
    public Map<Integer, Integer> f383424e;

    /* renamed from: f, reason: collision with root package name */
    public long f383425f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f383426g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f383419k = true;
        HashMap hashMap = new HashMap();
        f383416h = hashMap;
        hashMap.put("", "");
        f383417i = new HashMap();
        f383417i.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f383418j = hashMap2;
        hashMap2.put("", "");
    }

    public Cprotected() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383420a = 0L;
        this.f383421b = true;
        this.f383422c = 0L;
        this.f383423d = null;
        this.f383424e = null;
        this.f383425f = 0L;
        this.f383426g = null;
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Solar solar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) solar);
            return;
        }
        solar.a(this.f383420a, 0);
        solar.a(this.f383421b ? (byte) 1 : (byte) 0, 1);
        solar.a(this.f383422c, 2);
        solar.a((Map) this.f383423d, 3);
        solar.a((Map) this.f383424e, 4);
        solar.a(this.f383425f, 5);
        Map<String, String> map = this.f383426g;
        if (map != null) {
            solar.a((Map) map, 6);
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f383419k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        Cprotected cprotected = (Cprotected) obj;
        if (!Triangulum.a(this.f383420a, cprotected.f383420a) || !Triangulum.a(this.f383421b, cprotected.f383421b) || !Triangulum.a(this.f383422c, cprotected.f383422c) || !this.f383423d.equals(cprotected.f383423d) || !this.f383424e.equals(cprotected.f383424e) || !Triangulum.a(this.f383425f, cprotected.f383425f) || !this.f383426g.equals(cprotected.f383426g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.xq.Taurus
    public void a(Serpens serpens) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) serpens);
            return;
        }
        this.f383420a = serpens.a(this.f383420a, 0, true);
        this.f383421b = serpens.a(this.f383421b, 1, true);
        this.f383422c = serpens.a(this.f383422c, 2, true);
        this.f383423d = (Map) serpens.a((Serpens) f383416h, 3, true);
        this.f383424e = (Map) serpens.a((Serpens) f383417i, 4, true);
        this.f383425f = serpens.a(this.f383425f, 5, true);
        this.f383426g = (Map) serpens.a((Serpens) f383418j, 6, false);
    }
}
