package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class AppBrandPage extends AbsAppBrandPage implements PageWebview.PageWebViewListener {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AppBrandPage";
    private FrameLayout centerLayout;
    public FrameLayout fullScreenLayout;
    boolean isInitReady;
    private String mUrl;
    private LinearLayout rootView;
    private TabBarView tabView;
    private g toastView;
    private Map webViewMap;

    public AppBrandPage(Context context, AppBrandPageContainer appBrandPageContainer) {
        super(context, appBrandPageContainer);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) appBrandPageContainer);
        } else {
            appBrandPageContainer.fullScreenLayout = this.fullScreenLayout;
            this.webViewMap = new HashMap();
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void cleanup() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Iterator it = this.webViewMap.entrySet().iterator();
        while (it.hasNext()) {
            ((WebviewContainer) ((Map.Entry) it.next()).getValue()).destroy();
            it.remove();
        }
        this.rootView = null;
        this.mUrl = null;
        this.isInitReady = false;
        super.cleanup();
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public View createContentView() {
        k kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "createContentView apkgInfo=" + this.apkgInfo$5475ea27);
        }
        if (this.rootView == null && (kVar = this.apkgInfo$5475ea27.f245821b.f246136h) != null) {
            this.tabView.a(kVar);
            this.tabView.a(this.appBrandPageContainer);
            "top".equals(this.apkgInfo$5475ea27.f245821b.f246136h.f245868e);
        }
        return this.rootView;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public FrameLayout getCenterLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.centerLayout;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public PageWebview getCurrentPageWebview() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (PageWebview) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            return getWebView(this.mUrl);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public WebviewContainer getCurrentWebviewContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (WebviewContainer) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return (WebviewContainer) this.webViewMap.get(this.mUrl);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public TabBarView getTabBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TabBarView) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.tabView;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mUrl;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public PageWebview getWebView(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (PageWebview) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        WebviewContainer webviewContainer = (WebviewContainer) this.webViewMap.get(str);
        if (webviewContainer != null) {
            return webviewContainer.getPageWebview();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void hideToastView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hideToastView toastView=" + this.toastView);
        }
        g gVar = this.toastView;
        if (gVar != null) {
            gVar.a();
            this.toastView = null;
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public boolean isHomePage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.apkgInfo$5475ea27.i(this.mUrl);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public boolean isTabPage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.apkgInfo$5475ea27.h(this.mUrl);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void loadUrl(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str.equals(this.mUrl)) {
            onAppRoute(str2, str);
            return;
        }
        this.mUrl = str;
        if (!this.webViewMap.containsKey(str)) {
            this.appBrandPageContainer.appBrandRuntime.f245904i.loadAppServiceJs(str);
            PageWebview b16 = h.a().b(this.apkgInfo$5475ea27.f245823d);
            c cVar = this.apkgInfo$5475ea27;
            b16.apkgInfo$5475ea27 = cVar;
            a aVar = this.appBrandPageContainer.appBrandRuntime;
            b16.appBrandRuntime = aVar;
            b16.eventListener = aVar.f245903h;
            b16.openType = str2;
            b16.mRouteUrl = str;
            b16.listener = this;
            b16.loadPageWebviewJs$164d4c8c(cVar);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "loadUrl put webViewContainer url=" + str);
            }
        } else {
            for (Map.Entry entry : this.webViewMap.entrySet()) {
                WebviewContainer webviewContainer = (WebviewContainer) entry.getValue();
                if (((String) entry.getKey()).equals(str)) {
                    webviewContainer.setVisibility(0);
                    onAppRoute(str2, str);
                } else {
                    webviewContainer.setVisibility(8);
                }
            }
        }
        int pageCount = this.appBrandPageContainer.getPageCount();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "loadUrl url=" + str + ",pageCnt=" + pageCount);
        }
        if (isTabPage()) {
            this.tabView.setVisibility(0);
            this.tabView.a(str);
        } else {
            TabBarView tabBarView = this.tabView;
            if (tabBarView != null) {
                tabBarView.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void notifyChangePullDownRefreshStyle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Iterator it = this.webViewMap.entrySet().iterator();
        while (it.hasNext()) {
            ((WebviewContainer) ((Map.Entry) it.next()).getValue()).notifyChangePullDownRefreshStyle();
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void onAppRoute(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) str2);
        } else {
            super.onAppRoute(str, str2);
            reportPageVisit(str2);
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void onPageBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onPageBackground();
        if (getCurrentWebviewContainer() != null) {
            getCurrentWebviewContainer().onVideoPlayerPause();
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void onPageForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onPageForeground();
        if (getCurrentWebviewContainer() != null) {
            getCurrentWebviewContainer().onVideoPlayerResume();
        }
    }

    public void onSwipeFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.appBrandPageContainer.navigateBack(1, true);
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.PageWebview.PageWebViewListener
    public void onWebViewReady(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        } else {
            onAppRoute(str, str2);
        }
    }

    public void reportPageVisit(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else if (this.appBrandPageContainer.appBrandRuntime.f245907l != -1) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", c.n(str));
            } catch (Throwable unused) {
            }
            VACDReportUtil.addReportItem(this.appBrandPageContainer.appBrandRuntime.f245907l, (String) null, "PageVisit", jSONObject.toString(), 0, (String) null);
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void showToastView(String str, String str2, CharSequence charSequence, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, charSequence, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showToastView toastView=" + this.toastView);
        }
        this.toastView.a(str, str2, charSequence, i3, z16);
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public void stopPullDownRefresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        Iterator it = this.webViewMap.entrySet().iterator();
        while (it.hasNext()) {
            ((WebviewContainer) ((Map.Entry) it.next()).getValue()).stopPullDownRefresh();
        }
    }

    @Override // com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
    public PageWebview getWebView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (PageWebview) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        Iterator it = this.webViewMap.values().iterator();
        while (it.hasNext()) {
            PageWebview pageWebview = ((WebviewContainer) it.next()).getPageWebview();
            if (pageWebview != null && pageWebview.pageWebviewId == i3) {
                return pageWebview;
            }
        }
        return null;
    }
}
