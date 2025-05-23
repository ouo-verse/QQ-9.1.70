package com.qzone.reborn.feedpro.block;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedpro.widget.comment.QZoneFeedProDetailCommentAdItemView;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailBaseCommentItemView;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailCommentItemView;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailMoreReplyShrinkItemView;
import com.qzone.reborn.feedpro.widget.comment.QzoneFeedProDetailReplyItemView;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class h extends com.qzone.reborn.base.j<wd.c> {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        public void l(wd.c cVar, int i3) {
            View view = this.itemView;
            if (view instanceof QzoneFeedProDetailBaseCommentItemView) {
                ((QzoneFeedProDetailBaseCommentItemView) view).setData(cVar, i3);
            } else if (view instanceof QzoneFeedProDetailMoreReplyShrinkItemView) {
                ((QzoneFeedProDetailMoreReplyShrinkItemView) view).setData(cVar, i3);
            } else if (view instanceof QZoneFeedProDetailCommentAdItemView) {
                ((QZoneFeedProDetailCommentAdItemView) view).setData(cVar, i3);
            }
        }
    }

    public h(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getDataList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getItem(i3) instanceof wd.b) {
            return 104;
        }
        if (getItemCount() <= i3) {
            return 101;
        }
        return getItem(i3).getMItemType();
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 4;
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

    public void j0(CommonComment commonComment) {
        List<wd.c> dataList;
        CommonComment mComment;
        if (commonComment == null || TextUtils.isEmpty(commonComment.getId()) || (dataList = getDataList()) == null) {
            return;
        }
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            wd.c cVar = dataList.get(i3);
            if (cVar != null && cVar.getMItemType() == 101 && (mComment = cVar.getMComment()) != null && TextUtils.equals(mComment.getId(), commonComment.getId())) {
                getRecyclerView().scrollToPosition(getGlobalPosition(i3));
                return;
            }
        }
    }

    @Override // com.qzone.reborn.base.j
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public a onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 102) {
            return new a(new QzoneFeedProDetailReplyItemView(viewGroup.getContext()));
        }
        if (i3 == 103) {
            return new a(new QzoneFeedProDetailMoreReplyShrinkItemView(viewGroup.getContext()));
        }
        if (i3 == 104) {
            return new a(new QZoneFeedProDetailCommentAdItemView(viewGroup.getContext()));
        }
        return new a(new QzoneFeedProDetailCommentItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
