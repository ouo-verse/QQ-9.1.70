package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Bilberry {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final Apple<Bilberry> f375434d;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Cfor> f375435a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Cif> f375436b;

    /* renamed from: c, reason: collision with root package name */
    public Foxnut f375437c;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Bilberry$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cdo extends Apple<Bilberry> {
        static IPatchRedirector $redirector_;

        public Cdo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.tfd.sdk.wxa.Bilberry, java.lang.Object] */
        @Override // com.tencent.tfd.sdk.wxa.Apple
        public final Bilberry a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new Bilberry();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Bilberry$if, reason: invalid class name */
    /* loaded from: classes26.dex */
    public final class Cif implements com.tencent.tfd.sdk.wxa.Cfor {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f375446a;

        public Cif(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Bilberry.this, i3);
            } else {
                this.f375446a = i3;
            }
        }

        @Override // com.tencent.tfd.sdk.wxa.Cfor
        public final void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else {
                Bilberry.a(Bilberry.this, str, this.f375446a, 3, null);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Bilberry$new, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cnew {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f375448a;

        /* renamed from: b, reason: collision with root package name */
        public final float f375449b;

        /* renamed from: c, reason: collision with root package name */
        public final float f375450c;

        /* renamed from: d, reason: collision with root package name */
        public final float f375451d;

        /* renamed from: e, reason: collision with root package name */
        public final float f375452e;

        public Cnew(int i3, float f16, float f17, float f18, float f19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
                return;
            }
            this.f375448a = i3;
            this.f375449b = f16;
            this.f375450c = f17;
            this.f375451d = f18;
            this.f375452e = f19;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f375434d = new Cdo();
        }
    }

    public Bilberry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f375435a = new HashMap();
            this.f375436b = new HashMap();
        }
    }

    public static Bilberry a() {
        return f375434d.b();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$for>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Set<com.tencent.tfd.sdk.wxa.Crux>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Set<com.tencent.tfd.sdk.wxa.for>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$if>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$for>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$if>, java.util.HashMap] */
    public final void a(String str, int i3, Foxnut foxnut) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), foxnut);
            return;
        }
        this.f375437c = foxnut;
        if (this.f375435a.get(str) == null) {
            Cfor cfor = new Cfor(str, i3);
            this.f375435a.put(str, cfor);
            ComaBerenices.f375559c.add(cfor);
        }
        if (this.f375436b.get(str) == null) {
            Cif cif = new Cif(i3);
            this.f375436b.put(str, cif);
            ComaBerenices.f375560d.add(cif);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.Bilberry$for, reason: invalid class name */
    /* loaded from: classes26.dex */
    public class Cfor implements Crux {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f375438a;

        /* renamed from: b, reason: collision with root package name */
        public long f375439b;

        /* renamed from: c, reason: collision with root package name */
        public long f375440c;

        /* renamed from: d, reason: collision with root package name */
        public List<Cnew> f375441d;

        /* renamed from: e, reason: collision with root package name */
        public String f375442e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f375443f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f375444g;

        public Cfor(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Bilberry.this, str, Integer.valueOf(i3));
                return;
            }
            this.f375439b = -1L;
            this.f375441d = new ArrayList();
            this.f375443f = false;
            this.f375444g = false;
            this.f375438a = i3;
            this.f375442e = str;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<com.tencent.tfd.sdk.wxa.Bilberry$new>, java.util.ArrayList] */
        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.f375439b = -1L;
            this.f375440c = 0L;
            this.f375441d.clear();
            this.f375443f = false;
            this.f375444g = false;
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<com.tencent.tfd.sdk.wxa.Bilberry$new>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v16, types: [java.util.List<com.tencent.tfd.sdk.wxa.Bilberry$new>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List<com.tencent.tfd.sdk.wxa.Bilberry$new>, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v13, types: [java.util.List<com.tencent.tfd.sdk.wxa.Bilberry$new>, java.util.List, java.util.Collection, java.util.ArrayList] */
        @Override // com.tencent.tfd.sdk.wxa.Crux
        public final void a(Cygnus cygnus) {
            Cnew cnew;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cygnus);
                return;
            }
            if (this.f375442e.equals(cygnus.f375587j)) {
                this.f375443f = cygnus.f375581d <= 0;
                this.f375444g = cygnus.f375582e == 0;
                int i3 = cygnus.f375580c;
                if (i3 == 0) {
                    a();
                    this.f375439b = System.currentTimeMillis();
                    this.f375441d.add(new Cnew(0, cygnus.f375583f, cygnus.f375584g, cygnus.f375585h, cygnus.f375586i));
                    return;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return;
                        }
                        a();
                        return;
                    } else {
                        if (this.f375439b != -1) {
                            cnew = new Cnew(2, cygnus.f375583f, cygnus.f375584g, cygnus.f375585h, cygnus.f375586i);
                        } else {
                            a();
                            cnew = new Cnew(0, cygnus.f375583f, cygnus.f375584g, cygnus.f375585h, cygnus.f375586i);
                            this.f375439b = System.currentTimeMillis();
                        }
                        this.f375441d.add(cnew);
                        return;
                    }
                }
                this.f375440c = System.currentTimeMillis() - this.f375439b;
                this.f375441d.add(new Cnew(1, cygnus.f375583f, cygnus.f375584g, cygnus.f375585h, cygnus.f375586i));
                Bilberry bilberry = Bilberry.this;
                ?? r26 = this.f375441d;
                bilberry.getClass();
                ArrayList arrayList = new ArrayList();
                if (r26.size() <= 8) {
                    arrayList.addAll(r26);
                } else {
                    Cnew cnew2 = (Cnew) r26.get(0);
                    Cnew cnew3 = (Cnew) r26.get(r26.size() - 1);
                    r26.remove(cnew2);
                    r26.remove(cnew3);
                    int ceil = (int) Math.ceil(r26.size() / 6);
                    arrayList.add(cnew2);
                    for (int i16 = 1; i16 < r26.size(); i16 += ceil) {
                        arrayList.add(r26.get(i16));
                    }
                    arrayList.add(cnew3);
                }
                Bilberry bilberry2 = Bilberry.this;
                long j3 = this.f375439b;
                long j16 = this.f375440c;
                bilberry2.getClass();
                Betelnut betelnut = new Betelnut();
                betelnut.f375431b = (int) j16;
                betelnut.f375430a = j3;
                ArrayList<Blackberry> arrayList2 = new ArrayList<>();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Cnew cnew4 = (Cnew) it.next();
                    Blackberry blackberry = new Blackberry();
                    int i17 = cnew4.f375448a;
                    if (i17 == 0) {
                        blackberry.f375453a = 1;
                    } else if (i17 == 1) {
                        blackberry.f375453a = 3;
                    } else if (i17 == 2) {
                        blackberry.f375453a = 2;
                    } else if (i17 != 3) {
                        blackberry.f375453a = 0;
                    } else {
                        blackberry.f375453a = 4;
                    }
                    blackberry.f375454b = cnew4.f375449b;
                    blackberry.f375455c = cnew4.f375450c;
                    blackberry.f375456d = cnew4.f375451d;
                    blackberry.f375457e = cnew4.f375452e;
                    arrayList2.add(blackberry);
                }
                betelnut.f375432c = arrayList2;
                boolean z16 = this.f375443f;
                if (!z16 && !this.f375444g) {
                    Bilberry.a(Bilberry.this, this.f375442e, this.f375438a, 1, betelnut);
                } else {
                    if (z16) {
                        betelnut.f375433d |= 1;
                    }
                    if (this.f375444g) {
                        betelnut.f375433d |= 2;
                    }
                    Bilberry.a(Bilberry.this, this.f375442e, this.f375438a, 2, betelnut);
                }
                a();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$for>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$for>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$if>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map<java.lang.String, com.tencent.tfd.sdk.wxa.Bilberry$if>, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set<com.tencent.tfd.sdk.wxa.Crux>, java.util.concurrent.CopyOnWriteArraySet] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set<com.tencent.tfd.sdk.wxa.for>, java.util.concurrent.CopyOnWriteArraySet] */
    public final void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        ComaBerenices.f375559c.remove((Cfor) this.f375435a.get(str));
        this.f375435a.remove(str);
        ComaBerenices.f375560d.remove((Cif) this.f375436b.get(str));
        this.f375436b.remove(str);
    }

    public static void a(Bilberry bilberry, String str, int i3, int i16, Betelnut betelnut) {
        Foxnut foxnut = bilberry.f375437c;
        if (foxnut != null) {
            foxnut.a(str, i3, i16, betelnut);
        }
    }
}
