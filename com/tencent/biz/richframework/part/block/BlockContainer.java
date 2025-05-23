package com.tencent.biz.richframework.part.block;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IRecyclerViewPoolProvider;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class BlockContainer extends FrameLayout {
    protected BlockMerger mBlockMerger;
    private boolean mEnablePageRecyclerViewPool;
    private Serializable mExtraTypeInfo;
    private RecyclerView.LayoutManager mLayoutManager;
    private Fragment mParentFragment;
    protected NestScrollRecyclerView mRecyclerView;
    private IStatusViewProvider mStatusViewProvider;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class MergeItemDecorationDelegate extends RecyclerView.ItemDecoration {
        public MergeItemDecorationDelegate(BlockMerger blockMerger) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (BlockContainer.this.mBlockMerger == null) {
                return;
            }
            MultiViewBlock findBlock = BlockContainer.this.mBlockMerger.findBlock(recyclerView.getChildLayoutPosition(view));
            if (findBlock != null) {
                findBlock.getItemOffsets(rect, view, recyclerView, state);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            if (BlockContainer.this.mBlockMerger == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                MultiViewBlock findBlock = BlockContainer.this.mBlockMerger.findBlock(recyclerView.getChildLayoutPosition(childAt));
                if (findBlock != null) {
                    findBlock.onDrawItemDecoration(canvas, recyclerView, childAt, state);
                }
            }
        }
    }

    public BlockContainer(Context context) {
        this(context, null);
    }

    protected BlockMerger createBlockMerger() {
        return new BlockMerger(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public BlockMerger getBlockMerger() {
        return this.mBlockMerger;
    }

    public Serializable getExtraTypeInfo() {
        return this.mExtraTypeInfo;
    }

    @Deprecated
    public Fragment getFragment() {
        if (this.mParentFragment == null && RFWApplication.isDebug()) {
            throw new RuntimeException("please setParentFragment for ComponentPageView");
        }
        return this.mParentFragment;
    }

    public int getLayoutId() {
        return R.layout.f169065hn2;
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public NestScrollRecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public IStatusViewProvider getStatusInterface() {
        return this.mStatusViewProvider;
    }

    protected void initRecyclerView(FrameLayout frameLayout) {
        NestScrollRecyclerView nestScrollRecyclerView = (NestScrollRecyclerView) frameLayout.findViewById(R.id.f73913uu);
        this.mRecyclerView = nestScrollRecyclerView;
        nestScrollRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setNestedScrollingEnabled(false);
        BlockMerger createBlockMerger = createBlockMerger();
        this.mBlockMerger = createBlockMerger;
        this.mRecyclerView.setAdapter(createBlockMerger);
        this.mRecyclerView.addItemDecoration(new MergeItemDecorationDelegate(this.mBlockMerger));
        setLayoutManagerType(1, 1);
        this.mRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        try {
            LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
        } catch (Throwable th5) {
            RFWLog.d("BlockContainer", RFWLog.USR, "initView error:" + th5.toString());
        }
        initRecyclerView(this);
    }

    public boolean isEnableLoadMore() {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            return blockMerger.isEnableLoadMore();
        }
        return false;
    }

    public boolean isEnablePageRecyclerViewPool() {
        return this.mEnablePageRecyclerViewPool;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public boolean onBackEvent() {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            return blockMerger.onBackEvent();
        }
        return false;
    }

    public void onDestroy() {
        NestScrollRecyclerView nestScrollRecyclerView = this.mRecyclerView;
        if (nestScrollRecyclerView != null) {
            if (nestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
            }
            this.mRecyclerView.setAdapter(null);
        }
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.destroy();
        }
        this.mParentFragment = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void registerBlock(MultiViewBlock multiViewBlock) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.registerBlock(multiViewBlock);
        }
    }

    public void setBlockWrapper(BlockPart blockPart) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.setBlockWrapper(blockPart);
            this.mBlockMerger.setBlockContainer(this);
        }
    }

    public void setEnableLoadMore(boolean z16) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.setEnableLoadMore(z16);
        }
    }

    public void setEnablePageRecyclerViewPool(boolean z16) {
        this.mEnablePageRecyclerViewPool = z16;
        if (z16 && (getContext() instanceof IRecyclerViewPoolProvider)) {
            getRecyclerView().setRecycledViewPool(((IRecyclerViewPoolProvider) getContext()).getRecycledViewPool());
        } else {
            getRecyclerView().setRecycledViewPool(new RecyclerView.RecycledViewPool());
        }
    }

    public void setEnableRefresh(boolean z16) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.setEnableRefresh(z16);
        }
    }

    public void setExtraTypeInfo(Serializable serializable) {
        this.mExtraTypeInfo = serializable;
    }

    public void setLayoutManagerType(int i3, int i16) {
        if (i3 != 2) {
            if (i3 != 3) {
                this.mLayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
            } else {
                this.mRecyclerView.setHasFixedSize(false);
                SafeStaggeredGridLayoutManager safeStaggeredGridLayoutManager = new SafeStaggeredGridLayoutManager(i16, 1);
                this.mLayoutManager = safeStaggeredGridLayoutManager;
                safeStaggeredGridLayoutManager.setGapStrategy(0);
            }
        } else {
            SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(getContext(), i16);
            this.mLayoutManager = safeGridLayoutManager;
            safeGridLayoutManager.setSpanSizeLookup(this.mBlockMerger.getSpanSizeLookupListener());
        }
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mBlockMerger.updateLayoutManager(this.mLayoutManager);
    }

    public void setParentFragment(Fragment fragment) {
        this.mParentFragment = fragment;
    }

    public void setRefreshHeader(IRefreshViewProvider iRefreshViewProvider) {
        BlockMerger blockMerger;
        if (iRefreshViewProvider != null && (blockMerger = this.mBlockMerger) != null && blockMerger.getBlockContainer() != null && this.mBlockMerger.getBlockContainer().mBlockMerger != null) {
            this.mBlockMerger.getBlockContainer().mBlockMerger.setRefreshViewProvider(iRefreshViewProvider);
        }
    }

    public void setRefreshing(boolean z16) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            if (z16 && !blockMerger.isRefreshing()) {
                this.mBlockMerger.setRefreshing(true);
            }
            if (!z16 && this.mBlockMerger.isRefreshing()) {
                this.mBlockMerger.setRefreshing(false);
            }
        }
    }

    public void setStatusViewInterface(IStatusViewProvider iStatusViewProvider) {
        if (iStatusViewProvider != null) {
            this.mStatusViewProvider = iStatusViewProvider;
            View statusView = iStatusViewProvider.getStatusView();
            if (statusView != null && statusView.getParent() != null) {
                ((ViewGroup) statusView.getParent()).removeView(statusView);
            }
            addView(statusView, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        throw new RuntimeException("IStatusViewInterface can't be null");
    }

    public void start() {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.onInitEachBlock();
        }
    }

    public void unRegisterBlock(MultiViewBlock multiViewBlock) {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger != null) {
            blockMerger.unRegisterBlock(multiViewBlock);
        }
    }

    public BlockContainer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BlockContainer(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void registerBlock(ArrayList<MultiViewBlock> arrayList) {
        Iterator<MultiViewBlock> it = arrayList.iterator();
        while (it.hasNext()) {
            registerBlock(it.next());
        }
    }
}
