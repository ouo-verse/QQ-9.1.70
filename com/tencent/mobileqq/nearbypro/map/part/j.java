package com.tencent.mobileqq.nearbypro.map.part;

import android.view.MotionEvent;
import bb2.SortCluster;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J&\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J(\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/part/j;", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap$OnInfoWindowClickListener;", "Lcom/tencent/tencentmap/mapsdk/maps/model/Marker;", "marker", "", "onInfoWindowClick", "", "width", "height", HippyTKDListViewAdapter.X, "y", "onInfoWindowClickLocation", "Lbb2/d;", "Lda2/b;", "markerView", "date", "Landroid/view/MotionEvent;", "clickEvent", "a", "Lbb2/e;", "d", "Lbb2/e;", "clickMarkerOpt", "", "e", "J", "clickMills", "<init>", "()V", "f", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class j implements TencentMap.OnInfoWindowClickListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private bb2.e clickMarkerOpt;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long clickMills;

    public void a(@Nullable bb2.d<da2.b> markerView, @NotNull da2.b date, @NotNull MotionEvent clickEvent) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(clickEvent, "clickEvent");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public final void onInfoWindowClick(@Nullable Marker marker) {
        MarkerOptions markerOptions;
        this.clickMills = System.currentTimeMillis();
        bb2.e eVar = null;
        if (marker != null) {
            markerOptions = marker.getOptions();
        } else {
            markerOptions = null;
        }
        if (markerOptions instanceof bb2.e) {
            eVar = (bb2.e) markerOptions;
        }
        this.clickMarkerOpt = eVar;
        com.tencent.mobileqq.nearbypro.base.j.c().e("NBP.NearbyMapPart", "onInfoWindowClick");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener
    public final void onInfoWindowClickLocation(int width, int height, int x16, int y16) {
        bb2.d<da2.b> dVar;
        if (this.clickMarkerOpt == null) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("OnInfoWindowClickListenerWrapper", "clickMarkerOpt == null");
            return;
        }
        if (System.currentTimeMillis() - this.clickMills > 200) {
            com.tencent.mobileqq.nearbypro.base.j.c().d("OnInfoWindowClickListenerWrapper", "invalid callback");
            return;
        }
        com.tencent.mobileqq.nearbypro.base.j.c().e("OnInfoWindowClickListenerWrapper", "onInfoWindowClickLocation width=" + width + " height=" + height + " x=" + x16 + " y=" + y16);
        bb2.e eVar = this.clickMarkerOpt;
        Intrinsics.checkNotNull(eVar);
        SortCluster sortCluster = eVar.getSortCluster();
        MotionEvent clickEvent = MotionEvent.obtain(0L, 0L, 0, (float) x16, (float) y16, 0);
        bb2.e eVar2 = this.clickMarkerOpt;
        if (eVar2 != null) {
            dVar = eVar2.b();
        } else {
            dVar = null;
        }
        da2.b b16 = db2.a.f393512a.b(sortCluster);
        Intrinsics.checkNotNullExpressionValue(clickEvent, "clickEvent");
        a(dVar, b16, clickEvent);
    }
}
