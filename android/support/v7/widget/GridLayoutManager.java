package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
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

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i3, int i16) {
            return i3 % i16;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SpanSizeLookup {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;

        int findReferenceIndexFromCache(int i3) {
            int size = this.mSpanIndexCache.size() - 1;
            int i16 = 0;
            while (i16 <= size) {
                int i17 = (i16 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i17) < i3) {
                    i16 = i17 + 1;
                } else {
                    size = i17 - 1;
                }
            }
            int i18 = i16 - 1;
            if (i18 >= 0 && i18 < this.mSpanIndexCache.size()) {
                return this.mSpanIndexCache.keyAt(i18);
            }
            return -1;
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
            int spanSize = getSpanSize(i3);
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < i3; i19++) {
                int spanSize2 = getSpanSize(i19);
                i17 += spanSize2;
                if (i17 == i16) {
                    i18++;
                    i17 = 0;
                } else if (i17 > i16) {
                    i18++;
                    i17 = spanSize2;
                }
            }
            if (i17 + spanSize > i16) {
                return i18 + 1;
            }
            return i18;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0031 -> B:12:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:12:0x0036). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:12:0x0036). Please report as a decompilation issue!!! */
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
            if (this.mCacheSpanIndices && this.mSpanIndexCache.size() > 0 && (i17 = findReferenceIndexFromCache(i3)) >= 0) {
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

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean z16) {
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

    private void assignSpans(RecyclerView.Recycler recycler, RecyclerView.State state, int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27 = 0;
        if (z16) {
            i18 = i3;
            i17 = 0;
            i19 = 1;
        } else {
            i17 = i3 - 1;
            i18 = -1;
            i19 = -1;
        }
        if (this.mOrientation == 1 && isLayoutRTL()) {
            i27 = this.mSpanCount - 1;
            i26 = -1;
        } else {
            i26 = 1;
        }
        while (i17 != i18) {
            View view = this.mSet[i17];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            if (i26 != -1 || layoutParams.mSpanSize <= 1) {
                layoutParams.mSpanIndex = i27;
            } else {
                layoutParams.mSpanIndex = i27 - (layoutParams.mSpanSize - 1);
            }
            i27 += layoutParams.mSpanSize * i26;
            i17 += i19;
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
            return this.mSpanSizeLookup.getSpanGroupIndex(i3, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i3);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. " + i3);
            return 0;
        }
        return this.mSpanSizeLookup.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
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

    private void measureChildWithDecorationsAndMargin(View view, int i3, int i16, boolean z16, boolean z17) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z16 || this.mOrientation == 1) {
            int i17 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            Rect rect = this.mDecorInsets;
            i3 = updateSpecWithExtra(i3, i17 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        }
        if (z16 || this.mOrientation == 0) {
            int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            Rect rect2 = this.mDecorInsets;
            i16 = updateSpecWithExtra(i16, i18 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        }
        if (z17) {
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

    private int updateSpecWithExtra(int i3, int i16, int i17) {
        if (i16 == 0 && i17 == 0) {
            return i3;
        }
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE && mode != 1073741824) {
            return i3;
        }
        return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i3) - i16) - i17, mode);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
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

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
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
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        r25.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        return;
     */
    @Override // android.support.v7.widget.LinearLayoutManager
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
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        LayoutParams layoutParams;
        View view;
        int i47;
        int i48;
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
        int i49 = this.mSpanCount;
        if (!z17) {
            i49 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        int i56 = 0;
        int i57 = 0;
        while (i57 < this.mSpanCount && layoutState.hasMore(state) && i49 > 0) {
            int i58 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i58);
            if (spanSize <= this.mSpanCount) {
                i49 -= spanSize;
                if (i49 < 0 || (next = layoutState.next(recycler)) == null) {
                    break;
                }
                i56 += spanSize;
                this.mSet[i57] = next;
                i57++;
            } else {
                throw new IllegalArgumentException("Item at position " + i58 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        int i59 = i57;
        assignSpans(recycler, state, i57, i56, z17);
        float f16 = 0.0f;
        int i65 = 0;
        int i66 = 0;
        while (i66 < i59) {
            View view2 = this.mSet[i66];
            if (layoutState.mScrapList == null) {
                if (z17) {
                    addView(view2);
                } else {
                    addView(view2, 0);
                }
            } else if (z17) {
                addDisappearingView(view2);
            } else {
                addDisappearingView(view2, 0);
            }
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            int i67 = this.mCachedBorders[layoutParams2.mSpanIndex + layoutParams2.mSpanSize] - this.mCachedBorders[layoutParams2.mSpanIndex];
            if (this.mOrientation == 0) {
                i39 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
            } else {
                i39 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
            }
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(i67, modeInOther, 0, i39, false);
            int totalSpace = this.mOrientationHelper.getTotalSpace();
            int mode = this.mOrientationHelper.getMode();
            int i68 = i65;
            if (this.mOrientation == 1) {
                i46 = ((ViewGroup.MarginLayoutParams) layoutParams2).height;
            } else {
                i46 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
            }
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(totalSpace, mode, 0, i46, true);
            if (this.mOrientation == 1) {
                layoutParams = layoutParams2;
                view = view2;
                i48 = i68;
                i47 = i66;
                measureChildWithDecorationsAndMargin(view2, childMeasureSpec, childMeasureSpec2, false, false);
            } else {
                layoutParams = layoutParams2;
                view = view2;
                i47 = i66;
                i48 = i68;
                measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, false, false);
            }
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i48) {
                i65 = decoratedMeasurement;
            } else {
                i65 = i48;
            }
            float decoratedMeasurementInOther = (this.mOrientationHelper.getDecoratedMeasurementInOther(r1) * 1.0f) / layoutParams.mSpanSize;
            if (decoratedMeasurementInOther > f16) {
                f16 = decoratedMeasurementInOther;
            }
            i66 = i47 + 1;
        }
        int i69 = i65;
        if (z16) {
            guessMeasurement(f16, i3);
            i69 = 0;
            for (int i75 = 0; i75 < i59; i75++) {
                View view3 = this.mSet[i75];
                LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                int i76 = this.mCachedBorders[layoutParams3.mSpanIndex + layoutParams3.mSpanSize] - this.mCachedBorders[layoutParams3.mSpanIndex];
                if (this.mOrientation == 0) {
                    i37 = ((ViewGroup.MarginLayoutParams) layoutParams3).height;
                } else {
                    i37 = ((ViewGroup.MarginLayoutParams) layoutParams3).width;
                }
                int childMeasureSpec3 = RecyclerView.LayoutManager.getChildMeasureSpec(i76, 1073741824, 0, i37, false);
                int totalSpace2 = this.mOrientationHelper.getTotalSpace();
                int mode2 = this.mOrientationHelper.getMode();
                if (this.mOrientation == 1) {
                    i38 = ((ViewGroup.MarginLayoutParams) layoutParams3).height;
                } else {
                    i38 = ((ViewGroup.MarginLayoutParams) layoutParams3).width;
                }
                int childMeasureSpec4 = RecyclerView.LayoutManager.getChildMeasureSpec(totalSpace2, mode2, 0, i38, true);
                if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view3, childMeasureSpec3, childMeasureSpec4, false, true);
                } else {
                    measureChildWithDecorationsAndMargin(view3, childMeasureSpec4, childMeasureSpec3, false, true);
                }
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i69) {
                    i69 = decoratedMeasurement2;
                }
            }
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i69, 1073741824);
        for (int i77 = 0; i77 < i59; i77++) {
            View view4 = this.mSet[i77];
            if (this.mOrientationHelper.getDecoratedMeasurement(view4) != i69) {
                LayoutParams layoutParams4 = (LayoutParams) view4.getLayoutParams();
                int i78 = this.mCachedBorders[layoutParams4.mSpanIndex + layoutParams4.mSpanSize] - this.mCachedBorders[layoutParams4.mSpanIndex];
                if (this.mOrientation == 0) {
                    i36 = ((ViewGroup.MarginLayoutParams) layoutParams4).height;
                } else {
                    i36 = ((ViewGroup.MarginLayoutParams) layoutParams4).width;
                }
                int childMeasureSpec5 = RecyclerView.LayoutManager.getChildMeasureSpec(i78, 1073741824, 0, i36, false);
                if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view4, childMeasureSpec5, makeMeasureSpec, true, true);
                } else {
                    measureChildWithDecorationsAndMargin(view4, makeMeasureSpec, childMeasureSpec5, true, true);
                }
            }
        }
        int i79 = 0;
        layoutChunkResult.mConsumed = i69;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == -1) {
                int i85 = layoutState.mOffset;
                i18 = i85 - i69;
                i19 = i85;
                i17 = 0;
                i16 = 0;
            } else {
                int i86 = layoutState.mOffset;
                i19 = i86 + i69;
                i16 = 0;
                i18 = i86;
                i17 = 0;
            }
        } else {
            if (layoutState.mLayoutDirection == -1) {
                i17 = layoutState.mOffset;
                i16 = i17 - i69;
            } else {
                int i87 = layoutState.mOffset;
                i16 = i87;
                i17 = i87 + i69;
            }
            i18 = 0;
            i19 = 0;
        }
        while (i79 < i59) {
            View view5 = this.mSet[i79];
            LayoutParams layoutParams5 = (LayoutParams) view5.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    i17 = getPaddingLeft() + this.mCachedBorders[layoutParams5.mSpanIndex + layoutParams5.mSpanSize];
                    i16 = i17 - this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
                } else {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[layoutParams5.mSpanIndex];
                    i26 = paddingLeft;
                    i28 = i18;
                    i27 = i19;
                    i29 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + paddingLeft;
                    layoutDecorated(view5, i26 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin, i28 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin, i29 - ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, i27 - ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin);
                    if (!layoutParams5.isItemRemoved() || layoutParams5.isItemChanged()) {
                        layoutChunkResult.mIgnoreConsumed = true;
                    }
                    layoutChunkResult.mFocusable |= view5.isFocusable();
                    i79++;
                    i17 = i29;
                    i18 = i28;
                    i19 = i27;
                    i16 = i26;
                }
            } else {
                i18 = getPaddingTop() + this.mCachedBorders[layoutParams5.mSpanIndex];
                i19 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + i18;
            }
            i29 = i17;
            i28 = i18;
            i27 = i19;
            i26 = i16;
            layoutDecorated(view5, i26 + ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin, i28 + ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin, i29 - ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin, i27 - ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin);
            if (!layoutParams5.isItemRemoved()) {
            }
            layoutChunkResult.mIgnoreConsumed = true;
            layoutChunkResult.mFocusable |= view5.isFocusable();
            i79++;
            i17 = i29;
            i18 = i28;
            i19 = i27;
            i16 = i26;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i3) {
        super.onAnchorReady(recycler, state, anchorInfo, i3);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i3);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        if (r11 == r7) goto L42;
     */
    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
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
        boolean z19;
        View findContainingItemView = findContainingItemView(view);
        View view2 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i18 = layoutParams.mSpanIndex;
        int i19 = layoutParams.mSpanIndex + layoutParams.mSpanSize;
        if (super.onFocusSearchFailed(view, i3, recycler, state) == null) {
            return null;
        }
        boolean z26 = true;
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
        int i26 = -1;
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
        int i27 = 0;
        while (i17 != childCount) {
            View childAt = getChildAt(i17);
            if (childAt == findContainingItemView) {
                break;
            }
            if (childAt.isFocusable()) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i28 = layoutParams2.mSpanIndex;
                int i29 = layoutParams2.mSpanIndex + layoutParams2.mSpanSize;
                if (i28 == i18 && i29 == i19) {
                    return childAt;
                }
                if (view2 != null) {
                    int min = Math.min(i29, i19) - Math.max(i28, i18);
                    if (min <= i27) {
                        if (min == i27) {
                            if (i28 > i26) {
                                z19 = true;
                            } else {
                                z19 = false;
                            }
                        }
                        z26 = false;
                    }
                    z26 = true;
                }
                if (z26) {
                    int i36 = layoutParams2.mSpanIndex;
                    i27 = Math.min(i29, i19) - Math.max(i28, i18);
                    i26 = i36;
                    view2 = childAt;
                }
            }
            i17 += i16;
            z26 = true;
        }
        return view2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z16;
        boolean z17;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            int spanIndex = layoutParams2.getSpanIndex();
            int spanSize = layoutParams2.getSpanSize();
            if (this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount) {
                z17 = true;
            } else {
                z17 = false;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanIndex, spanSize, spanGroupIndex, 1, z17, false));
            return;
        }
        int spanIndex2 = layoutParams2.getSpanIndex();
        int spanSize2 = layoutParams2.getSpanSize();
        if (this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount) {
            z16 = true;
        } else {
            z16 = false;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, spanIndex2, spanSize2, z16, false));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i3, int i16) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i3, int i16, int i17) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i3, int i16) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i3, int i16, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
        if (!state.isPreLayout()) {
            this.mPendingSpanCountChange = false;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i3, recycler, state);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i3, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
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
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i3);
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z16) {
        if (!z16) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
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

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
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
        private int mSpanIndex;
        private int mSpanSize;

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
