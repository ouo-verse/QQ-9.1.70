package com.tencent.gdtad.web;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.r;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtWebViewFragment extends WebViewFragment implements com.tencent.mobileqq.webview.swift.h {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(Bundle bundle) {
            super.onShowPreview(bundle);
            QLog.i("WebLog_GdtWebViewFragment", 1, "[onShowPreview]");
            r uIStyle = GdtWebViewFragment.this.getUIStyle();
            if (uIStyle != null) {
                uIStyle.f314629l = false;
                uIStyle.f314634q = Boolean.TRUE;
            } else {
                QLog.e("WebLog_GdtWebViewFragment", 1, "[onShowPreview] error, uiStyle is null");
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.h
    public WebViewFragment newInstance(int i3, u uVar, WebViewTabBarData webViewTabBarData, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        GdtWebViewFragment gdtWebViewFragment = new GdtWebViewFragment();
        gdtWebViewFragment.setArguments(bundle);
        return gdtWebViewFragment;
    }
}
