package com.tencent.luggage.wxa.ck;

import com.tencent.luggage.wxa.bk.o;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final o f123584a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f123585b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f123586c;

    /* renamed from: d, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.ic.g f123587d;

    /* renamed from: e, reason: collision with root package name */
    public volatile long f123588e = 0;

    /* renamed from: f, reason: collision with root package name */
    public volatile long f123589f = 0;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedList f123590g = new LinkedList();

    public b(int i3) {
        this.f123584a = new o("MicroMsg.AppBrandPageViewStatistics[" + i3 + "]");
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        this.f123586c = gVar.getAppId();
        this.f123587d = gVar;
    }

    public long b() {
        return Math.max(0L, this.f123589f);
    }

    public long c() {
        return this.f123588e;
    }

    public boolean d() {
        return this.f123584a.b();
    }

    public boolean e() {
        return this.f123584a.c();
    }

    public boolean f() {
        if (this.f123588e > 0 && this.f123589f <= 0) {
            return true;
        }
        return false;
    }

    public void g() {
        if (this.f123584a.e()) {
            while (!this.f123590g.isEmpty()) {
                ((Runnable) this.f123590g.pollFirst()).run();
            }
        }
    }

    public void h() {
        this.f123584a.e();
        this.f123584a.d();
    }

    public void i() {
        if (this.f123588e > 0 && this.f123584a.f()) {
            this.f123590g.clear();
        }
    }

    public void j() {
        this.f123589f = w0.c() - this.f123588e;
    }

    public void a(String str) {
        this.f123588e = w0.c();
        this.f123585b = str;
    }

    public long a() {
        if (!e() && !d()) {
            return 0L;
        }
        long a16 = this.f123584a.a();
        long j3 = this.f123588e;
        long j16 = this.f123589f;
        if (a16 <= 0) {
            if (f()) {
                return 0L;
            }
            w.d("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", Long.valueOf(a16), Long.valueOf(j3), Long.valueOf(j16), this.f123586c, this.f123585b, Boolean.valueOf(this.f123587d != null && this.f123587d.w0()));
            if (j3 > 0 && j16 > 0 && a16 == 0) {
                return w0.c() - j3;
            }
        }
        return Math.max(0L, a16);
    }
}
