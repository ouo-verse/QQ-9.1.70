package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements Iterable<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Iterable f34671d;

        /* compiled from: P */
        /* renamed from: com.google.common.base.Optional$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0242a extends AbstractIterator<T> {

            /* renamed from: f, reason: collision with root package name */
            private final Iterator<? extends Optional<? extends T>> f34672f;

            C0242a() {
                this.f34672f = (Iterator) j.m(a.this.f34671d.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            protected T a() {
                while (this.f34672f.hasNext()) {
                    Optional<? extends T> next = this.f34672f.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        a(Iterable iterable) {
            this.f34671d = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C0242a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t16) {
        if (t16 == null) {
            return absent();
        }
        return new Present(t16);
    }

    public static <T> Optional<T> of(T t16) {
        return new Present(j.m(t16));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        j.m(iterable);
        return new a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(o<? extends T> oVar);

    public abstract T or(T t16);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(d<? super T, V> dVar);
}
