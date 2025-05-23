package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AITechReporter extends NearbyTechReporter {
    public e aiDetectTag;

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final String getKey() {
        return "ev_nearby_tech_ai";
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.NearbyTechReporter
    public final e toParams() {
        return this.aiDetectTag;
    }
}
