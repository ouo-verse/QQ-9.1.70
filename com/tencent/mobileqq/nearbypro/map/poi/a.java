package com.tencent.mobileqq.nearbypro.map.poi;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends com.tencent.biz.subscribe.part.a {
    private Marker D;

    /* renamed from: m, reason: collision with root package name */
    protected TencentMap f253566m;
    protected String C = "";
    boolean E = false;
    private MutableLiveData<LatLng> F = new MutableLiveData<>();
    private MutableLiveData<Integer> G = new MutableLiveData<>(270);
    private MutableLiveData<Boolean> H = new MutableLiveData<>(new Boolean(true));
    private MutableLiveData<Integer> I = new MutableLiveData<>();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearbypro.map.poi.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class C8151a implements TencentMap.OnMarkerClickListener {
        C8151a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            return true;
        }
    }

    public void N1() {
        if (this.f253566m == null || this.F.getValue() == null) {
            return;
        }
        this.f253566m.animateCamera(CameraUpdateFactory.newLatLng(this.F.getValue()));
    }

    public void O1(LatLng latLng) {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap == null || latLng == null) {
            return;
        }
        tencentMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    public void P1() {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap == null) {
            QLog.i(getLogTag(), 1, "setTencentMapListeners tencentMap is null");
        } else {
            tencentMap.setOnCameraChangeListener(null);
        }
    }

    public String Q1(LatLng latLng) {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap != null && latLng != null) {
            return tencentMap.getCityName(latLng);
        }
        return "";
    }

    public LatLng R1() {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap != null) {
            return tencentMap.getCameraPosition().target;
        }
        return null;
    }

    public MutableLiveData<Boolean> T1() {
        return this.H;
    }

    public MutableLiveData<Integer> U1() {
        return this.I;
    }

    public MutableLiveData<Integer> W1() {
        return this.G;
    }

    public MutableLiveData<LatLng> X1() {
        if (this.F == null) {
            this.F = new MutableLiveData<>();
        }
        return this.F;
    }

    public void Z1(LatLng latLng) {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap == null || latLng == null) {
            return;
        }
        tencentMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    public boolean b2() {
        if (this.F.getValue() == null) {
            QLog.i(getLogTag(), 1, "refreshMarker curLatLng is null");
            return false;
        }
        if (this.D == null || (this.F.getValue().getLatitude() == this.D.getPosition().getLatitude() && this.F.getValue().getLongitude() == this.D.getPosition().getLongitude())) {
            return false;
        }
        this.D.setPosition(this.F.getValue());
        this.D.setSnippet("");
        this.D.showInfoWindow();
        return true;
    }

    public void c2(boolean z16) {
        this.H.setValue(Boolean.valueOf(z16));
    }

    public void d2(int i3) {
        this.G.setValue(Integer.valueOf(i3));
    }

    public void f2(TencentMap.OnCameraChangeListener onCameraChangeListener, TencentMap.OnMapClickListener onMapClickListener, TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        TencentMap tencentMap = this.f253566m;
        if (tencentMap == null) {
            QLog.i(getLogTag(), 1, "setTencentMapListeners tencentMap is null");
            return;
        }
        if (onCameraChangeListener != null) {
            tencentMap.setOnCameraChangeListener(onCameraChangeListener);
        } else {
            QLog.i(getLogTag(), 1, "setTencentMapListeners onCameraChangeListener is null");
        }
        if (onMapClickListener != null) {
            this.f253566m.setOnMapClickListener(onMapClickListener);
        } else {
            QLog.i(getLogTag(), 1, "setTencentMapListeners onMapClickListener is null");
        }
        if (onMapPoiClickListener != null) {
            this.f253566m.setOnMapPoiClickListener(onMapPoiClickListener);
        } else {
            QLog.i(getLogTag(), 1, "setTencentMapListeners onMapPoiClickListener is null");
        }
    }

    public String getLogTag() {
        return "MapViewModel";
    }

    public void L1() {
        TencentMap tencentMap;
        if (!ThemeUtil.isNowThemeIsNight(null, false, null) || (tencentMap = this.f253566m) == null) {
            return;
        }
        tencentMap.setMapType(1008);
    }

    public void M1(View view) {
        if (view == null) {
            QLog.i(getLogTag(), 1, "addMarker selfFixedPopView is null");
            return;
        }
        TencentMap tencentMap = this.f253566m;
        if (tencentMap != null && tencentMap.getProjection() != null) {
            if (this.D == null) {
                Marker addMarker = this.f253566m.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(view)).position(X1().getValue()).snippet(""));
                this.D = addMarker;
                addMarker.showInfoWindow();
                return;
            }
            return;
        }
        QLog.i(getLogTag(), 1, "addMarker tencentMap is null || tencentMap.getProjection() is null");
    }

    public void a2(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        if (!this.E && S1(this.F.getValue(), latLng) <= 2.0d) {
            this.E = true;
            this.I.postValue(0);
        } else {
            if (!this.E || S1(this.F.getValue(), latLng) <= 2.0d) {
                return;
            }
            this.E = false;
            this.I.postValue(1);
        }
    }

    public void e2(TencentMap tencentMap) {
        if (tencentMap == null) {
            QLog.i(getLogTag(), 1, "setTencentMap tencentMap is null");
            return;
        }
        this.f253566m = tencentMap;
        tencentMap.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
        tencentMap.setOnMarkerClickListener(new C8151a());
        tencentMap.getUiSettings().setGestureScaleByMapCenter(true);
        tencentMap.getUiSettings().setRotateGesturesEnabled(false);
    }

    public static double S1(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0d;
        }
        return TencentLocationUtils.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }
}
