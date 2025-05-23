package com.qq.e.tg.nativ.widget;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface ViewStatusListener {
    void onAttachToWindow();

    void onDetachFromWindow();

    void onDispatchTouchEvent(MotionEvent motionEvent);

    void onWindowFocusChanged(boolean z16);

    void onWindowVisibilityChanged(int i3);
}
