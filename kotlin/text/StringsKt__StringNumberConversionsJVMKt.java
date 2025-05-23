package kotlin.text;

import com.tencent.ams.adcore.mma.api.Global;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b\u00a2\u0006\u0002\b\u0014\u001a\r\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0016*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u001a\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010 \u001a\u00020!*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020!*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\"\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010\"\u001a\u00020#*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010$\u001a\u00020\u0003*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u00a8\u0006%"}, d2 = {"screenFloatValue", "T", "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toBooleanNullable", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return function1.invoke(str);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new BigInteger(str);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @Nullable
    public static BigInteger toBigIntegerOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ boolean toBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Boolean.parseBoolean(str);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "toBooleanNullable")
    private static final boolean toBooleanNullable(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Byte.parseByte(str);
    }

    @InlineOnly
    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Double toDoubleOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Float toFloatOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (!ScreenFloatValueRegEx.value.matches(str)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str);
    }

    @InlineOnly
    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Long.parseLong(str);
    }

    @InlineOnly
    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(byte b16, int i3) {
        int checkRadix;
        int checkRadix2;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(checkRadix);
        String num = Integer.toString(b16, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final BigInteger toBigInteger(String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return new BigInteger(str, checkRadix);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @Nullable
    public static final BigInteger toBigIntegerOrNull(@NotNull String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i16 = str.charAt(0) == '-' ? 1 : 0; i16 < length; i16++) {
                if (CharsKt__CharJVMKt.digitOf(str.charAt(i16), i3) < 0) {
                    return null;
                }
            }
        } else if (CharsKt__CharJVMKt.digitOf(str.charAt(0), i3) < 0) {
            return null;
        }
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return new BigInteger(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte toByte(String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return Byte.parseByte(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int toInt(String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return Integer.parseInt(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long toLong(String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return Long.parseLong(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short toShort(String str, int i3) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(str, "<this>");
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        return Short.parseShort(str, checkRadix);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(short s16, int i3) {
        int checkRadix;
        int checkRadix2;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(checkRadix);
        String num = Integer.toString(s16, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(int i3, int i16) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i16);
        String num = Integer.toString(i3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @Nullable
    public static final BigDecimal toBigDecimalOrNull(@NotNull String str, @NotNull MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String toString(long j3, int i3) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        String l3 = Long.toString(j3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return l3;
    }
}
