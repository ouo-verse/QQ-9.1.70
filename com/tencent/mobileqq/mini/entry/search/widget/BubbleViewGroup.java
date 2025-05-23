package com.tencent.mobileqq.mini.entry.search.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class BubbleViewGroup extends ViewGroup {
    public static final int HORIZONTAL_SPACE;
    public static final int MAX_ROW = 3;
    public static final int VERTICAL_SPACE;
    private List<WarpLine> mRowLayoutList;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    static class Gravity {
        public static final int CENTER = 2;
        public static final int LEFT = 1;
        public static final int RIGHT = 0;

        Gravity() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private class WarpLine {
        private List<View> bubbleViews = new ArrayList();
        private int height = 0;
        private int lineWidth;

        WarpLine() {
            this.lineWidth = BubbleViewGroup.this.getPaddingLeft() + BubbleViewGroup.this.getPaddingRight();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addView(View view) {
            int measuredHeight;
            if (this.bubbleViews.size() != 0) {
                this.lineWidth += BubbleViewGroup.HORIZONTAL_SPACE;
            }
            if (this.height > view.getMeasuredHeight()) {
                measuredHeight = this.height;
            } else {
                measuredHeight = view.getMeasuredHeight();
            }
            this.height = measuredHeight;
            this.lineWidth += view.getMeasuredWidth();
            this.bubbleViews.add(view);
        }
    }

    public BubbleViewGroup(Context context) {
        super(context);
    }

    public int getGravity() {
        return 1;
    }

    public boolean isFull() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int measuredWidth;
        int i19;
        int paddingTop = getPaddingTop();
        for (int i26 = 0; i26 < this.mRowLayoutList.size(); i26++) {
            int paddingLeft = getPaddingLeft();
            WarpLine warpLine = this.mRowLayoutList.get(i26);
            int measuredWidth2 = getMeasuredWidth() - warpLine.lineWidth;
            for (int i27 = 0; i27 < warpLine.bubbleViews.size(); i27++) {
                View view = (View) warpLine.bubbleViews.get(i27);
                if (isFull()) {
                    view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft + (measuredWidth2 / warpLine.bubbleViews.size()), view.getMeasuredHeight() + paddingTop);
                    measuredWidth = view.getMeasuredWidth() + HORIZONTAL_SPACE;
                    i19 = measuredWidth2 / warpLine.bubbleViews.size();
                } else {
                    int gravity = getGravity();
                    if (gravity == 0) {
                        int i28 = paddingLeft + measuredWidth2;
                        view.layout(i28, paddingTop, view.getMeasuredWidth() + i28, view.getMeasuredHeight() + paddingTop);
                    } else if (gravity != 2) {
                        view.layout(paddingLeft, paddingTop, view.getMeasuredWidth() + paddingLeft, view.getMeasuredHeight() + paddingTop);
                    } else {
                        int i29 = (measuredWidth2 / 2) + paddingLeft;
                        view.layout(i29, paddingTop, view.getMeasuredWidth() + i29, view.getMeasuredHeight() + paddingTop);
                    }
                    measuredWidth = view.getMeasuredWidth();
                    i19 = HORIZONTAL_SPACE;
                }
                paddingLeft += measuredWidth + i19;
            }
            paddingTop += warpLine.height + VERTICAL_SPACE;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        int childCount = getChildCount();
        measureChildren(i3, i16);
        if (mode == Integer.MIN_VALUE) {
            int i17 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                if (i18 != 0) {
                    i17 += HORIZONTAL_SPACE;
                }
                i17 += getChildAt(i18).getMeasuredWidth();
            }
            int paddingLeft = i17 + getPaddingLeft() + getPaddingRight();
            if (paddingLeft <= size) {
                size = paddingLeft;
            }
        } else if (mode == 0) {
            int i19 = 0;
            for (int i26 = 0; i26 < childCount; i26++) {
                if (i26 != 0) {
                    i19 += HORIZONTAL_SPACE;
                }
                i19 += getChildAt(i26).getMeasuredWidth();
            }
            size = i19 + getPaddingLeft() + getPaddingRight();
        }
        WarpLine warpLine = new WarpLine();
        this.mRowLayoutList = new ArrayList();
        for (int i27 = 0; i27 < childCount && this.mRowLayoutList.size() < 3; i27++) {
            if (warpLine.lineWidth + getChildAt(i27).getMeasuredWidth() + HORIZONTAL_SPACE <= size) {
                warpLine.addView(getChildAt(i27));
            } else if (warpLine.bubbleViews.size() == 0) {
                warpLine.addView(getChildAt(i27));
                this.mRowLayoutList.add(warpLine);
                warpLine = new WarpLine();
            } else {
                this.mRowLayoutList.add(warpLine);
                warpLine = new WarpLine();
                warpLine.addView(getChildAt(i27));
            }
        }
        if (warpLine.bubbleViews.size() > 0 && !this.mRowLayoutList.contains(warpLine) && this.mRowLayoutList.size() < 3) {
            this.mRowLayoutList.add(warpLine);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        for (int i28 = 0; i28 < this.mRowLayoutList.size(); i28++) {
            if (i28 != 0) {
                paddingTop += VERTICAL_SPACE;
            }
            paddingTop += this.mRowLayoutList.get(i28).height;
        }
        if (mode2 == Integer.MIN_VALUE ? paddingTop <= size2 : mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public BubbleViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    static {
        int dpToPx = ViewUtils.dpToPx(12.0f);
        HORIZONTAL_SPACE = dpToPx;
        VERTICAL_SPACE = dpToPx;
    }
}
