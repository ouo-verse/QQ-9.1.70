package kotlin.collections;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"partition", "", HippyControllerProps.ARRAY, "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m929partitionnroSd4(long[] jArr, int i3, int i16) {
        long m707getsVKNKU = ULongArray.m707getsVKNKU(jArr, (i3 + i16) / 2);
        while (i3 <= i16) {
            while (UnsignedKt.ulongCompare(ULongArray.m707getsVKNKU(jArr, i3), m707getsVKNKU) < 0) {
                i3++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m707getsVKNKU(jArr, i16), m707getsVKNKU) > 0) {
                i16--;
            }
            if (i3 <= i16) {
                long m707getsVKNKU2 = ULongArray.m707getsVKNKU(jArr, i3);
                ULongArray.m712setk8EXiF4(jArr, i3, ULongArray.m707getsVKNKU(jArr, i16));
                ULongArray.m712setk8EXiF4(jArr, i16, m707getsVKNKU2);
                i3++;
                i16--;
            }
        }
        return i3;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m930partition4UcCI2c(byte[] bArr, int i3, int i16) {
        int i17;
        byte m551getw2LRezQ = UByteArray.m551getw2LRezQ(bArr, (i3 + i16) / 2);
        while (i3 <= i16) {
            while (true) {
                i17 = m551getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m551getw2LRezQ(bArr, i3) & 255, i17) >= 0) {
                    break;
                }
                i3++;
            }
            while (Intrinsics.compare(UByteArray.m551getw2LRezQ(bArr, i16) & 255, i17) > 0) {
                i16--;
            }
            if (i3 <= i16) {
                byte m551getw2LRezQ2 = UByteArray.m551getw2LRezQ(bArr, i3);
                UByteArray.m556setVurrAj0(bArr, i3, UByteArray.m551getw2LRezQ(bArr, i16));
                UByteArray.m556setVurrAj0(bArr, i16, m551getw2LRezQ2);
                i3++;
                i16--;
            }
        }
        return i3;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m931partitionAa5vz7o(short[] sArr, int i3, int i16) {
        int i17;
        short m811getMh2AYeg = UShortArray.m811getMh2AYeg(sArr, (i3 + i16) / 2);
        while (i3 <= i16) {
            while (true) {
                i17 = m811getMh2AYeg & 65535;
                if (Intrinsics.compare(UShortArray.m811getMh2AYeg(sArr, i3) & 65535, i17) >= 0) {
                    break;
                }
                i3++;
            }
            while (Intrinsics.compare(UShortArray.m811getMh2AYeg(sArr, i16) & 65535, i17) > 0) {
                i16--;
            }
            if (i3 <= i16) {
                short m811getMh2AYeg2 = UShortArray.m811getMh2AYeg(sArr, i3);
                UShortArray.m816set01HTLdE(sArr, i3, UShortArray.m811getMh2AYeg(sArr, i16));
                UShortArray.m816set01HTLdE(sArr, i16, m811getMh2AYeg2);
                i3++;
                i16--;
            }
        }
        return i3;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m932partitionoBK06Vg(int[] iArr, int i3, int i16) {
        int m629getpVg5ArA = UIntArray.m629getpVg5ArA(iArr, (i3 + i16) / 2);
        while (i3 <= i16) {
            while (UnsignedKt.uintCompare(UIntArray.m629getpVg5ArA(iArr, i3), m629getpVg5ArA) < 0) {
                i3++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m629getpVg5ArA(iArr, i16), m629getpVg5ArA) > 0) {
                i16--;
            }
            if (i3 <= i16) {
                int m629getpVg5ArA2 = UIntArray.m629getpVg5ArA(iArr, i3);
                UIntArray.m634setVXSXFK8(iArr, i3, UIntArray.m629getpVg5ArA(iArr, i16));
                UIntArray.m634setVXSXFK8(iArr, i16, m629getpVg5ArA2);
                i3++;
                i16--;
            }
        }
        return i3;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m933quickSortnroSd4(long[] jArr, int i3, int i16) {
        int m929partitionnroSd4 = m929partitionnroSd4(jArr, i3, i16);
        int i17 = m929partitionnroSd4 - 1;
        if (i3 < i17) {
            m933quickSortnroSd4(jArr, i3, i17);
        }
        if (m929partitionnroSd4 < i16) {
            m933quickSortnroSd4(jArr, m929partitionnroSd4, i16);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m934quickSort4UcCI2c(byte[] bArr, int i3, int i16) {
        int m930partition4UcCI2c = m930partition4UcCI2c(bArr, i3, i16);
        int i17 = m930partition4UcCI2c - 1;
        if (i3 < i17) {
            m934quickSort4UcCI2c(bArr, i3, i17);
        }
        if (m930partition4UcCI2c < i16) {
            m934quickSort4UcCI2c(bArr, m930partition4UcCI2c, i16);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m935quickSortAa5vz7o(short[] sArr, int i3, int i16) {
        int m931partitionAa5vz7o = m931partitionAa5vz7o(sArr, i3, i16);
        int i17 = m931partitionAa5vz7o - 1;
        if (i3 < i17) {
            m935quickSortAa5vz7o(sArr, i3, i17);
        }
        if (m931partitionAa5vz7o < i16) {
            m935quickSortAa5vz7o(sArr, m931partitionAa5vz7o, i16);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m936quickSortoBK06Vg(int[] iArr, int i3, int i16) {
        int m932partitionoBK06Vg = m932partitionoBK06Vg(iArr, i3, i16);
        int i17 = m932partitionoBK06Vg - 1;
        if (i3 < i17) {
            m936quickSortoBK06Vg(iArr, i3, i17);
        }
        if (m932partitionoBK06Vg < i16) {
            m936quickSortoBK06Vg(iArr, m932partitionoBK06Vg, i16);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m937sortArraynroSd4(@NotNull long[] array, int i3, int i16) {
        Intrinsics.checkNotNullParameter(array, "array");
        m933quickSortnroSd4(array, i3, i16 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m938sortArray4UcCI2c(@NotNull byte[] array, int i3, int i16) {
        Intrinsics.checkNotNullParameter(array, "array");
        m934quickSort4UcCI2c(array, i3, i16 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m939sortArrayAa5vz7o(@NotNull short[] array, int i3, int i16) {
        Intrinsics.checkNotNullParameter(array, "array");
        m935quickSortAa5vz7o(array, i3, i16 - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m940sortArrayoBK06Vg(@NotNull int[] array, int i3, int i16) {
        Intrinsics.checkNotNullParameter(array, "array");
        m936quickSortoBK06Vg(array, i3, i16 - 1);
    }
}
