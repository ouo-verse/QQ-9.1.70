package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public abstract class ExternalElementProxy {
    public static final String EVENT_INSERT_XWEB_EXTERNAL_ELEMENT = "insertXWebExternalElement";
    public static final String EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT = "operateXWebExternalElement";
    public static final String EVENT_REMOVE_XWEB_EXTERNAL_ELEMENT = "removeXWebExternalElement";
    public static final String EVENT_UPDATE_XWEB_EXTERNAL_ELEMENT = "updateXWebExternalElement";
    public static final String ON_XWEB_EXTERNAL_ELEMENT_EVENT = "onExternalElementEvent";

    protected void callbackOnXWebExternalElementEvent(IMiniAppContext iMiniAppContext, IJsService iJsService, String str, int i3) {
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(ON_XWEB_EXTERNAL_ELEMENT_EVENT, str, i3));
        }
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS(ON_XWEB_EXTERNAL_ELEMENT_EVENT, str, i3);
        }
    }

    protected void evaluateCallbackJs(IJsService iJsService, int i3, String str) {
        if (iJsService != null) {
            iJsService.evaluateCallbackJs(i3, str);
        }
    }

    public abstract void handleInsertXWebExternalElement(JSONObject jSONObject, long j3);

    public abstract void handleOperateExternalElement(JSONObject jSONObject, int i3, IJsService iJsService, long j3);

    public abstract void handleRemoveExternalElement(long j3);

    public abstract void handleUpdateExternalElement(JSONObject jSONObject, long j3);

    public abstract void nativeDestroy(long j3);

    public abstract void nativePause(long j3);

    public abstract void nativeResume(long j3);

    public abstract void onActive(long j3);

    public abstract void onDeActive(long j3);

    public abstract void onDestroy(long j3);

    public abstract void onInit(String str, Map<String, String> map, long j3);

    public abstract void onRectChanged(Rect rect, long j3);

    public abstract void onRequestRedraw(long j3);

    public abstract void onSurfaceCreated(Surface surface, long j3);

    public abstract void onSurfaceDestroyed(Surface surface, long j3);

    public abstract boolean onTouchEvent(MotionEvent motionEvent, long j3);

    public abstract void onVisibilityChanged(boolean z16, long j3);

    public abstract void setCallBackWebView(IJsService iJsService, long j3);

    public abstract void setCurPageWebViewId(int i3, long j3);

    public abstract void setMiniAppContext(IMiniAppContext iMiniAppContext, long j3);

    public abstract void webViewDestroy(long j3);

    public abstract void webViewPause(long j3);

    public abstract void webViewResume(long j3);
}
