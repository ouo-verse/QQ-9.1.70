package com.tencent.ditto.area;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface DittoElement {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    float getAlpha();

    int getBottom();

    int getContentHeight();

    int getContentWidth();

    Context getContext();

    int getGravity();

    int getHeight();

    int getLeft();

    int getMarginBottom();

    int getMarginLeft();

    int getMarginRight();

    int getMarginTop();

    int getMeasuredHeight();

    int getMeasuredWidth();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getRight();

    int getTop();

    int getVisibility();

    int getWidth();

    void invalidate();

    void invalidateDelayed(long j3);

    void layout(int i3, int i16, int i17, int i18);

    void measure(int i3, int i16);

    void requestLayout();

    void setAlpha(float f16);

    void setGravity(int i3);

    void setMargin(int i3, int i16, int i17, int i18);

    void setPadding(int i3, int i16, int i17, int i18);

    void setPxMargin(int i3, int i16, int i17, int i18);

    void setShadowSize(int i3, int i16, int i17, int i18);

    void setVisibility(int i3);
}
