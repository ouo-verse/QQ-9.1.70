package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import p35.af;

/* loaded from: classes31.dex */
public final class NBPLatLngExtKt {
    public static final NBPLatLng DEFAULT_INIT_POS = new NBPLatLng(0.0d, 0.0d);
    public static final OffsetRandom offsetRandom = new OffsetRandom(0.0d, 0.0d);

    public static final NBPLatLng toLatLng(af afVar) {
        double d16 = 1000000;
        return new NBPLatLng(afVar.f425135d / d16, afVar.f425136e / d16);
    }
}
