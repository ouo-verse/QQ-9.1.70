package okio;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, BaseConstants.BROADCAST_USERSYNC_ENTER, "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    private static AsyncTimeout head;
    private boolean inQueue;

    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000\u00a2\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout node) {
            synchronized (AsyncTimeout.class) {
                if (node.inQueue) {
                    node.inQueue = false;
                    for (AsyncTimeout asyncTimeout = AsyncTimeout.head; asyncTimeout != null; asyncTimeout = asyncTimeout.next) {
                        if (asyncTimeout.next == node) {
                            asyncTimeout.next = node.next;
                            node.next = null;
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout node, long timeoutNanos, boolean hasDeadline) {
            synchronized (AsyncTimeout.class) {
                if (!node.inQueue) {
                    node.inQueue = true;
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    if (timeoutNanos != 0 && hasDeadline) {
                        node.timeoutAt = Math.min(timeoutNanos, node.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (timeoutNanos != 0) {
                        node.timeoutAt = timeoutNanos + nanoTime;
                    } else if (hasDeadline) {
                        node.timeoutAt = node.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long remainingNanos = node.remainingNanos(nanoTime);
                    AsyncTimeout asyncTimeout = AsyncTimeout.head;
                    Intrinsics.checkNotNull(asyncTimeout);
                    while (asyncTimeout.next != null) {
                        AsyncTimeout asyncTimeout2 = asyncTimeout.next;
                        Intrinsics.checkNotNull(asyncTimeout2);
                        if (remainingNanos < asyncTimeout2.remainingNanos(nanoTime)) {
                            break;
                        }
                        asyncTimeout = asyncTimeout.next;
                        Intrinsics.checkNotNull(asyncTimeout);
                    }
                    node.next = asyncTimeout.next;
                    asyncTimeout.next = node;
                    if (asyncTimeout == AsyncTimeout.head) {
                        AsyncTimeout.class.notify();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
            }
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 != null) {
                long remainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
                if (remainingNanos <= 0) {
                    AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                    Intrinsics.checkNotNull(asyncTimeout3);
                    asyncTimeout3.next = asyncTimeout2.next;
                    asyncTimeout2.next = null;
                    return asyncTimeout2;
                }
                long j3 = remainingNanos / 1000000;
                AsyncTimeout.class.wait(j3, (int) (remainingNanos - (1000000 * j3)));
                return null;
            }
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout4);
            if (asyncTimeout4.next == null && System.nanoTime() - nanoTime >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                return AsyncTimeout.head;
            }
            return null;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", TencentLocation.RUN_MODE, "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class Watchdog extends BaseThread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout awaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        awaitTimeout$okio = AsyncTimeout.INSTANCE.awaitTimeout$okio();
                        if (awaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (awaitTimeout$okio != null) {
                        awaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long now) {
        return this.timeoutAt - now;
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException cause) {
        return newTimeoutException(cause);
    }

    public final void enter() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            INSTANCE.scheduleTimeout(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return INSTANCE.cancelScheduledTimeout(this);
    }

    @NotNull
    protected IOException newTimeoutException(@Nullable IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e16) {
                    if (!asyncTimeout.exit()) {
                        throw e16;
                    }
                    throw asyncTimeout.access$newTimeoutException(e16);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e16) {
                    if (!asyncTimeout.exit()) {
                        throw e16;
                    }
                    throw asyncTimeout.access$newTimeoutException(e16);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(@NotNull Buffer source, long byteCount) {
                Intrinsics.checkNotNullParameter(source, "source");
                _UtilKt.checkOffsetAndCount(source.size(), 0L, byteCount);
                while (true) {
                    long j3 = 0;
                    if (byteCount > 0) {
                        Segment segment = source.head;
                        Intrinsics.checkNotNull(segment);
                        while (true) {
                            if (j3 >= 65536) {
                                break;
                            }
                            j3 += segment.limit - segment.pos;
                            if (j3 >= byteCount) {
                                j3 = byteCount;
                                break;
                            } else {
                                segment = segment.next;
                                Intrinsics.checkNotNull(segment);
                            }
                        }
                        AsyncTimeout asyncTimeout = AsyncTimeout.this;
                        Sink sink2 = sink;
                        asyncTimeout.enter();
                        try {
                            sink2.write(source, j3);
                            Unit unit = Unit.INSTANCE;
                            if (!asyncTimeout.exit()) {
                                byteCount -= j3;
                            } else {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                        } catch (IOException e16) {
                            if (!asyncTimeout.exit()) {
                                throw e16;
                            }
                            throw asyncTimeout.access$newTimeoutException(e16);
                        } finally {
                            asyncTimeout.exit();
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // okio.Sink
            @NotNull
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getThis$0() {
                return AsyncTimeout.this;
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    source2.close();
                    Unit unit = Unit.INSTANCE;
                    if (!asyncTimeout.exit()) {
                    } else {
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                } catch (IOException e16) {
                    if (!asyncTimeout.exit()) {
                        throw e16;
                    }
                    throw asyncTimeout.access$newTimeoutException(e16);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    long read = source2.read(sink, byteCount);
                    if (!asyncTimeout.exit()) {
                        return read;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e16) {
                    if (!asyncTimeout.exit()) {
                        throw e16;
                    }
                    throw asyncTimeout.access$newTimeoutException(e16);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // okio.Source
            @NotNull
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getThis$0() {
                return AsyncTimeout.this;
            }
        };
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                InlineMarker.finallyStart(1);
                if (!exit()) {
                    InlineMarker.finallyEnd(1);
                    return invoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e16) {
                if (!exit()) {
                    throw e16;
                }
                throw access$newTimeoutException(e16);
            }
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            exit();
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    protected void timedOut() {
    }
}
