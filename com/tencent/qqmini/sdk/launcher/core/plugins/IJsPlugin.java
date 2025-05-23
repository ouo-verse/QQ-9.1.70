package com.tencent.qqmini.sdk.launcher.core.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

/* loaded from: classes23.dex */
public interface IJsPlugin extends ILifeCycle {
    boolean onInterceptJsEvent(RequestEvent requestEvent);
}
