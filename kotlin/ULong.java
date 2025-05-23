package kotlin;

import com.heytap.databaseengine.apiv3.data.Element;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%H\u00d6\u0003\u00a2\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\u0087\f\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\u0087\b\u00a2\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\u0087\b\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\u0087\b\u00a2\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\u0087\b\u00a2\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\u0087\b\u00a2\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016\u00a2\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\u0087\b\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006}"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", Element.ELEMENT_NAME_TIMES, "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes28.dex */
public final class ULong implements Comparable<ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    @PublishedApi
    @IntrinsicConstEvaluation
    /* synthetic */ ULong(long j3) {
        this.data = j3;
    }

    @InlineOnly
    /* renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m641andVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 & j16);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m642boximpl(long j3) {
        return new ULong(j3);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m643compareTo7apg3OU(long j3, byte b16) {
        return UnsignedKt.ulongCompare(j3, m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m644compareToVKZWuLQ(long j3) {
        return UnsignedKt.ulongCompare(getData(), j3);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m646compareToWZ4Q5Ns(long j3, int i3) {
        return UnsignedKt.ulongCompare(j3, m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m647compareToxj2QHRw(long j3, short s16) {
        return UnsignedKt.ulongCompare(j3, m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m649decsVKNKU(long j3) {
        return m648constructorimpl(j3 - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m650div7apg3OU(long j3, byte b16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m651divVKZWuLQ(long j3, long j16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, j16);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m652divWZ4Q5Ns(long j3, int i3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m653divxj2QHRw(long j3, short s16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m654equalsimpl(long j3, Object obj) {
        if (!(obj instanceof ULong) || j3 != ((ULong) obj).getData()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m655equalsimpl0(long j3, long j16) {
        if (j3 == j16) {
            return true;
        }
        return false;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m656floorDiv7apg3OU(long j3, byte b16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m657floorDivVKZWuLQ(long j3, long j16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, j16);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m658floorDivWZ4Q5Ns(long j3, int i3) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m659floorDivxj2QHRw(long j3, short s16) {
        return UnsignedKt.m825ulongDivideeb3DHEI(j3, m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m660hashCodeimpl(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    @InlineOnly
    /* renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m661incsVKNKU(long j3) {
        return m648constructorimpl(j3 + 1);
    }

    @InlineOnly
    /* renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m662invsVKNKU(long j3) {
        return m648constructorimpl(~j3);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m663minus7apg3OU(long j3, byte b16) {
        return m648constructorimpl(j3 - m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m664minusVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 - j16);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m665minusWZ4Q5Ns(long j3, int i3) {
        return m648constructorimpl(j3 - m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m666minusxj2QHRw(long j3, short s16) {
        return m648constructorimpl(j3 - m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m667mod7apg3OU(long j3, byte b16) {
        return UByte.m494constructorimpl((byte) UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(b16 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m668modVKZWuLQ(long j3, long j16) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(j3, j16);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m669modWZ4Q5Ns(long j3, int i3) {
        return UInt.m570constructorimpl((int) UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(i3 & 4294967295L)));
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m670modxj2QHRw(long j3, short s16) {
        return UShort.m754constructorimpl((short) UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @InlineOnly
    /* renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m671orVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 | j16);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m672plus7apg3OU(long j3, byte b16) {
        return m648constructorimpl(j3 + m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m673plusVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 + j16);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m674plusWZ4Q5Ns(long j3, int i3) {
        return m648constructorimpl(j3 + m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m675plusxj2QHRw(long j3, short s16) {
        return m648constructorimpl(j3 + m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m676rangeToVKZWuLQ(long j3, long j16) {
        return new ULongRange(j3, j16, null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m677rem7apg3OU(long j3, byte b16) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m678remVKZWuLQ(long j3, long j16) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(j3, j16);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m679remWZ4Q5Ns(long j3, int i3) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m680remxj2QHRw(long j3, short s16) {
        return UnsignedKt.m826ulongRemaindereb3DHEI(j3, m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m681shlsVKNKU(long j3, int i3) {
        return m648constructorimpl(j3 << i3);
    }

    @InlineOnly
    /* renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m682shrsVKNKU(long j3, int i3) {
        return m648constructorimpl(j3 >>> i3);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m683times7apg3OU(long j3, byte b16) {
        return m648constructorimpl(j3 * m648constructorimpl(b16 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m684timesVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 * j16);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m685timesWZ4Q5Ns(long j3, int i3) {
        return m648constructorimpl(j3 * m648constructorimpl(i3 & 4294967295L));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m686timesxj2QHRw(long j3, short s16) {
        return m648constructorimpl(j3 * m648constructorimpl(s16 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m687toByteimpl(long j3) {
        return (byte) j3;
    }

    @InlineOnly
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m688toDoubleimpl(long j3) {
        return UnsignedKt.ulongToDouble(j3);
    }

    @InlineOnly
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m689toFloatimpl(long j3) {
        return (float) UnsignedKt.ulongToDouble(j3);
    }

    @InlineOnly
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m690toIntimpl(long j3) {
        return (int) j3;
    }

    @InlineOnly
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m692toShortimpl(long j3) {
        return (short) j3;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m693toStringimpl(long j3) {
        return UnsignedKt.ulongToString(j3);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m694toUBytew2LRezQ(long j3) {
        return UByte.m494constructorimpl((byte) j3);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m695toUIntpVg5ArA(long j3) {
        return UInt.m570constructorimpl((int) j3);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m697toUShortMh2AYeg(long j3) {
        return UShort.m754constructorimpl((short) j3);
    }

    @InlineOnly
    /* renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m698xorVKZWuLQ(long j3, long j16) {
        return m648constructorimpl(j3 ^ j16);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(getData(), uLong.getData());
    }

    public boolean equals(Object obj) {
        return m654equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m660hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m693toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m645compareToVKZWuLQ(long j3, long j16) {
        return UnsignedKt.ulongCompare(j3, j16);
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m648constructorimpl(long j3) {
        return j3;
    }

    @InlineOnly
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m691toLongimpl(long j3) {
        return j3;
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m696toULongsVKNKU(long j3) {
        return j3;
    }
}
