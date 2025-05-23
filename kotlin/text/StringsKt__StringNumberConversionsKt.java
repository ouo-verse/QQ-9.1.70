package kotlin.text;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes28.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    @NotNull
    public static final Void numberFormatError(@NotNull String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toByteOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Integer toIntOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static Long toLongOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toShortOrNull(str, 10);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Byte toByteOrNull(@NotNull String str, int i3) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i3);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Integer toIntOrNull(@NotNull String str, int i3) {
        boolean z16;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i18 = 0;
        char charAt = str.charAt(0);
        int i19 = -2147483647;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            i16 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i19 = Integer.MIN_VALUE;
                z16 = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z16 = false;
            }
        } else {
            z16 = false;
            i16 = 0;
        }
        int i26 = -59652323;
        while (i16 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i16), i3);
            if (digitOf < 0) {
                return null;
            }
            if ((i18 < i26 && (i26 != -59652323 || i18 < (i26 = i19 / i3))) || (i17 = i18 * i3) < i19 + digitOf) {
                return null;
            }
            i18 = i17 - digitOf;
            i16++;
        }
        return z16 ? Integer.valueOf(i18) : Integer.valueOf(-i18);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Long toLongOrNull(@NotNull String str, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i16 = 0;
        char charAt = str.charAt(0);
        long j3 = -9223372036854775807L;
        if (Intrinsics.compare((int) charAt, 48) < 0) {
            z16 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j3 = Long.MIN_VALUE;
                i16 = 1;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z16 = false;
                i16 = 1;
            }
        } else {
            z16 = false;
        }
        long j16 = -256204778801521550L;
        long j17 = 0;
        long j18 = -256204778801521550L;
        while (i16 < length) {
            int digitOf = CharsKt__CharJVMKt.digitOf(str.charAt(i16), i3);
            if (digitOf < 0) {
                return null;
            }
            if (j17 < j18) {
                if (j18 == j16) {
                    j18 = j3 / i3;
                    if (j17 < j18) {
                    }
                }
                return null;
            }
            long j19 = j17 * i3;
            long j26 = digitOf;
            if (j19 < j3 + j26) {
                return null;
            }
            j17 = j19 - j26;
            i16++;
            j16 = -256204778801521550L;
        }
        return z16 ? Long.valueOf(j17) : Long.valueOf(-j17);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Short toShortOrNull(@NotNull String str, int i3) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = toIntOrNull(str, i3);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
