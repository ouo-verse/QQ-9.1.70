package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPPerformanceInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class PagePerfTechReporter extends NearbyTechReporter {
    public final String pageId;
    public int reportCount;
    public NBPPerformanceInfo startupPerfInfo;
    public String timeoutRef;

    public /* synthetic */ PagePerfTechReporter() {
        this(NearbyTechReporterKt.currentPageId());
    }

    public static void startAutoReport$default(PagePerfTechReporter pagePerfTechReporter) {
        if (pagePerfTechReporter.timeoutRef != null) {
            return;
        }
        pagePerfTechReporter.report();
        if (pagePerfTechReporter.reportCount >= 3) {
            return;
        }
        pagePerfTechReporter.timeoutRef = TimerKt.d(5000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PagePerfTechReporter$startAutoReport$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                PagePerfTechReporter pagePerfTechReporter2 = PagePerfTechReporter.this;
                pagePerfTechReporter2.timeoutRef = null;
                PagePerfTechReporter.startAutoReport$default(pagePerfTechReporter2);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_perf_info";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final void report() {
        if (this.reportCount >= 3) {
            return;
        }
        super.report();
        this.reportCount++;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        NBPPerformanceInfo performanceInfo;
        NBPPerformanceInfo nBPPerformanceInfo = this.startupPerfInfo;
        if (nBPPerformanceInfo == null || (performanceInfo = QQNearbyModule.Companion.getInstance().getPerformanceInfo()) == null) {
            return null;
        }
        e eVar = new e();
        eVar.v("nearby_page_id", this.pageId);
        eVar.v("nearby_cpu", Float.valueOf(performanceInfo.cpu));
        eVar.v("nearby_mem_left", Float.valueOf(performanceInfo.memLeft));
        eVar.v("nearby_mem_app", Float.valueOf(performanceInfo.memUsage));
        eVar.v("nearby_mem_delta", Float.valueOf(performanceInfo.memUsage - nBPPerformanceInfo.memUsage));
        eVar.t("nearby_is_first_report", this.reportCount == 0 ? 1 : 0);
        return eVar;
    }

    public PagePerfTechReporter(String str) {
        this.pageId = str;
        try {
            this.startupPerfInfo = QQNearbyModule.Companion.getInstance().getPerformanceInfo();
        } catch (Exception e16) {
            this.startupPerfInfo = null;
            KLog.INSTANCE.e("PagePerfTechReporter", "init error " + e16);
        }
    }
}
