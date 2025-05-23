package com.tencent.hippykotlin.demo.pages.advertising_attribution;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.advertising_attribution.model.AdAttributionAddResult;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAttributionReporter {
    public static final AdAttributionReporter INSTANCE = new AdAttributionReporter();
    public static final Lazy repo$delegate;
    public static final Lazy viewModelScope$delegate;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter$viewModelScope$2
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return e.f117232d;
            }
        });
        viewModelScope$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AdAttributionRepo>() { // from class: com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter$repo$2
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ AdAttributionRepo invoke() {
                return AdAttributionRepo.INSTANCE;
            }
        });
        repo$delegate = lazy2;
    }

    public static final void access$reportDT(com.tencent.kuikly.core.nvi.serialization.json.e eVar, AdAttributionAddResult adAttributionAddResult) {
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("action_type", "CLAIM_OFFER");
        m3.v("body", eVar.toString());
        m3.t("code", adAttributionAddResult.code);
        m3.v("msg", adAttributionAddResult.f114179msg);
        m3.v("msg_cn", adAttributionAddResult.msgCN);
        Utils.INSTANCE.currentBridgeModule().reportDT("advertising_attribution_report", m3);
    }

    public final com.tencent.kuikly.core.nvi.serialization.json.e combineReportData(String str, String str2) {
        com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("click_id", str);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.u("action_time", Utils.INSTANCE.currentBridgeModule().currentTimeStamp() / 1000);
        eVar.v("action_type", str2);
        eVar.v("trace", m3);
        eVar.v(WadlProxyConsts.CHANNEL, "CHANNEL_TENCENT");
        b bVar = new b();
        bVar.t(eVar);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar2.t(ReportDataBuilder.KEY_ACCOUNT_ID, 30133431);
        eVar2.t("user_action_set_id", 1201029499);
        eVar2.v("actions", bVar);
        return eVar2;
    }
}
