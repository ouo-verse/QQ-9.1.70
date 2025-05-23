package com.tencent.biz.map.poi;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
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
/* loaded from: classes2.dex */
public class b extends BaseViewModel {
    private Marker C;

    /* renamed from: i, reason: collision with root package name */
    protected TencentMap f78747i;

    /* renamed from: m, reason: collision with root package name */
    protected String f78748m = "";
    boolean D = false;
    private MutableLiveData<LatLng> E = new MutableLiveData<>();
    private MutableLiveData<Integer> F = new MutableLiveData<>(270);
    private MutableLiveData<Boolean> G = new MutableLiveData<>(new Boolean(true));
    private MutableLiveData<Integer> H = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements TencentMap.OnMarkerClickListener {
        a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            return true;
        }
    }

    public static double S1(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return TencentLocationUtils.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
        }
        return 0.0d;
    }

    public void L1() {
        TencentMap tencentMap;
        if (ThemeUtil.isNowThemeIsNight(null, false, null) && (tencentMap = this.f78747i) != null) {
            tencentMap.setMapType(1008);
        }
    }

    public void M1(View view) {
        if (view == null) {
            QLog.i(getTAG(), 1, "addMarker selfFixedPopView is null");
            return;
        }
        TencentMap tencentMap = this.f78747i;
        if (tencentMap != null && tencentMap.getProjection() != null) {
            if (this.C == null) {
                Marker addMarker = this.f78747i.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(view)).position(X1().getValue()).snippet(""));
                this.C = addMarker;
                addMarker.showInfoWindow();
                return;
            }
            return;
        }
        QLog.i(getTAG(), 1, "addMarker tencentMap is null || tencentMap.getProjection() is null");
    }

    public void N1() {
        if (this.f78747i != null && this.E.getValue() != null) {
            this.f78747i.animateCamera(CameraUpdateFactory.newLatLng(this.E.getValue()));
        }
    }

    public void O1(LatLng latLng) {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap != null && latLng != null) {
            tencentMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    public void P1() {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap == null) {
            QLog.i(getTAG(), 1, "setTencentMapListeners tencentMap is null");
        } else {
            tencentMap.setOnCameraChangeListener(null);
        }
    }

    public String Q1(LatLng latLng) {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap != null && latLng != null) {
            return tencentMap.getCityName(latLng);
        }
        return "";
    }

    public LatLng R1() {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap != null) {
            return tencentMap.getCameraPosition().target;
        }
        return null;
    }

    public MutableLiveData<Boolean> T1() {
        return this.G;
    }

    public MutableLiveData<Integer> U1() {
        return this.H;
    }

    public MutableLiveData<Integer> W1() {
        return this.F;
    }

    public MutableLiveData<LatLng> X1() {
        if (this.E == null) {
            this.E = new MutableLiveData<>();
        }
        return this.E;
    }

    public void Z1(LatLng latLng) {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap != null && latLng != null) {
            tencentMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }

    public void a2(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        if (!this.D && S1(this.E.getValue(), latLng) <= 2.0d) {
            this.D = true;
            this.H.postValue(0);
        } else if (this.D && S1(this.E.getValue(), latLng) > 2.0d) {
            this.D = false;
            this.H.postValue(1);
        }
    }

    public boolean b2() {
        if (this.E.getValue() == null) {
            QLog.i(getTAG(), 1, "refreshMarker curLatLng is null");
            return false;
        }
        if (this.C == null || (this.E.getValue().getLatitude() == this.C.getPosition().getLatitude() && this.E.getValue().getLongitude() == this.C.getPosition().getLongitude())) {
            return false;
        }
        this.C.setPosition(this.E.getValue());
        this.C.setSnippet("");
        this.C.showInfoWindow();
        return true;
    }

    public void c2(boolean z16) {
        this.G.setValue(Boolean.valueOf(z16));
    }

    public void d2(int i3) {
        this.F.setValue(Integer.valueOf(i3));
    }

    public void e2(TencentMap tencentMap) {
        if (tencentMap == null) {
            QLog.i(getTAG(), 1, "setTencentMap tencentMap is null");
            return;
        }
        this.f78747i = tencentMap;
        tencentMap.moveCamera(CameraUpdateFactory.zoomTo(15.0f));
        tencentMap.setOnMarkerClickListener(new a());
        tencentMap.getUiSettings().setGestureScaleByMapCenter(true);
        tencentMap.getUiSettings().setRotateGesturesEnabled(false);
    }

    public void f2(TencentMap.OnCameraChangeListener onCameraChangeListener, TencentMap.OnMapClickListener onMapClickListener, TencentMap.OnMapPoiClickListener onMapPoiClickListener) {
        TencentMap tencentMap = this.f78747i;
        if (tencentMap == null) {
            QLog.i(getTAG(), 1, "setTencentMapListeners tencentMap is null");
            return;
        }
        if (onCameraChangeListener != null) {
            tencentMap.setOnCameraChangeListener(onCameraChangeListener);
        } else {
            QLog.i(getTAG(), 1, "setTencentMapListeners onCameraChangeListener is null");
        }
        if (onMapClickListener != null) {
            this.f78747i.setOnMapClickListener(onMapClickListener);
        } else {
            QLog.i(getTAG(), 1, "setTencentMapListeners onMapClickListener is null");
        }
        if (onMapPoiClickListener != null) {
            this.f78747i.setOnMapPoiClickListener(onMapPoiClickListener);
        } else {
            QLog.i(getTAG(), 1, "setTencentMapListeners onMapPoiClickListener is null");
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "MapViewModel";
    }
}
