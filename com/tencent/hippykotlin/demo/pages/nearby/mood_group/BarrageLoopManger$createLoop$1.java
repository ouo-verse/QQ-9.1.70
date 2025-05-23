package com.tencent.hippykotlin.demo.pages.nearby.mood_group;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BarrageDisplayInfoKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import h35.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BarrageLoopManger$createLoop$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ BarrageLoopManger this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarrageLoopManger$createLoop$1(BarrageLoopManger barrageLoopManger) {
        super(0);
        this.this$0 = barrageLoopManger;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List<h35.a>, java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        Unit unit;
        int coerceAtMost;
        List shuffled;
        List<a> take;
        int collectionSizeOrDefault;
        int coerceAtMost2;
        List shuffled2;
        List take2;
        NBPMoodGroupConfig.BarrageConfig barrageConfig;
        Object random;
        NBPMoodGroupConfig.BarrageConfig barrageConfig2;
        List<NBPMoodGroupConfig.BarrageItemConfig> list;
        BarrageLoopManger barrageLoopManger = this.this$0;
        if (barrageLoopManger.mangerState != 1) {
            Long l3 = barrageLoopManger.barrageTime;
            ArrayList arrayList = null;
            if (l3 != null) {
                long longValue = l3.longValue();
                if (longValue - APICallTechReporterKt.NBPCurrentTime() <= 0) {
                    BarrageLoopManger.access$realBarrage(barrageLoopManger);
                    KLog.INSTANCE.i("BarrageLoopManger", "barrage real time, " + longValue + ", " + MangerState$EnumUnboxingLocalUtility.stringValueOf(barrageLoopManger.mangerState));
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                BarrageLoopManger barrageLoopManger2 = this.this$0;
                BarrageLoopManger.access$realBarrage(barrageLoopManger2);
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("barrage real time is null, ");
                m3.append(MangerState$EnumUnboxingLocalUtility.stringValueOf(barrageLoopManger2.mangerState));
                kLog.i("BarrageLoopManger", m3.toString());
            }
            final BarrageLoopManger barrageLoopManger3 = this.this$0;
            int i3 = barrageLoopManger3.nonRealTimes - 1;
            barrageLoopManger3.nonRealTimes = i3;
            if (i3 <= 0) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(barrageLoopManger3.historyBarrage.size(), 3);
                shuffled = CollectionsKt__CollectionsJVMKt.shuffled(barrageLoopManger3.historyBarrage);
                take = CollectionsKt___CollectionsKt.take(shuffled, coerceAtMost);
                for (final a aVar : take) {
                    TimerKt.d(Random.INSTANCE.nextInt(0, 1001), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$unrealSend$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            BarrageLoopManger.this.onNewBarrage(aVar, null);
                            return Unit.INSTANCE;
                        }
                    });
                }
                List<UserMarkerInfo> markerList = barrageLoopManger3.util.getMarkerList();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : markerList) {
                    if (((UserMarkerInfo) obj).user.F == 1) {
                        arrayList2.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(Long.valueOf(((UserMarkerInfo) it.next()).user.f444488d));
                }
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(arrayList3.size(), 3);
                shuffled2 = CollectionsKt__CollectionsJVMKt.shuffled(arrayList3);
                take2 = CollectionsKt___CollectionsKt.take(shuffled2, coerceAtMost2);
                NBPMoodGroupConfig moodConfig = barrageLoopManger3.util.getMoodConfig();
                if (moodConfig != null && (barrageConfig2 = moodConfig.barrageConfig) != null && (list = barrageConfig2.items) != null) {
                    arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (!((NBPMoodGroupConfig.BarrageItemConfig) obj2).canReplyBarrage()) {
                            arrayList.add(obj2);
                        }
                    }
                }
                Iterator it5 = take2.iterator();
                while (it5.hasNext()) {
                    long longValue2 = ((Number) it5.next()).longValue();
                    if (arrayList != null) {
                        Random.Companion companion = Random.INSTANCE;
                        random = CollectionsKt___CollectionsKt.random(arrayList, companion);
                        NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) random;
                        if (barrageItemConfig != null) {
                            final a createLocalBarrage$default = BarrageDisplayInfoKt.createLocalBarrage$default(Long.parseLong(barrageItemConfig.f114228id), longValue2, barrageItemConfig.text);
                            TimerKt.d(companion.nextInt(0, 1001), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$unrealSend$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    BarrageLoopManger.this.onNewBarrage(createLocalBarrage$default, null);
                                    return Unit.INSTANCE;
                                }
                            });
                        }
                    }
                }
                BarrageLoopManger barrageLoopManger4 = this.this$0;
                NBPMoodGroupConfig moodConfig2 = barrageLoopManger4.util.getMoodConfig();
                barrageLoopManger4.nonRealTimes = ((moodConfig2 == null || (barrageConfig = moodConfig2.barrageConfig) == null) ? 3000 : barrageConfig.localLoopTime) / 1000;
                KLog kLog2 = KLog.INSTANCE;
                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("barrage nonReal time, ");
                m16.append(MangerState$EnumUnboxingLocalUtility.stringValueOf(this.this$0.mangerState));
                kLog2.i("BarrageLoopManger", m16.toString());
            }
            BarrageLoopManger barrageLoopManger5 = this.this$0;
            barrageLoopManger5.getClass();
            barrageLoopManger5.loop = TimerKt.d(1000, new BarrageLoopManger$createLoop$1(barrageLoopManger5));
        }
        return Unit.INSTANCE;
    }
}
