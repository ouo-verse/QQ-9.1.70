package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0019\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a-\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0005\u001a5\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\u0007\u001a9\u0010\u0017\u001a\u0002H\u0001\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0003\u001a\u0002H\u00012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\t\"\u0002H\u0001H\u0007\u00a2\u0006\u0002\u0010\n\u001a\u0019\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0087\b\u001a!\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\n\u0010\b\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\n\u0010\b\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00112\n\u0010\b\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0013H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0013H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00132\n\u0010\b\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\b\u001a!\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\n\u0010\b\u001a\u00020\u0016\"\u00020\u0015H\u0007\u00a8\u0006\u0018"}, d2 = {"maxOf", "T", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "other", "", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes28.dex */
public class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static <T extends Comparable<? super T>> T maxOf(@NotNull T a16, @NotNull T b16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        return a16.compareTo(b16) >= 0 ? a16 : b16;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T a16, @NotNull T b16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        return a16.compareTo(b16) <= 0 ? a16 : b16;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b16, byte b17) {
        return (byte) Math.max((int) b16, (int) b17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b16, byte b17) {
        return (byte) Math.min((int) b16, (int) b17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s16, short s17) {
        return (short) Math.max((int) s16, (int) s17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s16, short s17) {
        return (short) Math.min((int) s16, (int) s17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i3, int i16) {
        return Math.max(i3, i16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i3, int i16) {
        return Math.min(i3, i16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j3, long j16) {
        return Math.max(j3, j16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j3, long j16) {
        return Math.min(j3, j16);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f16, float f17) {
        return Math.max(f16, f17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f16, float f17) {
        return Math.min(f16, f17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d16, double d17) {
        return Math.max(d16, d17);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d16, double d17) {
        return Math.min(d16, d17);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T a16, @NotNull T b16, @NotNull T c16) {
        Comparable maxOf;
        Comparable maxOf2;
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        Intrinsics.checkNotNullParameter(c16, "c");
        maxOf = maxOf(b16, c16);
        maxOf2 = maxOf(a16, maxOf);
        return (T) maxOf2;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T a16, @NotNull T b16, @NotNull T c16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        Intrinsics.checkNotNullParameter(c16, "c");
        return (T) minOf(a16, minOf(b16, c16));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b16, byte b17, byte b18) {
        return (byte) Math.max((int) b16, Math.max((int) b17, (int) b18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b16, byte b17, byte b18) {
        return (byte) Math.min((int) b16, Math.min((int) b17, (int) b18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s16, short s17, short s18) {
        return (short) Math.max((int) s16, Math.max((int) s17, (int) s18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s16, short s17, short s18) {
        return (short) Math.min((int) s16, Math.min((int) s17, (int) s18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i3, int i16, int i17) {
        return Math.max(i3, Math.max(i16, i17));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i3, int i16, int i17) {
        return Math.min(i3, Math.min(i16, i17));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j3, long j16, long j17) {
        return Math.max(j3, Math.max(j16, j17));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j3, long j16, long j17) {
        return Math.min(j3, Math.min(j16, j17));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f16, float f17, float f18) {
        return Math.max(f16, Math.max(f17, f18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f16, float f17, float f18) {
        return Math.min(f16, Math.min(f17, f18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d16, double d17, double d18) {
        return Math.max(d16, Math.max(d17, d18));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d16, double d17, double d18) {
        return Math.min(d16, Math.min(d17, d18));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T a16, @NotNull T... other) {
        Comparable maxOf;
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t16 : other) {
            maxOf = maxOf(a16, t16);
            a16 = (T) maxOf;
        }
        return a16;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T a16, @NotNull T... other) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(other, "other");
        for (T t16 : other) {
            a16 = (T) minOf(a16, t16);
        }
        return a16;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b16, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b17 : other) {
            b16 = (byte) Math.max((int) b16, (int) b17);
        }
        return b16;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b16, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (byte b17 : other) {
            b16 = (byte) Math.min((int) b16, (int) b17);
        }
        return b16;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s16, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s17 : other) {
            s16 = (short) Math.max((int) s16, (int) s17);
        }
        return s16;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s16, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (short s17 : other) {
            s16 = (short) Math.min((int) s16, (int) s17);
        }
        return s16;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i3, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i16 : other) {
            i3 = Math.max(i3, i16);
        }
        return i3;
    }

    @SinceKotlin(version = "1.4")
    public static int minOf(int i3, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i16 : other) {
            i3 = Math.min(i3, i16);
        }
        return i3;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j3, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j16 : other) {
            j3 = Math.max(j3, j16);
        }
        return j3;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j3, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (long j16 : other) {
            j3 = Math.min(j3, j16);
        }
        return j3;
    }

    @SinceKotlin(version = "1.4")
    public static float maxOf(float f16, @NotNull float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f17 : other) {
            f16 = Math.max(f16, f17);
        }
        return f16;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float f16, @NotNull float... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (float f17 : other) {
            f16 = Math.min(f16, f17);
        }
        return f16;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d16, @NotNull double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d17 : other) {
            d16 = Math.max(d16, d17);
        }
        return d16;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d16, @NotNull double... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (double d17 : other) {
            d16 = Math.min(d16, d17);
        }
        return d16;
    }
}
