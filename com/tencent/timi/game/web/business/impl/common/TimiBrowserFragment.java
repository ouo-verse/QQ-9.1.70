package com.tencent.timi.game.web.business.impl.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.timi.game.liveroom.impl.room.match.TGLiveMatchWebViewFragment;
import com.tencent.timi.game.liveroom.impl.room.match.TGLiveTabLoadingView;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.web.business.api.race.LivingRaceNativeEvent;
import com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TimiBrowserFragment extends WebViewFragment {
    private boolean C;
    protected TGLiveTabLoadingView D;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            super.loadUrlFinish();
            l.b("TimiBrowserFragment_", "onPageFinished ");
            TimiBrowserFragment.this.getUIStyleHandler().f314512m.A = true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            TimiBrowserFragment timiBrowserFragment = TimiBrowserFragment.this;
            timiBrowserFragment.qh(timiBrowserFragment.getContentView());
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle bundle) {
            super.onInitUIContent(bundle);
            TimiBrowserFragment.this.initView();
            TimiBrowserFragment timiBrowserFragment = TimiBrowserFragment.this;
            timiBrowserFragment.rh(timiBrowserFragment.getContentView());
            TimiBrowserFragment.this.yh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            l.b("TimiBrowserFragment_", "onPageFinished " + str);
            TimiBrowserFragment.this.hideLoading();
            webView.postInvalidate();
            if (!(TimiBrowserFragment.this instanceof TGLiveMatchWebViewFragment)) {
                pi4.a.f426276a.c();
            }
            TimiBrowserFragment timiBrowserFragment = TimiBrowserFragment.this;
            timiBrowserFragment.sh(timiBrowserFragment.getContentView(), webView);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            l.b("TimiBrowserFragment_", "onReceivedError ");
            TimiBrowserFragment.this.hideLoading();
            TimiBrowserFragment timiBrowserFragment = TimiBrowserFragment.this;
            timiBrowserFragment.th(timiBrowserFragment.getContentView(), webView, i3, str, str2);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            boolean onReceivedSslError = super.onReceivedSslError(webView, sslErrorHandler, sslError);
            l.b("TimiBrowserFragment_", "onReceivedSslError ");
            TimiBrowserFragment.this.hideLoading();
            TimiBrowserFragment timiBrowserFragment = TimiBrowserFragment.this;
            timiBrowserFragment.uh(timiBrowserFragment.getContentView(), webView);
            return onReceivedSslError;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(Bundle bundle) {
            super.onShowPreview(bundle);
            Activity hostActivity = TimiBrowserFragment.this.getHostActivity();
            if ((hostActivity instanceof TimiBrowserActivity) && ((TimiBrowserActivity) hostActivity).V2()) {
                TimiBrowserFragment.this.getUIStyle().f314634q = Boolean.TRUE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WebView f380332d;

        b(WebView webView) {
            this.f380332d = webView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.timi.game.liveroom.impl.room.util.b.a()) {
                this.f380332d.reload();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void vh(boolean z16) {
        WebViewPluginEngine pluginEngine;
        if (getWebView() == null || (pluginEngine = getWebView().getPluginEngine()) == null) {
            return;
        }
        pluginEngine.D(new String[]{"timiEsports"});
        LivingInscriptionWebPlugin livingInscriptionWebPlugin = (LivingInscriptionWebPlugin) pluginEngine.n("timiEsports", true);
        if (livingInscriptionWebPlugin == null) {
            return;
        }
        if (z16) {
            livingInscriptionWebPlugin.m0(new LivingRaceNativeEvent("live_trigge_race_model_type", "TAB_CHANGED"));
        }
        livingInscriptionWebPlugin.w0(!z16);
        l.i("TimiBrowserFragment_", "sendTabSelectedEvent");
    }

    private void wh(WebView webView) {
        this.D.setIcon(R.drawable.o96);
        this.D.setTip("\u52a0\u8f7d\u5931\u8d25");
        this.D.setBtn("\u91cd\u8bd5", new b(webView));
    }

    private void xh() {
        this.D.setIcon(R.drawable.o95);
        this.D.setTip("\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e");
        this.D.setBtn("", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (!this.C) {
            FragmentActivity activity = getActivity();
            if (activity instanceof TimiBrowserActivity) {
                ((TimiBrowserActivity) activity).Y2();
                this.C = true;
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    protected void hideLoading() {
        FragmentActivity activity = getActivity();
        if (activity instanceof TimiBrowserActivity) {
            ((TimiBrowserActivity) activity).hideLoading();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        getWebTitleBarInterface().u5(false);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.getWindow().setBackgroundDrawableResource(R.color.ajr);
        }
        getUIStyleHandler().T.setVisibility(8);
        getUIStyleHandler().f314500b0.setVisibility(8);
        ViewGroup viewGroup = getUIStyleHandler().S;
        if (viewGroup instanceof RefreshView) {
            ((RefreshView) viewGroup).a(false);
        }
        if (this.webView.getX5WebViewExtension() != null) {
            try {
                this.webView.getView().setBackgroundColor(0);
                this.webView.setBackgroundColor(0);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        this.webView.setBackgroundColor(0);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setBackgroundColor(0);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh(WebBrowserViewContainerKt webBrowserViewContainerKt) {
        if (this.D == null) {
            TGLiveTabLoadingView tGLiveTabLoadingView = new TGLiveTabLoadingView(webBrowserViewContainerKt.getContext());
            this.D = tGLiveTabLoadingView;
            tGLiveTabLoadingView.setWhiteMode();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 16;
            this.D.setLayoutParams(layoutParams);
            webBrowserViewContainerKt.c().addView(this.D);
            xh();
            getWebView().setVisibility(4);
            this.D.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        super.setUserVisibleHint(z16);
        l.i("TimiBrowserFragment_", "setUserVisibleHint == " + z16);
        vh(z16);
    }

    protected void sh(WebBrowserViewContainerKt webBrowserViewContainerKt, WebView webView) {
        getWebView().setVisibility(0);
        TGLiveTabLoadingView tGLiveTabLoadingView = this.D;
        if (tGLiveTabLoadingView != null) {
            tGLiveTabLoadingView.setVisibility(8);
        }
    }

    public void th(WebBrowserViewContainerKt webBrowserViewContainerKt, WebView webView, int i3, String str, String str2) {
        if (this.D != null) {
            webView.setVisibility(4);
            wh(webView);
            this.D.setVisibility(0);
        }
    }

    protected void uh(WebBrowserViewContainerKt webBrowserViewContainerKt, WebView webView) {
        if (this.D != null) {
            webView.setVisibility(4);
            wh(webView);
            this.D.setVisibility(0);
        }
    }

    protected void qh(WebBrowserViewContainerKt webBrowserViewContainerKt) {
    }
}
