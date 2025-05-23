package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hm extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "showCount")
    private int f148684a;

    hm() {
        this.f148684a = 0;
    }

    public final int a() {
        int i3 = this.f148684a + 1;
        this.f148684a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hm(long j3) {
        super(j3);
        this.f148684a = 0;
    }
}
