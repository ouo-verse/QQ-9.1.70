package com.tencent.tavcut.core.session;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "onFirstFrameTimeFinish", "", "finishTimeInMs", "", "onRenderTimeCost", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onSingleFrameTimeCost", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IRenderTimeListener {
    void onFirstFrameTimeFinish(long finishTimeInMs);

    void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs);

    void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs);
}
