package kotlin.time;

import com.tencent.mobileqq.msf.core.auth.k;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.time.TimeSource;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u00c1\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u0006H\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0015"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource;", "()V", "zero", "", "adjustReading", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "timeMark", "duration", "Lkotlin/time/Duration;", "adjustReading-6QKq23U", "(JJ)J", "elapsedFrom", "elapsedFrom-6eNON_k", "(J)J", "markNow", "markNow-z9LOYto", "()J", k.f247491e, "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
/* loaded from: classes28.dex */
public final class MonotonicTimeSource implements TimeSource {

    @NotNull
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
    private static final long zero = System.nanoTime();

    MonotonicTimeSource() {
    }

    private final long read() {
        return System.nanoTime() - zero;
    }

    /* renamed from: adjustReading-6QKq23U, reason: not valid java name */
    public final long m1956adjustReading6QKq23U(long timeMark, long duration) {
        return TimeSource.Monotonic.ValueTimeMark.m1965constructorimpl(LongSaturatedMathKt.m1954saturatingAddpTJri5U(timeMark, duration));
    }

    /* renamed from: elapsedFrom-6eNON_k, reason: not valid java name */
    public final long m1957elapsedFrom6eNON_k(long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(read(), timeMark);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m1964boximpl(m1958markNowz9LOYto());
    }

    /* renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m1958markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m1965constructorimpl(read());
    }

    @NotNull
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
