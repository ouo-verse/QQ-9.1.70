package com.tencent.sqshow.zootopia.view.pull2refresh.androidx;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* loaded from: classes34.dex */
public class XPullToRefreshViewV2 extends AbsPullToRefreshView implements PullToRefreshListener, LoadingMoreHelper.OnLoadMoreListener {
    private c L;
    protected RecyclerViewXWithHeaderFooter M;
    private LoadingMoreHelper N;
    protected ILoadMoreLayout P;
    private int Q;
    private boolean R;
    private int S;
    private int T;
    private ThreadLocal<Boolean> U;

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

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            boolean z16;
            super.onScrollStateChanged(recyclerView, i3);
            int childCount = recyclerView.getChildCount();
            boolean z17 = true;
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int itemCount = staggeredGridLayoutManager.getItemCount();
                int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
                int proLoaderCount = XPullToRefreshViewV2.this.N.getProLoaderCount();
                boolean z18 = itemCount - childCount <= findFirstVisibleItemPositions[0] + proLoaderCount;
                if (QLog.isColorLevel()) {
                    QLog.d("XRecyclerViewV2", 2, "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(itemCount), Integer.valueOf(findFirstVisibleItemPositions[0]), Integer.valueOf(proLoaderCount), Boolean.valueOf(z18));
                }
                if (z18) {
                    XPullToRefreshViewV2.this.N.setLoadMore(true);
                    z16 = true;
                }
                z16 = false;
            } else {
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager.getItemCount() - childCount <= linearLayoutManager.findFirstVisibleItemPosition() + XPullToRefreshViewV2.this.N.getProLoaderCount()) {
                        XPullToRefreshViewV2.this.N.setLoadMore(true);
                        z16 = true;
                    }
                }
                z16 = false;
            }
            int state = XPullToRefreshViewV2.this.P.getState();
            if (z16 && state != 4 && state != 5) {
                z17 = false;
            }
            if (i3 == 0 && XPullToRefreshViewV2.this.Q == 2 && z17) {
                XPullToRefreshViewV2.this.t();
            }
            XPullToRefreshViewV2.this.Q = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            XPullToRefreshViewV2.w(XPullToRefreshViewV2.this, i3);
            XPullToRefreshViewV2.x(XPullToRefreshViewV2.this, i16);
        }
    }

    /* loaded from: classes34.dex */
    public interface c {
        void b(XPullToRefreshViewV2 xPullToRefreshViewV2, int i3);

        void e(XPullToRefreshViewV2 xPullToRefreshViewV2, boolean z16);

        void endOfRefresh();
    }

    public XPullToRefreshViewV2(Context context) {
        super(context);
        this.Q = 0;
        this.R = true;
        this.S = 0;
        this.T = 0;
        this.U = new a();
        i();
    }

    private void i() {
        u(this);
        RecyclerViewXWithHeaderFooter recyclerViewXWithHeaderFooter = new RecyclerViewXWithHeaderFooter(getContext());
        this.M = recyclerViewXWithHeaderFooter;
        recyclerViewXWithHeaderFooter.setVerticalFadingEdgeEnabled(false);
        this.M.setHorizontalFadingEdgeEnabled(false);
        this.M.setOverScrollMode(2);
        this.M.setId(R.id.qey);
        addView(this.M, new RelativeLayout.LayoutParams(-1, -1));
        ILoadMoreLayout C = C();
        this.P = C;
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = new com.tencent.sqshow.zootopia.view.pull2refresh.a(C, getContext());
        this.N = aVar;
        aVar.setLoadMoreEnabled(true);
        this.N.setOnLoadMoreListener(this);
        this.M.E((View) this.P);
        this.M.addOnScrollListener(new b());
        a(this.f373347f);
    }

    static /* synthetic */ int w(XPullToRefreshViewV2 xPullToRefreshViewV2, int i3) {
        int i16 = xPullToRefreshViewV2.S + i3;
        xPullToRefreshViewV2.S = i16;
        return i16;
    }

    static /* synthetic */ int x(XPullToRefreshViewV2 xPullToRefreshViewV2, int i3) {
        int i16 = xPullToRefreshViewV2.T + i3;
        xPullToRefreshViewV2.T = i16;
        return i16;
    }

    protected ILoadMoreLayout C() {
        return new XLoadMoreLayout(getContext());
    }

    public LoadingMoreHelper D() {
        return this.N;
    }

    public RecyclerViewXWithHeaderFooter E() {
        return this.M;
    }

    public void F(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("XRecyclerViewV2", 2, "loadMoreComplete(): hasMoreData=" + z17);
        }
        this.N.setLoadMoreComplete(z16, z17);
    }

    public void G(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("XRecyclerViewV2", 2, "loadMoreEnabled(): enable=" + z16);
        }
        this.N.setLoadMoreEnabled(z16);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected void d(boolean z16) {
        this.M.E = z16;
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
        setPullHeaderBgDrawable(new ColorDrawable(getResources().getColor(R.color.qui_common_bg_middle_light)));
        refreshView.setId(R.id.qeo);
        return refreshView;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean k() {
        return !this.M.canScrollVertically(1);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected boolean l() {
        if (this.R) {
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
        cVar.b(this, 0);
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
        boolean booleanValue = this.U.get().booleanValue();
        this.U.set(Boolean.FALSE);
        IAnimManager iAnimManager = this.I;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return true;
        }
        this.I.onPullRefreshComplete(booleanValue);
        c cVar = this.L;
        if (cVar == null) {
            return true;
        }
        cVar.e(this, booleanValue);
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
        this.R = z16;
    }

    public XPullToRefreshViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Q = 0;
        this.R = true;
        this.S = 0;
        this.T = 0;
        this.U = new a();
        i();
    }

    public XPullToRefreshViewV2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = 0;
        this.R = true;
        this.S = 0;
        this.T = 0;
        this.U = new a();
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
