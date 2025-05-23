package com.tencent.mobileqq.nearbypro.map.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/view/NearbyProMapView;", "Lcom/tencent/tencentmap/mapsdk/maps/TextureMapView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tencentMapOptions", "Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;", "(Landroid/content/Context;Lcom/tencent/tencentmap/mapsdk/maps/TencentMapOptions;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NearbyProMapView extends TextureMapView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProMapView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    public final void init() {
        if (TencentMapInitializer.getAgreePrivacy()) {
            return;
        }
        TencentMapInitializer.setAgreePrivacy(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProMapView(@NotNull Context context, @NotNull TencentMapOptions tencentMapOptions) {
        super(context, tencentMapOptions);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tencentMapOptions, "tencentMapOptions");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProMapView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyProMapView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        init();
    }
}
