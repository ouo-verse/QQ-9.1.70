package org.tencwebrtc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ThreadUtils {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.ThreadUtils$1CaughtException, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class C1CaughtException {

        /* renamed from: e, reason: collision with root package name */
        Exception f423850e;

        C1CaughtException() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: org.tencwebrtc.ThreadUtils$1Result, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class C1Result {
        public V value;

        C1Result() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ThreadChecker {

        @Nullable
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() == this.thread) {
            } else {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        executeUninterruptibly(new BlockingOperation() { // from class: org.tencwebrtc.ThreadUtils.2
            @Override // org.tencwebrtc.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                countDownLatch.await();
            }
        });
    }

    public static void checkIsOnMainThread() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        } else {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StackTraceElement[] concatStackTraces(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[stackTraceElementArr.length + stackTraceElementArr2.length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr3, 0, stackTraceElementArr.length);
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, stackTraceElementArr.length, stackTraceElementArr2.length);
        return stackTraceElementArr3;
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        boolean z16 = false;
        while (true) {
            try {
                blockingOperation.run();
                break;
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler handler, final Callable<V> callable) {
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            try {
                return callable.call();
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        final C1Result c1Result = new C1Result();
        final C1CaughtException c1CaughtException = new C1CaughtException();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        handler.post(new Runnable() { // from class: org.tencwebrtc.ThreadUtils.3
            /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1Result.this.value = callable.call();
                } catch (Exception e17) {
                    c1CaughtException.f423850e = e17;
                }
                countDownLatch.countDown();
            }
        });
        awaitUninterruptibly(countDownLatch);
        if (c1CaughtException.f423850e == null) {
            return c1Result.value;
        }
        RuntimeException runtimeException = new RuntimeException(c1CaughtException.f423850e);
        runtimeException.setStackTrace(concatStackTraces(c1CaughtException.f423850e.getStackTrace(), runtimeException.getStackTrace()));
        throw runtimeException;
    }

    public static boolean joinUninterruptibly(Thread thread, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        long j16 = j3;
        while (j16 > 0) {
            try {
                thread.join(j16);
                break;
            } catch (InterruptedException unused) {
                j16 = j3 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z16 = false;
        long j16 = j3;
        boolean z17 = false;
        while (true) {
            try {
                z16 = countDownLatch.await(j16, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                j16 = j3 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j16 <= 0) {
                    z17 = true;
                    break;
                }
                z17 = true;
            }
        }
        if (z17) {
            Thread.currentThread().interrupt();
        }
        return z16;
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterruptibly(new BlockingOperation() { // from class: org.tencwebrtc.ThreadUtils.1
            @Override // org.tencwebrtc.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                thread.join();
            }
        });
    }

    public static void invokeAtFrontUninterruptibly(Handler handler, final Runnable runnable) {
        invokeAtFrontUninterruptibly(handler, new Callable<Void>() { // from class: org.tencwebrtc.ThreadUtils.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }
}
