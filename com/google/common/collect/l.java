package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class l<E> implements Iterable<E> {

    /* renamed from: d, reason: collision with root package name */
    private final Optional<Iterable<E>> f35029d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a extends l<E> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable f35030e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f35030e = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f35030e.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<T> extends l<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable f35031e;

        b(Iterable iterable) {
            this.f35031e = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return r.e(r.x(this.f35031e.iterator(), q.m()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c<T> extends l<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable[] f35032e;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends com.google.common.collect.a<Iterator<? extends T>> {
            a(int i3) {
                super(i3);
            }

            @Override // com.google.common.collect.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i3) {
                return c.this.f35032e[i3].iterator();
            }
        }

        c(Iterable[] iterableArr) {
            this.f35032e = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return r.e(new a(this.f35032e.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l() {
        this.f35029d = Optional.absent();
    }

    @Beta
    public static <T> l<T> a(Iterable<? extends Iterable<? extends T>> iterable) {
        com.google.common.base.j.m(iterable);
        return new b(iterable);
    }

    @Beta
    public static <T> l<T> d(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return g(iterable, iterable2);
    }

    private static <T> l<T> g(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.j.m(iterable);
        }
        return new c(iterableArr);
    }

    public static <E> l<E> i(Iterable<E> iterable) {
        if (iterable instanceof l) {
            return (l) iterable;
        }
        return new a(iterable, iterable);
    }

    private Iterable<E> m() {
        return this.f35029d.or((Optional<Iterable<E>>) this);
    }

    public final l<E> h(com.google.common.base.k<? super E> kVar) {
        return i(q.f(m(), kVar));
    }

    public final l<E> n(int i3) {
        return i(q.i(m(), i3));
    }

    public final <T> l<T> o(com.google.common.base.d<? super E, T> dVar) {
        return i(q.o(m(), dVar));
    }

    public String toString() {
        return q.n(m());
    }

    l(Iterable<E> iterable) {
        com.google.common.base.j.m(iterable);
        this.f35029d = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
