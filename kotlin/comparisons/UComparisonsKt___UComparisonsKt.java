package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes28.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m1677maxOf5PvTz6A(short s16, short s17) {
        if (Intrinsics.compare(s16 & 65535, 65535 & s17) < 0) {
            return s17;
        }
        return s16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m1678maxOfJ1ME1BU(int i3, int i16) {
        if (UnsignedKt.uintCompare(i3, i16) < 0) {
            return i16;
        }
        return i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m1679maxOfKr8caGY(byte b16, byte b17) {
        if (Intrinsics.compare(b16 & 255, b17 & 255) < 0) {
            return b17;
        }
        return b16;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m1680maxOfMd2H83M(int i3, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m630getSizeimpl = UIntArray.m630getSizeimpl(other);
        for (int i16 = 0; i16 < m630getSizeimpl; i16++) {
            i3 = m1678maxOfJ1ME1BU(i3, UIntArray.m629getpVg5ArA(other, i16));
        }
        return i3;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m1681maxOfR03FKyM(long j3, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m708getSizeimpl = ULongArray.m708getSizeimpl(other);
        for (int i3 = 0; i3 < m708getSizeimpl; i3++) {
            j3 = m1686maxOfeb3DHEI(j3, ULongArray.m707getsVKNKU(other, i3));
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m1682maxOfVKSA0NQ(short s16, short s17, short s18) {
        return m1677maxOf5PvTz6A(s16, m1677maxOf5PvTz6A(s17, s18));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m1683maxOfWZ9TVnA(int i3, int i16, int i17) {
        int m1678maxOfJ1ME1BU;
        int m1678maxOfJ1ME1BU2;
        m1678maxOfJ1ME1BU = m1678maxOfJ1ME1BU(i16, i17);
        m1678maxOfJ1ME1BU2 = m1678maxOfJ1ME1BU(i3, m1678maxOfJ1ME1BU);
        return m1678maxOfJ1ME1BU2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1684maxOfWr6uiD8(byte b16, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m552getSizeimpl = UByteArray.m552getSizeimpl(other);
        for (int i3 = 0; i3 < m552getSizeimpl; i3++) {
            b16 = m1679maxOfKr8caGY(b16, UByteArray.m551getw2LRezQ(other, i3));
        }
        return b16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m1685maxOfb33U2AM(byte b16, byte b17, byte b18) {
        return m1679maxOfKr8caGY(b16, m1679maxOfKr8caGY(b17, b18));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m1686maxOfeb3DHEI(long j3, long j16) {
        if (UnsignedKt.ulongCompare(j3, j16) < 0) {
            return j16;
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m1687maxOfsambcqE(long j3, long j16, long j17) {
        long m1686maxOfeb3DHEI;
        long m1686maxOfeb3DHEI2;
        m1686maxOfeb3DHEI = m1686maxOfeb3DHEI(j16, j17);
        m1686maxOfeb3DHEI2 = m1686maxOfeb3DHEI(j3, m1686maxOfeb3DHEI);
        return m1686maxOfeb3DHEI2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m1688maxOft1qELG4(short s16, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m812getSizeimpl = UShortArray.m812getSizeimpl(other);
        for (int i3 = 0; i3 < m812getSizeimpl; i3++) {
            s16 = m1677maxOf5PvTz6A(s16, UShortArray.m811getMh2AYeg(other, i3));
        }
        return s16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m1689minOf5PvTz6A(short s16, short s17) {
        if (Intrinsics.compare(s16 & 65535, 65535 & s17) > 0) {
            return s17;
        }
        return s16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m1690minOfJ1ME1BU(int i3, int i16) {
        if (UnsignedKt.uintCompare(i3, i16) > 0) {
            return i16;
        }
        return i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m1691minOfKr8caGY(byte b16, byte b17) {
        if (Intrinsics.compare(b16 & 255, b17 & 255) > 0) {
            return b17;
        }
        return b16;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m1692minOfMd2H83M(int i3, @NotNull int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m630getSizeimpl = UIntArray.m630getSizeimpl(other);
        for (int i16 = 0; i16 < m630getSizeimpl; i16++) {
            i3 = m1690minOfJ1ME1BU(i3, UIntArray.m629getpVg5ArA(other, i16));
        }
        return i3;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m1693minOfR03FKyM(long j3, @NotNull long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m708getSizeimpl = ULongArray.m708getSizeimpl(other);
        for (int i3 = 0; i3 < m708getSizeimpl; i3++) {
            j3 = m1698minOfeb3DHEI(j3, ULongArray.m707getsVKNKU(other, i3));
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m1694minOfVKSA0NQ(short s16, short s17, short s18) {
        return m1689minOf5PvTz6A(s16, m1689minOf5PvTz6A(s17, s18));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m1695minOfWZ9TVnA(int i3, int i16, int i17) {
        int m1690minOfJ1ME1BU;
        int m1690minOfJ1ME1BU2;
        m1690minOfJ1ME1BU = m1690minOfJ1ME1BU(i16, i17);
        m1690minOfJ1ME1BU2 = m1690minOfJ1ME1BU(i3, m1690minOfJ1ME1BU);
        return m1690minOfJ1ME1BU2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1696minOfWr6uiD8(byte b16, @NotNull byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m552getSizeimpl = UByteArray.m552getSizeimpl(other);
        for (int i3 = 0; i3 < m552getSizeimpl; i3++) {
            b16 = m1691minOfKr8caGY(b16, UByteArray.m551getw2LRezQ(other, i3));
        }
        return b16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m1697minOfb33U2AM(byte b16, byte b17, byte b18) {
        return m1691minOfKr8caGY(b16, m1691minOfKr8caGY(b17, b18));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m1698minOfeb3DHEI(long j3, long j16) {
        if (UnsignedKt.ulongCompare(j3, j16) > 0) {
            return j16;
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m1699minOfsambcqE(long j3, long j16, long j17) {
        long m1698minOfeb3DHEI;
        long m1698minOfeb3DHEI2;
        m1698minOfeb3DHEI = m1698minOfeb3DHEI(j16, j17);
        m1698minOfeb3DHEI2 = m1698minOfeb3DHEI(j3, m1698minOfeb3DHEI);
        return m1698minOfeb3DHEI2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m1700minOft1qELG4(short s16, @NotNull short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m812getSizeimpl = UShortArray.m812getSizeimpl(other);
        for (int i3 = 0; i3 < m812getSizeimpl; i3++) {
            s16 = m1689minOf5PvTz6A(s16, UShortArray.m811getMh2AYeg(other, i3));
        }
        return s16;
    }
}
