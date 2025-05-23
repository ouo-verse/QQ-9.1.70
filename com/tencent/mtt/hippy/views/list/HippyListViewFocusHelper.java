package com.tencent.mtt.hippy.views.list;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.StrictFocusFinder;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyListViewFocusHelper {
    private View mFocusedView;
    private int mKeyCode = 23;
    private HippyListView mListView;

    public HippyListViewFocusHelper(HippyListView hippyListView) {
        this.mListView = hippyListView;
    }

    private int getFirstFocusHeightBefore() {
        View focusedChild = this.mListView.getFocusedChild();
        int position = this.mListView.getLayoutManager().getPosition(focusedChild);
        if (focusedChild != null) {
            return this.mListView.getHeightBefore(position) + getRealFocusedChild(focusedChild).getHeight();
        }
        return this.mListView.getHeightBefore(position);
    }

    private int getOffset(View view, int i3) {
        int top;
        int height;
        if (isBottomEdge(i3)) {
            top = view.getTop() + view.getHeight();
            view = this.mListView;
        } else if (isTopEdge(i3)) {
            top = view.getBottom();
        } else {
            top = view.getTop() + (view.getHeight() / 2);
            height = this.mListView.getHeight() / 2;
            return top - height;
        }
        height = view.getHeight();
        return top - height;
    }

    private int getOffsetKeyDown(int i3) {
        if (this.mListView.getAdapter().getItemCount() == this.mListView.getChildCount()) {
            View childAt = this.mListView.getChildAt(r0.getChildCount() - 1);
            int top = (childAt.getTop() + childAt.getHeight()) - this.mListView.getHeight();
            if (i3 < 0) {
                i3 = 0;
            } else if (i3 > top) {
                i3 = top;
            }
            LogUtils.d("HippyListView", "requestChildFocus offset=" + i3 + ",max_bottom=" + top);
            return i3;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    private int getOffsetKeyUp(int i3) {
        if (this.mListView.getAdapter().getItemCount() == this.mListView.getChildCount()) {
            View childAt = this.mListView.getChildAt(0);
            int bottom = childAt.getBottom() - childAt.getHeight();
            if (i3 > 0) {
                i3 = 0;
            } else if (i3 < bottom) {
                i3 = bottom;
            }
            LogUtils.d("HippyListView", "requestChildFocus offset=" + i3 + ",max_top=" + bottom);
            return i3;
        }
        if (i3 > 0) {
            return 0;
        }
        return i3;
    }

    private View getParentRecycleItem(View view) {
        if (view instanceof RecyclerViewItem) {
            return view;
        }
        Object parent = view.getParent();
        if (parent == null) {
            return null;
        }
        return getParentRecycleItem((View) parent);
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
        if (this.mFocusedView == null && getFirstFocusHeightBefore() < this.mListView.getHeight()) {
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

    private boolean isVertical() {
        if (this.mListView.getLayoutManager() == null || ((LinearLayoutManager) this.mListView.getLayoutManager()).getOrientation() != 1) {
            return false;
        }
        return true;
    }

    private boolean isViewOfSameRecycleItem(View view, View view2) {
        if (view == view2 || getParentRecycleItem(view) == getParentRecycleItem(view2)) {
            return true;
        }
        return false;
    }

    public View focusSearch(View view, int i3) {
        View findNextFocus = StrictFocusFinder.getInstance().findNextFocus(this.mListView, view, i3);
        if (findNextFocus == null && this.mListView.getParent() != null) {
            return this.mListView.getParent().focusSearch(view, i3);
        }
        return findNextFocus;
    }

    public int getChildAdapterPosition(View view) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mListView.getLayoutManager();
        for (int i3 = 0; i3 < linearLayoutManager.getChildCount(); i3++) {
            if (linearLayoutManager.findViewByPosition(i3) == view) {
                return i3;
            }
        }
        return -1;
    }

    public int getChildDrawingOrder(int i3, int i16) {
        View focusedChild = this.mListView.getFocusedChild();
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
        if (this.mListView.getChildCount() == 0) {
            return 0;
        }
        return getChildAdapterPosition(this.mListView.getChildAt(0));
    }

    public boolean isBottomEdge(int i3) {
        if (!(this.mListView.getLayoutManager() instanceof LinearLayoutManager)) {
            return false;
        }
        if (isVertical() && i3 != this.mListView.getLayoutManager().getItemCount() - 1) {
            return false;
        }
        return true;
    }

    public boolean isScrollToFix(int i3, boolean z16) {
        if (z16 && this.mListView.getHeightBefore(i3) - this.mListView.getOffsetY() < this.mListView.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean isTopEdge(int i3) {
        if (!(this.mListView.getLayoutManager() instanceof LinearLayoutManager)) {
            return false;
        }
        if (isVertical() && i3 != 0) {
            return false;
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        View parentRecycleItem = getParentRecycleItem(view2);
        if (parentRecycleItem != null) {
            int offset = getOffset(parentRecycleItem, this.mListView.getLayoutManager().getPosition(this.mListView.getFocusedChild()));
            LogUtils.d("HippyListView", "requestChildFocus offset=" + offset);
            int i3 = this.mKeyCode;
            if (i3 == 20) {
                offset = getOffsetKeyDown(offset);
            } else if (i3 == 19) {
                offset = getOffsetKeyUp(offset);
            }
            if (!isNoFocusDoNothing() && !isSameItemDoNothing(view2)) {
                this.mListView.smoothScrollBy(0, offset);
            }
        }
        this.mFocusedView = view2;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        int paddingLeft = this.mListView.getPaddingLeft();
        int width = this.mListView.getWidth() - this.mListView.getPaddingRight();
        int paddingTop = this.mListView.getPaddingTop();
        int height = this.mListView.getHeight() - this.mListView.getPaddingBottom();
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
        boolean canScrollHorizontally = this.mListView.getLayoutManager().canScrollHorizontally();
        boolean canScrollVertically = this.mListView.getLayoutManager().canScrollVertically();
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
        HippyListView hippyListView = this.mListView;
        if (z16) {
            hippyListView.scrollBy(min, min2);
        } else {
            hippyListView.smoothScrollBy(min, min2);
        }
        this.mListView.postInvalidate();
        return true;
    }

    public void setKeyCode(int i3) {
        this.mKeyCode = i3;
    }

    public void setListData() {
        this.mFocusedView = null;
    }
}
