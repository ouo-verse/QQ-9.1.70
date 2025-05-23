package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/avatar/BusinessSceneConfig;", "", "camera", "Lcom/tencent/filament/zplan/avatar/CameraParams;", "renderer", "Lcom/tencent/filament/zplan/avatar/RendererParams;", "lights", "Lcom/tencent/filament/zplan/avatar/LightsParams;", "(Lcom/tencent/filament/zplan/avatar/CameraParams;Lcom/tencent/filament/zplan/avatar/RendererParams;Lcom/tencent/filament/zplan/avatar/LightsParams;)V", "getCamera", "()Lcom/tencent/filament/zplan/avatar/CameraParams;", "setCamera", "(Lcom/tencent/filament/zplan/avatar/CameraParams;)V", "getLights", "()Lcom/tencent/filament/zplan/avatar/LightsParams;", "setLights", "(Lcom/tencent/filament/zplan/avatar/LightsParams;)V", "getRenderer", "()Lcom/tencent/filament/zplan/avatar/RendererParams;", "setRenderer", "(Lcom/tencent/filament/zplan/avatar/RendererParams;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class BusinessSceneConfig {

    @NotNull
    private CameraParams camera;

    @Nullable
    private LightsParams lights;

    @NotNull
    private RendererParams renderer;

    public BusinessSceneConfig(@NotNull CameraParams camera2, @NotNull RendererParams renderer, @Nullable LightsParams lightsParams) {
        Intrinsics.checkNotNullParameter(camera2, "camera");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.camera = camera2;
        this.renderer = renderer;
        this.lights = lightsParams;
    }

    @NotNull
    public final CameraParams getCamera() {
        return this.camera;
    }

    @Nullable
    public final LightsParams getLights() {
        return this.lights;
    }

    @NotNull
    public final RendererParams getRenderer() {
        return this.renderer;
    }

    public final void setCamera(@NotNull CameraParams cameraParams) {
        Intrinsics.checkNotNullParameter(cameraParams, "<set-?>");
        this.camera = cameraParams;
    }

    public final void setLights(@Nullable LightsParams lightsParams) {
        this.lights = lightsParams;
    }

    public final void setRenderer(@NotNull RendererParams rendererParams) {
        Intrinsics.checkNotNullParameter(rendererParams, "<set-?>");
        this.renderer = rendererParams;
    }

    public /* synthetic */ BusinessSceneConfig(CameraParams cameraParams, RendererParams rendererParams, LightsParams lightsParams, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new CameraParams(null, null, null, null, null, 31, null) : cameraParams, (i3 & 2) != 0 ? new RendererParams(null, 1, null) : rendererParams, lightsParams);
    }
}
