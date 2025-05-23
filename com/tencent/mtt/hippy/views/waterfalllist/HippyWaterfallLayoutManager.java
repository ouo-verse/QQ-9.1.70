package com.tencent.mtt.hippy.views.waterfalllist;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.uimanager.i;
import com.tencent.mtt.hippy.utils.HippyViewUtil;
import com.tencent.mtt.hippy.views.refresh.FooterUtil;
import com.tencent.mtt.hippy.views.refresh.HippyPullFooterView;
import com.tencent.mtt.hippy.views.waterfalllist.HippyWaterfallView;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallLayoutManager extends BaseLayoutManager {
    static final int MIN_COLUMN = 2;
    private static final String TAG = "HippyWaterfallLayout";
    boolean mBannerViewMatch;
    int mColumnSpacing;
    int mColumns;
    boolean mHasContainBannerView;
    ArrayList<Integer> mHeaderHeight;
    int mItemGap;
    boolean mPaddingStartZero;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LayoutParams extends RecyclerViewBase.LayoutParams {
        public int mLocateAtColumn;

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.mLocateAtColumn = -1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mLocateAtColumn = -1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mLocateAtColumn = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mLocateAtColumn = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerViewBase.LayoutParams) layoutParams);
            this.mLocateAtColumn = -1;
            this.mLocateAtColumn = layoutParams.mLocateAtColumn;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class MeasureWH {
        int height;
        int width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class WaterFallRenderState extends BaseLayoutManager.RenderState {
        public int targetColumn = 0;

        protected WaterFallRenderState() {
        }
    }

    public HippyWaterfallLayoutManager(Context context) {
        this(context, 1, false);
    }

    private View getChildClosestToDefaultFooter() {
        View view;
        View[] viewArr = new View[this.mColumns];
        for (int i3 = 0; i3 < getChildCount() - 1; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i16 = 0;
            while (true) {
                if (i16 >= this.mColumns) {
                    break;
                }
                if (layoutParams.mLocateAtColumn == i16) {
                    viewArr[i16] = childAt;
                    break;
                }
                i16++;
            }
        }
        int i17 = 0;
        for (int i18 = 0; i18 < this.mColumns && (view = viewArr[i17]) != null && viewArr[i18] != null; i18++) {
            if (view.getBottom() < viewArr[i18].getBottom()) {
                i17 = i18;
            }
        }
        return viewArr[i17];
    }

    private View getChildClosestToEndInternal() {
        boolean z16;
        if (this.mHasContainBannerView && getChildCount() == 1) {
            return getChildAt(0);
        }
        View[] viewArr = new View[this.mColumns];
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getLayoutParams() instanceof LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i16 = 0;
                while (true) {
                    if (i16 >= this.mColumns) {
                        break;
                    }
                    if (layoutParams.mLocateAtColumn == i16) {
                        viewArr[i16] = childAt;
                        break;
                    }
                    i16++;
                }
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < this.mColumns && viewArr[i18] != null) {
            View view = viewArr[i17];
            if (view == null) {
                break;
            }
            if (getPosition(view) == getItemCount() - 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 || isFooterView(viewArr[i18])) {
                break;
            }
            if (viewArr[i18].getBottom() > viewArr[i17].getBottom()) {
                i18 = i17;
            }
            i17++;
        }
        i17 = i18;
        return viewArr[i17];
    }

    private View getChildClosestToStartInternal() {
        int shortestColumnIndex = getShortestColumnIndex(calculateColumnHeightsBefore(getPosition(getChildClosestToStartByOrder()) + this.mRenderState.mItemDirection, false));
        View view = null;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            view = getChildAt(i3);
            if ((view.getLayoutParams() instanceof LayoutParams) && ((LayoutParams) view.getLayoutParams()).mLocateAtColumn == shortestColumnIndex) {
                break;
            }
        }
        return view;
    }

    public static int getHightestColumnHeight(int[] iArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            if (iArr[i3] < iArr[i16]) {
                i3 = i16;
            }
        }
        return iArr[i3];
    }

    public static int getShortestColumnHeight(int[] iArr) {
        return iArr[getShortestColumnIndex(iArr)];
    }

    public static int getShortestColumnIndex(int[] iArr) {
        int i3 = 0;
        for (int i16 = 1; i16 < iArr.length; i16++) {
            if (iArr[i3] > iArr[i16]) {
                i3 = i16;
            }
        }
        return i3;
    }

    private boolean isFooterView(View view) {
        return FooterUtil.isFooterView(view);
    }

    private void resetTargetColumn() {
        if (this.mHasContainBannerView) {
            BaseLayoutManager.RenderState renderState = this.mRenderState;
            if (renderState.mCurrentPosition == 0) {
                ((WaterFallRenderState) renderState).targetColumn = 0;
                return;
            }
        }
        int[] calculateColumnHeightsBefore = calculateColumnHeightsBefore(this.mRenderState.mCurrentPosition, false);
        ((WaterFallRenderState) this.mRenderState).targetColumn = getShortestColumnIndex(calculateColumnHeightsBefore);
    }

    public int[] calculateColumnHeightsAfter(int i3) {
        return calculateColumnHeightsBefore(i3 + 1, false);
    }

    int[] calculateColumnHeightsBefore(int i3, boolean z16) {
        int[] iArr = new int[this.mColumns];
        HippyWaterfallView.HippyWaterfallAdapter hippyWaterfallAdapter = (HippyWaterfallView.HippyWaterfallAdapter) this.mRecyclerView.getAdapter();
        for (int i16 = 0; i16 < i3; i16++) {
            int itemHeight = hippyWaterfallAdapter.getItemHeight(i16) + hippyWaterfallAdapter.getItemMaigin(1, i16) + hippyWaterfallAdapter.getItemMaigin(3, i16);
            if (i16 == 0 && this.mHasContainBannerView) {
                Arrays.fill(iArr, itemHeight);
            } else if (hippyWaterfallAdapter.getItemNode(i16) instanceof i) {
                Arrays.fill(iArr, getHightestColumnHeight(iArr) + itemHeight);
            } else {
                int shortestColumnIndex = getShortestColumnIndex(iArr);
                iArr[shortestColumnIndex] = iArr[shortestColumnIndex] + itemHeight;
            }
        }
        return iArr;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void calculateOffsetMap(SparseIntArray sparseIntArray, int i3) {
        RecyclerAdapter recyclerAdapter = (RecyclerAdapter) this.mRecyclerView.getAdapter();
        int itemCount = recyclerAdapter.getItemCount();
        int[] iArr = new int[this.mColumns];
        for (int i16 = 0; i16 < itemCount; i16++) {
            int shortestColumnIndex = getShortestColumnIndex(iArr);
            sparseIntArray.append(i16, iArr[shortestColumnIndex]);
            iArr[shortestColumnIndex] = iArr[shortestColumnIndex] + recyclerAdapter.getItemHeight(i16) + recyclerAdapter.getItemMaigin(1, i16) + recyclerAdapter.getItemMaigin(3, i16);
        }
    }

    void compensateLayoutStart(WaterFallRenderState waterFallRenderState) {
        int i3;
        int i16 = waterFallRenderState.mCurrentPosition;
        if (i16 > 0 && waterFallRenderState.mLayoutDirection == 1 && waterFallRenderState.mOffset < 0) {
            int i17 = 0;
            int[] calculateColumnHeightsBefore = calculateColumnHeightsBefore(i16, false);
            int i18 = calculateColumnHeightsBefore[0];
            int i19 = i18;
            for (int i26 = 1; i26 < calculateColumnHeightsBefore.length; i26++) {
                int i27 = calculateColumnHeightsBefore[i26];
                if (i27 > i19) {
                    i19 = i27;
                } else if (i27 < i18) {
                    i18 = i27;
                }
            }
            int i28 = i18 - waterFallRenderState.mOffset;
            if (i19 <= i28) {
                return;
            }
            int i29 = this.mColumns;
            int i36 = waterFallRenderState.targetColumn;
            for (int i37 = waterFallRenderState.mCurrentPosition - 1; i37 > 0 && waterFallRenderState.mCurrentPosition - i37 < i29; i37--) {
                int[] calculateColumnHeightsBefore2 = calculateColumnHeightsBefore(i37, false);
                int i38 = calculateColumnHeightsBefore2[0];
                int i39 = 0;
                i3 = i38;
                for (int i46 = 1; i46 < calculateColumnHeightsBefore2.length; i46++) {
                    int i47 = calculateColumnHeightsBefore2[i46];
                    if (i47 > i38) {
                        i38 = i47;
                    } else if (i47 < i3) {
                        i39 = i46;
                        i3 = i47;
                    }
                }
                if (i38 <= i28) {
                    i17 = i37;
                    i36 = i39;
                    break;
                }
            }
            i3 = 0;
            if (waterFallRenderState.mCurrentPosition - i17 >= i29) {
                Log.e(TAG, "compensateLayoutStart: discard inappropriate sugguestion " + waterFallRenderState.mCurrentPosition + " -> " + i17);
                return;
            }
            int i48 = i3 - i28;
            Log.d(TAG, "compensateLayoutStart: position=" + waterFallRenderState.mCurrentPosition + "->" + i17 + " mOffset=" + waterFallRenderState.mOffset + "->" + i48 + " column=" + waterFallRenderState.targetColumn + "->" + i36);
            waterFallRenderState.mCurrentPosition = i17;
            waterFallRenderState.mOffset = i48;
            waterFallRenderState.targetColumn = i36;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void ensureRenderState() {
        if (this.mRenderState == null) {
            this.mRenderState = new WaterFallRenderState();
        }
        super.ensureRenderState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fb, code lost:
    
        if (r23.mLayoutDirection == (-1)) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01fd, code lost:
    
        r0 = r23.mOffset;
        r5 = r0 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0202, code lost:
    
        r5 = r23.mOffset;
        r0 = r5 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0227, code lost:
    
        if (r23.mLayoutDirection == (-1)) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0198  */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected int fill(RecyclerViewBase.Recycler recycler, BaseLayoutManager.RenderState renderState, RecyclerViewBase.State state, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        StringBuilder sb5;
        String str;
        int decoratedMeasurement;
        int decoratedEnd;
        int i28;
        boolean z17;
        compensateLayoutStart((WaterFallRenderState) renderState);
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / this.mColumns;
        int columnSpacing = getColumnSpacing();
        int i29 = this.mColumns;
        int i36 = (columnSpacing * (i29 - 1)) / i29;
        int i37 = renderState.mAvailable;
        int i38 = renderState.mScrollingOffset;
        int i39 = Integer.MIN_VALUE;
        if (i38 != Integer.MIN_VALUE) {
            if (i37 < 0) {
                renderState.mScrollingOffset = i38 + i37;
            }
            recycleByRenderState(recycler, renderState);
        }
        int i46 = renderState.mAvailable + renderState.mExtra;
        while (i46 > 0) {
            if (renderState.hasMore(state) == 1) {
                return i46;
            }
            int i47 = renderState.mCurrentPosition;
            if (this.mHasContainBannerView && i47 == 0) {
                i3 = getWidth();
            } else {
                i3 = width;
            }
            View nextView = getNextView(recycler, renderState, state);
            if (nextView == null) {
                break;
            }
            if (isFooterView(nextView)) {
                i3 = getWidth();
            }
            RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) nextView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).mLocateAtColumn = -1;
            }
            if (!layoutParams.isItemRemoved() && this.mRenderState.mScrapList == null) {
                boolean z18 = this.mShouldReverseLayout;
                if (renderState.mLayoutDirection == -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z18 == z17) {
                    addView(nextView);
                } else {
                    addView(nextView, 0);
                }
            }
            int i48 = layoutParams.mViewHolder.mViewType;
            if (i48 == -3) {
                if (layoutParams instanceof LayoutParams) {
                    int i49 = ((WaterFallRenderState) this.mRenderState).targetColumn;
                    ((LayoutParams) layoutParams).mLocateAtColumn = i49;
                    if (this.mHasContainBannerView && i47 == 0) {
                        setChildPadding(0, i47, nextView, i49);
                    } else if (!isFooterView(nextView)) {
                        setChildPadding(i36, i47, nextView, i49);
                    }
                }
                if (getOrientation() == 1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = (i3 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = (i3 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight() && (nextView instanceof RecyclerViewItem)) {
                    RecyclerViewItem recyclerViewItem = (RecyclerViewItem) nextView;
                    if (recyclerViewItem.getChildCount() > 0) {
                        View childAt = recyclerViewItem.getChildAt(0);
                        ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                        if (layoutParams2 != null) {
                            layoutParams2.width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                        } else {
                            layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
                        }
                        if ((!this.mHasContainBannerView || i47 != 0 || !this.mBannerViewMatch) && !isFooterView(nextView) && ((!this.mHasContainBannerView || i47 != 0) && (i28 = layoutParams2.width) > 0)) {
                            layoutParams2.width = i28 - i36;
                        }
                        childAt.setLayoutParams(layoutParams2);
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(layoutParams2.width, i39), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), i39));
                    }
                }
                if (!isFooterView(nextView)) {
                    if (this.mHasContainBannerView && i47 == 0) {
                        i16 = this.mRecyclerView.getMeasuredWidth();
                    } else {
                        i16 = (this.mRecyclerView.getMeasuredWidth() * (getColumns() - 1)) / getColumns();
                    }
                    measureChildWithMargins(nextView, i16, 0);
                    if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) {
                        if (!(nextView instanceof RecyclerViewItem)) {
                            RecyclerViewItem recyclerViewItem2 = (RecyclerViewItem) nextView;
                            if (recyclerViewItem2.getChildCount() > 0) {
                                recordItemSize(i47, recyclerViewItem2.getChildAt(0));
                            }
                        } else if (i48 == -1) {
                            int measuredHeight = nextView.getMeasuredHeight();
                            int abs = Math.abs(i47) - 1;
                            while (abs >= this.mHeaderHeight.size()) {
                                this.mHeaderHeight.add(0);
                            }
                            this.mHeaderHeight.set(abs, Integer.valueOf(measuredHeight));
                        }
                        if (renderState.hasMore(state) == 1) {
                            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
                            recyclerViewBase.mState.mTotalHeight = recyclerViewBase.getAdapter().getListTotalHeight();
                        }
                    }
                    int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(nextView);
                    if (getOrientation() != 1) {
                        if (!isFooterView(nextView) && i48 != -2) {
                            if (i48 == -1) {
                                i19 = getPaddingLeft();
                                i26 = this.mOrientationHelper.getDecoratedMeasurementInOther(nextView) + i19;
                            } else {
                                if (this.mHasContainBannerView && i47 == 0) {
                                    i19 = 0;
                                } else {
                                    i19 = (((WaterFallRenderState) this.mRenderState).targetColumn * width) + getPaddingLeft();
                                }
                                i26 = i19 + this.mOrientationHelper.getDecoratedMeasurementInOther(nextView);
                            }
                        } else {
                            i26 = this.mOrientationHelper.getDecoratedMeasurementInOther(nextView) + 0;
                            decoratedEnd = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter());
                            i18 = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter()) + decoratedMeasurement2;
                            i19 = 0;
                        }
                        i17 = decoratedEnd;
                    } else if (renderState.mLayoutDirection == -1) {
                        i18 = (getHeight() - getPaddingBottom()) - (((WaterFallRenderState) this.mRenderState).targetColumn * width);
                        int decoratedMeasurementInOther = i18 - this.mOrientationHelper.getDecoratedMeasurementInOther(nextView);
                        i26 = renderState.mOffset;
                        i17 = decoratedMeasurementInOther;
                        i19 = i26 - decoratedMeasurement2;
                    } else {
                        int paddingTop = (((WaterFallRenderState) this.mRenderState).targetColumn * width) + getPaddingTop();
                        int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(nextView) + paddingTop;
                        int i56 = renderState.mOffset;
                        i17 = paddingTop;
                        i18 = decoratedMeasurementInOther2;
                        i19 = i56;
                        i26 = i56 + decoratedMeasurement2;
                    }
                    int i57 = width;
                    int i58 = i36;
                    layoutDecorated(nextView, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i19, i17 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i26 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    if (layoutParams.isItemRemoved()) {
                        if (i48 == -2) {
                            int i59 = renderState.mOffset;
                            int decoratedEnd2 = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter());
                            renderState.mOffset = decoratedEnd2;
                            renderState.mOffset = decoratedEnd2 + this.mOrientationHelper.getDecoratedMeasurement(nextView);
                            Log.d(TAG, "fill: mOffset=" + renderState.mOffset + " viewType=" + i48 + " @1");
                            decoratedMeasurement2 = renderState.mOffset - i59;
                        } else {
                            int i65 = renderState.mLayoutDirection;
                            if (i48 == -1) {
                                if (i65 == -1) {
                                    decoratedMeasurement = -this.mOrientationHelper.getDecoratedMeasurement(nextView);
                                } else {
                                    decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(nextView);
                                }
                                decoratedMeasurement2 = decoratedMeasurement;
                                renderState.mOffset += decoratedMeasurement2;
                                sb5 = new StringBuilder();
                                sb5.append("fill: mOffset=");
                                sb5.append(renderState.mOffset);
                                sb5.append(" viewType=");
                                sb5.append(i48);
                                str = " @2";
                            } else if (i65 == -1) {
                                decoratedMeasurement2 = getHightestColumnHeight(calculateColumnHeightsBefore(renderState.mCurrentPosition - renderState.mItemDirection, false)) - getHightestColumnHeight(calculateColumnHeightsAfter(renderState.mCurrentPosition - renderState.mItemDirection));
                                renderState.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
                                sb5 = new StringBuilder();
                                sb5.append("fill: mOffset=");
                                sb5.append(renderState.mOffset);
                                sb5.append(" viewType=");
                                sb5.append(i48);
                                str = " @3";
                            } else if (this.mHasContainBannerView && i47 == 0) {
                                renderState.mOffset += decoratedMeasurement2;
                                sb5 = new StringBuilder();
                                sb5.append("fill: mOffset=");
                                sb5.append(renderState.mOffset);
                                sb5.append(" cosume=");
                                sb5.append(decoratedMeasurement2);
                                sb5.append(" viewType=");
                                sb5.append(i48);
                                str = " @4";
                            } else {
                                decoratedMeasurement2 = getShortestColumnHeight(calculateColumnHeightsAfter(renderState.mCurrentPosition - renderState.mItemDirection)) - getShortestColumnHeight(calculateColumnHeightsBefore(renderState.mCurrentPosition - renderState.mItemDirection, false));
                                renderState.mOffset += decoratedMeasurement2;
                                sb5 = new StringBuilder();
                                sb5.append("fill: mOffset=");
                                sb5.append(renderState.mOffset);
                                sb5.append(" cosume=");
                                sb5.append(decoratedMeasurement2);
                                sb5.append(" viewType=");
                                sb5.append(i48);
                                str = " @5";
                            }
                            sb5.append(str);
                            Log.d(TAG, sb5.toString());
                        }
                        if (this.mHasContainBannerView && i47 == 0) {
                            ((WaterFallRenderState) this.mRenderState).targetColumn = 0;
                        } else {
                            resetTargetColumn();
                        }
                        renderState.mAvailable -= Math.abs(decoratedMeasurement2);
                        i46 -= Math.abs(decoratedMeasurement2);
                        int i66 = renderState.mScrollingOffset;
                        i27 = Integer.MIN_VALUE;
                        if (i66 != Integer.MIN_VALUE) {
                            int abs2 = i66 + Math.abs(decoratedMeasurement2);
                            renderState.mScrollingOffset = abs2;
                            int i67 = renderState.mAvailable;
                            if (i67 < 0) {
                                renderState.mScrollingOffset = abs2 + i67;
                            }
                            recycleByRenderState(recycler, renderState);
                        }
                    } else {
                        i27 = Integer.MIN_VALUE;
                    }
                    if ((!z16 && nextView.isFocusable()) || (state != null && state.getTargetScrollPosition() == getPosition(nextView))) {
                        break;
                    }
                    i39 = i27;
                    width = i57;
                    i36 = i58;
                }
            }
            i16 = 0;
            measureChildWithMargins(nextView, i16, 0);
            if (this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) {
                if (!(nextView instanceof RecyclerViewItem)) {
                }
                if (renderState.hasMore(state) == 1) {
                }
            }
            int decoratedMeasurement22 = this.mOrientationHelper.getDecoratedMeasurement(nextView);
            if (getOrientation() != 1) {
            }
            int i572 = width;
            int i582 = i36;
            layoutDecorated(nextView, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i19, i17 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i26 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i18 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            if (layoutParams.isItemRemoved()) {
            }
            if (!z16) {
            }
            i39 = i27;
            width = i572;
            i36 = i582;
        }
        return i37 - renderState.mAvailable;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToEndInScreen() {
        if (this.mShouldReverseLayout) {
            return getChildClosestToStartInternal();
        }
        return getChildClosestToEndInternal();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public View getChildClosestToStartInScreen() {
        if (this.mShouldReverseLayout) {
            return getChildClosestToEndInternal();
        }
        return getChildClosestToStartInternal();
    }

    public int getColumnSpacing() {
        return this.mColumnSpacing;
    }

    public int getColumns() {
        return this.mColumns;
    }

    public boolean getContainBannerView() {
        return this.mHasContainBannerView;
    }

    public int getHeaderHeight(int i3) {
        if (i3 > 0 && i3 <= this.mHeaderHeight.size()) {
            return this.mHeaderHeight.get(i3 - 1).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public int getHeightBefore(int i3) {
        int[] calculateColumnHeightsBefore = calculateColumnHeightsBefore(i3, false);
        return calculateColumnHeightsBefore[getShortestColumnIndex(calculateColumnHeightsBefore)];
    }

    public int getItemGap() {
        return this.mItemGap;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getLayoutType() {
        return 3;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getTotalHeight() {
        return getHightestColumnHeight(calculateColumnHeightsBefore(getItemCount(), false));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureChildWithMargins(View view, int i3, int i16) {
        RecyclerViewBase.LayoutParams generateDefaultLayoutParams;
        boolean z16;
        int measuredHeight;
        if (view == null) {
            return;
        }
        if (view.getLayoutParams() != null) {
            generateDefaultLayoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
        } else {
            generateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i17 = i3 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
        int i18 = i16 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
        MeasureWH measureWH = new MeasureWH();
        measureWH.width = ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width;
        measureWH.height = ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).height;
        int i19 = 0;
        if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) {
            z16 = true;
            if (view instanceof RecyclerViewItem) {
                RecyclerViewItem recyclerViewItem = (RecyclerViewItem) view;
                if (recyclerViewItem.getChildCount() > 0) {
                    View childAt = recyclerViewItem.getChildAt(0);
                    if (isFooterView(childAt)) {
                        setFooterMeasureWH(childAt, measureWH);
                    } else {
                        measureWH.width = childAt.getMeasuredWidth() + view.getPaddingRight() + view.getPaddingLeft();
                        measuredHeight = childAt.getMeasuredHeight() + this.mItemGap;
                        measureWH.height = measuredHeight;
                    }
                }
            } else if (view instanceof HippyPullFooterView) {
                setFooterMeasureWH(view, measureWH);
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    measureWH.width = childAt2.getMeasuredWidth();
                    measuredHeight = childAt2.getMeasuredHeight();
                    measureWH.height = measuredHeight;
                }
            }
            if (!z16) {
                i19 = getPaddingRight() + getPaddingLeft();
            }
            view.measure(RecyclerViewBase.LayoutManager.getChildMeasureSpec(getWidth(), i19 + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).rightMargin + i17, measureWH.width, canScrollHorizontally()), RecyclerViewBase.LayoutManager.getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).topMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin + i18, measureWH.height, canScrollVertically()));
        }
        z16 = false;
        if (!z16) {
        }
        view.measure(RecyclerViewBase.LayoutManager.getChildMeasureSpec(getWidth(), i19 + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).rightMargin + i17, measureWH.width, canScrollHorizontally()), RecyclerViewBase.LayoutManager.getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).topMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin + i18, measureWH.height, canScrollVertically()));
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public RecyclerViewBase.LayoutParams onCreateItemLayoutParams(RecyclerView.ViewHolderWrapper viewHolderWrapper, int i3, int i16, int i17) {
        int itemHeight = this.mRecyclerView.getAdapter().getItemHeight(i3);
        ViewGroup.LayoutParams layoutParams = viewHolderWrapper.itemView.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, itemHeight);
        }
        if (layoutParams instanceof LayoutParams) {
            return (RecyclerViewBase.LayoutParams) layoutParams;
        }
        return new LayoutParams(layoutParams.width, itemHeight);
    }

    public void setBannerViewMatch(boolean z16) {
        this.mBannerViewMatch = z16;
    }

    void setChildPadding(int i3, int i16, View view, int i17) {
        if (this.mHasContainBannerView && i16 == 0) {
            if (this.mBannerViewMatch) {
                view.setPadding(0, 0, 0, this.mItemGap);
                return;
            }
        } else if (this.mPaddingStartZero) {
            if (i17 == 0) {
                view.setPadding(0, 0, i3, this.mItemGap);
                return;
            } else if (i17 == this.mColumns - 1) {
                view.setPadding(i3, 0, 0, this.mItemGap);
                return;
            }
        } else {
            int i18 = this.mColumns;
            int i19 = (i3 * i18) / (i18 + 1);
            if (i17 == 0) {
                view.setPadding(i19, 0, i3 - i19, this.mItemGap);
                return;
            } else if (i17 == i18 - 1) {
                view.setPadding(i3 - i19, 0, i19, this.mItemGap);
                return;
            }
        }
        int i26 = i3 / 2;
        view.setPadding(i26, 0, i26, this.mItemGap);
    }

    public void setColumnSpacing(int i3) {
        this.mColumnSpacing = Math.max(0, i3);
    }

    public void setColumns(int i3) {
        this.mColumns = Math.max(2, i3);
    }

    public void setContainBannerView(boolean z16) {
        this.mHasContainBannerView = z16;
    }

    void setFooterMeasureWH(View view, MeasureWH measureWH) {
        int height;
        RenderNode renderNode = HippyViewUtil.getRenderNode(view);
        if (renderNode != null) {
            measureWH.width = renderNode.getWidth();
            height = renderNode.getHeight();
        } else {
            measureWH.width = view.getWidth();
            height = view.getHeight();
        }
        measureWH.height = height + this.mItemGap;
    }

    public void setItemGap(int i3) {
        this.mItemGap = Math.max(0, i3);
    }

    public void setPaddingStartZero(boolean z16) {
        this.mPaddingStartZero = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderState(int i3, int i16, boolean z16, RecyclerViewBase.State state) {
        super.updateRenderState(i3, i16, z16, state);
        resetTargetColumn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderStateToFillEnd(int i3, int i16) {
        super.updateRenderStateToFillEnd(i3, i16);
        if (this.mHasContainBannerView && i3 == 0) {
            ((WaterFallRenderState) this.mRenderState).targetColumn = 0;
        } else {
            resetTargetColumn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderStateToFillStart(int i3, int i16) {
        super.updateRenderStateToFillStart(i3, i16);
        if (this.mHasContainBannerView && i3 == 0) {
            ((WaterFallRenderState) this.mRenderState).targetColumn = 0;
        } else {
            resetTargetColumn();
        }
    }

    public HippyWaterfallLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, false);
        this.mColumns = 2;
        this.mItemGap = 0;
        this.mColumnSpacing = 0;
        this.mPaddingStartZero = true;
        this.mBannerViewMatch = false;
        this.mHasContainBannerView = false;
        this.mHeaderHeight = new ArrayList<>();
    }
}
