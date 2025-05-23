package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

/* compiled from: P */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes20.dex */
public class QQMapView extends QTextureMapView {

    /* renamed from: d, reason: collision with root package name */
    b f316047d;

    /* renamed from: e, reason: collision with root package name */
    GeoPoint f316048e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f316049f;

    /* renamed from: h, reason: collision with root package name */
    private TencentMap.OnCameraChangeListener f316050h;

    /* renamed from: i, reason: collision with root package name */
    boolean f316051i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements TencentMap.OnCameraChangeListener {
        a() {
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
            QQMapView qQMapView = QQMapView.this;
            b bVar = qQMapView.f316047d;
            if (bVar != null && !qQMapView.f316049f) {
                qQMapView.f316049f = true;
                bVar.onMapScrollStart(new GeoPoint((int) (cameraPosition.target.getLatitude() * 1000000.0d), (int) (cameraPosition.target.getLongitude() * 1000000.0d)));
            }
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
        public void onCameraChangeFinished(CameraPosition cameraPosition) {
            QQMapView qQMapView = QQMapView.this;
            if (qQMapView.f316049f) {
                qQMapView.dealMapScroll(cameraPosition);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void onMapScrollEnd(GeoPoint geoPoint);

        void onMapScrollStart(GeoPoint geoPoint);
    }

    public QQMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, new TencentMapOptions().setCustomUserID(com.tencent.mobileqq.utils.ah.e()));
        this.f316049f = false;
        this.f316051i = false;
        this.f316050h = new a();
        getMap().setOnCameraChangeListener(this.f316050h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealMapScroll(CameraPosition cameraPosition) {
        if (this.f316051i) {
            QLog.d("QQMapView", 1, "dismiss map scroll");
            this.f316051i = false;
            return;
        }
        GeoPoint geoPoint = new GeoPoint((int) (cameraPosition.target.getLatitude() * 1000000.0d), (int) (cameraPosition.target.getLongitude() * 1000000.0d));
        GeoPoint geoPoint2 = this.f316048e;
        if (geoPoint2 != null) {
            int abs = Math.abs(geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6());
            int abs2 = Math.abs(this.f316048e.getLongitudeE6() - geoPoint.getLongitudeE6());
            QLog.d("QQMapView", 2, "dealMapScroll() latScroll =" + abs + " lngScroll =" + abs2);
            if (abs == 0 || abs2 == 0) {
                return;
            }
        }
        this.f316047d.onMapScrollEnd(geoPoint);
        this.f316049f = false;
        this.f316048e = geoPoint;
    }

    public void b() {
        this.f316051i = true;
    }

    public void destroy() {
        this.f316047d = null;
        this.f316050h = null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setObserver(b bVar) {
        this.f316047d = bVar;
    }
}
