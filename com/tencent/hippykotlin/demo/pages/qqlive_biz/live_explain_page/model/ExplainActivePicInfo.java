package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.model;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes32.dex */
public final class ExplainActivePicInfo {
    public String url = "";

    public final void decode(e eVar) {
        this.url = eVar.q("url", "");
        eVar.k("width", 0);
        eVar.k("height", 0);
    }
}
