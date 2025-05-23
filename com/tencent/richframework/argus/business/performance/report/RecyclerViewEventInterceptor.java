package com.tencent.richframework.argus.business.performance.report;

import com.google.gson.Gson;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.richframework.argus.business.performance.report.sample.ReleaseMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.recyclerview.GrayMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.recyclerview.PublicMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.recyclerview.RecyclerViewSceneSampleUtil;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J*\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/RecyclerViewEventInterceptor;", "Lcom/tencent/richframework/argus/business/performance/report/IEventReportInterceptor;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "()V", "gson", "Lcom/google/gson/Gson;", "scrollDurationStandard", "", "scrollTimeStandard", "strategies", "", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "addReport", "", "performanceData", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", Element.ELEMENT_NAME_DISTANCE, "", "dispatchEvent", "", "eventId", "", "map", "", "", "getMeetStrategies", "needReport", "key", "reportNow", "Companion", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RecyclerViewEventInterceptor implements IEventReportInterceptor, IRFWSampleManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int sIsOpenPreload;

    @NotNull
    private final Gson gson = new Gson();
    private final int scrollDurationStandard;
    private final int scrollTimeStandard;

    @NotNull
    private final List<IRFWSampleMeetStrategy> strategies;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/RecyclerViewEventInterceptor$Companion;", "", "()V", "KEY_BUSINESS_TYPE", "", "TAG", "sIsOpenPreload", "", "isOpenPreload", "", h.f248218g, "", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void isOpenPreload(boolean isOpen) {
            RecyclerViewEventInterceptor.sIsOpenPreload = isOpen ? 1 : 0;
        }

        Companion() {
        }
    }

    public RecyclerViewEventInterceptor() {
        List<IRFWSampleMeetStrategy> listOf;
        RecyclerViewSceneSampleUtil recyclerViewSceneSampleUtil = RecyclerViewSceneSampleUtil.INSTANCE;
        this.scrollTimeStandard = recyclerViewSceneSampleUtil.getScrollTimeStand();
        this.scrollDurationStandard = recyclerViewSceneSampleUtil.getScrollDistanceStand();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IRFWSampleMeetStrategy[]{new GrayMeetStrategy(), new PublicMeetStrategy(), new ReleaseMeetStrategy()});
        this.strategies = listOf;
    }

    private final void addReport(final WindowPerformanceData performanceData, final long distance) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.richframework.argus.business.performance.report.d
            @Override // java.lang.Runnable
            public final void run() {
                RecyclerViewEventInterceptor.addReport$lambda$0(RecyclerViewEventInterceptor.this, performanceData, distance);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addReport$lambda$0(RecyclerViewEventInterceptor this$0, WindowPerformanceData performanceData, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(performanceData, "$performanceData");
        this$0.reportNow(performanceData, j3);
    }

    private final boolean needReport(WindowPerformanceData performanceData, long distance, String key) {
        if (performanceData.getMonitorDuration() > this.scrollTimeStandard && distance > this.scrollDurationStandard && hitSample(key)) {
            return true;
        }
        return false;
    }

    private final void reportNow(WindowPerformanceData performanceData, long distance) {
        NodePO nodePO;
        Object obj = performanceData.getExtMap().get("block_msg");
        if (obj instanceof NodePO) {
            nodePO = (NodePO) obj;
        } else {
            nodePO = null;
        }
        if (nodePO == null) {
            return;
        }
        String blockMsg = this.gson.toJson(nodePO);
        Intrinsics.checkNotNullExpressionValue(blockMsg, "blockMsg");
        if (!needReport(performanceData, distance, blockMsg)) {
            return;
        }
        ArgusReportHelper argusReportHelper = ArgusReportHelper.INSTANCE;
        HashMap<String, String> createReportMap = argusReportHelper.createReportMap(performanceData, "recycler_view_scroll");
        createReportMap.put("is_preload", String.valueOf(sIsOpenPreload));
        createReportMap.put(Element.ELEMENT_NAME_DISTANCE, String.valueOf(distance));
        argusReportHelper.report(createReportMap);
    }

    @Override // com.tencent.richframework.argus.business.performance.report.IEventReportInterceptor
    public boolean dispatchEvent(@Nullable String eventId, @Nullable Map<String, ? extends Object> map) {
        WindowPerformanceData windowPerformanceData;
        long j3;
        if (Intrinsics.areEqual("recyclerViewStopScroll", eventId) && map != null) {
            Object obj = map.get("performance_data");
            Long l3 = null;
            if (obj instanceof WindowPerformanceData) {
                windowPerformanceData = (WindowPerformanceData) obj;
            } else {
                windowPerformanceData = null;
            }
            if (windowPerformanceData == null) {
                return true;
            }
            Object obj2 = windowPerformanceData.getExtMap().get("recyclerview_performance_scroll_distance");
            if (obj2 instanceof Long) {
                l3 = (Long) obj2;
            }
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            addReport(windowPerformanceData, j3);
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    @NotNull
    public List<IRFWSampleMeetStrategy> getMeetStrategies() {
        return this.strategies;
    }

    @Override // com.tencent.biz.richframework.monitor.sample.IRFWSampleManager
    public boolean hitSample(@Nullable String str) {
        return IRFWSampleManager.DefaultImpls.hitSample(this, str);
    }
}
