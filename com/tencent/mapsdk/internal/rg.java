package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rg {

    /* renamed from: a, reason: collision with root package name */
    private re f150026a;

    public rg(re reVar) {
        this.f150026a = reVar;
    }

    public final qz a(TileOverlayOptions tileOverlayOptions) {
        qz qzVar;
        TileProvider tileProvider = tileOverlayOptions.getTileProvider();
        if (tileProvider != null) {
            if (tileProvider instanceof ro) {
                qzVar = new rf(this.f150026a, tileOverlayOptions);
            } else if (tileProvider instanceof sq) {
                qzVar = new rh(this.f150026a, tileOverlayOptions);
            } else {
                qzVar = new qz(this.f150026a, tileOverlayOptions);
            }
        } else {
            qzVar = null;
        }
        this.f150026a.a(qzVar);
        return qzVar;
    }
}
