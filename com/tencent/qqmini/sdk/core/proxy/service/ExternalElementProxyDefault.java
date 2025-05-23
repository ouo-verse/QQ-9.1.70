package com.tencent.qqmini.sdk.core.proxy.service;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy = ExternalElementProxy.class)
/* loaded from: classes23.dex */
public class ExternalElementProxyDefault extends ExternalElementProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public boolean onTouchEvent(MotionEvent motionEvent, long j3) {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleRemoveExternalElement(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeDestroy(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativePause(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void nativeResume(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onActive(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDeActive(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onDestroy(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRequestRedraw(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewDestroy(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewPause(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void webViewResume(long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleInsertXWebExternalElement(JSONObject jSONObject, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleUpdateExternalElement(JSONObject jSONObject, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onRectChanged(Rect rect, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceCreated(Surface surface, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onSurfaceDestroyed(Surface surface, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onVisibilityChanged(boolean z16, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCallBackWebView(IJsService iJsService, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setCurPageWebViewId(int i3, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void setMiniAppContext(IMiniAppContext iMiniAppContext, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void onInit(String str, Map<String, String> map, long j3) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy
    public void handleOperateExternalElement(JSONObject jSONObject, int i3, IJsService iJsService, long j3) {
    }
}
