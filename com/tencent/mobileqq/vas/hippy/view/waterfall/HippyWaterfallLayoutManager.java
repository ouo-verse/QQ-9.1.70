package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallLayoutManager extends BaseLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    int f309518a;

    /* renamed from: b, reason: collision with root package name */
    int f309519b;

    /* renamed from: c, reason: collision with root package name */
    boolean f309520c;

    /* renamed from: d, reason: collision with root package name */
    boolean f309521d;

    /* renamed from: e, reason: collision with root package name */
    boolean f309522e;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<Integer> f309523f;

    /* renamed from: g, reason: collision with root package name */
    int f309524g;

    /* renamed from: h, reason: collision with root package name */
    int f309525h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    Rect f309526i;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f309528a;

        /* renamed from: b, reason: collision with root package name */
        int f309529b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b extends BaseLayoutManager.RenderState {

        /* renamed from: a, reason: collision with root package name */
        public int f309530a = 0;

        protected b() {
        }
    }

    public HippyWaterfallLayoutManager(Context context) {
        this(context, 1, false);
    }

    private void a(BaseLayoutManager.RenderState renderState, RecyclerViewBase.State state, int i3, View view, int i16) {
        if (view instanceof RecyclerViewItem) {
            RecyclerViewItem recyclerViewItem = (RecyclerViewItem) view;
            if (recyclerViewItem.getChildCount() > 0) {
                recordItemSize(i3, recyclerViewItem.getChildAt(0));
            }
        } else if (i16 == -1) {
            int measuredHeight = view.getMeasuredHeight();
            int abs = Math.abs(i3) - 1;
            while (abs >= this.f309523f.size()) {
                this.f309523f.add(0);
            }
            this.f309523f.set(abs, Integer.valueOf(measuredHeight));
        }
        if (renderState.hasMore(state) == 1) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            recyclerViewBase.mState.mTotalHeight = recyclerViewBase.getAdapter().getListTotalHeight();
        }
    }

    private void d(int i3, int i16, RecyclerViewBase.State state) {
        int i17;
        if (((com.tencent.mobileqq.vas.hippy.view.waterfall.a) this.mRecyclerView.getAdapter()).F) {
            return;
        }
        int preloadThresholdInItemNumber = this.mRecyclerView.mAdapter.getPreloadThresholdInItemNumber();
        int preloadThresholdInPixels = this.mRecyclerView.mAdapter.getPreloadThresholdInPixels();
        if (i3 == 1) {
            i17 = i16;
        } else {
            i17 = i16 * (-1);
        }
        int i18 = this.mRenderState.mScrollingOffset + this.f309524g;
        if (i16 > i18) {
            i17 = i3 * i18;
        }
        if (preloadThresholdInPixels > 0 && this.mRecyclerView.getHeight() < state.mTotalHeight) {
            RecyclerViewBase recyclerViewBase = this.mRecyclerView;
            if (recyclerViewBase.mOffsetY + preloadThresholdInPixels + recyclerViewBase.getHeight() < state.mTotalHeight) {
                RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
                if (recyclerViewBase2.mOffsetY + preloadThresholdInPixels + i17 + recyclerViewBase2.getHeight() >= state.mTotalHeight) {
                    this.mRecyclerView.mAdapter.onPreload();
                    return;
                }
                return;
            }
            return;
        }
        if (preloadThresholdInItemNumber > 0 && this.mRecyclerView.getHeight() < state.mTotalHeight) {
            RecyclerViewBase.Adapter<RecyclerViewBase.ViewHolder> adapter = this.mRecyclerView.mAdapter;
            BaseLayoutManager.RenderState renderState = this.mRenderState;
            int heightBefore = adapter.getHeightBefore(renderState.mCurrentPosition - renderState.mItemDirection);
            if (this.mRenderState.mCurrentPosition >= getItemCount() - preloadThresholdInItemNumber) {
                RecyclerViewBase recyclerViewBase3 = this.mRecyclerView;
                if (recyclerViewBase3.mOffsetY + recyclerViewBase3.getHeight() < state.mTotalHeight) {
                    RecyclerViewBase recyclerViewBase4 = this.mRecyclerView;
                    if (recyclerViewBase4.mOffsetY + i17 + recyclerViewBase4.getHeight() >= heightBefore) {
                        this.mRecyclerView.mAdapter.onPreload();
                    }
                }
            }
        }
    }

    private int e(RecyclerViewBase.Recycler recycler, BaseLayoutManager.RenderState renderState, int i3, int i16, View view, int i17, int i18) {
        int i19;
        if (i17 == -2) {
            i19 = f(renderState);
        } else if (i17 == -1) {
            i19 = g(renderState, view);
        } else {
            i19 = i(renderState, i16, i18);
        }
        if (this.f309522e && i16 == 0) {
            ((b) this.mRenderState).f309530a = 0;
        } else {
            resetTargetColumn();
        }
        int i26 = renderState.mLayoutDirection;
        if (i26 == -1) {
            renderState.mOffset = this.mOrientationHelper.getDecoratedStart(getChildClosestToStartInScreen());
        } else {
            renderState.mOffset += i26 * i19;
        }
        renderState.mAvailable -= Math.abs(i19);
        int abs = i3 - Math.abs(i19);
        int i27 = renderState.mScrollingOffset;
        if (i27 != Integer.MIN_VALUE) {
            int abs2 = i27 + Math.abs(i19);
            renderState.mScrollingOffset = abs2;
            int i28 = renderState.mAvailable;
            if (i28 < 0) {
                renderState.mScrollingOffset = abs2 + i28;
            }
            recycleByRenderState(recycler, renderState);
        }
        return abs;
    }

    private int f(BaseLayoutManager.RenderState renderState) {
        int i3 = renderState.mOffset;
        int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter());
        renderState.mOffset = decoratedEnd;
        return decoratedEnd - i3;
    }

    private int g(BaseLayoutManager.RenderState renderState, View view) {
        if (renderState.mLayoutDirection == -1) {
            return -this.mOrientationHelper.getDecoratedMeasurement(view);
        }
        return this.mOrientationHelper.getDecoratedMeasurement(view);
    }

    private View getChildClosestToDefaultFooter() {
        View view;
        View[] viewArr = new View[this.f309518a];
        for (int i3 = 0; i3 < getChildCount() - 1; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i16 = 0;
            while (true) {
                if (i16 >= this.f309518a) {
                    break;
                }
                if (layoutParams.f309527a == i16) {
                    viewArr[i16] = childAt;
                    break;
                }
                i16++;
            }
        }
        int i17 = 0;
        for (int i18 = 0; i18 < this.f309518a && (view = viewArr[i17]) != null && viewArr[i18] != null; i18++) {
            if (view.getBottom() < viewArr[i18].getBottom()) {
                i17 = i18;
            }
        }
        return viewArr[i17];
    }

    private View getChildClosestToEndInternal() {
        int i3;
        boolean z16 = true;
        if (this.f309522e && getChildCount() == 1) {
            return getChildAt(0);
        }
        View[] viewArr = new View[this.f309518a];
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if ((childAt.getLayoutParams() instanceof LayoutParams) && (i3 = ((LayoutParams) childAt.getLayoutParams()).f309527a) >= 0 && i3 < this.f309518a) {
                viewArr[i3] = childAt;
            }
        }
        if (this.mRenderState.mCurrentPosition != getItemCount()) {
            z16 = false;
        }
        int i17 = 0;
        for (int i18 = 0; i18 < this.f309518a; i18++) {
            if (viewArr[i18] != null) {
                View view = viewArr[i17];
                if (view != null) {
                    if (z16) {
                        if (view.getBottom() >= viewArr[i18].getBottom()) {
                        }
                    } else if (view.getBottom() < viewArr[i18].getBottom()) {
                    }
                }
                i17 = i18;
            }
        }
        return viewArr[i17];
    }

    private View getChildClosestToStartInternal() {
        int shortestColumnIndex = getShortestColumnIndex(b(getPosition(getChildClosestToStartByOrder()) + this.mRenderState.mItemDirection));
        View view = null;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            view = getChildAt(i3);
            if ((view.getLayoutParams() instanceof LayoutParams) && ((LayoutParams) view.getLayoutParams()).f309527a == shortestColumnIndex) {
                break;
            }
        }
        return view;
    }

    public static int getShortestColumnHeight(int[] iArr) {
        return iArr[getShortestColumnIndex(iArr)];
    }

    public static int getShortestColumnIndex(int[] iArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            if (iArr[i3] > iArr[i16]) {
                i3 = i16;
            }
        }
        return i3;
    }

    private int h(BaseLayoutManager.RenderState renderState, int i3, int i16, View view, RecyclerViewBase.LayoutParams layoutParams, int i17) {
        int paddingTop;
        int decoratedMeasurementInOther;
        int i18;
        int i19;
        int paddingLeft;
        int decoratedMeasurementInOther2;
        int i26;
        int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
        if (getOrientation() == 1) {
            if (i17 == -2) {
                i18 = getPaddingLeft();
                i19 = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + i18;
                paddingTop = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter());
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedEnd(getChildClosestToDefaultFooter()) + decoratedMeasurement;
            } else if (i17 == -1) {
                paddingLeft = getPaddingLeft();
                decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + paddingLeft;
                if (renderState.mLayoutDirection == -1) {
                    decoratedMeasurementInOther = renderState.mOffset;
                    i26 = decoratedMeasurementInOther - decoratedMeasurement;
                    int i27 = decoratedMeasurementInOther2;
                    paddingTop = i26;
                    i18 = paddingLeft;
                    i19 = i27;
                } else {
                    i26 = renderState.mOffset;
                    decoratedMeasurementInOther = i26 + decoratedMeasurement;
                    int i272 = decoratedMeasurementInOther2;
                    paddingTop = i26;
                    i18 = paddingLeft;
                    i19 = i272;
                }
            } else {
                int i28 = 0;
                if (this.f309520c && ((b) this.mRenderState).f309530a != 0) {
                    i28 = i16 / 2;
                }
                paddingLeft = ((((b) this.mRenderState).f309530a * i3) + getPaddingLeft()) - i28;
                decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view) + paddingLeft;
                if (renderState.mLayoutDirection == -1) {
                    int i29 = renderState.mOffset;
                    decoratedMeasurementInOther = i29;
                    i26 = i29 - decoratedMeasurement;
                    int i2722 = decoratedMeasurementInOther2;
                    paddingTop = i26;
                    i18 = paddingLeft;
                    i19 = i2722;
                } else {
                    i26 = renderState.mOffset;
                    decoratedMeasurementInOther = i26 + decoratedMeasurement;
                    int i27222 = decoratedMeasurementInOther2;
                    paddingTop = i26;
                    i18 = paddingLeft;
                    i19 = i27222;
                }
            }
        } else if (renderState.mLayoutDirection == -1) {
            decoratedMeasurementInOther = (getHeight() - getPaddingBottom()) - (i3 * ((b) this.mRenderState).f309530a);
            paddingTop = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(view);
            i19 = renderState.mOffset;
            i18 = i19 - decoratedMeasurement;
        } else {
            paddingTop = (((b) this.mRenderState).f309530a * i3) + getPaddingTop();
            decoratedMeasurementInOther = paddingTop + this.mOrientationHelper.getDecoratedMeasurementInOther(view);
            i18 = renderState.mOffset;
            i19 = i18 + decoratedMeasurement;
        }
        layoutDecorated(view, i18 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i19 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, decoratedMeasurementInOther - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        return decoratedMeasurement;
    }

    private int i(BaseLayoutManager.RenderState renderState, int i3, int i16) {
        int shortestColumnHeight;
        int shortestColumnHeight2;
        if (renderState.mLayoutDirection == -1) {
            int[] calculateColumnHeightsAfter = calculateColumnHeightsAfter(renderState.mCurrentPosition - renderState.mItemDirection);
            int[] b16 = b(renderState.mCurrentPosition - renderState.mItemDirection);
            shortestColumnHeight = k(calculateColumnHeightsAfter);
            shortestColumnHeight2 = k(b16);
        } else if (!this.f309522e || i3 != 0) {
            int[] b17 = b(renderState.mCurrentPosition - renderState.mItemDirection);
            int[] calculateColumnHeightsAfter2 = calculateColumnHeightsAfter(renderState.mCurrentPosition - renderState.mItemDirection);
            shortestColumnHeight = getShortestColumnHeight(b17);
            shortestColumnHeight2 = getShortestColumnHeight(calculateColumnHeightsAfter2);
        } else {
            return i16;
        }
        return shortestColumnHeight2 - shortestColumnHeight;
    }

    private int j(int i3, int i16, int i17, View view, RecyclerViewBase.LayoutParams layoutParams) {
        int i18;
        if (layoutParams instanceof LayoutParams) {
            int i19 = ((b) this.mRenderState).f309530a;
            ((LayoutParams) layoutParams).f309527a = i19;
            setChildPadding(i3, i16, view, i19);
        }
        if (getOrientation() == 1) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = (i17 - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight() && (view instanceof RecyclerViewItem)) {
            RecyclerViewItem recyclerViewItem = (RecyclerViewItem) view;
            if (recyclerViewItem.getChildCount() > 0) {
                View childAt = recyclerViewItem.getChildAt(0);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                } else {
                    layoutParams2 = new ViewGroup.LayoutParams(layoutParams);
                }
                if ((!this.f309522e || i16 != 0 || !this.f309521d) && (i18 = layoutParams2.width) > 0) {
                    layoutParams2.width = i18 - i3;
                }
                childAt.setLayoutParams(layoutParams2);
                childAt.measure(View.MeasureSpec.makeMeasureSpec(layoutParams2.width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
            }
        }
        if (this.f309522e && i16 == 0) {
            return this.mRecyclerView.getMeasuredWidth();
        }
        return (this.mRecyclerView.getMeasuredWidth() * (getColumns() - 1)) / getColumns();
    }

    public static int k(int[] iArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            if (iArr[i3] < iArr[i16]) {
                i3 = i16;
            }
        }
        return iArr[i3];
    }

    private int l(RecyclerViewBase.Recycler recycler, BaseLayoutManager.RenderState renderState, RecyclerViewBase.State state, int i3, int i16, int i17, int i18, int i19, View view) {
        int i26;
        boolean z16;
        RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            ((LayoutParams) layoutParams).f309527a = -1;
        }
        if (!layoutParams.isItemRemoved() && this.mRenderState.mScrapList == null) {
            boolean z17 = this.mShouldReverseLayout;
            if (renderState.mLayoutDirection == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z17 == z16) {
                addView(view);
            } else {
                addView(view, 0);
            }
        }
        int i27 = layoutParams.mViewHolder.mViewType;
        if (i27 == -3) {
            i26 = j(i16, i18, i19, view, layoutParams);
        } else {
            i26 = 0;
        }
        measureChildWithMargins(view, i26, 0);
        if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) {
            a(renderState, state, i18, view, i27);
        }
        int h16 = h(renderState, i3, i16, view, layoutParams, i27);
        if (!layoutParams.isItemRemoved()) {
            return e(recycler, renderState, i17, i18, view, i27, h16);
        }
        return i17;
    }

    private void resetTargetColumn() {
        if (this.f309522e) {
            BaseLayoutManager.RenderState renderState = this.mRenderState;
            if (renderState.mCurrentPosition == 0) {
                ((b) renderState).f309530a = 0;
                return;
            }
        }
        int[] b16 = b(this.mRenderState.mCurrentPosition);
        ((b) this.mRenderState).f309530a = getShortestColumnIndex(b16);
    }

    int[] b(int i3) {
        int i16;
        int i17 = this.f309518a;
        int[] iArr = new int[i17];
        RecyclerAdapter recyclerAdapter = (RecyclerAdapter) this.mRecyclerView.getAdapter();
        if (this.f309522e) {
            i3 += this.f309518a - 1;
        }
        for (int i18 = 0; i18 < i3; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < i17; i26++) {
                if (iArr[i19] > iArr[i26]) {
                    i19 = i26;
                }
            }
            if (this.f309522e) {
                int i27 = this.f309518a;
                if (i18 > i27 - 1) {
                    i16 = i18 - (i27 - 1);
                } else {
                    i16 = 0;
                }
            } else {
                i16 = i18;
            }
            int itemHeight = recyclerAdapter.getItemHeight(i16) + recyclerAdapter.getItemMaigin(1, i16) + recyclerAdapter.getItemMaigin(3, i16);
            iArr[i19] = iArr[i19] + itemHeight;
            if (this.f309525h < itemHeight) {
                this.f309525h = itemHeight;
            }
        }
        return iArr;
    }

    void c(b bVar) {
        int i3;
        int i16 = bVar.mCurrentPosition;
        if (i16 > 0 && bVar.mLayoutDirection == 1 && bVar.mOffset < 0) {
            int[] b16 = b(i16);
            int i17 = 0;
            int i18 = b16[0];
            int i19 = i18;
            for (int i26 = 1; i26 < b16.length; i26++) {
                int i27 = b16[i26];
                if (i27 > i19) {
                    i19 = i27;
                } else if (i27 < i18) {
                    i18 = i27;
                }
            }
            int i28 = i18 - bVar.mOffset;
            if (i19 <= i28) {
                return;
            }
            int i29 = this.f309518a;
            int i36 = bVar.f309530a;
            for (int i37 = bVar.mCurrentPosition - 1; i37 > 0 && bVar.mCurrentPosition - i37 < i29; i37--) {
                int[] b17 = b(i37);
                int i38 = b17[0];
                int i39 = 0;
                i3 = i38;
                for (int i46 = 1; i46 < b17.length; i46++) {
                    int i47 = b17[i46];
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
            if (bVar.mCurrentPosition - i17 >= i29) {
                return;
            }
            bVar.mCurrentPosition = i17;
            bVar.mOffset = i3 - i28;
            bVar.f309530a = i36;
        }
    }

    public int[] calculateColumnHeightsAfter(int i3) {
        int i16;
        int i17 = this.f309518a;
        int[] iArr = new int[i17];
        RecyclerAdapter recyclerAdapter = (RecyclerAdapter) this.mRecyclerView.getAdapter();
        if (this.f309522e) {
            i3 += this.f309518a - 1;
        }
        for (int i18 = 0; i18 <= i3; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < i17; i26++) {
                if (iArr[i19] > iArr[i26]) {
                    i19 = i26;
                }
            }
            if (this.f309522e) {
                int i27 = this.f309518a;
                if (i18 > i27 - 1) {
                    i16 = i18 - (i27 - 1);
                } else {
                    i16 = 0;
                }
            } else {
                i16 = i18;
            }
            iArr[i19] = iArr[i19] + recyclerAdapter.getItemHeight(i16) + recyclerAdapter.getItemMaigin(1, i16) + recyclerAdapter.getItemMaigin(3, i16);
        }
        return iArr;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void calculateOffsetMap(SparseIntArray sparseIntArray, int i3) {
        RecyclerAdapter recyclerAdapter = (RecyclerAdapter) this.mRecyclerView.getAdapter();
        int itemCount = recyclerAdapter.getItemCount();
        int[] iArr = new int[this.f309518a];
        for (int i16 = 0; i16 < itemCount; i16++) {
            int shortestColumnIndex = getShortestColumnIndex(iArr);
            sparseIntArray.append(i16, iArr[shortestColumnIndex]);
            iArr[shortestColumnIndex] = iArr[shortestColumnIndex] + recyclerAdapter.getItemHeight(i16) + recyclerAdapter.getItemMaigin(1, i16) + recyclerAdapter.getItemMaigin(3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void ensureRenderState() {
        if (this.mRenderState == null) {
            this.mRenderState = new b();
        }
        super.ensureRenderState();
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    protected int fill(RecyclerViewBase.Recycler recycler, BaseLayoutManager.RenderState renderState, RecyclerViewBase.State state, boolean z16) {
        int i3;
        int i16;
        c((b) renderState);
        int i17 = this.f309519b;
        if (this.f309520c) {
            int width = ((getWidth() + i17) - getPaddingLeft()) - getPaddingRight();
            Rect rect = this.f309526i;
            i3 = ((width - rect.left) - rect.right) / this.f309518a;
        } else {
            int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            Rect rect2 = this.f309526i;
            i3 = ((width2 - rect2.left) - rect2.right) / this.f309518a;
        }
        int i18 = i3;
        int i19 = renderState.mAvailable;
        int i26 = renderState.mScrollingOffset;
        if (i26 != Integer.MIN_VALUE) {
            if (i19 < 0) {
                renderState.mScrollingOffset = i26 + i19;
            }
            recycleByRenderState(recycler, renderState);
        }
        int i27 = renderState.mAvailable + renderState.mExtra;
        while (true) {
            if (i27 > 0) {
                if (state == null) {
                    QLog.e("HippyWaterfallLayout", 1, "state is null. renderState:", renderState, " remainingSpace", Integer.valueOf(i27));
                    break;
                }
                if (renderState.hasMore(state) == 1) {
                    return i27;
                }
                int i28 = renderState.mCurrentPosition;
                if (this.f309522e && i28 == 0) {
                    i16 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                } else {
                    i16 = i18;
                }
                View nextView = getNextView(recycler, renderState, state);
                if (nextView != null) {
                    i27 = l(recycler, renderState, state, i18, i17, i27, i28, i16, nextView);
                    if ((z16 && nextView.isFocusable()) || state.getTargetScrollPosition() == getPosition(nextView)) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        int i29 = renderState.mAvailable;
        this.f309524g = i19 - i29;
        return i19 - i29;
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

    public int getColumns() {
        return this.f309518a;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public int getHeightBefore(int i3) {
        int[] b16 = b(i3);
        return b16[getShortestColumnIndex(b16)];
    }

    public int getItemGap() {
        return this.f309519b;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getLayoutType() {
        return 3;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getTotalHeight() {
        return k(calculateColumnHeightsAfter(getItemCount()));
    }

    public void m(@NotNull Rect rect) {
        this.f309526i = rect;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void measureChildWithMargins(View view, int i3, int i16) {
        RecyclerViewBase.LayoutParams generateDefaultLayoutParams;
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
        a aVar = new a();
        aVar.f309528a = ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width;
        aVar.f309529b = ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).height;
        if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) {
            if (view instanceof RecyclerViewItem) {
                RecyclerViewItem recyclerViewItem = (RecyclerViewItem) view;
                if (recyclerViewItem.getChildCount() > 0) {
                    View childAt = recyclerViewItem.getChildAt(0);
                    aVar.f309528a = childAt.getMeasuredWidth() + view.getPaddingRight() + view.getPaddingLeft();
                    aVar.f309529b = childAt.getMeasuredHeight() + this.f309519b;
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    aVar.f309528a = childAt2.getMeasuredWidth();
                    aVar.f309529b = childAt2.getMeasuredHeight();
                }
            }
        }
        view.measure(RecyclerViewBase.LayoutManager.getChildMeasureSpec(getWidth(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).rightMargin + i17, aVar.f309528a, canScrollHorizontally()), RecyclerViewBase.LayoutManager.getChildMeasureSpec(getHeight(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).topMargin + ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin + i18, aVar.f309529b, canScrollVertically()));
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
        this.f309521d = z16;
    }

    void setChildPadding(int i3, int i16, View view, int i17) {
        if (this.f309522e && i16 == 0) {
            if (this.f309521d) {
                view.setPadding(0, 0, 0, this.f309519b);
                return;
            } else {
                int i18 = i3 / 2;
                view.setPadding(i18, 0, i18, this.f309519b);
                return;
            }
        }
        if (this.f309520c) {
            if (i17 == 0) {
                view.setPadding(this.f309526i.left, 0, i3 / 2, this.f309519b);
                return;
            } else if (i17 == this.f309518a - 1) {
                view.setPadding((i3 / 2) + this.f309526i.left, 0, 0, this.f309519b);
                return;
            } else {
                int i19 = i3 / 2;
                view.setPadding(this.f309526i.left + i19, 0, i19, this.f309519b);
                return;
            }
        }
        int i26 = i3 / 2;
        view.setPadding(this.f309526i.left + i26, 0, i26, this.f309519b);
    }

    public void setColumns(int i3) {
        this.f309518a = Math.max(2, i3);
    }

    public void setContainBannerView(boolean z16) {
        this.f309522e = z16;
    }

    public void setItemGap(int i3) {
        this.f309519b = Math.max(0, i3);
    }

    public void setPaddingStartZero(boolean z16) {
        this.f309520c = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderState(int i3, int i16, boolean z16, RecyclerViewBase.State state) {
        super.updateRenderState(i3, i16, z16, state);
        if (!((com.tencent.mobileqq.vas.hippy.view.waterfall.a) this.mRecyclerView.getAdapter()).F) {
            d(i3, i16, state);
        }
        resetTargetColumn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderStateToFillEnd(int i3, int i16) {
        super.updateRenderStateToFillEnd(i3, i16);
        if (this.f309522e && i3 == 0) {
            ((b) this.mRenderState).f309530a = 0;
        } else {
            resetTargetColumn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    public void updateRenderStateToFillStart(int i3, int i16) {
        super.updateRenderStateToFillStart(i3, i16);
        if (this.f309522e && i3 == 0) {
            ((b) this.mRenderState).f309530a = 0;
        } else {
            resetTargetColumn();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class LayoutParams extends RecyclerViewBase.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f309527a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f309527a = -1;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f309527a = -1;
        }
    }

    public HippyWaterfallLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, z16);
        this.f309518a = 2;
        this.f309519b = 0;
        this.f309520c = true;
        this.f309521d = false;
        this.f309522e = false;
        this.f309523f = new ArrayList<>();
        this.f309524g = 0;
        this.f309525h = 0;
        this.f309526i = new Rect(0, 0, 0, 0);
    }
}
