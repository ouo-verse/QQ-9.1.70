package com.qzone.reborn.albumx.qzonex.view;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.mapview.QTextureMapView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/QZAlbumxTextureMapView;", "Lcom/tencent/mobileqq/widget/mapview/QTextureMapView;", "context", "Landroid/content/Context;", "mapOptions", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;", "(Landroid/content/Context;Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxTextureMapView extends QTextureMapView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZAlbumxTextureMapView(Context context, TencentMapOptions mapOptions) {
        super(context, mapOptions);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mapOptions, "mapOptions");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.MapView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        if (ev5 == null) {
            return super.onInterceptTouchEvent(ev5);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }
}
