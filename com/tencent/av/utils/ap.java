package com.tencent.av.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0006\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0005R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/av/utils/ap;", "", "", "step", "action", "", "a", "b", "", "J", "reportStartTime", "", "Lcom/tencent/av/utils/ap$b;", "Ljava/util/Map;", "stepCostTimeMap", "<init>", "()V", "c", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long reportStartTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, b> stepCostTimeMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/av/utils/ap$b;", "", "", "d", "", "b", "", "toString", "a", "Ljava/lang/String;", "getStepName", "()Ljava/lang/String;", "setStepName", "(Ljava/lang/String;)V", "stepName", "", "J", "c", "()J", "e", "(J)V", "startTime", "Ljava/util/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setCostTime", "(Ljava/util/ArrayList;)V", "costTime", "<init>", "qqrtc-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String stepName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<Long> costTime;

        public b(@NotNull String stepName) {
            Intrinsics.checkNotNullParameter(stepName, "stepName");
            this.stepName = stepName;
            this.costTime = new ArrayList<>();
        }

        @NotNull
        public final ArrayList<Long> a() {
            return this.costTime;
        }

        public final int b() {
            Iterator<Long> it = this.costTime.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Long costTime = it.next();
                Intrinsics.checkNotNullExpressionValue(costTime, "costTime");
                if (costTime.longValue() > 80) {
                    i3++;
                }
            }
            return i3;
        }

        /* renamed from: c, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public final void d() {
            this.costTime.clear();
        }

        public final void e(long j3) {
            this.startTime = j3;
        }

        @NotNull
        public String toString() {
            Comparable maxOrNull;
            Comparable minOrNull;
            double averageOfLong;
            maxOrNull = CollectionsKt___CollectionsKt.maxOrNull((Iterable<? extends Comparable>) this.costTime);
            minOrNull = CollectionsKt___CollectionsKt.minOrNull((Iterable<? extends Comparable>) this.costTime);
            averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(this.costTime);
            int b16 = b();
            return this.stepName + " costTime max: " + ((Long) maxOrNull) + ", min: " + ((Long) minOrNull) + ", average: " + averageOfLong + ", overLimitTimeCounts: " + b16;
        }
    }

    public ap() {
        Map<Integer, b> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(0, new b("STEP_PRE_RENDER")), TuplesKt.to(1, new b("STEP_AE_FILTER_RENDER")), TuplesKt.to(2, new b("STEP_FACE_DETECTED")), TuplesKt.to(3, new b("STEP_POST_RENDER")), TuplesKt.to(4, new b("STEP_AE_DRAW_FRAME")));
        this.stepCostTimeMap = mapOf;
    }

    public final void a(int step, int action) {
        if (step > -1 && step < 5) {
            if (action >= 0 && action <= 1) {
                b bVar = this.stepCostTimeMap.get(Integer.valueOf(step));
                Intrinsics.checkNotNull(bVar);
                b bVar2 = bVar;
                if (action != 0) {
                    if (action == 1 && bVar2.a().size() < 10000) {
                        bVar2.a().add(Long.valueOf(System.currentTimeMillis() - bVar2.getStartTime()));
                        return;
                    }
                    return;
                }
                if (this.reportStartTime == 0) {
                    this.reportStartTime = System.currentTimeMillis();
                }
                bVar2.e(System.currentTimeMillis());
                return;
            }
            QLog.e("RenderStepTimeRecorder", 1, "invalid action");
            return;
        }
        QLog.e("RenderStepTimeRecorder", 1, "invalid step");
    }

    public final void b() {
        if (System.currentTimeMillis() - this.reportStartTime >= 10000) {
            this.reportStartTime = 0L;
            for (Map.Entry<Integer, b> entry : this.stepCostTimeMap.entrySet()) {
                QLog.i("RenderStepTimeRecorder", 1, entry.getValue().toString());
                entry.getValue().d();
            }
        }
    }
}
