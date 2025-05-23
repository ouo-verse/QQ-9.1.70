package com.tencent.hippykotlin.demo.pages.nearby.mood_group;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.INBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.repo.NBPMoodGroupRepo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.BarrageDisplayInfoKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.playground.UserMarkerInfo;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import h35.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k35.e;
import k35.p;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BarrageLoopManger {
    public Long barrageTime;
    public final List<a> historyBarrage;
    public String loop;
    public int mangerState;
    public final Set<String> msgIdSet;
    public int nonRealTimes;
    public int pageVisibleState;
    public boolean realBarrageRequest;
    public final Lazy repo$delegate;
    public final NBPMoodGroupReportViewModel reporter;
    public final IBarrageLoop util;

    public BarrageLoopManger(NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel, IBarrageLoop iBarrageLoop) {
        Lazy lazy;
        this.reporter = nBPMoodGroupReportViewModel;
        this.util = iBarrageLoop;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NBPMoodGroupRepo>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final NBPMoodGroupRepo invoke() {
                return new NBPMoodGroupRepo();
            }
        });
        this.repo$delegate = lazy;
        this.msgIdSet = new LinkedHashSet();
        this.historyBarrage = new ArrayList();
        this.pageVisibleState = 1;
        this.mangerState = 1;
    }

    public static final boolean access$isNewId(BarrageLoopManger barrageLoopManger, String str) {
        if (barrageLoopManger.msgIdSet.contains(str)) {
            return false;
        }
        return barrageLoopManger.msgIdSet.add(str);
    }

    public static final void access$realBarrage(final BarrageLoopManger barrageLoopManger) {
        int collectionSizeOrDefault;
        if (barrageLoopManger.util.getCurrentPageState() == NBPMoodGroupPageState.SUCCESS && !barrageLoopManger.realBarrageRequest) {
            barrageLoopManger.realBarrageRequest = true;
            List<UserMarkerInfo> markerList = barrageLoopManger.util.getMarkerList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : markerList) {
                if (((UserMarkerInfo) obj).user.F == 0) {
                    arrayList.add(obj);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(((UserMarkerInfo) it.next()).user.f444488d));
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 == null) {
                return;
            }
            ((INBPMoodGroupRepo) barrageLoopManger.repo$delegate.getValue()).getBarrage(barrageLoopManger.util.getMid(), arrayList2, new Function3<e, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$realBarrage$1
                {
                    super(3);
                }

                /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List<h35.a>, java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r8v1, types: [java.util.List<h35.a>, java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r8v19, types: [java.util.List<h35.a>, java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r8v23, types: [java.util.List<h35.a>, java.util.ArrayList] */
                @Override // kotlin.jvm.functions.Function3
                public final Unit invoke(e eVar, Integer num, String str) {
                    long j3;
                    Collection<a> collection;
                    List<a> list;
                    Object obj2;
                    NBPMoodGroupConfig.BarrageConfig barrageConfig;
                    List<NBPMoodGroupConfig.BarrageItemConfig> list2;
                    Object obj3;
                    NBPMoodGroupConfig.BarrageConfig barrageConfig2;
                    List<NBPMoodGroupConfig.BarrageItemConfig> list3;
                    Object obj4;
                    List<a> list4;
                    int mapCapacity;
                    Object next;
                    long j16;
                    NBPMoodGroupConfig.BarrageConfig barrageConfig3;
                    e eVar2 = eVar;
                    num.intValue();
                    BarrageLoopManger barrageLoopManger2 = BarrageLoopManger.this;
                    barrageLoopManger2.realBarrageRequest = false;
                    NBPMoodGroupConfig moodConfig = barrageLoopManger2.util.getMoodConfig();
                    long j17 = (moodConfig == null || (barrageConfig3 = moodConfig.barrageConfig) == null) ? 5000 : barrageConfig3.requestLoopDefaultTime;
                    BarrageLoopManger.this.barrageTime = Long.valueOf(APICallTechReporterKt.NBPCurrentTime() + (eVar2 != null ? RangesKt___RangesKt.coerceAtLeast(eVar2.f411543e * 1000, j17) : j17));
                    if (eVar2 == null || (list4 = eVar2.f411542d) == null) {
                        j3 = j17;
                        collection = null;
                    } else {
                        BarrageLoopManger barrageLoopManger3 = BarrageLoopManger.this;
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj5 : list4) {
                            if (BarrageLoopManger.access$isNewId(barrageLoopManger3, ((a) obj5).f404268d)) {
                                arrayList3.add(obj5);
                            }
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Iterator it5 = arrayList3.iterator();
                        while (it5.hasNext()) {
                            Object next2 = it5.next();
                            Long valueOf = Long.valueOf(((a) next2).f404269e);
                            Object obj6 = linkedHashMap.get(valueOf);
                            if (obj6 == null) {
                                obj6 = new ArrayList();
                                linkedHashMap.put(valueOf, obj6);
                            }
                            ((List) obj6).add(next2);
                        }
                        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size());
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap(mapCapacity);
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            Object key = entry.getKey();
                            Iterator it6 = ((Iterable) entry.getValue()).iterator();
                            if (it6.hasNext()) {
                                next = it6.next();
                                if (it6.hasNext()) {
                                    long j18 = ((a) next).f404272i;
                                    while (true) {
                                        Object next3 = it6.next();
                                        j16 = j17;
                                        long j19 = ((a) next3).f404272i;
                                        if (j18 < j19) {
                                            j18 = j19;
                                            next = next3;
                                        }
                                        if (!it6.hasNext()) {
                                            break;
                                        }
                                        j17 = j16;
                                    }
                                } else {
                                    j16 = j17;
                                }
                            } else {
                                j16 = j17;
                                next = null;
                            }
                            linkedHashMap2.put(key, (a) next);
                            j17 = j16;
                        }
                        j3 = j17;
                        collection = linkedHashMap2.values();
                    }
                    if (collection != null) {
                        BarrageLoopManger barrageLoopManger4 = BarrageLoopManger.this;
                        for (a aVar : collection) {
                            Iterator it7 = barrageLoopManger4.historyBarrage.iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it7.next();
                                if (aVar != null && ((a) obj2).f404269e == aVar.f404269e) {
                                    break;
                                }
                            }
                            a aVar2 = (a) obj2;
                            if (aVar2 != null) {
                                barrageLoopManger4.historyBarrage.remove(aVar2);
                            }
                            NBPMoodGroupConfig moodConfig2 = barrageLoopManger4.util.getMoodConfig();
                            if (moodConfig2 != null && (barrageConfig = moodConfig2.barrageConfig) != null && (list2 = barrageConfig.items) != null) {
                                Iterator<T> it8 = list2.iterator();
                                while (true) {
                                    if (!it8.hasNext()) {
                                        obj3 = null;
                                        break;
                                    }
                                    obj3 = it8.next();
                                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj3).f114228id, String.valueOf(aVar != null ? Long.valueOf(aVar.f404271h) : null))) {
                                        break;
                                    }
                                }
                                NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj3;
                                if (barrageItemConfig != null) {
                                    if (aVar != null && aVar.f404269e == UserDataManager.INSTANCE.getUserSelfInfo().tid) {
                                        if (barrageItemConfig.canReplyBarrage()) {
                                            NBPMoodGroupConfig moodConfig3 = barrageLoopManger4.util.getMoodConfig();
                                            if (moodConfig3 != null && (barrageConfig2 = moodConfig3.barrageConfig) != null && (list3 = barrageConfig2.items) != null) {
                                                Iterator<T> it9 = list3.iterator();
                                                while (true) {
                                                    if (!it9.hasNext()) {
                                                        obj4 = null;
                                                        break;
                                                    }
                                                    obj4 = it9.next();
                                                    if (((NBPMoodGroupConfig.BarrageItemConfig) obj4).joinAutoShow) {
                                                        break;
                                                    }
                                                }
                                                NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig2 = (NBPMoodGroupConfig.BarrageItemConfig) obj4;
                                                if (barrageItemConfig2 != null) {
                                                    barrageLoopManger4.onNewBarrage(new a("-1", UserDataManager.INSTANCE.getUserSelfInfo().tid, barrageItemConfig2.text, Long.parseLong(barrageItemConfig2.f114228id), aVar.f404272i), null);
                                                }
                                            }
                                        } else {
                                            barrageLoopManger4.onNewBarrage(aVar, null);
                                        }
                                    } else if (aVar != null) {
                                        if (APICallTechReporterKt.NBPCurrentTime() - (aVar.f404272i * 1000) < 20000) {
                                            barrageLoopManger4.onNewBarrage(aVar, null);
                                        } else if (!barrageItemConfig.canReplyBarrage()) {
                                            barrageLoopManger4.historyBarrage.add(aVar);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("barrage repo time last=");
                    m3.append(eVar2 != null ? Long.valueOf(eVar2.f411543e * 1000) : null);
                    m3.append(", pageVisibleState=");
                    m3.append(NBPMoodGroupPageVisibleState$EnumUnboxingLocalUtility.stringValueOf(BarrageLoopManger.this.pageVisibleState));
                    m3.append(", size=");
                    m3.append((eVar2 == null || (list = eVar2.f411542d) == null) ? null : Integer.valueOf(list.size()));
                    m3.append(", uniqueBarrages=");
                    m3.append(collection != null ? Integer.valueOf(collection.size()) : null);
                    m3.append(", historyBarrage=");
                    m3.append(BarrageLoopManger.this.historyBarrage.size());
                    m3.append(",mangerState=");
                    m3.append(MangerState$EnumUnboxingLocalUtility.stringValueOf(BarrageLoopManger.this.mangerState));
                    m3.append(",defaultTime=");
                    m3.append(j3);
                    kLog.i("BarrageLoopManger", m3.toString());
                    return Unit.INSTANCE;
                }
            });
        }
    }

    public final boolean cancelSend() {
        return this.util.isShooting() || this.mangerState == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if (r5 == false) goto L33;
     */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<h35.a>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void sendBarrage(NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig, boolean z16) {
        Long longOrNull;
        boolean z17;
        NBPMoodGroupConfig.BarrageConfig barrageConfig;
        List<NBPMoodGroupConfig.BarrageItemConfig> list;
        Object obj;
        ((INBPMoodGroupRepo) this.repo$delegate.getValue()).sendBarrage(this.util.getMid(), Long.parseLong(barrageItemConfig.f114228id), new Function3<p, Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$sendBarrage$1
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(p pVar, Integer num, String str) {
                KLog.INSTANCE.i("NBPMoodGroupViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("sendBarrage api,code=", num.intValue(), ",msg=", str));
                return Unit.INSTANCE;
            }
        });
        long j3 = UserDataManager.INSTANCE.getUserSelfInfo().tid;
        String str = barrageItemConfig.text;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(barrageItemConfig.f114228id);
        a createLocalBarrage$default = BarrageDisplayInfoKt.createLocalBarrage$default(longOrNull != null ? longOrNull.longValue() : 0L, j3, str);
        onNewBarrage(createLocalBarrage$default, null);
        if (z16) {
            NBPMoodGroupConfig moodConfig = this.util.getMoodConfig();
            ?? r16 = this.historyBarrage;
            ArrayList arrayList = new ArrayList();
            Iterator it = r16.iterator();
            while (true) {
                boolean z18 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                a aVar = (a) next;
                if (aVar.f404271h == createLocalBarrage$default.f404271h) {
                    if (moodConfig != null && (barrageConfig = moodConfig.barrageConfig) != null && (list = barrageConfig.items) != null) {
                        Iterator<T> it5 = list.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                obj = null;
                                break;
                            } else {
                                obj = it5.next();
                                if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj).f114228id, String.valueOf(aVar.f404271h))) {
                                    break;
                                }
                            }
                        }
                        NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig2 = (NBPMoodGroupConfig.BarrageItemConfig) obj;
                        if (barrageItemConfig2 != null && barrageItemConfig2.sameAutoShow) {
                            z17 = true;
                        }
                    }
                    z17 = false;
                }
                z18 = false;
                if (z18) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    onNewBarrage((a) it6.next(), null);
                }
            }
        }
    }

    public final void resume() {
        this.mangerState = 2;
        String str = this.loop;
        if (str != null) {
            TimerKt.b(str);
            this.loop = null;
        }
        this.loop = TimerKt.d(1000, new BarrageLoopManger$createLoop$1(this));
    }

    public final void onNewBarrage(a aVar, NBPMoodGroupConfig.BubbleConfig bubbleConfig) {
        NBPMoodGroupConfig moodConfig;
        NBPMoodGroupConfig.BarrageConfig barrageConfig;
        List<NBPMoodGroupConfig.BarrageItemConfig> list;
        Object obj;
        final NBPMoodGroupConfig.BarrageLocalReplyEffect barrageLocalReplyEffect;
        NBPMoodGroupConfig moodConfig2;
        NBPMoodGroupConfig.BarrageConfig barrageConfig2;
        List<NBPMoodGroupConfig.BarrageItemConfig> list2;
        Object obj2;
        a aVar2 = aVar;
        if (cancelSend()) {
            return;
        }
        Object obj3 = null;
        if ((aVar2.f404270f.length() == 0) && (moodConfig2 = this.util.getMoodConfig()) != null && (barrageConfig2 = moodConfig2.barrageConfig) != null && (list2 = barrageConfig2.items) != null) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj2).f114228id, String.valueOf(aVar2.f404271h))) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig = (NBPMoodGroupConfig.BarrageItemConfig) obj2;
            if (barrageItemConfig != null) {
                aVar2 = new a(aVar2.f404268d, aVar2.f404269e, barrageItemConfig.text, aVar2.f404271h, aVar2.f404272i);
            }
        }
        if (UserDataManager.INSTANCE.isHostTid(Long.valueOf(aVar2.f404269e)) && (moodConfig = this.util.getMoodConfig()) != null && (barrageConfig = moodConfig.barrageConfig) != null && (list = barrageConfig.items) != null) {
            Iterator<T> it5 = list.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.BarrageItemConfig) obj).f114228id, String.valueOf(aVar2.f404271h))) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            NBPMoodGroupConfig.BarrageItemConfig barrageItemConfig2 = (NBPMoodGroupConfig.BarrageItemConfig) obj;
            if (barrageItemConfig2 != null && (barrageLocalReplyEffect = barrageItemConfig2.localReplyEffect) != null) {
                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6c42\u5938\u5938 localReplyEffect.autoReplyDuring="), barrageLocalReplyEffect.autoReplyDuring, KLog.INSTANCE, "BarrageLoopManger");
                List<UserMarkerInfo> markerList = this.util.getMarkerList();
                ArrayList<UserMarkerInfo> arrayList = new ArrayList();
                for (Object obj4 : markerList) {
                    if (!((UserMarkerInfo) obj4).isHost()) {
                        arrayList.add(obj4);
                    }
                }
                for (final UserMarkerInfo userMarkerInfo : arrayList) {
                    TimerKt.d(Random.INSTANCE.nextInt(0, barrageLocalReplyEffect.autoReplyDuring), new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.BarrageLoopManger$onNewBarrage$4$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            Object random;
                            NBPMoodGroupConfig.UserMarkerConfig userMarkerConfig;
                            if (!BarrageLoopManger.this.cancelSend()) {
                                NBPMoodGroupConfig.BarrageLocalReplyEffect barrageLocalReplyEffect2 = barrageLocalReplyEffect;
                                String str = UserDataManager.INSTANCE.getUserSelfInfo().nickName;
                                random = CollectionsKt___CollectionsKt.random(barrageLocalReplyEffect2.texts, Random.INSTANCE);
                                String str2 = (String) random;
                                if (str.length() > 8) {
                                    StringBuilder sb5 = new StringBuilder();
                                    String substring = str.substring(0, 6);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                    sb5.append(substring);
                                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                    str = sb5.toString();
                                }
                                if (barrageLocalReplyEffect2.needRefNick) {
                                    str2 = '@' + str + TokenParser.SP + str2;
                                }
                                a createLocalBarrage$default = BarrageDisplayInfoKt.createLocalBarrage$default(-1L, userMarkerInfo.user.f444488d, str2);
                                UserMarkerInfo userMarkerInfo2 = userMarkerInfo;
                                BarrageLoopManger barrageLoopManger = BarrageLoopManger.this;
                                NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel = barrageLoopManger.reporter;
                                NBPMoodGroupConfig moodConfig3 = barrageLoopManger.util.getMoodConfig();
                                userMarkerInfo2.showBarrage(nBPMoodGroupReportViewModel, createLocalBarrage$default, (moodConfig3 == null || (userMarkerConfig = moodConfig3.userMarkerConfig) == null) ? null : userMarkerConfig.localEffectBubbleConfig);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                }
            }
        }
        Iterator<T> it6 = this.util.getMarkerList().iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next = it6.next();
            if (((UserMarkerInfo) next).user.f444488d == aVar2.f404269e) {
                obj3 = next;
                break;
            }
        }
        UserMarkerInfo userMarkerInfo2 = (UserMarkerInfo) obj3;
        if (userMarkerInfo2 != null) {
            userMarkerInfo2.showBarrage(this.reporter, aVar2, bubbleConfig);
        }
    }
}
