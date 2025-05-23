package com.tencent.hippy.qq.view.viola.list;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.views.list.HippyListAdapter;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TkdListViewAdapter extends HippyListAdapter {
    public TkdListViewAdapter(RecyclerView recyclerView, HippyEngineContext hippyEngineContext) {
        super(recyclerView, hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.views.list.HippyListAdapter, com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter
    public void notifyEndReached() {
        RecyclerView recyclerView = this.mParentRecyclerView;
        if (recyclerView instanceof TkdListView) {
            TkdListView tkdListView = (TkdListView) recyclerView;
            if (!tkdListView.isLoading() && tkdListView.shouldEmitEndReachedEvent()) {
                getOnEndReachedEvent().send(this.mParentRecyclerView, null);
                tkdListView.setIsLoading(true);
            }
        }
    }
}
