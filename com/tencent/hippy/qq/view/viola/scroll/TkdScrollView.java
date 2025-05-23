package com.tencent.hippy.qq.view.viola.scroll;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface TkdScrollView extends HippyScrollView {
    void callLoadMoreFinish();

    void callScrollToPosition(int i3, int i16, Promise promise);

    void callScrollToTop(boolean z16);

    void setPreloadDistance(int i3);
}
