package com.tencent.luggage.wxa.h7;

import com.tencent.luggage.wxa.v6.h;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.a6.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull b service) {
        super(service);
        Intrinsics.checkNotNullParameter(service, "service");
    }

    public final Map a(h hVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.luggage.wxa.v5.a.f143255a.a(), new com.tencent.luggage.wxa.v5.a());
        hashMap.put(com.tencent.luggage.wxa.v5.c.f143257b.a(), new com.tencent.luggage.wxa.v5.c());
        hashMap.put(com.tencent.luggage.wxa.v5.b.f143256b.a(), new com.tencent.luggage.wxa.v5.b());
        hashMap.putAll(hVar.b());
        hashMap.putAll(hVar.a());
        hashMap.putAll(new com.tencent.luggage.wxa.v1.c().a());
        return hashMap;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public Map q() {
        return a(new h());
    }
}
