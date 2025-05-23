package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.object.param.DrivingParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.TransitParam;
import com.tencent.lbssearch.object.param.WalkingParam;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.ILiuHaiUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.az;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MapWidget extends QTextureMapView {
    static IPatchRedirector $redirector_;
    private j C;
    private CameraPosition D;
    private Marker E;
    private final Map<String, Marker> F;
    protected Map<String, Marker> G;
    private volatile boolean H;
    private LocationShareLocationManager.d I;
    protected int J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Activity> f241514d;

    /* renamed from: e, reason: collision with root package name */
    protected LocationRoom f241515e;

    /* renamed from: f, reason: collision with root package name */
    private View f241516f;

    /* renamed from: h, reason: collision with root package name */
    protected TencentMap f241517h;

    /* renamed from: i, reason: collision with root package name */
    private LocationRoom.Venue f241518i;

    /* renamed from: m, reason: collision with root package name */
    protected Polyline f241519m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements TencentMap.OnMapLoadedCallback {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.location.ui.MapWidget$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        class ViewTreeObserverOnGlobalLayoutListenerC7978a implements ViewTreeObserver.OnGlobalLayoutListener {
            static IPatchRedirector $redirector_;

            ViewTreeObserverOnGlobalLayoutListenerC7978a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                MapWidget.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                CameraPosition cameraPosition = MapWidget.this.f241517h.getCameraPosition();
                if (cameraPosition != null) {
                    MapWidget.this.C.c(cameraPosition.target);
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
        public void onMapLoaded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.location.data.a j3 = MapWidget.this.f241515e.j();
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][init]onMapLoaded invoked. selfItem: ", j3.b());
            }
            if (j3.b() != null && !MapUtils.j(MapWidget.this.getContext(), MapWidget.this.f241517h, j3.b())) {
                MapWidget.this.p(false);
                MapWidget.this.setTag(Integer.MIN_VALUE, null);
                if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][init]onMapLoaded invoked. success moveMapToSelfCenter selfItem: ", j3.b());
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][init]onMapLoaded invoked. failed moveMapToSelfCenter selfItem: ", j3.b());
            }
            if (MapWidget.this.C != null) {
                if (MapWidget.this.f241517h.getCameraPosition() == null) {
                    MapWidget.this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC7978a());
                } else {
                    MapWidget.this.C.c(MapWidget.this.f241517h.getCameraPosition().target);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements TencentMapGestureListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f241522a;

        /* renamed from: b, reason: collision with root package name */
        private volatile boolean f241523b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            } else {
                this.f241522a = false;
                this.f241523b = false;
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onDoubleTap(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onDown(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            this.f241523b = true;
            if (MapWidget.this.C != null) {
                MapWidget.this.C.a(false, new Point(Math.round(f16), Math.round(f17)));
            }
            return false;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onFling(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onLongPress(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public void onMapStable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            if (this.f241523b && MapWidget.this.C != null) {
                MapWidget.this.C.c(MapWidget.this.f241517h.getCameraPosition().target);
            }
            this.f241523b = false;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onScroll(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            this.f241522a = true;
            return false;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onSingleTap(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
        public boolean onUp(float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if (this.f241522a) {
                ReportController.o(null, "CliOper", "", "", "0X800A772", "0X800A772", 0, 0, "", "0", "0", "");
                this.f241522a = false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements TencentMap.OnMapClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener
        public void onMapClick(LatLng latLng) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
            } else {
                MapWidget.this.f241517h.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                MapWidget.this.C.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements TencentMap.OnMapPoiClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener
        public void onClicked(MapPoi mapPoi) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) mapPoi);
            } else {
                MapWidget.this.f241517h.animateCamera(CameraUpdateFactory.newLatLng(mapPoi.position));
                MapWidget.this.C.d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LocationRoom.Venue f241527d;

        e(LocationRoom.Venue venue) {
            this.f241527d = venue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this, (Object) venue);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            MapWidget.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (this.f241527d != null) {
                MapWidget.this.L();
            } else {
                MapWidget.this.q(true, Float.valueOf(15.0f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class f implements HttpResponseListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f241529a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f241530b;

        f(int i3, k kVar) {
            this.f241529a = i3;
            this.f241530b = kVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MapWidget.this, Integer.valueOf(i3), kVar);
            }
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onFailure(int i3, String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, th5);
                return;
            }
            if (QLog.isColorLevel()) {
                if (th5 != null) {
                    th5.printStackTrace();
                }
                QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onFailure invoked. error code: " + i3 + " msg: " + str);
            }
            if (MapWidget.this.C != null) {
                MapWidget.this.C.f(false, this.f241530b);
            }
        }

        @Override // com.tencent.map.tools.net.http.HttpResponseListener
        public void onSuccess(int i3, Object obj) {
            List<DrivingResultObject.Route> list;
            int parseColor;
            List<TransitResultObject.Route> list2;
            TransitResultObject.Transit transit;
            List<TransitResultObject.Line> list3;
            WalkingResultObject.Result result;
            List<WalkingResultObject.Route> list4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, obj);
                return;
            }
            int i16 = this.f241529a;
            boolean z16 = true;
            List<LatLng> list5 = null;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        WalkingResultObject walkingResultObject = (WalkingResultObject) obj;
                        if (walkingResultObject != null && (result = walkingResultObject.result) != null && (list4 = result.routes) != null && !list4.isEmpty()) {
                            WalkingResultObject.Route route = walkingResultObject.result.routes.get(0);
                            k kVar = this.f241530b;
                            kVar.f241537b = route.duration;
                            kVar.f241538c = route.distance;
                            list5 = route.polyline;
                        } else if (QLog.isColorLevel()) {
                            QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_WALK");
                        }
                    }
                } else {
                    TransitResultObject transitResultObject = (TransitResultObject) obj;
                    TransitResultObject.Result result2 = transitResultObject.result;
                    if (result2 != null && (list2 = result2.routes) != null && !list2.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        TransitResultObject.Route route2 = transitResultObject.result.routes.get(0);
                        for (TransitResultObject.Segment segment : route2.steps) {
                            if (segment instanceof TransitResultObject.Walking) {
                                arrayList.addAll(((TransitResultObject.Walking) segment).polyline);
                            } else if ((segment instanceof TransitResultObject.Transit) && (list3 = (transit = (TransitResultObject.Transit) segment).lines) != null && !list3.isEmpty()) {
                                arrayList.addAll(transit.lines.get(0).polyline);
                            }
                        }
                        k kVar2 = this.f241530b;
                        kVar2.f241537b = (float) route2.duration;
                        kVar2.f241538c = route2.distance;
                        if (!arrayList.isEmpty()) {
                            list5 = arrayList;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_BUS");
                    }
                }
            } else {
                DrivingResultObject drivingResultObject = (DrivingResultObject) obj;
                DrivingResultObject.Result result3 = drivingResultObject.result;
                if (result3 != null && (list = result3.routes) != null && !list.isEmpty()) {
                    DrivingResultObject.Route route3 = drivingResultObject.result.routes.get(0);
                    k kVar3 = this.f241530b;
                    kVar3.f241537b = route3.duration;
                    kVar3.f241538c = route3.distance;
                    list5 = route3.polyline;
                } else if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error ROUTE_TYPE_DRIVE");
                }
            }
            if (list5 != null) {
                MapWidget mapWidget = MapWidget.this;
                if (mapWidget.f241519m != null) {
                    mapWidget.v(false);
                }
                if (az.f()) {
                    parseColor = Color.parseColor("#0071FF");
                } else {
                    parseColor = Color.parseColor("#4D94FF");
                }
                MapWidget mapWidget2 = MapWidget.this;
                mapWidget2.f241519m = mapWidget2.f241517h.addPolyline(new PolylineOptions().addAll(list5).color(parseColor).width(x.c(MapWidget.this.getContext(), 5.0f)));
                MapWidget mapWidget3 = MapWidget.this;
                if (mapWidget3.f241519m != null) {
                    mapWidget3.t();
                    MapWidget mapWidget4 = MapWidget.this;
                    if (mapWidget4.J == 0) {
                        mapWidget4.K();
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][venue][route]getRoutePlan onSuccess invoked. error polyline: null");
            }
            if (MapWidget.this.C != null) {
                j jVar = MapWidget.this.C;
                if (list5 == null || MapWidget.this.f241519m == null) {
                    z16 = false;
                }
                jVar.f(z16, this.f241530b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f241532d;

        g(ViewTreeObserver viewTreeObserver) {
            this.f241532d = viewTreeObserver;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this, (Object) viewTreeObserver);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f241532d.removeGlobalOnLayoutListener(this);
            MapWidget mapWidget = MapWidget.this;
            Polyline polyline = mapWidget.f241519m;
            if (polyline != null) {
                mapWidget.J(polyline.getPoints());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class h implements LocationShareLocationManager.d {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            }
        }

        @Override // com.tencent.mobileqq.location.net.LocationShareLocationManager.d
        public void a(LatLng latLng, Double d16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, latLng, d16, Boolean.valueOf(z16));
            } else {
                MapWidget.this.G(latLng, d16, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class i implements LocationRoom.a {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MapWidget.this);
            }
        }

        @Override // com.tencent.mobileqq.location.data.LocationRoom.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            Polyline polyline = MapWidget.this.f241519m;
            if (polyline != null) {
                polyline.remove();
            }
            if (MapWidget.this.C != null) {
                MapWidget.this.C.e(null);
            }
        }

        @Override // com.tencent.mobileqq.location.data.LocationRoom.a
        public void b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            Marker marker = (Marker) MapWidget.this.F.get(str);
            if (marker != null) {
                marker.remove();
                MapWidget.this.F.remove(str);
            }
            Marker marker2 = MapWidget.this.G.get(str);
            if (marker2 != null) {
                marker2.remove();
                MapWidget.this.G.remove(str);
            }
        }

        @Override // com.tencent.mobileqq.location.data.LocationRoom.a
        public void c(LocationRoom.Venue venue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) venue);
                return;
            }
            Marker addMarker = MapWidget.this.f241517h.addMarker(new MarkerOptions(venue.f241273i).anchor(0.5f, 0.8f).zIndex(2.14748365E9f).icon(BitmapDescriptorFactory.fromResource(R.drawable.location_venue_marker)));
            if (addMarker != null) {
                venue.f241269d = new SoftReference<>(addMarker);
                MapWidget.this.E = addMarker;
                addMarker.setClickable(false);
                addMarker.refreshInfoWindow();
            }
            if (MapWidget.this.C != null) {
                MapWidget.this.C.e(venue);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][venue]onNewVenue invoked. Result venue: ", venue);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface j {
        void a(boolean z16, Point point);

        void b(LatLng latLng, float f16, List<String> list);

        void c(LatLng latLng);

        void d();

        void e(LocationRoom.Venue venue);

        void f(boolean z16, k kVar);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class k {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Integer f241536a;

        /* renamed from: b, reason: collision with root package name */
        float f241537b;

        /* renamed from: c, reason: collision with root package name */
        float f241538c;

        public k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public MapWidget(Context context) {
        this(context, (TencentMapOptions) null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            return;
        }
        iPatchRedirector.redirect((short) 26, (Object) this, (Object) context);
    }

    private void A() {
        LocationRoom.Venue l3 = this.f241515e.l();
        if (l3 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][venue]resetVenue invoked. venue: " + l3 + " mVenueMarker: " + this.E);
            }
            if (this.E != null) {
                this.f241515e.l().f241269d = new SoftReference<>(this.E);
            } else {
                this.f241515e.l().f241269d = null;
            }
            this.f241515e.t(l3);
        }
    }

    private void D(com.tencent.mobileqq.location.data.a aVar, Marker marker, boolean z16) {
        marker.setZIndex(aVar.e());
        marker.setPosition(aVar.b());
        marker.setClickable(false);
        if (z16) {
            marker.setRotation((float) aVar.c());
        }
        marker.refreshInfoWindow();
    }

    private void E() {
        List<com.tencent.mobileqq.location.data.a> e16 = this.f241515e.e();
        Iterator<com.tencent.mobileqq.location.data.a> it = e16.iterator();
        while (it.hasNext()) {
            F(it.next());
        }
        if (e16.size() == this.F.size()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<com.tencent.mobileqq.location.data.a> it5 = e16.iterator();
        while (it5.hasNext()) {
            hashSet.add(it5.next().d());
        }
        Iterator<Map.Entry<String, Marker>> it6 = this.F.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry<String, Marker> next = it6.next();
            String key = next.getKey();
            if (!hashSet.contains(key)) {
                Marker value = next.getValue();
                if (value != null) {
                    value.remove();
                }
                it6.remove();
                Marker marker = this.G.get(key);
                if (marker != null) {
                    marker.remove();
                    this.G.remove(key);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(List<LatLng> list) {
        int i3;
        if (list != null && !list.isEmpty()) {
            View view = this.f241516f;
            if (view != null) {
                if (view instanceof PoiSlideBottomPanel) {
                    i3 = ((PoiSlideBottomPanel) view).e();
                } else {
                    i3 = view.getHeight();
                }
            } else {
                i3 = 0;
            }
            int c16 = x.c(getContext(), 60.0f);
            int i16 = c16 / 2;
            int c17 = x.c(getContext(), 102.0f) + ((ILiuHaiUtilsApi) QRoute.api(ILiuHaiUtilsApi.class)).getNotchHeight() + c16 + i16;
            int i17 = i3 + i16;
            CameraPosition calculateZoomToSpanLevel = this.f241517h.calculateZoomToSpanLevel(null, list, c16, c16, c17, i17);
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][init]zoomMapToShowAll invoked. mBottomContainer: " + this.f241516f + " paddingTop: " + c17 + " paddingBottom: " + i17 + " cameraPosition: ", calculateZoomToSpanLevel);
            }
            if (calculateZoomToSpanLevel != null) {
                this.f241517h.animateCamera(CameraUpdateFactory.newCameraPosition(calculateZoomToSpanLevel));
                if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][init]zoomMapToShowAll invoked. target: ", calculateZoomToSpanLevel.target + " zoom: " + calculateZoomToSpanLevel.zoom);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        View view = this.f241516f;
        if (view != null && view.getHeight() == 0) {
            ViewTreeObserver viewTreeObserver = this.f241516f.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new g(viewTreeObserver));
        } else {
            J(this.f241519m.getPoints());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        J(this.f241515e.h());
    }

    private void h(View view) {
        if (this.J == 0) {
            ((ImageView) view.findViewById(R.id.f167074kh0)).setVisibility(8);
        }
    }

    private List<String> j() {
        ArrayList arrayList = new ArrayList(30);
        for (com.tencent.mobileqq.location.data.a aVar : this.f241515e.e()) {
            if (!this.G.containsKey(aVar.d())) {
                arrayList.add(aVar.d());
            }
        }
        return arrayList;
    }

    private boolean n(LatLng latLng) {
        LatLng b16 = this.f241515e.j().b();
        if (b16 == null || latLng == null || Math.abs(latLng.altitude - b16.altitude) > 5.0E-6d || Math.abs(latLng.latitude - b16.latitude) > 5.0E-6d || Math.abs(latLng.longitude - b16.longitude) > 5.0E-6d) {
            return false;
        }
        return true;
    }

    private void s(com.tencent.mobileqq.location.data.a aVar) {
        Marker addMarker = this.f241517h.addMarker(new MarkerOptions(aVar.b()));
        if (addMarker != null) {
            this.F.put(aVar.d(), addMarker);
            if (aVar.equals(this.f241515e.j())) {
                addMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.f160913ho2));
            } else {
                addMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.f160912ho1));
            }
            addMarker.setTag(aVar.d());
            D(aVar, addMarker, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, "[map][new]onNewLabelMarker invoked. Result LocationItem: ", aVar);
        }
    }

    private void w() {
        z(this.G);
    }

    private void x() {
        z(this.F);
    }

    private void z(Map<String, Marker> map) {
        List<String> k3 = this.f241515e.k();
        Iterator<Map.Entry<String, Marker>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Marker> next = it.next();
            String key = next.getKey();
            Marker value = next.getValue();
            if (!k3.contains(key)) {
                value.remove();
                it.remove();
            }
        }
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            if (this.f241514d.get() == null) {
                return;
            }
            LocationDialogUtil.i(this.f241514d.get(), str, AccessibleTouchItem.MY_LOCATION_PREFIX, this.f241515e.l().f241271f, this.f241515e.j().b(), this.f241515e.l().f241273i);
        }
    }

    public Integer C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3);
        }
        v(false);
        LocationRoom locationRoom = this.f241515e;
        RoutePlanningParam routePlanningParam = null;
        if (locationRoom != null && locationRoom.j() != null && this.f241515e.l() != null) {
            LatLng b16 = this.f241515e.j().b();
            LatLng latLng = this.f241515e.l().f241273i;
            if (b16 != null && latLng != null) {
                if (i3 == 0) {
                    if (MapUtils.f(b16, latLng) < 2000.0d) {
                        i3 = 3;
                    } else {
                        i3 = 1;
                    }
                }
                k kVar = new k();
                kVar.f241536a = Integer.valueOf(i3);
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            routePlanningParam = new WalkingParam();
                        }
                    } else {
                        routePlanningParam = new TransitParam();
                    }
                } else {
                    routePlanningParam = new DrivingParam();
                }
                this.f241515e.s(i3);
                if (routePlanningParam != null) {
                    new TencentSearch(getContext()).getRoutePlan(routePlanningParam.from(b16).to(latLng), new f(i3, kVar));
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error RoutePlanningParam: null");
                    }
                    j jVar = this.C;
                    if (jVar != null) {
                        jVar.f(false, kVar);
                    }
                }
                return Integer.valueOf(i3);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error locationSelf: " + b16 + " locationVenue: " + latLng);
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MapWidget", 2, "[map][venue][route]showRouteToVenue invoked. error mLocationRoom: " + this.f241515e);
        }
        return null;
    }

    protected void F(com.tencent.mobileqq.location.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
            return;
        }
        Marker marker = this.F.get(aVar.d());
        if (marker != null) {
            D(aVar, marker, true);
        } else {
            s(aVar);
        }
        Marker marker2 = this.G.get(aVar.d());
        if (marker2 != null) {
            D(aVar, marker2, false);
        }
    }

    protected void G(LatLng latLng, Double d16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, latLng, d16, Boolean.valueOf(z16));
            return;
        }
        if (!this.f241517h.isDestroyed() && latLng != null) {
            com.tencent.mobileqq.location.data.a j3 = this.f241515e.j();
            Marker marker = this.F.get(j3.d());
            if (this.D == null && marker == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][init]updateSelfLocation invoked. moveMapToSelfCenter: ", latLng);
                }
                this.f241515e.q(true);
            }
            List<String> list = null;
            if (((Boolean) getTag(Integer.MIN_VALUE)) != null && !MapUtils.j(getContext(), this.f241517h, latLng)) {
                p(false);
                setTag(Integer.MIN_VALUE, null);
                if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][init]updateSelfLocation invoked. success moveMapToSelfCenter selfItem: ", j3.b());
                }
            }
            this.f241515e.v(latLng, d16);
            if (z16) {
                F(j3);
            } else if (marker != null) {
                D(j3, marker, true);
            }
            if (this.C != null && marker != null) {
                if (z16) {
                    list = j();
                }
                this.C.b(marker.getPosition(), marker.getRotation(), list);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][location]updateSelfLocation invoked. update self LocationItem: ", j3);
            }
        }
    }

    public void H(String str, Bitmap bitmap) {
        LocationRoom locationRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) bitmap);
            return;
        }
        if (!this.f241517h.isDestroyed() && QBaseActivity.sTopActivity == this.f241514d.get() && (locationRoom = this.f241515e) != null) {
            com.tencent.mobileqq.location.data.a d16 = locationRoom.d(str);
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][head]updateUserHead invoked. ", "LocationItem = [" + d16 + "], uin = [" + str + "]");
            }
            if (d16 != null) {
                View inflate = View.inflate(getContext(), R.layout.c8u, null);
                h(inflate);
                ((QQProAvatarView) inflate.findViewById(R.id.lrb)).x(1, str, null);
                Marker marker = this.G.get(str);
                if (marker != null) {
                    marker.setIcon(BitmapDescriptorFactory.fromView(inflate));
                } else {
                    marker = this.f241517h.addMarker(new MarkerOptions(d16.b()).anchor(0.5f, 1.1f).icon(BitmapDescriptorFactory.fromView(inflate)));
                    marker.setTag(str);
                }
                D(d16, marker, false);
                this.G.put(str, marker);
            }
        }
    }

    protected void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            J(this.f241515e.c());
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f241515e.a(z16);
        }
    }

    public CameraPosition i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (CameraPosition) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f241517h.getCameraPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LatLng k() {
        return this.f241515e.j().b();
    }

    public LocationRoom.Venue l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LocationRoom.Venue) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f241515e.l();
    }

    public void m(Activity activity, LocationRoom locationRoom, CameraPosition cameraPosition, int i3, View view) {
        CameraPosition cameraPosition2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, locationRoom, cameraPosition, Integer.valueOf(i3), view);
            return;
        }
        this.f241515e = locationRoom;
        this.f241514d = new WeakReference<>(activity);
        this.f241516f = view;
        TencentMap map = getMap();
        this.f241517h = map;
        map.getUiSettings().setRotateGesturesEnabled(false);
        this.f241517h.getUiSettings().setLogoPositionWithMargin(3, i3, 0, x.c(BaseApplication.getContext(), 10.0f), 0);
        this.f241517h.getUiSettings().setScaleViewPositionWithMargin(0, 0, x.c(BaseApplication.getContext(), 17.0f), x.c(BaseApplication.getContext(), 62.0f), 0);
        this.f241517h.getUiSettings().setGestureScaleByMapCenter(true);
        this.f241517h.getUiSettings().setRotateGesturesEnabled(false);
        if (cameraPosition == null) {
            cameraPosition2 = this.f241515e.b();
        } else {
            cameraPosition2 = cameraPosition;
        }
        this.D = cameraPosition2;
        if (cameraPosition2 != null) {
            if (QLog.isColorLevel()) {
                try {
                    QLog.d("MapWidget", 2, "[map][init]init: invoked. ", " camera position cached: ", this.D);
                } catch (Throwable unused) {
                }
            }
            this.f241517h.moveCamera(CameraUpdateFactory.newCameraPosition(this.D));
        } else {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).initLocationManager();
            TencentLocation lastKnownLocation = TencentLocationManager.getInstance(getContext()).getLastKnownLocation();
            if (lastKnownLocation != null) {
                LatLng latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                if (QLog.isColorLevel()) {
                    QLog.d("MapWidget", 2, "[map][init]init: invoked. ", " location last known: ", latLng);
                }
                TencentMap tencentMap = this.f241517h;
                tencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, tencentMap.getCameraPosition().zoom)));
            }
        }
        setTag(Integer.MIN_VALUE, Boolean.TRUE);
        if (this.J == 0) {
            this.f241517h.setOnMapLoadedCallback(new a());
            this.f241517h.addTencentMapGestureListener(new b());
            this.f241517h.setOnMapClickListener(new c());
            this.f241517h.setOnMapPoiClickListener(new d());
            this.f241517h.getUiSettings().setGestureScaleByMapCenter(true);
            this.f241517h.getUiSettings().setRotateGesturesEnabled(false);
        }
    }

    public void o(LatLng latLng, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, latLng, Boolean.valueOf(z16));
            return;
        }
        if (!this.f241517h.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][marker]moveMapToLocation invoked. location: ", latLng);
            }
            CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, this.f241517h.getCameraPosition().zoom));
            if (z16) {
                this.f241517h.animateCamera(newCameraPosition);
            } else {
                this.f241517h.moveCamera(newCameraPosition);
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.onDestroy();
        this.f241514d = null;
        this.f241516f = null;
        MapUtils.b(this.f241517h);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.onPause();
        LocationShareLocationManager.h().k(this.I);
        this.f241515e.p(this.f241517h.getCameraPosition());
        if (this.f241519m == null) {
            this.f241515e.s(-1);
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.onResume();
        if (this.I == null) {
            this.I = new h();
        }
        LocationShareLocationManager.h().l(this.I);
        try {
            if (this.f241514d.get() != null) {
                LocationShareLocationManager.h().m(this.f241514d.get(), this.f241515e);
            }
        } catch (Throwable th5) {
            QLog.e("MapWidget", 1, "onResume: failed. ", th5);
        }
        this.f241515e.r(new i());
        A();
        if (this.f241515e.i() != -1) {
            C(this.f241515e.i());
        }
    }

    public void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            q(z16, null);
        }
    }

    protected void q(boolean z16, Float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), f16);
            return;
        }
        j jVar = this.C;
        if (jVar != null) {
            jVar.a(true, null);
        }
        com.tencent.mobileqq.location.data.a j3 = this.f241515e.j();
        j3.g(this.f241515e.m());
        if (!this.f241517h.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][init]moveMapToSelfCenter invoked. location: ", j3.b());
            }
            if (z16) {
                if (f16 == null) {
                    f16 = Float.valueOf(this.f241517h.getCameraPosition().zoom);
                }
                this.f241517h.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(j3.b(), f16.floatValue())));
            } else {
                if (f16 == null) {
                    f16 = Float.valueOf(15.0f);
                }
                this.f241517h.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(j3.b(), f16.floatValue())));
            }
        }
        F(j3);
    }

    public void r(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Boolean.valueOf(z16));
            return;
        }
        com.tencent.mobileqq.location.data.a d16 = this.f241515e.d(str);
        if (d16 == null) {
            return;
        }
        j jVar = this.C;
        if (jVar != null) {
            jVar.a(str.equals(this.f241515e.j().d()), null);
        }
        d16.g(this.f241515e.m());
        if (!this.f241517h.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.d("MapWidget", 2, "[map][init]moveMapToUserCenter invoked. uin: " + str + " location: ", d16.b());
            }
            if (z16) {
                this.f241517h.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(d16.b(), this.f241517h.getCameraPosition().zoom)));
            } else {
                this.f241517h.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(d16.b(), this.f241517h.getCameraPosition().zoom)));
            }
        }
        F(d16);
    }

    public void setListener(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) jVar);
            return;
        }
        this.C = jVar;
        if (jVar != null) {
            this.C.a(n(this.f241517h.getCameraPosition().target), null);
        }
    }

    public void setMapLogoVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            MapUtils.r(this.f241517h, i3);
        }
    }

    public void setVenue(LocationRoom.Venue venue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) venue);
        } else {
            this.f241515e.t(venue);
            getViewTreeObserver().addOnGlobalLayoutListener(new e(venue));
        }
    }

    public void setVenueOprating(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.H = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void u(LocationRoom.b bVar) {
        LocationRoom locationRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bVar);
            return;
        }
        if (!this.f241517h.isDestroyed() && this.f241514d.get() != null && !this.f241514d.get().isFinishing() && (locationRoom = this.f241515e) != null && locationRoom.o(bVar)) {
            E();
            if (this.f241515e.f()) {
                if (QLog.isColorLevel()) {
                    CameraPosition cameraPosition = this.f241517h.getCameraPosition();
                    QLog.d("MapWidget", 2, "[map][location]onUpdateUserLocations invoked. target: " + cameraPosition.target + " zoom: " + cameraPosition.zoom);
                }
                I();
                if (this.f241515e.k().contains(MobileQQ.sMobileQQ.peekAppRuntime().getAccount())) {
                    this.f241515e.q(false);
                }
            }
            if (!this.H) {
                return;
            }
            LocationRoom.Venue l3 = this.f241515e.l();
            j jVar = this.C;
            if (jVar != null) {
                LocationRoom.Venue venue = this.f241518i;
                if (venue == null && l3 != null) {
                    if (this.f241515e.i() == -1) {
                        this.C.e(l3);
                    }
                } else if (venue != null && l3 == null) {
                    jVar.e(null);
                    q(true, Float.valueOf(15.0f));
                } else if (venue != null && l3 != null && !venue.equals(l3) && this.f241515e.i() == -1) {
                    this.C.e(l3);
                }
            }
            this.f241518i = l3;
        }
    }

    public void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        Polyline polyline = this.f241519m;
        if (polyline != null) {
            polyline.remove();
            this.f241519m = null;
        }
        if (z16) {
            this.f241515e.s(-1);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        A();
        x();
        w();
        E();
    }

    public MapWidget(Context context, TencentMapOptions tencentMapOptions) {
        super(context.getApplicationContext(), tencentMapOptions);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) context, (Object) tencentMapOptions);
            return;
        }
        this.F = new HashMap(10);
        this.G = new HashMap(10);
        this.H = false;
        this.J = 0;
        this.K = 0;
    }

    public MapWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MapWidget(Context context, AttributeSet attributeSet, int i3) {
        super(context.getApplicationContext(), attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.F = new HashMap(10);
        this.G = new HashMap(10);
        this.H = false;
        this.J = 0;
        this.K = 0;
    }
}
