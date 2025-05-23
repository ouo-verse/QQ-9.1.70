package com.tencent.hippykotlin.demo.pages.base.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AddWindowModule extends Module {
    public final String addProductToWindow(String str, String str2, int i3) {
        e eVar = new e();
        if (str != null) {
            eVar.v("productID", str);
        }
        if (str2 != null) {
            eVar.v("saasType", str2);
        }
        eVar.t("goodsType", i3);
        return toNative(false, "addProductToWindow", eVar.toString(), null, true).toString();
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "HRAddWindowModule";
    }
}
