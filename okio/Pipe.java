package okio;

import com.tencent.mobileqq.tritonaudio.webaudio.AudioContext;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u0010J\r\u0010\u0017\u001a\u00020\u0010H\u0007\u00a2\u0006\u0002\b$J\r\u0010\u001b\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b%J&\u0010&\u001a\u00020\"*\u00020\u00102\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"0(\u00a2\u0006\u0002\b)H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00108G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e\u00a8\u0006*"}, d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "cancel", "", QCircleDaTongConstant.ElementParamValue.PYMK_FOLD, "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class Pipe {

    @NotNull
    private final Buffer buffer = new Buffer();
    private boolean canceled;

    @Nullable
    private Sink foldedSink;
    private final long maxBufferSize;

    @NotNull
    private final Sink sink;
    private boolean sinkClosed;

    @NotNull
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j3) {
        boolean z16;
        this.maxBufferSize = j3;
        if (j3 >= 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1

                @NotNull
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        if (pipe.getSinkClosed()) {
                            return;
                        }
                        Sink foldedSink = pipe.getFoldedSink();
                        if (foldedSink == null) {
                            if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            pipe.setSinkClosed$okio(true);
                            pipe.getBuffer().notifyAll();
                            foldedSink = null;
                        }
                        Unit unit = Unit.INSTANCE;
                        if (foldedSink != null) {
                            Pipe pipe2 = Pipe.this;
                            Timeout timeout = foldedSink.getTimeout();
                            Timeout timeout2 = pipe2.sink().getTimeout();
                            long timeoutNanos = timeout.getTimeoutNanos();
                            long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (timeout.getHasDeadline()) {
                                long deadlineNanoTime = timeout.deadlineNanoTime();
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                                }
                                try {
                                    foldedSink.close();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.deadlineNanoTime(deadlineNanoTime);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.deadlineNanoTime(deadlineNanoTime);
                                    }
                                    throw th5;
                                }
                            }
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            } catch (Throwable th6) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th6;
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink;
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        if (!pipe.getSinkClosed()) {
                            if (!pipe.getCanceled()) {
                                foldedSink = pipe.getFoldedSink();
                                if (foldedSink == null) {
                                    if (pipe.getSourceClosed() && pipe.getBuffer().size() > 0) {
                                        throw new IOException("source is closed");
                                    }
                                    foldedSink = null;
                                }
                                Unit unit = Unit.INSTANCE;
                            } else {
                                throw new IOException("canceled");
                            }
                        } else {
                            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                        }
                    }
                    if (foldedSink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = foldedSink.getTimeout();
                        Timeout timeout2 = pipe2.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (timeout.getHasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th5;
                            }
                        }
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            foldedSink.flush();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                        } catch (Throwable th6) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th6;
                        }
                    }
                }

                @Override // okio.Sink
                @NotNull
                /* renamed from: timeout, reason: from getter */
                public Timeout getTimeout() {
                    return this.timeout;
                }

                /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
                
                    r1 = kotlin.Unit.INSTANCE;
                 */
                @Override // okio.Sink
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void write(@NotNull Buffer source, long byteCount) {
                    Sink sink;
                    Intrinsics.checkNotNullParameter(source, "source");
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        if (!pipe.getSinkClosed()) {
                            if (!pipe.getCanceled()) {
                                while (true) {
                                    if (byteCount > 0) {
                                        sink = pipe.getFoldedSink();
                                        if (sink != null) {
                                            break;
                                        }
                                        if (!pipe.getSourceClosed()) {
                                            long maxBufferSize = pipe.getMaxBufferSize() - pipe.getBuffer().size();
                                            if (maxBufferSize == 0) {
                                                this.timeout.waitUntilNotified(pipe.getBuffer());
                                                if (pipe.getCanceled()) {
                                                    throw new IOException("canceled");
                                                }
                                            } else {
                                                long min = Math.min(maxBufferSize, byteCount);
                                                pipe.getBuffer().write(source, min);
                                                byteCount -= min;
                                                pipe.getBuffer().notifyAll();
                                            }
                                        } else {
                                            throw new IOException("source is closed");
                                        }
                                    } else {
                                        sink = null;
                                        break;
                                    }
                                }
                            } else {
                                throw new IOException("canceled");
                            }
                        } else {
                            throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                        }
                    }
                    if (sink != null) {
                        Pipe pipe2 = Pipe.this;
                        Timeout timeout = sink.getTimeout();
                        Timeout timeout2 = pipe2.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (timeout.getHasDeadline()) {
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                sink.write(source, byteCount);
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                    return;
                                }
                                return;
                            } catch (Throwable th5) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th5;
                            }
                        }
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                        }
                        try {
                            sink.write(source, byteCount);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                        } catch (Throwable th6) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.clearDeadline();
                            }
                            throw th6;
                        }
                    }
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1

                @NotNull
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        pipe.setSourceClosed$okio(true);
                        pipe.getBuffer().notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                }

                @Override // okio.Source
                public long read(@NotNull Buffer sink, long byteCount) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Buffer buffer = Pipe.this.getBuffer();
                    Pipe pipe = Pipe.this;
                    synchronized (buffer) {
                        if (!pipe.getSourceClosed()) {
                            if (!pipe.getCanceled()) {
                                while (pipe.getBuffer().size() == 0) {
                                    if (pipe.getSinkClosed()) {
                                        return -1L;
                                    }
                                    this.timeout.waitUntilNotified(pipe.getBuffer());
                                    if (pipe.getCanceled()) {
                                        throw new IOException("canceled");
                                    }
                                }
                                long read = pipe.getBuffer().read(sink, byteCount);
                                pipe.getBuffer().notifyAll();
                                return read;
                            }
                            throw new IOException("canceled");
                        }
                        throw new IllegalStateException(AudioContext.State.CLOSED.toString());
                    }
                }

                @Override // okio.Source
                @NotNull
                /* renamed from: timeout, reason: from getter */
                public Timeout getTimeout() {
                    return this.timeout;
                }
            };
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("maxBufferSize < 1: ", Long.valueOf(getMaxBufferSize())).toString());
    }

    private final void forward(Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink.getTimeout();
        Timeout timeout2 = sink().getTimeout();
        long timeoutNanos = timeout.getTimeoutNanos();
        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.getHasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke(sink);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.getHasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                return;
            } catch (Throwable th5) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.getHasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.finallyEnd(1);
                throw th5;
            }
        }
        if (timeout2.getHasDeadline()) {
            timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            function1.invoke(sink);
            Unit unit2 = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.getHasDeadline()) {
                timeout.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th6) {
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.getHasDeadline()) {
                timeout.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
            throw th6;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    @NotNull
    /* renamed from: -deprecated_sink, reason: not valid java name and from getter */
    public final Sink getSink() {
        return this.sink;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    @JvmName(name = "-deprecated_source")
    @NotNull
    /* renamed from: -deprecated_source, reason: not valid java name and from getter */
    public final Source getSource() {
        return this.source;
    }

    public final void cancel() {
        synchronized (this.buffer) {
            setCanceled$okio(true);
            getBuffer().clear();
            getBuffer().notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void fold(@NotNull Sink sink) throws IOException {
        boolean z16;
        boolean sinkClosed;
        Buffer buffer;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (getFoldedSink() == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (!getCanceled()) {
                        if (getBuffer().exhausted()) {
                            setSourceClosed$okio(true);
                            setFoldedSink$okio(sink);
                            return;
                        } else {
                            sinkClosed = getSinkClosed();
                            buffer = new Buffer();
                            buffer.write(getBuffer(), getBuffer().size());
                            getBuffer().notifyAll();
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        setFoldedSink$okio(sink);
                        throw new IOException("canceled");
                    }
                } else {
                    throw new IllegalStateException("sink already folded".toString());
                }
            }
            try {
                sink.write(buffer, buffer.size());
                if (sinkClosed) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th5) {
                synchronized (this.buffer) {
                    setSourceClosed$okio(true);
                    getBuffer().notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                    throw th5;
                }
            }
        }
    }

    @NotNull
    /* renamed from: getBuffer$okio, reason: from getter */
    public final Buffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getCanceled$okio, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    @Nullable
    /* renamed from: getFoldedSink$okio, reason: from getter */
    public final Sink getFoldedSink() {
        return this.foldedSink;
    }

    /* renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    /* renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z16) {
        this.canceled = z16;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z16) {
        this.sinkClosed = z16;
    }

    public final void setSourceClosed$okio(boolean z16) {
        this.sourceClosed = z16;
    }

    @JvmName(name = "sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name = "source")
    @NotNull
    public final Source source() {
        return this.source;
    }
}
