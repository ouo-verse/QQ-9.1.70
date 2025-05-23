package com.tencent.mtt.hippy.views.hippylist;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.StrictFocusFinder;
import com.tencent.mtt.hippy.views.list.HippyListItemView;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.refresh.HippyPullHeaderView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyRecycleViewFocusHelper {
    private static final String TAG = "HippyRecycleView";
    private View mFocusedView;
    private HippyRecyclerView mRecyclerView;
    private int mKeyCode = 23;
    private Rect mFocusRect = new Rect();

    public HippyRecycleViewFocusHelper(HippyRecyclerView hippyRecyclerView) {
        this.mRecyclerView = hippyRecyclerView;
    }

    private int getFirstFocusHeightBefore() {
        View focusedChild = this.mRecyclerView.getFocusedChild();
        int position = this.mRecyclerView.getLayoutManager().getPosition(focusedChild);
        if (focusedChild != null) {
            return this.mRecyclerView.getTotalHeightBefore(position) + getRealFocusedChild(focusedChild).getHeight();
        }
        return this.mRecyclerView.getTotalHeightBefore(position);
    }

    private int getOffset(View view, int i3) {
        int top;
        int height;
        if (isBottomEdge(i3)) {
            top = view.getTop() + view.getHeight();
            view = this.mRecyclerView;
        } else if (isTopEdge(i3)) {
            top = view.getBottom();
        } else {
            top = view.getTop() + (view.getHeight() / 2);
            height = this.mRecyclerView.getHeight() / 2;
            return top - height;
        }
        height = view.getHeight();
        return top - height;
    }

    private int getOffsetKeyDown(int i3) {
        if (this.mRecyclerView.getAdapter().getNUM_BACKGOURND_ICON() == this.mRecyclerView.getChildCount()) {
            View childAt = this.mRecyclerView.getChildAt(r0.getChildCount() - 1);
            int top = (childAt.getTop() + childAt.getHeight()) - this.mRecyclerView.getHeight();
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > top) {
                i3 = top;
            }
            LogUtils.d(TAG, "requestChildFocus offset=" + i3 + ",max_bottom=" + top);
            return i3;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private int getOffsetKeyUp(int i3) {
        if (this.mRecyclerView.getAdapter().getNUM_BACKGOURND_ICON() == this.mRecyclerView.getChildCount()) {
            View childAt = this.mRecyclerView.getChildAt(0);
            int bottom = childAt.getBottom() - childAt.getHeight();
            if (i3 > 0) {
                i3 = 0;
            } else if (i3 < bottom) {
                i3 = bottom;
            }
            LogUtils.d(TAG, "requestChildFocus offset=" + i3 + ",max_top=" + bottom);
            return i3;
        }
        if (i3 > 0) {
            return 0;
        }
        return i3;
    }

    private View getParentRecycleItem(View view) {
        if (!(view instanceof HippyPullHeaderView) && !(view instanceof HippyPullFooterView)) {
            if (view instanceof HippyListItemView) {
                return view;
            }
            Object parent = view.getParent();
            if (parent == null) {
                return null;
            }
            return getParentRecycleItem((View) parent);
        }
        return (View) view.getParent();
    }

    private View getRealFocusedChild(View view) {
        if (view instanceof ViewGroup) {
            View focusedChild = ((ViewGroup) view).getFocusedChild();
            if (focusedChild == null) {
                return view;
            }
            return getRealFocusedChild(focusedChild);
        }
        return view;
    }

    private boolean isNoFocusDoNothing() {
        if (this.mFocusedView == null && getFirstFocusHeightBefore() < this.mRecyclerView.getHeight()) {
            return true;
        }
        return false;
    }

    private boolean isSameItemDoNothing(View view) {
        View view2 = this.mFocusedView;
        if (view2 != null && isViewOfSameRecycleItem(view2, view)) {
            return true;
        }
        return false;
    }

    private boolean isViewOfSameRecycleItem(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (this.mRecyclerView.isTheSameRenderNode((HippyRecyclerViewHolder) this.mRecyclerView.getChildViewHolder(view), (HippyRecyclerViewHolder) this.mRecyclerView.getChildViewHolder(view2))) {
            return true;
        }
        return false;
    }

    private void scrollToFocusChildVertical(View view) {
        View parentRecycleItem = getParentRecycleItem(view);
        if (parentRecycleItem != null) {
            int offset = getOffset(parentRecycleItem, this.mRecyclerView.getLayoutManager().getPosition(this.mRecyclerView.getFocusedChild()));
            LogUtils.d(TAG, "requestChildFocus offset=" + offset);
            int i3 = this.mKeyCode;
            if (i3 == 20) {
                offset = getOffsetKeyDown(offset);
            } else if (i3 == 19) {
                offset = getOffsetKeyUp(offset);
            }
            if (!isNoFocusDoNothing() && !isSameItemDoNothing(view)) {
                this.mRecyclerView.smoothScrollBy(0, offset);
            }
        }
    }

    protected int computeScrollDelta(Rect rect) {
        int i3;
        int i16;
        if (this.mRecyclerView.getChildCount() == 0) {
            return 0;
        }
        int width = this.mRecyclerView.getWidth();
        int scrollX = this.mRecyclerView.getScrollX();
        int i17 = scrollX + width;
        int horizontalFadingEdgeLength = this.mRecyclerView.getHorizontalFadingEdgeLength();
        if (rect.left > 0) {
            scrollX += horizontalFadingEdgeLength;
        }
        if (rect.right < this.mRecyclerView.getChildAt(0).getWidth()) {
            i17 -= horizontalFadingEdgeLength;
        }
        int i18 = rect.right;
        if (i18 > i17 && rect.left > scrollX) {
            if (rect.width() > width) {
                i16 = rect.left - scrollX;
            } else {
                i16 = rect.right - i17;
            }
            return Math.min(i16 + 0, this.mRecyclerView.getChildAt(0).getRight() - i17);
        }
        if (rect.left >= scrollX || i18 >= i17) {
            return 0;
        }
        if (rect.width() > width) {
            i3 = 0 - (i17 - rect.right);
        } else {
            i3 = 0 - (scrollX - rect.left);
        }
        return Math.max(i3, -this.mRecyclerView.getScrollX());
    }

    public View focusSearch(View view, int i3) {
        View findNextFocus = StrictFocusFinder.getInstance().findNextFocus(this.mRecyclerView, view, i3);
        if (findNextFocus == null && this.mRecyclerView.getParent() != null) {
            return this.mRecyclerView.getParent().focusSearch(view, i3);
        }
        return findNextFocus;
    }

    public int getChildAdapterPosition(View view) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        for (int i3 = 0; i3 < layoutManager.getChildCount(); i3++) {
            if (layoutManager.findViewByPosition(i3) == view) {
                return i3;
            }
        }
        return -1;
    }

    public int getChildDrawingOrder(int i3, int i16) {
        View focusedChild = this.mRecyclerView.getFocusedChild();
        if (focusedChild != null) {
            int childAdapterPosition = getChildAdapterPosition(focusedChild) - getFirstVisiblePosition();
            if (childAdapterPosition < 0) {
                return i16;
            }
            int i17 = i3 - 1;
            if (i16 == i17) {
                if (childAdapterPosition <= i16) {
                    return childAdapterPosition;
                }
                return i16;
            }
            if (i16 == childAdapterPosition) {
                return i17;
            }
        }
        return i16;
    }

    public int getFirstVisiblePosition() {
        if (this.mRecyclerView.getChildCount() == 0) {
            return 0;
        }
        return getChildAdapterPosition(this.mRecyclerView.getChildAt(0));
    }

    public boolean isBottomEdge(int i3) {
        if (!this.mRecyclerView.getLayoutManager().canScrollVertically() || i3 != this.mRecyclerView.getLayoutManager().getItemCount() - 1) {
            return false;
        }
        return true;
    }

    public boolean isTopEdge(int i3) {
        if (!this.mRecyclerView.getLayoutManager().canScrollVertically() || i3 != 0) {
            return false;
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.mRecyclerView.getLayoutManager().canScrollVertically()) {
            scrollToFocusChildVertical(view2);
        } else {
            scrollToFocusChildHorizontal(view2);
        }
        this.mFocusedView = view2;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        int paddingLeft = this.mRecyclerView.getPaddingLeft();
        int width = this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight();
        int paddingTop = this.mRecyclerView.getPaddingTop();
        int height = this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom();
        int left = view.getLeft() + rect.left;
        int top = view.getTop() + rect.top;
        int width2 = rect.width() + left;
        int height2 = rect.height() + top;
        int i3 = left - paddingLeft;
        int min = Math.min(0, i3);
        int max = Math.max(0, width2 - width);
        int i16 = top - paddingTop;
        int min2 = Math.min(0, i16);
        int max2 = Math.max(0, height2 - height);
        boolean canScrollHorizontally = this.mRecyclerView.getLayoutManager().canScrollHorizontally();
        boolean canScrollVertically = this.mRecyclerView.getLayoutManager().canScrollVertically();
        if (canScrollHorizontally) {
            if (min == 0) {
                min = Math.min(i3, max);
            }
        } else {
            min = 0;
        }
        if (canScrollVertically) {
            if (min2 == 0) {
                min2 = Math.min(i16, max2);
            }
        } else {
            min2 = 0;
        }
        if (min == 0 && min2 == 0) {
            return false;
        }
        HippyRecyclerView hippyRecyclerView = this.mRecyclerView;
        if (z16) {
            hippyRecyclerView.scrollBy(min, min2);
        } else {
            hippyRecyclerView.smoothScrollBy(min, min2);
        }
        this.mRecyclerView.postInvalidate();
        return true;
    }

    public void scrollToFocusChildHorizontal(View view) {
        view.getDrawingRect(this.mFocusRect);
        this.mRecyclerView.offsetDescendantRectToMyCoords(view, this.mFocusRect);
        int computeScrollDelta = computeScrollDelta(this.mFocusRect);
        if (computeScrollDelta != 0) {
            this.mRecyclerView.scrollBy(computeScrollDelta, 0);
        }
    }

    public void setKeyCode(int i3) {
        this.mKeyCode = i3;
    }

    public void setListData() {
        this.mFocusedView = null;
    }
}
