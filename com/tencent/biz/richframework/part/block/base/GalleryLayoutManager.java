package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GalleryLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    View mCurSelectedView;
    private OrientationHelper mHorizontalHelper;
    private ItemTransformer mItemTransformer;
    private int mOrientation;
    RecyclerView mRecyclerView;
    private State mState;
    private OrientationHelper mVerticalHelper;
    private int mFirstVisiblePosition = 0;
    private int mLastVisiblePos = 0;
    private int mInitialSelectedPosition = 0;
    int mCurSelectedPosition = -1;
    private LinearSnapHelper mSnapHelper = new LinearSnapHelper();
    private InnerScrollListener mInnerScrollListener = new InnerScrollListener();
    private boolean mCallbackInFling = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class GallerySmoothScroller extends LinearSmoothScroller {
        public GallerySmoothScroller(Context context) {
            super(context);
        }

        public int calculateDxToMakeCentral(View view) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null && layoutManager.canScrollHorizontally()) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                int decoratedLeft = layoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                int decoratedRight = layoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                return ((int) (((layoutManager.getWidth() - layoutManager.getPaddingRight()) - layoutManager.getPaddingLeft()) / 2.0f)) - (decoratedLeft + ((int) ((decoratedRight - decoratedLeft) / 2.0f)));
            }
            return 0;
        }

        public int calculateDyToMakeCentral(View view) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager != null && layoutManager.canScrollVertically()) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                int decoratedTop = layoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                int decoratedBottom = layoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                return ((int) (((layoutManager.getHeight() - layoutManager.getPaddingBottom()) - layoutManager.getPaddingTop()) / 2.0f)) - (decoratedTop + ((int) ((decoratedBottom - decoratedTop) / 2.0f)));
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i3) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
                return ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i3);
            }
            Log.w("GalleryLayoutManager", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView.SmoothScroller.ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        protected void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            int calculateDxToMakeCentral = calculateDxToMakeCentral(view);
            int calculateDyToMakeCentral = calculateDyToMakeCentral(view);
            int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((calculateDxToMakeCentral * calculateDxToMakeCentral) + (calculateDyToMakeCentral * calculateDyToMakeCentral)));
            if (calculateTimeForDeceleration > 0) {
                action.update(-calculateDxToMakeCentral, -calculateDyToMakeCentral, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class InnerScrollListener extends RecyclerView.OnScrollListener {
        boolean mCallbackOnIdle;
        int mState;

        InnerScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            this.mState = i3;
            if (RFWApplication.isDebug()) {
                Log.v("GalleryLayoutManager", "onScrollStateChanged: " + i3);
            }
            if (this.mState == 0) {
                View findSnapView = GalleryLayoutManager.this.mSnapHelper.findSnapView(recyclerView.getLayoutManager());
                if (findSnapView != null) {
                    int position = recyclerView.getLayoutManager().getPosition(findSnapView);
                    GalleryLayoutManager galleryLayoutManager = GalleryLayoutManager.this;
                    if (position != galleryLayoutManager.mCurSelectedPosition) {
                        View view = galleryLayoutManager.mCurSelectedView;
                        if (view != null) {
                            view.setSelected(false);
                        }
                        GalleryLayoutManager.this.mCurSelectedView = findSnapView;
                        findSnapView.setSelected(true);
                        GalleryLayoutManager galleryLayoutManager2 = GalleryLayoutManager.this;
                        galleryLayoutManager2.mCurSelectedPosition = position;
                        GalleryLayoutManager.access$300(galleryLayoutManager2);
                        return;
                    }
                    if (!galleryLayoutManager.mCallbackInFling) {
                        GalleryLayoutManager.access$300(GalleryLayoutManager.this);
                        return;
                    }
                    return;
                }
                Log.e("GalleryLayoutManager", "onScrollStateChanged: snap null");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            View findSnapView = GalleryLayoutManager.this.mSnapHelper.findSnapView(recyclerView.getLayoutManager());
            if (findSnapView != null) {
                int position = recyclerView.getLayoutManager().getPosition(findSnapView);
                GalleryLayoutManager galleryLayoutManager = GalleryLayoutManager.this;
                if (position != galleryLayoutManager.mCurSelectedPosition) {
                    View view = galleryLayoutManager.mCurSelectedView;
                    if (view != null) {
                        view.setSelected(false);
                    }
                    GalleryLayoutManager.this.mCurSelectedView = findSnapView;
                    findSnapView.setSelected(true);
                    GalleryLayoutManager galleryLayoutManager2 = GalleryLayoutManager.this;
                    galleryLayoutManager2.mCurSelectedPosition = position;
                    if (!galleryLayoutManager2.mCallbackInFling && this.mState != 0) {
                        if (RFWApplication.isDebug()) {
                            Log.v("GalleryLayoutManager", "ignore selection change callback when fling ");
                        }
                        this.mCallbackOnIdle = true;
                        return;
                    }
                    GalleryLayoutManager.access$300(GalleryLayoutManager.this);
                }
            }
            if (RFWApplication.isDebug()) {
                Log.v("GalleryLayoutManager", "onScrolled: dx:" + i3 + ",dy:" + i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ItemTransformer {
        void transformItem(GalleryLayoutManager galleryLayoutManager, View view, float f16);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnItemSelectedListener {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class State {
        SparseArray<Rect> mItemsFrames = new SparseArray<>();
        int mScrollDelta = 0;

        public State() {
        }
    }

    public GalleryLayoutManager(int i3) {
        this.mOrientation = i3;
    }

    static /* synthetic */ OnItemSelectedListener access$300(GalleryLayoutManager galleryLayoutManager) {
        galleryLayoutManager.getClass();
        return null;
    }

    private int calculateDistanceCenter(View view, float f16) {
        float height;
        int top;
        OrientationHelper orientationHelper = getOrientationHelper();
        int endAfterPadding = ((orientationHelper.getEndAfterPadding() - orientationHelper.getStartAfterPadding()) / 2) + orientationHelper.getStartAfterPadding();
        if (this.mOrientation == 0) {
            height = (view.getWidth() / 2) - f16;
            top = view.getLeft();
        } else {
            height = (view.getHeight() / 2) - f16;
            top = view.getTop();
        }
        return (int) ((height + top) - endAfterPadding);
    }

    private int calculateScrollDirectionForPosition(int i3) {
        if (getChildCount() == 0 || i3 < this.mFirstVisiblePosition) {
            return -1;
        }
        return 1;
    }

    private float calculateToCenterFraction(View view, float f16) {
        int height;
        int calculateDistanceCenter = calculateDistanceCenter(view, f16);
        if (this.mOrientation == 0) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        if (RFWApplication.isDebug()) {
            Log.d("GalleryLayoutManager", "calculateToCenterFraction: distance:" + calculateDistanceCenter + ",childLength:" + height);
        }
        return Math.max(-1.0f, Math.min(1.0f, (calculateDistanceCenter * 1.0f) / height));
    }

    private void fillBottom(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        Rect rect = new Rect();
        int horizontalSpace = getHorizontalSpace();
        while (i3 < getItemCount() && i16 < i17) {
            View viewForPosition = recycler.getViewForPosition(i3);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - r2) / 2.0f));
            rect.set(paddingLeft, i16, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + i16);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i16 = rect.bottom;
            this.mLastVisiblePos = i3;
            if (getState().mItemsFrames.get(i3) == null) {
                getState().mItemsFrames.put(i3, rect);
            } else {
                getState().mItemsFrames.get(i3).set(rect);
            }
            i3++;
        }
    }

    private void fillCover(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (getItemCount() == 0) {
            return;
        }
        if (this.mOrientation == 0) {
            fillWithHorizontal(recycler, state, i3);
        } else {
            fillWithVertical(recycler, state, i3);
        }
        if (this.mItemTransformer != null) {
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                this.mItemTransformer.transformItem(this, childAt, calculateToCenterFraction(childAt, i3));
            }
        }
    }

    private void fillLeft(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        Rect rect = new Rect();
        int verticalSpace = getVerticalSpace();
        while (i3 >= 0 && i16 > i17) {
            View viewForPosition = recycler.getViewForPosition(i3);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingTop = (int) (getPaddingTop() + ((verticalSpace - r4) / 2.0f));
            rect.set(i16 - getDecoratedMeasuredWidth(viewForPosition), paddingTop, i16, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i16 = rect.left;
            this.mFirstVisiblePosition = i3;
            if (getState().mItemsFrames.get(i3) == null) {
                getState().mItemsFrames.put(i3, rect);
            } else {
                getState().mItemsFrames.get(i3).set(rect);
            }
            i3--;
        }
    }

    private void fillRight(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        Rect rect = new Rect();
        int verticalSpace = getVerticalSpace();
        while (i3 < getItemCount() && i16 < i17) {
            View viewForPosition = recycler.getViewForPosition(i3);
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingTop = (int) (getPaddingTop() + ((verticalSpace - r3) / 2.0f));
            rect.set(i16, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + i16, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i16 = rect.right;
            this.mLastVisiblePos = i3;
            if (getState().mItemsFrames.get(i3) == null) {
                getState().mItemsFrames.put(i3, rect);
            } else {
                getState().mItemsFrames.get(i3).set(rect);
            }
            i3++;
        }
    }

    private void fillTop(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        Rect rect = new Rect();
        int horizontalSpace = getHorizontalSpace();
        while (i3 >= 0 && i16 > i17) {
            View viewForPosition = recycler.getViewForPosition(i3);
            addView(viewForPosition, 0);
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - decoratedMeasuredWidth) / 2.0f));
            rect.set(paddingLeft, i16 - getDecoratedMeasuredHeight(viewForPosition), decoratedMeasuredWidth + paddingLeft, i16);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i16 = rect.top;
            this.mFirstVisiblePosition = i3;
            if (getState().mItemsFrames.get(i3) == null) {
                getState().mItemsFrames.put(i3, rect);
            } else {
                getState().mItemsFrames.get(i3).set(rect);
            }
            i3--;
        }
    }

    private void fillWithHorizontal(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        int startAfterPadding = getOrientationHelper().getStartAfterPadding();
        int endAfterPadding = getOrientationHelper().getEndAfterPadding();
        if (RFWApplication.isDebug()) {
            Log.v("GalleryLayoutManager", "fillWithHorizontal() called with: dx = [" + i3 + "],leftEdge:" + startAfterPadding + ",rightEdge:" + endAfterPadding);
        }
        removeAndRecycleChildView(recycler, i3, startAfterPadding, endAfterPadding);
        int i16 = this.mFirstVisiblePosition;
        int verticalSpace = getVerticalSpace();
        if (i3 >= 0) {
            handlePositiveX(recycler, i3, endAfterPadding, i16, -1, verticalSpace);
        } else {
            handleNegativeX(recycler, i3, startAfterPadding, i16, -1, verticalSpace);
        }
    }

    private void fillWithVertical(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        int startAfterPadding = getOrientationHelper().getStartAfterPadding();
        int endAfterPadding = getOrientationHelper().getEndAfterPadding();
        removeAndRecycleViewWithVertical(recycler, i3, startAfterPadding, endAfterPadding);
        int i16 = this.mFirstVisiblePosition;
        int horizontalSpace = getHorizontalSpace();
        if (i3 >= 0) {
            handleReAttachItemWithPositiveY(recycler, i3, endAfterPadding, i16, -1, horizontalSpace);
        } else {
            handleReAttachItemWithNegativeY(recycler, i3, startAfterPadding, i16, -1, horizontalSpace);
        }
    }

    private void firstFillCover(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (this.mOrientation == 0) {
            firstFillWithHorizontal(recycler, state);
        } else {
            firstFillWithVertical(recycler, state);
        }
        if (this.mItemTransformer != null) {
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                View childAt = getChildAt(i16);
                this.mItemTransformer.transformItem(this, childAt, calculateToCenterFraction(childAt, i3));
            }
        }
        this.mInnerScrollListener.onScrolled(this.mRecyclerView, 0, 0);
    }

    private void firstFillWithHorizontal(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int startAfterPadding = getOrientationHelper().getStartAfterPadding();
        int endAfterPadding = getOrientationHelper().getEndAfterPadding();
        int i3 = this.mInitialSelectedPosition;
        Rect rect = new Rect();
        int verticalSpace = getVerticalSpace();
        View viewForPosition = recycler.getViewForPosition(this.mInitialSelectedPosition);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int paddingTop = (int) (getPaddingTop() + ((verticalSpace - r6) / 2.0f));
        int paddingLeft = (int) (getPaddingLeft() + ((getHorizontalSpace() - r5) / 2.0f));
        rect.set(paddingLeft, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
        layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
        if (getState().mItemsFrames.get(i3) == null) {
            getState().mItemsFrames.put(i3, rect);
        } else {
            getState().mItemsFrames.get(i3).set(rect);
        }
        this.mLastVisiblePos = i3;
        this.mFirstVisiblePosition = i3;
        int decoratedLeft = getDecoratedLeft(viewForPosition);
        int decoratedRight = getDecoratedRight(viewForPosition);
        fillLeft(recycler, this.mInitialSelectedPosition - 1, decoratedLeft, startAfterPadding);
        fillRight(recycler, this.mInitialSelectedPosition + 1, decoratedRight, endAfterPadding);
    }

    private void firstFillWithVertical(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int startAfterPadding = getOrientationHelper().getStartAfterPadding();
        int endAfterPadding = getOrientationHelper().getEndAfterPadding();
        int i3 = this.mInitialSelectedPosition;
        Rect rect = new Rect();
        int horizontalSpace = getHorizontalSpace();
        View viewForPosition = recycler.getViewForPosition(this.mInitialSelectedPosition);
        addView(viewForPosition, 0);
        measureChildWithMargins(viewForPosition, 0, 0);
        int paddingLeft = (int) (getPaddingLeft() + ((horizontalSpace - r5) / 2.0f));
        int paddingTop = (int) (getPaddingTop() + ((getVerticalSpace() - r6) / 2.0f));
        rect.set(paddingLeft, paddingTop, getDecoratedMeasuredWidth(viewForPosition) + paddingLeft, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
        layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
        if (getState().mItemsFrames.get(i3) == null) {
            getState().mItemsFrames.put(i3, rect);
        } else {
            getState().mItemsFrames.get(i3).set(rect);
        }
        this.mLastVisiblePos = i3;
        this.mFirstVisiblePosition = i3;
        int decoratedTop = getDecoratedTop(viewForPosition);
        int decoratedBottom = getDecoratedBottom(viewForPosition);
        fillTop(recycler, this.mInitialSelectedPosition - 1, decoratedTop, startAfterPadding);
        fillBottom(recycler, this.mInitialSelectedPosition + 1, decoratedBottom, endAfterPadding);
    }

    private int getHorizontalSpace() {
        return (getWidth() - getPaddingRight()) - getPaddingLeft();
    }

    private int getVerticalSpace() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    private void handleNegativeX(RecyclerView.Recycler recycler, int i3, int i16, int i17, int i18, int i19) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int position = getPosition(childAt) - 1;
            int decoratedLeft = getDecoratedLeft(childAt);
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "fillWithHorizontal:to left startPosition:" + position + ",startOffset:" + decoratedLeft + ",leftEdge:" + i16 + ",child count:" + getChildCount());
            }
            i18 = decoratedLeft;
            i17 = position;
        }
        while (i17 >= 0 && i18 > i16 + i3) {
            Rect rect = getState().mItemsFrames.get(i17);
            View viewForPosition = recycler.getViewForPosition(i17);
            addView(viewForPosition, 0);
            if (rect == null) {
                rect = new Rect();
                getState().mItemsFrames.put(i17, rect);
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            int paddingTop = (int) (getPaddingTop() + ((i19 - r4) / 2.0f));
            rect.set(i18 - getDecoratedMeasuredWidth(viewForPosition), paddingTop, i18, getDecoratedMeasuredHeight(viewForPosition) + paddingTop);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i18 = rect.left;
            this.mFirstVisiblePosition = i17;
            i17--;
        }
    }

    private void handlePositiveX(RecyclerView.Recycler recycler, int i3, int i16, int i17, int i18, int i19) {
        int i26;
        int i27;
        if (getChildCount() != 0) {
            View childAt = getChildAt(getChildCount() - 1);
            int position = getPosition(childAt) + 1;
            i27 = getDecoratedRight(childAt);
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "fillWithHorizontal:to right startPosition:" + position + ",startOffset:" + i27 + ",rightEdge:" + i16);
            }
            i26 = position;
        } else {
            i26 = i17;
            i27 = i18;
        }
        for (int i28 = i26; i28 < getItemCount() && i27 < i16 + i3; i28++) {
            Rect rect = getState().mItemsFrames.get(i28);
            View viewForPosition = recycler.getViewForPosition(i28);
            addView(viewForPosition);
            if (rect == null) {
                rect = new Rect();
                getState().mItemsFrames.put(i28, rect);
            }
            Rect rect2 = rect;
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int paddingTop = (int) (getPaddingTop() + ((i19 - decoratedMeasuredHeight) / 2.0f));
            if (i27 == -1 && i26 == 0) {
                int paddingLeft = (int) (getPaddingLeft() + ((getHorizontalSpace() - decoratedMeasuredWidth) / 2.0f));
                rect2.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
            } else {
                rect2.set(i27, paddingTop, decoratedMeasuredWidth + i27, decoratedMeasuredHeight + paddingTop);
            }
            layoutDecorated(viewForPosition, rect2.left, rect2.top, rect2.right, rect2.bottom);
            i27 = rect2.right;
            this.mLastVisiblePos = i28;
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "fillWithHorizontal,layout:mLastVisiblePos: " + this.mLastVisiblePos);
            }
        }
    }

    private void handleReAttachItemWithNegativeY(RecyclerView.Recycler recycler, int i3, int i16, int i17, int i18, int i19) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int position = getPosition(childAt) - 1;
            i18 = getDecoratedTop(childAt);
            i17 = position;
        }
        while (i17 >= 0 && i18 > i16 + i3) {
            Rect rect = getState().mItemsFrames.get(i17);
            View viewForPosition = recycler.getViewForPosition(i17);
            addView(viewForPosition, 0);
            if (rect == null) {
                rect = new Rect();
                getState().mItemsFrames.put(i17, rect);
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((i19 - decoratedMeasuredWidth) / 2.0f));
            rect.set(paddingLeft, i18 - getDecoratedMeasuredHeight(viewForPosition), decoratedMeasuredWidth + paddingLeft, i18);
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i18 = rect.top;
            this.mFirstVisiblePosition = i17;
            i17--;
        }
    }

    private void handleReAttachItemWithPositiveY(RecyclerView.Recycler recycler, int i3, int i16, int i17, int i18, int i19) {
        if (getChildCount() != 0) {
            View childAt = getChildAt(getChildCount() - 1);
            int position = getPosition(childAt) + 1;
            i18 = getDecoratedBottom(childAt);
            i17 = position;
        }
        for (int i26 = i17; i26 < getItemCount() && i18 < i16 + i3; i26++) {
            Rect rect = getState().mItemsFrames.get(i26);
            View viewForPosition = recycler.getViewForPosition(i26);
            addView(viewForPosition);
            if (rect == null) {
                rect = new Rect();
                getState().mItemsFrames.put(i26, rect);
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition);
            int paddingLeft = (int) (getPaddingLeft() + ((i19 - decoratedMeasuredWidth) / 2.0f));
            if (i18 == -1 && i17 == 0) {
                int paddingTop = (int) (getPaddingTop() + ((getVerticalSpace() - decoratedMeasuredHeight) / 2.0f));
                rect.set(paddingLeft, paddingTop, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + paddingTop);
            } else {
                rect.set(paddingLeft, i18, decoratedMeasuredWidth + paddingLeft, decoratedMeasuredHeight + i18);
            }
            layoutDecorated(viewForPosition, rect.left, rect.top, rect.right, rect.bottom);
            i18 = rect.bottom;
            this.mLastVisiblePos = i26;
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "fillWithVertical: add view:" + i26 + ",startOffset:" + i18 + ",mLastVisiblePos:" + this.mLastVisiblePos + ",bottomEdge" + i16);
            }
        }
    }

    private void removeAndRecycleChildView(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        if (getChildCount() > 0) {
            if (i3 >= 0) {
                int i18 = 0;
                for (int i19 = 0; i19 < getChildCount(); i19++) {
                    View childAt = getChildAt(i19 + i18);
                    if (getDecoratedRight(childAt) - i3 < i16) {
                        removeAndRecycleView(childAt, recycler);
                        this.mFirstVisiblePosition++;
                        i18--;
                        if (RFWApplication.isDebug()) {
                            Log.v("GalleryLayoutManager", "fillWithHorizontal:removeAndRecycleView:" + getPosition(childAt) + " mFirstVisiblePosition change to:" + this.mFirstVisiblePosition);
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt2 = getChildAt(childCount);
                if (getDecoratedLeft(childAt2) - i3 > i17) {
                    removeAndRecycleView(childAt2, recycler);
                    this.mLastVisiblePos--;
                    if (RFWApplication.isDebug()) {
                        Log.v("GalleryLayoutManager", "fillWithHorizontal:removeAndRecycleView:" + getPosition(childAt2) + "mLastVisiblePos change to:" + this.mLastVisiblePos);
                    }
                }
            }
        }
    }

    private void removeAndRecycleViewWithVertical(RecyclerView.Recycler recycler, int i3, int i16, int i17) {
        if (getChildCount() > 0) {
            if (i3 >= 0) {
                int i18 = 0;
                for (int i19 = 0; i19 < getChildCount(); i19++) {
                    View childAt = getChildAt(i19 + i18);
                    if (getDecoratedBottom(childAt) - i3 < i16) {
                        if (RFWApplication.isDebug()) {
                            Log.v("GalleryLayoutManager", "fillWithVertical: removeAndRecycleView:" + getPosition(childAt) + ",bottom:" + getDecoratedBottom(childAt));
                        }
                        removeAndRecycleView(childAt, recycler);
                        this.mFirstVisiblePosition++;
                        i18--;
                    } else {
                        if (RFWApplication.isDebug()) {
                            Log.d("GalleryLayoutManager", "fillWithVertical: break:" + getPosition(childAt) + ",bottom:" + getDecoratedBottom(childAt));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt2 = getChildAt(childCount);
                if (getDecoratedTop(childAt2) - i3 > i17) {
                    if (RFWApplication.isDebug()) {
                        Log.v("GalleryLayoutManager", "fillWithVertical: removeAndRecycleView:" + getPosition(childAt2));
                    }
                    removeAndRecycleView(childAt2, recycler);
                    this.mLastVisiblePos--;
                } else {
                    return;
                }
            }
        }
    }

    private void reset() {
        State state = this.mState;
        if (state != null) {
            state.mItemsFrames.clear();
        }
        int i3 = this.mCurSelectedPosition;
        if (i3 != -1) {
            this.mInitialSelectedPosition = i3;
        }
        int min = Math.min(Math.max(0, this.mInitialSelectedPosition), getItemCount() - 1);
        this.mInitialSelectedPosition = min;
        this.mFirstVisiblePosition = min;
        this.mLastVisiblePos = min;
        this.mCurSelectedPosition = -1;
        View view = this.mCurSelectedView;
        if (view != null) {
            view.setSelected(false);
            this.mCurSelectedView = null;
        }
    }

    public void attach(RecyclerView recyclerView, int i3) {
        if (recyclerView != null) {
            this.mRecyclerView = recyclerView;
            this.mInitialSelectedPosition = Math.max(0, i3);
            recyclerView.setLayoutManager(this);
            this.mSnapHelper.attachToRecyclerView(recyclerView);
            recyclerView.addOnScrollListener(this.mInnerScrollListener);
            return;
        }
        throw new IllegalArgumentException("The attach RecycleView must not null!!");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i3) {
        int calculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i3);
        PointF pointF = new PointF();
        if (calculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = calculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = calculateScrollDirectionForPosition;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return new LayoutParams(-2, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public OrientationHelper getOrientationHelper() {
        if (this.mOrientation == 0) {
            if (this.mHorizontalHelper == null) {
                this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(this);
            }
            return this.mHorizontalHelper;
        }
        if (this.mVerticalHelper == null) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(this);
        }
        return this.mVerticalHelper;
    }

    public State getState() {
        if (this.mState == null) {
            this.mState = new State();
        }
        return this.mState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        super.onItemsRemoved(recyclerView, i3, i16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() == 0) {
            reset();
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (state.isPreLayout()) {
            return;
        }
        if (state.getItemCount() != 0 && !state.didStructureChange()) {
            return;
        }
        if (getChildCount() == 0 || state.didStructureChange()) {
            reset();
        }
        this.mInitialSelectedPosition = Math.min(Math.max(0, this.mInitialSelectedPosition), getItemCount() - 1);
        detachAndScrapAttachedViews(recycler);
        firstFillCover(recycler, state, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int min;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        int i16 = -i3;
        int endAfterPadding = ((getOrientationHelper().getEndAfterPadding() - getOrientationHelper().getStartAfterPadding()) / 2) + getOrientationHelper().getStartAfterPadding();
        if (i3 > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                min = Math.max(0, Math.min(i3, (((childAt.getRight() - childAt.getLeft()) / 2) + childAt.getLeft()) - endAfterPadding));
                i16 = -min;
            }
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "scrollHorizontallyBy: dx:" + i3 + ",fixed:" + i16);
            }
            int i17 = -i16;
            getState().mScrollDelta = i17;
            fillCover(recycler, state, i17);
            offsetChildrenHorizontal(i16);
            return i17;
        }
        if (this.mFirstVisiblePosition == 0) {
            View childAt2 = getChildAt(0);
            min = Math.min(0, Math.max(i3, (((childAt2.getRight() - childAt2.getLeft()) / 2) + childAt2.getLeft()) - endAfterPadding));
            i16 = -min;
        }
        if (RFWApplication.isDebug()) {
        }
        int i172 = -i16;
        getState().mScrollDelta = i172;
        fillCover(recycler, state, i172);
        offsetChildrenHorizontal(i16);
        return i172;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int min;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        int i16 = -i3;
        int endAfterPadding = ((getOrientationHelper().getEndAfterPadding() - getOrientationHelper().getStartAfterPadding()) / 2) + getOrientationHelper().getStartAfterPadding();
        if (i3 > 0) {
            if (getPosition(getChildAt(getChildCount() - 1)) == getItemCount() - 1) {
                View childAt = getChildAt(getChildCount() - 1);
                min = Math.max(0, Math.min(i3, (((getDecoratedBottom(childAt) - getDecoratedTop(childAt)) / 2) + getDecoratedTop(childAt)) - endAfterPadding));
                i16 = -min;
            }
            if (RFWApplication.isDebug()) {
                Log.d("GalleryLayoutManager", "scrollVerticallyBy: dy:" + i3 + ",fixed:" + i16);
            }
            int i17 = -i16;
            getState().mScrollDelta = i17;
            fillCover(recycler, state, i17);
            offsetChildrenVertical(i16);
            return i17;
        }
        if (this.mFirstVisiblePosition == 0) {
            View childAt2 = getChildAt(0);
            min = Math.min(0, Math.max(i3, (((getDecoratedBottom(childAt2) - getDecoratedTop(childAt2)) / 2) + getDecoratedTop(childAt2)) - endAfterPadding));
            i16 = -min;
        }
        if (RFWApplication.isDebug()) {
        }
        int i172 = -i16;
        getState().mScrollDelta = i172;
        fillCover(recycler, state, i172);
        offsetChildrenVertical(i16);
        return i172;
    }

    public void setCallbackInFling(boolean z16) {
        this.mCallbackInFling = z16;
    }

    public void setItemTransformer(ItemTransformer itemTransformer) {
        this.mItemTransformer = itemTransformer;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        GallerySmoothScroller gallerySmoothScroller = new GallerySmoothScroller(recyclerView.getContext());
        gallerySmoothScroller.setTargetPosition(i3);
        startSmoothScroll(gallerySmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
