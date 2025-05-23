package kotlin;

import com.tencent.ams.adcore.mma.api.Global;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b\u00a8\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes28.dex */
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(int i3) {
        return Integer.numberOfLeadingZeros(i3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(int i3) {
        return Integer.bitCount(i3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(int i3) {
        return Integer.numberOfTrailingZeros(i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final double fromBits(DoubleCompanionObject doubleCompanionObject, long j3) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return Double.longBitsToDouble(j3);
    }

    @InlineOnly
    private static final boolean isFinite(double d16) {
        return (Double.isInfinite(d16) || Double.isNaN(d16)) ? false : true;
    }

    @InlineOnly
    private static final boolean isInfinite(double d16) {
        return Double.isInfinite(d16);
    }

    @InlineOnly
    private static final boolean isNaN(double d16) {
        return Double.isNaN(d16);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateLeft(int i3, int i16) {
        return Integer.rotateLeft(i3, i16);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateRight(int i3, int i16) {
        return Integer.rotateRight(i3, i16);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int takeHighestOneBit(int i3) {
        return Integer.highestOneBit(i3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int takeLowestOneBit(int i3) {
        return Integer.lowestOneBit(i3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final long toBits(double d16) {
        return Double.doubleToLongBits(d16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final long toRawBits(double d16) {
        return Double.doubleToRawLongBits(d16);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(long j3) {
        return Long.numberOfLeadingZeros(j3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(long j3) {
        return Long.bitCount(j3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(long j3) {
        return Long.numberOfTrailingZeros(j3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final float fromBits(FloatCompanionObject floatCompanionObject, int i3) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return Float.intBitsToFloat(i3);
    }

    @InlineOnly
    private static final boolean isFinite(float f16) {
        return (Float.isInfinite(f16) || Float.isNaN(f16)) ? false : true;
    }

    @InlineOnly
    private static final boolean isInfinite(float f16) {
        return Float.isInfinite(f16);
    }

    @InlineOnly
    private static final boolean isNaN(float f16) {
        return Float.isNaN(f16);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateLeft(long j3, int i3) {
        return Long.rotateLeft(j3, i3);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateRight(long j3, int i3) {
        return Long.rotateRight(j3, i3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long takeHighestOneBit(long j3) {
        return Long.highestOneBit(j3);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long takeLowestOneBit(long j3) {
        return Long.lowestOneBit(j3);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final int toBits(float f16) {
        return Float.floatToIntBits(f16);
    }

    @SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
    @InlineOnly
    private static final int toRawBits(float f16) {
        return Float.floatToRawIntBits(f16);
    }
}
