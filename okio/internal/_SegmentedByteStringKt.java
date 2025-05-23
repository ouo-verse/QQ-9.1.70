package okio.internal;

import com.tencent.luggage.wxa.c8.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a-\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0017\u001a\u00020\u000f*\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00020\u0019*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u000b*\u00020\bH\u0080\b\u001a%\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0080\b\u001a]\u0010!\u001a\u00020\u0007*\u00020\b2K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0080\b\u00f8\u0001\u0000\u001aj\u0010!\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012K\u0010\"\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070#H\u0082\b\u001a\u0014\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006("}, d2 = {"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonCopyInto", "", "Lokio/SegmentedByteString;", "offset", "target", "", "targetOffset", "byteCount", "commonEquals", "", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", c.G, "commonRangeEquals", "otherOffset", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _SegmentedByteStringKt {
    public static final int binarySearch(@NotNull int[] iArr, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i18 = i17 - 1;
        while (i16 <= i18) {
            int i19 = (i16 + i18) >>> 1;
            int i26 = iArr[i19];
            if (i26 < i3) {
                i16 = i19 + 1;
            } else if (i26 > i3) {
                i18 = i19 - 1;
            } else {
                return i19;
            }
        }
        return (-i16) - 1;
    }

    public static final void commonCopyInto(@NotNull SegmentedByteString segmentedByteString, int i3, @NotNull byte[] target, int i16, int i17) {
        int i18;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        long j3 = i17;
        _UtilKt.checkOffsetAndCount(segmentedByteString.size(), i3, j3);
        _UtilKt.checkOffsetAndCount(target.length, i16, j3);
        int i19 = i17 + i3;
        int segment = segment(segmentedByteString, i3);
        while (i3 < i19) {
            if (segment == 0) {
                i18 = 0;
            } else {
                i18 = segmentedByteString.getDirectory()[segment - 1];
            }
            int i26 = segmentedByteString.getDirectory()[segment] - i18;
            int i27 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i19, i26 + i18) - i3;
            int i28 = i27 + (i3 - i18);
            ArraysKt___ArraysJvmKt.copyInto(segmentedByteString.getSegments()[segment], target, i16, i28, i28 + min);
            i16 += min;
            i3 += min;
            segment++;
        }
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString segmentedByteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        return segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int hashCode = segmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = segmentedByteString.getSegments().length;
        int i3 = 0;
        int i16 = 1;
        int i17 = 0;
        while (i3 < length) {
            int i18 = segmentedByteString.getDirectory()[length + i3];
            int i19 = segmentedByteString.getDirectory()[i3];
            byte[] bArr = segmentedByteString.getSegments()[i3];
            int i26 = (i19 - i17) + i18;
            while (i18 < i26) {
                i16 = (i16 * 31) + bArr[i18];
                i18++;
            }
            i3++;
            i17 = i19;
        }
        segmentedByteString.setHashCode$okio(i16);
        return i16;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString segmentedByteString, int i3) {
        int i16;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        _UtilKt.checkOffsetAndCount(segmentedByteString.getDirectory()[segmentedByteString.getSegments().length - 1], i3, 1L);
        int segment = segment(segmentedByteString, i3);
        if (segment == 0) {
            i16 = 0;
        } else {
            i16 = segmentedByteString.getDirectory()[segment - 1];
        }
        return segmentedByteString.getSegments()[segment][(i3 - i16) + segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i3, @NotNull ByteString other, int i16, int i17) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0 || i3 > segmentedByteString.size() - i17) {
            return false;
        }
        int i18 = i17 + i3;
        int segment = segment(segmentedByteString, i3);
        while (i3 < i18) {
            int i19 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i26 = segmentedByteString.getDirectory()[segment] - i19;
            int i27 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i18, i26 + i19) - i3;
            if (!other.rangeEquals(i16, segmentedByteString.getSegments()[segment], i27 + (i3 - i19), min)) {
                return false;
            }
            i16 += min;
            i3 += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString segmentedByteString, int i3, int i16) {
        boolean z16;
        boolean z17;
        boolean z18;
        Object[] copyOfRange;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(segmentedByteString, i16);
        int i17 = 0;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (resolveDefaultParameter <= segmentedByteString.size()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                int i18 = resolveDefaultParameter - i3;
                if (i18 >= 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (i3 == 0 && resolveDefaultParameter == segmentedByteString.size()) {
                        return segmentedByteString;
                    }
                    if (i3 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(segmentedByteString, i3);
                    int segment2 = segment(segmentedByteString, resolveDefaultParameter - 1);
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(segmentedByteString.getSegments(), segment, segment2 + 1);
                    byte[][] bArr = (byte[][]) copyOfRange;
                    int[] iArr = new int[bArr.length * 2];
                    if (segment <= segment2) {
                        int i19 = 0;
                        int i26 = segment;
                        while (true) {
                            int i27 = i26 + 1;
                            iArr[i19] = Math.min(segmentedByteString.getDirectory()[i26] - i3, i18);
                            int i28 = i19 + 1;
                            iArr[i19 + bArr.length] = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + i26];
                            if (i26 == segment2) {
                                break;
                            }
                            i26 = i27;
                            i19 = i28;
                        }
                    }
                    if (segment != 0) {
                        i17 = segmentedByteString.getDirectory()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i3 - i17);
                    return new SegmentedByteString(bArr, iArr);
                }
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i3).toString());
            }
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + segmentedByteString.size() + ')').toString());
        }
        throw new IllegalArgumentException(("beginIndex=" + i3 + " < 0").toString());
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments().length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            int i18 = segmentedByteString.getDirectory()[length + i3];
            int i19 = segmentedByteString.getDirectory()[i3];
            int i26 = i19 - i16;
            ArraysKt___ArraysJvmKt.copyInto(segmentedByteString.getSegments()[i3], bArr, i17, i18, i18 + i26);
            i17 += i26;
            i3++;
            i16 = i19;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString segmentedByteString, @NotNull Buffer buffer, int i3, int i16) {
        int i17;
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i18 = i3 + i16;
        int segment = segment(segmentedByteString, i3);
        while (i3 < i18) {
            if (segment == 0) {
                i17 = 0;
            } else {
                i17 = segmentedByteString.getDirectory()[segment - 1];
            }
            int i19 = segmentedByteString.getDirectory()[segment] - i17;
            int i26 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i18, i19 + i17) - i3;
            int i27 = i26 + (i3 - i17);
            Segment segment2 = new Segment(segmentedByteString.getSegments()[segment], i27, i27 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i3 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + i16);
    }

    public static final void forEachSegment(@NotNull SegmentedByteString segmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = segmentedByteString.getSegments().length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            int i17 = segmentedByteString.getDirectory()[length + i3];
            int i18 = segmentedByteString.getDirectory()[i3];
            action.invoke(segmentedByteString.getSegments()[i3], Integer.valueOf(i17), Integer.valueOf(i18 - i16));
            i3++;
            i16 = i18;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segmentedByteString, int i3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        int binarySearch = binarySearch(segmentedByteString.getDirectory(), i3 + 1, 0, segmentedByteString.getSegments().length);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        return binarySearch;
    }

    private static final void forEachSegment(SegmentedByteString segmentedByteString, int i3, int i16, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int segment = segment(segmentedByteString, i3);
        while (i3 < i16) {
            int i17 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i18 = segmentedByteString.getDirectory()[segment] - i17;
            int i19 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i16, i18 + i17) - i3;
            function3.invoke(segmentedByteString.getSegments()[segment], Integer.valueOf(i19 + (i3 - i17)), Integer.valueOf(min));
            i3 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i3, @NotNull byte[] other, int i16, int i17) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i3 < 0 || i3 > segmentedByteString.size() - i17 || i16 < 0 || i16 > other.length - i17) {
            return false;
        }
        int i18 = i17 + i3;
        int segment = segment(segmentedByteString, i3);
        while (i3 < i18) {
            int i19 = segment == 0 ? 0 : segmentedByteString.getDirectory()[segment - 1];
            int i26 = segmentedByteString.getDirectory()[segment] - i19;
            int i27 = segmentedByteString.getDirectory()[segmentedByteString.getSegments().length + segment];
            int min = Math.min(i18, i26 + i19) - i3;
            if (!_UtilKt.arrayRangeEquals(segmentedByteString.getSegments()[segment], i27 + (i3 - i19), other, i16, min)) {
                return false;
            }
            i16 += min;
            i3 += min;
            segment++;
        }
        return true;
    }
}
