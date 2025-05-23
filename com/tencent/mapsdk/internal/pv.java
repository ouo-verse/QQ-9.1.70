package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pv extends AccessibleTouchItem {

    /* renamed from: a, reason: collision with root package name */
    private MapPoi f149667a;

    /* renamed from: b, reason: collision with root package name */
    private tr f149668b;

    public pv(tr trVar, MapPoi mapPoi) {
        this.f149667a = mapPoi;
        this.f149668b = trVar;
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final Rect getBounds() {
        fw a16 = ((VectorMap) this.f149668b.e_).getProjection().a(GeoPoint.from(new LatLng(this.f149667a.getLatitude(), this.f149667a.getLongitude())));
        return new Rect((int) (a16.f148383a - (ho.o() * 20.0f)), (int) (a16.f148384b - (ho.o() * 20.0f)), (int) (a16.f148383a + (ho.o() * 20.0f)), (int) (a16.f148384b + (ho.o() * 20.0f)));
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final String getContentDescription() {
        return this.f149667a.getName();
    }

    @Override // com.tencent.map.lib.models.AccessibleTouchItem
    public final void onClick() {
        TencentMap.OnMapPoiClickListener onMapPoiClickListener;
        tr trVar = this.f149668b;
        if (trVar != null && (onMapPoiClickListener = trVar.f151067x) != null) {
            MapPoi mapPoi = new MapPoi();
            mapPoi.position = new LatLng(this.f149667a.getLatitude(), this.f149667a.getLongitude());
            mapPoi.name = this.f149667a.getName();
            onMapPoiClickListener.onClicked(mapPoi);
        }
    }
}
