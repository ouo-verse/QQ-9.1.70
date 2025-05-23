package com.tencent.xweb;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.f;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.pinus.PinusWebView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewContextWrapper extends MutableContextWrapper {
    public static final String TAG = "WebViewContextWrapper";

    /* renamed from: a, reason: collision with root package name */
    public IWebView f385015a;

    public WebViewContextWrapper(Context context) {
        super(context);
    }

    public final void a(IWebView iWebView) {
        f b16;
        d webViewCoreWrapper;
        if (!(iWebView instanceof PinusWebView) || (b16 = g.b(WebView.WebViewKind.WV_KIND_PINUS)) == null || (webViewCoreWrapper = b16.getWebViewCoreWrapper()) == null) {
            return;
        }
        webViewCoreWrapper.invokeRuntimeChannel(80001, new Object[]{((PinusWebView) iWebView).getBridge()});
    }

    @Override // android.content.MutableContextWrapper
    public void setBaseContext(Context context) {
        super.setBaseContext(context);
        x0.d(TAG, "setBaseContext, context:" + context + ", webViewType:" + WebView.getCurrentModuleWebCoreType());
        a(this.f385015a);
    }

    public void setBindedWebview(IWebView iWebView) {
        this.f385015a = iWebView;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e16) {
            x0.c(TAG, "XWebContextWrapper unbindService IllegalArgumentException:" + e16);
        }
    }
}
