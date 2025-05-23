package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class st extends JsonComposer {

    /* renamed from: i, reason: collision with root package name */
    private static final String f150387i = "default";

    /* renamed from: k, reason: collision with root package name */
    private static final int f150388k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f150389l = 1;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "logo_night")
    public String f150394e;

    /* renamed from: f, reason: collision with root package name */
    @Json(ignore = true)
    public Bitmap f150395f;

    /* renamed from: g, reason: collision with root package name */
    @Json(ignore = true)
    public Bitmap f150396g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f150397h;

    /* renamed from: a, reason: collision with root package name */
    @Json(name = TransferConfig.ExtendParamFloats.KEY_RULE)
    public int f150390a = 0;

    /* renamed from: j, reason: collision with root package name */
    @Json(name = "priority")
    private int f150398j = 0;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "frontier")
    public String f150391b = "default";

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "logo_name")
    public String f150392c = "";

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "logo")
    public String f150393d = "";

    private boolean b() {
        return this.f150397h;
    }

    private void c() {
        this.f150397h = true;
    }

    private void d() {
        this.f150390a = 1;
    }

    private String e() {
        return this.f150392c;
    }

    private String f() {
        return this.f150393d;
    }

    private String g() {
        return this.f150394e;
    }

    public final int a() {
        return (this.f150390a * 10) + this.f150398j;
    }

    private void b(String str) {
        this.f150392c = str;
    }

    private void c(String str) {
        this.f150393d = str;
    }

    private void d(String str) {
        this.f150394e = str;
    }

    public final boolean a(gd gdVar) {
        boolean b16;
        int i3 = this.f150390a;
        if (i3 != 0) {
            b16 = i3 != 1 ? false : c(gdVar);
        } else {
            b16 = b(gdVar);
        }
        return this.f150397h ? !b16 : b16;
    }

    private void b(Bitmap bitmap) {
        this.f150396g = bitmap;
    }

    private boolean c(gd gdVar) {
        if ("default".equals(this.f150391b)) {
            return true;
        }
        if (gdVar == null) {
            return false;
        }
        sm.a();
        ge[] c16 = sm.c(this.f150391b);
        ge[] geVarArr = gdVar.f148476b;
        if (geVarArr == null || c16 == null) {
            return true;
        }
        return sm.a(geVarArr, c16);
    }

    private boolean b(gd gdVar) {
        if ("default".equals(this.f150391b)) {
            return true;
        }
        if (gdVar == null) {
            return false;
        }
        ge geVar = gdVar.f148475a;
        sm.a();
        return sm.a(geVar, sm.c(this.f150391b));
    }

    private void a(int i3) {
        this.f150398j = i3;
    }

    private void a(String str) {
        this.f150391b = str;
    }

    public final Bitmap a(boolean z16) {
        return z16 ? this.f150396g : this.f150395f;
    }

    private void a(Bitmap bitmap) {
        this.f150395f = bitmap;
    }
}
