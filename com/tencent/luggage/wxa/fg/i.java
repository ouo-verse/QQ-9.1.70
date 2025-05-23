package com.tencent.luggage.wxa.fg;

import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.p;
import com.tencent.luggage.wxa.xd.k0;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: d, reason: collision with root package name */
    public static int f126173d;

    /* renamed from: a, reason: collision with root package name */
    public final List f126174a;

    /* renamed from: b, reason: collision with root package name */
    public p f126175b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f126176c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean isEmpty;
            synchronized (i.this.f126174a) {
                if (i.this.f126174a.isEmpty()) {
                    return;
                }
                k0 k0Var = (k0) i.this.f126174a.remove(0);
                int size = i.this.f126174a.size();
                k0Var.dispatch();
                w.g("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", k0Var.getName(), Integer.valueOf(size));
                synchronized (i.this.f126174a) {
                    isEmpty = i.this.f126174a.isEmpty();
                }
                if (!isEmpty) {
                    l.a().b(this, i.f126173d);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements p.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.uk.p.a
        public boolean a(Object... objArr) {
            synchronized (i.this.f126174a) {
                if (i.this.f126174a.isEmpty()) {
                    return false;
                }
                i.this.f126176c.run();
                return true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static i f126179a = new i(null);
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static int a(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 20) {
            return i3 != 60 ? 3 : 2;
        }
        return 1;
    }

    public static int c() {
        return h.f126170b.l();
    }

    public static int d() {
        return h.f126170b.h();
    }

    public i() {
        this.f126174a = new LinkedList();
        f126173d = c();
        this.f126176c = new a();
        this.f126175b = new p(f126173d, new b());
    }

    public static i b() {
        return c.f126179a;
    }

    public boolean c(k0 k0Var, com.tencent.luggage.wxa.xd.d dVar) {
        if (h.f126170b.M()) {
            return b(k0Var, dVar);
        }
        return a(k0Var, dVar);
    }

    public boolean b(k0 k0Var, com.tencent.luggage.wxa.xd.d dVar) {
        if (k0Var == null || dVar == null || !h.f126170b.a(dVar, k0Var)) {
            return false;
        }
        w.g("MicroMsg.SensorJsEventPublisher", "post direct event(event : %s).", k0Var.getName());
        k0Var.dispatch();
        return true;
    }

    public boolean a(k0 k0Var, com.tencent.luggage.wxa.xd.d dVar) {
        boolean isEmpty;
        if (k0Var == null || dVar == null || !h.f126170b.a(dVar, k0Var)) {
            return false;
        }
        synchronized (this.f126174a) {
            isEmpty = this.f126174a.isEmpty();
            if (!this.f126174a.isEmpty()) {
                if (((k0) this.f126174a.get(0)).equals(k0Var)) {
                    this.f126174a.add(0, k0Var);
                    this.f126174a.remove(1);
                } else {
                    this.f126174a.remove(k0Var);
                    this.f126174a.add(k0Var);
                }
            } else {
                this.f126174a.add(k0Var);
            }
        }
        if (isEmpty && !this.f126175b.a(new Object[0])) {
            w.g("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", k0Var.getName());
            l.a().b(this.f126176c, f126173d);
        }
        return true;
    }
}
