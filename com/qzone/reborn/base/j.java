package com.qzone.reborn.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class j<E> extends MultiViewBlock<E> {
    public j(Bundle bundle) {
        super(bundle);
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
