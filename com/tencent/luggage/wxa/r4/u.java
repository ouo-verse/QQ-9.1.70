package com.tencent.luggage.wxa.r4;

import com.tencent.luggage.wxa.xd.k1;
import com.tencent.luggage.wxa.xd.m1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u extends k1 {
    @Override // com.tencent.luggage.wxa.xd.k1, com.tencent.luggage.wxa.xd.m1
    public void a(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.a(config);
        m1.f144865a.a(config, "isIsolateContext", Boolean.TRUE);
    }
}
