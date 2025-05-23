package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBlockMerger extends BlockMerger {
    public GuildBlockMerger(BlockContainer blockContainer) {
        super(blockContainer);
        setRefreshViewProvider(new GuildRefreshHeadView(blockContainer.getContext()));
    }

    private View j0() {
        Context context = getRecyclerView().getContext();
        if (context == null) {
            return null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.epa, (ViewGroup) null, false);
        View findViewById = inflate.findViewById(R.id.zel);
        if (QQTheme.isNowThemeIsNight()) {
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.bnk));
        } else {
            findViewById.setBackgroundColor(context.getResources().getColor(R.color.bnl));
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(inflate);
        return frameLayout;
    }

    public void k0() {
        if (((PullLoadMoreAdapter) this).mRecyclerView != null && getRefreshViewProvider() != null) {
            QLog.d("BlockMerger", 4, "onShowRefreshAnim");
            getRefreshViewProvider().setState(4);
            this.mUIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.widget.GuildBlockMerger.1
                @Override // java.lang.Runnable
                public void run() {
                    ((PullLoadMoreAdapter) GuildBlockMerger.this).mRecyclerView.scrollToPosition(0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.BlockMerger, com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void onBindItemViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder != null && (viewHolder.itemView instanceof BaseWidgetView) && getRecyclerView() != null) {
            ((BaseWidgetView) viewHolder.itemView).setParentView(getRecyclerView());
        }
        super.onBindItemViewHolder(viewHolder, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
    public void onBindProgressViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindProgressViewHolder(viewHolder, i3);
        FrameLayout frameLayout = (FrameLayout) ((PullLoadMoreAdapter.LoadMoreViewHolder) viewHolder).itemView.findViewById(R.id.v7r);
        if (frameLayout != null && frameLayout.getChildCount() == 0) {
            View j06 = j0();
            setCustomNoMoreDataView(j06);
            frameLayout.addView(j06);
        }
    }
}
