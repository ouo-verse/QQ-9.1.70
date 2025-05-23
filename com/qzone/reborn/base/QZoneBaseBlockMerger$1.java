package com.qzone.reborn.base;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter;

/* compiled from: P */
/* loaded from: classes37.dex */
class QZoneBaseBlockMerger$1 implements Runnable {
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView;
        recyclerView = ((PullLoadMoreAdapter) ((PullLoadMoreAdapter) this.this$0)).mRecyclerView;
        recyclerView.scrollToPosition(0);
    }
}
