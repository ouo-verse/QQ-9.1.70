package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidget;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class EmbeddedWidgetClientHolder implements IExtendedEmbeddedWidgetClient {
    private static final String TAG = "miniapp-embedded-EmbeddedWidgetClientHolder";
    private Map<String, String> attributes;
    private IExtendedEmbeddedWidgetClient realClient = null;
    private Surface surfaceCreated;
    private String tagName;
    private IEmbeddedWidget widget;

    public EmbeddedWidgetClientHolder(String str, Map<String, String> map, IEmbeddedWidget iEmbeddedWidget) {
        this.tagName = str;
        this.attributes = map;
        this.widget = iEmbeddedWidget;
    }

    private void createRealClient(String str, IMiniAppContext iMiniAppContext, JSONObject jSONObject, IJsService iJsService) {
        if (this.realClient == null) {
            if (!"insertXWebVideo".equals(str) && !"updateXWebVideo".equals(str)) {
                if (!"insertXWebLivePlayer".equals(str) && !"updateXWebLivePlayer".equals(str)) {
                    if (!"insertXWebLivePusher".equals(str) && !"updateXWebLivePusher".equals(str)) {
                        if (!ExternalElementProxy.EVENT_INSERT_XWEB_EXTERNAL_ELEMENT.equals(str) && !ExternalElementProxy.EVENT_UPDATE_XWEB_EXTERNAL_ELEMENT.equals(str)) {
                            if ("insertXWebCanvas".equals(str) || "updateXWebCanvas".equals(str)) {
                                aa aaVar = new aa(iMiniAppContext, this.tagName, this.attributes, this.widget);
                                this.realClient = aaVar;
                                Surface surface = this.surfaceCreated;
                                if (surface != null) {
                                    aaVar.onSurfaceCreated(surface);
                                }
                                ((aa) this.realClient).c0(jSONObject, iJsService);
                                return;
                            }
                            return;
                        }
                        ExternalEmbeddedWidgetClient externalEmbeddedWidgetClient = new ExternalEmbeddedWidgetClient(iMiniAppContext, this.tagName, this.attributes, this.widget);
                        this.realClient = externalEmbeddedWidgetClient;
                        Surface surface2 = this.surfaceCreated;
                        if (surface2 != null) {
                            externalEmbeddedWidgetClient.onSurfaceCreated(surface2);
                        }
                        ((ExternalEmbeddedWidgetClient) this.realClient).handleInsertXWebExternalElement(jSONObject, iJsService);
                        return;
                    }
                    LivePusherEmbeddedWidgetClient livePusherEmbeddedWidgetClient = new LivePusherEmbeddedWidgetClient(iMiniAppContext, this.tagName, this.attributes, this.widget);
                    this.realClient = livePusherEmbeddedWidgetClient;
                    Surface surface3 = this.surfaceCreated;
                    if (surface3 != null) {
                        livePusherEmbeddedWidgetClient.onSurfaceCreated(surface3);
                    }
                    ((LivePusherEmbeddedWidgetClient) this.realClient).handleInsertXWebLivePusher(jSONObject, iJsService);
                    return;
                }
                LivePlayerEmbeddedWidgetClient livePlayerEmbeddedWidgetClient = new LivePlayerEmbeddedWidgetClient(iMiniAppContext, this.tagName, this.attributes, this.widget);
                this.realClient = livePlayerEmbeddedWidgetClient;
                Surface surface4 = this.surfaceCreated;
                if (surface4 != null) {
                    livePlayerEmbeddedWidgetClient.onSurfaceCreated(surface4);
                }
                ((LivePlayerEmbeddedWidgetClient) this.realClient).handleInsertXWebLivePlayer(jSONObject, iJsService);
                return;
            }
            VideoEmbeddedWidgetClient videoEmbeddedWidgetClient = new VideoEmbeddedWidgetClient(iMiniAppContext, this.tagName, this.attributes, this.widget);
            this.realClient = videoEmbeddedWidgetClient;
            Surface surface5 = this.surfaceCreated;
            if (surface5 != null) {
                videoEmbeddedWidgetClient.onSurfaceCreated(surface5);
            }
            ((VideoEmbeddedWidgetClient) this.realClient).handleInsertXWebVideo(jSONObject, iJsService);
        }
    }

    private void removeWidget() {
        IMiniAppContext miniAppContext = this.realClient.getMiniAppContext();
        if (miniAppContext != null) {
            miniAppContext.performAction(new Action<Boolean>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientHolder.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                public Boolean perform(BaseRuntime baseRuntime) {
                    IPage page = baseRuntime.getPage();
                    if (!(page instanceof AppBrandPageContainer)) {
                        QMLog.d(Action.TAG, "Page is invalid");
                        return Boolean.FALSE;
                    }
                    EmbeddedWidgetClientFactory currentX5EmbeddedWidgetClientFactory = ((AppBrandPageContainer) page).getCurrentX5EmbeddedWidgetClientFactory();
                    if (currentX5EmbeddedWidgetClientFactory != null) {
                        if (EmbeddedWidgetClientHolder.this.widget != null) {
                            return Boolean.valueOf(currentX5EmbeddedWidgetClientFactory.handleEmbeddedWidgetDestory(EmbeddedWidgetClientHolder.this.widget.getWidgetId()));
                        }
                        return Boolean.FALSE;
                    }
                    QMLog.d(Action.TAG, "factory is null");
                    return Boolean.FALSE;
                }
            });
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public IMiniAppContext getMiniAppContext() {
        return null;
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public int getViewId() {
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            return iExtendedEmbeddedWidgetClient.getViewId();
        }
        return -1;
    }

    public void handleEmbeddedWidgetEvent(String str, IMiniAppContext iMiniAppContext, JSONObject jSONObject, int i3, IJsService iJsService) {
        QMLog.d(TAG, "handleEmbeddedWidgetEvent event:" + str);
        createRealClient(str, iMiniAppContext, jSONObject, iJsService);
        if ("operateXWebVideo".equals(str)) {
            ((VideoEmbeddedWidgetClient) this.realClient).handleOperateXWebVideo(jSONObject);
            return;
        }
        if ("updateXWebVideo".equals(str)) {
            ((VideoEmbeddedWidgetClient) this.realClient).handleUpdateXWebVideo(jSONObject);
            return;
        }
        if ("operateXWebLivePlayer".equals(str)) {
            ((LivePlayerEmbeddedWidgetClient) this.realClient).handleOperateXWebLivePlayer(jSONObject, i3);
            return;
        }
        if ("updateXWebLivePlayer".equals(str)) {
            ((LivePlayerEmbeddedWidgetClient) this.realClient).handleUpdateXWebLivePlayer(jSONObject);
            return;
        }
        if ("removeXWebLivePlayer".equals(str)) {
            ((LivePlayerEmbeddedWidgetClient) this.realClient).handleRemoveXWebLivePlayer();
            return;
        }
        if ("operateXWebLivePusher".equals(str)) {
            ((LivePusherEmbeddedWidgetClient) this.realClient).handleOperateXWebLivePusher(jSONObject, i3);
            return;
        }
        if ("updateXWebLivePusher".equals(str)) {
            ((LivePusherEmbeddedWidgetClient) this.realClient).handleUpdateXWebLivePusher(jSONObject);
            return;
        }
        if ("removeXWebLivePusher".equals(str)) {
            ((LivePusherEmbeddedWidgetClient) this.realClient).handleRemoveXWebLivePusher();
            return;
        }
        if (ExternalElementProxy.EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT.equals(str)) {
            ((ExternalEmbeddedWidgetClient) this.realClient).handleOperateXWebExternalElement(jSONObject, i3, iJsService);
            return;
        }
        if (ExternalElementProxy.EVENT_UPDATE_XWEB_EXTERNAL_ELEMENT.equals(str)) {
            ((ExternalEmbeddedWidgetClient) this.realClient).handleUpdateXWebExternalElement(jSONObject);
            return;
        }
        if (ExternalElementProxy.EVENT_REMOVE_XWEB_EXTERNAL_ELEMENT.equals(str)) {
            ((ExternalEmbeddedWidgetClient) this.realClient).handleRemoveXWebExternalElement();
            return;
        }
        if ("operateXWebCanvas".equals(str)) {
            ((aa) this.realClient).d0(jSONObject);
            return;
        }
        if ("updateXWebCanvas".equals(str)) {
            ((aa) this.realClient).j0(jSONObject);
            return;
        }
        if ("removeXWebCanvas".equals(str)) {
            ((aa) this.realClient).e0();
            return;
        }
        if ("xWebCanvasGetImageData".equals(str)) {
            ((aa) this.realClient).b0(str, jSONObject, i3);
        } else if ("xWebCanvasPutImageData".equals(str)) {
            ((aa) this.realClient).T0(str, jSONObject, i3);
        } else if ("xWebCanvasToTempFilePath".equals(str)) {
            ((aa) this.realClient).j1(str, jSONObject, i3);
        }
    }

    public void handleInsertEmbeddedWidgetEvent(String str, IMiniAppContext iMiniAppContext, JSONObject jSONObject, IJsService iJsService) {
        QMLog.d(TAG, "handleInsertEmbeddedWidgetEvent event:" + str);
        createRealClient(str, iMiniAppContext, jSONObject, iJsService);
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeDestroy() {
        QMLog.d(TAG, "nativeDestroy");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.nativeDestroy();
        } else {
            QMLog.d(TAG, "nativeDestroy-realClient is null");
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativePause() {
        QMLog.d(TAG, "nativePause");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.nativePause();
        } else {
            QMLog.d(TAG, "nativePause-realClient is null");
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void nativeResume() {
        QMLog.d(TAG, "nativeResume");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.nativeResume();
        } else {
            QMLog.d(TAG, "nativeResume-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onActive() {
        QMLog.d(TAG, "onActive");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onActive();
        } else {
            QMLog.d(TAG, "onActive-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDeactive() {
        QMLog.d(TAG, "onDeactive");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onDeactive();
        } else {
            QMLog.d(TAG, "onDeactive-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onDestroy() {
        QMLog.d(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (this.realClient != null) {
            removeWidget();
            this.realClient.onDestroy();
        } else {
            QMLog.d(TAG, "onDestroy-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRectChanged(Rect rect) {
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onRectChanged(rect);
        } else {
            QMLog.d(TAG, "onRectChanged-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onRequestRedraw() {
        QMLog.d(TAG, "onRequestRedraw");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onRequestRedraw();
        } else {
            QMLog.d(TAG, "onRequestRedraw-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceCreated(Surface surface) {
        QMLog.d(TAG, "onSurfaceCreated");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onSurfaceCreated(surface);
        } else {
            this.surfaceCreated = surface;
            QMLog.e(TAG, "onSurfaceCreated-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onSurfaceDestroyed(Surface surface) {
        QMLog.d(TAG, "onSurfaceDestroyed");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onSurfaceDestroyed(surface);
        } else {
            this.surfaceCreated = null;
            QMLog.d(TAG, "onSurfaceDestroyed-realClient is null");
        }
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public boolean onTouchEvent(MotionEvent motionEvent) {
        QMLog.d(TAG, "onTouchEvent");
        if (this.realClient != null) {
            QMLog.d(TAG, "onTouchEvent-realClient.onTouchEvent");
            return this.realClient.onTouchEvent(motionEvent);
        }
        QMLog.d(TAG, "onTouchEvent-realClient is null");
        return false;
    }

    @Override // com.tencent.smtt.export.external.embeddedwidget.interfaces.IEmbeddedWidgetClient
    public void onVisibilityChanged(boolean z16) {
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.onVisibilityChanged(z16);
            QMLog.d(TAG, "onVisibilityChanged");
        } else {
            QMLog.d(TAG, "onVisibilityChanged is null");
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewDestroy() {
        QMLog.d(TAG, "webViewDestroy");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.webViewDestroy();
        } else {
            QMLog.d(TAG, "webViewDestroy-realClient is null");
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewPause() {
        QMLog.d(TAG, "webViewPause");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.webViewPause();
        } else {
            QMLog.d(TAG, "webViewPause-realClient is null");
        }
    }

    @Override // com.tencent.qqmini.miniapp.plugin.IExtendedEmbeddedWidgetClient
    public void webViewResume() {
        QMLog.d(TAG, "webViewResume");
        IExtendedEmbeddedWidgetClient iExtendedEmbeddedWidgetClient = this.realClient;
        if (iExtendedEmbeddedWidgetClient != null) {
            iExtendedEmbeddedWidgetClient.webViewResume();
        } else {
            QMLog.d(TAG, "webViewResume-realClient is null");
        }
    }
}
