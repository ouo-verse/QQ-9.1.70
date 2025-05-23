package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a<T> implements com.google.common.base.d<Iterable<? extends T>, Iterator<? extends T>> {
        a() {
        }

        @Override // com.google.common.base.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b<T> extends l<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable f35034e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.k f35035f;

        b(Iterable iterable, com.google.common.base.k kVar) {
            this.f35034e = iterable;
            this.f35035f = kVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return r.l(this.f35034e.iterator(), this.f35035f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class c<T> extends l<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable f35036e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.d f35037f;

        c(Iterable iterable, com.google.common.base.d dVar) {
            this.f35036e = iterable;
            this.f35037f = dVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return r.x(this.f35036e.iterator(), this.f35037f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class d<T> extends l<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Iterable f35038e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f35039f;

        d(Iterable iterable, int i3) {
            this.f35038e = iterable;
            this.f35039f = i3;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return r.q(this.f35038e.iterator(), this.f35039f);
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(i.a(iterable));
        }
        return r.a(collection, ((Iterable) com.google.common.base.j.m(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, com.google.common.base.k<? super T> kVar) {
        return r.b(iterable.iterator(), kVar);
    }

    private static <E> Collection<E> c(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.j(iterable.iterator());
    }

    public static <T> Iterable<T> d(Iterable<? extends Iterable<? extends T>> iterable) {
        return l.a(iterable);
    }

    public static <T> Iterable<T> e(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return l.d(iterable, iterable2);
    }

    public static <T> Iterable<T> f(Iterable<T> iterable, com.google.common.base.k<? super T> kVar) {
        com.google.common.base.j.m(iterable);
        com.google.common.base.j.m(kVar);
        return new b(iterable, kVar);
    }

    @NullableDecl
    public static <T> T g(Iterable<? extends T> iterable, @NullableDecl T t16) {
        return (T) r.o(iterable.iterator(), t16);
    }

    public static boolean h(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> i(Iterable<T> iterable, int i3) {
        boolean z16;
        com.google.common.base.j.m(iterable);
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "limit is negative");
        return new d(iterable, i3);
    }

    public static int j(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return r.v(iterable.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] k(Iterable<?> iterable) {
        return c(iterable).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] l(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) c(iterable).toArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> com.google.common.base.d<Iterable<? extends T>, Iterator<? extends T>> m() {
        return new a();
    }

    public static String n(Iterable<?> iterable) {
        return r.w(iterable.iterator());
    }

    public static <F, T> Iterable<T> o(Iterable<F> iterable, com.google.common.base.d<? super F, ? extends T> dVar) {
        com.google.common.base.j.m(iterable);
        com.google.common.base.j.m(dVar);
        return new c(iterable, dVar);
    }
}
