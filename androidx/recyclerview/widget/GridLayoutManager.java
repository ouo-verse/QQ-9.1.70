package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i3, int i16) {
            return i3 % i16;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i3) {
            int size = sparseIntArray.size() - 1;
            int i16 = 0;
            while (i16 <= size) {
                int i17 = (i16 + size) >>> 1;
                if (sparseIntArray.keyAt(i17) < i3) {
                    i16 = i17 + 1;
                } else {
                    size = i17 - 1;
                }
            }
            int i18 = i16 - 1;
            if (i18 >= 0 && i18 < sparseIntArray.size()) {
                return sparseIntArray.keyAt(i18);
            }
            return -1;
        }

        int getCachedSpanGroupIndex(int i3, int i16) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i3, i16);
            }
            int i17 = this.mSpanGroupIndexCache.get(i3, -1);
            if (i17 != -1) {
                return i17;
            }
            int spanGroupIndex = getSpanGroupIndex(i3, i16);
            this.mSpanGroupIndexCache.put(i3, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i3, int i16) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i3, i16);
            }
            int i17 = this.mSpanIndexCache.get(i3, -1);
            if (i17 != -1) {
                return i17;
            }
            int spanIndex = getSpanIndex(i3, i16);
            this.mSpanIndexCache.put(i3, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            int findFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i3)) != -1) {
                i17 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i18 = findFirstKeyLessThan + 1;
                i19 = getCachedSpanIndex(findFirstKeyLessThan, i16) + getSpanSize(findFirstKeyLessThan);
                if (i19 == i16) {
                    i17++;
                    i19 = 0;
                }
            } else {
                i17 = 0;
                i18 = 0;
                i19 = 0;
            }
            int spanSize = getSpanSize(i3);
            while (i18 < i3) {
                int spanSize2 = getSpanSize(i18);
                i19 += spanSize2;
                if (i19 == i16) {
                    i17++;
                    i19 = 0;
                } else if (i19 > i16) {
                    i17++;
                    i19 = spanSize2;
                }
                i18++;
            }
            if (i19 + spanSize > i16) {
                return i17 + 1;
            }
            return i17;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i3, int i16) {
            int i17;
            int i18;
            int spanSize = getSpanSize(i3);
            if (spanSize == i16) {
                return 0;
            }
            if (this.mCacheSpanIndices && (i17 = findFirstKeyLessThan(this.mSpanIndexCache, i3)) >= 0) {
                i18 = this.mSpanIndexCache.get(i17) + getSpanSize(i17);
                i17++;
                if (i17 >= i3) {
                }
            } else {
                i17 = 0;
                i18 = 0;
                if (i17 >= i3) {
                    int spanSize2 = getSpanSize(i17);
                    i18 += spanSize2;
                    if (i18 == i16) {
                        i18 = 0;
                    } else if (i18 > i16) {
                        i18 = spanSize2;
                    }
                    i17++;
                    if (i17 >= i3) {
                        if (spanSize + i18 > i16) {
                            return 0;
                        }
                        return i18;
                    }
                }
            }
        }

        public abstract int getSpanSize(int i3);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z16) {
            if (!z16) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z16;
        }

        public void setSpanIndexCacheEnabled(boolean z16) {
            if (!z16) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z16;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i3, i16).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, boolean z16) {
        int i16;
        int i17;
        int i18;
        int i19 = 0;
        if (z16) {
            i18 = 1;
            i17 = i3;
            i16 = 0;
        } else {
            i16 = i3 - 1;
            i17 = -1;
            i18 = -1;
        }
        while (i16 != i17) {
            View view = this.mSet[i16];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanSize = spanSize;
            layoutParams.mSpanIndex = i19;
            i19 += spanSize;
            i16 += i18;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i3) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i3);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State state) {
        int max;
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max2 = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    max = Math.max(0, (cachedSpanGroupIndex3 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart)));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State state) {
        if (getChildCount() != 0 && state.getItemCount() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1;
                }
                int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((decoratedEnd / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(state.getItemCount() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i3) {
        boolean z16;
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (z16) {
            while (spanIndex > 0) {
                int i16 = anchorInfo.mPosition;
                if (i16 > 0) {
                    int i17 = i16 - 1;
                    anchorInfo.mPosition = i17;
                    spanIndex = getSpanIndex(recycler, state, i17);
                } else {
                    return;
                }
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i18 = anchorInfo.mPosition;
        while (i18 < itemCount) {
            int i19 = i18 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i19);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i18 = i19;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i18;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i3, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i3);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. " + i3);
            return 0;
        }
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i3, this.mSpanCount);
        }
        int i16 = this.mPreLayoutSpanIndexCache.get(i3, -1);
        if (i16 != -1) {
            return i16;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i3);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
            return 0;
        }
        return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler recycler, RecyclerView.State state, int i3) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i3);
        }
        int i16 = this.mPreLayoutSpanSizeCache.get(i3, -1);
        if (i16 != -1) {
            return i16;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i3);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i3);
            return 1;
        }
        return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
    }

    private void guessMeasurement(float f16, int i3) {
        calculateItemBorders(Math.max(Math.round(f16 * this.mSpanCount), i3));
    }

    private void measureChild(View view, int i3, boolean z16) {
        int i16;
        int i17;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i18 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i19 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i17 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i3, i19, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i16 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i18, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i3, i18, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i19, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i16 = childMeasureSpec;
            i17 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i17, i16, z16);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i3, int i16, boolean z16) {
        boolean shouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z16) {
            shouldMeasureChild = shouldReMeasureChild(view, i3, i16, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i3, i16, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(i3, i16);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3 = this.mSpanCount;
        for (int i16 = 0; i16 < this.mSpanCount && layoutState.hasMore(state) && i3 > 0; i16++) {
            int i17 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i17, Math.max(0, layoutState.mScrollingOffset));
            i3 -= this.mSpanSizeLookup.getSpanSize(i17);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i17 && getSpanIndex(recycler, state, position) == 0) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    int getSpaceForSpanRange(int i3, int i16) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            int i17 = this.mSpanCount;
            return iArr[i17 - i3] - iArr[(i17 - i3) - i16];
        }
        int[] iArr2 = this.mCachedBorders;
        return iArr2[i16 + i3] - iArr2[i3];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a3, code lost:
    
        r21.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
    
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int decoratedMeasurementInOther;
        int i36;
        int i37;
        int childMeasureSpec;
        int i38;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getChildCount() > 0) {
            i3 = this.mCachedBorders[this.mSpanCount];
        } else {
            i3 = 0;
        }
        if (z16) {
            updateMeasurements();
        }
        if (layoutState.mItemDirection == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        int i39 = this.mSpanCount;
        if (!z17) {
            i39 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        int i46 = 0;
        while (i46 < this.mSpanCount && layoutState.hasMore(state) && i39 > 0) {
            int i47 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i47);
            if (spanSize <= this.mSpanCount) {
                i39 -= spanSize;
                if (i39 < 0 || (next = layoutState.next(recycler)) == null) {
                    break;
                }
                this.mSet[i46] = next;
                i46++;
            } else {
                throw new IllegalArgumentException("Item at position " + i47 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        assignSpans(recycler, state, i46, z17);
        float f16 = 0.0f;
        int i48 = 0;
        for (int i49 = 0; i49 < i46; i49++) {
            View view = this.mSet[i49];
            if (layoutState.mScrapList == null) {
                if (z17) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z17) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, false);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i48) {
                i48 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther2 = (this.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther2 > f16) {
                f16 = decoratedMeasurementInOther2;
            }
        }
        if (z16) {
            guessMeasurement(f16, i3);
            i48 = 0;
            for (int i56 = 0; i56 < i46; i56++) {
                View view2 = this.mSet[i56];
                measureChild(view2, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i48) {
                    i48 = decoratedMeasurement2;
                }
            }
        }
        for (int i57 = 0; i57 < i46; i57++) {
            View view3 = this.mSet[i57];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i48) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i58 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                int i59 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i38 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i59, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i48 - i58, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i48 - i59, 1073741824);
                    childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i58, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
                    i38 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i38, childMeasureSpec, true);
            }
        }
        layoutChunkResult.mConsumed = i48;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                i27 = layoutState.mOffset;
                i37 = i27 - i48;
            } else {
                i37 = layoutState.mOffset;
                i27 = i37 + i48;
            }
            i19 = i37;
            i26 = 0;
            i18 = 0;
        } else {
            if (layoutState.mLayoutDirection == -1) {
                i17 = layoutState.mOffset;
                i16 = i17 - i48;
            } else {
                i16 = layoutState.mOffset;
                i17 = i16 + i48;
            }
            i18 = i16;
            i19 = 0;
            i26 = i17;
            i27 = 0;
        }
        int i65 = 0;
        while (i65 < i46) {
            View view4 = this.mSet[i65];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                    i18 = paddingLeft - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                    decoratedMeasurementInOther = i27;
                    i29 = paddingLeft;
                    i28 = i19;
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                    decoratedMeasurementInOther = i27;
                    i36 = paddingLeft2;
                    i28 = i19;
                    i29 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft2;
                    layoutDecoratedWithMargins(view4, i36, i28, i29, decoratedMeasurementInOther);
                    if (!layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                        layoutChunkResult.mIgnoreConsumed = true;
                    }
                    layoutChunkResult.mFocusable |= view4.hasFocusable();
                    i65++;
                    i27 = decoratedMeasurementInOther;
                    i26 = i29;
                    i19 = i28;
                    i18 = i36;
                }
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i28 = paddingTop;
                i29 = i26;
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
            }
            i36 = i18;
            layoutDecoratedWithMargins(view4, i36, i28, i29, decoratedMeasurementInOther);
            if (!layoutParams2.isItemRemoved()) {
            }
            layoutChunkResult.mIgnoreConsumed = true;
            layoutChunkResult.mFocusable |= view4.hasFocusable();
            i65++;
            i27 = decoratedMeasurementInOther;
            i26 = i29;
            i19 = i28;
            i18 = i36;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i3) {
        super.onAnchorReady(recycler, state, anchorInfo, i3);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i3);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
    
        if (r13 == r7) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f6, code lost:
    
        if (r13 == r11) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z16;
        boolean z17;
        int childCount;
        int i16;
        int i17;
        boolean z18;
        View view2;
        View view3;
        int i18;
        int i19;
        boolean z19;
        int i26;
        int i27;
        boolean z26;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i28 = layoutParams.mSpanIndex;
        int i29 = layoutParams.mSpanSize + i28;
        if (super.onFocusSearchFailed(view, i3, recycler, state) == null) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection(i3) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.mShouldReverseLayout) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i17 = getChildCount() - 1;
            childCount = -1;
            i16 = -1;
        } else {
            childCount = getChildCount();
            i16 = 1;
            i17 = 0;
        }
        if (this.mOrientation == 1 && isLayoutRTL()) {
            z18 = true;
        } else {
            z18 = false;
        }
        int spanGroupIndex = getSpanGroupIndex(recycler2, state2, i17);
        int i36 = -1;
        int i37 = -1;
        int i38 = 0;
        int i39 = 0;
        int i46 = i17;
        View view5 = null;
        while (i46 != childCount) {
            int spanGroupIndex2 = getSpanGroupIndex(recycler2, state2, i46);
            View childAt = getChildAt(i46);
            if (childAt == findContainingItemView) {
                break;
            }
            if (childAt.hasFocusable() && spanGroupIndex2 != spanGroupIndex) {
                if (view4 != null) {
                    break;
                }
                view2 = findContainingItemView;
                view3 = view5;
                i18 = i38;
                i19 = childCount;
                i27 = i37;
                i26 = i39;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i47 = layoutParams2.mSpanIndex;
                view2 = findContainingItemView;
                int i48 = layoutParams2.mSpanSize + i47;
                if (childAt.hasFocusable() && i47 == i28 && i48 == i29) {
                    return childAt;
                }
                if ((childAt.hasFocusable() && view4 == null) || (!childAt.hasFocusable() && view5 == null)) {
                    view3 = view5;
                } else {
                    view3 = view5;
                    int min = Math.min(i48, i29) - Math.max(i47, i28);
                    if (childAt.hasFocusable()) {
                        if (min <= i38) {
                            if (min == i38) {
                                if (i47 > i36) {
                                    z26 = true;
                                } else {
                                    z26 = false;
                                }
                            }
                        }
                    } else if (view4 == null) {
                        i18 = i38;
                        i19 = childCount;
                        z19 = true;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i26 = i39;
                            if (min > i26) {
                                i27 = i37;
                                if (z19) {
                                    if (childAt.hasFocusable()) {
                                        i36 = layoutParams2.mSpanIndex;
                                        i37 = i27;
                                        i39 = i26;
                                        view5 = view3;
                                        view4 = childAt;
                                        i38 = Math.min(i48, i29) - Math.max(i47, i28);
                                    } else {
                                        int i49 = layoutParams2.mSpanIndex;
                                        i39 = Math.min(i48, i29) - Math.max(i47, i28);
                                        i37 = i49;
                                        i38 = i18;
                                        view5 = childAt;
                                    }
                                    i46 += i16;
                                    recycler2 = recycler;
                                    state2 = state;
                                    findContainingItemView = view2;
                                    childCount = i19;
                                }
                            } else {
                                if (min == i26) {
                                    i27 = i37;
                                    if (i47 <= i27) {
                                        z19 = false;
                                    }
                                } else {
                                    i27 = i37;
                                }
                                z19 = false;
                                if (z19) {
                                }
                            }
                        }
                        i27 = i37;
                        i26 = i39;
                        z19 = false;
                        if (z19) {
                        }
                    }
                    i18 = i38;
                    i19 = childCount;
                    i27 = i37;
                    i26 = i39;
                    z19 = false;
                    if (z19) {
                    }
                }
                i18 = i38;
                i19 = childCount;
                i27 = i37;
                i26 = i39;
                z19 = true;
                if (z19) {
                }
            }
            i37 = i27;
            i39 = i26;
            i38 = i18;
            view5 = view3;
            i46 += i16;
            recycler2 = recycler;
            state2 = state;
            findContainingItemView = view2;
            childCount = i19;
        }
        View view6 = view5;
        if (view4 == null) {
            return view6;
        }
        return view4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i3, int i16) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i3, int i16, int i17) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i3, int i16, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i3, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i3, int i16) {
        int chooseSize;
        int chooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i3, i16);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i16, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            chooseSize = RecyclerView.LayoutManager.chooseSize(i3, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.LayoutManager.chooseSize(i3, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            chooseSize2 = RecyclerView.LayoutManager.chooseSize(i16, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i3) {
        if (i3 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i3 >= 1) {
            this.mSpanCount = i3;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z16) {
        if (!z16) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z16) {
        this.mUsingSpansToEstimateScrollBarDimensions = z16;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && !this.mPendingSpanCountChange) {
            return true;
        }
        return false;
    }

    static int[] calculateItemBorders(int[] iArr, int i3, int i16) {
        int i17;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i16) {
            iArr = new int[i3 + 1];
        }
        int i18 = 0;
        iArr[0] = 0;
        int i19 = i16 / i3;
        int i26 = i16 % i3;
        int i27 = 0;
        for (int i28 = 1; i28 <= i3; i28++) {
            i18 += i26;
            if (i18 <= 0 || i3 - i18 >= i26) {
                i17 = i19;
            } else {
                i17 = i19 + 1;
                i18 -= i3;
            }
            i27 += i17;
            iArr[i28] = i27;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    public GridLayoutManager(Context context, int i3) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i3);
    }

    public GridLayoutManager(Context context, int i3, int i16, boolean z16) {
        super(context, i16, z16);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i3);
    }
}
