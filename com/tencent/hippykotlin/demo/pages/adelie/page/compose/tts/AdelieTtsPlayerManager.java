package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.module.AdelieKuiklyTTSPageModule;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;

/* loaded from: classes31.dex */
public final class AdelieTtsPlayerManager {
    public static final AdelieTtsPlayerManager INSTANCE = new AdelieTtsPlayerManager();

    public final AdelieKuiklyTTSPageModule bridgeModule() {
        return (AdelieKuiklyTTSPageModule) c.f117352a.g().acquireModule("AdelieKuiklyTTSPageModule");
    }

    public final e getTtsPlayObject(AdelieTtsInfo adelieTtsInfo) {
        e eVar = new e();
        eVar.v("ttsId", adelieTtsInfo.ttsId);
        eVar.v("ttsName", adelieTtsInfo.getTtsName());
        eVar.v("ttsExample", adelieTtsInfo.ttsExample);
        return eVar;
    }

    public final void startPlay(AdelieTtsInfo adelieTtsInfo) {
        if (adelieTtsInfo.type == 1) {
            adelieTtsInfo.playState$delegate.setValue(TtsPlayState.COMPLETED);
        } else {
            adelieTtsInfo.playState$delegate.setValue(TtsPlayState.NONE);
        }
        AdelieKuiklyTTSPageModule bridgeModule = bridgeModule();
        e ttsPlayObject = getTtsPlayObject(adelieTtsInfo);
        AdelieTtsPlayerManager$startPlay$1 adelieTtsPlayerManager$startPlay$1 = new AdelieTtsPlayerManager$startPlay$1(this);
        bridgeModule.getClass();
        bridgeModule.toNative(true, "playTtsVoice", ttsPlayObject.toString(), adelieTtsPlayerManager$startPlay$1, false);
        k kVar = (k) c.f117352a.g().acquireModule("KRNotifyModule");
        e eVar = new e();
        eVar.v("ttsId", adelieTtsInfo.ttsId);
        eVar.v("ttsName", adelieTtsInfo.getTtsName());
        eVar.t("ttsType", BoxType$EnumUnboxingSharedUtility.ordinal(adelieTtsInfo.type));
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "adelie_tts_select_result", eVar, false, 4, null);
    }
}
