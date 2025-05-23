package com.tencent.biz.pubaccount.weishi.operationh5;

import android.content.Intent;
import android.os.Bundle;
import cc2.b;
import com.tencent.biz.pubaccount.weishi.s;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSCommonWebViewFragment extends WebViewFragment {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            WSCommonWebViewFragment.this.rh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            super.onWebViewInit(bundle, touchWebView);
            WSCommonWebViewFragment.this.sh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        Intent intent;
        if (getActivity() == null || (intent = this.intent) == null || !intent.getBooleanExtra(IPCConst.KEY_HIDE_TITLE_BAR, false)) {
            return;
        }
        getWebTitleBarInterface().u5(false);
        getUIStyleHandler().T.setVisibility(8);
        b.e(getHostActivity(), false);
        b.c(getHostActivity(), ResourceUtil.getColor(R.color.f77857));
        int a16 = b.a(getHostActivity());
        getWebTitleBarInterface().Kb(a16, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        CookieSyncManager.createInstance(BaseApplication.getContext());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie(".weishi.qq.com", "Domain=.weishi.qq.com");
        cookieManager.setCookie(".weishi.qq.com", "Path=/");
        cookieManager.setCookie(".weishi.qq.com", "iAuthType=1");
        cookieManager.setCookie(".weishi.qq.com", "openid=" + s.h().j().f81578a);
        cookieManager.setCookie(".weishi.qq.com", "sSessionKey=" + s.h().j().f81579b);
        cookieManager.setCookie(".weishi.qq.com", "person_id=" + bb.q());
        cookieManager.setCookie(".weishi.qq.com", "sUid=" + bb.y());
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }
}
