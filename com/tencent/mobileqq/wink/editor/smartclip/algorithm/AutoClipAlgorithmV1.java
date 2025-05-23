package com.tencent.mobileqq.wink.editor.smartclip.algorithm;

import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.smartclip.FindDirection;
import com.tencent.mobileqq.wink.editor.smartclip.algorithm.MusicTimePoint;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0011\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J7\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u000fJ0\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J.\u0010\u0018\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/AutoClipAlgorithmV1;", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/e;", "", "duration", "", DomainData.DOMAIN_NAME, "sourceDuration", "", "Lcom/tencent/mobileqq/wink/editor/smartclip/algorithm/MusicTimePoint;", "beats", "", "f", "durations", "maxIdx", "e", "([JLjava/lang/Integer;JLjava/util/List;)[J", "g", "count", "musicDuration", "a", "musicTimePoints", "musicDurationInMillis", "sourceTotalDuration", "sourceCount", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class AutoClipAlgorithmV1 implements e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(long[] pre2, Integer c16, Integer c26) {
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

    private final long[] e(long[] durations, Integer maxIdx, long sourceDuration, List<MusicTimePoint> beats) {
        IntRange until;
        Intrinsics.checkNotNull(maxIdx);
        long j3 = durations[maxIdx.intValue()];
        until = RangesKt___RangesKt.until(0, maxIdx.intValue());
        Iterator<Integer> it = until.iterator();
        long j16 = 0;
        while (it.hasNext()) {
            j16 += durations[((IntIterator) it).nextInt()];
        }
        long j17 = j3 / 2;
        c f16 = CalculateHelperKt.f(j16 + j17, sourceDuration, beats, new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$halveMaxClip$near$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM);
            }
        }, FindDirection.BACKWARD, 0L, 32, null);
        if (f16 != null) {
            j17 = f16.a() - j16;
        }
        long[] copyOf = Arrays.copyOf(durations, durations.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[maxIdx.intValue()] = j17;
        copyOf[maxIdx.intValue() + 1] = j3 - j17;
        System.arraycopy(durations, maxIdx.intValue() + 1, copyOf, maxIdx.intValue() + 2, (durations.length - maxIdx.intValue()) - 1);
        return copyOf;
    }

    private final long[] f(long duration, int n3, long sourceDuration, List<MusicTimePoint> beats) {
        long j3;
        long[] jArr = new long[n3];
        long j16 = duration / n3;
        long[] jArr2 = new long[n3];
        int i3 = n3 - 1;
        jArr2[i3] = duration;
        for (int i16 = 0; i16 < n3; i16++) {
            if (i16 != i3) {
                c e16 = CalculateHelperKt.e(j16, sourceDuration, beats, new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$splitN2or3$near$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull MusicTimePoint it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM);
                    }
                }, FindDirection.BI_DIRECTION, 1000L);
                if (e16 == null) {
                    e16 = CalculateHelperKt.e(j16, sourceDuration, beats, new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$splitN2or3$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final Boolean invoke(@NotNull MusicTimePoint it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(it.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM);
                        }
                    }, FindDirection.BACKWARD, -1L);
                }
                if (e16 != null) {
                    j3 = e16.a();
                } else {
                    j3 = j16;
                }
                jArr2[i16] = j3;
            }
            if (i16 == 0) {
                jArr[i16] = jArr2[i16] - 0;
            } else {
                jArr[i16] = jArr2[i16] - jArr2[i16 - 1];
            }
            j16 <<= 1;
        }
        return jArr;
    }

    private final long[] g(long[] durations, Integer maxIdx, long sourceDuration, List<MusicTimePoint> beats) {
        IntRange until;
        long j3;
        Intrinsics.checkNotNull(maxIdx);
        long j16 = durations[maxIdx.intValue()];
        until = RangesKt___RangesKt.until(0, maxIdx.intValue());
        Iterator<Integer> it = until.iterator();
        long j17 = 0;
        while (it.hasNext()) {
            j17 += durations[((IntIterator) it).nextInt()];
        }
        long j18 = j16 / 3;
        AutoClipAlgorithmV1$trisectMaxClip$near$1 autoClipAlgorithmV1$trisectMaxClip$near$1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$trisectMaxClip$near$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM);
            }
        };
        FindDirection findDirection = FindDirection.BACKWARD;
        c f16 = CalculateHelperKt.f(j17 + j18, sourceDuration, beats, autoClipAlgorithmV1$trisectMaxClip$near$1, findDirection, 0L, 32, null);
        if (f16 != null) {
            j3 = f16.a() - j17;
        } else {
            j3 = j18;
        }
        long j19 = j18 * 2;
        c f17 = CalculateHelperKt.f(j17 + j19, sourceDuration, beats, new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$trisectMaxClip$near2$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it5) {
                Intrinsics.checkNotNullParameter(it5, "it");
                return Boolean.valueOf(it5.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM);
            }
        }, findDirection, 0L, 32, null);
        if (f17 != null) {
            j19 = f17.a() - j17;
        }
        long j26 = j19 - j3;
        long[] copyOf = Arrays.copyOf(durations, durations.length + 2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[maxIdx.intValue()] = j3;
        copyOf[maxIdx.intValue() + 1] = j26;
        copyOf[maxIdx.intValue() + 2] = (j16 - j3) - j26;
        System.arraycopy(durations, maxIdx.intValue() + 1, copyOf, maxIdx.intValue() + 3, (durations.length - maxIdx.intValue()) - 1);
        return copyOf;
    }

    @Override // com.tencent.mobileqq.wink.editor.smartclip.algorithm.e
    @Nullable
    public long[] a(long duration, int count, @NotNull List<MusicTimePoint> beats, long musicDuration) {
        IntRange indices;
        Integer next;
        boolean z16;
        Object obj;
        Object obj2;
        boolean z17;
        Intrinsics.checkNotNullParameter(beats, "beats");
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
                        Iterator<Integer> it = indices.iterator();
                        if (!it.hasNext()) {
                            next = null;
                        } else {
                            next = it.next();
                            if (it.hasNext()) {
                                long j3 = jArr2[next.intValue()];
                                do {
                                    Integer next2 = it.next();
                                    long j16 = jArr2[next2.intValue()];
                                    if (j3 < j16) {
                                        next = next2;
                                        j3 = j16;
                                    }
                                } while (it.hasNext());
                            }
                        }
                        long[] e16 = e(jArr2, next, musicDuration, beats);
                        double d16 = CalculateHelperKt.d(e16);
                        jArr[i17] = e16;
                        if (d16 == 0.0d) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            final long[] jArr3 = jArr[i17 - 2];
                            PriorityQueue priorityQueue = new PriorityQueue(2, new Comparator() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.a
                                @Override // java.util.Comparator
                                public final int compare(Object obj3, Object obj4) {
                                    int d17;
                                    d17 = AutoClipAlgorithmV1.d(jArr3, (Integer) obj3, (Integer) obj4);
                                    return d17;
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
                                obj2 = maxI1;
                            } else {
                                obj = maxI1;
                                obj2 = maxI2;
                            }
                            long[] e17 = e(e(jArr3, (Integer) obj2, musicDuration, beats), (Integer) obj, musicDuration, beats);
                            double d17 = CalculateHelperKt.d(e17);
                            if (d17 < d16) {
                                jArr[i17] = e17;
                                d16 = d17;
                            }
                            if (d17 == 0.0d) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                long[] g16 = g(jArr3, num, musicDuration, beats);
                                if (CalculateHelperKt.d(g16) < d16) {
                                    jArr[i17] = g16;
                                }
                            }
                        }
                    } else {
                        jArr[i17] = f(duration, i17, musicDuration, beats);
                    }
                } else {
                    jArr[i17][0] = duration;
                }
                if (i17 == count) {
                    break;
                }
                i17++;
            }
        }
        return jArr[count];
    }

    @Override // com.tencent.mobileqq.wink.editor.smartclip.algorithm.e
    public long b(@NotNull List<MusicTimePoint> musicTimePoints, long musicDurationInMillis, long sourceTotalDuration, int sourceCount) {
        Intrinsics.checkNotNullParameter(musicTimePoints, "musicTimePoints");
        long j3 = 15000;
        if (sourceTotalDuration < 15000) {
            j3 = 10000;
        }
        long j16 = j3;
        if (musicTimePoints.isEmpty()) {
            return j16;
        }
        AutoClipAlgorithmV1$calculateTargetDuration$acceptBeat$1 autoClipAlgorithmV1$calculateTargetDuration$acceptBeat$1 = new Function1<MusicTimePoint, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.smartclip.algorithm.AutoClipAlgorithmV1$calculateTargetDuration$acceptBeat$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull MusicTimePoint it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_PUCKING_DRUM || it.getType() == MusicTimePoint.MusicTimePointType.BEAT_TYPE_SLOW_RHYTHM);
            }
        };
        int b16 = CalculateHelperKt.b(musicTimePoints, musicDurationInMillis, 15000L, false, autoClipAlgorithmV1$calculateTargetDuration$acceptBeat$1, 0L, 40, null);
        QLog.i("AutoClipAlgorithmV1", 1, "calculate total duration, beats count in 15s=" + b16);
        if (sourceCount > b16) {
            j16 = 30000;
        }
        c f16 = CalculateHelperKt.f(j16, musicDurationInMillis, musicTimePoints, autoClipAlgorithmV1$calculateTargetDuration$acceptBeat$1, FindDirection.BACKWARD, 0L, 32, null);
        QLog.i("AutoClipAlgorithmV1", 1, "calculate total duration, nearest beat=" + f16);
        if (f16 != null) {
            return f16.a();
        }
        return j16;
    }
}
