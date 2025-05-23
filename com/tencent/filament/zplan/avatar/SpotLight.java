package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019\u00a8\u00060"}, d2 = {"Lcom/tencent/filament/zplan/avatar/SpotLight;", "", "key", "", "position", "", "direction", "color", "intensity", "", "falloff", "", "innerCone", "", "outerCone", "castShadows", "", "(Ljava/lang/String;[F[F[FFDIIZ)V", "getCastShadows", "()Z", "setCastShadows", "(Z)V", "getColor", "()[F", "setColor", "([F)V", "getDirection", "setDirection", "getFalloff", "()D", "setFalloff", "(D)V", "getInnerCone", "()I", "setInnerCone", "(I)V", "getIntensity", "()F", "setIntensity", "(F)V", "getKey", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "getOuterCone", "setOuterCone", "getPosition", "setPosition", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SpotLight {
    private boolean castShadows;

    @NotNull
    private float[] color;

    @NotNull
    private float[] direction;
    private double falloff;
    private int innerCone;
    private float intensity;

    @NotNull
    private String key;
    private int outerCone;

    @NotNull
    private float[] position;

    public SpotLight() {
        this(null, null, null, null, 0.0f, 0.0d, 0, 0, false, 511, null);
    }

    public final boolean getCastShadows() {
        return this.castShadows;
    }

    @NotNull
    public final float[] getColor() {
        return this.color;
    }

    @NotNull
    public final float[] getDirection() {
        return this.direction;
    }

    public final double getFalloff() {
        return this.falloff;
    }

    public final int getInnerCone() {
        return this.innerCone;
    }

    public final float getIntensity() {
        return this.intensity;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final int getOuterCone() {
        return this.outerCone;
    }

    @NotNull
    public final float[] getPosition() {
        return this.position;
    }

    public final void setCastShadows(boolean z16) {
        this.castShadows = z16;
    }

    public final void setColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.color = fArr;
    }

    public final void setDirection(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.direction = fArr;
    }

    public final void setFalloff(double d16) {
        this.falloff = d16;
    }

    public final void setInnerCone(int i3) {
        this.innerCone = i3;
    }

    public final void setIntensity(float f16) {
        this.intensity = f16;
    }

    public final void setKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final void setOuterCone(int i3) {
        this.outerCone = i3;
    }

    public final void setPosition(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.position = fArr;
    }

    public SpotLight(@NotNull String key, @NotNull float[] position, @NotNull float[] direction, @NotNull float[] color, float f16, double d16, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(color, "color");
        this.key = key;
        this.position = position;
        this.direction = direction;
        this.color = color;
        this.intensity = f16;
        this.falloff = d16;
        this.innerCone = i3;
        this.outerCone = i16;
        this.castShadows = z16;
    }

    public /* synthetic */ SpotLight(String str, float[] fArr, float[] fArr2, float[] fArr3, float f16, double d16, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? new float[]{1.017f, 1.017f, 0.905f} : fArr, (i17 & 4) != 0 ? new float[]{-0.61f, 0.281f, -0.741f} : fArr2, (i17 & 8) != 0 ? new float[]{1.0f, 1.0f, 1.0f} : fArr3, (i17 & 16) != 0 ? 158995.0f : f16, (i17 & 32) != 0 ? 45.0d : d16, (i17 & 64) != 0 ? 0 : i3, (i17 & 128) != 0 ? 44 : i16, (i17 & 256) == 0 ? z16 : false);
    }
}
