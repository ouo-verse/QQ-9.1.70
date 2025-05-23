package com.tencent.mtt.hippy.dom;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<com.tencent.mtt.hippy.dom.node.b> f337296a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final SparseBooleanArray f337297b = new SparseBooleanArray();

    public synchronized int a() {
        return this.f337297b.size();
    }

    public synchronized void b() {
        this.f337296a.clear();
        this.f337297b.clear();
    }

    public synchronized com.tencent.mtt.hippy.dom.node.b c(int i3) {
        return this.f337296a.get(i3);
    }

    public synchronized int d(int i3) {
        return this.f337297b.keyAt(i3);
    }

    public synchronized void a(int i3) {
        this.f337296a.remove(i3);
    }

    public synchronized void b(int i3) {
        this.f337296a.remove(i3);
        this.f337297b.delete(i3);
    }

    public synchronized void a(com.tencent.mtt.hippy.dom.node.b bVar) {
        int id5 = bVar.getId();
        this.f337296a.put(id5, bVar);
        this.f337297b.put(id5, true);
    }

    public synchronized void b(com.tencent.mtt.hippy.dom.node.b bVar) {
        this.f337296a.put(bVar.getId(), bVar);
    }
}
