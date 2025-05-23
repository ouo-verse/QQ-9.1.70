package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCommodityData implements ISSOReqModel, ISSORspModel<QPlusCommodityData> {
    public final int clickNum;
    public final int salesAmount;
    public final int salesNum;

    public QPlusCommodityData(int i3, int i16, int i17) {
        this.clickNum = i3;
        this.salesNum = i16;
        this.salesAmount = i17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("click_num", this.clickNum);
        eVar.t("sales_num", this.salesNum);
        eVar.t("sales_amount", this.salesAmount);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCommodityData decode(e eVar) {
        return new QPlusCommodityData(eVar.k("click_num", 0), eVar.k("sales_num", 0), eVar.k("sales_amount", 0));
    }
}
