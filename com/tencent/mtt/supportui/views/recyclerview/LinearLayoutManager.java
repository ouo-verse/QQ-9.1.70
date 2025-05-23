package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes21.dex */
public class LinearLayoutManager extends BaseLayoutManager {
    private static final String TAG = "LinearLayoutManager";

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public void calculateOffsetMap(SparseIntArray sparseIntArray, int i3) {
        int itemHeight;
        RecyclerViewBase.Adapter adapter;
        int i16;
        if (this.mRecyclerView.mLayoutType == 1) {
            int itemCount = getItemCount();
            for (int i17 = 0; i17 < itemCount; i17++) {
                sparseIntArray.append(i17, i3);
                if (this.mRecyclerView.mLayout.canScrollHorizontally()) {
                    itemHeight = i3 + ((RecyclerAdapter) this.mRecyclerView.getAdapter()).getItemWidth(i17) + this.mRecyclerView.getAdapter().getItemMaigin(0, i17);
                    adapter = this.mRecyclerView.getAdapter();
                    i16 = 2;
                } else {
                    itemHeight = i3 + ((RecyclerAdapter) this.mRecyclerView.getAdapter()).getItemHeight(i17) + this.mRecyclerView.getAdapter().getItemMaigin(1, i17);
                    adapter = this.mRecyclerView.getAdapter();
                    i16 = 3;
                }
                i3 = itemHeight + adapter.getItemMaigin(i16, i17);
            }
        }
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    protected int fill(RecyclerViewBase.Recycler recycler, BaseLayoutManager.RenderState renderState, RecyclerViewBase.State state, boolean z16) {
        int paddingTop;
        int decoratedMeasurementInOther;
        int i3;
        int i16;
        boolean z17;
        int i17 = renderState.mAvailable;
        int i18 = renderState.mScrollingOffset;
        if (i18 != Integer.MIN_VALUE) {
            if (i17 < 0) {
                renderState.mScrollingOffset = i18 + i17;
            }
            recycleByRenderState(recycler, renderState);
        }
        int i19 = renderState.mAvailable + renderState.mExtra;
        while (true) {
            if (i19 > 0) {
                if (renderState.hasMore(state) == 1) {
                    int i26 = (i17 - renderState.mAvailable) + i19;
                    if (renderState.overscroll) {
                        if (renderState.mItemDirection > 0 && !this.mEndReached) {
                            this.mEndReached = true;
                            if (this.mRecyclerView.getAdapter() != null) {
                                this.mRecyclerView.getAdapter().notifyEndReached();
                            }
                        }
                        return i26;
                    }
                } else {
                    this.mEndReached = false;
                    int i27 = renderState.mCurrentPosition;
                    View nextView = getNextView(recycler, renderState, state);
                    if (nextView != null) {
                        RecyclerViewBase.LayoutParams layoutParams = (RecyclerViewBase.LayoutParams) nextView.getLayoutParams();
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
                        measureChildWithMargins(nextView, 0, 0);
                        if ((this.mRecyclerView.getAdapter() instanceof RecyclerAdapter) && ((RecyclerAdapter) this.mRecyclerView.getAdapter()).isAutoCalculateItemHeight()) {
                            if (nextView instanceof RecyclerViewItem) {
                                RecyclerViewItem recyclerViewItem = (RecyclerViewItem) nextView;
                                if (recyclerViewItem.getChildCount() > 0) {
                                    recordItemSize(i27, recyclerViewItem.getChildAt(0));
                                    ((RecyclerAdapter) this.mRecyclerView.getAdapter()).forceUpdateOffsetMap();
                                }
                            }
                            if (renderState.hasMore(state) == 1) {
                                this.mRecyclerView.getAdapter().getTotalHeight();
                            }
                        }
                        int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(nextView);
                        if (getOrientation() == 1) {
                            if (isLayoutRTL()) {
                                i16 = getWidth() - getPaddingRight();
                                i3 = i16 - this.mOrientationHelper.getDecoratedMeasurementInOther(nextView);
                            } else {
                                i3 = getPaddingLeft();
                                i16 = this.mOrientationHelper.getDecoratedMeasurementInOther(nextView) + i3;
                            }
                            if (renderState.mLayoutDirection == -1) {
                                decoratedMeasurementInOther = renderState.mOffset;
                                paddingTop = decoratedMeasurementInOther - decoratedMeasurement;
                            } else {
                                paddingTop = renderState.mOffset;
                                decoratedMeasurementInOther = paddingTop + decoratedMeasurement;
                            }
                        } else {
                            paddingTop = getPaddingTop();
                            decoratedMeasurementInOther = paddingTop + this.mOrientationHelper.getDecoratedMeasurementInOther(nextView);
                            if (renderState.mLayoutDirection == -1) {
                                i16 = renderState.mOffset;
                                i3 = i16 - decoratedMeasurement;
                            } else {
                                i3 = renderState.mOffset;
                                i16 = i3 + decoratedMeasurement;
                            }
                        }
                        layoutDecorated(nextView, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i3, paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, i16 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, decoratedMeasurementInOther - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        renderState.mOffset += renderState.mLayoutDirection * decoratedMeasurement;
                        if (!layoutParams.isItemRemoved()) {
                            renderState.mAvailable -= decoratedMeasurement;
                            i19 -= decoratedMeasurement;
                        }
                        int i28 = renderState.mScrollingOffset;
                        if (i28 != Integer.MIN_VALUE) {
                            int i29 = i28 + decoratedMeasurement;
                            renderState.mScrollingOffset = i29;
                            int i36 = renderState.mAvailable;
                            if (i36 < 0) {
                                renderState.mScrollingOffset = i29 + i36;
                            }
                            recycleByRenderState(recycler, renderState);
                        }
                        if ((z16 && nextView.isFocusable()) || (state != null && state.getTargetScrollPosition() == getPosition(nextView))) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return i17 - renderState.mAvailable;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.LayoutManager
    public int getLayoutType() {
        return 1;
    }

    @Override // com.tencent.mtt.supportui.views.recyclerview.BaseLayoutManager
    protected void handleRecordItemHeightChange(int i3, int i16, int i17) {
        RecyclerViewBase recyclerViewBase;
        int i18;
        RecyclerViewBase recyclerViewBase2 = this.mRecyclerView;
        if (recyclerViewBase2 != null && recyclerViewBase2.getFirstVisibleItemPos() >= i3 && (i18 = (recyclerViewBase = this.mRecyclerView).mOffsetY) > 0) {
            recyclerViewBase.mOffsetY = (i18 - i16) + i17;
        }
    }

    public LinearLayoutManager(Context context, int i3, boolean z16) {
        super(context, i3, false);
    }
}
