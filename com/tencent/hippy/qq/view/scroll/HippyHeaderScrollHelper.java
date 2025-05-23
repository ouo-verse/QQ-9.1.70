package com.tencent.hippy.qq.view.scroll;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ScrollView;
import com.tencent.mtt.hippy.views.list.HippyListView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyHeaderScrollHelper {
    private ScrollableContainer mCurrentScrollableContainer;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface ScrollableContainer {
        View getScrollableView();
    }

    private View getScrollableView() {
        ScrollableContainer scrollableContainer = this.mCurrentScrollableContainer;
        if (scrollableContainer == null) {
            return null;
        }
        return scrollableContainer.getScrollableView();
    }

    private boolean isAdapterViewTop(HippyListView hippyListView) {
        if (hippyListView == null || hippyListView.getFirstVisibleItemPos() != 0) {
            return false;
        }
        View childAt = hippyListView.getChildAt(0);
        return childAt == null || childAt.getTop() == 0;
    }

    private boolean isScrollViewTop(ScrollView scrollView) {
        if (scrollView == null || scrollView.getScrollY() <= 0) {
            return true;
        }
        return false;
    }

    public boolean isTop() {
        View scrollableView = getScrollableView();
        if (scrollableView == null) {
            return true;
        }
        if (scrollableView instanceof HippyListView) {
            return isAdapterViewTop((HippyListView) scrollableView);
        }
        if (scrollableView instanceof AdapterView) {
            return isAdapterViewTop((AdapterView) scrollableView);
        }
        if (!(scrollableView instanceof ScrollView)) {
            return true;
        }
        return isScrollViewTop((ScrollView) scrollableView);
    }

    public void setCurrentScrollableContainer(ScrollableContainer scrollableContainer) {
        this.mCurrentScrollableContainer = scrollableContainer;
    }

    @SuppressLint({"NewApi"})
    public void smoothScrollBy(int i3, int i16, int i17) {
        View scrollableView = getScrollableView();
        if (scrollableView instanceof AbsListView) {
            ((AbsListView) scrollableView).smoothScrollBy(i16, i17);
            return;
        }
        if (scrollableView instanceof HippyListView) {
            ((HippyListView) scrollableView).smoothScrollBy(i16, i17);
        } else if (scrollableView instanceof ScrollView) {
            ((ScrollView) scrollableView).fling(i3);
        } else if (scrollableView instanceof WebView) {
            ((WebView) scrollableView).flingScroll(0, i3);
        }
    }

    private boolean isAdapterViewTop(AdapterView adapterView) {
        if (adapterView == null || adapterView.getFirstVisiblePosition() != 0) {
            return false;
        }
        View childAt = adapterView.getChildAt(0);
        return childAt == null || childAt.getTop() == 0;
    }
}
