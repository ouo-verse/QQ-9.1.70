package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.ForOverride;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Equivalence<T> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class EquivalentToPredicate<T> implements k<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @NullableDecl
        private final T target;

        EquivalentToPredicate(Equivalence<T> equivalence, @NullableDecl T t16) {
            this.equivalence = (Equivalence) j.m(equivalence);
            this.target = t16;
        }

        @Override // com.google.common.base.k
        public boolean apply(@NullableDecl T t16) {
            return this.equivalence.equivalent(t16, this.target);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            if (this.equivalence.equals(equivalentToPredicate.equivalence) && g.a(this.target, equivalentToPredicate.target)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return g.b(this.equivalence, this.target);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @NullableDecl
        private final T reference;

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Wrapper) {
                Wrapper wrapper = (Wrapper) obj;
                if (this.equivalence.equals(wrapper.equivalence)) {
                    return this.equivalence.equivalent(this.reference, wrapper.reference);
                }
                return false;
            }
            return false;
        }

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        Wrapper(Equivalence<? super T> equivalence, @NullableDecl T t16) {
            this.equivalence = (Equivalence) j.m(equivalence);
            this.reference = t16;
        }
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    @ForOverride
    protected abstract boolean doEquivalent(T t16, T t17);

    @ForOverride
    protected abstract int doHash(T t16);

    public final boolean equivalent(@NullableDecl T t16, @NullableDecl T t17) {
        if (t16 == t17) {
            return true;
        }
        if (t16 != null && t17 != null) {
            return doEquivalent(t16, t17);
        }
        return false;
    }

    public final k<T> equivalentTo(@NullableDecl T t16) {
        return new EquivalentToPredicate(this, t16);
    }

    public final int hash(@NullableDecl T t16) {
        if (t16 == null) {
            return 0;
        }
        return doHash(t16);
    }

    public final <F> Equivalence<F> onResultOf(d<F, ? extends T> dVar) {
        return new FunctionalEquivalence(dVar, this);
    }

    @GwtCompatible(serializable = true)
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S s16) {
        return new Wrapper<>(s16);
    }
}
