package com.tencent.luggage.wxa.kj;

import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.qqmini.miniapp.core.EventListener;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum k1 {
    APP_LAUNCH(EventListener.APPLAUNCH),
    NAVIGATE_TO("navigateTo"),
    NAVIGATE_BACK("navigateBack"),
    REDIRECT_TO("redirectTo"),
    REWRITE_ROUTE(com.tencent.luggage.wxa.yf.r.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB("switchTab"),
    DISMISS_PIP("dismissPip"),
    RELOAD(DKWebViewController.DKHippyWebviewFunction.RELOAD);


    /* renamed from: a, reason: collision with root package name */
    public final String f132243a;

    k1(String str) {
        this.f132243a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f132243a;
    }
}
