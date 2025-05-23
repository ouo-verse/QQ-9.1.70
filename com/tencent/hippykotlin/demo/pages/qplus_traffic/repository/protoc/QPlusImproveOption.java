package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class QPlusImproveOption implements ISSOReqModel, ISSORspModel<QPlusImproveOption> {
    public final QPlusExpectSetting expectSetting;
    public final String improveId;
    public final int improveType;
    public final String text;

    public QPlusImproveOption() {
        this(null, 0, null, null, 15, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("improve_id", this.improveId);
        eVar.t("improve_type", this.improveType);
        eVar.v("text", this.text);
        QPlusExpectSetting qPlusExpectSetting = this.expectSetting;
        if (qPlusExpectSetting != null) {
            eVar.v("expect_setting", qPlusExpectSetting.encode());
        }
        return eVar;
    }

    public QPlusImproveOption(String str, int i3, String str2, QPlusExpectSetting qPlusExpectSetting) {
        this.improveId = str;
        this.improveType = i3;
        this.text = str2;
        this.expectSetting = qPlusExpectSetting;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusImproveOption decode(e eVar) {
        String q16 = eVar.q("improve_id", "");
        int k3 = eVar.k("improve_type", 0);
        String q17 = eVar.q("text", "");
        e m3 = eVar.m("expect_setting");
        return new QPlusImproveOption(q16, k3, q17, m3 != null ? new QPlusExpectSetting(m3.q("setting_id", ""), m3.q("main_text", ""), m3.o("lower_limit", 0L), m3.o("upper_limit", 0L), m3.q("sub_text", ""), m3.o("sub_lower_limit", 0L), m3.o("sub_upper_limit", 0L)) : null);
    }

    public /* synthetic */ QPlusImproveOption(String str, int i3, String str2, QPlusExpectSetting qPlusExpectSetting, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "", null);
    }
}
