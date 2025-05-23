package com.tencent.qqmini.nativePlugins;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.timiqqid.api.ITimiQQIDApi;
import com.tencent.mobileqq.timiqqid.constants.QQIDConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class aj extends BaseJsPlugin {

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements pr2.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346992a;

        a(RequestEvent requestEvent) {
            this.f346992a = requestEvent;
        }

        @Override // pr2.d
        public void a(int i3, int i16, int i17, JSONObject jSONObject, JSONArray jSONArray) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("selfInfo", jSONObject);
                jSONObject2.put("familyInfoList", jSONArray);
                jSONObject2.put("familyListSuccess", i17);
                jSONObject2.put("errorDomain", i3);
                jSONObject2.put("errorCode", i16);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "queryHealthCode,build result fail," + e16.getMessage());
            }
            if (QLog.isColorLevel()) {
                QLog.e("ScityIdentifyPlugin", 2, "queryHealthCode,result:" + jSONObject2);
            }
            this.f346992a.ok(jSONObject2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346998a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f346999b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f347000c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f347001d;

        d(RequestEvent requestEvent, boolean z16, boolean z17, boolean z18) {
            this.f346998a = requestEvent;
            this.f346999b = z16;
            this.f347000c = z17;
            this.f347001d = z18;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            aj.this.d(this.f346998a, this.f346999b, this.f347000c, this.f347001d);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            aj.this.d(this.f346998a, this.f346999b, this.f347000c, this.f347001d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class e implements pr2.b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347003a;

        e(RequestEvent requestEvent) {
            this.f347003a = requestEvent;
        }

        @Override // pr2.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str, int i3, String str2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wxCode", str);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "requestMiniProgramCode,parse param fail," + e16.getMessage());
            }
            this.f347003a.ok(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(RequestEvent requestEvent, boolean z16, boolean z17, boolean z18) {
        JSONObject jSONObject = new JSONObject();
        if (z16) {
            try {
                jSONObject.put("hasLbsPermission", ContextCompat.checkSelfPermission(BaseApplication.context, "android.permission.ACCESS_FINE_LOCATION") == 0);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "callbackRequestPermission,parse param fail," + e16.getMessage());
            }
        }
        if (z17) {
            jSONObject.put("hasNotifyPermission", QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.context));
        }
        if (z18) {
            jSONObject.put("hasCameraPermission", ContextCompat.checkSelfPermission(BaseApplication.context, QQPermissionConstants.Permission.CAMERA) == 0);
        }
        requestEvent.ok(jSONObject);
    }

    @JsEvent({"scityCheckIsAlphaUser"})
    public void checkIsAlphaUser(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 1, "scityCheckIsAlphaUser called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            boolean z16 = false;
            try {
                JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
                if (optJSONObject != null) {
                    z16 = optJSONObject.optBoolean("useCache", false);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "checkIsQQIDAlphaUser,parse param fail," + e16.getMessage());
            }
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).checkIsQQIDAlphaUser(z16, this.mMiniAppInfo.appId, new b(requestEvent));
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityCheckPermission"})
    public void checkQQIDPermission(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 1, "scityCheckPermission called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            boolean z16 = ContextCompat.checkSelfPermission(BaseApplication.context, "android.permission.ACCESS_FINE_LOCATION") == 0;
            boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.context);
            boolean z17 = ContextCompat.checkSelfPermission(BaseApplication.context, "android.permission.ACCESS_FINE_LOCATION") == 0;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hasLbsPermission", z16);
                jSONObject.put("hasNotifyPermission", areNotificationsEnabled);
                jSONObject.put("hasCameraPermission", z17);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "checkQQIDPermission,parse param fail," + e16.getMessage());
            }
            requestEvent.ok(jSONObject);
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityGetSceneRecognitionEnable"})
    public void getSceneRecognitionEnable(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityGetSceneRecognitionEnable called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            int sceneRecognitionEnable = ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).getSceneRecognitionEnable();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("enable", sceneRecognitionEnable);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            requestEvent.ok(jSONObject);
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityGotoQQChannel"})
    public void gotoQQChannel(RequestEvent requestEvent) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityGotoQQChannel called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            try {
                str = new JSONObject(requestEvent.jsonParams).getJSONObject("data").optString("channelUrl");
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "gotoQQChannel,parse param fail," + e16.getMessage());
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                requestEvent.fail();
                return;
            }
            if (HttpUtil.isValidUrl(str)) {
                Intent intent = new Intent(BaseApplication.context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                BaseApplication.context.startActivity(intent);
            } else {
                Intent intent2 = new Intent(BaseApplication.context, (Class<?>) JumpActivity.class);
                intent2.setData(Uri.parse(str));
                BaseApplication.context.startActivity(intent2);
            }
            requestEvent.ok();
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityOpenRealNameWebview"})
    public void openRealNameWebview(RequestEvent requestEvent) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 1, "scityOpenRealNameWebview called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            try {
                str = new JSONObject(requestEvent.jsonParams).getJSONObject("data").optString("url");
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("ScityIdentifyPlugin", 1, "openRealNameWebview,parse param fail," + e16.getMessage());
                }
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                requestEvent.fail("url is empty");
                return;
            } else {
                ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).openRealNameWebview(BaseApplication.context, str);
                requestEvent.ok();
                return;
            }
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityQueryHealthCode"})
    public void queryHealthCode(RequestEvent requestEvent) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityQueryHealthCode called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            int i3 = 0;
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                i3 = jSONObject.getJSONObject("data").optInt("permissionType");
                str = jSONObject.getJSONObject("data").optString("returnScheme");
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("ScityIdentifyPlugin", 1, "queryHealthCode,parse param fail," + e16.getMessage());
                }
                str = "";
            }
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).fetchYuekangmaData(i3, str, new a(requestEvent));
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityRequestMiniProgramCode"})
    public void requestMiniProgramCode(RequestEvent requestEvent) {
        String str;
        String str2 = "";
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityRequestMiniProgramCode called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                str = jSONObject.getJSONObject("data").optString("wxAppId");
                try {
                    str2 = jSONObject.getJSONObject("data").optString("returnScheme");
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("ScityIdentifyPlugin", 1, "requestMiniProgramCode,parse param fail," + e.getMessage());
                    }
                    if (TextUtils.isEmpty(str)) {
                    }
                    requestEvent.fail("appId or returnScheme is empty");
                    return;
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).requestWxCode(str, str2, new e(requestEvent));
                return;
            } else {
                requestEvent.fail("appId or returnScheme is empty");
                return;
            }
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    @JsEvent({"scityRequestPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestQQIDPermission(RequestEvent requestEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        QBaseActivity qBaseActivity;
        boolean z26;
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 1, "scityRequestPermission called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            boolean z27 = false;
            try {
                JSONObject optJSONObject = new JSONObject(requestEvent.jsonParams).optJSONObject("data");
                if (optJSONObject != null) {
                    z16 = optJSONObject.optBoolean("requestLbsPermission", false);
                    try {
                        z17 = optJSONObject.optBoolean("requestNotifyPermission", false);
                        try {
                            z26 = optJSONObject.optBoolean("requestCameraPermission", false);
                            z27 = z16;
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            QLog.e("ScityIdentifyPlugin", 1, "requestQQIDPermission,parse param fail," + e.getMessage());
                            z18 = false;
                            z19 = z16;
                            boolean z28 = z17;
                            if (z19) {
                            }
                            BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ID, QQPermissionConstants.Business.SCENE.QQID_SCENE_RECOGNITION);
                            qBaseActivity = QBaseActivity.sTopActivity;
                            if (qBaseActivity != null) {
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        z17 = false;
                    }
                } else {
                    z26 = false;
                    z17 = false;
                }
                z19 = z27;
                z18 = z26;
            } catch (Exception e18) {
                e = e18;
                z16 = false;
                z17 = false;
            }
            boolean z282 = z17;
            if (z19 && !z282 && !z18) {
                requestEvent.fail("no permission in param");
                return;
            }
            BusinessConfig businessConfig2 = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ID, QQPermissionConstants.Business.SCENE.QQID_SCENE_RECOGNITION);
            qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                requestEvent.fail("top activity is null");
                return;
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(qBaseActivity, businessConfig2);
            ArrayList arrayList = new ArrayList();
            if (z19) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (z282) {
                arrayList.add(QQPermissionConstants.Permission.PERMISSION_NOTIFICATION);
            }
            if (z18) {
                arrayList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (arrayList.size() > 2) {
                requestEvent.fail("cannot request more than 2 permissions");
                return;
            }
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            qQPermission.requestPermissions(strArr, 2, new d(requestEvent, z19, z282, z18));
            return;
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityQuerySceneRecognitionMaxAge"})
    public void requestSceneRecognitionMaxAge(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityQuerySceneRecognitionMaxAge called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).requestSceneRecognitionMaxAge(2, new f(requestEvent));
        } else {
            requestEvent.fail("no permission");
            QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
        }
    }

    @JsEvent({"scitySetAsAlphaUser"})
    public void setAsAlphaUser(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 1, "scitySetAsAlphaUser called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).setQQIDAlphaUser(this.mMiniAppInfo.appId, new c(requestEvent));
        } else {
            requestEvent.fail("no permission");
            QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
        }
    }

    @JsEvent({"scitySetSceneRecognitionEnable"})
    public void setSceneRecognitionEnable(final RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scitySetSceneRecognitionEnable called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).setSceneRecognitionEnable(jSONObject.getJSONObject("data").optInt("enable"), jSONObject.getJSONObject("data").optString("openId"), new pr2.a() { // from class: com.tencent.qqmini.nativePlugins.ai
                    @Override // pr2.a
                    public final void onCallback(int i3, String str) {
                        aj.e(RequestEvent.this, i3, str);
                    }
                });
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("ScityIdentifyPlugin", 1, "gotoQQChannel,parse param fail," + e16.getMessage());
                requestEvent.fail();
                return;
            }
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    @JsEvent({"scityStartFetchPassResult"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startFetchPassResult(RequestEvent requestEvent) {
        String str;
        String str2 = "";
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityStartFetchPassResult called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams).getJSONObject("data");
                str = Uri.decode(jSONObject.optString("url", ""));
                try {
                    str2 = jSONObject.optString("cookie", "");
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    QLog.e("ScityIdentifyPlugin", 1, "startFetchPassResult,parse param fail," + e.getMessage());
                    if (HttpUtil.isValidUrl(str)) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                str = "";
            }
            if (HttpUtil.isValidUrl(str)) {
                requestEvent.fail();
                return;
            } else {
                ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).startFetchPassResult(str, str2);
                requestEvent.ok();
                return;
            }
        }
        requestEvent.fail("no permission");
        QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
    }

    @JsEvent({"scityStopFetchPassResult"})
    public void stopFetchPassResult(RequestEvent requestEvent) {
        if (QLog.isColorLevel()) {
            QLog.d("ScityIdentifyPlugin", 2, "scityStopFetchPassResult called,params:" + requestEvent.jsonParams);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && QQIDConstants.isWhiteAppId(miniAppInfo.appId)) {
            ((ITimiQQIDApi) QRoute.api(ITimiQQIDApi.class)).stopFetchPassResult();
            requestEvent.ok();
        } else {
            requestEvent.fail("no permission");
            QLog.e("ScityIdentifyPlugin", 1, "appId no permission");
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b implements pr2.b<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346994a;

        b(RequestEvent requestEvent) {
            this.f346994a = requestEvent;
        }

        @Override // pr2.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool, int i3, String str) {
            boolean booleanValue;
            if (i3 == 0) {
                JSONObject jSONObject = new JSONObject();
                if (bool != null) {
                    try {
                        booleanValue = bool.booleanValue();
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        QLog.e("ScityIdentifyPlugin", 1, "startFetchPassResult,parse param fail," + e16.getMessage());
                    }
                } else {
                    booleanValue = false;
                }
                jSONObject.put("isAlphaUser", booleanValue);
                this.f346994a.ok(jSONObject);
                return;
            }
            this.f346994a.fail("error code:" + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c implements pr2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f346996a;

        c(RequestEvent requestEvent) {
            this.f346996a = requestEvent;
        }

        @Override // pr2.a
        public void onCallback(int i3, String str) {
            if (i3 == 0) {
                this.f346996a.ok();
            } else {
                this.f346996a.fail(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(RequestEvent requestEvent, int i3, String str) {
        if (i3 == 0) {
            requestEvent.ok();
        } else {
            requestEvent.fail(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class f implements pr2.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347005a;

        f(RequestEvent requestEvent) {
            this.f347005a = requestEvent;
        }

        @Override // pr2.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Long l3, int i3, String str) {
            if (i3 == 0 && l3 != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("maxAge", l3.toString());
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QLog.e("ScityIdentifyPlugin", 1, "requestSceneRecognitionMaxAge,parse param fail," + e16.getMessage());
                }
                this.f347005a.ok(jSONObject);
                return;
            }
            this.f347005a.fail(str);
        }
    }
}
