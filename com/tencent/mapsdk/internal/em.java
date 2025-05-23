package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class em extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(name = "layers")
    public List<el> f148206a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "enable")
    private int f148207b;

    private List<el> b() {
        return this.f148206a;
    }

    public final boolean a() {
        if (this.f148207b == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "DataLayerInfo{enable=" + this.f148207b + ", layers=" + this.f148206a + '}';
    }
}
