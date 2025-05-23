package com.tencent.qqmini.sdk.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.browser.BrowserPluginEngine;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class BaseBrowserFragment extends MiniBaseFragment implements View.OnClickListener {
    private static final String TAG = "BaseBrowserFragment";
    BrowserPluginEngine mBrowserEngine;
    ArrayMap<String, Object> mCoreDumpData;
    TextView mLeftBtnView;
    View mTitleBar;
    TextView mTitleView;
    private WebView mWebView;

    private void initCookie(Intent intent, String str) {
        String stringExtra = intent.getStringExtra("cookie");
        if (!TextUtils.isEmpty(stringExtra)) {
            String replace = stringExtra.replace(" ", "");
            if (!TextUtils.isEmpty(replace)) {
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                for (String str2 : replace.split(";")) {
                    cookieManager.setCookie(Uri.parse(str).getHost(), str2);
                }
                try {
                    CookieSyncManager.getInstance().sync();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void initLeftView(Intent intent) {
        if (intent.getBooleanExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false)) {
            this.mLeftBtnView.setVisibility(4);
            return;
        }
        String stringExtra = intent.getStringExtra(IPCConst.KEY_LEFT_BUTTON_TEXT);
        TextView textView = this.mLeftBtnView;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "\u8fd4\u56de";
        }
        textView.setText(stringExtra);
        this.mLeftBtnView.setOnClickListener(this);
    }

    private void initTitle(Intent intent) {
        if (intent.getBooleanExtra(IPCConst.KEY_HIDE_TITLE, false)) {
            this.mTitleView.setVisibility(4);
            return;
        }
        String stringExtra = intent.getStringExtra(IPCConst.KEY_TITLE_TEXT);
        TextView textView = this.mTitleView;
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "";
        }
        textView.setText(stringExtra);
    }

    private void initView(Intent intent, View view) {
        this.mTitleBar = view.findViewById(R.id.title_bar);
        this.mLeftBtnView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mTitleView = (TextView) view.findViewById(R.id.ivTitleName);
        this.mWebView = (WebView) view.findViewById(R.id.web_view);
        initWebview();
        if (intent.getBooleanExtra(IPCConst.KEY_HIDE_TITLE_BAR, false)) {
            this.mTitleBar.setVisibility(8);
        } else {
            initLeftView(intent);
            initTitle(intent);
        }
    }

    private void initWebview() {
        if (needWebViewTranslucent()) {
            this.mWebView.setBackgroundColor(0);
        }
        WebView.setWebContentsDebuggingEnabled(true);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.qqmini.sdk.ui.BaseBrowserFragment.1
            @Override // android.webkit.WebViewClient
            public void doUpdateVisitedHistory(WebView webView, String str, boolean z16) {
                super.doUpdateVisitedHistory(webView, str, z16);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                QMLog.d(BaseBrowserFragment.TAG, "onPageFinished " + str);
                super.onPageFinished(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                QMLog.d(BaseBrowserFragment.TAG, "onPageStarted " + str);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i3, String str, String str2) {
                super.onReceivedError(webView, i3, str, str2);
                String url = webView.getUrl();
                QMLog.d(BaseBrowserFragment.TAG, "onReceivedError " + url + "; webResourceError : " + str + ", errCode = " + i3 + ", failingUrl=" + str2);
                BaseBrowserFragment.this.processCoreDumpData(i3, str, str2, url);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                QMLog.i(BaseBrowserFragment.TAG, "onReceivedHttpError:" + webResourceResponse.getStatusCode());
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                BaseBrowserFragment.this.processCoreDumpData(webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString(), webView.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                QMLog.d(BaseBrowserFragment.TAG, "shouldOverrideUrlLoading " + str);
                if (BaseBrowserFragment.this.isUrlBlank(str)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    StringBuilder sb6 = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
                    sb6.append(str);
                    sb6.append("].");
                    sb5.append((Object) sb6);
                    QMLog.e(BaseBrowserFragment.TAG, sb5.toString());
                    return true;
                }
                if (str.startsWith("https://jsbridge/")) {
                    str = str.replace("https://jsbridge/", "jsbridge://");
                } else if (str.startsWith("http://jsbridge/")) {
                    str = str.replace("http://jsbridge/", "jsbridge://");
                } else if (BaseBrowserFragment.this.isSchemeUrl(str)) {
                    BaseBrowserFragment.this.mWebView.getContext().startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str)));
                    return true;
                }
                BrowserPluginEngine browserPluginEngine = BaseBrowserFragment.this.mBrowserEngine;
                if (browserPluginEngine != null && browserPluginEngine.shouldOverrideUrlRequest(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                String str;
                String url = webView.getUrl();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceivedError ");
                sb5.append(url);
                sb5.append("; webResourceError : ");
                if (webResourceError != null) {
                    str = ((Object) webResourceError.getDescription()) + " " + webResourceError.getErrorCode();
                } else {
                    str = null;
                }
                sb5.append(str);
                QMLog.d(BaseBrowserFragment.TAG, sb5.toString());
                BaseBrowserFragment baseBrowserFragment = BaseBrowserFragment.this;
                if (baseBrowserFragment.mCoreDumpData == null) {
                    baseBrowserFragment.mCoreDumpData = new ArrayMap<>(4);
                }
                BaseBrowserFragment.this.mCoreDumpData.put("errorCode", Integer.valueOf(webResourceError.getErrorCode()));
                BaseBrowserFragment.this.mCoreDumpData.put("errorMsg", webResourceError.getDescription());
                BaseBrowserFragment.this.mCoreDumpData.put(BrowserPlugin.KEY_REQUEST_URL, webResourceRequest.getUrl().toString());
                if (BaseBrowserFragment.this.mBrowserEngine == null || webResourceError.getErrorCode() < 400) {
                    return;
                }
                BaseBrowserFragment.this.mBrowserEngine.handleEvent(webView.getUrl(), 1L, BaseBrowserFragment.this.mCoreDumpData);
            }
        });
        BrowserPluginEngine browserPluginEngine = new BrowserPluginEngine(getActivity(), this.mWebView);
        this.mBrowserEngine = browserPluginEngine;
        browserPluginEngine.bindFragment(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSchemeUrl(String str) {
        if (!str.startsWith("mqqapi://") && !str.startsWith("weixin://") && !str.startsWith("sms://")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUrlBlank(String str) {
        if (!TextUtils.isEmpty(str) && !"about:blank;".equals(str) && !"about:blank".equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCoreDumpData(int i3, String str, String str2, String str3) {
        if (this.mCoreDumpData == null) {
            this.mCoreDumpData = new ArrayMap<>(4);
        }
        this.mCoreDumpData.put("errorCode", Integer.valueOf(i3));
        this.mCoreDumpData.put("errorMsg", str);
        this.mCoreDumpData.put(BrowserPlugin.KEY_REQUEST_URL, str2);
        BrowserPluginEngine browserPluginEngine = this.mBrowserEngine;
        if (browserPluginEngine != null && i3 >= 400) {
            browserPluginEngine.handleEvent(str3, 1L, this.mCoreDumpData);
        }
    }

    protected boolean needWebViewTranslucent() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mini_sdk_fragment_browser, viewGroup, false);
        if (inflate == null) {
            getActivity().finish();
        } else {
            if (DisplayUtil.isImmersiveSupported()) {
                inflate.setFitsSystemWindows(true);
            }
            Intent intent = getActivity().getIntent();
            if (intent == null) {
                getActivity().finish();
            } else {
                String stringExtra = intent.getStringExtra("url");
                if (StringUtil.isEmpty(stringExtra)) {
                    getActivity().finish();
                } else {
                    initView(intent, inflate);
                    initCookie(intent, stringExtra);
                    this.mWebView.loadUrl(stringExtra);
                    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
                    return inflate;
                }
            }
        }
        inflate = null;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BrowserPluginEngine browserPluginEngine = this.mBrowserEngine;
        if (browserPluginEngine != null) {
            browserPluginEngine.onDestroy();
            this.mBrowserEngine = null;
        }
    }
}
