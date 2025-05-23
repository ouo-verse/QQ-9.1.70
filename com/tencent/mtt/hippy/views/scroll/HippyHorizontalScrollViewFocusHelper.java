package com.tencent.mtt.hippy.views.scroll;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mtt.hippy.utils.StrictFocusFinder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyHorizontalScrollViewFocusHelper {
    private Rect mFocusRect = new Rect();
    private HippyHorizontalScrollView mScrollView;

    public HippyHorizontalScrollViewFocusHelper(HippyHorizontalScrollView hippyHorizontalScrollView) {
        this.mScrollView = hippyHorizontalScrollView;
    }

    protected int computeScrollDelta(Rect rect) {
        int i3;
        int i16;
        if (this.mScrollView.getChildCount() == 0) {
            return 0;
        }
        int width = this.mScrollView.getWidth();
        int scrollX = this.mScrollView.getScrollX();
        int i17 = scrollX + width;
        int horizontalFadingEdgeLength = this.mScrollView.getHorizontalFadingEdgeLength();
        if (rect.left > 0) {
            scrollX += horizontalFadingEdgeLength;
        }
        if (rect.right < this.mScrollView.getChildAt(0).getWidth()) {
            i17 -= horizontalFadingEdgeLength;
        }
        int i18 = rect.right;
        if (i18 > i17 && rect.left > scrollX) {
            if (rect.width() > width) {
                i16 = rect.left - scrollX;
            } else {
                i16 = rect.right - i17;
            }
            return Math.min(i16 + 0, this.mScrollView.getChildAt(0).getRight() - i17);
        }
        if (rect.left >= scrollX || i18 >= i17) {
            return 0;
        }
        if (rect.width() > width) {
            i3 = 0 - (i17 - rect.right);
        } else {
            i3 = 0 - (scrollX - rect.left);
        }
        return Math.max(i3, -this.mScrollView.getScrollX());
    }

    public View focusSearch(View view, int i3) {
        View findNextFocus = StrictFocusFinder.getInstance().findNextFocus(this.mScrollView, view, i3);
        if (findNextFocus == null && this.mScrollView.getParent() != null) {
            return this.mScrollView.getParent().focusSearch(view, i3);
        }
        return findNextFocus;
    }

    public void scrollToFocusChild(View view) {
        view.getDrawingRect(this.mFocusRect);
        this.mScrollView.offsetDescendantRectToMyCoords(view, this.mFocusRect);
        int computeScrollDelta = computeScrollDelta(this.mFocusRect);
        if (computeScrollDelta != 0) {
            this.mScrollView.scrollBy(computeScrollDelta, 0);
        }
    }
}
