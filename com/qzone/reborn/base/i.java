package com.qzone.reborn.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class i<E> extends BaseListViewAdapter<E> {
    public i() {
        setHasStableIds(true);
    }

    public abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder onCreateItemViewHolder = onCreateItemViewHolder(viewGroup, i3);
        View view = onCreateItemViewHolder.itemView;
        if (view instanceof BaseWidgetView) {
            ((BaseWidgetView) view).setParentView(viewGroup);
        }
        return onCreateItemViewHolder;
    }
}
