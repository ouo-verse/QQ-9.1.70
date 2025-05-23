package com.tencent.mobileqq.qwallet.home;

import android.graphics.Bitmap;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bJ\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/af;", "", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "i", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "c", "", "url", "Lkotlin/Function1;", "", "callback", "d", tl.h.F, "g", "f", "e", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "a", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "getFragment", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "fragment", "Lcom/tencent/mobileqq/qwallet/home/report/d;", "b", "Lcom/tencent/mobileqq/qwallet/home/report/d;", "()Lcom/tencent/mobileqq/qwallet/home/report/d;", "techReporter", "Lcom/tencent/mobileqq/qwallet/home/NoTouchWebView;", "Lcom/tencent/mobileqq/qwallet/home/NoTouchWebView;", "Lkotlin/jvm/functions/Function1;", "loadFinishCallback", "<init>", "(Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;Lcom/tencent/mobileqq/qwallet/home/report/d;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class af {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletHomeFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qwallet.home.report.d techReporter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private NoTouchWebView webView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> loadFinishCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qwallet/home/af$b", "Lcom/tencent/mobileqq/qwallet/home/ae;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "", "onPageStarted", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ae {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TouchWebView f278015d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ af f278016e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(TouchWebView touchWebView, AppRuntime appRuntime, af afVar, QBaseActivity qBaseActivity) {
            super(qBaseActivity, touchWebView, appRuntime);
            this.f278015d = touchWebView;
            this.f278016e = afVar;
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            this.f278015d.setForeground(null);
            Function1 function1 = this.f278016e.loadFinishCallback;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            this.f278016e.getTechReporter().l();
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            this.f278015d.setForeground(null);
            Function1 function1 = this.f278016e.loadFinishCallback;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }

    public af(@NotNull QWalletHomeFragment fragment, @NotNull com.tencent.mobileqq.qwallet.home.report.d techReporter) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(techReporter, "techReporter");
        this.fragment = fragment;
        this.techReporter = techReporter;
    }

    private final void i(TouchWebView webView) {
        int i3;
        if (this.fragment.Oh().getIsNightMode()) {
            i3 = R.drawable.f162131nv2;
        } else {
            i3 = R.drawable.fs7;
        }
        webView.setForeground(ContextCompat.getDrawable(this.fragment.getQBaseActivity(), i3));
        AppRuntime qWalletRuntime = this.fragment.getQWalletRuntime();
        new com.tencent.mobileqq.webview.m(new b(webView, qWalletRuntime, this, this.fragment.getQBaseActivity())).a(null, qWalletRuntime, null);
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.qwallet.home.report.d getTechReporter() {
        return this.techReporter;
    }

    public final void c(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.zrz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.no_touch_web_view)");
        NoTouchWebView noTouchWebView = (NoTouchWebView) findViewById;
        this.webView = noTouchWebView;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        i(noTouchWebView);
    }

    public final void d(@Nullable String url, @Nullable Function1<? super Boolean, Unit> callback) {
        NoTouchWebView noTouchWebView = this.webView;
        NoTouchWebView noTouchWebView2 = null;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        boolean z16 = true;
        QLog.d("QWalletHomeFragment-webview", 1, "addDataObservers: url " + url + ", old url " + noTouchWebView.getUrl());
        this.loadFinishCallback = callback;
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_HOME_CHECK_URL_DIFF, false);
        if (url != null && url.length() != 0) {
            z16 = false;
        }
        if (z16) {
            NoTouchWebView noTouchWebView3 = this.webView;
            if (noTouchWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                noTouchWebView2 = noTouchWebView3;
            }
            noTouchWebView2.setVisibility(8);
            return;
        }
        if (isSwitchOn) {
            NoTouchWebView noTouchWebView4 = this.webView;
            if (noTouchWebView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                noTouchWebView4 = null;
            }
            if (Intrinsics.areEqual(url, noTouchWebView4.getUrl())) {
                return;
            }
        }
        this.techReporter.p();
        NoTouchWebView noTouchWebView5 = this.webView;
        if (noTouchWebView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView5 = null;
        }
        noTouchWebView5.setVisibility(0);
        NoTouchWebView noTouchWebView6 = this.webView;
        if (noTouchWebView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            noTouchWebView2 = noTouchWebView6;
        }
        noTouchWebView2.loadUrl(url);
    }

    public final void e() {
        NoTouchWebView noTouchWebView = this.webView;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        WebViewPluginEngine pluginEngine = noTouchWebView.getPluginEngine();
        if (pluginEngine != null) {
            pluginEngine.H();
        }
        noTouchWebView.setPluginEngine(null);
        noTouchWebView.destroy();
    }

    public final void f() {
        NoTouchWebView noTouchWebView = this.webView;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        noTouchWebView.onPause();
        NoTouchWebView noTouchWebView2 = this.webView;
        if (noTouchWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView2 = null;
        }
        WebViewPluginEngine pluginEngine = noTouchWebView2.getPluginEngine();
        if (pluginEngine != null) {
            NoTouchWebView noTouchWebView3 = this.webView;
            if (noTouchWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                noTouchWebView3 = null;
            }
            pluginEngine.s(noTouchWebView3.getUrl(), 8589934597L, null);
        }
    }

    public final void g() {
        NoTouchWebView noTouchWebView = this.webView;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        noTouchWebView.onResume();
        NoTouchWebView noTouchWebView2 = this.webView;
        if (noTouchWebView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView2 = null;
        }
        WebViewPluginEngine pluginEngine = noTouchWebView2.getPluginEngine();
        if (pluginEngine != null) {
            NoTouchWebView noTouchWebView3 = this.webView;
            if (noTouchWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                noTouchWebView3 = null;
            }
            pluginEngine.s(noTouchWebView3.getUrl(), 2L, null);
        }
    }

    public final boolean h() {
        NoTouchWebView noTouchWebView = this.webView;
        NoTouchWebView noTouchWebView2 = null;
        if (noTouchWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            noTouchWebView = null;
        }
        if (noTouchWebView.getVisibility() == 0) {
            NoTouchWebView noTouchWebView3 = this.webView;
            if (noTouchWebView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            } else {
                noTouchWebView2 = noTouchWebView3;
            }
            noTouchWebView2.reload();
            return true;
        }
        return false;
    }
}
