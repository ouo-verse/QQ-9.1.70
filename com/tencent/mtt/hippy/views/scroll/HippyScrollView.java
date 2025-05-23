package com.tencent.mtt.hippy.views.scroll;

import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface HippyScrollView {
    void callSmoothScrollTo(int i3, int i16, int i17);

    void scrollToInitContentOffset();

    void setContentOffset4Reuse(HippyMap hippyMap);

    void setFlingEnabled(boolean z16);

    void setInitialContentOffset(int i3);

    void setMomentumScrollBeginEventEnable(boolean z16);

    void setMomentumScrollEndEventEnable(boolean z16);

    void setPagingEnabled(boolean z16);

    void setScrollBeginDragEventEnable(boolean z16);

    void setScrollEnabled(boolean z16);

    void setScrollEndDragEventEnable(boolean z16);

    void setScrollEventEnable(boolean z16);

    void setScrollEventThrottle(int i3);

    void setScrollMinOffset(int i3);

    void showScrollIndicator(boolean z16);
}
