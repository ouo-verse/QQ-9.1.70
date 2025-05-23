package com.tencent.luggage.wxa.ve;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public b f143354a;

    /* renamed from: b, reason: collision with root package name */
    public String f143355b;

    /* renamed from: c, reason: collision with root package name */
    public String f143356c;

    /* renamed from: d, reason: collision with root package name */
    public C6841a f143357d;

    /* renamed from: e, reason: collision with root package name */
    public C6841a f143358e;

    /* renamed from: f, reason: collision with root package name */
    public C6841a f143359f;

    /* renamed from: g, reason: collision with root package name */
    public String f143360g;

    /* renamed from: h, reason: collision with root package name */
    public String f143361h;

    /* renamed from: i, reason: collision with root package name */
    public String f143362i;

    /* renamed from: j, reason: collision with root package name */
    public String f143363j;

    /* renamed from: k, reason: collision with root package name */
    public String f143364k;

    /* renamed from: l, reason: collision with root package name */
    public String f143365l;

    /* renamed from: m, reason: collision with root package name */
    public String f143366m;

    /* renamed from: n, reason: collision with root package name */
    public String f143367n;

    /* renamed from: o, reason: collision with root package name */
    public String f143368o;

    /* renamed from: p, reason: collision with root package name */
    public String f143369p;

    /* renamed from: q, reason: collision with root package name */
    public String f143370q;

    /* renamed from: r, reason: collision with root package name */
    public String f143371r;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ve.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6841a {

        /* renamed from: a, reason: collision with root package name */
        public String f143372a;

        /* renamed from: b, reason: collision with root package name */
        public String f143373b;

        /* renamed from: c, reason: collision with root package name */
        public String f143374c;

        /* renamed from: d, reason: collision with root package name */
        public String f143375d;

        /* renamed from: e, reason: collision with root package name */
        public String f143376e;

        public C6841a(String str, String str2, String str3, String str4, String str5) {
            this.f143372a = w0.d(str);
            this.f143373b = w0.d(str2);
            this.f143374c = w0.d(str3);
            this.f143375d = w0.d(str4);
            this.f143376e = w0.d(str5);
        }

        public final String a() {
            StringBuilder sb5 = new StringBuilder();
            if (this.f143372a.length() > 0) {
                sb5.append(this.f143372a);
            }
            if (this.f143373b.length() > 0) {
                sb5.append(this.f143373b);
            }
            if (this.f143374c.length() > 0) {
                sb5.append(this.f143374c);
            }
            if (this.f143375d.length() > 0) {
                sb5.append(this.f143375d);
            }
            if (this.f143376e.length() > 0) {
                sb5.append(" ");
                sb5.append(this.f143376e);
            }
            return sb5.toString();
        }

        public final String b() {
            StringBuilder sb5 = new StringBuilder();
            if (this.f143375d.length() > 0) {
                sb5.append(this.f143375d);
                sb5.append(" ");
            }
            if (this.f143374c.length() > 0) {
                sb5.append(this.f143374c + " ");
            }
            if (this.f143373b.length() > 0) {
                sb5.append(this.f143373b + " ");
            }
            if (this.f143372a.length() > 0) {
                sb5.append(this.f143372a);
            }
            if (this.f143376e.length() > 0) {
                sb5.append(" ");
                sb5.append(this.f143376e);
            }
            return sb5.toString();
        }

        public String c() {
            if (!w0.b(this.f143372a) && !w0.b(this.f143373b) && !w0.b(this.f143374c) && !w0.b(this.f143375d) && !w0.b(this.f143376e)) {
                return b();
            }
            return a();
        }

        public String d() {
            return this.f143376e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f143377a;

        /* renamed from: b, reason: collision with root package name */
        public String f143378b;

        /* renamed from: c, reason: collision with root package name */
        public String f143379c;

        public b(String str, String str2, String str3) {
            this.f143377a = w0.d(str);
            this.f143378b = w0.d(str2);
            this.f143379c = w0.d(str3);
        }

        public String a() {
            StringBuilder sb5 = new StringBuilder();
            if (!w0.b(this.f143377a) && !w0.b(this.f143378b) && !w0.b(this.f143379c)) {
                if (this.f143377a.trim().length() > 0) {
                    sb5.append(this.f143377a);
                }
                if (this.f143378b.trim().length() > 0) {
                    sb5.append(" ");
                    sb5.append(this.f143378b);
                }
                if (this.f143379c.trim().length() > 0) {
                    sb5.append(" ");
                    sb5.append(this.f143379c);
                }
            } else {
                if (this.f143379c.trim().length() > 0) {
                    sb5.append(this.f143379c);
                }
                if (this.f143378b.trim().length() > 0) {
                    sb5.append(this.f143378b);
                }
                if (this.f143377a.trim().length() > 0) {
                    sb5.append(this.f143377a);
                }
            }
            return sb5.toString();
        }
    }

    public void a(b bVar) {
        this.f143354a = bVar;
    }

    public b b() {
        return this.f143354a;
    }

    public void c(C6841a c6841a) {
        this.f143358e = c6841a;
    }

    public C6841a d() {
        return this.f143357d;
    }

    public void e(String str) {
        this.f143360g = str;
    }

    public void f(String str) {
        this.f143355b = str;
    }

    public String g() {
        return this.f143362i;
    }

    public void h(String str) {
        this.f143356c = str;
    }

    public String i() {
        return this.f143355b;
    }

    public void j(String str) {
        this.f143365l = str;
    }

    public String k() {
        return this.f143356c;
    }

    public String l() {
        return this.f143366m;
    }

    public String m() {
        return this.f143365l;
    }

    public void n(String str) {
        this.f143363j = str;
    }

    public String o() {
        return this.f143371r;
    }

    public C6841a p() {
        return this.f143358e;
    }

    public String q() {
        return this.f143369p;
    }

    public String r() {
        return this.f143363j;
    }

    public C6841a a() {
        return this.f143359f;
    }

    public void b(C6841a c6841a) {
        this.f143357d = c6841a;
    }

    public void c(String str) {
        this.f143361h = str;
    }

    public void d(String str) {
        this.f143362i = str;
    }

    public String e() {
        return this.f143370q;
    }

    public String f() {
        return this.f143361h;
    }

    public void g(String str) {
        this.f143368o = str;
    }

    public String h() {
        return this.f143360g;
    }

    public void i(String str) {
        this.f143366m = str;
    }

    public String j() {
        return this.f143368o;
    }

    public void k(String str) {
        this.f143367n = str;
    }

    public void l(String str) {
        this.f143371r = str;
    }

    public void m(String str) {
        this.f143369p = str;
    }

    public String n() {
        return this.f143367n;
    }

    public void a(C6841a c6841a) {
        this.f143359f = c6841a;
    }

    public void b(String str) {
        this.f143370q = str;
    }

    public String c() {
        return this.f143364k;
    }

    public void a(String str) {
        this.f143364k = str;
    }
}
