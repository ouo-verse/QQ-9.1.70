package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCoinAccount implements ISSOReqModel, ISSORspModel<QPlusCoinAccount> {
    public final int coinAmount;

    public QPlusCoinAccount(int i3) {
        this.coinAmount = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCoinAccount decode(e eVar) {
        return new QPlusCoinAccount(eVar.k("coin_amount", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("coin_amount", this.coinAmount);
        return eVar;
    }
}
