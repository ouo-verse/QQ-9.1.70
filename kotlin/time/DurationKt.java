package kotlin.time;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&\u001a\u0018\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0018\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\b\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\b2\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010A\u001a\u001f\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\b2\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010G\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010H\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T\u00a2\u0006\u0002\n\u0000\"!\u0010\u0006\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\r\u001a\u0004\b\u000b\u0010\u000e\"!\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\t\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010\"!\u0010\u0011\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000e\"!\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010\"!\u0010\u0014\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000e\"!\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010\"!\u0010\u0017\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000e\"!\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0010\"!\u0010\u001a\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000e\"!\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u0010\"!\u0010\u001d\u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000e\"!\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\"!\u0010 \u001a\u00020\u0007*\u00020\b8FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010\f\"!\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000e\"!\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\f\u0012\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006J"}, d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", TuxTimeView.TUX_TIME_STYLE_MINUTES, "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", Element.ELEMENT_NAME_TIMES, "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long durationOf(long j3, int i3) {
        return Duration.m1826constructorimpl((j3 << 1) + i3);
    }

    public static final long durationOfMillis(long j3) {
        return Duration.m1826constructorimpl((j3 << 1) + 1);
    }

    public static final long durationOfMillisNormalized(long j3) {
        long coerceIn;
        if (!new LongRange(-4611686018426L, MAX_NANOS_IN_MILLIS).contains(j3)) {
            coerceIn = RangesKt___RangesKt.coerceIn(j3, -4611686018427387903L, MAX_MILLIS);
            return durationOfMillis(coerceIn);
        }
        return durationOfNanos(millisToNanos(j3));
    }

    public static final long durationOfNanos(long j3) {
        return Duration.m1826constructorimpl(j3 << 1);
    }

    public static final long durationOfNanosNormalized(long j3) {
        if (new LongRange(-4611686018426999999L, MAX_NANOS).contains(j3)) {
            return durationOfNanos(j3);
        }
        return durationOfMillis(nanosToMillis(j3));
    }

    public static final long getDays(int i3) {
        return toDuration(i3, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d16) {
    }

    public static final long getHours(int i3) {
        return toDuration(i3, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d16) {
    }

    public static final long getMicroseconds(int i3) {
        return toDuration(i3, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d16) {
    }

    public static final long getMilliseconds(int i3) {
        return toDuration(i3, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d16) {
    }

    public static final long getMinutes(int i3) {
        return toDuration(i3, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d16) {
    }

    public static final long getNanoseconds(int i3) {
        return toDuration(i3, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d16) {
    }

    public static final long getSeconds(int i3) {
        return toDuration(i3, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d16) {
    }

    public static final long millisToNanos(long j3) {
        return j3 * 1000000;
    }

    public static final long nanosToMillis(long j3) {
        return j3 / 1000000;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[LOOP:1: B:25:0x0072->B:33:0x00a1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad A[EDGE_INSN: B:34:0x00ad->B:35:0x00ad BREAK  A[LOOP:1: B:25:0x0072->B:33:0x00a1], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long parseDuration(String str, boolean z16) {
        int i3;
        boolean z17;
        boolean z18;
        boolean regionMatches;
        int i16;
        boolean z19;
        int indexOf$default;
        boolean z26;
        boolean z27;
        char last;
        int i17;
        boolean z28;
        int lastIndex;
        int indexOf$default2;
        boolean z29;
        boolean contains$default;
        boolean startsWith$default;
        int length = str.length();
        if (length != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            long m1928getZEROUwyO8pc = companion.m1928getZEROUwyO8pc();
            char charAt = str.charAt(0);
            boolean z36 = true;
            if (charAt == '+' || charAt == '-') {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null);
                if (startsWith$default) {
                    z18 = true;
                    if (length <= i3) {
                        char c16 = '0';
                        if (str.charAt(i3) == 'P') {
                            int i18 = i3 + 1;
                            if (i18 != length) {
                                boolean z37 = false;
                                DurationUnit durationUnit = null;
                                while (i18 < length) {
                                    if (str.charAt(i18) == 'T') {
                                        if (!z37 && (i18 = i18 + 1) != length) {
                                            z37 = z36;
                                        } else {
                                            throw new IllegalArgumentException();
                                        }
                                    } else {
                                        int i19 = i18;
                                        while (true) {
                                            if (i19 < str.length()) {
                                                char charAt2 = str.charAt(i19);
                                                if (!new CharRange(c16, '9').contains(charAt2)) {
                                                    i17 = length;
                                                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) "+-.", charAt2, false, 2, (Object) null);
                                                    if (!contains$default) {
                                                        z29 = false;
                                                        if (z29) {
                                                            break;
                                                        }
                                                        i19++;
                                                        length = i17;
                                                        c16 = '0';
                                                    }
                                                } else {
                                                    i17 = length;
                                                }
                                                z29 = true;
                                                if (z29) {
                                                }
                                            } else {
                                                i17 = length;
                                                break;
                                            }
                                        }
                                        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                                        String substring = str.substring(i18, i19);
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                        if (substring.length() == 0) {
                                            z28 = true;
                                        } else {
                                            z28 = false;
                                        }
                                        if (!z28) {
                                            int length2 = i18 + substring.length();
                                            if (length2 >= 0) {
                                                lastIndex = StringsKt__StringsKt.getLastIndex(str);
                                                if (length2 <= lastIndex) {
                                                    char charAt3 = str.charAt(length2);
                                                    i18 = length2 + 1;
                                                    DurationUnit durationUnitByIsoChar = DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(charAt3, z37);
                                                    if (durationUnit == null || durationUnit.compareTo(durationUnitByIsoChar) > 0) {
                                                        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6, (Object) null);
                                                        if (durationUnitByIsoChar == DurationUnit.SECONDS && indexOf$default2 > 0) {
                                                            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                                            String substring2 = substring.substring(0, indexOf$default2);
                                                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                            long m1862plusLRDsOJo = Duration.m1862plusLRDsOJo(m1928getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring2), durationUnitByIsoChar));
                                                            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                                            String substring3 = substring.substring(indexOf$default2);
                                                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                                                            m1928getZEROUwyO8pc = Duration.m1862plusLRDsOJo(m1862plusLRDsOJo, toDuration(Double.parseDouble(substring3), durationUnitByIsoChar));
                                                        } else {
                                                            m1928getZEROUwyO8pc = Duration.m1862plusLRDsOJo(m1928getZEROUwyO8pc, toDuration(parseOverLongIsoComponent(substring), durationUnitByIsoChar));
                                                        }
                                                        durationUnit = durationUnitByIsoChar;
                                                        length = i17;
                                                        c16 = '0';
                                                        z36 = true;
                                                    } else {
                                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                                    }
                                                }
                                            }
                                            throw new IllegalArgumentException("Missing unit for value " + substring);
                                        }
                                        throw new IllegalArgumentException();
                                    }
                                }
                            } else {
                                throw new IllegalArgumentException();
                            }
                        } else if (!z16) {
                            String str2 = "null cannot be cast to non-null type java.lang.String";
                            String str3 = "this as java.lang.String).substring(startIndex)";
                            regionMatches = StringsKt__StringsJVMKt.regionMatches(str, i3, "Infinity", 0, Math.max(length - i3, 8), true);
                            if (regionMatches) {
                                m1928getZEROUwyO8pc = companion.m1926getINFINITEUwyO8pc();
                            } else {
                                boolean z38 = !z17;
                                if (z17 && str.charAt(i3) == '(') {
                                    last = StringsKt___StringsKt.last(str);
                                    if (last == ')') {
                                        i3++;
                                        int i26 = length - 1;
                                        if (i3 != i26) {
                                            i16 = i26;
                                            z38 = true;
                                            boolean z39 = false;
                                            DurationUnit durationUnit2 = null;
                                            while (i3 < i16) {
                                                if (z39 && z38) {
                                                    while (i3 < str.length()) {
                                                        if (str.charAt(i3) == ' ') {
                                                            z27 = true;
                                                        } else {
                                                            z27 = false;
                                                        }
                                                        if (!z27) {
                                                            break;
                                                        }
                                                        i3++;
                                                    }
                                                }
                                                int i27 = i3;
                                                while (i27 < str.length()) {
                                                    char charAt4 = str.charAt(i27);
                                                    if (!new CharRange('0', '9').contains(charAt4) && charAt4 != '.') {
                                                        z26 = false;
                                                    } else {
                                                        z26 = true;
                                                    }
                                                    if (!z26) {
                                                        break;
                                                    }
                                                    i27++;
                                                }
                                                String str4 = str2;
                                                Intrinsics.checkNotNull(str, str4);
                                                String substring4 = str.substring(i3, i27);
                                                Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                if (substring4.length() == 0) {
                                                    z19 = true;
                                                } else {
                                                    z19 = false;
                                                }
                                                if (!z19) {
                                                    int length3 = i3 + substring4.length();
                                                    int i28 = length3;
                                                    while (i28 < str.length()) {
                                                        if (!new CharRange('a', 'z').contains(str.charAt(i28))) {
                                                            break;
                                                        }
                                                        i28++;
                                                    }
                                                    Intrinsics.checkNotNull(str, str4);
                                                    String substring5 = str.substring(length3, i28);
                                                    Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                    i3 = length3 + substring5.length();
                                                    DurationUnit durationUnitByShortName = DurationUnitKt__DurationUnitKt.durationUnitByShortName(substring5);
                                                    if (durationUnit2 == null || durationUnit2.compareTo(durationUnitByShortName) > 0) {
                                                        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) substring4, '.', 0, false, 6, (Object) null);
                                                        if (indexOf$default > 0) {
                                                            Intrinsics.checkNotNull(substring4, str4);
                                                            String substring6 = substring4.substring(0, indexOf$default);
                                                            Intrinsics.checkNotNullExpressionValue(substring6, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                            long m1862plusLRDsOJo2 = Duration.m1862plusLRDsOJo(m1928getZEROUwyO8pc, toDuration(Long.parseLong(substring6), durationUnitByShortName));
                                                            Intrinsics.checkNotNull(substring4, str4);
                                                            String substring7 = substring4.substring(indexOf$default);
                                                            String str5 = str3;
                                                            Intrinsics.checkNotNullExpressionValue(substring7, str5);
                                                            m1928getZEROUwyO8pc = Duration.m1862plusLRDsOJo(m1862plusLRDsOJo2, toDuration(Double.parseDouble(substring7), durationUnitByShortName));
                                                            if (i3 >= i16) {
                                                                str3 = str5;
                                                            } else {
                                                                throw new IllegalArgumentException("Fractional component must be last");
                                                            }
                                                        } else {
                                                            m1928getZEROUwyO8pc = Duration.m1862plusLRDsOJo(m1928getZEROUwyO8pc, toDuration(Long.parseLong(substring4), durationUnitByShortName));
                                                        }
                                                        str2 = str4;
                                                        durationUnit2 = durationUnitByShortName;
                                                        z39 = true;
                                                    } else {
                                                        throw new IllegalArgumentException("Unexpected order of duration components");
                                                    }
                                                } else {
                                                    throw new IllegalArgumentException();
                                                }
                                            }
                                        } else {
                                            throw new IllegalArgumentException("No components");
                                        }
                                    }
                                }
                                i16 = length;
                                boolean z392 = false;
                                DurationUnit durationUnit22 = null;
                                while (i3 < i16) {
                                }
                            }
                        } else {
                            throw new IllegalArgumentException();
                        }
                        if (z18) {
                            return Duration.m1878unaryMinusUwyO8pc(m1928getZEROUwyO8pc);
                        }
                        return m1928getZEROUwyO8pc;
                    }
                    throw new IllegalArgumentException("No components");
                }
            }
            z18 = false;
            if (length <= i3) {
            }
        } else {
            throw new IllegalArgumentException("The string is empty");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final long parseOverLongIsoComponent(String str) {
        int i3;
        boolean startsWith$default;
        int lastIndex;
        boolean z16;
        boolean contains$default;
        int length = str.length();
        if (length > 0) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null);
            if (contains$default) {
                i3 = 1;
                if (length - i3 > 16) {
                    lastIndex = StringsKt__StringsKt.getLastIndex(str);
                    Iterable intRange = new IntRange(i3, lastIndex);
                    if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                        Iterator it = intRange.iterator();
                        while (it.hasNext()) {
                            if (!new CharRange('0', '9').contains(str.charAt(((IntIterator) it).nextInt()))) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (z16) {
                        if (str.charAt(0) == '-') {
                            return Long.MIN_VALUE;
                        }
                        return Long.MAX_VALUE;
                    }
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, Marker.ANY_NON_NULL_MARKER, false, 2, null);
                if (startsWith$default) {
                    str = StringsKt___StringsKt.drop(str, 1);
                }
                return Long.parseLong(str);
            }
        }
        i3 = 0;
        if (length - i3 > 16) {
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, Marker.ANY_NON_NULL_MARKER, false, 2, null);
        if (startsWith$default) {
        }
        return Long.parseLong(str);
    }

    private static final int skipWhile(String str, int i3, Function1<? super Character, Boolean> function1) {
        while (i3 < str.length() && function1.invoke(Character.valueOf(str.charAt(i3))).booleanValue()) {
            i3++;
        }
        return i3;
    }

    private static final String substringWhile(String str, int i3, Function1<? super Character, Boolean> function1) {
        int i16 = i3;
        while (i16 < str.length() && function1.invoke(Character.valueOf(str.charAt(i16))).booleanValue()) {
            i16++;
        }
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i3, i16);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* renamed from: times-kIfJnKk */
    private static final long m1951timeskIfJnKk(double d16, long j3) {
        return Duration.m1863timesUwyO8pc(j3, d16);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InlineOnly
    /* renamed from: times-mvk6XK0 */
    private static final long m1952timesmvk6XK0(int i3, long j3) {
        return Duration.m1864timesUwyO8pc(j3, i3);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(int i3, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i3, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(i3, unit);
    }

    public static final long getDays(long j3) {
        return toDuration(j3, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i3) {
    }

    public static final long getHours(long j3) {
        return toDuration(j3, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i3) {
    }

    public static final long getMicroseconds(long j3) {
        return toDuration(j3, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i3) {
    }

    public static final long getMilliseconds(long j3) {
        return toDuration(j3, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i3) {
    }

    public static final long getMinutes(long j3) {
        return toDuration(j3, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i3) {
    }

    public static final long getNanoseconds(long j3) {
        return toDuration(j3, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i3) {
    }

    public static final long getSeconds(long j3) {
        return toDuration(j3, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i3) {
    }

    public static final long getDays(double d16) {
        return toDuration(d16, DurationUnit.DAYS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j3) {
    }

    public static final long getHours(double d16) {
        return toDuration(d16, DurationUnit.HOURS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j3) {
    }

    public static final long getMicroseconds(double d16) {
        return toDuration(d16, DurationUnit.MICROSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j3) {
    }

    public static final long getMilliseconds(double d16) {
        return toDuration(d16, DurationUnit.MILLISECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j3) {
    }

    public static final long getMinutes(double d16) {
        return toDuration(d16, DurationUnit.MINUTES);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j3) {
    }

    public static final long getNanoseconds(double d16) {
        return toDuration(d16, DurationUnit.NANOSECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j3) {
    }

    public static final long getSeconds(double d16) {
        return toDuration(d16, DurationUnit.SECONDS);
    }

    @SinceKotlin(version = "1.3")
    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j3) {
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(long j3, @NotNull DurationUnit unit) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if (!new LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j3)) {
            coerceIn = RangesKt___RangesKt.coerceIn(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j3, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS);
            return durationOfMillis(coerceIn);
        }
        return durationOfNanos(DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j3, unit, durationUnit));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long toDuration(double d16, @NotNull DurationUnit unit) {
        long roundToLong;
        long roundToLong2;
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d16, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            roundToLong = MathKt__MathJVMKt.roundToLong(convertDurationUnit);
            if (!new LongRange(-4611686018426999999L, MAX_NANOS).contains(roundToLong)) {
                roundToLong2 = MathKt__MathJVMKt.roundToLong(DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d16, unit, DurationUnit.MILLISECONDS));
                return durationOfMillisNormalized(roundToLong2);
            }
            return durationOfNanos(roundToLong);
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }
}
