package com.tencent.hippy.qq.view.viola.scroll;

import android.view.ViewGroup;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TkdScrollViewEventHelper extends HippyScrollViewEventHelper {
    public static final String EVENT_TYPE_END_REACHED = "onEndReached";
    public static final String EVENT_TYPE_START_REACHED = "onStartReached";

    public static void emitScrollEndReachedEvent(ViewGroup viewGroup) {
        HippyScrollViewEventHelper.emitScrollEvent(viewGroup, "onEndReached");
    }

    public static void emitScrollStartReachedEvent(ViewGroup viewGroup) {
        HippyScrollViewEventHelper.emitScrollEvent(viewGroup, EVENT_TYPE_START_REACHED);
    }
}
