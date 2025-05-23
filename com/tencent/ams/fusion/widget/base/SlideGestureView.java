package com.tencent.ams.fusion.widget.base;

import android.view.View;
import com.tencent.ams.fusion.widget.slideinteractive.SlideGestureViewHelper;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface SlideGestureView {
    void setGestureClickHotArea(int i3, int i16, int i17, int i18);

    void setGestureClickView(View... viewArr);

    void setGestureColor(String str);

    void setGestureSlideDirection(@SlideGestureViewHelper.SlideDirection int i3);

    void setGestureSlideHotArea(int i3, int i16, int i17, int i18);

    void setGestureSlideValidAngle(float f16);

    void setGestureSlideValidHeightDp(int i3);

    void setGestureStrokeWidthDp(int i3);

    void setGestureVisible(boolean z16);

    void setSlideGestureListener(SlideGestureViewHelper.ISlideGestureListener iSlideGestureListener);
}
