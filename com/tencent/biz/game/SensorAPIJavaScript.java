package com.tencent.biz.game;

import OnlinePushPack.SvcRespPushMsg;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.game.b;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troopplugin.PluginJumpManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.k;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.AudioMonitor;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.util.URLUtil;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SensorAPIJavaScript extends k {

    /* renamed from: e0, reason: collision with root package name */
    private static Boolean f78514e0;

    /* renamed from: f0, reason: collision with root package name */
    protected static com.tencent.biz.game.b f78515f0;
    protected SensorManager H;
    protected j I;
    protected j J;
    protected j K;
    protected MediaRecorder P;

    /* renamed from: b0, reason: collision with root package name */
    private QQPermission f78517b0;

    /* renamed from: d0, reason: collision with root package name */
    protected Handler f78520d0;

    /* renamed from: e, reason: collision with root package name */
    protected Activity f78521e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<WebView> f78522f;

    /* renamed from: h, reason: collision with root package name */
    protected SoundPool f78523h;

    /* renamed from: i, reason: collision with root package name */
    protected HashMap<String, Integer> f78524i;

    /* renamed from: m, reason: collision with root package name */
    protected String f78525m;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f78519d = false;
    protected final byte C = 0;
    protected final byte D = 1;
    protected final byte E = 2;
    protected final int F = 8000;
    protected final int G = 0;
    protected boolean L = false;
    protected String M = "";
    protected Object N = new Object();
    protected boolean Q = false;
    protected final int R = 5;
    protected final int S = 291;
    protected final int T = 0;
    protected final int U = 1;
    protected final int V = 2;
    protected final int W = 3;
    protected final int X = 4;
    protected final int Y = 0;
    protected final int Z = 1;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.biz.troop.b f78516a0 = null;

    /* renamed from: c0, reason: collision with root package name */
    protected int f78518c0 = 100;

    /* renamed from: com.tencent.biz.game.SensorAPIJavaScript$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f78526d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78527e;
        final /* synthetic */ SensorAPIJavaScript this$0;

        @Override // java.lang.Runnable
        public void run() {
            SoundPool soundPool = this.this$0.f78523h;
            if (soundPool != null && soundPool.play(this.f78526d, 1.0f, 1.0f, 0, 0, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SensorApi", 2, "play failure url=" + this.f78527e);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f78532d;

        a(String str) {
            this.f78532d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                int i3 = bundle.getInt("state");
                SensorAPIJavaScript.this.callJs(this.f78532d, i3 + "");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f78534d;

        b(String str) {
            this.f78534d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                int i3 = bundle.getInt("mode");
                SensorAPIJavaScript.this.callJs(this.f78534d, i3 + "");
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f78536d;

        c(String str) {
            this.f78536d = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            if (bundle != null) {
                SensorAPIJavaScript.this.callJs(this.f78536d, bundle.getString("music"));
            }
        }
    }

    /* loaded from: classes2.dex */
    class d extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f78538a;

        d(String str) {
            this.f78538a = str;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 1, "CheckPermission user grant = ");
            }
            SensorAPIJavaScript.this.r(this.f78538a);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 1, "CheckPermission user denied = ");
            }
            SensorAPIJavaScript.this.callJs(this.f78538a, "false", "{result: -10, msg: 'no permission to record'}");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 5) {
                SensorAPIJavaScript.this.q((String) message.obj);
            } else if (i3 == 291) {
                SensorAPIJavaScript.this.updateMicStatus((String) message.obj);
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f78541a;

        f(String str) {
            this.f78541a = str;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i3, int i16) {
            if (SensorAPIJavaScript.this.f78523h.play(i3, 1.0f, 1.0f, 0, 0, 1.0f) == 0 && QLog.isColorLevel()) {
                QLog.d("SensorApi", 2, "play failure url=" + this.f78541a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements ITroopMemberApiClientApi.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f78543d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f78544e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f78545f;

        g(Activity activity, boolean z16, String str) {
            this.f78543d = activity;
            this.f78544e = z16;
            this.f78545f = str;
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            Intent aliasIntent;
            int i3 = bundle.getInt("currentFragment", -1);
            if (QLog.isColorLevel()) {
                QLog.i("SensorAPIJavaScript", 2, "isFromAio callback " + i3);
            }
            if (i3 == 2) {
                Intent aliasIntent2 = SplashActivity.getAliasIntent(this.f78543d);
                aliasIntent2.setFlags(67108864);
                this.f78543d.startActivity(aliasIntent2);
            } else {
                if (this.f78544e && !TextUtils.isEmpty(this.f78545f)) {
                    if (bundle.getBoolean("KEY_OPEN_MINI_CHAT", false)) {
                        aliasIntent = new Intent(this.f78543d, (Class<?>) ChatActivity.class);
                        aliasIntent.putExtra("KEY_OPEN_MINI_CHAT", true);
                    } else {
                        aliasIntent = SplashActivity.getAliasIntent(this.f78543d);
                    }
                    Intent m3 = BaseAIOUtils.m(aliasIntent, null);
                    m3.putExtra("uin", this.f78545f);
                    m3.putExtra("uintype", 1);
                    this.f78543d.startActivity(m3);
                    return;
                }
                this.f78543d.setResult(4660);
                this.f78543d.finish();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097 A[Catch: JSONException -> 0x00f6, TryCatch #0 {JSONException -> 0x00f6, blocks: (B:7:0x0024, B:9:0x005f, B:10:0x008f, B:12:0x0097, B:13:0x00a1), top: B:6:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005f A[Catch: JSONException -> 0x00f6, TryCatch #0 {JSONException -> 0x00f6, blocks: (B:7:0x0024, B:9:0x005f, B:10:0x008f, B:12:0x0097, B:13:0x00a1), top: B:6:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getDeviceInfoEx(String str) {
        String str2;
        String model = DeviceInfoMonitor.getModel();
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.FINGERPRINT;
        String str5 = Build.VERSION.INCREMENTAL;
        String str6 = "";
        try {
            str2 = o.b();
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            str6 = o.c();
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.e(str, 2, "get QIMEI fail");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("model", model);
            jSONObject.put("systemName", "android");
            jSONObject.put("systemVersion", str3);
            jSONObject.put("isMobileQQ", true);
            jSONObject.put(IECDtReport.ACTION_IDENTIFIER, MobileInfoUtil.getImei());
            jSONObject.put("fingerprint", str4);
            jSONObject.put("incremental", str5);
            if (f78514e0 == null) {
            }
            if (!f78514e0.booleanValue()) {
            }
            jSONObject.put("androidID", ah.e());
            jSONObject.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str2);
            jSONObject.put("qimei36", str6);
            jSONObject.put("totalMemory", String.valueOf(m.c()));
            jSONObject.put("availableMemory", String.valueOf(ah.X()));
            jSONObject.put("cpuType", ah.o());
            jSONObject.put("cpuNum", ah.n());
            jSONObject.put("cpuFreq", ah.l());
            return jSONObject.toString();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("model", model);
            jSONObject2.put("systemName", "android");
            jSONObject2.put("systemVersion", str3);
            jSONObject2.put("isMobileQQ", true);
            jSONObject2.put(IECDtReport.ACTION_IDENTIFIER, MobileInfoUtil.getImei());
            jSONObject2.put("fingerprint", str4);
            jSONObject2.put("incremental", str5);
            if (f78514e0 == null) {
                f78514e0 = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102364", false));
                QLog.d("qbizApi", 1, "s_isMacCutOff=" + f78514e0);
            }
            if (!f78514e0.booleanValue()) {
                jSONObject2.put("macAddress", MobileInfoUtil.getLocalMacAddress());
            }
            jSONObject2.put("androidID", ah.e());
            jSONObject2.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, str2);
            jSONObject2.put("qimei36", str6);
            jSONObject2.put("totalMemory", String.valueOf(m.c()));
            jSONObject2.put("availableMemory", String.valueOf(ah.X()));
            jSONObject2.put("cpuType", ah.o());
            jSONObject2.put("cpuNum", ah.n());
            jSONObject2.put("cpuFreq", ah.l());
            return jSONObject2.toString();
        } catch (JSONException unused3) {
            return "{}";
        }
    }

    public static com.tencent.biz.game.b getMsfToWebViewConnector() {
        return f78515f0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        if (this.P == null) {
            this.P = new MediaRecorder();
        }
        try {
            AudioMonitor.setAudioSource(this.P, 1);
            this.P.setOutputFormat(3);
            this.P.setAudioEncoder(0);
            this.P.setOutputFile("/dev/null");
            this.P.setMaxDuration(600000);
            this.P.prepare();
            AudioMonitor.start(this.P);
            updateMicStatus(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            callJs(str, "false");
            this.P.release();
            this.P = null;
            this.L = false;
        }
    }

    public static void returnToAio(com.tencent.biz.troop.b bVar, Activity activity, String str, boolean z16) {
        if (bVar == null) {
            return;
        }
        bVar.Q(new g(activity, z16, str));
    }

    private void s() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f78520d0 = new e();
    }

    public void checkUpdate(String str, String str2) {
        HtmlOffline.f(str, this.mRuntime.b(), new i(str2), false);
    }

    public void connectToWiFi(String str) {
        String str2;
        boolean z16;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                final String string = jSONObject.getString(TPDownloadProxyEnum.USER_SSID);
                final String string2 = jSONObject.getString("type");
                final String string3 = jSONObject.getString("callback");
                try {
                    str2 = jSONObject.getString(NotificationActivity.PASSWORD);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    str2 = "";
                }
                final String str3 = str2;
                try {
                    z16 = jSONObject.getBoolean("isHidden");
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    z16 = false;
                }
                final boolean z17 = z16;
                if (this.Q) {
                    callJs(string3, "4");
                    return;
                }
                if (!TextUtils.isEmpty(string3) && this.f78521e != null) {
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        final WifiManager wifiManager = (WifiManager) this.f78521e.getApplicationContext().getSystemService("wifi");
                        if (wifiManager == null) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("SensorApi", 4, "No WifiManager available from device");
                            }
                            callJs(string3, "2");
                            return;
                        } else {
                            this.Q = true;
                            new BaseThread() { // from class: com.tencent.biz.game.SensorAPIJavaScript.10
                                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                                public void run() {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("SensorApi", 4, "start connectToWiFi");
                                    }
                                    if (new com.google.zxing.client.android.wifi.a(wifiManager).k(new com.google.zxing.client.android.wifi.c(string2, string, str3, z17))) {
                                        Message message = new Message();
                                        message.what = 5;
                                        message.obj = string3;
                                        SensorAPIJavaScript.this.f78520d0.sendMessage(message);
                                        return;
                                    }
                                    SensorAPIJavaScript sensorAPIJavaScript = SensorAPIJavaScript.this;
                                    sensorAPIJavaScript.Q = false;
                                    sensorAPIJavaScript.callJs(string3, s.l(Integer.toString(1)));
                                }
                            }.start();
                            return;
                        }
                    }
                    callJs(string3, "3");
                }
            } catch (JSONException e18) {
                e18.printStackTrace();
            }
        } catch (JSONException e19) {
            e19.printStackTrace();
        }
    }

    public void forceUpdate(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        forceUpdate(str, str2, "0", str3);
    }

    public final String getClientInfo() {
        return "{\"qqVersion\":\"" + qqVersion() + "\",\"qqBuild\":\"" + AppSetting.f99542b + "\"}";
    }

    public boolean getCurrentSong(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            String optString = new JSONObject(str).optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            this.f78516a0.E().a(new c(optString));
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "getCurrentSong json err");
            }
            return true;
        }
    }

    public final String getDeviceInfo() {
        return getDeviceInfoEx("WebViewPlugin");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qbizApi";
    }

    public JSONObject getNetworkInfo() {
        int netWorkType = HttpUtil.getNetWorkType();
        String netWorkTypeByStr = HttpUtil.getNetWorkTypeByStr();
        int H = ah.H(BaseApplication.getContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", netWorkType);
            jSONObject.put("radio", netWorkTypeByStr);
            jSONObject.put("carriertype", H);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public int getNetworkType() {
        return HttpUtil.getNetWorkType();
    }

    public boolean getPlayMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            String optString = new JSONObject(str).optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            this.f78516a0.E().b(new b(optString));
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "getPlayMode json err");
            }
            return true;
        }
    }

    public boolean getPlayState(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            String optString = new JSONObject(str).optString("callback");
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            this.f78516a0.E().c(new a(optString));
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "getPlayState json err");
            }
            return true;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 4L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (j3 == 4) {
            if (map != null) {
                notifyCacheReady(((Integer) map.get("code")).intValue());
                return true;
            }
            return true;
        }
        return false;
    }

    public void isCached(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String z16 = HtmlOffline.z(str);
        if (TextUtils.isEmpty(z16)) {
            callJs(str2, "-1");
        } else {
            callJs(str2, z16);
        }
    }

    public final String modelVersion() {
        return DeviceInfoMonitor.getModel();
    }

    public boolean notifyCacheReady(int i3) {
        if (TextUtils.isEmpty(this.f78525m)) {
            return false;
        }
        String str = "";
        if (i3 == 0) {
            str = "success";
        } else if (i3 == 1) {
            str = "param error";
        } else if (i3 == 2) {
            str = "download error";
        } else if (i3 == 3) {
            str = "no sdcard";
        } else if (i3 == 4) {
            str = "other ";
        } else if (i3 == 5) {
            str = "had update ";
        }
        callJs(this.f78525m, Integer.toString(i3), s.l(str));
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        Activity a16;
        if (i3 == -1 && b16 == 1 && intent != null && intent.getBooleanExtra("closeSpecialLogic", false) && this.f78519d && (a16 = this.mRuntime.a()) != null) {
            a16.setResult(-1, intent);
            a16.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        s();
        this.f78521e = this.mRuntime.a();
        if (this.mRuntime.b() != null) {
            this.M = this.mRuntime.b().getCurrentAccountUin();
        }
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f78516a0 = A;
        A.p();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        this.f78522f = new WeakReference<>(this.mRuntime.e());
    }

    public final void openLinkInNewWebView(String str, String str2) {
        int i3;
        PluginJumpManager.getInstance().updateConfig(((QBaseActivity) this.f78521e).getAppRuntime());
        PluginJumpManager.getInstance().loadConfig();
        if (!PluginJumpManager.getInstance().openView(this.f78521e, str, str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Bundle extras = this.f78521e.getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            } else {
                extras.remove("title");
                extras.remove(AppConstants.LeftViewText.LEFTVIEWTEXT);
                extras.remove("post_data");
                extras.remove("options");
                if (extras.containsKey("startOpenPageTime")) {
                    extras.putLong("startOpenPageTime", System.currentTimeMillis());
                }
            }
            try {
                i3 = Integer.valueOf(str2).intValue();
            } catch (Exception unused) {
                i3 = 0;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            extras.putBoolean("hide_more_button", true);
                            extras.putBoolean("hide_operation_bar", false);
                            extras.putString("webStyle", "");
                        }
                    } else {
                        extras.putBoolean("hide_more_button", false);
                        extras.putBoolean("hide_operation_bar", false);
                        extras.putString("webStyle", "");
                    }
                } else {
                    extras.putBoolean("hide_more_button", true);
                    extras.putBoolean("hide_operation_bar", true);
                }
            } else {
                extras.putBoolean("hide_more_button", false);
                extras.putBoolean("hide_operation_bar", true);
            }
            Activity activity = this.f78521e;
            Intent intent = new Intent(activity, activity.getClass());
            intent.putExtras(extras);
            intent.putExtra("url", str);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            intent.setFlags(0);
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof r)) {
                String currentUrl = ((r) d16).getCurrentUrl();
                if (!TextUtils.isEmpty(currentUrl) && currentUrl.contains("closeSpecialLogic") && URLUtil.getInt(URLUtil.getArgumentsFromURL(currentUrl), "closeSpecialLogic", 0) != 0) {
                    this.f78519d = true;
                }
            }
            if (this.f78519d) {
                startActivityForResult(intent, (byte) 1);
            } else {
                this.f78521e.startActivityForResult(intent, 100);
            }
        }
    }

    public boolean pausePlayMusic() {
        this.f78516a0.E().e();
        return true;
    }

    public final void phoneVibrate(String str) {
        long j3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            j3 = Long.valueOf(str).longValue();
        } catch (Exception unused) {
            j3 = 0;
        }
        Vibrator vibrator = (Vibrator) this.f78521e.getSystemService("vibrator");
        if (vibrator == null) {
            return;
        }
        vibrator.vibrate(j3);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(8)
    public boolean playVoice(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (this.f78523h == null) {
            this.f78523h = new SoundPool(10, 3, 0);
        }
        if (this.f78524i == null) {
            this.f78524i = new HashMap<>();
        }
        if (!this.f78524i.containsKey(str2)) {
            if (!preloadVoice(str, str2, null)) {
                return false;
            }
            this.f78523h.setOnLoadCompleteListener(new f(str2));
            return true;
        }
        if (this.f78523h.play(this.f78524i.get(str2).intValue(), 1.0f, 1.0f, 0, 0, 1.0f) == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SensorApi", 2, "play failure url=" + str2);
            }
            return false;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(8)
    public boolean preloadVoice(String str, String str2, String str3) {
        HashMap<String, Integer> hashMap;
        String str4;
        if (TextUtils.isEmpty(str2) || ((hashMap = this.f78524i) != null && hashMap.containsKey(str2))) {
            return false;
        }
        Environment.getExternalStorageDirectory().getAbsolutePath();
        String str5 = File.separator;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(com.tencent.biz.common.offline.c.e());
        sb5.append(str);
        sb5.append('/');
        String scheme = Uri.parse(str2).getScheme();
        if (scheme != null) {
            str4 = scheme + QzoneWebViewOfflinePlugin.STR_DEVIDER;
        } else {
            str4 = "";
        }
        if (str2.length() >= str4.length()) {
            sb5.append(str2.substring(str4.length()));
        }
        File file = new File(sb5.toString());
        if (!file.exists()) {
            return false;
        }
        if (this.f78523h == null) {
            this.f78523h = new SoundPool(10, 3, 0);
        }
        if (this.f78524i == null) {
            this.f78524i = new HashMap<>();
        }
        this.f78523h.setOnLoadCompleteListener(null);
        int load = this.f78523h.load(file.getAbsolutePath(), 1);
        if (load == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("SensorApi", 2, "load failure url=" + str2);
            }
            return false;
        }
        this.f78524i.put(str2, Integer.valueOf(load));
        return true;
    }

    void q(final String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("SensorApi", 4, "start checkWifiStatus");
        }
        final Context applicationContext = this.f78521e.getApplicationContext();
        new BaseThread() { // from class: com.tencent.biz.game.SensorAPIJavaScript.11
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                int i3;
                WeakReference<WebView> weakReference;
                String str2 = "";
                for (int i16 = 15; i16 > 0 && (weakReference = SensorAPIJavaScript.this.f78522f) != null && weakReference.get() != null; i16--) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("SensorApi", 4, "run check: " + i16);
                    }
                    str2 = com.google.zxing.client.android.wifi.a.e(applicationContext);
                    if (!TextUtils.isEmpty(str2)) {
                        i3 = 0;
                        break;
                    }
                    try {
                        LockMethodProxy.sleep(2000L);
                    } catch (InterruptedException unused) {
                    }
                }
                i3 = 2;
                SensorAPIJavaScript.this.Q = false;
                if (QLog.isDevelopLevel()) {
                    QLog.d("SensorApi", 4, "run check end: " + i3);
                }
                if (i3 == 0) {
                    SensorAPIJavaScript.this.callJs(str, s.l(Integer.toString(i3)), s.l(str2), s.l(Integer.toString(SensorAPIJavaScript.this.t())));
                } else {
                    SensorAPIJavaScript.this.callJs(str, s.l(Integer.toString(i3)));
                }
            }
        }.start();
    }

    public final String qqVersion() {
        String str;
        try {
            WebViewPlugin.b bVar = this.mRuntime;
            y d16 = bVar.d(bVar.a());
            if (d16 != null && (d16 instanceof com.tencent.mobileqq.webviewplugin.k)) {
                str = InstalledAppListMonitor.getPackageInfo(this.f78521e.getPackageManager(), "com.tencent.mobileqq", 0).versionName;
            } else {
                str = InstalledAppListMonitor.getPackageInfo(this.f78521e.getPackageManager(), this.f78521e.getPackageName(), 0).versionName;
            }
            return str;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public void refreshOfflineCache() {
        WebView webView;
        WeakReference<WebView> weakReference = this.f78522f;
        if (weakReference != null && (webView = weakReference.get()) != null) {
            webView.loadUrl(webView.getUrl());
        }
    }

    public void release() {
        SoundPool soundPool = this.f78523h;
        if (soundPool != null) {
            soundPool.release();
            this.f78523h = null;
        }
        com.tencent.biz.game.b bVar = f78515f0;
        if (bVar != null) {
            bVar.a();
            f78515f0 = null;
        }
        stopAccelerometer();
        stopCompass();
        stopListen();
        stopLight();
        WeakReference<WebView> weakReference = this.f78522f;
        if (weakReference != null) {
            weakReference.clear();
        }
        com.tencent.biz.troop.b bVar2 = this.f78516a0;
        if (bVar2 != null) {
            bVar2.q();
        }
        this.f78522f = null;
    }

    public boolean resumePlayMusic() {
        this.f78516a0.E().f();
        return true;
    }

    public void returnToAIO() {
        if ("Meizu_M040".equals(Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel())) {
            if (QLog.isColorLevel()) {
                QLog.d("Sensor", 2, "meizu mx2 returnToAIO");
            }
            new Handler().postDelayed(new Runnable() { // from class: com.tencent.biz.game.SensorAPIJavaScript.5
                @Override // java.lang.Runnable
                public void run() {
                    SensorAPIJavaScript sensorAPIJavaScript = SensorAPIJavaScript.this;
                    SensorAPIJavaScript.returnToAio(sensorAPIJavaScript.f78516a0, sensorAPIJavaScript.f78521e, "", false);
                }
            }, 400L);
        } else {
            returnToAio(this.f78516a0, this.f78521e, "", false);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SensorAPIJavaScript", 2, String.format("returnToAIO mBrowserActivity=[%s]", this.f78521e));
        }
    }

    public void sendFunnyFace(String str, String str2, String str3, String str4, String str5) {
        SessionInfo sessionInfo;
        try {
            int parseInt = Integer.parseInt(str5);
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.f78521e), null);
            m3.putExtra("indexOfFunnyFaceClickedInWebview", parseInt);
            Intent intent = this.f78521e.getIntent();
            if (intent != null && (sessionInfo = (SessionInfo) intent.getParcelableExtra("sessionInfo")) != null) {
                ChatActivityUtils.J(sessionInfo, m3);
                m3.putExtra("sessionInfo", sessionInfo);
                this.f78521e.startActivity(m3);
            }
        } catch (Exception unused) {
        }
    }

    public boolean setPlayMode(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            int optInt = new JSONObject(str).optInt("mode", -1);
            if (optInt == -1) {
                return true;
            }
            this.f78516a0.E().g(optInt);
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("WebViewPlugin", 2, "setPlayMode json err");
            }
            return true;
        }
    }

    public final void startAccelerometer(String str) {
        if (this.H == null) {
            this.H = (SensorManager) this.f78521e.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        List<Sensor> sensorList = SensorMonitor.getSensorList(this.H, 1);
        if (sensorList.size() > 0) {
            Sensor sensor = sensorList.get(0);
            if (this.I != null) {
                stopAccelerometer();
            }
            j jVar = new j((byte) 0, str);
            this.I = jVar;
            SensorMonitor.registerListener(this.H, jVar, sensor, 0);
            return;
        }
        callJs(str, "false");
    }

    public final void startCompass(String str) {
        if (this.H == null) {
            this.H = (SensorManager) this.f78521e.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        List<Sensor> sensorList = SensorMonitor.getSensorList(this.H, 3);
        if (sensorList.size() > 0) {
            Sensor sensor = sensorList.get(0);
            if (this.K != null) {
                stopCompass();
            }
            j jVar = new j((byte) 2, str);
            this.K = jVar;
            SensorMonitor.registerListener(this.H, jVar, sensor, 0);
            return;
        }
        callJs(str, "false");
    }

    public final void startLight(String str) {
        if (this.H == null) {
            this.H = (SensorManager) this.f78521e.getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
        }
        List<Sensor> sensorList = SensorMonitor.getSensorList(this.H, 5);
        if (sensorList.size() > 0) {
            Sensor sensor = sensorList.get(0);
            if (this.J != null) {
                stopLight();
            }
            j jVar = new j((byte) 1, str);
            this.J = jVar;
            SensorMonitor.registerListener(this.H, jVar, sensor, 0);
            return;
        }
        callJs(str, "false");
    }

    public final void startListen(String str) {
        if (this.L) {
            callJs(str, "false");
            return;
        }
        if (this.f78521e instanceof AppActivity) {
            if (this.f78517b0 == null) {
                this.f78517b0 = QQPermissionFactory.getQQPermission(this.f78521e, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_SENSOR));
            }
            this.f78517b0.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new d(str));
            return;
        }
        callJs(str, "false", "{result: -1, msg: 'no record activity'}");
    }

    public boolean startPlayMusic(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            new JSONObject(str);
            this.f78516a0.E().h(str);
            return true;
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "playQQMusic err:" + str);
            }
            e16.printStackTrace();
            return true;
        }
    }

    public void startSyncData(String str, String str2) {
        if (f78515f0 == null) {
            f78515f0 = new com.tencent.biz.game.b();
        }
        AppInterface b16 = this.mRuntime.b();
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SensorApi", 2, "appRuntime is null");
                return;
            }
            return;
        }
        f78515f0.c(str, str2, b16, this.f78521e, new b.InterfaceC0792b() { // from class: com.tencent.biz.game.SensorAPIJavaScript.9
            @Override // com.tencent.biz.game.b.InterfaceC0792b
            public void a(int i3, final String str3) {
                final String b17 = SensorAPIJavaScript.f78515f0.b(String.valueOf(i3));
                if (!TextUtils.isEmpty(b17)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SensorApi", 2, "send data to appId=" + i3);
                    }
                    SensorAPIJavaScript sensorAPIJavaScript = SensorAPIJavaScript.this;
                    if (sensorAPIJavaScript.f78520d0 == null) {
                        sensorAPIJavaScript.f78520d0 = new Handler(Looper.getMainLooper());
                    }
                    SensorAPIJavaScript.this.f78520d0.post(new Runnable() { // from class: com.tencent.biz.game.SensorAPIJavaScript.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SensorAPIJavaScript.this.callJs(b17, str3);
                        }
                    });
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SensorApi", 2, "appId=" + i3 + "'s callback is empty");
                }
            }

            @Override // com.tencent.biz.game.b.InterfaceC0792b
            public void b(int i3, SvcRespPushMsg svcRespPushMsg) {
                AppInterface b17;
                SensorAPIJavaScript sensorAPIJavaScript = SensorAPIJavaScript.this;
                if (sensorAPIJavaScript.f78521e != null && (b17 = sensorAPIJavaScript.mRuntime.b()) != null) {
                    ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", b17.getAccount(), BaseConstants.CMD_RESPPUSH);
                    toServiceMsg.setNeedCallback(false);
                    UniPacket uniPacket = new UniPacket(true);
                    uniPacket.setEncodeName("utf-8");
                    int i16 = MobileQQServiceBase.seq;
                    MobileQQServiceBase.seq = i16 + 1;
                    uniPacket.setRequestId(i16);
                    uniPacket.setServantName("OnlinePush");
                    uniPacket.setFuncName("SvcRespPushMsg");
                    uniPacket.setRequestId(i3);
                    uniPacket.put("resp", svcRespPushMsg);
                    toServiceMsg.putWupBuffer(uniPacket.encode());
                    NewIntent newIntent = new NewIntent(SensorAPIJavaScript.this.f78521e.getApplicationContext(), com.tencent.mobileqq.compatible.a.class);
                    newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
                    b17.startServlet(newIntent);
                    if (QLog.isColorLevel()) {
                        QLog.d("SensorApi", 2, "reply push");
                    }
                }
            }
        });
    }

    public final void stopAccelerometer() {
        j jVar;
        SensorManager sensorManager = this.H;
        if (sensorManager != null && (jVar = this.I) != null) {
            sensorManager.unregisterListener(jVar);
            this.I = null;
        }
    }

    public void stopCompass() {
        j jVar;
        SensorManager sensorManager = this.H;
        if (sensorManager != null && (jVar = this.K) != null) {
            sensorManager.unregisterListener(jVar);
            this.K = null;
        }
    }

    public final void stopLight() {
        j jVar;
        SensorManager sensorManager = this.H;
        if (sensorManager != null && (jVar = this.J) != null) {
            sensorManager.unregisterListener(jVar);
            this.J = null;
        }
    }

    public final void stopListen() {
        MediaRecorder mediaRecorder = this.P;
        if (mediaRecorder != null) {
            mediaRecorder.release();
            this.P = null;
        }
        this.f78520d0.removeMessages(291);
        this.L = false;
    }

    public boolean stopPlayMusic() {
        this.f78516a0.E().i();
        return true;
    }

    public void stopSyncData() {
        com.tencent.biz.game.b bVar = f78515f0;
        if (bVar != null) {
            bVar.a();
        }
        f78515f0 = null;
    }

    public final String systemName() {
        return "android";
    }

    public final String systemVersion() {
        return Build.VERSION.RELEASE;
    }

    protected final int t() {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Process exec;
        try {
            try {
                exec = RuntimeMonitor.exec(Runtime.getRuntime(), "ping -c 3 -w 100 www.qq.com");
                inputStream = exec.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.i("SensorApi", 4, "result content : " + stringBuffer.toString());
                        }
                    } catch (IOException unused) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("SensorApi", 4, "finally result = failed~ IOException");
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            return 1;
                        }
                        return 1;
                    } catch (InterruptedException unused2) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("SensorApi", 4, "finally result = failed~ InterruptedException");
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                            return 1;
                        }
                        return 1;
                    } catch (Throwable th5) {
                        th = th5;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("SensorApi", 4, "finally result = " + ((String) null));
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException e19) {
                                e19.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                    bufferedReader = null;
                } catch (InterruptedException unused4) {
                    bufferedReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                }
            } catch (IOException unused5) {
                inputStream = null;
                bufferedReader = null;
            } catch (InterruptedException unused6) {
                inputStream = null;
                bufferedReader = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                bufferedReader = null;
            }
            if (exec.waitFor() == 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("SensorApi", 4, "finally result = successful~");
                }
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return 0;
                    } catch (IOException e27) {
                        e27.printStackTrace();
                        return 0;
                    }
                }
                return 0;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("SensorApi", 4, "finally result = failed~ cannot reach the IP address");
            }
            try {
                bufferedReader.close();
            } catch (IOException e28) {
                e28.printStackTrace();
            }
            if (inputStream != null) {
                inputStream.close();
                return 1;
            }
            return 1;
        } catch (IOException e29) {
            e29.printStackTrace();
            return 1;
        }
    }

    public void updateMicStatus(String str) {
        if (this.P != null) {
            int log10 = (int) (Math.log10(r0.getMaxAmplitude()) * 20.0d);
            if (!TextUtils.isEmpty(str)) {
                callJs(str, "true", Integer.toString(log10));
                Message message = new Message();
                message.what = 291;
                message.obj = str;
                this.f78520d0.sendMessageDelayed(message, this.f78518c0);
            }
        }
    }

    public void forceUpdate(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || str.length() > 10) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap(arrayList.size());
        hashMap.put(str, "0");
        HtmlOffline.l(this.mRuntime.b(), hashMap, new h(str4), true, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f78546d;

        h(String str) {
            this.f78546d = str;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (TextUtils.isEmpty(this.f78546d)) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("forceUpdate", 2, "loaded code:" + i3);
            }
            SensorAPIJavaScript sensorAPIJavaScript = SensorAPIJavaScript.this;
            sensorAPIJavaScript.f78525m = this.f78546d;
            sensorAPIJavaScript.notifyCacheReady(i3);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }

    /* loaded from: classes2.dex */
    class i implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f78548d;

        i(String str) {
            this.f78548d = str;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (!TextUtils.isEmpty(this.f78548d) && !TextUtils.isEmpty(str)) {
                try {
                    SensorAPIJavaScript.this.callJs(this.f78548d, new JSONObject(str).toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }

    /* loaded from: classes2.dex */
    public class j implements SensorEventListener {

        /* renamed from: d, reason: collision with root package name */
        protected byte f78550d;

        /* renamed from: e, reason: collision with root package name */
        protected String f78551e;

        public j(byte b16, String str) {
            this.f78550d = b16;
            this.f78551e = str;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            byte b16 = this.f78550d;
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 == 2) {
                        SensorAPIJavaScript.this.callJs(this.f78551e, String.valueOf(true), String.valueOf(sensorEvent.values[0]));
                        return;
                    }
                    return;
                }
                SensorAPIJavaScript.this.callJs(this.f78551e, String.valueOf(true), String.valueOf(sensorEvent.values[0]));
                return;
            }
            float[] fArr = sensorEvent.values;
            SensorAPIJavaScript.this.callJs(this.f78551e, String.valueOf(true), String.valueOf(fArr[0]), String.valueOf(fArr[1]), String.valueOf(fArr[2]));
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i3) {
        }
    }
}
