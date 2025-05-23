package com.tencent.mobileqq.triton.internal.render;

import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/RenderContext;", "", "()V", "accomulatedDrawCalls", "", "getAccomulatedDrawCalls", "()J", "accomulatedFrames", "getAccomulatedFrames", "currentFPS", "", "getCurrentFPS", "()F", "targetFPS", "", "getTargetFPS", "()I", "setFrameCallback", "", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "takeScreenShot", "callback", "Lcom/tencent/mobileqq/triton/engine/ScreenShotCallback;", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class RenderContext {
    public final long getAccomulatedDrawCalls() {
        throw new NotImplementedError(null, 1, null);
    }

    public final long getAccomulatedFrames() {
        throw new NotImplementedError(null, 1, null);
    }

    public final float getCurrentFPS() {
        throw new NotImplementedError(null, 1, null);
    }

    public final int getTargetFPS() {
        throw new NotImplementedError(null, 1, null);
    }

    public final void takeScreenShot(@NotNull ScreenShotCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
    }

    public final void setFrameCallback(@Nullable FrameCallback frameCallback) {
    }
}
