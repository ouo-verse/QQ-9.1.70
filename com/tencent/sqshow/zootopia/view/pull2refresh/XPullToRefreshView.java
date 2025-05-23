package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* loaded from: classes34.dex */
public class XPullToRefreshView extends AbsPullToRefreshView implements PullToRefreshListener, LoadingMoreHelper.OnLoadMoreListener {
    private c L;
    protected RecyclerViewWithHeaderFooterFix M;
    private LoadingMoreHelper N;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private int U;
    private ThreadLocal<Boolean> V;

    /* loaded from: classes34.dex */
    class a extends ThreadLocal<Boolean> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && XPullToRefreshView.this.P == 2 && XPullToRefreshView.this.S) {
                XPullToRefreshView.this.t();
            }
            int childCount = recyclerView.getChildCount();
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int itemCount = staggeredGridLayoutManager.getItemCount();
                int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
                int proLoaderCount = XPullToRefreshView.this.N.getProLoaderCount();
                boolean z16 = itemCount - childCount <= findFirstVisibleItemPositions[0] + proLoaderCount;
                if (QLog.isColorLevel()) {
                    QLog.d(XRecyclerView.TAG, 2, "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(itemCount), Integer.valueOf(findFirstVisibleItemPositions[0]), Integer.valueOf(proLoaderCount), Boolean.valueOf(z16));
                }
                if (z16) {
                    XPullToRefreshView.this.N.setLoadMore(true);
                }
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getItemCount() - childCount <= linearLayoutManager.findFirstVisibleItemPosition() + XPullToRefreshView.this.N.getProLoaderCount()) {
                    XPullToRefreshView.this.N.setLoadMore(true);
                }
            }
            XPullToRefreshView.this.P = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            XPullToRefreshView.w(XPullToRefreshView.this, i3);
            XPullToRefreshView.x(XPullToRefreshView.this, i16);
        }
    }

    /* loaded from: classes34.dex */
    public interface c {
        void J3(XPullToRefreshView xPullToRefreshView, int i3);

        void endOfRefresh();

        void xe(XPullToRefreshView xPullToRefreshView, boolean z16);
    }

    public XPullToRefreshView(Context context) {
        super(context);
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = 0;
        this.U = 0;
        this.V = new a();
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        u(this);
        LayoutInflater.from(getContext()).inflate(R.layout.d9n, (ViewGroup) this, true);
        ILoadMoreLayout C = C();
        this.M = (RecyclerViewWithHeaderFooterFix) findViewById(R.id.qey);
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = new com.tencent.sqshow.zootopia.view.pull2refresh.a(C, getContext());
        this.N = aVar;
        aVar.setLoadMoreEnabled(true);
        this.N.setOnLoadMoreListener(this);
        this.M.addFooterView((View) C);
        this.M.addOnScrollListener(new b());
        a(this.f373347f);
    }

    static /* synthetic */ int w(XPullToRefreshView xPullToRefreshView, int i3) {
        int i16 = xPullToRefreshView.T + i3;
        xPullToRefreshView.T = i16;
        return i16;
    }

    static /* synthetic */ int x(XPullToRefreshView xPullToRefreshView, int i3) {
        int i16 = xPullToRefreshView.U + i3;
        xPullToRefreshView.U = i16;
        return i16;
    }

    protected ILoadMoreLayout C() {
        return new XLoadMoreLayout(getContext());
    }

    public LoadingMoreHelper D() {
        return this.N;
    }

    public RecyclerViewWithHeaderFooterFix E() {
        return this.M;
    }

    public void F(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(XRecyclerView.TAG, 2, "loadMoreComplete(): hasMoreData=" + z17);
        }
        this.N.setLoadMoreComplete(z16, z17);
    }

    public void G(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(XRecyclerView.TAG, 2, "loadMoreEnabled(): enable=" + z16);
        }
        this.N.setLoadMoreEnabled(z16);
    }

    public void H(boolean z16) {
        this.S = z16;
    }

    public void I() {
        this.M.stopScroll();
        this.M.smoothScrollToPosition(0);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected void d(boolean z16) {
        this.M.mInterceptTouchEvent = z16;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected int e() {
        return this.I.getPullRefreshAreaHeight();
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected View f() {
        return null;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected View g() {
        View refreshView = this.I.getRefreshView(this);
        setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        refreshView.setId(R.id.qeo);
        return refreshView;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean k() {
        return this.R && !this.M.canScrollVertically(1);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean l() {
        if (this.Q) {
            return !this.M.canScrollVertically(-1);
        }
        return false;
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean z16) {
        c cVar = this.L;
        if (cVar == null) {
            return true;
        }
        cVar.J3(this, 0);
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onNotCompleteVisable(View view, int i3) {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.I.onPullRefreshing(i3, this.f373346e);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewCompleteVisable(View view) {
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.I.onPullRefreshing(100, this.f373346e);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public boolean onViewCompleteVisableAndReleased(View view) {
        boolean equals = Boolean.TRUE.equals(this.V.get());
        this.V.set(Boolean.FALSE);
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return true;
        }
        this.I.onPullRefreshComplete(equals);
        c cVar = this.L;
        if (cVar == null) {
            return true;
        }
        cVar.xe(this, equals);
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    public void s(boolean z16) {
        super.s(z16);
        IAnimManager iAnimManager = this.I;
        if (iAnimManager != null) {
            iAnimManager.showRefreshResult(z16, "");
        }
        c cVar = this.L;
        if (cVar != null) {
            cVar.endOfRefresh();
        }
    }

    public void setPullRefreshMode(int i3) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
        if (i3 == 0) {
            layoutParams.addRule(3, 0);
            this.M.setLayoutParams(layoutParams);
        } else {
            if (i3 != 1) {
                return;
            }
            layoutParams.addRule(3, R.id.qeo);
            this.M.setLayoutParams(layoutParams);
        }
    }

    public void setRefreshCallback(c cVar) {
        this.L = cVar;
    }

    public void setRefreshEnable(boolean z16) {
        this.Q = z16;
    }

    public void setShouldReboundWhenBottom(boolean z16) {
        this.R = z16;
    }

    public XPullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = 0;
        this.U = 0;
        this.V = new a();
        i();
    }

    public XPullToRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = 0;
        this.Q = true;
        this.R = true;
        this.S = true;
        this.T = 0;
        this.U = 0;
        this.V = new a();
        i();
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewNotCompleteVisableAndReleased(View view) {
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onRefreshCompleted(View view, boolean z16) {
    }
}
