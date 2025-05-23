package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchReportKt {
    public static final void reportNetQuality(String str, int i3, int i16, String str2) {
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("pageName", "qsearch_detail", "cmdName", str);
        m3.t("duration", i3);
        m3.t("errorCode", i16);
        m3.v("word", str2);
        m3.v("custom_beacon_app_key", "0DOU0TYBSY4OEY1K");
        Unit unit = Unit.INSTANCE;
        currentBridgeModule.reportDT("ktv_page_request_quality", m3);
    }
}
