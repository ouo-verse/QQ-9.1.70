package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StVisitor implements ISSOReqModel, ISSORspModel<StVisitor> {
    public final int viewCount;

    public StVisitor(int i3) {
        this.viewCount = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StVisitor decode(e eVar) {
        return new StVisitor(eVar.k("view_count", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("view_count", this.viewCount);
        return eVar;
    }
}
