package com.tencent.biz.qqstory.takevideo.slideshow;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    private a f94402a;

    public g(a aVar) {
        this.f94402a = aVar;
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof SlideShowAdapter.c) {
            ((SlideShowAdapter.c) viewHolder).C = false;
            if (recyclerView.getScrollState() == 0 && !recyclerView.isComputingLayout()) {
                recyclerView.getAdapter().notifyItemChanged(viewHolder.getAdapterPosition(), 0);
            }
        }
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.25f;
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int i3;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if ((layoutManager instanceof LinearLayoutManager) && ((LinearLayoutManager) layoutManager).getOrientation() == 0) {
            i3 = 15;
        } else {
            i3 = 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(i3, 0);
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        a aVar = this.f94402a;
        if (aVar != null) {
            aVar.onItemMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return false;
        }
        return false;
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
        super.onSelectedChanged(viewHolder, i3);
        if (i3 == 2 && (viewHolder instanceof SlideShowAdapter.c)) {
            SlideShowAdapter.c cVar = (SlideShowAdapter.c) viewHolder;
            cVar.C = true;
            a aVar = this.f94402a;
            if (aVar instanceof SlideShowAdapter) {
                ((SlideShowAdapter) aVar).notifyItemChanged(cVar.getAdapterPosition(), 0);
            }
        }
    }

    @Override // com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
