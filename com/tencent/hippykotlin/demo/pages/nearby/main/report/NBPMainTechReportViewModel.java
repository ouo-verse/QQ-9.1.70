package com.tencent.hippykotlin.demo.pages.nearby.main.report;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPSsoLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.DeviceInfoTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PageLoadTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.PagePerfTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.kuikly.core.timer.TimerKt;
import f35.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes31.dex */
public final class NBPMainTechReportViewModel extends NBPMainBaseViewModel {
    public final PageLoadTechReporter pageLoadReporter = new PageLoadTechReporter((String) null, 3);
    public final PagePerfTechReporter perfReporter = new PagePerfTechReporter();

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onEnterMap() {
        TimerKt.h(0, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.report.NBPMainTechReportViewModel$onEnterMap$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NBPMainTechReportViewModel.this.pageLoadReporter.report();
                return Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationFinish(boolean z16, NBPSsoLocation nBPSsoLocation) {
        PageLoadTechReporter pageLoadTechReporter = this.pageLoadReporter;
        Long l3 = pageLoadTechReporter.part4StartTime;
        if (l3 != null) {
            pageLoadTechReporter.part4Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onLocationPermissionGranted(boolean z16) {
        PageLoadTechReporter pageLoadTechReporter = this.pageLoadReporter;
        Long l3 = pageLoadTechReporter.part3StartTime;
        if (l3 != null) {
            pageLoadTechReporter.part3Time = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - l3.longValue()));
        }
        this.pageLoadReporter.startPart4();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onNBPBeforeLogin() {
        this.pageLoadReporter.reset();
        this.pageLoadReporter.startPart1();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onNBPLogin(boolean z16, g gVar) {
        this.pageLoadReporter.finishPart1();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidAppear() {
        PagePerfTechReporter.startAutoReport$default(this.perfReporter);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPageDidDisappear() {
        PagePerfTechReporter pagePerfTechReporter = this.perfReporter;
        String str = pagePerfTechReporter.timeoutRef;
        if (str != null) {
            TimerKt.b(str);
            pagePerfTechReporter.timeoutRef = null;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerCreated() {
        new DeviceInfoTechReporter().report();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerViewDidLoad() {
        PagePerfTechReporter.startAutoReport$default(this.perfReporter);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onPagerWillDestroy() {
        PagePerfTechReporter pagePerfTechReporter = this.perfReporter;
        String str = pagePerfTechReporter.timeoutRef;
        if (str != null) {
            TimerKt.b(str);
            pagePerfTechReporter.timeoutRef = null;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onRequestLocationPermission() {
        this.pageLoadReporter.startPart3();
    }
}
