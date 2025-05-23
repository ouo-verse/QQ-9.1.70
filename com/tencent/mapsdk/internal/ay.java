package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ay extends aw<ar> implements Polygon {

    /* renamed from: b, reason: collision with root package name */
    ar f147779b;

    public ay(ar arVar) {
        this.f147779b = arVar;
    }

    private ar b() {
        return this.f147779b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final boolean contains(LatLng latLng) {
        return this.f147779b.contains(latLng);
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ ar f_() {
        return this.f147779b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public final int getFillColor() {
        return this.f147779b.getFillColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final List<LatLng> getPoints() {
        return this.f147779b.getPoints();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final int getStrokeColor() {
        return this.f147779b.getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final float getStrokeWidth() {
        return this.f147779b.getStrokeWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final Object getTag() {
        return this.f147779b.getTag();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final boolean isClickable() {
        ar arVar = this.f147779b;
        if (arVar != null) {
            return arVar.isClickable();
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Clickable
    public final void setClickable(boolean z16) {
        this.f147779b.setClickable(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Fillable
    public final void setFillColor(int i3) {
        this.f147779b.setFillColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setHolePoints(List<List<LatLng>> list) {
        ar arVar = this.f147779b;
        if (arVar == null) {
            return;
        }
        arVar.setHolePoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setOptions(PolygonOptions polygonOptions) {
        this.f147779b.setOptions(polygonOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Polygon
    public final void setPoints(List<LatLng> list) {
        ar arVar = this.f147779b;
        if (arVar == null) {
            return;
        }
        arVar.setPoints(list);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeColor(int i3) {
        this.f147779b.setStrokeColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeWidth(float f16) {
        this.f147779b.setStrokeWidth(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Tagable
    public final void setTag(Object obj) {
        this.f147779b.setTag(obj);
    }
}
