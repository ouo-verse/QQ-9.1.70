package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetJsRuntimeListener implements Action<CoverView.JsRuntimeListener> {
    private int webViewId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements CoverView.JsRuntimeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniWebView f346212d;

        a(MiniWebView miniWebView) {
            this.f346212d = miniWebView;
        }

        @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
        public void onCallbackJsEventFail(String str, JSONObject jSONObject, int i3) {
            String str2;
            if (this.f346212d == null) {
                return;
            }
            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(str, jSONObject);
            if (wrapCallbackFail != null) {
                str2 = wrapCallbackFail.toString();
            } else {
                str2 = "";
            }
            this.f346212d.evaluateCallbackJs(i3, str2);
        }

        @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
        public void onCallbackJsEventOK(String str, JSONObject jSONObject, int i3) {
            String str2;
            if (this.f346212d == null) {
                return;
            }
            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(str, jSONObject);
            if (wrapCallbackOk != null) {
                str2 = wrapCallbackOk.toString();
            } else {
                str2 = "";
            }
            this.f346212d.evaluateCallbackJs(i3, str2);
        }

        @Override // com.tencent.qqmini.sdk.widget.CoverView.JsRuntimeListener
        public void onEvaluateSubscribeJS(String str, String str2) {
            MiniWebView miniWebView = this.f346212d;
            if (miniWebView == null) {
                return;
            }
            miniWebView.evaluateSubscribeJS(str, str2, GetJsRuntimeListener.this.webViewId);
        }
    }

    public static CoverView.JsRuntimeListener get(IMiniAppContext iMiniAppContext, int i3) {
        GetJsRuntimeListener getJsRuntimeListener = new GetJsRuntimeListener();
        getJsRuntimeListener.webViewId = i3;
        return (CoverView.JsRuntimeListener) iMiniAppContext.performAction(getJsRuntimeListener);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public CoverView.JsRuntimeListener perform(BaseRuntime baseRuntime) {
        if (baseRuntime.isContainer()) {
            return new a(((ax) baseRuntime).s(this.webViewId));
        }
        IPage page = baseRuntime.getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            QMLog.w(Action.TAG, "Excepted AppBrandPageContainer, but is " + page);
            return null;
        }
        return ((AppBrandPageContainer) page).getJsRuntimeListener();
    }
}
