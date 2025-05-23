package com.tencent.qqmini.miniapp.core.page;

import com.tencent.qqmini.sdk.launcher.core.IJsService;

/* loaded from: classes23.dex */
public interface PageEventListener {
    void onAppRoute(String str, String str2, int i3);

    void onAppRouteDone(String str, String str2, int i3);

    void onWebViewEvent(String str, String str2, int i3);

    String onWebViewNativeRequest(String str, String str2, IJsService iJsService, int i3, int i16);

    void onWebViewReady(String str, String str2, int i3);
}
