package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager {
    private static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    public static final String TAG = "StaggeredGridLayoutManager";
    public static final int VERTICAL = 1;
    public ExceptionListener mExceptionListener;
    private int mFullSizeSpec;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private LayoutState mLayoutState;
    private int mOrientation;
    private SavedState mPendingSavedState;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    OrientationHelper mSecondaryOrientation;
    private int mSizePerSpan;
    private Span[] mSpans;
    private int mSpanCount = -1;
    private boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mGapStrategy = 2;
    private final Rect mTmpRect = new Rect();
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable mCheckForGapsRunnable = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    };
    public boolean mClearSpanOnItemsChanged = true;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface ExceptionListener {
        void onGetPositionErr(View view, boolean z16, int i3, Exception exc);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int getSpanIndex() {
            Span span = this.mSpan;
            if (span == null) {
                return -1;
            }
            return span.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z16) {
            this.mFullSpan = z16;
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

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
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
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        private ArrayList<View> mViews;

        void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void cacheReferenceLineAndClear(boolean z16, int i3) {
            int startLine;
            if (z16) {
                startLine = getEndLine(Integer.MIN_VALUE);
            } else {
                startLine = getStartLine(Integer.MIN_VALUE);
            }
            clear();
            if (startLine == Integer.MIN_VALUE) {
                return;
            }
            if (!z16 || startLine >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                if (!z16 && startLine > StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    return;
                }
                if (i3 != Integer.MIN_VALUE) {
                    startLine += i3;
                }
                this.mCachedEnd = startLine;
                this.mCachedStart = startLine;
            }
        }

        void calculateCachedEnd() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            ArrayList<View> arrayList = this.mViews;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
                this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        void calculateCachedStart() {
            LazySpanLookup.FullSpanItem fullSpanItem;
            if (this.mViews.size() == 0) {
                return;
            }
            View view = this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan && (fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
                this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
            }
        }

        void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        int findOneVisibleChild(int i3, int i16, boolean z16) {
            int i17;
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            if (i16 > i3) {
                i17 = 1;
            } else {
                i17 = -1;
            }
            while (i3 != i16) {
                View view = this.mViews.get(i3);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (z16) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i3 += i17;
            }
            return -1;
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        int getEndLine(int i3) {
            int i16 = this.mCachedEnd;
            if (i16 != Integer.MIN_VALUE) {
                return i16;
            }
            if (this.mViews.size() == 0) {
                return i3;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public View getFocusableViewAfter(int i3, int i16) {
            boolean z16;
            boolean z17;
            View view = null;
            if (i16 == -1) {
                int size = this.mViews.size();
                int i17 = 0;
                while (i17 < size) {
                    View view2 = this.mViews.get(i17);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if (StaggeredGridLayoutManager.this.getPosition(view2) > i3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 != StaggeredGridLayoutManager.this.mReverseLayout) {
                        break;
                    }
                    i17++;
                    view = view2;
                }
            } else {
                int size2 = this.mViews.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.mViews.get(size2);
                    if (!view3.isFocusable()) {
                        break;
                    }
                    if (StaggeredGridLayoutManager.this.getPosition(view3) > i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 != (!StaggeredGridLayoutManager.this.mReverseLayout)) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int getStartLine(int i3) {
            int i16 = this.mCachedStart;
            if (i16 != Integer.MIN_VALUE) {
                return i16;
            }
            if (this.mViews.size() == 0) {
                return i3;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void onOffset(int i3) {
            int i16 = this.mCachedStart;
            if (i16 != Integer.MIN_VALUE) {
                this.mCachedStart = i16 + i3;
            }
            int i17 = this.mCachedEnd;
            if (i17 != Integer.MIN_VALUE) {
                this.mCachedEnd = i17 + i3;
            }
        }

        void popEnd() {
            int size = this.mViews.size();
            View remove = this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void popStart() {
            View remove = this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(remove);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(remove);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void setLine(int i3) {
            this.mCachedStart = i3;
            this.mCachedEnd = i3;
        }

        Span(int i3) {
            this.mViews = new ArrayList<>();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = i3;
        }

        int getEndLine() {
            int i3 = this.mCachedEnd;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        int getStartLine() {
            int i3 = this.mCachedStart;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i3, i16);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        setAutoMeasureEnabled(this.mGapStrategy != 0);
    }

    private void appendViewToAllSpans(View view) {
        for (int i3 = this.mSpanCount - 1; i3 >= 0; i3--) {
            this.mSpans[i3].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        int startAfterPadding;
        SavedState savedState = this.mPendingSavedState;
        int i3 = savedState.mSpanOffsetsSize;
        if (i3 > 0) {
            if (i3 == this.mSpanCount) {
                for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                    this.mSpans[i16].clear();
                    SavedState savedState2 = this.mPendingSavedState;
                    int i17 = savedState2.mSpanOffsets[i16];
                    if (i17 != Integer.MIN_VALUE) {
                        if (savedState2.mAnchorLayoutFromEnd) {
                            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        }
                        i17 += startAfterPadding;
                    }
                    this.mSpans[i16].setLine(i17);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.mPendingSavedState;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.mPendingSavedState;
        int i18 = savedState5.mAnchorPosition;
        if (i18 != -1) {
            this.mPendingScrollPosition = i18;
            anchorInfo.mLayoutFromEnd = savedState5.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
            lazySpanLookup.mData = savedState5.mSpanLookup;
            lazySpanLookup.mFullSpanItems = savedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
                return;
            } else {
                layoutParams.mSpan.appendToSpan(view);
                return;
            }
        }
        if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateScrollDirectionForPosition(int i3) {
        boolean z16;
        if (getChildCount() == 0) {
            if (!this.mShouldReverseLayout) {
                return -1;
            }
            return 1;
        }
        if (i3 < getFirstChildPosition()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.mShouldReverseLayout) {
            return -1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkForGaps() {
        int firstChildPosition;
        int lastChildPosition;
        int i3;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
            lastChildPosition = getFirstChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
            lastChildPosition = getLastChildPosition();
        }
        if (firstChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        int i16 = lastChildPosition + 1;
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, i16, i3, true);
        if (firstFullSpanItemInRange == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.forceInvalidateAfter(i16);
            return false;
        }
        LazySpanLookup.FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, firstFullSpanItemInRange.mPosition, i3 * (-1), true);
        if (firstFullSpanItemInRange2 == null) {
            this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
        } else {
            this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    private boolean checkSpanForGap(Span span) {
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                return !span.getLayoutParams((View) span.mViews.get(span.mViews.size() - 1)).mFullSpan;
            }
        } else if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return !span.getLayoutParams((View) span.mViews.get(0)).mFullSpan;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureOrientationHelper();
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureOrientationHelper();
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureOrientationHelper();
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int i3) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i16 = 0; i16 < this.mSpanCount; i16++) {
            fullSpanItem.mGapPerSpan[i16] = i3 - this.mSpans[i16].getEndLine(i3);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int i3) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i16 = 0; i16 < this.mSpanCount; i16++) {
            fullSpanItem.mGapPerSpan[i16] = this.mSpans[i16].getStartLine(i3) - i3;
        }
        return fullSpanItem;
    }

    private void ensureOrientationHelper() {
        if (this.mPrimaryOrientation == null) {
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
            this.mLayoutState = new LayoutState();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i3;
        int startAfterPadding;
        int maxEnd;
        boolean z16;
        Span span;
        int startLine;
        int decoratedMeasurement;
        int i16;
        int startAfterPadding2;
        int i17;
        int decoratedMeasurement2;
        boolean z17;
        int endAfterPadding;
        boolean areAllStartsEqual;
        int endLine;
        ?? r95 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite) {
            if (layoutState.mLayoutDirection == 1) {
                i3 = Integer.MAX_VALUE;
            } else {
                i3 = Integer.MIN_VALUE;
            }
        } else if (layoutState.mLayoutDirection == 1) {
            i3 = layoutState.mEndLine + layoutState.mAvailable;
        } else {
            i3 = layoutState.mStartLine - layoutState.mAvailable;
        }
        int i18 = i3;
        updateAllRemainingSpans(layoutState.mLayoutDirection, i18);
        if (this.mShouldReverseLayout) {
            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        }
        int i19 = startAfterPadding;
        boolean z18 = false;
        while (layoutState.hasMore(state) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
            View next = layoutState.next(recycler);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span2 = this.mLazySpanLookup.getSpan(viewLayoutPosition);
            if (span2 == -1) {
                z16 = true;
            } else {
                z16 = r95;
            }
            if (z16) {
                if (layoutParams.mFullSpan) {
                    span = this.mSpans[r95];
                } else {
                    span = getNextSpan(layoutState);
                }
                this.mLazySpanLookup.setSpan(viewLayoutPosition, span);
            } else {
                span = this.mSpans[span2];
            }
            Span span3 = span;
            layoutParams.mSpan = span3;
            if (layoutState.mLayoutDirection == 1) {
                addView(next);
            } else {
                addView(next, r95);
            }
            measureChildWithDecorationsAndMargin(next, layoutParams, r95);
            if (layoutState.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    endLine = getMaxEnd(i19);
                } else {
                    endLine = span3.getEndLine(i19);
                }
                int decoratedMeasurement3 = this.mPrimaryOrientation.getDecoratedMeasurement(next) + endLine;
                if (z16 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(endLine);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                }
                i16 = decoratedMeasurement3;
                decoratedMeasurement = endLine;
            } else {
                if (layoutParams.mFullSpan) {
                    startLine = getMinStart(i19);
                } else {
                    startLine = span3.getStartLine(i19);
                }
                decoratedMeasurement = startLine - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z16 && layoutParams.mFullSpan) {
                    LazySpanLookup.FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(startLine);
                    createFullSpanItemFromStart.mGapDir = 1;
                    createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                }
                i16 = startLine;
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (z16) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (layoutState.mLayoutDirection == 1) {
                        areAllStartsEqual = areAllEndsEqual();
                    } else {
                        areAllStartsEqual = areAllStartsEqual();
                    }
                    if (!areAllStartsEqual) {
                        LazySpanLookup.FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(next, layoutParams, layoutState);
            if (isLayoutRTL() && this.mOrientation == 1) {
                if (layoutParams.mFullSpan) {
                    endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    endAfterPadding = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - span3.mIndex) * this.mSizePerSpan);
                }
                decoratedMeasurement2 = endAfterPadding;
                i17 = endAfterPadding - this.mSecondaryOrientation.getDecoratedMeasurement(next);
            } else {
                if (layoutParams.mFullSpan) {
                    startAfterPadding2 = this.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    startAfterPadding2 = (span3.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                }
                i17 = startAfterPadding2;
                decoratedMeasurement2 = this.mSecondaryOrientation.getDecoratedMeasurement(next) + startAfterPadding2;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(next, i17, decoratedMeasurement, decoratedMeasurement2, i16);
            } else {
                layoutDecoratedWithMargins(next, decoratedMeasurement, i17, i16, decoratedMeasurement2);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i18);
            } else {
                updateRemainingSpans(span3, this.mLayoutState.mLayoutDirection, i18);
            }
            recycle(recycler, this.mLayoutState);
            if (this.mLayoutState.mStopInFocusable && next.isFocusable()) {
                if (layoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    z17 = false;
                    this.mRemainingSpans.set(span3.mIndex, false);
                    r95 = z17;
                    z18 = true;
                }
            }
            z17 = false;
            r95 = z17;
            z18 = true;
        }
        int i26 = r95;
        if (!z18) {
            recycle(recycler, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (maxEnd > 0) {
            return Math.min(layoutState.mAvailable, maxEnd);
        }
        return i26;
    }

    private int findFirstReferenceChildPosition(int i3) {
        int childCount = getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            int position = getPosition(getChildAt(i16));
            if (position >= 0 && position < i3) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i3) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i3) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i3 = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z16 && i3 > 0) {
                this.mPrimaryOrientation.offsetChildren(i3);
            }
        }
    }

    private void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z16 && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    private int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int getLastChildPosition() {
        boolean z16;
        View view;
        View childAt;
        int childCount = getChildCount();
        int i3 = 0;
        if (childCount == 0) {
            return 0;
        }
        int i16 = childCount - 1;
        try {
            return getPosition(getChildAt(i16));
        } catch (Exception e16) {
            if (childCount > 2 && (childAt = getChildAt(childCount - 2)) != null && ((RecyclerView.LayoutParams) childAt.getLayoutParams()).mViewHolder != null) {
                i3 = getPosition(childAt) + 1;
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.mExceptionListener != null) {
                if (childCount > 1) {
                    view = getChildAt(i16);
                } else {
                    view = null;
                }
                this.mExceptionListener.onGetPositionErr(view, z16, i3, e16);
                return i3;
            }
            return i3;
        }
    }

    private int getMaxEnd(int i3) {
        int endLine = this.mSpans[0].getEndLine(i3);
        for (int i16 = 1; i16 < this.mSpanCount; i16++) {
            int endLine2 = this.mSpans[i16].getEndLine(i3);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i3) {
        int startLine = this.mSpans[0].getStartLine(i3);
        for (int i16 = 1; i16 < this.mSpanCount; i16++) {
            int startLine2 = this.mSpans[i16].getStartLine(i3);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i3) {
        int endLine = this.mSpans[0].getEndLine(i3);
        for (int i16 = 1; i16 < this.mSpanCount; i16++) {
            int endLine2 = this.mSpans[i16].getEndLine(i3);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i3) {
        int startLine = this.mSpans[0].getStartLine(i3);
        for (int i16 = 1; i16 < this.mSpanCount; i16++) {
            int startLine2 = this.mSpans[i16].getStartLine(i3);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i3;
        int i16;
        int i17;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i16 = this.mSpanCount - 1;
            i3 = -1;
            i17 = -1;
        } else {
            i3 = this.mSpanCount;
            i16 = 0;
            i17 = 1;
        }
        Span span = null;
        if (layoutState.mLayoutDirection == 1) {
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            int i18 = Integer.MAX_VALUE;
            while (i16 != i3) {
                Span span2 = this.mSpans[i16];
                int endLine = span2.getEndLine(startAfterPadding);
                if (endLine < i18) {
                    span = span2;
                    i18 = endLine;
                }
                i16 += i17;
            }
            return span;
        }
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int i19 = Integer.MIN_VALUE;
        while (i16 != i3) {
            Span span3 = this.mSpans[i16];
            int startLine = span3.getStartLine(endAfterPadding);
            if (startLine > i19) {
                span = span3;
                i19 = startLine;
            }
            i16 += i17;
        }
        return span;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleUpdate(int i3, int i16, int i17) {
        int firstChildPosition;
        int i18;
        int i19;
        int lastChildPosition;
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
        }
        if (i17 == 8) {
            if (i3 < i16) {
                i18 = i16 + 1;
            } else {
                i18 = i3 + 1;
                i19 = i16;
                this.mLazySpanLookup.invalidateAfter(i19);
                if (i17 == 1) {
                    if (i17 != 2) {
                        if (i17 == 8) {
                            this.mLazySpanLookup.offsetForRemoval(i3, 1);
                            this.mLazySpanLookup.offsetForAddition(i16, 1);
                        }
                    } else {
                        this.mLazySpanLookup.offsetForRemoval(i3, i16);
                    }
                } else {
                    this.mLazySpanLookup.offsetForAddition(i3, i16);
                }
                if (i18 > firstChildPosition) {
                    return;
                }
                if (this.mShouldReverseLayout) {
                    lastChildPosition = getFirstChildPosition();
                } else {
                    lastChildPosition = getLastChildPosition();
                }
                if (i19 <= lastChildPosition) {
                    requestLayout();
                    return;
                }
                return;
            }
        } else {
            i18 = i3 + i16;
        }
        i19 = i3;
        this.mLazySpanLookup.invalidateAfter(i19);
        if (i17 == 1) {
        }
        if (i18 > firstChildPosition) {
        }
    }

    private void layoutDecoratedWithMargins(View view, int i3, int i16, int i17, int i18) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecorated(view, i3 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i16 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i17 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z16) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z16);
                return;
            } else {
                measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, true), this.mFullSizeSpec, z16);
                return;
            }
        }
        if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, true), z16);
        } else {
            measureChildWithDecorationsAndMargin(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), z16);
        }
    }

    private boolean preferLastSpan(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.mOrientation == 0) {
            if (i3 == -1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (i3 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 == this.mShouldReverseLayout) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    private void prependViewToAllSpans(View view) {
        for (int i3 = this.mSpanCount - 1; i3 >= 0; i3--) {
            this.mSpans[i3].prependToSpan(view);
        }
    }

    private void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int min;
        int min2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable == 0) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleFromEnd(recycler, layoutState.mEndLine);
                    return;
                } else {
                    recycleFromStart(recycler, layoutState.mStartLine);
                    return;
                }
            }
            if (layoutState.mLayoutDirection == -1) {
                int i3 = layoutState.mStartLine;
                int maxStart = i3 - getMaxStart(i3);
                if (maxStart < 0) {
                    min2 = layoutState.mEndLine;
                } else {
                    min2 = layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable);
                }
                recycleFromEnd(recycler, min2);
                return;
            }
            int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            if (minEnd < 0) {
                min = layoutState.mStartLine;
            } else {
                min = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
            }
            recycleFromStart(recycler, min);
        }
    }

    private void recycleFromEnd(RecyclerView.Recycler recycler, int i3) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i3) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                        if (this.mSpans[i16].mViews.size() == 1) {
                            return;
                        }
                    }
                    for (int i17 = 0; i17 < this.mSpanCount; i17++) {
                        this.mSpans[i17].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                } else {
                    layoutParams.mSpan.popEnd();
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(RecyclerView.Recycler recycler, int i3) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i3) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                        if (this.mSpans[i16].mViews.size() == 1) {
                            return;
                        }
                    }
                    for (int i17 = 0; i17 < this.mSpanCount; i17++) {
                        this.mSpans[i17].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() == 1) {
                    return;
                } else {
                    layoutParams.mSpan.popStart();
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= f16) {
                if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                f16 = Math.max(f16, decoratedMeasurement);
            }
        }
        int i16 = this.mSizePerSpan;
        int round = Math.round(f16 * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(round);
        if (this.mSizePerSpan == i16) {
            return;
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            if (!layoutParams.mFullSpan) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    int i18 = this.mSpanCount;
                    int i19 = layoutParams.mSpan.mIndex;
                    childAt2.offsetLeftAndRight(((-((i18 - 1) - i19)) * this.mSizePerSpan) - ((-((i18 - 1) - i19)) * i16));
                } else {
                    int i26 = layoutParams.mSpan.mIndex;
                    int i27 = this.mSizePerSpan * i26;
                    int i28 = i26 * i16;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i27 - i28);
                    } else {
                        childAt2.offsetTopAndBottom(i27 - i28);
                    }
                }
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

    private void setLayoutStateDirection(int i3) {
        boolean z16;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i3;
        boolean z17 = this.mShouldReverseLayout;
        int i16 = 1;
        if (i3 == -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17 != z16) {
            i16 = -1;
        }
        layoutState.mItemDirection = i16;
    }

    private void updateAllRemainingSpans(int i3, int i16) {
        for (int i17 = 0; i17 < this.mSpanCount; i17++) {
            if (!this.mSpans[i17].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i17], i3, i16);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        int findFirstReferenceChildPosition;
        if (this.mLastLayoutFromEnd) {
            findFirstReferenceChildPosition = findLastReferenceChildPosition(state.getItemCount());
        } else {
            findFirstReferenceChildPosition = findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = findFirstReferenceChildPosition;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    private void updateLayoutState(int i3, RecyclerView.State state) {
        int i16;
        int i17;
        int targetScrollPosition;
        boolean z16;
        LayoutState layoutState = this.mLayoutState;
        boolean z17 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i3;
        if (isSmoothScrolling() && (targetScrollPosition = state.getTargetScrollPosition()) != -1) {
            boolean z18 = this.mShouldReverseLayout;
            if (targetScrollPosition < i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z18 == z16) {
                i16 = this.mPrimaryOrientation.getTotalSpace();
                i17 = 0;
            } else {
                i17 = this.mPrimaryOrientation.getTotalSpace();
                i16 = 0;
            }
        } else {
            i16 = 0;
            i17 = 0;
        }
        if (getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i17;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i16;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i16;
            this.mLayoutState.mStartLine = -i17;
        }
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = false;
        layoutState2.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) {
            z17 = true;
        }
        layoutState2.mInfinite = z17;
    }

    private void updateRemainingSpans(Span span, int i3, int i16) {
        int deletedSize = span.getDeletedSize();
        if (i3 == -1) {
            if (span.getStartLine() + deletedSize <= i16) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
        } else if (span.getEndLine() - deletedSize >= i16) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int i3, int i16, int i17) {
        if (i16 == 0 && i17 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i3;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i3) - i16) - i17), mode);
    }

    boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.mSpanCount; i3++) {
            if (this.mSpans[i3].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i3 = 1; i3 < this.mSpanCount; i3++) {
            if (this.mSpans[i3].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
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
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            iArr[i3] = this.mSpans[i3].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    View findFirstVisibleItemClosestToEnd(boolean z16, boolean z17) {
        ensureOrientationHelper();
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd > endAfterPadding && z16) {
                    if (z17 && view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    View findFirstVisibleItemClosestToStart(boolean z16, boolean z17) {
        ensureOrientationHelper();
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart < startAfterPadding && z16) {
                    if (z17 && view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    int findFirstVisibleItemPositionInt() {
        View findFirstVisibleItemClosestToStart;
        if (this.mShouldReverseLayout) {
            findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToEnd(true, true);
        } else {
            findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(true, true);
        }
        if (findFirstVisibleItemClosestToStart == null) {
            return -1;
        }
        return getPosition(findFirstVisibleItemClosestToStart);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            iArr[i3] = this.mSpans[i3].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            iArr[i3] = this.mSpans[i3].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            iArr[i3] = this.mSpans[i3].findLastVisibleItemPosition();
        }
        return iArr;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View hasGapsToFix() {
        char c16;
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        boolean z18;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        int i17 = -1;
        if (this.mOrientation == 1 && isLayoutRTL()) {
            c16 = 1;
        } else {
            c16 = '\uffff';
        }
        if (this.mShouldReverseLayout) {
            i3 = -1;
        } else {
            i3 = childCount + 1;
            childCount = 0;
        }
        if (childCount < i3) {
            i17 = 1;
        }
        while (childCount != i3) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                if (checkSpanForGap(layoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.mSpan.mIndex);
            }
            if (!layoutParams.mFullSpan && (i16 = childCount + i17) != i3) {
                View childAt2 = getChildAt(i16);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                }
                if (z16) {
                    if (layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (c16 < 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z17 != z18) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i17;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i3) {
        super.offsetChildrenHorizontal(i3);
        for (int i16 = 0; i16 < this.mSpanCount; i16++) {
            this.mSpans[i16].onOffset(i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i3) {
        super.offsetChildrenVertical(i3);
        for (int i16 = 0; i16 < this.mSpanCount; i16++) {
            this.mSpans[i16].onOffset(i3);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            this.mSpans[i3].clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int firstChildPosition;
        View focusableViewAfter;
        if (getChildCount() == 0 || findContainingItemView(view) == null) {
            return null;
        }
        ensureOrientationHelper();
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i3);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z16 = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        if (convertFocusDirectionToLayoutDirection == 1) {
            firstChildPosition = getLastChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
        }
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(convertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + firstChildPosition;
        layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = true;
        layoutState2.mRecycle = false;
        fill(recycler, layoutState2, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z16 && (focusableViewAfter = span.getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != view) {
            return focusableViewAfter;
        }
        if (preferLastSpan(convertFocusDirectionToLayoutDirection)) {
            for (int i16 = this.mSpanCount - 1; i16 >= 0; i16--) {
                View focusableViewAfter2 = this.mSpans[i16].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != view) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i17 = 0; i17 < this.mSpanCount; i17++) {
                View focusableViewAfter3 = this.mSpans[i17].getFocusableViewAfter(firstChildPosition, convertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != view) {
                    return focusableViewAfter3;
                }
            }
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false, true);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false, true);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    asRecord.setFromIndex(position);
                    asRecord.setToIndex(position2);
                } else {
                    asRecord.setFromIndex(position2);
                    asRecord.setToIndex(position);
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int i3 = 1;
        if (this.mOrientation == 0) {
            int spanIndex = layoutParams2.getSpanIndex();
            boolean z16 = layoutParams2.mFullSpan;
            if (z16) {
                i3 = this.mSpanCount;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, i3, -1, -1, z16, false));
            return;
        }
        int spanIndex2 = layoutParams2.getSpanIndex();
        boolean z17 = layoutParams2.mFullSpan;
        if (z17) {
            i3 = this.mSpanCount;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, spanIndex2, i3, z17, false));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i3, int i16) {
        handleUpdate(i3, i16, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        if (this.mClearSpanOnItemsChanged) {
            this.mLazySpanLookup.clear();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i3, int i16, int i17) {
        handleUpdate(i3, i16, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        handleUpdate(i3, i16, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i3, int i16, Object obj) {
        handleUpdate(i3, i16, 4);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
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
        int firstChildPosition;
        int startLine;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup lazySpanLookup = this.mLazySpanLookup;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.mData) != null) {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.mFullSpanItems;
        } else {
            savedState.mSpanLookupSize = 0;
        }
        if (getChildCount() > 0) {
            ensureOrientationHelper();
            if (this.mLastLayoutFromEnd) {
                firstChildPosition = getLastChildPosition();
            } else {
                firstChildPosition = getFirstChildPosition();
            }
            savedState.mAnchorPosition = firstChildPosition;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i3 = this.mSpanCount;
            savedState.mSpanOffsetsSize = i3;
            savedState.mSpanOffsets = new int[i3];
            for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                if (this.mLastLayoutFromEnd) {
                    startLine = this.mSpans[i16].getEndLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        startLine -= startAfterPadding;
                        savedState.mSpanOffsets[i16] = startLine;
                    } else {
                        savedState.mSpanOffsets[i16] = startLine;
                    }
                } else {
                    startLine = this.mSpans[i16].getStartLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        startLine -= startAfterPadding;
                        savedState.mSpanOffsets[i16] = startLine;
                    } else {
                        savedState.mSpanOffsets[i16] = startLine;
                    }
                }
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i3) {
        if (i3 == 0) {
            checkForGaps();
        }
    }

    int scrollBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int firstChildPosition;
        int i16;
        ensureOrientationHelper();
        if (i3 > 0) {
            firstChildPosition = getLastChildPosition();
            i16 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            i16 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, state);
        setLayoutStateDirection(i16);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
        int abs = Math.abs(i3);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mAvailable = abs;
        int fill = fill(recycler, layoutState2, state);
        if (abs >= fill) {
            if (i3 < 0) {
                i3 = -fill;
            } else {
                i3 = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-i3);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i3, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i3) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mAnchorPosition != i3) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
        EventCollector.getInstance().onRecyclerViewScrollToPosition(this);
    }

    public void scrollToPositionWithOffset(int i3, int i16) {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i3;
        this.mPendingScrollPositionOffset = i16;
        requestLayout();
        EventCollector.getInstance().onRecyclerViewScrollToPositionWithOffset(this);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i3, recycler, state);
    }

    public void setGapStrategy(int i3) {
        boolean z16;
        assertNotInLayoutOrScroll(null);
        if (i3 == this.mGapStrategy) {
            return;
        }
        if (i3 != 0 && i3 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = i3;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setAutoMeasureEnabled(z16);
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i3, int i16) {
        int chooseSize;
        int chooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i16, rect.height() + paddingTop, getMinimumHeight());
            chooseSize = RecyclerView.LayoutManager.chooseSize(i3, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i3, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i16, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setOrientation(int i3) {
        OrientationHelper orientationHelper;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i3 == this.mOrientation) {
            return;
        }
        this.mOrientation = i3;
        OrientationHelper orientationHelper2 = this.mPrimaryOrientation;
        if (orientationHelper2 != null && (orientationHelper = this.mSecondaryOrientation) != null) {
            this.mPrimaryOrientation = orientationHelper;
            this.mSecondaryOrientation = orientationHelper2;
        }
        requestLayout();
    }

    public void setReverseLayout(boolean z16) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.mReverseLayout != z16) {
            savedState.mReverseLayout = z16;
        }
        this.mReverseLayout = z16;
        requestLayout();
    }

    public void setSpanCount(int i3) {
        assertNotInLayoutOrScroll(null);
        if (i3 != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i3;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                this.mSpans[i16] = new Span(i16);
            }
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: android.support.v7.widget.StaggeredGridLayoutManager.2
            @Override // android.support.v7.widget.LinearSmoothScroller
            public PointF computeScrollVectorForPosition(int i16) {
                int calculateScrollDirectionForPosition = StaggeredGridLayoutManager.this.calculateScrollDirectionForPosition(i16);
                if (calculateScrollDirectionForPosition == 0) {
                    return null;
                }
                if (StaggeredGridLayoutManager.this.mOrientation == 0) {
                    return new PointF(calculateScrollDirectionForPosition, 0.0f);
                }
                return new PointF(0.0f, calculateScrollDirectionForPosition);
            }
        };
        linearSmoothScroller.setTargetPosition(i3);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) {
            return true;
        }
        return false;
    }

    boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i3;
        int firstChildPosition;
        int startAfterPadding;
        boolean z16 = false;
        if (!state.isPreLayout() && (i3 = this.mPendingScrollPosition) != -1) {
            if (i3 >= 0 && i3 < state.getItemCount()) {
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.mAnchorPosition != -1 && savedState.mSpanOffsetsSize >= 1) {
                    anchorInfo.mOffset = Integer.MIN_VALUE;
                    anchorInfo.mPosition = this.mPendingScrollPosition;
                } else {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            firstChildPosition = getLastChildPosition();
                        } else {
                            firstChildPosition = getFirstChildPosition();
                        }
                        anchorInfo.mPosition = firstChildPosition;
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                            } else {
                                anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                            }
                            return true;
                        }
                        if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            if (anchorInfo.mLayoutFromEnd) {
                                startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                            } else {
                                startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                            }
                            anchorInfo.mOffset = startAfterPadding;
                            return true;
                        }
                        int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            anchorInfo.mOffset = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                        if (endAfterPadding < 0) {
                            anchorInfo.mOffset = endAfterPadding;
                            return true;
                        }
                        anchorInfo.mOffset = Integer.MIN_VALUE;
                    } else {
                        int i16 = this.mPendingScrollPosition;
                        anchorInfo.mPosition = i16;
                        int i17 = this.mPendingScrollPositionOffset;
                        if (i17 == Integer.MIN_VALUE) {
                            if (calculateScrollDirectionForPosition(i16) == 1) {
                                z16 = true;
                            }
                            anchorInfo.mLayoutFromEnd = z16;
                            anchorInfo.assignCoordinateFromPadding();
                        } else {
                            anchorInfo.assignCoordinateFromPadding(i17);
                        }
                        anchorInfo.mInvalidateOffsets = true;
                    }
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(state, anchorInfo)) {
            return;
        }
        anchorInfo.assignCoordinateFromPadding();
        anchorInfo.mPosition = 0;
    }

    void updateMeasureSpecs(int i3) {
        this.mSizePerSpan = i3 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(i3, this.mSecondaryOrientation.getMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;

        AnchorInfo() {
        }

        void assignCoordinateFromPadding() {
            this.mOffset = this.mLayoutFromEnd ? StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() : StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
        }

        void assignCoordinateFromPadding(int i3) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i3;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0117, code lost:
    
        if (checkForGaps() != false) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z16) {
        SavedState savedState;
        ensureOrientationHelper();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        anchorInfo.reset();
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.mPendingSavedState != null) {
            applyPendingSavedState(anchorInfo);
        } else {
            resolveShouldLayoutReverse();
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        updateAnchorInfoForLayout(state, anchorInfo);
        boolean z17 = true;
        if (this.mPendingSavedState == null && (anchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd || isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            anchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
            if (anchorInfo.mInvalidateOffsets) {
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].clear();
                    int i16 = anchorInfo.mOffset;
                    if (i16 != Integer.MIN_VALUE) {
                        this.mSpans[i3].setLine(i16);
                    }
                }
            } else {
                for (int i17 = 0; i17 < this.mSpanCount; i17++) {
                    this.mSpans[i17].cacheReferenceLineAndClear(this.mShouldReverseLayout, anchorInfo.mOffset);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(anchorInfo.mPosition, state);
        if (anchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(1);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        } else {
            setLayoutStateDirection(1);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(-1);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition = anchorInfo.mPosition + layoutState2.mItemDirection;
            fill(recycler, layoutState2, state);
        }
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recycler, state, true);
                fixStartGap(recycler, state, false);
            } else {
                fixStartGap(recycler, state, true);
                fixEndGap(recycler, state, false);
            }
        }
        if (!z16 || state.isPreLayout()) {
            z17 = false;
        } else {
            if (this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
                removeCallbacks(this.mCheckForGapsRunnable);
            }
            z17 = false;
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        this.mPendingSavedState = null;
        if (z17) {
            onLayoutChildren(recycler, state, false);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int i3) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i3);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i16 = 0;
            while (true) {
                if (i16 < size) {
                    if (this.mFullSpanItems.get(i16).mPosition >= i3) {
                        break;
                    }
                    i16++;
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i16);
            this.mFullSpanItems.remove(i16);
            return fullSpanItem2.mPosition;
        }

        private void offsetFullSpansForAddition(int i3, int i16) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i17 = fullSpanItem.mPosition;
                if (i17 >= i3) {
                    fullSpanItem.mPosition = i17 + i16;
                }
            }
        }

        private void offsetFullSpansForRemoval(int i3, int i16) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return;
            }
            int i17 = i3 + i16;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                int i18 = fullSpanItem.mPosition;
                if (i18 >= i3) {
                    if (i18 < i17) {
                        this.mFullSpanItems.remove(size);
                    } else {
                        fullSpanItem.mPosition = i18 - i16;
                    }
                }
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                FullSpanItem fullSpanItem2 = this.mFullSpanItems.get(i3);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i3);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i3, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.mFullSpanItems = null;
        }

        void ensureSize(int i3) {
            int[] iArr = this.mData;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i3, 10) + 1];
                this.mData = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[sizeForPosition(i3)];
                this.mData = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.mData;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int forceInvalidateAfter(int i3) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.mFullSpanItems.get(size).mPosition >= i3) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i3);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i3, int i16, int i17, boolean z16) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i18 = 0; i18 < size; i18++) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(i18);
                int i19 = fullSpanItem.mPosition;
                if (i19 >= i16) {
                    return null;
                }
                if (i19 >= i3 && (i17 == 0 || fullSpanItem.mGapDir == i17 || (z16 && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i3) {
            List<FullSpanItem> list = this.mFullSpanItems;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i3) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int getSpan(int i3) {
            int[] iArr = this.mData;
            if (iArr != null && i3 < iArr.length) {
                return iArr[i3];
            }
            return -1;
        }

        int invalidateAfter(int i3) {
            int[] iArr = this.mData;
            if (iArr == null || i3 >= iArr.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i3);
            if (invalidateFullSpansAfter == -1) {
                int[] iArr2 = this.mData;
                Arrays.fill(iArr2, i3, iArr2.length, -1);
                return this.mData.length;
            }
            int i16 = invalidateFullSpansAfter + 1;
            Arrays.fill(this.mData, i3, i16, -1);
            return i16;
        }

        void offsetForAddition(int i3, int i16) {
            int[] iArr = this.mData;
            if (iArr != null && i3 < iArr.length) {
                int i17 = i3 + i16;
                ensureSize(i17);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i3, iArr2, i17, (iArr2.length - i3) - i16);
                Arrays.fill(this.mData, i3, i17, -1);
                offsetFullSpansForAddition(i3, i16);
            }
        }

        void offsetForRemoval(int i3, int i16) {
            int[] iArr = this.mData;
            if (iArr != null && i3 < iArr.length) {
                int i17 = i3 + i16;
                ensureSize(i17);
                int[] iArr2 = this.mData;
                System.arraycopy(iArr2, i17, iArr2, i3, (iArr2.length - i3) - i16);
                int[] iArr3 = this.mData;
                Arrays.fill(iArr3, iArr3.length - i16, iArr3.length, -1);
                offsetFullSpansForRemoval(i3, i16);
            }
        }

        void setSpan(int i3, Span span) {
            ensureSize(i3);
            this.mData[i3] = span.mIndex;
        }

        int sizeForPosition(int i3) {
            int length = this.mData.length;
            while (length <= i3) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i3) {
                    return new FullSpanItem[i3];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int getGapForSpan(int i3) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i3];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.mGapPerSpan);
                } else {
                    parcel.writeInt(0);
                }
            }

            public FullSpanItem() {
            }
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i3, int i16, boolean z16) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.mTmpRect;
        int updateSpecWithExtra = updateSpecWithExtra(i3, i17 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.mTmpRect;
        int updateSpecWithExtra2 = updateSpecWithExtra(i16, i18 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z16) {
            shouldMeasureChild = shouldReMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    public StaggeredGridLayoutManager(int i3, int i16) {
        this.mOrientation = i16;
        setSpanCount(i3);
        setAutoMeasureEnabled(this.mGapStrategy != 0);
    }
}
