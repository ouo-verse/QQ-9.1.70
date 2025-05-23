package com.tencent.sqshow.zootopia.operation.facead.web;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.operation.facead.a;
import com.tencent.sqshow.zootopia.operation.facead.report.ZootopiaFaceAdReport;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebCloseSplashAdEvent;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebPageLoadFinishedEvent;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mb4.c;
import mqq.app.Constants;
import nw4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 L2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\u0012\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020.H\u0016J&\u00104\u001a\u0004\u0018\u0001032\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010%2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J(\u00109\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000407\u0018\u000106j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000407\u0018\u0001`8H\u0016R\u0016\u0010<\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/web/ZplanFaceAdWebFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/sqshow/zootopia/operation/facead/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Eh", "", "isMax", "Ih", "Fh", "Gh", "Lcom/tencent/sqshow/zootopia/operation/facead/web/event/ZplanWebPageLoadFinishedEvent;", "event", "Kh", "Lcom/tencent/sqshow/zootopia/operation/facead/web/event/ZplanWebCloseSplashAdEvent;", "Jh", "yh", "Lcom/tencent/biz/ui/TouchWebView;", "touchWebView", OcrConfig.CHINESE, "", "h5CostTime", "clientTotalTime", "Hh", "", "logMsg", "isDebugOnly", "Bh", "Ah", "xh", "U8", "Lnw4/h;", "faceAdInfo", "Dh", "Lcom/tencent/sqshow/zootopia/operation/facead/a;", "faceAdListener", "Landroid/view/ViewGroup;", "parentContainer", "Ch", "M8", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "faceAdId", "D", "Lnw4/h;", "E", "Lcom/tencent/sqshow/zootopia/operation/facead/a;", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "", "G", "J", "loadStartTime", "H", "Z", "hasNotifyLoadFinish", "<init>", "()V", "I", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanFaceAdWebFragment extends WebViewFragment implements com.tencent.sqshow.zootopia.operation.facead.b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: I, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String faceAdId = "";

    /* renamed from: D, reason: from kotlin metadata */
    private h faceAdInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private a faceAdListener;

    /* renamed from: F, reason: from kotlin metadata */
    private ViewGroup parentContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private long loadStartTime;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hasNotifyLoadFinish;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/web/ZplanFaceAdWebFragment$a;", "", "Lnw4/h;", "faceAdInfo", "Landroid/os/Bundle;", "a", "Lcom/tencent/sqshow/zootopia/operation/facead/web/ZplanFaceAdWebFragment;", "b", "", "KEY_AD_INFO", "Ljava/lang/String;", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.operation.facead.web.ZplanFaceAdWebFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle a(h faceAdInfo) {
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            intent.putExtra("url", faceAdInfo.f421485d);
            Unit unit = Unit.INSTANCE;
            bundle.putParcelable("intent", intent);
            return bundle;
        }

        public final ZplanFaceAdWebFragment b(h faceAdInfo) {
            Intrinsics.checkNotNullParameter(faceAdInfo, "faceAdInfo");
            ZplanFaceAdWebFragment zplanFaceAdWebFragment = new ZplanFaceAdWebFragment();
            zplanFaceAdWebFragment.setArguments(ZplanFaceAdWebFragment.INSTANCE.a(faceAdInfo));
            zplanFaceAdWebFragment.Dh(faceAdInfo);
            return zplanFaceAdWebFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u001a\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001b"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/web/ZplanFaceAdWebFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onShowPreview", "onFinalState", "onInitUIContent", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "newProgress", "onProgressChanged", "", "url", "onPageFinished", "Lcom/tencent/smtt/export/external/interfaces/SslErrorHandler;", "handler", "Lcom/tencent/smtt/export/external/interfaces/SslError;", "error", "", "onReceivedSslError", "errorCode", "description", "failingUrl", "onReceivedError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            super.loadUrlFinish();
            ZplanFaceAdWebFragment.this.Bh("loadUrlFinish", false);
            ZplanFaceAdWebFragment.this.getUIStyleHandler().f314512m.A = true;
            ZplanFaceAdWebFragment.this.getUIStyleHandler().f314512m.f314619b = true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle extraData) {
            super.onFinalState(extraData);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle extraData) {
            super.onInitUIContent(extraData);
            ZplanFaceAdWebFragment.this.Bh("onInitUIContent", false);
            ZplanFaceAdWebFragment zplanFaceAdWebFragment = ZplanFaceAdWebFragment.this;
            TouchWebView webView = ((WebViewFragment) zplanFaceAdWebFragment).webView;
            Intrinsics.checkNotNullExpressionValue(webView, "webView");
            zplanFaceAdWebFragment.zh(webView);
            ((WebViewFragment) ZplanFaceAdWebFragment.this).webView.setVisibility(4);
            ZplanFaceAdWebFragment.this.Ih(true);
            ZplanFaceAdWebFragment.this.Eh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            ZplanFaceAdWebFragment.this.Bh("onPageFinished", false);
            ZplanFaceAdWebFragment.this.Bh("onPageFinished, url = " + url, true);
            if (view != null) {
                view.postInvalidate();
            }
            ZplanFaceAdWebFragment.this.Gh();
            ZootopiaFaceAdReport.f372190a.h(ZplanFaceAdWebFragment.this.getArguments(), 0, 0);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            ZplanFaceAdWebFragment.this.Bh("onProgressChanged - " + newProgress + " %", false);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            ZplanFaceAdWebFragment.this.Ah("onReceivedError", false);
            ZplanFaceAdWebFragment.this.Fh();
            ZootopiaFaceAdReport.f372190a.h(ZplanFaceAdWebFragment.this.getArguments(), errorCode, 110);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            boolean onReceivedSslError = super.onReceivedSslError(view, handler, error);
            ZplanFaceAdWebFragment.this.Ah("onReceivedSslError", false);
            ZplanFaceAdWebFragment.this.Fh();
            ZootopiaFaceAdReport.f372190a.h(ZplanFaceAdWebFragment.this.getArguments(), 120, error != null ? error.getPrimaryError() : 110);
            return onReceivedSslError;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(Bundle extraData) {
            super.onShowPreview(extraData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(String logMsg, boolean isDebugOnly) {
        if (xh(isDebugOnly)) {
            QLog.e("ZplanFaceAdWebFragment", 1, logMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(String logMsg, boolean isDebugOnly) {
        if (xh(isDebugOnly)) {
            QLog.i("ZplanFaceAdWebFragment", 1, logMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh() {
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
    public final void Fh() {
        Ah("sysNotifyError", false);
        a aVar = this.faceAdListener;
        if (aVar != null) {
            aVar.b();
        }
        M8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        Bh("sysOnPageFinished", false);
    }

    private final void Hh(int h5CostTime, int clientTotalTime) {
        HashMap hashMap = new HashMap();
        hashMap.put("k_loading_end_time", String.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        hashMap.put("k_cost_time", String.valueOf(clientTotalTime));
        hashMap.put("k_h5_loading_cost_time", String.valueOf(h5CostTime));
        c.c(c.f416532a, "e_zplan_facead_show", hashMap, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih(boolean isMax) {
        ViewGroup viewGroup = this.parentContainer;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i3 = isMax ? -1 : 1;
            if (layoutParams.width == i3 && layoutParams.height == i3) {
                return;
            }
            layoutParams.width = i3;
            layoutParams.height = i3;
            Bh("update lp for parentContainer - " + isMax, false);
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    private final void Jh(ZplanWebCloseSplashAdEvent event) {
        Bh("!! webNotifyCloseFaceAd", false);
        ZootopiaFaceAdReport.f372190a.b(getArguments(), event.getShowAgainStatus(), event.getCompleteData());
        M8();
    }

    private final void Kh(ZplanWebPageLoadFinishedEvent event) {
        Bh("!! webNotifyPageLoadFinished, h5LoadCostTime = " + event + ".loadCostTime", false);
        yh(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(TouchWebView touchWebView) {
        getWebTitleBarInterface().u5(false);
        getSwiftTitleUI().f314047e.f314634q = Boolean.TRUE;
        getUIStyleHandler().f0();
        getUIStyleHandler().T.setVisibility(8);
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
                QLog.e("ZplanFaceAdWebFragment", 1, "initView setX5WebView error", e16);
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

    public void Ch(a faceAdListener, ViewGroup parentContainer) {
        Intrinsics.checkNotNullParameter(faceAdListener, "faceAdListener");
        Intrinsics.checkNotNullParameter(parentContainer, "parentContainer");
        this.faceAdListener = faceAdListener;
        this.parentContainer = parentContainer;
    }

    public void Dh(h faceAdInfo) {
        Intrinsics.checkNotNullParameter(faceAdInfo, "faceAdInfo");
        this.faceAdInfo = faceAdInfo;
        String str = faceAdInfo.f421494m;
        Intrinsics.checkNotNullExpressionValue(str, "faceAdInfo.activityId");
        this.faceAdId = str;
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.b
    public void M8() {
        Bh("dismissSelf", false);
        try {
            getParentFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        } catch (Exception unused) {
            Ah("dismissSelf error", false);
        }
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.b
    /* renamed from: U8, reason: from getter */
    public String getFaceAdId() {
        return this.faceAdId;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZplanWebPageLoadFinishedEvent.class);
        arrayList.add(ZplanWebCloseSplashAdEvent.class);
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
        Bh("START - onCreate", false);
        this.loadStartTime = System.currentTimeMillis();
        ZootopiaFaceAdReport.f372190a.g(getArguments());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView != null) {
            onCreateView.setBackgroundColor(0);
        }
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bh(MosaicConstants$JsFunction.FUNC_ON_DESTROY, false);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        a aVar = this.faceAdListener;
        if (aVar != null) {
            aVar.c(false);
        }
        Ih(false);
        this.faceAdListener = null;
        this.parentContainer = null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof ZplanWebPageLoadFinishedEvent) {
            Kh((ZplanWebPageLoadFinishedEvent) event);
        } else if (event instanceof ZplanWebCloseSplashAdEvent) {
            Jh((ZplanWebCloseSplashAdEvent) event);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Eh();
    }

    private final void yh(ZplanWebPageLoadFinishedEvent event) {
        this.hasNotifyLoadFinish = true;
        long currentTimeMillis = System.currentTimeMillis() - this.loadStartTime;
        Bh("!! finalDoPageFinished, h5LoadCostTime = " + event.getLoadCostTime() + ", clientTotalLoadCostTime = " + currentTimeMillis, false);
        CustomWebView webView = getWebView();
        if (webView != null) {
            webView.setVisibility(0);
        }
        Ih(true);
        a aVar = this.faceAdListener;
        if (aVar != null) {
            aVar.a(this);
        }
        Hh(event.getLoadCostTime(), (int) currentTimeMillis);
        ZootopiaFaceAdReport.f(ZootopiaFaceAdReport.f372190a, getArguments(), event.getLoadCostTime(), event.getLoadResult(), event.getCompleteData(), false, 16, null);
    }

    private final boolean xh(boolean isDebugOnly) {
        return !isDebugOnly || QLog.isColorLevel();
    }
}
