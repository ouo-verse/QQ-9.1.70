package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class ReadInJoyWebRenderPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<WebView> f97417d;

    /* renamed from: e, reason: collision with root package name */
    private AppInterface f97418e;

    /* renamed from: f, reason: collision with root package name */
    private String f97419f;

    /* renamed from: i, reason: collision with root package name */
    private String f97421i;

    /* renamed from: h, reason: collision with root package name */
    private boolean f97420h = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f97422m = false;

    private String r(String str) {
        return "";
    }

    private void s(String str, String str2, Map<String, Object> map) {
        if (this.f97420h) {
            return;
        }
        String r16 = r(str);
        if (!TextUtils.isEmpty(r16)) {
            this.mRuntime.e().loadDataWithBaseURL(str, r16, "text/html", "utf-8", str);
            this.f97420h = true;
            t(false);
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache on eventType : " + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render load renderHtmlData data cache renderResult is empty on eventType:" + str2);
        }
    }

    private void t(boolean z16) {
        WebViewFragment q16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        Activity a16 = bVar.a();
        if (!(a16 instanceof QBaseActivity) || (q16 = q((QBaseActivity) a16)) == null || q16.getUIStyleHandler() == null) {
            return;
        }
        if (q16.getUIStyleHandler().U != null) {
            q16.getUIStyleHandler().f314499a0 = !z16;
            q16.getUIStyleHandler().U.l(z16);
        } else {
            q16.getUIStyleHandler().f314499a0 = !z16;
        }
    }

    private Boolean v(String str) {
        if (TextUtils.isEmpty(this.f97421i)) {
            return Boolean.FALSE;
        }
        g.a b16 = com.tencent.mobileqq.webview.swift.utils.g.b(this.f97421i);
        if (b16 != null && !TextUtils.isEmpty(b16.f314753b)) {
            this.mRuntime.e().loadDataWithBaseURL(str, b16.f314753b, "text/html", "utf-8", str);
            this.f97420h = true;
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data with cache transUrl = " + this.f97421i);
            }
            return Boolean.TRUE;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ReadInJoyWebRenderPlugin", 2, "native_render  shouldOfflineIntercept offline data no cache transUrl = " + this.f97421i);
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "readInJoyWebRender";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (!u(str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyWebRenderPlugin", 2, "native_render handleEvent type: " + j3 + "; timeStamp: " + System.currentTimeMillis() + "; isRender: " + this.f97420h + "; url:" + str);
        }
        if (j3 == 32) {
            s(str, "KEY_EVENT_BEFORE_LOAD", map);
            if (!((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getCanLoadStartWebRenderModeConfig() && !this.f97420h) {
                return v(str).booleanValue();
            }
            return this.f97420h;
        }
        if (j3 == 8589934593L && ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getCanLoadStartWebRenderModeConfig()) {
            s(str, "EVENT_LOAD_START", map);
            if (!this.f97420h) {
                return v(str).booleanValue();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        WebViewFragment q16;
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            AppInterface b16 = bVar.b();
            this.f97418e = b16;
            this.f97419f = b16.getAccount();
            this.f97422m = ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getWebRenderConfig();
        }
        WebViewPlugin.b bVar2 = this.mRuntime;
        if (bVar2 == null || !this.f97422m) {
            return;
        }
        Activity a16 = bVar2.a();
        if (!(a16 instanceof QBaseActivity) || (q16 = q((QBaseActivity) a16)) == null) {
            return;
        }
        String currentUrl = q16.getCurrentUrl();
        String queryParameter = Uri.parse(currentUrl).getQueryParameter("_pbid");
        if (TextUtils.isEmpty(currentUrl) || TextUtils.isEmpty(queryParameter)) {
            return;
        }
        this.f97421i = HtmlOffline.b(currentUrl, "_bid=" + queryParameter);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.webviewplugin.ReadInJoyWebRenderPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(ReadInJoyWebRenderPlugin.this.f97421i)) {
                    return;
                }
                com.tencent.mobileqq.webview.swift.utils.g.e(ReadInJoyWebRenderPlugin.this.f97421i);
            }
        }, 5, null, true);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f97417d = new WeakReference<>(this.mRuntime.e());
    }

    public WebViewFragment q(QBaseActivity qBaseActivity) {
        List<Fragment> fragments;
        FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
        if (supportFragmentManager == null || (fragments = supportFragmentManager.getFragments()) == null || fragments.size() <= 0) {
            return null;
        }
        for (Fragment fragment : fragments) {
            if (fragment instanceof WebViewFragment) {
                return (WebViewFragment) fragment;
            }
        }
        return null;
    }

    public boolean u(String str) {
        if (!((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).getWebRenderConfig()) {
            if (QLog.isColorLevel()) {
                QLog.d("ReadInJoyWebRenderPlugin", 2, "native_render shouldIntercept  getWebRenderConfig false");
            }
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            String host = url.getHost();
            String path = url.getPath();
            Uri parse = Uri.parse(str);
            if (parse == null || !parse.isHierarchical()) {
                return false;
            }
            String queryParameter = parse.getQueryParameter("_prenr");
            String queryParameter2 = parse.getQueryParameter("_pbid");
            if (!"kandian.qq.com".equalsIgnoreCase(host) || TextUtils.isEmpty(path) || TextUtils.isEmpty(queryParameter2) || !path.endsWith(".html")) {
                return false;
            }
            return "1".equals(queryParameter);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
