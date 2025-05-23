package com.tencent.qqmini.nativePlugins;

import com.tencent.mobileqq.mini.api.IMiniCustomViewService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class u extends BaseJsPlugin {
    @JsEvent({"endLaunchLoading"})
    public void hideSplashLoading(RequestEvent requestEvent) {
        ((IMiniCustomViewService) QRoute.api(IMiniCustomViewService.class)).hideMetaRoomLoadingView();
        requestEvent.ok();
    }
}
