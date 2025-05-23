package kotlin.time;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
/* loaded from: classes28.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Monotonic implements TimeSource {

        @NotNull
        public static final Monotonic INSTANCE = new Monotonic();

        /* compiled from: P */
        @SinceKotlin(version = "1.7")
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\bH\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020 H\u00d6\u0001\u00a2\u0006\u0004\b!\u0010\"R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006#"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/TimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "", "hashCode-impl", "(J)I", "minus", "duration", "minus-LRDsOJo", "(JJ)J", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        @JvmInline
        @ExperimentalTime
        /* loaded from: classes28.dex */
        public static final class ValueTimeMark implements TimeMark {
            private final long reading;

            /* synthetic */ ValueTimeMark(long j3) {
                this.reading = j3;
            }

            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m1964boximpl(long j3) {
                return new ValueTimeMark(j3);
            }

            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m1967equalsimpl(long j3, Object obj) {
                if (!(obj instanceof ValueTimeMark) || j3 != ((ValueTimeMark) obj).getReading()) {
                    return false;
                }
                return true;
            }

            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m1968equalsimpl0(long j3, long j16) {
                if (j3 == j16) {
                    return true;
                }
                return false;
            }

            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m1969hasNotPassedNowimpl(long j3) {
                return Duration.m1859isNegativeimpl(m1966elapsedNowUwyO8pc(j3));
            }

            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m1970hasPassedNowimpl(long j3) {
                return !Duration.m1859isNegativeimpl(m1966elapsedNowUwyO8pc(j3));
            }

            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m1971hashCodeimpl(long j3) {
                return (int) (j3 ^ (j3 >>> 32));
            }

            /* renamed from: toString-impl, reason: not valid java name */
            public static String m1974toStringimpl(long j3) {
                return "ValueTimeMark(reading=" + j3 + ')';
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo1818elapsedNowUwyO8pc() {
                return m1966elapsedNowUwyO8pc(this.reading);
            }

            public boolean equals(Object obj) {
                return m1967equalsimpl(this.reading, obj);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m1969hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m1970hasPassedNowimpl(this.reading);
            }

            public int hashCode() {
                return m1971hashCodeimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1819minusLRDsOJo(long j3) {
                return m1964boximpl(m1975minusLRDsOJo(j3));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo1820plusLRDsOJo(long j3) {
                return m1964boximpl(m1976plusLRDsOJo(j3));
            }

            public String toString() {
                return m1974toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getReading() {
                return this.reading;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m1966elapsedNowUwyO8pc(long j3) {
                return MonotonicTimeSource.INSTANCE.m1957elapsedFrom6eNON_k(j3);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m1975minusLRDsOJo(long j3) {
                return m1972minusLRDsOJo(this.reading, j3);
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m1976plusLRDsOJo(long j3) {
                return m1973plusLRDsOJo(this.reading, j3);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m1972minusLRDsOJo(long j3, long j16) {
                return MonotonicTimeSource.INSTANCE.m1956adjustReading6QKq23U(j3, Duration.m1878unaryMinusUwyO8pc(j16));
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m1973plusLRDsOJo(long j3, long j16) {
                return MonotonicTimeSource.INSTANCE.m1956adjustReading6QKq23U(j3, j16);
            }

            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m1965constructorimpl(long j3) {
                return j3;
            }
        }

        Monotonic() {
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m1964boximpl(m1963markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m1963markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m1958markNowz9LOYto();
        }

        @NotNull
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @NotNull
    TimeMark markNow();
}
