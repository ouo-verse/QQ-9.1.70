package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.smartclip.FindDirection;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicTimePoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b$\u0010%J.\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JJ\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002JD\u0010\u001b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0005H\u0002J7\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b \u0010\u001fJ.\u0010!\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010#\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/AutoClipAlgorithmV2;", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/e;", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "musicTimePoints", "", "musicDurationInMillis", "sourceTotalDuration", "", "sourceCount", "d", "duration", DomainData.DOMAIN_NAME, "musicDuration", "beats", "", tl.h.F, "slotsCount", "splitCount", "Lkotlin/Function1;", "", "dividerBeat", "totalDuration", "i", "endTime", "acceptBeat", "startTime", "g", "durations", "maxIdx", "f", "([JLjava/lang/Integer;JLjava/util/List;)[J", "j", "b", "count", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AutoClipAlgorithmV2 implements e {
    private final long d(List<MusicTimePoint> musicTimePoints, long musicDurationInMillis, long sourceTotalDuration, int sourceCount) {
        return new AutoClipAlgorithmV1().b(musicTimePoints, musicDurationInMillis, sourceTotalDuration, sourceCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(long[] pre2, Integer c16, Integer c26) {
        Intrinsics.checkNotNullParameter(pre2, "$pre2");
        Intrinsics.checkNotNullExpressionValue(c16, "c1");
        long j3 = pre2[c16.intValue()];
        Intrinsics.checkNotNullExpressionValue(c26, "c2");
        if (j3 > pre2[c26.intValue()]) {
            return 1;
        }
        if (pre2[c16.intValue()] == pre2[c26.intValue()]) {
            return 0;
        }
        return -1;
    }

    private final long[] f(long[] durations, Integer maxIdx, long musicDuration, List<MusicTimePoint> beats) {
        IntRange until;
        int i3;
        long j3;
        Intrinsics.checkNotNull(maxIdx);
        long j16 = durations[maxIdx.intValue()];
        until = RangesKt___RangesKt.until(0, maxIdx.intValue());
        Iterator<Integer> it = until.iterator();
        long j17 = 0;
        while (it.hasNext()) {
            j17 += durations[((IntIterator) it).nextInt()];
        }
        Function1<? super MusicTimePoint, Boolean> function1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$halveMaxClip$acceptBeat$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM);
            }
        };
        long j18 = j17 + j16;
        int g16 = g(beats, musicDuration, j18, function1, j17);
        if (g16 < 2) {
            function1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$halveMaxClip$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull MusicTimePoint it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return Boolean.TRUE;
                }
            };
            i3 = 2;
            g16 = g(beats, musicDuration, j18, function1, j17);
        } else {
            i3 = 2;
        }
        c cVar = null;
        if (g16 >= i3) {
            int i16 = g16 - (g16 / 2);
            long j19 = j17;
            c cVar2 = null;
            for (int i17 = 0; i17 < i16; i17++) {
                cVar2 = CalculateHelperKt.f(j19 + 1, musicDuration, beats, function1, FindDirection.FORWARD, 0L, 32, null);
                Intrinsics.checkNotNull(cVar2);
                j19 = cVar2.a();
            }
            cVar = cVar2;
        }
        if (cVar != null) {
            j3 = cVar.a() - j17;
        } else {
            j3 = j16 / i3;
        }
        long[] copyOf = Arrays.copyOf(durations, durations.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[maxIdx.intValue()] = j3;
        copyOf[maxIdx.intValue() + 1] = j16 - j3;
        System.arraycopy(durations, maxIdx.intValue() + 1, copyOf, maxIdx.intValue() + i3, (durations.length - maxIdx.intValue()) - 1);
        return copyOf;
    }

    private final int g(List<MusicTimePoint> beats, long musicDuration, long endTime, Function1<? super MusicTimePoint, Boolean> acceptBeat, long startTime) {
        return CalculateHelperKt.a(beats, musicDuration, endTime, false, acceptBeat, startTime) + 1;
    }

    private final long[] h(long duration, int n3, long musicDuration, List<MusicTimePoint> beats) {
        AutoClipAlgorithmV2$splitN2or3$acceptBeat$1 autoClipAlgorithmV2$splitN2or3$acceptBeat$1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$splitN2or3$acceptBeat$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM);
            }
        };
        int g16 = g(beats, musicDuration, duration, autoClipAlgorithmV2$splitN2or3$acceptBeat$1, 0L);
        if (g16 >= n3) {
            return i(g16, n3, beats, musicDuration, autoClipAlgorithmV2$splitN2or3$acceptBeat$1, duration);
        }
        AutoClipAlgorithmV2$splitN2or3$1 autoClipAlgorithmV2$splitN2or3$1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$splitN2or3$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint musicTimePoint) {
                Intrinsics.checkNotNullParameter(musicTimePoint, "<anonymous parameter 0>");
                return Boolean.TRUE;
            }
        };
        int g17 = g(beats, musicDuration, duration, autoClipAlgorithmV2$splitN2or3$1, 0L);
        if (g17 >= n3) {
            return i(g17, n3, beats, musicDuration, autoClipAlgorithmV2$splitN2or3$1, duration);
        }
        long j3 = n3;
        long j16 = duration / j3;
        int i3 = (int) (duration % j3);
        long[] jArr = new long[n3];
        for (int i16 = 0; i16 < n3; i16++) {
            jArr[i16] = j16;
        }
        for (int i17 = 0; i17 < i3; i17++) {
            jArr[i17] = jArr[i17] + 1;
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long[] i(int slotsCount, int splitCount, List<MusicTimePoint> beats, long musicDuration, Function1<? super MusicTimePoint, Boolean> dividerBeat, long totalDuration) {
        int lastIndex;
        int[] iArr = new int[splitCount];
        for (int i3 = 0; i3 < splitCount; i3++) {
            iArr[i3] = slotsCount / splitCount;
        }
        int i16 = slotsCount % splitCount;
        for (int i17 = 0; i17 < i16; i17++) {
            iArr[i17] = iArr[i17] + 1;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : beats) {
            if (dividerBeat.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        long[] jArr = new long[splitCount];
        int i18 = slotsCount - 1;
        long j3 = 0;
        int i19 = 0;
        int i26 = 0;
        for (int i27 = 0; i27 < i18; i27++) {
            lastIndex = ArraysKt___ArraysKt.getLastIndex(jArr);
            if (i19 == lastIndex) {
                break;
            }
            i26++;
            if (i26 == iArr[i19]) {
                long size = ((i27 / arrayList.size()) * musicDuration) + ((MusicTimePoint) arrayList.get(i27 % arrayList.size())).getTimeInMillis();
                jArr[i19] = size - j3;
                i19++;
                j3 = size;
                i26 = 0;
            }
        }
        jArr[i19] = totalDuration - j3;
        return jArr;
    }

    private final long[] j(long[] durations, Integer maxIdx, long musicDuration, List<MusicTimePoint> beats) {
        IntRange until;
        int i3;
        c cVar;
        long j3;
        long j16;
        Intrinsics.checkNotNull(maxIdx);
        long j17 = durations[maxIdx.intValue()];
        until = RangesKt___RangesKt.until(0, maxIdx.intValue());
        Iterator<Integer> it = until.iterator();
        long j18 = 0;
        while (it.hasNext()) {
            j18 += durations[((IntIterator) it).nextInt()];
        }
        Function1<? super MusicTimePoint, Boolean> function1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$trisectMaxClip$acceptBeat$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM);
            }
        };
        long j19 = j18 + j17;
        int g16 = g(beats, musicDuration, j19, function1, j18);
        if (g16 < 3) {
            function1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV2$trisectMaxClip$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull MusicTimePoint it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    return Boolean.TRUE;
                }
            };
            i3 = 3;
            g16 = g(beats, musicDuration, j19, function1, j18);
        } else {
            i3 = 3;
        }
        c cVar2 = null;
        if (g16 >= i3) {
            int i16 = g16 - (g16 / 3);
            int i17 = i16 / 2;
            int i18 = i16 - i17;
            long j26 = j18;
            c cVar3 = null;
            for (int i19 = 0; i19 < i18; i19++) {
                cVar3 = CalculateHelperKt.f(j26 + 1, musicDuration, beats, function1, FindDirection.FORWARD, 0L, 32, null);
                Intrinsics.checkNotNull(cVar3);
                j26 = cVar3.a();
            }
            for (int i26 = 0; i26 < i17; i26++) {
                cVar2 = CalculateHelperKt.f(j26 + 1, musicDuration, beats, function1, FindDirection.FORWARD, 0L, 32, null);
                Intrinsics.checkNotNull(cVar2);
                j26 = cVar2.a();
            }
            cVar = cVar2;
            cVar2 = cVar3;
        } else {
            cVar = null;
        }
        if (cVar2 != null) {
            j3 = cVar2.a() - j18;
        } else {
            j3 = j17 / i3;
        }
        if (cVar != null) {
            j16 = (cVar.a() - j18) - j3;
        } else {
            j16 = ((j17 / i3) * 2) - j3;
        }
        long[] copyOf = Arrays.copyOf(durations, durations.length + 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[maxIdx.intValue()] = j3;
        copyOf[maxIdx.intValue() + 1] = j16;
        copyOf[maxIdx.intValue() + 2] = (j17 - j3) - j16;
        System.arraycopy(durations, maxIdx.intValue() + 1, copyOf, maxIdx.intValue() + i3, (durations.length - maxIdx.intValue()) - 1);
        return copyOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x014a, code lost:
    
        if (r2 != false) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0189 A[LOOP:2: B:24:0x0048->B:67:0x0189, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018d A[EDGE_INSN: B:68:0x018d->B:82:0x018d BREAK  A[LOOP:2: B:24:0x0048->B:67:0x0189], SYNTHETIC] */
    @Override // com.tencent.mobileqq.wink.editor.smartclip.algorithm.e
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long[] a(long totalDuration, int count, @NotNull List<MusicTimePoint> musicTimePoints, long musicDurationInMillis) {
        IntRange indices;
        Integer next;
        boolean z16;
        Object obj;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(musicTimePoints, "musicTimePoints");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = musicTimePoints.iterator();
        while (true) {
            boolean z19 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next2 = it.next();
            if (((MusicTimePoint) next2).getType() != MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                z19 = true;
            }
            if (z19) {
                arrayList.add(next2);
            }
        }
        if (count < 1) {
            return null;
        }
        int i3 = count + 1;
        long[][] jArr = new long[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            jArr[i16] = new long[i16];
        }
        if (1 <= count) {
            int i17 = 1;
            while (true) {
                if (i17 != 1) {
                    if (i17 != 2 && i17 != 3) {
                        long[] jArr2 = jArr[i17 - 1];
                        indices = ArraysKt___ArraysKt.getIndices(jArr2);
                        Iterator<Integer> it5 = indices.iterator();
                        if (!it5.hasNext()) {
                            next = null;
                        } else {
                            next = it5.next();
                            if (it5.hasNext()) {
                                long j3 = jArr2[next.intValue()];
                                do {
                                    Integer next3 = it5.next();
                                    long j16 = jArr2[next3.intValue()];
                                    if (j3 < j16) {
                                        next = next3;
                                        j3 = j16;
                                    }
                                } while (it5.hasNext());
                            }
                        }
                        long[] f16 = f(jArr2, next, musicDurationInMillis, arrayList);
                        double d16 = CalculateHelperKt.d(f16);
                        jArr[i17] = f16;
                        if (d16 == 0.0d) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            final long[] jArr3 = jArr[i17 - 2];
                            PriorityQueue priorityQueue = new PriorityQueue(2, new Comparator() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.b
                                @Override // java.util.Comparator
                                public final int compare(Object obj2, Object obj3) {
                                    int e16;
                                    e16 = AutoClipAlgorithmV2.e(jArr3, (Integer) obj2, (Integer) obj3);
                                    return e16;
                                }
                            });
                            int length = jArr3.length;
                            for (int i18 = 0; i18 < length; i18++) {
                                priorityQueue.add(Integer.valueOf(i18));
                                if (priorityQueue.size() > 2) {
                                    priorityQueue.poll();
                                }
                            }
                            Object maxI1 = priorityQueue.poll();
                            Object maxI2 = priorityQueue.poll();
                            Integer num = (Integer) maxI2;
                            Intrinsics.checkNotNullExpressionValue(maxI1, "maxI1");
                            int intValue = ((Number) maxI1).intValue();
                            Intrinsics.checkNotNullExpressionValue(maxI2, "maxI2");
                            if (intValue > ((Number) maxI2).intValue()) {
                                obj = maxI2;
                            } else {
                                obj = maxI1;
                                maxI1 = maxI2;
                            }
                            long[] f17 = f(f(jArr3, (Integer) maxI1, musicDurationInMillis, arrayList), (Integer) obj, musicDurationInMillis, arrayList);
                            double d17 = CalculateHelperKt.d(f17);
                            if (d17 < d16) {
                                jArr[i17] = f17;
                                d16 = d17;
                            }
                            if (d17 == 0.0d) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                long[] j17 = j(jArr3, num, musicDurationInMillis, arrayList);
                                double d18 = CalculateHelperKt.d(j17);
                                if (d18 < d16) {
                                    jArr[i17] = j17;
                                }
                                if (d18 == 0.0d) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                            }
                        }
                        if (i17 != count) {
                            break;
                        }
                        i17++;
                    } else {
                        jArr[i17] = h(totalDuration, i17, musicDurationInMillis, arrayList);
                    }
                } else {
                    jArr[i17][0] = totalDuration;
                }
                QLog.i("AutoClipAlgorithmV2", 1, "dp[" + i17 + "]=" + Arrays.toString(jArr[i17]));
                if (i17 != count) {
                }
            }
        }
        return jArr[count];
    }

    @Override // com.tencent.mobileqq.wink.editor.smartclip.algorithm.e
    public long b(@NotNull List<MusicTimePoint> musicTimePoints, long musicDurationInMillis, long sourceTotalDuration, int sourceCount) {
        boolean z16;
        Intrinsics.checkNotNullParameter(musicTimePoints, "musicTimePoints");
        if (sourceTotalDuration <= 10000) {
            return 10000L;
        }
        List<MusicTimePoint> list = musicTimePoints;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((MusicTimePoint) next).getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((MusicTimePoint) obj).getType() != MusicTimePoint.MusicTimePointType.BEAT_TYPE_PARAGRAPH) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList.isEmpty() && !arrayList2.isEmpty()) {
            return d(arrayList2, musicDurationInMillis, sourceTotalDuration, sourceCount);
        }
        QLog.i("AutoClipAlgorithmV2", 1, "no paragraphs or no beats, use V1");
        return d(arrayList2, musicDurationInMillis, sourceTotalDuration, sourceCount);
    }
}
