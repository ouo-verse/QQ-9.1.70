package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gv extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "showCount")
    public int f148600a;

    public gv() {
        this.f148600a = 0;
    }

    private int a() {
        int i3 = this.f148600a + 1;
        this.f148600a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gv(long j3) {
        super(j3);
        this.f148600a = 0;
    }
}
