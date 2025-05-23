package com.tencent.qqmini.sdk.launcher.core.plugins.engine;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle;

/* loaded from: classes23.dex */
public interface IJsPluginEngine extends ILifeCycle {
    String checkAuthorization(RequestEvent requestEvent);

    String handleNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16);
}
