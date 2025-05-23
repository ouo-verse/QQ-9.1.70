package com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap;

import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#\u0012\b\b\u0002\u0010*\u001a\u00020\t\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\f\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\"\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0015\u0010!R\u001f\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b\u001f\u0010&R\u0017\u0010*\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b\u0011\u0010)R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b+\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/m;", "", "", "i", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "a", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", tl.h.F, "()Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;", "reason", "b", "J", "()J", "frameId", "c", "I", "g", "()I", "radius", "d", "e", "imgWidth", "imgHeight", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "f", "Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "()Lcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;", "imgBounds", "", "Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/h;", "Ljava/util/List;", "()Ljava/util/List;", "points", "Z", "()Z", "ignoreTransition", "getCreateTs", "createTs", "<init>", "(Lcom/tencent/mobileqq/nearbypro/qqkuikly/view/heatmap/RenderReason;JIIILcom/tencent/tencentmap/mapsdk/maps/model/LatLngBounds;Ljava/util/List;ZJ)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.nearbypro.qqkuikly.view.heatmap.m, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class RenderTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final RenderReason reason;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long frameId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int radius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imgWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int imgHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LatLngBounds imgBounds;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<HeatPoint> points;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean ignoreTransition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final long createTs;

    public RenderTask(@NotNull RenderReason reason, long j3, int i3, int i16, int i17, @NotNull LatLngBounds imgBounds, @Nullable List<HeatPoint> list, boolean z16, long j16) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(imgBounds, "imgBounds");
        this.reason = reason;
        this.frameId = j3;
        this.radius = i3;
        this.imgWidth = i16;
        this.imgHeight = i17;
        this.imgBounds = imgBounds;
        this.points = list;
        this.ignoreTransition = z16;
        this.createTs = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getFrameId() {
        return this.frameId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIgnoreTransition() {
        return this.ignoreTransition;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final LatLngBounds getImgBounds() {
        return this.imgBounds;
    }

    /* renamed from: d, reason: from getter */
    public final int getImgHeight() {
        return this.imgHeight;
    }

    /* renamed from: e, reason: from getter */
    public final int getImgWidth() {
        return this.imgWidth;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderTask)) {
            return false;
        }
        RenderTask renderTask = (RenderTask) other;
        if (this.reason == renderTask.reason && this.frameId == renderTask.frameId && this.radius == renderTask.radius && this.imgWidth == renderTask.imgWidth && this.imgHeight == renderTask.imgHeight && Intrinsics.areEqual(this.imgBounds, renderTask.imgBounds) && Intrinsics.areEqual(this.points, renderTask.points) && this.ignoreTransition == renderTask.ignoreTransition && this.createTs == renderTask.createTs) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<HeatPoint> f() {
        return this.points;
    }

    /* renamed from: g, reason: from getter */
    public final int getRadius() {
        return this.radius;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final RenderReason getReason() {
        return this.reason;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((this.reason.hashCode() * 31) + androidx.fragment.app.a.a(this.frameId)) * 31) + this.radius) * 31) + this.imgWidth) * 31) + this.imgHeight) * 31) + this.imgBounds.hashCode()) * 31;
        List<HeatPoint> list = this.points;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        boolean z16 = this.ignoreTransition;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return ((i3 + i16) * 31) + androidx.fragment.app.a.a(this.createTs);
    }

    public final long i() {
        return System.currentTimeMillis() - this.createTs;
    }

    @NotNull
    public String toString() {
        return "RenderTask(reason=" + this.reason + ", frameId=" + this.frameId + ", radius=" + this.radius + ", imgWidth=" + this.imgWidth + ", imgHeight=" + this.imgHeight + ", imgBounds=" + this.imgBounds + ", points=" + this.points + ", ignoreTransition=" + this.ignoreTransition + ", createTs=" + this.createTs + ")";
    }

    public /* synthetic */ RenderTask(RenderReason renderReason, long j3, int i3, int i16, int i17, LatLngBounds latLngBounds, List list, boolean z16, long j16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderReason, j3, i3, i16, i17, latLngBounds, list, (i18 & 128) != 0 ? false : z16, (i18 & 256) != 0 ? System.currentTimeMillis() : j16);
    }
}
