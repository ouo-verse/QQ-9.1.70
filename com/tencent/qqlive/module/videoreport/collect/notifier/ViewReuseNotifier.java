package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewReuseNotifier implements IEventNotifier {
    private long mItemId = -1;
    private ViewGroup mParentView;
    private View mView;

    public void init(ViewGroup viewGroup, View view, long j3) {
        this.mParentView = viewGroup;
        this.mView = view;
        this.mItemId = j3;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onViewReused(this.mParentView, this.mView, this.mItemId);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mParentView = null;
        this.mView = null;
        this.mItemId = -1L;
    }
}
