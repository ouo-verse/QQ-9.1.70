package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.qa;
import com.tencent.mapsdk.internal.ua;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface bb extends MapDelegate<ne, VectorMap, bw>, fc, oy, ua.m, TencentMap.OnIndoorStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public static final int f147790a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f147791b = 1;

    void A();

    boolean B();

    boolean C();

    ol D();

    void E();

    void F();

    void G();

    Context H();

    void I();

    @Deprecated
    boolean J();

    boolean K();

    TencentMapOptions L();

    qj M();

    boolean N();

    TencentMap.OnPolylineClickListener O();

    TencentMap.OnPolygonClickListener P();

    TencentMap.InfoWindowAdapter Q();

    TencentMap.OnMarkerCollisionStatusListener R();

    TencentMap.OnMarkerDragListener S();

    TencentMap.OnMarkerClickListener T();

    TencentMap.OnInfoWindowClickListener U();

    TencentMap.OnMapClickListener V();

    TencentMap.OnMapFrameFinishCallback W();

    CameraPosition a();

    void a(float f16);

    void a(float f16, float f17, float f18);

    void a(int i3);

    void a(int i3, int i16);

    void a(Handler handler, Bitmap.Config config, int i3);

    void a(bd bdVar);

    void a(bi.a aVar);

    void a(fd fdVar);

    void a(fj fjVar);

    void a(fp fpVar);

    void a(ol olVar, lu luVar);

    void a(oq oqVar);

    void a(qa.b bVar);

    void a(qs qsVar);

    void a(sj sjVar);

    void a(TencentMap.InfoWindowAdapter infoWindowAdapter);

    void a(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void a(TencentMap.OnDismissCallback onDismissCallback);

    void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);

    void a(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener);

    void a(TencentMap.OnMapPoiClickListener onMapPoiClickListener);

    void a(TencentMap.OnMarkerClickListener onMarkerClickListener);

    void a(TencentMap.OnMarkerCollisionStatusListener onMarkerCollisionStatusListener);

    void a(TencentMap.OnMarkerDragListener onMarkerDragListener);

    void a(TencentMap.OnPolygonClickListener onPolygonClickListener);

    void a(TencentMap.OnPolylineClickListener onPolylineClickListener);

    void a(TencentMapOptions tencentMapOptions);

    void a(OverSeaTileProvider overSeaTileProvider);

    void a(TencentMapGestureListener tencentMapGestureListener);

    void a(String str);

    void a(boolean z16);

    boolean a(float f16, float f17);

    ne b();

    void b(float f16);

    void b(int i3, int i16);

    void b(fd fdVar);

    void b(fj fjVar);

    void b(qa.b bVar);

    void b(TencentMapGestureListener tencentMapGestureListener);

    void b(String str);

    void b(boolean z16);

    boolean b(float f16, float f17);

    nd c();

    po c(String str);

    void c(int i3, int i16);

    void c(boolean z16);

    boolean c(float f16, float f17);

    so d();

    Marker d(float f16, float f17);

    void d(int i3, int i16);

    void d(boolean z16);

    boolean d(String str);

    String e();

    void e(boolean z16);

    boolean e(float f16, float f17);

    void f(boolean z16);

    boolean f();

    boolean f(float f16, float f17);

    void g(boolean z16);

    boolean g();

    @Override // com.tencent.mapsdk.internal.oy
    int getEGLContextHash();

    void h(boolean z16);

    boolean h();

    void i(boolean z16);

    boolean i();

    void j(boolean z16);

    boolean j();

    void k();

    void k(boolean z16);

    void l();

    void l(boolean z16);

    void m();

    void n();

    boolean o();

    boolean p();

    qs q();

    ac r();

    GeoPoint s();

    int t();

    int u();

    int v();

    int w();

    TencentMap.OnMapPoiClickListener x();

    boolean y();

    void z();
}
