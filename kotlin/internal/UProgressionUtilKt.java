package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1702differenceModuloWZ9TVnA(int i3, int i16, int i17) {
        int m824uintRemainderJ1ME1BU = UnsignedKt.m824uintRemainderJ1ME1BU(i3, i17);
        int m824uintRemainderJ1ME1BU2 = UnsignedKt.m824uintRemainderJ1ME1BU(i16, i17);
        int uintCompare = UnsignedKt.uintCompare(m824uintRemainderJ1ME1BU, m824uintRemainderJ1ME1BU2);
        int m570constructorimpl = UInt.m570constructorimpl(m824uintRemainderJ1ME1BU - m824uintRemainderJ1ME1BU2);
        if (uintCompare < 0) {
            return UInt.m570constructorimpl(m570constructorimpl + i17);
        }
        return m570constructorimpl;
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1703differenceModulosambcqE(long j3, long j16, long j17) {
        long m826ulongRemaindereb3DHEI = UnsignedKt.m826ulongRemaindereb3DHEI(j3, j17);
        long m826ulongRemaindereb3DHEI2 = UnsignedKt.m826ulongRemaindereb3DHEI(j16, j17);
        int ulongCompare = UnsignedKt.ulongCompare(m826ulongRemaindereb3DHEI, m826ulongRemaindereb3DHEI2);
        long m648constructorimpl = ULong.m648constructorimpl(m826ulongRemaindereb3DHEI - m826ulongRemaindereb3DHEI2);
        if (ulongCompare < 0) {
            return ULong.m648constructorimpl(m648constructorimpl + j17);
        }
        return m648constructorimpl;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1704getProgressionLastElement7ftBX0g(long j3, long j16, long j17) {
        if (j17 > 0) {
            if (UnsignedKt.ulongCompare(j3, j16) < 0) {
                return ULong.m648constructorimpl(j16 - m1703differenceModulosambcqE(j16, j3, ULong.m648constructorimpl(j17)));
            }
            return j16;
        }
        if (j17 < 0) {
            if (UnsignedKt.ulongCompare(j3, j16) > 0) {
                return ULong.m648constructorimpl(j16 + m1703differenceModulosambcqE(j3, j16, ULong.m648constructorimpl(-j17)));
            }
            return j16;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1705getProgressionLastElementNkh28Cs(int i3, int i16, int i17) {
        if (i17 > 0) {
            if (UnsignedKt.uintCompare(i3, i16) < 0) {
                return UInt.m570constructorimpl(i16 - m1702differenceModuloWZ9TVnA(i16, i3, UInt.m570constructorimpl(i17)));
            }
            return i16;
        }
        if (i17 < 0) {
            if (UnsignedKt.uintCompare(i3, i16) > 0) {
                return UInt.m570constructorimpl(i16 + m1702differenceModuloWZ9TVnA(i3, i16, UInt.m570constructorimpl(-i17)));
            }
            return i16;
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
