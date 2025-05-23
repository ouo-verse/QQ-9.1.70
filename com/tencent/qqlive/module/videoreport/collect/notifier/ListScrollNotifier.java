package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.widget.AbsListView;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ListScrollNotifier implements IEventNotifier {
    private AbsListView mListView;
    private int mScrollState;

    public void init(AbsListView absListView, int i3) {
        this.mListView = absListView;
        this.mScrollState = i3;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onListScrollStateChanged(this.mListView, this.mScrollState);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mListView = null;
        this.mScrollState = 0;
    }
}
