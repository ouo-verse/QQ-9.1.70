package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hl extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "customLayerTimes")
    public int f148683a;

    hl() {
    }

    private int a() {
        int i3 = this.f148683a + 1;
        this.f148683a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hl(long j3) {
        super(j3);
    }
}
