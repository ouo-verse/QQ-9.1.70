package com.tencent.luggage.wxa.so;

import android.os.Build;
import com.tencent.luggage.wxa.so.a;
import com.tencent.luggage.wxa.tn.w;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final Future[] f140449a = {null};

    /* renamed from: b, reason: collision with root package name */
    public final d f140450b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f140451c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f140452d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        Object call();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        Object get();

        boolean hasValue();

        Object reset();

        void set(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f140453a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference f140454b;

        public e() {
            this.f140453a = new AtomicBoolean(false);
            this.f140454b = new AtomicReference();
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public Object get() {
            return this.f140454b.get();
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public boolean hasValue() {
            return this.f140453a.get();
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public Object reset() {
            Object andUpdate;
            andUpdate = this.f140454b.getAndUpdate(new UnaryOperator() { // from class: c41.c
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Object a16;
                    a16 = a.e.this.a(obj);
                    return a16;
                }
            });
            return andUpdate;
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public void set(final Object obj) {
            this.f140454b.getAndUpdate(new UnaryOperator() { // from class: c41.d
                @Override // java.util.function.Function
                public final Object apply(Object obj2) {
                    Object a16;
                    a16 = a.e.this.a(obj, obj2);
                    return a16;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object a(Object obj, Object obj2) {
            this.f140453a.set(true);
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object a(Object obj) {
            this.f140453a.set(false);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f140455a;

        /* renamed from: b, reason: collision with root package name */
        public Object f140456b;

        public f() {
            this.f140455a = false;
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public synchronized Object get() {
            return this.f140456b;
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public synchronized boolean hasValue() {
            return this.f140455a;
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public synchronized Object reset() {
            Object obj;
            obj = this.f140456b;
            this.f140456b = null;
            this.f140455a = false;
            return obj;
        }

        @Override // com.tencent.luggage.wxa.so.a.d
        public synchronized void set(Object obj) {
            this.f140456b = obj;
            this.f140455a = true;
        }
    }

    public a() {
        d fVar;
        if (Build.VERSION.SDK_INT >= 24) {
            fVar = new e();
        } else {
            fVar = new f();
        }
        this.f140450b = fVar;
        this.f140451c = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object b(b bVar) {
        try {
            if (this.f140451c.get()) {
                return null;
            }
            Object call = bVar.call();
            if (this.f140451c.get()) {
                if (call != null && this.f140452d != null) {
                    this.f140452d.a(call);
                }
                return null;
            }
            this.f140450b.set(call);
            return call;
        } catch (Exception e16) {
            if ((e16 instanceof CancellationException) || (e16 instanceof InterruptedException)) {
                return null;
            }
            throw e16;
        }
    }

    public void c(final b bVar) {
        if (this.f140450b.hasValue()) {
            return;
        }
        Future[] futureArr = this.f140449a;
        if (futureArr[0] == null) {
            synchronized (futureArr) {
                Future[] futureArr2 = this.f140449a;
                if (futureArr2[0] == null) {
                    futureArr2[0] = com.tencent.luggage.wxa.zp.h.f146825d.b(new Callable() { // from class: c41.a
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Object b16;
                            b16 = com.tencent.luggage.wxa.so.a.this.b(bVar);
                            return b16;
                        }
                    });
                }
            }
        }
    }

    public void a(b bVar) {
        if (this.f140450b.hasValue()) {
            return;
        }
        Future[] futureArr = this.f140449a;
        if (futureArr[0] != null) {
            synchronized (futureArr) {
                Future future = this.f140449a[0];
                if (future != null) {
                    future.cancel(true);
                    this.f140449a[0] = null;
                }
            }
        }
        this.f140450b.set(bVar.call());
    }

    public Object a() {
        Object obj;
        if (this.f140450b.hasValue()) {
            return this.f140450b.get();
        }
        try {
            Future[] futureArr = this.f140449a;
            Future future = futureArr[0];
            if (future == null) {
                synchronized (futureArr) {
                    Objects.requireNonNull(this.f140449a[0]);
                    obj = this.f140449a[0].get();
                }
                return obj;
            }
            return future.get();
        } catch (Exception e16) {
            w.b("MicroMsg.AsyncComputedValue", "get() exception(%s) occurs", e16);
            return null;
        }
    }

    public void a(c cVar) {
        this.f140451c.set(true);
        Object reset = this.f140450b.reset();
        if (reset == null) {
            this.f140452d = cVar;
        } else if (cVar != null) {
            cVar.a(reset);
        }
    }
}
