package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.anim.IAnimManager;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XRecyclerView extends AbsPullToRefreshView2 implements PullToRefreshListener, LoadingMoreHelper.OnLoadMoreListener {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "XRecyclerView";
    private ThreadLocal<Boolean> mIsMachineRefresh;
    private int mLastScrollState;
    private XLoadMoreLayout mLoadMoreLayout;
    private LoadingMoreHelper mLoadMoreLayoutHelper;
    protected RecyclerViewWithHeaderFooter mRecyclerView;
    private RefreshCallback mRefreshCallback;
    private int mScrollX;
    private int mScrollY;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface RefreshCallback {
        void endOfRefresh();

        void startLoadMore(XRecyclerView xRecyclerView, int i3);

        void startTopRefresh(XRecyclerView xRecyclerView, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends ThreadLocal<Boolean> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XRecyclerView.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) XRecyclerView.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
                return;
            }
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0 && XRecyclerView.this.mLastScrollState == 2) {
                XRecyclerView.this.rebound();
            }
            int childCount = recyclerView.getChildCount();
            boolean z17 = false;
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                int itemCount = staggeredGridLayoutManager.getItemCount();
                int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
                int proLoaderCount = XRecyclerView.this.mLoadMoreLayoutHelper.getProLoaderCount();
                if (itemCount - childCount <= findFirstVisibleItemPositions[0] + proLoaderCount) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(XRecyclerView.TAG, 2, "totalItemCount=%d, firstVisibleItem=%d, visibleThreshold=%d, isCloseToTheEnd=%b", Integer.valueOf(itemCount), Integer.valueOf(findFirstVisibleItemPositions[0]), Integer.valueOf(proLoaderCount), Boolean.valueOf(z16));
                }
                if (z16) {
                    XRecyclerView.this.mLoadMoreLayoutHelper.setLoadMore(true);
                }
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager.getItemCount() - childCount <= linearLayoutManager.findFirstVisibleItemPosition() + XRecyclerView.this.mLoadMoreLayoutHelper.getProLoaderCount()) {
                    z17 = true;
                }
                if (z17) {
                    XRecyclerView.this.mLoadMoreLayoutHelper.setLoadMore(true);
                }
            }
            XRecyclerView.this.mLastScrollState = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            super.onScrolled(recyclerView, i3, i16);
            XRecyclerView.this.mScrollX += i3;
            XRecyclerView.this.mScrollY += i16;
        }
    }

    public XRecyclerView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mLastScrollState = 0;
        this.mScrollX = 0;
        this.mScrollY = 0;
        this.mIsMachineRefresh = new a();
        init();
    }

    private void init() {
        setPullToRefreshListener(this);
        LayoutInflater.from(getContext()).inflate(R.layout.c4g, (ViewGroup) this, true);
        this.mLoadMoreLayout = new XLoadMoreLayout(getContext());
        this.mRecyclerView = (RecyclerViewWithHeaderFooter) findViewById(R.id.gsc);
        LoadingMoreHelper loadingMoreHelper = new LoadingMoreHelper(this.mLoadMoreLayout, getContext());
        this.mLoadMoreLayoutHelper = loadingMoreHelper;
        loadingMoreHelper.setLoadMoreEnabled(true);
        this.mLoadMoreLayoutHelper.setOnLoadMoreListener(this);
        this.mRecyclerView.addFooterView(this.mLoadMoreLayout);
        this.mRecyclerView.addOnScrollListener(new b());
    }

    public void backToTopAtOnce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mRecyclerView.stopScroll();
            this.mRecyclerView.scrollToPosition(0);
        }
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected void clearContentViewClickEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.mRecyclerView.mInterceptTouchEvent = z16;
        }
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected int configHeaderVisibleHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mAnimManager.getPullRefreshAreaHeight();
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected View generateFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    protected View generateHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        View refreshView = this.mAnimManager.getRefreshView(this);
        if (this.mAnimManager.isSkinAnimManager()) {
            setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
        } else {
            setPullHeaderBgDrawable(getResources().getDrawable(R.drawable.common_list_overscoll_top_bg));
        }
        return refreshView;
    }

    public LoadingMoreHelper getLoadMoreLayoutHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LoadingMoreHelper) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mLoadMoreLayoutHelper;
    }

    public RecyclerViewWithHeaderFooter getRecyclerView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (RecyclerViewWithHeaderFooter) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mRecyclerView;
    }

    public int getScrollPositionX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mScrollX;
    }

    public int getScrollPositionY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mScrollY;
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    @TargetApi(14)
    protected boolean isScroll2Bottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return !this.mRecyclerView.canScrollVertically(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    @TargetApi(14)
    public boolean isScroll2Top() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return !this.mRecyclerView.canScrollVertically(-1);
    }

    public void loadMoreComplete(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadMoreComplete(): hasMoreData=" + z17);
        }
        this.mLoadMoreLayoutHelper.setLoadMoreComplete(z16, z17);
        this.mLoadMoreLayoutHelper.setLoadMoreEnabled(z17);
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, z16)).booleanValue();
        }
        RefreshCallback refreshCallback = this.mRefreshCallback;
        if (refreshCallback != null) {
            refreshCallback.startLoadMore(this, 0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onNotCompleteVisable(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view, i3);
            return;
        }
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null && view == iAnimManager.getRefreshView(this)) {
            this.mAnimManager.onPullRefreshing(i3, this.isRefreshing);
        }
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onRefreshCompleted(View view, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, view, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewCompleteVisable(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null && view == iAnimManager.getRefreshView(this)) {
            this.mAnimManager.onPullRefreshing(100, this.isRefreshing);
        }
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public boolean onViewCompleteVisableAndReleased(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) view)).booleanValue();
        }
        boolean booleanValue = this.mIsMachineRefresh.get().booleanValue();
        this.mIsMachineRefresh.set(Boolean.FALSE);
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null && view == iAnimManager.getRefreshView(this)) {
            this.mAnimManager.onPullRefreshComplete(booleanValue);
            RefreshCallback refreshCallback = this.mRefreshCallback;
            if (refreshCallback != null) {
                refreshCallback.startTopRefresh(this, booleanValue);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.widget.pull2refresh.PullToRefreshListener
    public void onViewNotCompleteVisableAndReleased(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
        }
    }

    @Override // com.tencent.widget.pull2refresh.AbsPullToRefreshView2
    public void pullRefreshCompleted(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        super.pullRefreshCompleted(z16);
        IAnimManager iAnimManager = this.mAnimManager;
        if (iAnimManager != null) {
            iAnimManager.showRefreshResult(z16, "");
        }
        RefreshCallback refreshCallback = this.mRefreshCallback;
        if (refreshCallback != null) {
            refreshCallback.endOfRefresh();
        }
    }

    public void scrollToTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.mRecyclerView.stopScroll();
            this.mRecyclerView.smoothScrollToPosition(0);
        }
    }

    public void setRefreshCallback(RefreshCallback refreshCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) refreshCallback);
        } else {
            this.mRefreshCallback = refreshCallback;
        }
    }

    public void startMachineRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.mIsMachineRefresh.set(Boolean.TRUE);
            changeToState(1);
        }
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mLastScrollState = 0;
        this.mScrollX = 0;
        this.mScrollY = 0;
        this.mIsMachineRefresh = new a();
        init();
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mLastScrollState = 0;
        this.mScrollX = 0;
        this.mScrollY = 0;
        this.mIsMachineRefresh = new a();
        init();
    }
}
