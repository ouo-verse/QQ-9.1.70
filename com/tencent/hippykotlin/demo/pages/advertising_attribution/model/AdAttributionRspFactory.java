package com.tencent.hippykotlin.demo.pages.advertising_attribution.model;

import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdAttributionRspFactory implements ISSOModelFactory<AdAttributionAddResult> {
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
    public final AdAttributionAddResult decode(e eVar) {
        return new AdAttributionAddResult(eVar.k("code", 0), eVar.q("msg", ""), eVar.q("msg_cn", ""));
    }
}
