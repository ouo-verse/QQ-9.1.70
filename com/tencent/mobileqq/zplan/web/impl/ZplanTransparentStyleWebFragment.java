package com.tencent.mobileqq.zplan.web.impl;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebCloseEvent;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebCloseSplashAdEvent;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebPageLoadFinishedEvent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010$\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"\u0018\u00010!j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"\u0018\u0001`#H\u0016J\u0012\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\rJ\u0018\u0010.\u001a\u00020\u00042\u0006\u0010+\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010,R\u0018\u00101\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00106R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZplanTransparentStyleWebFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Gh", "Ih", "Ah", "Lcom/tencent/biz/ui/TouchWebView;", "touchWebView", "Ch", "Bh", "showLoadingView", "", "isMax", "Jh", "Fh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "viewGroup", "Eh", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "webView", "setWebView", "", "url", "needFinishFromJs", "Dh", "methodName", "Lorg/json/JSONObject;", "params", "yh", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "loadingView", "D", "Landroid/view/ViewGroup;", "viewContainer", "E", "Z", "isReloading", UserInfo.SEX_FEMALE, "G", "needSilentLoad", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "hideLoadingRunnable", "<init>", "()V", "I", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanTransparentStyleWebFragment extends WebViewFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup viewContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isReloading;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean needFinishFromJs;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needSilentLoad;

    /* renamed from: H, reason: from kotlin metadata */
    private final Runnable hideLoadingRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.i
        @Override // java.lang.Runnable
        public final void run() {
            ZplanTransparentStyleWebFragment.zh(ZplanTransparentStyleWebFragment.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZplanTransparentStyleWebFragment$a;", "", "", "url", "", "needFinishFromJs", "needSilentLoad", "Lcom/tencent/mobileqq/zplan/web/impl/ZplanTransparentStyleWebFragment;", "a", "KEY_NEED_FINISH_FROM_JS", "Ljava/lang/String;", "KEY_NEED_SILENT_LOAD", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.web.impl.ZplanTransparentStyleWebFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZplanTransparentStyleWebFragment a(String url, boolean needFinishFromJs, boolean needSilentLoad) {
            Intrinsics.checkNotNullParameter(url, "url");
            ZplanTransparentStyleWebFragment zplanTransparentStyleWebFragment = new ZplanTransparentStyleWebFragment();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.putExtra("url", url);
            Unit unit = Unit.INSTANCE;
            bundle.putParcelable("intent", intent);
            bundle.putBoolean("need_finish_from_js", needFinishFromJs);
            bundle.putBoolean("need_silent_load", needSilentLoad);
            zplanTransparentStyleWebFragment.setArguments(bundle);
            return zplanTransparentStyleWebFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u001a\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/mobileqq/zplan/web/impl/ZplanTransparentStyleWebFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onShowPreview", "onFinalState", "onInitUIContent", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "newProgress", "onProgressChanged", "", "url", "onPageFinished", "Lcom/tencent/smtt/export/external/interfaces/SslErrorHandler;", "handler", "Lcom/tencent/smtt/export/external/interfaces/SslError;", "error", "", "onReceivedSslError", "errorCode", "description", "failingUrl", "onReceivedError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            super.loadUrlFinish();
            ZplanTransparentStyleWebFragment.this.getUIStyleHandler().f314512m.A = true;
            ZplanTransparentStyleWebFragment.this.getUIStyleHandler().f314512m.f314619b = true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle extraData) {
            super.onFinalState(extraData);
            QLog.d("ZpanTranspareWebFragmet_", 1, "onFinalState");
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle extraData) {
            super.onInitUIContent(extraData);
            ZplanTransparentStyleWebFragment zplanTransparentStyleWebFragment = ZplanTransparentStyleWebFragment.this;
            TouchWebView webView = ((WebViewFragment) zplanTransparentStyleWebFragment).webView;
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            zplanTransparentStyleWebFragment.Ch(webView);
            ZplanTransparentStyleWebFragment.this.Bh();
            QLog.d("ZpanTranspareWebFragmet_", 1, "initUiContent " + extraData);
            TouchWebView touchWebView = ((WebViewFragment) ZplanTransparentStyleWebFragment.this).webView;
            if (touchWebView != null) {
                touchWebView.setVisibility(4);
            }
            ZplanTransparentStyleWebFragment.this.Jh(true);
            ZplanTransparentStyleWebFragment.this.Fh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            QLog.d("ZpanTranspareWebFragmet_", 1, "onPageFinished, url = " + url);
            if (ZplanTransparentStyleWebFragment.this.needFinishFromJs) {
                return;
            }
            ZplanTransparentStyleWebFragment.this.Gh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            QLog.d("ZpanTranspareWebFragmet_", 1, "onProgressChanged, progress: " + newProgress);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            QLog.e("ZpanTranspareWebFragmet_", 1, "onReceivedError:  " + errorCode);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            boolean onReceivedSslError = super.onReceivedSslError(view, handler, error);
            QLog.e("ZpanTranspareWebFragmet_", 1, "onReceivedSslError:  ", error);
            return onReceivedSslError;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(Bundle extraData) {
            super.onShowPreview(extraData);
            QLog.d("ZpanTranspareWebFragmet_", 1, "onShowPreview");
        }
    }

    private final void Ah() {
        ViewGroup viewGroup = this.viewContainer;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        if (this.loadingView == null && !this.needSilentLoad) {
            WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
            if (webBrowserViewContainerKt != null) {
                this.loadingView = new ProgressBar(webBrowserViewContainerKt.getContext());
                int b16 = com.tencent.sqshow.zootopia.utils.i.b(18);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b16, b16);
                layoutParams.addRule(13);
                webBrowserViewContainerKt.addView(this.loadingView, layoutParams);
                webBrowserViewContainerKt.setBackgroundColor(0);
                showLoadingView();
                return;
            }
            return;
        }
        QLog.i("ZpanTranspareWebFragmet_", 1, "initLoadingView skip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ch(TouchWebView touchWebView) {
        getWebTitleBarInterface().u5(false);
        getSwiftTitleUI().f314047e.f314635r = true;
        getSwiftTitleUI().f314047e.f314634q = Boolean.FALSE;
        getSwiftTitleUI().f314047e.f314630m = false;
        getSwiftTitleUI().f314047e.Q = true;
        getUIStyleHandler().f0();
        getUIStyleHandler().T.setVisibility(8);
        getUIStyleHandler().f314499a0 = true;
        getUIStyleHandler().U.l(false);
        getUIStyleHandler().f314500b0.setVisibility(8);
        ViewGroup viewGroup = getUIStyleHandler().S;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "uiStyleHandler.webviewWrapper");
        if (viewGroup instanceof RefreshView) {
            ((RefreshView) viewGroup).a(false);
        }
        if (touchWebView.getX5WebViewExtension() != null) {
            try {
                View view = touchWebView.getView();
                if (view != null) {
                    view.setBackgroundColor(0);
                }
                View view2 = touchWebView.getView();
                Drawable background = view2 != null ? view2.getBackground() : null;
                if (background != null) {
                    background.setAlpha(0);
                }
            } catch (Exception e16) {
                QLog.e("ZpanTranspareWebFragmet_", 1, "initView setX5WebView error", e16);
            }
        }
        touchWebView.setBackgroundColor(0);
        Drawable background2 = touchWebView.getBackground();
        if (background2 != null) {
            background2.setAlpha(0);
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            webBrowserViewContainerKt.setBackgroundColor(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh() {
        if (getActivity() instanceof QBaseActivity) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            SystemBarActivityModule.setImmersiveStatus((QBaseActivity) activity, 0);
        }
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        View view;
        if (!this.isReloading || (view = this.loadingView) == null) {
            Ih();
        } else if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.j
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanTransparentStyleWebFragment.Hh(ZplanTransparentStyleWebFragment.this);
                }
            }, 100L);
        }
        this.isReloading = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(ZplanTransparentStyleWebFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
    }

    private final void Ih() {
        View view = this.loadingView;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.loadingView;
        if (view2 != null) {
            view2.removeCallbacks(this.hideLoadingRunnable);
        }
        Jh(true);
        CustomWebView webView = getWebView();
        if (webView != null) {
            webView.setVisibility(0);
        }
        CustomWebView webView2 = getWebView();
        QLog.i("ZpanTranspareWebFragmet_", 1, "getWebView visibility " + (webView2 != null ? Integer.valueOf(webView2.getVisibility()) : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(boolean isMax) {
        ViewGroup viewGroup = this.viewContainer;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i3 = isMax ? -1 : 1;
            if (layoutParams.width != i3 || layoutParams.height != i3) {
                layoutParams.width = i3;
                layoutParams.height = i3;
                QLog.d("ZpanTranspareWebFragmet_", 1, "update lp for parentContainer - " + isMax);
                viewGroup.setLayoutParams(layoutParams);
            }
            if (isMax) {
                viewGroup.setVisibility(0);
            }
        }
    }

    private final void showLoadingView() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setVisibility(4);
        }
        View view = this.loadingView;
        if (view != null) {
            view.setVisibility(0);
        }
        QLog.d("ZpanTranspareWebFragmet_", 1, "showLoadingView");
        View view2 = this.loadingView;
        if (view2 != null) {
            view2.postDelayed(this.hideLoadingRunnable, 10000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(ZplanTransparentStyleWebFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.loadingView;
        boolean z16 = false;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            View view2 = this$0.loadingView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            ViewGroup viewGroup = this$0.viewContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            QLog.e("ZpanTranspareWebFragmet_", 1, "show loading time out ,auto close webView " + this$0.loadingView);
        }
    }

    public final void Dh(String url, boolean needFinishFromJs) {
        Intrinsics.checkNotNullParameter(url, "url");
        QLog.d("ZpanTranspareWebFragmet_", 1, "loadUrl: " + url + " ");
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.loadUrl(url);
        }
        showLoadingView();
        this.isReloading = true;
        this.needFinishFromJs = needFinishFromJs;
    }

    public final void Eh(ViewGroup viewGroup) {
        this.viewContainer = viewGroup;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZplanWebPageLoadFinishedEvent.class);
        arrayList.add(ZplanWebCloseSplashAdEvent.class);
        arrayList.add(ZplanWebCloseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        Bundle arguments = getArguments();
        this.needFinishFromJs = arguments != null ? arguments.getBoolean("need_finish_from_js") : false;
        Bundle arguments2 = getArguments();
        boolean z16 = arguments2 != null ? arguments2.getBoolean("need_silent_load") : false;
        this.needSilentLoad = z16;
        QLog.i("ZpanTranspareWebFragmet_", 1, "onCreate_, needFinishFromJs= " + this.needFinishFromJs + ", needSilentLoad= " + z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        Bh();
        if (this.needSilentLoad && (viewGroup = this.viewContainer) != null) {
            viewGroup.setVisibility(4);
        }
        QLog.d("ZpanTranspareWebFragmet_", 1, "onCreateView");
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.d("ZpanTranspareWebFragmet_", 1, "onDestroy_");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Jh(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.i("ZpanTranspareWebFragmet_", 1, "onReceiveEvent " + event);
        if (event instanceof ZplanWebPageLoadFinishedEvent) {
            Gh();
        } else if (event instanceof ZplanWebCloseEvent) {
            Ah();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView webView) {
        super.setWebView(webView);
        QLog.d("ZpanTranspareWebFragmet_", 1, "data : ..  ");
    }

    public final void yh(String methodName, JSONObject params) {
        String str;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        try {
            QLog.i("ZpanTranspareWebFragmet_", 1, "callWebJs " + methodName + " - " + params + " ");
            if (params == null || (str = params.toString()) == null) {
                str = "";
            }
            String str2 = "javascript:mqq.dispatchEvent(\"" + methodName + "\"," + str + ");";
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null) {
                touchWebView.callJs(str2);
            }
        } catch (Exception e16) {
            QLog.e("ZpanTranspareWebFragmet_", 1, "callWebJs " + methodName + " - " + params + " ", e16);
        }
    }
}
