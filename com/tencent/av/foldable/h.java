package com.tencent.av.foldable;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h<T> {

    /* renamed from: d, reason: collision with root package name */
    private T f73752d;

    /* renamed from: e, reason: collision with root package name */
    private final List<a<T>> f73753e = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a<V> {
        void a(V v3);
    }

    public h(T t16) {
        this.f73752d = t16;
    }

    public void a() {
        this.f73753e.clear();
    }

    public T b() {
        return this.f73752d;
    }

    public void c(a<T> aVar) {
        this.f73753e.add(aVar);
    }

    public void e(T t16) {
        T t17 = this.f73752d;
        if (t17 == null && t16 == null) {
            return;
        }
        if (t17 != null && t17.equals(t16)) {
            return;
        }
        if (t16 != null && t16.equals(this.f73752d)) {
            return;
        }
        this.f73752d = t16;
        for (a<T> aVar : this.f73753e) {
            if (aVar != null) {
                aVar.a(t16);
            }
        }
    }

    public void d() {
    }
}
