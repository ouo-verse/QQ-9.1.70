package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ExternalEmbeddedWidgetClient implements IExtendedEmbeddedWidgetClient {
    private static final String TAG = "miniapp-embedded-external";
    private IMiniAppContext mMiniAppContext;
    private int mViewId;
    private ExternalElementProxy proxy;
    private IEmbeddedWidget widget;

    public ExternalEmbeddedWidgetClient(IMiniAppContext iMiniAppContext, String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        ExternalElementProxy externalElementProxy = (ExternalElementProxy) ProxyManager.get(ExternalElementProxy.class);
        this.proxy = externalElementProxy;
        this.mViewId = -1;
        this.widget = iEmbeddedWidget;
        this.mMiniAppContext = iMiniAppContext;
        if (externalElementProxy != null) {
            externalElementProxy.setMiniAppContext(iMiniAppContext, iEmbeddedWidget.getWidgetId());
            this.proxy.onInit(str, map, iEmbeddedWidget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public IMiniAppContext getMiniAppContext() {
        return this.mMiniAppContext;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public int getViewId() {
        return this.mViewId;
    }

    public void handleInsertXWebExternalElement(JSONObject jSONObject, IJsService iJsService) {
        int i3;
        if (iJsService instanceof BrandPageWebview) {
            i3 = ((BrandPageWebview) iJsService).getWebViewId();
        } else if (iJsService instanceof MiniWebView) {
            i3 = ((MiniWebView) iJsService).J();
        } else {
            i3 = -1;
        }
        if (jSONObject != null) {
            this.mViewId = jSONObject.optInt("viewId", -1);
        }
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.setCurPageWebViewId(i3, this.widget.getWidgetId());
            this.proxy.setCallBackWebView(iJsService, this.widget.getWidgetId());
            this.proxy.handleInsertXWebExternalElement(jSONObject, this.widget.getWidgetId());
        }
    }

    public void handleOperateXWebExternalElement(JSONObject jSONObject, int i3, IJsService iJsService) {
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.handleOperateExternalElement(jSONObject, i3, iJsService, this.widget.getWidgetId());
        }
    }

    public void handleRemoveXWebExternalElement() {
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.handleRemoveExternalElement(this.widget.getWidgetId());
        }
    }

    public void handleUpdateXWebExternalElement(JSONObject jSONObject) {
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.handleUpdateExternalElement(jSONObject, this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.nativeDestroy " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.nativeDestroy(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.nativePause " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.nativePause(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.nativeResume " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.nativeResume(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onActive");
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onActive(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onDeactive");
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onDeActive(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onDestroy");
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onDestroy(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onRectChanged, rect:" + rect.toString() + "\uff1b size : " + (rect.right - rect.left) + "," + (rect.bottom - rect.top));
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onRectChanged(rect, this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onRequestRedraw");
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onRequestRedraw(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        Boolean bool;
        QMLog.d(TAG, "onSurfaceCreated: " + surface);
        if (surface != null && surface.isValid()) {
            ExternalElementProxy externalElementProxy = this.proxy;
            if (externalElementProxy != null) {
                externalElementProxy.onSurfaceCreated(surface, this.widget.getWidgetId());
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSurfaceCreated isValid() : ");
        if (surface != null) {
            bool = Boolean.valueOf(surface.isValid());
        } else {
            bool = null;
        }
        sb5.append(bool);
        QMLog.e(TAG, sb5.toString());
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceDestroyed(Surface surface) {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onSurfaceDestroyed");
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onSurfaceDestroyed(surface, this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onTouchEvent, rect:" + motionEvent.toString());
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            return externalElementProxy.onTouchEvent(motionEvent, this.widget.getWidgetId());
        }
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.onVisibilityChanged \uff1a " + z16);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.onVisibilityChanged(z16, this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.webViewDestroy " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.webViewDestroy(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.webviewPause " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.webViewPause(this.widget.getWidgetId());
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.d(TAG, "ExternalEmbeddedWidgetClient.webviewResume " + this);
        ExternalElementProxy externalElementProxy = this.proxy;
        if (externalElementProxy != null) {
            externalElementProxy.webViewResume(this.widget.getWidgetId());
        }
    }
}
