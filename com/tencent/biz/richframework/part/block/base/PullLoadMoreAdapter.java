package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class PullLoadMoreAdapter<E> extends BaseListViewAdapter<E> implements IRefreshViewProvider.OnRefreshListener {
    public static int GRID_PRELOAD_SCROLL_COUNT = 16;
    public static int LINEAR_GRID_PRELOAD_SCROLL_COUNT = 15;
    public static int LINEAR_PRELOAD_SCROLL_COUNT = 8;
    private View mCustomNoMoreDataView;
    protected String mEmptyHint;
    protected String mErrorHint;
    private boolean mIsLoading;
    private boolean mIsShow;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String mLoadingHint;
    protected String mNoNetWorkHint;
    protected RecyclerView mRecyclerView;
    private IRefreshViewProvider mRefreshViewProvider;
    protected final Handler mUIHandler = new Handler(Looper.getMainLooper());
    private int mStaggeredRemainCountToTriggerPreload = -1;
    private boolean mIsFinish = false;
    protected String mNoMoreHint;
    protected String mLoadText = this.mNoMoreHint;
    private boolean mEnableRefresh = false;
    private boolean mEnableLoadMore = true;
    private boolean mShowHint = true;
    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            if (i16 > 0) {
                PullLoadMoreAdapter.this.scrollToLoadMore();
            }
        }
    };

    /* loaded from: classes5.dex */
    public static class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mContainer;
        public final FrameLayout mCustomViewWrapper;
        public TextView mProgressInfo;
        public ProgressBar mProgressbar;

        public LoadMoreViewHolder(View view) {
            super(view);
            this.mProgressbar = (ProgressBar) view.findViewById(R.id.lz7);
            this.mContainer = (LinearLayout) view.findViewById(R.id.f165997lp1);
            this.mProgressInfo = (TextView) view.findViewById(R.id.kbr);
            this.mCustomViewWrapper = (FrameLayout) view.findViewById(R.id.v7r);
        }
    }

    /* loaded from: classes5.dex */
    public static class RefreshViewHolder extends RecyclerView.ViewHolder {
        public RefreshViewHolder(View view) {
            super(view);
        }
    }

    private void handleLinearCanLoadMore(LinearLayoutManager linearLayoutManager) {
        int itemCount = linearLayoutManager.getItemCount() - linearLayoutManager.findLastVisibleItemPosition();
        if ((linearLayoutManager instanceof GridLayoutManager) && itemCount < LINEAR_GRID_PRELOAD_SCROLL_COUNT) {
            triggerToLoadMore();
        } else if (itemCount < getLinearPreloadCount()) {
            triggerToLoadMore();
        }
    }

    private void initDefaultHint(Context context) {
        this.mEmptyHint = context.getResources().getString(R.string.f221466aw);
        this.mErrorHint = context.getResources().getString(R.string.f221446au);
        this.mNoNetWorkHint = context.getResources().getString(R.string.f221446au);
        this.mNoMoreHint = context.getResources().getString(R.string.f221476ax);
        this.mLoadingHint = context.getResources().getString(R.string.f221456av);
    }

    protected abstract RecyclerView.ViewHolder createItemViewHolder(ViewGroup viewGroup, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public RecyclerView.ViewHolder createProgressViewHolder(ViewGroup viewGroup, int i3) {
        LoadMoreViewHolder loadMoreViewHolder = new LoadMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(getProgressLayoutId(), viewGroup, false));
        View view = this.mCustomNoMoreDataView;
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.mCustomNoMoreDataView.getParent()).removeView(this.mCustomNoMoreDataView);
            }
            loadMoreViewHolder.mCustomViewWrapper.addView(this.mCustomNoMoreDataView);
        }
        return loadMoreViewHolder;
    }

    protected RecyclerView.ViewHolder createRefreshViewHolder(ViewGroup viewGroup, int i3) {
        IRefreshViewProvider iRefreshViewProvider = this.mRefreshViewProvider;
        if (iRefreshViewProvider != null) {
            if (iRefreshViewProvider.getRefreshView() != null) {
                this.mRefreshViewProvider.setOnRefreshListener(this);
                return new RefreshViewHolder(this.mRefreshViewProvider.getRefreshView());
            }
            throw new RuntimeException("createRefreshViewHolder mRefreshViewProvider getRefreshView can't be null");
        }
        throw new RuntimeException("createRefreshViewHolder mRefreshViewProvider can't be null");
    }

    public int getExtraCount() {
        boolean z16 = this.mEnableRefresh;
        if (this.mEnableLoadMore) {
            return (z16 ? 1 : 0) + 1;
        }
        return z16 ? 1 : 0;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public E getItem(int i3) {
        List<E> list = this.mDataList;
        if (list != null && list.size() > getRealPosition(i3)) {
            return this.mDataList.get(getRealPosition(i3));
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mDataList.size() + getExtraCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.mEnableRefresh && i3 == 0) {
            return -10000;
        }
        if (getRealPosition(i3) < this.mDataList.size()) {
            return 0;
        }
        return -99999;
    }

    protected int getLinearPreloadCount() {
        return LINEAR_PRELOAD_SCROLL_COUNT;
    }

    protected int getProgressLayoutId() {
        return R.layout.f169066hn3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRealPosition(int i3) {
        if (this.mEnableRefresh) {
            return i3 - 1;
        }
        return i3;
    }

    public String getRefreshUpdateTips() {
        return null;
    }

    public IRefreshViewProvider getRefreshViewProvider() {
        return this.mRefreshViewProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getStaggeredRemainCountToTriggerPreload(int i3) {
        int i16 = this.mStaggeredRemainCountToTriggerPreload;
        if (i16 != -1) {
            return i16;
        }
        return i3 * 3;
    }

    protected int getTriggerShowMinCount() {
        return 1;
    }

    public boolean isEnableLoadMore() {
        return this.mEnableLoadMore;
    }

    public boolean isEnableRefresh() {
        return this.mEnableRefresh;
    }

    public boolean isFinish() {
        return this.mIsFinish;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public boolean isRefreshing() {
        IRefreshViewProvider iRefreshViewProvider = this.mRefreshViewProvider;
        if (iRefreshViewProvider != null) {
            return iRefreshViewProvider.getIsRefreshing();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = recyclerView.getLayoutManager();
        this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        initDefaultHint(recyclerView.getContext());
    }

    protected void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof RefreshViewHolder) {
            KeyEvent.Callback callback = ((RefreshViewHolder) viewHolder).itemView;
            if (callback instanceof IRefreshViewProvider) {
                IRefreshViewProvider iRefreshViewProvider = (IRefreshViewProvider) callback;
                this.mRefreshViewProvider = iRefreshViewProvider;
                iRefreshViewProvider.setOnRefreshListener(this);
            }
        }
    }

    protected abstract void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onBindProgressViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        boolean z16;
        int i16;
        FrameLayout frameLayout;
        if (viewHolder instanceof LoadMoreViewHolder) {
            LoadMoreViewHolder loadMoreViewHolder = (LoadMoreViewHolder) viewHolder;
            if (!this.mIsShow) {
                loadMoreViewHolder.mContainer.setVisibility(8);
                if (this.mCustomNoMoreDataView != null) {
                    loadMoreViewHolder.mCustomViewWrapper.setVisibility(8);
                }
                RFWLog.i("PullLoadMoreAdapter", RFWLog.USR, "onBindProgressViewHolder hideLoadingFooter");
                return;
            }
            if (this.mIsLoading && getNUM_BACKGOURND_ICON() > getTriggerShowMinCount()) {
                z16 = true;
            } else {
                z16 = false;
            }
            loadMoreViewHolder.mProgressbar.setIndeterminate(z16);
            ProgressBar progressBar = loadMoreViewHolder.mProgressbar;
            if (z16) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            progressBar.setVisibility(i16);
            if (this.mCustomNoMoreDataView != null && loadMoreViewHolder.mCustomViewWrapper != null && this.mIsFinish) {
                loadMoreViewHolder.mContainer.setVisibility(8);
                loadMoreViewHolder.mCustomViewWrapper.setVisibility(0);
                RFWLog.i("PullLoadMoreAdapter", RFWLog.USR, "onBindProgressViewHolder show CustomNoMoreDataView");
                return;
            }
            loadMoreViewHolder.mContainer.setVisibility(0);
            loadMoreViewHolder.mProgressInfo.setText(this.mLoadText);
            if (this.mCustomNoMoreDataView != null && (frameLayout = loadMoreViewHolder.mCustomViewWrapper) != null) {
                frameLayout.setVisibility(8);
            }
            RFWLog.i("PullLoadMoreAdapter", RFWLog.USR, "onBindProgressViewHolder show progress text:" + this.mLoadText);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder != null && i3 < getNUM_BACKGOURND_ICON()) {
            int itemViewType = getItemViewType(i3);
            if (-10000 == itemViewType) {
                onBindHeaderViewHolder(viewHolder);
            } else if (-99999 == itemViewType) {
                onBindProgressViewHolder(viewHolder, i3);
            } else {
                onBindItemViewHolder(viewHolder, getRealPosition(i3));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == -99999) {
            return createProgressViewHolder(viewGroup, i3);
        }
        if (i3 == -10000) {
            return createRefreshViewHolder(viewGroup, i3);
        }
        RecyclerView.ViewHolder createItemViewHolder = createItemViewHolder(viewGroup, i3);
        if (createItemViewHolder != null) {
            View view = createItemViewHolder.itemView;
            if (view instanceof BaseWidgetView) {
                ((BaseWidgetView) view).setParentView(viewGroup);
            }
        }
        return createItemViewHolder;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        IRefreshViewProvider iRefreshViewProvider = this.mRefreshViewProvider;
        if (iRefreshViewProvider != null) {
            iRefreshViewProvider.onDestroy();
        }
        recyclerView.removeOnScrollListener(this.mOnScrollListener);
        this.mUIHandler.removeCallbacksAndMessages(null);
    }

    public void onLoadMoreCompleted(boolean z16, boolean z17) {
        onLoadMoreCompleted(z16, z17, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadingStart() {
        this.mIsLoading = true;
        this.mLoadText = this.mLoadingHint;
        this.mIsShow = true;
        notifyItemChanged(getNUM_BACKGOURND_ICON() - 1);
    }

    public void onRefreshWithAnim() {
        RecyclerView recyclerView;
        IRefreshViewProvider iRefreshViewProvider;
        if (!isRefreshing() && (recyclerView = this.mRecyclerView) != null && (iRefreshViewProvider = this.mRefreshViewProvider) != null) {
            iRefreshViewProvider.callRefresh(recyclerView);
        }
    }

    protected void scrollToLoadMore() {
        try {
            if (this.mLayoutManager == null) {
                this.mLayoutManager = this.mRecyclerView.getLayoutManager();
            }
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            if (layoutManager instanceof LinearLayoutManager) {
                handleLinearCanLoadMore((LinearLayoutManager) layoutManager);
                return;
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
                if (columnCountForAccessibility == 1) {
                    int[] iArr = new int[1];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                    if (iArr[0] >= staggeredGridLayoutManager.getItemCount() - GRID_PRELOAD_SCROLL_COUNT) {
                        triggerToLoadMore();
                        return;
                    }
                    return;
                }
                int[] iArr2 = new int[columnCountForAccessibility];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
                int i3 = iArr2[columnCountForAccessibility - 1];
                if (columnCountForAccessibility == 2) {
                    i3 = Math.max(iArr2[1], iArr2[0]);
                }
                if (i3 >= (staggeredGridLayoutManager.getItemCount() - getExtraCount()) - getStaggeredRemainCountToTriggerPreload(columnCountForAccessibility)) {
                    triggerToLoadMore();
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setCustomNoMoreDataView(View view) {
        this.mCustomNoMoreDataView = view;
    }

    public void setEnableLoadMore(boolean z16) {
        this.mEnableLoadMore = z16;
    }

    public void setEnableRefresh(boolean z16) {
        this.mEnableRefresh = z16;
    }

    public void setNoMoreHint(String str) {
        this.mNoMoreHint = str;
    }

    public void setRefreshViewProvider(IRefreshViewProvider iRefreshViewProvider) {
        this.mRefreshViewProvider = iRefreshViewProvider;
    }

    public void setRefreshing(boolean z16) {
        if (this.mRefreshViewProvider != null) {
            this.mIsLoading = isRefreshing();
            this.mRefreshViewProvider.setRefreshing(z16);
        }
    }

    public void setStaggeredRemainCountToTriggerPreload(int i3) {
        this.mStaggeredRemainCountToTriggerPreload = i3;
    }

    public void showHint(boolean z16) {
        this.mShowHint = z16;
    }

    protected abstract void triggerToLoadMore();

    public void updateLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }

    public void onLoadMoreCompleted(boolean z16, boolean z17, boolean z18) {
        if (isEnableLoadMore()) {
            boolean z19 = false;
            this.mIsLoading = false;
            this.mIsFinish = z17;
            String str = z17 ? this.mNoMoreHint : "";
            this.mLoadText = str;
            if (!TextUtils.isEmpty(str) || (z17 && this.mCustomNoMoreDataView != null)) {
                z19 = true;
            }
            this.mIsShow = z19;
            if (!z16) {
                this.mLoadText = RFWNetworkUtils.isNetworkAvailable(RFWApplication.getApplication()) ^ true ? this.mNoNetWorkHint : this.mErrorHint;
                this.mIsShow = this.mShowHint;
            }
            if (z18) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PullLoadMoreAdapter.this.notifyDataSetChanged();
                    }
                });
            }
            RFWLog.i("PullLoadMoreAdapter", RFWLog.USR, "onLoadMoreCompleted: hashCode:" + hashCode() + " ,isSuccess:" + z16 + ", isFinish:" + z17 + " , isShow:" + this.mIsShow + " , notifyChanged:" + z18);
        }
    }

    public void onRefresh() {
    }
}
