package com.tencent.luggage.wxa.y1;

import com.tencent.luggage.wxa.jg.e0;
import com.tencent.luggage.wxa.r4.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends e0 {
    @Override // com.tencent.luggage.wxa.jg.e0
    public void a(d component, Map outRes) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(outRes, "outRes");
        int a16 = com.tencent.luggage.wxa.e2.a.a(component);
        if (a16 > 0) {
            outRes.put("statusBarHeight", Integer.valueOf(a16));
        }
    }
}
