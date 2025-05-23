package com.tencent.mobileqq;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0012R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00100\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/HalfScreenBrowserFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/mobileqq/webview/util/h;", "", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "fragmentLayout", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "uh", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webviewplugin/q;", "getWebTitleBarInterface", WadlProxyConsts.EXTRA_DATA, "webViewKernelCallBack", "onInitUIContent", "isShowNext", "i2", "onFinalState", "", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "webViewHeightRatio", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "halfScreenFloatingView", "E", "Lcom/tencent/mobileqq/webview/util/h;", "getActionListener", "()Lcom/tencent/mobileqq/webview/util/h;", "yh", "(Lcom/tencent/mobileqq/webview/util/h;)V", "actionListener", "", "Ljava/lang/String;", "getWebViewBgColor", "()Ljava/lang/String;", "setWebViewBgColor", "(Ljava/lang/String;)V", "webViewBgColor", "G", "Landroid/view/View;", "webViewBgMask", "H", "loadingView", "<init>", "()V", "I", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class HalfScreenBrowserFragment extends WebViewFragment implements com.tencent.mobileqq.webview.util.h {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float webViewHeightRatio;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenImmersiveFloatingView halfScreenFloatingView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.webview.util.h actionListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String webViewBgColor;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View webViewBgMask;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/HalfScreenBrowserFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.HalfScreenBrowserFragment$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/HalfScreenBrowserFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f154287d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HalfScreenBrowserFragment f154288e;

        b(View view, HalfScreenBrowserFragment halfScreenBrowserFragment) {
            this.f154287d = view;
            this.f154288e = halfScreenBrowserFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) halfScreenBrowserFragment);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Float.valueOf(x16), Float.valueOf(y16))).booleanValue();
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f154287d;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return com.tencent.mobileqq.webview.util.f.f314875a.h(this.f154288e.webViewHeightRatio);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/HalfScreenBrowserFragment$c", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class c implements QUSBaseHalfScreenFloatingView.o {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HalfScreenBrowserFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                HalfScreenBrowserFragment.this.i2(false);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/HalfScreenBrowserFragment$d", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "onWebViewInit", "onInitUIContent", "onFinalState", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class d extends com.tencent.mobileqq.webview.swift.proxy.a {
        static IPatchRedirector $redirector_;

        d(com.tencent.mobileqq.webview.swift.ak akVar) {
            super(akVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HalfScreenBrowserFragment.this, (Object) akVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                QLog.i("HalfScreenBrowserFragment", 1, "loadUrlFinish");
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) extraData);
                return;
            }
            HalfScreenBrowserFragment halfScreenBrowserFragment = HalfScreenBrowserFragment.this;
            com.tencent.mobileqq.webview.swift.utils.t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            halfScreenBrowserFragment.onFinalState(extraData, webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) extraData);
                return;
            }
            HalfScreenBrowserFragment halfScreenBrowserFragment = HalfScreenBrowserFragment.this;
            com.tencent.mobileqq.webview.swift.utils.t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            halfScreenBrowserFragment.onInitUIContent(extraData, webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) url);
                return;
            }
            QLog.i("HalfScreenBrowserFragment", 1, "onPageFinished");
            View view2 = HalfScreenBrowserFragment.this.webViewBgMask;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = HalfScreenBrowserFragment.this.loadingView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(@Nullable Bundle extraData, @Nullable TouchWebView webView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) extraData, (Object) webView);
            } else {
                QLog.i("HalfScreenBrowserFragment", 1, "onWebViewInit");
                super.onWebViewInit(extraData, webView);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HalfScreenBrowserFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.webViewBgColor = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(HalfScreenBrowserFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.webview.util.h hVar = this$0.actionListener;
        if (hVar != null) {
            hVar.i2(false);
        }
    }

    private final void wh() {
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            this.loadingView = LoadingUtil.getLoadingDialogTipsRight(webBrowserViewContainerKt.getContext(), false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            webBrowserViewContainerKt.addView(this.loadingView, layoutParams);
            View view = this.loadingView;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(HalfScreenBrowserFragment this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.webview.util.h hVar = this$0.actionListener;
        if (hVar != null) {
            hVar.i2(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState)).booleanValue();
        }
        this.webViewHeightRatio = this.intent.getFloatExtra("webViewHeightRatio", 0.0f);
        return super.doOnCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public com.tencent.mobileqq.webviewplugin.q getWebTitleBarInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.webviewplugin.q) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.mobileqq.webviewplugin.q webTitleBarInterface = super.getWebTitleBarInterface();
        webTitleBarInterface.u6(true);
        Intrinsics.checkNotNullExpressionValue(webTitleBarInterface, "webTitleBarInterface");
        return webTitleBarInterface;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.webview.swift.utils.t) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new d(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.util.h
    public void i2(final boolean isShowNext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isShowNext);
            return;
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.halfScreenFloatingView;
        if (qUSHalfScreenImmersiveFloatingView != null) {
            qUSHalfScreenImmersiveFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.p
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    HalfScreenBrowserFragment.xh(HalfScreenBrowserFragment.this, isShowNext);
                }
            });
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.halfScreenFloatingView;
        if (qUSHalfScreenImmersiveFloatingView2 != null) {
            qUSHalfScreenImmersiveFloatingView2.t();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 7, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            String stringExtra = this.intent.getStringExtra("webViewBgColor");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.webViewBgColor = stringExtra;
            onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            if (getContext() != null) {
                onCreateView = uh(onCreateView);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    public final void onFinalState(@Nullable Bundle extraData, @NotNull com.tencent.mobileqq.webview.swift.utils.t webViewKernelCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) extraData, (Object) webViewKernelCallBack);
            return;
        }
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        webViewKernelCallBack.onFinalState(extraData);
        QLog.i("HalfScreenBrowserFragment", 1, "onFinalState");
    }

    public void onInitUIContent(@Nullable Bundle extraData, @NotNull com.tencent.mobileqq.webview.swift.utils.t webViewKernelCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) extraData, (Object) webViewKernelCallBack);
            return;
        }
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        getUIStyle().f314622e = 0L;
        getUIStyleHandler().f314499a0 = true;
        getUIStyle().A = true;
        getUIStyle().f314619b = true;
        webViewKernelCallBack.onInitUIContent(extraData);
        super.requireActivity().getWindow().setBackgroundDrawableResource(R.color.ajr);
        if (getUIStyleHandler().S instanceof RefreshView) {
            ViewGroup viewGroup = getUIStyleHandler().S;
            Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.tencent.biz.ui.RefreshView");
            ((RefreshView) viewGroup).a(false);
        }
        if (getUIStyleHandler().f314500b0 != null) {
            getUIStyleHandler().f314500b0.setVisibility(8);
        }
        if (this.webView.getX5WebViewExtension() != null) {
            try {
                this.webView.getView().setBackgroundColor(0);
                this.webView.setBackgroundColor(0);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.webView.setBackgroundColor(0);
        }
        QLog.i("HalfScreenBrowserFragment", 1, "onInitUIContent");
        wh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public QUSHalfScreenImmersiveFloatingView uh(@Nullable View fragmentLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QUSHalfScreenImmersiveFloatingView) iPatchRedirector.redirect((short) 8, (Object) this, (Object) fragmentLayout);
        }
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = new QUSHalfScreenImmersiveFloatingView(requireContext());
        qUSHalfScreenImmersiveFloatingView.setBackgroundColor(0);
        qUSHalfScreenImmersiveFloatingView.setIgnoreHorizontalMove(true);
        qUSHalfScreenImmersiveFloatingView.setIsContentDraggable(false);
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new b(fragmentLayout, this));
        qUSHalfScreenImmersiveFloatingView.r();
        qUSHalfScreenImmersiveFloatingView.setOnOutsideClickListener(new c());
        qUSHalfScreenImmersiveFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.o
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                HalfScreenBrowserFragment.vh(HalfScreenBrowserFragment.this);
            }
        });
        this.halfScreenFloatingView = qUSHalfScreenImmersiveFloatingView;
        return qUSHalfScreenImmersiveFloatingView;
    }

    public final void yh(@Nullable com.tencent.mobileqq.webview.util.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) hVar);
        } else {
            this.actionListener = hVar;
        }
    }
}
