package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import com.tencent.mobileqq.wink.editor.smartclip.FindDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001aP\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u001aN\u0010\u0016\u001a\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u001a>\u0010\u0019\u001a\u00020\u00152\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u00a8\u0006\u001a"}, d2 = {"", "arr", "", "d", "", "time", "musicDuration", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "beats", "Lkotlin/Function1;", "", "acceptBeat", "Lcom/tencent/mobileqq/wink/editor/smartclip/FindDirection;", "findDirection", "nearTimeLimit", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/c;", "e", "endTime", "includeBeatAtEndTime", "startTime", "", "a", "timeLimit", "includeBeatAtTime", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class CalculateHelperKt {
    public static final int a(@NotNull List<MusicTimePoint> beats, long j3, long j16, boolean z16, @NotNull Function1<? super MusicTimePoint, Boolean> acceptBeat, long j17) {
        Intrinsics.checkNotNullParameter(beats, "beats");
        Intrinsics.checkNotNullParameter(acceptBeat, "acceptBeat");
        if (j17 > 0) {
            return a(beats, j3, j16, z16, acceptBeat, 0L) - a(beats, j3, j17, true, acceptBeat, 0L);
        }
        long j18 = j16 / j3;
        long j19 = j16 % j3;
        if (j18 > 0) {
            return (c(beats, j16, true, acceptBeat) * ((int) j18)) + c(beats, j19, z16, acceptBeat);
        }
        return c(beats, j16, z16, acceptBeat);
    }

    public static /* synthetic */ int b(List list, long j3, long j16, boolean z16, Function1 function1, long j17, int i3, Object obj) {
        boolean z17;
        Function1 function12;
        long j18;
        if ((i3 & 8) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        if ((i3 & 16) != 0) {
            function12 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.CalculateHelperKt$beatCountInTimeByLoop$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull MusicTimePoint musicTimePoint) {
                    Intrinsics.checkNotNullParameter(musicTimePoint, "<anonymous parameter 0>");
                    return Boolean.TRUE;
                }
            };
        } else {
            function12 = function1;
        }
        if ((i3 & 32) != 0) {
            j18 = 0;
        } else {
            j18 = j17;
        }
        return a(list, j3, j16, z17, function12, j18);
    }

    private static final int c(List<MusicTimePoint> list, long j3, boolean z16, Function1<? super MusicTimePoint, Boolean> function1) {
        int i3 = 0;
        for (MusicTimePoint musicTimePoint : list) {
            if (musicTimePoint.getTimeInMillis() > j3 || (!z16 && musicTimePoint.getTimeInMillis() == j3)) {
                break;
            }
            if (function1.invoke(musicTimePoint).booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    public static final double d(@NotNull long[] arr) {
        boolean z16;
        long sum;
        Intrinsics.checkNotNullParameter(arr, "arr");
        if (arr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            sum = ArraysKt___ArraysKt.sum(arr);
            double length = (sum * 1.0d) / arr.length;
            double d16 = 0.0d;
            for (long j3 : arr) {
                double d17 = j3 - length;
                d16 += d17 * d17;
            }
            return d16 / arr.length;
        }
        throw new IllegalArgumentException("can not calculate variance for an empty array");
    }

    @Nullable
    public static final c e(long j3, long j16, @NotNull List<MusicTimePoint> beats, @NotNull Function1<? super MusicTimePoint, Boolean> acceptBeat, @NotNull FindDirection findDirection, long j17) {
        boolean z16;
        int i3;
        int binarySearch;
        Object last;
        int i16;
        Intrinsics.checkNotNullParameter(beats, "beats");
        Intrinsics.checkNotNullParameter(acceptBeat, "acceptBeat");
        Intrinsics.checkNotNullParameter(findDirection, "findDirection");
        ArrayList arrayList = new ArrayList();
        for (Object obj : beats) {
            if (acceptBeat.invoke((MusicTimePoint) obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (j17 < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (findDirection == FindDirection.BI_DIRECTION) {
            i3 = 0;
            c e16 = e(j3, j16, beats, acceptBeat, FindDirection.BACKWARD, j17);
            c e17 = e(j3, j16, beats, acceptBeat, FindDirection.FORWARD, j17);
            if (e16 == null && e17 == null) {
                return null;
            }
            if (e16 != null && e17 != null) {
                long abs = Math.abs(e16.a() - j3);
                long abs2 = Math.abs(e17.a() - j3);
                long min = Math.min(abs, abs2);
                if (!z16 && min > j17) {
                    return null;
                }
                if (abs >= abs2) {
                    return e17;
                }
                return e16;
            }
            if (e16 != null) {
                return e16;
            }
            if (e17 != null) {
                return e17;
            }
        } else {
            i3 = 0;
        }
        long j18 = j3 % j16;
        long j19 = j3 / j16;
        final Long valueOf = Long.valueOf(j18);
        binarySearch = CollectionsKt__CollectionsKt.binarySearch(arrayList, i3, arrayList.size(), new Function1<MusicTimePoint, Integer>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.CalculateHelperKt$findNearestBeat$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Integer invoke(MusicTimePoint musicTimePoint) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(musicTimePoint.getTimeInMillis()), valueOf);
                return Integer.valueOf(compareValues);
            }
        });
        if (binarySearch >= 0) {
            return new c(j19, (MusicTimePoint) arrayList.get(binarySearch), j16);
        }
        int i17 = (-binarySearch) - 1;
        if (findDirection == FindDirection.BACKWARD) {
            if (i17 > 0 && i17 - 1 < arrayList.size()) {
                MusicTimePoint musicTimePoint = (MusicTimePoint) arrayList.get(i16);
                if (!z16 && Math.abs(musicTimePoint.getTimeInMillis() - j18) > j17) {
                    return null;
                }
                return new c(j19, musicTimePoint, j16);
            }
            if (i17 == 0 && j19 > 0) {
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                MusicTimePoint musicTimePoint2 = (MusicTimePoint) last;
                if (!z16 && Math.abs((j16 + j18) - musicTimePoint2.getTimeInMillis()) > j17) {
                    return null;
                }
                return new c(j19 - 1, musicTimePoint2, j16);
            }
            return null;
        }
        if (findDirection != FindDirection.FORWARD) {
            return null;
        }
        if (i17 < arrayList.size()) {
            MusicTimePoint musicTimePoint3 = (MusicTimePoint) arrayList.get(i17);
            if (!z16 && Math.abs(musicTimePoint3.getTimeInMillis() - j18) > j17) {
                return null;
            }
            return new c(j19, musicTimePoint3, j16);
        }
        if (i17 != arrayList.size()) {
            return null;
        }
        MusicTimePoint musicTimePoint4 = (MusicTimePoint) arrayList.get(i3);
        if (!z16 && Math.abs((j16 + musicTimePoint4.getTimeInMillis()) - j18) > j17) {
            return null;
        }
        return new c(j19 + 1, musicTimePoint4, j16);
    }

    public static /* synthetic */ c f(long j3, long j16, List list, Function1 function1, FindDirection findDirection, long j17, int i3, Object obj) {
        Function1 function12;
        FindDirection findDirection2;
        long j18;
        if ((i3 & 8) != 0) {
            function12 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.CalculateHelperKt$findNearestBeat$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull MusicTimePoint musicTimePoint) {
                    Intrinsics.checkNotNullParameter(musicTimePoint, "<anonymous parameter 0>");
                    return Boolean.TRUE;
                }
            };
        } else {
            function12 = function1;
        }
        if ((i3 & 16) != 0) {
            findDirection2 = FindDirection.BACKWARD;
        } else {
            findDirection2 = findDirection;
        }
        if ((i3 & 32) != 0) {
            j18 = -1;
        } else {
            j18 = j17;
        }
        return e(j3, j16, list, function12, findDirection2, j18);
    }
}
