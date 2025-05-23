package com.tencent.biz.richframework.preload.recyclerview;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWAbsLoadMoreAdapter extends VisibleNotifyAdapter implements ILoadMoreProvider$LoadMoreListener {
    public static final boolean DEBUG = false;
    private static final String TAG = "RFWAbsLoadMoreAdapter";
    private static final int UNKNOWN_ORIENTATION = Integer.MIN_VALUE;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RecyclerView.ViewHolder mLoadMoreViewHolder;
    protected InnerOnGlobalLayoutListener mOnGlobalLayoutListener;
    private boolean mHasMore = true;
    private boolean mIsLoading = false;
    private final Set<ILoadMoreProvider$LoadMoreListener> mLoadMoreListeners = new HashSet();
    protected LoadMoreStrategy mLoadMoreStrategy = new RFWCountLoadMoreStrategy(false, true);
    private int mMaxAutoTriggerLoadTimes = 0;
    private int mHasTriggerLoadMoreTimes = 0;
    private final InnerOnScrollListener mOnScrollListener = new InnerOnScrollListener(this);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class InnerOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final WeakReference<RFWAbsLoadMoreAdapter> mWrfAdapter;

        public InnerOnGlobalLayoutListener(RFWAbsLoadMoreAdapter rFWAbsLoadMoreAdapter) {
            this.mWrfAdapter = new WeakReference<>(rFWAbsLoadMoreAdapter);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RFWAbsLoadMoreAdapter rFWAbsLoadMoreAdapter = this.mWrfAdapter.get();
            if (rFWAbsLoadMoreAdapter != null) {
                rFWAbsLoadMoreAdapter.tryToLoadMoreIfIsNotFull();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class InnerOnScrollListener extends RecyclerView.OnScrollListener {
        private final WeakReference<RFWAbsLoadMoreAdapter> mWrfAdapter;

        public InnerOnScrollListener(RFWAbsLoadMoreAdapter rFWAbsLoadMoreAdapter) {
            this.mWrfAdapter = new WeakReference<>(rFWAbsLoadMoreAdapter);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            super.onScrolled(recyclerView, i3, i16);
            RFWAbsLoadMoreAdapter rFWAbsLoadMoreAdapter = this.mWrfAdapter.get();
            if (rFWAbsLoadMoreAdapter != null) {
                rFWAbsLoadMoreAdapter.handleLoadMore(i3, i16);
            }
        }
    }

    private boolean checkIsValidRetry() {
        int i3 = this.mMaxAutoTriggerLoadTimes;
        if (i3 > 0 && this.mHasTriggerLoadMoreTimes < i3) {
            return true;
        }
        return false;
    }

    private void dispatchLoadEnd(boolean z16) {
        if (this.mLoadMoreViewHolder != null) {
            onLoadMoreEnd(z16);
        }
        Iterator<ILoadMoreProvider$LoadMoreListener> it = this.mLoadMoreListeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadMoreEnd(z16);
        }
    }

    private void dispatchLoadStart() {
        if (this.mLoadMoreViewHolder != null) {
            onLoadMoreStart();
        }
        Iterator<ILoadMoreProvider$LoadMoreListener> it = this.mLoadMoreListeners.iterator();
        while (it.hasNext()) {
            it.next().onLoadMoreStart();
        }
    }

    private int getOrientation() {
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        RFWLog.fatal(TAG, RFWLog.USR, new UnsupportedOperationException("LayoutManager \u4e0d\u662fLinearLayoutManager\u6216StaggeredGridLayoutManager\u5b50\u7c7b"));
        return Integer.MIN_VALUE;
    }

    private ViewTreeObserver getRootViewTreeObserver(RecyclerView recyclerView) {
        if (recyclerView.getContext() instanceof Activity) {
            Activity activity = (Activity) recyclerView.getContext();
            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                return activity.getWindow().getDecorView().getViewTreeObserver();
            }
        }
        return recyclerView.getViewTreeObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadMore(int i3, int i16) {
        int orientation = getOrientation();
        if (orientation == Integer.MIN_VALUE) {
            return;
        }
        startLoadMore(i3, i16, orientation);
    }

    private void registerScrollListenerOrNot(boolean z16, RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        if (z16) {
            recyclerView.removeOnScrollListener(this.mOnScrollListener);
            recyclerView.addOnScrollListener(this.mOnScrollListener);
        } else {
            recyclerView.removeOnScrollListener(this.mOnScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewParent] */
    public void traverseRecyclerViewParent(boolean z16) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        for (RecyclerView recyclerView2 = recyclerView.getParent(); recyclerView2 != null; recyclerView2 = recyclerView2.getParent()) {
            if (recyclerView2 instanceof RecyclerView) {
                registerScrollListenerOrNot(z16, recyclerView2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToLoadMoreIfIsNotFull() {
        logDebug(" tryToLoadMoreIfIsNotFull");
        if (!this.mIsLoading && this.mHasMore) {
            if (!checkIsValidRetry()) {
                logDebug("isInvalidRetry: count:" + this.mHasTriggerLoadMoreTimes + " max:" + this.mMaxAutoTriggerLoadTimes);
                return;
            }
            int findLastCompletelyVisibleItemPositions = RFWLayoutManagerUtil.findLastCompletelyVisibleItemPositions(this.mRecyclerView);
            if (findLastCompletelyVisibleItemPositions == -1) {
                logDebug("find last position is error");
                return;
            }
            RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter == null) {
                logDebug("adapter is empty");
                return;
            }
            if (getItemCount() == adapter.getItemCount()) {
                logDebug("only the loadMore adapter is visible return");
                return;
            }
            if (findLastCompletelyVisibleItemPositions < adapter.getItemCount() - 1) {
                logDebug("lastPosition: " + findLastCompletelyVisibleItemPositions + " adapter.getItemCount():" + adapter.getItemCount());
                return;
            }
            this.mHasTriggerLoadMoreTimes++;
            this.mIsLoading = true;
            logDebug("dispatchLoadStart:" + this.mHasTriggerLoadMoreTimes);
            dispatchLoadStart();
            return;
        }
        logDebug("mIsLoading:" + this.mIsLoading + " hasMore:" + this.mHasMore);
    }

    public boolean canLoadMore() {
        return this.mHasMore;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public boolean isLoadingMore() {
        return this.mIsLoading;
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter
    public void onAdapterDestroyed(RecyclerView recyclerView) {
        super.onAdapterDestroyed(recyclerView);
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.mOnScrollListener);
            getRootViewTreeObserver(recyclerView).removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mLayoutManager = recyclerView.getLayoutManager();
        this.mOnGlobalLayoutListener = new InnerOnGlobalLayoutListener(this);
        recyclerView.addOnScrollListener(this.mOnScrollListener);
        recyclerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                RFWAbsLoadMoreAdapter.this.traverseRecyclerViewParent(true);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                RFWAbsLoadMoreAdapter.this.traverseRecyclerViewParent(false);
            }
        });
        getRootViewTreeObserver(recyclerView).addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (this.mIsLoading) {
            onLoadMoreStart();
        } else {
            onLoadMoreEnd(this.mHasMore);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        getRootViewTreeObserver(recyclerView).removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.mLoadMoreViewHolder = viewHolder;
    }

    public boolean registerLoadMoreListener(@NonNull ILoadMoreProvider$LoadMoreListener iLoadMoreProvider$LoadMoreListener) {
        return this.mLoadMoreListeners.add(iLoadMoreProvider$LoadMoreListener);
    }

    public void resetAutoLoadMoreTimes() {
        this.mHasTriggerLoadMoreTimes = 0;
    }

    public void scrollToLoadMore(boolean z16) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && recyclerView.getAdapter() != null) {
            if (z16) {
                this.mRecyclerView.smoothScrollToPosition(r3.getAdapter().getItemCount() - 1);
                return;
            }
            this.mRecyclerView.scrollToPosition(r3.getAdapter().getItemCount() - 1);
            int orientation = getOrientation();
            if (orientation != Integer.MIN_VALUE) {
                if (orientation == 0) {
                    startLoadMore(Integer.MAX_VALUE, 0, orientation);
                } else {
                    startLoadMore(0, Integer.MAX_VALUE, orientation);
                }
            }
        }
    }

    public void setLoadMoreStrategy(LoadMoreStrategy loadMoreStrategy) {
        this.mLoadMoreStrategy = loadMoreStrategy;
    }

    public void setLoadState(boolean z16, boolean z17) {
        if (this.mIsLoading != z16) {
            this.mIsLoading = z16;
            this.mHasMore = z17;
            if (z16) {
                dispatchLoadStart();
                return;
            } else {
                dispatchLoadEnd(z17);
                return;
            }
        }
        this.mHasMore = z17;
    }

    public void setMaxAutoLoadMoreTimes(int i3) {
        this.mMaxAutoTriggerLoadTimes = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startLoadMore(int i3, int i16, int i17) {
        if (this.mHasMore && !this.mIsLoading && this.mLoadMoreStrategy.canLoadMore(this.mRecyclerView, i3, i16, i17)) {
            this.mIsLoading = true;
            dispatchLoadStart();
        }
    }

    public boolean unRegisterLoadMoreListener(@NonNull ILoadMoreProvider$LoadMoreListener iLoadMoreProvider$LoadMoreListener) {
        return this.mLoadMoreListeners.remove(iLoadMoreProvider$LoadMoreListener);
    }

    private void logDebug(String str) {
    }
}
