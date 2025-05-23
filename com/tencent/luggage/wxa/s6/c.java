package com.tencent.luggage.wxa.s6;

import com.tencent.xweb.XWebSdk;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.z5.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull h pv5) {
        super(pv5);
        Intrinsics.checkNotNullParameter(pv5, "pv");
    }

    @Override // com.tencent.luggage.wxa.z5.c, com.tencent.luggage.wxa.kj.a, com.tencent.luggage.wxa.mj.d
    public Map q() {
        com.tencent.luggage.wxa.p5.b bVar;
        com.tencent.luggage.wxa.v6.h hVar = new com.tencent.luggage.wxa.v6.h();
        if (b()) {
            bVar = com.tencent.luggage.wxa.p5.b.Skyline;
        } else if (XWebSdk.isXWebView()) {
            bVar = com.tencent.luggage.wxa.p5.b.XWalk;
        } else {
            bVar = com.tencent.luggage.wxa.p5.b.Sys;
        }
        hVar.a(bVar);
        return hVar.b();
    }
}
