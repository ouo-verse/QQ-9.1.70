package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module;

import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class AdelieKuiklyTTSPageModule extends Module {
    public static void stopTtsVoice$default(AdelieKuiklyTTSPageModule adelieKuiklyTTSPageModule, e eVar) {
        adelieKuiklyTTSPageModule.getClass();
        adelieKuiklyTTSPageModule.toNative(true, "stopTtsVoice", eVar.toString(), null, false);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "AdelieKuiklyTTSPageModule";
    }
}
