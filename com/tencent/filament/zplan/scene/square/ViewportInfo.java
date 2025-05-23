package com.tencent.filament.zplan.scene.square;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/ViewportInfo;", "", "scale", "", "center", "Lcom/tencent/filament/zplan/scene/square/Location;", "(FLcom/tencent/filament/zplan/scene/square/Location;)V", "getCenter", "()Lcom/tencent/filament/zplan/scene/square/Location;", "getScale", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJson", "", "toString", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class ViewportInfo {

    @NotNull
    private final Location center;
    private final float scale;

    public ViewportInfo() {
        this(0.0f, null, 3, 0 == true ? 1 : 0);
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

    /* renamed from: component1, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Location getCenter() {
        return this.center;
    }

    @NotNull
    public final ViewportInfo copy(float scale, @NotNull Location center) {
        Intrinsics.checkNotNullParameter(center, "center");
        return new ViewportInfo(scale, center);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ViewportInfo) {
                ViewportInfo viewportInfo = (ViewportInfo) other;
                if (Float.compare(this.scale, viewportInfo.scale) != 0 || !Intrinsics.areEqual(this.center, viewportInfo.center)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Location getCenter() {
        return this.center;
    }

    public final float getScale() {
        return this.scale;
    }

    public int hashCode() {
        int i3;
        int floatToIntBits = Float.floatToIntBits(this.scale) * 31;
        Location location = this.center;
        if (location != null) {
            i3 = location.hashCode();
        } else {
            i3 = 0;
        }
        return floatToIntBits + i3;
    }

    @NotNull
    public final String toJson() {
        String json = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
        return json;
    }

    @NotNull
    public String toString() {
        return "ViewportInfo(scale=" + this.scale + ", center=" + this.center + ")";
    }

    public ViewportInfo(float f16, @NotNull Location center) {
        Intrinsics.checkNotNullParameter(center, "center");
        this.scale = f16;
        this.center = center;
    }

    public /* synthetic */ ViewportInfo(float f16, Location location, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f16, (i3 & 2) != 0 ? new Location(0.0f, 0.0f) : location);
    }
}
