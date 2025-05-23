package com.tencent.mobileqq.guild.discoveryv2.fragment.configtab;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.parts.MainProcessWebContentPart;
import com.tencent.mobileqq.guild.discoveryv2.parts.TabMisc;
import com.tencent.mobileqq.guild.discoveryv2.widget.webview.DiscoverNestedWebView;
import com.tencent.mobileqq.guild.home.views.embeddable.ScrollableLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.af;
import com.tencent.mobileqq.util.dd;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.r;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LoadingUtil;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 C2\u00020\u0001:\u0001DB\u0013\b\u0002\u0012\b\b\u0002\u0010#\u001a\u00020 \u00a2\u0006\u0004\b@\u0010AB\t\b\u0016\u00a2\u0006\u0004\b@\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R#\u0010.\u001a\n **\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001e\u00106\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/configtab/GuildDiscoveryMainProcessWebFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "yh", "Bh", "vh", "Ah", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "useWebViewPool", "Lcom/tencent/mobileqq/webview/swift/WebViewWrapper;", "createWebViewWrapper", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "needStatusTrans", "needImmersive", "isWrapContent", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;", "miscPart", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/MainProcessWebContentPart;", "D", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/mobileqq/guild/discoveryv2/parts/MainProcessWebContentPart;", "webContentPart", "kotlin.jvm.PlatformType", "E", "wh", "()Landroid/view/View;", "loadingFrameLayout", UserInfo.SEX_FEMALE, "Landroid/view/View;", "webviewContainer", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "G", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "blurViewWeakref", "H", "tabsViewWeakRef", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "recoverBlurRunnable", "J", "Ljava/util/List;", "parts", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabMisc;)V", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDiscoveryMainProcessWebFragment extends WebViewFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TabMisc miscPart;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy webContentPart;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingFrameLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View webviewContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.meta.refresh.c<QQBlurViewWrapper> blurViewWeakref;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.meta.refresh.c<View> tabsViewWeakRef;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Runnable recoverBlurRunnable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final List<Part> parts;

    @Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J.\u0010\u0017\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/fragment/configtab/GuildDiscoveryMainProcessWebFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onDataInit", "onInitUIContent", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "onWebViewInit", "onFinalState", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(@Nullable Bundle extraData) {
            super.onDataInit(extraData);
            GuildDiscoveryMainProcessWebFragment.this.showLoading();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            super.onFinalState(extraData);
            GuildDiscoveryMainProcessWebFragment.this.yh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            super.onInitUIContent(extraData);
            GuildDiscoveryMainProcessWebFragment.this.yh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            GuildDiscoveryMainProcessWebFragment.this.hideLoading();
            GuildDiscoveryMainProcessWebFragment.this.xh().H9(url);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            GuildDiscoveryMainProcessWebFragment.this.hideLoading();
            GuildDiscoveryMainProcessWebFragment.this.xh().G9(failingUrl, errorCode, description);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(@Nullable Bundle extraData, @Nullable TouchWebView webView) {
            DiscoverNestedWebView discoverNestedWebView;
            Unit unit;
            super.onWebViewInit(extraData, webView);
            if (webView instanceof DiscoverNestedWebView) {
                discoverNestedWebView = (DiscoverNestedWebView) webView;
            } else {
                discoverNestedWebView = null;
            }
            if (discoverNestedWebView != null) {
                GuildDiscoveryMainProcessWebFragment.this.xh().C9(discoverNestedWebView);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[onWebViewInit] custom webview not match discover");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildDiscoveryMainProcessWebFragment", 1, (String) it.next(), null);
                }
            }
        }
    }

    GuildDiscoveryMainProcessWebFragment(TabMisc tabMisc) {
        Lazy lazy;
        Lazy lazy2;
        List<Part> listOf;
        this.miscPart = tabMisc;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MainProcessWebContentPart>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.GuildDiscoveryMainProcessWebFragment$webContentPart$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MainProcessWebContentPart invoke() {
                return new MainProcessWebContentPart();
            }
        });
        this.webContentPart = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.GuildDiscoveryMainProcessWebFragment$loadingFrameLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return LoadingUtil.getLoadingDialogTipsRight(GuildDiscoveryMainProcessWebFragment.this.getContext(), false);
            }
        });
        this.loadingFrameLayout = lazy2;
        this.recoverBlurRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.fragment.configtab.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildDiscoveryMainProcessWebFragment.zh(GuildDiscoveryMainProcessWebFragment.this);
            }
        };
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{tabMisc, xh()});
        this.parts = listOf;
    }

    private final void Ah() {
        View view;
        QQBlurViewWrapper qQBlurViewWrapper;
        com.tencent.qqnt.avatar.meta.refresh.c<QQBlurViewWrapper> cVar = this.blurViewWeakref;
        if (cVar != null && (qQBlurViewWrapper = cVar.get()) != null) {
            Logger.f235387a.d().d("GuildDiscoveryMainProcessWebFragment", 1, "[recoverBlurView] setEnableBlur");
            qQBlurViewWrapper.setEnableBlur(true);
            qQBlurViewWrapper.setVisibility(0);
        }
        com.tencent.qqnt.avatar.meta.refresh.c<View> cVar2 = this.tabsViewWeakRef;
        if (cVar2 != null && (view = cVar2.get()) != null) {
            view.setBackgroundColor(0);
        }
    }

    private final void Bh() {
        ViewParent viewParent;
        try {
            TouchWebView touchWebView = this.webView;
            if (touchWebView != null) {
                viewParent = touchWebView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                ((ViewGroup) viewParent).removeView(this.webView);
            }
            TouchWebView touchWebView2 = this.webView;
            if (touchWebView2 != null) {
                touchWebView2.destroy();
            }
        } catch (Throwable th5) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "tryFixOldVersionMemoryLeak error " + th5;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildDiscoveryMainProcessWebFragment", 1, (String) it.next(), th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        View view = this.webviewContainer;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading() {
        View view = this.webviewContainer;
        if (view != null) {
            view.setAlpha(0.0f);
        }
    }

    private final void vh() {
        View findViewById;
        QQBlurViewWrapper qQBlurViewWrapper;
        FragmentActivity activity = getActivity();
        if (activity != null && (qQBlurViewWrapper = (QQBlurViewWrapper) activity.findViewById(R.id.kmr)) != null) {
            Logger.f235387a.d().d("GuildDiscoveryMainProcessWebFragment", 1, "[disableBlurView] isBlurEnabled " + qQBlurViewWrapper.b());
            if (qQBlurViewWrapper.b()) {
                this.blurViewWeakref = new com.tencent.qqnt.avatar.meta.refresh.c<>(qQBlurViewWrapper);
                qQBlurViewWrapper.setEnableBlur(false);
                qQBlurViewWrapper.setVisibility(8);
            }
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (findViewById = activity2.findViewById(af.f())) != null) {
            this.tabsViewWeakRef = new com.tencent.qqnt.avatar.meta.refresh.c<>(findViewById);
            dd.a(findViewById, R.drawable.qui_tab_bottom_nav_bg);
        }
    }

    private final View wh() {
        return (View) this.loadingFrameLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainProcessWebContentPart xh() {
        return (MainProcessWebContentPart) this.webContentPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh() {
        ViewGroup viewGroup;
        View view;
        r uIStyle = getUIStyle();
        if (uIStyle != null) {
            uIStyle.f314622e = 0L;
        }
        v uIStyleHandler = getUIStyleHandler();
        if (uIStyleHandler != null) {
            uIStyleHandler.f314499a0 = true;
        }
        r uIStyle2 = getUIStyle();
        if (uIStyle2 != null) {
            uIStyle2.A = true;
        }
        v uIStyleHandler2 = getUIStyleHandler();
        WebViewProgressBar webViewProgressBar = null;
        if (uIStyleHandler2 != null) {
            viewGroup = uIStyleHandler2.S;
        } else {
            viewGroup = null;
        }
        if (viewGroup instanceof RefreshView) {
            ViewGroup viewGroup2 = getUIStyleHandler().S;
            Intrinsics.checkNotNull(viewGroup2, "null cannot be cast to non-null type com.tencent.biz.ui.RefreshView");
            ((RefreshView) viewGroup2).a(false);
        }
        v uIStyleHandler3 = getUIStyleHandler();
        if (uIStyleHandler3 != null) {
            view = uIStyleHandler3.f314500b0;
        } else {
            view = null;
        }
        if (view != null) {
            getUIStyleHandler().f314500b0.setVisibility(8);
        }
        v uIStyleHandler4 = getUIStyleHandler();
        if (uIStyleHandler4 != null) {
            webViewProgressBar = uIStyleHandler4.T;
        }
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
        getWebTitleBarInterface().u5(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void zh(GuildDiscoveryMainProcessWebFragment this$0) {
        QQBlurViewWrapper qQBlurViewWrapper;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.a d16 = Logger.f235387a.d();
        com.tencent.qqnt.avatar.meta.refresh.c cVar = this$0.blurViewWeakref;
        if (cVar != null) {
            qQBlurViewWrapper = (QQBlurViewWrapper) cVar.get();
        } else {
            qQBlurViewWrapper = null;
        }
        if (qQBlurViewWrapper != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("GuildDiscoveryMainProcessWebFragment", 1, "[recoverBlurRunnable] lastBlurSwitch " + z16);
        this$0.Ah();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return this.parts;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public WebViewWrapper createWebViewWrapper(boolean useWebViewPool) {
        Context requireContext = requireContext();
        Intent intent = this.intent;
        t webViewKernelCallBack = getWebViewKernelCallBack();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return new ni1.a(requireContext, intent, false, webViewKernelCallBack);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.webviewContainer = super.onCreateView(inflater, container, savedInstanceState);
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        ScrollableLayout scrollableLayout = new ScrollableLayout(context, null, 0, 6, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams.setMargins(0, 0, 0, QQGuildUIUtil.f(54.0f));
        scrollableLayout.addView(wh(), layoutParams);
        scrollableLayout.addView(this.webviewContainer, -1, -1);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, scrollableLayout);
        return scrollableLayout;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (1 == MobileQQ.sProcessId) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("destroy in main process!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildDiscoveryMainProcessWebFragment", 1, (String) it.next(), null);
            }
            Bh();
            SwiftReuseTouchWebView.r();
            WebAccelerateHelper.preloadBrowserView = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().d("GuildDiscoveryMainProcessWebFragment", 1, "[onPause]");
        UiThreadUtil.runOnUiThread(this.recoverBlurRunnable, 2500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QQBlurViewWrapper qQBlurViewWrapper;
        boolean z16;
        super.onResume();
        Logger.a d16 = Logger.f235387a.d();
        com.tencent.qqnt.avatar.meta.refresh.c cVar = this.blurViewWeakref;
        if (cVar != null) {
            qQBlurViewWrapper = (QQBlurViewWrapper) cVar.get();
        } else {
            qQBlurViewWrapper = null;
        }
        if (qQBlurViewWrapper != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("GuildDiscoveryMainProcessWebFragment", 1, "[onResume] lastBlurSwitch " + z16);
        UiThreadUtil.remove(this.recoverBlurRunnable);
        vh();
    }

    public GuildDiscoveryMainProcessWebFragment() {
        this(new TabMisc());
    }
}
