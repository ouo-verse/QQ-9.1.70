package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes31.dex */
public /* synthetic */ class AdelieTtsPlayerManager$startPlay$1 extends FunctionReferenceImpl implements Function1<e, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e m3;
        e eVar2 = eVar;
        ((AdelieTtsPlayerManager) this.receiver).getClass();
        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("playTtsCallback result: ", eVar2, KLog.INSTANCE, "AdelieTtsSettingViewModel");
        if (eVar2 != null && (m3 = eVar2.m("data")) != null) {
            boolean g16 = m3.g("result", true);
            String p16 = m3.p("tts_id");
            AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
            AdelieTtsInfo ttsInfoById = adelieTtsDataManager.getTtsInfoById(p16);
            if (ttsInfoById != null) {
                int j3 = m3.j("tts_play_state");
                if (j3 == 0) {
                    ttsInfoById.playState$delegate.setValue(TtsPlayState.LOADING);
                } else if (j3 != 1) {
                    if (j3 == 2) {
                        ttsInfoById.playState$delegate.setValue(TtsPlayState.PLAYING);
                    } else if (j3 == 3) {
                        ttsInfoById.playState$delegate.setValue(TtsPlayState.COMPLETED);
                    } else if (j3 == 4) {
                        ttsInfoById.playState$delegate.setValue(TtsPlayState.COMPLETED);
                    } else if (j3 == 5) {
                        ttsInfoById.playState$delegate.setValue(TtsPlayState.COMPLETED);
                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u64ad\u653e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                    }
                } else if (!g16) {
                    AdelieTtsInfo ttsInfoById2 = adelieTtsDataManager.getTtsInfoById(AdelieTtsDataManager.preSelectTtsId);
                    if (ttsInfoById2 != null) {
                        ttsInfoById2.playState$delegate.setValue(TtsPlayState.COMPLETED);
                    }
                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).qToast("\u64ad\u653e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                    ttsInfoById.playState$delegate.setValue(TtsPlayState.NONE);
                } else {
                    ttsInfoById.playState$delegate.setValue(TtsPlayState.PLAYING);
                }
            }
        }
        return Unit.INSTANCE;
    }

    public AdelieTtsPlayerManager$startPlay$1(Object obj) {
        super(1, obj, AdelieTtsPlayerManager.class, "playTtsCallback", "playTtsCallback(Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}
