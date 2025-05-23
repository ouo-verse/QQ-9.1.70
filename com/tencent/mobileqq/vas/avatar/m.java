package com.tencent.mobileqq.vas.avatar;

import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m<V> implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b<V>> f308815d = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a<E> {
        void onComplete(E e16, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class b<E> {

        /* renamed from: a, reason: collision with root package name */
        public a<E> f308816a;

        /* renamed from: b, reason: collision with root package name */
        public String f308817b;

        /* renamed from: c, reason: collision with root package name */
        public Object f308818c;

        public b(a<E> aVar, Object obj, String str) {
            this.f308816a = aVar;
            this.f308818c = obj;
            this.f308817b = str;
        }
    }

    public void a(String str, V v3) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f308815d) {
            for (int size = this.f308815d.size() - 1; size >= 0; size--) {
                b<V> bVar = this.f308815d.get(size);
                if (str.equals(bVar.f308817b)) {
                    this.f308815d.remove(size);
                    arrayList.add(bVar);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            bVar2.f308816a.onComplete(v3, bVar2.f308818c);
        }
    }

    public void b(String str, a<V> aVar, Object obj) {
        if (aVar != null) {
            b<V> bVar = new b<>(aVar, obj, str);
            synchronized (this.f308815d) {
                this.f308815d.add(bVar);
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        synchronized (this.f308815d) {
            this.f308815d.clear();
        }
    }
}
