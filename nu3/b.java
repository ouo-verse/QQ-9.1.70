package nu3;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.r;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = ExternalElementProxy.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b7\u00108J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lnu3/b;", "Lcom/tencent/qqmini/sdk/launcher/core/proxy/ExternalElementProxy;", "Lcom/tencent/qqmini/sdk/launcher/core/IJsService;", "callBackWebView", "", "widgetId", "", "setCallBackWebView", "", "curPageWebViewId", "setCurPageWebViewId", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "miniAppContext", "setMiniAppContext", "", ReportConstant.COSTREPORT_PREFIX, "", "map", "onInit", "Landroid/view/Surface;", "surface", "onSurfaceCreated", "onSurfaceDestroyed", "Landroid/view/MotionEvent;", "motionEvent", "", "onTouchEvent", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "onRectChanged", "onRequestRedraw", "b", "onVisibilityChanged", "onActive", "onDeActive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "webViewPause", "webViewResume", "webViewDestroy", "nativeResume", "nativePause", "nativeDestroy", "Lorg/json/JSONObject;", "jsonObject", "handleInsertXWebExternalElement", "handleUpdateExternalElement", "req", "callbackId", "webview", "handleOperateExternalElement", "handleRemoveExternalElement", "", "a", "Ljava/util/Map;", "proxyMap", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends ExternalElementProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, ExternalElementProxy> proxyMap = new HashMap();

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleInsertXWebExternalElement(JSONObject jsonObject, long widgetId) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        ee4.b.a("ExternalElementProxyImp", "handleInsertXWebExternalElement() called with: jsonObject = [" + jsonObject + "], widgetId = [" + widgetId + "]");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.handleInsertXWebExternalElement(jsonObject, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleOperateExternalElement(JSONObject req, int callbackId, IJsService webview, long widgetId) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(webview, "webview");
        ee4.b.a("ExternalElementProxyImp", "handleOperateExternalElement() called with: req = [" + req + "], callbackId = [" + callbackId + "], webview = [" + webview + "], widgetId = [" + widgetId + "]");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.handleOperateExternalElement(req, callbackId, webview, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleRemoveExternalElement(long widgetId) {
        ee4.b.a("ExternalElementProxyImp", "handleRemoveExternalElement() called with: widgetId = [" + widgetId + "]");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.handleRemoveExternalElement(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleUpdateExternalElement(JSONObject jsonObject, long widgetId) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        ee4.b.a("ExternalElementProxyImp", "handleUpdateExternalElement() called with: jsonObject = [" + jsonObject + "], widgetId = [" + widgetId + "]");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.handleUpdateExternalElement(jsonObject, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeDestroy(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.nativeDestroy(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativePause(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.nativePause(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeResume(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.nativeResume(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onActive(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onActive(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDeActive(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onDeActive(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDestroy(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onDestroy(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onInit(String s16, Map<String, String> map, long widgetId) {
        Intrinsics.checkNotNullParameter(s16, "s");
        Intrinsics.checkNotNullParameter(map, "map");
        ee4.b.a("ExternalElementProxyImp", "onInit() called with: s = [" + s16 + "], map = [" + map + "], widgetId = [" + widgetId + "]");
        this.proxyMap.put(Long.valueOf(widgetId), new r());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRectChanged(Rect rect, long widgetId) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onRectChanged(rect, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRequestRedraw(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onRequestRedraw(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceCreated(Surface surface, long widgetId) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ee4.b.a("ExternalElementProxyImp", "onSurfaceCreated() called with: surface = [" + surface + "], widgetId = [" + widgetId + "]");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onSurfaceCreated(surface, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceDestroyed(Surface surface, long widgetId) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onSurfaceDestroyed(surface, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public boolean onTouchEvent(MotionEvent motionEvent, long widgetId) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        return externalElementProxy != null && externalElementProxy.onTouchEvent(motionEvent, widgetId);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onVisibilityChanged(boolean b16, long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.onVisibilityChanged(b16, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCallBackWebView(IJsService callBackWebView, long widgetId) {
        Intrinsics.checkNotNullParameter(callBackWebView, "callBackWebView");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.setCallBackWebView(callBackWebView, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCurPageWebViewId(int curPageWebViewId, long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.setCurPageWebViewId(curPageWebViewId, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setMiniAppContext(IMiniAppContext miniAppContext, long widgetId) {
        Intrinsics.checkNotNullParameter(miniAppContext, "miniAppContext");
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.setMiniAppContext(miniAppContext, widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewDestroy(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.webViewDestroy(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewPause(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.webViewPause(widgetId);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewResume(long widgetId) {
        ExternalElementProxy externalElementProxy = this.proxyMap.get(Long.valueOf(widgetId));
        if (externalElementProxy != null) {
            externalElementProxy.webViewResume(widgetId);
        }
    }
}
