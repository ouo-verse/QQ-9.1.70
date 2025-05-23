package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IOverScrollDecor {
    int getOrientation();

    void initAnimationAttributes(View view, AnimationAttributes animationAttributes);

    boolean initMotionAttributes(View view, MotionAttributes motionAttributes, MotionEvent motionEvent);

    boolean isInAbsoluteEnd(View view);

    boolean isInAbsoluteStart(View view);

    void setOrientation(int i3);

    void translateView(View view, float f16);

    void translateViewAndEvent(View view, float f16, MotionEvent motionEvent);
}
