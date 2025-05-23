package com.tencent.luggage.wxa.uk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k0 implements u {

    /* renamed from: c, reason: collision with root package name */
    public static final a f142752c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f142753a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f142754b = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final ReentrantLock f142755a;

        /* renamed from: b, reason: collision with root package name */
        public final Condition f142756b;

        public b(ReentrantLock lock, Condition condition) {
            Intrinsics.checkNotNullParameter(lock, "lock");
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.f142755a = lock;
            this.f142756b = condition;
        }

        public final Condition a() {
            return this.f142756b;
        }

        public final ReentrantLock b() {
            return this.f142755a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (Intrinsics.areEqual(this.f142755a, bVar.f142755a) && Intrinsics.areEqual(this.f142756b, bVar.f142756b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f142755a.hashCode() * 31) + this.f142756b.hashCode();
        }

        public String toString() {
            return "LockAndCondition(lock=" + this.f142755a + ", condition=" + this.f142756b + ')';
        }
    }

    @Override // com.tencent.luggage.wxa.uk.u
    public void a(String tag, Object obj) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        b bVar = (b) this.f142753a.remove(tag);
        if (bVar != null) {
            this.f142754b.put(tag, obj);
            bVar.b().lock();
            bVar.a().signalAll();
            bVar.b().unlock();
        }
    }

    @Override // com.tencent.luggage.wxa.uk.u
    public Object b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return this.f142754b.get(tag);
    }

    public boolean h(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (this.f142753a.get(tag) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.uk.u
    public void i(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        ConcurrentHashMap concurrentHashMap = this.f142753a;
        Intrinsics.checkNotNullExpressionValue(condition, "condition");
        concurrentHashMap.put(tag, new b(reentrantLock, condition));
    }

    @Override // com.tencent.luggage.wxa.uk.u
    public boolean a(String tag, long j3) {
        b bVar;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!h(tag) || (bVar = (b) this.f142753a.get(tag)) == null) {
            return true;
        }
        bVar.b().lock();
        try {
            try {
                bVar.a().await(j3, TimeUnit.MILLISECONDS);
                return true;
            } catch (InterruptedException unused) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.SyncWaiter", "hy: wait from async fail due to timeout!");
                bVar.b().unlock();
                return false;
            }
        } finally {
            bVar.b().unlock();
        }
    }
}
