package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class su extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "version")
    public int f150399a = 0;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "path")
    public String f150400b;

    private String a() {
        return this.f150400b;
    }

    private int b() {
        return this.f150399a;
    }

    private void a(String str) {
        this.f150400b = str;
    }

    private void a(int i3) {
        this.f150399a = i3;
    }
}
