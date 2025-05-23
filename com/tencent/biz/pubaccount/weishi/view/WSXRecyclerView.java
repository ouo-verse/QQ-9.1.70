package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSXRecyclerView extends XRecyclerView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f82426d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f82427e;

    public WSXRecyclerView(Context context) {
        super(context);
        this.f82426d = true;
        this.f82427e = false;
    }

    public boolean h() {
        int i3;
        LoadingMoreHelper loadMoreLayoutHelper = getLoadMoreLayoutHelper();
        RecyclerViewWithHeaderFooter recyclerView = getRecyclerView();
        int childCount = recyclerView.getChildCount();
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
            int itemCount = staggeredGridLayoutManager.getItemCount();
            try {
                i3 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            } catch (Exception e16) {
                QLog.e("WSXRecyclerView", 2, e16, new Object[0]);
                i3 = 0;
            }
            int proLoaderCount = loadMoreLayoutHelper.getProLoaderCount();
            boolean z16 = itemCount - childCount <= i3 + proLoaderCount;
            x.b("WSXRecyclerView", "totalItemCount=" + itemCount + ", visibleItemCount=" + childCount + ", firstVisibleItem=" + i3 + ", visibleThreshold=" + proLoaderCount + ", isCloseToTheEnd=" + z16);
            if (z16) {
                loadMoreLayoutHelper.setLoadMore(true);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.XRecyclerView, com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public boolean isScroll2Top() {
        if (this.f82426d) {
            return super.isScroll2Top();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void rebound() {
        x.j("WSXRecyclerView", "[WSXRecyclerView.java][rebound] mAutoScroller:" + this.f82427e);
        if (this.f82427e) {
            return;
        }
        super.rebound();
    }

    public void setIsAutoScrolling(boolean z16) {
        this.f82427e = z16;
    }

    public void setRefreshEnable(boolean z16) {
        this.f82426d = z16;
    }

    public WSXRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82426d = true;
        this.f82427e = false;
    }

    public WSXRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82426d = true;
        this.f82427e = false;
    }
}
