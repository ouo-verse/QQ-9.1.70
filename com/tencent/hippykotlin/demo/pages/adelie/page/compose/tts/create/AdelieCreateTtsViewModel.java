package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.create;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.manager.c;
import h25.ak;
import kotlin.Unit;
import zz0.a;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCreateTtsViewModel {
    public String currentTaskId;
    public StateHolder<ak> ttsReadTtsInfo = new StateHolder<>(null, 1, null);
    public StateHolder<Boolean> isRecognizing = new StateHolder<>(Boolean.FALSE);
    public final e requestScope = e.f117232d;

    public final void reportDT$enumunboxing$(int i3, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        long a16 = a.f453719a.a();
        AdelieKuiklyBaseModule adelieKuiklyBaseModule = (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
        eVar.t("state", CreateTtsReportState$EnumUnboxingLocalUtility.getValue(i3));
        eVar.u("curTime", a16);
        Unit unit = Unit.INSTANCE;
        adelieKuiklyBaseModule.reportBeacon("ibot#create#tts#clone", eVar);
    }
}
