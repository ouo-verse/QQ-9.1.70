package com.tencent.mtt.hippy.views.waterfalllist;

import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WaterfallEndChecker {
    private boolean isVerticalEnd = false;

    private boolean checkVerticalEnd(HippyWaterfallView hippyWaterfallView) {
        int preloadThresholdInItemNumber;
        boolean z16;
        HippyWaterfallLayoutManager hippyWaterfallLayoutManager = (HippyWaterfallLayoutManager) hippyWaterfallView.getLayoutManager();
        int findLastVisibleItemPosition = hippyWaterfallLayoutManager.findLastVisibleItemPosition();
        RecyclerViewBase.Adapter adapter = hippyWaterfallView.getAdapter();
        if (adapter == null) {
            preloadThresholdInItemNumber = 0;
        } else {
            preloadThresholdInItemNumber = adapter.getPreloadThresholdInItemNumber();
        }
        int itemCount = hippyWaterfallLayoutManager.getItemCount() - 1;
        if (findLastVisibleItemPosition > itemCount - preloadThresholdInItemNumber) {
            return true;
        }
        if (findLastVisibleItemPosition == itemCount) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || hippyWaterfallView.findViewByPosition(findLastVisibleItemPosition).getBottom() > hippyWaterfallView.getBottom()) {
            return false;
        }
        return true;
    }

    public void check(HippyWaterfallView hippyWaterfallView) {
        boolean checkVerticalEnd = checkVerticalEnd(hippyWaterfallView);
        if (!this.isVerticalEnd && checkVerticalEnd) {
            new HippyWaterfallView.HippyWaterfallEvent("onEndReached").send(hippyWaterfallView, null);
        }
        this.isVerticalEnd = checkVerticalEnd;
    }

    public void reset() {
        this.isVerticalEnd = false;
    }
}
