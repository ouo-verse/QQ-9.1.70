package com.tencent.gdtad.basics.motivevideo.hippy.web;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ams.dsdk.view.webview.DKWebView;
import com.tencent.ams.dsdk.view.webview.DKWebViewLaunchMode;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes6.dex */
final class b extends AbsWebView implements m {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<GdtMotiveHippyWebView> f109031a;

    /* renamed from: b, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f109032b;

    /* renamed from: c, reason: collision with root package name */
    private CopyOnWriteArraySet<String> f109033c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f109034d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f109035e;

        a(Activity activity, Intent intent) {
            this.f109034d = activity;
            this.f109035e = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[createDialog][onClick] onConfirm");
            b.e(this.f109034d, this.f109035e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.hippy.web.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class DialogInterfaceOnClickListenerC1156b implements DialogInterface.OnClickListener {
        DialogInterfaceOnClickListenerC1156b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[createDialog][onClick] onCancel");
        }
    }

    public b(Context context, Activity activity, AppInterface appInterface, WeakReference<GdtMotiveHippyWebView> weakReference) {
        super(context, activity, appInterface);
        this.f109031a = weakReference;
        this.f109032b = new CopyOnWriteArraySet<>();
        this.f109033c = new CopyOnWriteArraySet<>();
    }

    private static Intent b(Uri uri) {
        Bundle bundle = new Bundle();
        bundle.putString("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, uri);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        return intent;
    }

    private static QQCustomDialog c(Activity activity, Intent intent) {
        if (activity == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[createDialog] error, activity is null");
            return null;
        }
        return DialogUtil.createCenterTextDialog(activity, 0, null, activity.getString(R.string.f213195pj), activity.getString(R.string.cancel), activity.getString(R.string.igh), new a(activity, intent), new DialogInterfaceOnClickListenerC1156b());
    }

    private DKWebView.DKWebViewEventListener d() {
        GdtMotiveHippyWebView gdtMotiveHippyWebView;
        WeakReference<GdtMotiveHippyWebView> weakReference = this.f109031a;
        if (weakReference != null) {
            gdtMotiveHippyWebView = weakReference.get();
        } else {
            gdtMotiveHippyWebView = null;
        }
        if (this.f109031a == null) {
            return null;
        }
        return gdtMotiveHippyWebView.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                context.startActivity(intent);
                return;
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[startActivity]", th5);
                return;
            }
        }
        QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[startActivity] error");
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void buildWebView(AppRuntime appRuntime) {
        super.buildBaseWebView(appRuntime);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    protected com.tencent.mobileqq.webview.swift.a myCommonJsPlugins() {
        return new com.tencent.gdtad.basics.motivevideo.hippy.web.a();
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f109033c.contains(str)) {
            QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[onPageFinished] do nothing, " + str);
            return;
        }
        DKWebView.DKWebViewEventListener d16 = d();
        if (d16 == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[onPageFinished] error, listener is null");
            return;
        }
        QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[onPageFinished]" + str);
        this.f109033c.add(str);
        d16.onPageFinished(str);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.f109032b.contains(str)) {
            QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[onPageStarted] do nothing, " + str);
            return;
        }
        DKWebView.DKWebViewEventListener d16 = d();
        if (d16 == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[onPageStarted] error, listener is null");
            return;
        }
        QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[onPageStarted]" + str);
        this.f109032b.add(str);
        d16.onPageStart(str);
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        super.onReceivedError(webView, i3, str, str2);
        DKWebView.DKWebViewEventListener d16 = d();
        if (d16 == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[onReceivedError] error, listener is null");
            return;
        }
        QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[onReceivedError] description: " + str + " error: " + i3 + " failingUrl:" + str2);
        d16.onReceivedError(i3, str2);
    }

    @Override // com.tencent.mobileqq.webview.util.m
    public void preInitWebviewPlugin() {
        super.preInitPluginEngine();
    }

    public void setWebView(TouchWebView touchWebView) {
        this.mWebview = touchWebView;
    }

    @Override // com.tencent.mobileqq.webview.AbsWebView
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        DKWebView.DKWebViewEventListener d16 = d();
        if (d16 == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, listener is null");
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (d16.shouldOverrideUrlLoading(str)) {
            QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] return true, listener return true");
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, url is empty");
            return super.shouldOverrideUrlLoading(webView, str);
        }
        GdtMotiveHippyWebView gdtMotiveHippyWebView = null;
        try {
            uri = Uri.parse(str);
        } catch (Throwable th5) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading]", th5);
            uri = null;
        }
        if (uri == null) {
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, uri is null");
            return super.shouldOverrideUrlLoading(webView, str);
        }
        String scheme = uri.getScheme();
        if (!"http".equals(scheme) && !"https".equals(scheme) && !"data".equals(scheme) && !"file".equals(scheme)) {
            if (!AuthorizeConfig.y().G(webView.getUrl(), scheme).booleanValue()) {
                QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] return false, has no jump right, uriScheme:" + scheme + " url:" + str);
                return super.shouldOverrideUrlLoading(webView, str);
            }
            Intent b16 = b(uri);
            WeakReference<GdtMotiveHippyWebView> weakReference = this.f109031a;
            if (weakReference != null) {
                gdtMotiveHippyWebView = weakReference.get();
            }
            if (gdtMotiveHippyWebView == null) {
                QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, hippyWebView is null");
                return super.shouldOverrideUrlLoading(webView, str);
            }
            int s16 = gdtMotiveHippyWebView.s();
            com.tencent.gdtad.basics.motivevideo.report.a.o("GdtMotiveHippyWebViewBuilder", "[shouldOverrideUrlLoading] launchMode:" + s16 + " uriScheme:" + scheme + " url:" + str, AdMetricID.Reward.HIPPY_WEB_START_ACTIVITY, null, AdMetricTag.Reward.LAUNCH_MODE, String.valueOf(s16));
            GdtAnalysisHelperForMotiveAd.s(this.mContext, s16);
            if (s16 == DKWebViewLaunchMode.LAUNCH_WITH_CONFIRMATION) {
                Context context = this.mContext;
                if (!(context instanceof Activity)) {
                    QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, mContext not instanceof Activity");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, activity is finishing");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                if (AdAppUtil.resolveActivity(activity, b16) == null) {
                    QLog.i("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] return false, resolveInfo is null");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                QQCustomDialog c16 = c(activity, b16);
                if (c16 == null) {
                    QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, dialog is null");
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                c16.show();
                return true;
            }
            if (s16 == DKWebViewLaunchMode.LAUNCH_WITHOUT_CONFIRMATION) {
                e(this.mContext, b16);
                return true;
            }
            if (s16 == DKWebViewLaunchMode.LAUNCH_NOT_ALLOWED) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, launchMode:" + s16 + " uriScheme:" + scheme + " url:" + str);
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (webView instanceof CustomWebView) {
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine != null && pluginEngine.s(str, 16L, null)) {
                return true;
            }
            return false;
        }
        QLog.e("GdtMotiveHippyWebViewBuilder", 1, "[shouldOverrideUrlLoading] error, webview not instanceof CustomWebView");
        return super.shouldOverrideUrlLoading(webView, str);
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
