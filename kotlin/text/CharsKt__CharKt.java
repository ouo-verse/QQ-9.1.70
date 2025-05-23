package kotlin.text;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007\u00a8\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", QCircleDaTongConstant.ElementParamValue.PLUS, "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes28.dex */
public class CharsKt__CharKt extends CharsKt__CharJVMKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int i3) {
        if (new IntRange(0, 9).contains(i3)) {
            return (char) (i3 + 48);
        }
        throw new IllegalArgumentException("Int " + i3 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char c16) {
        int digitOf = CharsKt__CharJVMKt.digitOf(c16, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new IllegalArgumentException("Char " + c16 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer digitToIntOrNull(char c16) {
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c16, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static boolean equals(char c16, char c17, boolean z16) {
        if (c16 == c17) {
            return true;
        }
        if (!z16) {
            return false;
        }
        char upperCase = Character.toUpperCase(c16);
        char upperCase2 = Character.toUpperCase(c17);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean equals$default(char c16, char c17, boolean z16, int i3, Object obj) {
        boolean equals;
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        equals = equals(c16, c17, z16);
        return equals;
    }

    public static final boolean isSurrogate(char c16) {
        return new CharRange('\ud800', '\udfff').contains(c16);
    }

    @InlineOnly
    private static final String plus(char c16, String other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return c16 + other;
    }

    @SinceKotlin(version = "1.5")
    @NotNull
    public static final String titlecase(char c16) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c16);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer digitToIntOrNull(char c16, int i3) {
        CharsKt__CharJVMKt.checkRadix(i3);
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.digitOf(c16, i3));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char digitToChar(int i3, int i16) {
        if (!new IntRange(2, 36).contains(i16)) {
            throw new IllegalArgumentException("Invalid radix: " + i16 + ". Valid radix values are in range 2..36");
        }
        if (i3 >= 0 && i3 < i16) {
            return (char) (i3 < 10 ? i3 + 48 : ((char) (i3 + 65)) - '\n');
        }
        throw new IllegalArgumentException("Digit " + i3 + " does not represent a valid digit in radix " + i16);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int digitToInt(char c16, int i3) {
        Integer digitToIntOrNull = digitToIntOrNull(c16, i3);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c16 + " is not a digit in the given radix=" + i3);
    }
}
