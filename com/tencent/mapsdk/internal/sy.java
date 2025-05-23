package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapNavi;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sy extends VectorMap implements TencentMapNavi {
    public sy(ne neVar) {
        super(neVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions intersectionOverlayOptions) {
        return getMapPro().addIntersectionEnlargeOverlay(intersectionOverlayOptions);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void addSegmentsWithRouteName(List<MapRouteSection> list, List<LatLng> list2) {
        getMapPro().addSegmentsWithRouteName(list, list2);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17) {
        getMapPro().animateToNaviPosition(latLng, f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void animateToNaviPosition2(LatLng latLng, float f16, float f17, float f18, boolean z16) {
        getMapPro().animateToNaviPosition2(latLng, f16, f17, f18, z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final float calNaviLevel(LatLngBounds latLngBounds, float f16, int i3, boolean z16) {
        return getMapPro().calNaviLevel(latLngBounds, f16, i3, z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final float calNaviLevel2(LatLng latLng, LatLng latLng2, float f16, float f17, int i3, boolean z16) {
        return getMapPro().calNaviLevel2(latLng, latLng2, f16, f17, i3, z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final float calNaviLevel3(LatLng latLng, LatLng latLng2, float f16, int i3, int i16, int i17, int i18, boolean z16) {
        return getMapPro().calNaviLevel3(latLng, latLng2, f16, i3, i16, i17, i18, z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback) {
        return getMapPro().calculateZoomToSpanLevelAsync(list, list2, i3, i16, i17, i18, asyncOperateCallback);
    }

    @Override // com.tencent.mapsdk.vector.VectorMap, com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void clearRouteNameSegments() {
        getMapPro().clearRouteNameSegments();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final boolean isNaviStateEnabled() {
        return getMapPro().isNaviStateEnabled();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void moveToNavPosition(CameraUpdate cameraUpdate, LatLng latLng) {
        getMapPro().moveToNavPosition(cameraUpdate, latLng);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void setNavCenter(int i3, int i16) {
        getMapPro().setNavCenter(i3, i16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void setNaviFixingProportion(float f16, float f17) {
        getMapPro().setNaviFixingProportion(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void setNaviFixingProportion2D(float f16, float f17) {
        getMapPro().setNaviFixingProportion2D(f16, f17);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void setNaviStateEnabled(boolean z16) {
        getMapPro().setNaviStateEnabled(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void setOptionalResourcePath(String str) {
        getMapPro().setOptionalResourcePath(str);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18) {
        getMapPro().animateToNaviPosition(latLng, f16, f17, f18);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
    public final void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18, boolean z16) {
        getMapPro().animateToNaviPosition(latLng, f16, f17, f18, z16);
    }
}
