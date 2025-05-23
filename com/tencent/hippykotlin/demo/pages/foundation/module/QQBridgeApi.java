package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import com.tencent.kuikly.core.module.k;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQBridgeApi {
    public static final QQBridgeApi INSTANCE = new QQBridgeApi();

    public final BridgeModule getBridgeModule() {
        return (BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule");
    }

    public final b getCalendarModule() {
        return (b) c.f117352a.g().acquireModule("KRCalendarModule");
    }

    public final k getNotifyModule() {
        return (k) c.f117352a.g().acquireModule("KRNotifyModule");
    }
}
