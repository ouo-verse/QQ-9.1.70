package com.tencent.qqmini.map;

import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.IPermissionManagerProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.Permissions;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MapViewJsPlugin extends BaseJsPlugin {
    public static final String EVENT_ADD_MAP_CIRCLES = "addMapCircles";
    public static final String EVENT_ADD_MAP_CONTROLS = "addMapControls";
    public static final String EVENT_ADD_MAP_LINE = "addMapLines";
    public static final String EVENT_ADD_MAP_MARKERS = "addMapMarkers";
    public static final String EVENT_ADD_MAP_POLYGONS = "addMapPolygons";
    public static final String EVENT_GET_MAPCENTER_LOCATION = "getMapCenterLocation";
    public static final String EVENT_GET_MAP_REGION = "getMapRegion";
    public static final String EVENT_GET_MAP_ROTATE = "getMapRotate";
    public static final String EVENT_GET_MAP_SCALE = "getMapScale";
    public static final String EVENT_GET_MAP_SKEW = "getMapSkew";
    public static final String EVENT_INCLUDE_MAP_POINT = "includeMapPoints";
    public static final String EVENT_INSERT_MAP = "insertMap";
    public static final String EVENT_MOVE_TO_MAP_LOCATION = "moveToMapLocation";
    public static final String EVENT_REMOVE_MAP = "removeMap";
    public static final String EVENT_REMOVE_MAP_MARKERS = "removeMapMarkers";
    public static final String EVENT_TRANSLATE_MAP_MARKER = "translateMapMarker";
    public static final String EVENT_UPDATE_MAP = "updateMap";
    public static final String EVENT_UPDATE_MAP_COVERS = "updateMapCovers";
    public static final String MAP_TAG = "MiniAppMapTag";
    public static final String TAG = "MapViewJsPlugin";
    private SparseArray<MapContext> mapContextArray;

    /* JADX INFO: Access modifiers changed from: private */
    public MapContext getMapContext(int i3) {
        return this.mapContextArray.get(i3);
    }

    private int getPageId() {
        return PageAction.obtain(this.mMiniAppContext).getPageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertMap(int i3, int i16, int i17, String str, String str2) {
        CoverMapView coverMapView;
        MapContext mapContext = this.mapContextArray.get(i16);
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "insertMapView mapId=" + i16 + ",mapContext=" + mapContext);
        }
        if (mapContext != null) {
            return;
        }
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(i16);
        if (coverView == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                TencentMapOptions tencentMapOptions = new TencentMapOptions();
                tencentMapOptions.setSubInfo(str, str2);
                coverMapView = new CoverMapView(this.mContext, tencentMapOptions);
            } else {
                coverMapView = new CoverMapView(this.mContext);
            }
            coverView = coverMapView;
            coverView.setContentDescription(i16 + "_" + i17);
            coverView.setParentId(i17);
            CoverViewAction.obtain(this.mMiniAppContext, i3).add(i17, i16, coverView);
        }
        if (coverView instanceof CoverMapView) {
            if (!this.mIsContainer) {
                i3 = getPageId();
            }
            this.mapContextArray.put(i16, new MapContext(this.mMiniAppContext, (CoverMapView) coverView, i16, i3));
            coverView.setTag("MiniAppMapTag");
        }
    }

    @JsEvent({"addMapCircles"})
    public void addMapCircles(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.addMapCircles(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"addMapControls"})
    public void addMapControls(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.addMapControls(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"addMapLines"})
    public void addMapLines(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.addMapPolyline(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"addMapMarkers"})
    public void addMapMarkers(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.addMapMarkers(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"addMapPolygons"})
    public void addMapPolygons(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.addMapPolygons(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getMapCenterLocation"})
    public void getMapCenterLocation(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                LatLng latLng;
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId", 0));
                    if (mapContext != null) {
                        latLng = mapContext.getCenterLocation();
                    } else {
                        latLng = null;
                    }
                    if (latLng != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", latLng.getLatitude());
                        jSONObject.put("longitude", latLng.getLongitude());
                        QMLog.w(MapViewJsPlugin.TAG, "handleNativeRequest eventName=" + requestEvent.event + "callbackJsEventOK:" + jSONObject.toString());
                        requestEvent.ok(jSONObject);
                        return;
                    }
                    requestEvent.fail();
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getMapRegion"})
    public void getMapRegion(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId", 0));
                    if (mapContext != null) {
                        JSONObject region = mapContext.getRegion();
                        if (region != null) {
                            requestEvent.ok(region);
                        } else {
                            requestEvent.fail();
                        }
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getMapRotate"})
    public void getMapRotate(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.16
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId", 0));
                    if (mapContext != null) {
                        float rotate = mapContext.getRotate();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(CanvasView.ACTION_ROTATE, rotate);
                            requestEvent.ok(jSONObject);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            requestEvent.fail();
                        }
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e17) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e17);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getMapScale"})
    public void getMapScale(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.11
            @Override // java.lang.Runnable
            public void run() {
                float f16;
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId", 0));
                    if (mapContext != null) {
                        f16 = mapContext.getScale();
                    } else {
                        f16 = 0.0f;
                    }
                    if (f16 != 0.0f) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("scale", f16);
                        requestEvent.ok(jSONObject);
                        return;
                    }
                    requestEvent.fail();
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"getMapSkew"})
    public void getMapSkew(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId", 0));
                    if (mapContext != null) {
                        float skew = mapContext.getSkew();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("skew", skew);
                            requestEvent.ok(jSONObject);
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            requestEvent.fail();
                        }
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e17) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e17);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"includeMapPoints"})
    public void includeMapPoints(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    boolean z16 = false;
                    int optInt = jSONObject.optInt("mapId", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(optInt);
                    if (mapContext != null) {
                        mapContext.includeMapPoints(jSONObject);
                        z16 = true;
                    }
                    if (z16) {
                        requestEvent.ok(jSONObject2);
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"moveToMapLocation"})
    public void moveToMapLocation(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    int optInt = jSONObject.optInt("mapId", 0);
                    JSONObject jSONObject2 = new JSONObject();
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(optInt);
                    if (mapContext != null) {
                        if (!jSONObject.has("longitude") && !jSONObject.has("latitude")) {
                            IPermissionManagerProxy iPermissionManagerProxy = (IPermissionManagerProxy) ProxyManager.get(IPermissionManagerProxy.class);
                            Activity attachedActivity = ((BaseJsPlugin) MapViewJsPlugin.this).mMiniAppContext.getAttachedActivity();
                            Permissions permissions = Permissions.ACCESS_FINE_LOCATION;
                            if (iPermissionManagerProxy.isPermissionGranted(attachedActivity, permissions)) {
                                mapContext.moveToCurrentLocation();
                                requestEvent.ok(jSONObject2);
                            } else {
                                iPermissionManagerProxy.requestForPermission(attachedActivity, permissions, new a(mapContext, jSONObject2));
                            }
                        }
                        mapContext.moveToLocation(jSONObject);
                        requestEvent.ok(jSONObject2);
                    }
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }

            /* renamed from: com.tencent.qqmini.map.MapViewJsPlugin$8$a */
            /* loaded from: classes23.dex */
            class a implements RequestPermissionCallback {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ MapContext f346206a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ JSONObject f346207b;

                a(MapContext mapContext, JSONObject jSONObject) {
                    this.f346206a = mapContext;
                    this.f346207b = jSONObject;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
                public void onFail() {
                    requestEvent.fail("getCurrentLocation permission denied.");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
                public void onSuccess() {
                    this.f346206a.moveToCurrentLocation();
                    requestEvent.ok(this.f346207b);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestPermissionCallback
                public void onPartialGrant() {
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.mapContextArray = new SparseArray<>();
    }

    @JsEvent({"removeMap"})
    public void removeMap(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(new JSONObject(requestEvent.jsonParams).optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.destroy();
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"removeMapMarkers"})
    public void removeMapMarkers(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.removeMapMarkers(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"translateMapMarker"})
    public void translateMapMarker(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    boolean z16 = false;
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId", 0));
                    if (mapContext != null) {
                        mapContext.translateMapMarker(jSONObject);
                        z16 = true;
                    }
                    if (z16) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.e(MapViewJsPlugin.TAG, "", e16);
                    }
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"updateMap"})
    public void updateMap(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(jSONObject.optInt("mapId"));
                    if (mapContext != null) {
                        mapContext.updateMap(jSONObject);
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }

    @JsEvent({"insertMap"})
    public void insertMap(final RequestEvent requestEvent) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.map.MapViewJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    int optInt = jSONObject.optInt("mapId");
                    int optInt2 = jSONObject.optInt("parentId");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("containerId", optInt);
                    MapViewJsPlugin.this.insertMap(requestEvent.webViewId, optInt, optInt2, jSONObject.optString("subKey"), ((BaseJsPlugin) MapViewJsPlugin.this).mMiniAppInfo.appId);
                    MapContext mapContext = MapViewJsPlugin.this.getMapContext(optInt);
                    if (mapContext != null) {
                        mapContext.updateMap(jSONObject);
                        requestEvent.ok(jSONObject2);
                    } else {
                        requestEvent.fail();
                    }
                } catch (JSONException e16) {
                    QMLog.e(MapViewJsPlugin.TAG, requestEvent.event + " error.", e16);
                    requestEvent.fail();
                }
            }
        });
    }
}
