package com.tencent.mtt.hippy.runtime.builtins.a;

import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mtt.hippy.runtime.builtins.f;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends com.tencent.mtt.hippy.runtime.builtins.a.a {

    /* renamed from: a, reason: collision with root package name */
    private Set<Pair<String, Object>> f337573a;

    /* renamed from: b, reason: collision with root package name */
    private Set<Pair<Integer, Object>> f337574b;

    /* renamed from: c, reason: collision with root package name */
    private SparseArray<Object> f337575c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private final class a implements Iterator<Pair<String, Object>> {

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<Pair<String, Object>> f337577b;

        /* renamed from: c, reason: collision with root package name */
        private int f337578c = 0;

        a() {
            this.f337577b = c.super.i().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<String, Object> next() {
            if (this.f337578c < c.this.h()) {
                Pair<String, Object> pair = new Pair<>(String.valueOf(c.this.f337575c.keyAt(this.f337578c)), c.this.f337575c.valueAt(this.f337578c));
                this.f337578c++;
                return pair;
            }
            return this.f337577b.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337578c >= c.this.f337575c.size() && !this.f337577b.hasNext()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private final class b extends AbstractSet<Pair<String, Object>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Pair<String, Object>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.c();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.runtime.builtins.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private final class C9231c implements Iterator<Pair<Integer, Object>> {

        /* renamed from: b, reason: collision with root package name */
        private int f337581b;

        C9231c() {
            this.f337581b = 0;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<Integer, Object> next() {
            if (this.f337581b < c.this.f337575c.size()) {
                Pair<Integer, Object> pair = new Pair<>(Integer.valueOf(c.this.f337575c.keyAt(this.f337581b)), c.this.f337575c.valueAt(this.f337581b));
                this.f337581b++;
                return pair;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337581b < c.this.f337575c.size()) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private final class d extends AbstractSet<Pair<Integer, Object>> {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Pair<Integer, Object>> iterator() {
            return new C9231c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.f337575c.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private final class e implements Iterator<Object> {

        /* renamed from: b, reason: collision with root package name */
        private int f337584b;

        /* renamed from: c, reason: collision with root package name */
        private int f337585c;

        e() {
            this.f337584b = 0;
            this.f337585c = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337585c < c.this.f337575c.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.f337585c < c.this.f337575c.size()) {
                int keyAt = c.this.f337575c.keyAt(this.f337585c);
                int i3 = this.f337584b;
                this.f337584b = i3 + 1;
                if (keyAt == i3) {
                    SparseArray sparseArray = c.this.f337575c;
                    int i16 = this.f337585c;
                    this.f337585c = i16 + 1;
                    return sparseArray.valueAt(i16);
                }
                return f.f337626a;
            }
            throw new NoSuchElementException();
        }
    }

    public c() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        return this.f337575c.size() + super.h();
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public int h() {
        return this.f337575c.keyAt(r0.size() - 1);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public Set<Pair<String, Object>> i() {
        Set<Pair<String, Object>> set = this.f337573a;
        if (set == null) {
            b bVar = new b();
            this.f337573a = bVar;
            return bVar;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return new e();
    }

    public c(int i3) {
        this.f337575c = new SparseArray<>(i3);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.a.a
    public Object a(int i3) {
        int h16 = h();
        if (i3 < h16) {
            return this.f337575c.get(i3, f.f337626a);
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + h16);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c clone() throws CloneNotSupportedException {
        c cVar = (c) super.clone();
        SparseArray<Object> sparseArray = new SparseArray<>(this.f337575c.size());
        for (int i3 = 0; i3 < this.f337575c.size(); i3++) {
            sparseArray.append(this.f337575c.keyAt(i3), this.f337575c.valueAt(i3));
        }
        cVar.f337575c = sparseArray;
        return cVar;
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.a.a
    public Object a(int i3, Object obj) {
        int h16 = h();
        if (i3 < h16) {
            this.f337575c.put(i3, obj);
            return obj;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + h16);
    }

    public Set<Pair<Integer, Object>> a() {
        Set<Pair<Integer, Object>> set = this.f337574b;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.f337574b = dVar;
        return dVar;
    }
}
