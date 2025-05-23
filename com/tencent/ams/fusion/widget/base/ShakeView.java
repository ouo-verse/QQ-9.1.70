package com.tencent.ams.fusion.widget.base;

import com.tencent.ams.fusion.widget.olympicshake.OnShakeListener;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ShakeView<T extends OnShakeListener> extends AnimatableView {
    void setOnShakeListener(T t16);

    void setSensorEventsDeliveredOnMainThread(boolean z16);

    void setShakeDirectCombine(int[] iArr);

    void setShakeFactor(float f16, float f17, float f18);

    void setShakeSampleRate(int i3);

    void setShakeTimeDuration(int i3);

    void setShakeValue(float f16, int i3);
}
