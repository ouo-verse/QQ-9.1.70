package com.tencent.qqlive.module.videoreport.collect.notifier;

import android.app.Activity;
import android.content.res.Configuration;
import com.tencent.qqlive.module.videoreport.collect.IEventListener;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ActivityConfigurationChangedNotifier implements IEventNotifier {
    private Activity mActivity;
    private Configuration mConfiguration;

    public void init(Activity activity, Configuration configuration) {
        this.mActivity = activity;
        this.mConfiguration = configuration;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier
    public void notifyEvent(IEventListener iEventListener) {
        iEventListener.onActivityConfigurationChanged(this.mActivity, this.mConfiguration);
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.reuse.IReusable
    public void reset() {
        this.mActivity = null;
        this.mConfiguration = null;
    }
}
