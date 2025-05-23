package com.tencent.hippykotlin.demo.pages.dataline;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DatalineModule extends Module {
    public final void datalineCheckSwitch$qecommerce_biz_release(String str, String str2, int i3, boolean z16) {
        e eVar = new e();
        eVar.v("type", str);
        eVar.w("isChecked", z16);
        eVar.v(IProfileProtocolConst.PARAM_TARGET_UIN, str2);
        eVar.t("device_type", i3);
        toNative(false, "checkSwitch", eVar.toString(), null, false);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "DatalineModule";
    }
}
