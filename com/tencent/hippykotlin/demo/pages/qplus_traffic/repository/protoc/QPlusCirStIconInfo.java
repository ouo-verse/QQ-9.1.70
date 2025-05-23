package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStIconInfo implements ISSOReqModel, ISSORspModel<QPlusCirStIconInfo> {
    public final String iconUrl;

    public QPlusCirStIconInfo(String str) {
        this.iconUrl = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStIconInfo decode(e eVar) {
        return new QPlusCirStIconInfo(eVar.q("iconUrl", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("iconUrl", this.iconUrl);
        return eVar;
    }
}
