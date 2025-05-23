package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/avatar/LensProjection;", "", "aspect", "", "far", "focalLength", "", "near", "(FFIF)V", "getAspect", "()F", "setAspect", "(F)V", "getFar", "setFar", "getFocalLength", "()I", "setFocalLength", "(I)V", "getNear", "setNear", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class LensProjection {
    private float aspect;
    private float far;
    private int focalLength;
    private float near;

    public LensProjection() {
        this(0.0f, 0.0f, 0, 0.0f, 15, null);
    }

    public final float getAspect() {
        return this.aspect;
    }

    public final float getFar() {
        return this.far;
    }

    public final int getFocalLength() {
        return this.focalLength;
    }

    public final float getNear() {
        return this.near;
    }

    public final void setAspect(float f16) {
        this.aspect = f16;
    }

    public final void setFar(float f16) {
        this.far = f16;
    }

    public final void setFocalLength(int i3) {
        this.focalLength = i3;
    }

    public final void setNear(float f16) {
        this.near = f16;
    }

    public LensProjection(float f16, float f17, int i3, float f18) {
        this.aspect = f16;
        this.far = f17;
        this.focalLength = i3;
        this.near = f18;
    }

    public /* synthetic */ LensProjection(float f16, float f17, int i3, float f18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0.75f : f16, (i16 & 2) != 0 ? 1000.0f : f17, (i16 & 4) != 0 ? 120 : i3, (i16 & 8) != 0 ? 0.05f : f18);
    }
}
