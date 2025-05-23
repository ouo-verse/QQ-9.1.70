package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelation;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ap extends aq, Marker {
    int a();

    void a(Bitmap bitmap, boolean z16);

    void a(TencentMap.OnMarkerClickListener onMarkerClickListener);

    void a(AnimationListener animationListener);

    void a(BitmapDescriptor bitmapDescriptor, BitmapDescriptor bitmapDescriptor2);

    void a(LatLng latLng);

    void a(boolean z16);

    void a(int[] iArr, int[] iArr2);

    boolean b();

    Point c();

    TencentMap.OnMarkerClickListener d();

    List<LatLng> e();

    List<Boundable<fa>> f();

    TencentMap.InfoWindowAdapter g();

    ey h();

    boolean i();

    Rect j();

    qx k();

    List<MarkerCollisionRelationUnit> l();

    MarkerCollisionRelation m();

    boolean n();
}
