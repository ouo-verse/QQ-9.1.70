package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.o;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.q;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final com.google.common.base.d<K, V> computingFunction;

        public FunctionToCacheLoader(com.google.common.base.d<K, V> dVar) {
            this.computingFunction = (com.google.common.base.d) com.google.common.base.j.m(dVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k3) {
            return (V) this.computingFunction.apply(com.google.common.base.j.m(k3));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final o<V> computingSupplier;

        public SupplierToCacheLoader(o<V> oVar) {
            this.computingSupplier = (o) com.google.common.base.j.m(oVar);
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            com.google.common.base.j.m(obj);
            return this.computingSupplier.get();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a extends CacheLoader<K, V> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Executor f34738e;

        /* compiled from: P */
        /* renamed from: com.google.common.cache.CacheLoader$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class CallableC0245a implements Callable<V> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Object f34739d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Object f34740e;

            CallableC0245a(Object obj, Object obj2) {
                this.f34739d = obj;
                this.f34740e = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                return CacheLoader.this.reload(this.f34739d, this.f34740e).get();
            }
        }

        a(Executor executor) {
            this.f34738e = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k3) throws Exception {
            return (V) CacheLoader.this.load(k3);
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            return CacheLoader.this.loadAll(iterable);
        }

        @Override // com.google.common.cache.CacheLoader
        public q<V> reload(K k3, V v3) throws Exception {
            ListenableFutureTask a16 = ListenableFutureTask.a(new CallableC0245a(k3, v3));
            this.f34738e.execute(a16);
            return a16;
        }
    }

    @GwtIncompatible
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        com.google.common.base.j.m(cacheLoader);
        com.google.common.base.j.m(executor);
        return new a(executor);
    }

    public static <K, V> CacheLoader<K, V> from(com.google.common.base.d<K, V> dVar) {
        return new FunctionToCacheLoader(dVar);
    }

    public abstract V load(K k3) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    @GwtIncompatible
    public q<V> reload(K k3, V v3) throws Exception {
        com.google.common.base.j.m(k3);
        com.google.common.base.j.m(v3);
        return Futures.c(load(k3));
    }

    public static <V> CacheLoader<Object, V> from(o<V> oVar) {
        return new SupplierToCacheLoader(oVar);
    }
}
