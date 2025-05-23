package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class at extends aw<ah> implements Arc {

    /* renamed from: b, reason: collision with root package name */
    private final ah f147773b;

    public at(ah ahVar) {
        this.f147773b = ahVar;
    }

    private ah b() {
        return this.f147773b;
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final /* bridge */ /* synthetic */ ah f_() {
        return this.f147773b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final LatLng getCenter() {
        return this.f147773b.getCenter();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public final int getColor() {
        return this.f147773b.getColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final double getLength() {
        return this.f147773b.getLength();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Arc
    public final double getRadius() {
        return this.f147773b.getRadius();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final int getStrokeColor() {
        return this.f147773b.getStrokeColor();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final float getStrokeWidth() {
        return this.f147773b.getStrokeWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public final float getWidth() {
        return this.f147773b.getWidth();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Colorable
    public final void setColor(int i3) {
        this.f147773b.setColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeColor(int i3) {
        this.f147773b.setStrokeColor(i3);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Strokeable
    public final void setStrokeWidth(float f16) {
        this.f147773b.setStrokeWidth(f16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Widthable
    public final void setWidth(float f16) {
        this.f147773b.setWidth(f16);
    }
}
