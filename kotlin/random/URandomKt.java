package kotlin.random;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", HippyControllerProps.ARRAY, "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", DownloaderConstant.KEY_RANGE, "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class URandomKt {
    /* renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m1710checkUIntRangeBoundsJ1ME1BU(int i3, int i16) {
        boolean z16;
        if (UnsignedKt.uintCompare(i16, i3) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
        } else {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m564boximpl(i3), UInt.m564boximpl(i16)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m1711checkULongRangeBoundseb3DHEI(long j3, long j16) {
        boolean z16;
        if (UnsignedKt.ulongCompare(j16, j3) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
        } else {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m642boximpl(j3), ULong.m642boximpl(j16)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] nextUBytes(@NotNull Random random, int i3) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UByteArray.m546constructorimpl(random.nextBytes(i3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m1712nextUBytesEVgfTAA(@NotNull Random nextUBytes, @NotNull byte[] array) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array);
        return array;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m1713nextUBytesWvrt4B4(@NotNull Random nextUBytes, @NotNull byte[] array, int i3, int i16) {
        Intrinsics.checkNotNullParameter(nextUBytes, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(array, "array");
        nextUBytes.nextBytes(array, i3, i16);
        return array;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m1714nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = UByteArray.m552getSizeimpl(bArr);
        }
        return m1713nextUBytesWvrt4B4(random, bArr, i3, i16);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return UInt.m570constructorimpl(random.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m1715nextUInta8DCA5k(@NotNull Random nextUInt, int i3, int i16) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        m1710checkUIntRangeBoundsJ1ME1BU(i3, i16);
        return UInt.m570constructorimpl(nextUInt.nextInt(i3 ^ Integer.MIN_VALUE, i16 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m1716nextUIntqCasIEU(@NotNull Random nextUInt, int i3) {
        Intrinsics.checkNotNullParameter(nextUInt, "$this$nextUInt");
        return m1715nextUInta8DCA5k(nextUInt, 0, i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        return ULong.m648constructorimpl(random.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m1717nextULongV1Xi4fY(@NotNull Random nextULong, long j3) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        return m1718nextULongjmpaWc(nextULong, 0L, j3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m1718nextULongjmpaWc(@NotNull Random nextULong, long j3, long j16) {
        Intrinsics.checkNotNullParameter(nextULong, "$this$nextULong");
        m1711checkULongRangeBoundseb3DHEI(j3, j16);
        return ULong.m648constructorimpl(nextULong.nextLong(j3 ^ Long.MIN_VALUE, j16 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(@NotNull Random random, @NotNull UIntRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return UnsignedKt.uintCompare(range.getLast(), -1) < 0 ? m1715nextUInta8DCA5k(random, range.getFirst(), UInt.m570constructorimpl(range.getLast() + 1)) : UnsignedKt.uintCompare(range.getFirst(), 0) > 0 ? UInt.m570constructorimpl(m1715nextUInta8DCA5k(random, UInt.m570constructorimpl(range.getFirst() - 1), range.getLast()) + 1) : nextUInt(random);
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(@NotNull Random random, @NotNull ULongRange range) {
        Intrinsics.checkNotNullParameter(random, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            if (UnsignedKt.ulongCompare(range.getLast(), -1L) < 0) {
                return m1718nextULongjmpaWc(random, range.getFirst(), ULong.m648constructorimpl(range.getLast() + ULong.m648constructorimpl(1 & 4294967295L)));
            }
            if (UnsignedKt.ulongCompare(range.getFirst(), 0L) <= 0) {
                return nextULong(random);
            }
            long j3 = 1 & 4294967295L;
            return ULong.m648constructorimpl(m1718nextULongjmpaWc(random, ULong.m648constructorimpl(range.getFirst() - ULong.m648constructorimpl(j3)), range.getLast()) + ULong.m648constructorimpl(j3));
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }
}
