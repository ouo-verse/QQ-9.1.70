package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager {
    private static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private boolean mLastStackFromEnd;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        int mPosition;

        AnchorInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isViewValidAsAnchor(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount()) {
                return true;
            }
            return false;
        }

        void assignCoordinateFromPadding() {
            int startAfterPadding;
            if (this.mLayoutFromEnd) {
                startAfterPadding = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
            } else {
                startAfterPadding = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = startAfterPadding;
        }

        public void assignFromView(View view) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
        }

        public void assignFromViewAndKeepVisibleRect(View view) {
            int totalSpaceChange = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            if (this.mLayoutFromEnd) {
                int endAfterPadding = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.mCoordinate - LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.mCoordinate += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedStart + LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LinearLayoutManager#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        boolean mInfinite;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mOffset;
        int mScrollingOffset;
        boolean mRecycle = true;
        int mExtra = 0;
        boolean mIsPreLayout = false;
        List<RecyclerView.ViewHolder> mScrapList = null;

        LayoutState() {
        }

        private View nextViewFromScrapList() {
            int size = this.mScrapList.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.mScrapList.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.mCurrentPosition == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasMore(RecyclerView.State state) {
            int i3 = this.mCurrentPosition;
            if (i3 >= 0 && i3 < state.getItemCount()) {
                return true;
            }
            return false;
        }

        void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View next(RecyclerView.Recycler recycler) {
            if (this.mScrapList != null) {
                return nextViewFromScrapList();
            }
            View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return viewForPosition;
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.mScrapList.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i16 = 0; i16 < size; i16++) {
                View view3 = this.mScrapList.get(i16).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < i3) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i3 = viewLayoutPosition;
                }
            }
            return view2;
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            if (nextViewInLimitedList == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
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

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        boolean hasValidAnchor() {
            if (this.mAnchorPosition >= 0) {
                return true;
            }
            return false;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return findReferenceChild(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private View findFirstVisibleChildClosestToEnd(boolean z16, boolean z17) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z16, z17);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z16, z17);
    }

    private View findFirstVisibleChildClosestToStart(boolean z16, boolean z17) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z16, z17);
        }
        return findOneVisibleChild(0, getChildCount(), z16, z17);
    }

    private View findLastReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(recycler, state);
        }
        return findLastReferenceChild(recycler, state);
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(recycler, state);
        }
        return findFirstReferenceChild(recycler, state);
    }

    private int fixLayoutEndGap(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i3;
        if (endAfterPadding2 > 0) {
            int i16 = -scrollBy(-endAfterPadding2, recycler, state);
            int i17 = i3 + i16;
            if (z16 && (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i17) > 0) {
                this.mOrientationHelper.offsetChildren(endAfterPadding);
                return endAfterPadding + i16;
            }
            return i16;
        }
        return 0;
    }

    private int fixLayoutStartGap(int i3, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        int startAfterPadding;
        int startAfterPadding2 = i3 - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int i16 = -scrollBy(startAfterPadding2, recycler, state);
            int i17 = i3 + i16;
            if (z16 && (startAfterPadding = i17 - this.mOrientationHelper.getStartAfterPadding()) > 0) {
                this.mOrientationHelper.offsetChildren(-startAfterPadding);
                return i16 - startAfterPadding;
            }
            return i16;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        int childCount;
        if (this.mShouldReverseLayout) {
            childCount = 0;
        } else {
            childCount = getChildCount() - 1;
        }
        return getChildAt(childCount);
    }

    private View getChildClosestToStart() {
        int i3;
        if (this.mShouldReverseLayout) {
            i3 = getChildCount() - 1;
        } else {
            i3 = 0;
        }
        return getChildAt(i3);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, int i16) {
        boolean z16;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < size; i19++) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i19);
                if (!viewHolder.isRemoved()) {
                    char c16 = 1;
                    if (viewHolder.getLayoutPosition() < position) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 != this.mShouldReverseLayout) {
                        c16 = '\uffff';
                    }
                    if (c16 == '\uffff') {
                        i17 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    } else {
                        i18 += this.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.mScrapList = scrapList;
            if (i17 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i3);
                LayoutState layoutState = this.mLayoutState;
                layoutState.mExtra = i17;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            if (i18 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i16);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtra = i18;
                layoutState2.mAvailable = 0;
                layoutState2.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            this.mLayoutState.mScrapList = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, layoutState.mScrollingOffset);
            } else {
                recycleViewsFromStart(recycler, layoutState.mScrollingOffset);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i3, int i16) {
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

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i3) {
        int childCount = getChildCount();
        if (i3 < 0) {
            return;
        }
        int end = this.mOrientationHelper.getEnd() - i3;
        if (this.mShouldReverseLayout) {
            for (int i16 = 0; i16 < childCount; i16++) {
                if (this.mOrientationHelper.getDecoratedStart(getChildAt(i16)) < end) {
                    recycleChildren(recycler, 0, i16);
                    return;
                }
            }
            return;
        }
        int i17 = childCount - 1;
        for (int i18 = i17; i18 >= 0; i18--) {
            if (this.mOrientationHelper.getDecoratedStart(getChildAt(i18)) < end) {
                recycleChildren(recycler, i17, i18);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i3) {
        if (i3 < 0) {
            return;
        }
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int i16 = childCount - 1;
            for (int i17 = i16; i17 >= 0; i17--) {
                if (this.mOrientationHelper.getDecoratedEnd(getChildAt(i17)) > i3) {
                    recycleChildren(recycler, i16, i17);
                    return;
                }
            }
            return;
        }
        for (int i18 = 0; i18 < childCount; i18++) {
            if (this.mOrientationHelper.getDecoratedEnd(getChildAt(i18)) > i3) {
                recycleChildren(recycler, 0, i18);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChildClosestToStart;
        int startAfterPadding;
        boolean z16 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (anchorInfo.mLayoutFromEnd) {
            findReferenceChildClosestToStart = findReferenceChildClosestToEnd(recycler, state);
        } else {
            findReferenceChildClosestToStart = findReferenceChildClosestToStart(recycler, state);
        }
        if (findReferenceChildClosestToStart == null) {
            return false;
        }
        anchorInfo.assignFromView(findReferenceChildClosestToStart);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.getDecoratedStart(findReferenceChildClosestToStart) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(findReferenceChildClosestToStart) < this.mOrientationHelper.getStartAfterPadding()) {
                z16 = true;
            }
            if (z16) {
                if (anchorInfo.mLayoutFromEnd) {
                    startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
                } else {
                    startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                }
                anchorInfo.mCoordinate = startAfterPadding;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i3;
        boolean z16;
        int decoratedStart;
        boolean z17 = false;
        if (!state.isPreLayout() && (i3 = this.mPendingScrollPosition) != -1) {
            if (i3 >= 0 && i3 < state.getItemCount()) {
                anchorInfo.mPosition = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z18 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    anchorInfo.mLayoutFromEnd = z18;
                    if (z18) {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.getDecoratedMeasurement(findViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                            anchorInfo.assignCoordinateFromPadding();
                            return true;
                        }
                        if (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                            anchorInfo.mLayoutFromEnd = false;
                            return true;
                        }
                        if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition) < 0) {
                            anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                            anchorInfo.mLayoutFromEnd = true;
                            return true;
                        }
                        if (anchorInfo.mLayoutFromEnd) {
                            decoratedStart = this.mOrientationHelper.getDecoratedEnd(findViewByPosition) + this.mOrientationHelper.getTotalSpaceChange();
                        } else {
                            decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition);
                        }
                        anchorInfo.mCoordinate = decoratedStart;
                    } else {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16 == this.mShouldReverseLayout) {
                                z17 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z17;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    }
                    return true;
                }
                boolean z19 = this.mShouldReverseLayout;
                anchorInfo.mLayoutFromEnd = z19;
                if (z19) {
                    anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                } else {
                    anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i3;
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        if (this.mStackFromEnd) {
            i3 = state.getItemCount() - 1;
        } else {
            i3 = 0;
        }
        anchorInfo.mPosition = i3;
    }

    private void updateLayoutState(int i3, int i16, boolean z16, RecyclerView.State state) {
        boolean z17;
        int startAfterPadding;
        LayoutState layoutState = this.mLayoutState;
        int i17 = 1;
        if (this.mOrientationHelper.getMode() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        layoutState.mInfinite = z17;
        this.mLayoutState.mExtra = getExtraLayoutSpace(state);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mLayoutDirection = i3;
        if (i3 == 1) {
            layoutState2.mExtra += this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState3 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i17 = -1;
            }
            layoutState3.mItemDirection = i17;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState3.mCurrentPosition = position + layoutState4.mItemDirection;
            layoutState4.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
            LayoutState layoutState5 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i17 = -1;
            }
            layoutState5.mItemDirection = i17;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState6 = this.mLayoutState;
            layoutState5.mCurrentPosition = position2 + layoutState6.mItemDirection;
            layoutState6.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LayoutState layoutState7 = this.mLayoutState;
        layoutState7.mAvailable = i16;
        if (z16) {
            layoutState7.mAvailable = i16 - startAfterPadding;
        }
        layoutState7.mScrollingOffset = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
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

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i3) {
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

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        }
    }

    int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z16) {
        int i3 = layoutState.mAvailable;
        int i16 = layoutState.mScrollingOffset;
        if (i16 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                layoutState.mScrollingOffset = i16 + i3;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i17 = layoutState.mAvailable + layoutState.mExtra;
        LayoutChunkResult layoutChunkResult = new LayoutChunkResult();
        while (true) {
            if ((!layoutState.mInfinite && i17 <= 0) || !layoutState.hasMore(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                if (!layoutChunkResult.mIgnoreConsumed || this.mLayoutState.mScrapList != null || !state.isPreLayout()) {
                    int i18 = layoutState.mAvailable;
                    int i19 = layoutChunkResult.mConsumed;
                    layoutState.mAvailable = i18 - i19;
                    i17 -= i19;
                }
                int i26 = layoutState.mScrollingOffset;
                if (i26 != Integer.MIN_VALUE) {
                    int i27 = i26 + layoutChunkResult.mConsumed;
                    layoutState.mScrollingOffset = i27;
                    int i28 = layoutState.mAvailable;
                    if (i28 < 0) {
                        layoutState.mScrollingOffset = i27 + i28;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z16 && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - layoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i3, int i16, boolean z16, boolean z17) {
        int i17;
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        if (i16 > i3) {
            i17 = 1;
        } else {
            i17 = -1;
        }
        View view = null;
        while (i3 != i16) {
            View childAt = getChildAt(i3);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (z16) {
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return childAt;
                    }
                    if (z17 && view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
            i3 += i17;
        }
        return view;
    }

    View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, int i16, int i17) {
        int i18;
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        if (i16 > i3) {
            i18 = 1;
        } else {
            i18 = -1;
        }
        View view = null;
        View view2 = null;
        while (i3 != i16) {
            View childAt = getChildAt(i3);
            int position = getPosition(childAt);
            if (position >= 0 && position < i17) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i3 += i18;
        }
        if (view == null) {
            return view2;
        }
        return view;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i3) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i3 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i3) {
                return childAt;
            }
        }
        return super.findViewByPosition(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z17;
        View next = layoutState.next(recycler);
        if (next == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) next.getLayoutParams();
        if (layoutState.mScrapList == null) {
            boolean z18 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z18 == z17) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            boolean z19 = this.mShouldReverseLayout;
            if (layoutState.mLayoutDirection == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z19 == z16) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i18 = getWidth() - getPaddingRight();
                i3 = i18 - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                i3 = getPaddingLeft();
                i18 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + i3;
            }
            if (layoutState.mLayoutDirection == -1) {
                i16 = layoutState.mOffset;
                i17 = i16 - layoutChunkResult.mConsumed;
            } else {
                i17 = layoutState.mOffset;
                i16 = layoutChunkResult.mConsumed + i17;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (layoutState.mLayoutDirection == -1) {
                int i19 = layoutState.mOffset;
                int i26 = i19 - layoutChunkResult.mConsumed;
                i18 = i19;
                i16 = decoratedMeasurementInOther;
                i3 = i26;
                i17 = paddingTop;
            } else {
                int i27 = layoutState.mOffset;
                int i28 = layoutChunkResult.mConsumed + i27;
                i3 = i27;
                i16 = decoratedMeasurementInOther;
                i17 = paddingTop;
                i18 = i28;
            }
        }
        layoutDecorated(next, i3 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i17, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i16 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.isFocusable();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View findReferenceChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        if (convertFocusDirectionToLayoutDirection == -1) {
            findReferenceChildClosestToEnd = findReferenceChildClosestToStart(recycler, state);
        } else {
            findReferenceChildClosestToEnd = findReferenceChildClosestToEnd(recycler, state);
        }
        if (findReferenceChildClosestToEnd == null) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd == findReferenceChildClosestToEnd || !childClosestToEnd.isFocusable()) {
            return null;
        }
        return childClosestToEnd;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(findFirstVisibleItemPosition());
            asRecord.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3;
        int i16;
        boolean z16;
        int i17;
        int i18;
        int i19;
        int i26;
        int fixLayoutEndGap;
        int i27;
        View findViewByPosition;
        int decoratedStart;
        int i28;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        this.mAnchorInfo.reset();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(recycler, state, anchorInfo);
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLastScrollDelta >= 0) {
            i3 = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i3 = 0;
        }
        int startAfterPadding = extraLayoutSpace + this.mOrientationHelper.getStartAfterPadding();
        int endPadding = i3 + this.mOrientationHelper.getEndPadding();
        if (state.isPreLayout() && (i27 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i27)) != null) {
            if (this.mShouldReverseLayout) {
                i28 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                i28 = this.mPendingScrollPositionOffset;
            }
            int i29 = i28 - decoratedStart;
            if (i29 > 0) {
                startAfterPadding += i29;
            } else {
                endPadding -= i29;
            }
        }
        AnchorInfo anchorInfo2 = this.mAnchorInfo;
        if (!anchorInfo2.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i16 = 1;
        } else {
            i16 = -1;
        }
        onAnchorReady(recycler, state, anchorInfo2, i16);
        detachAndScrapAttachedViews(recycler);
        LayoutState layoutState = this.mLayoutState;
        if (this.mOrientationHelper.getMode() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        layoutState.mInfinite = z16;
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (anchorInfo3.mLayoutFromEnd) {
            updateLayoutStateToFillStart(anchorInfo3);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtra = startAfterPadding;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i17 = layoutState3.mOffset;
            int i36 = layoutState3.mCurrentPosition;
            int i37 = layoutState3.mAvailable;
            if (i37 > 0) {
                endPadding += i37;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtra = endPadding;
            layoutState4.mCurrentPosition += layoutState4.mItemDirection;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i18 = layoutState5.mOffset;
            int i38 = layoutState5.mAvailable;
            if (i38 > 0) {
                updateLayoutStateToFillStart(i36, i17);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mExtra = i38;
                fill(recycler, layoutState6, state, false);
                i17 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo3);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.mExtra = endPadding;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            int i39 = layoutState8.mOffset;
            int i46 = layoutState8.mCurrentPosition;
            int i47 = layoutState8.mAvailable;
            if (i47 > 0) {
                startAfterPadding += i47;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mExtra = startAfterPadding;
            layoutState9.mCurrentPosition += layoutState9.mItemDirection;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            int i48 = layoutState10.mOffset;
            int i49 = layoutState10.mAvailable;
            if (i49 > 0) {
                updateLayoutStateToFillEnd(i46, i39);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.mExtra = i49;
                fill(recycler, layoutState11, state, false);
                i17 = i48;
                i18 = this.mLayoutState.mOffset;
            } else {
                i17 = i48;
                i18 = i39;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i18, recycler, state, true);
                i19 = i17 + fixLayoutEndGap2;
                i26 = i18 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i19, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i17, recycler, state, true);
                i19 = i17 + fixLayoutStartGap;
                i26 = i18 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i26, recycler, state, false);
            }
            i17 = i19 + fixLayoutEndGap;
            i18 = i26 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i17, i18);
        if (!state.isPreLayout()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
        this.mPendingSavedState = null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z16 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z16;
            if (z16) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToStart);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    int scrollBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i16;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        this.mLayoutState.mRecycle = true;
        ensureLayoutState();
        if (i3 > 0) {
            i16 = 1;
        } else {
            i16 = -1;
        }
        int abs = Math.abs(i3);
        updateLayoutState(i16, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = layoutState.mScrollingOffset + fill(recycler, layoutState, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i3 = i16 * fill;
        }
        this.mOrientationHelper.offsetChildren(-i3);
        this.mLayoutState.mLastScrollDelta = i3;
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i3, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
        EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
    }

    public void scrollToPositionWithOffset(int i3, int i16) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = i16;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
        EventCollector.getInstance().onRecyclerViewScrollToPositionWithOffset(this);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i3, recycler, state);
    }

    public void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        assertNotInLayoutOrScroll(null);
        if (i3 == this.mOrientation) {
            return;
        }
        this.mOrientation = i3;
        this.mOrientationHelper = null;
        requestLayout();
    }

    public void setRecycleChildrenOnDetach(boolean z16) {
        this.mRecycleChildrenOnDetach = z16;
    }

    public void setReverseLayout(boolean z16) {
        assertNotInLayoutOrScroll(null);
        if (z16 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z16;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z16) {
        this.mSmoothScrollbarEnabled = z16;
    }

    public void setStackFromEnd(boolean z16) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z16) {
            return;
        }
        this.mStackFromEnd = z16;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: android.support.v7.widget.LinearLayoutManager.1
            @Override // android.support.v7.widget.LinearSmoothScroller
            public PointF computeScrollVectorForPosition(int i16) {
                return LinearLayoutManager.this.computeScrollVectorForPosition(i16);
            }
        };
        linearSmoothScroller.setTargetPosition(i3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    void validateChildOrder() {
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

    public LinearLayoutManager(Context context, int i3, boolean z16) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        setOrientation(i3);
        setReverseLayout(z16);
        setAutoMeasureEnabled(true);
    }

    private void updateLayoutStateToFillEnd(int i3, int i16) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i16;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        layoutState.mCurrentPosition = i3;
        layoutState.mLayoutDirection = 1;
        layoutState.mOffset = i16;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i3, int i16) {
        this.mLayoutState.mAvailable = i16 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = i3;
        layoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        layoutState.mLayoutDirection = -1;
        layoutState.mOffset = i16;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i3, i16);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
        setAutoMeasureEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i3) {
    }
}
