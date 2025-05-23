package com.tencent.mtt.hippy.runtime.builtins.a;

import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.runtime.builtins.i;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends com.tencent.mtt.hippy.runtime.builtins.a.a {

    /* renamed from: a, reason: collision with root package name */
    private Set<Pair<String, Object>> f337567a;

    /* renamed from: b, reason: collision with root package name */
    private List<Object> f337568b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private final class a implements Iterator<Pair<String, Object>> {

        /* renamed from: b, reason: collision with root package name */
        private final Iterator<Pair<String, Object>> f337570b;

        /* renamed from: c, reason: collision with root package name */
        private int f337571c = 0;

        a() {
            this.f337570b = b.super.i().iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<String, Object> next() {
            if (this.f337571c < b.this.h()) {
                Pair<String, Object> pair = new Pair<>(String.valueOf(this.f337571c), b.this.a(this.f337571c));
                this.f337571c++;
                return pair;
            }
            return this.f337570b.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f337571c >= b.this.h() && !this.f337570b.hasNext()) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mtt.hippy.runtime.builtins.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    private final class C9230b extends AbstractSet<Pair<String, Object>> {
        C9230b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Pair<String, Object>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return b.this.b();
        }
    }

    public b() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        return h() + super.h();
    }

    public void c(Object obj) {
        this.f337568b.add(obj);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public int h() {
        return this.f337568b.size();
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public Set<Pair<String, Object>> i() {
        Set<Pair<String, Object>> set = this.f337567a;
        if (set == null) {
            C9230b c9230b = new C9230b();
            this.f337567a = c9230b;
            return c9230b;
        }
        return set;
    }

    @Override // java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f337568b.iterator();
    }

    public b(int i3) {
        this.f337568b = new ArrayList(i3);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        ArrayList arrayList = new ArrayList(this.f337568b.size());
        Iterator<Object> it = this.f337568b.iterator();
        while (it.hasNext()) {
            arrayList.add(i.b(it.next()));
        }
        bVar.f337568b = arrayList;
        return bVar;
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.a.a
    public Object a(int i3) {
        return this.f337568b.get(i3);
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.a.a
    public Object a(int i3, Object obj) {
        return this.f337568b.set(i3, obj);
    }
}
