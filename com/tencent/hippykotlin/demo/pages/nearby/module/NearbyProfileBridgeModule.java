package com.tencent.hippykotlin.demo.pages.nearby.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class NearbyProfileBridgeModule extends Module {
    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "NearbyProfileKuiklyModule";
    }

    public final e getZPlanUserInfo() {
        String bVar = toNative(false, "getZPlanUserInfo", null, null, true).toString();
        if (bVar.length() > 0) {
            return new e(bVar);
        }
        return null;
    }
}
