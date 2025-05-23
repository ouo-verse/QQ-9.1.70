package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import cooperation.qzone.report.QZonePushReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006!"}, d2 = {"Lcom/tencent/filament/zplan/avatar/CameraParams;", "", QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE, "Lcom/tencent/filament/zplan/avatar/Exposure;", "lookAt", "Lcom/tencent/filament/zplan/avatar/LookAt;", "lensProjection", "Lcom/tencent/filament/zplan/avatar/LensProjection;", "fovProjection", "Lcom/tencent/filament/zplan/avatar/FovProjection;", "manipulator", "Lcom/tencent/filament/zplan/avatar/Manipulator;", "(Lcom/tencent/filament/zplan/avatar/Exposure;Lcom/tencent/filament/zplan/avatar/LookAt;Lcom/tencent/filament/zplan/avatar/LensProjection;Lcom/tencent/filament/zplan/avatar/FovProjection;Lcom/tencent/filament/zplan/avatar/Manipulator;)V", "getExposure", "()Lcom/tencent/filament/zplan/avatar/Exposure;", "setExposure", "(Lcom/tencent/filament/zplan/avatar/Exposure;)V", "getFovProjection", "()Lcom/tencent/filament/zplan/avatar/FovProjection;", "setFovProjection", "(Lcom/tencent/filament/zplan/avatar/FovProjection;)V", "getLensProjection", "()Lcom/tencent/filament/zplan/avatar/LensProjection;", "setLensProjection", "(Lcom/tencent/filament/zplan/avatar/LensProjection;)V", "getLookAt", "()Lcom/tencent/filament/zplan/avatar/LookAt;", "setLookAt", "(Lcom/tencent/filament/zplan/avatar/LookAt;)V", "getManipulator", "()Lcom/tencent/filament/zplan/avatar/Manipulator;", "setManipulator", "(Lcom/tencent/filament/zplan/avatar/Manipulator;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class CameraParams {

    @NotNull
    private Exposure exposure;

    @Nullable
    private FovProjection fovProjection;

    @Nullable
    private LensProjection lensProjection;

    @NotNull
    private LookAt lookAt;

    @Nullable
    private Manipulator manipulator;

    public CameraParams() {
        this(null, null, null, null, null, 31, null);
    }

    @NotNull
    public final Exposure getExposure() {
        return this.exposure;
    }

    @Nullable
    public final FovProjection getFovProjection() {
        return this.fovProjection;
    }

    @Nullable
    public final LensProjection getLensProjection() {
        return this.lensProjection;
    }

    @NotNull
    public final LookAt getLookAt() {
        return this.lookAt;
    }

    @Nullable
    public final Manipulator getManipulator() {
        return this.manipulator;
    }

    public final void setExposure(@NotNull Exposure exposure) {
        Intrinsics.checkNotNullParameter(exposure, "<set-?>");
        this.exposure = exposure;
    }

    public final void setFovProjection(@Nullable FovProjection fovProjection) {
        this.fovProjection = fovProjection;
    }

    public final void setLensProjection(@Nullable LensProjection lensProjection) {
        this.lensProjection = lensProjection;
    }

    public final void setLookAt(@NotNull LookAt lookAt) {
        Intrinsics.checkNotNullParameter(lookAt, "<set-?>");
        this.lookAt = lookAt;
    }

    public final void setManipulator(@Nullable Manipulator manipulator) {
        this.manipulator = manipulator;
    }

    public CameraParams(@NotNull Exposure exposure, @NotNull LookAt lookAt, @Nullable LensProjection lensProjection, @Nullable FovProjection fovProjection, @Nullable Manipulator manipulator) {
        Intrinsics.checkNotNullParameter(exposure, "exposure");
        Intrinsics.checkNotNullParameter(lookAt, "lookAt");
        this.exposure = exposure;
        this.lookAt = lookAt;
        this.lensProjection = lensProjection;
        this.fovProjection = fovProjection;
        this.manipulator = manipulator;
    }

    public /* synthetic */ CameraParams(Exposure exposure, LookAt lookAt, LensProjection lensProjection, FovProjection fovProjection, Manipulator manipulator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Exposure(0, 0.0d, 0.0d, 7, null) : exposure, (i3 & 2) != 0 ? new LookAt(null, null, null, 7, null) : lookAt, (i3 & 4) != 0 ? null : lensProjection, (i3 & 8) != 0 ? null : fovProjection, (i3 & 16) == 0 ? manipulator : null);
    }
}
