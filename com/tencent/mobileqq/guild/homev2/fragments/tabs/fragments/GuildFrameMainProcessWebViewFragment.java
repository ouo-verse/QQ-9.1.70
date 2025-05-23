package com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.home.subhome.GuildHomeSubFragmentBehavior;
import com.tencent.mobileqq.guild.homev2.views.embeddable.Report;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.webview.swift.r;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.smtt.sdk.WebView;
import cp1.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ArgusTag(testConfigKey = "Argus_Guild_Home_Web", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u0002*\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\"\u00108\u001a\u0002018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildFrameMainProcessWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "", "Ah", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, OcrConfig.CHINESE, "Eh", "Landroid/view/View;", "Fh", "Landroid/os/Bundle;", "args", "setArguments", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "useWebViewPool", "Lcom/tencent/mobileqq/webview/swift/WebViewWrapper;", "createWebViewWrapper", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "context", "Ch", "needStatusTrans", "needImmersive", "isWrapContent", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "categoryName", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "D", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "loadingFrameLayout", "E", "Landroid/view/View;", "webviewContainer", UserInfo.SEX_FEMALE, "errorLayout", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "G", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "yh", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Bh", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "reportTask", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "H", "Lcom/tencent/mobileqq/guild/homev2/views/embeddable/Report$a;", "reportData", "I", "Z", "isFirstVisible", "Lcom/tencent/biz/ui/TouchWebView;", "J", "Lcom/tencent/biz/ui/TouchWebView;", "currentWebView", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFrameMainProcessWebViewFragment extends WebViewFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String categoryName = "";

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ScanningLightView loadingFrameLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View webviewContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View errorLayout;

    /* renamed from: G, reason: from kotlin metadata */
    protected IPerformanceReportTask reportTask;

    /* renamed from: H, reason: from kotlin metadata */
    private Report.ReportData reportData;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isFirstVisible;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TouchWebView currentWebView;

    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010\u0019\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildFrameMainProcessWebViewFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onDataInit", "onInitUIContent", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "onWebViewInit", "", "interceptStartLoadUrl", "onFinalState", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            boolean z16;
            Logger logger = Logger.f235387a;
            GuildFrameMainProcessWebViewFragment guildFrameMainProcessWebViewFragment = GuildFrameMainProcessWebViewFragment.this;
            Logger.a d16 = logger.d();
            boolean z17 = guildFrameMainProcessWebViewFragment.isFirstVisible;
            if (guildFrameMainProcessWebViewFragment.currentWebView != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("GuildFrameMainProcessWebViewFragment", 1, "[interceptStartLoadUrl] isFirstVisible " + z17 + ", webview: " + z16);
            if (GuildFrameMainProcessWebViewFragment.this.isFirstVisible && GuildFrameMainProcessWebViewFragment.this.currentWebView != null) {
                GuildFrameMainProcessWebViewFragment.this.currentWebView = null;
                return super.interceptStartLoadUrl();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(@Nullable Bundle extraData) {
            super.onDataInit(extraData);
            GuildFrameMainProcessWebViewFragment.this.showLoading();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            super.onFinalState(extraData);
            GuildFrameMainProcessWebViewFragment.this.zh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            super.onInitUIContent(extraData);
            GuildFrameMainProcessWebViewFragment.this.zh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            GuildFrameMainProcessWebViewFragment.this.hideLoading();
            GuildFrameMainProcessWebViewFragment.this.yh().report();
            d.f391542a.b(GuildFrameMainProcessWebViewFragment.this.yh());
            Report report = Report.f226086a;
            Report.ReportData reportData = GuildFrameMainProcessWebViewFragment.this.reportData;
            if (reportData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reportData");
                reportData = null;
            }
            report.a(reportData);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(@Nullable WebView view, @Nullable String url, @Nullable Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            GuildFrameMainProcessWebViewFragment.this.hideLoading();
            GuildFrameMainProcessWebViewFragment guildFrameMainProcessWebViewFragment = GuildFrameMainProcessWebViewFragment.this;
            Context requireContext = guildFrameMainProcessWebViewFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            guildFrameMainProcessWebViewFragment.Ch(requireContext);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(@Nullable Bundle extraData, @Nullable TouchWebView webView) {
            super.onWebViewInit(extraData, webView);
            GuildFrameMainProcessWebViewFragment.this.currentWebView = webView;
            Logger logger = Logger.f235387a;
            GuildFrameMainProcessWebViewFragment guildFrameMainProcessWebViewFragment = GuildFrameMainProcessWebViewFragment.this;
            logger.d().d("GuildFrameMainProcessWebViewFragment", 1, "[onWebViewInit] isFirstVisible " + guildFrameMainProcessWebViewFragment.isFirstVisible);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildFrameMainProcessWebViewFragment$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            GuildFrameMainProcessWebViewFragment.this.Fh(v3);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    private final void Ah() {
        if (this.loadingFrameLayout == null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ScanningLightView scanningLightView = new ScanningLightView(requireContext, null, 2, null);
            this.loadingFrameLayout = scanningLightView;
            scanningLightView.setScaleType(ImageView.ScaleType.FIT_START);
            ScanningLightView scanningLightView2 = this.loadingFrameLayout;
            if (scanningLightView2 != null) {
                scanningLightView2.setImageResource(R.drawable.guild_home_sub_fragment_loading);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(GuildFrameMainProcessWebViewFragment this$0, View view) {
        ViewParent viewParent;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScanningLightView scanningLightView = this$0.loadingFrameLayout;
        ViewGroup viewGroup = null;
        if (scanningLightView != null) {
            viewParent = scanningLightView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this$0.errorLayout);
        }
        this$0.showLoading();
        TouchWebView touchWebView = this$0.webView;
        if (touchWebView != null) {
            touchWebView.loadUrl(this$0.getUrl());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eh() {
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
                Logger.f235387a.d().e("GuildFrameMainProcessWebViewFragment", 1, (String) it.next(), th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(View view) {
        ViewGroup viewGroup;
        GuildHomeSubFragmentBehavior guildHomeSubFragmentBehavior = null;
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        int i3 = 0;
        ViewGroup.LayoutParams layoutParams = null;
        while (i3 < 10) {
            layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                break;
            }
            ViewParent parent = viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null) {
                break;
            }
            Logger logger = Logger.f235387a;
            String logTag = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag, "logTag");
            if (QLog.isDevelopLevel()) {
                Log.d(logTag, "tryNotifyLayoutChange!(" + i3 + "), view: " + viewGroup);
            }
            i3++;
        }
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            Logger logger2 = Logger.f235387a;
            String logTag2 = getTAG();
            Intrinsics.checkNotNullExpressionValue(logTag2, "logTag");
            if (QLog.isDevelopLevel()) {
                Log.d(logTag2, "tryNotifyLayoutChange success!(" + i3 + "), layoutParams is " + layoutParams);
            }
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof GuildHomeSubFragmentBehavior) {
                guildHomeSubFragmentBehavior = (GuildHomeSubFragmentBehavior) behavior;
            }
            if (guildHomeSubFragmentBehavior != null) {
                guildHomeSubFragmentBehavior.G();
                return;
            }
            return;
        }
        Logger logger3 = Logger.f235387a;
        String logTag3 = getTAG();
        Intrinsics.checkNotNullExpressionValue(logTag3, "logTag");
        if (QLog.isDevelopLevel()) {
            Log.d(logTag3, "tryNotifyLayoutChange failed(" + i3 + "), layoutParams is " + layoutParams);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
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

    protected final void Bh(@NotNull IPerformanceReportTask iPerformanceReportTask) {
        Intrinsics.checkNotNullParameter(iPerformanceReportTask, "<set-?>");
        this.reportTask = iPerformanceReportTask;
    }

    public final void Ch(@NotNull Context context) {
        ViewParent viewParent;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.errorLayout == null) {
            this.errorLayout = new QUIEmptyState.Builder(context).setImageType(13).setTitle("\u9875\u9762\u4e0d\u53ef\u7528").setButton("\u91cd\u8bd5\u52a0\u8f7d", new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFrameMainProcessWebViewFragment.Dh(GuildFrameMainProcessWebViewFragment.this, view);
                }
            }).build();
        }
        View view = this.errorLayout;
        if (view == null) {
            return;
        }
        ScanningLightView scanningLightView = this.loadingFrameLayout;
        ViewGroup viewGroup = null;
        if (scanningLightView != null) {
            viewParent = scanningLightView.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            viewGroup = (ViewGroup) viewParent;
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup.indexOfChild(view) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            viewGroup.addView(view);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public WebViewWrapper createWebViewWrapper(boolean useWebViewPool) {
        Context requireContext = requireContext();
        Intent intent = this.intent;
        t webViewKernelCallBack = getWebViewKernelCallBack();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return new ep1.a(requireContext, intent, false, webViewKernelCallBack);
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

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildFrameMainProcessWebViewFragment", 1, "onCreateView savedInstanceState:" + savedInstanceState);
        }
        Bh(qw1.b.d(getArguments(), null, 1, null));
        yh().setExtra("isMainProcessWebView", Boolean.TRUE);
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        String str2;
        Map mapOf;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.webviewContainer = super.onCreateView(inflater, container, savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Ah();
        frameLayout.addView(this.loadingFrameLayout, layoutParams);
        frameLayout.addView(this.webviewContainer, -1, -1);
        String g16 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "guildId");
        if (g16 == null) {
            str = "";
        } else {
            str = g16;
        }
        String g17 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "EXTRA_CATEGORY_NAME");
        if (g17 == null) {
            g17 = "Unknown";
        }
        String str3 = g17;
        String g18 = com.tencent.mobileqq.guild.base.extension.c.g(getArguments(), "EXTRA_URL");
        if (g18 == null) {
            str2 = "";
        } else {
            str2 = g18;
        }
        String valueOf = String.valueOf(com.tencent.mobileqq.guild.base.extension.c.f(getArguments(), "EXTRA_CATEGORY_ID", 0L, 2, null));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isMainProcessX5", "true"));
        this.reportData = new Report.ReportData(str2, str3, 2, str, null, valueOf, mapOf, 16, null);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        if (1 == MobileQQ.sProcessId) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("destroy in main process!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFrameMainProcessWebViewFragment", 1, (String) it.next(), null);
            }
            Eh();
            SwiftReuseTouchWebView.r();
            WebAccelerateHelper.preloadBrowserView = null;
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z16;
        TouchWebView touchWebView;
        super.onResume();
        Logger.a d16 = Logger.f235387a.d();
        if (this.currentWebView != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.d("GuildFrameMainProcessWebViewFragment", 1, "[onResume] needLoadUrl " + z16);
        if (!this.isFirstVisible && (touchWebView = this.currentWebView) != null) {
            this.isFirstVisible = true;
            if (touchWebView != null) {
                touchWebView.loadUrl(this.mUrl);
            }
            this.currentWebView = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Report report = Report.f226086a;
        Report.ReportData reportData = this.reportData;
        if (reportData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportData");
            reportData = null;
        }
        report.b(reportData);
        view.addOnAttachStateChangeListener(new c());
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(@Nullable Bundle args) {
        String str;
        Intent intent = new Intent();
        String str2 = "";
        if (args != null) {
            str = args.getString("EXTRA_URL", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        intent.putExtra("url", str2);
        intent.putExtra("key_url_source", "main.guild");
        if (args != null) {
            args.putParcelable("intent", intent);
        }
        Logger.f235387a.d().d("GuildFrameMainProcessWebViewFragment", 1, "[setArguments] url " + str2);
        super.setArguments(args);
    }

    @NotNull
    protected final IPerformanceReportTask yh() {
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            return iPerformanceReportTask;
        }
        Intrinsics.throwUninitializedPropertyAccessException("reportTask");
        return null;
    }
}
