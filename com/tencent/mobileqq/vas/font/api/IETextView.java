package com.tencent.mobileqq.vas.font.api;

import android.content.res.Resources;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IETextView {
    int getETMaxWidth();

    void getLocationInWindow(int[] iArr);

    int getMaxEms();

    int getMaxLines();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    Paint getPaint();

    Resources getResources();

    CharSequence getText();

    float getTextSize();

    int getVisibility();

    boolean hasSelected();

    int highlightBackgroundColor();

    void invalidate();

    boolean isCacheMeasureResult();

    void onAnimationEnd(int i3);

    void setIsFounderAnimating(boolean z16);
}
