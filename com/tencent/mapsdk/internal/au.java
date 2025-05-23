package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class au extends aw<ai> implements Circle {

    /* renamed from: b, reason: collision with root package name */
    private ai f147774b;

    public au(ai aiVar) {
        this.f147774b = aiVar;
    }

    private ai b() {
        return this.f147774b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final boolean contains(LatLng latLng) {
        return this.f147774b.contains(latLng);
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ ai f_() {
        return this.f147774b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final LatLng getCenter() {
        return this.f147774b.getCenter();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public final int getFillColor() {
        return this.f147774b.getFillColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final double getRadius() {
        return this.f147774b.getRadius();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final int getStrokeColor() {
        return this.f147774b.getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final float getStrokeWidth() {
        return this.f147774b.getStrokeWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final Object getTag() {
        return this.f147774b.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final boolean isClickable() {
        return this.f147774b.isClickable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final void setCenter(LatLng latLng) {
        this.f147774b.setCenter(latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final void setClickable(boolean z16) {
        this.f147774b.setClickable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public final void setFillColor(int i3) {
        this.f147774b.setFillColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    @Deprecated
    public final void setOptions(CircleOptions circleOptions) {
        this.f147774b.setOptions(circleOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Circle
    public final void setRadius(double d16) {
        this.f147774b.setRadius(d16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeColor(int i3) {
        this.f147774b.setStrokeColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeWidth(float f16) {
        this.f147774b.setStrokeWidth(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final void setTag(Object obj) {
        this.f147774b.setTag(obj);
    }
}
