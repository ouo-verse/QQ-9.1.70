package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ss extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "level")
    public int[] f150385a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "districts")
    public List<st> f150386b;

    private void a(int[] iArr) {
        this.f150385a = iArr;
    }

    private List<st> b() {
        return this.f150386b;
    }

    private void a(List<st> list) {
        this.f150386b = list;
    }

    private int[] a() {
        return this.f150385a;
    }
}
