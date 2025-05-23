package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class hk extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "showCount")
    public int f148682a;

    hk() {
        this.f148682a = 0;
    }

    private int a() {
        int i3 = this.f148682a + 1;
        this.f148682a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public hk(long j3) {
        super(j3);
        this.f148682a = 0;
    }
}
