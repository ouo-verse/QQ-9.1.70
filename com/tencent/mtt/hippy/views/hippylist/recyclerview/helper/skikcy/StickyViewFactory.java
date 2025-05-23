package com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class StickyViewFactory implements IHeaderViewFactory {
    private final RecyclerViewBase recyclerView;

    public StickyViewFactory(RecyclerViewBase recyclerViewBase) {
        this.recyclerView = recyclerViewBase;
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.recyclerview.helper.skikcy.IHeaderViewFactory
    public RecyclerView.ViewHolder getHeaderForPosition(int i3) {
        if (i3 < 0) {
            return null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(i3);
        if (findViewHolderForAdapterPosition == null) {
            return this.recyclerView.getViewHolderForPosition(i3);
        }
        return findViewHolderForAdapterPosition;
    }
}
