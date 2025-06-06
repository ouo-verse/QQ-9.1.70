package kotlin;

import com.heytap.databaseengine.apiv3.data.Element;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u0012J\u001b\u0010H\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u000fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u0012J\u001b\u0010M\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b\u00a2\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b]\u0010-J\u0010\u0010^\u001a\u00020_H\u0087\b\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b\u00a2\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020gH\u0016\u00a2\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bk\u0010\u0005J\u0016\u0010l\u001a\u00020\u0010H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0013H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010aJ\u0016\u0010p\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010eJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006u"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Element.ELEMENT_NAME_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes28.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @PublishedApi
    @IntrinsicConstEvaluation
    /* synthetic */ UByte(byte b16) {
        this.data = b16;
    }

    @InlineOnly
    /* renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m487and7apg3OU(byte b16, byte b17) {
        return m494constructorimpl((byte) (b16 & b17));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m488boximpl(byte b16) {
        return new UByte(b16);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m489compareTo7apg3OU(byte b16) {
        return Intrinsics.compare(getData() & 255, b16 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m491compareToVKZWuLQ(byte b16, long j3) {
        return UnsignedKt.ulongCompare(ULong.m648constructorimpl(b16 & 255), j3);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m492compareToWZ4Q5Ns(byte b16, int i3) {
        return UnsignedKt.uintCompare(UInt.m570constructorimpl(b16 & 255), i3);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m493compareToxj2QHRw(byte b16, short s16) {
        return Intrinsics.compare(b16 & 255, s16 & 65535);
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m495decw2LRezQ(byte b16) {
        return m494constructorimpl((byte) (b16 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m496div7apg3OU(byte b16, byte b17) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m497divVKZWuLQ(byte b16, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(b16 & 255), j3);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m498divWZ4Q5Ns(byte b16, int i3) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), i3);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m499divxj2QHRw(byte b16, short s16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(s16 & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m500equalsimpl(byte b16, Object obj) {
        if (!(obj instanceof UByte) || b16 != ((UByte) obj).getData()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m501equalsimpl0(byte b16, byte b17) {
        if (b16 == b17) {
            return true;
        }
        return false;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m502floorDiv7apg3OU(byte b16, byte b17) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m503floorDivVKZWuLQ(byte b16, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(b16 & 255), j3);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m504floorDivWZ4Q5Ns(byte b16, int i3) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), i3);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m505floorDivxj2QHRw(byte b16, short s16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m507incw2LRezQ(byte b16) {
        return m494constructorimpl((byte) (b16 + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m508invw2LRezQ(byte b16) {
        return m494constructorimpl((byte) (~b16));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m509minus7apg3OU(byte b16, byte b17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) - UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m510minusVKZWuLQ(byte b16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(b16 & 255) - j3);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m511minusWZ4Q5Ns(byte b16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) - i3);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m512minusxj2QHRw(byte b16, short s16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) - UInt.m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m513mod7apg3OU(byte b16, byte b17) {
        return m494constructorimpl((byte) UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m514modVKZWuLQ(byte b16, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(b16 & 255), j3);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m515modWZ4Q5Ns(byte b16, int i3) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), i3);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m516modxj2QHRw(byte b16, short s16) {
        return UShort.m754constructorimpl((short) UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(s16 & 65535)));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m517or7apg3OU(byte b16, byte b17) {
        return m494constructorimpl((byte) (b16 | b17));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m518plus7apg3OU(byte b16, byte b17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) + UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m519plusVKZWuLQ(byte b16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(b16 & 255) + j3);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m520plusWZ4Q5Ns(byte b16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) + i3);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m521plusxj2QHRw(byte b16, short s16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) + UInt.m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m522rangeTo7apg3OU(byte b16, byte b17) {
        return new UIntRange(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m523rem7apg3OU(byte b16, byte b17) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m524remVKZWuLQ(byte b16, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(b16 & 255), j3);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m525remWZ4Q5Ns(byte b16, int i3) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), i3);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m526remxj2QHRw(byte b16, short s16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(b16 & 255), UInt.m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m527times7apg3OU(byte b16, byte b17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) * UInt.m570constructorimpl(b17 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m528timesVKZWuLQ(byte b16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(b16 & 255) * j3);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m529timesWZ4Q5Ns(byte b16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) * i3);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m530timesxj2QHRw(byte b16, short s16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(b16 & 255) * UInt.m570constructorimpl(s16 & 65535));
    }

    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m532toDoubleimpl(byte b16) {
        return b16 & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m533toFloatimpl(byte b16) {
        return b16 & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m534toIntimpl(byte b16) {
        return b16 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m535toLongimpl(byte b16) {
        return b16 & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m536toShortimpl(byte b16) {
        return (short) (b16 & 255);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m537toStringimpl(byte b16) {
        return String.valueOf(b16 & 255);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m539toUIntpVg5ArA(byte b16) {
        return UInt.m570constructorimpl(b16 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m540toULongsVKNKU(byte b16) {
        return ULong.m648constructorimpl(b16 & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m541toUShortMh2AYeg(byte b16) {
        return UShort.m754constructorimpl((short) (b16 & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m542xor7apg3OU(byte b16, byte b17) {
        return m494constructorimpl((byte) (b16 ^ b17));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & 255, uByte.getData() & 255);
    }

    public boolean equals(Object obj) {
        return m500equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m506hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m537toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m490compareTo7apg3OU(byte b16, byte b17) {
        return Intrinsics.compare(b16 & 255, b17 & 255);
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m494constructorimpl(byte b16) {
        return b16;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m506hashCodeimpl(byte b16) {
        return b16;
    }

    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m531toByteimpl(byte b16) {
        return b16;
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m538toUBytew2LRezQ(byte b16) {
        return b16;
    }
}
