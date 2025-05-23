package com.tencent.mapsdk.navi;

import android.content.Context;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.bw;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.sy;
import com.tencent.mapsdk.internal.sz;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

@Keep
/* loaded from: classes9.dex */
public class VectorMapNaviDelegateProxy implements MapDelegate<ne, sy, bw> {
    private sz mMapDelegate;

    @Keep
    public VectorMapNaviDelegateProxy(Context context, TencentMapOptions tencentMapOptions, ViewGroup viewGroup) {
        this.mMapDelegate = new sz(context, tencentMapOptions, viewGroup);
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
        this.mMapDelegate.onCreated();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onDestroy() {
        this.mMapDelegate.onDestroy();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onPause() {
        this.mMapDelegate.onPause();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onRestart() {
        this.mMapDelegate.onRestart();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onResume() {
        this.mMapDelegate.onResume();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.mMapDelegate.onSizeChanged(i3, i16, i17, i18);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStart() {
        this.mMapDelegate.onStart();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onStop() {
        this.mMapDelegate.onStop();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onSurfaceChanged(Object obj, int i3, int i16) {
        this.mMapDelegate.onSurfaceChanged(obj, i3, i16);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mMapDelegate.onTouchEvent(motionEvent);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public void onUpdateOptions(TencentMapOptions tencentMapOptions) {
        this.mMapDelegate.onUpdateOptions(tencentMapOptions);
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
    public sy createMap(ne neVar) {
        return (sy) this.mMapDelegate.a((sz) neVar);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate
    public bw createMapView(ne neVar, ViewGroup viewGroup) {
        return this.mMapDelegate.a((sz) neVar, viewGroup);
    }

    @Override // com.tencent.mapsdk.core.MapDelegate, com.tencent.tencentmap.mapsdk.maps.BaseMapView.MapViewProxy
    public sy getMap() {
        return (sy) this.mMapDelegate.e_;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mapsdk.core.MapDelegate
    public ne getMapContext() {
        return (ne) this.mMapDelegate.d_;
    }
}
