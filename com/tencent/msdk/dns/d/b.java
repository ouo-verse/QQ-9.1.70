package com.tencent.msdk.dns.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.core.rest.share.a;
import oicq.wlogin_sdk.tools.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes21.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f336405a;

    /* renamed from: b, reason: collision with root package name */
    public final String f336406b;

    /* renamed from: c, reason: collision with root package name */
    public final String f336407c;

    /* renamed from: d, reason: collision with root package name */
    public final String f336408d;

    /* renamed from: e, reason: collision with root package name */
    public final String f336409e;

    /* renamed from: f, reason: collision with root package name */
    public final String f336410f;

    /* renamed from: g, reason: collision with root package name */
    public final String f336411g;

    /* renamed from: h, reason: collision with root package name */
    public final String f336412h;

    /* renamed from: i, reason: collision with root package name */
    public final String f336413i;

    /* renamed from: j, reason: collision with root package name */
    public final String f336414j;

    /* renamed from: k, reason: collision with root package name */
    public final String f336415k;

    /* renamed from: l, reason: collision with root package name */
    public final String f336416l;

    /* renamed from: m, reason: collision with root package name */
    public final String f336417m;

    /* renamed from: n, reason: collision with root package name */
    public final String f336418n;

    /* renamed from: o, reason: collision with root package name */
    public final String f336419o;

    /* renamed from: p, reason: collision with root package name */
    public final String f336420p;

    /* renamed from: q, reason: collision with root package name */
    public final String f336421q;

    /* renamed from: r, reason: collision with root package name */
    public final String f336422r;

    /* renamed from: s, reason: collision with root package name */
    public final String f336423s;

    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.d.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9223b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final boolean f336424a;

        /* renamed from: b, reason: collision with root package name */
        private final StringBuilder f336425b;

        /* renamed from: c, reason: collision with root package name */
        private final StringBuilder f336426c;

        /* renamed from: d, reason: collision with root package name */
        private final StringBuilder f336427d;

        /* renamed from: e, reason: collision with root package name */
        private final StringBuilder f336428e;

        /* renamed from: f, reason: collision with root package name */
        private final StringBuilder f336429f;

        /* renamed from: g, reason: collision with root package name */
        private final StringBuilder f336430g;

        /* renamed from: h, reason: collision with root package name */
        private final StringBuilder f336431h;

        /* renamed from: i, reason: collision with root package name */
        private final StringBuilder f336432i;

        /* renamed from: j, reason: collision with root package name */
        private final StringBuilder f336433j;

        /* renamed from: k, reason: collision with root package name */
        private final StringBuilder f336434k;

        /* renamed from: l, reason: collision with root package name */
        private final StringBuilder f336435l;

        /* renamed from: m, reason: collision with root package name */
        private final StringBuilder f336436m;

        /* renamed from: n, reason: collision with root package name */
        private final StringBuilder f336437n;

        /* renamed from: o, reason: collision with root package name */
        private final StringBuilder f336438o;

        /* renamed from: p, reason: collision with root package name */
        private final StringBuilder f336439p;

        /* renamed from: q, reason: collision with root package name */
        private final StringBuilder f336440q;

        /* renamed from: r, reason: collision with root package name */
        private final StringBuilder f336441r;

        /* renamed from: s, reason: collision with root package name */
        private final StringBuilder f336442s;

        /* renamed from: t, reason: collision with root package name */
        private final StringBuilder f336443t;

        /* renamed from: u, reason: collision with root package name */
        private final StringBuilder f336444u;

        public C9223b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
                return;
            }
            this.f336425b = new StringBuilder();
            this.f336426c = new StringBuilder();
            this.f336427d = new StringBuilder();
            this.f336428e = new StringBuilder();
            this.f336429f = new StringBuilder();
            this.f336430g = new StringBuilder();
            this.f336431h = new StringBuilder();
            this.f336432i = new StringBuilder();
            this.f336433j = new StringBuilder();
            this.f336434k = new StringBuilder();
            this.f336435l = new StringBuilder();
            this.f336436m = new StringBuilder();
            this.f336437n = new StringBuilder();
            this.f336438o = new StringBuilder();
            this.f336439p = new StringBuilder();
            this.f336440q = new StringBuilder();
            this.f336441r = new StringBuilder();
            this.f336442s = new StringBuilder();
            this.f336443t = new StringBuilder();
            this.f336444u = new StringBuilder();
            this.f336424a = z16;
        }

        public C9223b a(com.tencent.msdk.dns.core.stat.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C9223b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            }
            if (bVar != null) {
                StringBuilder sb5 = this.f336425b;
                sb5.append(bVar.f336380a);
                sb5.append(util.base64_pad_url);
                StringBuilder sb6 = this.f336426c;
                sb6.append(bVar.f336381b);
                sb6.append(util.base64_pad_url);
                StringBuilder sb7 = this.f336428e;
                sb7.append(bVar.f336383d);
                sb7.append(util.base64_pad_url);
                if (this.f336424a) {
                    StringBuilder sb8 = this.f336427d;
                    sb8.append(bVar.f336382c);
                    sb8.append(util.base64_pad_url);
                    a.C9218a c9218a = a.C9218a.f336318m;
                    a.C9218a c9218a2 = bVar.f336385f;
                    if (c9218a == c9218a2) {
                        c9218a2 = bVar.f336386g;
                    }
                    StringBuilder sb9 = this.f336429f;
                    sb9.append(c9218a2.f336326l);
                    sb9.append(util.base64_pad_url);
                    StringBuilder sb10 = this.f336430g;
                    sb10.append(c9218a2.f336379d);
                    sb10.append(util.base64_pad_url);
                    StringBuilder sb11 = this.f336431h;
                    sb11.append(c9218a2.f336319e);
                    sb11.append(util.base64_pad_url);
                    StringBuilder sb12 = this.f336432i;
                    sb12.append(c9218a2.f336320f);
                    sb12.append(util.base64_pad_url);
                    StringBuilder sb13 = this.f336433j;
                    sb13.append(com.tencent.msdk.dns.c.e.a.c(c9218a2.f336376a, ","));
                    sb13.append(util.base64_pad_url);
                    StringBuilder sb14 = this.f336434k;
                    sb14.append(c9218a2.f336322h);
                    sb14.append(util.base64_pad_url);
                    StringBuilder sb15 = this.f336435l;
                    sb15.append(c9218a2.f336321g);
                    sb15.append(util.base64_pad_url);
                    StringBuilder sb16 = this.f336436m;
                    sb16.append(c9218a2.f336378c);
                    sb16.append(util.base64_pad_url);
                    StringBuilder sb17 = this.f336437n;
                    sb17.append(c9218a2.f336323i);
                    sb17.append(util.base64_pad_url);
                } else {
                    StringBuilder sb18 = this.f336431h;
                    sb18.append(bVar.f336385f.f336319e);
                    sb18.append(util.base64_pad_url);
                    StringBuilder sb19 = this.f336432i;
                    sb19.append(bVar.f336385f.f336320f);
                    sb19.append(util.base64_pad_url);
                    StringBuilder sb20 = this.f336433j;
                    sb20.append(com.tencent.msdk.dns.c.e.a.c(bVar.f336385f.f336376a, ","));
                    sb20.append(util.base64_pad_url);
                    StringBuilder sb21 = this.f336434k;
                    sb21.append(bVar.f336385f.f336322h);
                    sb21.append(util.base64_pad_url);
                    StringBuilder sb22 = this.f336435l;
                    sb22.append(bVar.f336385f.f336321g);
                    sb22.append(util.base64_pad_url);
                    StringBuilder sb23 = this.f336436m;
                    sb23.append(bVar.f336385f.f336378c);
                    sb23.append(util.base64_pad_url);
                    StringBuilder sb24 = this.f336437n;
                    sb24.append(bVar.f336385f.f336323i);
                    sb24.append(util.base64_pad_url);
                    StringBuilder sb25 = this.f336438o;
                    sb25.append(bVar.f336386g.f336319e);
                    sb25.append(util.base64_pad_url);
                    StringBuilder sb26 = this.f336439p;
                    sb26.append(bVar.f336386g.f336320f);
                    sb26.append(util.base64_pad_url);
                    StringBuilder sb27 = this.f336440q;
                    sb27.append(com.tencent.msdk.dns.c.e.a.c(bVar.f336386g.f336376a, ","));
                    sb27.append(util.base64_pad_url);
                    StringBuilder sb28 = this.f336441r;
                    sb28.append(bVar.f336386g.f336322h);
                    sb28.append(util.base64_pad_url);
                    StringBuilder sb29 = this.f336442s;
                    sb29.append(bVar.f336386g.f336321g);
                    sb29.append(util.base64_pad_url);
                    StringBuilder sb30 = this.f336443t;
                    sb30.append(bVar.f336386g.f336378c);
                    sb30.append(util.base64_pad_url);
                    StringBuilder sb31 = this.f336444u;
                    sb31.append(bVar.f336386g.f336323i);
                    sb31.append(util.base64_pad_url);
                }
                return this;
            }
            throw new IllegalArgumentException("statMerge".concat(" can not be null"));
        }

        public b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (this.f336425b.length() != 0) {
                this.f336425b.setLength(r1.length() - 1);
                this.f336426c.setLength(r1.length() - 1);
                this.f336428e.setLength(r1.length() - 1);
                this.f336431h.setLength(r1.length() - 1);
                this.f336432i.setLength(r1.length() - 1);
                this.f336433j.setLength(r1.length() - 1);
                this.f336434k.setLength(r1.length() - 1);
                this.f336435l.setLength(r1.length() - 1);
                this.f336436m.setLength(r1.length() - 1);
                this.f336437n.setLength(r1.length() - 1);
                if (this.f336424a) {
                    this.f336427d.setLength(r1.length() - 1);
                    this.f336429f.setLength(r1.length() - 1);
                    this.f336430g.setLength(r1.length() - 1);
                } else {
                    this.f336438o.setLength(r1.length() - 1);
                    this.f336439p.setLength(r1.length() - 1);
                    this.f336440q.setLength(r1.length() - 1);
                    this.f336441r.setLength(r1.length() - 1);
                    this.f336442s.setLength(r1.length() - 1);
                    this.f336443t.setLength(r1.length() - 1);
                    this.f336444u.setLength(r1.length() - 1);
                }
            }
            return new b(this.f336425b.toString(), this.f336426c.toString(), this.f336427d.toString(), this.f336428e.toString(), this.f336429f.toString(), this.f336430g.toString(), this.f336431h.toString(), this.f336432i.toString(), this.f336433j.toString(), this.f336434k.toString(), this.f336435l.toString(), this.f336436m.toString(), this.f336437n.toString(), this.f336438o.toString(), this.f336439p.toString(), this.f336440q.toString(), this.f336441r.toString(), this.f336442s.toString(), this.f336443t.toString(), this.f336444u.toString(), null);
        }
    }

    /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, a aVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, aVar);
    }

    b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        String str21 = str15;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null) {
            if (iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20);
                return;
            }
            str21 = str15;
        }
        this.f336405a = str;
        this.f336406b = str2;
        this.f336407c = str4;
        this.f336408d = str5;
        this.f336409e = str6;
        this.f336410f = str7;
        this.f336411g = str8;
        this.f336412h = str9;
        this.f336413i = str10;
        this.f336414j = str11;
        this.f336415k = str12;
        this.f336416l = str13;
        this.f336417m = str14;
        this.f336419o = str21;
        this.f336418n = str16;
        this.f336420p = str17;
        this.f336421q = str18;
        this.f336422r = str19;
        this.f336423s = str20;
    }
}
