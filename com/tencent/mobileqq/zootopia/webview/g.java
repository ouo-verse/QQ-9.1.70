package com.tencent.mobileqq.zootopia.webview;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.web.impl.CommonNative2JsEvent;
import com.tencent.mobileqq.zplan.web.impl.JsbL2NEvent;
import com.tencent.mobileqq.zplan.web.impl.UpdateCustomTitleEvent;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebCloseEvent;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebCloseSplashAdEvent;
import com.tencent.sqshow.zootopia.operation.facead.web.event.ZplanWebPageLoadFinishedEvent;
import com.tencent.sqshow.zootopia.recommend.specialtab.event.TabBackFrom;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c1B\u000f\u0012\u0006\u0010L\u001a\u00020I\u00a2\u0006\u0004\bP\u0010QJ1\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0005\"\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010$\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010%\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010&\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010'\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010(\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010)\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010*\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010+\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010.\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u0010/\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u00101\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u00102\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u00103\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0018\u00104\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002J\"\u00107\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u0007H\u0002J\u0018\u00108\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002JM\u0010=\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010\u00032\b\u0010<\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0005\"\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b=\u0010>J\u0016\u0010A\u001a\u00020\r2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0003J\u0016\u0010B\u001a\u00020\r2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\nJ\u0006\u0010C\u001a\u00020\rJ\u0012\u0010E\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010H\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020G\u0018\u00010FH\u0016R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010N\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/g;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "method", "", "args", "", "p", "(Ljava/lang/String;[Ljava/lang/String;)Z", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "callbackId", "", "D", "e", "E", UserInfo.SEX_FEMALE, "G", DomainData.DOMAIN_NAME, "H", "j", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "params", "u", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "O", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "P", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "y", "I", "w", ReportConstant.COSTREPORT_PREFIX, "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "M", "B", "L", "r", "N", h.F, "b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "i", BdhLogUtil.LogTag.Tag_Req, "callbackRet", "isLogDebugOnly", "c", "g", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "o", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", AdMetricTag.EVENT_NAME, "data", "J", "K", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "d", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lcom/tencent/mobileqq/zootopia/webview/JSEventDelegate;", "Lcom/tencent/mobileqq/zootopia/webview/JSEventDelegate;", "delegate", "<init>", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WebViewPlugin plugin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final JSEventDelegate delegate;

    public g(WebViewPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.plugin = plugin;
        SimpleEventBus.getInstance().registerReceiver(this);
        QLog.i("ZplanWebViewPlugin", 1, "process == " + MobileQQ.processName);
        if (t74.h.a("com.tencent.mobileqq:tool")) {
            try {
                QIPCClientHelper.getInstance().register(((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).getIPCModule());
            } catch (Exception e16) {
                QLog.i("ZplanWebViewPlugin", 1, "ZplanWebViewPlugin error :: ", e16);
            }
        }
        this.delegate = new JSEventDelegate();
    }

    private final void A(JSONObject params, String callback) {
        this.delegate.H(params, new b(this, callback));
    }

    private final void B(String callbackId) {
        this.delegate.I(new b(this, callbackId));
    }

    private final void C(JSONObject params, String callback) {
        this.delegate.J(params, new b(this, callback));
    }

    private final void D(JSONObject json, String callbackId) {
        this.delegate.L(json, new b(this, callbackId));
    }

    private final void E(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.M(json));
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void F(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.N(json));
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void G(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.O());
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void H(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "refreshSilenceDownloadList json:" + json);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.P());
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void I(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "requestJsonServer json:" + json);
        this.delegate.Q(json, new b(this, callbackId));
    }

    private final void L(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.R(json));
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void M(JSONObject json, String callbackId) {
        this.delegate.S(json, new b(this, callbackId), System.currentTimeMillis());
    }

    private final void N(JSONObject json, String callbackId) {
        JSEventDelegate jSEventDelegate = this.delegate;
        b bVar = new b(this, callbackId);
        Activity a16 = this.plugin.mRuntime.a();
        Intrinsics.checkNotNullExpressionValue(a16, "plugin.mRuntime.activity");
        jSEventDelegate.T(json, bVar, a16);
    }

    private final void O(JSONObject params, String callback) {
        this.delegate.V(params, new b(this, callback));
    }

    private final void P(JSONObject params, String callback) {
        int X = this.delegate.X(params);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", X);
        Unit unit = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026res)\n        }.toString()");
        d(this, callback, jSONObject2, false, 4, null);
    }

    private final void Q(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "updateCustomWebView json:" + json);
        Object opt = json.opt("params");
        if (opt == null) {
            QLog.e("ZplanWebViewPlugin", 1, "updateCustomWebView no params");
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new UpdateCustomTitleEvent(opt.toString()));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 0);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ESS)\n        }.toString()");
        this.plugin.callJs(callbackId, jSONObject2);
    }

    private final void R(JSONObject json, String callbackId) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.c0(json));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026on))\n        }.toString()");
        this.plugin.callJs(callbackId, jSONObject2);
    }

    private final void a(JSONObject params, String callback) {
        QLog.i("ZplanWebViewPlugin", 1, "batchQueryDownloadInfo " + params);
        this.delegate.g(params, new b(this, callback));
    }

    private final void b(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "callN2LEvent:: json:" + json);
        this.delegate.h(json, new b(this, callbackId));
    }

    private final void e(JSONObject json, String callbackId) {
        this.delegate.i(json, new b(this, callbackId));
    }

    private final void f(JSONObject json, String callbackId) {
        this.delegate.l(json, new b(this, callbackId));
    }

    private final void g(JSONObject json, String callbackId) {
        this.delegate.n(new b(this, callbackId));
    }

    private final void h(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", 0);
        jSONObject.put("data", this.delegate.o(json));
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void i(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "h5 getMaintenanceInfo json:" + json);
        this.plugin.callJs(callbackId, this.delegate.p());
    }

    private final void j(JSONObject json, String callbackId) {
        int r16 = this.delegate.r();
        QLog.i("ZplanWebViewPlugin", 4, "getStatusBarHeight statusBarHeight:" + r16);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("statusBarHeight", r16);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void k(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "h5NotifyCloseSplashAd json:" + json);
        int optInt = json.optInt("showAgainStatus");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        simpleEventBus.dispatchEvent(new ZplanWebCloseSplashAdEvent(optInt, jSONObject));
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", 0);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject2.toString());
    }

    private final void l(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "h5NotifyCloseWebView json:" + json);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        simpleEventBus.dispatchEvent(new ZplanWebCloseEvent(jSONObject));
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", 0);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject2.toString());
    }

    private final void m(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "h5NotifyPageLoadFinished json:" + json);
        int optInt = json.optInt("loadCostTime");
        int optInt2 = json.optInt(WinkDengtaReportConstant.Params.AVATAR_SHARE_LOAD_RESULT);
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        simpleEventBus.dispatchEvent(new ZplanWebPageLoadFinishedEvent(optInt, optInt2, jSONObject), true);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("result", 0);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject2.toString());
    }

    private final void n(JSONObject json, String callbackId) {
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", this.delegate.t(json));
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final boolean p(String method, String... args) {
        JSONObject jSONObject;
        try {
            if (!(args.length == 0)) {
                jSONObject = new JSONObject(args[0]);
            } else {
                jSONObject = new JSONObject();
            }
            String optString = jSONObject.optString("callback", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"callback\", \"\")");
            QLog.i("ZplanWebViewPlugin", 1, "handlerZootopiaJsRequest, method= " + method + ", callbackId= " + optString);
            if (method != null) {
                switch (method.hashCode()) {
                    case -2140931520:
                        if (!method.equals("dispatchEvent")) {
                            break;
                        } else {
                            f(jSONObject, optString);
                            return true;
                        }
                    case -2122560336:
                        if (!method.equals("callN2LEvent")) {
                            break;
                        } else {
                            b(jSONObject, optString);
                            return true;
                        }
                    case -2106691297:
                        if (!method.equals("updateCustomWebView")) {
                            break;
                        } else {
                            Q(jSONObject, optString);
                            return true;
                        }
                    case -2065462166:
                        if (!method.equals("openDetailPage")) {
                            break;
                        } else {
                            t(jSONObject, optString);
                            return true;
                        }
                    case -2027339990:
                        if (!method.equals("cancelMapDownload")) {
                            break;
                        } else {
                            e(jSONObject, optString);
                            return true;
                        }
                    case -1830616342:
                        if (!method.equals(IZplanHandleApi.METHOD_REFRESH_DRESS_INFO)) {
                            break;
                        } else {
                            E(jSONObject, optString);
                            return true;
                        }
                    case -1663476129:
                        if (!method.equals("handleH5Data")) {
                            break;
                        } else {
                            n(jSONObject, optString);
                            return true;
                        }
                    case -1554160100:
                        if (!method.equals("tabBack")) {
                            break;
                        } else {
                            this.delegate.Y(TabBackFrom.H5);
                            return true;
                        }
                    case -1480867425:
                        if (!method.equals("refreshReserveList")) {
                            break;
                        } else {
                            G(jSONObject, optString);
                            return true;
                        }
                    case -1278803410:
                        if (!method.equals("pauseMapDownload")) {
                            break;
                        } else {
                            z(jSONObject, optString);
                            return true;
                        }
                    case -1250914197:
                        if (!method.equals("sendMsgToNative")) {
                            break;
                        } else {
                            F(jSONObject, optString);
                            return true;
                        }
                    case -1249471437:
                        if (!method.equals("queryStorageSpace")) {
                            break;
                        } else {
                            D(jSONObject, optString);
                            return true;
                        }
                    case -1204214512:
                        if (!method.equals("notifyPageLoadFinished")) {
                            break;
                        } else {
                            m(jSONObject, optString);
                            return true;
                        }
                    case -1026974146:
                        if (!method.equals("queryDownloadInfo")) {
                            break;
                        } else {
                            A(jSONObject, optString);
                            return true;
                        }
                    case -829902394:
                        if (!method.equals("enterSence")) {
                            break;
                        } else {
                            u(jSONObject, optString);
                            return true;
                        }
                    case -760318203:
                        if (!method.equals("openPortalPage")) {
                            break;
                        } else {
                            v(jSONObject, optString);
                            return true;
                        }
                    case -714097293:
                        if (!method.equals("openRechargePanel")) {
                            break;
                        } else {
                            w(jSONObject, optString);
                            return true;
                        }
                    case -682098942:
                        if (!method.equals("closeSplashAd")) {
                            break;
                        } else {
                            k(jSONObject, optString);
                            return true;
                        }
                    case -480810942:
                        if (!method.equals("startMapDownload")) {
                            break;
                        } else {
                            O(jSONObject, optString);
                            return true;
                        }
                    case -449556206:
                        if (!method.equals("getStatusBarHeight")) {
                            break;
                        } else {
                            j(jSONObject, optString);
                            return true;
                        }
                    case -344781475:
                        if (!method.equals("queryFloatingPermission")) {
                            break;
                        } else {
                            B(optString);
                            return true;
                        }
                    case -257089108:
                        if (!method.equals("refreshSilenceDownloadList")) {
                            break;
                        } else {
                            H(jSONObject, optString);
                            return true;
                        }
                    case -165967424:
                        if (!method.equals("getDesignerDraft")) {
                            break;
                        } else {
                            h(jSONObject, optString);
                            return true;
                        }
                    case -121617663:
                        if (!method.equals("closeWebView")) {
                            break;
                        } else {
                            l(jSONObject, optString);
                            return true;
                        }
                    case 310720496:
                        if (!method.equals("openSameStylePage")) {
                            break;
                        } else {
                            x(jSONObject, optString);
                            return true;
                        }
                    case 313598237:
                        if (!method.equals("updateQQLiveStreamMediaInfo")) {
                            break;
                        } else {
                            R(jSONObject, optString);
                            return true;
                        }
                    case 492773878:
                        if (!method.equals("openSameStylePreviewPage")) {
                            break;
                        } else {
                            y(jSONObject, optString);
                            return true;
                        }
                    case 510241132:
                        if (!method.equals("queryResourceDownloadInfo")) {
                            break;
                        } else {
                            C(jSONObject, optString);
                            return true;
                        }
                    case 808971921:
                        if (!method.equals("setOpenScheme")) {
                            break;
                        } else {
                            L(jSONObject, optString);
                            return true;
                        }
                    case 835574827:
                        if (!method.equals("getMaintenanceInfo")) {
                            break;
                        } else {
                            i(jSONObject, optString);
                            return true;
                        }
                    case 842875771:
                        if (!method.equals("notifyH5MediaStatusUpdated")) {
                            break;
                        } else {
                            s(jSONObject, optString);
                            return true;
                        }
                    case 1098150712:
                        if (!method.equals("launchScheme")) {
                            break;
                        } else {
                            r(jSONObject, optString);
                            return true;
                        }
                    case 1278288420:
                        if (!method.equals("batchQueryDownloadInfo")) {
                            break;
                        } else {
                            a(jSONObject, optString);
                            return true;
                        }
                    case 1343126668:
                        if (!method.equals("showWheelPicker")) {
                            break;
                        } else {
                            N(jSONObject, optString);
                            return true;
                        }
                    case 1361194701:
                        if (!method.equals("showMapFloatWindow")) {
                            break;
                        } else {
                            M(jSONObject, optString);
                            return true;
                        }
                    case 1389602482:
                        if (!method.equals("requestServer")) {
                            break;
                        } else {
                            I(jSONObject, optString);
                            return true;
                        }
                    case 1504249656:
                        if (!method.equals("startResourceDownload")) {
                            break;
                        } else {
                            P(jSONObject, optString);
                            return true;
                        }
                    case 1523339644:
                        if (!method.equals("getCurrentUserInfo")) {
                            break;
                        } else {
                            g(jSONObject, optString);
                            return true;
                        }
                    case 1984416350:
                        if (!method.equals("isSupportZplan")) {
                            break;
                        } else {
                            q(jSONObject, optString);
                            return true;
                        }
                }
            }
            return false;
        } catch (Throwable th5) {
            QLog.e("ZplanWebViewPlugin", 1, "handlerZplanJsRequest error", th5);
            return false;
        }
    }

    private final void q(JSONObject json, String callback) {
        this.delegate.u(json, new b(this, callback));
    }

    private final void r(JSONObject json, String callbackId) {
        int w3 = this.delegate.w(json);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", w3);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void s(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "notifyH5MediaStatusUpdated json:" + json);
        this.delegate.y(json, new b(this, callbackId));
    }

    private final void t(JSONObject params, String callback) {
        int z16 = this.delegate.z(params);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", z16);
        Unit unit = Unit.INSTANCE;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026res)\n        }.toString()");
        d(this, callback, jSONObject2, false, 4, null);
    }

    private final void u(JSONObject params, String callback) {
        this.delegate.A(params, new b(this, callback));
    }

    private final void v(JSONObject params, String callback) {
        this.delegate.B(params, new b(this, callback));
    }

    private final void w(JSONObject json, String callbackId) {
        QLog.i("ZplanWebViewPlugin", 1, "openRechargePanel json:" + json);
        JSEventDelegate jSEventDelegate = this.delegate;
        String jSONObject = json.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "json.toString()");
        jSEventDelegate.D(jSONObject, new b(this, callbackId));
    }

    private final void x(JSONObject json, String callbackId) {
        int E = this.delegate.E(json);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", E);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void y(JSONObject json, String callbackId) {
        int F = this.delegate.F(json);
        WebViewPlugin webViewPlugin = this.plugin;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("result", F);
        Unit unit = Unit.INSTANCE;
        webViewPlugin.callJs(callbackId, jSONObject.toString());
    }

    private final void z(JSONObject params, String callback) {
        QLog.i("ZplanWebViewPlugin", 1, "pauseMapDownload " + params);
        String mapId = params.optString("mapId", "");
        JSEventDelegate jSEventDelegate = this.delegate;
        Intrinsics.checkNotNullExpressionValue(mapId, "mapId");
        jSEventDelegate.G(mapId, new b(this, callback));
    }

    public final void J(String eventName, String data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", data);
        jSONObject.put("result", 0);
        this.plugin.dispatchJsEvent(eventName, jSONObject, new JSONObject());
    }

    public final void K(String eventName, JSONObject data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", data);
        jSONObject.put("result", 0);
        this.plugin.dispatchJsEvent(eventName, jSONObject, new JSONObject());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(JsbL2NEvent.class);
        arrayList.add(CommonNative2JsEvent.class);
        return arrayList;
    }

    public final boolean o(JsBridgeListener listener, String url, String pkgName, String method, String... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return p(method, (String[]) Arrays.copyOf(args, args.length));
    }

    public final void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof JsbL2NEvent) {
            JsbL2NEvent jsbL2NEvent = (JsbL2NEvent) event;
            QLog.i("ZplanWebViewPlugin", 1, "onReceiveEvent :: eventName == " + jsbL2NEvent.getEventName() + " , params == " + jsbL2NEvent.getParams());
            if (jsbL2NEvent.getEventName().length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AdMetricTag.EVENT_NAME, jsbL2NEvent.getEventName());
                if (jsbL2NEvent.getParams().length() > 0) {
                    jSONObject.put("params", new JSONObject(jsbL2NEvent.getParams()));
                }
                QLog.i("ZplanWebViewPlugin", 1, "onReceiveEvent :: result == " + jSONObject);
                K("onReceiveL2NEvent", jSONObject);
                return;
            }
            return;
        }
        if (event instanceof CommonNative2JsEvent) {
            CommonNative2JsEvent commonNative2JsEvent = (CommonNative2JsEvent) event;
            QLog.i("ZplanWebViewPlugin", 1, "onReceiveEvent :: event == " + commonNative2JsEvent.getMethodName() + " , param == " + commonNative2JsEvent.getParams());
            if (commonNative2JsEvent.getMethodName().length() == 0) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (commonNative2JsEvent.getParams().length() > 0) {
                jSONObject2.put("params", new JSONObject(commonNative2JsEvent.getParams()));
            }
            K(commonNative2JsEvent.getMethodName(), jSONObject2);
        }
    }

    private final void c(String callbackId, String callbackRet, boolean isLogDebugOnly) {
        if (!isLogDebugOnly) {
            QLog.i("ZplanWebViewPlugin", 1, "callbackPlugin, callbackId= " + callbackId + ", callbackRet= " + callbackRet);
        }
        this.plugin.callJs(callbackId, callbackRet);
    }

    static /* synthetic */ void d(g gVar, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        gVar.c(str, str2, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/webview/g$b;", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "a", "Ljava/lang/String;", "getCallbackId", "()Ljava/lang/String;", "callbackId", "<init>", "(Lcom/tencent/mobileqq/zootopia/webview/g;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class b implements Promise {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String callbackId;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f329824b;

        public b(g gVar, String callbackId) {
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            this.f329824b = gVar;
            this.callbackId = callbackId;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        /* renamed from: getCallId, reason: from getter */
        public String getCallbackId() {
            return this.callbackId;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
            String str;
            g gVar = this.f329824b;
            String str2 = this.callbackId;
            if (p06 == null || (str = p06.toString()) == null) {
                str = "";
            }
            g.d(gVar, str2, str, false, 4, null);
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            String str;
            g gVar = this.f329824b;
            String str2 = this.callbackId;
            if (p06 == null || (str = p06.toString()) == null) {
                str = "";
            }
            g.d(gVar, str2, str, false, 4, null);
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }
}
