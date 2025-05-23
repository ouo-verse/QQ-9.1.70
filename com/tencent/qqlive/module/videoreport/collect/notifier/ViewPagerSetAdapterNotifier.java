package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.support.v4.view.ViewPager;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* loaded from: classes22.dex */
public class ViewPagerSetAdapterNotifier implements IEventNotifier {
    private ViewPager mView;

    public void init(ViewPager viewPager) {
        this.mView = viewPager;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onSetViewPagerAdapter(this.mView);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mView = null;
    }
}
