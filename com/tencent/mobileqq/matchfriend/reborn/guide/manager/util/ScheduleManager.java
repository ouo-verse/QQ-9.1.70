package com.tencent.mobileqq.matchfriend.reborn.guide.manager.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J@\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u0007J\"\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002J>\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u0018R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR9\u0010)\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0%0$0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager;", "", "", "key", "e", "actualName", "groupName", "", "index", "", "g", "", "", "set", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "obj", "name", "limitTimes", "windowSize", "totalExecutionTimes", h.F, "a", "", "c", "", "showTimeList", "oldTotalTimes", "isRestTotalTimes", "k", "Ljava/lang/String;", "totalTimesPrefix", "b", "treeSetPrefix", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Lazy;", "f", "()Ljava/util/concurrent/ConcurrentHashMap;", "initParamMap", "Lcom/google/gson/Gson;", "d", "Lcom/google/gson/Gson;", "gson", "businessTag", "<init>", "(Ljava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ScheduleManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String totalTimesPrefix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String treeSetPrefix;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy initParamMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Gson gson;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager$b", "Lcom/google/gson/reflect/TypeToken;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends TypeToken<TreeSet<Long>> {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager$c", "Lcom/google/gson/reflect/TypeToken;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c extends TypeToken<TreeSet<Long>> {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager$d", "Lcom/google/gson/reflect/TypeToken;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends TypeToken<TreeSet<Long>> {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/guide/manager/util/ScheduleManager$e", "Lcom/google/gson/reflect/TypeToken;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e extends TypeToken<TreeSet<Long>> {
    }

    public ScheduleManager(String businessTag) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(businessTag, "businessTag");
        this.totalTimesPrefix = businessTag + "_total_times";
        this.treeSetPrefix = businessTag + "_tree_set";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, Map<String, CopyOnWriteArrayList<Number>>>>() { // from class: com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager$initParamMap$2
            @Override // kotlin.jvm.functions.Function0
            public final ConcurrentHashMap<String, Map<String, CopyOnWriteArrayList<Number>>> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.initParamMap = lazy;
        this.gson = new Gson();
    }

    private final String e(String key) {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    private final ConcurrentHashMap<String, Map<String, CopyOnWriteArrayList<Number>>> f() {
        return (ConcurrentHashMap) this.initParamMap.getValue();
    }

    private final void j(String key, Set<Long> set) {
        String m3 = m(set);
        if (m3 != null) {
            QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putString(key, m3);
        }
    }

    public static /* synthetic */ void l(ScheduleManager scheduleManager, Object obj, String str, List list, int i3, boolean z16, int i16, Object obj2) {
        if ((i16 & 2) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i16 & 4) != 0) {
            list = null;
        }
        List list2 = list;
        if ((i16 & 8) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            z16 = false;
        }
        scheduleManager.k(obj, str2, list2, i17, z16);
    }

    private final String m(Set<Long> set) {
        try {
            return this.gson.toJson(set);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public final void a(Object obj, String name, String groupName) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        if (name.length() == 0) {
            name = obj.getClass().getSimpleName();
        }
        Map<String, CopyOnWriteArrayList<Number>> map = f().get(groupName);
        if (map == null || map.get(name) == null) {
            return;
        }
        String e16 = e(this.treeSetPrefix + "_" + name);
        String e17 = e(this.totalTimesPrefix + "_" + name);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        Collection collection = null;
        try {
            collection = (Set) this.gson.fromJson(QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(e16, null), new b().getType());
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        TreeSet treeSet = (TreeSet) collection;
        if (treeSet == null) {
            treeSet = new TreeSet();
        }
        fromV2.putInt(e17, fromV2.getInt(e17, Integer.MIN_VALUE) - 1);
        if (QLog.isColorLevel()) {
            QLog.d("ScheduleManager", 2, "The rest times of " + name + " is " + fromV2.getInt(e17, Integer.MIN_VALUE));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("ScheduleManager", 2, "The show record size of " + name + " is " + treeSet.size());
        }
        treeSet.add(Long.valueOf(currentTimeMillis));
        j(e16, treeSet);
    }

    public final void h(Object obj, String groupName, String name, int limitTimes, long windowSize, int totalExecutionTimes) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() == 0) {
            name = obj.getClass().getSimpleName();
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String e16 = e(this.treeSetPrefix + "_" + name);
        String e17 = e(this.totalTimesPrefix + "_" + name);
        if (f().get(groupName) == null) {
            f().put(groupName, new ConcurrentHashMap());
        }
        Map<String, CopyOnWriteArrayList<Number>> map = f().get(groupName);
        if (map != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, Integer.valueOf(limitTimes));
            arrayList.add(1, Long.valueOf(windowSize));
            Intrinsics.checkNotNullExpressionValue(name, "actualName");
            map.put(name, new CopyOnWriteArrayList<>(arrayList));
        }
        Set set = null;
        try {
            set = (Set) this.gson.fromJson(QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(e16, null), new d().getType());
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        if (set == null) {
            j(e16, new TreeSet());
        }
        fromV2.putInt(e17, fromV2.getInt(e17, totalExecutionTimes));
    }

    public final void k(Object obj, String name, List<Long> showTimeList, int oldTotalTimes, boolean isRestTotalTimes) {
        int max;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.length() == 0) {
            name = obj.getClass().getSimpleName();
        }
        String e16 = e(this.treeSetPrefix + "_" + name);
        String e17 = e(this.totalTimesPrefix + "_" + name);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("old_record_sync_");
        sb5.append(name);
        String sb6 = sb5.toString();
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!fromV2.getBoolean(sb6, false)) {
            if (QLog.isColorLevel()) {
                QLog.d("ScheduleManager", 2, "The needed sync total time of " + name + " is " + oldTotalTimes + " and isRestTotalTimes " + isRestTotalTimes);
            }
            if (oldTotalTimes != Integer.MIN_VALUE) {
                int i3 = fromV2.getInt(e17, Integer.MIN_VALUE);
                if (isRestTotalTimes) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(oldTotalTimes, 0);
                    max = Math.min(i3, coerceAtLeast);
                } else {
                    max = Math.max(i3 - oldTotalTimes, 0);
                }
                fromV2.putInt(e17, max);
                if (QLog.isColorLevel()) {
                    QLog.d("ScheduleManager", 2, "The old total execution times of " + name + " sync success.");
                }
            }
            if (showTimeList != null) {
                Collection collection = null;
                try {
                    collection = (Set) this.gson.fromJson(QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(e16, null), new e().getType());
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                TreeSet treeSet = (TreeSet) collection;
                if (treeSet == null) {
                    treeSet = new TreeSet();
                }
                treeSet.addAll(showTimeList);
                j(e16, treeSet);
                if (QLog.isColorLevel()) {
                    QLog.d("ScheduleManager", 2, "The old execution time record of " + name + " sync success.");
                }
            }
        }
        fromV2.putBoolean(sb6, true);
    }

    public static /* synthetic */ void b(ScheduleManager scheduleManager, Object obj, String str, String str2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = Dispatcher.DEFAULT_GROUP_NAME;
        }
        scheduleManager.a(obj, str, str2);
    }

    public static /* synthetic */ boolean d(ScheduleManager scheduleManager, Object obj, String str, String str2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = Dispatcher.DEFAULT_GROUP_NAME;
        }
        return scheduleManager.c(obj, str, str2);
    }

    public final boolean c(Object obj, String name, String groupName) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        String actualName = name;
        Intrinsics.checkNotNullParameter(actualName, "name");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        if (name.length() == 0) {
            actualName = obj.getClass().getSimpleName();
        }
        String e16 = e(this.treeSetPrefix + "_" + actualName);
        String e17 = e(this.totalTimesPrefix + "_" + actualName);
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        Collection collection = null;
        try {
            collection = (Set) this.gson.fromJson(QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getString(e16, null), new c().getType());
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        TreeSet treeSet = (TreeSet) collection;
        int i3 = fromV2.getInt(e17, Integer.MIN_VALUE);
        Intrinsics.checkNotNullExpressionValue(actualName, "actualName");
        Number g16 = g(actualName, groupName, 0);
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) g16).intValue();
        if (intValue == -1) {
            if (QLog.isColorLevel()) {
                QLog.w("ScheduleManager", 2, "The limitTimes haven't been initialized.");
            }
            return false;
        }
        Number g17 = g(actualName, groupName, 1);
        Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type kotlin.Long");
        long longValue = ((Long) g17).longValue();
        if (((int) longValue) == -1) {
            if (QLog.isColorLevel()) {
                QLog.w("ScheduleManager", 2, "The windowSize haven't been initialized.");
            }
            return false;
        }
        if (i3 != Integer.MIN_VALUE && i3 <= 0) {
            if (QLog.isColorLevel()) {
                QLog.w("ScheduleManager", 2, actualName + " has no rest times");
            }
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (intValue == Integer.MIN_VALUE) {
            return true;
        }
        if (treeSet == null) {
            return false;
        }
        boolean z16 = false;
        while (!treeSet.isEmpty()) {
            Object first = treeSet.first();
            Intrinsics.checkNotNullExpressionValue(first, "treeSet.first()");
            if (((Number) first).longValue() >= currentTimeMillis - longValue) {
                break;
            }
            treeSet.pollFirst();
            z16 = true;
        }
        int size = treeSet.size();
        if (z16) {
            j(e16, treeSet);
        }
        if (size < intValue) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScheduleManager", 2, actualName + " exceed frequency");
        }
        return false;
    }

    private final Number g(String actualName, String groupName, int index) {
        CopyOnWriteArrayList<Number> copyOnWriteArrayList;
        Object orNull;
        boolean z16 = false;
        if (index >= 0 && index < 2) {
            z16 = true;
        }
        if (!z16) {
            return -1;
        }
        Map<String, CopyOnWriteArrayList<Number>> map = f().get(groupName);
        if (map != null && (copyOnWriteArrayList = map.get(actualName)) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(copyOnWriteArrayList, index);
            Number number = (Number) orNull;
            if (number != null) {
                return number;
            }
        }
        if (index == 0) {
            return Integer.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }
}
