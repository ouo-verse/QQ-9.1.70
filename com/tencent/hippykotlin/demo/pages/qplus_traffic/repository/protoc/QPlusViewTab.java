package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusViewTab implements ISSOReqModel, ISSORspModel<QPlusViewTab> {
    public final int contentType;
    public final String tabName;

    public QPlusViewTab(int i3, String str) {
        this.contentType = i3;
        this.tabName = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusViewTab decode(e eVar) {
        return new QPlusViewTab(eVar.k("content_type", 0), eVar.q("tab_name", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("content_type", this.contentType);
        eVar.v("tab_name", this.tabName);
        return eVar;
    }
}
