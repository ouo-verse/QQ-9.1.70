package com.tencent.mobileqq.zplan.web.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.zootopia.ipc.z;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.web.api.impl.ZPlanJsPluginImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.usercenter.friend.ui.ZPlanUserCenterEmptyView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001^B\u0007\u00a2\u0006\u0004\b[\u0010\\J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J(\u0010!\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f\u0018\u00010\u001ej\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f\u0018\u0001` H\u0016R\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\"\u00104\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\"\u00108\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010#\u001a\u0004\b6\u0010%\"\u0004\b7\u0010'R\"\u0010<\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010#\u001a\u0004\b:\u0010%\"\u0004\b;\u0010'R\"\u0010@\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010#\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\"\u0010D\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010#\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R\"\u0010F\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010#\u001a\u0004\bF\u0010%\"\u0004\bG\u0010'R\"\u0010K\u001a\u00020H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010R\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010#\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010'R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZPlanCustomTitleWebFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initIntentData", "showErrorView", "hideErrorView", "initView", "Dh", "Bh", "vh", OcrConfig.CHINESE, "xh", "", AdMetricTag.EVENT_NAME, "Eh", "Fh", "Ah", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "doOnBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "activityFinish", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTitleText", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "D", "getTitleColor", "setTitleColor", "titleColor", "E", "getSubTitleText", "setSubTitleText", "subTitleText", UserInfo.SEX_FEMALE, "getSubTitleColor", "setSubTitleColor", "subTitleColor", "G", "getConfirmText", "setConfirmText", "confirmText", "H", "getConfirmTextColor", "setConfirmTextColor", "confirmTextColor", "I", "getConfirmIconUrl", "setConfirmIconUrl", "confirmIconUrl", "J", "getBackIconUrl", "setBackIconUrl", "backIconUrl", "K", "isNeedBackEvent", "setNeedBackEvent", "", "L", "Z", "isNeedCallbackThirdAuth", "()Z", "setNeedCallbackThirdAuth", "(Z)V", "M", "getWebViewId", "setWebViewId", "webViewId", "Landroid/view/View;", "N", "Landroid/view/View;", "customTitleView", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "P", "Lcom/tencent/sqshow/zootopia/usercenter/friend/ui/ZPlanUserCenterEmptyView;", "errorView", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanCustomTitleWebFragment extends WebViewFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isNeedCallbackThirdAuth;

    /* renamed from: N, reason: from kotlin metadata */
    private View customTitleView;

    /* renamed from: P, reason: from kotlin metadata */
    private ZPlanUserCenterEmptyView errorView;

    /* renamed from: C, reason: from kotlin metadata */
    private String titleText = "";

    /* renamed from: D, reason: from kotlin metadata */
    private String titleColor = "#FF000000";

    /* renamed from: E, reason: from kotlin metadata */
    private String subTitleText = "";

    /* renamed from: F, reason: from kotlin metadata */
    private String subTitleColor = "#FF999999";

    /* renamed from: G, reason: from kotlin metadata */
    private String confirmText = "";

    /* renamed from: H, reason: from kotlin metadata */
    private String confirmTextColor = "#FF000000";

    /* renamed from: I, reason: from kotlin metadata */
    private String confirmIconUrl = "";

    /* renamed from: J, reason: from kotlin metadata */
    private String backIconUrl = "";

    /* renamed from: K, reason: from kotlin metadata */
    private String isNeedBackEvent = "0";

    /* renamed from: M, reason: from kotlin metadata */
    private String webViewId = "";

    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0012\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J.\u0010\u0017\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/zplan/web/impl/ZPlanCustomTitleWebFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "Landroid/graphics/Bitmap;", "favicon", "onPageStarted", "Lcom/tencent/smtt/export/external/interfaces/SslErrorHandler;", "handler", "Lcom/tencent/smtt/export/external/interfaces/SslError;", "error", "", "onReceivedSslError", "", "errorCode", "description", "failingUrl", "onReceivedError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle extraData) {
            super.onInitUIContent(extraData);
            ZPlanCustomTitleWebFragment.this.initView();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            QLog.e(WebViewFragment.TAG, 1, "onPageStarted :: url == " + url);
            ZPlanCustomTitleWebFragment.this.hideErrorView();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            QLog.e(WebViewFragment.TAG, 1, "onReceivedError :: description == " + description);
            ZPlanCustomTitleWebFragment.this.showErrorView();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            boolean onReceivedSslError = super.onReceivedSslError(view, handler, error);
            QLog.e(WebViewFragment.TAG, 1, "onReceivedSslError :: error == " + (error != null ? Integer.valueOf(error.getPrimaryError()) : null));
            ZPlanCustomTitleWebFragment.this.showErrorView();
            return onReceivedSslError;
        }
    }

    private final void Ah() {
        if (this.webViewId.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("webViewId", this.webViewId);
            z zVar = (z) k74.i.INSTANCE.a(z.class);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "luaParams.toString()");
            zVar.callN2L("N2L_OnWebViewClose", jSONObject2);
        }
    }

    private final void Bh() {
        Context context = getContext();
        if (context != null) {
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = new ZPlanUserCenterEmptyView(context);
            this.errorView = zPlanUserCenterEmptyView;
            zPlanUserCenterEmptyView.setVisibility(8);
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView2 = this.errorView;
            if (zPlanUserCenterEmptyView2 != null) {
                zPlanUserCenterEmptyView2.setMode(ZPlanUserCenterEmptyView.MODE.MODE_NO_NETWORK, true, new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.web.impl.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZPlanCustomTitleWebFragment.Ch(ZPlanCustomTitleWebFragment.this, view);
                    }
                });
            }
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView3 = this.errorView;
            if (zPlanUserCenterEmptyView3 != null) {
                zPlanUserCenterEmptyView3.setText(R.string.xws);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            ZPlanUserCenterEmptyView zPlanUserCenterEmptyView4 = this.errorView;
            if (zPlanUserCenterEmptyView4 != null) {
                zPlanUserCenterEmptyView4.setBackgroundColor(-1);
            }
            layoutParams.addRule(13);
            WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
            if (webBrowserViewContainerKt != null) {
                webBrowserViewContainerKt.addView(this.errorView, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(ZPlanCustomTitleWebFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TouchWebView touchWebView = this$0.webView;
        if (touchWebView != null) {
            touchWebView.reload();
        }
    }

    private final void Dh() {
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (webBrowserViewContainerKt != null) {
            webBrowserViewContainerKt.setBackgroundColor(-1);
        }
        View view = this.customTitleView;
        if (view != null) {
            view.setBackgroundColor(-1);
        }
        vh();
        zh();
        xh();
    }

    private final void Eh(String eventName) {
        TouchWebView touchWebView = this.webView;
        WebViewPluginEngine pluginEngine = touchWebView != null ? touchWebView.getPluginEngine() : null;
        if (pluginEngine == null) {
            return;
        }
        pluginEngine.D(new String[]{"zplan"});
        WebViewPlugin n3 = pluginEngine.n("zplan", true);
        Intrinsics.checkNotNull(n3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.web.api.impl.ZPlanJsPluginImpl");
        ((ZPlanJsPluginImpl) n3).sendEventToZPlanJs(eventName, "");
    }

    private final void Fh() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        SystemBarActivityModule.setImmersiveStatus((QBaseActivity) activity, 0);
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideErrorView() {
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.errorView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setVisibility(8);
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null) {
            return;
        }
        touchWebView.setVisibility(0);
    }

    private final void initIntentData() {
        Intent intent = getIntent();
        if (intent == null) {
            activityFinish();
            return;
        }
        String stringExtra = intent.getStringExtra("title");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.titleText = stringExtra;
        String stringExtra2 = intent.getStringExtra("titleColor");
        if (stringExtra2 == null) {
            stringExtra2 = "#FF000000";
        }
        this.titleColor = stringExtra2;
        String stringExtra3 = intent.getStringExtra("subtitle");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.subTitleText = stringExtra3;
        String stringExtra4 = intent.getStringExtra("subTitleColor");
        if (stringExtra4 == null) {
            stringExtra4 = "#FF999999";
        }
        this.subTitleColor = stringExtra4;
        String stringExtra5 = intent.getStringExtra("confirmText");
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.confirmText = stringExtra5;
        String stringExtra6 = intent.getStringExtra("confirmTextColor");
        this.confirmTextColor = stringExtra6 != null ? stringExtra6 : "#FF000000";
        String stringExtra7 = intent.getStringExtra("confirmIcon");
        if (stringExtra7 == null) {
            stringExtra7 = "";
        }
        this.confirmIconUrl = stringExtra7;
        String stringExtra8 = intent.getStringExtra("backIcon");
        if (stringExtra8 == null) {
            stringExtra8 = "";
        }
        this.backIconUrl = stringExtra8;
        String stringExtra9 = intent.getStringExtra("isNeedBackEvent");
        if (stringExtra9 == null) {
            stringExtra9 = "0";
        }
        this.isNeedBackEvent = stringExtra9;
        this.isNeedCallbackThirdAuth = intent.getBooleanExtra("needCallbackThirdAuth", false);
        String stringExtra10 = intent.getStringExtra("webViewId");
        this.webViewId = stringExtra10 != null ? stringExtra10 : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        SimpleEventBus.getInstance().registerReceiver(this);
        getWebTitleBarInterface().u5(false);
        getWebTitleBarInterface().setRightButton(true);
        getUIStyleHandler().T.setVisibility(8);
        getUIStyleHandler().f314500b0.setVisibility(8);
        ViewGroup viewGroup = getUIStyleHandler().S;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "uiStyleHandler.webviewWrapper");
        if (viewGroup instanceof RefreshView) {
            ((RefreshView) viewGroup).a(false);
        }
        int statusBarHeight = ImmersiveUtils.isSupporImmersive() == 1 ? ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) : 0;
        TouchWebView webView = this.webView;
        Intrinsics.checkNotNullExpressionValue(webView, "webView");
        int pxToDp = ViewUtils.pxToDp(statusBarHeight) + 46;
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = LayoutAttrsKt.getDp(pxToDp);
        }
        View titleBarView = getWebTitleBarInterface().getTitleBarView();
        if (titleBarView == null) {
            return;
        }
        titleBarView.setBackgroundColor(0);
        if (titleBarView instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) titleBarView;
            viewGroup2.removeAllViews();
            View inflate = LayoutInflater.from(viewGroup2.getContext()).inflate(R.layout.db_, viewGroup2);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            this.customTitleView = (RelativeLayout) inflate;
            Dh();
            Bh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorView() {
        ZPlanUserCenterEmptyView zPlanUserCenterEmptyView = this.errorView;
        if (zPlanUserCenterEmptyView != null) {
            zPlanUserCenterEmptyView.setVisibility(0);
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null) {
            return;
        }
        touchWebView.setVisibility(8);
    }

    private final void vh() {
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        ImageView imageView = webBrowserViewContainerKt != null ? (ImageView) webBrowserViewContainerKt.findViewById(R.id.r3x) : null;
        if (!(this.backIconUrl.length() == 0)) {
            URLDrawable drawable = URLDrawable.getDrawable(this.backIconUrl, URLDrawable.URLDrawableOptions.obtain());
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView != null) {
            imageView.setImageResource(R.drawable.ikn);
        }
        if (Intrinsics.areEqual(this.isNeedBackEvent, "1")) {
            Eh("onBackClickEvent");
        } else if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.web.impl.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanCustomTitleWebFragment.wh(ZPlanCustomTitleWebFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(ZPlanCustomTitleWebFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        if (this$0.isNeedCallbackThirdAuth) {
            pe3.a.f426058a.c();
        }
    }

    private final void xh() {
        boolean isBlank;
        boolean isBlank2;
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        View findViewById = webBrowserViewContainerKt != null ? webBrowserViewContainerKt.findViewById(R.id.r3z) : null;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.web.impl.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZPlanCustomTitleWebFragment.yh(ZPlanCustomTitleWebFragment.this, view);
                }
            });
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt2 = this.contentView;
        ImageView imageView = webBrowserViewContainerKt2 != null ? (ImageView) webBrowserViewContainerKt2.findViewById(R.id.r3y) : null;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.confirmIconUrl);
        if (!isBlank) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            URLDrawable drawable = URLDrawable.getDrawable(this.confirmIconUrl, URLDrawable.URLDrawableOptions.obtain());
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt3 = this.contentView;
        TextView textView = webBrowserViewContainerKt3 != null ? (TextView) webBrowserViewContainerKt3.findViewById(R.id.f163621r40) : null;
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.confirmText);
        if (!(!isBlank2)) {
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if ((this.confirmTextColor.length() > 0) && textView != null) {
            textView.setTextColor(Color.parseColor(this.confirmTextColor));
        }
        if (textView == null) {
            return;
        }
        textView.setText(this.confirmText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(ZPlanCustomTitleWebFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Eh("onConfirmClickEvent");
    }

    private final void zh() {
        boolean isBlank;
        boolean isBlank2;
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        TextView textView = webBrowserViewContainerKt != null ? (TextView) webBrowserViewContainerKt.findViewById(R.id.f163623r42) : null;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.titleText);
        if (!isBlank) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if ((this.titleColor.length() > 0) && textView != null) {
                textView.setTextColor(Color.parseColor(this.titleColor));
            }
            if (textView != null) {
                textView.setText(this.titleText);
            }
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt2 = this.contentView;
        TextView textView2 = webBrowserViewContainerKt2 != null ? (TextView) webBrowserViewContainerKt2.findViewById(R.id.f163622r41) : null;
        isBlank2 = StringsKt__StringsJVMKt.isBlank(this.subTitleText);
        if (!(!isBlank2)) {
            if (textView2 == null) {
                return;
            }
            textView2.setVisibility(8);
            return;
        }
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        if ((this.subTitleColor.length() > 0) && textView2 != null) {
            textView2.setTextColor(Color.parseColor(this.subTitleColor));
        }
        if (textView2 == null) {
            return;
        }
        textView2.setText(this.subTitleText);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void activityFinish() {
        super.activityFinish();
        QLog.d(WebViewFragment.TAG, 1, "activity Finish");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        super.doOnBackEvent();
        if (this.isNeedCallbackThirdAuth) {
            pe3.a.f426058a.c();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(UpdateCustomTitleEvent.class);
        arrayList.add(CloseWebViewEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            QIPCClientHelper.getInstance().register(((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).getIPCModule());
        } catch (Exception e16) {
            QLog.i(WebViewFragment.TAG, 1, "ZplanWebViewPlugin error :: ", e16);
        }
        initIntentData();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        Ah();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        FragmentActivity activity;
        if (event instanceof UpdateCustomTitleEvent) {
            UpdateCustomTitleEvent updateCustomTitleEvent = (UpdateCustomTitleEvent) event;
            if (updateCustomTitleEvent.getData().length() > 0) {
                JSONObject jSONObject = new JSONObject(updateCustomTitleEvent.getData());
                String optString = jSONObject.optString("title", this.titleText);
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"title\", titleText)");
                this.titleText = optString;
                String optString2 = jSONObject.optString("titleColor", this.titleColor);
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"titleColor\", titleColor)");
                this.titleColor = optString2;
                String optString3 = jSONObject.optString("subtitle", this.subTitleText);
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"subtitle\", subTitleText)");
                this.subTitleText = optString3;
                String optString4 = jSONObject.optString("subTitleColor", this.subTitleColor);
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"subTitleColor\", subTitleColor)");
                this.subTitleColor = optString4;
                String optString5 = jSONObject.optString("confirmText", this.confirmText);
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"confirmText\", confirmText)");
                this.confirmText = optString5;
                String optString6 = jSONObject.optString("confirmTextColor", this.confirmTextColor);
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"confirmT\u2026Color\", confirmTextColor)");
                this.confirmTextColor = optString6;
                String optString7 = jSONObject.optString("confirmIcon", this.confirmIconUrl);
                Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"confirmIcon\", confirmIconUrl)");
                this.confirmIconUrl = optString7;
                String optString8 = jSONObject.optString("backIcon", this.backIconUrl);
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"backIcon\", backIconUrl)");
                this.backIconUrl = optString8;
                String optString9 = jSONObject.optString("isNeedBackEvent", this.isNeedBackEvent);
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"isNeedBackEvent\", isNeedBackEvent)");
                this.isNeedBackEvent = optString9;
                Dh();
                return;
            }
            return;
        }
        if (!(event instanceof CloseWebViewEvent) || (activity = getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Fh();
    }
}
