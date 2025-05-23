package com.tencent.biz.pubaccount.weishi.view.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.AbsPullToRefreshView2;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.PullToRefreshListener;
import com.tencent.widget.pull2refresh.XLoadMoreLayout;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class XRecyclerView extends AbsPullToRefreshView2 implements PullToRefreshListener, LoadingMoreHelper.OnLoadMoreListener {
    private int C;
    private boolean D;
    private boolean E;
    private ThreadLocal<Boolean> F;

    /* renamed from: d, reason: collision with root package name */
    private c f82479d;

    /* renamed from: e, reason: collision with root package name */
    protected RecyclerViewWithHeaderFooter f82480e;

    /* renamed from: f, reason: collision with root package name */
    private LoadingMoreHelper f82481f;

    /* renamed from: h, reason: collision with root package name */
    private XLoadMoreLayout f82482h;

    /* renamed from: i, reason: collision with root package name */
    private int f82483i;

    /* renamed from: m, reason: collision with root package name */
    private int f82484m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
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
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && XRecyclerView.this.f82483i == 2) {
                XRecyclerView.this.rebound();
            }
            int childCount = recyclerView.getChildCount();
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int itemCount = staggeredGridLayoutManager.getItemCount();
                int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
                int proLoaderCount = XRecyclerView.this.f82481f.getProLoaderCount();
                boolean z16 = itemCount - childCount <= findFirstVisibleItemPositions[0] + proLoaderCount;
                if (QLog.isColorLevel()) {
                    QLog.d(com.tencent.widget.pull2refresh.XRecyclerView.TAG, 2, "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(itemCount), Integer.valueOf(findFirstVisibleItemPositions[0]), Integer.valueOf(proLoaderCount), Boolean.valueOf(z16));
                }
                if (z16) {
                    XRecyclerView.this.f82481f.setLoadMore(true);
                }
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getItemCount() - childCount <= linearLayoutManager.findFirstVisibleItemPosition() + XRecyclerView.this.f82481f.getProLoaderCount()) {
                    XRecyclerView.this.f82481f.setLoadMore(true);
                }
            }
            XRecyclerView.this.f82483i = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            XRecyclerView.this.f82484m += i3;
            XRecyclerView.this.C += i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(XRecyclerView xRecyclerView, boolean z16);

        void b(XRecyclerView xRecyclerView, int i3);

        void endOfRefresh();
    }

    public XRecyclerView(Context context) {
        super(context);
        this.f82483i = 0;
        this.f82484m = 0;
        this.C = 0;
        this.D = true;
        this.F = new a();
        init();
    }

    private void init() {
        setPullToRefreshListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.f167389d22, (ViewGroup) this, true);
        this.f82482h = new XLoadMoreLayout(getContext());
        this.f82480e = (RecyclerViewWithHeaderFooter) findViewById(R.id.p5h);
        LoadingMoreHelper loadingMoreHelper = new LoadingMoreHelper(this.f82482h, getContext());
        this.f82481f = loadingMoreHelper;
        loadingMoreHelper.setLoadMoreEnabled(true);
        this.f82481f.setOnLoadMoreListener(this);
        this.f82480e.E(this.f82482h);
        this.f82480e.addOnScrollListener(new b());
    }

    public void backToTopAtOnce() {
        this.f82480e.stopScroll();
        this.f82480e.scrollToPosition(0);
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected void clearContentViewClickEvent(boolean z16) {
        this.f82480e.f82477i = z16;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected int configHeaderVisibleHeight() {
        return this.mAnimManager.getPullRefreshAreaHeight();
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected View generateFooterView() {
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected View generateHeaderView() {
        View refreshView = this.mAnimManager.getRefreshView(this);
        if (this.mAnimManager.isSkinAnimManager()) {
            setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
        } else {
            setPullHeaderBgDrawable(getResources().getDrawable(R.drawable.common_list_overscoll_top_bg));
        }
        return refreshView;
    }

    public LoadingMoreHelper getLoadMoreLayoutHelper() {
        return this.f82481f;
    }

    public RecyclerViewWithHeaderFooter h() {
        return this.f82480e;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected boolean isScroll2Bottom() {
        return !this.f82480e.canScrollVertically(1);
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected boolean isScroll2Top() {
        if (this.D) {
            return !this.f82480e.canScrollVertically(-1);
        }
        return false;
    }

    public void loadMoreComplete(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(com.tencent.widget.pull2refresh.XRecyclerView.TAG, 2, "loadMoreComplete(): hasMoreData=" + z17);
        }
        this.f82481f.setLoadMoreComplete(z16, z17);
        this.f82481f.setLoadMoreEnabled(z17);
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean z16) {
        c cVar = this.f82479d;
        if (cVar == null) {
            return true;
        }
        cVar.b(this, 0);
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onNotCompleteVisable(View view, int i3) {
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.mAnimManager.onPullRefreshing(i3, this.isRefreshing);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewCompleteVisable(View view) {
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return;
        }
        this.mAnimManager.onPullRefreshing(100, this.isRefreshing);
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public boolean onViewCompleteVisableAndReleased(View view) {
        boolean booleanValue = this.F.get().booleanValue();
        this.F.set(Boolean.FALSE);
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager == null || view != iAnimManager.getRefreshView(this)) {
            return true;
        }
        this.mAnimManager.onPullRefreshComplete(booleanValue);
        c cVar = this.f82479d;
        if (cVar == null) {
            return true;
        }
        cVar.a(this, booleanValue);
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void pullRefreshCompleted(boolean z16) {
        super.pullRefreshCompleted(z16);
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null) {
            iAnimManager.showRefreshResult(z16, "");
        }
        c cVar = this.f82479d;
        if (cVar != null) {
            cVar.endOfRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void rebound() {
        x.j(com.tencent.widget.pull2refresh.XRecyclerView.TAG, "[WSXRecyclerView.java][rebound] mAutoScroller:" + this.E);
        if (this.E) {
            return;
        }
        super.rebound();
    }

    public void setIsAutoScrolling(boolean z16) {
        this.E = z16;
    }

    public void setRefreshCallback(c cVar) {
        this.f82479d = cVar;
    }

    public void setRefreshEnable(boolean z16) {
        this.D = z16;
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82483i = 0;
        this.f82484m = 0;
        this.C = 0;
        this.D = true;
        this.F = new a();
        init();
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82483i = 0;
        this.f82484m = 0;
        this.C = 0;
        this.D = true;
        this.F = new a();
        init();
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
