package com.tencent.biz.richframework.part.block;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.io.Serializable;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public abstract class MultiViewBlock<E> extends BaseListViewAdapter<E> {
    private static final String TAG = "MultiViewBlock";
    protected static final int VIEW_TYPE_FOOTER = 100001;
    protected static final int VIEW_TYPE_HEADER = 100000;
    protected static final int VIEW_TYPE_ITEM = 100002;
    protected static final int VIEW_TYPE_LIVE = 100003;
    private BlockMerger mBlockMerger;
    protected boolean mHasInitialized;
    private Bundle mInitData;
    protected BaseWidgetView.IInteractor mInteractor;
    protected boolean mIsDestroyed;
    private OnLoadDataDelegate mOnLoadDataDelegate;
    private int mPositionOffsetStart;
    private int mViewTypeOffsetStart;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final LoadInfo mLoadInfo = new LoadInfo();
    private String mUniqueKey = String.valueOf(hashCode());
    private final RecyclerView.AdapterDataObserver mDataSetObserver = new RecyclerView.AdapterDataObserver() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.1
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyDataSetChanged();
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(final int i3, final int i16) {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.2
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyItemRangeChanged(MultiViewBlock.this.getGlobalPosition(i3), i16);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(final int i3, final int i16) {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.4
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyItemRangeInserted(MultiViewBlock.this.getGlobalPosition(i3), i16);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(final int i3, final int i16, int i17) {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.6
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyItemMoved(MultiViewBlock.this.getGlobalPosition(i3), MultiViewBlock.this.getGlobalPosition(i16));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(final int i3, final int i16) {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.5
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyItemRangeRemoved(MultiViewBlock.this.getGlobalPosition(i3), i16);
                    MultiViewBlock.this.getBlockMerger().notifyItemRangeChanged(MultiViewBlock.this.getGlobalPosition(i3), MultiViewBlock.this.getBlockMerger().getItemCount() - MultiViewBlock.this.getGlobalPosition(i3));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(final int i3, final int i16, final Object obj) {
            MultiViewBlock.this.mHandler.post(new Runnable() { // from class: com.tencent.biz.richframework.part.block.MultiViewBlock.1.3
                @Override // java.lang.Runnable
                public void run() {
                    MultiViewBlock.this.getBlockMerger().notifyItemRangeChanged(MultiViewBlock.this.getGlobalPosition(i3), i16, obj);
                }
            });
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnLoadDataDelegate<T> {
        void onLoadData(LoadInfo loadInfo, T t16);
    }

    public MultiViewBlock(Bundle bundle) {
        this.mInitData = bundle;
        setHasStableIds(true);
    }

    private void innerloadData(LoadInfo loadInfo) {
        OnLoadDataDelegate onLoadDataDelegate = this.mOnLoadDataDelegate;
        if (onLoadDataDelegate != null) {
            onLoadDataDelegate.onLoadData(loadInfo, this);
        } else {
            loadData(loadInfo);
        }
    }

    public void addFixViewOccupySpaceAtTop(View view, int i3) {
        if (view != null && getBlockContainer() != null && getParentRecyclerView() != null) {
            if (view.getLayoutParams() != null) {
                ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = 48;
            }
            getBlockContainer().addView(view);
            getParentRecyclerView().setPadding(0, i3, 0, 0);
        }
    }

    public void addFloatView(View view) {
        if (getBlockContainer() != null) {
            getBlockContainer().addView(view);
        }
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        if (getParentRecyclerView() != null) {
            getParentRecyclerView().addOnScrollListener(onScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getActivity() {
        if (getBlockContainer() != null && getBlockContainer().getFragment() != null) {
            return getBlockContainer().getFragment().getActivity();
        }
        return null;
    }

    public BlockContainer getBlockContainer() {
        if (getBlockMerger() != null) {
            return getBlockMerger().getBlockContainer();
        }
        return null;
    }

    public BlockMerger getBlockMerger() {
        return this.mBlockMerger;
    }

    protected FrameLayout getCommonHeaderFooterWrapper(@Nullable View view) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (view != null) {
            frameLayout.addView(view);
        }
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return getActivity();
    }

    public Serializable getExtraTypeInfo() {
        if (getBlockContainer() != null) {
            return getBlockContainer().getExtraTypeInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFixedViewTypeOffset() {
        return 0;
    }

    public int getGlobalPosition(int i3) {
        return this.mPositionOffsetStart + i3;
    }

    public int getGlobalViewType(int i3) {
        return this.mViewTypeOffsetStart + i3;
    }

    public Bundle getInitParams() {
        return this.mInitData;
    }

    public BaseWidgetView.IInteractor getInteractor() {
        return this.mInteractor;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public E getItem(int i3) {
        if (getDataList() != null && !ArrayUtils.isOutOfArrayIndex(i3, getDataList())) {
            return getDataList().get(i3);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract int getItemCount();

    public LoadInfo getLoadInfo() {
        return this.mLoadInfo;
    }

    public int getLocalPosition(int i3) {
        return i3 - this.mPositionOffsetStart;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public Handler getMainHandler() {
        return this.mHandler;
    }

    public OnLoadDataDelegate getOnLoadDataDelegate() {
        return this.mOnLoadDataDelegate;
    }

    public Fragment getParentFragment() {
        if (getBlockContainer() != null) {
            return getBlockContainer().getFragment();
        }
        return null;
    }

    public NestScrollRecyclerView getParentRecyclerView() {
        if (getBlockContainer() != null) {
            return getBlockContainer().getRecyclerView();
        }
        return null;
    }

    public int getPositionOffsetStart() {
        return this.mPositionOffsetStart;
    }

    public int getSpanCount(int i3) {
        return 1;
    }

    public String getUniqueKey() {
        return this.mUniqueKey;
    }

    public <T extends ViewModel> T getViewModel(Class<T> cls) {
        if (getBlockMerger() != null && getBlockMerger().getBlockPart() != null) {
            return (T) getBlockMerger().getBlockPart().getViewModel(cls);
        }
        return null;
    }

    public abstract int getViewTypeCount();

    public int getViewTypeOffsetStart() {
        return this.mViewTypeOffsetStart;
    }

    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    public boolean isEnableRefresh() {
        return true;
    }

    public boolean isLastPeerBlock() {
        if (getBlockMerger() == null || getDataList().size() <= 0 || getBlockMerger().getDataList().get(getBlockMerger().getDataList().size() - 1) != this) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLazyLoad() {
        return false;
    }

    public boolean isOnScreen() {
        return true;
    }

    public abstract void loadData(LoadInfo loadInfo);

    public void loadMoreData(LoadInfo loadInfo) {
        OnLoadDataDelegate onLoadDataDelegate = this.mOnLoadDataDelegate;
        if (onLoadDataDelegate != null) {
            onLoadDataDelegate.onLoadData(loadInfo, this);
        } else {
            innerloadData(loadInfo);
        }
    }

    public void notifyLoadingComplete(boolean z16) {
        notifyLoadingComplete(z16, getLoadInfo().isFinish());
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (!hasObservers()) {
            registerAdapterDataObserver(this.mDataSetObserver);
        }
        this.mIsDestroyed = false;
    }

    public boolean onBackEvent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mIsDestroyed = true;
        if (hasObservers()) {
            unregisterAdapterDataObserver(this.mDataSetObserver);
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInit() {
        if (!this.mHasInitialized) {
            onInitBlock(getInitParams());
            this.mLoadInfo.setCurrentState(1);
            innerloadData(this.mLoadInfo);
            this.mHasInitialized = true;
        }
    }

    public abstract void onInitBlock(Bundle bundle);

    public void onRefreshData() {
        this.mLoadInfo.setCurrentState(2);
        OnLoadDataDelegate onLoadDataDelegate = this.mOnLoadDataDelegate;
        if (onLoadDataDelegate != null) {
            onLoadDataDelegate.onLoadData(this.mLoadInfo, this);
        } else {
            innerloadData(this.mLoadInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (isLazyLoad()) {
            onInit();
        }
    }

    public void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        if (getParentRecyclerView() != null) {
            getParentRecyclerView().removeOnScrollListener(onScrollListener);
        }
    }

    public void setBlockMerger(BlockMerger blockMerger) {
        this.mBlockMerger = blockMerger;
    }

    public void setGlobalPositionOffset(int i3) {
        this.mPositionOffsetStart = i3;
    }

    public void setInteractor(BaseWidgetView.IInteractor iInteractor) {
        this.mInteractor = iInteractor;
    }

    public void setOnLoadDataDelegate(OnLoadDataDelegate onLoadDataDelegate) {
        this.mOnLoadDataDelegate = onLoadDataDelegate;
    }

    public void setViewTypeOffset(int i3) {
        this.mViewTypeOffsetStart = i3;
    }

    public void notifyLoadingComplete(boolean z16, boolean z17) {
        notifyLoadingComplete(z16, z17, true);
    }

    public void notifyLoadingComplete(boolean z16, boolean z17, boolean z18) {
        if (getBlockContainer() == null || getBlockMerger() == null) {
            return;
        }
        getLoadInfo().setCurrentState(4);
        getLoadInfo().setFinish(z17);
        boolean z19 = false;
        getBlockContainer().setRefreshing(false);
        if (isLastPeerBlock()) {
            boolean z26 = getItemCount() == 0;
            BlockMerger blockMerger = getBlockMerger();
            if (z17 && !z26) {
                z19 = true;
            }
            blockMerger.onLoadMoreCompleted(z16, z19, z18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBlockChange(MultiViewBlock multiViewBlock, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDrawItemDecoration(Canvas canvas, RecyclerView recyclerView, View view, RecyclerView.State state) {
    }
}
