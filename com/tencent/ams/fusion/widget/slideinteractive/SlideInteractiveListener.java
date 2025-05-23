package com.tencent.ams.fusion.widget.slideinteractive;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SlideInteractiveListener {
    void onEndAnimationFinish();

    void onGestureResult(boolean z16, View view, float f16, float f17);

    void onGestureStart();

    void onTouch(View view, MotionEvent motionEvent);
}
