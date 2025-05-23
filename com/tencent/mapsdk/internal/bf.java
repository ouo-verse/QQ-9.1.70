package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.mapsdk.core.MapDelegate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import com.tencent.tencentmap.mapsdk.maps.VisualSettings;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface bf extends TencentMapContext {
    ae a();

    MapDelegate b();

    bk c();

    fa d();

    VisualSettings e();

    v f();

    tk g();

    Rect h();

    float i();

    Object j();

    int k();

    int l();

    boolean m();

    float n();

    boolean o();

    boolean p();

    TencentMap.OnMarkerCollisionStatusListener q();

    TencentMap.OnMarkerDragListener r();

    TencentMap.OnMapPoiClickListener s();

    TencentMap.OnMapClickListener t();
}
