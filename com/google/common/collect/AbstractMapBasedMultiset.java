package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class AbstractMapBasedMultiset<E> extends d<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient w<E> backingMap;
    transient long size;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends AbstractMapBasedMultiset<E>.c<E> {
        a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        E b(int i3) {
            return AbstractMapBasedMultiset.this.backingMap.i(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b extends AbstractMapBasedMultiset<E>.c<u.a<E>> {
        b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultiset.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public u.a<E> b(int i3) {
            return AbstractMapBasedMultiset.this.backingMap.g(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    abstract class c<T> implements Iterator<T> {

        /* renamed from: d, reason: collision with root package name */
        int f34833d;

        /* renamed from: e, reason: collision with root package name */
        int f34834e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f34835f;

        c() {
            this.f34833d = AbstractMapBasedMultiset.this.backingMap.e();
            this.f34835f = AbstractMapBasedMultiset.this.backingMap.f35066d;
        }

        private void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f35066d == this.f34835f) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        abstract T b(int i3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            if (this.f34833d >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T b16 = b(this.f34833d);
                int i3 = this.f34833d;
                this.f34834e = i3;
                this.f34833d = AbstractMapBasedMultiset.this.backingMap.s(i3);
                return b16;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z16;
            a();
            if (this.f34834e != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            h.d(z16);
            AbstractMapBasedMultiset.this.size -= r0.backingMap.x(this.f34834e);
            this.f34833d = AbstractMapBasedMultiset.this.backingMap.t(this.f34833d, this.f34834e);
            this.f34834e = -1;
            this.f34835f = AbstractMapBasedMultiset.this.backingMap.f35066d;
        }
    }

    AbstractMapBasedMultiset(int i3) {
        init(i3);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int c16 = aa.c(objectInputStream);
        init(3);
        aa.b(this, objectInputStream, c16);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        aa.e(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.u
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e16, int i3) {
        boolean z16;
        if (i3 == 0) {
            return count(e16);
        }
        boolean z17 = true;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.f(z16, "occurrences cannot be negative: %s", i3);
        int m3 = this.backingMap.m(e16);
        if (m3 == -1) {
            this.backingMap.u(e16, i3);
            this.size += i3;
            return 0;
        }
        int k3 = this.backingMap.k(m3);
        long j3 = i3;
        long j16 = k3 + j3;
        if (j16 > TTL.MAX_VALUE) {
            z17 = false;
        }
        com.google.common.base.j.g(z17, "too many occurrences: %s", j16);
        this.backingMap.B(m3, (int) j16);
        this.size += j3;
        return k3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTo(u<? super E> uVar) {
        com.google.common.base.j.m(uVar);
        int e16 = this.backingMap.e();
        while (e16 >= 0) {
            uVar.add(this.backingMap.i(e16), this.backingMap.k(e16));
            e16 = this.backingMap.s(e16);
        }
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.u
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.f(obj);
    }

    @Override // com.google.common.collect.d
    final int distinctElements() {
        return this.backingMap.C();
    }

    @Override // com.google.common.collect.d
    final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d
    final Iterator<u.a<E>> entryIterator() {
        return new b();
    }

    abstract void init(int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return Multisets.h(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.u
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i3) {
        boolean z16;
        if (i3 == 0) {
            return count(obj);
        }
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.f(z16, "occurrences cannot be negative: %s", i3);
        int m3 = this.backingMap.m(obj);
        if (m3 == -1) {
            return 0;
        }
        int k3 = this.backingMap.k(m3);
        if (k3 > i3) {
            this.backingMap.B(m3, k3 - i3);
        } else {
            this.backingMap.x(m3);
            i3 = k3;
        }
        this.size -= i3;
        return k3;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.u
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e16, int i3) {
        h.b(i3, "count");
        w<E> wVar = this.backingMap;
        int v3 = i3 == 0 ? wVar.v(e16) : wVar.u(e16, i3);
        this.size += i3 - v3;
        return v3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u
    public final int size() {
        return s1.c.b(this.size);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.u
    public final boolean setCount(@NullableDecl E e16, int i3, int i16) {
        h.b(i3, "oldCount");
        h.b(i16, "newCount");
        int m3 = this.backingMap.m(e16);
        if (m3 == -1) {
            if (i3 != 0) {
                return false;
            }
            if (i16 > 0) {
                this.backingMap.u(e16, i16);
                this.size += i16;
            }
            return true;
        }
        if (this.backingMap.k(m3) != i3) {
            return false;
        }
        if (i16 == 0) {
            this.backingMap.x(m3);
            this.size -= i3;
        } else {
            this.backingMap.B(m3, i16);
            this.size += i16 - i3;
        }
        return true;
    }
}
