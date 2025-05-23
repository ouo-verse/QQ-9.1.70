package com.tencent.mapsdk.engine.jni;

import android.graphics.Rect;
import android.support.annotation.Keep;
import com.tencent.map.lib.JNIInterface;
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
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.bs;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.oo;
import com.tencent.mapsdk.internal.os;
import com.tencent.mapsdk.internal.ot;
import com.tencent.mapsdk.internal.ox;
import com.tencent.mapsdk.internal.oy;
import com.tencent.mapsdk.internal.oz;
import com.tencent.mapsdk.internal.pa;
import com.tencent.mapsdk.internal.pb;
import com.tencent.mapsdk.internal.pc;
import com.tencent.mapsdk.internal.pd;
import com.tencent.mapsdk.internal.pe;
import com.tencent.mapsdk.internal.w;
import com.tencent.mapsdk.shell.events.EngineWriteDataModel;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LightColor;
import com.tencent.tencentmap.mapsdk.maps.model.LightDirection;
import com.tencent.tencentmap.mapsdk.maps.model.LightType;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficStyle;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class JNI {
    private JNICallback mCallback;
    private JNIInterface mJNIInterface;

    public static synchronized void nativeEndProfile() {
        synchronized (JNI.class) {
            JNIInterface.nativeEndProfile();
        }
    }

    public static synchronized void nativeStartProfile() {
        synchronized (JNI.class) {
            JNIInterface.nativeStartProfile();
        }
    }

    public int addLineText(long j3, GeoPoint[] geoPointArr, PolylineOptions.Text text) {
        return this.mJNIInterface.addLineText(j3, geoPointArr, text);
    }

    public boolean checkMapLoadFinishedTask(long j3, int i3) {
        return this.mJNIInterface.checkMapLoadFinishedTask(j3, i3);
    }

    public void destory() {
        this.mCallback.destory();
        this.mCallback = null;
        this.mJNIInterface = null;
    }

    public VectorHeatAggregationUnit getAggregationUnit(long j3, long j16, LatLng latLng) {
        return this.mJNIInterface.nativeGetAggregationUnit(j3, j16, latLng);
    }

    public int getIndoorOutlineZoom(long j3, String str) {
        return this.mJNIInterface.getIndoorOutlineZoom(j3, str);
    }

    public String getMapEngineRenderStatus(long j3) {
        return this.mJNIInterface.getMapEngineRenderStatus(j3);
    }

    public void initCallback(oo ooVar, w wVar, ot otVar, os osVar, pb pbVar, ox oxVar, pa paVar, bs bsVar, pd pdVar, oz ozVar, pe peVar, pc pcVar) {
        JNICallback jNICallback = new JNICallback(ooVar, wVar, otVar, osVar, pbVar, oxVar, paVar, bsVar, pdVar, ozVar, peVar, pcVar);
        this.mCallback = jNICallback;
        this.mJNIInterface = new JNIInterface(jNICallback);
    }

    public long nativeAddAggregatioinOverlay(long j3, AggregationOverlayInfo aggregationOverlayInfo) {
        return this.mJNIInterface.nativeAddAggregationOverlay(j3, aggregationOverlayInfo);
    }

    public long nativeAddArcLineOverlay(long j3, ArcLineOverlayInfo arcLineOverlayInfo) {
        return this.mJNIInterface.nativeAddArcLineOverlay(j3, arcLineOverlayInfo);
    }

    public int nativeAddCircle(long j3, CircleInfo circleInfo) {
        return this.mJNIInterface.nativeAddCircle(j3, circleInfo);
    }

    public long nativeAddGLModel(long j3, GLModelInfo gLModelInfo) {
        return this.mJNIInterface.nativeAddGLModel(j3, gLModelInfo);
    }

    public long nativeAddGroundOverlay(long j3, GroundOverlayInfo groundOverlayInfo) {
        return this.mJNIInterface.nativeAddGroundOverlay(j3, groundOverlayInfo);
    }

    public long nativeAddHeatmapOverlay(long j3, HeatmapInfo heatmapInfo) {
        return this.mJNIInterface.nativeAddHeatmapOverlay(j3, heatmapInfo);
    }

    public long nativeAddIntersectionOverlay(long j3, IntersectionOverlayInfo intersectionOverlayInfo) {
        return this.mJNIInterface.nativeAddIntersectionOverlay(j3, intersectionOverlayInfo);
    }

    public int nativeAddMarker(long j3, String str, String str2, double d16, double d17, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i3, int i16) {
        return this.mJNIInterface.nativeAddMarker(j3, str, str2, d16, d17, f16, f17, f18, f19, f26, f27, z16, z17, z18, z19, z26, i3, i16);
    }

    public long nativeAddMarker2(long j3, MarkerInfo markerInfo) {
        return this.mJNIInterface.nativeAddMarker2(j3, markerInfo);
    }

    public int nativeAddMaskLayer(long j3, MaskLayer maskLayer) {
        return this.mJNIInterface.nativeAddMaskLayer(j3, maskLayer);
    }

    public int nativeAddPolygon(long j3, PolygonInfo polygonInfo) {
        return this.mJNIInterface.nativeAddPolygon(j3, polygonInfo);
    }

    public void nativeAddRouteNameSegments(long j3, byte[][] bArr, int i3, GeoPoint[] geoPointArr, int i16) {
        this.mJNIInterface.nativeAddRouteNameSegments(j3, bArr, i3, geoPointArr, i16);
    }

    public long nativeAddScatterOverlay(long j3, ScatterPlotInfo scatterPlotInfo) {
        return this.mJNIInterface.nativeAddScatterPlotOverlay(j3, scatterPlotInfo);
    }

    public int nativeAddTileOverlay(long j3, TileOverlayCallback tileOverlayCallback, boolean z16, boolean z17) {
        return this.mJNIInterface.nativeAddTileOverlay(j3, tileOverlayCallback, z16, z17);
    }

    public long nativeAddTrailOverlay(long j3, TrailOverlayInfo trailOverlayInfo) {
        return this.mJNIInterface.nativeAddTrailOverlay(j3, trailOverlayInfo);
    }

    public void nativeBringElementAbove(long j3, int i3, int i16) {
        this.mJNIInterface.nativeBringElementAbove(j3, i3, i16);
    }

    public void nativeBringElementBelow(long j3, int i3, int i16) {
        this.mJNIInterface.nativeBringElementBelow(j3, i3, i16);
    }

    public void nativeCheckTrafficBlockCache(long j3, int i3, int i16, int i17, int i18, int i19) {
        this.mJNIInterface.nativeCheckTrafficBlockCache(j3, i3, i16, i17, i18, i19);
    }

    public void nativeCheckTrafficBlockCacheForReplay(long j3, int i3, int i16, int i17, int i18, int i19) {
        this.mJNIInterface.nativeCheckTrafficBlockCacheForReplay(j3, i3, i16, i17, i18, i19);
    }

    public int nativeClearCache(long j3) {
        return this.mJNIInterface.nativeClearCache(j3);
    }

    public void nativeClearDownloadURLCache(long j3) {
        this.mJNIInterface.nativeClearDownloadURLCache(j3);
    }

    public void nativeClearRouteNameSegments(long j3) {
        this.mJNIInterface.nativeClearRouteNameSegments(j3);
    }

    public AnnocationTextResult nativeCreateAnnotationTextBitmap(long j3, AnnocationText annocationText) {
        return this.mJNIInterface.nativeCreateAnnotationText(j3, annocationText);
    }

    public int nativeCreateOrUpdateLine(long j3, int i3, int[] iArr, int[] iArr2, GeoPoint[] geoPointArr, String str, float f16, int i16, boolean z16, boolean z17, boolean z18, boolean z19, float f17, boolean z26, int[] iArr3, int[] iArr4, float f18, int[] iArr5, float f19, int i17, boolean z27) {
        LogUtil.b(ky.f149101g, "create or update line = " + i3 + " p:" + geoPointArr.length + " w:" + f16 + " v:" + z27 + " a:" + f19 + " bw:" + f18);
        return this.mJNIInterface.nativeCreateOrUpdateLine(j3, i3, iArr, iArr2, geoPointArr, str, f16, i16, z16, z17, z18, z19, (int) f17, z26, iArr3, iArr4, f18, iArr5, f19, i17, z27);
    }

    public void nativeDeleteCircle(long j3, int i3) {
        this.mJNIInterface.nativeDeleteCircle(j3, i3);
    }

    public void nativeDeleteIcons(long j3, int[] iArr, int i3) {
        this.mJNIInterface.nativeDeleteIcons(j3, iArr, i3);
    }

    public void nativeDeleteLine(long j3, long j16, boolean z16) {
        this.mJNIInterface.nativeDeleteLine(j3, j16, z16);
    }

    public void nativeDeletePolygon(long j3, int i3, int i16, int[] iArr) {
        this.mJNIInterface.nativeDeletePolygon(j3, i3, i16, iArr);
    }

    public void nativeDestroyEngine(long j3) {
        this.mJNIInterface.nativeDestroyEngine(j3);
    }

    public boolean nativeDrawFrame(long j3) {
        return this.mJNIInterface.nativeDrawFrame(j3);
    }

    public void nativeEnableBaseMap(long j3, boolean z16) {
        this.mJNIInterface.nativeEnableBaseMap(j3, z16);
    }

    public void nativeEnableBuilding(long j3, boolean z16) {
        this.mJNIInterface.nativeEnableBuilding(j3, z16);
    }

    public void nativeEnablePOI(long j3, boolean z16) {
        this.mJNIInterface.nativeEnablePOI(j3, z16);
    }

    public int[] nativeFetchLackedTrafficBlocks(long j3) {
        return this.mJNIInterface.nativeFetchLackedTrafficBlocks(j3);
    }

    public void nativeFromMapSight(long j3, double[] dArr) {
        this.mJNIInterface.nativeFromMapSight(j3, dArr);
    }

    public void nativeFromScreenLocation(long j3, byte[] bArr, float f16, float f17, double[] dArr) {
        this.mJNIInterface.nativeFromScreenLocation(j3, bArr, f16, f17, dArr);
    }

    public float[] nativeGLProjectMatrix() {
        return this.mJNIInterface.nativeGLProjectMatrix();
    }

    public double[] nativeGLViewMatrix() {
        return this.mJNIInterface.nativeGLViewMatrix();
    }

    public float nativeGLViewScaleRatio() {
        return this.mJNIInterface.nativeGLViewScaleRatio();
    }

    public int[] nativeGLViewport() {
        return this.mJNIInterface.nativeGLViewport();
    }

    public boolean nativeGenerateTextures(long j3) {
        return this.mJNIInterface.nativeGenerateTextures(j3);
    }

    public String nativeGetActiveIndoorBuildingGUID(long j3) {
        return this.mJNIInterface.nativeGetActiveIndoorBuildingGUID(j3);
    }

    public boolean nativeGetAndResetDirty(long j3) {
        return this.mJNIInterface.nativeGetAndResetDirty(j3);
    }

    public String nativeGetBlockRouteInfo(long j3, int i3, int i16) {
        return this.mJNIInterface.nativeGetBlockRouteInfo(j3, i3, i16);
    }

    public void nativeGetCenterMapPoint(long j3, GeoPoint geoPoint) {
        this.mJNIInterface.nativeGetCenterMapPoint(j3, geoPoint);
    }

    public byte[] nativeGetCityName(long j3, GeoPoint geoPoint) {
        return this.mJNIInterface.nativeGetCityName(j3, geoPoint);
    }

    public String nativeGetCurIndoorName(long j3, GeoPoint geoPoint) {
        return this.mJNIInterface.nativeGetCurIndoorName(j3, geoPoint);
    }

    public int nativeGetCurrentMaterialVariant(long j3, long j16) {
        return this.mJNIInterface.nativeGetCurrentMaterialVariant(j3, j16);
    }

    public String nativeGetDataEngineVersion(long j3) {
        return this.mJNIInterface.nativeGetDataEngineVersion(j3);
    }

    public int nativeGetEngineId(long j3) {
        return this.mJNIInterface.nativeGetEngineId(j3);
    }

    public String nativeGetEngineLogInfo(long j3) {
        return this.mJNIInterface.nativeGetEngineLogInfo(j3);
    }

    public int nativeGetGLModelSkeletonAnimationCount(long j3, long j16) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationCount(j3, j16);
    }

    public float[] nativeGetGLModelSkeletonAnimationDuration(long j3, long j16) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationDuration(j3, j16);
    }

    public String[] nativeGetGLModelSkeletonAnimationName(long j3, long j16) {
        return this.mJNIInterface.nativeGetGLModelSkeletonAnimationName(j3, j16);
    }

    public Rect nativeGetIndoorBound(long j3) {
        return this.mJNIInterface.nativeGetIndoorBound(j3);
    }

    public int nativeGetIndoorCurrentFloorId(long j3) {
        return this.mJNIInterface.nativeGetIndoorCurrentFloorId(j3);
    }

    public String[] nativeGetIndoorFloorNames(long j3) {
        return this.mJNIInterface.nativeGetIndoorFloorNames(j3);
    }

    public int nativeGetLanguage(long j3) {
        return this.mJNIInterface.nativeGetLanguage(j3);
    }

    public String nativeGetMapEngineVersion(long j3) {
        return this.mJNIInterface.nativeGetDataEngineVersion(j3);
    }

    public int nativeGetMapStyle(long j3) {
        return this.mJNIInterface.nativeGetMapStyle(j3);
    }

    public ArrayList nativeGetPoisInScreen(long j3) {
        return this.mJNIInterface.nativeGetPoisInScreen(j3);
    }

    public float nativeGetRotate(long j3) {
        return this.mJNIInterface.nativeGetRotate(j3);
    }

    public double nativeGetScale(long j3) {
        return this.mJNIInterface.nativeGetScale(j3);
    }

    public int nativeGetScaleLevel(long j3) {
        return this.mJNIInterface.nativeGetScaleLevel(j3);
    }

    public float nativeGetSkew(long j3) {
        return this.mJNIInterface.nativeGetSkew(j3);
    }

    public double nativeGetTargetScale(long j3, Rect rect, Rect rect2) {
        return this.mJNIInterface.nativeGetTargetScale(j3, rect, rect2);
    }

    public boolean nativeGetTrafficCityInfo(long j3, String str, CityTrafficInfo cityTrafficInfo) {
        return this.mJNIInterface.nativeGetTrafficCityInfo(j3, str, cityTrafficInfo);
    }

    public String[] nativeGetVariantNames(long j3, long j16) {
        return this.mJNIInterface.nativeGetVariantNames(j3, j16);
    }

    public boolean nativeHasStreetRoad(long j3, String str) {
        return this.mJNIInterface.nativeHasStreetRoad(j3, str);
    }

    public void nativeHideCompass(long j3) {
        this.mJNIInterface.nativeHideCompass(j3);
    }

    public void nativeHideIcons(long j3, int[] iArr, int i3) {
        this.mJNIInterface.nativeHideIcons(j3, iArr, i3);
    }

    public void nativeHideStreetRoad(long j3) {
        this.mJNIInterface.nativeHideStreetRoad(j3);
    }

    public void nativeHideTraffic(long j3) {
        this.mJNIInterface.nativeHideTraffic(j3);
    }

    public void nativeIndoorBuildingEnabled(long j3, boolean z16) {
        this.mJNIInterface.nativeIndoorBuildingEnabled(j3, z16);
    }

    public long nativeInitEngine(String str, String str2, String str3, float f16, int i3, float f17, int[] iArr, boolean z16, int i16) {
        return this.mJNIInterface.nativeInitEngine(str, str2, str3, f16, i3, f17, iArr, z16, i16);
    }

    public int nativeIsCityHasTraffic(long j3, String str) {
        return this.mJNIInterface.nativeIsCityHasTraffic(j3, str);
    }

    @Deprecated
    public boolean nativeIsMapDrawFinished(long j3) {
        return this.mJNIInterface.nativeIsMapDrawFinished(j3);
    }

    public boolean nativeIsTileOverlayEnabled(long j3) {
        return this.mJNIInterface.nativeIsTileOverlayEnabled(j3);
    }

    public void nativeLandMarkEnabled(long j3, boolean z16) {
        this.mJNIInterface.nativeLandMarkEnabled(j3, z16);
    }

    public void nativeLineClearPoint(long j3, long j16, GeoPoint geoPoint, int i3) {
        this.mJNIInterface.nativeLineClearPoint(j3, j16, geoPoint, i3);
    }

    public void nativeLineInsertPoint(long j3, long j16, GeoPoint geoPoint, int i3) {
        this.mJNIInterface.nativeLineInsertPoint(j3, j16, geoPoint, i3);
    }

    public void nativeLoadBlockRouteCityList(long j3, int[] iArr, int[] iArr2, int i3) {
        this.mJNIInterface.nativeLoadBlockRouteCityList(j3, iArr, iArr2, i3);
    }

    public void nativeLockEngine(long j3) {
        this.mJNIInterface.nativeLockEngine(j3);
    }

    public void nativeMapLoadKMLFile(long j3, String str) {
        this.mJNIInterface.nativeMapLoadKMLFile(j3, str);
    }

    public void nativeMapSetSatelliteServerFullUrl(long j3, String str) {
        this.mJNIInterface.nativeMapSetSatelliteServerFullUrl(j3, str);
    }

    public float nativeMapSightGetOnScreenHeight(long j3) {
        return this.mJNIInterface.nativeMapSightGetOnScreenHeight(j3);
    }

    public void nativeMoveBy(long j3, float f16, float f17, boolean z16) {
        this.mJNIInterface.nativeMoveBy(j3, f16, f17, z16);
    }

    public boolean nativeNeedDispaly(long j3) {
        return this.mJNIInterface.nativeNeedDispaly(j3);
    }

    public boolean nativeNeedRedraw(long j3) {
        return this.mJNIInterface.nativeNeedRedraw(j3);
    }

    public byte[] nativeOnTap(long j3, float f16, float f17) {
        return this.mJNIInterface.nativeOnTap(j3, f16, f17);
    }

    public boolean nativeOnTapLine(long j3, float f16, float f17) {
        return this.mJNIInterface.nativeOnTapLine(j3, f16, f17);
    }

    public int nativeQueryCityCodeList(long j3, Rect rect, int i3, int[] iArr, int i16) {
        return this.mJNIInterface.nativeQueryCityCodeList(j3, rect, i3, iArr, i16);
    }

    public int nativeRefreshTrafficData(long j3, byte[] bArr, int i3, boolean z16, boolean z17) {
        return this.mJNIInterface.nativeRefreshTrafficData(j3, bArr, i3, z16, z17);
    }

    public void nativeReloadTileOverlay(long j3, int i3) {
        this.mJNIInterface.nativeReloadTileOverlay(j3, i3);
    }

    public void nativeRemoveEngineOverlay(long j3) {
        this.mJNIInterface.nativeRemoveEngineOverlay(j3);
    }

    public void nativeRemoveGLVisualizationOverlay(long j3, long j16) {
        this.mJNIInterface.nativeRemoveGLVisualizationOverlay(j3, j16);
    }

    public void nativeRemoveMaskLayer(long j3, int i3) {
        this.mJNIInterface.nativeRemoveMaskLayer(j3, i3);
    }

    public void nativeRemovePolygon(long j3, int i3, int i16, int[] iArr) {
        this.mJNIInterface.nativeDeletePolygon(j3, i3, i16, iArr);
    }

    public void nativeRemoveTileOverlay(long j3, int i3) {
        this.mJNIInterface.nativeRemoveTileOverlay(j3, i3);
    }

    public void nativeResetEnginePath(long j3, String str, String str2, String str3) {
        this.mJNIInterface.nativeResetEnginePath(j3, str, str2, str3);
    }

    public void nativeResetIndoorCellInfo(long j3) {
        this.mJNIInterface.nativeResetIndoorCellInfo(j3);
    }

    public void nativeResetMonoColor(long j3, long j16) {
        this.mJNIInterface.nativeResetMonoColor(j3, j16);
    }

    public void nativeResumeRenderMsgQueue(long j3) {
        this.mJNIInterface.nativeMapResumeRenderMsgQueue(j3);
    }

    public void nativeSetAmbientLight(long j3, LightColor lightColor, float f16) {
        this.mJNIInterface.nativeSetAmbientLight(j3, lightColor.getR(), lightColor.getG(), lightColor.getB(), f16);
    }

    public void nativeSetBlockRouteVisible(long j3, boolean z16) {
        this.mJNIInterface.nativeSetBlockRouteVisible(j3, z16);
    }

    public void nativeSetBuilding3DEffect(long j3, boolean z16) {
        this.mJNIInterface.nativeSetBuilding3DEffect(j3, z16);
    }

    public void nativeSetBuildingBlackList(long j3, LatLngBounds[] latLngBoundsArr) {
        this.mJNIInterface.nativeSetBuildingBlackList(j3, latLngBoundsArr);
    }

    public void nativeSetBuildingToSpecificFloor(long j3, String str, String str2) {
        this.mJNIInterface.nativeSetBuildingToSpecificFloor(j3, str, str2);
    }

    public void nativeSetCallback(long j3) {
        this.mJNIInterface.nativeSetCallback(j3);
    }

    public void nativeSetCenter(long j3, GeoPoint geoPoint, boolean z16) {
        this.mJNIInterface.nativeSetCenter(j3, geoPoint, z16);
    }

    public void nativeSetCenterMapPointAndScaleLevel(long j3, GeoPoint geoPoint, int i3, boolean z16) {
        this.mJNIInterface.nativeSetCenterMapPointAndScaleLevel(j3, geoPoint, i3, z16);
    }

    public void nativeSetCompassImage(long j3, String str) {
        this.mJNIInterface.nativeSetCompassImage(j3, str);
    }

    public void nativeSetCompassPosition(long j3, int i3, int i16) {
        this.mJNIInterface.nativeSetCompassPosition(j3, i3, i16);
    }

    public void nativeSetCompassVisible(long j3, boolean z16) {
        this.mJNIInterface.nativeSetCompassVisible(j3, z16);
    }

    public void nativeSetDrawCap(long j3, long j16, boolean z16) {
        this.mJNIInterface.nativeSetDrawCap(j3, j16, z16);
    }

    public void nativeSetFlagOfZoomToSpanForLocation(long j3, float f16, float f17, float f18, float f19) {
        this.mJNIInterface.nativeSetFlagOfZoomToSpanForLocation(j3, f16, f17, f18, f19);
    }

    public void nativeSetIconsHidden(long j3, int[] iArr, int i3, boolean z16) {
        this.mJNIInterface.nativeSetIconsHidden(j3, iArr, i3, z16);
    }

    public void nativeSetIndoorActiveScreenArea(long j3, float f16, float f17, float f18, float f19) {
        this.mJNIInterface.nativeSetIndoorActiveScreenArea(j3, f16, f17, f18, f19);
    }

    public void nativeSetIndoorBuildingPickEnabled(long j3, boolean z16) {
        this.mJNIInterface.nativeSetIndoorBuildingPickEnabled(j3, z16);
    }

    public void nativeSetIndoorBuildingStyle(long j3, int i3) {
        LogUtil.b(ky.f149101g, "nativeSetIndoorBuildingStyle:".concat(String.valueOf(i3)));
        this.mJNIInterface.nativeSetIndoorBuildingStyle(j3, i3);
    }

    public void nativeSetIndoorCellInfo(long j3, List<IndoorCellInfo> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (IndoorCellInfo indoorCellInfo : list) {
                if (indoorCellInfo != null && indoorCellInfo.getStyle() != null) {
                    arrayList.add(indoorCellInfo);
                }
            }
            this.mJNIInterface.nativeSetIndoorCellInfo(j3, (IndoorCellInfo[]) arrayList.toArray(new IndoorCellInfo[0]));
        }
    }

    public void nativeSetIndoorConfigType(long j3, int i3) {
        this.mJNIInterface.nativeSetIndoorConfigType(j3, i3);
    }

    public void nativeSetIndoorFloor(long j3, int i3) {
        this.mJNIInterface.nativeSetIndoorFloor(j3, i3);
    }

    public void nativeSetIndoorMaskColor(long j3, int i3) {
        this.mJNIInterface.nativeSetIndoorMaskColor(j3, i3);
    }

    public void nativeSetLanguage(long j3, int i3) {
        this.mJNIInterface.nativeSetLanguage(j3, i3);
    }

    public void nativeSetLineArrowSpacing(long j3, int i3, float f16) {
        this.mJNIInterface.nativeSetLineArrowSpacing(j3, i3, f16);
    }

    public void nativeSetLineDirectionArrowTextureName(long j3, long j16, String str) {
        this.mJNIInterface.nativeSetLineDirectionArrowTextureName(j3, j16, str);
    }

    public void nativeSetLineDrawArrow(long j3, long j16, boolean z16) {
        this.mJNIInterface.nativeSetLineDrawArrow(j3, j16, z16);
    }

    public void nativeSetLineFootPrintSpacing(long j3, int i3, float f16) {
        this.mJNIInterface.nativeSetLineFootPrintSpacing(j3, i3, f16);
    }

    public void nativeSetLineSelected(long j3, long j16, boolean z16) {
        this.mJNIInterface.nativeSetLineSelected(j3, j16, z16);
    }

    public void nativeSetLocationCircleColor(long j3, int i3) {
        this.mJNIInterface.nativeSetLocationCircleColor(j3, i3);
    }

    public void nativeSetLocationCircleHidden(long j3, boolean z16) {
        this.mJNIInterface.nativeSetLocationCircleHidden(j3, z16);
    }

    public void nativeSetLocationCompassGroupImages(long j3, String str, String str2, String str3, String str4, String str5) {
        this.mJNIInterface.nativeSetLocationCompassGroupImages(j3, str, str2, str3, str4, str5);
    }

    public void nativeSetLocationCompassMarkerHidden(long j3, boolean z16) {
        this.mJNIInterface.nativeSetLocationCompassMarkerHidden(j3, z16);
    }

    public void nativeSetLocationCompassMarkerImage(long j3, String str) {
        this.mJNIInterface.nativeSetLocationCompassMarkerImage(j3, str);
    }

    public void nativeSetLocationFollow(long j3, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.mJNIInterface.nativeSetLocationFollow(j3, z16, z17, z18, z19);
    }

    public void nativeSetLocationHeading(long j3, float f16) {
        this.mJNIInterface.nativeSetLocationHeading(j3, f16);
    }

    public void nativeSetLocationInfo(long j3, double d16, double d17, float f16, float f17, boolean z16) {
        this.mJNIInterface.nativeSetLocationInfo(j3, d16, d17, f16, f17, z16);
    }

    public void nativeSetLocationMarkerHidden(long j3, boolean z16) {
        this.mJNIInterface.nativeSetLocationMarkerHidden(j3, z16);
    }

    public int nativeSetLocationMarkerImage(long j3, String str, float f16, float f17) {
        return this.mJNIInterface.nativeSetLocationMarkerImage(j3, str, f16, f17);
    }

    public void nativeSetLocationRedLineHidden(long j3, boolean z16) {
        this.mJNIInterface.nativeSetLocationRedLineHidden(j3, z16);
    }

    public void nativeSetLocationRedLineInfo(long j3, float f16, int i3, LatLng latLng) {
        this.mJNIInterface.nativeSetLocationRedLineInfo(j3, f16, i3, latLng);
    }

    public void nativeSetMapFontSize(long j3, int i3) {
        this.mJNIInterface.nativeSetMapFontSize(j3, i3);
    }

    public void nativeSetMapParam(long j3, byte[] bArr) {
        this.mJNIInterface.nativeSetMapParam(j3, bArr);
    }

    public void nativeSetMapStyle(long j3, int i3, boolean z16) {
        this.mJNIInterface.nativeSetMapStyle(j3, i3, z16);
    }

    public void nativeSetMarkerMainSubRelation(long j3, int i3, int i16, boolean z16) {
        this.mJNIInterface.nativeSetMarkerMainSubRelation(j3, i3, i16, z16);
    }

    public void nativeSetMarkerScaleLevelRange(long j3, int i3, int i16, int i17) {
        this.mJNIInterface.nativeSetMarkerScaleLevelRange(j3, i3, i16, i17);
    }

    public void nativeSetMaterialVariant(long j3, long j16, int i3) {
        this.mJNIInterface.nativeSetMaterialVariant(j3, j16, i3);
    }

    public void nativeSetMaxScaleLevel(long j3, int i3) {
        this.mJNIInterface.nativeSetMaxScaleLevel(j3, i3);
    }

    public void nativeSetMinScaleLevel(long j3, int i3) {
        this.mJNIInterface.nativeSetMinScaleLevel(j3, i3);
    }

    public void nativeSetMonoColor(long j3, long j16, float f16, float f17, float f18) {
        this.mJNIInterface.nativeSetMonoColor(j3, j16, f16, f17, f18);
    }

    public void nativeSetNeedDisplay(long j3, boolean z16) {
        this.mJNIInterface.nativeSetNeedDisplay(j3, z16);
    }

    public void nativeSetPolygonHidden(long j3, int i3, int i16, boolean z16, int[] iArr) {
        int[] iArr2 = new int[iArr.length + 2];
        iArr2[0] = i3;
        iArr2[1] = i16;
        for (int i17 = 0; i17 < iArr.length; i17++) {
            iArr2[i17 + 2] = iArr[i17];
        }
        nativeSetIconsHidden(j3, iArr2, iArr.length + 2, z16);
    }

    public void nativeSetPriority(long j3, int i3, float f16) {
        this.mJNIInterface.nativeSetPriority(j3, i3, f16);
    }

    public void nativeSetRotate(long j3, float f16, boolean z16) {
        this.mJNIInterface.nativeSetRotate(j3, f16, z16);
    }

    public void nativeSetSatelliteEnabled(long j3, boolean z16) {
        this.mJNIInterface.nativeSetSatelliteEnabled(j3, z16);
    }

    public void nativeSetScale(long j3, double d16, boolean z16) {
        this.mJNIInterface.nativeSetScale(j3, d16, z16);
    }

    public void nativeSetScaleLevel(long j3, int i3, boolean z16) {
        this.mJNIInterface.nativeSetScaleLevel(j3, i3, z16);
    }

    public void nativeSetScreenCenterOffset(long j3, float f16, float f17, boolean z16) {
        this.mJNIInterface.nativeSetScreenCenterOffset(j3, f16, f17, z16);
    }

    public void nativeSetServerHost(long j3, String str) {
        this.mJNIInterface.nativeSetServerHost(j3, str);
    }

    public void nativeSetShowIndoorBuildingWhiteList(long j3, String[] strArr) {
        this.mJNIInterface.nativeSetShowIndoorBuildingWhiteList(j3, strArr);
    }

    public void nativeSetSkew(long j3, float f16, boolean z16) {
        this.mJNIInterface.nativeSetSkew(j3, f16, z16);
    }

    public void nativeSetSkyBoxTexture(long j3, String str) {
        this.mJNIInterface.nativeSetSkyBoxTexture(j3, str);
    }

    public void nativeSetSpotOrDirectionalLight(long j3, LightType lightType, LightColor lightColor, LightDirection lightDirection, float f16) {
        this.mJNIInterface.nativeSetSpotOrDirectionalLight(j3, lightType.ordinal(), lightColor.getR(), lightColor.getG(), lightColor.getB(), lightDirection.getX(), lightDirection.getY(), lightDirection.getZ(), f16);
    }

    public void nativeSetTileOverlayDataLevelRange(long j3, int i3, int i16, int i17) {
        this.mJNIInterface.nativeSetTileOverlayDataLevelRange(j3, i3, i16, i17);
    }

    public void nativeSetTileOverlayEnabled(long j3, boolean z16) {
        this.mJNIInterface.nativeSetTileOverlayEnabled(j3, z16);
    }

    public void nativeSetTileOverlayPriority(long j3, int i3, int i16) {
        this.mJNIInterface.nativeSetTileOverlayPriority(j3, i3, i16);
    }

    public void nativeSetTrafficColor(long j3, int i3, int i16, int i17, int i18) {
        this.mJNIInterface.nativeSetTrafficColor(j3, i3, i16, i17, i18);
    }

    public void nativeSetTrafficMode(long j3, int i3, int i16) {
        this.mJNIInterface.nativeSetTrafficMode(j3, i3, i16);
    }

    public void nativeSetTurnArrow(long j3, long j16, List<GeoPoint> list, int i3, int i16) {
        if (list != null) {
            this.mJNIInterface.nativeSetTurnArrow(j3, j16, (GeoPoint[]) list.toArray(new GeoPoint[0]), i3, i16);
        }
    }

    public void nativeSetTurnArrowStyle(long j3, long j16, int i3, int i16) {
        this.mJNIInterface.nativeSetTurnArrowStyle(j3, j16, i3, i16);
    }

    public void nativeSetViewport(long j3, int i3, int i16, int i17, int i18) {
        this.mJNIInterface.nativeSetViewport(j3, i3, i16, i17, i18);
    }

    public void nativeShowStreetRoad(long j3) {
        this.mJNIInterface.nativeShowStreetRoad(j3);
    }

    public void nativeShowTraffic(long j3) {
        this.mJNIInterface.nativeShowTraffic(j3);
    }

    public void nativeStartGLModelSkeletonAnimation(long j3, long j16, int i3, float f16, boolean z16) {
        this.mJNIInterface.nativeStartGLModelSkeletonAnimation(j3, j16, i3, f16, z16);
    }

    public void nativeStopGLModelSkeletonAnimation(long j3, long j16) {
        this.mJNIInterface.nativeStopGLModelSkeletonAnimation(j3, j16);
    }

    public void nativeSwitchEngineForeGround(long j3, boolean z16) {
        this.mJNIInterface.nativeSwitchEngineForeGround(j3, z16);
    }

    public void nativeToScreenLocation(long j3, byte[] bArr, double d16, double d17, float[] fArr) {
        this.mJNIInterface.nativeToScreenLocation(j3, bArr, d16, d17, fArr);
    }

    public void nativeUnlockEngine(long j3) {
        this.mJNIInterface.nativeUnlockEngine(j3);
    }

    public void nativeUpdateAggregatioinOverlay(long j3, long j16, AggregationOverlayInfo aggregationOverlayInfo) {
        this.mJNIInterface.nativeUpdateAggregationOverlay(j3, j16, aggregationOverlayInfo);
    }

    public void nativeUpdateArcLineOverlay(long j3, long j16, ArcLineOverlayInfo arcLineOverlayInfo) {
        this.mJNIInterface.nativeUpdateArcLineOverlay(j3, j16, arcLineOverlayInfo);
    }

    public void nativeUpdateCircle(long j3, int i3, CircleInfo circleInfo) {
        this.mJNIInterface.nativeUpdateCircle(j3, i3, circleInfo);
    }

    public void nativeUpdateFrame(long j3, double d16) {
        this.mJNIInterface.nativeUpdateFrame(j3, d16);
    }

    public void nativeUpdateGLModel(long j3, long j16, GLModelInfo gLModelInfo) {
        this.mJNIInterface.nativeUpdateGLModel(j3, j16, gLModelInfo);
    }

    public void nativeUpdateGroundOverlay(long j3, long j16, GroundOverlayInfo groundOverlayInfo) {
        this.mJNIInterface.nativeUpdateGroundOverlay(j3, j16, groundOverlayInfo);
    }

    public void nativeUpdateHeatmapOverlay(long j3, long j16, HeatmapInfo heatmapInfo) {
        this.mJNIInterface.nativeUpdateHeatmapOverlay(j3, j16, heatmapInfo);
    }

    public void nativeUpdateIntersectionOverlay(long j3, IntersectionOverlayInfo intersectionOverlayInfo) {
        this.mJNIInterface.nativeUpdateIntersectionOverlay(j3, intersectionOverlayInfo);
    }

    public void nativeUpdateMapResource(long j3, String str) {
        this.mJNIInterface.nativeUpdateMapResource(j3, str);
    }

    public void nativeUpdateMarker(long j3, MarkerInfo markerInfo) {
        this.mJNIInterface.nativeUpdateMarker(j3, markerInfo);
    }

    public void nativeUpdateMarkerInfo(long j3, int i3, String str, double d16, double d17, float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, int i16, int i17, boolean z27) {
        this.mJNIInterface.nativeUpdateMarkerInfo(j3, i3, str, d16, d17, f16, f17, f18, f19, f26, f27, z16, z17, z18, z19, z26, i16, i17, z27);
    }

    public void nativeUpdateMaskLayer(long j3, int i3, int i16) {
        this.mJNIInterface.nativeUpdateMaskLayer(j3, i3, i16);
    }

    public void nativeUpdatePolygon(long j3, int i3, int i16, PolygonInfo polygonInfo) {
        this.mJNIInterface.nativeUpdatePolygon(j3, i3, i16, polygonInfo);
    }

    public void nativeUpdateScatterPlotOverlay(long j3, long j16, ScatterPlotInfo scatterPlotInfo) {
        this.mJNIInterface.nativeUpdateScatterPlotOverlay(j3, j16, scatterPlotInfo);
    }

    public void nativeUpdateTrailOverlay(long j3, long j16, TrailOverlayInfo trailOverlayInfo) {
        this.mJNIInterface.nativeUpdateTrailOverlay(j3, j16, trailOverlayInfo);
    }

    public EngineWriteDataModel nativeWriteMapDataBlock(long j3, String str, byte[] bArr) {
        return this.mJNIInterface.nativeWriteMapDataBlock(j3, str, bArr);
    }

    public void nativeZoomIn(long j3, float f16, float f17) {
        this.mJNIInterface.nativeZoomIn(j3, f16, f17);
    }

    public void nativeZoomOut(long j3) {
        this.mJNIInterface.nativeZoomOut(j3);
    }

    public void nativeZoomToSpan(long j3, Rect rect, Rect rect2, boolean z16) {
        this.mJNIInterface.nativeZoomToSpan(j3, rect, rect2, z16);
    }

    public void nativeZoomToSpanForNavigation(long j3, GeoPoint geoPoint, int i3, int i16, boolean z16) {
        this.mJNIInterface.nativeZoomToSpanForNavigation(j3, geoPoint, i3, i16, z16);
    }

    public void registerCallback(long j3) {
        nativeSetCallback(j3);
    }

    public void removeLineText(long j3, int i3) {
        this.mJNIInterface.removeLineText(j3, i3);
    }

    public void scheduleClickOnNextRender(long j3, float f16, float f17) {
        this.mJNIInterface.nativeScheduleClickOnNextRender(j3, f16, f17);
    }

    public void setLineTextStyle(long j3, int i3, PolylineOptions.Text text) {
        this.mJNIInterface.setLineTextStyle(j3, i3, text);
    }

    public void setMapCallbackGetGLContext(oy oyVar) {
        JNICallback jNICallback = this.mCallback;
        if (jNICallback != null) {
            jNICallback.setMapCallbackGetGLContext(oyVar);
        }
    }

    public void setRestrictBounds(long j3, double[] dArr, double[] dArr2, int i3) {
        this.mJNIInterface.setRestrictBounds(j3, dArr, dArr2, i3);
    }

    public void setTrafficStyle(long j3, TrafficStyle trafficStyle) {
        this.mJNIInterface.nativeSetTrafficStyle(j3, trafficStyle);
    }
}
