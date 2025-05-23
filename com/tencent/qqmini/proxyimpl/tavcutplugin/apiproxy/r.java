package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = ExternalElementProxy.class)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J,\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001d2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010/\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00100\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00101\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00102\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00103\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00104\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u00105\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u00109\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J(\u0010:\u001a\u00020\u00022\u0006\u00107\u001a\u0002062\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0014\u0010=\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010<R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010>R\u0016\u0010@\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010?R\u0016\u0010A\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010?R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/r;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/ExternalElementProxy;", "", "b", "c", "", "callbackId", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "webview", "", "msg", "e", "type", "service", "d", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "player", "", "a", "callBackWebView", "", "widgetId", "setCallBackWebView", "curPageWebViewId", "setCurPageWebViewId", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "miniAppContext", "setMiniAppContext", "tagName", "", "attributes", "onInit", "Landroid/view/Surface;", "surface", "onSurfaceCreated", "onSurfaceDestroyed", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "onRectChanged", "onRequestRedraw", "visibility", "onVisibilityChanged", "onActive", "onDeActive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "webViewPause", "webViewResume", "webViewDestroy", "nativeResume", "nativePause", "nativeDestroy", "Lorg/json/JSONObject;", "req", "handleInsertXWebExternalElement", "handleUpdateExternalElement", "handleOperateExternalElement", "handleRemoveExternalElement", "Ljava/lang/String;", "TAG", "Landroid/view/Surface;", "I", "width", "height", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/o;", "<init>", "()V", "f", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class r extends ExternalElementProxy {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Surface surface;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private o player;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "WS_TavVideoView@" + Integer.toHexString(hashCode());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int width = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int height = -1;

    private final void b() {
        int i3;
        int i16;
        ee4.b.a(this.TAG, "checkSurfaceCreated() called, player = " + this.player + ", surface = " + this.surface + ", width&height = " + this.width + "_" + this.height);
        o oVar = this.player;
        Surface surface = this.surface;
        if (oVar == null || surface == null || (i3 = this.width) == -1 || (i16 = this.height) == -1) {
            return;
        }
        oVar.g(surface, i3, i16);
    }

    private final void c() {
        ee4.b.a(this.TAG, "checkSurfaceDestroy() called, player = " + this.player);
        o oVar = this.player;
        if (oVar != null) {
            oVar.h();
        }
        nu3.g.f421341a.d(this);
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
    }

    private final void d(String type, int callbackId, IJsService service) throws JSONException {
        ee4.b.a(this.TAG, "matchingGetObject() called with: type = [" + type + "], callbackId = [" + callbackId + "], service = [" + service + "]");
        if (!Intrinsics.areEqual("tav_getObject", type)) {
            e(callbackId, service, "no match type");
        } else {
            service.evaluateCallbackJs(callbackId, ApiUtil.wrapCallbackOk(ExternalElementProxy.EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT, b.f347944a.f(this, nu3.g.f421341a.c(this))).toString());
        }
    }

    private final void e(int callbackId, IJsService webview, String msg2) {
        ee4.b.a(this.TAG, "returnFail() called with: callbackId = [" + callbackId + "], webview = [" + webview + "], msg = [" + msg2 + "]");
        String jSONObject = ApiUtil.wrapCallbackFail(ExternalElementProxy.EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT, null, msg2).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "resultObj.toString()");
        webview.evaluateCallbackJs(callbackId, jSONObject);
    }

    public final boolean a(o player) {
        Intrinsics.checkNotNullParameter(player, "player");
        ee4.b.a(this.TAG, "attachPlayer() called with: player = [" + player + "]");
        o oVar = this.player;
        if (oVar != null && !Intrinsics.areEqual(oVar, player)) {
            ee4.b.j(this.TAG, "attachPlayer: this.player exits");
            return false;
        }
        this.player = player;
        b();
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleInsertXWebExternalElement(JSONObject req, long widgetId) {
        Intrinsics.checkNotNullParameter(req, "req");
        ee4.b.a(this.TAG, "handleInsertXWebExternalElement() called with: req = [" + req + "]");
        if (req.has("position")) {
            JSONObject optJSONObject = req.optJSONObject("position");
            this.width = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("width", -1)) + 0.5f);
            this.height = (int) ((DisplayUtil.getDensity(AppLoaderFactory.g().getContext()) * optJSONObject.optInt("height", -1)) + 0.5f);
            b();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleOperateExternalElement(JSONObject req, int callbackId, IJsService service, long widgetId) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(service, "service");
        ee4.b.a(this.TAG, "handleOperateExternalElement() called with: req = [" + req + "], callbackId = [" + callbackId + "]");
        try {
            String string = req.getJSONObject("data").getString("type");
            Intrinsics.checkNotNullExpressionValue(string, "{\n            req.getJSO\u2026tString(\"type\")\n        }");
            try {
                d(string, callbackId, service);
            } catch (JSONException e16) {
                ee4.b.c(this.TAG, "handleOperateExternalElement: ", e16);
                e(callbackId, service, "no match type");
            }
        } catch (Exception e17) {
            ee4.b.c(this.TAG, "handleOperateExternalElement: ", e17);
            e(callbackId, service, "no match type");
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleRemoveExternalElement(long widgetId) {
        ee4.b.a(this.TAG, "handleRemoveExternalElement() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleUpdateExternalElement(JSONObject req, long widgetId) {
        Intrinsics.checkNotNullParameter(req, "req");
        ee4.b.a(this.TAG, "handleUpdateExternalElement() called with: req = [" + req + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeDestroy(long widgetId) {
        ee4.b.a(this.TAG, "nativeDestroy() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativePause(long widgetId) {
        ee4.b.a(this.TAG, "nativePause() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeResume(long widgetId) {
        ee4.b.a(this.TAG, "nativeResume() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onActive(long widgetId) {
        ee4.b.a(this.TAG, "onActive() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDeActive(long widgetId) {
        ee4.b.a(this.TAG, "onDeactive() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDestroy(long widgetId) {
        ee4.b.a(this.TAG, "onDestroy() called");
        c();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onInit(String tagName, Map<String, String> attributes, long widgetId) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        ee4.b.a(this.TAG, "onInit() called with: tagName = [" + tagName + "], attributes = [" + attributes + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRectChanged(Rect rect, long widgetId) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ee4.b.a(this.TAG, "onRectChanged() called with: rect = [" + rect + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRequestRedraw(long widgetId) {
        ee4.b.a(this.TAG, "onRequestRedraw() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceCreated(Surface surface, long widgetId) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ee4.b.a(this.TAG, "onSurfaceCreated() called with: surface = [" + surface + "]");
        this.surface = surface;
        b();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceDestroyed(Surface surface, long widgetId) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ee4.b.a(this.TAG, "onSurfaceDestroyed() called with: surface = [" + surface + "]");
        c();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public boolean onTouchEvent(MotionEvent event, long widgetId) {
        Intrinsics.checkNotNullParameter(event, "event");
        ee4.b.a(this.TAG, "onTouchEvent() called with: event = [" + event + "]");
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onVisibilityChanged(boolean visibility, long widgetId) {
        ee4.b.a(this.TAG, "onVisibilityChanged() called with: visibility = [" + visibility + "], player = " + this.player);
        o oVar = this.player;
        if (oVar == null || visibility || oVar == null) {
            return;
        }
        oVar.i();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCallBackWebView(IJsService callBackWebView, long widgetId) {
        Intrinsics.checkNotNullParameter(callBackWebView, "callBackWebView");
        ee4.b.a(this.TAG, "setCallBackWebView() called with: callBackWebView = [" + callBackWebView + "], widgetId = [" + widgetId + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCurPageWebViewId(int curPageWebViewId, long widgetId) {
        ee4.b.a(this.TAG, "setCurPageWebViewId() called with: curPageWebViewId = [" + curPageWebViewId + "], widgetId = [" + widgetId + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setMiniAppContext(IMiniAppContext miniAppContext, long widgetId) {
        Intrinsics.checkNotNullParameter(miniAppContext, "miniAppContext");
        ee4.b.a(this.TAG, "setMiniAppContext() called with: miniAppContext = [" + miniAppContext + "], widgetId = [" + widgetId + "]");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewDestroy(long widgetId) {
        ee4.b.a(this.TAG, "webViewDestroy() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewPause(long widgetId) {
        ee4.b.a(this.TAG, "webViewPause() called");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewResume(long widgetId) {
        ee4.b.a(this.TAG, "webViewResume() called");
    }
}
