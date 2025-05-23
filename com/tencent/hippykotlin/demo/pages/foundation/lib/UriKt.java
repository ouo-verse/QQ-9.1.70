package com.tencent.hippykotlin.demo.pages.foundation.lib;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class UriKt {
    public static final String decodeURIComponent(String str) {
        return ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).urlDecode(str);
    }

    public static final String encodeURIComponent(String str) {
        return ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).urlEncode(str);
    }
}
