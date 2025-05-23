package com.tencent.bugly.common.thread;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/bugly/common/thread/ThreadManager;", "", "()V", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ThreadManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile Looper DUMP_LOOPER;
    private static volatile Looper LOG_ERROR_LOOPER;
    private static volatile Looper MONITOR_LOOPER;
    private static volatile Handler dumpThreadHandler;
    private static volatile Handler logAndErrorThreadHandler;
    private static volatile Handler mainThreadHandler;
    private static volatile Handler monitorThreadHandler;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/bugly/common/thread/ThreadManager$Companion;", "", "()V", "DUMP_LOOPER", "Landroid/os/Looper;", "LOG_ERROR_LOOPER", "MONITOR_LOOPER", "dumpThreadHandler", "Landroid/os/Handler;", "logAndErrorThreadHandler", "mainThreadHandler", "monitorThreadHandler", "cancelFromMainThread", "", "task", "Ljava/lang/Runnable;", "cancelFromMonitorThread", "getDumpThreadLooper", "getLogAndErrorThreadLooper", "getMonitorThreadLooper", "inMonitorThread", "", "postDelayed", "delay", "", "handler", "runInDumpThread", "runInLogThread", "runInMainThread", "runInMonitorThread", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final void postDelayed(Runnable task, long delay, Handler handler) {
            if (delay == 0) {
                if (handler != null) {
                    handler.post(task);
                }
            } else if (handler != null) {
                handler.postDelayed(task, delay);
            }
        }

        static /* synthetic */ void postDelayed$default(Companion companion, Runnable runnable, long j3, Handler handler, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.postDelayed(runnable, j3, handler);
        }

        public static /* synthetic */ void runInDumpThread$default(Companion companion, Runnable runnable, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.runInDumpThread(runnable, j3);
        }

        public static /* synthetic */ void runInLogThread$default(Companion companion, Runnable runnable, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.runInLogThread(runnable, j3);
        }

        public static /* synthetic */ void runInMainThread$default(Companion companion, Runnable runnable, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.runInMainThread(runnable, j3);
        }

        public static /* synthetic */ void runInMonitorThread$default(Companion companion, Runnable runnable, long j3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            companion.runInMonitorThread(runnable, j3);
        }

        @JvmStatic
        public final void cancelFromMainThread(@NotNull Runnable task) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            Handler handler = ThreadManager.mainThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(task);
            }
        }

        @JvmStatic
        public final void cancelFromMonitorThread(@NotNull Runnable task) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            Handler handler = ThreadManager.monitorThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(task);
            }
        }

        @JvmStatic
        @NotNull
        public final Looper getDumpThreadLooper() {
            if (ThreadManager.DUMP_LOOPER == null) {
                synchronized (ThreadManager.class) {
                    if (ThreadManager.DUMP_LOOPER == null) {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RMonitor_Dump");
                        baseHandlerThread.start();
                        ThreadManager.DUMP_LOOPER = baseHandlerThread.getLooper();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Looper looper = ThreadManager.DUMP_LOOPER;
            if (looper == null) {
                Intrinsics.throwNpe();
            }
            return looper;
        }

        @JvmStatic
        @NotNull
        public final Looper getLogAndErrorThreadLooper() {
            if (ThreadManager.LOG_ERROR_LOOPER == null) {
                synchronized (ThreadManager.class) {
                    if (ThreadManager.LOG_ERROR_LOOPER == null) {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RMonitor_Log");
                        baseHandlerThread.start();
                        ThreadManager.LOG_ERROR_LOOPER = baseHandlerThread.getLooper();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Looper looper = ThreadManager.LOG_ERROR_LOOPER;
            if (looper == null) {
                Intrinsics.throwNpe();
            }
            return looper;
        }

        @JvmStatic
        @NotNull
        public final Looper getMonitorThreadLooper() {
            if (ThreadManager.MONITOR_LOOPER == null) {
                synchronized (ThreadManager.class) {
                    if (ThreadManager.MONITOR_LOOPER == null) {
                        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RMonitor_Monitor");
                        baseHandlerThread.start();
                        ThreadManager.MONITOR_LOOPER = baseHandlerThread.getLooper();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Looper looper = ThreadManager.MONITOR_LOOPER;
            if (looper == null) {
                Intrinsics.throwNpe();
            }
            return looper;
        }

        @JvmStatic
        public final boolean inMonitorThread() {
            return Intrinsics.areEqual(Thread.currentThread(), getMonitorThreadLooper().getThread());
        }

        @JvmStatic
        public final void runInDumpThread(@NotNull Runnable task, long delay) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (ThreadManager.dumpThreadHandler == null) {
                ThreadManager.dumpThreadHandler = new Handler(getDumpThreadLooper());
            }
            postDelayed(task, delay, ThreadManager.dumpThreadHandler);
        }

        @JvmStatic
        public final void runInLogThread(@NotNull Runnable task, long delay) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (ThreadManager.logAndErrorThreadHandler == null) {
                ThreadManager.logAndErrorThreadHandler = new Handler(getLogAndErrorThreadLooper());
            }
            postDelayed(task, delay, ThreadManager.logAndErrorThreadHandler);
        }

        @JvmStatic
        public final void runInMainThread(@NotNull Runnable task, long delay) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (ThreadManager.mainThreadHandler == null) {
                ThreadManager.mainThreadHandler = new Handler(Looper.getMainLooper());
            }
            postDelayed(task, delay, ThreadManager.mainThreadHandler);
        }

        @JvmStatic
        public final void runInMonitorThread(@NotNull Runnable task, long delay) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (ThreadManager.monitorThreadHandler == null) {
                ThreadManager.monitorThreadHandler = new Handler(getMonitorThreadLooper());
            }
            postDelayed(task, delay, ThreadManager.monitorThreadHandler);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    public static final void cancelFromMainThread(@NotNull Runnable runnable) {
        INSTANCE.cancelFromMainThread(runnable);
    }

    @JvmStatic
    public static final void cancelFromMonitorThread(@NotNull Runnable runnable) {
        INSTANCE.cancelFromMonitorThread(runnable);
    }

    @JvmStatic
    @NotNull
    public static final Looper getDumpThreadLooper() {
        return INSTANCE.getDumpThreadLooper();
    }

    @JvmStatic
    @NotNull
    public static final Looper getLogAndErrorThreadLooper() {
        return INSTANCE.getLogAndErrorThreadLooper();
    }

    @JvmStatic
    @NotNull
    public static final Looper getMonitorThreadLooper() {
        return INSTANCE.getMonitorThreadLooper();
    }

    @JvmStatic
    public static final boolean inMonitorThread() {
        return INSTANCE.inMonitorThread();
    }

    @JvmStatic
    public static final void runInDumpThread(@NotNull Runnable runnable, long j3) {
        INSTANCE.runInDumpThread(runnable, j3);
    }

    @JvmStatic
    public static final void runInLogThread(@NotNull Runnable runnable, long j3) {
        INSTANCE.runInLogThread(runnable, j3);
    }

    @JvmStatic
    public static final void runInMainThread(@NotNull Runnable runnable, long j3) {
        INSTANCE.runInMainThread(runnable, j3);
    }

    @JvmStatic
    public static final void runInMonitorThread(@NotNull Runnable runnable, long j3) {
        INSTANCE.runInMonitorThread(runnable, j3);
    }
}
