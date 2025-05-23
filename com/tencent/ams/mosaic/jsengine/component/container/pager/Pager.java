package com.tencent.ams.mosaic.jsengine.component.container.pager;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;

@JSAgent
/* loaded from: classes3.dex */
public interface Pager {
    void notifyDataSetChanged();

    void scrollToPage(int i3, boolean z16);

    void setAutoScrollInterval(int i3);

    void setOnPageSelectListener(JSFunction jSFunction);

    void setPageSize(int i3);

    void setScroller(int i3, float[] fArr);

    void setStackSize(int i3);

    void startAutoScroll();

    void stopAutoScroll();
}
