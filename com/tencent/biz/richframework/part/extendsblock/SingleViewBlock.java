package com.tencent.biz.richframework.part.extendsblock;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public abstract class SingleViewBlock extends MultiViewBlock {
    private boolean mIsBlockVisible;
    private BaseWidgetView mRootView;

    public SingleViewBlock(Bundle bundle) {
        super(bundle);
        this.mIsBlockVisible = true;
    }

    protected abstract BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock);

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mIsBlockVisible ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 1;
    }

    public BaseWidgetView getSingleBlockRootView() {
        return this.mRootView;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    public boolean getVisible() {
        return this.mIsBlockVisible;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.mRootView == null) {
            BaseWidgetView createBlockRootView = createBlockRootView(viewGroup, this);
            this.mRootView = createBlockRootView;
            if (createBlockRootView != null) {
                createBlockRootView.setParentView(viewGroup);
            }
        }
        return new BaseListViewAdapter.BaseVH(this.mRootView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    public void setBlockVisible(boolean z16) {
        if (z16 == this.mIsBlockVisible) {
            return;
        }
        this.mIsBlockVisible = z16;
        if (getBlockMerger() != null) {
            if (z16) {
                getBlockMerger().notifyItemRangeInserted(getGlobalPosition(0), 1);
            } else {
                getBlockMerger().notifyItemRangeRemoved(getGlobalPosition(0), 1);
            }
            int itemCount = getBlockMerger().getItemCount() - getGlobalPosition(0);
            getBlockMerger().notifyItemRangeChanged(getGlobalPosition(0), itemCount);
            RFWLog.i("SingleViewBlock", RFWLog.USR, String.format("%s : isVisible:%b, globalPos:%d, notifyCount:%d", getClass().getSimpleName(), Boolean.valueOf(z16), Integer.valueOf(getGlobalPosition(0)), Integer.valueOf(itemCount)));
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void setDatas(List list) {
        this.mDataList.clear();
        notifyDataSetChanged();
        if (list == null) {
            return;
        }
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
