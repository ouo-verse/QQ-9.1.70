package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.manager.c;

/* loaded from: classes31.dex */
public final class APICallTechReporterKt {
    public static final long NBPCurrentTime() {
        return ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
    }
}
