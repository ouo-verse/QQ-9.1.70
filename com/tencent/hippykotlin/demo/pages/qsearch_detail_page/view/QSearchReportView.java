package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportAttr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class QSearchReportView<A extends QSearchReportAttr, E extends l> extends ComposeView<A, E> {
    /* JADX WARN: Multi-variable type inference failed */
    public final e getBaseReportParams() {
        e eVar = new e();
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        eVar.v("pageId", "pg_qq_network_search_result_level2_page");
        eVar.v("tab_name", ((QSearchReportAttr) getAttr()).tabData.tabName);
        eVar.u("tab_mask", ((QSearchReportAttr) getAttr()).tabData.tabMask);
        return eVar;
    }
}
