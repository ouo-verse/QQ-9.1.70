package com.tencent.map.lib;

import android.graphics.Rect;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.lib.models.AnnocationText;
import com.tencent.map.lib.models.AnnocationTextResult;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.map.lib.models.CircleInfo;
import com.tencent.map.lib.models.CityTrafficInfo;
import com.tencent.map.lib.models.GLModelInfo;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.map.lib.models.IndoorCellInfo;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.map.lib.models.MaskLayer;
import com.tencent.map.lib.models.PolygonInfo;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JNIInterface implements JNIInterfaceCallback {
    private final JNIInterfaceCallback mCallback;

    public JNIInterface(JNIInterfaceCallback jNIInterfaceCallback) {
        this.mCallback = jNIInterfaceCallback;
    }

    public static native synchronized void nativeEndProfile();

    public static native synchronized void nativeStartProfile();

    public native int addLineText(long j3, GeoPoint[] geoPointArr, PolylineOptions.Text text);

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public Object callback(int i3, int i16, String str, byte[] bArr, Object obj) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.callback(i3, i16, str, bArr, obj);
        }
        return null;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public int callbackGetGLContext() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.callbackGetGLContext();
        }
        return 0;
    }

    public native boolean checkMapLoadFinishedTask(long j3, int i3);

    public native int getIndoorOutlineZoom(long j3, String str);

    public native String getMapEngineRenderStatus(long j3);

    public native long nativeAddAggregationOverlay(long j3, AggregationOverlayInfo aggregationOverlayInfo);

    public native long nativeAddArcLineOverlay(long j3, ArcLineOverlayInfo arcLineOverlayInfo);

    public native int nativeAddCircle(long j3, CircleInfo circleInfo);

    public native long nativeAddGLModel(long j3, GLModelInfo gLModelInfo);

    public native long nativeAddGroundOverlay(long j3, GroundOverlayInfo groundOverlayInfo);

    public native long nativeAddHeatmapOverlay(long j3, HeatmapInfo heatmapInfo);

    public native long nativeAddIntersectionOverlay(long j3, IntersectionOverlayInfo intersectionOverlayInfo);

    public native int nativeAddMarker(long j3, String str, String str2, double d16, double d17, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16);

    public native long nativeAddMarker2(long j3, MarkerInfo markerInfo);

    public native int nativeAddMaskLayer(long j3, MaskLayer maskLayer);

    public native int nativeAddPolygon(long j3, PolygonInfo polygonInfo);

    public native void nativeAddRouteNameSegments(long j3, byte[][] bArr, int i3, GeoPoint[] geoPointArr, int i16);

    public native long nativeAddScatterPlotOverlay(long j3, ScatterPlotInfo scatterPlotInfo);

    public native int nativeAddTileOverlay(long j3, TileOverlayCallback tileOverlayCallback, boolean z16, boolean z17);

    public native long nativeAddTrailOverlay(long j3, TrailOverlayInfo trailOverlayInfo);

    public native void nativeBringElementAbove(long j3, int i3, int i16);

    public native void nativeBringElementBelow(long j3, int i3, int i16);

    public native void nativeCheckTrafficBlockCache(long j3, int i3, int i16, int i17, int i18, int i19);

    public native void nativeCheckTrafficBlockCacheForReplay(long j3, int i3, int i16, int i17, int i18, int i19);

    public native int nativeClearCache(long j3);

    public native void nativeClearDownloadURLCache(long j3);

    public native void nativeClearRouteNameSegments(long j3);

    public native AnnocationTextResult nativeCreateAnnotationText(long j3, AnnocationText annocationText);

    public native int nativeCreateOrUpdateLine(long j3, int i3, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f16, int i16, boolean z16, boolean z17, boolean z18, boolean z19, int i17, boolean z26, int[] iArr3, int[] iArr4, float f17, int[] iArr5, float f18, int i18, boolean z27);

    public native void nativeDeleteCircle(long j3, int i3);

    public native void nativeDeleteIcons(long j3, int[] iArr, int i3);

    public native void nativeDeleteLine(long j3, long j16, boolean z16);

    public native void nativeDeletePolygon(long j3, int i3, int i16, int[] iArr);

    public native void nativeDestroyEngine(long j3);

    public native boolean nativeDrawFrame(long j3);

    public native void nativeEnableBaseMap(long j3, boolean z16);

    public native void nativeEnableBuilding(long j3, boolean z16);

    public native void nativeEnablePOI(long j3, boolean z16);

    public native int[] nativeFetchLackedTrafficBlocks(long j3);

    public native void nativeFromMapSight(long j3, double[] dArr);

    public native void nativeFromScreenLocation(long j3, byte[] bArr, float f16, float f17, double[] dArr);

    public native float[] nativeGLProjectMatrix();

    public native double[] nativeGLViewMatrix();

    public native float nativeGLViewScaleRatio();

    public native int[] nativeGLViewport();

    public native boolean nativeGenerateTextures(long j3);

    public native String nativeGetActiveIndoorBuildingGUID(long j3);

    public native VectorHeatAggregationUnit nativeGetAggregationUnit(long j3, long j16, LatLng latLng);

    public native boolean nativeGetAndResetDirty(long j3);

    public native String nativeGetBlockRouteInfo(long j3, int i3, int i16);

    public native void nativeGetCenterMapPoint(long j3, GeoPoint geoPoint);

    public native byte[] nativeGetCityName(long j3, GeoPoint geoPoint);

    public native String nativeGetCurIndoorName(long j3, GeoPoint geoPoint);

    public native int nativeGetCurrentMaterialVariant(long j3, long j16);

    public native String nativeGetDataEngineVersion(long j3);

    public native int nativeGetEngineId(long j3);

    public native String nativeGetEngineLogInfo(long j3);

    public native int nativeGetGLModelSkeletonAnimationCount(long j3, long j16);

    public native float[] nativeGetGLModelSkeletonAnimationDuration(long j3, long j16);

    public native String[] nativeGetGLModelSkeletonAnimationName(long j3, long j16);

    public native Rect nativeGetIndoorBound(long j3);

    public native int nativeGetIndoorCurrentFloorId(long j3);

    public native String[] nativeGetIndoorFloorNames(long j3);

    public native int nativeGetLanguage(long j3);

    public native String nativeGetMapEngineVersion(long j3);

    public native int nativeGetMapStyle(long j3);

    public native ArrayList nativeGetPoisInScreen(long j3);

    public native float nativeGetRotate(long j3);

    public native double nativeGetScale(long j3);

    public native int nativeGetScaleLevel(long j3);

    public native float nativeGetSkew(long j3);

    public native double nativeGetTargetScale(long j3, Rect rect, Rect rect2);

    public native boolean nativeGetTrafficCityInfo(long j3, String str, CityTrafficInfo cityTrafficInfo);

    public native String[] nativeGetVariantNames(long j3, long j16);

    public native boolean nativeHasStreetRoad(long j3, String str);

    public native void nativeHideCompass(long j3);

    public native void nativeHideIcons(long j3, int[] iArr, int i3);

    public native void nativeHideStreetRoad(long j3);

    public native void nativeHideTraffic(long j3);

    public native void nativeIndoorBuildingEnabled(long j3, boolean z16);

    public native long nativeInitEngine(String str, String str2, String str3, float f16, int i3, float f17, int[] iArr, boolean z16, int i16);

    public native int nativeIsCityHasTraffic(long j3, String str);

    @Deprecated
    public native boolean nativeIsMapDrawFinished(long j3);

    public native boolean nativeIsTileOverlayEnabled(long j3);

    public native void nativeLandMarkEnabled(long j3, boolean z16);

    public native void nativeLineClearPoint(long j3, long j16, GeoPoint geoPoint, int i3);

    public native void nativeLineInsertPoint(long j3, long j16, GeoPoint geoPoint, int i3);

    public native void nativeLoadBlockRouteCityList(long j3, int[] iArr, int[] iArr2, int i3);

    public native void nativeLockEngine(long j3);

    public native void nativeMapLoadKMLFile(long j3, String str);

    public native void nativeMapResumeRenderMsgQueue(long j3);

    public native void nativeMapSetSatelliteServerFullUrl(long j3, String str);

    public native float nativeMapSightGetOnScreenHeight(long j3);

    public native void nativeMoveBy(long j3, float f16, float f17, boolean z16);

    public native boolean nativeNeedDispaly(long j3);

    public native boolean nativeNeedRedraw(long j3);

    public native byte[] nativeOnTap(long j3, float f16, float f17);

    public native boolean nativeOnTapLine(long j3, float f16, float f17);

    public native int nativeQueryCityCodeList(long j3, Rect rect, int i3, int[] iArr, int i16);

    public native int nativeRefreshTrafficData(long j3, byte[] bArr, int i3, boolean z16, boolean z17);

    public native void nativeReloadTileOverlay(long j3, int i3);

    public native void nativeRemoveEngineOverlay(long j3);

    public native void nativeRemoveGLVisualizationOverlay(long j3, long j16);

    public native void nativeRemoveMaskLayer(long j3, int i3);

    public native void nativeRemoveTileOverlay(long j3, int i3);

    public native void nativeResetEnginePath(long j3, String str, String str2, String str3);

    public native void nativeResetIndoorCellInfo(long j3);

    public native void nativeResetMonoColor(long j3, long j16);

    public native void nativeScheduleClickOnNextRender(long j3, float f16, float f17);

    public native void nativeSetAmbientLight(long j3, float f16, float f17, float f18, float f19);

    public native void nativeSetBlockRouteVisible(long j3, boolean z16);

    public native void nativeSetBuilding3DEffect(long j3, boolean z16);

    public native void nativeSetBuildingBlackList(long j3, LatLngBounds[] latLngBoundsArr);

    public native void nativeSetBuildingToSpecificFloor(long j3, String str, String str2);

    public native void nativeSetCallback(long j3);

    public native void nativeSetCenter(long j3, GeoPoint geoPoint, boolean z16);

    public native void nativeSetCenterMapPointAndScaleLevel(long j3, GeoPoint geoPoint, int i3, boolean z16);

    public native void nativeSetCompassImage(long j3, String str);

    public native void nativeSetCompassPosition(long j3, int i3, int i16);

    public native void nativeSetCompassVisible(long j3, boolean z16);

    public native void nativeSetDrawCap(long j3, long j16, boolean z16);

    public native void nativeSetFlagOfZoomToSpanForLocation(long j3, float f16, float f17, float f18, float f19);

    public native void nativeSetIconsHidden(long j3, int[] iArr, int i3, boolean z16);

    public native void nativeSetIndoorActiveScreenArea(long j3, float f16, float f17, float f18, float f19);

    public native void nativeSetIndoorBuildingPickEnabled(long j3, boolean z16);

    public native void nativeSetIndoorBuildingStyle(long j3, int i3);

    public native void nativeSetIndoorCellInfo(long j3, IndoorCellInfo[] indoorCellInfoArr);

    public native void nativeSetIndoorConfigType(long j3, int i3);

    public native void nativeSetIndoorFloor(long j3, int i3);

    public native void nativeSetIndoorMaskColor(long j3, int i3);

    public native void nativeSetLanguage(long j3, int i3);

    public native void nativeSetLineArrowSpacing(long j3, int i3, float f16);

    public native void nativeSetLineDirectionArrowTextureName(long j3, long j16, String str);

    public native void nativeSetLineDrawArrow(long j3, long j16, boolean z16);

    public native void nativeSetLineFootPrintSpacing(long j3, int i3, float f16);

    public native void nativeSetLineSelected(long j3, long j16, boolean z16);

    public native void nativeSetLocationCircleColor(long j3, int i3);

    public native void nativeSetLocationCircleHidden(long j3, boolean z16);

    public native void nativeSetLocationCompassGroupImages(long j3, String str, String str2, String str3, String str4, String str5);

    public native void nativeSetLocationCompassMarkerHidden(long j3, boolean z16);

    public native void nativeSetLocationCompassMarkerImage(long j3, String str);

    public native void nativeSetLocationFollow(long j3, boolean z16, boolean z17, boolean z18, boolean z19);

    public native void nativeSetLocationHeading(long j3, float f16);

    public native void nativeSetLocationInfo(long j3, double d16, double d17, float f16, float f17, boolean z16);

    public native void nativeSetLocationMarkerHidden(long j3, boolean z16);

    public native int nativeSetLocationMarkerImage(long j3, String str, float f16, float f17);

    public native void nativeSetLocationRedLineHidden(long j3, boolean z16);

    public native void nativeSetLocationRedLineInfo(long j3, float f16, int i3, LatLng latLng);

    public native void nativeSetMapFontSize(long j3, int i3);

    public native void nativeSetMapParam(long j3, byte[] bArr);

    public native void nativeSetMapStyle(long j3, int i3, boolean z16);

    public native void nativeSetMarkerMainSubRelation(long j3, int i3, int i16, boolean z16);

    public native void nativeSetMarkerScaleLevelRange(long j3, int i3, int i16, int i17);

    public native void nativeSetMarsXLogLevel(int i3, boolean z16, boolean z17);

    public native void nativeSetMaterialVariant(long j3, long j16, int i3);

    public native void nativeSetMaxScaleLevel(long j3, int i3);

    public native void nativeSetMinScaleLevel(long j3, int i3);

    public native void nativeSetMonoColor(long j3, long j16, float f16, float f17, float f18);

    public native void nativeSetNeedDisplay(long j3, boolean z16);

    public native void nativeSetPriority(long j3, int i3, float f16);

    public native void nativeSetRotate(long j3, float f16, boolean z16);

    public native void nativeSetSatelliteEnabled(long j3, boolean z16);

    public native void nativeSetScale(long j3, double d16, boolean z16);

    public native void nativeSetScaleLevel(long j3, int i3, boolean z16);

    public native void nativeSetScreenCenterOffset(long j3, float f16, float f17, boolean z16);

    public native void nativeSetServerHost(long j3, String str);

    public native void nativeSetShowIndoorBuildingWhiteList(long j3, String[] strArr);

    public native void nativeSetSkew(long j3, float f16, boolean z16);

    public native void nativeSetSkyBoxTexture(long j3, String str);

    public native void nativeSetSpotOrDirectionalLight(long j3, int i3, float f16, float f17, float f18, float f19, float f26, float f27, float f28);

    public native void nativeSetTileOverlayDataLevelRange(long j3, int i3, int i16, int i17);

    public native void nativeSetTileOverlayEnabled(long j3, boolean z16);

    public native void nativeSetTileOverlayPriority(long j3, int i3, int i16);

    public native void nativeSetTrafficColor(long j3, int i3, int i16, int i17, int i18);

    public native void nativeSetTrafficMode(long j3, int i3, int i16);

    public native void nativeSetTrafficStyle(long j3, TrafficStyle trafficStyle);

    public native void nativeSetTurnArrow(long j3, long j16, GeoPoint[] geoPointArr, int i3, int i16);

    public native void nativeSetTurnArrowStyle(long j3, long j16, int i3, int i16);

    public native void nativeSetViewport(long j3, int i3, int i16, int i17, int i18);

    public native void nativeShowStreetRoad(long j3);

    public native void nativeShowTraffic(long j3);

    public native void nativeStartGLModelSkeletonAnimation(long j3, long j16, int i3, float f16, boolean z16);

    public native void nativeStopGLModelSkeletonAnimation(long j3, long j16);

    public native void nativeSwitchEngineForeGround(long j3, boolean z16);

    public native void nativeToScreenLocation(long j3, byte[] bArr, double d16, double d17, float[] fArr);

    public native void nativeUnlockEngine(long j3);

    public native void nativeUpdateAggregationOverlay(long j3, long j16, AggregationOverlayInfo aggregationOverlayInfo);

    public native void nativeUpdateArcLineOverlay(long j3, long j16, ArcLineOverlayInfo arcLineOverlayInfo);

    public native void nativeUpdateCircle(long j3, int i3, CircleInfo circleInfo);

    public native void nativeUpdateFrame(long j3, double d16);

    public native void nativeUpdateGLModel(long j3, long j16, GLModelInfo gLModelInfo);

    public native void nativeUpdateGroundOverlay(long j3, long j16, GroundOverlayInfo groundOverlayInfo);

    public native void nativeUpdateHeatmapOverlay(long j3, long j16, HeatmapInfo heatmapInfo);

    public native void nativeUpdateIntersectionOverlay(long j3, IntersectionOverlayInfo intersectionOverlayInfo);

    public native void nativeUpdateMapResource(long j3, String str);

    public native void nativeUpdateMarker(long j3, MarkerInfo markerInfo);

    public native void nativeUpdateMarkerInfo(long j3, int i3, String str, double d16, double d17, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i16, int i17, boolean z27);

    public native void nativeUpdateMaskLayer(long j3, int i3, int i16);

    public native void nativeUpdatePolygon(long j3, int i3, int i16, PolygonInfo polygonInfo);

    public native void nativeUpdateScatterPlotOverlay(long j3, long j16, ScatterPlotInfo scatterPlotInfo);

    public native void nativeUpdateTrailOverlay(long j3, long j16, TrailOverlayInfo trailOverlayInfo);

    public native EngineWriteDataModel nativeWriteMapDataBlock(long j3, String str, byte[] bArr);

    public native void nativeZoomIn(long j3, float f16, float f17);

    public native void nativeZoomOut(long j3);

    public native void nativeZoomToSpan(long j3, Rect rect, Rect rect2, boolean z16);

    public native void nativeZoomToSpanForNavigation(long j3, GeoPoint geoPoint, int i3, int i16, boolean z16);

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public boolean onJniCallbackRenderMapFrame(int i3) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            return jNIInterfaceCallback.onJniCallbackRenderMapFrame(i3);
        }
        return false;
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChangeStopped() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapCameraChangeStopped();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapCameraChanged() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapCameraChanged();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMapLoaded() {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMapLoaded();
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onMarkerCollisionCallback(int[] iArr, int[] iArr2) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onMarkerCollisionCallback(iArr, iArr2);
        }
    }

    @Override // com.tencent.map.lib.JNIInterfaceCallback
    public void onVisualLayerClickResult(float f16, float f17, long j3, String str, String str2) {
        JNIInterfaceCallback jNIInterfaceCallback = this.mCallback;
        if (jNIInterfaceCallback != null) {
            jNIInterfaceCallback.onVisualLayerClickResult(f16, f17, j3, str, str2);
        }
    }

    public native void removeLineText(long j3, int i3);

    public native void setLineTextStyle(long j3, int i3, PolylineOptions.Text text);

    public native void setRestrictBounds(long j3, double[] dArr, double[] dArr2, int i3);
}
