package com.tencent.luggage.wxa.zp;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends AbstractExecutorService {

    /* renamed from: o, reason: collision with root package name */
    public static ConcurrentLinkedQueue f146788o = new ConcurrentLinkedQueue();

    /* renamed from: p, reason: collision with root package name */
    public static final Class f146789p;

    /* renamed from: q, reason: collision with root package name */
    public static final Field f146790q;

    /* renamed from: r, reason: collision with root package name */
    public static final e f146791r;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f146792a;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue f146793b;

    /* renamed from: c, reason: collision with root package name */
    public final ReentrantLock f146794c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f146795d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList f146796e;

    /* renamed from: f, reason: collision with root package name */
    public final Condition f146797f;

    /* renamed from: g, reason: collision with root package name */
    public int f146798g;

    /* renamed from: h, reason: collision with root package name */
    public long f146799h;

    /* renamed from: i, reason: collision with root package name */
    public volatile ThreadFactory f146800i;

    /* renamed from: j, reason: collision with root package name */
    public volatile e f146801j;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f146802k;

    /* renamed from: l, reason: collision with root package name */
    public volatile int f146803l;

    /* renamed from: m, reason: collision with root package name */
    public volatile int f146804m;

    /* renamed from: n, reason: collision with root package name */
    public volatile String f146805n;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements e {
        @Override // com.tencent.luggage.wxa.zp.e
        public void a(Runnable runnable, b bVar) {
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + bVar.toString());
        }
    }

    static {
        Class j3 = j();
        f146789p = j3;
        f146790q = a(j3);
        f146791r = new a();
    }

    public b(String str, int i3, int i16, BlockingQueue blockingQueue, e eVar) {
        this(str, i3, i16, Long.MAX_VALUE, TimeUnit.DAYS, blockingQueue, eVar == null ? new a() : eVar);
    }

    public static int a(int i3, int i16) {
        return i3 | i16;
    }

    public static boolean b(int i3, int i16) {
        return i3 >= i16;
    }

    public static boolean d(int i3) {
        return i3 < 0;
    }

    public static int e(int i3) {
        return i3 & (-536870912);
    }

    public static int f(int i3) {
        return i3 & NotificationUtil.Constants.NOTIFY_ID_HASH_VALUE_END;
    }

    public static Class j() {
        try {
            try {
                int i3 = DispatchedContinuation.f412777d;
                return DispatchedContinuation.class;
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (ClassNotFoundException unused2) {
            return Class.forName("kotlinx.coroutines.DispatchedContinuation");
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        while (!b(this.f146792a.get(), 1610612736)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.f146797f.awaitNanos(nanos);
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public final void c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.getClass();
        int i3 = this.f146792a.get();
        if (f(i3) < this.f146803l) {
            if (a(runnable, true)) {
                return;
            } else {
                i3 = this.f146792a.get();
            }
        }
        if (d(i3) && this.f146793b.offer(runnable)) {
            int i16 = this.f146792a.get();
            if (!d(i16) && c(runnable)) {
                b(runnable);
                return;
            } else if (f(i16) == 0) {
                a((Runnable) null, false);
                return;
            } else {
                a((Runnable) null);
                return;
            }
        }
        if (!a(runnable, false)) {
            b(runnable);
        }
    }

    public void finalize() {
        shutdown();
    }

    public final void g() {
        a(false);
    }

    public final void h() {
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            Iterator it = this.f146795d.iterator();
            while (it.hasNext()) {
                ((C6995b) it.next()).c();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !d(this.f146792a.get());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return b(this.f146792a.get(), 1610612736);
    }

    public void k() {
        Iterator it = f146788o.iterator();
        while (it.hasNext()) {
            if (this == ((b) ((WeakReference) it.next()).get())) {
                it.remove();
            }
        }
    }

    public final void l() {
        while (true) {
            int i3 = this.f146792a.get();
            if (!d(i3) && !b(i3, 1073741824)) {
                if (e(i3) != 0 || this.f146793b.isEmpty()) {
                    if (f(i3) != 0) {
                        a(true);
                        return;
                    }
                    ReentrantLock reentrantLock = this.f146794c;
                    reentrantLock.lock();
                    try {
                        if (this.f146792a.compareAndSet(i3, a(1073741824, 0))) {
                            try {
                                k();
                                return;
                            } finally {
                                this.f146792a.set(a(1610612736, 0));
                                this.f146797f.signalAll();
                            }
                        }
                    } finally {
                        reentrantLock.unlock();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            c();
            a(0);
            g();
            i();
            reentrantLock.unlock();
            l();
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            c();
            a(536870912);
            h();
            List e16 = e();
            reentrantLock.unlock();
            l();
            return e16;
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public String toString() {
        String str;
        ReentrantLock reentrantLock = this.f146794c;
        StringBuilder sb5 = new StringBuilder();
        reentrantLock.lock();
        try {
            long j3 = this.f146799h;
            int size = this.f146795d.size();
            Iterator it = this.f146795d.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C6995b c6995b = (C6995b) it.next();
                j3 += c6995b.f146808c.get();
                if (c6995b.a()) {
                    i3++;
                    sb5.append(c6995b.f146807b);
                }
            }
            reentrantLock.unlock();
            int i16 = this.f146792a.get();
            if (c(i16, 0)) {
                str = "Running";
            } else if (b(i16, 1610612736)) {
                str = "Terminated";
            } else {
                str = "Shutting down";
            }
            return super.toString() + "[" + str + ", pool size = " + size + ", active threads = " + i3 + ", queued tasks = " + this.f146793b.size() + ", completed tasks = " + j3 + ", running tasks = " + ((Object) sb5) + "]";
        } catch (Throwable th5) {
            reentrantLock.unlock();
            throw th5;
        }
    }

    public b(String str, int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, e eVar) {
        this(str, i3, i16, j3, timeUnit, blockingQueue, Executors.defaultThreadFactory(), eVar);
    }

    public static boolean c(int i3, int i16) {
        return i3 < i16;
    }

    public void a(Runnable runnable, Throwable th5) {
    }

    public final void d() {
        do {
        } while (!b(this.f146792a.get()));
    }

    public final List e() {
        BlockingQueue blockingQueue = this.f146793b;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    arrayList.add(runnable);
                }
            }
        }
        return arrayList;
    }

    public final Runnable f() {
        int e16 = e(this.f146792a.get());
        if (e16 >= 0 && (e16 >= 536870912 || this.f146793b.isEmpty())) {
            d();
            return null;
        }
        return (Runnable) this.f146793b.poll();
    }

    public void a(Thread thread, Runnable runnable) {
    }

    public final boolean b(int i3) {
        return this.f146792a.compareAndSet(i3, i3 - 1);
    }

    public final boolean c(int i3) {
        return this.f146792a.compareAndSet(i3, i3 + 1);
    }

    public b(String str, int i3, int i16, long j3, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, e eVar) {
        this.f146792a = new AtomicInteger(a(-536870912, 0));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f146794c = reentrantLock;
        this.f146795d = new HashSet();
        this.f146796e = new LinkedList();
        this.f146797f = reentrantLock.newCondition();
        if (i3 < 0 || i16 <= 0 || i16 < i3 || j3 < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue != null && threadFactory != null && eVar != null) {
            this.f146803l = i3;
            this.f146804m = i16;
            this.f146793b = blockingQueue;
            this.f146802k = timeUnit.toNanos(j3);
            this.f146800i = threadFactory;
            this.f146801j = eVar;
            this.f146805n = str;
            return;
        }
        throw null;
    }

    public final void b(Runnable runnable) {
        this.f146801j.a(runnable, this);
    }

    public boolean c(Runnable runnable) {
        boolean remove = this.f146793b.remove(runnable);
        l();
        return remove;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0014, code lost:
    
        if (r1 != null) goto L6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Thread] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(C6995b c6995b) {
        boolean z16;
        ?? currentThread = Thread.currentThread();
        Runnable runnable = c6995b.f146806a;
        c6995b.f146806a = null;
        c6995b.e();
        boolean z17 = false;
        boolean z18 = true;
        if (runnable == null) {
            try {
                runnable = f();
            } catch (Throwable th5) {
                th = th5;
                z17 = true;
                if (z17) {
                }
                throw th;
            }
        }
        c6995b.b();
        if (b(this.f146792a.get(), 536870912) && !currentThread.isInterrupted()) {
            c6995b.c();
            a(c6995b, true);
            return;
        }
        try {
            try {
                try {
                    a((Thread) currentThread, runnable);
                    try {
                        try {
                            runnable.run();
                            a(runnable, (Throwable) null);
                            c6995b.f146808c.getAndIncrement();
                            Runnable f16 = f();
                            if (f16 != null) {
                                c6995b.a(f16);
                                c6995b.f146810e = h.f146825d.execute(c6995b);
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                        } catch (Error e16) {
                            throw e16;
                        } catch (Throwable th6) {
                            throw new Error(th6);
                        }
                    } catch (RuntimeException e17) {
                        throw e17;
                    }
                } catch (Throwable th7) {
                    a(runnable, (Throwable) currentThread);
                    throw th7;
                }
            } catch (Throwable th8) {
                c6995b.f146808c.getAndIncrement();
                Runnable f17 = f();
                if (f17 != null) {
                    c6995b.a(f17);
                    c6995b.f146810e = h.f146825d.execute(c6995b);
                }
                c6995b.e();
                throw th8;
            }
        } catch (Throwable th9) {
            th = th9;
        }
        try {
            c6995b.e();
            z18 = z16;
            if (z18) {
                a(c6995b, false);
            }
        } catch (Throwable th10) {
            z17 = z16;
            th = th10;
            if (z17) {
                a(c6995b, true);
            }
            throw th;
        }
    }

    public static Field a(Class cls) {
        if (cls == null) {
            return null;
        }
        try {
            Field field = cls.getField("continuation");
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public final void a(int i3) {
        int i16;
        do {
            i16 = this.f146792a.get();
            if (b(i16, i3)) {
                return;
            }
        } while (!this.f146792a.compareAndSet(i16, a(i3, f(i16))));
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zp.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public final class C6995b extends AbstractQueuedSynchronizer implements com.tencent.luggage.wxa.jq.g {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f146806a;

        /* renamed from: b, reason: collision with root package name */
        public String f146807b;

        /* renamed from: c, reason: collision with root package name */
        public AtomicLong f146808c = new AtomicLong(0);

        /* renamed from: d, reason: collision with root package name */
        public AtomicBoolean f146809d = new AtomicBoolean(false);

        /* renamed from: e, reason: collision with root package name */
        public Future f146810e;

        public C6995b(Runnable runnable) {
            setState(-1);
            a(runnable);
        }

        public void a(Runnable runnable) {
            String name;
            this.f146806a = runnable;
            if (runnable == null) {
                this.f146807b = b.this.f146805n + "#Worker";
                return;
            }
            if (runnable instanceof com.tencent.luggage.wxa.jq.g) {
                this.f146807b = ((com.tencent.luggage.wxa.jq.g) runnable).getKey();
                return;
            }
            if (runnable.getClass() == b.f146789p && b.f146790q != null) {
                try {
                    name = b.f146790q.get(runnable).getClass().getName();
                } catch (IllegalAccessException unused) {
                    name = runnable.getClass().getName();
                }
                this.f146807b = b.this.f146805n + "#" + name;
                return;
            }
            this.f146807b = b.this.f146805n + "#" + runnable.getClass().getName();
        }

        public void b() {
            acquire(1);
        }

        public void c() {
            d.f146814c.i("ForkThreadPoolExecutor", "[releaseWork] name=" + b.this.f146805n, new Object[0]);
            Future future = this.f146810e;
            if (future != null && !future.isDone()) {
                this.f146810e.cancel(true);
            }
        }

        public void d() {
            this.f146810e = h.f146825d.execute(this);
        }

        public void e() {
            release(1);
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return this.f146807b;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean isHeldExclusively() {
            if (getState() != 0) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this);
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryAcquire(int i3) {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryRelease(int i3) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public boolean a() {
            return isHeldExclusively();
        }
    }

    public final void a(boolean z16) {
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            Iterator it = this.f146795d.iterator();
            while (it.hasNext()) {
                ((C6995b) it.next()).c();
                if (z16) {
                    break;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0096, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:28:0x0041, B:36:0x006c, B:38:0x0071, B:49:0x007c, B:50:0x007f, B:30:0x0046, B:43:0x005a, B:45:0x0069), top: B:27:0x0041, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Runnable runnable, boolean z16) {
        C6995b c6995b;
        boolean z17;
        loop0: while (true) {
            int i3 = this.f146792a.get();
            int e16 = e(i3);
            boolean z18 = false;
            if (h.f146825d.isShutdown()) {
                return false;
            }
            if (e16 < 0 || (e16 == 0 && runnable == null && !this.f146793b.isEmpty())) {
                do {
                    int f16 = f(i3);
                    if (f16 >= 536870911) {
                        break loop0;
                    }
                    if (f16 >= (z16 ? this.f146803l : this.f146804m)) {
                        break loop0;
                    }
                    if (c(i3)) {
                        try {
                            c6995b = new C6995b(runnable);
                        } catch (Throwable th5) {
                            th = th5;
                            c6995b = null;
                        }
                        try {
                            ReentrantLock reentrantLock = this.f146794c;
                            reentrantLock.lock();
                            try {
                                int e17 = e(this.f146792a.get());
                                if (e17 >= 0 && (e17 != 0 || runnable != null)) {
                                    z17 = false;
                                    if (z17) {
                                        c6995b.d();
                                        z18 = true;
                                    }
                                    if (!z18) {
                                        a(c6995b);
                                    }
                                    return z18;
                                }
                                this.f146795d.add(c6995b);
                                int size = this.f146795d.size();
                                if (size > this.f146798g) {
                                    this.f146798g = size;
                                }
                                z17 = true;
                                if (z17) {
                                }
                                if (!z18) {
                                }
                                return z18;
                            } finally {
                                reentrantLock.unlock();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            a(c6995b);
                            throw th;
                        }
                    }
                    i3 = this.f146792a.get();
                } while (e(i3) == e16);
            }
        }
    }

    public void i() {
    }

    public final void a(C6995b c6995b) {
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        if (c6995b != null) {
            try {
                this.f146795d.remove(c6995b);
            } finally {
                reentrantLock.unlock();
            }
        }
        d();
        l();
    }

    public final void a(C6995b c6995b, boolean z16) {
        c6995b.e();
        if (z16) {
            d();
        }
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            if (z16) {
                this.f146799h += c6995b.f146808c.get();
                this.f146795d.remove(c6995b);
                c6995b.f146806a = null;
                c6995b.f146810e = null;
            } else if (c6995b.f146809d.compareAndSet(false, true)) {
                this.f146796e.add(c6995b);
                Runnable f16 = f();
                if (f16 != null) {
                    a(f16);
                }
            }
        } finally {
            reentrantLock.unlock();
            l();
        }
    }

    public final boolean a(Runnable runnable) {
        if (e(this.f146792a.get()) >= 0) {
            return false;
        }
        ReentrantLock reentrantLock = this.f146794c;
        reentrantLock.lock();
        try {
            C6995b c6995b = this.f146796e.isEmpty() ? null : (C6995b) this.f146796e.remove();
            if (c6995b == null) {
                return false;
            }
            c6995b.f146809d.compareAndSet(true, false);
            c6995b.a(runnable);
            c6995b.d();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
