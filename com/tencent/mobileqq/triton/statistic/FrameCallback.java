package com.tencent.mobileqq.triton.statistic;

import androidx.annotation.WorkerThread;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "", "onFrameBegin", "", "frameTimeNanos", "", "firstFrame", "", "onFrameEnd", "frameDurationNanos", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface FrameCallback {
    @WorkerThread
    void onFrameBegin(long frameTimeNanos, boolean firstFrame);

    @WorkerThread
    void onFrameEnd(long frameTimeNanos, long frameDurationNanos);
}
