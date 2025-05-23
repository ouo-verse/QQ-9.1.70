package com.tencent.mobileqq.webview.swift.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.smtt.sdk.ValueCallback;

/* compiled from: P */
/* loaded from: classes20.dex */
public class s {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements ValueCallback<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewProvider f314791a;

        a(WebViewProvider webViewProvider) {
            this.f314791a = webViewProvider;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewProvider);
            }
        }

        @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SwiftWebViewUtils", 2, "evaluateJavascript: " + str);
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str2 = "";
            } else {
                str2 = str.trim();
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.startsWith("\"")) {
                    str2 = str2.replaceFirst("\"", "");
                }
                if (str2.endsWith("\"")) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                bundle.putString("banner_wording", String.format(HardCodeUtil.qqStr(R.string.typ), str2));
            }
            s.d(bundle, this.f314791a);
        }
    }

    public static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("banner_webViewUrl");
        if (stringExtra.contains("minAIOFromMsgList")) {
            return;
        }
        intent.putExtra("banner_webViewUrl", stringExtra + "&minAIOFromMsgList=1");
    }

    public static Intent b(Bundle bundle, WebViewProvider webViewProvider) {
        String str;
        boolean z16;
        Bundle bundle2;
        if (bundle != null) {
            Intent intent = new Intent();
            Activity hostActivity = webViewProvider.getHostActivity();
            CustomWebView webView = webViewProvider.getWebView();
            String currentUrl = webViewProvider.getCurrentUrl();
            if (hostActivity == null) {
                return null;
            }
            intent.setComponent(SplashActivity.getAliasComponent(hostActivity));
            intent.setFlags(67108864);
            intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
            if (bundle.containsKey("banner_activityName")) {
                intent.putExtra("banner_activityName", bundle.getString("banner_activityName"));
            } else {
                intent.putExtra("banner_activityName", QQBrowserActivity.class.getName());
            }
            if (bundle.containsKey("banner_activityFlag")) {
                intent.putExtra("banner_activityFlag", bundle.getInt("banner_activityFlag"));
            }
            if (bundle.containsKey("banner_webViewUrl")) {
                intent.putExtra("banner_webViewUrl", bundle.getString("banner_webViewUrl"));
            } else if (!TextUtils.isEmpty(currentUrl)) {
                intent.putExtra("banner_webViewUrl", currentUrl);
            }
            if (bundle.containsKey("banner_wording")) {
                intent.putExtra("banner_wording", bundle.getString("banner_wording"));
            } else {
                String title = webView.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    str = title.trim();
                } else {
                    str = "";
                }
                String k3 = i.k(str);
                if (!"http".equals(k3) && !"https".equals(k3) && !"data".equals(k3) && !"file".equals(k3) && !str.startsWith("about") && !str.startsWith("base64")) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && str.length() > 1) {
                    intent.putExtra("banner_wording", String.format(HardCodeUtil.qqStr(R.string.f172922vk3), webView.getTitle()));
                } else {
                    intent.putExtra("banner_wording", HardCodeUtil.qqStr(R.string.f172923vk4));
                }
            }
            if (bundle.containsKey("banner_businessCategory")) {
                intent.putExtra("banner_businessCategory", bundle.getString("banner_businessCategory"));
            } else if (!TextUtils.isEmpty(currentUrl)) {
                Uri parse = Uri.parse(currentUrl);
                if (parse.isHierarchical()) {
                    intent.putExtra("banner_businessCategory", "WebView_" + parse.getHost());
                }
            }
            if (bundle.containsKey("banner_webview_extra")) {
                bundle2 = bundle.getBundle("banner_webview_extra");
            } else {
                bundle2 = new Bundle();
            }
            if (webView.getView() != null && webView.getView().getScrollY() > 0) {
                bundle2.putInt("AIO_Scroll_Y", webView.getView().getScrollY());
            }
            intent.putExtra("banner_webview_extra", bundle2);
            return intent;
        }
        QLog.e("WebViewJumpUtils", 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
        return null;
    }

    public static Bundle c(WebViewProvider webViewProvider) {
        Bundle bundle = new Bundle();
        Uri parse = Uri.parse(webViewProvider.getCurrentUrl());
        if (parse != null) {
            String host = parse.getHost();
            if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isKandianHost(host) || "buluo.qq.com".equalsIgnoreCase(host)) {
                webViewProvider.getWebView().evaluateJavascript("document.querySelector(\"meta[itemprop='name']\").getAttribute('content')", new a(webViewProvider));
                return null;
            }
        }
        return bundle;
    }

    public static final void d(Bundle bundle, WebViewProvider webViewProvider) {
        com.tencent.mobileqq.webview.swift.component.v vVar = (com.tencent.mobileqq.webview.swift.component.v) webViewProvider.getComponentProvider().a(2);
        if (vVar == null) {
            return;
        }
        if (vVar.f314512m.U && bundle != null) {
            Intent b16 = b(bundle, webViewProvider);
            if (b16 != null) {
                webViewProvider.getHostActivity().startActivity(b16);
                return;
            }
            return;
        }
        QLog.e(WebViewFragment.TAG, 1, "WebViewSwitchAio goToConversation call from illegal url or bundle is null, ignore.");
    }

    public static void e(WebViewProvider webViewProvider) {
        d(c(webViewProvider), webViewProvider);
    }

    public static void f(String str, int i3, String str2, String str3, WebViewProvider webViewProvider) {
        QLog.d("WebViewJumpUtils", 1, "WebViewSwitchAio gotoConversationForH5SDK " + str + "," + i3 + "," + str2 + "," + str3);
        if (!webViewProvider.getIntent().getBooleanExtra("from_single_task", false)) {
            QLog.e("WebViewJumpUtils", 1, "WebViewSwitchAio gotoConversationForH5SDK call from normal activity, ignore.");
            return;
        }
        Bundle a16 = com.tencent.mobileqq.emosm.a.a("ipc_qqbrowser_to_conversation", "", 0, null);
        a16.putInt("banner_msg", Conversation.MSG_GAME_BAR_SHOW);
        Bundle bundle = new Bundle();
        if (TextUtils.isEmpty(str)) {
            str = HardCodeUtil.qqStr(R.string.f172919vk0);
        }
        bundle.putString("tips", str);
        bundle.putString(MiniBoxNoticeInfo.KEY_ICON_URL, str2);
        bundle.putInt("icon", i3);
        bundle.putInt("timeout", 900000);
        bundle.putString("url", webViewProvider.getCurrentUrl());
        bundle.putString(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, str3);
        bundle.putInt(WadlProxyConsts.FLAGS, 335544320);
        a16.putBundle("barInfo", bundle);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(a16);
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(webViewProvider.getHostActivity()));
        intent.setFlags(335544320);
        intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        webViewProvider.getHostActivity().startActivity(intent);
    }
}
