package com.tencent.qqlive.module.videoreport.collect.notifier;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AndroidXRVSetAdapterNotifier implements IEventNotifier {
    private RecyclerView mView;

    public void init(RecyclerView recyclerView) {
        this.mView = recyclerView;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onSetAndroidXRVAdapter(this.mView);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mView = null;
    }
}
