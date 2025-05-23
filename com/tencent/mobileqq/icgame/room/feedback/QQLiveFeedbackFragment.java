package com.tencent.mobileqq.icgame.room.feedback;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveFeedbackFragment extends WebViewFragment {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            super.onWebViewInit(bundle, touchWebView);
            if (touchWebView != null) {
                touchWebView.setMask(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }
}
