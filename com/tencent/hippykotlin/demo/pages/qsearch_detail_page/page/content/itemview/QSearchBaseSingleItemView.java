package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.ISearchReport;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchBaseSingleItemView<A extends QSearchBaseSingleItemAttr, E extends l> extends QSearchReportView<A, E> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchBaseSingleItemAttr access$getAttr(QSearchBaseSingleItemView qSearchBaseSingleItemView) {
        return (QSearchBaseSingleItemAttr) qSearchBaseSingleItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e getReportParams() {
        e baseReportParams = getBaseReportParams();
        baseReportParams.v("search_query_text", ((QSearchBaseSingleItemAttr) getAttr()).keyword);
        baseReportParams.v("search_trace_id", ((QSearchBaseSingleItemAttr) getAttr()).traceId);
        if (!((QSearchBaseSingleItemAttr) getAttr()).isInGroup) {
            baseReportParams.t("serial_number", ((QSearchBaseSingleItemAttr) getAttr()).index + 1);
        }
        b pager = getPager();
        ISearchReport iSearchReport = pager instanceof ISearchReport ? (ISearchReport) pager : null;
        if (iSearchReport != null) {
            baseReportParams.v("query_source", String.valueOf(iSearchReport.getQuerySource()));
            baseReportParams.v("user_source", String.valueOf(iSearchReport.getUserSource()));
        }
        return baseReportParams;
    }
}
