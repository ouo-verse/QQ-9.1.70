package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ConstantsKt {
    public static final e getJubaoDTBaseParams() {
        String str;
        e eVar = new e();
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            str = "0M2003OIIM08YV9M";
        } else {
            str = "0S200MNJT807V3GE";
        }
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, str);
        return eVar;
    }
}
