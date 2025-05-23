package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class BaseLayoutManager extends RecyclerViewBase.LayoutManager {
    protected static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final float SUSPEND_ITEM_ALPHA = 0.8f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    private boolean doNotCheckAgain;
    private int mCurrentSuspentionPos;
    private View mCurrentSuspentionView;
    protected boolean mEndReached;
    private boolean mLastStackFromEnd;
    private int mOrientation;
    public OrientationHelper mOrientationHelper;
    private int mPendingGravity;
    private SavedState mPendingSavedState;
    private int mPendingScrollPositionItemHeight;
    public RenderState mRenderState;
    private boolean mReverseLayout;
    protected boolean mShouldReverseLayout;
    private boolean mStackFromEnd;
    protected int mSuspentedAreaSize;
    long time;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface OrientationHelper {
        int getDecoratedEnd(View view);

        int getDecoratedMeasurement(View view);

        int getDecoratedMeasurementInOther(View view);

        int getDecoratedStart(View view);

        int getEndAfterPadding();

        int getStartAfterPadding();

        int getTotalSpace();

        void offsetChildren(int i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class RenderState {
        public static final int FILL_TYPE_FOOTER = 4;
        public static final int FILL_TYPE_HEADER = 2;
        public static final int FILL_TYPE_NOMORE = 1;
        public static final int FILL_TYPE_NORMAL = 3;
        public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_NO_DIRECTION = Integer.MAX_VALUE;
        public static final int LAYOUT_START = -1;
        public static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "TMYGRID";
        public int mAvailable;
        public int mCurrentPosition;
        public int mItemDirection;
        public int mLayoutDirection;
        public int mOffset;
        public int mScrollingOffset;
        public boolean overscroll = false;
        public int mExtra = 0;
        public List<RecyclerViewBase.ViewHolder> mScrapList = null;

        private View nextFromLimitedList() {
            int size = this.mScrapList.size();
            int i3 = Integer.MAX_VALUE;
            RecyclerViewBase.ViewHolder viewHolder = null;
            for (int i16 = 0; i16 < size; i16++) {
                RecyclerViewBase.ViewHolder viewHolder2 = this.mScrapList.get(i16);
                int position = (viewHolder2.getPosition() - this.mCurrentPosition) * this.mItemDirection;
                if (position >= 0 && position < i3) {
                    viewHolder = viewHolder2;
                    if (position == 0) {
                        break;
                    }
                    i3 = position;
                }
            }
            if (viewHolder == null) {
                return null;
            }
            this.mCurrentPosition = viewHolder.getPosition() + this.mItemDirection;
            return viewHolder.itemView;
        }

        public int hasMore(RecyclerViewBase.State state) {
            int i3 = this.mCurrentPosition;
            if (i3 < 0) {
                if (Math.abs(i3) > state.mHeaderCount) {
                    return 1;
                }
                return 2;
            }
            if (i3 >= state.getItemCount()) {
                if (Math.abs(this.mCurrentPosition) - state.getItemCount() >= state.mFooterCount) {
                    return 1;
                }
                return 4;
            }
            return 3;
        }

        public void log() {
            log("");
        }

        public View next(RecyclerViewBase.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextFromLimitedList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }

        public View nextFooter(RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
            View footerForPosition = recycler.getFooterForPosition((Math.abs(this.mCurrentPosition) - state.getItemCount()) + 1);
            this.mCurrentPosition += this.mItemDirection;
            return footerForPosition;
        }

        public View nextHeader(RecyclerViewBase.Recycler recycler) {
            View headerForPosition = recycler.getHeaderForPosition(Math.abs(this.mCurrentPosition));
            this.mCurrentPosition += this.mItemDirection;
            return headerForPosition;
        }

        public void log(String str) {
            Log.d(TAG, str + "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection + ", scrollOffset:" + this.mScrollingOffset);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;
        int mOrientation;
        boolean mReverseLayout;
        boolean mStackFromEnd;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mOrientation = parcel.readInt();
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mReverseLayout = parcel.readInt() == 1;
            this.mStackFromEnd = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.mOrientation);
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mStackFromEnd ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(SavedState savedState) {
            this.mOrientation = savedState.mOrientation;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mStackFromEnd = savedState.mStackFromEnd;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public BaseLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int convertFocusDirectionToLayoutDirection(int i3) {
        if (i3 == 1) {
            return -1;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130 && this.mOrientation == 1) {
                        return 1;
                    }
                    return Integer.MIN_VALUE;
                }
                if (this.mOrientation == 0) {
                    return 1;
                }
                return Integer.MIN_VALUE;
            }
            if (this.mOrientation == 1) {
                return -1;
            }
            return Integer.MIN_VALUE;
        }
        if (this.mOrientation == 0) {
            return -1;
        }
        return Integer.MIN_VALUE;
    }

    private void ensureSuspentionState() {
        View view;
        int top;
        if (!this.mRecyclerView.hasSuspentedItem() || getChildCount() == 0) {
            return;
        }
        View childClosestToStartByOrder = getChildClosestToStartByOrder();
        int position = getPosition(childClosestToStartByOrder);
        if (childClosestToStartByOrder.getTop() > 0) {
            showCurrentSuspention(Integer.MIN_VALUE);
            return;
        }
        int findPrevSuspentedPos = this.mRecyclerView.findPrevSuspentedPos(position);
        if (findPrevSuspentedPos != -1) {
            showCurrentSuspention(findPrevSuspentedPos);
        }
        View view2 = this.mCurrentSuspentionView;
        if (view2 != null && view2.getParent() == this.mRecyclerView) {
            int measuredHeight = this.mCurrentSuspentionView.getMeasuredHeight();
            int findNextSuspentedPos = this.mRecyclerView.findNextSuspentedPos(position);
            if (findNextSuspentedPos != -1) {
                view = findViewByPosition(findNextSuspentedPos);
            } else {
                view = null;
            }
            if (view == null) {
                top = Integer.MAX_VALUE;
            } else {
                top = view.getTop();
            }
            if (top < measuredHeight) {
                this.mCurrentSuspentionView.offsetTopAndBottom(top - measuredHeight);
            }
        }
    }

    private int fixLayoutEndGap(int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state, boolean z16) {
        int endAfterPadding;
        int endAfterPadding2;
        if (this.mRecyclerView.isRefreshing() || this.mRecyclerView.mState.mCustomHeaderHeight > 0 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i3) <= 0) {
            return 0;
        }
        state.overscroll = false;
        int i16 = -scrollBy(-endAfterPadding, recycler, state);
        int i17 = i3 + i16;
        if (z16 && (endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i17) > 0) {
            this.mOrientationHelper.offsetChildren(endAfterPadding2);
            return endAfterPadding2 + i16;
        }
        return i16;
    }

    private int fixLayoutStartGap(int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state, boolean z16) {
        int startAfterPadding;
        int startAfterPadding2;
        if (this.mRecyclerView.isRefreshing() || (startAfterPadding = i3 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return 0;
        }
        state.overscroll = false;
        int i16 = -scrollBy(startAfterPadding, recycler, state);
        int i17 = i3 + i16;
        if (z16 && (startAfterPadding2 = i17 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
            this.mOrientationHelper.offsetChildren(-startAfterPadding2);
            return i16 - startAfterPadding2;
        }
        return i16;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleChildren(RecyclerViewBase.Recycler recycler, int i3, int i16) {
        if (i3 == i16) {
            return;
        }
        if (i16 > i3) {
            for (int i17 = i16 - 1; i17 >= i3; i17--) {
                removeAndRecycleViewAt(i17, recycler);
            }
            return;
        }
        while (i3 > i16) {
            removeAndRecycleViewAt(i3, recycler);
            i3--;
        }
    }

    private void recycleViewsFromEnd(RecyclerViewBase.Recycler recycler, int i3) {
        int childCount = getChildCount();
        if (i3 < 0) {
            i3 = 0;
        }
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i3;
        if (this.mShouldReverseLayout) {
            for (int i16 = 0; i16 < childCount; i16++) {
                if (this.mOrientationHelper.getDecoratedStart(getChildAt(i16)) < endAfterPadding) {
                    recycleChildren(recycler, 0, i16);
                    return;
                }
            }
            return;
        }
        int i17 = childCount - 1;
        for (int i18 = i17; i18 >= 0; i18--) {
            if (this.mOrientationHelper.getDecoratedStart(getChildAt(i18)) < endAfterPadding) {
                recycleChildren(recycler, i17, i18);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerViewBase.Recycler recycler, int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding() + i3;
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int i16 = childCount - 1;
            for (int i17 = i16; i17 >= 0; i17--) {
                if (this.mOrientationHelper.getDecoratedEnd(getChildAt(i17)) > startAfterPadding) {
                    recycleChildren(recycler, i16, i17);
                    return;
                }
            }
            return;
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            if (this.mOrientationHelper.getDecoratedEnd(getChildAt(i18)) > startAfterPadding) {
                recycleChildren(recycler, 0, i18);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        boolean z16;
        if (this.mOrientation != 1 && isLayoutRTL()) {
            z16 = !this.mReverseLayout;
        } else {
            z16 = this.mReverseLayout;
        }
        this.mShouldReverseLayout = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        if ((((r0.mOffsetY + r6) + r5) + r0.getHeight()) >= r7.mTotalHeight) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0068, code lost:
    
        r4.mRecyclerView.mAdapter.onPreload();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (((r7.mOffsetY + r5) + r7.getHeight()) >= r6) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int scrollBy(int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
        int i16;
        this.time = System.currentTimeMillis();
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        ensureRenderState();
        if (i3 > 0) {
            i16 = 1;
        } else {
            i16 = -1;
        }
        updateRenderState(i16, Math.abs(i3), true, state);
        fill(recycler, this.mRenderState, state, false);
        this.mOrientationHelper.offsetChildren(-i3);
        ensureSuspentionState();
        int preloadThresholdInPixels = this.mRecyclerView.mAdapter.getPreloadThresholdInPixels();
        int preloadThresholdInItemNumber = this.mRecyclerView.mAdapter.getPreloadThresholdInItemNumber();
        if (preloadThresholdInPixels > 0 && this.mRecyclerView.getHeight() < state.mTotalHeight) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase.mOffsetY + preloadThresholdInPixels + recyclerViewBase.getHeight() < state.mTotalHeight) {
                RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
            }
            if (this.mOrientation != 0) {
            }
            this.mPreventFixGap = this.mRecyclerView.isInOverScrollArea();
            return i3;
        }
        if (preloadThresholdInItemNumber > 0 && this.mRecyclerView.getHeight() < state.mTotalHeight) {
            RecyclerViewBase.Adapter<RecyclerViewBase.ViewHolder> adapter = this.mRecyclerView.mAdapter;
            RenderState renderState = this.mRenderState;
            int heightBefore = adapter.getHeightBefore(renderState.mCurrentPosition - renderState.mItemDirection);
            if (this.mRenderState.mCurrentPosition == getItemCount() - preloadThresholdInItemNumber) {
                RecyclerViewBase recyclerViewBase3 = this.mRecyclerView;
                if (recyclerViewBase3.mOffsetY + recyclerViewBase3.getHeight() < heightBefore) {
                    RecyclerViewBase recyclerViewBase4 = this.mRecyclerView;
                }
            }
        }
        if (this.mOrientation != 0) {
            this.mRecyclerView.mOffsetX += i3;
        } else {
            this.mRecyclerView.mOffsetY += i3;
        }
        this.mPreventFixGap = this.mRecyclerView.isInOverScrollArea();
        return i3;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerViewBase.State state) {
        return getChildCount();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerViewBase.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int position = getPosition(getChildClosestToStartByOrder());
        if (this.mShouldReverseLayout) {
            return (state.getItemCount() - 1) - position;
        }
        return position;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeHorizontalScrollRange(RecyclerViewBase.State state) {
        return state.getItemCount();
    }

    public PointF computeScrollVectorForPosition(int i3) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z16 = false;
        int i16 = 1;
        if (i3 < getPosition(getChildAt(0))) {
            z16 = true;
        }
        if (z16 != this.mShouldReverseLayout) {
            i16 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF(i16, 0.0f);
        }
        return new PointF(0.0f, i16);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeVerticalScrollExtent(RecyclerViewBase.State state) {
        return getChildCount();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeVerticalScrollOffset(RecyclerViewBase.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int position = getPosition(getChildClosestToStartByOrder());
        if (this.mShouldReverseLayout) {
            return (state.getItemCount() - 1) - position;
        }
        return position;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int computeVerticalScrollRange(RecyclerViewBase.State state) {
        return state.getItemCount();
    }

    OrientationHelper createHorizontalOrientationHelper() {
        return new OrientationHelper() { // from class: com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.3
            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedEnd(View view) {
                if (view == null) {
                    return 0;
                }
                return BaseLayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerViewBase.LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
                return BaseLayoutManager.this.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
                return BaseLayoutManager.this.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedStart(View view) {
                if (view == null) {
                    return 0;
                }
                return BaseLayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerViewBase.LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getEndAfterPadding() {
                return (BaseLayoutManager.this.getWidth() - BaseLayoutManager.this.getPaddingRight()) + BaseLayoutManager.this.mRecyclerView.mState.mCustomHeaderWidth;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getStartAfterPadding() {
                return BaseLayoutManager.this.getPaddingLeft() - BaseLayoutManager.this.mRecyclerView.mState.mCustomHeaderWidth;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getTotalSpace() {
                return (BaseLayoutManager.this.getWidth() - BaseLayoutManager.this.getPaddingLeft()) - BaseLayoutManager.this.getPaddingRight();
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public void offsetChildren(int i3) {
                BaseLayoutManager.this.offsetChildrenHorizontal(i3);
            }
        };
    }

    OrientationHelper createVerticalOrientationHelper() {
        return new OrientationHelper() { // from class: com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.2
            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedEnd(View view) {
                if (view == null) {
                    return 0;
                }
                return BaseLayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerViewBase.LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedMeasurement(View view) {
                RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
                return BaseLayoutManager.this.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedMeasurementInOther(View view) {
                RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
                return BaseLayoutManager.this.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getDecoratedStart(View view) {
                if (view == null) {
                    return 0;
                }
                return BaseLayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerViewBase.LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getEndAfterPadding() {
                return (BaseLayoutManager.this.getHeight() - BaseLayoutManager.this.getPaddingBottom()) + BaseLayoutManager.this.mRecyclerView.mState.mCustomHeaderHeight;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getStartAfterPadding() {
                return BaseLayoutManager.this.getPaddingTop() - BaseLayoutManager.this.mRecyclerView.mState.mCustomHeaderHeight;
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public int getTotalSpace() {
                return (BaseLayoutManager.this.getHeight() - BaseLayoutManager.this.getPaddingTop()) - BaseLayoutManager.this.getPaddingBottom();
            }

            @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.OrientationHelper
            public void offsetChildren(int i3) {
                BaseLayoutManager.this.offsetChildrenVertical(i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureRenderState() {
        OrientationHelper createVerticalOrientationHelper;
        if (this.mRenderState == null) {
            this.mRenderState = new RenderState();
        }
        if (this.mOrientationHelper == null) {
            if (this.mOrientation == 0) {
                createVerticalOrientationHelper = createHorizontalOrientationHelper();
            } else {
                createVerticalOrientationHelper = createVerticalOrientationHelper();
            }
            this.mOrientationHelper = createVerticalOrientationHelper;
        }
    }

    protected abstract int fill(RecyclerViewBase.Recycler recycler, RenderState renderState, RecyclerViewBase.State state, boolean z16);

    public int findFirstCompletelyVisibleItemPosition() {
        return findOneVisibleChild(0, getChildCount(), true);
    }

    public int findFirstVisibleItemPosition() {
        return findOneVisibleChild(0, getChildCount(), false);
    }

    public int findLastCompletelyVisibleItemPosition() {
        return findOneVisibleChild(getChildCount() - 1, -1, true);
    }

    public int findLastVisibleItemPosition() {
        return findOneVisibleChild(getChildCount() - 1, -1, false);
    }

    protected int findOneVisibleChild(int i3, int i16, boolean z16) {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int i17 = -1;
        if (orientationHelper == null) {
            return -1;
        }
        int startAfterPadding = orientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        if (i16 > i3) {
            i17 = 1;
        }
        while (i3 != i16) {
            View childAt = getChildAt(i3);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (z16) {
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return getPosition(childAt);
                    }
                } else {
                    return getPosition(childAt);
                }
            }
            i3 += i17;
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View findViewByPosition(int i3) {
        int position;
        int childCount = getChildCount();
        if (childCount == 0 || (position = i3 - getPosition(getChildAt(0))) < 0 || position >= childCount) {
            return null;
        }
        return getChildAt(position);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public RecyclerViewBase.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerViewBase.LayoutParams(-2, -2);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToEndByOrder() {
        int childCount;
        if (this.mShouldReverseLayout) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToEndInScreen() {
        int childCount;
        if (this.mShouldReverseLayout) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToStartByOrder() {
        int i3;
        if (this.mShouldReverseLayout) {
            i3 = getChildCount() - 1;
        } else {
            i3 = 0;
        }
        return getChildAt(i3);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToStartInScreen() {
        int i3;
        if (this.mShouldReverseLayout) {
            i3 = getChildCount() - 1;
        } else {
            i3 = 0;
        }
        return getChildAt(i3);
    }

    public int getCurrentSuspentionPosition() {
        return this.mCurrentSuspentionPos;
    }

    public View getCurrentSuspentionView() {
        return this.mCurrentSuspentionView;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getDecoratedEnd(View view) {
        return this.mOrientationHelper.getDecoratedEnd(view);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getDecoratedStart(View view) {
        return this.mOrientationHelper.getDecoratedStart(view);
    }

    protected int getExtraLayoutSpace(RecyclerViewBase.State state) {
        if (!this.mRecyclerView.shouldPrebindItem() && !state.hasTargetScrollPosition()) {
            return 0;
        }
        return this.mOrientationHelper.getTotalSpace();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getFirstItemAfterOffset(int i3) {
        return super.getFirstItemAfterOffset(i3 + this.mOrientationHelper.getStartAfterPadding());
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getFirstItemBeforeOffset(int i3) {
        return super.getFirstItemBeforeOffset(i3 + this.mOrientationHelper.getStartAfterPadding());
    }

    protected int getHeightBefore(int i3) {
        RecyclerViewBase recyclerViewBase = this.mRecyclerView;
        if (recyclerViewBase != null) {
            return recyclerViewBase.getHeightBefore(i3);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getNextView(RecyclerViewBase.Recycler recycler, RenderState renderState, RecyclerViewBase.State state) {
        RecyclerViewBase.LayoutParams layoutParams;
        if (renderState.hasMore(state) == 2) {
            View nextHeader = renderState.nextHeader(recycler);
            if (nextHeader != null) {
                ViewGroup.LayoutParams layoutParams2 = nextHeader.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams = new RecyclerViewBase.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams2);
                } else {
                    layoutParams = new RecyclerViewBase.LayoutParams(layoutParams2);
                }
                RecyclerViewBase recyclerViewBase = this.mRecyclerView;
                RecyclerViewBase.ViewHolder createViewHolder = recyclerViewBase.createViewHolder(nextHeader, recyclerViewBase);
                layoutParams.mViewHolder = createViewHolder;
                createViewHolder.mViewType = -1;
                createViewHolder.mPosition = renderState.mCurrentPosition - renderState.mItemDirection;
                nextHeader.setLayoutParams(layoutParams);
                state.mHeaderCountInScreen++;
                return nextHeader;
            }
            return nextHeader;
        }
        if (renderState.hasMore(state) == 4) {
            View nextFooter = renderState.nextFooter(recycler, state);
            if (nextFooter != null) {
                RecyclerViewBase.LayoutParams layoutParams3 = new RecyclerViewBase.LayoutParams(nextFooter.getLayoutParams());
                RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
                RecyclerViewBase.ViewHolder createViewHolder2 = recyclerViewBase2.createViewHolder(nextFooter, recyclerViewBase2);
                layoutParams3.mViewHolder = createViewHolder2;
                createViewHolder2.mViewType = -2;
                createViewHolder2.mPosition = renderState.mCurrentPosition - renderState.mItemDirection;
                if (this.mRecyclerView.getAdapter().getFooterViewInBottomMode()) {
                    int height = this.mRecyclerView.getHeight() - this.mRecyclerView.getAdapter().getListTotalHeight();
                    int footerViewHeight = this.mRecyclerView.getAdapter().getFooterViewHeight(this.mRecyclerView.getAdapter().getFooterViewCount());
                    if (height > 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams3).height = footerViewHeight + height;
                        nextFooter.setPadding(nextFooter.getPaddingLeft(), height, nextFooter.getPaddingRight(), nextFooter.getPaddingBottom());
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams3).height = footerViewHeight;
                        nextFooter.setPadding(nextFooter.getPaddingLeft(), 0, nextFooter.getPaddingRight(), nextFooter.getPaddingBottom());
                    }
                }
                nextFooter.setLayoutParams(layoutParams3);
                state.mFooterCountInScreen++;
                if ((layoutParams3.mViewHolder.mPosition - state.getItemCount()) + 1 == state.mFooterCount) {
                    if (this.mRenderState.mScrollingOffset != Integer.MIN_VALUE || this.mRecyclerView.filterCheckNotifyFooterAppeared) {
                        RecyclerViewBase recyclerViewBase3 = this.mRecyclerView;
                        if (recyclerViewBase3.filterCheckNotifyFooterAppeared) {
                            recyclerViewBase3.filterCheckNotifyFooterAppeared = false;
                        }
                        recyclerViewBase3.needNotifyFooter = true;
                        return nextFooter;
                    }
                    return nextFooter;
                }
                return nextFooter;
            }
            return nextFooter;
        }
        return renderState.next(recycler);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getPendingOffset() {
        return this.mPendingScrollPositionOffset;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getPendingPosition() {
        return this.mPendingScrollPosition;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return false;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View onFocusSearchFailed(View view, int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
        int convertFocusDirectionToLayoutDirection;
        View childClosestToEndInScreen;
        View view2;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEndInScreen = getChildClosestToStartInScreen();
        } else {
            childClosestToEndInScreen = getChildClosestToEndInScreen();
        }
        ensureRenderState();
        updateRenderState(convertFocusDirectionToLayoutDirection, (int) ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getStartAfterPadding()) * MAX_SCROLL_FACTOR), false, state);
        RenderState renderState = this.mRenderState;
        renderState.mScrollingOffset = Integer.MIN_VALUE;
        this.mRecyclerView.filterCheckNotifyFooterAppeared = true;
        fill(recycler, renderState, state, true);
        try {
            view2 = FocusFinder.getInstance().findNextFocus(this.mRecyclerView, view, i3);
        } catch (Exception unused) {
            view2 = null;
        }
        if (view2 == null || view2 == childClosestToEndInScreen || !view2.isFocusable()) {
            return null;
        }
        return view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x00df, code lost:
    
        if (r3 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x00e1, code lost:
    
        r5 = r18.mOrientationHelper.getEndAfterPadding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x00e9, code lost:
    
        r5 = r18.mOrientationHelper.getStartAfterPadding();
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0143, code lost:
    
        if (r3 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02b2, code lost:
    
        if (r18.doNotCheckAgain != false) goto L137;
     */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayoutChildren(RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
        boolean z16;
        int startAfterPadding;
        boolean z17;
        int i3;
        int i16;
        int i17;
        boolean z18;
        char c16;
        RecyclerViewBase.ViewHolder childViewHolder;
        boolean z19;
        int startAfterPadding2;
        boolean z26;
        int i18;
        int i19;
        int i26;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            setOrientation(savedState.mOrientation);
            setReverseLayout(this.mPendingSavedState.mReverseLayout);
            setStackFromEnd(this.mPendingSavedState.mStackFromEnd);
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureRenderState();
        resolveShouldLayoutReverse();
        int i27 = this.mPendingScrollPosition;
        if (i27 != Integer.MIN_VALUE && ((i27 < (-state.mHeaderCount) || i27 >= state.getItemCount()) && (this.mPendingScrollPosition != 0 || state.getItemCount() != 0))) {
            this.mPendingScrollPosition = Integer.MIN_VALUE;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        boolean z27 = this.mShouldReverseLayout;
        boolean z28 = this.mStackFromEnd;
        boolean z29 = z27 ^ z28;
        if (this.mLastStackFromEnd != z28) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i28 = this.mPendingScrollPosition;
        if (i28 != Integer.MIN_VALUE) {
            int i29 = this.mPendingGravity;
            if (i29 != 0) {
                int i36 = i29 & 112;
                if (i36 != 16) {
                    if (i36 != 48) {
                        if (i36 == 80) {
                            i19 = this.mRecyclerView.getMeasuredHeight();
                            i18 = this.mPendingScrollPositionItemHeight;
                        }
                    } else {
                        i26 = this.mOrientationHelper.getStartAfterPadding();
                        this.mPendingScrollPositionOffset = i26;
                    }
                } else {
                    int measuredHeight = this.mRecyclerView.getMeasuredHeight();
                    i18 = this.mPendingScrollPositionItemHeight;
                    i19 = (measuredHeight - i18) / 2;
                }
                i26 = i19 - i18;
                this.mPendingScrollPositionOffset = i26;
            }
            SavedState savedState2 = this.mPendingSavedState;
            if (savedState2 != null) {
                z29 = savedState2.mAnchorLayoutFromEnd;
                OrientationHelper orientationHelper = this.mOrientationHelper;
                if (z29) {
                    startAfterPadding = orientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                } else {
                    startAfterPadding = orientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                }
            } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (findViewByPosition != null) {
                    int decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                    int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                    if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) <= this.mOrientationHelper.getTotalSpace()) {
                        if (decoratedStart < 0) {
                            startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                            z29 = false;
                        } else if (endAfterPadding < 0) {
                            startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                            z29 = true;
                        } else {
                            OrientationHelper orientationHelper2 = this.mOrientationHelper;
                            if (z29) {
                                startAfterPadding = orientationHelper2.getDecoratedEnd(findViewByPosition);
                            } else {
                                startAfterPadding = orientationHelper2.getDecoratedStart(findViewByPosition);
                            }
                        }
                    }
                } else if (getChildCount() > 0) {
                    if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19 == this.mShouldReverseLayout) {
                        startAfterPadding2 = this.mOrientationHelper.getEndAfterPadding();
                        z26 = true;
                    } else {
                        startAfterPadding2 = this.mOrientationHelper.getStartAfterPadding();
                        z26 = false;
                    }
                    boolean z36 = z26;
                    startAfterPadding = startAfterPadding2;
                    z29 = z36;
                }
            } else if (this.mShouldReverseLayout) {
                startAfterPadding = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                z29 = true;
            } else {
                startAfterPadding = this.mPendingScrollPositionOffset + this.mOrientationHelper.getStartAfterPadding();
                z29 = false;
            }
        } else if (getChildCount() > 0 && !z16) {
            if (z29) {
                startAfterPadding = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
                i28 = getPosition(getChildClosestToEndByOrder());
            } else {
                View childClosestToStartByOrder = getChildClosestToStartByOrder();
                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childClosestToStartByOrder);
                i28 = getPosition(childClosestToStartByOrder);
                startAfterPadding = decoratedStart2;
            }
        } else {
            OrientationHelper orientationHelper3 = this.mOrientationHelper;
            if (z29) {
                startAfterPadding = orientationHelper3.getEndAfterPadding();
            } else {
                startAfterPadding = orientationHelper3.getStartAfterPadding();
            }
            i28 = this.mStackFromEnd ? (state.getItemCount() - 1) + this.mRecyclerView.mAdapter.getFooterViewCount() : -this.mRecyclerView.mAdapter.getHeaderViewCount();
        }
        int validateAnchorPosition = validateAnchorPosition(this.mRenderState.mItemDirection, this.mRecyclerView.validateAnchorItemPosition(i28), state.getItemCount());
        detachAndScrapAttachedViews(recycler);
        if (state.mDataChanged) {
            state.mDataChanged = false;
            if (this.mCurrentSuspentionView != null && !this.mRecyclerView.isRepeatableSuspensionMode() && (childViewHolder = this.mRecyclerView.getChildViewHolder(this.mCurrentSuspentionView)) != null) {
                childViewHolder.setIsRecyclable(true);
            }
            removeAndRecycleScrapInt(recycler, true, true);
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (state.getTargetScrollPosition() < validateAnchorPosition) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 == this.mShouldReverseLayout) {
            i3 = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i3 = 0;
        }
        updateRenderStateToFillStart(validateAnchorPosition, startAfterPadding);
        RenderState renderState = this.mRenderState;
        renderState.mExtra = extraLayoutSpace;
        if (!z29) {
            renderState.mCurrentPosition += renderState.mItemDirection;
        }
        fill(recycler, renderState, state, false);
        RenderState renderState2 = this.mRenderState;
        int i37 = renderState2.mCurrentPosition - renderState2.mItemDirection;
        int i38 = renderState2.mOffset;
        int i39 = this.mOrientation;
        if (i39 == 1) {
            this.mRecyclerView.mOffsetY = getHeightBefore(i37) - i38;
        } else if (i39 == 0) {
            this.mRecyclerView.mOffsetX = getHeightBefore(i37) - i38;
        }
        updateRenderStateToFillEnd(validateAnchorPosition, startAfterPadding);
        RenderState renderState3 = this.mRenderState;
        renderState3.mExtra = i3;
        if (z29) {
            renderState3.mCurrentPosition += renderState3.mItemDirection;
        }
        fill(recycler, renderState3, state, false);
        int i46 = this.mRenderState.mOffset;
        this.mRecyclerView.onItemsFill(i46);
        this.mRecyclerView.checkNotifyFooterAppearWithFewChild(i46);
        if (getChildCount() > 0 && !this.mPreventFixGap && this.mRecyclerView.mState.mCustomHeaderHeight == 0) {
            if (getHeight() <= this.mRecyclerView.mAdapter.getListTotalHeight()) {
                int fixLayoutStartGap = fixLayoutStartGap(i38, recycler, state, true);
                int i47 = i38 + fixLayoutStartGap;
                int i48 = i46 + fixLayoutStartGap;
                int fixLayoutEndGap = fixLayoutEndGap(i48, recycler, state, false);
                i38 = i47 + fixLayoutEndGap;
                i46 = i48 + fixLayoutEndGap;
            } else if (this.mRecyclerView.mOffsetY - this.mOrientationHelper.getStartAfterPadding() != 0) {
                if (!this.doNotCheckAgain) {
                    this.doNotCheckAgain = true;
                    scrollToPositionWidthOffsetInLayout(-this.mRecyclerView.mAdapter.getHeaderViewCount(), this.mOrientationHelper.getStartAfterPadding());
                }
                this.doNotCheckAgain = false;
            }
        }
        if (getChildCount() > 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerViewBase.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i49 = 0;
            int i56 = 0;
            for (int i57 = 0; i57 < size; i57++) {
                RecyclerViewBase.ViewHolder viewHolder = scrapList.get(i57);
                if (viewHolder.getPosition() < position) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 != this.mShouldReverseLayout) {
                    c16 = '\uffff';
                } else {
                    c16 = 1;
                }
                if (c16 == '\uffff') {
                    i49 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                } else {
                    i56 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                }
            }
            this.mRenderState.mScrapList = scrapList;
            if (i49 > 0) {
                updateRenderStateToFillStart(getPosition(getChildClosestToStartByOrder()), i38);
                RenderState renderState4 = this.mRenderState;
                renderState4.mExtra = i49;
                renderState4.mAvailable = 0;
                int i58 = renderState4.mCurrentPosition;
                if (this.mShouldReverseLayout) {
                    i17 = 1;
                } else {
                    i17 = -1;
                }
                renderState4.mCurrentPosition = i58 + i17;
                fill(recycler, renderState4, state, false);
            }
            if (i56 > 0) {
                updateRenderStateToFillEnd(getPosition(getChildClosestToEndByOrder()), i46);
                RenderState renderState5 = this.mRenderState;
                renderState5.mExtra = i56;
                renderState5.mAvailable = 0;
                int i59 = renderState5.mCurrentPosition;
                if (this.mShouldReverseLayout) {
                    i16 = -1;
                } else {
                    i16 = 1;
                }
                renderState5.mCurrentPosition = i59 + i16;
                fill(recycler, renderState5, state, false);
            }
            this.mRenderState.mScrapList = null;
        }
        removeSuspentions();
        ensureSuspentionState();
        this.mPendingScrollPosition = Integer.MIN_VALUE;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastStackFromEnd = this.mStackFromEnd;
        this.mPendingGravity = 0;
        this.mPendingSavedState = null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public Parcelable onSaveInstanceState() {
        int i3;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            boolean z16 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z16;
            if (z16) {
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
                savedState.mAnchorPosition = getPosition(getChildClosestToEndByOrder());
                savedState.mStackFromEnd = this.mStackFromEnd;
                savedState.mReverseLayout = this.mReverseLayout;
                savedState.mOrientation = this.mOrientation;
                return savedState;
            }
            savedState.mAnchorPosition = getPosition(getChildClosestToStartByOrder());
            i3 = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen()) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            i3 = 0;
            savedState.mAnchorPosition = 0;
        }
        savedState.mAnchorOffset = i3;
        savedState.mStackFromEnd = this.mStackFromEnd;
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mOrientation = this.mOrientation;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recordItemSize(int i3, View view) {
        RecyclerViewBase recyclerViewBase = this.mRecyclerView;
        if (recyclerViewBase != null && recyclerViewBase.getAdapter() != null && (this.mRecyclerView.getAdapter() instanceof RecyclerAdapter)) {
            RecyclerAdapter recyclerAdapter = (RecyclerAdapter) this.mRecyclerView.getAdapter();
            if (recyclerAdapter.isAutoCalculateItemHeight()) {
                int measuredWidth = view.getMeasuredWidth();
                if (recyclerAdapter.mItemWidthList == null) {
                    recyclerAdapter.mItemWidthList = new ArrayList<>(recyclerAdapter.getItemCount());
                }
                if (recyclerAdapter.mItemWidthList.size() > i3) {
                    recyclerAdapter.mItemWidthList.set(i3, Integer.valueOf(measuredWidth));
                    return;
                }
                if (recyclerAdapter.mItemWidthList.size() == i3) {
                    recyclerAdapter.mItemWidthList.add(Integer.valueOf(measuredWidth));
                    return;
                }
                Log.e(TAG, "recordItemSize with wrong index " + i3 + ", itemWidth " + measuredWidth + ", listSize " + recyclerAdapter.mItemWidthList.size());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recycleByRenderState(RecyclerViewBase.Recycler recycler, RenderState renderState) {
        int i3 = renderState.mLayoutDirection;
        int i16 = renderState.mScrollingOffset;
        if (i3 == -1) {
            recycleViewsFromEnd(recycler, i16);
        } else {
            recycleViewsFromStart(recycler, i16);
        }
    }

    public void removeSuspentions() {
        View view = this.mCurrentSuspentionView;
        if (view != null && view.getParent() == this.mRecyclerView) {
            this.mCurrentSuspentionView.clearAnimation();
            this.mRecyclerView.removeAnimatingView(this.mCurrentSuspentionView, true);
            this.mCurrentSuspentionView = null;
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        state.overscroll = true;
        return scrollBy(i3, recycler, state);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void scrollToPosition(int i3) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void scrollToPositionWidthGravity(int i3, int i16, int i17) {
        this.mPendingScrollPosition = i3;
        this.mPendingGravity = i16;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingScrollPositionItemHeight = i17;
        requestLayout();
    }

    public void scrollToPositionWidthOffsetInLayout(int i3, int i16) {
        this.mPendingGravity = 0;
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = i16;
        this.mRecyclerView.dispatchLayout();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void scrollToPositionWithOffset(int i3, int i16) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = i16;
        requestLayout();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerViewBase.Recycler recycler, RecyclerViewBase.State state) {
        int listTotalHeight;
        if (this.mOrientation == 0) {
            return 0;
        }
        if (Math.abs(i3) > getHeight() * 1.5f) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase.mOffsetY + i3 < (-recyclerViewBase.getSpringBackMaxDistance())) {
                listTotalHeight = -this.mRecyclerView.getSpringBackMaxDistance();
            } else {
                RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
                if (recyclerViewBase2.mOffsetY + i3 > recyclerViewBase2.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance()) {
                    listTotalHeight = this.mRecyclerView.mAdapter.getListTotalHeight() + this.mRecyclerView.getSpringBackMaxDistance();
                }
                RecyclerViewBase recyclerViewBase3 = this.mRecyclerView;
                int[] beginPositionWithOffset = recyclerViewBase3.mAdapter.getBeginPositionWithOffset(recyclerViewBase3.mOffsetY + i3);
                RecyclerViewBase recyclerViewBase4 = this.mRecyclerView;
                RecyclerViewBase.LayoutManager layoutManager = recyclerViewBase4.mLayout;
                layoutManager.mPendingScrollPosition = beginPositionWithOffset[0];
                layoutManager.mPendingScrollPositionOffset = beginPositionWithOffset[1];
                recyclerViewBase4.dispatchLayout();
                return Math.abs(i3);
            }
            i3 = listTotalHeight - this.mRecyclerView.mOffsetY;
            RecyclerViewBase recyclerViewBase32 = this.mRecyclerView;
            int[] beginPositionWithOffset2 = recyclerViewBase32.mAdapter.getBeginPositionWithOffset(recyclerViewBase32.mOffsetY + i3);
            RecyclerViewBase recyclerViewBase42 = this.mRecyclerView;
            RecyclerViewBase.LayoutManager layoutManager2 = recyclerViewBase42.mLayout;
            layoutManager2.mPendingScrollPosition = beginPositionWithOffset2[0];
            layoutManager2.mPendingScrollPositionOffset = beginPositionWithOffset2[1];
            recyclerViewBase42.dispatchLayout();
            return Math.abs(i3);
        }
        state.overscroll = true;
        return scrollBy(i3, recycler, state);
    }

    public void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mOrientation != i3) {
            savedState.mOrientation = i3;
        }
        if (i3 == this.mOrientation) {
            return;
        }
        this.mOrientation = i3;
        this.mOrientationHelper = null;
        requestLayout();
    }

    public void setReverseLayout(boolean z16) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z16) {
            savedState.mReverseLayout = z16;
        }
        if (z16 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z16;
        requestLayout();
    }

    public void setStackFromEnd(boolean z16) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mStackFromEnd != z16) {
            savedState.mStackFromEnd = z16;
        }
        if (this.mStackFromEnd == z16) {
            return;
        }
        this.mStackFromEnd = z16;
        requestLayout();
    }

    public void showCurrentSuspention(int i3) {
        View suspendViewForPosition;
        Log.d("TMYHIS", "showCurrentSuspention=");
        RecyclerViewBase recyclerViewBase = this.mRecyclerView;
        recyclerViewBase.mAnimatingViewPrevPos = recyclerViewBase.mAnimatingViewPos;
        recyclerViewBase.mAnimatingViewPos = i3;
        this.mCurrentSuspentionPos = i3;
        removeSuspentions();
        if (i3 != Integer.MIN_VALUE) {
            RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
            if (recyclerViewBase2.mRecycler != null) {
                if (recyclerViewBase2.isRepeatableSuspensionMode()) {
                    suspendViewForPosition = this.mRecyclerView.mRecycler.getViewForPosition(i3);
                } else {
                    suspendViewForPosition = this.mRecyclerView.mRecycler.getSuspendViewForPosition(i3);
                }
                if (suspendViewForPosition == null) {
                    return;
                }
                measureChildWithMargins(suspendViewForPosition, 0, 0);
                layoutDecorated(suspendViewForPosition, 0, 0, suspendViewForPosition.getMeasuredWidth(), suspendViewForPosition.getMeasuredHeight());
                this.mRecyclerView.addAnimatingView(suspendViewForPosition, true);
                this.mCurrentSuspentionView = suspendViewForPosition;
                RecyclerViewBase.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(suspendViewForPosition);
                if (childViewHolder.isRecyclable()) {
                    childViewHolder.setIsRecyclable(false);
                    return;
                }
                return;
            }
        }
        this.mCurrentSuspentionView = null;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void smoothScrollToPosition(RecyclerViewBase recyclerViewBase, RecyclerViewBase.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerViewBase.getContext()) { // from class: com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager.1
            @Override // com.tencent.mtt.supportui.views.recyclerview.LinearSmoothScroller
            public PointF computeScrollVectorForPosition(int i16) {
                return BaseLayoutManager.this.computeScrollVectorForPosition(i16);
            }
        };
        linearSmoothScroller.setTargetPosition(i3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRenderState(int i3, int i16, boolean z16, RecyclerViewBase.State state) {
        int startAfterPadding;
        this.mRenderState.mExtra = getExtraLayoutSpace(state);
        RenderState renderState = this.mRenderState;
        renderState.mLayoutDirection = i3;
        int i17 = -1;
        if (i3 == 1) {
            if (!this.mShouldReverseLayout) {
                i17 = 1;
            }
            renderState.mItemDirection = i17;
            int position = getPosition(getChildClosestToEndByOrder());
            RenderState renderState2 = this.mRenderState;
            renderState.mCurrentPosition = position + renderState2.mItemDirection;
            renderState2.mOffset = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen());
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(getChildClosestToEndInScreen()) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            if (this.mShouldReverseLayout) {
                i17 = 1;
            }
            renderState.mItemDirection = i17;
            int position2 = getPosition(getChildClosestToStartByOrder());
            RenderState renderState3 = this.mRenderState;
            renderState.mCurrentPosition = position2 + renderState3.mItemDirection;
            renderState3.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen())) + this.mOrientationHelper.getStartAfterPadding();
        }
        RenderState renderState4 = this.mRenderState;
        renderState4.mAvailable = i16;
        if (z16) {
            renderState4.mAvailable = i16 - startAfterPadding;
        }
        renderState4.overscroll = state.overscroll;
        renderState4.mScrollingOffset = startAfterPadding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRenderStateToFillEnd(int i3, int i16) {
        int i17;
        this.mRenderState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i16;
        RenderState renderState = this.mRenderState;
        if (this.mShouldReverseLayout) {
            i17 = -1;
        } else {
            i17 = 1;
        }
        renderState.mItemDirection = i17;
        renderState.mCurrentPosition = i3;
        renderState.mLayoutDirection = 1;
        renderState.mOffset = i16;
        renderState.mScrollingOffset = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRenderStateToFillStart(int i3, int i16) {
        int i17;
        this.mRenderState.mAvailable = i16 - this.mOrientationHelper.getStartAfterPadding();
        RenderState renderState = this.mRenderState;
        renderState.mCurrentPosition = i3;
        if (this.mShouldReverseLayout) {
            i17 = 1;
        } else {
            i17 = -1;
        }
        renderState.mItemDirection = i17;
        renderState.mLayoutDirection = -1;
        renderState.mOffset = i16;
        renderState.mScrollingOffset = Integer.MIN_VALUE;
    }

    protected void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z16 = true;
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i3 = 1; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int position2 = getPosition(childAt);
                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("detected invalid position. loc invalid? ");
                    if (decoratedStart2 >= decoratedStart) {
                        z16 = false;
                    }
                    sb5.append(z16);
                    throw new RuntimeException(sb5.toString());
                }
                if (decoratedStart2 > decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i16 = 1; i16 < getChildCount(); i16++) {
            View childAt2 = getChildAt(i16);
            int position3 = getPosition(childAt2);
            int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("detected invalid position. loc invalid? ");
                if (decoratedStart3 >= decoratedStart) {
                    z16 = false;
                }
                sb6.append(z16);
                throw new RuntimeException(sb6.toString());
            }
            if (decoratedStart3 < decoratedStart) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public BaseLayoutManager(Context context, int i3, boolean z16) {
        this.mSuspentedAreaSize = 0;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mPendingSavedState = null;
        this.mCurrentSuspentionView = null;
        this.mCurrentSuspentionPos = Integer.MIN_VALUE;
        this.mPendingGravity = 0;
        this.mEndReached = false;
        this.doNotCheckAgain = false;
        this.time = 0L;
        setOrientation(i3);
        setReverseLayout(z16);
    }

    protected void handleRecordItemHeightChange(int i3, int i16, int i17) {
    }

    public int validateAnchorPosition(int i3, int i16, int i17) {
        return i16;
    }
}
