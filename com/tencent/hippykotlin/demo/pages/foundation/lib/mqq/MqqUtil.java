package com.tencent.hippykotlin.demo.pages.foundation.lib.mqq;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class MqqUtil {
    public final long currentTime() {
        return ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).currentTimeStamp();
    }
}
