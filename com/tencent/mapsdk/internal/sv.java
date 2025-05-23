package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sv extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    public static int f150401a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f150402b = 1000;

    /* renamed from: c, reason: collision with root package name */
    public static int f150403c = 100;

    /* renamed from: d, reason: collision with root package name */
    public static final int f150404d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f150405e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static final int f150406f = 7;

    /* renamed from: g, reason: collision with root package name */
    @Json(name = "version")
    public int f150407g;

    /* renamed from: h, reason: collision with root package name */
    @Json(name = "frontier")
    public su f150408h;

    /* renamed from: i, reason: collision with root package name */
    @Json(name = "ver_data")
    public List<sr> f150409i;

    /* renamed from: j, reason: collision with root package name */
    @Json(name = "detail")
    public List<ss> f150410j;

    private int a() {
        return this.f150407g;
    }

    private su b() {
        return this.f150408h;
    }

    private List<sr> c() {
        return this.f150409i;
    }

    private List<ss> d() {
        return this.f150410j;
    }

    private void a(int i3) {
        this.f150407g = i3;
    }

    private void b(List<ss> list) {
        this.f150410j = list;
    }

    private void a(su suVar) {
        this.f150408h = suVar;
    }

    private void a(List<sr> list) {
        this.f150409i = list;
    }
}
