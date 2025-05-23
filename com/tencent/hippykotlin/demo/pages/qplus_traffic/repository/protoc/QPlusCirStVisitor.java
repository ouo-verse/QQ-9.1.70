package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStVisitor implements ISSOReqModel, ISSORspModel<QPlusCirStVisitor> {
    public final int viewCount;

    public QPlusCirStVisitor(int i3) {
        this.viewCount = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStVisitor decode(e eVar) {
        return new QPlusCirStVisitor(eVar.k("viewCount", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("viewCount", this.viewCount);
        return eVar;
    }
}
