package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.CallbackRunnable;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qw {

    /* renamed from: a, reason: collision with root package name */
    public int f149953a;

    /* renamed from: b, reason: collision with root package name */
    public tk f149954b;

    public qw(tk tkVar, GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        this.f149954b = tkVar;
        if (tkVar == null) {
            return;
        }
        this.f149953a = ((Integer) tkVar.a((CallbackRunnable<tk.AnonymousClass52>) new tk.AnonymousClass52(geoPointArr, text), (tk.AnonymousClass52) (-1))).intValue();
    }

    private void a(PolylineOptions.Text text) {
        int i3;
        tk tkVar = this.f149954b;
        if (tkVar == null || (i3 = this.f149953a) <= 0) {
            return;
        }
        tkVar.a(new tk.AnonymousClass54(i3, text));
    }

    public final void a() {
        int i3;
        tk tkVar = this.f149954b;
        if (tkVar == null || (i3 = this.f149953a) <= 0) {
            return;
        }
        tkVar.f(i3);
    }
}
