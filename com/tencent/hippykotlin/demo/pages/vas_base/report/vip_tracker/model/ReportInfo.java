package com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model;

import b01.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ReportInfo implements b {
    public final ReportPageInfo pageInfo;
    public final TraceInfo trace;

    public ReportInfo(ReportPageInfo reportPageInfo, TraceInfo traceInfo, int i3) {
        this.pageInfo = reportPageInfo;
        this.trace = traceInfo;
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.ReportInfo$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                eVar2.y("page_info", ReportInfo.this.pageInfo);
                eVar2.y("trace_info", ReportInfo.this.trace);
                ReportInfo.this.getClass();
                eVar2.z("to_uin", 0);
                return Unit.INSTANCE;
            }
        });
    }
}
