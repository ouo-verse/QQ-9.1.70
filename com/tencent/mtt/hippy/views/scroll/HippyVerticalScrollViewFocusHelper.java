package com.tencent.mtt.hippy.views.scroll;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.StrictFocusFinder;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyVerticalScrollViewFocusHelper {
    private static final String TAG = "HippyVerticalScrollViewFocusHelper";
    private HippyVerticalScrollView mScrollView;
    private Rect mFocusRect = new Rect();
    private int mFocusPosition = 0;

    public HippyVerticalScrollViewFocusHelper(HippyVerticalScrollView hippyVerticalScrollView) {
        this.mScrollView = null;
        this.mScrollView = hippyVerticalScrollView;
    }

    private int getFocusViewPosition(View view) {
        ViewGroup viewGroup = (ViewGroup) this.mScrollView.getChildAt(0);
        if (viewGroup == null) {
            return 0;
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            if (viewGroup.getChildAt(i3) == view) {
                return i3;
            }
        }
        return 0;
    }

    private boolean isChildRequestOnTouch(float f16, View view) {
        if (view.getTop() - this.mScrollView.getScrollY() < f16 && f16 < (view.getTop() - this.mScrollView.getScrollY()) + view.getHeight()) {
            return true;
        }
        return false;
    }

    private void setFocusPosition(int i3) {
        this.mFocusPosition = i3;
    }

    public boolean addFocusablesImp(ArrayList<View> arrayList, int i3, int i16) {
        ViewGroup viewGroup;
        if (this.mScrollView.hasFocus() || this.mScrollView.getDescendantFocusability() == 393216 || (viewGroup = (ViewGroup) this.mScrollView.getChildAt(0)) == null) {
            return false;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        for (int i17 = 0; i17 < viewGroup.getChildCount(); i17++) {
            View childAt = viewGroup.getChildAt(i17);
            if (childAt != null && childAt.getVisibility() == 0) {
                childAt.addFocusables(arrayList2, i3, i16);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(this.mScrollView);
            return true;
        }
        return true;
    }

    protected int computeScrollDelta(Rect rect) {
        int i3;
        int i16;
        int bottom;
        if (this.mScrollView.getChildCount() == 0) {
            return 0;
        }
        int height = this.mScrollView.getHeight();
        int scrollY = this.mScrollView.getScrollY();
        int i17 = scrollY + height;
        int verticalFadingEdgeLength = this.mScrollView.getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = this.mScrollView.getChildAt(0);
        if (childAt != null && rect.bottom < childAt.getHeight()) {
            i17 -= verticalFadingEdgeLength;
        }
        LogUtils.i(TAG, "computeScrollDelta height=" + height + ",screenTop=" + scrollY + ",screenBottom=" + i17 + ",fadingEdge=" + verticalFadingEdgeLength + ",rect=" + rect);
        int i18 = rect.bottom;
        if (i18 > i17 && rect.top > scrollY) {
            if (rect.height() > height) {
                i16 = rect.top - scrollY;
            } else {
                i16 = (rect.bottom - i17) + (height / 4);
            }
            int i19 = i16 + 0;
            if (childAt == null) {
                bottom = this.mScrollView.getBottom();
            } else {
                bottom = childAt.getBottom();
            }
            int i26 = bottom - i17;
            int min = Math.min(i19, i26);
            LogUtils.i(TAG, "computeScrollDelta bottom=" + bottom + ",distanceToBottom=" + i26 + ",scrollYDelta=" + min);
            return min;
        }
        if (rect.top >= scrollY || i18 >= i17) {
            return 0;
        }
        if (rect.height() > height) {
            i3 = 0 - (i17 - rect.bottom);
        } else {
            i3 = 0 - ((scrollY - rect.top) + (height / 4));
        }
        int max = Math.max(i3, -this.mScrollView.getScrollY());
        LogUtils.i(TAG, "computeScrollDelta getScrollY=" + this.mScrollView.getScrollY() + ",scrollYDelta=" + max);
        return max;
    }

    public View focusSearch(View view, int i3) {
        View findNextFocus = StrictFocusFinder.getInstance().findNextFocus(this.mScrollView, view, i3);
        if (findNextFocus == null && this.mScrollView.getParent() != null) {
            return this.mScrollView.getParent().focusSearch(view, i3);
        }
        return findNextFocus;
    }

    public int getFocusPosition() {
        return this.mFocusPosition;
    }

    public void handleRequestFocusFromTouch(MotionEvent motionEvent) {
        float y16 = motionEvent.getY();
        ViewGroup viewGroup = (ViewGroup) this.mScrollView.getChildAt(0);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (isChildRequestOnTouch(y16, childAt)) {
                childAt.requestFocusFromTouch();
                return;
            }
        }
    }

    public boolean requestFocusInDescendants(int i3, Rect rect) {
        View childAt;
        boolean z16;
        int focusPosition = getFocusPosition();
        ViewGroup viewGroup = (ViewGroup) this.mScrollView.getChildAt(0);
        if (viewGroup == null || (childAt = viewGroup.getChildAt(focusPosition)) == null) {
            return false;
        }
        if (childAt.requestFocus(i3, rect)) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.d("HippyVerticalScrollView", "requestFocusInDescendants  ret : " + z16);
        if (!z16) {
            if (Math.abs(focusPosition) <= Math.abs(focusPosition - viewGroup.getChildCount())) {
                for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
                    View childAt2 = viewGroup.getChildAt(i16);
                    if (childAt2 != null && childAt2.getVisibility() == 0 && childAt2.requestFocus(i3, rect)) {
                        return true;
                    }
                }
            } else {
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt3 = viewGroup.getChildAt(childCount);
                    if (childAt3 != null && childAt3.getVisibility() == 0 && childAt3.requestFocus(i3, rect)) {
                        return true;
                    }
                }
            }
        }
        return z16;
    }

    public void scrollToFocusChild(View view) {
        setFocusPosition(getFocusViewPosition(view));
        view.getDrawingRect(this.mFocusRect);
        this.mScrollView.offsetDescendantRectToMyCoords(view, this.mFocusRect);
        int computeScrollDelta = computeScrollDelta(this.mFocusRect);
        if (computeScrollDelta != 0) {
            this.mScrollView.smoothScrollBy(0, computeScrollDelta);
        }
    }
}
