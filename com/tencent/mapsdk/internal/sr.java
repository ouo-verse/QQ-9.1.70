package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sr extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    public static final int f150380a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f150381b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f150382c = 3;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "scenetype")
    public int f150383d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "tilesrc")
    public sx f150384e;

    private int a() {
        return this.f150383d;
    }

    private sx b() {
        return this.f150384e;
    }

    private void c() {
        this.f150383d = 1;
    }

    private void a(sx sxVar) {
        this.f150384e = sxVar;
    }
}
