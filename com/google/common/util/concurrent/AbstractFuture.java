package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.j2objc.annotations.ReflectionSupport;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;

/* compiled from: P */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> extends t1.a implements q<V> {
    private static final Object C;

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f35075h = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: i, reason: collision with root package name */
    private static final Logger f35076i = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: m, reason: collision with root package name */
    private static final b f35077m;

    /* renamed from: d, reason: collision with root package name */
    @NullableDecl
    private volatile Object f35078d;

    /* renamed from: e, reason: collision with root package name */
    @NullableDecl
    private volatile d f35079e;

    /* renamed from: f, reason: collision with root package name */
    @NullableDecl
    private volatile j f35080f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        static final Failure f35081b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        final Throwable f35082a;

        Failure(Throwable th5) {
            this.f35082a = (Throwable) com.google.common.base.j.m(th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class SetFuture<V> implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final AbstractFuture<V> f35083d;

        /* renamed from: e, reason: collision with root package name */
        final q<? extends V> f35084e;

        SetFuture(AbstractFuture<V> abstractFuture, q<? extends V> qVar) {
            this.f35083d = abstractFuture;
            this.f35084e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.f35083d).f35078d == this) {
                if (AbstractFuture.f35077m.b(this.f35083d, this, AbstractFuture.w(this.f35084e))) {
                    AbstractFuture.t(this.f35083d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b {
        b() {
        }

        abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        abstract boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2);

        abstract void d(j jVar, j jVar2);

        abstract void e(j jVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        static final c f35085c;

        /* renamed from: d, reason: collision with root package name */
        static final c f35086d;

        /* renamed from: a, reason: collision with root package name */
        final boolean f35087a;

        /* renamed from: b, reason: collision with root package name */
        @NullableDecl
        final Throwable f35088b;

        static {
            if (AbstractFuture.f35075h) {
                f35086d = null;
                f35085c = null;
            } else {
                f35086d = new c(false, null);
                f35085c = new c(true, null);
            }
        }

        c(boolean z16, @NullableDecl Throwable th5) {
            this.f35087a = z16;
            this.f35088b = th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: d, reason: collision with root package name */
        static final d f35089d = new d(null, null);

        /* renamed from: a, reason: collision with root package name */
        final Runnable f35090a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f35091b;

        /* renamed from: c, reason: collision with root package name */
        @NullableDecl
        d f35092c;

        d(Runnable runnable, Executor executor) {
            this.f35090a = runnable;
            this.f35091b = executor;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class e extends b {

        /* renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, Thread> f35093a;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<j, j> f35094b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, j> f35095c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, d> f35096d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f35097e;

        e(AtomicReferenceFieldUpdater<j, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<j, j> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, j> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f35093a = atomicReferenceFieldUpdater;
            this.f35094b = atomicReferenceFieldUpdater2;
            this.f35095c = atomicReferenceFieldUpdater3;
            this.f35096d = atomicReferenceFieldUpdater4;
            this.f35097e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return com.google.common.util.concurrent.b.a(this.f35096d, abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return com.google.common.util.concurrent.b.a(this.f35097e, abstractFuture, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return com.google.common.util.concurrent.b.a(this.f35095c, abstractFuture, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void d(j jVar, j jVar2) {
            this.f35094b.lazySet(jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void e(j jVar, Thread thread) {
            this.f35093a.lazySet(jVar, thread);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class f extends b {
        f() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f35079e == dVar) {
                    ((AbstractFuture) abstractFuture).f35079e = dVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f35078d == obj) {
                    ((AbstractFuture) abstractFuture).f35078d = obj2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f35080f == jVar) {
                    ((AbstractFuture) abstractFuture).f35080f = jVar2;
                    return true;
                }
                return false;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void d(j jVar, j jVar2) {
            jVar.f35106b = jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void e(j jVar, Thread thread) {
            jVar.f35105a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface g<V> extends q<V> {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class h<V> extends AbstractFuture<V> implements g<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.q
        public final void c(Runnable runnable, Executor executor) {
            super.c(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z16) {
            return super.cancel(z16);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j3, timeUnit);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class i extends b {

        /* renamed from: a, reason: collision with root package name */
        static final Unsafe f35098a;

        /* renamed from: b, reason: collision with root package name */
        static final long f35099b;

        /* renamed from: c, reason: collision with root package name */
        static final long f35100c;

        /* renamed from: d, reason: collision with root package name */
        static final long f35101d;

        /* renamed from: e, reason: collision with root package name */
        static final long f35102e;

        /* renamed from: f, reason: collision with root package name */
        static final long f35103f;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static class a implements PrivilegedExceptionAction<Unsafe> {
            a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e16) {
                    throw new RuntimeException("Could not initialize intrinsics", e16.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f35100c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("f"));
                f35099b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("e"));
                f35101d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("d"));
                f35102e = unsafe.objectFieldOffset(j.class.getDeclaredField("a"));
                f35103f = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
                f35098a = unsafe;
            } catch (Exception e17) {
                com.google.common.base.p.j(e17);
                throw new RuntimeException(e17);
            }
        }

        i() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return com.google.common.util.concurrent.c.a(f35098a, abstractFuture, f35099b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return com.google.common.util.concurrent.c.a(f35098a, abstractFuture, f35101d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        boolean c(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return com.google.common.util.concurrent.c.a(f35098a, abstractFuture, f35100c, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void d(j jVar, j jVar2) {
            f35098a.putObject(jVar, f35103f, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.b
        void e(j jVar, Thread thread) {
            f35098a.putObject(jVar, f35102e, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class j {

        /* renamed from: c, reason: collision with root package name */
        static final j f35104c = new j(false);

        /* renamed from: a, reason: collision with root package name */
        @NullableDecl
        volatile Thread f35105a;

        /* renamed from: b, reason: collision with root package name */
        @NullableDecl
        volatile j f35106b;

        j(boolean z16) {
        }

        void a(j jVar) {
            AbstractFuture.f35077m.d(this, jVar);
        }

        void b() {
            Thread thread = this.f35105a;
            if (thread != null) {
                this.f35105a = null;
                LockSupport.unpark(thread);
            }
        }

        j() {
            AbstractFuture.f35077m.e(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.google.common.util.concurrent.AbstractFuture$e] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.common.util.concurrent.AbstractFuture$a] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.common.util.concurrent.AbstractFuture$i] */
    static {
        f fVar;
        ?? r26 = 0;
        r26 = 0;
        try {
            fVar = new i();
            th = null;
        } catch (Throwable th5) {
            th = th5;
            try {
                fVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, j.class, "f"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "e"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "d"));
            } catch (Throwable th6) {
                fVar = new f();
                r26 = th6;
            }
        }
        f35077m = fVar;
        if (r26 != 0) {
            ?? r06 = f35076i;
            Level level = Level.SEVERE;
            r06.log(level, "UnsafeAtomicHelper is broken!", th);
            r06.log(level, "SafeAtomicHelper is broken!", r26);
        }
        C = new Object();
    }

    private void B() {
        j jVar;
        do {
            jVar = this.f35080f;
        } while (!f35077m.c(this, jVar, j.f35104c));
        while (jVar != null) {
            jVar.b();
            jVar = jVar.f35106b;
        }
    }

    private void C(j jVar) {
        jVar.f35105a = null;
        while (true) {
            j jVar2 = this.f35080f;
            if (jVar2 == j.f35104c) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.f35106b;
                if (jVar2.f35105a != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.f35106b = jVar4;
                    if (jVar3.f35105a == null) {
                        break;
                    }
                } else if (!f35077m.c(this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    private String G(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    private void p(StringBuilder sb5) {
        try {
            Object x16 = x(this);
            sb5.append("SUCCESS, result=[");
            sb5.append(G(x16));
            sb5.append("]");
        } catch (CancellationException unused) {
            sb5.append("CANCELLED");
        } catch (RuntimeException e16) {
            sb5.append("UNKNOWN, cause=[");
            sb5.append(e16.getClass());
            sb5.append(" thrown from get()]");
        } catch (ExecutionException e17) {
            sb5.append("FAILURE, cause=[");
            sb5.append(e17.getCause());
            sb5.append("]");
        }
    }

    private static CancellationException r(@NullableDecl String str, @NullableDecl Throwable th5) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th5);
        return cancellationException;
    }

    private d s(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f35079e;
        } while (!f35077m.a(this, dVar2, d.f35089d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f35092c;
            dVar4.f35092c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.B();
            abstractFuture.q();
            d s16 = abstractFuture.s(dVar);
            while (s16 != null) {
                dVar = s16.f35092c;
                Runnable runnable = s16.f35090a;
                if (runnable instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture) runnable;
                    abstractFuture = setFuture.f35083d;
                    if (((AbstractFuture) abstractFuture).f35078d == setFuture) {
                        if (f35077m.b(abstractFuture, setFuture, w(setFuture.f35084e))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    u(runnable, s16.f35091b);
                }
                s16 = dVar;
            }
            return;
        }
    }

    private static void u(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e16) {
            f35076i.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V v(Object obj) throws ExecutionException {
        if (!(obj instanceof c)) {
            if (!(obj instanceof Failure)) {
                if (obj == C) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((Failure) obj).f35082a);
        }
        throw r("Task was cancelled.", ((c) obj).f35088b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object w(q<?> qVar) {
        Throwable a16;
        if (qVar instanceof g) {
            Object obj = ((AbstractFuture) qVar).f35078d;
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.f35087a) {
                    if (cVar.f35088b != null) {
                        return new c(false, cVar.f35088b);
                    }
                    return c.f35086d;
                }
                return obj;
            }
            return obj;
        }
        if ((qVar instanceof t1.a) && (a16 = t1.b.a((t1.a) qVar)) != null) {
            return new Failure(a16);
        }
        boolean isCancelled = qVar.isCancelled();
        if ((!f35075h) & isCancelled) {
            return c.f35086d;
        }
        try {
            Object x16 = x(qVar);
            if (isCancelled) {
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + qVar));
            }
            if (x16 == null) {
                return C;
            }
            return x16;
        } catch (CancellationException e16) {
            if (!isCancelled) {
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + qVar, e16));
            }
            return new c(false, e16);
        } catch (ExecutionException e17) {
            if (isCancelled) {
                return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + qVar, e17));
            }
            return new Failure(e17.getCause());
        } catch (Throwable th5) {
            return new Failure(th5);
        }
    }

    private static <V> V x(Future<V> future) throws ExecutionException {
        V v3;
        boolean z16 = false;
        while (true) {
            try {
                v3 = future.get();
                break;
            } catch (InterruptedException unused) {
                z16 = true;
            } catch (Throwable th5) {
                if (z16) {
                    Thread.currentThread().interrupt();
                }
                throw th5;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @NullableDecl
    public String A() {
        Object obj = this.f35078d;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + G(((SetFuture) obj).f35084e) + "]";
        }
        if (this instanceof ScheduledFuture) {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean D(@NullableDecl V v3) {
        if (v3 == null) {
            v3 = (V) C;
        }
        if (f35077m.b(this, null, v3)) {
            t(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public boolean E(Throwable th5) {
        if (f35077m.b(this, null, new Failure((Throwable) com.google.common.base.j.m(th5)))) {
            t(this);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    @Beta
    public boolean F(q<? extends V> qVar) {
        Failure failure;
        com.google.common.base.j.m(qVar);
        Object obj = this.f35078d;
        if (obj == null) {
            if (qVar.isDone()) {
                if (!f35077m.b(this, null, w(qVar))) {
                    return false;
                }
                t(this);
                return true;
            }
            SetFuture setFuture = new SetFuture(this, qVar);
            if (f35077m.b(this, null, setFuture)) {
                try {
                    qVar.c(setFuture, DirectExecutor.INSTANCE);
                } catch (Throwable th5) {
                    try {
                        failure = new Failure(th5);
                    } catch (Throwable unused) {
                        failure = Failure.f35081b;
                    }
                    f35077m.b(this, setFuture, failure);
                }
                return true;
            }
            obj = this.f35078d;
        }
        if (obj instanceof c) {
            qVar.cancel(((c) obj).f35087a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean H() {
        Object obj = this.f35078d;
        if ((obj instanceof c) && ((c) obj).f35087a) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.util.concurrent.q
    public void c(Runnable runnable, Executor executor) {
        d dVar;
        com.google.common.base.j.n(runnable, "Runnable was null.");
        com.google.common.base.j.n(executor, "Executor was null.");
        if (!isDone() && (dVar = this.f35079e) != d.f35089d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f35092c = dVar;
                if (f35077m.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f35079e;
                }
            } while (dVar != d.f35089d);
        }
        u(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z16) {
        boolean z17;
        c cVar;
        boolean z18;
        Object obj = this.f35078d;
        if (obj == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!(z17 | (obj instanceof SetFuture))) {
            return false;
        }
        if (f35075h) {
            cVar = new c(z16, new CancellationException("Future.cancel() was called."));
        } else if (z16) {
            cVar = c.f35085c;
        } else {
            cVar = c.f35086d;
        }
        AbstractFuture<V> abstractFuture = this;
        boolean z19 = false;
        while (true) {
            if (f35077m.b(abstractFuture, obj, cVar)) {
                if (z16) {
                    abstractFuture.y();
                }
                t(abstractFuture);
                if (!(obj instanceof SetFuture)) {
                    return true;
                }
                q<? extends V> qVar = ((SetFuture) obj).f35084e;
                if (qVar instanceof g) {
                    abstractFuture = (AbstractFuture) qVar;
                    obj = abstractFuture.f35078d;
                    if (obj == null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!(z18 | (obj instanceof SetFuture))) {
                        return true;
                    }
                    z19 = true;
                } else {
                    qVar.cancel(z16);
                    return true;
                }
            } else {
                obj = abstractFuture.f35078d;
                if (!(obj instanceof SetFuture)) {
                    return z19;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // t1.a
    @NullableDecl
    public final Throwable e() {
        if (this instanceof g) {
            Object obj = this.f35078d;
            if (obj instanceof Failure) {
                return ((Failure) obj).f35082a;
            }
            return null;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.f35078d;
            if ((obj != null) & (!(obj instanceof SetFuture))) {
                return v(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                j jVar = this.f35080f;
                if (jVar != j.f35104c) {
                    j jVar2 = new j();
                    do {
                        jVar2.a(jVar);
                        if (f35077m.c(this, jVar, jVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f35078d;
                                    if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                                        return v(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    C(jVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            C(jVar2);
                        } else {
                            jVar = this.f35080f;
                        }
                    } while (jVar != j.f35104c);
                }
                return v(this.f35078d);
            }
            while (nanos > 0) {
                Object obj3 = this.f35078d;
                if ((obj3 != null) & (!(obj3 instanceof SetFuture))) {
                    return v(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
            String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j16 = -nanos;
                long convert = timeUnit.convert(j16, TimeUnit.NANOSECONDS);
                long nanos2 = j16 - timeUnit.toNanos(convert);
                boolean z16 = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z16) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z16) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f35078d instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z16;
        if (this.f35078d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return (!(r0 instanceof SetFuture)) & z16;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(super.toString());
        sb5.append("[status=");
        if (isCancelled()) {
            sb5.append("CANCELLED");
        } else if (isDone()) {
            p(sb5);
        } else {
            try {
                str = A();
            } catch (RuntimeException e16) {
                str = "Exception thrown from implementation: " + e16.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb5.append("PENDING, info=[");
                sb5.append(str);
                sb5.append("]");
            } else if (isDone()) {
                p(sb5);
            } else {
                sb5.append("PENDING");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(@NullableDecl Future<?> future) {
        boolean z16;
        if (future != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 & isCancelled()) {
            future.cancel(H());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Beta
    @ForOverride
    public void q() {
    }

    protected void y() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f35078d;
            if ((obj2 != null) & (!(obj2 instanceof SetFuture))) {
                return v(obj2);
            }
            j jVar = this.f35080f;
            if (jVar != j.f35104c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (f35077m.c(this, jVar, jVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f35078d;
                            } else {
                                C(jVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return v(obj);
                    }
                    jVar = this.f35080f;
                } while (jVar != j.f35104c);
            }
            return v(this.f35078d);
        }
        throw new InterruptedException();
    }
}
