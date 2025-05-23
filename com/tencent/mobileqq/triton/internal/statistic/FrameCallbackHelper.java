package com.tencent.mobileqq.triton.internal.statistic;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/statistic/FrameCallbackHelper;", "", "frameCallback", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "(Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;)V", "drawBeginTime", "", "frameBeginDrawingTime", "isFirstFrame", "", "onFrameBegin", "", "drawingTime", "onFrameEnd", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FrameCallbackHelper {
    private long drawBeginTime;
    private long frameBeginDrawingTime;
    private final ValueHolder<FrameCallback> frameCallback;
    private boolean isFirstFrame;

    public FrameCallbackHelper(@NotNull ValueHolder<FrameCallback> frameCallback) {
        Intrinsics.checkParameterIsNotNull(frameCallback, "frameCallback");
        this.frameCallback = frameCallback;
        this.isFirstFrame = true;
    }

    public final void onFrameBegin(long drawingTime) {
        this.drawBeginTime = Utils.nanoTime();
        FrameCallback value = this.frameCallback.getValue();
        if (value != null) {
            value.onFrameBegin(drawingTime, this.isFirstFrame);
        }
        this.isFirstFrame = false;
        this.frameBeginDrawingTime = drawingTime;
    }

    public final void onFrameEnd() {
        FrameCallback value = this.frameCallback.getValue();
        if (value != null) {
            value.onFrameEnd(this.frameBeginDrawingTime, Utils.nanoTime() - this.drawBeginTime);
        }
    }
}
