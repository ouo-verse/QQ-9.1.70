package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u00a8\u0006\t"}, d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes28.dex */
public class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b16, byte b17) {
        int i3 = b16 / b17;
        return ((b16 ^ b17) >= 0 || b17 * i3 == b16) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(byte b16, byte b17) {
        int i3 = b16 % b17;
        return (byte) (i3 + (b17 & (((i3 ^ b17) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b16, short s16) {
        int i3 = b16 / s16;
        return ((b16 ^ s16) >= 0 || s16 * i3 == b16) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(byte b16, short s16) {
        int i3 = b16 % s16;
        return (short) (i3 + (s16 & (((i3 ^ s16) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(byte b16, int i3) {
        int i16 = b16 / i3;
        return ((b16 ^ i3) >= 0 || i3 * i16 == b16) ? i16 : i16 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(byte b16, int i3) {
        int i16 = b16 % i3;
        return i16 + (i3 & (((i16 ^ i3) & ((-i16) | i16)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(byte b16, long j3) {
        long j16 = b16;
        long j17 = j16 / j3;
        return ((j16 ^ j3) >= 0 || j3 * j17 == j16) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(byte b16, long j3) {
        long j16 = b16 % j3;
        return j16 + (j3 & (((j16 ^ j3) & ((-j16) | j16)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s16, byte b16) {
        int i3 = s16 / b16;
        return ((s16 ^ b16) >= 0 || b16 * i3 == s16) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(short s16, byte b16) {
        int i3 = s16 % b16;
        return (byte) (i3 + (b16 & (((i3 ^ b16) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s16, short s17) {
        int i3 = s16 / s17;
        return ((s16 ^ s17) >= 0 || s17 * i3 == s16) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(short s16, short s17) {
        int i3 = s16 % s17;
        return (short) (i3 + (s17 & (((i3 ^ s17) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(short s16, int i3) {
        int i16 = s16 / i3;
        return ((s16 ^ i3) >= 0 || i3 * i16 == s16) ? i16 : i16 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(short s16, int i3) {
        int i16 = s16 % i3;
        return i16 + (i3 & (((i16 ^ i3) & ((-i16) | i16)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(short s16, long j3) {
        long j16 = s16;
        long j17 = j16 / j3;
        return ((j16 ^ j3) >= 0 || j3 * j17 == j16) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(short s16, long j3) {
        long j16 = s16 % j3;
        return j16 + (j3 & (((j16 ^ j3) & ((-j16) | j16)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i3, byte b16) {
        int i16 = i3 / b16;
        return ((i3 ^ b16) >= 0 || b16 * i16 == i3) ? i16 : i16 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(int i3, byte b16) {
        int i16 = i3 % b16;
        return (byte) (i16 + (b16 & (((i16 ^ b16) & ((-i16) | i16)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i3, short s16) {
        int i16 = i3 / s16;
        return ((i3 ^ s16) >= 0 || s16 * i16 == i3) ? i16 : i16 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(int i3, short s16) {
        int i16 = i3 % s16;
        return (short) (i16 + (s16 & (((i16 ^ s16) & ((-i16) | i16)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int floorDiv(int i3, int i16) {
        int i17 = i3 / i16;
        return ((i3 ^ i16) >= 0 || i16 * i17 == i3) ? i17 : i17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(int i3, int i16) {
        int i17 = i3 % i16;
        return i17 + (i16 & (((i17 ^ i16) & ((-i17) | i17)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(int i3, long j3) {
        long j16 = i3;
        long j17 = j16 / j3;
        return ((j16 ^ j3) >= 0 || j3 * j17 == j16) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(int i3, long j3) {
        long j16 = i3 % j3;
        return j16 + (j3 & (((j16 ^ j3) & ((-j16) | j16)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j3, byte b16) {
        long j16 = b16;
        long j17 = j3 / j16;
        return ((j3 ^ j16) >= 0 || j16 * j17 == j3) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final byte mod(long j3, byte b16) {
        long j16 = j3 % b16;
        return (byte) (j16 + (r0 & (((j16 ^ r0) & ((-j16) | j16)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j3, short s16) {
        long j16 = s16;
        long j17 = j3 / j16;
        return ((j3 ^ j16) >= 0 || j16 * j17 == j3) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final short mod(long j3, short s16) {
        long j16 = j3 % s16;
        return (short) (j16 + (r0 & (((j16 ^ r0) & ((-j16) | j16)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j3, int i3) {
        long j16 = i3;
        long j17 = j3 / j16;
        return ((j3 ^ j16) >= 0 || j16 * j17 == j3) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final int mod(long j3, int i3) {
        long j16 = i3;
        long j17 = j3 % j16;
        return (int) (j17 + (j16 & (((j17 ^ j16) & ((-j17) | j17)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long floorDiv(long j3, long j16) {
        long j17 = j3 / j16;
        return ((j3 ^ j16) >= 0 || j16 * j17 == j3) ? j17 : j17 - 1;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final long mod(long j3, long j16) {
        long j17 = j3 % j16;
        return j17 + (j16 & (((j17 ^ j16) & ((-j17) | j17)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final float mod(float f16, float f17) {
        float f18 = f16 % f17;
        if (f18 == 0.0f) {
            return f18;
        }
        return !(Math.signum(f18) == Math.signum(f17)) ? f18 + f17 : f18;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(float f16, double d16) {
        double d17 = f16 % d16;
        if (d17 == 0.0d) {
            return d17;
        }
        return !(Math.signum(d17) == Math.signum(d16)) ? d17 + d16 : d17;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double d16, float f16) {
        double d17 = f16;
        double d18 = d16 % d17;
        if (d18 == 0.0d) {
            return d18;
        }
        return !(Math.signum(d18) == Math.signum(d17)) ? d18 + d17 : d18;
    }

    @SinceKotlin(version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    private static final double mod(double d16, double d17) {
        double d18 = d16 % d17;
        if (d18 == 0.0d) {
            return d18;
        }
        return !(Math.signum(d18) == Math.signum(d17)) ? d18 + d17 : d18;
    }
}
