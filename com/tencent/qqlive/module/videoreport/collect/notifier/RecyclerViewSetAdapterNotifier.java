package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.support.v7.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RecyclerViewSetAdapterNotifier implements IEventNotifier {
    private RecyclerView mView;

    public void init(RecyclerView recyclerView) {
        this.mView = recyclerView;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onSetRecyclerViewAdapter(this.mView);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mView = null;
    }
}
