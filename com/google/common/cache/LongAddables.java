package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.o;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class LongAddables {

    /* renamed from: a, reason: collision with root package name */
    private static final o<g> f34811a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements g {
        PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.g
        public void add(long j3) {
            getAndAdd(j3);
        }

        @Override // com.google.common.cache.g
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.g
        public long sum() {
            return get();
        }

        /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements o<g> {
        a() {
        }

        @Override // com.google.common.base.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g get() {
            return new LongAdder();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements o<g> {
        b() {
        }

        @Override // com.google.common.base.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        o<g> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f34811a = bVar;
    }

    public static g a() {
        return f34811a.get();
    }
}
