package com.tencent.tencentmap.mapsdk.maps;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.map.sdk.comps.indoor.IIndoor;
import com.tencent.map.sdk.comps.mylocation.IMyLocation;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
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
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapFontSize;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
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
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TencentMap extends IIndoor, IMyLocation {
    public static final int MAP_MODE_NAV = 12;
    public static final int MAP_MODE_NAV_NIGHT = 1013;
    public static final int MAP_MODE_NAV_TRAFFIC = 1009;
    public static final int MAP_MODE_NORMAL = 0;
    public static final int MAP_MODE_NORMAL_TRAFFIC = 5;
    public static final int MAP_TYPE_DARK = 1008;
    public static final int MAP_TYPE_NAVI = 1012;
    public static final int MAP_TYPE_NIGHT = 1013;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1000;
    public static final int MAP_TYPE_SATELLITE = 1011;
    public static final int MAP_TYPE_TRAFFIC_NAVI = 1009;
    public static final int MAP_TYPE_TRAFFIC_NIGHT = 1010;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface AsyncOperateCallback<T> {
        void onOperateFinished(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IClickedObject {
        String getIdentifier();

        @Nullable
        String getName();

        LatLng getPosition();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnAuthResultCallback {
        void onAuthFail(int i3, String str);

        void onAuthSuccess();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinished(CameraPosition cameraPosition);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnCompassClickedListener {
        void onCompassClicked();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnDismissCallback {
        void onDismiss();

        void onNotify();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnIndoorStateChangeListener {
        boolean onIndoorBuildingDeactivated();

        boolean onIndoorBuildingFocused();

        boolean onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);

        void onInfoWindowClickLocation(int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMapFrameFinishCallback {
        void onMapFrameFinished();

        void onMapFrameStart();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMapPoiClickListener {
        void onClicked(MapPoi mapPoi);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMarkerCollisionStatusListener {
        void onCollisionHidden(Marker marker, List<MarkerCollisionRelationUnit> list);

        void onCollisionShown(Marker marker, List<MarkerCollisionRelationUnit> list);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnMyLocationClickListener {
        boolean onMyLocationClicked(LatLng latLng);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon, LatLng latLng);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline, LatLng latLng);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnScaleViewChangedListener {
        void onScaleViewChanged(float f16);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnTrafficEventClickListener {
        void onTrafficEventClicked(TrafficEvent trafficEvent);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnVectorOverlayClickListener {
        void onClicked(VectorOverlay vectorOverlay, @Nullable IClickedObject iClickedObject);
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    AoiLayer addAoiLayer(String str, AoiLayerOptions aoiLayerOptions, AoiLayer.OnAoiLayerLoadListener onAoiLayerLoadListener);

    Arc addArc(ArcOptions arcOptions);

    Circle addCircle(CircleOptions circleOptions);

    CustomLayer addCustomLayer(CustomLayerOptions customLayerOptions);

    GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions);

    Marker addMarker(MarkerOptions markerOptions);

    void addOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    Polygon addPolygon(PolygonOptions polygonOptions);

    Polyline addPolyline(PolylineOptions polylineOptions);

    void addTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions);

    VectorHeatOverlay addVectorHeatOverlay(VectorHeatOverlayOptions vectorHeatOverlayOptions);

    <L extends VectorOverlay> L addVectorOverlay(VectorOverlayProvider vectorOverlayProvider);

    VisualLayer addVisualLayer(VisualLayerOptions visualLayerOptions);

    void animateCamera(CameraUpdate cameraUpdate);

    void animateCamera(CameraUpdate cameraUpdate, long j3, CancelableCallback cancelableCallback);

    void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback);

    CameraPosition calculateZoomToSpanLevel(List<IOverlay> list, List<LatLng> list2, int i3, int i16, int i17, int i18);

    void clear();

    void clearAllOverlays();

    void clearCache();

    void enableAutoMaxSkew(boolean z16);

    void enableMultipleInfowindow(boolean z16);

    String executeVisualLayerCommand(VisualLayer visualLayer, String str);

    List<LatLng> getBounderPoints(Marker marker);

    CameraPosition getCameraPosition();

    String getCityName(LatLng latLng);

    String getDebugError();

    Language getLanguage();

    <T extends TencentMapComponent.Component> T getMapComponent(Class<T> cls);

    TencentMapContext getMapContext();

    int getMapHeight();

    Rect getMapPadding();

    int getMapStyle();

    int getMapType();

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    Projection getProjection();

    List<Marker> getScreenMarkers();

    UiSettings getUiSettings();

    String getVersion();

    VisualSettings getVisualSettings();

    float getZoomToSpanLevel(LatLng latLng, LatLng latLng2);

    boolean isBlockRouteEnabled();

    boolean isDestroyed();

    boolean isHandDrawMapEnable();

    boolean isSateLiteEnable();

    boolean isTrafficEnabled();

    void loadKMLFile(String str);

    void moveCamera(CameraUpdate cameraUpdate);

    void removeOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    void removeTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setBaseMapEnabled(boolean z16);

    void setBlockRouteEnabled(boolean z16);

    void setBuilding3dEffectEnable(boolean z16);

    void setBuildingBlackList(List<LatLngBounds> list);

    void setBuildingEnable(boolean z16);

    void setCameraCenterProportion(float f16, float f17);

    void setCameraCenterProportion(float f16, float f17, boolean z16);

    void setCustomRender(CustomRender customRender);

    void setDrawPillarWith2DStyle(boolean z16);

    void setForeignLanguage(Language language);

    void setHandDrawMapEnable(boolean z16);

    void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter);

    void setLanguage(Language language);

    void setLocationCompassHidden(boolean z16);

    void setLocationNavigationGravityLineHidden(boolean z16);

    void setMapCenterAndScale(float f16, float f17, float f18);

    void setMapFontSize(MapFontSize mapFontSize);

    void setMapFrameRate(float f16);

    void setMapStyle(int i3);

    void setMapType(int i3);

    void setMaxZoomLevel(int i3);

    void setMinZoomLevel(int i3);

    void setMyLocationStyle(MyLocationStyle myLocationStyle);

    void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener);

    void setOnCompassClickedListener(OnCompassClickedListener onCompassClickedListener);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener);

    void setOnMapClickListener(OnMapClickListener onMapClickListener);

    void setOnMapFrameFinished(OnMapFrameFinishCallback onMapFrameFinishCallback);

    void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback);

    void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

    void setOnMapPoiClickListener(OnMapPoiClickListener onMapPoiClickListener);

    void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener);

    void setOnMarkerCollisionStatusListener(OnMarkerCollisionStatusListener onMarkerCollisionStatusListener);

    void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener);

    void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener);

    void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener);

    void setOnScaleViewChangedListener(OnScaleViewChangedListener onScaleViewChangedListener);

    void setOnTapMapViewInfoWindowHidden(boolean z16);

    void setOnTrafficEventClickListener(OnTrafficEventClickListener onTrafficEventClickListener);

    void setOnVectorOverlayClickListener(OnVectorOverlayClickListener onVectorOverlayClickListener);

    void setOverSeaEnable(boolean z16);

    void setOverSeaTileProvider(OverSeaTileProvider overSeaTileProvider);

    void setPadding(int i3, int i16, int i17, int i18);

    void setPadding(int i3, int i16, int i17, int i18, boolean z16);

    void setPointToCenter(int i3, int i16);

    void setPoisEnabled(boolean z16);

    void setRestrictBounds(LatLngBounds latLngBounds, RestrictBoundsFitMode restrictBoundsFitMode);

    void setSatelliteEnabled(boolean z16);

    void setSceneByTag(String str);

    void setTencentMapGestureListener(TencentMapGestureListener tencentMapGestureListener);

    void setTrafficEnabled(boolean z16);

    void setTrafficMode(int i3, int i16);

    void showBuilding(boolean z16);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config);

    void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap.Config config, int i3);

    void stopAnimation();

    void updateVectorOverlay(VectorOverlay vectorOverlay, VectorOverlayProvider vectorOverlayProvider);
}
