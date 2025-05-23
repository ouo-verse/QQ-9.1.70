package com.tencent.qqperf.crashdefend.report;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey;
import com.tencent.common.config.AppSetting;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class b {

    /* renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat f363103h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: i, reason: collision with root package name */
    static volatile String f363104i = "unknown";

    /* renamed from: j, reason: collision with root package name */
    static volatile String f363105j = null;

    /* renamed from: a, reason: collision with root package name */
    String f363106a = "unknown";

    /* renamed from: b, reason: collision with root package name */
    String f363107b = "unknown_device_model";

    /* renamed from: c, reason: collision with root package name */
    String f363108c = "unknown_device_id";

    /* renamed from: d, reason: collision with root package name */
    String f363109d = "unknown_device_rom";

    /* renamed from: e, reason: collision with root package name */
    String f363110e = "unknown";

    /* renamed from: f, reason: collision with root package name */
    String f363111f = "unknown";

    /* renamed from: g, reason: collision with root package name */
    String f363112g = MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;

    private void c(JSONObject jSONObject) throws JSONException, UnsupportedEncodingException {
        jSONObject.put("appVersion", URLEncoder.encode(this.f363106a, "UTF-8"));
        jSONObject.put("sdkId", EnginePathProvider.ENGINE_JS_DIR);
        jSONObject.put("sdkVersion", "4.3.4-web");
        jSONObject.put("mainAppKey", "0S200MNJT807V3GE");
        jSONObject.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "3");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(NowProxyConstants.AccountInfoKey.A2, this.f363108c);
        jSONObject.put("common", jSONObject2);
    }

    public static void e(Context context) {
        PackageManager packageManager;
        try {
            String j3 = AppSetting.j(context);
            ReportSaveInfoHelper.f(context);
            f();
            if (com.tencent.mobileqq.qqperftool.common.f.a(j3) && context != null && (packageManager = context.getPackageManager()) != null) {
                try {
                    PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, MobileQQ.PACKAGE_NAME, 0);
                    if (packageInfo != null) {
                        j3 = packageInfo.versionName + "." + packageInfo.versionCode;
                    }
                } catch (PackageManager.NameNotFoundException e16) {
                    wy3.c.d("StartStepCrashReportHelper", "initBaseEnvironment packageManager failed", e16);
                }
            }
            if (!com.tencent.mobileqq.qqperftool.common.f.a(j3)) {
                f363104i = j3;
            }
        } catch (Throwable th5) {
            wy3.c.d("StartStepCrashReportHelper", "initBaseEnvironment failed", th5);
        }
    }

    private static void f() {
        if (f363105j != null) {
            return;
        }
        f363105j = Process.myPid() + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        try {
            this.f363106a = f363104i;
            this.f363110e = "" + Build.VERSION.SDK_INT;
            this.f363111f = "" + Build.VERSION.RELEASE;
            this.f363108c = ReportSaveInfoHelper.e().c();
            this.f363107b = ReportSaveInfoHelper.e().a();
            this.f363109d = ReportSaveInfoHelper.e().b();
            this.f363112g = ReportSaveInfoHelper.e().d();
        } catch (Throwable th5) {
            wy3.c.d("StartStepCrashReportHelper", "fullBaseReportInfo failed", th5);
        }
    }

    protected abstract JSONArray b() throws JSONException;

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            c(jSONObject);
            JSONArray b16 = b();
            if (b16 != null) {
                jSONObject.put(LinkReportConstant$GlobalKey.EVENTS, b16);
            }
        } catch (Throwable th5) {
            wy3.c.d("StartStepCrashReportHelper", "getReportJson has exception: ", th5);
        }
        return jSONObject;
    }
}
