package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusExpectSetting implements ISSOReqModel, ISSORspModel<QPlusExpectSetting> {
    public final long lowerLimit;
    public final String mainText;
    public final String settingId;
    public final long subLowerLimit;
    public final String subText;
    public final long subUpperLimit;
    public final long upperLimit;

    public QPlusExpectSetting(String str, String str2, long j3, long j16, String str3, long j17, long j18) {
        this.settingId = str;
        this.mainText = str2;
        this.lowerLimit = j3;
        this.upperLimit = j16;
        this.subText = str3;
        this.subLowerLimit = j17;
        this.subUpperLimit = j18;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("setting_id", this.settingId);
        eVar.v("main_text", this.mainText);
        eVar.u("lower_limit", this.lowerLimit);
        eVar.u("upper_limit", this.upperLimit);
        eVar.v("sub_text", this.subText);
        eVar.u("sub_lower_limit", this.subLowerLimit);
        eVar.u("sub_upper_limit", this.subUpperLimit);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusExpectSetting decode(e eVar) {
        return new QPlusExpectSetting(eVar.q("setting_id", ""), eVar.q("main_text", ""), eVar.o("lower_limit", 0L), eVar.o("upper_limit", 0L), eVar.q("sub_text", ""), eVar.o("sub_lower_limit", 0L), eVar.o("sub_upper_limit", 0L));
    }
}
