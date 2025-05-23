package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes31.dex */
public final class QPlusTimeRange implements ISSOReqModel, ISSORspModel<QPlusTimeRange> {
    public final long beginTime;
    public final long endTime;

    public QPlusTimeRange(long j3, long j16) {
        this.beginTime = j3;
        this.endTime = j16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusTimeRange decode(e eVar) {
        return new QPlusTimeRange(eVar.o(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0L), eVar.o("end_time", 0L));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u(QCircleLpReportDc05502.KEY_BEGIN_TIME, this.beginTime);
        eVar.u("end_time", this.endTime);
        return eVar;
    }
}
