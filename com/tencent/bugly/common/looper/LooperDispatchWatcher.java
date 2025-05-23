package com.tencent.bugly.common.looper;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.bugly.common.looper.LooperDispatchWatcher;
import com.tencent.bugly.common.looper.LooperPrinter;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ReflectUtil;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0002J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0012H\u0002J\u0010\u0010'\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/bugly/common/looper/LooperDispatchWatcher;", "Landroid/os/MessageQueue$IdleHandler;", "Lcom/tencent/bugly/common/looper/LooperPrinter$IDispatch;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "isStart", "", "lastCheckPrinterTime", "", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/bugly/common/looper/ILooperDispatchListener;", "Lkotlin/collections/HashSet;", "printer", "Lcom/tencent/bugly/common/looper/LooperPrinter;", "startTime", "addIdleHandler", "", "addListener", "listener", "checkAndStart", "checkAndStop", "checkValid", "Landroid/util/Printer;", "clearListeners", "dealOriginPrinter", "originPrinter", "dispatch", "isBegin", "log", "", "dispatchEnd", "msg", "endTime", "duration", "dispatchStart", "queueIdle", "release", "removeIdleHandler", "removeListener", "resetPrinter", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class LooperDispatchWatcher implements MessageQueue.IdleHandler, LooperPrinter.IDispatch {
    private static final long CHECK_TIME_IN_MS = 60000;
    private static final int MAX_CHECK_COUNT = 100;
    private static final String TAG = "RMonitor_looper_DispatchWatcher";
    private boolean isStart;
    private long lastCheckPrinterTime;
    private final HashSet<ILooperDispatchListener> listeners;
    private final Looper looper;
    private LooperPrinter printer;
    private long startTime;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadLocal<LooperDispatchWatcher> watcher = new ThreadLocal<>();
    private static final ConcurrentHashMap<Looper, Handler> handlerMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u001a\u0010\u001b\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/bugly/common/looper/LooperDispatchWatcher$Companion;", "", "()V", "CHECK_TIME_IN_MS", "", "MAX_CHECK_COUNT", "", "TAG", "", "handlerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/os/Looper;", "Landroid/os/Handler;", "watcher", "Ljava/lang/ThreadLocal;", "Lcom/tencent/bugly/common/looper/LooperDispatchWatcher;", "fetchHandler", "looper", "createWhenNotExist", "", "fetchWatcher", "forceStop", "", "register", "listener", "Lcom/tencent/bugly/common/looper/ILooperDispatchListener;", "release", "unregister", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        Companion() {
        }

        private final Handler fetchHandler(Looper looper, boolean createWhenNotExist) {
            Handler handler = (Handler) LooperDispatchWatcher.handlerMap.get(looper);
            if (handler == null && createWhenNotExist) {
                Handler handler2 = new Handler(looper);
                LooperDispatchWatcher.handlerMap.put(looper, handler2);
                Logger.f365497g.i(LooperDispatchWatcher.TAG, "create handler of looper[" + looper + ']');
                return handler2;
            }
            return handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LooperDispatchWatcher fetchWatcher(Looper looper, boolean createWhenNotExist) {
            LooperDispatchWatcher looperDispatchWatcher = (LooperDispatchWatcher) LooperDispatchWatcher.watcher.get();
            if (looperDispatchWatcher == null && createWhenNotExist) {
                LooperDispatchWatcher looperDispatchWatcher2 = new LooperDispatchWatcher(looper);
                LooperDispatchWatcher.watcher.set(looperDispatchWatcher2);
                Logger.f365497g.i(LooperDispatchWatcher.TAG, "create watcher of looper[" + looper + ']');
                return looperDispatchWatcher2;
            }
            return looperDispatchWatcher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void release(Looper looper) {
            LooperDispatchWatcher.watcher.remove();
            LooperDispatchWatcher.handlerMap.remove(looper);
            Logger.f365497g.i(LooperDispatchWatcher.TAG, "release watcher and handler of looper[" + looper + ']');
        }

        public final void forceStop(@Nullable final Looper looper) {
            Handler fetchHandler;
            if (looper != null && (fetchHandler = fetchHandler(looper, false)) != null) {
                fetchHandler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.LooperDispatchWatcher$Companion$forceStop$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LooperDispatchWatcher fetchWatcher;
                        LooperDispatchWatcher.Companion companion = LooperDispatchWatcher.INSTANCE;
                        fetchWatcher = companion.fetchWatcher(looper, false);
                        if (fetchWatcher != null) {
                            fetchWatcher.clearListeners();
                            fetchWatcher.checkAndStop();
                            if (!fetchWatcher.getIsStart()) {
                                companion.release(looper);
                            }
                        }
                    }
                });
            }
        }

        public final void register(@Nullable final Looper looper, @Nullable final ILooperDispatchListener listener) {
            Handler fetchHandler;
            if (listener != null && looper != null && (fetchHandler = fetchHandler(looper, true)) != null) {
                fetchHandler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.LooperDispatchWatcher$Companion$register$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LooperDispatchWatcher fetchWatcher;
                        fetchWatcher = LooperDispatchWatcher.INSTANCE.fetchWatcher(looper, true);
                        if (fetchWatcher != null) {
                            fetchWatcher.addListener(listener);
                            fetchWatcher.checkAndStart();
                        }
                    }
                });
            }
        }

        public final void unregister(@Nullable final Looper looper, @Nullable final ILooperDispatchListener listener) {
            Handler fetchHandler;
            if (listener != null && looper != null && (fetchHandler = fetchHandler(looper, false)) != null) {
                fetchHandler.post(new Runnable() { // from class: com.tencent.bugly.common.looper.LooperDispatchWatcher$Companion$unregister$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LooperDispatchWatcher fetchWatcher;
                        LooperDispatchWatcher.Companion companion = LooperDispatchWatcher.INSTANCE;
                        fetchWatcher = companion.fetchWatcher(looper, false);
                        if (fetchWatcher != null) {
                            fetchWatcher.removeListener(listener);
                            fetchWatcher.checkAndStop();
                            if (!fetchWatcher.getIsStart()) {
                                companion.release(looper);
                            }
                        }
                    }
                });
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LooperDispatchWatcher(@NotNull Looper looper) {
        Intrinsics.checkParameterIsNotNull(looper, "looper");
        this.looper = looper;
        this.listeners = new HashSet<>();
    }

    private final synchronized void addIdleHandler(Looper looper) {
        if (AndroidVersion.INSTANCE.isOverM()) {
            looper.getQueue().addIdleHandler(this);
        } else {
            try {
                ReflectUtil.messageQueue(looper).addIdleHandler(this);
            } catch (Throwable th5) {
                Logger logger = Logger.f365497g;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("addIdleHandler in ");
                Thread thread = looper.getThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
                sb5.append(thread.getName());
                sb5.append(", ");
                logger.b(TAG, sb5.toString(), th5);
            }
        }
    }

    private final void dispatchEnd(String msg2, long endTime, long duration) {
        for (ILooperDispatchListener iLooperDispatchListener : this.listeners) {
            if (iLooperDispatchListener.isOpen()) {
                iLooperDispatchListener.onDispatchEnd(msg2, endTime, duration);
            }
        }
    }

    private final void dispatchStart(String msg2, long startTime) {
        for (ILooperDispatchListener iLooperDispatchListener : this.listeners) {
            if (iLooperDispatchListener.isOpen()) {
                iLooperDispatchListener.onDispatchStart(msg2, startTime);
            }
        }
    }

    private final synchronized void release() {
        LooperPrinter looperPrinter = this.printer;
        if (looperPrinter != null) {
            if (Logger.verbos) {
                Logger logger = Logger.f365497g;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("release printer[");
                sb5.append(looperPrinter);
                sb5.append("] originPrinter[");
                sb5.append(looperPrinter.getOrigin());
                sb5.append("] in ");
                Thread thread = this.looper.getThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
                sb5.append(thread.getName());
                logger.v(TAG, sb5.toString());
            }
            this.looper.setMessageLogging(looperPrinter.getOrigin());
            removeIdleHandler(this.looper);
        }
        this.printer = null;
    }

    private final synchronized void removeIdleHandler(Looper looper) {
        if (AndroidVersion.INSTANCE.isOverM()) {
            looper.getQueue().removeIdleHandler(this);
        } else {
            try {
                ReflectUtil.messageQueue(looper).removeIdleHandler(this);
            } catch (Throwable th5) {
                Logger logger = Logger.f365497g;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("removeIdleHandler in ");
                Thread thread = looper.getThread();
                Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
                sb5.append(thread.getName());
                sb5.append(", ");
                logger.b(TAG, sb5.toString(), th5);
            }
        }
    }

    private final synchronized void resetPrinter(Looper looper) {
        Printer currentPrinter = ReflectUtil.getCurrentPrinter(looper);
        LooperPrinter looperPrinter = this.printer;
        if (currentPrinter == looperPrinter && looperPrinter != null) {
            return;
        }
        if (looperPrinter != null) {
            Logger logger = Logger.f365497g;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resetPrinter maybe printer[");
            sb5.append(this.printer);
            sb5.append("] was replace by other[");
            sb5.append(currentPrinter);
            sb5.append("] ");
            sb5.append("in ");
            Thread thread = looper.getThread();
            Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
            sb5.append(thread.getName());
            sb5.append(TokenParser.SP);
            logger.w(TAG, sb5.toString());
        }
        LooperPrinter looperPrinter2 = new LooperPrinter(dealOriginPrinter(currentPrinter), this);
        this.printer = looperPrinter2;
        looper.setMessageLogging(looperPrinter2);
        if (currentPrinter != null || Logger.debug) {
            Logger logger2 = Logger.f365497g;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("resetPrinter printer[");
            sb6.append(this.printer);
            sb6.append("] originPrinter[");
            sb6.append(currentPrinter);
            sb6.append("] in ");
            Thread thread2 = looper.getThread();
            Intrinsics.checkExpressionValueIsNotNull(thread2, "looper.thread");
            sb6.append(thread2.getName());
            logger2.w(TAG, sb6.toString());
        }
    }

    public final void addListener(@NotNull ILooperDispatchListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listeners.add(listener);
    }

    public final void checkAndStart() {
        if (!this.isStart && this.listeners.size() != 0) {
            Logger logger = Logger.f365497g;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkAndStart in ");
            Thread thread = this.looper.getThread();
            Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
            sb5.append(thread.getName());
            logger.d(TAG, sb5.toString());
            this.isStart = true;
            resetPrinter(this.looper);
            addIdleHandler(this.looper);
        }
    }

    public final void checkAndStop() {
        if (this.isStart && this.listeners.size() <= 0) {
            Logger logger = Logger.f365497g;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkAndStop in ");
            Thread thread = this.looper.getThread();
            Intrinsics.checkExpressionValueIsNotNull(thread, "looper.thread");
            sb5.append(thread.getName());
            logger.d(TAG, sb5.toString());
            release();
            this.isStart = false;
        }
    }

    @Override // com.tencent.bugly.common.looper.LooperPrinter.IDispatch
    public boolean checkValid(@NotNull Printer printer) {
        Intrinsics.checkParameterIsNotNull(printer, "printer");
        LooperPrinter looperPrinter = this.printer;
        if (printer == looperPrinter && looperPrinter != null) {
            return true;
        }
        return false;
    }

    public final void clearListeners() {
        this.listeners.clear();
    }

    @Nullable
    public final Printer dealOriginPrinter(@Nullable Printer originPrinter) {
        int i3 = 0;
        while (originPrinter instanceof LooperPrinter) {
            originPrinter = ((LooperPrinter) originPrinter).getOrigin();
            i3++;
            if (i3 >= 100) {
                return null;
            }
        }
        return originPrinter;
    }

    @Override // com.tencent.bugly.common.looper.LooperPrinter.IDispatch
    public void dispatch(boolean isBegin, @NotNull String log) {
        Intrinsics.checkParameterIsNotNull(log, "log");
        if (isBegin) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.startTime = uptimeMillis;
            dispatchStart(log, uptimeMillis);
        } else if (this.startTime != 0) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            long j3 = uptimeMillis2 - this.startTime;
            this.startTime = 0L;
            dispatchEnd(log, uptimeMillis2, j3);
        }
    }

    /* renamed from: isStart, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.lastCheckPrinterTime >= 60000) {
            resetPrinter(this.looper);
            this.lastCheckPrinterTime = SystemClock.uptimeMillis();
            return true;
        }
        return true;
    }

    public final void removeListener(@NotNull ILooperDispatchListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listeners.remove(listener);
    }
}
