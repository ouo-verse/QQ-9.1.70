package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class PageLoadTechReporter extends NearbyTechReporter {
    public int loadTime;
    public final String pageId;
    public Long part1StartTime;
    public Integer part1Time;
    public Long part2StartTime;
    public Integer part2Time;
    public Long part3StartTime;
    public Integer part3Time;
    public Long part4StartTime;
    public Integer part4Time;
    public long startTime;

    public /* synthetic */ PageLoadTechReporter(String str, int i3) {
        this((i3 & 1) != 0 ? NearbyTechReporterKt.currentPageId() : str, (i3 & 2) != 0 ? APICallTechReporterKt.NBPCurrentTime() : 0L);
    }

    public final PageLoadTechReporter finishPart1() {
        Long l3 = this.part1StartTime;
        if (l3 != null) {
            this.part1Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
        }
        return this;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_page_load";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final void report() {
        this.loadTime = (int) (APICallTechReporterKt.NBPCurrentTime() - this.startTime);
        super.report();
    }

    public final PageLoadTechReporter reset() {
        this.startTime = APICallTechReporterKt.NBPCurrentTime();
        this.part1StartTime = null;
        this.part2StartTime = null;
        this.part3StartTime = null;
        this.part4StartTime = null;
        this.part1Time = null;
        this.part2Time = null;
        this.part3Time = null;
        this.part4Time = null;
        return this;
    }

    public final void startPart1() {
        this.part1StartTime = Long.valueOf(APICallTechReporterKt.NBPCurrentTime());
    }

    public final void startPart2() {
        this.part2StartTime = Long.valueOf(APICallTechReporterKt.NBPCurrentTime());
    }

    public final void startPart3() {
        this.part3StartTime = Long.valueOf(APICallTechReporterKt.NBPCurrentTime());
    }

    public final void startPart4() {
        this.part4StartTime = Long.valueOf(APICallTechReporterKt.NBPCurrentTime());
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        e eVar = new e();
        eVar.v("nearby_page_id", this.pageId);
        eVar.t("nearby_load_time", this.loadTime);
        Integer num = this.part1Time;
        if (num != null) {
            eVar.v("nearby_load_time_part_1", num);
        }
        Integer num2 = this.part2Time;
        if (num2 != null) {
            eVar.v("nearby_load_time_part_2", num2);
        }
        Integer num3 = this.part3Time;
        if (num3 != null) {
            eVar.v("nearby_load_time_part_3", num3);
        }
        Integer num4 = this.part4Time;
        if (num4 != null) {
            eVar.v("nearby_load_time_part_4", num4);
        }
        return eVar;
    }

    public PageLoadTechReporter(String str, long j3) {
        this.pageId = str;
        this.startTime = j3;
    }
}
