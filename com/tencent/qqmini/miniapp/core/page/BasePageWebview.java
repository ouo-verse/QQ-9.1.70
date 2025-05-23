package com.tencent.qqmini.miniapp.core.page;

import android.content.Context;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqmini.miniapp.core.page.c;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

/* loaded from: classes23.dex */
public class BasePageWebview extends QmX5Webview implements c {
    public static volatile int PAGE_WEBVIEW_ID_FACTORY = 0;
    private static final String TAG = "BasePageWebview";
    private AppBrandPageContainer mAppBrandPageContainer;
    protected PageEventListener mPageEventListener;
    protected int mPageWebviewId;
    protected int scrollY;
    public ArrayList<c.a> webviewScrollListenerList;

    public BasePageWebview(Context context, AppBrandPageContainer appBrandPageContainer) {
        super(context);
        this.mAppBrandPageContainer = appBrandPageContainer;
        this.mPageWebviewId = generatedWebViewId();
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        WebView.setWebContentsDebuggingEnabled(true);
        settings.setMixedContentMode(0);
        settings.setUserAgent(settings.getUserAgentString() + "QQ/MiniApp");
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        try {
            if (getSettingsExtension() != null) {
                getSettingsExtension().setFirstScreenDetect(false);
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "BasePageWebview init exception!", th5);
        }
        AppBrandPageContainer appBrandPageContainer2 = this.mAppBrandPageContainer;
        if (appBrandPageContainer2 != null) {
            appBrandPageContainer2.aliveWebViewCount++;
        }
    }

    public static int generatedWebViewId() {
        int i3 = PAGE_WEBVIEW_ID_FACTORY + 1;
        PAGE_WEBVIEW_ID_FACTORY = i3;
        return i3;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void destroy() {
        super.destroy();
        if (this.mAppBrandPageContainer != null) {
            r0.aliveWebViewCount--;
        }
    }

    public int getPageWebViewId() {
        return this.mPageWebviewId;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.c
    public int getSavedScrollY() {
        return this.scrollY;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.c
    public boolean handleBackPressed() {
        return false;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.c
    public void removeWebviewScrollListener(c.a aVar) {
        ArrayList<c.a> arrayList = this.webviewScrollListenerList;
        if (arrayList != null && arrayList.contains(aVar)) {
            this.webviewScrollListenerList.remove(aVar);
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.page.c
    public void saveScrollY(int i3) {
        this.scrollY = i3;
    }

    @Override // com.tencent.qqmini.miniapp.core.page.c
    public void setOnWebviewScrollListener(c.a aVar) {
        if (this.webviewScrollListenerList == null) {
            this.webviewScrollListenerList = new ArrayList<>();
        }
        this.webviewScrollListenerList.add(aVar);
    }

    public void setPageEventListener(PageEventListener pageEventListener) {
        this.mPageEventListener = pageEventListener;
    }
}
