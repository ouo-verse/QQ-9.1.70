package com.qzone.reborn.feedx.block;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedDetailBaseCommentWidget;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailCommentItemView;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailMoreReplyShrinkItemView;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailReplyItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;

/* compiled from: P */
/* loaded from: classes37.dex */
public class j extends com.qzone.reborn.base.j<pg.a> {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(pg.a aVar, int i3) {
            View view = this.itemView;
            if (view instanceof QZoneFeedDetailBaseCommentWidget) {
                ((QZoneFeedDetailBaseCommentWidget) view).setData(aVar, i3);
            } else if (view instanceof QZoneFeedxDetailMoreReplyShrinkItemView) {
                ((QZoneFeedxDetailMoreReplyShrinkItemView) view).setData(aVar, i3);
            }
        }
    }

    public j(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getNUM_BACKGOURND_ICON() <= i3) {
            return 101;
        }
        return getItem(i3).f426123a;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public boolean isLastPeerBlock() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadMoreData(LoadInfo loadInfo) {
        super.loadMoreData(loadInfo);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).l(getItem(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z16) {
        super.setHasStableIds(false);
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public a onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 102) {
            return new a(new QZoneFeedxDetailReplyItemView(viewGroup.getContext()));
        }
        if (i3 == 103) {
            return new a(new QZoneFeedxDetailMoreReplyShrinkItemView(viewGroup.getContext()));
        }
        return new a(new QZoneFeedxDetailCommentItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
