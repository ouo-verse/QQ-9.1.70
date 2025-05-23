package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class nt extends ng<nv> implements GroundOverlay {
    /* JADX INFO: Access modifiers changed from: package-private */
    public nt(nu nuVar, nv nvVar) {
        super(nuVar, nvVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setAlpha(float f16) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.alpha(f16);
        }
        ((nv) this.f149454d).setAlpha(f16);
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setAnchor(float f16, float f17) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.anchor(f16, f17);
        }
        ((nv) this.f149454d).a();
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setBitmap(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null) {
            return;
        }
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.bitmap(bitmapDescriptor);
        }
        nh<T> nhVar = this.f149453c;
        if (nhVar != 0) {
            ((nv) this.f149454d).setBitmap(bitmapDescriptor.getBitmap(nhVar.a()));
        }
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setLatLongBounds(LatLngBounds latLngBounds) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.latLngBounds(latLngBounds);
        }
        ((nv) this.f149454d).setLatLngBounds(latLngBounds);
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setLevel(int i3) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.level(i3);
        }
        ((nv) this.f149454d).setLevel(i3);
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setPosition(LatLng latLng) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.position(latLng);
        }
        ((nv) this.f149454d).a();
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setVisibility(boolean z16) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.visible(z16);
        }
        ((nv) this.f149454d).setVisibility(z16);
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setZindex(int i3) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.zIndex(i3);
        }
        ((nv) this.f149454d).setZIndex(i3);
        a((nt) this.f149454d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay
    public final void setZoom(float f16) {
        T t16 = this.f149454d;
        if (((nv) t16).f149474a != null) {
            ((nv) t16).f149474a.zoom(f16);
        }
        ((nv) this.f149454d).a();
        a((nt) this.f149454d);
    }
}
