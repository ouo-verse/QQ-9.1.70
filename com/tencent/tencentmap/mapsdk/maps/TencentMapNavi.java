package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TencentMapNavi extends TencentMap {
    IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions intersectionOverlayOptions);

    void addSegmentsWithRouteName(List<MapRouteSection> list, List<LatLng> list2);

    void animateToNaviPosition(LatLng latLng, float f16, float f17);

    void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18);

    void animateToNaviPosition(LatLng latLng, float f16, float f17, float f18, boolean z16);

    void animateToNaviPosition2(LatLng latLng, float f16, float f17, float f18, boolean z16);

    float calNaviLevel(LatLngBounds latLngBounds, float f16, int i3, boolean z16);

    float calNaviLevel2(LatLng latLng, LatLng latLng2, float f16, float f17, int i3, boolean z16);

    float calNaviLevel3(LatLng latLng, LatLng latLng2, float f16, int i3, int i16, int i17, int i18, boolean z16);

    CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback);

    void clearRouteNameSegments();

    boolean isNaviStateEnabled();

    void moveToNavPosition(CameraUpdate cameraUpdate, LatLng latLng);

    void setNavCenter(int i3, int i16);

    void setNaviFixingProportion(float f16, float f17);

    void setNaviFixingProportion2D(float f16, float f17);

    void setNaviStateEnabled(boolean z16);

    void setOptionalResourcePath(String str);
}
