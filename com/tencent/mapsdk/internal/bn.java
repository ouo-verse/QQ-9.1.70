package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayer;
import com.tencent.tencentmap.mapsdk.maps.model.AoiLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Arc;
import com.tencent.tencentmap.mapsdk.maps.model.ArcOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class bn implements bv, TencentMap {
    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public AoiLayer addAoiLayer(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener) {
        lc.a(lb.f149152aa, "addAoiLayer", (Object) (str + "#" + aoiLayerOptions + "#" + onAoiLayerLoadListener), h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Arc addArc(ArcOptions arcOptions) {
        lc.a(lb.f149152aa, "addArc", arcOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Circle addCircle(CircleOptions circleOptions) {
        lc.a(lb.f149152aa, "addCircle", circleOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions) {
        lc.a(lb.f149152aa, "addCustomLayer", customLayerOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        lc.a(lb.f149152aa, "addGroundOverlay", groundOverlayOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Marker addMarker(MarkerOptions markerOptions) {
        lc.a(lb.f149152aa, "addMarker", markerOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        lc.a(lb.f149152aa, "addOnMapLoadedCallback", onMapLoadedCallback, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        lc.a(lb.f149152aa, "addPolygon", polygonOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        lc.a(lb.f149152aa, "addPolyline", polylineOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        lc.a(lb.f149152aa, "addTencentMapGestureListener", tencentMapGestureListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        lc.a(lb.f149152aa, "addTileOverlay", tileOverlayOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        lc.a(lb.f149152aa, "addVectorHeatOverlay", vectorHeatOverlayOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public <L extends VectorOverlay> L addVectorOverlay(VectorOverlayProvider vectorOverlayProvider) {
        lc.a(lb.f149152aa, "addVectorOverlay", vectorOverlayProvider, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public VisualLayer addVisualLayer(VisualLayerOptions visualLayerOptions) {
        lc.a(lb.f149152aa, "addVisualLayer", visualLayerOptions, h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate) {
        lc.a(lb.f149152aa, "animateCamera", cameraUpdate, h());
    }

    protected abstract void b();

    @Override // com.tencent.mapsdk.internal.bv
    public final void b(Bundle bundle) {
        lc.a(lb.Q, h());
        a(bundle);
        lc.c(lb.Q, h());
    }

    protected abstract void c();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public CameraPosition calculateZoomToSpanLevel(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18) {
        lc.a(lb.f149152aa, "calculateZoomToSpanLevel", (Object) (list + "#" + list2 + "#" + i3 + "#" + i16 + "#" + i17 + "#" + i18), h());
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clear() {
        lc.a(lb.f149152aa, QCircleLpReportDc05507.KEY_CLEAR, Integer.valueOf(lc.e(lb.f149152aa, QCircleLpReportDc05507.KEY_CLEAR, h())), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearAllOverlays() {
        lc.a(lb.f149152aa, "clearAllOverlays", Integer.valueOf(lc.e(lb.f149152aa, "clearAllOverlays", h())), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void clearCache() {
        lc.a(lb.f149152aa, HippyReporter.RemoveEngineReason.CLEAR_CACHE, Integer.valueOf(lc.e(lb.f149152aa, HippyReporter.RemoveEngineReason.CLEAR_CACHE, h())), h());
    }

    protected abstract void d();

    protected abstract void e();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableAutoMaxSkew(boolean z16) {
        lc.a(lb.f149152aa, "enableAutoMaxSkew", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void enableMultipleInfowindow(boolean z16) {
        lc.a(lb.f149152aa, "enableMultipleInfowindow", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public String executeVisualLayerCommand(VisualLayer visualLayer, String str) {
        lc.a(lb.f149152aa, "executeVisualLayerCommand", (Object) (visualLayer + "#" + str), h());
        return null;
    }

    protected abstract void f();

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls) {
        return (T) getMapContext().getMapComponent(cls);
    }

    protected abstract int h();

    @Override // com.tencent.mapsdk.internal.bv
    public final void i() {
        lc.a(lb.R, h());
        b();
        lc.c(lb.R, h());
    }

    @Override // com.tencent.mapsdk.internal.bv
    public final void j() {
        lc.a(lb.S, h());
        c();
        lc.c(lb.S, h());
    }

    @Override // com.tencent.mapsdk.internal.bv
    public final void k() {
        lc.a(lb.U, h());
        d();
        lc.c(lb.U, h());
    }

    @Override // com.tencent.mapsdk.internal.bv
    public final void l() {
        lc.a(lb.T, h());
        lc.c(lb.T, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void loadKMLFile(String str) {
        lc.a(lb.f149152aa, "loadKMLFile", (Object) str, h());
    }

    @Override // com.tencent.mapsdk.internal.bv
    public final void m() {
        lc.a(lb.V, h());
        f();
        lc.c(lb.V, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void moveCamera(CameraUpdate cameraUpdate) {
        lc.a(lb.f149152aa, "moveCamera", cameraUpdate, h());
    }

    @Override // com.tencent.mapsdk.internal.bv
    public final void n() {
        lc.a(lb.W, h());
        g();
        lc.c(lb.W, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        lc.a(lb.f149152aa, "removeOnMapLoadedCallback", onMapLoadedCallback, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        lc.a(lb.f149152aa, "removeTencentMapGestureListener", tencentMapGestureListener, h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void resetIndoorCellInfo() {
        lc.a(lb.f149152aa, "resetIndoorParkSpaceColors", (Object) "", h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBaseMapEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setBaseMapEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBlockRouteEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setBlockRouteEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuilding3dEffectEnable(boolean z16) {
        lc.a(lb.f149152aa, "setBuilding3dEffectEnable", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingBlackList(List<LatLngBounds> list) {
        lc.a(lb.f149152aa, "setBuildingBlackList", list, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setBuildingEnable(boolean z16) {
        lc.a(lb.f149152aa, "setBuildingEnable", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f16, float f17) {
        lc.a(lb.f149152aa, "setCameraCenterProportion", (Object) (f16 + "#" + f17), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCustomRender(CustomRender customRender) {
        lc.a(lb.f149152aa, "setCustomRender", customRender, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setDrawPillarWith2DStyle(boolean z16) {
        lc.a(lb.f149152aa, "setDrawPillarWith2DStyle", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setForeignLanguage(Language language) {
        lc.a(lb.f149152aa, "setForeignLanguage", language, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setHandDrawMapEnable(boolean z16) {
        lc.a(lb.f149152aa, "setHandDrawMapEnable", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorCellInfo(List<IndoorCellInfo> list) {
        lc.a(lb.f149152aa, "setIndoorParkSpaceColors", list, h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setIndoorEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(int i3) {
        lc.a(lb.f149152aa, "setIndoorFloor", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorMaskColor(int i3) {
        lc.a(lb.f149152aa, "setIndoorMaskColor", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        lc.a(lb.f149152aa, "setInfoWindowAdapter", infoWindowAdapter, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLanguage(Language language) {
        lc.a(lb.f149152aa, "setLanguage", language, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationCompassHidden(boolean z16) {
        lc.a(lb.f149152aa, "setLocationCompassEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setLocationNavigationGravityLineHidden(boolean z16) {
        lc.a(lb.f149152aa, "setLocationNavigationGravityLineEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setLocationSource(LocationSource locationSource) {
        lc.a(lb.f149152aa, "setLocationSource", locationSource, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapCenterAndScale(float f16, float f17, float f18) {
        lc.a(lb.f149152aa, "setMapCenterAndScale", (Object) (f16 + "#" + f17 + "#" + f18), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFontSize(MapFontSize mapFontSize) {
        lc.a(lb.f149152aa, "setMapFontSize", mapFontSize, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapFrameRate(float f16) {
        lc.a(lb.f149152aa, "setMapFrameRate", Float.valueOf(f16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapStyle(int i3) {
        lc.a(lb.f149152aa, "setMapStyle", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMapType(int i3) {
        lc.a(lb.f149152aa, "setMapType", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMaxZoomLevel(int i3) {
        lc.a(lb.f149152aa, "setMaxZoomLevel", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setMinZoomLevel(int i3) {
        lc.a(lb.f149152aa, "setMinZoomLevel", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationClickListener(TencentMap.OnMyLocationClickListener onMyLocationClickListener) {
        lc.a(lb.f149152aa, "setMyLocationClickListener", onMyLocationClickListener, h());
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setMyLocationEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap, com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        lc.a(lb.f149152aa, "setMyLocationStyle", myLocationStyle, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCameraChangeListener(TencentMap.OnCameraChangeListener onCameraChangeListener) {
        lc.a(lb.f149152aa, "setOnCameraChangeListener", onCameraChangeListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnCompassClickedListener(TencentMap.OnCompassClickedListener onCompassClickedListener) {
        lc.a(lb.f149152aa, "setOnCompassClickedListener", onCompassClickedListener, h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        lc.a(lb.f149152aa, "setOnIndoorStateChangeListener", onIndoorStateChangeListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        lc.a(lb.f149152aa, "OnInfoWindowClickListener", onInfoWindowClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        lc.a(lb.f149152aa, "setOnMapClickListener", onMapClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapFrameFinished(TencentMap.OnMapFrameFinishCallback onMapFrameFinishCallback) {
        lc.a(lb.f149152aa, "setOnMapFrameFinished", onMapFrameFinishCallback, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback onMapLoadedCallback) {
        addOnMapLoadedCallback(onMapLoadedCallback);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapLongClickListener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        lc.a(lb.f149152aa, "setOnMapLongClickListener", onMapLongClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        lc.a(lb.f149152aa, "setOnMapPoiClickListener", onMapPoiClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        lc.a(lb.f149152aa, "setOnMarkerClickListener", onMarkerClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerCollisionStatusListener(TencentMap.OnMarkerCollisionStatusListener onMarkerCollisionStatusListener) {
        lc.a(lb.f149152aa, "OnMarkerCollisionStatusListener", onMarkerCollisionStatusListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnMarkerDragListener(TencentMap.OnMarkerDragListener onMarkerDragListener) {
        lc.a(lb.f149152aa, "OnMarkerDragListener", onMarkerDragListener, h());
    }

    @Override // com.tencent.map.sdk.comps.mylocation.IMyLocation
    public void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        lc.a(lb.f149152aa, "setOnMyLocationChangeListener", onMyLocationChangeListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolygonClickListener(TencentMap.OnPolygonClickListener onPolygonClickListener) {
        lc.a(lb.f149152aa, "setOnPolygonClickListener", onPolygonClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnPolylineClickListener(TencentMap.OnPolylineClickListener onPolylineClickListener) {
        lc.a(lb.f149152aa, "setOnPolylineClickListener", onPolylineClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnScaleViewChangedListener(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener) {
        lc.a(lb.f149152aa, "setOnScaleViewChangedListener", onScaleViewChangedListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTapMapViewInfoWindowHidden(boolean z16) {
        lc.a(lb.f149152aa, "setOnTapMapViewInfoWindowHidden", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnTrafficEventClickListener(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener) {
        boolean z16;
        if (onTrafficEventClickListener != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        lc.a(lb.f149152aa, "setOnTrafficEventClickListener", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOnVectorOverlayClickListener(TencentMap.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        lc.a(lb.f149152aa, "setOnVectorOverlayClickListener", onVectorOverlayClickListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaEnable(boolean z16) {
        lc.a(lb.f149152aa, "enableOverSea", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider) {
        lc.a(lb.f149152aa, "setOverSeaTileProvider", overSeaTileProvider, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i3, int i16, int i17, int i18) {
        lc.a(lb.f149152aa, "setPadding", (Object) (i3 + "#" + i16 + "#" + i17 + "#" + i18), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPointToCenter(int i3, int i16) {
        lc.a(lb.f149152aa, "setPointToCenter", (Object) (i3 + "#" + i16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPoisEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setPoisEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode) {
        String str;
        if (latLngBounds == null) {
            str = "null restrictBounds";
        } else {
            str = latLngBounds.toString() + "#" + restrictBoundsFitMode;
        }
        lc.a(lb.f149152aa, "setRestrictBounds", (Object) str, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSatelliteEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setSatelliteEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setSceneByTag(String str) {
        lc.a(lb.f149152aa, "setSceneByTag", (Object) str, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener) {
        lc.a(lb.f149152aa, "setTencentMapGestureListener", tencentMapGestureListener, h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficEnabled(boolean z16) {
        lc.a(lb.f149152aa, "setTrafficEnabled", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setTrafficMode(int i3, int i16) {
        lc.a(lb.f149152aa, "setTrafficMode", (Object) (i3 + "#" + i16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void showBuilding(boolean z16) {
        lc.a(lb.f149152aa, "showBuilding", Boolean.valueOf(z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(snapshotReadyCallback != null);
        sb5.append("#");
        sb5.append(config);
        sb5.append("#");
        sb5.append(i3);
        lc.a(lb.f149152aa, "snapshot", (Object) sb5.toString(), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void stopAnimation() {
        lc.a(lb.f149152aa, "stopAnimation", Integer.valueOf(lc.e(lb.f149152aa, "stopAnimation", h())), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void updateVectorOverlay(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider) {
        lc.a(lb.f149152aa, "updateVectorOverlay", (Object) (vectorOverlay + "#" + vectorOverlayProvider), h());
    }

    public void a(int i3) {
        lc.a(lb.f149152aa, "setIndoorConfigType", Integer.valueOf(i3), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, TencentMap.CancelableCallback cancelableCallback) {
        lc.a(lb.f149152aa, "animateCamera", (Object) (cameraUpdate + "#" + cancelableCallback), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setCameraCenterProportion(float f16, float f17, boolean z16) {
        lc.a(lb.f149152aa, "setCameraCenterProportion", (Object) (f16 + "#" + f17 + "#" + z16), h());
    }

    @Override // com.tencent.map.sdk.comps.indoor.IIndoor
    public void setIndoorFloor(String str, String str2) {
        lc.a(lb.f149152aa, "setIndoorFloor", (Object) (str + "#" + str2), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void setPadding(int i3, int i16, int i17, int i18, boolean z16) {
        lc.a(lb.f149152aa, "setPadding", (Object) (i3 + "#" + i16 + "#" + i17 + "#" + i18 + "#" + z16), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(snapshotReadyCallback != null);
        sb5.append("#");
        sb5.append(config);
        lc.a(lb.f149152aa, "snapshot", (Object) sb5.toString(), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void animateCamera(CameraUpdate cameraUpdate, long j3, TencentMap.CancelableCallback cancelableCallback) {
        lc.a(lb.f149152aa, "animateCamera", (Object) (cameraUpdate + "#" + j3 + "#" + cancelableCallback), h());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap
    public void snapshot(TencentMap.SnapshotReadyCallback snapshotReadyCallback) {
        lc.a(lb.f149152aa, "snapshot", Boolean.valueOf(snapshotReadyCallback != null), h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }
}
