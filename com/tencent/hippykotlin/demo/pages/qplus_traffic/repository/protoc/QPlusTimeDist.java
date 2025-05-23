package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusTimeDist implements ISSOReqModel, ISSORspModel<QPlusTimeDist> {
    public final int percent;
    public final String timeAt;

    public QPlusTimeDist() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("time_at", this.timeAt);
        eVar.t("percent", this.percent);
        return eVar;
    }

    public QPlusTimeDist(String str, int i3) {
        this.timeAt = str;
        this.percent = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusTimeDist decode(e eVar) {
        return new QPlusTimeDist(eVar.q("time_at", ""), eVar.k("percent", 0));
    }

    public /* synthetic */ QPlusTimeDist(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }
}
