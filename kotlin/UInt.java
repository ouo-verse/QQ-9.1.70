package kotlin;

import com.heytap.databaseengine.apiv3.data.Element;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!H\u00d6\u0003\u00a2\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\u0087\b\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\u0087\b\u00a2\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\u0087\b\u00a2\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\u0087\b\u00a2\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\u0087\b\u00a2\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016\u00a2\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006z"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", Element.ELEMENT_NAME_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes28.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    @PublishedApi
    @IntrinsicConstEvaluation
    /* synthetic */ UInt(int i3) {
        this.data = i3;
    }

    @InlineOnly
    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m563andWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 & i16);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m564boximpl(int i3) {
        return new UInt(i3);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m565compareTo7apg3OU(int i3, byte b16) {
        return UnsignedKt.uintCompare(i3, m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m566compareToVKZWuLQ(int i3, long j3) {
        return UnsignedKt.ulongCompare(ULong.m648constructorimpl(i3 & 4294967295L), j3);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m567compareToWZ4Q5Ns(int i3) {
        return UnsignedKt.uintCompare(getData(), i3);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m569compareToxj2QHRw(int i3, short s16) {
        return UnsignedKt.uintCompare(i3, m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m571decpVg5ArA(int i3) {
        return m570constructorimpl(i3 - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m572div7apg3OU(int i3, byte b16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m573divVKZWuLQ(int i3, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(i3 & 4294967295L), j3);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m574divWZ4Q5Ns(int i3, int i16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, i16);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m575divxj2QHRw(int i3, short s16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, m570constructorimpl(s16 & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m576equalsimpl(int i3, Object obj) {
        if (!(obj instanceof UInt) || i3 != ((UInt) obj).getData()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m577equalsimpl0(int i3, int i16) {
        if (i3 == i16) {
            return true;
        }
        return false;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m578floorDiv7apg3OU(int i3, byte b16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m579floorDivVKZWuLQ(int i3, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(i3 & 4294967295L), j3);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m580floorDivWZ4Q5Ns(int i3, int i16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, i16);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m581floorDivxj2QHRw(int i3, short s16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(i3, m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m583incpVg5ArA(int i3) {
        return m570constructorimpl(i3 + 1);
    }

    @InlineOnly
    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m584invpVg5ArA(int i3) {
        return m570constructorimpl(~i3);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m585minus7apg3OU(int i3, byte b16) {
        return m570constructorimpl(i3 - m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m586minusVKZWuLQ(int i3, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(i3 & 4294967295L) - j3);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m587minusWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 - i16);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m588minusxj2QHRw(int i3, short s16) {
        return m570constructorimpl(i3 - m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m589mod7apg3OU(int i3, byte b16) {
        return UByte.m494constructorimpl((byte) UnsignedKt.m824uintRemainderJ1ME1BU(i3, m570constructorimpl(b16 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m590modVKZWuLQ(int i3, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(i3 & 4294967295L), j3);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m591modWZ4Q5Ns(int i3, int i16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(i3, i16);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m592modxj2QHRw(int i3, short s16) {
        return UShort.m754constructorimpl((short) UnsignedKt.m824uintRemainderJ1ME1BU(i3, m570constructorimpl(s16 & 65535)));
    }

    @InlineOnly
    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m593orWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 | i16);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m594plus7apg3OU(int i3, byte b16) {
        return m570constructorimpl(i3 + m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m595plusVKZWuLQ(int i3, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(i3 & 4294967295L) + j3);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m596plusWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 + i16);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m597plusxj2QHRw(int i3, short s16) {
        return m570constructorimpl(i3 + m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m598rangeToWZ4Q5Ns(int i3, int i16) {
        return new UIntRange(i3, i16, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m599rem7apg3OU(int i3, byte b16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(i3, m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m600remVKZWuLQ(int i3, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(i3 & 4294967295L), j3);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m601remWZ4Q5Ns(int i3, int i16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(i3, i16);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m602remxj2QHRw(int i3, short s16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(i3, m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m603shlpVg5ArA(int i3, int i16) {
        return m570constructorimpl(i3 << i16);
    }

    @InlineOnly
    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m604shrpVg5ArA(int i3, int i16) {
        return m570constructorimpl(i3 >>> i16);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m605times7apg3OU(int i3, byte b16) {
        return m570constructorimpl(i3 * m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m606timesVKZWuLQ(int i3, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(i3 & 4294967295L) * j3);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m607timesWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 * i16);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m608timesxj2QHRw(int i3, short s16) {
        return m570constructorimpl(i3 * m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m609toByteimpl(int i3) {
        return (byte) i3;
    }

    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m610toDoubleimpl(int i3) {
        return UnsignedKt.uintToDouble(i3);
    }

    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m611toFloatimpl(int i3) {
        return (float) UnsignedKt.uintToDouble(i3);
    }

    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m613toLongimpl(int i3) {
        return i3 & 4294967295L;
    }

    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m614toShortimpl(int i3) {
        return (short) i3;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m615toStringimpl(int i3) {
        return String.valueOf(i3 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m616toUBytew2LRezQ(int i3) {
        return UByte.m494constructorimpl((byte) i3);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m618toULongsVKNKU(int i3) {
        return ULong.m648constructorimpl(i3 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m619toUShortMh2AYeg(int i3) {
        return UShort.m754constructorimpl((short) i3);
    }

    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m620xorWZ4Q5Ns(int i3, int i16) {
        return m570constructorimpl(i3 ^ i16);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(Object obj) {
        return m576equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m582hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m615toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m568compareToWZ4Q5Ns(int i3, int i16) {
        return UnsignedKt.uintCompare(i3, i16);
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m570constructorimpl(int i3) {
        return i3;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m582hashCodeimpl(int i3) {
        return i3;
    }

    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m612toIntimpl(int i3) {
        return i3;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m617toUIntpVg5ArA(int i3) {
        return i3;
    }
}
