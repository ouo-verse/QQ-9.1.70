package com.tencent.qqmini.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

/* compiled from: P */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes23.dex */
public class QQMapView extends TextureMapView {
    static final String TAG = "QQMapView";
    public static boolean isSelectPoiListItem;
    private TencentMap.OnCameraChangeListener cameraChangeListener;
    protected boolean mIsScrolling;
    GeoPoint mLastPoint;
    QQMapViewObserver mObserver;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface QQMapViewObserver {
        void onMapScrollEnd(GeoPoint geoPoint);

        void onMapScrollStart(GeoPoint geoPoint);
    }

    public QQMapView(Context context, AttributeSet attributeSet, TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        this.mIsScrolling = false;
        init();
        this.cameraChangeListener = new TencentMap.OnCameraChangeListener() { // from class: com.tencent.qqmini.map.QQMapView.1
            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
            public void onCameraChange(CameraPosition cameraPosition) {
                QQMapView qQMapView = QQMapView.this;
                QQMapViewObserver qQMapViewObserver = qQMapView.mObserver;
                if (qQMapViewObserver != null && !qQMapView.mIsScrolling) {
                    qQMapView.mIsScrolling = true;
                    qQMapViewObserver.onMapScrollStart(new GeoPoint((int) (cameraPosition.target.getLatitude() * 1000000.0d), (int) (cameraPosition.target.getLongitude() * 1000000.0d)));
                }
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
            public void onCameraChangeFinished(CameraPosition cameraPosition) {
                QQMapView qQMapView = QQMapView.this;
                if (qQMapView.mIsScrolling) {
                    qQMapView.dealMapScroll(cameraPosition);
                }
            }
        };
        getMap().setOnCameraChangeListener(this.cameraChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealMapScroll(CameraPosition cameraPosition) {
        GeoPoint geoPoint = new GeoPoint((int) (cameraPosition.target.getLatitude() * 1000000.0d), (int) (cameraPosition.target.getLongitude() * 1000000.0d));
        GeoPoint geoPoint2 = this.mLastPoint;
        if (geoPoint2 != null) {
            int abs = Math.abs(geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6());
            int abs2 = Math.abs(this.mLastPoint.getLongitudeE6() - geoPoint.getLongitudeE6());
            QMLog.d(TAG, "dealMapScroll() latScroll =" + abs + " lngScroll =" + abs2);
            if (abs == 0 || abs2 == 0) {
                return;
            }
        }
        if (!isSelectPoiListItem) {
            this.mObserver.onMapScrollEnd(geoPoint);
        } else {
            isSelectPoiListItem = false;
        }
        this.mIsScrolling = false;
        this.mLastPoint = geoPoint;
    }

    private void init() {
        if (TencentMapInitializer.getAgreePrivacy()) {
            return;
        }
        TencentMapInitializer.setAgreePrivacy(true);
    }

    public void destroy() {
        this.mObserver = null;
        this.cameraChangeListener = null;
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

    public void setObserver(QQMapViewObserver qQMapViewObserver) {
        this.mObserver = qQMapViewObserver;
    }

    public QQMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsScrolling = false;
        init();
        this.cameraChangeListener = new TencentMap.OnCameraChangeListener() { // from class: com.tencent.qqmini.map.QQMapView.2
            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
            public void onCameraChange(CameraPosition cameraPosition) {
                QQMapView qQMapView = QQMapView.this;
                QQMapViewObserver qQMapViewObserver = qQMapView.mObserver;
                if (qQMapViewObserver != null && !qQMapView.mIsScrolling) {
                    qQMapView.mIsScrolling = true;
                    qQMapViewObserver.onMapScrollStart(new GeoPoint((int) (cameraPosition.target.getLatitude() * 1000000.0d), (int) (cameraPosition.target.getLongitude() * 1000000.0d)));
                }
            }

            @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
            public void onCameraChangeFinished(CameraPosition cameraPosition) {
                QQMapView qQMapView = QQMapView.this;
                if (qQMapView.mIsScrolling) {
                    qQMapView.dealMapScroll(cameraPosition);
                }
            }
        };
        getMap().setOnCameraChangeListener(this.cameraChangeListener);
    }
}
