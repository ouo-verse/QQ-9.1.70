package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface Scroll {
    float getScrollPosition();

    void scrollTo(float f16, boolean z16);

    void setScrollEnabled(boolean z16);

    void setScrollIndicatorFadingEnabled(boolean z16);

    void setScrollListener(JSFunction jSFunction, JSFunction jSFunction2);

    void showScrollIndicator(boolean z16);
}
