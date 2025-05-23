package com.tencent.mobileqq.triton.internal.render;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/triton/internal/render/FpsStabilizer;", "", "()V", "accumulateStartTimeNanos", "", "accumulatedFrames", "", "fpsIntervalNanos", "", "setTargetFps", "", "fps", "", "shouldDoFrame", "", "drawingTimeNanos", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class FpsStabilizer {
    private static final String TAG = "FpsStabilizer";
    private volatile long accumulateStartTimeNanos = -1000;
    private int accumulatedFrames;
    private volatile double fpsIntervalNanos;

    public final void setTargetFps(float fps) {
        double nanos;
        Logger.i$default(TAG, "setTargetFps=" + fps, null, 4, null);
        if (fps <= 0) {
            nanos = 0.0d;
        } else {
            nanos = TimeUnit.SECONDS.toNanos(1L) / fps;
        }
        this.fpsIntervalNanos = nanos;
        this.accumulateStartTimeNanos = 0L;
    }

    public final boolean shouldDoFrame(long drawingTimeNanos) {
        boolean z16 = true;
        if (this.fpsIntervalNanos != 0.0d && drawingTimeNanos > 0) {
            long j3 = drawingTimeNanos - this.accumulateStartTimeNanos;
            double d16 = j3 / this.fpsIntervalNanos;
            int i3 = this.accumulatedFrames;
            if (d16 >= i3) {
                this.accumulatedFrames = i3 + 1;
            } else {
                z16 = false;
            }
            if (j3 > TimeUnit.SECONDS.toNanos(1L)) {
                this.accumulateStartTimeNanos = drawingTimeNanos;
                this.accumulatedFrames = 0;
            }
        }
        return z16;
    }
}
