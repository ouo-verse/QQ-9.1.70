package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.inner.auth.QQAuth;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\b\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\n\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqmini/nativePlugins/ad;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "", "retCode", "", "errMsg", "", "d", "proxyAuthCode", "f", "jsonString", "Lcom/tencent/open/inner/auth/QQAuth$AuthParams;", "g", "req", "openConnectAuthorize", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ad extends BaseJsPlugin {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqmini/nativePlugins/ad$b", "Lcom/tencent/qqmini/sdk/launcher/shell/IActivityResultListener;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "doOnActivityResult", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IActivityResultListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f346986a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IActivityResultManager f346987b;

        b(c cVar, IActivityResultManager iActivityResultManager) {
            this.f346986a = cVar;
            this.f346987b = iActivityResultManager;
        }

        @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
        public boolean doOnActivityResult(int requestCode, int resultCode, Intent data) {
            if (!this.f346986a.onActivityResult(requestCode, resultCode, data)) {
                return false;
            }
            this.f346987b.removeActivityResultListener(this);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/qqmini/nativePlugins/ad$c", "Lwp3/b;", "", "response", "", "onComplete", "Lwp3/a;", "e", "onError", "onCancel", "", "code", "onWarning", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends wp3.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346989b;

        c(RequestEvent requestEvent) {
            this.f346989b = requestEvent;
        }

        @Override // wp3.b
        public void onCancel() {
            QMLog.e(wp3.b.TAG, "onCancel");
            ad.e(ad.this, this.f346989b, 0, "Authorize canceled", 1, null);
        }

        @Override // wp3.b
        public void onComplete(Object response) {
            QMLog.i(wp3.b.TAG, "onComplete: rsp=" + response);
            if (response instanceof JSONObject) {
                String authCode = ((JSONObject) response).optString("proxy_code");
                if (!(authCode == null || authCode.length() == 0)) {
                    ad adVar = ad.this;
                    RequestEvent requestEvent = this.f346989b;
                    Intrinsics.checkNotNullExpressionValue(authCode, "authCode");
                    adVar.f(requestEvent, authCode);
                    return;
                }
            }
            ad.e(ad.this, this.f346989b, 0, "Authorize completed but proxy_code is empty", 1, null);
        }

        @Override // wp3.b
        public void onError(wp3.a e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            QMLog.e(wp3.b.TAG, "onError: errCode=" + e16.f446029a + ", errMsg=" + e16.f446030b);
            ad.this.d(this.f346989b, e16.f446029a, e16.f446030b);
        }

        @Override // wp3.b
        public void onWarning(int code) {
            QMLog.e(wp3.b.TAG, "onWarning: code=" + code);
            ad.e(ad.this, this.f346989b, code, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(RequestEvent requestEvent, int i3, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", i3);
        requestEvent.fail(jSONObject, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(RequestEvent requestEvent, String str) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("proxyAuthCode", str);
        requestEvent.ok(jSONObject);
    }

    private final QQAuth.AuthParams g(String jsonString) {
        Bundle bundle;
        if (jsonString == null || jsonString.length() == 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonString).getJSONObject("data");
            String appId = jSONObject.getString("appId");
            String proxyAppId = jSONObject.getString("proxyAppId");
            String proxyAppName = jSONObject.getString("proxyAppName");
            String permissions = jSONObject.getString("permissions");
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            if (!(appId.length() == 0)) {
                Intrinsics.checkNotNullExpressionValue(proxyAppId, "proxyAppId");
                if (!(proxyAppId.length() == 0)) {
                    Intrinsics.checkNotNullExpressionValue(proxyAppName, "proxyAppName");
                    if (!(proxyAppName.length() == 0)) {
                        Intrinsics.checkNotNullExpressionValue(permissions, "permissions");
                        if (!(permissions.length() == 0)) {
                            String base64EncodeNoWrap = QQAuth.AuthParams.base64EncodeNoWrap(jSONObject.optString("clientage_token"));
                            if (TextUtils.isEmpty(base64EncodeNoWrap)) {
                                bundle = null;
                            } else {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("key_proxy_token", base64EncodeNoWrap);
                                bundle = bundle2;
                            }
                            return new QQAuth.AuthParams(proxyAppId, appId, proxyAppName, permissions, bundle);
                        }
                    }
                }
            }
            return null;
        } catch (JSONException e16) {
            QMLog.e("OpenConnectPlugin", "buildAuthParamFromReqData failed ---> ", e16);
            return null;
        }
    }

    @JsEvent({"openConnectAuthorize"})
    public final void openConnectAuthorize(RequestEvent req) {
        Intrinsics.checkNotNullParameter(req, "req");
        QQAuth.AuthParams g16 = g(req.jsonParams);
        if (g16 == null) {
            e(this, req, 0, "invalid params", 1, null);
            return;
        }
        c cVar = new c(req);
        IActivityResultManager activityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
        if (activityResultManager != null) {
            activityResultManager.addActivityResultListener(new b(cVar, activityResultManager));
        }
        QQAuth qQAuth = QQAuth.getInstance();
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        qQAuth.proxyAuth(iMiniAppContext != null ? iMiniAppContext.getAttachActivity() : null, cVar, g16);
    }

    static /* synthetic */ void e(ad adVar, RequestEvent requestEvent, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = -1;
        }
        if ((i16 & 2) != 0) {
            str = "unknown error";
        }
        adVar.d(requestEvent, i3, str);
    }
}
