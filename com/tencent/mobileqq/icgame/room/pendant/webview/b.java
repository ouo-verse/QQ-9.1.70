package com.tencent.mobileqq.icgame.room.pendant.webview;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.payguide.showdialog.ShowDialogEvent;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.icgame.api.halfweb.IQQLiveHalfWebHelperApi;
import com.tencent.mobileqq.icgame.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.icgame.webview.SendPendantData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vaswebviewplugin.ICGameJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\r\u001a\u00020\u00072\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019JM\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/pendant/webview/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "url", "method", "", "args", "", "r", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;[Ljava/lang/String;)V", "t", "([Ljava/lang/String;Ljava/lang/String;)Z", "", "heightCoefficient", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "u", PushClientConstants.TAG_PKG_NAME, ReportConstant.COSTREPORT_PREFIX, "", "p", "getNameSpace", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "v", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "d", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "e", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "<init>", "()V", "f", "a", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TouchWebView webView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    public b() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
    }

    private final int p() {
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null) {
            return e16.hashCode();
        }
        return 0;
    }

    private final void q(String url, String[] args) {
        boolean z16;
        Long l3;
        String str;
        Integer num;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("ICGamePendant|ICGamePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleGetUserInfoJs url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            String optString = new JSONObject(args[0]).optString("callback", "");
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            if (selfUserInfo != null) {
                l3 = Long.valueOf(selfUserInfo.uid);
            } else {
                l3 = null;
            }
            jSONObject.put("uid", l3);
            if (selfUserInfo != null) {
                str = selfUserInfo.nick;
            } else {
                str = null;
            }
            jSONObject.put("nick", str);
            if (selfUserInfo != null) {
                num = Integer.valueOf(selfUserInfo.sex);
            } else {
                num = null;
            }
            jSONObject.put("sex", num);
            if (selfUserInfo != null) {
                str2 = selfUserInfo.headUrl;
            }
            jSONObject.put("headUrl", str2);
            callJs(optString, jSONObject.toString());
        } catch (JSONException e16) {
            this.mAegisLog.a("ICGamePendant|ICGamePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenGiftPanelJs JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final boolean r(String url, String method, String[] args) {
        Integer num;
        String str;
        boolean z16;
        TouchWebView touchWebView;
        if (args != null) {
            num = Integer.valueOf(args.length);
        } else {
            num = null;
        }
        Intrinsics.checkNotNull(num);
        if (num.intValue() <= 0) {
            str = "";
        } else {
            str = args[0];
        }
        this.mAegisLog.i("ICGamePendant|ICGamePendantJsPlugin", 1, "handleQQLivestreamJsRequest: url ->" + url + ", arg ->" + str);
        if (method != null) {
            switch (method.hashCode()) {
                case -668458870:
                    if (method.equals("hideWebPendant")) {
                        this.mAegisLog.i("ICGamePendant|ICGamePendantJsPlugin", 1, "hideWebPendant");
                        TouchWebView touchWebView2 = this.webView;
                        if (touchWebView2 != null && (touchWebView2 instanceof PendantWebView)) {
                            Intrinsics.checkNotNull(touchWebView2, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.room.pendant.webview.PendantWebView");
                            ((PendantWebView) touchWebView2).setVisibility(8);
                        }
                        return true;
                    }
                    break;
                case -625809843:
                    if (method.equals("addEventListener")) {
                        if (args != null) {
                            if (args.length == 0) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if ((!z16) && (touchWebView = this.webView) != null && (touchWebView instanceof PendantWebView)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(args[0]);
                                    String optString = jSONObject.optString("name", "");
                                    String optString2 = jSONObject.optString("callback", "");
                                    TouchWebView touchWebView3 = this.webView;
                                    Intrinsics.checkNotNull(touchWebView3, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.room.pendant.webview.PendantWebView");
                                    ((PendantWebView) touchWebView3).setCallback(optString, optString2);
                                } catch (JSONException e16) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("ICGamePendant|ICGamePendantJsPlugin", 4, "closeWebViews failed:" + e16);
                                    }
                                }
                                SimpleEventBus.getInstance().dispatchEvent(new SendPendantData(method));
                            }
                        }
                        return true;
                    }
                    break;
                case -543897314:
                    if (method.equals("openCustomWebview")) {
                        return t(args, url);
                    }
                    break;
                case -424901544:
                    if (method.equals("closeCurrentWebview")) {
                        this.mAegisLog.i("ICGamePendant|ICGamePendantJsPlugin", 1, "url=" + url);
                        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide", url, p()));
                        return true;
                    }
                    break;
                case 276112707:
                    if (method.equals("showPopActivity")) {
                        SimpleEventBus.getInstance().dispatchEvent(new ShowDialogEvent("showPopActivity", url, p()));
                        return true;
                    }
                    break;
                case 1646635098:
                    if (method.equals("getUserCommonInfo")) {
                        q(url, args);
                        return true;
                    }
                    break;
                case 1682191098:
                    if (method.equals("stoploading")) {
                        TouchWebView touchWebView4 = this.webView;
                        if (touchWebView4 != null) {
                            touchWebView4.stopLoading();
                        }
                        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent(UIJsPlugin.EVENT_HIDE_LOADING, url, p()));
                        break;
                    }
                    break;
                case 1793290373:
                    if (method.equals("showWebPendant")) {
                        this.mAegisLog.i("ICGamePendant|ICGamePendantJsPlugin", 1, "showWebPendant");
                        TouchWebView touchWebView5 = this.webView;
                        if (touchWebView5 != null && (touchWebView5 instanceof PendantWebView)) {
                            Intrinsics.checkNotNull(touchWebView5, "null cannot be cast to non-null type com.tencent.mobileqq.icgame.room.pendant.webview.PendantWebView");
                            ((PendantWebView) touchWebView5).setVisibility(0);
                        }
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private final boolean s(String pkgName) {
        return Intrinsics.areEqual(ICGameJsPlugin.BUSINESS_NAME, pkgName);
    }

    private final boolean t(String[] args, String url) {
        boolean z16;
        ColorDrawable colorDrawable;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.w("ICGamePendant|ICGamePendantJsPlugin", 1, "handleQQLivestreamJsRequest: args error! >>" + url);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String url2 = jSONObject.optString("url", "");
            double optDouble = jSONObject.optDouble("height", 0.5d);
            int optInt = jSONObject.optInt("target", 1);
            try {
                colorDrawable = new ColorDrawable(Color.parseColor("#" + jSONObject.optString("bgColor", "")));
            } catch (Exception unused) {
                QLog.e("ICGamePendant|ICGamePendantJsPlugin", 1, "openCustomWebView, parse bgColor error");
                colorDrawable = null;
            }
            if (optInt == 0) {
                TouchWebView touchWebView = this.webView;
                if (touchWebView != null) {
                    touchWebView.loadUrl(url2);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(url2, "url");
                u(url2, (float) optDouble, colorDrawable);
            }
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ICGamePendant|ICGamePendantJsPlugin", 4, "openCustomWebView failed:" + e16);
            }
        }
        return true;
    }

    private final void u(String url, float heightCoefficient, Drawable bgDrawable) {
        Bundle bundle = new Bundle();
        int i3 = x.f(BaseApplication.getContext()).f185861b;
        int i16 = x.f(BaseApplication.getContext()).f185860a;
        if (i3 <= i16) {
            i3 = i16;
        }
        bundle.putInt("height_web_dialog", x.h(BaseApplication.getContext(), i3 * heightCoefficient));
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            ((IQQLiveHalfWebHelperApi) QRoute.api(IQQLiveHalfWebHelperApi.class)).start(topActivity, url, bundle, null, bgDrawable);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return ICGameJsPlugin.BUSINESS_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @NotNull String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(args, "args");
        if (s(pkgName)) {
            return r(url, method, args);
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }

    public final void v(@NotNull TouchWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
    }
}
