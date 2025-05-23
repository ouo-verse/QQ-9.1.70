package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/filament/zplan/avatar/FovProjection;", "", "fov", "", "aspect", "far", "near", "direction", "", "(FFFFLjava/lang/String;)V", "getAspect", "()F", "setAspect", "(F)V", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "getFar", "setFar", "getFov", "setFov", "getNear", "setNear", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FovProjection {
    private float aspect;

    @NotNull
    private String direction;
    private float far;
    private float fov;
    private float near;

    public FovProjection() {
        this(0.0f, 0.0f, 0.0f, 0.0f, null, 31, null);
    }

    public final float getAspect() {
        return this.aspect;
    }

    @NotNull
    public final String getDirection() {
        return this.direction;
    }

    public final float getFar() {
        return this.far;
    }

    public final float getFov() {
        return this.fov;
    }

    public final float getNear() {
        return this.near;
    }

    public final void setAspect(float f16) {
        this.aspect = f16;
    }

    public final void setDirection(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.direction = str;
    }

    public final void setFar(float f16) {
        this.far = f16;
    }

    public final void setFov(float f16) {
        this.fov = f16;
    }

    public final void setNear(float f16) {
        this.near = f16;
    }

    public FovProjection(float f16, float f17, float f18, float f19, @NotNull String direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.fov = f16;
        this.aspect = f17;
        this.far = f18;
        this.near = f19;
        this.direction = direction;
    }

    public /* synthetic */ FovProjection(float f16, float f17, float f18, float f19, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10.0f : f16, (i3 & 2) != 0 ? 0.75f : f17, (i3 & 4) != 0 ? 1000.0f : f18, (i3 & 8) != 0 ? 0.05f : f19, (i3 & 16) != 0 ? "horizontal" : str);
    }
}
