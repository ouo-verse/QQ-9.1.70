package com.tencent.luggage.wxa.rg;

import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l {

    /* renamed from: x, reason: collision with root package name */
    public static AtomicInteger f139713x = new AtomicInteger(10000);

    /* renamed from: a, reason: collision with root package name */
    public Future f139714a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f139715b;

    /* renamed from: e, reason: collision with root package name */
    public m f139718e;

    /* renamed from: j, reason: collision with root package name */
    public long f139723j;

    /* renamed from: k, reason: collision with root package name */
    public long f139724k;

    /* renamed from: m, reason: collision with root package name */
    public boolean f139726m;

    /* renamed from: n, reason: collision with root package name */
    public String f139727n;

    /* renamed from: o, reason: collision with root package name */
    public String f139728o;

    /* renamed from: p, reason: collision with root package name */
    public String f139729p;

    /* renamed from: q, reason: collision with root package name */
    public String f139730q;

    /* renamed from: r, reason: collision with root package name */
    public String f139731r;

    /* renamed from: u, reason: collision with root package name */
    public int f139734u;

    /* renamed from: v, reason: collision with root package name */
    public int f139735v;

    /* renamed from: c, reason: collision with root package name */
    public int f139716c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f139717d = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Object f139719f = new Object();

    /* renamed from: h, reason: collision with root package name */
    public int f139721h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f139722i = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f139725l = -1;

    /* renamed from: s, reason: collision with root package name */
    public String f139732s = "";

    /* renamed from: t, reason: collision with root package name */
    public b f139733t = b.f139662c;

    /* renamed from: g, reason: collision with root package name */
    public int f139720g = f139713x.incrementAndGet();

    /* renamed from: w, reason: collision with root package name */
    public long f139736w = System.currentTimeMillis();

    public void a(Future future) {
        this.f139714a = future;
    }

    public void b(boolean z16) {
        this.f139726m = z16;
    }

    public void c(String str) {
        this.f139731r = str;
    }

    public void d(String str) {
        this.f139729p = str;
        this.f139728o = com.tencent.luggage.wxa.tg.h.h(str);
    }

    public void e(String str) {
        this.f139727n = str;
    }

    public synchronized void f(int i3) {
        this.f139734u += i3;
    }

    public synchronized b g() {
        return this.f139733t;
    }

    public String h() {
        return this.f139732s + "VideoRequest";
    }

    public int i() {
        return this.f139722i;
    }

    public long j() {
        return this.f139724k;
    }

    public long k() {
        return this.f139723j;
    }

    public String l() {
        return this.f139731r;
    }

    public int m() {
        return this.f139720g;
    }

    public String n() {
        return this.f139729p;
    }

    public long o() {
        return this.f139736w;
    }

    public synchronized long p() {
        return this.f139725l;
    }

    public String q() {
        return this.f139727n;
    }

    public String r() {
        return this.f139728o;
    }

    public boolean s() {
        return this.f139726m;
    }

    public boolean t() {
        return a(2);
    }

    public String toString() {
        String obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append("{seq=");
        sb5.append(this.f139720g);
        sb5.append(",priority=");
        sb5.append(i());
        sb5.append(",range=[");
        sb5.append(k());
        sb5.append(",");
        sb5.append(j());
        sb5.append("],uuid=");
        sb5.append(q());
        sb5.append(",contentType=");
        sb5.append(this.f139730q);
        sb5.append(",cancelState=");
        sb5.append(this.f139717d);
        sb5.append(",sourceUrl=");
        sb5.append(this.f139729p);
        sb5.append(",videoKey=");
        sb5.append(this.f139728o);
        sb5.append(",task=");
        Future future = this.f139714a;
        if (future == null) {
            obj = "null";
        } else {
            obj = future.toString();
        }
        sb5.append(obj);
        sb5.append("}");
        return sb5.toString();
    }

    public boolean u() {
        String str = this.f139731r;
        if (str != null && str.toLowerCase().equals("head")) {
            return true;
        }
        return false;
    }

    public boolean v() {
        return a(0);
    }

    public boolean w() {
        return a(1);
    }

    public void a(long j3) {
        this.f139724k = j3;
    }

    public void b(long j3) {
        this.f139723j = j3;
    }

    public synchronized void c(int i3) {
        this.f139735v = i3;
    }

    public com.tencent.luggage.wxa.tg.e e() {
        return new com.tencent.luggage.wxa.tg.d(this.f139730q, h());
    }

    public long f() {
        return ((float) (this.f139734u * 1000)) / ((float) ((System.currentTimeMillis() - this.f139736w) * 1024));
    }

    public void a(String str) {
        this.f139732s = str;
    }

    public void b(int i3) {
        this.f139721h = i3;
    }

    public void c() {
        if (a(2, 3)) {
            m mVar = this.f139718e;
            if (mVar != null) {
                mVar.a(this);
            }
            if (com.tencent.luggage.wxa.og.a.a().n()) {
                com.tencent.luggage.wxa.tg.h.a(3, h(), "cancel success, seq=" + this.f139720g);
            }
        }
    }

    public void d(int i3) {
        this.f139722i = i3;
    }

    public void e(int i3) {
        int i16 = this.f139716c;
        if ((i16 & i3) == 0) {
            this.f139716c = i16 + i3;
        }
    }

    public synchronized void a(long j3, b bVar) {
        this.f139725l = j3;
        this.f139733t = bVar;
        if (bVar.equals(b.f139664e)) {
            this.f139721h |= 8;
        }
    }

    public void b(String str) {
        this.f139730q = str;
    }

    public int d() {
        return this.f139721h;
    }

    public final void b() {
        if (a(0, 1)) {
            m mVar = this.f139718e;
            if (mVar != null) {
                mVar.b(this);
            }
            if (com.tencent.luggage.wxa.og.a.a().n()) {
                com.tencent.luggage.wxa.tg.h.a(3, h(), "cancel start, seq=" + this.f139720g);
            }
        }
    }

    public void a() {
        if (a(1, 2)) {
            m mVar = this.f139718e;
            if (mVar != null) {
                mVar.a(this, 100);
            }
            if (com.tencent.luggage.wxa.og.a.a().n()) {
                com.tencent.luggage.wxa.tg.h.a(3, h(), "cancel proceeding, seq=" + this.f139720g);
            }
        }
    }

    public void c(boolean z16) {
        this.f139715b = z16;
    }

    public void a(m mVar) {
        a(true, mVar);
    }

    public void a(boolean z16, m mVar) {
        this.f139718e = mVar;
        a(z16);
    }

    public void a(boolean z16) {
        if (this.f139714a != null) {
            b();
            e(1);
            this.f139714a.cancel(z16);
        }
    }

    public final boolean a(int i3) {
        boolean z16;
        synchronized (this.f139719f) {
            z16 = this.f139717d == i3;
        }
        return z16;
    }

    public final boolean a(int i3, int i16) {
        synchronized (this.f139719f) {
            if (this.f139717d == i3) {
                this.f139717d = i16;
                return true;
            }
            com.tencent.luggage.wxa.tg.h.a(5, h(), String.format(Locale.US, "transState error, current %d, condition %d, newState %d", Integer.valueOf(this.f139717d), Integer.valueOf(i3), Integer.valueOf(i16)));
            return false;
        }
    }
}
