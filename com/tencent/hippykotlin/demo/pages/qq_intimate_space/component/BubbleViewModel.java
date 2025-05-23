package com.tencent.hippykotlin.demo.pages.qq_intimate_space.component;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import e25.a;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class BubbleViewModel {
    public MutableState<BubbleStatus> bubbleStatus;
    public MutableState<a> bubbleTips;
    public BubbleConfig config;
    public MutableState<Float> trianglePointToX;

    public BubbleViewModel(BubbleConfig bubbleConfig) {
        MutableState<BubbleStatus> mutableStateOf$default;
        MutableState<Float> mutableStateOf$default2;
        MutableState<a> mutableStateOf$default3;
        this.config = bubbleConfig;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bubbleConfig.getStartStatus(), null, 2, null);
        this.bubbleStatus = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.trianglePointToX = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.bubbleTips = mutableStateOf$default3;
        updateBubbleConfig(this.config);
    }

    public final float getTriangleMarginLeft() {
        return this.trianglePointToX.getValue().floatValue() - (this.config.triangleSize.getWidth() / 2.0f);
    }

    public final void updateBubbleConfig(BubbleConfig bubbleConfig) {
        float f16;
        float f17;
        this.config = bubbleConfig;
        MutableState<Float> mutableState = this.trianglePointToX;
        int ordinal = bubbleConfig.triangleDirection.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                f17 = bubbleConfig.bubbleUnfoldWidth;
            } else if (ordinal == 2) {
                f16 = bubbleConfig.bubbleUnfoldWidth - 48;
            } else if (ordinal == 3) {
                f17 = bubbleConfig.bubbleUnfoldWidth;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            f16 = f17 / 2.0f;
        } else {
            f16 = 48;
        }
        mutableState.setValue(Float.valueOf(f16));
    }
}
