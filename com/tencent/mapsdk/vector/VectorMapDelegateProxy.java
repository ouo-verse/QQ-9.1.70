package com.tencent.mapsdk.vector;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.bw;
import com.tencent.mapsdk.internal.lb;
import com.tencent.mapsdk.internal.lc;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.tr;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

@Keep
/* loaded from: classes9.dex */
public class VectorMapDelegateProxy implements MapDelegate<ne, VectorMap, bw> {
    private tr mMapDelegate;

    @Keep
    public VectorMapDelegateProxy(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        this.mMapDelegate = new tr(context, tencentMapOptions, viewGroup);
    }

    private int getMapId() {
        if (getMapContext() != null) {
            return getMapContext().N;
        }
        return -1;
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public bw getMapRenderView() {
        return this.mMapDelegate.getMapRenderView();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isOpaque() {
        return this.mMapDelegate.isOpaque();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean isTouchable() {
        return this.mMapDelegate.isTouchable();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onCreated() {
        lc.a(lb.D, getMapId());
        this.mMapDelegate.onCreated();
        lc.c(lb.D, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        lc.a(lb.J, getMapId());
        this.mMapDelegate.onDestroy();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        lc.a(lb.G, getMapId());
        this.mMapDelegate.onPause();
        lc.c(lb.G, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onRestart() {
        lc.a(lb.H, getMapId());
        this.mMapDelegate.onRestart();
        lc.c(lb.H, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        lc.a(lb.F, getMapId());
        this.mMapDelegate.onResume();
        lc.c(lb.F, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        lc.a(lb.L, getMapId());
        this.mMapDelegate.onSizeChanged(i3, i16, i17, i18);
        lc.c(lb.L, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStart() {
        lc.a(lb.E, getMapId());
        this.mMapDelegate.onStart();
        lc.c(lb.E, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStop() {
        lc.a(lb.I, getMapId());
        this.mMapDelegate.onStop();
        lc.c(lb.I, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSurfaceChanged(Object obj, int i3, int i16) {
        lc.a(lb.M, getMapId());
        lc.a(lb.M, "width", Integer.valueOf(i3), getMapId());
        lc.a(lb.M, "height", Integer.valueOf(i16), getMapId());
        this.mMapDelegate.onSurfaceChanged(obj, i3, i16);
        lc.c(lb.M, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mMapDelegate.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onUpdateOptions(TencentMapOptions tencentMapOptions) {
        lc.a(lb.K, getMapId());
        this.mMapDelegate.onUpdateOptions(tencentMapOptions);
        lc.c(lb.K, getMapId());
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOnTop(boolean z16) {
        this.mMapDelegate.setOnTop(z16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void setOpaque(boolean z16) {
        this.mMapDelegate.setOpaque(z16);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public VectorMap createMap(ne neVar) {
        return this.mMapDelegate.a((tr) neVar);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public bw createMapView(ne neVar, ViewGroup viewGroup) {
        return this.mMapDelegate.a((tr) neVar, viewGroup);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public VectorMap getMap() {
        return (VectorMap) this.mMapDelegate.e_;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mapsdk.core.MapDelegate
    public ne getMapContext() {
        return (ne) this.mMapDelegate.d_;
    }
}
