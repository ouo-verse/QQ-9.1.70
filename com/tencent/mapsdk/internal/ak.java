package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ak {
    int A();

    float a(int i3, int i16, int i17, int i18, LatLng latLng, LatLng latLng2, LatLng latLng3);

    float a(LatLng latLng, LatLng latLng2);

    float a(LatLng latLng, LatLng latLng2, float f16, int i3, int i16, int i17, int i18, boolean z16);

    float a(LatLng latLng, LatLng latLng2, float f16, int i3, boolean z16);

    float a(LatLngBounds latLngBounds, float f16, int i3, boolean z16);

    int a(CameraUpdate cameraUpdate);

    int a(CameraUpdate cameraUpdate, long j3, TencentMap.CancelableCallback cancelableCallback);

    CameraPosition a();

    CameraPosition a(List<fb> list, List<LatLng> list2, int i3, int i16, int i17, int i18);

    CameraPosition a(List<fb> list, List<LatLng> list2, int i3, int i16, int i17, int i18, TencentMap.AsyncOperateCallback<CameraPosition> asyncOperateCallback);

    CustomLayer a(CustomLayerOptions customLayerOptions);

    TileOverlay a(TileOverlayOptions tileOverlayOptions);

    String a(LatLng latLng);

    List<Rect> a(List<String> list);

    void a(float f16, float f17);

    void a(float f16, float f17, boolean z16);

    void a(int i3);

    void a(int i3, int i16);

    void a(Handler handler, Bitmap.Config config, int i3);

    void a(fk fkVar);

    void a(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void a(TencentMap.OnCompassClickedListener onCompassClickedListener);

    void a(TencentMap.OnDismissCallback onDismissCallback);

    void a(TencentMap.OnIndoorStateChangeListener onIndoorStateChangeListener);

    void a(TencentMap.OnMapClickListener onMapClickListener);

    void a(TencentMap.OnMapLoadedCallback onMapLoadedCallback);

    void a(TencentMap.OnMapLongClickListener onMapLongClickListener);

    void a(TencentMap.OnScaleViewChangedListener onScaleViewChangedListener);

    void a(TencentMap.OnTrafficEventClickListener onTrafficEventClickListener);

    void a(Language language);

    void a(LatLng latLng, float f16, float f17);

    void a(LatLng latLng, float f16, float f17, float f18);

    void a(LatLng latLng, float f16, float f17, float f18, boolean z16);

    void a(LatLngBounds latLngBounds, int i3);

    void a(TencentMapGestureListener tencentMapGestureListener);

    void a(String str);

    void a(String str, String str2);

    void a(List<MapRouteSection> list, List<LatLng> list2);

    void a(boolean z16);

    float b();

    int b(String str);

    void b(float f16, float f17);

    void b(int i3);

    void b(fk fkVar);

    void b(TencentMap.OnCameraChangeListener onCameraChangeListener);

    void b(TencentMap.OnMapLoadedCallback onMapLoadedCallback);

    void b(Language language);

    void b(TencentMapGestureListener tencentMapGestureListener);

    void b(boolean z16);

    float c();

    void c(int i3);

    void c(boolean z16);

    void d();

    void d(int i3);

    void d(boolean z16);

    void e();

    void e(int i3);

    void e(boolean z16);

    int f();

    void f(int i3);

    void f(boolean z16);

    int g();

    void g(boolean z16);

    void h(boolean z16);

    boolean h();

    void i();

    void i(boolean z16);

    void j();

    void k();

    void l();

    void m();

    void n();

    String o();

    Language p();

    void q();

    int r();

    String[] s();

    String t();

    IndoorBuilding u();

    String v();

    boolean w();

    boolean x();

    ArrayList<MapPoi> y();

    String z();
}
