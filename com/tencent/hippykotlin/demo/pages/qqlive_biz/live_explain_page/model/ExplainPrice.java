package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes32.dex */
public final class ExplainPrice {
    public String pricesTxt = "";
    public String pricesSuffix = "";

    public final void decode(e eVar) {
        eVar.k("price", 0);
        this.pricesTxt = eVar.q("prices_txt", "");
        this.pricesSuffix = eVar.q("prices_suffix", "");
        eVar.q("integer_txt", "");
        eVar.q("decimal_txt", "");
    }
}
