package com.tencent.xweb.compatible;

import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CalledByRuntime;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.pinus.sdk.WebView;

@CalledByRuntime
/* loaded from: classes27.dex */
public class PinusAdaptClient {
    private static final String TAG = "PinusAdaptClient";
    public static final int XWEB_PINUS = 1;
    protected WebView psWebview;
    public int xwebType = -1;

    public void init(XWebExtendInterface xWebExtendInterface) {
        if (xWebExtendInterface instanceof WebView) {
            initPSWebView((WebView) xWebExtendInterface);
        } else {
            x0.c(TAG, "PinusAdaptClient constructor error");
        }
        if (this.xwebType != -1) {
            return;
        }
        x0.c(TAG, "xwebType = -1, super init not call view:" + xWebExtendInterface);
        throw new RuntimeException("PinusAdaptClient init error royle");
    }

    public void initPSWebView(WebView webView) {
        this.xwebType = 1;
        this.psWebview = webView;
    }
}
