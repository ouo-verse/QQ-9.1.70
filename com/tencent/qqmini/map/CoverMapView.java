package com.tencent.qqmini.map;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverMapView extends CoverView {
    private boolean isLoadMap;
    private QQMapView mapView;

    public CoverMapView(Context context) {
        super(context);
        QQMapView qQMapView = new QQMapView(context, null);
        this.mapView = qQMapView;
        qQMapView.onResume();
        addView(this.mapView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void captureImage(TencentMap.SnapshotReadyCallback snapshotReadyCallback) {
        if (snapshotReadyCallback == null) {
            return;
        }
        TencentMap map = getMap();
        if (map != null) {
            map.snapshot(snapshotReadyCallback);
        } else {
            snapshotReadyCallback.onSnapshotReady(null);
        }
    }

    public boolean getLoadMapState() {
        return this.isLoadMap;
    }

    public TencentMap getMap() {
        return this.mapView.getMap();
    }

    public UiSettings getUiSetrings() {
        return this.mapView.getMap().getUiSettings();
    }

    public void setLoadMapState(boolean z16) {
        this.isLoadMap = z16;
    }

    public CoverMapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        QQMapView qQMapView = new QQMapView(context, null, tencentMapOptions);
        this.mapView = qQMapView;
        qQMapView.onResume();
        addView(this.mapView, new FrameLayout.LayoutParams(-1, -1));
    }
}
