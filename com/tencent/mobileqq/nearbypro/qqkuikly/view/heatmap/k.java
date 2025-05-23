package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/k;", "", "Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "bounds", "", "c", "a", "", com.tencent.luggage.wxa.c8.c.f123400v, "b", "Lcom/tencent/tencentmap/mapsdk/maps/model/GroundOverlay;", "Lcom/tencent/tencentmap/mapsdk/maps/model/GroundOverlay;", "getOverlay", "()Lcom/tencent/tencentmap/mapsdk/maps/model/GroundOverlay;", "overlay", "Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", "getBitmap", "()Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", "setBitmap", "(Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;)V", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "getBounds", "()Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "setBounds", "(Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;)V", "d", UserInfo.SEX_FEMALE, "getAlpha", "()F", "setAlpha", "(F)V", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/model/GroundOverlay;Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;F)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroundOverlay overlay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BitmapDescriptor bitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LatLngBounds bounds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float alpha;

    public k(@NotNull GroundOverlay overlay, @Nullable BitmapDescriptor bitmapDescriptor, @Nullable LatLngBounds latLngBounds, float f16) {
        Intrinsics.checkNotNullParameter(overlay, "overlay");
        this.overlay = overlay;
        this.bitmap = bitmapDescriptor;
        this.bounds = latLngBounds;
        this.alpha = f16;
    }

    public final void a() {
        c(null, null);
        b(0.0f);
        this.overlay.setVisibility(false);
    }

    public final void b(float alpha) {
        if (this.bitmap == null) {
            return;
        }
        this.alpha = alpha;
        this.overlay.setAlpha(alpha);
    }

    public final void c(@Nullable BitmapDescriptor bitmap, @Nullable LatLngBounds bounds) {
        this.bitmap = bitmap;
        this.bounds = bounds;
        if (bitmap != null) {
            this.overlay.setBitmap(bitmap);
            this.overlay.setVisibility(true);
        }
        if (bounds != null) {
            this.overlay.setLatLongBounds(bounds);
        }
    }

    public /* synthetic */ k(GroundOverlay groundOverlay, BitmapDescriptor bitmapDescriptor, LatLngBounds latLngBounds, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(groundOverlay, (i3 & 2) != 0 ? null : bitmapDescriptor, (i3 & 4) != 0 ? null : latLngBounds, (i3 & 8) != 0 ? 0.0f : f16);
    }
}
