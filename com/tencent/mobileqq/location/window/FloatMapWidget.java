package com.tencent.mobileqq.location.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FloatMapWidget extends MapWidget {
    static IPatchRedirector $redirector_;
    private final Map<String, View> L;
    private int M;
    private LocationRoom.Venue N;
    private Marker P;
    private LocationRoom.Venue Q;
    private TencentMap.OnMapLoadedCallback R;
    private boolean S;
    private LatLng T;
    private Double U;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements TencentMap.OnMapLoadedCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FloatMapWidget.this);
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback
        public void onMapLoaded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.mobileqq.location.data.a j3 = ((MapWidget) FloatMapWidget.this).f241515e.j();
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "[map][init]onMapLoaded invoked. selfItem: ", j3.b());
            }
            if (j3.b() != null) {
                LocationRoom.Venue l3 = ((MapWidget) FloatMapWidget.this).f241515e.l();
                if (QLog.isColorLevel()) {
                    QLog.d("FloatMapWidget", 2, "onMapLoaded: invoked. ", " venue: ", l3);
                }
                if (((MapWidget) FloatMapWidget.this).f241515e.k().size() == 1 && l3 == null) {
                    FloatMapWidget.this.q(false, null);
                } else {
                    FloatMapWidget.this.I();
                }
            }
            FloatMapWidget.this.S = true;
            FloatMapWidget.this.R();
        }
    }

    public FloatMapWidget(Context context) {
        this(context, null, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        int i3 = this.f241515e.i();
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "drawMapRoute: invoked. ", " routeType: ", Integer.valueOf(i3));
        }
        v(false);
        if (i3 != -1) {
            C(i3);
        }
    }

    private void S() {
        View inflate = View.inflate(getContext(), R.layout.f167957lu, null);
        LocationRoom.Venue l3 = this.f241515e.l();
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "drawMapVenue: invoked. ", " venue: ", l3, " mLastDrawVenue: ", this.N);
        }
        this.N = l3;
        Marker marker = this.P;
        if (marker != null) {
            marker.remove();
        }
        if (l3 != null) {
            Marker addMarker = this.f241517h.addMarker(new MarkerOptions(l3.f241273i).anchor(0.5f, 0.8f).zIndex(2.14748365E9f).icon(BitmapDescriptorFactory.fromView(inflate)));
            this.P = addMarker;
            addMarker.refreshInfoWindow();
        }
    }

    @NotNull
    private View T(String str) {
        View view = this.L.get(str);
        if (view == null) {
            View inflate = View.inflate(getContext(), R.layout.f167956lt, null);
            this.L.put(str, inflate);
            return inflate;
        }
        return view;
    }

    private Marker U(com.tencent.mobileqq.location.data.a aVar, View view) {
        String d16 = aVar.d();
        Marker marker = this.G.get(d16);
        if (marker == null) {
            marker = this.f241517h.addMarker(new MarkerOptions(aVar.b()).icon(BitmapDescriptorFactory.fromView(view)));
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "findHeadMarker: invoked. ", " headMarker: ", marker, "isDestroyed: ", Boolean.valueOf(this.f241517h.isDestroyed()));
            }
        } else {
            marker.setIcon(BitmapDescriptorFactory.fromView(view));
        }
        marker.setTag(d16);
        this.G.put(d16, marker);
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 4, "dev: findHeadMarker: invoked. ", " item: ", aVar);
        }
        return marker;
    }

    private void W(com.tencent.mobileqq.location.data.a aVar, View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.ai_);
        if (aVar.d().equals(this.f241515e.j().d())) {
            imageView.setBackgroundResource(R.drawable.location_float_avatar_bg_blue);
        } else {
            imageView.setBackgroundResource(R.drawable.location_float_avatar_bg_orange);
        }
        imageView.setRotation((float) (aVar.c() + 315.0d));
    }

    @Override // com.tencent.mobileqq.location.ui.MapWidget
    protected void G(LatLng latLng, Double d16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, latLng, d16, Boolean.valueOf(z16));
            return;
        }
        boolean isDestroyed = this.f241517h.isDestroyed();
        QLog.isColorLevel();
        if (!isDestroyed && latLng != null) {
            if (latLng.equals(this.T) && d16 != null && Math.abs(d16.doubleValue() - this.U.doubleValue()) < 5.0d) {
                QLog.isColorLevel();
                return;
            }
            this.T = latLng;
            this.U = d16;
            com.tencent.mobileqq.location.data.a j3 = this.f241515e.j();
            this.f241515e.v(latLng, d16);
            View T = T(j3.d());
            W(j3, T);
            U(j3, T).refreshInfoWindow();
            QLog.isColorLevel();
        }
    }

    @Override // com.tencent.mobileqq.location.ui.MapWidget
    public void H(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bitmap);
            return;
        }
        boolean isDestroyed = this.f241517h.isDestroyed();
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "updateUserHead: invoked. ", " mapDestroyed: ", Boolean.valueOf(isDestroyed));
        }
        if (isDestroyed) {
            return;
        }
        com.tencent.mobileqq.location.data.a d16 = this.f241515e.d(str);
        int size = this.f241515e.k().size();
        if (this.M != size) {
            this.L.clear();
            this.G.clear();
            this.f241517h.clear();
            R();
            this.M = size;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "[map][head]updateUserHead invoked. ", "LocationItem = [" + d16 + "], uin = [" + str + "], avatar = [" + bitmap + "]");
        }
        if (d16 != null) {
            View T = T(str);
            ((RoundImageView) T.findViewById(R.id.aif)).setImageBitmap(bitmap);
            W(d16, T);
            Marker U = U(d16, T);
            if (str.equals(this.f241515e.j().d())) {
                if (QLog.isColorLevel()) {
                    QLog.d("FloatMapWidget", 2, "updateUserHead: invoked. no need refresh self. ", " uin: ", str);
                }
            } else {
                LatLng b16 = d16.b();
                if (b16 != null) {
                    U.setZIndex(d16.e());
                    U.setPosition(b16);
                }
            }
            U.refreshInfoWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.location.ui.MapWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void I() {
        List<LatLng> list;
        Throwable th5;
        List<LatLng> list2;
        CameraPosition calculateZoomToSpanLevel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        int c16 = x.c(getContext(), 16.0f);
        List<LatLng> c17 = this.f241515e.c();
        try {
            if (this.f241515e.i() != -1) {
                list = new ArrayList<>();
                try {
                    LatLng latLng = this.T;
                    if (latLng != null) {
                        list.add(latLng);
                    }
                    if (this.f241515e.l() != null) {
                        list.add(this.f241515e.l().f241273i);
                    }
                    c17 = list;
                } catch (Throwable th6) {
                    th5 = th6;
                    QLog.e("FloatMapWidget", 1, "zoomMapToShowAll: failed. ", th5);
                    list2 = list;
                    if (QLog.isColorLevel()) {
                    }
                    if (this.f241519m == null) {
                    }
                    if (this.f241519m == null) {
                        if (!QLog.isColorLevel()) {
                        }
                    }
                    calculateZoomToSpanLevel = this.f241517h.calculateZoomToSpanLevel(null, list2, c16, c16, c16, c16);
                    if (calculateZoomToSpanLevel == null) {
                    }
                }
            }
            list2 = c17;
        } catch (Throwable th7) {
            list = c17;
            th5 = th7;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "zoomMapToShowAll: invoked. ", " mPolyLine: ", this.f241519m);
        }
        if (this.f241519m == null && this.f241515e.i() != -1) {
            List<LatLng> points = this.f241519m.getPoints();
            if (points != null) {
                list2.addAll(points);
            }
        } else if (this.f241519m == null && this.f241515e.i() != -1) {
            if (!QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "zoomMapToShowAll: invoked. need wait route draw. ", " latLngs: ", list2);
                return;
            }
            return;
        }
        calculateZoomToSpanLevel = this.f241517h.calculateZoomToSpanLevel(null, list2, c16, c16, c16, c16);
        if (calculateZoomToSpanLevel == null) {
            this.f241517h.animateCamera(CameraUpdateFactory.newCameraPosition(calculateZoomToSpanLevel));
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "[map][init]zoomMapToShowAll invoked. target: ", calculateZoomToSpanLevel.target + " zoom: " + calculateZoomToSpanLevel.zoom);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FloatMapWidget", 2, "zoomMapToShowAll: invoked. check padding", " cameraPosition: ", calculateZoomToSpanLevel);
        }
    }

    public void V(LocationRoom.Venue venue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) venue);
        } else if (venue == null) {
            v(true);
        }
    }

    @Override // com.tencent.mobileqq.location.ui.MapWidget, com.tencent.tencentmap.mapsdk.maps.MapView, com.tencent.tencentmap.mapsdk.maps.BaseMapView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        setListener(null);
        LocationShareLocationManager.h().l(null);
        this.R = null;
        this.L.clear();
        this.f241519m = null;
    }

    @Override // com.tencent.mobileqq.location.ui.MapWidget
    protected void q(boolean z16, Float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), f16);
            return;
        }
        com.tencent.mobileqq.location.data.a j3 = this.f241515e.j();
        j3.g(this.f241515e.m());
        if (!this.f241517h.isDestroyed()) {
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "[float][map][init]moveMapToSelfCenter invoked. location: ", j3.b());
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
    }

    public void setOnMapLoadedCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        a aVar = new a();
        this.R = aVar;
        this.f241517h.setOnMapLoadedCallback(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.location.ui.MapWidget
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.t();
        if (this.S) {
            I();
        }
    }

    @Override // com.tencent.mobileqq.location.ui.MapWidget
    public void u(LocationRoom.b bVar) {
        CameraPosition cameraPosition;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        LocationRoom locationRoom = this.f241515e;
        if (locationRoom != null && locationRoom.o(bVar)) {
            LocationRoom.Venue l3 = this.f241515e.l();
            if (QLog.isColorLevel()) {
                QLog.d("FloatMapWidget", 2, "onUpdateUserLocations: invoked. ", " currentVenue: ", l3, " mLastDrawVenue: ", this.N);
            }
            if (this.Q != null && l3 == null) {
                V(l3);
            }
            this.Q = l3;
            this.f241515e.q(true);
            if (this.f241515e.f()) {
                if (QLog.isColorLevel() && (cameraPosition = this.f241517h.getCameraPosition()) != null) {
                    QLog.d("FloatMapWidget", 2, "[map][location]onUpdateUserLocations invoked.  zoom: " + cameraPosition.zoom);
                }
                this.f241515e.q(false);
                S();
                if (this.S) {
                    I();
                }
            }
        }
    }

    public FloatMapWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public FloatMapWidget(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.L = new HashMap();
        this.S = false;
        this.J = 1;
    }
}
