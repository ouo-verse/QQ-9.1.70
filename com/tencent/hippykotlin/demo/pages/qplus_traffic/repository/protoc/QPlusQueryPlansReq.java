package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.util.ArrayList;

/* loaded from: classes31.dex */
public final class QPlusQueryPlansReq implements ISSOReqModel, ISSORspModel<QPlusQueryPlansReq> {
    public final String cookie;
    public final QPlusQueryOptions queryOptions;

    public QPlusQueryPlansReq(QPlusQueryOptions qPlusQueryOptions, String str) {
        this.queryOptions = qPlusQueryOptions;
        this.cookie = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusQueryPlansReq decode(e eVar) {
        ArrayList arrayList;
        e m3 = eVar.m("query_options");
        QPlusQueryOptions qPlusQueryOptions = null;
        ArrayList arrayList2 = null;
        if (m3 != null) {
            String q16 = m3.q("query_words", "");
            b l3 = m3.l("plan_status");
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    arrayList.add(Integer.valueOf(l3.i(i3)));
                }
            } else {
                arrayList = null;
            }
            e m16 = m3.m("time_range");
            QPlusTimeRange qPlusTimeRange = m16 != null ? new QPlusTimeRange(m16.o(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0L), m16.o("end_time", 0L)) : null;
            b l16 = m3.l("content_types");
            if (l16 != null) {
                arrayList2 = new ArrayList();
                int c17 = l16.c();
                for (int i16 = 0; i16 < c17; i16++) {
                    arrayList2.add(Integer.valueOf(l16.i(i16)));
                }
            }
            qPlusQueryOptions = new QPlusQueryOptions(q16, arrayList, qPlusTimeRange, arrayList2);
        }
        return new QPlusQueryPlansReq(qPlusQueryOptions, eVar.q("cookie", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        QPlusQueryOptions qPlusQueryOptions = this.queryOptions;
        if (qPlusQueryOptions != null) {
            eVar.v("query_options", qPlusQueryOptions.encode());
        }
        eVar.v("cookie", this.cookie);
        return eVar;
    }
}
