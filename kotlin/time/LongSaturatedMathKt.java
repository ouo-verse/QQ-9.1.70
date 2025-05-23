package kotlin.time;

import kotlin.Metadata;
import kotlin.time.Duration;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class LongSaturatedMathKt {
    /* renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m1953checkInfiniteSumDefinedPjuGub4(long j3, long j16, long j17) {
        if (Duration.m1858isInfiniteimpl(j16) && (j3 ^ j17) < 0) {
            throw new IllegalArgumentException("Summing infinities of different signs");
        }
        return j3;
    }

    /* renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m1954saturatingAddpTJri5U(long j3, long j16) {
        long m1846getInWholeNanosecondsimpl = Duration.m1846getInWholeNanosecondsimpl(j16);
        if (((j3 - 1) | 1) == Long.MAX_VALUE) {
            return m1953checkInfiniteSumDefinedPjuGub4(j3, j16, m1846getInWholeNanosecondsimpl);
        }
        if ((1 | (m1846getInWholeNanosecondsimpl - 1)) == Long.MAX_VALUE) {
            return m1955saturatingAddInHalvespTJri5U(j3, j16);
        }
        long j17 = j3 + m1846getInWholeNanosecondsimpl;
        if (((j3 ^ j17) & (m1846getInWholeNanosecondsimpl ^ j17)) < 0) {
            if (j3 >= 0) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
        return j17;
    }

    /* renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m1955saturatingAddInHalvespTJri5U(long j3, long j16) {
        long m1829divUwyO8pc = Duration.m1829divUwyO8pc(j16, 2);
        if (((Duration.m1846getInWholeNanosecondsimpl(m1829divUwyO8pc) - 1) | 1) == Long.MAX_VALUE) {
            return (long) (j3 + Duration.m1869toDoubleimpl(j16, DurationUnit.NANOSECONDS));
        }
        return m1954saturatingAddpTJri5U(m1954saturatingAddpTJri5U(j3, m1829divUwyO8pc), m1829divUwyO8pc);
    }

    public static final long saturatingDiff(long j3, long j16) {
        if ((1 | (j16 - 1)) == Long.MAX_VALUE) {
            return Duration.m1878unaryMinusUwyO8pc(DurationKt.toDuration(j16, DurationUnit.DAYS));
        }
        long j17 = j3 - j16;
        if (((j17 ^ j3) & (~(j17 ^ j16))) < 0) {
            long j18 = 1000000;
            long j19 = (j3 / j18) - (j16 / j18);
            long j26 = (j3 % j18) - (j16 % j18);
            Duration.Companion companion = Duration.INSTANCE;
            return Duration.m1862plusLRDsOJo(DurationKt.toDuration(j19, DurationUnit.MILLISECONDS), DurationKt.toDuration(j26, DurationUnit.NANOSECONDS));
        }
        Duration.Companion companion2 = Duration.INSTANCE;
        return DurationKt.toDuration(j17, DurationUnit.NANOSECONDS);
    }
}
