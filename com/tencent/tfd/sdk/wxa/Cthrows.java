package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* renamed from: com.tencent.tfd.sdk.wxa.throws, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cthrows extends CanisMinor implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Map<String, String> f375842h;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Integer, Integer> f375843i;

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f375844j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ boolean f375845k;

    /* renamed from: a, reason: collision with root package name */
    public long f375846a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f375847b;

    /* renamed from: c, reason: collision with root package name */
    public long f375848c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f375849d;

    /* renamed from: e, reason: collision with root package name */
    public Map<Integer, Integer> f375850e;

    /* renamed from: f, reason: collision with root package name */
    public long f375851f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f375852g;

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Map<java.lang.Integer, java.lang.Integer>, java.util.HashMap] */
    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f375845k = true;
        HashMap hashMap = new HashMap();
        f375842h = hashMap;
        hashMap.put("", "");
        f375843i = new HashMap();
        f375843i.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f375844j = hashMap2;
        hashMap2.put("", "");
    }

    public Cthrows() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f375846a = 0L;
        this.f375847b = true;
        this.f375848c = 0L;
        this.f375849d = null;
        this.f375850e = null;
        this.f375851f = 0L;
        this.f375852g = null;
    }

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Canesatici canesatici) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canesatici);
            return;
        }
        canesatici.a(this.f375846a, 0);
        canesatici.a(this.f375847b ? (byte) 1 : (byte) 0, 1);
        canesatici.a(this.f375848c, 2);
        canesatici.a((Map) this.f375849d, 3);
        canesatici.a((Map) this.f375850e, 4);
        canesatici.a(this.f375851f, 5);
        Map<String, String> map = this.f375852g;
        if (map != null) {
            canesatici.a((Map) map, 6);
        }
    }

    public final Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f375845k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        Cthrows cthrows = (Cthrows) obj;
        if (!CanisMajor.a(this.f375846a, cthrows.f375846a)) {
            return false;
        }
        if (this.f375847b == cthrows.f375847b) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !CanisMajor.a(this.f375848c, cthrows.f375848c) || !this.f375849d.equals(cthrows.f375849d) || !this.f375850e.equals(cthrows.f375850e) || !CanisMajor.a(this.f375851f, cthrows.f375851f) || !this.f375852g.equals(cthrows.f375852g)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
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

    @Override // com.tencent.tfd.sdk.wxa.CanisMinor
    public final void a(Caelum caelum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) caelum);
            return;
        }
        this.f375846a = caelum.a(this.f375846a, 0, true);
        this.f375847b = caelum.a(this.f375847b, 1, true);
        this.f375848c = caelum.a(this.f375848c, 2, true);
        this.f375849d = (Map) caelum.a((Caelum) f375842h, 3, true);
        this.f375850e = (Map) caelum.a((Caelum) f375843i, 4, true);
        this.f375851f = caelum.a(this.f375851f, 5, true);
        this.f375852g = (Map) caelum.a((Caelum) f375844j, 6, false);
    }
}
