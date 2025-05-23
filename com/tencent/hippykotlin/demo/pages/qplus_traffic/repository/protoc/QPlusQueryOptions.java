package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes31.dex */
public final class QPlusQueryOptions implements ISSOReqModel, ISSORspModel<QPlusQueryOptions> {
    public final ArrayList<Integer> contentTypes;
    public final ArrayList<Integer> planStatus;
    public final String queryWords;
    public final QPlusTimeRange timeRange;

    public QPlusQueryOptions(String str, ArrayList<Integer> arrayList, QPlusTimeRange qPlusTimeRange, ArrayList<Integer> arrayList2) {
        this.queryWords = str;
        this.planStatus = arrayList;
        this.timeRange = qPlusTimeRange;
        this.contentTypes = arrayList2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b a16 = o.a(eVar, "query_words", this.queryWords);
        ArrayList<Integer> arrayList = this.planStatus;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.r(((Number) it.next()).intValue());
            }
        }
        eVar.v("plan_status", a16);
        QPlusTimeRange qPlusTimeRange = this.timeRange;
        if (qPlusTimeRange != null) {
            eVar.v("time_range", qPlusTimeRange.encode());
        }
        b bVar = new b();
        ArrayList<Integer> arrayList2 = this.contentTypes;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                bVar.r(((Number) it5.next()).intValue());
            }
        }
        eVar.v("content_types", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusQueryOptions decode(e eVar) {
        ArrayList arrayList;
        String q16 = eVar.q("query_words", "");
        b l3 = eVar.l("plan_status");
        ArrayList arrayList2 = null;
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                arrayList.add(Integer.valueOf(l3.i(i3)));
            }
        } else {
            arrayList = null;
        }
        e m3 = eVar.m("time_range");
        QPlusTimeRange qPlusTimeRange = m3 != null ? new QPlusTimeRange(m3.o(QCircleLpReportDc05502.KEY_BEGIN_TIME, 0L), m3.o("end_time", 0L)) : null;
        b l16 = eVar.l("content_types");
        if (l16 != null) {
            arrayList2 = new ArrayList();
            int c17 = l16.c();
            for (int i16 = 0; i16 < c17; i16++) {
                arrayList2.add(Integer.valueOf(l16.i(i16)));
            }
        }
        return new QPlusQueryOptions(q16, arrayList, qPlusTimeRange, arrayList2);
    }
}
