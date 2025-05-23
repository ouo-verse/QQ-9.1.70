package kotlin.ranges;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010B\u001a\u0014\u0010C\u001a\u00020\u0005*\u000208H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001a\u0014\u0010C\u001a\u00020\b*\u00020>H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010E\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010G\u001a\u00020\u0005*\u000208H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010D\u001a\u0014\u0010G\u001a\u00020\b*\u00020>H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010E\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u00f8\u0001\u0000\u001a\u0011\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u00f8\u0001\u0000\u001a\u0015\u0010I\u001a\u00020\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010J\u001a\u001c\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010L\u001a\u0015\u0010I\u001a\u00020\b*\u00020/H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010M\u001a\u001c\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010N\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u001a\u0012\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\b\u00f8\u0001\u0000\u001a\u0019\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u00f8\u0001\u0000\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010R\u001a\u001f\u0010P\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010T\u001a\u001f\u0010P\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bU\u0010V\u001a\u001f\u0010P\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bW\u0010X\u001a\f\u0010Y\u001a\u000208*\u000208H\u0007\u001a\f\u0010Y\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Z\u001a\u000208*\u0002082\u0006\u0010Z\u001a\u00020[H\u0087\u0004\u001a\u0015\u0010Z\u001a\u00020>*\u00020>2\u0006\u0010Z\u001a\u00020\\H\u0087\u0004\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u0010R\u001a\u001f\u0010]\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b_\u0010T\u001a\u001f\u0010]\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b`\u0010V\u001a\u001f\u0010]\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\ba\u0010X\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006b"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", DownloaderConstant.KEY_RANGE, "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", DTConstants.TAG.ELEMENT, "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "rangeUntil", "rangeUntil-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "reversed", "step", "", "", "until", "until-Kr8caGY", "until-J1ME1BU", "until-eb3DHEI", "until-5PvTz6A", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes28.dex */
class URangesKt___URangesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m1737coerceAtLeast5PvTz6A(short s16, short s17) {
        if (Intrinsics.compare(s16 & 65535, 65535 & s17) < 0) {
            return s17;
        }
        return s16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m1738coerceAtLeastJ1ME1BU(int i3, int i16) {
        if (UnsignedKt.uintCompare(i3, i16) < 0) {
            return i16;
        }
        return i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m1739coerceAtLeastKr8caGY(byte b16, byte b17) {
        if (Intrinsics.compare(b16 & 255, b17 & 255) < 0) {
            return b17;
        }
        return b16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m1740coerceAtLeasteb3DHEI(long j3, long j16) {
        if (UnsignedKt.ulongCompare(j3, j16) < 0) {
            return j16;
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m1741coerceAtMost5PvTz6A(short s16, short s17) {
        if (Intrinsics.compare(s16 & 65535, 65535 & s17) > 0) {
            return s17;
        }
        return s16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m1742coerceAtMostJ1ME1BU(int i3, int i16) {
        if (UnsignedKt.uintCompare(i3, i16) > 0) {
            return i16;
        }
        return i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m1743coerceAtMostKr8caGY(byte b16, byte b17) {
        if (Intrinsics.compare(b16 & 255, b17 & 255) > 0) {
            return b17;
        }
        return b16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m1744coerceAtMosteb3DHEI(long j3, long j16) {
        if (UnsignedKt.ulongCompare(j3, j16) > 0) {
            return j16;
        }
        return j3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m1745coerceInJPwROB0(long j3, @NotNull ClosedRange<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m642boximpl(j3), (ClosedFloatingPointRange<ULong>) range)).getData();
        }
        if (!range.isEmpty()) {
            if (UnsignedKt.ulongCompare(j3, range.getStart().getData()) < 0) {
                return range.getStart().getData();
            }
            if (UnsignedKt.ulongCompare(j3, range.getEndInclusive().getData()) > 0) {
                return range.getEndInclusive().getData();
            }
            return j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m1746coerceInVKSA0NQ(short s16, short s17, short s18) {
        int i3 = s17 & 65535;
        int i16 = s18 & 65535;
        if (Intrinsics.compare(i3, i16) <= 0) {
            int i17 = 65535 & s16;
            if (Intrinsics.compare(i17, i3) < 0) {
                return s17;
            }
            if (Intrinsics.compare(i17, i16) > 0) {
                return s18;
            }
            return s16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m797toStringimpl(s18)) + " is less than minimum " + ((Object) UShort.m797toStringimpl(s17)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m1747coerceInWZ9TVnA(int i3, int i16, int i17) {
        if (UnsignedKt.uintCompare(i16, i17) <= 0) {
            if (UnsignedKt.uintCompare(i3, i16) < 0) {
                return i16;
            }
            if (UnsignedKt.uintCompare(i3, i17) > 0) {
                return i17;
            }
            return i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m615toStringimpl(i17)) + " is less than minimum " + ((Object) UInt.m615toStringimpl(i16)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m1748coerceInb33U2AM(byte b16, byte b17, byte b18) {
        int i3 = b17 & 255;
        int i16 = b18 & 255;
        if (Intrinsics.compare(i3, i16) <= 0) {
            int i17 = b16 & 255;
            if (Intrinsics.compare(i17, i3) < 0) {
                return b17;
            }
            if (Intrinsics.compare(i17, i16) > 0) {
                return b18;
            }
            return b16;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m537toStringimpl(b18)) + " is less than minimum " + ((Object) UByte.m537toStringimpl(b17)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m1749coerceInsambcqE(long j3, long j16, long j17) {
        if (UnsignedKt.ulongCompare(j16, j17) <= 0) {
            if (UnsignedKt.ulongCompare(j3, j16) < 0) {
                return j16;
            }
            if (UnsignedKt.ulongCompare(j3, j17) > 0) {
                return j17;
            }
            return j3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m693toStringimpl(j17)) + " is less than minimum " + ((Object) ULong.m693toStringimpl(j16)) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m1750coerceInwuiCnnA(int i3, @NotNull ClosedRange<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m564boximpl(i3), (ClosedFloatingPointRange<UInt>) range)).getData();
        }
        if (!range.isEmpty()) {
            if (UnsignedKt.uintCompare(i3, range.getStart().getData()) < 0) {
                return range.getStart().getData();
            }
            if (UnsignedKt.uintCompare(i3, range.getEndInclusive().getData()) > 0) {
                return range.getEndInclusive().getData();
            }
            return i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m1751contains68kG9v0(@NotNull UIntRange contains, byte b16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1724containsWZ4Q5Ns(UInt.m570constructorimpl(b16 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m1752containsGYNo2lE(ULongRange contains, ULong uLong) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (uLong != null && contains.m1733containsVKZWuLQ(uLong.getData())) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m1753containsGab390E(@NotNull ULongRange contains, int i3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1733containsVKZWuLQ(ULong.m648constructorimpl(i3 & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m1754containsULbyJY(@NotNull ULongRange contains, byte b16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1733containsVKZWuLQ(ULong.m648constructorimpl(b16 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m1755containsZsK3CEQ(@NotNull UIntRange contains, short s16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1724containsWZ4Q5Ns(UInt.m570constructorimpl(s16 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m1756containsbiwQdVI(UIntRange contains, UInt uInt) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (uInt != null && contains.m1724containsWZ4Q5Ns(uInt.getData())) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m1757containsfz5IDCE(@NotNull UIntRange contains, long j3) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        if (ULong.m648constructorimpl(j3 >>> 32) == 0 && contains.m1724containsWZ4Q5Ns(UInt.m570constructorimpl((int) j3))) {
            return true;
        }
        return false;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m1758containsuhHAxoY(@NotNull ULongRange contains, short s16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1733containsVKZWuLQ(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m1759downTo5PvTz6A(short s16, short s17) {
        return UIntProgression.INSTANCE.m1721fromClosedRangeNkh28Cs(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m1760downToJ1ME1BU(int i3, int i16) {
        return UIntProgression.INSTANCE.m1721fromClosedRangeNkh28Cs(i3, i16, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m1761downToKr8caGY(byte b16, byte b17) {
        return UIntProgression.INSTANCE.m1721fromClosedRangeNkh28Cs(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m1762downToeb3DHEI(long j3, long j16) {
        return ULongProgression.INSTANCE.m1730fromClosedRange7ftBX0g(j3, j16, -1L);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt firstOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m564boximpl(uIntProgression.getFirst());
    }

    @SinceKotlin(version = "1.7")
    public static final int last(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt lastOrNull(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.m564boximpl(uIntProgression.getLast());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int random(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return random(uIntRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final UInt randomOrNull(UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        return randomOrNull(uIntRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-5PvTz6A, reason: not valid java name */
    private static final UIntRange m1763rangeUntil5PvTz6A(short s16, short s17) {
        return m1767until5PvTz6A(s16, s17);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-J1ME1BU, reason: not valid java name */
    private static final UIntRange m1764rangeUntilJ1ME1BU(int i3, int i16) {
        return m1768untilJ1ME1BU(i3, i16);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-Kr8caGY, reason: not valid java name */
    private static final UIntRange m1765rangeUntilKr8caGY(byte b16, byte b17) {
        return m1769untilKr8caGY(b16, b17);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rangeUntil-eb3DHEI, reason: not valid java name */
    private static final ULongRange m1766rangeUntileb3DHEI(long j3, long j16) {
        return m1770untileb3DHEI(j3, j16);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression reversed(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return UIntProgression.INSTANCE.m1721fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final UIntProgression step(@NotNull UIntProgression uIntProgression, int i3) {
        Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(i3 > 0, Integer.valueOf(i3));
        UIntProgression.Companion companion = UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i3 = -i3;
        }
        return companion.m1721fromClosedRangeNkh28Cs(first, last, i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m1767until5PvTz6A(short s16, short s17) {
        if (Intrinsics.compare(s17 & 65535, 0) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(UInt.m570constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static final UIntRange m1768untilJ1ME1BU(int i3, int i16) {
        if (UnsignedKt.uintCompare(i16, 0) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(i3, UInt.m570constructorimpl(i16 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m1769untilKr8caGY(byte b16, byte b17) {
        if (Intrinsics.compare(b17 & 255, 0) <= 0) {
            return UIntRange.INSTANCE.getEMPTY();
        }
        return new UIntRange(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(UInt.m570constructorimpl(r3) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static final ULongRange m1770untileb3DHEI(long j3, long j16) {
        if (UnsignedKt.ulongCompare(j16, 0L) <= 0) {
            return ULongRange.INSTANCE.getEMPTY();
        }
        return new ULongRange(j3, ULong.m648constructorimpl(j16 - ULong.m648constructorimpl(1 & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong firstOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m642boximpl(uLongProgression.getFirst());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong lastOrNull(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.m642boximpl(uLongProgression.getLast());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long random(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return random(uLongRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final ULong randomOrNull(ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        return randomOrNull(uLongRange, Random.INSTANCE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression reversed(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return ULongProgression.INSTANCE.m1730fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final UInt randomOrNull(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m564boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @NotNull
    public static final ULongProgression step(@NotNull ULongProgression uLongProgression, long j3) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        RangesKt__RangesKt.checkStepIsPositive(j3 > 0, Long.valueOf(j3));
        ULongProgression.Companion companion = ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j3 = -j3;
        }
        return companion.m1730fromClosedRange7ftBX0g(first, last, j3);
    }

    @SinceKotlin(version = "1.7")
    public static final long first(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getFirst();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getLast();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e16) {
            throw new NoSuchElementException(e16.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @Nullable
    public static final ULong randomOrNull(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m642boximpl(URandomKt.nextULong(random, uLongRange));
    }
}
