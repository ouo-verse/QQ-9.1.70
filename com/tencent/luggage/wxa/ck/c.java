package com.tencent.luggage.wxa.ck;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.luggage.wxa.ck.g;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.Deque;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements g, f {

    /* renamed from: b, reason: collision with root package name */
    public final String f123591b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f123592c = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final Deque f123593d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f123594e = true;

    /* renamed from: f, reason: collision with root package name */
    public String f123595f;

    /* renamed from: g, reason: collision with root package name */
    public g.b f123596g;

    public c(String str, String str2) {
        this.f123591b = str;
        synchronized (this) {
            this.f123595f = str2;
        }
    }

    public final synchronized void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.m4.b bVar2) {
        boolean a16 = a(bVar2.B0());
        if (a16) {
            e();
        }
        g.b e16 = e(bVar2);
        this.f123596g = e16;
        e16.f123601c = new g.d(1, bVar.B0());
        int hashCode = bVar.hashCode();
        while (!f() && peek().f123599a != hashCode) {
            g();
        }
        if (a16) {
            a(new g.b(bVar));
        }
        e(bVar).f123602d = new g.c(bVar2.B0());
        e(bVar).f123601c = null;
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public synchronized void c(com.tencent.luggage.wxa.m4.b bVar) {
        if (this.f123594e) {
            f(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public void d(com.tencent.luggage.wxa.m4.b bVar) {
        synchronized (this) {
            g.b e16 = e(bVar);
            if (e16 == null) {
                return;
            }
            Pair a16 = d.a(bVar);
            e16.f123601c = new g.d(((Integer) a16.first).intValue(), (String) a16.second);
        }
    }

    public final synchronized void e() {
        this.f123596g = null;
        this.f123595f = null;
        this.f123594e = false;
    }

    public final synchronized void f(com.tencent.luggage.wxa.m4.b bVar) {
        this.f123595f = bVar.B0();
        this.f123594e = false;
        a(new g.b(bVar));
        peek().f123602d = w0.c(this.f123591b) ? null : new g.c(this.f123591b);
    }

    public synchronized g.b g() {
        g.b bVar;
        bVar = (g.b) this.f123593d.pollFirst();
        if (bVar != null) {
            w.a("MicroMsg.AppBrandPageVisitStack", "pop node(%d:%s)", Integer.valueOf(bVar.f123599a), bVar.f123600b);
            this.f123592c.remove(bVar.f123599a);
        }
        return bVar;
    }

    @Override // com.tencent.luggage.wxa.ck.g
    public synchronized g.b peek() {
        return (g.b) this.f123593d.peekFirst();
    }

    public final g.b e(com.tencent.luggage.wxa.m4.b bVar) {
        g.b peek = peek();
        if (peek == null) {
            boolean z16 = com.tencent.luggage.wxa.tn.e.f141559a;
            return new g.b(bVar);
        }
        if (peek.f123599a != bVar.hashCode() && !com.tencent.luggage.wxa.tn.e.f141559a) {
            w.a("MicroMsg.AppBrandPageVisitStack", new Throwable(), "mismatch stack order", new Object[0]);
        }
        return peek;
    }

    public synchronized boolean f() {
        return this.f123593d.isEmpty();
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.m4.b bVar2, k1 k1Var) {
        g.b e16;
        synchronized (this) {
            if (this.f123594e) {
                f(bVar);
                return;
            }
            if (k1Var == k1.NAVIGATE_BACK) {
                a(bVar, bVar2);
                return;
            }
            if (this.f123596g != null) {
                e();
            }
            if (bVar2 != null && (e16 = e(bVar2)) != null) {
                e16.f123601c = new g.d(2, bVar.B0());
            }
            g.b bVar3 = new g.b(bVar);
            bVar3.f123602d = bVar2 == null ? null : new g.c(bVar2.B0());
            a(bVar3);
        }
    }

    public synchronized void a(g.b bVar) {
        w.a("MicroMsg.AppBrandPageVisitStack", "push node(%d:%s)", Integer.valueOf(bVar.f123599a), bVar.f123600b);
        if (this.f123593d.peekFirst() != bVar) {
            this.f123593d.offerFirst(bVar);
        }
        this.f123592c.put(bVar.f123599a, bVar);
    }

    @Override // com.tencent.luggage.wxa.ck.g
    public synchronized boolean a(String str) {
        boolean z16;
        if (!w0.c(this.f123595f)) {
            z16 = this.f123595f.equals(str);
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.ck.g
    public synchronized g.b a(com.tencent.luggage.wxa.m4.b bVar) {
        g.b bVar2;
        g.b bVar3 = (g.b) this.f123592c.get(bVar.hashCode());
        return (bVar3 == null && (bVar2 = this.f123596g) != null && bVar2.f123599a == bVar.hashCode()) ? this.f123596g : bVar3;
    }
}
