package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusPayDetail implements ISSOReqModel, ISSORspModel<QPlusPayDetail> {
    public final int costAmount;
    public final int payedAmount;
    public final int refundAmount;

    public QPlusPayDetail(int i3, int i16, int i17) {
        this.payedAmount = i3;
        this.costAmount = i16;
        this.refundAmount = i17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("payed_amount", this.payedAmount);
        eVar.t("cost_amount", this.costAmount);
        eVar.t("refund_amount", this.refundAmount);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusPayDetail decode(e eVar) {
        return new QPlusPayDetail(eVar.k("payed_amount", 0), eVar.k("cost_amount", 0), eVar.k("refund_amount", 0));
    }
}
