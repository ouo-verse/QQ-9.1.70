package kotlinx.coroutines;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\r\u0010\u001e\u001a\u00020\u001cH\u0000\u00a2\u0006\u0002\b\u001fJ$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\n\u0010#\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u001cH\u0016J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0004R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00148@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00108TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006*"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutdownRequested", "", "()Z", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", MosaicConstants$JsProperty.PROP_THREAD, "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", TencentLocation.RUN_MODE, "shutdown", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE = 1000;
    private static final int FRESH = 0;

    @NotNull
    public static final DefaultExecutor INSTANCE;
    private static final long KEEP_ALIVE_NANOS;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;

    @NotNull
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";

    @Nullable
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    static {
        Long l3;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        INSTANCE = defaultExecutor;
        EventLoop.incrementUseCount$default(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l3.longValue());
    }

    DefaultExecutor() {
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        if (!isShutdownRequested()) {
            return;
        }
        debugStatus = 3;
        resetAll();
        notifyAll();
    }

    private final synchronized Thread createThreadSync() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new BaseThread(this, THREAD_NAME);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean isShutdownRequested() {
        int i3 = debugStatus;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    private final synchronized boolean notifyStartup() {
        if (isShutdownRequested()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        debugStatus = 0;
        createThreadSync();
        while (debugStatus == 0) {
            LockMethodProxy.wait(this);
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    @NotNull
    protected Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            return createThreadSync();
        }
        return thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull Runnable block, @NotNull CoroutineContext context) {
        return scheduleInvokeOnTimeout(timeMillis, block);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        if (_thread != null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        long nanoTime;
        boolean isEmpty;
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            if (!notifyStartup()) {
                if (!isEmpty) {
                    return;
                } else {
                    return;
                }
            }
            long j3 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long processNextEvent = processNextEvent();
                if (processNextEvent == Long.MAX_VALUE) {
                    AbstractTimeSource timeSource2 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 == null) {
                        nanoTime = System.nanoTime();
                    } else {
                        nanoTime = timeSource2.nanoTime();
                    }
                    if (j3 == Long.MAX_VALUE) {
                        j3 = KEEP_ALIVE_NANOS + nanoTime;
                    }
                    long j16 = j3 - nanoTime;
                    if (j16 > 0) {
                        processNextEvent = RangesKt___RangesKt.coerceAtMost(processNextEvent, j16);
                    } else {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSource timeSource3 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource3 != null) {
                            timeSource3.unregisterTimeLoopThread();
                        }
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                } else {
                    j3 = Long.MAX_VALUE;
                }
                if (processNextEvent > 0) {
                    if (isShutdownRequested()) {
                        _thread = null;
                        acknowledgeShutdownIfNeeded();
                        AbstractTimeSource timeSource4 = AbstractTimeSourceKt.getTimeSource();
                        if (timeSource4 != null) {
                            timeSource4.unregisterTimeLoopThread();
                        }
                        if (!isEmpty()) {
                            getThread();
                            return;
                        }
                        return;
                    }
                    AbstractTimeSource timeSource5 = AbstractTimeSourceKt.getTimeSource();
                    if (timeSource5 == null) {
                        LockSupport.parkNanos(this, processNextEvent);
                    } else {
                        timeSource5.parkNanos(this, processNextEvent);
                    }
                }
            }
        } finally {
            _thread = null;
            acknowledgeShutdownIfNeeded();
            AbstractTimeSource timeSource6 = AbstractTimeSourceKt.getTimeSource();
            if (timeSource6 != null) {
                timeSource6.unregisterTimeLoopThread();
            }
            if (!isEmpty()) {
                getThread();
            }
        }
    }

    public final synchronized void shutdown(long timeout) {
        long currentTimeMillis = System.currentTimeMillis() + timeout;
        if (!isShutdownRequested()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource == null) {
                    LockSupport.unpark(thread);
                } else {
                    timeSource.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            } else {
                wait(timeout);
            }
        }
        debugStatus = 0;
    }

    private static /* synthetic */ void get_thread$annotations() {
    }
}
