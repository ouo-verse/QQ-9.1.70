package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Suppliers {

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class MemoizingSupplier<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;
        final o<T> delegate;
        volatile transient boolean initialized;

        @NullableDecl
        transient T value;

        MemoizingSupplier(o<T> oVar) {
            this.delegate = (o) j.m(oVar);
        }

        @Override // com.google.common.base.o
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t16 = this.delegate.get();
                        this.value = t16;
                        this.initialized = true;
                        return t16;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb5.append(obj);
            sb5.append(")");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SupplierOfInstance<T> implements o<T>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final T instance;

        SupplierOfInstance(@NullableDecl T t16) {
            this.instance = t16;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return g.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.o
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return g.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class a<T> implements o<T> {

        /* renamed from: d, reason: collision with root package name */
        volatile o<T> f34674d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f34675e;

        /* renamed from: f, reason: collision with root package name */
        @NullableDecl
        T f34676f;

        a(o<T> oVar) {
            this.f34674d = (o) j.m(oVar);
        }

        @Override // com.google.common.base.o
        public T get() {
            if (!this.f34675e) {
                synchronized (this) {
                    if (!this.f34675e) {
                        T t16 = this.f34674d.get();
                        this.f34676f = t16;
                        this.f34675e = true;
                        this.f34674d = null;
                        return t16;
                    }
                }
            }
            return this.f34676f;
        }

        public String toString() {
            Object obj = this.f34674d;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.f34676f + ">";
            }
            sb5.append(obj);
            sb5.append(")");
            return sb5.toString();
        }
    }

    public static <T> o<T> a(o<T> oVar) {
        if (!(oVar instanceof a) && !(oVar instanceof MemoizingSupplier)) {
            if (oVar instanceof Serializable) {
                return new MemoizingSupplier(oVar);
            }
            return new a(oVar);
        }
        return oVar;
    }

    public static <T> o<T> b(@NullableDecl T t16) {
        return new SupplierOfInstance(t16);
    }
}
