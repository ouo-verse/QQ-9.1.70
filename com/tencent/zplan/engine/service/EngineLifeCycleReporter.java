package com.tencent.zplan.engine.service;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.zplan.utils.ZLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JB\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022(\b\u0002\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001cJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fR\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R0\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/zplan/engine/service/EngineLifeCycleReporter;", "", "", "event", "Lcom/tencent/zplan/engine/service/ReporterEventRecordTime;", "recordTime", "", "p", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "recordTimes", "l", "", "", "reportMap", "", "needMessage", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "spaces", "o", "msg", "r", "dataMap", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "message", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "j", "i", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "a", "Z", "enableLog", "b", "enableReport", "c", "Ljava/util/Map;", "recordMap", "Ljava/util/concurrent/locks/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "recordMapLock", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "subHandler", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class EngineLifeCycleReporter {

    /* renamed from: e, reason: from kotlin metadata */
    private static Handler subHandler;

    /* renamed from: f */
    @NotNull
    public static final EngineLifeCycleReporter f385573f = new EngineLifeCycleReporter();

    /* renamed from: a, reason: from kotlin metadata */
    private static volatile boolean enableLog = true;

    /* renamed from: b, reason: from kotlin metadata */
    private static volatile boolean enableReport = true;

    /* renamed from: c, reason: from kotlin metadata */
    private static final Map<String, ArrayList<ReporterEventRecordTime>> recordMap = new LinkedHashMap();

    /* renamed from: d, reason: from kotlin metadata */
    private static final ReentrantLock recordMapLock = new ReentrantLock();

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(QMMKVFile.FILE_ZPLAN_REPORT);
        baseHandlerThread.start();
        subHandler = new Handler(baseHandlerThread.getLooper());
    }

    EngineLifeCycleReporter() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(EngineLifeCycleReporter engineLifeCycleReporter, String str, String str2, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        engineLifeCycleReporter.j(str, str2, hashMap);
    }

    private final ArrayList<ReporterEventRecordTime> l(ArrayList<ReporterEventRecordTime> recordTimes, String event) {
        if (recordTimes.size() >= 1000) {
            ReporterEventRecordTime reporterEventRecordTime = recordTimes.get(0);
            Intrinsics.checkNotNullExpressionValue(reporterEventRecordTime, "recordTimesTmp[0]");
            t(this, event, false, 2, null);
            ArrayList<ReporterEventRecordTime> n3 = n(event);
            n3.add(reporterEventRecordTime);
            return n3;
        }
        return recordTimes;
    }

    private final String m(String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
        if (split$default.size() < 3) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 3; i3++) {
            sb5.append((String) split$default.get(i3));
            if (i3 != 2) {
                sb5.append("_");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    private final String o(int spaces) {
        String valueOf;
        if (spaces <= 0) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(spaces);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%" + valueOf + ReportConstant.COSTREPORT_PREFIX, Arrays.copyOf(new Object[]{""}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public final void p(String event, ReporterEventRecordTime recordTime) {
        l(n(event), event).add(recordTime);
    }

    public final String q(String str, List<ReporterEventRecordTime> list, Map<String, String> map, boolean z16) {
        int i3;
        List<ReporterEventRecordTime> list2 = list;
        if (list2 != null && !list.isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" \n ");
            sb5.append(str);
            sb5.append(":");
            sb5.append("\n");
            int size = list.size();
            long time = list2.get(0).getTime();
            long time2 = list2.get(size - 1).getTime() - time;
            int i16 = 0;
            while (i16 < size) {
                ReporterEventRecordTime reporterEventRecordTime = list2.get(i16);
                long time3 = reporterEventRecordTime.getTime() - time;
                if (z16) {
                    String message = reporterEventRecordTime.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    map.put(message, String.valueOf(time3));
                }
                Map<String, String> b16 = reporterEventRecordTime.b();
                if (b16 != null) {
                    map.putAll(b16);
                }
                String message2 = reporterEventRecordTime.getMessage();
                if (message2 != null) {
                    i3 = message2.length();
                } else {
                    i3 = 0;
                }
                String o16 = f385573f.o(30 - i3);
                sb5.append("    ");
                sb5.append(reporterEventRecordTime.getMessage());
                sb5.append(o16);
                sb5.append(MsgSummary.STR_COLON);
                sb5.append(time3);
                sb5.append(" ms");
                sb5.append("\n");
                i16++;
                list2 = list;
            }
            sb5.append(" Total: ");
            sb5.append(time2);
            sb5.append(" ms");
            if (time2 > 0) {
                map.put(f385573f.m(str) + "_total", String.valueOf(time2));
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            return sb6;
        }
        return null;
    }

    public final void r(String msg2) {
        ZLog.f386189b.k("EngineLifeCycleReporter", msg2);
    }

    public static /* synthetic */ void t(EngineLifeCycleReporter engineLifeCycleReporter, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        engineLifeCycleReporter.s(str, z16);
    }

    public final void u(String event, Map<String, String> dataMap) {
        if (dataMap.isEmpty()) {
            return;
        }
        ZPlanEngineQualityReporter.f385585b.b(m(event), dataMap);
    }

    public final void i(@NotNull final String event, @NotNull final ReporterEventRecordTime recordTime) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(recordTime, "recordTime");
        subHandler.post(new Runnable() { // from class: com.tencent.zplan.engine.service.EngineLifeCycleReporter$addRecord$2
            @Override // java.lang.Runnable
            public final void run() {
                EngineLifeCycleReporter.f385573f.p(event, recordTime);
            }
        });
    }

    public final void j(@NotNull final String event, @Nullable final String message, @Nullable final HashMap<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(event, "event");
        subHandler.post(new Runnable() { // from class: com.tencent.zplan.engine.service.EngineLifeCycleReporter$addRecord$1
            @Override // java.lang.Runnable
            public final void run() {
                EngineLifeCycleReporter.f385573f.p(event, new ReporterEventRecordTime(message, SystemClock.elapsedRealtime(), reportMap));
            }
        });
    }

    @NotNull
    public final ArrayList<ReporterEventRecordTime> n(@NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ReentrantLock reentrantLock = recordMapLock;
        reentrantLock.lock();
        try {
            Map<String, ArrayList<ReporterEventRecordTime>> map = recordMap;
            ArrayList<ReporterEventRecordTime> arrayList = map.get(event);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                ArrayList<ReporterEventRecordTime> put = map.put(event, arrayList);
                if (put != null) {
                    arrayList = put;
                }
            }
            return arrayList;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void s(@NotNull final String event, final boolean z16) {
        Intrinsics.checkNotNullParameter(event, "event");
        subHandler.post(new Runnable() { // from class: com.tencent.zplan.engine.service.EngineLifeCycleReporter$printResult$1

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 4, 2})
            /* loaded from: classes27.dex */
            public static final class a<T> implements Comparator<T> {
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t16, T t17) {
                    int compareValues;
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((ReporterEventRecordTime) t16).getTime()), Long.valueOf(((ReporterEventRecordTime) t17).getTime()));
                    return compareValues;
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReentrantLock reentrantLock;
                Map map;
                String q16;
                boolean z17;
                boolean z18;
                EngineLifeCycleReporter engineLifeCycleReporter = EngineLifeCycleReporter.f385573f;
                reentrantLock = EngineLifeCycleReporter.recordMapLock;
                reentrantLock.lock();
                try {
                    map = EngineLifeCycleReporter.recordMap;
                    ArrayList arrayList = (ArrayList) map.remove(event);
                    if (arrayList != null) {
                        if (arrayList.size() > 1) {
                            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        q16 = engineLifeCycleReporter.q(event, arrayList, linkedHashMap, z16);
                        z17 = EngineLifeCycleReporter.enableLog;
                        if (z17) {
                            engineLifeCycleReporter.r(q16);
                        }
                        z18 = EngineLifeCycleReporter.enableReport;
                        if (z18) {
                            engineLifeCycleReporter.u(event, linkedHashMap);
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
    }
}
