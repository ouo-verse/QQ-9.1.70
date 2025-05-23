package com.qzone.proxy.feedcomponent.text;

import android.view.View;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface TextLayoutBase {
    View getAttachedView();

    void invalidate();

    boolean isLongClickTrig();

    boolean isPressed();

    void performCellClick(TextCell textCell);

    void performCellLongClick();

    void postInvalidate();

    void postRequestLayout();

    void requestLayout();

    void setLongClickTrig(boolean z16);

    void setPressed(boolean z16);
}
