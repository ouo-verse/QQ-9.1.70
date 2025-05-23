package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.component.media.MtpConstants;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        void assignCoordinateFromPadding() {
            int startAfterPadding;
            if (this.mLayoutFromEnd) {
                startAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            } else {
                startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = startAfterPadding;
        }

        public void assignFromView(View view, int i3) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = i3;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i3) {
            int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i3);
                return;
            }
            this.mPosition = i3;
            if (this.mLayoutFromEnd) {
                int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
                    int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.mCoordinate += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedStart + this.mOrientationHelper.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        boolean isViewValidAsAnchor(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            if (!layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount()) {
                return true;
            }
            return false;
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
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
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        boolean mInfinite;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mOffset;
        int mScrollingOffset;
        boolean mRecycle = true;
        int mExtraFillSpace = 0;
        int mNoRecycleSpace = 0;
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
    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
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

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return findReferenceChild(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
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
                layoutState.mExtraFillSpace = i17;
                layoutState.mAvailable = 0;
                layoutState.assignPositionFromScrapList();
                fill(recycler, this.mLayoutState, state, false);
            }
            if (i18 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i16);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.mExtraFillSpace = i18;
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
            int i3 = layoutState.mScrollingOffset;
            int i16 = layoutState.mNoRecycleSpace;
            if (layoutState.mLayoutDirection == -1) {
                recycleViewsFromEnd(recycler, i3, i16);
            } else {
                recycleViewsFromStart(recycler, i3, i16);
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

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i3, int i16) {
        int childCount = getChildCount();
        if (i3 < 0) {
            return;
        }
        int end = (this.mOrientationHelper.getEnd() - i3) + i16;
        if (this.mShouldReverseLayout) {
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                    recycleChildren(recycler, 0, i17);
                    return;
                }
            }
            return;
        }
        int i18 = childCount - 1;
        for (int i19 = i18; i19 >= 0; i19--) {
            View childAt2 = getChildAt(i19);
            if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                recycleChildren(recycler, i18, i19);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i3, int i16) {
        if (i3 < 0) {
            return;
        }
        int i17 = i3 - i16;
        int childCount = getChildCount();
        if (this.mShouldReverseLayout) {
            int i18 = childCount - 1;
            for (int i19 = i18; i19 >= 0; i19--) {
                View childAt = getChildAt(i19);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > i17 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i17) {
                    recycleChildren(recycler, i18, i19);
                    return;
                }
            }
            return;
        }
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt2 = getChildAt(i26);
            if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i17 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i17) {
                recycleChildren(recycler, 0, i26);
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
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
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
        anchorInfo.assignFromView(findReferenceChildClosestToStart, getPosition(findReferenceChildClosestToStart));
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
        int i17;
        int startAfterPadding;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = i3;
        int[] iArr = this.mReusableIntPair;
        boolean z17 = false;
        iArr[0] = 0;
        int i18 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i3 == 1) {
            z17 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z17) {
            i17 = max2;
        } else {
            i17 = max;
        }
        layoutState.mExtraFillSpace = i17;
        if (!z17) {
            max = max2;
        }
        layoutState.mNoRecycleSpace = max;
        if (z17) {
            layoutState.mExtraFillSpace = i17 + this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i18 = -1;
            }
            layoutState2.mItemDirection = i18;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.mCurrentPosition = position + layoutState3.mItemDirection;
            layoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
            LayoutState layoutState4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i18 = -1;
            }
            layoutState4.mItemDirection = i18;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState5 = this.mLayoutState;
            layoutState4.mCurrentPosition = position2 + layoutState5.mItemDirection;
            layoutState5.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LayoutState layoutState6 = this.mLayoutState;
        layoutState6.mAvailable = i16;
        if (z16) {
            layoutState6.mAvailable = i16 - startAfterPadding;
        }
        layoutState6.mScrollingOffset = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i3;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLayoutDirection == -1) {
            i3 = 0;
        } else {
            i3 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i3;
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
    public void collectAdjacentPrefetchPositions(int i3, int i16, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i17;
        if (this.mOrientation != 0) {
            i3 = i16;
        }
        if (getChildCount() != 0 && i3 != 0) {
            ensureLayoutState();
            if (i3 > 0) {
                i17 = 1;
            } else {
                i17 = -1;
            }
            updateLayoutState(i17, Math.abs(i3), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i3, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z16;
        int i16;
        SavedState savedState = this.mPendingSavedState;
        int i17 = -1;
        if (savedState != null && savedState.hasValidAnchor()) {
            SavedState savedState2 = this.mPendingSavedState;
            z16 = savedState2.mAnchorLayoutFromEnd;
            i16 = savedState2.mAnchorPosition;
        } else {
            resolveShouldLayoutReverse();
            z16 = this.mShouldReverseLayout;
            i16 = this.mPendingScrollPosition;
            if (i16 == -1) {
                i16 = z16 ? i3 - 1 : 0;
            }
        }
        if (!z16) {
            i17 = 1;
        }
        for (int i18 = 0; i18 < this.mInitialPrefetchItemCount && i16 >= 0 && i16 < i3; i18++) {
            layoutPrefetchRegistry.addPosition(i16, 0);
            i16 += i17;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3 = layoutState.mCurrentPosition;
        if (i3 >= 0 && i3 < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, layoutState.mScrollingOffset));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
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
            if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            }
            return 1;
        }
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            return -1;
        }
        return 1;
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
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
        int i17 = layoutState.mAvailable + layoutState.mExtraFillSpace;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.mInfinite && i17 <= 0) || !layoutState.hasMore(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                if (!layoutChunkResult.mIgnoreConsumed || layoutState.mScrapList != null || !state.isPreLayout()) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z16, boolean z17) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z16, z17);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z16, boolean z17) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z16, z17);
        }
        return findOneVisibleChild(0, getChildCount(), z16, z17);
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

    View findOnePartiallyOrCompletelyInvisibleChild(int i3, int i16) {
        char c16;
        int i17;
        int i18;
        ensureLayoutState();
        if (i16 > i3) {
            c16 = 1;
        } else if (i16 < i3) {
            c16 = '\uffff';
        } else {
            c16 = 0;
        }
        if (c16 == 0) {
            return getChildAt(i3);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i3)) < this.mOrientationHelper.getStartAfterPadding()) {
            i17 = 16644;
            i18 = MtpConstants.TYPE_AUINT16;
        } else {
            i17 = 4161;
            i18 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i3, i16, i17, i18);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i3, i16, i17, i18);
    }

    View findOneVisibleChild(int i3, int i16, boolean z16, boolean z17) {
        int i17;
        ensureLayoutState();
        int i18 = 320;
        if (z16) {
            i17 = GCloudVoiceErrorCode.GCloudVoiceCompleteCode.GV_ON_PUNISHED;
        } else {
            i17 = 320;
        }
        if (!z17) {
            i18 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i3, i16, i17, i18);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i3, i16, i17, i18);
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
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
        int decoratedMeasurementInOther;
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
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                i18 = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                i18 = getPaddingLeft();
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + i18;
            }
            if (layoutState.mLayoutDirection == -1) {
                int i19 = layoutState.mOffset;
                i17 = i19;
                i16 = decoratedMeasurementInOther;
                i3 = i19 - layoutChunkResult.mConsumed;
            } else {
                int i26 = layoutState.mOffset;
                i3 = i26;
                i16 = decoratedMeasurementInOther;
                i17 = layoutChunkResult.mConsumed + i26;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (layoutState.mLayoutDirection == -1) {
                int i27 = layoutState.mOffset;
                i16 = i27;
                i3 = paddingTop;
                i17 = decoratedMeasurementInOther2;
                i18 = i27 - layoutChunkResult.mConsumed;
            } else {
                int i28 = layoutState.mOffset;
                i3 = paddingTop;
                i16 = layoutChunkResult.mConsumed + i28;
                i17 = decoratedMeasurementInOther2;
                i18 = i28;
            }
        }
        layoutDecoratedWithMargins(next, i18, i3, i16, i17);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = next.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i3)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mScrollingOffset = Integer.MIN_VALUE;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int fixLayoutEndGap;
        int i26;
        View findViewByPosition;
        int decoratedStart;
        int i27;
        int i28 = -1;
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
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (anchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
                this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
            }
        } else {
            anchorInfo.reset();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.mValid = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.mLastScrollDelta >= 0) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        layoutState.mLayoutDirection = i3;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (state.isPreLayout() && (i26 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i26)) != null) {
            if (this.mShouldReverseLayout) {
                i27 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                i27 = this.mPendingScrollPositionOffset;
            }
            int i29 = i27 - decoratedStart;
            if (i29 > 0) {
                max += i29;
            } else {
                max2 -= i29;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i28 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, i28);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.mLayoutFromEnd) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mExtraFillSpace = max;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i17 = layoutState3.mOffset;
            int i36 = layoutState3.mCurrentPosition;
            int i37 = layoutState3.mAvailable;
            if (i37 > 0) {
                max2 += i37;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.mExtraFillSpace = max2;
            layoutState4.mCurrentPosition += layoutState4.mItemDirection;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i16 = layoutState5.mOffset;
            int i38 = layoutState5.mAvailable;
            if (i38 > 0) {
                updateLayoutStateToFillStart(i36, i17);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.mExtraFillSpace = i38;
                fill(recycler, layoutState6, state, false);
                i17 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.mExtraFillSpace = max2;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            i16 = layoutState8.mOffset;
            int i39 = layoutState8.mCurrentPosition;
            int i46 = layoutState8.mAvailable;
            if (i46 > 0) {
                max += i46;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.mExtraFillSpace = max;
            layoutState9.mCurrentPosition += layoutState9.mItemDirection;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            i17 = layoutState10.mOffset;
            int i47 = layoutState10.mAvailable;
            if (i47 > 0) {
                updateLayoutStateToFillEnd(i39, i16);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.mExtraFillSpace = i47;
                fill(recycler, layoutState11, state, false);
                i16 = this.mLayoutState.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i16, recycler, state, true);
                i18 = i17 + fixLayoutEndGap2;
                i19 = i16 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i18, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i17, recycler, state, true);
                i18 = i17 + fixLayoutStartGap;
                i19 = i16 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i19, recycler, state, false);
            }
            i17 = i18 + fixLayoutEndGap;
            i16 = i19 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i17, i16);
        if (!state.isPreLayout()) {
            this.mOrientationHelper.onLayoutComplete();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
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

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i3, int i16) {
        char c16;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            c16 = 1;
        } else {
            c16 = '\uffff';
        }
        if (this.mShouldReverseLayout) {
            if (c16 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
                return;
            }
        }
        if (c16 == '\uffff') {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0) {
            return true;
        }
        return false;
    }

    int scrollBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i16;
        if (getChildCount() == 0 || i3 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i3, int i16) {
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = i16;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i3, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i3) {
        this.mInitialPrefetchItemCount = i3;
    }

    public void setOrientation(int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i3);
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.mOrientation || this.mOrientationHelper == null) {
            OrientationHelper createOrientationHelper = OrientationHelper.createOrientationHelper(this, i3);
            this.mOrientationHelper = createOrientationHelper;
            this.mAnchorInfo.mOrientationHelper = createOrientationHelper;
            this.mOrientation = i3;
            requestLayout();
        }
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

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824 && getWidthMode() != 1073741824 && hasFlexibleChildInBothOrientations()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
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
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i3);
        setReverseLayout(z16);
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
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i3, i16);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i3) {
    }
}
