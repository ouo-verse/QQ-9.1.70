package com.tencent.biz.richframework.preload.recyclerview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCountLoadMoreStrategy implements LoadMoreStrategy {
    public static final int GRID_PRELOAD_SCROLL_COUNT = 16;
    public static final int LINEAR_GRID_PRELOAD_SCROLL_COUNT = 15;
    public static final int LINEAR_PRELOAD_SCROLL_COUNT = 8;
    private final boolean mSupportLoadMoreDown;
    private final boolean mSupportLoadMoreUp;

    public RFWCountLoadMoreStrategy() {
        this(false, true);
    }

    private boolean handleLinearCanLoadMoreDown(LinearLayoutManager linearLayoutManager) {
        int itemCount = (linearLayoutManager.getItemCount() - 1) - linearLayoutManager.findLastVisibleItemPosition();
        if (((linearLayoutManager instanceof GridLayoutManager) && itemCount < 15) || itemCount < getLinearPreloadCount()) {
            return true;
        }
        return false;
    }

    private boolean handleLinearCanLoadMoreUp(LinearLayoutManager linearLayoutManager) {
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        if (((linearLayoutManager instanceof GridLayoutManager) && findFirstVisibleItemPosition < 15) || findFirstVisibleItemPosition < getLinearPreloadCount()) {
            return true;
        }
        return false;
    }

    private boolean handleStaggeredGridCanLoadMoreDown(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        if (columnCountForAccessibility == 1) {
            int[] iArr = new int[1];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            if (iArr[0] < staggeredGridLayoutManager.getItemCount() - 16) {
                return false;
            }
            return true;
        }
        int[] iArr2 = new int[columnCountForAccessibility];
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
        int i3 = iArr2[columnCountForAccessibility - 1];
        if (columnCountForAccessibility == 2) {
            i3 = Math.max(iArr2[1], iArr2[0]);
        }
        if (i3 < (staggeredGridLayoutManager.getItemCount() - 1) - (columnCountForAccessibility * 3)) {
            return false;
        }
        return true;
    }

    private boolean handleStaggeredGridCanLoadMoreUp(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        if (columnCountForAccessibility == 1) {
            int[] iArr = new int[1];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            if (iArr[0] >= 16) {
                return false;
            }
            return true;
        }
        int[] iArr2 = new int[columnCountForAccessibility];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr2);
        int i3 = iArr2[columnCountForAccessibility - 1];
        if (columnCountForAccessibility == 2) {
            i3 = Math.max(iArr2[1], iArr2[0]);
        }
        if (i3 >= columnCountForAccessibility * 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.LoadMoreStrategy
    public boolean canLoadMore(RecyclerView recyclerView, int i3, int i16, int i17) {
        if ((i17 == 0 && i3 > 0) || (i17 == 1 && i16 > 0)) {
            if (!this.mSupportLoadMoreDown) {
                return false;
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                return handleLinearCanLoadMoreDown((LinearLayoutManager) recyclerView.getLayoutManager());
            }
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                return handleStaggeredGridCanLoadMoreDown((StaggeredGridLayoutManager) recyclerView.getLayoutManager());
            }
        } else {
            if (((i17 != 0 || i3 >= 0) && (i17 != 1 || i16 >= 0)) || !this.mSupportLoadMoreUp) {
                return false;
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                return handleLinearCanLoadMoreUp((LinearLayoutManager) recyclerView.getLayoutManager());
            }
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                return handleStaggeredGridCanLoadMoreUp((StaggeredGridLayoutManager) recyclerView.getLayoutManager());
            }
        }
        return false;
    }

    protected int getLinearPreloadCount() {
        return 8;
    }

    public RFWCountLoadMoreStrategy(boolean z16, boolean z17) {
        this.mSupportLoadMoreUp = z16;
        this.mSupportLoadMoreDown = z17;
    }
}
