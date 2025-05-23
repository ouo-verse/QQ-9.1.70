package com.tencent.ecommerce.base.ui.recyclerviewhelper;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/ui/recyclerviewhelper/ECOnDragSortListener;", "", "onDragEnd", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onStartDrag", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface ECOnDragSortListener {
    void onDragEnd(RecyclerView.ViewHolder viewHolder);

    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
