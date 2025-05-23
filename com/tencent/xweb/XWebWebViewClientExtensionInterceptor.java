package com.tencent.xweb;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.internal.IWebView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebWebViewClientExtensionInterceptor {
    public static final String TAG = "XWebWebViewClientExtensionInterceptor";

    /* renamed from: a, reason: collision with root package name */
    public int f385098a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final IWebView f385099b;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class InterceptResult {
        public boolean intercepted;
        public Object result;

        public InterceptResult(boolean z16, Object obj) {
            this.intercepted = z16;
            this.result = obj;
        }
    }

    public XWebWebViewClientExtensionInterceptor(IWebView iWebView) {
        this.f385099b = iWebView;
    }

    public InterceptResult interceptOnMiscCallback(String str, Bundle bundle) {
        int i3;
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("onContentHeightChanged") && (i3 = bundle.getInt("height")) != this.f385098a) {
            this.f385098a = i3;
            IWebView iWebView = this.f385099b;
            if (iWebView != null && iWebView.getWebViewCallbackClient() != null) {
                x0.d(TAG, "onContentHeightChanged, height:" + i3);
                this.f385099b.getWebViewCallbackClient().onContentHeightChanged(i3);
                return new InterceptResult(true, null);
            }
        }
        return new InterceptResult(false, null);
    }
}
