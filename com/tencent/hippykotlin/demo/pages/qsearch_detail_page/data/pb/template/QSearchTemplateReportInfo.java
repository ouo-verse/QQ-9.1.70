package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchTemplateReportInfo {
    public String eid = "";
    public String transferInfo = "";

    public final e getReportParams(e eVar) {
        e mergeTransferInfo;
        if (!(this.transferInfo.length() == 0) && (mergeTransferInfo = TemplateItemsKt.mergeTransferInfo(this.transferInfo, eVar)) != null) {
            eVar.v("transfer_info", mergeTransferInfo);
            TemplateItemsKt.inflateTransferInfo(eVar, mergeTransferInfo);
        }
        return eVar;
    }
}
