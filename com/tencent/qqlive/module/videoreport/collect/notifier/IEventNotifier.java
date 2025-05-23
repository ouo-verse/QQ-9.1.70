package com.tencent.qqlive.module.videoreport.collect.notifier;

import com.tencent.qqlive.module.videoreport.collect.IEventListener;
import com.tencent.qqlive.module.videoreport.utils.reuse.IReusable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IEventNotifier extends IReusable {
    void notifyEvent(IEventListener iEventListener);
}
