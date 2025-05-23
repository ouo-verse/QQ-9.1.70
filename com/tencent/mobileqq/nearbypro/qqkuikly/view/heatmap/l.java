package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tencentmap.mapsdk.maps.CustomRender;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.GroundOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/l;", "Lcom/tencent/tencentmap/mapsdk/maps/CustomRender;", "", "f", "Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "bounds", "", "ignoreTransition", "d", "b", "", "targetAlpha", ICustomDataEditor.STRING_ARRAY_PARAM_1, "a", com.tencent.luggage.wxa.c8.c.f123400v, "c", "onDrawFrame", "Z", "isHide", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/k;", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/k;", "preOverlay", "curOverlay", "", "J", "transitionDurationTime", "e", "startTransitionTime", "Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;", "waitingBitmap", "g", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "waitingBounds", tl.h.F, UserInfo.SEX_FEMALE, "Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;", "tencentMap", "<init>", "(Lcom/tencent/tencentmap/mapsdk/maps/TencentMap;)V", "i", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class l implements CustomRender {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isHide;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private k preOverlay;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private k curOverlay;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long transitionDurationTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTransitionTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BitmapDescriptor waitingBitmap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LatLngBounds waitingBounds;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float targetAlpha;

    public l(@NotNull TencentMap tencentMap) {
        Intrinsics.checkNotNullParameter(tencentMap, "tencentMap");
        this.isHide = true;
        GroundOverlay addGroundOverlay = tencentMap.addGroundOverlay(new GroundOverlayOptions());
        Intrinsics.checkNotNullExpressionValue(addGroundOverlay, "tencentMap.addGroundOver\u2026y(GroundOverlayOptions())");
        this.preOverlay = new k(addGroundOverlay, null, null, 0.0f, 14, null);
        GroundOverlay addGroundOverlay2 = tencentMap.addGroundOverlay(new GroundOverlayOptions());
        Intrinsics.checkNotNullExpressionValue(addGroundOverlay2, "tencentMap.addGroundOver\u2026y(GroundOverlayOptions())");
        this.curOverlay = new k(addGroundOverlay2, null, null, 0.0f, 14, null);
        this.transitionDurationTime = 200L;
        this.targetAlpha = 0.6f;
        tencentMap.setCustomRender(this);
    }

    public static /* synthetic */ void e(l lVar, BitmapDescriptor bitmapDescriptor, LatLngBounds latLngBounds, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        lVar.d(bitmapDescriptor, latLngBounds, z16);
    }

    private final void f() {
        if (this.startTransitionTime == 0) {
            return;
        }
        float max = Math.max(Math.min(((float) (System.currentTimeMillis() - this.startTransitionTime)) / ((float) this.transitionDurationTime), 1.0f), 0.0f);
        this.curOverlay.b(max);
        float f16 = this.targetAlpha;
        this.preOverlay.b(Math.max(Math.min(a(f16, max * f16) / this.targetAlpha, 1.0f), 0.0f));
        if (max >= 1.0f) {
            this.startTransitionTime = 0L;
            this.preOverlay.a();
            if (this.waitingBitmap != null && this.waitingBounds != null) {
                com.tencent.mobileqq.nearbypro.base.j.c().c("OverlayUpdater", "\u663e\u793a\u7b49\u5f85\u7684\u6700\u65b0\u56fe\u7247");
                BitmapDescriptor bitmapDescriptor = this.waitingBitmap;
                Intrinsics.checkNotNull(bitmapDescriptor);
                LatLngBounds latLngBounds = this.waitingBounds;
                Intrinsics.checkNotNull(latLngBounds);
                e(this, bitmapDescriptor, latLngBounds, false, 4, null);
                this.waitingBitmap = null;
                this.waitingBounds = null;
            }
        }
    }

    public final float a(float targetAlpha, float a16) {
        float f16 = (targetAlpha - a16) / (1 - a16);
        float f17 = 0.0f;
        if (f16 >= 0.0f) {
            f17 = 1.0f;
            if (f16 <= 1.0f) {
                return f16;
            }
        }
        return f17;
    }

    public final void b() {
        if (this.isHide) {
            return;
        }
        this.isHide = true;
        this.startTransitionTime = 0L;
        this.curOverlay.a();
        this.preOverlay.a();
    }

    public final void c(float alpha) {
        this.targetAlpha = alpha;
    }

    public final void d(@NotNull BitmapDescriptor bitmap, @NotNull LatLngBounds bounds, boolean ignoreTransition) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.isHide = false;
        if (ignoreTransition) {
            this.waitingBitmap = null;
            this.waitingBounds = null;
            this.startTransitionTime = 0L;
            this.preOverlay.a();
            this.curOverlay.c(bitmap, bounds);
            this.curOverlay.b(1.0f);
            return;
        }
        if (this.startTransitionTime != 0) {
            com.tencent.mobileqq.nearbypro.base.j.c().c("OverlayUpdater", "\u6b63\u5728\u6e10\u53d8\u4e2d\uff0c\u5148\u7f13\u5b58\u65b0\u56fe\u7247");
            this.waitingBitmap = bitmap;
            this.waitingBounds = bounds;
        } else {
            k kVar = this.preOverlay;
            this.preOverlay = this.curOverlay;
            this.curOverlay = kVar;
            kVar.c(bitmap, bounds);
            this.startTransitionTime = System.currentTimeMillis();
            f();
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.CustomRender
    public void onDrawFrame() {
        f();
    }
}
