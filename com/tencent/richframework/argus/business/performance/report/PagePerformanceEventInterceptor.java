package com.tencent.richframework.argus.business.performance.report;

import com.tencent.biz.richframework.monitor.sample.IRFWSampleManager;
import com.tencent.biz.richframework.monitor.sample.IRFWSampleMeetStrategy;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.PagePerformanceDataInfo;
import com.tencent.richframework.argus.business.performance.report.sample.ReleaseMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.page.PageGrayMeetStrategy;
import com.tencent.richframework.argus.business.performance.report.sample.page.PagePublicMeetStrategy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J*\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/PagePerformanceEventInterceptor;", "Lcom/tencent/richframework/argus/business/performance/report/IEventReportInterceptor;", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleManager;", "()V", "index", "", "strategies", "", "Lcom/tencent/biz/richframework/monitor/sample/IRFWSampleMeetStrategy;", "addReport", "", "performanceData", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "pageInfo", "Lcom/tencent/richframework/argus/PagePerformanceDataInfo;", "dispatchEvent", "", "eventId", "", "map", "", "", "getMeetStrategies", "needReport", "reportNow", "Companion", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PagePerformanceEventInterceptor implements IEventReportInterceptor, IRFWSampleManager {
    private int index;

    @NotNull
    private final List<IRFWSampleMeetStrategy> strategies;

    public PagePerformanceEventInterceptor() {
        List<IRFWSampleMeetStrategy> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IRFWSampleMeetStrategy[]{new PageGrayMeetStrategy(), new PagePublicMeetStrategy(), new ReleaseMeetStrategy()});
        this.strategies = listOf;
    }

    private final void addReport(final WindowPerformanceData performanceData, final PagePerformanceDataInfo pageInfo, final int index) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.richframework.argus.business.performance.report.c
            @Override // java.lang.Runnable
            public final void run() {
                PagePerformanceEventInterceptor.addReport$lambda$0(PagePerformanceEventInterceptor.this, pageInfo, performanceData, index);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addReport$lambda$0(PagePerformanceEventInterceptor this$0, PagePerformanceDataInfo pageInfo, WindowPerformanceData performanceData, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pageInfo, "$pageInfo");
        Intrinsics.checkNotNullParameter(performanceData, "$performanceData");
        if (this$0.needReport(pageInfo)) {
            this$0.reportNow(performanceData, pageInfo, i3);
        }
    }

    private final boolean needReport(PagePerformanceDataInfo pageInfo) {
        return hitSample(pageInfo.getNewPageInfo());
    }

    private final void reportNow(WindowPerformanceData performanceData, PagePerformanceDataInfo pageInfo, int index) {
        String str;
        ArgusReportHelper argusReportHelper = ArgusReportHelper.INSTANCE;
        HashMap<String, String> createReportMap = argusReportHelper.createReportMap(performanceData, "page");
        createReportMap.put("start_time", String.valueOf(pageInfo.getStartMonitorTime()));
        createReportMap.put("stop_time", String.valueOf(pageInfo.getStopMonitorTime()));
        String fromPageInfo = pageInfo.getFromPageInfo();
        String str2 = "";
        if (fromPageInfo == null) {
            fromPageInfo = "";
        }
        createReportMap.put("from_page", fromPageInfo);
        String newPageInfo = pageInfo.getNewPageInfo();
        if (newPageInfo != null) {
            str2 = newPageInfo;
        }
        createReportMap.put("new_page", str2);
        createReportMap.put("merge_result", pageInfo.getMergeResult().toString());
        if (pageInfo.getIsDeadlineUpdate()) {
            str = "1";
        } else {
            str = "0";
        }
        createReportMap.put("is_deadline_update", str);
        createReportMap.put("recyclerview_first_item", String.valueOf(pageInfo.getRecyclerViewFirstItemAttachWindowTime()));
        String blockMsg = PagePerformanceEventInterceptorKt.getBlockMsg(pageInfo.getRecyclerView());
        createReportMap.put("recyclerview_msg", blockMsg);
        createReportMap.put("index", String.valueOf(index));
        QLog.d("PagePerformanceEventInterceptor", 4, index + ".formPage:" + fromPageInfo + ", newPage:" + str2 + ", recyclerView:" + blockMsg);
        argusReportHelper.report(createReportMap);
    }

    @Override // com.tencent.richframework.argus.business.performance.report.IEventReportInterceptor
    public boolean dispatchEvent(@Nullable String eventId, @Nullable Map<String, ? extends Object> map) {
        WindowPerformanceData windowPerformanceData;
        if (Intrinsics.areEqual("argus_page_performance_report", eventId) && map != null) {
            Object obj = map.get("performance_data");
            PagePerformanceDataInfo pagePerformanceDataInfo = null;
            if (obj instanceof WindowPerformanceData) {
                windowPerformanceData = (WindowPerformanceData) obj;
            } else {
                windowPerformanceData = null;
            }
            if (windowPerformanceData == null) {
                return true;
            }
            Object obj2 = map.get("argus_ext_performdata");
            if (obj2 instanceof PagePerformanceDataInfo) {
                pagePerformanceDataInfo = (PagePerformanceDataInfo) obj2;
            }
            if (pagePerformanceDataInfo == null) {
                return true;
            }
            int i3 = this.index;
            this.index = i3 + 1;
            addReport(windowPerformanceData, pagePerformanceDataInfo, i3);
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
