package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplan/avatar/LookAt;", "", "eye", "", "target", "upward", "([F[F[F)V", "getEye", "()[F", "setEye", "([F)V", "getTarget", "setTarget", "getUpward", "setUpward", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class LookAt {

    @NotNull
    private float[] eye;

    @NotNull
    private float[] target;

    @NotNull
    private float[] upward;

    public LookAt() {
        this(null, null, null, 7, null);
    }

    @NotNull
    public final float[] getEye() {
        return this.eye;
    }

    @NotNull
    public final float[] getTarget() {
        return this.target;
    }

    @NotNull
    public final float[] getUpward() {
        return this.upward;
    }

    public final void setEye(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.eye = fArr;
    }

    public final void setTarget(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.target = fArr;
    }

    public final void setUpward(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.upward = fArr;
    }

    public LookAt(@NotNull float[] eye, @NotNull float[] target, @NotNull float[] upward) {
        Intrinsics.checkNotNullParameter(eye, "eye");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(upward, "upward");
        this.eye = eye;
        this.target = target;
        this.upward = upward;
    }

    public /* synthetic */ LookAt(float[] fArr, float[] fArr2, float[] fArr3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new float[]{0.0f, 1.0f, 6.7f} : fArr, (i3 & 2) != 0 ? new float[]{0.0f, 0.79f, 0.0f} : fArr2, (i3 & 4) != 0 ? new float[]{0.0f, 1.0f, 0.0f} : fArr3);
    }
}
