package com.tencent.mobileqq.mini.appbrand.ui;

import android.app.Activity;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.utils.bg;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import ne0.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppWebviewFragment extends WebViewFragment {
    public static final String KEY_HEADER = "key_header";
    public static final String KEY_URL_BLACK_LIST = "key_url_black_list";
    private final String TAG = "MiniAppWebviewFragment";

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBlackPrefixUrl(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() != 0) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.toLowerCase().startsWith(it.next().toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new com.tencent.mobileqq.webview.swift.proxy.a(this.webViewSurface) { // from class: com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment.1
            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
            public boolean interceptStartLoadUrl() {
                ArrayList<String> stringArrayListExtra = MiniAppWebviewFragment.this.getIntent().getStringArrayListExtra(MiniAppWebviewFragment.KEY_URL_BLACK_LIST);
                if (!bg.f().i(((WebViewFragment) MiniAppWebviewFragment.this).mUrl)) {
                    MiniAppWebviewFragment miniAppWebviewFragment = MiniAppWebviewFragment.this;
                    if (!miniAppWebviewFragment.isBlackPrefixUrl(((WebViewFragment) miniAppWebviewFragment).mUrl, stringArrayListExtra)) {
                        HashMap hashMap = MiniAppWebviewFragment.this.getIntent().hasExtra(MiniAppWebviewFragment.KEY_HEADER) ? (HashMap) MiniAppWebviewFragment.this.getIntent().getSerializableExtra(MiniAppWebviewFragment.KEY_HEADER) : null;
                        if (!TextUtils.isEmpty(((WebViewFragment) MiniAppWebviewFragment.this).mUrl)) {
                            if (hashMap != null && hashMap.size() > 0) {
                                ((WebViewFragment) MiniAppWebviewFragment.this).webView.loadUrl(((WebViewFragment) MiniAppWebviewFragment.this).mUrl, hashMap);
                            } else {
                                ((WebViewFragment) MiniAppWebviewFragment.this).webView.loadUrl(((WebViewFragment) MiniAppWebviewFragment.this).mUrl);
                            }
                        }
                        return true;
                    }
                }
                ((WebViewFragment) MiniAppWebviewFragment.this).webView.loadUrl("file:///android_asset/error.html");
                QLog.d("MiniAppWebviewFragment", 1, "url:", ((WebViewFragment) MiniAppWebviewFragment.this).mUrl, "in black");
                return true;
            }

            @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (MiniAppWebviewFragment.this.isDestroyed() || ((WebViewFragment) MiniAppWebviewFragment.this).webView == null) {
                    return true;
                }
                if (MiniAppWebviewFragment.this.isBlackPrefixUrl(str, MiniAppWebviewFragment.this.getIntent().getStringArrayListExtra(MiniAppWebviewFragment.KEY_URL_BLACK_LIST))) {
                    ((WebViewFragment) MiniAppWebviewFragment.this).webView.loadUrl("file:///android_asset/error.html");
                    QLog.d("MiniAppWebviewFragment", 1, "url:", ((WebViewFragment) MiniAppWebviewFragment.this).mUrl, "in black");
                    return true;
                }
                return this.webViewKernelCallBack.shouldOverrideUrlLoading(webView, str);
            }
        };
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        f.c(this, activity);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return f.e(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return f.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return f.g(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        f.l(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return f.o(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }
}
