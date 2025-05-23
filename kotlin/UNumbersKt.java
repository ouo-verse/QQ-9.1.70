package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0004\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0004\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u001b\u001a\u001f\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010!\u001a\u0017\u0010'\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u001a\u0017\u0010'\u001a\u00020\u0005*\u00020\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010'\u001a\u00020\b*\u00020\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001a\u0017\u0010'\u001a\u00020\u000b*\u00020\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010)\u001a\u0017\u0010/\u001a\u00020\u0005*\u00020\u0005H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0007\u001a\u0017\u0010/\u001a\u00020\b*\u00020\bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010,\u001a\u0017\u0010/\u001a\u00020\u000b*\u00020\u000bH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00064"}, d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "UNumbersKt")
/* loaded from: classes28.dex */
public final class UNumbersKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countLeadingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m719countLeadingZeroBits7apg3OU(byte b16) {
        return Integer.numberOfLeadingZeros(b16 & 255) - 24;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countLeadingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m720countLeadingZeroBitsVKZWuLQ(long j3) {
        return Long.numberOfLeadingZeros(j3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m721countLeadingZeroBitsWZ4Q5Ns(int i3) {
        return Integer.numberOfLeadingZeros(i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countLeadingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m722countLeadingZeroBitsxj2QHRw(short s16) {
        return Integer.numberOfLeadingZeros(s16 & 65535) - 16;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countOneBits-7apg3OU, reason: not valid java name */
    private static final int m723countOneBits7apg3OU(byte b16) {
        return Integer.bitCount(UInt.m570constructorimpl(b16 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countOneBits-VKZWuLQ, reason: not valid java name */
    private static final int m724countOneBitsVKZWuLQ(long j3) {
        return Long.bitCount(j3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countOneBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m725countOneBitsWZ4Q5Ns(int i3) {
        return Integer.bitCount(i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countOneBits-xj2QHRw, reason: not valid java name */
    private static final int m726countOneBitsxj2QHRw(short s16) {
        return Integer.bitCount(UInt.m570constructorimpl(s16 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countTrailingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m727countTrailingZeroBits7apg3OU(byte b16) {
        return Integer.numberOfTrailingZeros(b16 | 256);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countTrailingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m728countTrailingZeroBitsVKZWuLQ(long j3) {
        return Long.numberOfTrailingZeros(j3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m729countTrailingZeroBitsWZ4Q5Ns(int i3) {
        return Integer.numberOfTrailingZeros(i3);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: countTrailingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m730countTrailingZeroBitsxj2QHRw(short s16) {
        return Integer.numberOfTrailingZeros(s16 | 65536);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40, reason: not valid java name */
    private static final long m731rotateLeftJSWoG40(long j3, int i3) {
        return ULong.m648constructorimpl(Long.rotateLeft(j3, i3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4, reason: not valid java name */
    private static final byte m732rotateLeftLxnNnR4(byte b16, int i3) {
        return UByte.m494constructorimpl(NumbersKt__NumbersKt.rotateLeft(b16, i3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4, reason: not valid java name */
    private static final int m733rotateLeftV7xB4Y4(int i3, int i16) {
        return UInt.m570constructorimpl(Integer.rotateLeft(i3, i16));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4, reason: not valid java name */
    private static final short m734rotateLeftolVBNx4(short s16, int i3) {
        return UShort.m754constructorimpl(NumbersKt__NumbersKt.rotateLeft(s16, i3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40, reason: not valid java name */
    private static final long m735rotateRightJSWoG40(long j3, int i3) {
        return ULong.m648constructorimpl(Long.rotateRight(j3, i3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4, reason: not valid java name */
    private static final byte m736rotateRightLxnNnR4(byte b16, int i3) {
        return UByte.m494constructorimpl(NumbersKt__NumbersKt.rotateRight(b16, i3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4, reason: not valid java name */
    private static final int m737rotateRightV7xB4Y4(int i3, int i16) {
        return UInt.m570constructorimpl(Integer.rotateRight(i3, i16));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4, reason: not valid java name */
    private static final short m738rotateRightolVBNx4(short s16, int i3) {
        return UShort.m754constructorimpl(NumbersKt__NumbersKt.rotateRight(s16, i3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeHighestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m739takeHighestOneBit7apg3OU(byte b16) {
        return UByte.m494constructorimpl((byte) Integer.highestOneBit(b16 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeHighestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m740takeHighestOneBitVKZWuLQ(long j3) {
        return ULong.m648constructorimpl(Long.highestOneBit(j3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeHighestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m741takeHighestOneBitWZ4Q5Ns(int i3) {
        return UInt.m570constructorimpl(Integer.highestOneBit(i3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeHighestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m742takeHighestOneBitxj2QHRw(short s16) {
        return UShort.m754constructorimpl((short) Integer.highestOneBit(s16 & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeLowestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m743takeLowestOneBit7apg3OU(byte b16) {
        return UByte.m494constructorimpl((byte) Integer.lowestOneBit(b16 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeLowestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m744takeLowestOneBitVKZWuLQ(long j3) {
        return ULong.m648constructorimpl(Long.lowestOneBit(j3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeLowestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m745takeLowestOneBitWZ4Q5Ns(int i3) {
        return UInt.m570constructorimpl(Integer.lowestOneBit(i3));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: takeLowestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m746takeLowestOneBitxj2QHRw(short s16) {
        return UShort.m754constructorimpl((short) Integer.lowestOneBit(s16 & 65535));
    }
}
