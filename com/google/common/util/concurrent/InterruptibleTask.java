package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@ReflectionSupport(ReflectionSupport.Level.FULL)
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private static final Runnable f35133d;

    /* renamed from: e, reason: collision with root package name */
    private static final Runnable f35134e;

    /* renamed from: f, reason: collision with root package name */
    private static final Runnable f35135f;

    static {
        f35133d = new DoNothingRunnable();
        f35134e = new DoNothingRunnable();
        f35135f = new DoNothingRunnable();
    }

    abstract void afterRanInterruptibly(@NullableDecl T t16, @NullableDecl Throwable th5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, f35134e)) {
            try {
                ((Thread) runnable).interrupt();
            } finally {
                if (getAndSet(f35133d) == f35135f) {
                    LockSupport.unpark((Thread) runnable);
                }
            }
        }
    }

    abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        T runInterruptibly;
        Thread currentThread = Thread.currentThread();
        if (!compareAndSet(null, currentThread)) {
            return;
        }
        boolean z16 = !isDone();
        if (z16) {
            try {
                runInterruptibly = runInterruptibly();
            } catch (Throwable th5) {
                if (!compareAndSet(currentThread, f35133d)) {
                    Runnable runnable = get();
                    boolean z17 = false;
                    int i3 = 0;
                    while (true) {
                        Runnable runnable2 = f35134e;
                        if (runnable != runnable2 && runnable != f35135f) {
                            break;
                        }
                        i3++;
                        if (i3 > 1000) {
                            Runnable runnable3 = f35135f;
                            if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                if (!Thread.interrupted() && !z17) {
                                    z17 = false;
                                } else {
                                    z17 = true;
                                }
                                LockSupport.park(this);
                            }
                        } else {
                            Thread.yield();
                        }
                        runnable = get();
                    }
                    if (z17) {
                        currentThread.interrupt();
                    }
                }
                if (z16) {
                    afterRanInterruptibly(null, th5);
                    return;
                }
                return;
            }
        } else {
            runInterruptibly = null;
        }
        if (!compareAndSet(currentThread, f35133d)) {
            Runnable runnable4 = get();
            boolean z18 = false;
            int i16 = 0;
            while (true) {
                Runnable runnable5 = f35134e;
                if (runnable4 != runnable5 && runnable4 != f35135f) {
                    break;
                }
                i16++;
                if (i16 > 1000) {
                    Runnable runnable6 = f35135f;
                    if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                        if (!Thread.interrupted() && !z18) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        LockSupport.park(this);
                    }
                } else {
                    Thread.yield();
                }
                runnable4 = get();
            }
            if (z18) {
                currentThread.interrupt();
            }
        }
        if (z16) {
            afterRanInterruptibly(runInterruptibly, null);
        }
    }

    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == f35133d) {
            str = "running=[DONE]";
        } else if (runnable == f35134e) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + toPendingString();
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class DoNothingRunnable implements Runnable {
        DoNothingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
