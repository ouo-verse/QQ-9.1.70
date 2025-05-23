package com.tencent.gdtad.api.halfscreen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.ams.fusion.widget.utils.IFusionWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.api.halfscreen.h;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.m;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
final class h implements IFusionWebView {

    /* renamed from: a, reason: collision with root package name */
    private TouchWebView f108570a;

    /* renamed from: b, reason: collision with root package name */
    private a f108571b;

    public h(Context context) {
        Activity activity;
        AppRuntime appRuntime;
        AppRuntime appRuntime2;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            GdtLog.e("GdtHalfScreenDownloadWebViewImpl", "[GdtHalfScreenDownloadWebViewImpl]: activity is null");
            return;
        }
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime != null) {
            appRuntime2 = appRuntime.getAppRuntime("modular_web");
        } else {
            appRuntime2 = null;
        }
        if (!(appRuntime2 instanceof AppInterface)) {
            GdtLog.e("GdtHalfScreenDownloadWebViewImpl", "[GdtHalfScreenDownloadWebViewImpl]: peekAppRuntime wrong value");
            return;
        }
        TouchWebView touchWebView = new TouchWebView(context);
        this.f108570a = touchWebView;
        touchWebView.setDayOrNight(!QQTheme.isNowThemeIsNight());
        a aVar = new a(activity, activity, (AppInterface) appRuntime2);
        this.f108571b = aVar;
        aVar.setWebView(this.f108570a);
        new m(this.f108571b).a(null, appRuntime, activity.getIntent());
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public void destroy() {
        a aVar = this.f108571b;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public View getView() {
        return this.f108570a;
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public void loadUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            GdtLog.e("GdtHalfScreenDownloadWebViewImpl", "[loadUrl]: url is empty");
            return;
        }
        TouchWebView touchWebView = this.f108570a;
        if (touchWebView == null) {
            GdtLog.e("GdtHalfScreenDownloadWebViewImpl", "[loadUrl]: mWebView is null");
        } else {
            touchWebView.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a extends AbsWebView implements com.tencent.mobileqq.webview.util.m {
        public a(Context context, Activity activity, AppInterface appInterface) {
            super(context, activity, appInterface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            super.doOnDestroy();
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildWebView(AppRuntime appRuntime) {
            super.buildBaseWebView(appRuntime);
        }

        public void onDestroy() {
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.api.halfscreen.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.a.this.b();
                }
            }, AbsWebView.TAG, "doOnDestroy");
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void preInitWebviewPlugin() {
            super.preInitPluginEngine();
        }

        public void setWebView(TouchWebView touchWebView) {
            this.mWebview = touchWebView;
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildBottomBar() {
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildData() {
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildLayout() {
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildTitleBar() {
        }

        @Override // com.tencent.mobileqq.webview.util.m
        public void buildContentView(Bundle bundle) {
        }
    }
}
