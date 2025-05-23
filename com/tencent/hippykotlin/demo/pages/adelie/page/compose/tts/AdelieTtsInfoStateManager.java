package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import f25.j;
import h25.aj;
import h25.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieTtsInfoStateManager {
    public IAdelieTtsInfoStateManagerCallback callback;

    public final void monitorTtsState(final String str, final PollingEntrance pollingEntrance) {
        AdelieOIDBServer.queryTask$pollTaskState(new Ref.IntRef(), new Function3<Integer, String, aj, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsInfoStateManager$monitorTtsState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(Integer num, String str2, aj ajVar) {
                i iVar;
                String str3;
                j jVar;
                String str4;
                j jVar2;
                AdelieMyTtsVoiceState adelieMyTtsVoiceState;
                int intValue = num.intValue();
                String str5 = str2;
                aj ajVar2 = ajVar;
                if (intValue == 0) {
                    iVar = ajVar2 != null ? ajVar2.f404155m : null;
                    String str6 = "";
                    if (iVar == null || (jVar2 = iVar.f404208d) == null || (str3 = jVar2.f397755d) == null) {
                        str3 = "";
                    }
                    if (iVar != null && (jVar = iVar.f404208d) != null && (str4 = jVar.f397758h) != null) {
                        str6 = str4;
                    }
                    if (!(str3.length() == 0)) {
                        if (!(str6.length() == 0)) {
                            IAdelieTtsInfoStateManagerCallback iAdelieTtsInfoStateManagerCallback = AdelieTtsInfoStateManager.this.callback;
                            if (iAdelieTtsInfoStateManagerCallback != null) {
                                iAdelieTtsInfoStateManagerCallback.checkSuccess(str, str3, str6, pollingEntrance);
                            }
                        }
                    }
                    IAdelieTtsInfoStateManagerCallback iAdelieTtsInfoStateManagerCallback2 = AdelieTtsInfoStateManager.this.callback;
                    if (iAdelieTtsInfoStateManagerCallback2 != null) {
                        iAdelieTtsInfoStateManagerCallback2.checkFail(str, AdelieMyTtsVoiceState.ERROR, str5);
                    }
                } else if (intValue != 2) {
                    IAdelieTtsInfoStateManagerCallback iAdelieTtsInfoStateManagerCallback3 = AdelieTtsInfoStateManager.this.callback;
                    if (iAdelieTtsInfoStateManagerCallback3 != null) {
                        iAdelieTtsInfoStateManagerCallback3.checkFail(str, AdelieMyTtsVoiceState.ERROR, str5);
                    }
                } else {
                    if (str5.length() == 0) {
                        str5 = "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
                    }
                    iVar = ajVar2 != null ? ajVar2.f404155m : null;
                    if (iVar != null && iVar.f404209e == 4) {
                        adelieMyTtsVoiceState = AdelieMyTtsVoiceState.CANNOT;
                        str5 = "\u751f\u6210\u5931\u8d25\uff0c\u8bf7\u5220\u9664\u58f0\u97f3\u91cd\u65b0\u521b\u5efa";
                    } else {
                        adelieMyTtsVoiceState = AdelieMyTtsVoiceState.ERROR;
                    }
                    IAdelieTtsInfoStateManagerCallback iAdelieTtsInfoStateManagerCallback4 = AdelieTtsInfoStateManager.this.callback;
                    if (iAdelieTtsInfoStateManagerCallback4 != null) {
                        iAdelieTtsInfoStateManagerCallback4.checkFail(str, adelieMyTtsVoiceState, str5);
                    }
                }
                return Unit.INSTANCE;
            }
        }, str);
    }
}
