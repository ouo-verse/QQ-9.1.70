package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public class sw extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "error")
    public int f150411a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "info")
    public sv f150412b;

    private int a() {
        return this.f150411a;
    }

    private sv b() {
        return this.f150412b;
    }

    private void a(int i3) {
        this.f150411a = i3;
    }

    private void a(sv svVar) {
        this.f150412b = svVar;
    }
}
