package kotlin;

import com.heytap.databaseengine.apiv3.data.Element;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001tB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#H\u00d6\u0003\u00a2\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010\u0010J\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bJ\u0010\u0013J\u001b\u0010H\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010\u001fJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u0018J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u0010J\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\u0013J\u001b\u0010M\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bP\u0010\u001fJ\u001b\u0010M\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bQ\u0010\u0018J\u0010\u0010R\u001a\u00020SH\u0087\b\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b\u00a2\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\be\u0010\u0005J\u000f\u0010f\u001a\u00020gH\u0016\u00a2\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bk\u0010UJ\u0016\u0010l\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bm\u0010-J\u0016\u0010n\u001a\u00020\u0014H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bo\u0010cJ\u0016\u0010p\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bq\u0010\u0005J\u001b\u0010r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006u"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", Element.ELEMENT_NAME_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes28.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @PublishedApi
    @IntrinsicConstEvaluation
    /* synthetic */ UShort(short s16) {
        this.data = s16;
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m747andxj2QHRw(short s16, short s17) {
        return m754constructorimpl((short) (s16 & s17));
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m748boximpl(short s16) {
        return new UShort(s16);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m749compareTo7apg3OU(short s16, byte b16) {
        return Intrinsics.compare(s16 & 65535, b16 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m750compareToVKZWuLQ(short s16, long j3) {
        return UnsignedKt.ulongCompare(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j3);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m751compareToWZ4Q5Ns(short s16, int i3) {
        return UnsignedKt.uintCompare(UInt.m570constructorimpl(s16 & 65535), i3);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m752compareToxj2QHRw(short s16) {
        return Intrinsics.compare(getData() & 65535, s16 & 65535);
    }

    @InlineOnly
    /* renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m755decMh2AYeg(short s16) {
        return m754constructorimpl((short) (s16 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m756div7apg3OU(short s16, byte b16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m757divVKZWuLQ(short s16, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j3);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m758divWZ4Q5Ns(short s16, int i3) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), i3);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m759divxj2QHRw(short s16, short s17) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m760equalsimpl(short s16, Object obj) {
        if (!(obj instanceof UShort) || s16 != ((UShort) obj).getData()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m761equalsimpl0(short s16, short s17) {
        if (s16 == s17) {
            return true;
        }
        return false;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m762floorDiv7apg3OU(short s16, byte b16) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m763floorDivVKZWuLQ(short s16, long j3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j3);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m764floorDivWZ4Q5Ns(short s16, int i3) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), i3);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m765floorDivxj2QHRw(short s16, short s17) {
        return UnsignedKt.m823uintDivideJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535));
    }

    @InlineOnly
    /* renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m767incMh2AYeg(short s16) {
        return m754constructorimpl((short) (s16 + 1));
    }

    @InlineOnly
    /* renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m768invMh2AYeg(short s16) {
        return m754constructorimpl((short) (~s16));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m769minus7apg3OU(short s16, byte b16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) - UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m770minusVKZWuLQ(short s16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j3);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m771minusWZ4Q5Ns(short s16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) - i3);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m772minusxj2QHRw(short s16, short s17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) - UInt.m570constructorimpl(s17 & 65535));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m773mod7apg3OU(short s16, byte b16) {
        return UByte.m494constructorimpl((byte) UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(b16 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m774modVKZWuLQ(short s16, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j3);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m775modWZ4Q5Ns(short s16, int i3) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), i3);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m776modxj2QHRw(short s16, short s17) {
        return m754constructorimpl((short) UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535)));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m777orxj2QHRw(short s16, short s17) {
        return m754constructorimpl((short) (s16 | s17));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m778plus7apg3OU(short s16, byte b16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) + UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m779plusVKZWuLQ(short s16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j3);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m780plusWZ4Q5Ns(short s16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) + i3);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m781plusxj2QHRw(short s16, short s17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) + UInt.m570constructorimpl(s17 & 65535));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m782rangeToxj2QHRw(short s16, short s17) {
        return new UIntRange(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m783rem7apg3OU(short s16, byte b16) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m784remVKZWuLQ(short s16, long j3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j3);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m785remWZ4Q5Ns(short s16, int i3) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), i3);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m786remxj2QHRw(short s16, short s17) {
        return UnsignedKt.m824uintRemainderJ1ME1BU(UInt.m570constructorimpl(s16 & 65535), UInt.m570constructorimpl(s17 & 65535));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m787times7apg3OU(short s16, byte b16) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) * UInt.m570constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m788timesVKZWuLQ(short s16, long j3) {
        return ULong.m648constructorimpl(ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j3);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m789timesWZ4Q5Ns(short s16, int i3) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) * i3);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m790timesxj2QHRw(short s16, short s17) {
        return UInt.m570constructorimpl(UInt.m570constructorimpl(s16 & 65535) * UInt.m570constructorimpl(s17 & 65535));
    }

    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m791toByteimpl(short s16) {
        return (byte) s16;
    }

    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m792toDoubleimpl(short s16) {
        return s16 & 65535;
    }

    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m793toFloatimpl(short s16) {
        return s16 & 65535;
    }

    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m794toIntimpl(short s16) {
        return s16 & 65535;
    }

    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m795toLongimpl(short s16) {
        return s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m797toStringimpl(short s16) {
        return String.valueOf(s16 & 65535);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m798toUBytew2LRezQ(short s16) {
        return UByte.m494constructorimpl((byte) s16);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m799toUIntpVg5ArA(short s16) {
        return UInt.m570constructorimpl(s16 & 65535);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m800toULongsVKNKU(short s16) {
        return ULong.m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m802xorxj2QHRw(short s16, short s17) {
        return m754constructorimpl((short) (s16 ^ s17));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & 65535, uShort.getData() & 65535);
    }

    public boolean equals(Object obj) {
        return m760equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m766hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m797toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m753compareToxj2QHRw(short s16, short s17) {
        return Intrinsics.compare(s16 & 65535, s17 & 65535);
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m754constructorimpl(short s16) {
        return s16;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m766hashCodeimpl(short s16) {
        return s16;
    }

    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m796toShortimpl(short s16) {
        return s16;
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m801toUShortMh2AYeg(short s16) {
        return s16;
    }
}
