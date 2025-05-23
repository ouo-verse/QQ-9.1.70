package com.tencent.qmethod.pandoraex.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private final List<b> f344136a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Long, com.tencent.qmethod.pandoraex.api.t> f344137b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Comparator<com.tencent.qmethod.pandoraex.api.t> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.qmethod.pandoraex.api.t tVar, com.tencent.qmethod.pandoraex.api.t tVar2) {
            return tVar2.f343963c - tVar.f343963c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    protected static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f344139a;

        /* renamed from: b, reason: collision with root package name */
        public long f344140b;

        public b(long j3, long j16) {
            this.f344139a = j3;
            this.f344140b = j16;
        }
    }

    private void g(long j3) {
        com.tencent.qmethod.pandoraex.api.t tVar = this.f344137b.get(Long.valueOf(j3));
        if (tVar != null) {
            int i3 = tVar.f343963c - 1;
            tVar.f343963c = i3;
            if (i3 < 1) {
                this.f344137b.remove(Long.valueOf(j3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Throwable th5, String str) {
        long hashCode = str.hashCode();
        com.tencent.qmethod.pandoraex.api.t tVar = this.f344137b.get(Long.valueOf(hashCode));
        if (tVar == null) {
            this.f344137b.put(Long.valueOf(hashCode), new com.tencent.qmethod.pandoraex.api.t(th5, str, 1));
        } else {
            tVar.f343963c++;
        }
        this.f344136a.add(new b(System.currentTimeMillis(), hashCode));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long b() {
        if (this.f344136a.isEmpty()) {
            return 0L;
        }
        return Math.abs(System.currentTimeMillis() - this.f344136a.get(0).f344139a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.f344136a.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<com.tencent.qmethod.pandoraex.api.t> d() {
        ArrayList arrayList = new ArrayList(this.f344137b.values());
        if (arrayList.isEmpty()) {
            return arrayList;
        }
        Collections.sort(arrayList, new a());
        this.f344136a.clear();
        this.f344137b.clear();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (((com.tencent.qmethod.pandoraex.api.t) it.next()).f343961a == null) {
                it.remove();
                break;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i3) {
        int size = this.f344137b.size() - i3;
        Iterator<b> it = this.f344136a.iterator();
        for (int i16 = 0; it.hasNext() && i16 < size; i16++) {
            b next = it.next();
            it.remove();
            g(next.f344140b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(long j3) {
        Iterator<b> it = this.f344136a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (Math.abs(System.currentTimeMillis() - next.f344139a) > j3) {
                it.remove();
                g(next.f344140b);
            } else {
                return;
            }
        }
    }
}
