package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusFeatureDist implements ISSOReqModel, ISSORspModel<QPlusFeatureDist> {
    public final String featureName;
    public final int percent;

    public QPlusFeatureDist() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("feature_name", this.featureName);
        eVar.t("percent", this.percent);
        return eVar;
    }

    public QPlusFeatureDist(String str, int i3) {
        this.featureName = str;
        this.percent = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusFeatureDist decode(e eVar) {
        return new QPlusFeatureDist(eVar.q("feature_name", ""), eVar.k("percent", 0));
    }

    public /* synthetic */ QPlusFeatureDist(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
    }
}
