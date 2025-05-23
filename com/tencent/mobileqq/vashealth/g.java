package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.vashealth.api.IPathTraceManager;
import com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class g extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    public Activity f312271d;

    /* renamed from: e, reason: collision with root package name */
    public AppInterface f312272e;

    /* renamed from: f, reason: collision with root package name */
    private LocationManager f312273f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f312274h;

    /* renamed from: i, reason: collision with root package name */
    private QQPermission f312275i = null;

    /* renamed from: m, reason: collision with root package name */
    private BusinessConfig f312276m = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_HEALTH, QQPermissionConstants.Business.SCENE.HEALTH_COMMUNITY);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    @Nullable
    private JSONObject A(JSONObject jSONObject, String str, IPathTraceManager iPathTraceManager) throws JSONException {
        int i3;
        JSONObject jSONObject2 = new JSONObject();
        if (SensorMonitor.getDefaultSensor((SensorManager) this.f312271d.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR), 19) == null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        jSONObject2.put("stepAuth", i3);
        if (!s()) {
            F();
            jSONObject2.put("retCode", -2);
        } else {
            iPathTraceManager.startPathTrace(jSONObject, q());
        }
        return jSONObject2;
    }

    @NotNull
    private JSONObject B(IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", 1);
        jSONObject.put("runningState", iPathTraceManager.getRunningStatus());
        if (iPathTraceManager.getRunningStatus() != 0) {
            TracePathData tracePathData = (TracePathData) iPathTraceManager.getPathTrace();
            if (tracePathData == null) {
                tracePathData = (TracePathData) iPathTraceManager.getLastUnCompletedTrace();
            }
            if (tracePathData != null) {
                jSONObject.put("type", tracePathData.type);
            } else {
                QLog.i("PathTraceManager.Plugin", 1, "pathtrace type err");
            }
        }
        return jSONObject;
    }

    private void C(JSONObject jSONObject, String str, IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (!jSONObject.has("startTime")) {
            jSONObject2.put("retCode", -12);
            jSONObject2.put("message", "invalid startTime");
            super.callJs(str, jSONObject2.toString());
            return;
        }
        iPathTraceManager.pathTraceUpload(jSONObject.optLong("startTime"), str);
    }

    @NotNull
    private JSONObject D(String str, String str2, IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            JSONObject queryPathData = iPathTraceManager.queryPathData(str2);
            jSONObject.put("retCode", 1);
            jSONObject.put("records", queryPathData.toString());
        } else {
            jSONObject.put("retCode", -8);
        }
        return jSONObject;
    }

    private String E(String str, float f16, float f17) {
        String str2;
        if (str.contains("lati")) {
            str2 = str.replace("lati=" + Uri.parse(str).getQueryParameter("lati"), "lati=" + f17);
        } else {
            str2 = str + "&lati=" + f17;
        }
        if (str2.contains("logi")) {
            return str2.replace("logi=" + Uri.parse(str2).getQueryParameter("logi"), "logi=" + f16);
        }
        return str2 + "&logi=" + f16;
    }

    private void F() {
        QQPermission qQPermission = this.f312275i;
        if (qQPermission != null) {
            qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_LOCATION, 2, new a());
        }
    }

    private void G(IPathTraceManager iPathTraceManager, int i3) {
        if (i3 == 1) {
            iPathTraceManager.setIsMute(true);
        } else if (i3 == 0) {
            iPathTraceManager.setIsMute(false);
        }
    }

    private void H() {
        try {
            this.mRuntime.c().getApplicationContext().stopService(new Intent(this.mRuntime.c().getApplicationContext(), (Class<?>) PathTraceService.class));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("PathTraceManager.Plugin", 2, "", th5);
            }
        }
        QLog.i("PathTraceManager.Plugin", 1, "stopPathTraceService");
    }

    private String p(Map<String, Object> map, IPathTraceManager iPathTraceManager, Uri uri) {
        if (uri.getQuery() != null) {
            if (uri.getQueryParameter("runningState") != null) {
                return String.valueOf(map.get("url")).replace("runningState=" + uri.getQueryParameter("runningState"), "runningState=" + iPathTraceManager.getRunningStatus());
            }
            return map.get("url") + "&runningState=" + iPathTraceManager.getRunningStatus();
        }
        return map.get("url") + "?runningState=" + iPathTraceManager.getRunningStatus();
    }

    private String q() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || bVar.e() == null) {
            return "";
        }
        String originalUrl = this.mRuntime.e().getOriginalUrl();
        if (TextUtils.isEmpty(originalUrl)) {
            return "";
        }
        return originalUrl.replaceAll("isFromKuiklyWebview=\\d+", "");
    }

    @NotNull
    private Long r(IPathTraceManager iPathTraceManager, JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.optLong("startTime"));
        if (valueOf.longValue() == 0 && iPathTraceManager.getLastUnCompletedTrace() != null) {
            return Long.valueOf(((TracePointsData) iPathTraceManager.getLastUnCompletedTrace()).startTime);
        }
        return valueOf;
    }

    private boolean s() {
        if (this.f312275i == null) {
            t();
        }
        QQPermission qQPermission = this.f312275i;
        if (qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_HEALTH, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private void t() {
        if (this.f312271d != null) {
            this.f312275i = QQPermissionFactory.getQQPermission(this.mRuntime.a(), this.f312276m);
        }
    }

    private boolean u(String str, String str2, String str3) {
        if (str != null && "healthpathtrace".equals(str2) && str3 != null) {
            return false;
        }
        return true;
    }

    public static boolean v(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("__page=run")) {
            return true;
        }
        return false;
    }

    private boolean w(long j3) {
        if (j3 != 8589934597L && j3 != 2 && j3 != 32) {
            return false;
        }
        return true;
    }

    @NotNull
    private JSONObject x(JSONObject jSONObject, IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject2;
        SharedPreferences sharedPreferences;
        String str;
        int i3;
        JSONObject jSONObject3;
        JSONObject jSONObject4 = new JSONObject();
        TracePathData tracePathData = (TracePathData) iPathTraceManager.getPathTrace();
        if (tracePathData == null) {
            tracePathData = (TracePathData) iPathTraceManager.getLastUnCompletedTrace();
        }
        if (tracePathData == null) {
            jSONObject4.put("retCode", -8);
            QLog.e("PathTraceManager.Plugin", 1, "PathTraceEnd Err");
            jSONObject3 = jSONObject4;
            str = "PathTraceManager.Plugin";
        } else {
            long optLong = jSONObject.optLong("totalTime", tracePathData.totalTime);
            if (iPathTraceManager.pathTraceEnd(optLong, q())) {
                jSONObject4.put("retCode", 1);
            } else {
                jSONObject4.put("retCode", -5);
            }
            jSONObject4.put("startTime", tracePathData.startTime);
            JSONArray jSONArray = new JSONArray();
            SharedPreferences sharedPreferences2 = this.mRuntime.b().getApplication().getSharedPreferences(String.valueOf(tracePathData.startTime), 0);
            long j3 = sharedPreferences2.getLong(String.valueOf(PathTraceManagerImpl.LAST_TIME), 0L);
            float f16 = sharedPreferences2.getFloat(String.valueOf(PathTraceManagerImpl.LAST_DISTANCE), 0.0f);
            long j16 = optLong - j3;
            if (j16 > 0) {
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                String valueOf = String.valueOf((int) ((tracePathData.distance / 1000.0d) + 1.0d));
                StringBuilder sb5 = new StringBuilder();
                jSONObject2 = jSONObject4;
                sb5.append((int) (j16 / ((tracePathData.distance - f16) / 1000.0d)));
                sb5.append(",0,0");
                edit.putString(valueOf, sb5.toString()).apply();
                i3 = 1;
                QLog.d("PathTraceManager.Plugin", 1, ">0 toalTime:" + optLong + ",lastspeedtime:" + j3 + ",distance:" + tracePathData.distance + ",lastdistance:" + f16);
                sharedPreferences = sharedPreferences2;
                str = "PathTraceManager.Plugin";
            } else {
                jSONObject2 = jSONObject4;
                TracePathData tracePathData2 = tracePathData;
                if (tracePathData2.totalTime - j3 > 0) {
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    String valueOf2 = String.valueOf((int) ((tracePathData2.distance / 1000.0d) + 1.0d));
                    StringBuilder sb6 = new StringBuilder();
                    sharedPreferences = sharedPreferences2;
                    sb6.append((int) ((tracePathData2.totalTime - j3) / ((tracePathData2.distance - f16) / 1000.0d)));
                    sb6.append(",0,0");
                    edit2.putString(valueOf2, sb6.toString()).apply();
                    str = "PathTraceManager.Plugin";
                    i3 = 1;
                    QLog.d(str, 1, "<0 toalTime:" + optLong + ",lastspeedtime:" + j3 + ",distance:" + tracePathData2.distance + ",lastdistance:" + f16);
                } else {
                    sharedPreferences = sharedPreferences2;
                    str = "PathTraceManager.Plugin";
                    i3 = 1;
                    QLog.d(str, 1, "<>0exception toalTime:" + optLong + ",lastspeedtime:" + j3 + ",distance:" + tracePathData2.distance + ",lastdistance:" + f16);
                }
            }
            SharedPreferences sharedPreferences3 = sharedPreferences;
            String string = sharedPreferences3.getString(String.valueOf(i3), null);
            int i16 = 1;
            while (string != null) {
                String[] split = string.split(",");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("km", String.valueOf(i16));
                jSONObject5.put("time", split[0]);
                jSONObject5.put("latitude", split[1]);
                jSONObject5.put("longitude", split[2]);
                jSONArray.mo162put(jSONObject5);
                i16++;
                string = sharedPreferences3.getString(String.valueOf(i16), null);
            }
            jSONObject3 = jSONObject2;
            jSONObject3.put("kmrecords", jSONArray);
        }
        QLog.d(str, 1, "end result data:" + jSONObject3.toString());
        return jSONObject3;
    }

    @NotNull
    private JSONObject y(IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!s()) {
            jSONObject.put("retCode", -2);
        } else {
            jSONObject.put("retCode", 1);
            if (iPathTraceManager != null && iPathTraceManager.getLastUnCompletedTrace() != null) {
                jSONObject.put("retCode", -7);
                jSONObject.put("startTime", ((TracePathData) iPathTraceManager.getLastUnCompletedTrace()).startTime);
                jSONObject.put("records", iPathTraceManager.queryPathData(null).toString());
            }
        }
        return jSONObject;
    }

    @Nullable
    private JSONObject z(String str, IPathTraceManager iPathTraceManager) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!this.f312273f.isProviderEnabled("gps")) {
            jSONObject.put("retCode", -2);
            super.callJs(str, jSONObject.toString());
            return null;
        }
        if (((TracePathData) iPathTraceManager.getPathTrace()) == null) {
            jSONObject.put("retCode", -12);
            jSONObject.put("message", "invalid startTime");
        } else if (!s()) {
            F();
            jSONObject.put("retCode", -2);
            super.callJs(str, jSONObject.toString());
        } else {
            iPathTraceManager.pathTraceResume(q());
            jSONObject.put("retCode", 1);
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "healthpathtrace";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 8589934631L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00dc  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        String str2;
        float f16;
        IPathTraceManager iPathTraceManager = (IPathTraceManager) this.f312272e.getRuntimeService(IPathTraceManager.class, "tool");
        boolean v3 = v(str);
        this.f312274h = v3;
        boolean z16 = false;
        if (!v3) {
            return false;
        }
        iPathTraceManager.registerWebViewPlug(this);
        if (!w(j3)) {
            return false;
        }
        if (j3 == 8589934597L && iPathTraceManager.getEngineWorkingMode() == 0) {
            iPathTraceManager.stopLocation(0, q());
            str2 = "pause";
        } else if (j3 == 2 && iPathTraceManager.getEngineWorkingMode() == 0) {
            if (!s()) {
                F();
            } else {
                iPathTraceManager.startLocation(0, q());
            }
            str2 = "resume";
        } else {
            if (j3 == 32) {
                String p16 = p(map, iPathTraceManager, Uri.parse(str));
                SharedPreferences sharedPreferences = this.f312272e.getApplication().getSharedPreferences(this.mRuntime.b().getCurrentAccountUin(), 0);
                float f17 = 0.0f;
                if (System.currentTimeMillis() - sharedPreferences.getLong("search_lbs_timestamp", 0L) < 10800000) {
                    float f18 = sharedPreferences.getFloat("search_lbs_logitude", 0.0f);
                    f16 = sharedPreferences.getFloat("search_lbs_latitude", 0.0f);
                    f17 = f18;
                } else {
                    f16 = 0.0f;
                }
                String E = E(p16, f17, f16);
                map.put("url", E);
                if (QLog.isColorLevel()) {
                    QLog.d("PathTraceManager.Plugin", 2, "Intercep url:" + E);
                }
            }
            str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                QLog.i("PathTraceManager.Plugin", 1, "webview event type:" + j3 + ", event name: " + str2);
            }
            return z16;
        }
        z16 = true;
        if (!TextUtils.isEmpty(str2)) {
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        String str4;
        String str5;
        boolean z16;
        if (u(str, str2, str3)) {
            return false;
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
            if (jsonFromJSBridge != null) {
                str4 = jsonFromJSBridge.getString("callback");
                QLog.i("PathTraceManager.Plugin", 1, "handleJsRequest method: " + str3 + ", args: " + jsonFromJSBridge.toString());
            } else {
                str4 = null;
            }
            str5 = strArr[0];
        } catch (Exception e16) {
            QLog.i("PathTraceManager.Plugin", 1, "HandleJs Err:" + e16.toString());
        }
        if (TextUtils.isEmpty(str4)) {
            QLog.e("PathTraceManager.Plugin", 1, "need callback");
            return true;
        }
        IPathTraceManager iPathTraceManager = (IPathTraceManager) this.f312272e.getRuntimeService(IPathTraceManager.class, "tool");
        if ("PathTraceStatus".equals(str3)) {
            super.callJs(str4, B(iPathTraceManager).toString());
        } else if ("PathTraceInit".equals(str3)) {
            callJs(str4, y(iPathTraceManager).toString());
        } else if ("PathTraceOriginLocation".equals(str3)) {
            if (iPathTraceManager.getEngineWorkingMode() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retCode", -4);
                super.callJs(str4, jSONObject.toString());
            } else {
                JSONObject jSONObject2 = new JSONObject();
                if (!s()) {
                    F();
                    jSONObject2.put("retCode", -4);
                } else {
                    jSONObject2.put("retCode", 1);
                }
                super.callJs(str4, jSONObject2.toString());
            }
        } else if ("PathTraceStart".equals(str3)) {
            JSONObject A = A(jsonFromJSBridge, str4, iPathTraceManager);
            if (A == null) {
                return false;
            }
            super.callJs(str4, A.toString());
        } else if ("PathTracePause".equals(str3)) {
            JSONObject jSONObject3 = new JSONObject();
            iPathTraceManager.pathTracePause(q());
            jSONObject3.put("retCode", 1);
            super.callJs(str4, jSONObject3.toString());
        } else if ("PathTraceResume".equals(str3)) {
            JSONObject z17 = z(str4, iPathTraceManager);
            if (z17 == null) {
                return false;
            }
            super.callJs(str4, z17.toString());
        } else if ("PathTraceEnd".equals(str3)) {
            super.callJs(str4, x(jsonFromJSBridge, iPathTraceManager).toString());
        } else if ("PathTraceUpload".equals(str3)) {
            C(jsonFromJSBridge, str4, iPathTraceManager);
        } else if ("PathTraceBack".equals(str3)) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("retCode", 1);
            super.callJs(str4, jSONObject4.toString());
        } else if ("PathTraceQueryOne".equals(str3)) {
            super.callJs(str4, D(str4, str5, iPathTraceManager).toString());
        } else if ("PathTraceQuery".equals(str3)) {
            super.callJs(str4, iPathTraceManager.pathTraceQuery().toString());
        } else if ("PathTraceDelete".equals(str3)) {
            iPathTraceManager.pathTraceDelete(r(iPathTraceManager, new JSONObject(str5)));
        } else if ("PathTraceVoiceControl".equals(str3)) {
            G(iPathTraceManager, new JSONObject(str5).optInt("mute"));
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("retCode", 1);
            super.callJs(str4, jSONObject5.toString());
        } else if ("PathTraceIgnoreSpeed".equals(str3)) {
            if (new JSONObject(str5).optInt("ignoreSpeed") == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            iPathTraceManager.setIgnoreSpeed(z16);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("retCode", 1);
            super.callJs(str4, jSONObject6.toString());
        } else if ("PathTraceGpsAuth".equals(str3)) {
            JSONObject jSONObject7 = new JSONObject();
            if (!this.f312273f.isProviderEnabled("gps")) {
                jSONObject7.put("retCode", -2);
            } else {
                jSONObject7.put("retCode", 1);
            }
            super.callJs(str4, jSONObject7.toString());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        String str;
        super.onCreate();
        this.f312271d = this.mRuntime.a();
        this.f312272e = this.mRuntime.b();
        this.f312273f = (LocationManager) this.f312271d.getSystemService("location");
        IPathTraceManager iPathTraceManager = (IPathTraceManager) this.f312272e.getRuntimeService(IPathTraceManager.class, "tool");
        if (this.mRuntime.f() != null) {
            str = this.mRuntime.f().getCurrentUrl();
        } else {
            str = null;
        }
        boolean v3 = v(str);
        this.f312274h = v3;
        if (v3) {
            iPathTraceManager.registerWebViewPlug(this);
        }
        if (this.f312275i == null) {
            t();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PathTraceManager.Plugin", 2, "OnCreate isRunningPage: " + this.f312274h);
        }
        QQPermission.enterModule("biz_src_qqsport");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        try {
            IPathTraceManager iPathTraceManager = (IPathTraceManager) this.f312272e.getRuntimeService(IPathTraceManager.class, "tool");
            if (iPathTraceManager != null && iPathTraceManager.getEngineWorkingMode() == 0 && this.f312274h) {
                QLog.d("PathTraceManager.Plugin", 1, "here stop");
                iPathTraceManager.stopLocation(-1, q());
                H();
                QLog.d("PathTraceManager.Plugin", 1, "onDestroy isRunningPage: " + this.f312274h);
                QQPermission.exitModule("biz_src_qqsport");
            }
        } catch (Exception e16) {
            QLog.e("PathTraceManager.Plugin", 1, "onDestroy Err:", e16);
        }
    }
}
