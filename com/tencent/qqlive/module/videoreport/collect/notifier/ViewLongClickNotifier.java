package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ViewLongClickNotifier implements IEventNotifier {
    private DTConstants.ClickEventSource mClickEventSource = DTConstants.ClickEventSource.METHOND_AFTER;
    private View mView;

    public void init(View view, DTConstants.ClickEventSource clickEventSource) {
        this.mView = view;
        this.mClickEventSource = clickEventSource;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        if (iEventListener == null) {
            return;
        }
        iEventListener.onViewLongClick(this.mView, this.mClickEventSource);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mView = null;
        this.mClickEventSource = DTConstants.ClickEventSource.METHOND_AFTER;
    }
}
