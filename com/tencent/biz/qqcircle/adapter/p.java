package com.tencent.biz.qqcircle.adapter;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QFSNegativeItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSNegativeHeadItemView;
import com.tencent.biz.qqcircle.immersive.views.QFSNegativeFeedbackItemView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p extends com.tencent.biz.qqcircle.bizparts.a<QFSNegativeItemInfo> {

    /* renamed from: m, reason: collision with root package name */
    private static final String f82660m = "com.tencent.biz.qqcircle.adapter.p";

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    public p(Bundle bundle) {
        super(bundle);
    }

    private boolean i0(RecyclerView recyclerView, int i3) {
        if (!(recyclerView.getLayoutManager() instanceof SafeStaggeredGridLayoutManager)) {
            return false;
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 <= 3 || i3 % 2 != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3;
        if (recyclerView == null) {
            return;
        }
        if (i0(recyclerView, recyclerView.getChildLayoutPosition(view))) {
            i3 = cx.a(16.0f);
        } else {
            i3 = 0;
        }
        rect.right = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return ((QFSNegativeItemInfo) this.mDataList.get(i3)).getItemType();
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return f82660m;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getSpanCount(int i3) {
        if (getItemViewType(i3) != -102) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        QFSNegativeItemInfo qFSNegativeItemInfo = (QFSNegativeItemInfo) this.mDataList.get(i3);
        View view = viewHolder.itemView;
        if (view instanceof QFSNegativeHeadItemView) {
            ((QFSNegativeHeadItemView) view).bindData(qFSNegativeItemInfo, i3);
        } else if (view instanceof QFSNegativeFeedbackItemView) {
            ((QFSNegativeFeedbackItemView) view).bindData(qFSNegativeItemInfo, i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == -102) {
            return new a(new QFSNegativeFeedbackItemView(viewGroup.getContext()));
        }
        return new a(new QFSNegativeHeadItemView(viewGroup.getContext()));
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
