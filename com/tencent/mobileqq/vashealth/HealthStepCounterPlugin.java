package com.tencent.mobileqq.vashealth;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerRsp;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.forward.api.IForwardApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vashealth.hippy.HealthModule;
import com.tencent.mobileqq.vashealth.huawei.HuaWeiStepAuthManager;
import com.tencent.mobileqq.vashealth.huaweistep.HuaweiStepHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.util.QQDeviceInfo;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class HealthStepCounterPlugin extends WebViewPlugin {
    static long M = 0;
    public static int N = -1;
    static int P = 0;
    static boolean Q = false;
    static boolean R = true;
    private static h S;
    String D;
    private SensorEventListener K;

    /* renamed from: h, reason: collision with root package name */
    public Activity f312124h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f312125i;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, Long> f312121d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public HashMap<String, Long> f312122e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    public HashMap<String, Long> f312123f = new HashMap<>();

    /* renamed from: m, reason: collision with root package name */
    String f312126m = null;
    String C = null;
    AtomicBoolean E = new AtomicBoolean(false);
    String F = null;
    String G = null;
    String H = null;
    int I = 0;
    int J = 0;
    private BusinessObserver L = new a();

    /* loaded from: classes20.dex */
    class a implements BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            if (z16) {
                String string = bundle.getString("StepInfoJSON");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                QLog.i("HealthStepCounterPlugin", 1, "HealthStepCounterPlugin receive stepInfoJson:" + string);
                try {
                    jSONObject2.put("retCode", 0);
                    Map map = (Map) bundle.getSerializable(StepCounterConstants.ATTR_STEP_COUNT_HISTORY);
                    long d16 = SSOHttpUtils.d() / 1000;
                    if (map != null && map.containsKey(Long.valueOf(d16))) {
                        i16 = ((Integer) map.get(Long.valueOf(d16))).intValue();
                    } else {
                        i16 = 0;
                    }
                    int[] e16 = SSOHttpUtils.e();
                    int i17 = e16[1];
                    if (i17 != -1 && i17 > i16) {
                        QLog.e("HealthStepCounterPlugin", 1, "use device step:" + e16[1] + " instead of:" + i16);
                        i16 = e16[1];
                    }
                    jSONObject2.put("step", i16);
                    jSONObject.put("step", i16);
                    jSONObject.put("isStepCounterEnable", bundle.getBoolean(StepCounterConstants.ATTR_STEP_COUNTER_ENABLE, true));
                    if (QLog.isColorLevel()) {
                        QLog.d("HealthStepCounterPlugin", 2, " day key is: " + d16 + ", current step: " + i16);
                    }
                } catch (JSONException e17) {
                    QLog.e("HealthStepCounterPlugin", 2, "refreshStep failed  error is" + e17);
                }
                if (bundle.getString("json_getstepcallback") != null) {
                    HealthStepCounterPlugin.this.callJs(bundle.getString("json_getstepcallback"), jSONObject2.toString());
                    return;
                }
                String string2 = bundle.getString("json_string");
                if (!TextUtils.isEmpty(string2) || jSONObject.length() != 0) {
                    if (HealthStepCounterPlugin.this.E.get()) {
                        HealthStepCounterPlugin.this.H = string;
                    }
                    if (System.currentTimeMillis() - HealthStepCounterPlugin.M < 4000) {
                        return;
                    }
                    HealthStepCounterPlugin.M = System.currentTimeMillis();
                    HealthStepCounterPlugin.this.U(string2, jSONObject);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements com.tencent.mobileqq.vashealth.huawei.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f312131a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f312132b;

        c(String str, JSONObject jSONObject) {
            this.f312131a = str;
            this.f312132b = jSONObject;
        }

        @Override // com.tencent.mobileqq.vashealth.huawei.b
        public void a() {
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312131a, healthStepCounterPlugin.D(this.f312132b, 0, "cancelSuccess").toString());
        }

        @Override // com.tencent.mobileqq.vashealth.huawei.b
        public void b() {
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312131a, healthStepCounterPlugin.D(this.f312132b, -1, "cancelFailed").toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f312134a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312135b;

        d(JSONObject jSONObject, String str) {
            this.f312134a = jSONObject;
            this.f312135b = str;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            HealthStepCounterPlugin.this.y(this.f312134a, this.f312135b, Boolean.FALSE);
            QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission permissionDenied");
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            HealthStepCounterPlugin.this.y(this.f312134a, this.f312135b, Boolean.TRUE);
            StepCounterPermissionUtils.q();
            QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission permissionAllowed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f312137a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312138b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f312139c;

        e(boolean z16, String str, JSONObject jSONObject) {
            this.f312137a = z16;
            this.f312138b = str;
            this.f312139c = jSONObject;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312138b, healthStepCounterPlugin.D(this.f312139c, 104, HardCodeUtil.qqStr(R.string.n7u)).toString());
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            StepCounterPermissionUtils.z(this.f312137a);
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312138b, healthStepCounterPlugin.D(this.f312139c, 0, HardCodeUtil.qqStr(R.string.n7o)).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f312141a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f312142b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f312143c;

        f(boolean z16, String str, JSONObject jSONObject) {
            this.f312141a = z16;
            this.f312142b = str;
            this.f312143c = jSONObject;
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void a() {
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312142b, healthStepCounterPlugin.D(this.f312143c, 104, HardCodeUtil.qqStr(R.string.n7u)).toString());
            QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission permissionDenied");
        }

        @Override // com.tencent.mobileqq.vashealth.t
        public void b() {
            StepCounterPermissionUtils.z(this.f312141a);
            HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
            healthStepCounterPlugin.callJs(this.f312142b, healthStepCounterPlugin.D(this.f312143c, 0, HardCodeUtil.qqStr(R.string.n7o)).toString());
            StepCounterPermissionUtils.q();
            QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission permissionAllowed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g implements BusinessObserver {
        g() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            String str;
            try {
                String string = bundle.getString("extra_callbackid");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                long j3 = -1;
                if (!z16) {
                    HealthStepCounterPlugin.this.V(jSONObject, bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE));
                } else {
                    byte[] byteArray = bundle.getByteArray("extra_data");
                    if (byteArray != null) {
                        WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                        webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                        if (webSSOAgent$UniSsoServerRsp.comm.has()) {
                            String string2 = bundle.getString(WadlProxyConsts.EXTRA_CMD);
                            if (!TextUtils.isEmpty(string2)) {
                                if (webSSOAgent$UniSsoServerRsp.comm.delayms.has()) {
                                    HealthStepCounterPlugin.this.f312122e.put(string2, Long.valueOf(webSSOAgent$UniSsoServerRsp.comm.delayms.get()));
                                }
                                if (webSSOAgent$UniSsoServerRsp.comm.packagesize.has()) {
                                    HealthStepCounterPlugin.this.f312121d.put(string2, Long.valueOf(webSSOAgent$UniSsoServerRsp.comm.packagesize.get()));
                                }
                                if (webSSOAgent$UniSsoServerRsp.comm.proctime.has()) {
                                    j3 = webSSOAgent$UniSsoServerRsp.comm.proctime.get();
                                }
                            }
                        }
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                        HealthStepCounterPlugin.this.W(jSONObject, webSSOAgent$UniSsoServerRsp);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.w("HealthStepCounterPlugin", 2, "uniAgent, onReceive, ret success but no data");
                        }
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                        jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                        jSONObject.put("msg", "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                    }
                }
                QLog.i("HealthStepCounterPlugin", 1, "result:" + jSONObject.toString());
                if (HealthStepCounterPlugin.this.E.get()) {
                    HealthStepCounterPlugin.this.E.set(false);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        String str2 = "";
                        if (TextUtils.isEmpty(HealthStepCounterPlugin.this.G)) {
                            str = "";
                        } else {
                            str = HealthStepCounterPlugin.this.G;
                        }
                        jSONObject2.put("msg", str);
                        jSONObject2.put("report_result", jSONObject.toString());
                        if (!TextUtils.isEmpty(HealthStepCounterPlugin.this.H)) {
                            str2 = HealthStepCounterPlugin.this.H;
                        }
                        jSONObject2.put("msf_json", str2);
                    } catch (Exception unused) {
                    }
                    HealthStepCounterPlugin.this.B("test result:" + jSONObject2.toString());
                    if (!TextUtils.isEmpty(HealthStepCounterPlugin.this.F)) {
                        HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
                        healthStepCounterPlugin.callJs(healthStepCounterPlugin.F, jSONObject2.toString());
                        return;
                    }
                    return;
                }
                com.tencent.mobileqq.vashealth.websso.a.f312357h = System.currentTimeMillis();
                long j16 = com.tencent.mobileqq.vashealth.websso.a.f312355e - com.tencent.mobileqq.vashealth.websso.a.f312354d;
                long j17 = com.tencent.mobileqq.vashealth.websso.a.f312356f - com.tencent.mobileqq.vashealth.websso.a.f312355e;
                long j18 = com.tencent.mobileqq.vashealth.websso.a.f312357h - com.tencent.mobileqq.vashealth.websso.a.f312356f;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("packTime", j16);
                jSONObject3.put("SSONetworkTime", j17);
                jSONObject3.put("unpackTime", j18);
                jSONObject3.put("serverProcessTime", j3);
                jSONObject.put("speedPoint", jSONObject3);
                HealthStepCounterPlugin.this.callJs(string, jSONObject.toString());
            } catch (Exception e16) {
                HealthStepCounterPlugin.this.A("uniAgent, onReceive, Exception: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        if (QLog.isColorLevel()) {
            QLog.e("HealthStepCounterPlugin", 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("HealthStepCounterPlugin", 2, str);
        }
    }

    private Bundle C(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject D(JSONObject jSONObject, int i3, String str) {
        try {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, i3);
            jSONObject.put("msg", str);
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "callBackSwitchPermission  JSONObject put fail:" + th5);
        }
        return jSONObject;
    }

    private void E(String str) throws JSONException {
        String string = new JSONObject(str).getString("callback");
        if (com.tencent.mobileqq.vashealth.step.k.f312340a.j()) {
            S(string);
            return;
        }
        NewIntent newIntent = new NewIntent(this.mRuntime.b().getApplication(), u.class);
        newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
        newIntent.putExtra("json_string", str);
        newIntent.putExtra("json_getstepcallback", string);
        newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
        newIntent.setObserver(this.L);
        this.mRuntime.b().startServlet(newIntent);
    }

    private boolean F(String[] strArr) {
        QLog.d("HealthStepCounterPlugin", 1, "getDeviceModel");
        JSONObject jSONObject = new JSONObject();
        try {
            String string = new JSONObject(strArr[0]).getString("callback");
            jSONObject.put("model", Build.MANUFACTURER);
            super.callJs(string, jSONObject.toString());
            return true;
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "requestStepCounterPermission JSONObject put fail:" + th5);
            return false;
        }
    }

    private boolean G(String[] strArr) {
        int i3;
        QLog.d("HealthStepCounterPlugin", 1, "getDeviceStepPermission");
        JSONObject jSONObject = new JSONObject();
        try {
            String string = new JSONObject(strArr[0]).getString("callback");
            if (HuaweiStepHelper.isInHuaWeiSystemWhiteList()) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            if (StepCounterPermissionUtils.e()) {
                i3 = 1;
            }
            if (com.tencent.mobileqq.vashealth.honorstep.g.f312292a.n()) {
                i3 = 0;
            }
            if (StepCounterPermissionUtils.d()) {
                i3 = 1;
            }
            m43.c cVar = m43.c.f416147a;
            if (cVar.c()) {
                i3 = 0;
            }
            if (cVar.b()) {
                i3 = 1;
            }
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, i3);
            super.callJs(string, jSONObject.toString());
            return true;
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "getStepCounterPermission JSONObject put fail:" + th5);
            return false;
        }
    }

    @NotNull
    private BusinessObserver H() {
        return new g();
    }

    @NotNull
    private SensorEventListener I() {
        return new b();
    }

    private void J(JSONObject jSONObject, boolean z16, String str, JSONObject jSONObject2) throws JSONException {
        if (z16) {
            jSONObject2.put("result", 0);
            jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.n7q));
            jSONObject2.put("pic_uri", str);
            jSONObject.put("code", 0);
            B("ShareScreenshot success!");
            return;
        }
        jSONObject2.put("result", -1);
        jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.n7x));
        jSONObject.put("code", -1);
        B("ShareScreenshot Err");
    }

    private boolean K(String[] strArr) {
        QLog.d("HealthStepCounterPlugin", 1, "getStepCounterPermission");
        JSONObject jSONObject = new JSONObject();
        try {
            String string = new JSONObject(strArr[0]).getString("callback");
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, StepCounterPermissionUtils.f());
            if (StepCounterPermissionUtils.m()) {
                jSONObject.put("systemPermission", StepCounterPermissionUtils.c());
            }
            super.callJs(string, jSONObject.toString());
            return true;
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "getStepCounterPermission JSONObject put fail:" + th5);
            return false;
        }
    }

    private JSONObject L(String str) {
        int i3 = this.mRuntime.b().getApplication().getSharedPreferences(this.mRuntime.b().getCurrentAccountUin() + ".qqsport", 4).getInt("STEP_RED_PACK_STATUS", 0);
        JSONObject jSONObject = new JSONObject();
        try {
            String string = new JSONObject(str).getString("callback");
            jSONObject.put("status", i3);
            QLog.i("HealthStepCounterPlugin", 1, "getStepRedPackStatus:" + jSONObject.toString());
            callJs(string, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private void M(int i3, String str, Bitmap bitmap) throws IOException {
        switch (i3) {
            case 1:
                Bundle bundle = new Bundle();
                bundle.putInt("forward_type", 1);
                bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
                bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
                bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
                bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
                bundle.putBoolean("key_flag_from_plugin", true);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(this.f312124h, ((IForwardApi) QRoute.api(IForwardApi.class)).getForwardRecentActivityClass());
                intent.putExtra("caller_name", this.f312124h.getClass().getSimpleName());
                intent.putExtra("forward_source_business_type", -1);
                intent.putExtra("forward_source_sub_business_type", "");
                this.f312124h.startActivityForResult(intent, 21);
                return;
            case 2:
                Bundle bundle2 = new Bundle();
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(URLDecoder.decode(str));
                bundle2.putStringArrayList("images", arrayList);
                bundle2.putString("summary", HardCodeUtil.qqStr(R.string.n7w));
                bundle2.putInt(AppConstants.Key.SHARE_REQ_TYPE, 7);
                bundle2.putBoolean("key_need_save_draft", false);
                if (QLog.isColorLevel()) {
                    QLog.d("HealthStepCounterPlugin", 2, "Health publishToQzone:" + bundle2);
                }
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).publishToQzone(this.mRuntime.b(), this.mRuntime.a(), bundle2, null);
                return;
            case 3:
                if (WXShareHelper.b0().e0()) {
                    WXShareHelper.b0().u0(str, bitmap, 0);
                    return;
                } else {
                    this.mRuntime.e().post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.9
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(HealthStepCounterPlugin.this.mRuntime.e().getContext(), HardCodeUtil.qqStr(R.string.n7s), 0).show((int) (new QQToast(HealthStepCounterPlugin.this.mRuntime.e().getContext()).getStatusBarHeight() * 2.5d));
                        }
                    });
                    return;
                }
            case 4:
                if (WXShareHelper.b0().e0()) {
                    WXShareHelper.b0().u0(str, bitmap, 1);
                    return;
                } else {
                    this.mRuntime.e().post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.8
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(HealthStepCounterPlugin.this.mRuntime.e().getContext(), HardCodeUtil.qqStr(R.string.n7v), 0).show((int) (new QQToast(HealthStepCounterPlugin.this.mRuntime.e().getContext()).getStatusBarHeight() * 2.5d));
                        }
                    });
                    return;
                }
            case 5:
                StringBuilder sb5 = new StringBuilder();
                String str2 = AppConstants.SDCARD_IMG_SAVE;
                sb5.append(str2);
                sb5.append(File.separator);
                sb5.append(System.currentTimeMillis());
                sb5.append(".png");
                File file = new File(sb5.toString());
                BaseImageUtil.saveBitmapToFile(bitmap, file);
                Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent2.setData(Uri.fromFile(file));
                this.mRuntime.a().getApplicationContext().sendBroadcast(intent2);
                if (QLog.isColorLevel()) {
                    QLog.d("HealthStepCounterPlugin", 2, "pic save to" + str2);
                    return;
                }
                return;
            case 6:
                Intent intent3 = new Intent();
                intent3.putExtras(C(str));
                intent3.putExtra("call_by_forward", true);
                intent3.putExtra("is_multi_selection", false);
                intent3.putExtra("only_single_selection", true);
                intent3.putParcelableArrayListExtra("selected_target_list", new ArrayList<>());
                ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(this.mRuntime.a(), intent3, -1);
                return;
            default:
                return;
        }
    }

    private boolean N(String[] strArr) throws JSONException {
        B("healthSwitch:" + strArr[0]);
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.health_ban.name(), "");
        if (!TextUtils.isEmpty(featureValue) && Integer.parseInt(featureValue) == 0) {
            JSONObject jSONObject = new JSONObject();
            String string = new JSONObject(strArr[0]).getString("callback");
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 202);
            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7n));
            super.callJs(string, jSONObject.toString());
            return true;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject(strArr[0]);
        String string2 = jSONObject3.getString("callback");
        boolean z16 = jSONObject3.getBoolean(com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g);
        if (!z16) {
            StepCounterPermissionUtils.z(z16);
            jSONObject2.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
            jSONObject2.put("msg", HardCodeUtil.qqStr(R.string.n7o));
            super.callJs(string2, jSONObject2.toString());
            return true;
        }
        if (StepCounterPermissionUtils.m() && !StepCounterPermissionUtils.c()) {
            StepCounterPermissionUtils.r(new e(z16, string2, jSONObject2));
        } else {
            StepCounterPermissionUtils.x(new f(z16, string2, jSONObject2));
        }
        return true;
    }

    private void O(String str) {
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        try {
            Activity a16 = this.mRuntime.a();
            str2 = new JSONObject(str).getString("callback");
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + a16.getPackageName()));
            a16.startActivity(intent);
            jSONObject.put("ret", 0);
        } catch (Exception unused) {
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException unused2) {
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            callJs(str2, jSONObject.toString());
        }
    }

    private boolean P(int i3, int i16, int i17, int i18) {
        int width = this.mRuntime.a().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mRuntime.a().getWindowManager().getDefaultDisplay().getHeight();
        if (i3 >= 0 && i16 >= 0 && i17 <= width && i18 <= height) {
            return false;
        }
        return true;
    }

    private boolean Q(String str, String str2, String str3) {
        if (str != null && "healthkit".equals(str2) && str3 != null) {
            return false;
        }
        return true;
    }

    private boolean R(String[] strArr) throws JSONException {
        if (strArr.length > 0) {
            SensorManager sensorManager = (SensorManager) this.f312124h.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            String string = new JSONObject(strArr[0]).getString("callback");
            if (SensorMonitor.getDefaultSensor(sensorManager, 19) == null) {
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7r));
                super.callJs(string, jSONObject.toString());
            } else {
                if (com.tencent.mobileqq.vashealth.step.k.f312340a.j()) {
                    S(string);
                    return true;
                }
                NewIntent newIntent = new NewIntent(this.mRuntime.b().getApplication(), u.class);
                newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
                newIntent.putExtra("json_string", strArr[0]);
                newIntent.putExtra(StepCounterConstants.ATTR_IS_REPORT_STEP, true);
                newIntent.setObserver(this.L);
                this.mRuntime.b().startServlet(newIntent);
            }
        }
        return true;
    }

    private void S(String str) {
        try {
            com.tencent.mobileqq.vashealth.step.k kVar = com.tencent.mobileqq.vashealth.step.k.f312340a;
            Integer valueOf = Integer.valueOf(kVar.h());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", kVar.q());
            jSONObject.put("step", valueOf);
            callJs(str, jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "reportNewStep failed, error:" + th5);
        }
    }

    private boolean T(String[] strArr) {
        QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission");
        try {
            StepCounterPermissionUtils.x(new d(new JSONObject(), new JSONObject(strArr[0]).getString("callback")));
            return true;
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "requestStepCounterPermission JSONObject put fail:" + th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(String str, JSONObject jSONObject) {
        long j3;
        long j16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            String string = jSONObject2.getString("callback");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(this.f312124h)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 103);
                jSONObject3.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                jSONObject3.put("msg", "MSF\u672a\u8fde\u63a5");
                super.callJs(string, jSONObject3.toString());
                return;
            }
            if (this.f312121d.containsKey(HealthModule.REPORT_STEP_CMD)) {
                j3 = this.f312121d.get(HealthModule.REPORT_STEP_CMD).longValue();
            } else {
                j3 = 10240;
            }
            if (j3 > 0 && jSONObject2.toString().getBytes().length > j3) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 101);
                jSONObject4.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                jSONObject4.put("msg", HardCodeUtil.qqStr(R.string.n7m));
                super.callJs(string, jSONObject4.toString());
                return;
            }
            if (this.f312123f.containsKey(HealthModule.REPORT_STEP_CMD)) {
                long longValue = this.f312123f.get(HealthModule.REPORT_STEP_CMD).longValue();
                if (this.f312122e.containsKey(HealthModule.REPORT_STEP_CMD)) {
                    j16 = this.f312122e.get(HealthModule.REPORT_STEP_CMD).longValue();
                } else {
                    j16 = 1000;
                }
                if (j16 > 0 && System.currentTimeMillis() - longValue < j16) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 102);
                    jSONObject5.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
                    jSONObject5.put("msg", HardCodeUtil.qqStr(R.string.n7l));
                    super.callJs(string, jSONObject5.toString());
                    this.f312123f.put(HealthModule.REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
            }
            this.f312123f.put(HealthModule.REPORT_STEP_CMD, Long.valueOf(System.currentTimeMillis()));
            if (!jSONObject.optBoolean("isStepCounterEnable", true)) {
                QLog.i("HealthStepCounterPlugin", 1, "web process report step found step counter off!");
                return;
            }
            int optInt = jSONObject.optInt("step", 0);
            long serverTime = NetConnInfoCenter.getServerTime();
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("type", 1);
            jSONObject6.put("time", serverTime);
            jSONObject6.put("steps", optInt);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject6);
            jSONObject2.put(AdParam.CONSUMERID, 1002);
            jSONObject2.put("data", jSONArray);
            String str2 = AppSetting.f99551k;
            jSONObject2.put("version", str2);
            if (TextUtils.isEmpty(this.f312126m)) {
                this.f312126m = URLEncoder.encode(DeviceInfoMonitor.getModel(), "utf-8");
            }
            jSONObject2.put("model", this.f312126m);
            if (TextUtils.isEmpty(this.D)) {
                TimeZone timeZone = TimeZone.getDefault();
                this.D = timeZone.getDisplayName(false, 0) + " " + timeZone.getID();
            }
            jSONObject2.put("zone", String.valueOf(this.D));
            if (TextUtils.isEmpty(this.C)) {
                this.C = QQDeviceInfo.getQIMEI();
            }
            jSONObject2.put("imei", String.valueOf(this.C));
            B("parameters:" + jSONObject2.toString());
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(str2);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject2.toString());
            BusinessObserver H = H();
            if (this.mRuntime != null) {
                NewIntent newIntent = new NewIntent(this.mRuntime.a().getApplicationContext(), com.tencent.mobileqq.vashealth.websso.a.class);
                newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, HealthModule.REPORT_STEP_CMD);
                newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.putExtra("extra_callbackid", string);
                newIntent.setObserver(H);
                this.mRuntime.b().startServlet(newIntent);
            }
        } catch (Exception e16) {
            A("Exception:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(JSONObject jSONObject, int i3) throws JSONException {
        if (i3 == 1001) {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 201);
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7t));
        } else if (i3 != 1002 && i3 != 1013) {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 255);
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7k));
        } else {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 202);
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
            jSONObject.put("msg", HardCodeUtil.qqStr(R.string.n7p));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(JSONObject jSONObject, WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp) throws JSONException {
        if (webSSOAgent$UniSsoServerRsp.ret.has()) {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, webSSOAgent$UniSsoServerRsp.ret.get());
        } else {
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, 0);
        }
        if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
            jSONObject.put("msg", webSSOAgent$UniSsoServerRsp.errmsg.get());
        } else {
            jSONObject.put("msg", "SSO\u53d1\u9001\u6210\u529f");
        }
        if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
            jSONObject.put("data", webSSOAgent$UniSsoServerRsp.rspdata.get());
        }
    }

    private JSONObject X(String str) {
        int i3;
        SharedPreferences.Editor edit = this.mRuntime.b().getApplication().getSharedPreferences(this.mRuntime.b().getCurrentAccountUin() + ".qqsport", 4).edit();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            edit.putInt("STEP_RED_PACK_STATUS", jSONObject2.optInt("status"));
            boolean commit = edit.commit();
            String string = jSONObject2.getString("callback");
            if (commit) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            jSONObject.put("status", i3);
            QLog.i("HealthStepCounterPlugin", 1, "setStepRedPackStatus:" + jSONObject.toString());
            callJs(string, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private void Y(int i3) {
        QQProgressDialog qQProgressDialog;
        if (this.f312125i == null) {
            WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
            if (webViewFragment != null) {
                qQProgressDialog = webViewFragment.getSharePD();
            } else {
                qQProgressDialog = null;
            }
            this.f312125i = qQProgressDialog;
        }
        QQProgressDialog qQProgressDialog2 = this.f312125i;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.setMessage(i3);
            this.f312125i.setCancelable(false);
            this.f312125i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.tencent.mobileqq.widget.QQProgressDialog] */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.app.Dialog, com.tencent.mobileqq.widget.QQProgressDialog] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.tencent.mobileqq.vashealth.HealthStepCounterPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin] */
    public JSONObject Z(String str) {
        boolean z16;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRuntime != null && this.f312124h != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                String string = jSONObject2.getString("callback");
                if (TextUtils.isEmpty(string)) {
                    return jSONObject;
                }
                int i3 = jSONObject2.getInt(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE);
                String string2 = jSONObject2.getString("image_url");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = BitmapFactory.decodeFile(string2, options);
                options.inJustDecodeBounds = false;
                try {
                    decodeFile = BitmapFactory.decodeFile(string2, options);
                } catch (OutOfMemoryError e16) {
                    A("Exception:" + e16.toString());
                }
                FileOutputStream fileOutputStream3 = null;
                FileOutputStream fileOutputStream4 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(new File(string2));
                        try {
                            z16 = decodeFile.compress(Bitmap.CompressFormat.PNG, 80, fileOutputStream);
                            ?? r102 = this.f312125i;
                            fileOutputStream2 = r102;
                            if (r102 != 0) {
                                ?? isShowing = r102.isShowing();
                                fileOutputStream2 = isShowing;
                                if (isShowing != 0) {
                                    ?? r103 = this.f312125i;
                                    r103.dismiss();
                                    fileOutputStream2 = r103;
                                }
                            }
                            M(i3, string2, decodeFile);
                            B("Time used:" + (System.currentTimeMillis() - currentTimeMillis));
                        } catch (FileNotFoundException e17) {
                            e = e17;
                            fileOutputStream4 = fileOutputStream;
                            A("Exception:" + e.toString());
                            if (fileOutputStream4 != null) {
                                try {
                                    fileOutputStream4.close();
                                } catch (IOException unused) {
                                }
                            }
                            z16 = false;
                            fileOutputStream3 = fileOutputStream4;
                            J(jSONObject, z16, string2, new JSONObject());
                            callJs(string, jSONObject.toString());
                            return jSONObject;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream3 = fileOutputStream;
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e18) {
                        e = e18;
                    }
                    try {
                        fileOutputStream.close();
                        fileOutputStream3 = fileOutputStream2;
                    } catch (IOException unused3) {
                    }
                    J(jSONObject, z16, string2, new JSONObject());
                    callJs(string, jSONObject.toString());
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e19) {
                A("Exception:" + e19.toString());
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a0(String str) {
        int i3;
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject(str);
                String string = jSONObject2.getString("callback");
                int optInt = jSONObject2.optInt(HippyTKDListViewAdapter.X);
                int optInt2 = jSONObject2.optInt("y");
                int optInt3 = jSONObject2.optInt("w");
                int optInt4 = jSONObject2.optInt(tl.h.F);
                CustomWebView e16 = this.mRuntime.e();
                if (e16 == null) {
                    jSONObject.put("code", -1);
                    jSONObject.put("image_url", "");
                    callJs(string, jSONObject.toString());
                    QQProgressDialog qQProgressDialog = this.f312125i;
                    if (qQProgressDialog != null) {
                        qQProgressDialog.dismiss();
                    }
                    return jSONObject;
                }
                B("webview:" + e16.getWidth() + "," + e16.getHeight());
                Bitmap createBitmap = Bitmap.createBitmap(e16.getWidth(), e16.getHeight(), Bitmap.Config.ARGB_8888);
                e16.draw(new Canvas(createBitmap));
                if (P(optInt, optInt2, optInt3, optInt4)) {
                    jSONObject.put("code", -1);
                    jSONObject.put("image_url", "");
                    callJs(string, jSONObject.toString());
                    QQProgressDialog qQProgressDialog2 = this.f312125i;
                    if (qQProgressDialog2 != null) {
                        qQProgressDialog2.dismiss();
                    }
                    return jSONObject;
                }
                if (optInt3 > 0 && optInt4 > 0) {
                    createBitmap = Bitmap.createBitmap(createBitmap, optInt, optInt2, optInt3, optInt4);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("bitmap size:");
                if (createBitmap != null) {
                    i3 = createBitmap.getByteCount();
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                A(sb5.toString());
                File file = new File(VFSAssistantUtils.getSDKPrivatePath("cache"));
                file.mkdirs();
                String str2 = file.getAbsolutePath() + File.separator + System.currentTimeMillis() + ".png";
                BaseImageUtil.saveBitmapToFile(createBitmap, new File(str2));
                if (createBitmap != null) {
                    jSONObject.put("code", 0);
                    jSONObject.put("image_url", str2);
                    callJs(string, jSONObject.toString());
                    QQProgressDialog qQProgressDialog3 = this.f312125i;
                    if (qQProgressDialog3 != null) {
                        qQProgressDialog3.dismiss();
                    }
                    return jSONObject;
                }
                jSONObject.put("code", -2);
                jSONObject.put("image_url", "");
                callJs(string, jSONObject.toString());
                QQProgressDialog qQProgressDialog4 = this.f312125i;
                if (qQProgressDialog4 != null) {
                    qQProgressDialog4.dismiss();
                }
                return jSONObject;
            } catch (Exception e17) {
                A("Exception:" + e17.toString());
                QQProgressDialog qQProgressDialog5 = this.f312125i;
                if (qQProgressDialog5 != null) {
                    qQProgressDialog5.dismiss();
                    return null;
                }
                return null;
            }
        } catch (Throwable th5) {
            QQProgressDialog qQProgressDialog6 = this.f312125i;
            if (qQProgressDialog6 != null) {
                qQProgressDialog6.dismiss();
            }
            throw th5;
        }
    }

    private void b0(String str) {
        if (S == null) {
            h hVar = new h();
            SensorManager sensorManager = (SensorManager) this.f312124h.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            SensorMonitor.registerListener(sensorManager, hVar, SensorMonitor.getDefaultSensor(sensorManager, 1), 1);
            S = hVar;
            QLog.d("HealthStepCounterPlugin", 1, "register shakelistener");
        }
        try {
            this.F = new JSONObject(str).getString("callback");
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(this.F)) {
            this.E.set(true);
            SensorManager sensorManager2 = (SensorManager) this.f312124h.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager2, 19);
            if (defaultSensor == null) {
                this.G = "Unsupported model found.";
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", N);
                    jSONObject.put("msg", this.G);
                } catch (Exception unused2) {
                }
                callJs(this.F, jSONObject.toString());
                return;
            }
            if (this.K == null) {
                SensorEventListener I = I();
                this.K = I;
                SensorMonitor.registerListener(sensorManager2, I, defaultSensor, 3, 0);
                sensorManager2.flush(this.K);
            }
            if (com.tencent.mobileqq.vashealth.step.k.f312340a.j()) {
                S(this.F);
                return;
            }
            NewIntent newIntent = new NewIntent(this.mRuntime.b().getApplication(), u.class);
            newIntent.putExtra("msf_cmd_type", StepCounterConstants.CMD_REFRESH_STEPS);
            newIntent.putExtra("json_string", str);
            newIntent.setObserver(this.L);
            this.mRuntime.b().startServlet(newIntent);
        }
    }

    private void c0(String str) {
        try {
            IX5WebViewExtension x5WebViewExtension = this.mRuntime.e().getX5WebViewExtension();
            if (x5WebViewExtension == null) {
                return;
            }
            String optString = new JSONObject(str).optString("serviceWorkerURL");
            for (String str2 : optString.substring(1, optString.length() - 1).split(",")) {
                x5WebViewExtension.updateServiceWorkerBackground(str2);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(JSONObject jSONObject, String str, Boolean bool) {
        StepCounterPermissionUtils.z(bool.booleanValue());
        try {
            jSONObject.put(QCircleDaTongConstant.ElementParamValue.PERMISSION, bool);
            super.callJs(str, jSONObject.toString());
            QLog.d("HealthStepCounterPlugin", 1, "requestStepCounterPermission callBackPermission:" + bool);
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "requestStepCounterPermission callBackPermission:" + bool + " JSONObject put fail:" + th5);
        }
    }

    private boolean z(String[] strArr) {
        QLog.d("HealthStepCounterPlugin", 1, "cancelDeviceStepPermission");
        JSONObject jSONObject = new JSONObject();
        try {
            String string = new JSONObject(strArr[0]).getString("callback");
            int m3 = com.tencent.mobileqq.vashealth.honorstep.g.f312292a.m();
            c cVar = new c(string, jSONObject);
            if (m3 == 2) {
                HuaWeiStepAuthManager.h(this.f312124h).f(cVar);
            } else if (m3 == 1) {
                com.tencent.mobileqq.vashealth.honorstep.e.f312286a.g(cVar);
            } else if (m3 == 3) {
                m43.b.f416141a.e(cVar);
            }
            return true;
        } catch (Throwable th5) {
            QLog.e("HealthStepCounterPlugin", 1, "cancelDeviceStepPermission JSONObject put fail:" + th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "healthkit";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        B("handleJsRequest!!");
        if (Q(str, str2, str3)) {
            return false;
        }
        try {
        } catch (Exception e16) {
            QLog.d("HealthStepCounterPlugin", 2, "Err:" + e16.toString());
        }
        if (str3.equals("readHKData")) {
            return R(strArr);
        }
        if (str3.equals("getStepCounterPermission")) {
            return K(strArr);
        }
        if (str3.equals("getDeviceStepPermission")) {
            return G(strArr);
        }
        if (str3.equals("cancelDeviceStepPermission")) {
            return z(strArr);
        }
        if (str3.equals("getDeviceModel")) {
            return F(strArr);
        }
        if (str3.equals("requestStepCounterPermission")) {
            return T(strArr);
        }
        if (str3.equals("healthSwitch")) {
            return N(strArr);
        }
        if (str3.equals("shareSnapshot")) {
            Y(R.string.c7z);
            final String str4 = strArr[0];
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    HealthStepCounterPlugin.this.Z(str4);
                }
            }, 5, null, true);
            return true;
        }
        if (str3.equals("snapshot")) {
            final String str5 = strArr[0];
            Y(R.string.c7z);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    HealthStepCounterPlugin.this.a0(str5);
                }
            }, 5, null, true);
            return true;
        }
        if (str3.equals("TestReport")) {
            b0(strArr[0]);
        } else if (str3.equals("getCurrentStep")) {
            E(strArr[0]);
        } else if ("jumpToSetting".equals(str3)) {
            O(strArr[0]);
        } else {
            if (str3.equals("getStepRedPackStatus")) {
                L(strArr[0]);
                return true;
            }
            if (str3.equals("setStepRedPackStatus")) {
                X(strArr[0]);
                return true;
            }
            if (str3.equals("updateServiceWorkerBackground")) {
                c0(strArr[0]);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f312124h = this.mRuntime.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        if (S != null) {
            ((SensorManager) this.f312124h.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(S);
            S = null;
        }
        if (this.K != null) {
            ((SensorManager) this.f312124h.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR)).unregisterListener(this.K);
            this.K = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements SensorEventListener {
        b() {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            HealthStepCounterPlugin.this.G = "Current step data:" + String.valueOf(sensorEvent.values[0]);
            QLog.d("HealthStepCounterPlugin", 1, "onSensorChanged:" + HealthStepCounterPlugin.this.G);
            if (HealthStepCounterPlugin.P == 1 && HealthStepCounterPlugin.R) {
                HealthStepCounterPlugin.this.I = (int) sensorEvent.values[0];
                HealthStepCounterPlugin.R = false;
            }
            if (HealthStepCounterPlugin.P == 3) {
                HealthStepCounterPlugin.P = 0;
                HealthStepCounterPlugin.this.J = (int) sensorEvent.values[0];
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retCode", 0);
                    HealthStepCounterPlugin healthStepCounterPlugin = HealthStepCounterPlugin.this;
                    jSONObject.put("step", healthStepCounterPlugin.J - healthStepCounterPlugin.I);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("source", "none");
                    String jsScript = WebViewPlugin.toJsScript("StepsDetect", jSONObject, jSONObject2);
                    if (HealthStepCounterPlugin.Q) {
                        HealthStepCounterPlugin.this.mRuntime.e().loadUrl(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.JAVASCRIPT_PREFIX + jsScript);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Steps detect:");
                        HealthStepCounterPlugin healthStepCounterPlugin2 = HealthStepCounterPlugin.this;
                        sb5.append(healthStepCounterPlugin2.J - healthStepCounterPlugin2.I);
                        QLog.d("HealthStepCounterPlugin", 1, sb5.toString());
                        HealthStepCounterPlugin.Q = false;
                    }
                } catch (Exception unused) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("retCode", -1);
                        jSONObject3.put("step", 0);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("source", "none");
                        HealthStepCounterPlugin.this.dispatchJsEvent("StepsDetect", jSONObject3, jSONObject4);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    HealthStepCounterPlugin.this.B("Err StepsDetect");
                }
                HealthStepCounterPlugin.R = true;
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class h implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        private long f312146d;

        /* renamed from: e, reason: collision with root package name */
        private float f312147e;

        /* renamed from: f, reason: collision with root package name */
        private float f312148f;

        /* renamed from: h, reason: collision with root package name */
        private float f312149h;

        /* renamed from: i, reason: collision with root package name */
        private float f312150i;

        /* renamed from: m, reason: collision with root package name */
        private int f312151m = 0;

        h() {
        }

        private float a(float f16, float f17, float f18, float f19) {
            float f26 = this.f312147e;
            if (f26 == 0.0f && this.f312148f == 0.0f && this.f312149h == 0.0f) {
                return f16;
            }
            return Math.abs(f17 - f26) + Math.abs(f18 - this.f312148f) + Math.abs(f19 - this.f312149h);
        }

        private void b(long j3) {
            this.f312146d = j3;
            this.f312147e = 0.0f;
            this.f312148f = 0.0f;
            this.f312149h = 0.0f;
            this.f312150i = 0.0f;
            this.f312151m = 0;
        }

        public void c() {
            HealthStepCounterPlugin.P = 1;
            HealthStepCounterPlugin.Q = true;
        }

        public void d() {
            HealthStepCounterPlugin.P = 3;
            QLog.d("HealthStepCounterPlugin", 1, "shaking end");
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float[] fArr = sensorEvent.values;
                float f16 = fArr[0];
                float f17 = fArr[1];
                float f18 = fArr[2];
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = currentTimeMillis - this.f312146d;
                if (j3 > 5000) {
                    b(currentTimeMillis);
                    return;
                }
                if (j3 > 80) {
                    float a16 = this.f312150i + a(0.0f, f16, f17, f18);
                    this.f312150i = a16;
                    if (a16 > 180.0f && this.f312151m >= 3) {
                        c();
                        b(currentTimeMillis);
                        return;
                    }
                    int i3 = this.f312151m;
                    if (i3 < 10) {
                        this.f312151m = i3 + 1;
                        this.f312147e = f16;
                        this.f312148f = f17;
                        this.f312149h = f18;
                        this.f312146d = currentTimeMillis;
                        return;
                    }
                    b(currentTimeMillis);
                    if (HealthStepCounterPlugin.P < 3) {
                        d();
                    }
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
