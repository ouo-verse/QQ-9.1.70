package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class gz extends hj {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "showCount")
    public int f148606a;

    public gz() {
        this.f148606a = 0;
    }

    private int a() {
        int i3 = this.f148606a + 1;
        this.f148606a = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public gz(long j3) {
        super(j3);
        this.f148606a = 0;
    }
}
