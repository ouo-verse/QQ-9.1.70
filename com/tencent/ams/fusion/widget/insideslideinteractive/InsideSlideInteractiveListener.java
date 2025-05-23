package com.tencent.ams.fusion.widget.insideslideinteractive;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface InsideSlideInteractiveListener {
    void onGestureResult(boolean z16, View view, float f16, float f17, float f18, float f19);

    void onGestureStart();

    void onTouch(View view, MotionEvent motionEvent);
}
