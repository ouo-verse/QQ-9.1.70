package com.qq.e.comm.plugin.k;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$EventId;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class bb {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends com.qq.e.comm.plugin.i.a {

        /* renamed from: a, reason: collision with root package name */
        String f39647a;

        /* renamed from: b, reason: collision with root package name */
        JSONObject f39648b;

        /* renamed from: d, reason: collision with root package name */
        String f39649d;

        /* renamed from: e, reason: collision with root package name */
        String f39650e;

        /* renamed from: f, reason: collision with root package name */
        String f39651f;

        /* renamed from: g, reason: collision with root package name */
        long f39652g;

        /* renamed from: h, reason: collision with root package name */
        String f39653h;

        /* renamed from: i, reason: collision with root package name */
        long f39654i;

        /* renamed from: j, reason: collision with root package name */
        boolean f39655j;

        public a(String str, JSONObject jSONObject, String str2, String str3, String str4, long j3, String str5, boolean z16) {
            this.f39647a = str;
            this.f39648b = jSONObject;
            this.f39649d = str2;
            this.f39650e = str3;
            this.f39651f = str4;
            this.f39652g = j3;
            this.f39653h = str5;
            this.f39655j = z16;
        }

        @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, long j16, int i3) {
        }

        @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
        public void a() {
            bb.b(5000018, 2, bb.b(this.f39648b, this.f39647a, 2, 0L, 0), this.f39655j);
            GDTLogger.d("fetchPkgInfo: download start");
        }

        @Override // com.qq.e.comm.plugin.i.a
        public void b(boolean z16) {
        }

        @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, boolean z16) {
            this.f39654i = j3 / 1024;
            GDTLogger.d("onConnected, length = " + this.f39654i);
        }

        @Override // com.qq.e.comm.plugin.i.a
        public void a(boolean z16) {
            if (!z16) {
                bb.b(5000020, 2, bb.b(this.f39648b, this.f39647a, 2, this.f39654i, 0), this.f39655j);
            }
            GDTLogger.d("fetchPkgInfo: download complete");
            com.qq.e.comm.plugin.base.ad.c.k.a().a(this.f39649d, this.f39650e, this.f39651f, this.f39652g, this.f39653h, this.f39654i);
            com.qq.e.comm.plugin.base.ad.c.k.a().b();
        }

        @Override // com.qq.e.comm.plugin.i.a
        public void a(com.qq.e.comm.plugin.i.d dVar, boolean z16) {
            if (!z16) {
                bb.b(5000021, 2, bb.b(this.f39648b, this.f39647a, 2, this.f39654i, dVar.c()), this.f39655j);
            }
            GDTLogger.d("fetchPkgInfo: download failed");
        }

        @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
        public void c() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b() {
        int i3;
        int i16;
        Bundle bundle;
        Context appContext = GDTADManager.getInstance().getAppContext();
        int i17 = 0;
        if (appContext == null) {
            GDTLogger.e("getWXAppSupportAPI: context is null");
            return 0;
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        try {
            try {
            } catch (Throwable th5) {
                th = th5;
                i3 = 0;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            i16 = 3;
        }
        if (appContext.getPackageManager() == null) {
            GDTLogger.e("getWXAppSupportAPI: getPackageManager is null");
            return 0;
        }
        ApplicationInfo applicationInfo = appContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128);
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            i17 = bundle.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
            i16 = 0;
        } else {
            i16 = applicationInfo == null ? 1 : 2;
            try {
                cVar.a("wx", g());
            } catch (Throwable th6) {
                i3 = i16;
                th = th6;
                cVar.a("msg", th.toString());
                i16 = i3;
                if (i16 != 0) {
                }
                return i17;
            }
        }
        if (i16 != 0) {
            StatTracer.trackEvent(53802, i16, (com.qq.e.comm.plugin.stat.b) null, cVar);
        }
        return i17;
    }

    public static String c() {
        Class a16 = al.a("com.tencent.mm.opensdk.constants.Build");
        if (a16 != null) {
            try {
                return (String) a16.getField("SDK_VERSION_NAME").get(a16);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return "";
            } catch (NoSuchFieldException e17) {
                e17.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static int d() {
        Class a16 = al.a("com.tencent.mm.opensdk.constants.Build");
        if (a16 != null) {
            try {
                return a16.getField("SDK_INT").getInt(a16);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return 0;
            } catch (NoSuchFieldException e17) {
                e17.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static String e() {
        int b16 = b();
        int d16 = d();
        return String.format("WX: %d = 0x%x, OpenSDK: %d = 0x%x, %s, canLaunch = %b", Integer.valueOf(b16), Integer.valueOf(b16), Integer.valueOf(d16), Integer.valueOf(d16), c(), Boolean.valueOf(f()));
    }

    public static boolean f() {
        return b(true);
    }

    private static JSONObject g() {
        int length;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(GDTADManager.getInstance().getAppContext().getPackageManager(), "com.tencent.mm", 64);
            if (packageInfo == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("vc", Integer.valueOf(packageInfo.versionCode));
                jSONObject.putOpt("vn", packageInfo.versionName);
                Signature[] signatureArr = packageInfo.signatures;
                boolean z16 = false;
                if (signatureArr == null) {
                    length = 0;
                } else {
                    length = signatureArr.length;
                }
                jSONObject.putOpt("sigl", Integer.valueOf(length));
                Signature[] signatureArr2 = packageInfo.signatures;
                if (signatureArr2 != null && signatureArr2.length > 0) {
                    int length2 = signatureArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        if (signatureArr2[i3].toCharsString().toLowerCase().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                            z16 = true;
                            break;
                        }
                        i3++;
                    }
                    jSONObject.putOpt("sigv", Boolean.valueOf(z16));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            return jSONObject;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean a() {
        return al.a("com.tencent.mm.opensdk.openapi.WXAPIFactory") != null;
    }

    private static int a(Object obj, String str) {
        GDTLogger.i(String.format("%s start reg", str));
        Method a16 = al.a(obj.getClass(), "registerApp", String.class);
        if (a16 == null) {
            GDTLogger.e("reg failed, can't get registerApp method");
            return 2;
        }
        Object a17 = al.a(obj, a16, str);
        GDTLogger.i(String.format("%s end reg, result = %b", str, a17));
        if (a17 instanceof Boolean) {
            return ((Boolean) a17).booleanValue() ? 1 : 3;
        }
        return 4;
    }

    private static int a(Object obj) {
        GDTLogger.i(String.format("start openWXApp", new Object[0]));
        Method a16 = al.a(obj.getClass(), "openWXApp", new Class[0]);
        if (a16 == null) {
            GDTLogger.e("openWXApp failed, can't get openWXApp method");
            return 2;
        }
        Object a17 = al.a(obj, a16, new Object[0]);
        GDTLogger.i(String.format("end openWXApp, result = %b", a17));
        if (a17 instanceof Boolean) {
            return ((Boolean) a17).booleanValue() ? 1 : 3;
        }
        return 4;
    }

    private static boolean b(boolean z16) {
        return a() && d() >= 620953856 && a(z16) && b() >= 620953856;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i3, int i16, com.qq.e.comm.plugin.stat.b bVar, boolean z16) {
        if (z16) {
            StatTracer.trackEvent(i3, i16, bVar, (com.qq.e.comm.plugin.stat.c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.qq.e.comm.plugin.stat.b b(JSONObject jSONObject, String str, int i3, long j3, int i16) {
        if (!y.a(jSONObject)) {
            return null;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(str);
        bVar.c(jSONObject.optString("traceid"));
        bVar.b(jSONObject.optString("cl"));
        bVar.a(jSONObject.optInt("ad_first_category"));
        bVar.b(jSONObject.optInt("advertiser_id"));
        bVar.c(jSONObject.optInt("producttype"));
        bVar.d(jSONObject.optInt("inner_adshowtype"));
        int i17 = 3;
        if (i3 != 3) {
            i17 = 2;
            if (i3 != 2) {
                i17 = 1;
            }
        }
        bVar.a(LinkReportConstant$BizKey.WX_SDK_METHOD, i17);
        bVar.a(LinkReportConstant$BizKey.CODE_SIZE, j3);
        bVar.a(LinkReportConstant$BizKey.ORIGIN_ERROR_CODE, i16);
        return bVar;
    }

    public static boolean a(boolean z16) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            GDTLogger.e("isWXAppInstalled: context is null");
            return false;
        }
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(appContext.getPackageManager(), "com.tencent.mm", 64);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0) {
            if (!z16) {
                return true;
            }
            for (Signature signature : signatureArr) {
                if (signature.toCharsString().toLowerCase().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i3, boolean z16) {
        GDTLogger.d("launchInfo = " + jSONObject);
        GDTLogger.d(e());
        Context appContext = GDTADManager.getInstance().getAppContext();
        com.qq.e.comm.plugin.stat.b a16 = a(jSONObject2, str, i3);
        if (i3 == 3) {
            b(4006001, i3, a16, z16);
        } else {
            b(i3 == 2 ? 5000017 : 5000015, i3, a16, z16);
        }
        if (!a(jSONObject, appContext)) {
            GDTLogger.e("ad info invalid");
            b(4006003, i3, a16, z16);
            return -4;
        }
        b(4006002, i3, a16, z16);
        int d16 = d();
        if (d16 < 620953856) {
            GDTLogger.e("openSDK not support, ver = " + d16);
            b(LinkReportConstant$EventId.OPENSDK_VERSION_FAILED, i3, a16, z16);
            return -5;
        }
        b(LinkReportConstant$EventId.OPENSDK_VERSION_SUCCESS, i3, a16, z16);
        int b16 = b();
        if (b16 < 620953856) {
            GDTLogger.e("wx not support, ver = " + b16);
            b(4006007, i3, a16, z16);
            return -6;
        }
        b(4006006, i3, a16, z16);
        String a17 = a(jSONObject, appContext, i3, jSONObject2, str, z16);
        if ((i3 == 1 && d16 < 621085952) || i3 == 2) {
            return a(appContext, jSONObject, a17, jSONObject2, str, i3, z16);
        }
        int a18 = a(appContext, jSONObject, a17, i3, d16, jSONObject2, str);
        if (a18 == 0) {
            b(4006008, i3, a16, z16);
        } else if (a18 == -3 || a18 == -2) {
            b(4006009, i3, a16, z16);
        }
        return a18;
    }

    private static int a(Context context, JSONObject jSONObject, String str, int i3, int i16, JSONObject jSONObject2, String str2) {
        int i17;
        Field a16;
        String optString = jSONObject.optString("wx_appid");
        String optString2 = jSONObject.optString("username");
        String optString3 = jSONObject.optString("path");
        boolean z16 = i3 != 3;
        GDTLogger.i(String.format("%s start launch %s, path = %s, preload = %b", optString, optString2, optString3, Boolean.valueOf(z16)));
        Class a17 = al.a("com.tencent.mm.opensdk.openapi.WXAPIFactory");
        if (a17 == null) {
            GDTLogger.e("can't get class WXAPIFactory");
            i17 = 101;
        } else {
            Method a18 = al.a(a17, "createWXAPI", Context.class, String.class);
            if (a18 == null) {
                GDTLogger.e("get method createWXAPI() failed");
                i17 = 102;
            } else {
                Object a19 = al.a(a17, a18, context, optString);
                if (a19 == null) {
                    GDTLogger.e("invoke method createWXAPI() failed");
                    i17 = 103;
                } else {
                    if (a(a19, optString) != 1) {
                        GDTLogger.e("register to wx failed");
                    }
                    if (!z16 && ((Build.VERSION.SDK_INT < 28 || i16 < 621019904) && a(a19) != 1)) {
                        GDTLogger.e("open wx app failed");
                    }
                    String str3 = z16 ? "com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram$Req" : "com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req";
                    Class a26 = al.a(str3);
                    if (a26 == null) {
                        GDTLogger.e("can't get class " + str3);
                        i17 = 104;
                    } else {
                        Object a27 = al.a(a26);
                        if (a27 == null) {
                            GDTLogger.e("can't new " + str3);
                            i17 = 105;
                        } else {
                            Field a28 = al.a(a26, "userName");
                            if (a28 != null && al.a(a28, a27, optString2)) {
                                if (!TextUtils.isEmpty(optString3) && ((a16 = al.a(a26, "path")) == null || !al.a(a16, a27, optString3))) {
                                    GDTLogger.e("set field path failed");
                                    i17 = 107;
                                } else {
                                    Field a29 = al.a(a26, "extData");
                                    if (a29 != null && al.a(a29, a27, str)) {
                                        Method a36 = al.a(a19.getClass(), "sendReq", a26.getSuperclass());
                                        if (a36 == null) {
                                            GDTLogger.e("get method sendReq() failed");
                                            i17 = 109;
                                        } else {
                                            a(i3, str, optString3, jSONObject2, str2);
                                            Object a37 = al.a(a19, a36, a27);
                                            GDTLogger.i(String.format("%s end launch %s, path = %s, result = %s, preload = %s", optString, optString2, optString3, a37, Integer.valueOf(i3)));
                                            return ((a37 instanceof Boolean) && ((Boolean) a37).booleanValue()) ? 0 : -3;
                                        }
                                    } else {
                                        GDTLogger.e("set field extData failed");
                                        i17 = 108;
                                    }
                                }
                            } else {
                                GDTLogger.e("set field userName failed");
                                i17 = 106;
                            }
                        }
                    }
                }
            }
        }
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", Integer.valueOf(i17));
        StatTracer.trackEvent(53801, 0, new com.qq.e.comm.plugin.stat.b(), cVar);
        return -2;
    }

    private static boolean a(JSONObject jSONObject, Context context) {
        if (!y.a(jSONObject)) {
            GDTLogger.e("launchInfo is empty!");
            return false;
        }
        if (TextUtils.isEmpty(jSONObject.optString("wx_appid"))) {
            GDTLogger.e("wxAppId is empty!");
            return false;
        }
        if (TextUtils.isEmpty(jSONObject.optString("username"))) {
            GDTLogger.e("userName is empty!");
            return false;
        }
        if (context != null) {
            return true;
        }
        GDTLogger.e("context is null!");
        return false;
    }

    private static String a(JSONObject jSONObject, Context context, int i3, JSONObject jSONObject2, String str, boolean z16) {
        int i16;
        if (!a(jSONObject, context)) {
            StatTracer.trackEvent(b.c(jSONObject2) ? 53311 : 53711, i3, (com.qq.e.comm.plugin.stat.b) null);
            return "";
        }
        JSONObject jSONObject3 = new JSONObject();
        String optString = jSONObject.optString("token");
        String optString2 = jSONObject.optString("ad_trace_data");
        String optString3 = jSONObject.optString("path");
        String optString4 = jSONObject.optString("username");
        try {
            jSONObject3.put("pathType", 2);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("ad_trace_data", optString2);
            jSONObject4.put("token", optString);
            String hashDeviceId = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getHashDeviceId();
            if (!TextUtils.isEmpty(hashDeviceId)) {
                jSONObject4.put("muid", hashDeviceId);
            }
            if (i3 == 3) {
                JSONObject a16 = com.qq.e.comm.plugin.base.ad.c.k.a().a(optString4, optString3);
                if (y.a(a16)) {
                    i16 = a16.optInt(VirtualAppProxy.KEY_PKG_SIZE);
                    a16.remove(VirtualAppProxy.KEY_PKG_SIZE);
                    jSONObject4.put(CoverDBCacheData.PACKAGE_INFO, a16);
                } else {
                    i16 = 0;
                }
                if (com.qq.e.comm.plugin.base.ad.c.k.a().a(jSONObject2, str)) {
                    b(i16 == 0 ? LinkReportConstant$EventId.OPENSDK_INVOKE_PACKAGE_NOT_EXIST : LinkReportConstant$EventId.OPENSDK_INVOKE_PACKAGE_EXIST, i3, b(jSONObject2, str, 3, i16, 0), z16);
                }
            }
            jSONObject3.put("invokeData", jSONObject4);
        } catch (JSONException e16) {
            GDTLogger.e(e16.getMessage());
        }
        return jSONObject3.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ba, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01bd, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(Context context, JSONObject jSONObject, String str, JSONObject jSONObject2, String str2, int i3, boolean z16) {
        String str3 = str2;
        String optString = jSONObject.optString("wx_appid");
        String optString2 = jSONObject.optString("username");
        String optString3 = jSONObject.optString("path");
        int i16 = 1;
        GDTLogger.i(String.format("%s start launch %s, path = %s, preload = %b", optString, optString2, optString3, Boolean.FALSE));
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = i3 == 2;
        String[] strArr = new String[6];
        strArr[0] = optString;
        strArr[1] = optString2;
        strArr[2] = optString3;
        strArr[3] = "0";
        strArr[4] = str;
        strArr[5] = z17 ? "true" : "false";
        Cursor query = ContactsMonitor.query(contentResolver, parse, null, null, strArr, null);
        if (z17) {
            au.a(b.c(jSONObject2) ? 53310 : 53710, 0, str3, (int) (System.currentTimeMillis() - currentTimeMillis));
        }
        while (true) {
            if (query == null || !query.moveToNext() || !z17) {
                break;
            }
            File a16 = at.a();
            if (a16 == null || !a16.exists()) {
                break;
            }
            int columnIndex = query.getColumnIndex("downloadUrl");
            String string = columnIndex >= 0 ? query.getString(columnIndex) : "";
            if (TextUtils.isEmpty(string)) {
                GDTLogger.e("wx code package download url is empty!");
                break;
            }
            int columnIndex2 = query.getColumnIndex("fileMd5");
            String string2 = columnIndex2 >= 0 ? query.getString(columnIndex2) : "";
            int columnIndex3 = query.getColumnIndex("expireTime");
            long j3 = columnIndex3 >= 0 ? query.getLong(columnIndex3) : 0L;
            int columnIndex4 = query.getColumnIndex("extraBytes");
            String string3 = columnIndex4 >= 0 ? query.getString(columnIndex4) : "";
            GDTLogger.d("fetchPkgInfo: downloadUrl = " + string + ", fileMd5 = " + string2 + ", expireTime = " + j3 + ", extraBytes = " + string3);
            if ((com.qq.e.comm.plugin.j.e.a().a(str3, "wxPreloadNetwork", NetworkType.WIFI.getPermValue()) & GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue()) <= 0) {
                GDTLogger.d("fetchPkgInfo: networkType does not satisfy");
                break;
            }
            String b16 = com.qq.e.comm.plugin.base.ad.c.k.a().b(optString2, optString3);
            if (TextUtils.isEmpty(b16)) {
                break;
            }
            if (new File(a16, b16).exists()) {
                GDTLogger.d("fetchPkgInfo: wx preload file exists");
                break;
            }
            com.qq.e.comm.plugin.i.f.a(GDTADManager.getInstance().getAppContext()).a(new h.a().c(string).a(a16).a(b16).a(), com.qq.e.comm.plugin.j.c.a(str3, "wx_download_tag", i16, i16) ? string : b16, new a(str2, jSONObject2, b16, string, string2, j3, string3, z16));
            str3 = str2;
            i16 = 1;
        }
        return 0;
    }

    public static List<JSONObject> a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a(jSONObject, (ClickInfo.a) null));
        JSONArray optJSONArray = jSONObject.optJSONArray("materials");
        if (y.a(optJSONArray)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            ClickInfo.a aVar = new ClickInfo.a();
            aVar.a(i3);
            arrayList.add(a(jSONObject, aVar));
        }
        return arrayList;
    }

    public static JSONObject a(JSONObject jSONObject, ClickInfo.a aVar) {
        String jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("wechat_ad_trace_data");
        String optString = jSONObject.optString("wxappid");
        String optString2 = jSONObject.optString("wechat_app_username");
        String b16 = i.b(jSONObject, aVar);
        String optString3 = jSONObject.optString("wechat_app_token");
        if (optJSONObject != null) {
            try {
                jSONObject2 = optJSONObject.toString();
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        } else {
            jSONObject2 = null;
        }
        jSONObject3.putOpt("ad_trace_data", jSONObject2);
        jSONObject3.putOpt("wx_appid", optString);
        jSONObject3.putOpt("username", optString2);
        jSONObject3.putOpt("path", b16);
        jSONObject3.putOpt("token", optString3);
        return jSONObject3;
    }

    private static void a(int i3, String str, String str2, JSONObject jSONObject, String str3) {
        JSONObject a16 = y.a();
        y.a(a16, "extData", str);
        y.a(a16, "path", str2);
        com.qq.e.comm.plugin.stat.b a17 = z.a(jSONObject, (JSONObject) null);
        a17.a(str3);
        a(4006068, i3, a17, a16, jSONObject);
    }

    public static void a(final int i3, final int i16, final com.qq.e.comm.plugin.stat.b bVar, final JSONObject jSONObject, JSONObject jSONObject2) {
        if (!y.a(jSONObject2) || !y.a(jSONObject)) {
            GDTLogger.e("reportWithWXParams adInfo or WXParams is null");
            return;
        }
        if (3 != i16) {
            GDTLogger.e("reportWithWXParams InvokeType is not jump type");
        } else if (!b.j(jSONObject2)) {
            GDTLogger.d("reportWithWXParams net_log_req_id is null");
        } else {
            GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.k.bb.1
                @Override // java.lang.Runnable
                public void run() {
                    com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
                    try {
                        cVar.a("opensdk_param", new String(Base64.encode(new S2SSRequest(null, JSONObject.this.toString().getBytes(), true).getPostData(), 0), 0));
                        StatTracer.trackEvent(i3, i16, bVar, cVar);
                    } catch (Throwable th5) {
                        GDTLogger.e("encode exception", th5);
                    }
                }
            });
        }
    }

    private static com.qq.e.comm.plugin.stat.b a(JSONObject jSONObject, String str, int i3) {
        return b(jSONObject, str, i3, 0L, 0);
    }
}
