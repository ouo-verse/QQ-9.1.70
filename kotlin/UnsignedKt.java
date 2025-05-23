package kotlin;

import com.qq.e.comm.managers.plugin.PM;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", PM.BASE, "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "UnsignedKt")
/* loaded from: classes28.dex */
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d16) {
        if (Double.isNaN(d16) || d16 <= uintToDouble(0)) {
            return 0;
        }
        if (d16 >= uintToDouble(-1)) {
            return -1;
        }
        if (d16 <= 2.147483647E9d) {
            return UInt.m570constructorimpl((int) d16);
        }
        return UInt.m570constructorimpl(UInt.m570constructorimpl((int) (d16 - Integer.MAX_VALUE)) + UInt.m570constructorimpl(Integer.MAX_VALUE));
    }

    @PublishedApi
    public static final long doubleToULong(double d16) {
        if (Double.isNaN(d16) || d16 <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d16 >= ulongToDouble(-1L)) {
            return -1L;
        }
        if (d16 < 9.223372036854776E18d) {
            return ULong.m648constructorimpl((long) d16);
        }
        return ULong.m648constructorimpl(ULong.m648constructorimpl((long) (d16 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i3, int i16) {
        return Intrinsics.compare(i3 ^ Integer.MIN_VALUE, i16 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m823uintDivideJ1ME1BU(int i3, int i16) {
        return UInt.m570constructorimpl((int) ((i3 & 4294967295L) / (i16 & 4294967295L)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m824uintRemainderJ1ME1BU(int i3, int i16) {
        return UInt.m570constructorimpl((int) ((i3 & 4294967295L) % (i16 & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int i3) {
        return (Integer.MAX_VALUE & i3) + (((i3 >>> 31) << 30) * 2);
    }

    @PublishedApi
    public static final int ulongCompare(long j3, long j16) {
        return Intrinsics.compare(j3 ^ Long.MIN_VALUE, j16 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m825ulongDivideeb3DHEI(long j3, long j16) {
        if (j16 < 0) {
            if (ulongCompare(j3, j16) < 0) {
                return ULong.m648constructorimpl(0L);
            }
            return ULong.m648constructorimpl(1L);
        }
        if (j3 >= 0) {
            return ULong.m648constructorimpl(j3 / j16);
        }
        int i3 = 1;
        long j17 = ((j3 >>> 1) / j16) << 1;
        if (ulongCompare(ULong.m648constructorimpl(j3 - (j17 * j16)), ULong.m648constructorimpl(j16)) < 0) {
            i3 = 0;
        }
        return ULong.m648constructorimpl(j17 + i3);
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m826ulongRemaindereb3DHEI(long j3, long j16) {
        if (j16 < 0) {
            if (ulongCompare(j3, j16) >= 0) {
                return ULong.m648constructorimpl(j3 - j16);
            }
            return j3;
        }
        if (j3 >= 0) {
            return ULong.m648constructorimpl(j3 % j16);
        }
        long j17 = j3 - ((((j3 >>> 1) / j16) << 1) * j16);
        if (ulongCompare(ULong.m648constructorimpl(j17), ULong.m648constructorimpl(j16)) < 0) {
            j16 = 0;
        }
        return ULong.m648constructorimpl(j17 - j16);
    }

    @PublishedApi
    public static final double ulongToDouble(long j3) {
        return ((j3 >>> 11) * 2048) + (j3 & 2047);
    }

    @NotNull
    public static final String ulongToString(long j3) {
        return ulongToString(j3, 10);
    }

    @NotNull
    public static final String ulongToString(long j3, int i3) {
        int checkRadix;
        int checkRadix2;
        int checkRadix3;
        if (j3 >= 0) {
            checkRadix3 = CharsKt__CharJVMKt.checkRadix(i3);
            String l3 = Long.toString(j3, checkRadix3);
            Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
            return l3;
        }
        long j16 = i3;
        long j17 = ((j3 >>> 1) / j16) << 1;
        long j18 = j3 - (j17 * j16);
        if (j18 >= j16) {
            j18 -= j16;
            j17++;
        }
        StringBuilder sb5 = new StringBuilder();
        checkRadix = CharsKt__CharJVMKt.checkRadix(i3);
        String l16 = Long.toString(j17, checkRadix);
        Intrinsics.checkNotNullExpressionValue(l16, "toString(this, checkRadix(radix))");
        sb5.append(l16);
        checkRadix2 = CharsKt__CharJVMKt.checkRadix(i3);
        String l17 = Long.toString(j18, checkRadix2);
        Intrinsics.checkNotNullExpressionValue(l17, "toString(this, checkRadix(radix))");
        sb5.append(l17);
        return sb5.toString();
    }
}
