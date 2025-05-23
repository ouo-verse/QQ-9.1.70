package com.tencent.mapsdk.internal;

import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Collisionable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerCollisionRelationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface ey extends fb, Collisionable, MarkerCollisionRelationUnit {

    /* renamed from: a, reason: collision with root package name */
    public static final String f148338a = "tencent_map_infowindow_view";

    /* renamed from: b, reason: collision with root package name */
    public static final String f148339b = "tencent_map_infowindow_content_title";

    /* renamed from: c, reason: collision with root package name */
    public static final String f148340c = "tencent_map_infowindow_content_snippet";

    void a(int i3, int i16);

    void a(LatLng latLng);

    void a(MarkerOptions markerOptions);

    void a(boolean z16);

    void b(boolean z16);

    void c(boolean z16);

    boolean c();

    void d();

    void e();

    void f();

    View g();

    void i_();
}
