package com.tencent.state.map.v2;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/map/v2/ViewportInfo;", "", "scale", "", "center", "Lcom/tencent/state/map/v2/Location;", "(FLcom/tencent/state/map/v2/Location;)V", "getCenter", "()Lcom/tencent/state/map/v2/Location;", "getScale", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class ViewportInfo {
    private final Location center;
    private final float scale;

    public ViewportInfo() {
        this(0.0f, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* renamed from: component2, reason: from getter */
    public final Location getCenter() {
        return this.center;
    }

    public final ViewportInfo copy(float scale, Location center) {
        Intrinsics.checkNotNullParameter(center, "center");
        return new ViewportInfo(scale, center);
    }

    public final Location getCenter() {
        return this.center;
    }

    public final float getScale() {
        return this.scale;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.scale) * 31;
        Location location = this.center;
        return floatToIntBits + (location != null ? location.hashCode() : 0);
    }

    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    public String toString() {
        return "ViewportInfo(scale=" + this.scale + ", center=" + this.center + ")";
    }

    public ViewportInfo(float f16, Location center) {
        Intrinsics.checkNotNullParameter(center, "center");
        this.scale = f16;
        this.center = center;
    }

    public /* synthetic */ ViewportInfo(float f16, Location location, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f16, (i3 & 2) != 0 ? new Location(0.0f, 0.0f) : location);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewportInfo)) {
            return false;
        }
        ViewportInfo viewportInfo = (ViewportInfo) other;
        return Float.compare(this.scale, viewportInfo.scale) == 0 && Intrinsics.areEqual(this.center, viewportInfo.center);
    }

    public static /* synthetic */ ViewportInfo copy$default(ViewportInfo viewportInfo, float f16, Location location, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = viewportInfo.scale;
        }
        if ((i3 & 2) != 0) {
            location = viewportInfo.center;
        }
        return viewportInfo.copy(f16, location);
    }
}
