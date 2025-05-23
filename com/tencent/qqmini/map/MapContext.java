package com.tencent.qqmini.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.action.a;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.plugins.MapJsPlugin;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MapContext implements TencentMap.OnMarkerClickListener, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedCallback, TencentMap.OnCameraChangeListener, TencentMap.InfoWindowAdapter, SensorEventListener {
    private static float DEFAULT_ROTATE = 0.0f;
    private static float DEFAULT_SCALE = 16.0f;
    private static float DEFAULT_SKEW = 0.0f;
    private static String MAP_EVENT_CALLOUT_CLICK = "onMapCalloutClick";
    private static String MAP_EVENT_CLICK = "onMapClick";
    private static String MAP_EVENT_MARKER_CLICK = "onMapMarkerClick";
    private static String MAP_EVENT_REGION_CHANGE = "onMapRegionChange";
    public static String TAG = "MapContext";
    private ArrayList<Circle> circleArrayList;
    private Context context;
    private LatLng curLatLng;
    private Polygon curPolygon;
    private float density;
    private boolean isLocating;
    private Bitmap locationBitmap;
    private Marker locationMarker;
    private CoverMapView mCoverMapView;
    private int mMapId;
    private UiSettings mMapUiSettings;
    private IMiniAppContext mMiniAppContext;
    private int mPageWebViewId;
    private TencentMap mTencentMap;
    private int markerMaxSize;
    private int markerMinSize;
    private SparseArray<Marker> markerSparseArray;
    private LatLng myLatLng;
    private ArrayList<Polyline> polylineArrayList;
    private Sensor sensor;
    private SensorManager sensorManager;
    private float curScale = DEFAULT_SCALE;
    private float curRotate = 0.0f;
    private float curSkew = 0.0f;
    private float rotateDegree = 0.0f;
    private boolean curShowLocationMarkerStatus = false;
    private boolean showCurrentLocationStatus = false;

    public MapContext(IMiniAppContext iMiniAppContext, CoverMapView coverMapView, int i3, int i16) {
        this.mMiniAppContext = iMiniAppContext;
        this.mCoverMapView = coverMapView;
        this.mMapId = i3;
        this.mPageWebViewId = i16;
        this.mTencentMap = coverMapView.getMap();
        this.mMapId = i3;
        this.context = coverMapView.getContext();
        this.mTencentMap.setInfoWindowAdapter(this);
        this.mTencentMap.setOnMarkerClickListener(this);
        this.mTencentMap.setOnInfoWindowClickListener(this);
        this.mTencentMap.setOnMapClickListener(this);
        this.mTencentMap.addOnMapLoadedCallback(this);
        this.mTencentMap.setOnCameraChangeListener(this);
        this.mMapUiSettings = coverMapView.getUiSetrings();
        this.density = this.context.getResources().getDisplayMetrics().density;
        SensorManager sensorManager = (SensorManager) this.context.getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        this.sensorManager = sensorManager;
        this.sensor = SensorMonitor.getDefaultSensor(sensorManager, 3);
        float f16 = this.density;
        this.markerMinSize = (int) ((30.0f * f16) + 0.5d);
        this.markerMaxSize = (int) ((f16 * 50.0f) + 0.5d);
        try {
            this.locationBitmap = BitmapFactory.decodeResource(coverMapView.getResources(), R.drawable.ojw);
        } catch (Throwable th5) {
            QMLog.e(TAG, "decodeResource error, ", th5);
        }
        this.markerSparseArray = new SparseArray<>();
        this.circleArrayList = new ArrayList<>();
        this.polylineArrayList = new ArrayList<>();
    }

    private void addCircle(JSONObject jSONObject) {
        String str;
        if (QMLog.isColorLevel()) {
            String str2 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addCircles params=");
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = GlobalUtil.DEF_STRING;
            }
            sb5.append(str);
            QMLog.d(str2, sb5.toString());
        }
        if (jSONObject == null) {
            return;
        }
        double optDouble = jSONObject.optDouble("latitude", 0.0d);
        double optDouble2 = jSONObject.optDouble("longitude", 0.0d);
        String optString = jSONObject.optString("color", "");
        String optString2 = jSONObject.optString("fillColor", "");
        double optDouble3 = jSONObject.optDouble("radius", 0.0d);
        float optDouble4 = (float) jSONObject.optDouble("strokeWidth", 0.0d);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.center(new LatLng(optDouble, optDouble2));
        circleOptions.radius(optDouble3);
        if (!TextUtils.isEmpty(optString2)) {
            try {
                circleOptions.fillColor(ColorUtils.parseColor(optString2));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (!TextUtils.isEmpty(optString)) {
            try {
                circleOptions.strokeColor(ColorUtils.parseColor(optString));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (optDouble4 > 0.0f) {
            circleOptions.strokeWidth(optDouble4);
        }
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null) {
            this.circleArrayList.add(tencentMap.addCircle(circleOptions));
        }
    }

    private void addControl(JSONObject jSONObject) {
        String str;
        if (QMLog.isColorLevel()) {
            String str2 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addControl params=");
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = GlobalUtil.DEF_STRING;
            }
            sb5.append(str);
            QMLog.d(str2, sb5.toString());
        }
        if (jSONObject == null) {
            return;
        }
        jSONObject.optInt("id", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addCover(JSONObject jSONObject) {
        Drawable drawable;
        TencentMap tencentMap;
        if (jSONObject == null) {
            return;
        }
        double optDouble = jSONObject.optDouble("latitude", 0.0d);
        double optDouble2 = jSONObject.optDouble("longitude", 0.0d);
        String optString = jSONObject.optString("iconPath", "");
        int optInt = jSONObject.optInt("width", -2);
        int optInt2 = jSONObject.optInt("height", -2);
        MarkerOptions markerOptions = new MarkerOptions(new LatLng(optDouble, optDouble2));
        ImageView createMarkerView = createMarkerView(optInt, optInt2);
        if (!TextUtils.isEmpty(optString)) {
            try {
                drawable = Drawable.createFromPath(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString));
            } catch (OutOfMemoryError e16) {
                QMLog.e(TAG, "markerDrawable error,", e16);
            }
            if (drawable == null) {
                drawable = this.context.getResources().getDrawable(R.drawable.ojx);
            }
            createMarkerView.setImageDrawable(drawable);
            tencentMap = this.mTencentMap;
            if (tencentMap == null) {
                tencentMap.addMarker(markerOptions).setIcon(BitmapDescriptorFactory.fromView(createMarkerView));
                return;
            }
            return;
        }
        drawable = null;
        if (drawable == null) {
        }
        createMarkerView.setImageDrawable(drawable);
        tencentMap = this.mTencentMap;
        if (tencentMap == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addMarker(JSONObject jSONObject) {
        int i3;
        Drawable drawable;
        TencentMap tencentMap;
        String str;
        if (QMLog.isColorLevel()) {
            String str2 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addMarker params=");
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = GlobalUtil.DEF_STRING;
            }
            sb5.append(str);
            QMLog.d(str2, sb5.toString());
        }
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("id", 0);
        double optDouble = jSONObject.optDouble("latitude", 0.0d);
        double optDouble2 = jSONObject.optDouble("longitude", 0.0d);
        String optString = jSONObject.optString("title", "");
        int optInt2 = jSONObject.optInt(NodeProps.Z_INDEX, 0);
        String optString2 = jSONObject.optString("iconPath", "");
        float optDouble3 = (float) jSONObject.optDouble(CanvasView.ACTION_ROTATE, 0.0d);
        float optDouble4 = (float) jSONObject.optDouble(c.f123400v, 1.0d);
        int optInt3 = jSONObject.optInt("width", -2);
        int optInt4 = jSONObject.optInt("height", -2);
        JSONObject optJSONObject = jSONObject.optJSONObject("callout");
        if (optJSONObject != null) {
            optString = optJSONObject.optString("content");
        }
        String str3 = optString;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("anchor");
        MarkerOptions markerOptions = new MarkerOptions(new LatLng(optDouble, optDouble2));
        if (optJSONObject2 != null) {
            i3 = optInt2;
            markerOptions.anchor((float) optJSONObject2.optDouble(HippyTKDListViewAdapter.X, 0.5d), (float) optJSONObject2.optDouble("y", 1.0d));
        } else {
            i3 = optInt2;
        }
        if (!TextUtils.isEmpty(optString2)) {
            try {
                drawable = Drawable.createFromPath(((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString2));
            } catch (OutOfMemoryError e16) {
                QMLog.e(TAG, "markerDrawable error,", e16);
            }
            if (drawable == null) {
                drawable = this.context.getResources().getDrawable(R.drawable.ojx);
            }
            ImageView createMarkerView = createMarkerView(optInt3, optInt4);
            createMarkerView.setLayoutParams(new ViewGroup.LayoutParams(optInt3, optInt4));
            createMarkerView.setImageDrawable(drawable);
            markerOptions.icon(BitmapDescriptorFactory.fromView(createMarkerView));
            markerOptions.title(str3);
            markerOptions.rotation(optDouble3);
            markerOptions.alpha(optDouble4);
            markerOptions.zIndex(i3);
            tencentMap = this.mTencentMap;
            if (tencentMap == null) {
                Marker addMarker = tencentMap.addMarker(markerOptions);
                addMarker.setTag(jSONObject);
                addMarker.setClickable(true);
                this.markerSparseArray.put(optInt, addMarker);
                return;
            }
            return;
        }
        drawable = null;
        if (drawable == null) {
        }
        ImageView createMarkerView2 = createMarkerView(optInt3, optInt4);
        createMarkerView2.setLayoutParams(new ViewGroup.LayoutParams(optInt3, optInt4));
        createMarkerView2.setImageDrawable(drawable);
        markerOptions.icon(BitmapDescriptorFactory.fromView(createMarkerView2));
        markerOptions.title(str3);
        markerOptions.rotation(optDouble3);
        markerOptions.alpha(optDouble4);
        markerOptions.zIndex(i3);
        tencentMap = this.mTencentMap;
        if (tencentMap == null) {
        }
    }

    private void addPolyline(JSONObject jSONObject) {
        String str;
        String str2 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addPolyline params=");
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = GlobalUtil.DEF_STRING;
        }
        sb5.append(str);
        QMLog.d(str2, sb5.toString());
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("points");
        String optString = jSONObject.optString("color", "");
        double d16 = 0.0d;
        float dip2px = ViewUtils.dip2px((float) jSONObject.optDouble("width", 0.0d));
        boolean optBoolean = jSONObject.optBoolean("dottedLine", false);
        boolean optBoolean2 = jSONObject.optBoolean("arrowLine", false);
        String optString2 = jSONObject.optString("arrowIconPath", "");
        String optString3 = jSONObject.optString(NodeProps.BORDER_COLOR, "");
        float optDouble = (float) jSONObject.optDouble(NodeProps.BORDER_WIDTH, 0.0d);
        PolylineOptions polylineOptions = new PolylineOptions();
        if (optJSONArray != null) {
            int i3 = 0;
            while (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                polylineOptions.add(new LatLng(optJSONObject.optDouble("latitude", d16), optJSONObject.optDouble("longitude", d16)), new LatLng[0]);
                i3++;
                optBoolean2 = optBoolean2;
                d16 = 0.0d;
            }
        }
        boolean z16 = optBoolean2;
        if (dip2px > 0.0f) {
            polylineOptions.width(dip2px);
        }
        if (!TextUtils.isEmpty(optString)) {
            try {
                polylineOptions.color(ColorUtils.parseColor(optString));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (optBoolean) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf((int) (polylineOptions.getWidth() * 3.0f)));
            arrayList.add(Integer.valueOf((int) polylineOptions.getWidth()));
            polylineOptions.pattern(arrayList);
        }
        if (z16 && !TextUtils.isEmpty(optString2)) {
            String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(optString2);
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath, ImageUtil.scaleBitmap(absolutePath, this.markerMaxSize));
                if (decodeFile != null) {
                    polylineOptions.arrowTexture(BitmapDescriptorFactory.fromBitmap(decodeFile));
                }
            } catch (OutOfMemoryError unused2) {
            }
        }
        if (!TextUtils.isEmpty(optString3)) {
            try {
                polylineOptions.borderColor(ColorUtils.parseColor(optString3));
            } catch (IllegalArgumentException unused3) {
            }
        }
        if (optDouble > 0.0f) {
            polylineOptions.borderWidth(optDouble);
        }
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null) {
            this.polylineArrayList.add(tencentMap.addPolyline(polylineOptions));
        }
    }

    private ImageView createMarkerView(int i3, int i16) {
        ImageView imageView = new ImageView(this.context);
        if (i3 > 0 && i16 > 0) {
            imageView.setMinimumWidth((int) ((this.density * i3) + 0.5d));
            imageView.setMinimumHeight((int) ((this.density * i16) + 0.5d));
        } else {
            imageView.setMinimumWidth(this.markerMinSize);
            imageView.setMinimumHeight(this.markerMinSize);
        }
        return imageView;
    }

    private void location() {
        if (this.isLocating) {
            return;
        }
        this.isLocating = true;
        this.mMiniAppContext.performAction(a.b(new a.b() { // from class: com.tencent.qqmini.map.MapContext.1

            /* compiled from: P */
            /* renamed from: com.tencent.qqmini.map.MapContext$1$a */
            /* loaded from: classes23.dex */
            class a implements AsyncResult {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16 && jSONObject != null) {
                        Double valueOf = Double.valueOf(jSONObject.optDouble("latitude"));
                        Double valueOf2 = Double.valueOf(jSONObject.optDouble("longitude"));
                        MapContext.this.myLatLng = new LatLng(valueOf.doubleValue(), valueOf2.doubleValue());
                        if (MapContext.this.locationMarker == null) {
                            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(MapContext.this.locationBitmap);
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.icon(fromBitmap);
                            MapContext mapContext = MapContext.this;
                            mapContext.locationMarker = mapContext.mTencentMap.addMarker(markerOptions);
                        }
                        MapContext.this.locationMarker.setPosition(MapContext.this.myLatLng);
                        MapContext.this.locationMarker.setVisible(MapContext.this.curShowLocationMarkerStatus);
                        if (MapContext.this.showCurrentLocationStatus) {
                            MapContext mapContext2 = MapContext.this;
                            mapContext2.updateMapCamera(mapContext2.myLatLng.getLatitude(), MapContext.this.myLatLng.getLongitude());
                            return;
                        }
                        return;
                    }
                    QMLog.w(MapContext.TAG, "handleNativeRequest locate failed");
                }
            }

            @Override // com.tencent.qqmini.sdk.action.a.b
            public void onCheckLocationPermissionAction(boolean z16) {
                if (z16) {
                    ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getLocation(MapContext.this.mMiniAppContext.getAttachActivity(), MapJsPlugin.LOCATION_TYPE_84, true, new a());
                }
                MapContext.this.isLocating = false;
            }
        }));
    }

    private void setLocationStatus(JSONObject jSONObject, double d16, double d17) {
        if (jSONObject.has("skew") || jSONObject.has(CanvasView.ACTION_ROTATE) || jSONObject.has("centerLongitude") || jSONObject.has("centerLatitude") || jSONObject.has("scale")) {
            this.showCurrentLocationStatus = false;
            updateMapCamera(d16, d17);
        }
    }

    private void setRotate(JSONObject jSONObject) {
        if (jSONObject.has(CanvasView.ACTION_ROTATE)) {
            float longValue = (float) Long.valueOf(jSONObject.optString(CanvasView.ACTION_ROTATE)).longValue();
            this.curRotate = longValue;
            if (longValue < 0.0f || longValue > 360.0f) {
                this.curRotate = 0.0f;
                return;
            }
            return;
        }
        this.curRotate = getRotate();
    }

    private void setScale(JSONObject jSONObject) {
        if (jSONObject.has("scale")) {
            float longValue = (float) Long.valueOf(jSONObject.optString("scale")).longValue();
            this.curScale = longValue;
            if (longValue < 3.0f || longValue > 20.0f) {
                this.curScale = DEFAULT_SCALE;
                return;
            }
            return;
        }
        this.curScale = getScale();
    }

    private void setShowCompass(JSONObject jSONObject) {
        if (jSONObject.has("showCompass")) {
            this.mMapUiSettings.setCompassEnabled(jSONObject.optBoolean("showCompass", false));
        }
    }

    private void setSkew(JSONObject jSONObject) {
        if (jSONObject.has("skew")) {
            float longValue = (float) Long.valueOf(jSONObject.optString("skew")).longValue();
            this.curSkew = longValue;
            if (longValue < 0.0f || longValue > 40.0f) {
                this.curSkew = 0.0f;
                return;
            }
            return;
        }
        this.curSkew = getSkew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMapCamera(double d16, double d17) {
        if (d16 == 0.0d && d17 == 0.0d) {
            if (this.curLatLng == null) {
                this.curLatLng = this.mTencentMap.getCameraPosition().target;
            }
        } else {
            this.curLatLng = new LatLng(d16, d17);
        }
        LatLng latLng = this.curLatLng;
        if (latLng == null) {
            return;
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, this.curScale, this.curSkew, this.curRotate)));
    }

    private void updateMapViewPosition(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = (int) (jSONObject.optInt("left") * this.density);
            int optInt2 = (int) (jSONObject.optInt("top") * this.density);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (jSONObject.optInt("width") * this.density), (int) (jSONObject.optInt("height") * this.density));
            layoutParams.leftMargin = optInt;
            layoutParams.topMargin = optInt2;
            this.mCoverMapView.setLayoutParams(layoutParams);
        }
    }

    private void updateOtherParams(JSONObject jSONObject) {
        if (jSONObject.has("showScale")) {
            this.mMapUiSettings.setScaleViewEnabled(jSONObject.optBoolean("showScale", false));
        }
        if (jSONObject.has("enableOverlooking")) {
            this.mMapUiSettings.setTiltGesturesEnabled(jSONObject.optBoolean("enableOverlooking", false));
        }
        if (jSONObject.has("enableZoom")) {
            this.mMapUiSettings.setZoomGesturesEnabled(jSONObject.optBoolean("enableZoom", true));
        }
        if (jSONObject.has("enableScroll")) {
            this.mMapUiSettings.setScrollGesturesEnabled(jSONObject.optBoolean("enableScroll", true));
        }
        if (jSONObject.has("enableRotate")) {
            this.mMapUiSettings.setRotateGesturesEnabled(jSONObject.optBoolean("enableRotate", false));
        }
        if (jSONObject.has("enableSatellite")) {
            this.mTencentMap.setSatelliteEnabled(jSONObject.optBoolean("enableSatellite", false));
        }
        if (jSONObject.has("enableTraffic")) {
            this.mTencentMap.setTrafficEnabled(jSONObject.optBoolean("enableTraffic", false));
        }
        if (jSONObject.has("enable3D")) {
            this.mTencentMap.setBuildingEnable(jSONObject.optBoolean("enable3D", false));
        }
        if (jSONObject.has("showLocation")) {
            boolean optBoolean = jSONObject.optBoolean("showLocation");
            this.curShowLocationMarkerStatus = optBoolean;
            if (optBoolean) {
                location();
                return;
            }
            Marker marker = this.locationMarker;
            if (marker != null) {
                marker.setVisible(false);
            }
        }
    }

    public void addMapCircles(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int i3;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("circles")) != null) {
            int length = optJSONArray.length();
            int i16 = 0;
            if (length > 0) {
                while (i16 < length) {
                    addCircle(optJSONArray.optJSONObject(i16));
                    i16++;
                }
                return;
            }
            ArrayList<Circle> arrayList = this.circleArrayList;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                while (i16 < i3) {
                    this.circleArrayList.get(i16).remove();
                    i16++;
                }
            }
        }
    }

    public void addMapControls(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray(MosaicConstants$JsProperty.PROP_CONTROLS)) != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                addControl(optJSONArray.optJSONObject(i3));
            }
        }
    }

    public void addMapCovers(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("covers")) != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                addCover(optJSONArray.optJSONObject(i3));
            }
        }
    }

    public void addMapMarkers(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("markers");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                addMarker(optJSONArray.optJSONObject(i3));
            }
        }
    }

    public void addMapPolygons(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int i3;
        int i16;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("polygons")) != null) {
            if (optJSONArray.length() > 0) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("points");
                float optDouble = (float) optJSONObject.optDouble("strokeWidth");
                String optString = optJSONObject.optString("strokeColor");
                String optString2 = optJSONObject.optString("fillColor");
                boolean optBoolean = optJSONObject.optBoolean(NodeProps.VISIBLE, true);
                if (!TextUtils.isEmpty(optString2)) {
                    i3 = ColorUtils.parseColor(optString2);
                } else {
                    i3 = 0;
                }
                if (!TextUtils.isEmpty(optString)) {
                    i16 = ColorUtils.parseColor(optString);
                } else {
                    i16 = 0;
                }
                PolygonOptions polygonOptions = new PolygonOptions();
                polygonOptions.fillColor(i3);
                polygonOptions.visible(optBoolean);
                polygonOptions.strokeColor(i16);
                polygonOptions.strokeWidth(optDouble);
                if (optJSONArray2 != null) {
                    for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i17);
                        polygonOptions.add(new LatLng(optJSONObject2.optDouble("latitude", 0.0d), optJSONObject2.optDouble("longitude", 0.0d)));
                    }
                }
                TencentMap tencentMap = this.mTencentMap;
                if (tencentMap != null) {
                    this.curPolygon = tencentMap.addPolygon(polygonOptions);
                    return;
                }
                return;
            }
            Polygon polygon = this.curPolygon;
            if (polygon != null) {
                polygon.remove();
            }
        }
    }

    public void addMapPolyline(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int i3;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("lines")) != null) {
            ArrayList<Polyline> arrayList = this.polylineArrayList;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                for (int i16 = 0; i16 < i3; i16++) {
                    this.polylineArrayList.get(i16).remove();
                }
            }
            int length = optJSONArray.length();
            if (length > 0) {
                for (int i17 = 0; i17 < length; i17++) {
                    addPolyline(optJSONArray.optJSONObject(i17));
                }
            }
        }
    }

    public void destroy() {
        this.mTencentMap.removeOnMapLoadedCallback(this);
    }

    public LatLng getCenterLocation() {
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null && tencentMap.getCameraPosition() != null && this.mTencentMap.getCameraPosition().target != null) {
            return this.mTencentMap.getCameraPosition().target;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        return null;
    }

    public JSONObject getRegion() {
        JSONObject jSONObject = new JSONObject();
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null) {
            Projection projection = tencentMap.getProjection();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("longitude", projection.getVisibleRegion().latLngBounds.southwest.longitude);
                jSONObject2.put("latitude", projection.getVisibleRegion().latLngBounds.southwest.latitude);
                jSONObject.put("southwest", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("longitude", projection.getVisibleRegion().latLngBounds.northeast.longitude);
                jSONObject3.put("latitude", projection.getVisibleRegion().latLngBounds.northeast.latitude);
                jSONObject.put("northeast", jSONObject3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject;
    }

    public float getRotate() {
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null && tencentMap.getCameraPosition() != null) {
            return this.mTencentMap.getCameraPosition().bearing;
        }
        return DEFAULT_ROTATE;
    }

    public float getScale() {
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null && tencentMap.getCameraPosition() != null) {
            return (int) this.mTencentMap.getCameraPosition().zoom;
        }
        return DEFAULT_SCALE;
    }

    public float getSkew() {
        TencentMap tencentMap = this.mTencentMap;
        if (tencentMap != null && tencentMap.getCameraPosition() != null) {
            return this.mTencentMap.getCameraPosition().tilt;
        }
        return DEFAULT_SKEW;
    }

    public void includeMapPoints(JSONObject jSONObject) {
        int i3;
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("points");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("padding");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            double[] dArr = new double[optJSONArray.length()];
            double[] dArr2 = new double[optJSONArray.length()];
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble("latitude", 0.0d);
                    double optDouble2 = optJSONObject.optDouble("longitude", 0.0d);
                    dArr[i16] = optDouble;
                    dArr2[i16] = optDouble2;
                }
            }
            Arrays.sort(dArr);
            Arrays.sort(dArr2);
            double d16 = dArr[0];
            double d17 = dArr2[0];
            double d18 = dArr[optJSONArray.length() - 1];
            double d19 = dArr2[optJSONArray.length() - 1];
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "includeMapPoints leftTopLatitude=" + d16 + ",leftTopLongitude=" + d17 + ",rightBottomLatitude=" + d18 + ",rightBottomLongitude=" + d19);
            }
            LatLng latLng = new LatLng(d16, d17);
            LatLng latLng2 = new LatLng(d18, d19);
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                i3 = optJSONArray2.optInt(0, 0);
            } else {
                i3 = 0;
            }
            TencentMap tencentMap = this.mTencentMap;
            if (tencentMap != null) {
                this.showCurrentLocationStatus = false;
                tencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(latLng, latLng2), i3));
                this.curLatLng = this.mTencentMap.getCameraPosition().target;
            }
        }
    }

    public void moveToCurrentLocation() {
        this.showCurrentLocationStatus = true;
        location();
    }

    public void moveToLocation(JSONObject jSONObject) {
        this.showCurrentLocationStatus = false;
        if (jSONObject.has("longitude")) {
            double optDouble = jSONObject.optDouble("longitude", 0.0d);
            if (optDouble != 0.0d) {
                this.curLatLng.setLongitude(optDouble);
            }
        }
        if (jSONObject.has("latitude")) {
            double optDouble2 = jSONObject.optDouble("latitude", 0.0d);
            if (optDouble2 != 0.0d) {
                this.curLatLng.setLatitude(optDouble2);
            }
        }
        this.mTencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(this.curLatLng, this.curScale, this.curSkew, this.curRotate)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.mMapId);
            jSONObject.put("type", "begin");
            this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_REGION_CHANGE, jSONObject.toString(), this.mPageWebViewId));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public void onCameraChangeFinished(CameraPosition cameraPosition) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.mMapId);
            jSONObject.put("type", "end");
            this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_REGION_CHANGE, jSONObject.toString(), this.mPageWebViewId));
            this.curLatLng = cameraPosition.target;
            this.curScale = cameraPosition.zoom;
            this.curSkew = cameraPosition.tilt;
            this.curRotate = cameraPosition.bearing;
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        try {
            String optString = ((JSONObject) marker.getTag()).optString("data");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", optString);
            this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_CALLOUT_CLICK, jSONObject.toString(), this.mPageWebViewId));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        int size = this.markerSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            Marker valueAt = this.markerSparseArray.valueAt(i3);
            if (valueAt != null && valueAt.isInfoWindowShown()) {
                valueAt.hideInfoWindow();
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mapId", this.mMapId);
            jSONObject.put("latitude", latLng.latitude);
            jSONObject.put("longitude", latLng.longitude);
            this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_CLICK, jSONObject.toString(), this.mPageWebViewId));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
    public void onMapLoaded() {
        QMLog.d(TAG, "onMapLoaded");
        this.mCoverMapView.setLoadMapState(true);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (marker == null) {
            return false;
        }
        try {
            if (!marker.isInfoWindowShown()) {
                marker.showInfoWindow();
            }
            JSONObject jSONObject = (JSONObject) marker.getTag();
            if (jSONObject != null) {
                String optString = jSONObject.optString("data");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", optString);
                this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_MARKER_CLICK, jSONObject2.toString(), this.mPageWebViewId));
                return true;
            }
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return true;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float round = Math.round(sensorEvent.values[0] * 100.0f) / 100.0f;
        this.rotateDegree = round;
        Marker marker = this.locationMarker;
        if (marker != null) {
            marker.setRotation(round);
        }
    }

    public void removeMapMarkers(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("markers")) != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int optInt = optJSONArray.optInt(i3);
                Marker marker = this.markerSparseArray.get(optInt);
                if (marker != null) {
                    marker.remove();
                    this.markerSparseArray.remove(optInt);
                }
            }
        }
    }

    public void translateMapMarker(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        Marker marker = this.markerSparseArray.get(jSONObject.optInt("markerId"));
        if (marker != null && (optJSONArray = jSONObject.optJSONArray("keyFrames")) != null && optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            marker.setPosition(new LatLng(optJSONObject.optDouble("latitude", 0.0d), optJSONObject.optDouble("longitude", 0.0d)));
        }
    }

    public void updateMap(JSONObject jSONObject) {
        double d16;
        double d17;
        if (jSONObject == null) {
            QMLog.e(TAG, "updateMap jsonObject is null, return.");
            return;
        }
        try {
            if (jSONObject.has("position")) {
                updateMapViewPosition(jSONObject.optJSONObject("position"));
            }
            if (jSONObject.has("centerLongitude")) {
                d16 = jSONObject.optDouble("centerLongitude", 0.0d);
            } else {
                d16 = 0.0d;
            }
            if (jSONObject.has("centerLatitude")) {
                d17 = jSONObject.optDouble("centerLatitude", 0.0d);
            } else {
                d17 = 0.0d;
            }
            if (d17 != 0.0d || d16 != 0.0d) {
                this.curLatLng = new LatLng(d17, d16);
            }
            setScale(jSONObject);
            addMapMarkers(jSONObject);
            addMapCovers(jSONObject);
            addMapPolyline(jSONObject);
            addMapCircles(jSONObject);
            addMapControls(jSONObject);
            addMapPolygons(jSONObject);
            setRotate(jSONObject);
            setSkew(jSONObject);
            setLocationStatus(jSONObject, d17, d16);
            setShowCompass(jSONObject);
            updateOtherParams(jSONObject);
        } catch (Throwable th5) {
            QMLog.e(TAG, "updateMap error,", th5);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public void onInfoWindowClickLocation(int i3, int i16, int i17, int i18) {
    }
}
