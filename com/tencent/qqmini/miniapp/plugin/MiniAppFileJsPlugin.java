package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
/* loaded from: classes23.dex */
public class MiniAppFileJsPlugin extends BaseJsPlugin {
    public static final String EVENT_OPEN_DOCUMENT = "openDocument";

    @JsEvent({EVENT_OPEN_DOCUMENT})
    public void openDocument(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 1));
    }
}
