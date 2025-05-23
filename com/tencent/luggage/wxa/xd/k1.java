package com.tencent.luggage.wxa.xd;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k1 extends m1 {
    @Override // com.tencent.luggage.wxa.xd.m1
    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.a(config);
        m1.f144865a.a(config, "nativeBufferEnabled", Boolean.TRUE);
    }
}
