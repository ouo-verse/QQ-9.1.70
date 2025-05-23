package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/avatar/FreeFlight;", "", "maxSpeed", "", "speedSteps", "", "startPitch", "startYaw", "panSpeed", "", "moveDamping", "(FIFF[FF)V", "getMaxSpeed", "()F", "setMaxSpeed", "(F)V", "getMoveDamping", "setMoveDamping", "getPanSpeed", "()[F", "setPanSpeed", "([F)V", "getSpeedSteps", "()I", "setSpeedSteps", "(I)V", "getStartPitch", "setStartPitch", "getStartYaw", "setStartYaw", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FreeFlight {
    private float maxSpeed;
    private float moveDamping;

    @NotNull
    private float[] panSpeed;
    private int speedSteps;
    private float startPitch;
    private float startYaw;

    public FreeFlight() {
        this(0.0f, 0, 0.0f, 0.0f, null, 0.0f, 63, null);
    }

    public final float getMaxSpeed() {
        return this.maxSpeed;
    }

    public final float getMoveDamping() {
        return this.moveDamping;
    }

    @NotNull
    public final float[] getPanSpeed() {
        return this.panSpeed;
    }

    public final int getSpeedSteps() {
        return this.speedSteps;
    }

    public final float getStartPitch() {
        return this.startPitch;
    }

    public final float getStartYaw() {
        return this.startYaw;
    }

    public final void setMaxSpeed(float f16) {
        this.maxSpeed = f16;
    }

    public final void setMoveDamping(float f16) {
        this.moveDamping = f16;
    }

    public final void setPanSpeed(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.panSpeed = fArr;
    }

    public final void setSpeedSteps(int i3) {
        this.speedSteps = i3;
    }

    public final void setStartPitch(float f16) {
        this.startPitch = f16;
    }

    public final void setStartYaw(float f16) {
        this.startYaw = f16;
    }

    public FreeFlight(float f16, int i3, float f17, float f18, @NotNull float[] panSpeed, float f19) {
        Intrinsics.checkNotNullParameter(panSpeed, "panSpeed");
        this.maxSpeed = f16;
        this.speedSteps = i3;
        this.startPitch = f17;
        this.startYaw = f18;
        this.panSpeed = panSpeed;
        this.moveDamping = f19;
    }

    public /* synthetic */ FreeFlight(float f16, int i3, float f17, float f18, float[] fArr, float f19, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 10.0f : f16, (i16 & 2) != 0 ? 80 : i3, (i16 & 4) != 0 ? 0.0f : f17, (i16 & 8) == 0 ? f18 : 0.0f, (i16 & 16) != 0 ? new float[]{0.01f, 0.01f} : fArr, (i16 & 32) != 0 ? 15.0f : f19);
    }
}
