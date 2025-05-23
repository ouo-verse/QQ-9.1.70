package com.tencent.ad.tangram.widget.carouselcard;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class TGCarouselCardLayoutManager extends RecyclerView.LayoutManager {
    private static final int FINGER_MOVE_FROM_LEFT_TO_RIGHT = 0;
    private static final int FINGER_MOVE_FROM_RIGHT_TO_LEFT = 1;
    private static final int FINGER_MOVE_UNKNOWN = Integer.MIN_VALUE;
    private static final int MIN_FLING_VELOCITY = 1000;
    private int mItemHeightPx;
    private int mItemMinimumHeightPx;
    private int mItemMinimumWidthPx;
    private int mItemWidthPx;
    private int mMaxVisibleItemCount;
    private TGCarouselCardLayoutManagerParams mParams;
    private RecyclerView mRecyclerView;
    private int mScrollToNextItemOffsetPx;
    private int mTotalOffsetPx;
    private WeakReference<? extends IOnItemScrollListener> mWeakOnScrollListener;
    private int mFirstVisibleItemVirtualPosition = Integer.MIN_VALUE;
    private int mLastSelectedItemVirtualPosition = 0;
    private boolean mIsScrollFixedFlag = true;
    private boolean mIsScrolledToTheLeftEnd = false;
    private int mBaseOffsetPx = 0;
    private int mScrollState = 0;
    private int mFlingDirection = Integer.MIN_VALUE;
    private boolean mShouldUpdateData = true;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ILog {
        void e(String str);

        void i(String str);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface IOnItemScrollListener {
        void onItemScrolled(int i3, int i16);
    }

    TGCarouselCardLayoutManager(RecyclerView recyclerView) {
        if (recyclerView != null) {
            recyclerView.setOnFlingListener(getOnFlingListener());
            this.mRecyclerView = recyclerView;
        }
    }

    public static TGCarouselCardLayoutManager build(RecyclerView recyclerView, TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams) {
        if (tGCarouselCardLayoutManagerParams != null && tGCarouselCardLayoutManagerParams.isValid() && recyclerView != null) {
            TGCarouselCardLayoutManager tGCarouselCardLayoutManager = new TGCarouselCardLayoutManager(recyclerView);
            try {
                tGCarouselCardLayoutManager.mParams = (TGCarouselCardLayoutManagerParams) tGCarouselCardLayoutManagerParams.clone();
                return tGCarouselCardLayoutManager;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private void fillScreen(RecyclerView.Recycler recycler) {
        layout(recycler);
        recycleItems(recycler);
    }

    private int getAppropriateItemVirtualPosition() {
        int i3 = this.mFlingDirection;
        this.mFlingDirection = Integer.MIN_VALUE;
        if (i3 == 0) {
            return this.mFirstVisibleItemVirtualPosition;
        }
        if (i3 == 1) {
            return this.mFirstVisibleItemVirtualPosition + 1;
        }
        float firstVisibleItemConsumedFraction = getFirstVisibleItemConsumedFraction();
        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams = this.mParams;
        if (tGCarouselCardLayoutManagerParams != null && tGCarouselCardLayoutManagerParams.isValid() && firstVisibleItemConsumedFraction >= this.mParams.scrollThreshold) {
            return this.mFirstVisibleItemVirtualPosition + 1;
        }
        return this.mFirstVisibleItemVirtualPosition;
    }

    private int getDecoratedMeasuredHeightWithMargin(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return getDecoratedMeasuredHeight(view);
    }

    private int getDecoratedMeasuredWidthWithMargin(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        return getDecoratedMeasuredWidth(view);
    }

    private float getFirstVisibleItemConsumedFraction() {
        if (this.mScrollToNextItemOffsetPx <= 0) {
            return 0.0f;
        }
        int firstVisibleItemConsumedOffsetPx = getFirstVisibleItemConsumedOffsetPx();
        float f16 = firstVisibleItemConsumedOffsetPx / this.mScrollToNextItemOffsetPx;
        if (firstVisibleItemConsumedOffsetPx < 0) {
            return f16 + 1.0f;
        }
        return f16;
    }

    private int getFirstVisibleItemVirtualPosition() {
        if (this.mScrollToNextItemOffsetPx <= 0) {
            return 0;
        }
        return (int) Math.floor(this.mTotalOffsetPx / r0);
    }

    private int getOffsetPxToRealPosition(int i3) {
        int firstVisibleItemConsumedOffsetPx;
        int mapVirtualPositionToRealPosition = i3 - mapVirtualPositionToRealPosition(this.mFirstVisibleItemVirtualPosition);
        if (getItemCount() <= 2) {
            mapVirtualPositionToRealPosition = Math.abs(mapVirtualPositionToRealPosition);
        }
        int itemCount = getItemCount();
        if (Math.abs(mapVirtualPositionToRealPosition) > itemCount / 2.0f) {
            if (mapVirtualPositionToRealPosition < 0) {
                firstVisibleItemConsumedOffsetPx = ((itemCount + mapVirtualPositionToRealPosition) * this.mScrollToNextItemOffsetPx) - getFirstVisibleItemConsumedOffsetPx();
            } else {
                firstVisibleItemConsumedOffsetPx = getFirstVisibleItemConsumedOffsetPx() + ((mapVirtualPositionToRealPosition - itemCount) * this.mScrollToNextItemOffsetPx);
            }
        } else {
            firstVisibleItemConsumedOffsetPx = (mapVirtualPositionToRealPosition * this.mScrollToNextItemOffsetPx) - getFirstVisibleItemConsumedOffsetPx();
        }
        log("[getOffsetToTargetPosition] result = " + firstVisibleItemConsumedOffsetPx, false);
        return firstVisibleItemConsumedOffsetPx;
    }

    private RecyclerView.OnFlingListener getOnFlingListener() {
        return new RecyclerView.OnFlingListener() { // from class: com.tencent.ad.tangram.widget.carouselcard.TGCarouselCardLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
            public boolean onFling(int i3, int i16) {
                TGCarouselCardLayoutManager.this.log("[onFling] velocityX = " + i3 + " velocityY = " + i16, false);
                TGCarouselCardLayoutManager.this.mFlingDirection = Integer.MIN_VALUE;
                if (i3 > 1000) {
                    TGCarouselCardLayoutManager.this.mFlingDirection = 1;
                } else if (i3 < -1000) {
                    TGCarouselCardLayoutManager.this.mFlingDirection = 0;
                }
                if (TGCarouselCardLayoutManager.this.mIsScrolledToTheLeftEnd) {
                    TGCarouselCardLayoutManager tGCarouselCardLayoutManager = TGCarouselCardLayoutManager.this;
                    tGCarouselCardLayoutManager.notifyOnScrollListener(tGCarouselCardLayoutManager.mLastSelectedItemVirtualPosition, TGCarouselCardLayoutManager.this.mFirstVisibleItemVirtualPosition);
                    TGCarouselCardLayoutManager tGCarouselCardLayoutManager2 = TGCarouselCardLayoutManager.this;
                    tGCarouselCardLayoutManager2.mLastSelectedItemVirtualPosition = tGCarouselCardLayoutManager2.mFirstVisibleItemVirtualPosition;
                }
                TGCarouselCardLayoutManager.this.smoothScrollToAppropriatePosition();
                return true;
            }
        };
    }

    private void layout(RecyclerView.Recycler recycler) {
        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams;
        float f16;
        float f17;
        int mapVirtualPositionToRealPosition;
        int i3;
        int i16;
        if (recycler != null && this.mItemHeightPx > 0 && this.mItemWidthPx > 0 && (tGCarouselCardLayoutManagerParams = this.mParams) != null && tGCarouselCardLayoutManagerParams.isValid()) {
            this.mFirstVisibleItemVirtualPosition = getFirstVisibleItemVirtualPosition();
            detachAndScrapAttachedViews(recycler);
            float firstVisibleItemConsumedFraction = getFirstVisibleItemConsumedFraction();
            int paddingLeft = ((int) ((-this.mScrollToNextItemOffsetPx) * firstVisibleItemConsumedFraction)) + getPaddingLeft() + this.mItemWidthPx;
            int paddingLeft2 = ((int) ((-this.mParams.horizontalOffsetPx) * firstVisibleItemConsumedFraction)) + getPaddingLeft() + this.mItemWidthPx;
            int paddingTop = getPaddingTop();
            int paddingTop2 = ((int) ((-this.mParams.verticalOffsetPx) * firstVisibleItemConsumedFraction)) + getPaddingTop();
            log("mCurrentVirtualPosition " + this.mFirstVisibleItemVirtualPosition, false);
            int i17 = paddingLeft2;
            int i18 = paddingTop2;
            int i19 = this.mFirstVisibleItemVirtualPosition;
            while (true) {
                int i26 = this.mFirstVisibleItemVirtualPosition;
                if (i19 < this.mMaxVisibleItemCount + i26) {
                    if (i19 == i26) {
                        f17 = this.mItemHeightPx;
                        f16 = this.mItemWidthPx;
                    } else {
                        float f18 = this.mItemHeightPx;
                        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams2 = this.mParams;
                        float f19 = f18 - ((tGCarouselCardLayoutManagerParams2.verticalOffsetPx * 2) * ((i19 - i26) - firstVisibleItemConsumedFraction));
                        f16 = this.mItemWidthPx - (tGCarouselCardLayoutManagerParams2.horizontalOffsetPx * ((i19 - i26) - firstVisibleItemConsumedFraction));
                        f17 = f19;
                    }
                    if (i17 - f16 <= getWidth() - getPaddingLeft() && f17 > this.mItemMinimumHeightPx && f16 > this.mItemMinimumWidthPx && (mapVirtualPositionToRealPosition = mapVirtualPositionToRealPosition(i19)) >= 0 && this.mItemHeightPx >= 0) {
                        View viewForPosition = recycler.getViewForPosition(mapVirtualPositionToRealPosition);
                        addView(viewForPosition, 0);
                        measureChildWithMargins(viewForPosition, 0, 0);
                        float f26 = f17 / this.mItemHeightPx;
                        viewForPosition.setPivotX(this.mItemWidthPx);
                        viewForPosition.setPivotY(0.0f);
                        viewForPosition.setScaleX(f26);
                        viewForPosition.setScaleY(f26);
                        int i27 = this.mFirstVisibleItemVirtualPosition;
                        if (i19 == i27) {
                            i3 = paddingLeft;
                        } else {
                            i3 = i17;
                        }
                        int i28 = i3 - this.mItemWidthPx;
                        if (i19 == i27) {
                            i16 = paddingTop;
                        } else {
                            i16 = i18;
                        }
                        layoutDecoratedWithMargins(viewForPosition, i28, i16, i3, i16 + this.mItemHeightPx);
                        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams3 = this.mParams;
                        i17 += tGCarouselCardLayoutManagerParams3.horizontalOffsetPx;
                        i18 += tGCarouselCardLayoutManagerParams3.verticalOffsetPx;
                        i19++;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str, boolean z16) {
        WeakReference<ILog> weakReference;
        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams = this.mParams;
        ILog iLog = null;
        if (tGCarouselCardLayoutManagerParams != null) {
            weakReference = tGCarouselCardLayoutManagerParams.logger;
        } else {
            weakReference = null;
        }
        if (weakReference != null) {
            iLog = weakReference.get();
        }
        if (iLog == null) {
            return;
        }
        if (z16) {
            iLog.e(str);
        } else {
            iLog.i(str);
        }
    }

    private int mapVirtualPositionToRealPosition(int i3) {
        int itemCount = getItemCount();
        if (itemCount <= 0 || i3 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int i16 = i3 % itemCount;
        if (i16 < 0) {
            return i16 + itemCount;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnScrollListener(int i3, int i16) {
        IOnItemScrollListener iOnItemScrollListener;
        WeakReference<? extends IOnItemScrollListener> weakReference = this.mWeakOnScrollListener;
        if (weakReference != null) {
            iOnItemScrollListener = weakReference.get();
        } else {
            iOnItemScrollListener = null;
        }
        if (iOnItemScrollListener == null) {
            return;
        }
        iOnItemScrollListener.onItemScrolled(mapVirtualPositionToRealPosition(i3), mapVirtualPositionToRealPosition(i16));
    }

    private void recycleItems(RecyclerView.Recycler recycler) {
        List<RecyclerView.ViewHolder> list;
        if (recycler != null) {
            list = recycler.getScrapList();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                removeAndRecycleView(list.get(i3).itemView, recycler);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScrollToAppropriatePosition() {
        if (this.mRecyclerView == null) {
            return;
        }
        log("[smoothScrollToNearestPosition]", false);
        int mapVirtualPositionToRealPosition = mapVirtualPositionToRealPosition(getAppropriateItemVirtualPosition());
        this.mFlingDirection = Integer.MIN_VALUE;
        this.mRecyclerView.smoothScrollToPosition(mapVirtualPositionToRealPosition);
    }

    private void updateData(RecyclerView.Recycler recycler) {
        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams;
        if (getItemCount() > 0 && recycler != null && (tGCarouselCardLayoutManagerParams = this.mParams) != null && tGCarouselCardLayoutManagerParams.isValid()) {
            detachAndScrapAttachedViews(recycler);
            View viewForPosition = recycler.getViewForPosition(0);
            if (viewForPosition == null) {
                return;
            }
            measureChildWithMargins(viewForPosition, 0, 0);
            this.mItemHeightPx = getDecoratedMeasuredHeightWithMargin(viewForPosition);
            this.mItemWidthPx = getDecoratedMeasuredWidthWithMargin(viewForPosition);
            this.mItemMinimumHeightPx = viewForPosition.getMinimumHeight();
            this.mItemMinimumWidthPx = viewForPosition.getMinimumWidth();
            this.mMaxVisibleItemCount = Math.min(this.mParams.maxVisibleItemCount, getItemCount());
            int i3 = this.mItemWidthPx;
            this.mScrollToNextItemOffsetPx = i3;
            int i16 = i3 * this.mParams.startPosition;
            this.mTotalOffsetPx = i16;
            this.mBaseOffsetPx = i16;
            int firstVisibleItemVirtualPosition = getFirstVisibleItemVirtualPosition();
            this.mFirstVisibleItemVirtualPosition = firstVisibleItemVirtualPosition;
            this.mLastSelectedItemVirtualPosition = firstVisibleItemVirtualPosition;
            recycler.recycleView(viewForPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getFirstVisibleItemConsumedOffsetPx() {
        int i3 = this.mScrollToNextItemOffsetPx;
        if (i3 <= 0) {
            return 0;
        }
        int i16 = this.mTotalOffsetPx % i3;
        if (i16 < 0) {
            return i16 + i3;
        }
        return i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state != null && state.getItemCount() != 0) {
            log("[onLayoutChildren]", false);
            if (this.mShouldUpdateData) {
                updateData(recycler);
                this.mShouldUpdateData = false;
            }
            fillScreen(recycler);
            return;
        }
        removeAndRecycleAllViews(recycler);
        log("[onLayoutChildren] internal error", true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i3) {
        super.onScrollStateChanged(i3);
        log("[onScrollStateChanged] state = " + i3, false);
        this.mScrollState = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.mIsScrollFixedFlag = true;
                    return;
                }
                return;
            }
            this.mIsScrollFixedFlag = false;
            return;
        }
        if (!this.mIsScrollFixedFlag) {
            smoothScrollToAppropriatePosition();
        } else {
            notifyOnScrollListener(this.mLastSelectedItemVirtualPosition, this.mFirstVisibleItemVirtualPosition);
            this.mLastSelectedItemVirtualPosition = this.mFirstVisibleItemVirtualPosition;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        TGCarouselCardLayoutManagerParams tGCarouselCardLayoutManagerParams;
        int i16;
        if (i3 == 0 || getChildCount() == 0 || (tGCarouselCardLayoutManagerParams = this.mParams) == null || !tGCarouselCardLayoutManagerParams.isValid()) {
            return 0;
        }
        if (this.mScrollState == 1 && !this.mParams.canScrollByDragging) {
            return 0;
        }
        int i17 = this.mTotalOffsetPx + i3;
        this.mTotalOffsetPx = i17;
        if (!this.mParams.canScrollOverStartPosition && i17 < (i16 = this.mBaseOffsetPx)) {
            this.mTotalOffsetPx = i16;
            this.mIsScrolledToTheLeftEnd = true;
        } else {
            this.mIsScrolledToTheLeftEnd = false;
        }
        fillScreen(recycler);
        log("[scrollHorizontallyBy] dx = " + i3, false);
        return i3;
    }

    public void setOnScrollListener(WeakReference<? extends IOnItemScrollListener> weakReference) {
        this.mWeakOnScrollListener = weakReference;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        if (recyclerView != null && i3 >= 0 && i3 < getItemCount()) {
            log("[smoothScrollToPosition]", false);
            recyclerView.smoothScrollBy(getOffsetPxToRealPosition(i3), 0);
        } else {
            log("[smoothScrollToPosition] internal error", true);
        }
    }
}
