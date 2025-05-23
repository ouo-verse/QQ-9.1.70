package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStRecommendInfo implements ISSOReqModel, ISSORspModel<QPlusCirStRecommendInfo> {
    public final int recommendStatus;

    public QPlusCirStRecommendInfo(int i3) {
        this.recommendStatus = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStRecommendInfo decode(e eVar) {
        return new QPlusCirStRecommendInfo(eVar.k("recommend_status", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("recommend_status", this.recommendStatus);
        return eVar;
    }
}
