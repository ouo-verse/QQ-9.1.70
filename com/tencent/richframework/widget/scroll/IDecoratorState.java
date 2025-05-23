package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IDecoratorState {
    void handleEntryTransition(IDecoratorState iDecoratorState);

    boolean handleMoveTouchEvent(MotionEvent motionEvent);

    boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent);
}
