package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/filament/zplan/avatar/Directional;", "", "color", "", "cct", "", "intensity", "", "direction", "castShadows", "", "([FIF[FZ)V", "getCastShadows", "()Z", "setCastShadows", "(Z)V", "getCct", "()I", "setCct", "(I)V", "getColor", "()[F", "setColor", "([F)V", "getDirection", "setDirection", "getIntensity", "()F", "setIntensity", "(F)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class Directional {
    private boolean castShadows;
    private int cct;

    @NotNull
    private float[] color;

    @NotNull
    private float[] direction;
    private float intensity;

    public Directional() {
        this(null, 0, 0.0f, null, false, 31, null);
    }

    public final boolean getCastShadows() {
        return this.castShadows;
    }

    public final int getCct() {
        return this.cct;
    }

    @NotNull
    public final float[] getColor() {
        return this.color;
    }

    @NotNull
    public final float[] getDirection() {
        return this.direction;
    }

    public final float getIntensity() {
        return this.intensity;
    }

    public final void setCastShadows(boolean z16) {
        this.castShadows = z16;
    }

    public final void setCct(int i3) {
        this.cct = i3;
    }

    public final void setColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.color = fArr;
    }

    public final void setDirection(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.direction = fArr;
    }

    public final void setIntensity(float f16) {
        this.intensity = f16;
    }

    public Directional(@NotNull float[] color, int i3, float f16, @NotNull float[] direction, boolean z16) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.color = color;
        this.cct = i3;
        this.intensity = f16;
        this.direction = direction;
        this.castShadows = z16;
    }

    public /* synthetic */ Directional(float[] fArr, int i3, float f16, float[] fArr2, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new float[]{1.0f, 0.94f, 0.99f} : fArr, (i16 & 2) != 0 ? QQLiveError.UPLOAD_BITMAP_DOING : i3, (i16 & 4) != 0 ? 97000.0f : f16, (i16 & 8) != 0 ? new float[]{0.5f, -0.246f, -0.856f} : fArr2, (i16 & 16) != 0 ? true : z16);
    }
}
