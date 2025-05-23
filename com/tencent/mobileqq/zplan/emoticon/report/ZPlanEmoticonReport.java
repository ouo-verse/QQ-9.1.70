package com.tencent.mobileqq.zplan.emoticon.report;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.message.MessageForZPlan;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bK\u0010LJ\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J.\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\fJB\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003J\u0016\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0010R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010%R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00030#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00107\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010;\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00102\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\"\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\b8\u00104\"\u0004\b<\u00106R\"\u0010?\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00102\u001a\u0004\b1\u00104\"\u0004\b>\u00106R2\u0010F\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010@\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER'\u0010J\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00100G8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010H\u001a\u0004\b.\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/report/ZPlanEmoticonReport;", "", "", "", "durationList", "d", "index", "j", "list", "b", "avg", "c", "", "p", "k", "portraitId", "", "isTroop", "playerNumber", "isCoverRecorded", "isAnimRecorded", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "message", "drawDurationList", "decodeDurationList", "frameCount", "width", "height", "o", "", "key", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "Ljava/util/Map;", "downloadingMap", "reportPlayNumMap", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/emoticon/report/b;", "Ljava/util/List;", "reportRefreshListenerList", "Ljava/util/concurrent/locks/ReentrantLock;", "e", "Ljava/util/concurrent/locks/ReentrantLock;", "reentrantLock", "f", "I", "i", "()I", "v", "(I)V", "reportTopY", "g", h.F, "u", "reportTopPos", "t", "reportBottomY", ReportConstant.COSTREPORT_PREFIX, "reportBottomPos", "Lkotlin/Function0;", "Ljava/lang/ref/WeakReference;", "getObserverRef", "()Ljava/lang/ref/WeakReference;", "r", "(Ljava/lang/ref/WeakReference;)V", "observerRef", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "needReport", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonReport {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int reportTopY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static int reportTopPos;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int reportBottomY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int reportBottomPos;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Function0<Unit>> observerRef;

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanEmoticonReport f333324a = new ZPlanEmoticonReport();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Long> downloadingMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<Long, Integer> reportPlayNumMap = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<WeakReference<b>> reportRefreshListenerList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, Boolean> needReport = new ConcurrentHashMap<String, Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.report.ZPlanEmoticonReport$needReport$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            put("needResetReport", Boolean.TRUE);
            Boolean bool = Boolean.FALSE;
            put("onSelected", bool);
            put("onPanelCreate", bool);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(Boolean bool) {
            return super.containsValue((Object) bool);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
            return getEntries();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, Boolean>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public final /* bridge */ Boolean getOrDefault(Object obj, Boolean bool) {
            return !(obj instanceof String) ? bool : getOrDefault((String) obj, bool);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<Boolean> getValues() {
            return super.values();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Boolean remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Boolean> values() {
            return getValues();
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Boolean) {
                return containsValue((Boolean) obj);
            }
            return false;
        }

        public /* bridge */ Boolean get(String str) {
            return (Boolean) super.get((Object) str);
        }

        public /* bridge */ Boolean getOrDefault(String str, Boolean bool) {
            return (Boolean) super.getOrDefault((Object) str, (String) bool);
        }

        public /* bridge */ Boolean remove(String str) {
            return (Boolean) super.remove((Object) str);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Boolean) obj2);
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if (!(obj instanceof String)) {
                return false;
            }
            if (obj2 == null ? true : obj2 instanceof Boolean) {
                return remove((String) obj, (Boolean) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, Boolean bool) {
            return super.remove((Object) str, (Object) bool);
        }
    };

    ZPlanEmoticonReport() {
    }

    private final int b(List<Integer> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            i3 += it.next().intValue();
        }
        return i3 / size;
    }

    private final int c(List<Integer> list, int avg) {
        int size = list.size();
        int i3 = 0;
        if (size <= 1) {
            return 0;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue() - avg;
            i3 += intValue * intValue;
        }
        return i3 / (size - 1);
    }

    private final List<Integer> d(List<Integer> durationList) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = durationList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            int intValue = it.next().intValue();
            if (intValue <= 1000) {
                boolean z16 = true;
                boolean z17 = intValue > j(durationList, i3 + (-1)) * 3 || intValue > j(durationList, i3 + (-2)) * 3;
                if (intValue <= j(durationList, i16) * 3 && intValue <= j(durationList, i3 + 2) * 3) {
                    z16 = false;
                }
                if (!z17 || !z16) {
                    arrayList.add(Integer.valueOf(intValue));
                }
            }
            i3 = i16;
        }
        return arrayList;
    }

    private final void k() {
        boolean z16 = true;
        for (Boolean bool : needReport.values()) {
            if (bool == null) {
                bool = Boolean.FALSE;
            }
            z16 &= bool.booleanValue();
        }
        if (z16) {
            WeakReference<Function0<Unit>> weakReference = observerRef;
            Function0<Unit> function0 = weakReference != null ? weakReference.get() : null;
            if (function0 != null) {
                function0.invoke();
            }
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        ReentrantLock reentrantLock2 = reentrantLock;
        reentrantLock2.lock();
        try {
            Iterator<WeakReference<b>> it = reportRefreshListenerList.iterator();
            while (it.hasNext()) {
                b bVar = it.next().get();
                if (bVar != null) {
                    bVar.b();
                }
            }
            Iterator<WeakReference<b>> it5 = reportRefreshListenerList.iterator();
            while (it5.hasNext()) {
                if (it5.next().get() == null) {
                    it5.remove();
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock2.unlock();
        }
    }

    private final void p() {
        ConcurrentHashMap<String, Boolean> concurrentHashMap = needReport;
        Boolean bool = Boolean.FALSE;
        concurrentHashMap.put("needResetReport", bool);
        concurrentHashMap.put("onSelected", bool);
    }

    public final ConcurrentHashMap<String, Boolean> e() {
        return needReport;
    }

    public final int f() {
        return reportBottomPos;
    }

    public final int g() {
        return reportBottomY;
    }

    public final int h() {
        return reportTopPos;
    }

    public final int i() {
        return reportTopY;
    }

    public final void l(int portraitId, boolean isTroop, int playerNumber, boolean isCoverRecorded, boolean isAnimRecorded) {
        Object obj;
        Object obj2;
        Map mapOf;
        if (QLog.isColorLevel()) {
            QLog.i("ZPlanEmoticonReport", 2, "[ReportEmoticonClick] event=zplan_emoticon_click portraitId=" + portraitId + " isTroop=" + isTroop + " playerNumber=" + playerNumber + " isCoverRecorded=" + isCoverRecorded + " isAnimRecorded=" + isAnimRecorded);
        }
        String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("portrait_id", String.valueOf(portraitId));
        String str = "1";
        if (isTroop) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[1] = TuplesKt.to("troop", obj);
        pairArr[2] = TuplesKt.to("player_number", String.valueOf(playerNumber));
        if (isCoverRecorded) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        pairArr[3] = TuplesKt.to("cover_status", obj2);
        if (!isAnimRecorded) {
            str = "0";
        }
        pairArr[4] = TuplesKt.to("anim_status", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        QQBeaconReport.report(currentAccountUin, "zplan_emoticon_click", mapOf);
    }

    public final void m() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.report.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanEmoticonReport.n();
            }
        }, 16, null, true);
    }

    public final synchronized void q(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        needReport.put(key, Boolean.valueOf(value));
        k();
    }

    public final void r(WeakReference<Function0<Unit>> weakReference) {
        observerRef = weakReference;
    }

    public final void s(int i3) {
        reportBottomPos = i3;
    }

    public final void t(int i3) {
        reportBottomY = i3;
    }

    public final void u(int i3) {
        reportTopPos = i3;
    }

    public final void v(int i3) {
        reportTopY = i3;
    }

    private final int j(List<Integer> durationList, int index) {
        if (index < 0 || index >= durationList.size()) {
            return 0;
        }
        return durationList.get(index).intValue();
    }

    public final void o(MessageForZPlan message, List<Integer> drawDurationList, List<Integer> decodeDurationList, int frameCount, int width, int height) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(drawDurationList, "drawDurationList");
        Intrinsics.checkNotNullParameter(decodeDurationList, "decodeDurationList");
        Map<Long, Integer> map = reportPlayNumMap;
        Integer num = map.get(Long.valueOf(message.uniseq));
        if (num == null || num.intValue() < 3) {
            map.put(Long.valueOf(message.uniseq), Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            int id5 = message.getId();
            List<Integer> d16 = d(drawDurationList);
            int b16 = b(d16);
            int c16 = c(d16, b16);
            int b17 = b(decodeDurationList);
            int c17 = c(decodeDurationList, b17);
            QLog.i("ZPlanEmoticonReport", 1, "[ReportPlay] drawDurationList=" + drawDurationList + " validDrawDurationList=" + d16);
            QLog.i("ZPlanEmoticonReport", 1, "[ReportPlay] event=zplan_aio_emoticon_play uniseq=" + message.uniseq + " portraitId=" + id5 + " type=sharpP drawAvg=" + b16 + " drawVariance=" + c16 + " decodeAvg=" + b17 + " decodeVariance=" + c17 + " frameCount=" + frameCount + " width=" + width + " height=" + height);
            String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("type", "sharpP"), TuplesKt.to("draw_frame_duration_avg", String.valueOf(b16)), TuplesKt.to("draw_frame_duration_variance", String.valueOf(c16)), TuplesKt.to("decode_frame_duration_avg", String.valueOf(b17)), TuplesKt.to("decode_frame_duration_variance", String.valueOf(c17)), TuplesKt.to("portrait_id", String.valueOf(id5)), TuplesKt.to("width", String.valueOf(width)), TuplesKt.to("height", String.valueOf(height)), TuplesKt.to("frame_count", String.valueOf(frameCount)));
            QQBeaconReport.report(currentAccountUin, "zplan_aio_emoticon_play", mapOf);
        }
    }
}
