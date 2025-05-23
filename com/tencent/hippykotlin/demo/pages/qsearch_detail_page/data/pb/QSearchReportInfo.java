package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchReportInfo implements ISSOReqModel, ISSORspModel<QSearchReportInfo> {
    public final String eid;
    public final String reportInfo;

    public QSearchReportInfo(String str, String str2) {
        this.eid = str;
        this.reportInfo = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("eid", this.eid);
        eVar.v(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, this.reportInfo);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchReportInfo decode(e eVar) {
        return new QSearchReportInfo(eVar.q("eid", ""), eVar.q(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, ""));
    }
}
