package com.tencent.qqmini.nativePlugins;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.CMShowSetPetStatusServlet;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.action.PhoneNumberAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.plugins.engine.JsPluginEngine;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class b extends BaseJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f347018d;

    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.nativePlugins.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9399b implements PhoneNumberAction.PhoneNumberActionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f347021a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AuthState f347022b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f347023c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347024d;

        C9399b(String str, AuthState authState, String str2, RequestEvent requestEvent) {
            this.f347021a = str;
            this.f347022b = authState;
            this.f347023c = str2;
            this.f347024d = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.action.PhoneNumberAction.PhoneNumberActionCallback
        public void onGetAuthDialogRet(boolean z16, JSONObject jSONObject) {
            QLog.i("CMShowJsPlugin", 2, "showRequestPermissionDialog ret: " + z16 + ", " + jSONObject + ", " + ((BaseJsPlugin) b.this).mApkgInfo.appId);
            if (z16) {
                b.this.i(this.f347021a);
                this.f347022b.setAuthState(this.f347023c, true);
                b.this.h(this.f347024d);
            } else {
                this.f347022b.setAuthState(this.f347023c, false);
                this.f347024d.fail();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class c implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f347026a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347027b;

        /* compiled from: P */
        /* loaded from: classes34.dex */
        class a implements Downloader.DownloadListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JSONObject f347029a;

            a(JSONObject jSONObject) {
                this.f347029a = jSONObject;
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                try {
                    QLog.i("CMShowJsPlugin", 1, "get res from local succeed.");
                    JSONObject jSONObject = this.f347029a;
                    if (jSONObject != null && jSONObject.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D).get("local_face_data") != null && this.f347029a.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D).getJSONArray("local_dress_res") != null && this.f347029a.getJSONArray("avtr").getJSONObject(0).getJSONObject(GetCMShowInfoServlet.EXTRA_AVATAR_TYPE_3D).getJSONArray("local_dress_res").length() != 0) {
                        c.this.f347027b.ok(this.f347029a);
                    } else {
                        QLog.e("CMShowJsPlugin", 1, "invalid callback resultData!");
                        c.this.f347027b.fail();
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    c.this.f347027b.fail();
                }
                b.f347018d = false;
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str, DownloadResult downloadResult) {
                QLog.i("CMShowJsPlugin", 1, "get res from local failed.");
                c.this.f347027b.fail();
                b.f347018d = false;
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str) {
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str, long j3, float f16) {
            }
        }

        c(boolean z16, RequestEvent requestEvent) {
            this.f347026a = z16;
            this.f347027b = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            String str;
            if (z16 && jSONObject != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(GetCMShowInfoServlet.EXTRA_RESULT_DATA));
                    QLog.i("CMShowJsPlugin", 1, "pre-resultData ready");
                    if (this.f347026a) {
                        if (!b.f347018d) {
                            b.f347018d = true;
                            CMShowKitFileManager.l(jSONObject2, ((BaseJsPlugin) b.this).mMiniAppContext, new a(jSONObject2));
                            return;
                        } else {
                            QLog.i("CMShowJsPlugin", 1, "isRequesting...avoid duplicate request.");
                            return;
                        }
                    }
                    this.f347027b.ok(jSONObject2);
                    return;
                } catch (Throwable unused) {
                    this.f347027b.fail();
                    return;
                }
            }
            if (jSONObject != null) {
                str = jSONObject.optString("errMsg");
            } else {
                str = "";
            }
            this.f347027b.fail(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(RequestEvent requestEvent) {
        if (requestEvent == null) {
            QLog.e("CMShowJsPlugin", 1, "[getCMShowInfo] error! req is null!");
            return;
        }
        try {
            String str = getMiniAppInfo().appId;
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject.getString("openid");
            if (TextUtils.isEmpty(string)) {
                requestEvent.fail("invalid params!");
                return;
            }
            String string2 = jSONObject.getString(TagName.ENGINE_TYPE);
            if (!"laya".equals(string2) && !"egret".equals(string2) && !"cocos".equals(string2)) {
                requestEvent.fail("invalid params!");
                return;
            }
            String string3 = jSONObject.getString("engineVersion");
            String optString = jSONObject.optString("avatarType", "3D");
            if (!"2D".equals(optString) && !"3D".equals(optString)) {
                requestEvent.fail("invalid params!");
            } else {
                MiniAppCmdUtil.getInstance().getCMShowInfo(string, str, string2, string3, optString, new c(jSONObject.optBoolean("useLocalRes", false), requestEvent));
            }
        } catch (Throwable th5) {
            QLog.e("CMShowJsPlugin", 1, 1, "[getCMShowInfo] error! ", th5);
            requestEvent.fail("invalid params!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        if ("2D".equals(str)) {
            QIPCClientHelper.getInstance().callServer("cm_game_module", "action_open_cmshow_2d", null, null);
        } else if ("3D".equals(str)) {
            QIPCClientHelper.getInstance().callServer("cm_game_module", "action_open_cmshow_3d", null, null);
        }
    }

    @JsEvent({PluginConst.CMShowJsPluginConst.API_GET_CM_SHOW_INFO})
    public void getCmShowInfo(RequestEvent requestEvent) {
        String str;
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext instanceof BaseRuntime) {
            Context context = iMiniAppContext.getContext();
            if (context == null) {
                QLog.e("CMShowJsPlugin", 1, "getCmShowInfo context is null");
                requestEvent.fail();
                return;
            }
            if (((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableCmShowGameMiniApiUsgReduce()) {
                h(requestEvent);
                return;
            }
            IJsPluginEngine jsPluginEngine = ((BaseRuntime) this.mMiniAppContext).getJsPluginEngine();
            if (jsPluginEngine instanceof JsPluginEngine) {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    PermissionInfo permissionInfo = new PermissionInfo();
                    permissionInfo.reportSubAction = PluginConst.CMShowJsPluginConst.API_GET_CM_SHOW_INFO;
                    permissionInfo.rejectDescription = context.getString(R.string.f167252cf);
                    String optString = jSONObject.optString("avatarType", "2D");
                    if ("2D".equalsIgnoreCase(optString)) {
                        str = "scope.cmshowInfo2d";
                        permissionInfo.name = context.getString(R.string.f167212cb);
                        permissionInfo.description = context.getString(R.string.f167232cd);
                    } else if ("3D".equalsIgnoreCase(optString)) {
                        str = "scope.cmshowInfo3d";
                        permissionInfo.name = context.getString(R.string.f167222cc);
                        permissionInfo.description = context.getString(R.string.f167242ce);
                    } else {
                        QLog.e("CMShowJsPlugin", 1, "wrong avatarType: " + optString);
                        requestEvent.fail();
                        return;
                    }
                    String str2 = str;
                    AuthState authSate = MiniAppEnv.g().getAuthSate(this.mApkgInfo.appId);
                    if (authSate.getAuthFlag(str2) == 2) {
                        h(requestEvent);
                        return;
                    }
                    jSONObject.put("scope", str2);
                    requestEvent.jsonParams = jSONObject.toString();
                    PermissionManager.g().updateScopePermission(str2, permissionInfo);
                    ((JsPluginEngine) jsPluginEngine).showRequestPermissionDialog(requestEvent, new C9399b(optString, authSate, str2, requestEvent));
                    return;
                } catch (Exception e16) {
                    QLog.e("CMShowJsPlugin", 1, "getCmShowInfo error", e16);
                    requestEvent.fail();
                    return;
                }
            }
            return;
        }
        QLog.e("CMShowJsPlugin", 1, "getCmShowInfo miniAppContext: " + this.mMiniAppContext);
        requestEvent.fail();
    }

    @JsEvent({"setCMShowPetStatus"})
    public void setCMShowPetStatus(RequestEvent requestEvent) {
        if (requestEvent == null) {
            QLog.e("CMShowJsPlugin", 1, "[setCMShowPetStatus] error! req is null!");
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
            MiniAppCmdUtil.getInstance().setCMShowPetStatus(optJSONObject.optInt("roleId"), optJSONObject.optInt(CMShowSetPetStatusServlet.EXTRA_PET_STATUS), new a(requestEvent));
        } catch (Throwable th5) {
            QLog.e("CMShowJsPlugin", 1, 1, "[setCMShowPetStatus] error! ", th5);
            requestEvent.fail("invalid params!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347019a;

        a(RequestEvent requestEvent) {
            this.f347019a = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            String str;
            if (z16) {
                this.f347019a.ok(jSONObject);
                return;
            }
            if (jSONObject != null) {
                str = jSONObject.optString("errMsg");
            } else {
                str = "";
            }
            this.f347019a.fail(str);
        }
    }
}
