package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusProgress implements ISSOReqModel, ISSORspModel<QPlusProgress> {
    public final int actualCovers;
    public final int expectCovers;
    public final int percent;

    public QPlusProgress(int i3, int i16, int i17) {
        this.expectCovers = i3;
        this.actualCovers = i16;
        this.percent = i17;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("expect_covers", this.expectCovers);
        eVar.t("actual_covers", this.actualCovers);
        eVar.t("percent", this.percent);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusProgress decode(e eVar) {
        return new QPlusProgress(eVar.k("expect_covers", 0), eVar.k("actual_covers", 0), eVar.k("percent", 0));
    }
}
