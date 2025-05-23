package com.tencent.mtt.hippy.views.scroll;

import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyScrollViewEventHelper {
    public static final String EVENT_ON_END_REACHED = "onEndReached";
    public static final String EVENT_TYPE_ANIMATION_END = "onScrollAnimationEnd";
    public static final String EVENT_TYPE_BEGIN_DRAG = "onScrollBeginDrag";
    public static final String EVENT_TYPE_END_DRAG = "onScrollEndDrag";
    public static final String EVENT_TYPE_MOMENTUM_BEGIN = "onMomentumScrollBegin";
    public static final String EVENT_TYPE_MOMENTUM_END = "onMomentumScrollEnd";
    public static final String EVENT_TYPE_REFRESH = "onRefresh";
    public static final String EVENT_TYPE_SCROLL = "onScroll";
    public static final long MOMENTUM_DELAY = 20;

    public static void emitScrollBeginDragEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, EVENT_TYPE_BEGIN_DRAG);
    }

    public static void emitScrollEndDragEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, EVENT_TYPE_END_DRAG);
    }

    public static void emitScrollEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, EVENT_TYPE_SCROLL);
    }

    public static void emitScrollMomentumBeginEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, EVENT_TYPE_MOMENTUM_BEGIN);
    }

    public static void emitScrollMomentumEndEvent(ViewGroup viewGroup) {
        emitScrollEvent(viewGroup, EVENT_TYPE_MOMENTUM_END);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void emitScrollEvent(ViewGroup viewGroup, String str) {
        if (viewGroup == null) {
            return;
        }
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble("top", 0.0d);
        hippyMap.pushDouble("bottom", 0.0d);
        hippyMap.pushDouble("left", 0.0d);
        hippyMap.pushDouble("right", 0.0d);
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushDouble(HippyTKDListViewAdapter.X, PixelUtil.px2dp(viewGroup.getScrollX()));
        hippyMap2.pushDouble("y", PixelUtil.px2dp(viewGroup.getScrollY()));
        HippyMap hippyMap3 = new HippyMap();
        hippyMap3.pushDouble("width", PixelUtil.px2dp(viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0).getWidth() : viewGroup.getWidth()));
        hippyMap3.pushDouble("height", PixelUtil.px2dp(viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0).getHeight() : viewGroup.getHeight()));
        HippyMap hippyMap4 = new HippyMap();
        hippyMap4.pushDouble("width", PixelUtil.px2dp(viewGroup.getWidth()));
        hippyMap4.pushDouble("height", PixelUtil.px2dp(viewGroup.getHeight()));
        HippyMap hippyMap5 = new HippyMap();
        hippyMap5.pushMap(WaterFallComponentName.PROPERTY_CONTENT_INSET, hippyMap);
        hippyMap5.pushMap("contentOffset", hippyMap2);
        hippyMap5.pushMap("contentSize", hippyMap3);
        hippyMap5.pushMap("layoutMeasurement", hippyMap4);
        if (viewGroup.getContext() instanceof HippyInstanceContext) {
            ((EventDispatcher) ((HippyInstanceContext) viewGroup.getContext()).getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(viewGroup.getId(), str, hippyMap5);
        }
    }
}
