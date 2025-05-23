package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0018J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014R\u001a\u0010$\u001a\u00020\u00188\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b%\u0010.\"\u0004\b/\u00100R$\u00107\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u00103\u001a\u0004\b,\u00104\"\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "", "", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/Integer;", "a", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "req", "Lnu3/a;", "eventBean", "", "e", "Lnu3/c;", "f", "Lnu3/d;", "p", "obj", "k", "l", "o", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "msg", "i", tl.h.F, "paramName", "j", AdMetricTag.EVENT_NAME, "object", "g", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "TAG", "b", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "getReq", "()Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "setReq", "(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "c", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "()Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;)V", "appContext", "Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", "Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", "()Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;", "r", "(Lcom/tencent/qqmini/sdk/launcher/shell/IMiniAppFileManager;)V", MosaicConstants$JsProperty.PROP_FILE_MANAGER, "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "runtime", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "WS_BaseTavApiProxy";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RequestEvent req;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private IMiniAppContext appContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private IMiniAppFileManager fileManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BaseRuntime runtime;

    private final int a() {
        IPage page;
        if (this.runtime == null) {
            this.runtime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        }
        BaseRuntime baseRuntime = this.runtime;
        AppPageInfo pageInfo = (baseRuntime == null || (page = baseRuntime.getPage()) == null) ? null : page.getPageInfo(1);
        if (pageInfo != null) {
            return pageInfo.pageId;
        }
        return 0;
    }

    private final Integer s() {
        try {
            return Integer.valueOf(a());
        } catch (Throwable th5) {
            ee4.b.c(getTAG(), "tryGetCurPageWebViewId: fail", th5);
            return null;
        }
    }

    /* renamed from: b, reason: from getter */
    public final IMiniAppContext getAppContext() {
        return this.appContext;
    }

    /* renamed from: c, reason: from getter */
    public final IMiniAppFileManager getFileManager() {
        return this.fileManager;
    }

    /* renamed from: d, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    public final void e(RequestEvent req, nu3.a eventBean) throws JSONException {
        this.req = req;
        if (eventBean instanceof nu3.c) {
            f((nu3.c) eventBean);
        } else if (eventBean instanceof nu3.d) {
            p((nu3.d) eventBean);
        }
    }

    public void f(nu3.c eventBean) throws JSONException {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        ee4.b.a(getTAG(), "newObjInvoke() called with: req = [" + this.req + "], eventBean = [" + eventBean + "]");
    }

    public final void g(String eventName, JSONObject object) {
        IJsService iJsService;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (object == null) {
            return;
        }
        Integer s16 = s();
        if (s16 == null) {
            Logger.e(getTAG(), "onSubscribe: curPageWebViewId == null");
            return;
        }
        String jSONObject = object.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "`object`.toString()");
        String str = "custom_event_" + eventName;
        IMiniAppContext iMiniAppContext = this.appContext;
        if (iMiniAppContext != null) {
        }
        RequestEvent requestEvent = this.req;
        if (requestEvent == null || (iJsService = requestEvent.jsService) == null) {
            return;
        }
        iJsService.evaluateSubscribeJS(str, jSONObject, s16.intValue());
    }

    public final void h() {
        ee4.b.j(getTAG(), "returnFail() called");
        RequestEvent requestEvent = this.req;
        if (requestEvent != null) {
            requestEvent.fail();
        }
    }

    public final void i(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ee4.b.j(getTAG(), "returnFail() called with: msg = [" + msg2 + "]");
        RequestEvent requestEvent = this.req;
        if (requestEvent != null) {
            requestEvent.fail(msg2);
        }
    }

    public final void j(String paramName) {
        Intrinsics.checkNotNullParameter(paramName, "paramName");
        i("illegal params: " + paramName);
    }

    public final void k(Object obj) throws JSONException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        n(b.f347944a.f(obj, nu3.g.f421341a.c(obj)));
    }

    public final void l(Object obj) throws JSONException {
        o(b.f347944a.f(obj, nu3.g.f421341a.c(obj)));
    }

    public final void m() {
        ee4.b.i(getTAG(), "returnOk() called");
        RequestEvent requestEvent = this.req;
        if (requestEvent != null) {
            requestEvent.ok();
        }
    }

    public final void n(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        ee4.b.i(getTAG(), "returnOk() called with: json = [" + json + "]");
        RequestEvent requestEvent = this.req;
        if (requestEvent != null) {
            requestEvent.ok(json);
        }
    }

    public final void o(Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("value", obj);
        n(jSONObject);
    }

    public void p(nu3.d eventBean) throws JSONException {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        ee4.b.a(getTAG(), "sendMsgInvoke() called with: req = [" + this.req + "], eventBean = [" + eventBean + "]");
    }

    public final void q(IMiniAppContext iMiniAppContext) {
        this.appContext = iMiniAppContext;
    }

    public final void r(IMiniAppFileManager iMiniAppFileManager) {
        this.fileManager = iMiniAppFileManager;
    }
}
