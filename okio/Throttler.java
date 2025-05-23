package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\fJ$\u0010\u0006\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\f\u0010\u0016\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j3) {
        this.allocatedUntil = j3;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j16 = throttler.waitByteCount;
        }
        long j18 = j16;
        if ((i3 & 4) != 0) {
            j17 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j3, j18, j17);
    }

    private final long bytesToNanos(long j3) {
        return (j3 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j3) {
        return (j3 * this.bytesPerSecond) / 1000000000;
    }

    private final void waitNanos(long nanosToWait) {
        long j3 = nanosToWait / 1000000;
        wait(j3, (int) (nanosToWait - (1000000 * j3)));
    }

    public final long byteCountOrWaitNanos$okio(long now, long byteCount) {
        if (this.bytesPerSecond == 0) {
            return byteCount;
        }
        long max = Math.max(this.allocatedUntil - now, 0L);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= byteCount) {
            this.allocatedUntil = now + max + bytesToNanos(byteCount);
            return byteCount;
        }
        long j3 = this.waitByteCount;
        if (nanosToBytes >= j3) {
            this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j3, byteCount);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos == 0) {
            this.allocatedUntil = now + bytesToNanos(this.maxByteCount);
            return min;
        }
        return -bytesToNanos;
    }

    @JvmOverloads
    public final void bytesPerSecond(long j3) {
        bytesPerSecond$default(this, j3, 0L, 0L, 6, null);
    }

    @NotNull
    public final Sink sink(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new ForwardingSink(sink) { // from class: okio.Throttler$sink$1
            final /* synthetic */ Sink $sink;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(sink);
                this.$sink = sink;
            }

            @Override // okio.ForwardingSink, okio.Sink
            public void write(@NotNull Buffer source, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(source, "source");
                while (byteCount > 0) {
                    try {
                        long take$okio = Throttler.this.take$okio(byteCount);
                        super.write(source, take$okio);
                        byteCount -= take$okio;
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException("interrupted");
                    }
                }
            }
        };
    }

    @NotNull
    public final Source source(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new ForwardingSource(source) { // from class: okio.Throttler$source$1
            final /* synthetic */ Source $source;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(source);
                this.$source = source;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long byteCount) {
                Intrinsics.checkNotNullParameter(sink, "sink");
                try {
                    return super.read(sink, Throttler.this.take$okio(byteCount));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    public final long take$okio(long byteCount) {
        boolean z16;
        long byteCountOrWaitNanos$okio;
        if (byteCount > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            synchronized (this) {
                while (true) {
                    byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), byteCount);
                    if (byteCountOrWaitNanos$okio < 0) {
                        waitNanos(-byteCountOrWaitNanos$okio);
                    }
                }
            }
            return byteCountOrWaitNanos$okio;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @JvmOverloads
    public final void bytesPerSecond(long j3, long j16) {
        bytesPerSecond$default(this, j3, j16, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long bytesPerSecond, long waitByteCount, long maxByteCount) {
        synchronized (this) {
            if (!(bytesPerSecond >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(waitByteCount > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (maxByteCount >= waitByteCount) {
                this.bytesPerSecond = bytesPerSecond;
                this.waitByteCount = waitByteCount;
                this.maxByteCount = maxByteCount;
                notifyAll();
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
