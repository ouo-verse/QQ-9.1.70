package com.tencent.qqmini.sdk.action;

import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a implements Action<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private b f348012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.sdk.action.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public class C9408a implements PhoneNumberAction.PhoneNumberActionCallback {
        C9408a() {
        }

        @Override // com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback
        public void onGetAuthDialogRet(boolean z16, JSONObject jSONObject) {
            a.this.f348012a.onCheckLocationPermissionAction(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface b {
        void onCheckLocationPermissionAction(boolean z16);
    }

    public static a b(b bVar) {
        a aVar = new a();
        aVar.f348012a = bVar;
        return aVar;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean perform(BaseRuntime baseRuntime) {
        AuthState authSate;
        MiniAppInfo miniAppInfo = baseRuntime.getMiniAppInfo();
        if (miniAppInfo != null && (authSate = MiniAppEnv.g().getAuthSate(miniAppInfo.appId)) != null && authSate.getAuthFlag(AuthorizeCenter.SCOPE_USER_LOCATION) == 2) {
            this.f348012a.onCheckLocationPermissionAction(true);
            return Boolean.TRUE;
        }
        IJsPluginEngine jsPluginEngine = baseRuntime.getJsPluginEngine();
        if (jsPluginEngine instanceof JsPluginEngine) {
            RequestEvent requestEvent = new RequestEvent();
            requestEvent.callbackId = this.f348012a.hashCode();
            requestEvent.event = "getLocation";
            ((JsPluginEngine) jsPluginEngine).showRequestPermissionDialog(requestEvent, new C9408a());
        }
        return Boolean.TRUE;
    }
}
