package com.tencent.beacon.a.a;

import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.beacon.a.b.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f77578a;

    /* renamed from: c, reason: collision with root package name */
    private final Object f77580c = new Object();

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f77583f = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<List<d>> f77579b = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<List<c>> f77581d = new SparseArray<>();

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<Object> f77582e = new SparseArray<>();

    b() {
    }

    public static b a() {
        if (f77578a == null) {
            synchronized (b.class) {
                if (f77578a == null) {
                    f77578a = new b();
                }
            }
        }
        return f77578a;
    }

    private void c(c cVar) {
        d(cVar);
        synchronized (b(cVar.f77584a)) {
            List<d> c16 = c(cVar.f77584a);
            if (c16 == null) {
                return;
            }
            Iterator<d> it = c16.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(cVar);
                } catch (Throwable th5) {
                    com.tencent.beacon.base.util.c.a(th5);
                    if (this.f77583f.compareAndSet(false, true)) {
                        i.e().a("512", "dispatchEvent error", th5);
                    }
                }
            }
        }
    }

    public void b(@NonNull c cVar) {
        synchronized (b(cVar.f77584a)) {
            c cVar2 = new c(cVar.f77584a, cVar.f77585b);
            List<c> list = this.f77581d.get(cVar2.f77584a);
            if (list == null) {
                list = new ArrayList<>();
                this.f77581d.put(cVar2.f77584a, list);
            }
            list.add(cVar2);
            c(cVar);
        }
    }

    public void a(int i3, d dVar) {
        synchronized (b(i3)) {
            List<d> list = this.f77579b.get(i3);
            if (list == null) {
                list = new ArrayList<>();
                this.f77579b.put(i3, list);
            }
            if (list.contains(dVar)) {
                return;
            }
            list.add(dVar);
            List<c> list2 = this.f77581d.get(i3);
            if (list2 != null) {
                Iterator<c> it = list2.iterator();
                while (it.hasNext()) {
                    try {
                        dVar.a(it.next());
                    } catch (Throwable th5) {
                        com.tencent.beacon.base.util.c.a(th5);
                    }
                }
                if (i3 == 6 || i3 == 12) {
                    a(i3);
                }
            }
        }
    }

    private Object b(int i3) {
        Object obj;
        synchronized (this.f77580c) {
            obj = this.f77582e.get(i3);
            if (obj == null) {
                obj = new Object();
                this.f77582e.put(i3, obj);
            }
        }
        return obj;
    }

    private List<d> c(int i3) {
        List<d> list = this.f77579b.get(i3);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    public void a(@NonNull c cVar) {
        com.tencent.beacon.a.b.a.a().a(new a(this, cVar));
    }

    public void a(int i3) {
        synchronized (b(i3)) {
            this.f77581d.remove(i3);
        }
    }

    private void d(c cVar) {
    }
}
