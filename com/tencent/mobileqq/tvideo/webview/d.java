package com.tencent.mobileqq.tvideo.webview;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import bu2.TVideoAccountInfo;
import bu2.c;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPendantToastEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPlayOrPauseEvent;
import com.tencent.mobileqq.tvideo.event.TVideoChannelAutoJumpEvent;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.vivo.push.PushClientConstants;
import eipc.EIPCResult;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import jy2.g;
import jy2.i;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import tvideo.NetworkInfo;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J(\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0002H\u0007J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0007J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0007J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J:\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0007J\u001c\u0010\u001a\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0007J\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\b\u0010 \u001a\u00020\u0002H\u0007J\b\u0010!\u001a\u00020\u0002H\u0002J\u001e\u0010\"\u001a\u00020\u000f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J\u001e\u0010#\u001a\u00020\u000f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J\u001e\u0010$\u001a\u00020\u000f2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0002J\u0018\u0010&\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020\u0017J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0017J\u001a\u0010)\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/tvideo/webview/d;", "", "Lorg/json/JSONObject;", h.F, "j", "Lcom/tencent/biz/pubaccount/CustomWebView;", "webView", "", "", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "c", DomainData.DOMAIN_NAME, "g", "", "v", "event", ReportConstant.COSTREPORT_PREFIX, "l", "method", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isMainProcess", "o", "B", "key", "value", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "jsonObject", "k", "f", "e", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "isHippy", "p", "isPause", "y", "r", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f304853a = new d();

    d() {
    }

    @JvmStatic
    public static final void A(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        QLog.i("TVideoJSCallbackUtil", 1, "updateAppSetting key = " + key + " +  value  =  " + value);
        if (Intrinsics.areEqual("floatingWindow", key)) {
            com.tencent.mobileqq.tvideo.floatingwindow.a.a().g(value);
            return;
        }
        if (Intrinsics.areEqual("agreePrivacy", key)) {
            if (Intrinsics.areEqual(value, "1")) {
                ny2.a.f421586a.c();
            }
        } else if (Intrinsics.areEqual("hasPayVip", key)) {
            qx2.a.c().n(true);
        } else if (Intrinsics.areEqual("h5PrivacyShow", key)) {
            qx2.a.c().p(true);
        }
    }

    private final void B(Map<String, ? extends Object> params) {
        Object obj = params.get("key");
        Object obj2 = params.get("value");
        if (obj != null && obj2 != null) {
            A(obj.toString(), obj2.toString());
        }
    }

    private final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("account", g.e().getAccount());
            jSONObject2.put(PushClientConstants.TAG_PKG_NAME, g.e().getApp().getPackageName());
            TVideoConfig tVideoConfig = TVideoConfig.f304492a;
            jSONObject2.put("platformVersion", tVideoConfig.j());
            jSONObject2.put("versionName", tVideoConfig.n());
            jSONObject2.put("platform", tVideoConfig.h());
            jSONObject2.put("qimei36", tVideoConfig.k());
            jSONObject2.put("deviceModel", ah.s());
            jSONObject2.put("manufacturer", ah.C());
            jSONObject2.put("agreePrivacy", ny2.a.f421586a.b());
            jSONObject2.put("statusBarHeight", DisplayUtil.getTopHeight(Foreground.getTopActivity()));
            jSONObject2.put("openTime", k.a().f("tvideo_public_account_open_time", 0L));
            jSONObject2.put("isUnReadMsg", qx2.a.c().f430272d);
            jSONObject2.put("isSplitViewMode", AppSetting.t(BaseApplication.getContext()));
            NetworkInfo g16 = com.tencent.mobileqq.tvideo.net.utils.b.f304500a.g();
            if (g16 != null) {
                jSONObject2.put("networkMode", g16.network_mode);
                jSONObject2.put("ipv4", g16.ipv4);
                jSONObject2.put("ipv6", g16.ipv6);
            }
            jSONObject.put("result", jSONObject2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private final JSONObject d(String method) {
        Serializable serializable;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putString("method", method);
        EIPCResult c16 = yx2.a.c(bundle2);
        if (c16 != null && (bundle = c16.data) != null) {
            serializable = bundle.getSerializable("call_jsapi");
        } else {
            serializable = null;
        }
        if (serializable instanceof String) {
            return new JSONObject((String) serializable);
        }
        return new JSONObject();
    }

    private final JSONObject e() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            if (com.tencent.mobileqq.tvideo.pullqqlive.h.h(QCircleApplication.APP)) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject2.put("isInstalled", str);
            jSONObject.put("result", jSONObject2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject f() {
        if (g.B()) {
            return f304853a.e();
        }
        return f304853a.d("getVideoAppInstalled");
    }

    @JvmStatic
    @NotNull
    public static final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errCode", 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("floatingWindow", com.tencent.mobileqq.tvideo.floatingwindow.a.a().b());
        jSONObject.put("result", jSONObject2);
        return jSONObject;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject h() {
        if (g.B()) {
            return f304853a.c();
        }
        return f304853a.d("getAppInfo");
    }

    @JvmStatic
    @NotNull
    public static final JSONObject i() {
        if (g.B()) {
            return g();
        }
        return f304853a.d("getAppSetting");
    }

    @JvmStatic
    @NotNull
    public static final JSONObject j() {
        if (g.B()) {
            return n();
        }
        return f304853a.d("getUserInfo");
    }

    @JvmStatic
    @NotNull
    public static final JSONObject k(@Nullable JSONObject jsonObject, boolean isMainProcess) {
        if (!isMainProcess) {
            if (jsonObject == null) {
                return new JSONObject();
            }
            return jsonObject;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("msg", "");
            jSONObject.put("data", jsonObject);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject l() {
        if (g.B()) {
            return f304853a.m();
        }
        return f304853a.d("getReportMap");
    }

    private final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", 0);
            JSONObject jSONObject2 = new JSONObject();
            Iterator<T> it = gy2.c.o().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.put("result", jSONObject2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        bu2.a i3 = zt2.e.f453199a.i();
        if (i3 != null) {
            try {
                jSONObject.put("errCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CommonConstant.KEY_ACCESS_TOKEN, i3.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String());
                jSONObject2.put("accessTokenExpireTime", i3.getAccessTokenExpireTime());
                jSONObject2.put("appId", "102031143");
                jSONObject2.put("imToken", i3.getImToken());
                jSONObject2.put("headImageUrl", i3.getHeadImageUrl());
                jSONObject2.put("nickName", URLEncoder.encode(i3.getNickName(), "UTF-8"));
                jSONObject2.put("openId", i3.getOpenId());
                jSONObject2.put("refreshToken", i3.getRefreshToken());
                jSONObject2.put("videoUserId", i3.getVideoUserId());
                jSONObject2.put("videoSessionKey", i3.getVideoSessionKey());
                jSONObject2.put("isVip", i3.getIsVip());
                jSONObject2.put("videoCreateTime", i3.getVideoCreateTime());
                jSONObject2.put("videoExpireTime", i3.getVideoExpireTime());
                jSONObject2.put("isPlatformOverdue", i3.getIsPlatformOverdue());
                jSONObject2.put("isExpired", i3.isExpired());
                jSONObject.put("result", jSONObject2);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            jSONObject.put("errCode", -1);
        }
        return jSONObject;
    }

    @JvmStatic
    @NotNull
    public static final JSONObject o(@NotNull String method, @Nullable Map<String, ? extends Object> params, @Nullable CustomWebView webView, boolean isMainProcess) throws JSONException {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("TVideoJSCallbackUtil", 1, "handleJsRequest = " + method);
        if (Intrinsics.areEqual("getAppInfo", method)) {
            return k(h(), isMainProcess);
        }
        if (Intrinsics.areEqual("getUserInfo", method)) {
            return k(j(), isMainProcess);
        }
        if (Intrinsics.areEqual("login", method)) {
            return k(q(webView, params), isMainProcess);
        }
        if (Intrinsics.areEqual("pauseVideo", method)) {
            f304853a.y(true);
        } else if (Intrinsics.areEqual("resumeVideo", method)) {
            f304853a.y(false);
        } else if (Intrinsics.areEqual("openView", method)) {
            if (params != null) {
                f304853a.r(params);
            }
        } else if (Intrinsics.areEqual("closeH5", method)) {
            VideoReport.reportEvent("imp_end", webView, null);
            jy2.f.f411169a.h(webView);
        } else {
            if (Intrinsics.areEqual("getReportMap", method)) {
                return k(l(), isMainProcess);
            }
            if (Intrinsics.areEqual("invokeNative", method)) {
                if (params != null && (!params.isEmpty()) && params.get("method") != null) {
                    return o(String.valueOf(params.get("method")), params, webView, isMainProcess);
                }
            } else {
                if (Intrinsics.areEqual("getAppSetting", method)) {
                    return k(i(), isMainProcess);
                }
                if (Intrinsics.areEqual("updateAppSetting", method)) {
                    if (params != null) {
                        f304853a.B(params);
                    }
                } else if (Intrinsics.areEqual("showPendantToast", method)) {
                    f304853a.x(params);
                } else if (Intrinsics.areEqual("acceptCookie", method)) {
                    CookieManager.getInstance().setAcceptCookie(true);
                } else {
                    if (Intrinsics.areEqual("getVideoAppInstalled", method)) {
                        return k(f(), isMainProcess);
                    }
                    if (Intrinsics.areEqual("alertToast", method)) {
                        f304853a.z(params);
                    } else if (Intrinsics.areEqual("jumpToChannel", method)) {
                        f304853a.w(params);
                    }
                }
            }
        }
        return new JSONObject();
    }

    @JvmStatic
    @NotNull
    public static final JSONObject q(@Nullable CustomWebView webView, @Nullable Map<String, ? extends Object> params) {
        boolean areEqual;
        if (zt2.e.f453199a.k()) {
            return j();
        }
        if (params == null) {
            areEqual = false;
        } else {
            areEqual = Intrinsics.areEqual(params.get(ISchemeApi.KEY_IOS_SRC_TYPE), "hippy");
        }
        f304853a.p(webView, areEqual);
        return new JSONObject();
    }

    @JvmStatic
    public static final void s(@Nullable final CustomWebView webView, @NotNull String event, @NotNull String params) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(params, "params");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("messageName", event);
        jSONObject.put("messageParams", params);
        final String str = "javascript:(SQTVJSBridge && SQTVJSBridge.dispatchEvent(" + jSONObject + "))";
        if (webView != null) {
            webView.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.webview.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.t(CustomWebView.this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(CustomWebView customWebView, final String exeJs) {
        Intrinsics.checkNotNullParameter(exeJs, "$exeJs");
        customWebView.evaluateJavascript(exeJs, new ValueCallback() { // from class: com.tencent.mobileqq.tvideo.webview.c
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                d.u(exeJs, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String exeJs, String str) {
        Intrinsics.checkNotNullParameter(exeJs, "$exeJs");
        QLog.d("TVideoJSCallbackUtil", 4, "evaluateJavascript:" + exeJs);
    }

    @JvmStatic
    public static final void v(@Nullable CustomWebView webView) {
        String jSONObject = n().toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "getUserInfoJson().toString()");
        s(webView, "login", jSONObject);
    }

    private final void w(Map<String, ? extends Object> params) {
        Object obj;
        if (params != null) {
            try {
                obj = params.get("channelId");
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        } else {
            obj = null;
        }
        String valueOf = String.valueOf(obj);
        TVideoChannelAutoJumpEvent tVideoChannelAutoJumpEvent = new TVideoChannelAutoJumpEvent();
        tVideoChannelAutoJumpEvent.setChannelId(Integer.parseInt(valueOf));
        SimpleEventBus.getInstance().dispatchEvent(tVideoChannelAutoJumpEvent);
    }

    private final void x(Map<String, ? extends Object> params) {
        Object obj;
        Object obj2;
        Object obj3;
        try {
            QFSTVideoPendantToastEvent qFSTVideoPendantToastEvent = new QFSTVideoPendantToastEvent();
            String str = null;
            if (params != null) {
                obj = params.get("content");
            } else {
                obj = null;
            }
            qFSTVideoPendantToastEvent.setToastContent(String.valueOf(obj));
            if (params != null) {
                obj2 = params.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME);
            } else {
                obj2 = null;
            }
            qFSTVideoPendantToastEvent.setShowTime(Integer.parseInt(String.valueOf(obj2)));
            if (params != null && (obj3 = params.get(WadlProxyConsts.KEY_JUMP_URL)) != null) {
                str = obj3.toString();
            }
            qFSTVideoPendantToastEvent.setJumpUrl(str);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPendantToastEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final void z(Map<String, ? extends Object> params) {
        Object obj;
        Object obj2;
        int i3;
        Object obj3 = null;
        if (params != null) {
            try {
                obj = params.get("content");
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        } else {
            obj = null;
        }
        String valueOf = String.valueOf(obj);
        if (params != null) {
            obj2 = params.get("duration");
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (params != null) {
                obj3 = params.get("duration");
            }
            i3 = Integer.parseInt(String.valueOf(obj3));
        } else {
            i3 = 2000;
        }
        i.f411173a.b(valueOf, Integer.valueOf(i3));
    }

    public final void p(@Nullable CustomWebView webView, boolean isHippy) {
        zt2.e.f453199a.m(Foreground.getTopActivity(), new a(webView, isHippy));
    }

    public final void r(@NotNull Map<String, ? extends Object> params) {
        Object obj;
        Intrinsics.checkNotNullParameter(params, "params");
        if ((!params.isEmpty()) && (obj = params.get("url")) != null) {
            jy2.f.f411169a.i(Foreground.getTopActivity(), obj.toString());
        }
    }

    public final void y(boolean isPause) {
        if (!g.B()) {
            return;
        }
        QFSTVideoPlayOrPauseEvent qFSTVideoPlayOrPauseEvent = new QFSTVideoPlayOrPauseEvent();
        if (isPause) {
            qFSTVideoPlayOrPauseEvent.setPause(true);
        } else {
            qFSTVideoPlayOrPauseEvent.setPlay(true);
        }
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPlayOrPauseEvent);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/tvideo/webview/d$a", "Lcom/tencent/mobileqq/tvideo/webview/f;", "Lbu2/b;", "account", "", "c", "Lbu2/c$c;", "errorMessage", "a", "e", "b", "d", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f304854b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(CustomWebView customWebView, boolean z16) {
            super(customWebView);
            this.f304854b = z16;
        }

        @Override // eu2.a
        public void a(@NotNull c.C0152c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        @Override // eu2.a
        public void b(@NotNull c.C0152c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        @Override // eu2.a
        public void c(@NotNull TVideoAccountInfo account) {
            CustomWebView customWebView;
            Intrinsics.checkNotNullParameter(account, "account");
            WeakReference<CustomWebView> weakReference = this.f304855a;
            if (weakReference != null && (customWebView = weakReference.get()) != null) {
                if (!this.f304854b) {
                    d.v(customWebView);
                } else {
                    customWebView.callJs("promise", d.k(d.j(), g.B()).toString());
                }
            }
            if (!g.B()) {
                yx2.a.d();
            }
        }

        @Override // eu2.a
        public void d(@NotNull TVideoAccountInfo account) {
            Intrinsics.checkNotNullParameter(account, "account");
        }

        @Override // eu2.a
        public void f(@NotNull c.C0152c errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }

        @Override // eu2.a
        public void e() {
        }
    }
}
