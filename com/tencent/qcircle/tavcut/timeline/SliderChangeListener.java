package com.tencent.qcircle.tavcut.timeline;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface SliderChangeListener {
    void onIndicatorMove(float f16);

    void onIndicatorMove(long j3);

    void onIndicatorPress();

    void onIndicatorRelease();

    void onSelectionChange(long j3, long j16, boolean z16);

    void onSliderBarMove(boolean z16, float f16, float f17);

    void onSliderBarRelease(boolean z16);
}
