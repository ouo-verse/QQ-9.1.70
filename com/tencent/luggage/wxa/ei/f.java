package com.tencent.luggage.wxa.ei;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f124896f = true;

    /* renamed from: a, reason: collision with root package name */
    public final a f124897a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f124898b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f124899c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f124900d = false;

    /* renamed from: e, reason: collision with root package name */
    public String f124901e = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        com.tencent.luggage.wxa.b9.t a(int i3);

        com.tencent.luggage.wxa.b9.t a(int i3, int i16);
    }

    public f(a aVar) {
        if (!f124896f && aVar == null) {
            throw new AssertionError();
        }
        this.f124897a = aVar;
        this.f124898b = new AtomicInteger(1);
        this.f124899c = new SparseArray();
    }

    public static int c() {
        return 1;
    }

    public void a(e eVar) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8ContextMgr", "setMainContext id:%d", 1);
        synchronized (this.f124899c) {
            this.f124899c.put(1, eVar);
        }
        eVar.C().a((y) null);
        if (this.f124900d) {
            eVar.C().b(this.f124901e);
        }
    }

    public void b(int i3) {
        e eVar;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8ContextMgr", "destroyJsContext id:%d", Integer.valueOf(i3));
        synchronized (this.f124899c) {
            eVar = (e) this.f124899c.get(i3);
            this.f124899c.delete(i3);
        }
        if (eVar != null) {
            eVar.destroy();
        }
    }

    public h d() {
        return c(1);
    }

    public h c(int i3) {
        h hVar;
        synchronized (this.f124899c) {
            hVar = (h) this.f124899c.get(i3);
        }
        return hVar;
    }

    public void b() {
        synchronized (this.f124899c) {
            for (int i3 = 0; i3 < this.f124899c.size(); i3++) {
                int keyAt = this.f124899c.keyAt(i3);
                if (keyAt != 1) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d", Integer.valueOf(keyAt));
                    if (this.f124899c.get(keyAt) == null) {
                        com.tencent.luggage.wxa.tn.w.h("MicroMsg.AppBrandJ2V8ContextMgr", "destroyRestButNotMainContext contextId:%d null", Integer.valueOf(keyAt));
                    } else {
                        ((e) this.f124899c.get(keyAt)).destroy();
                    }
                }
            }
            this.f124899c.clear();
        }
    }

    public h a() {
        int incrementAndGet = this.f124898b.incrementAndGet();
        g gVar = new g(this.f124897a.a(incrementAndGet), incrementAndGet);
        synchronized (this.f124899c) {
            this.f124899c.put(incrementAndGet, gVar);
        }
        gVar.C().a((y) null);
        if (this.f124900d) {
            gVar.C().b(this.f124901e);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", Integer.valueOf(incrementAndGet));
        return gVar;
    }

    public h a(int i3) {
        int incrementAndGet = this.f124898b.incrementAndGet();
        g gVar = new g(this.f124897a.a(incrementAndGet, i3), incrementAndGet);
        if (gVar.C().j() == null) {
            return null;
        }
        synchronized (this.f124899c) {
            this.f124899c.put(incrementAndGet, gVar);
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContextFromSnapshot id:%d, index: %d", Integer.valueOf(incrementAndGet), Integer.valueOf(i3));
        return gVar;
    }

    public final List a(boolean z16) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f124899c) {
            for (int i3 = 0; i3 < this.f124899c.size(); i3++) {
                e eVar = (e) this.f124899c.valueAt(i3);
                if (!eVar.n() || z16) {
                    linkedList.add(eVar);
                }
            }
        }
        return linkedList;
    }
}
