package com.tencent.luggage.wxa.q7;

import android.os.Build;
import android.util.Log;
import com.tencent.luggage.wxa.m9.b;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.wo.a;
import com.tencent.luggage.wxa.yp.b;
import com.tencent.luggage.xlog.Xlog;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.xweb.XWebSdk;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f137981a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f137982b;

    /* renamed from: c, reason: collision with root package name */
    public static String f137983c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f137984d = System.currentTimeMillis();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements w.b {

        /* renamed from: a, reason: collision with root package name */
        public final Xlog f137985a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Xlog f137986b;

        public a(Xlog xlog) {
            this.f137986b = xlog;
            this.f137985a = xlog;
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(String str) {
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void appenderClose() {
            this.f137985a.appenderClose();
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void b(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logW(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void c(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logF(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void d(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logV(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void e(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logE(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void f(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logD(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(long j3, String str, String str2, String str3, int i3, int i16, long j16, long j17, String str4) {
            this.f137985a.logI(j3, str, str2, str3, i3, i16, j16, j17, str4);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public int a(long j3) {
            return this.f137985a.getLogLevel(j3);
        }

        @Override // com.tencent.luggage.wxa.tn.w.b
        public void a(long j3, boolean z16) {
            this.f137985a.appenderFlush(j3, z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.InterfaceC6963b {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f137987a = {6, 6, 0, 1, 2, 3, 4, 5};

        @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
        public boolean a(String str, int i3) {
            if (i3 >= 2 && i3 <= 7 && this.f137987a[i3] >= com.tencent.luggage.wxa.tn.w.d()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
        public void println(int i3, String str, String str2) {
            if (!a(str, i3)) {
                return;
            }
            switch (i3) {
                case 2:
                    com.tencent.luggage.wxa.tn.w.e(str, str2);
                    return;
                case 3:
                    com.tencent.luggage.wxa.tn.w.a(str, str2);
                    return;
                case 4:
                    com.tencent.luggage.wxa.tn.w.d(str, str2);
                    return;
                case 5:
                    com.tencent.luggage.wxa.tn.w.f(str, str2);
                    return;
                case 6:
                    com.tencent.luggage.wxa.tn.w.b(str, str2);
                    return;
                case 7:
                    com.tencent.luggage.wxa.tn.w.c(str, str2);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements a.InterfaceC6891a {
        @Override // com.tencent.luggage.wxa.wo.a.InterfaceC6891a
        public void d(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.a(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.wo.a.InterfaceC6891a
        public void e(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.wo.a.InterfaceC6891a
        public void i(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
        }

        @Override // com.tencent.luggage.wxa.wo.a.InterfaceC6891a
        public void w(String str, String str2, Object... objArr) {
            com.tencent.luggage.wxa.tn.w.h(str, str2, objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements b.InterfaceC6462b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Xlog f137988a;

        public e(Xlog xlog) {
            this.f137988a = xlog;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements com.tencent.luggage.wxa.k.n {
        @Override // com.tencent.luggage.wxa.k.n
        public boolean a(int i3) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void d(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.a(str, str2);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void e(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.b(str, str2);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void i(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.d(str, str2);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void w(String str, String str2) {
            com.tencent.luggage.wxa.tn.w.f(str, str2);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void a(String str, String str2, Throwable th5) {
            com.tencent.luggage.wxa.tn.w.h(str, str2, th5);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void e(String str, String str2, Throwable th5) {
            com.tencent.luggage.wxa.tn.w.b(str, str2, th5);
        }

        @Override // com.tencent.luggage.wxa.k.n
        public void i(String str, String str2, Throwable th5) {
            com.tencent.luggage.wxa.tn.w.d(str, str2, th5);
        }
    }

    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public static void a(String str) {
        Xlog xlog;
        String str2;
        ?? r152;
        if (f137981a) {
            return;
        }
        long a16 = w0.a();
        com.tencent.luggage.wxa.aa.h.g("wechatxlog");
        com.tencent.luggage.wxa.aa.h.g("stlport_shared");
        long a17 = w0.a() - a16;
        long a18 = w0.a();
        String absolutePath = b().getAbsolutePath();
        f137982b = absolutePath + "/wxa/xlog";
        f137983c = absolutePath + "/wxa/xlog/crash/";
        com.tencent.luggage.wxa.cp.x.m(f137982b);
        com.tencent.luggage.wxa.cp.x.m(f137983c);
        long a19 = w0.a() - a18;
        long a26 = w0.a();
        Locale locale = Locale.ENGLISH;
        Boolean bool = Boolean.FALSE;
        Log.i("Luggage.XLogSetup", String.format(locale, "init done nameprefix:%s debug[%b] snapshot[%b]", str, bool, Boolean.valueOf(r.a())));
        Xlog xlog2 = new Xlog();
        if (r.a()) {
            xlog = xlog2;
            str2 = "Luggage.XLogSetup";
            r152 = 1;
            xlog2.appenderOpen(0, 1, "", f137982b, str, 3);
            xlog.setConsoleLogOpen(0L, true);
        } else {
            xlog = xlog2;
            str2 = "Luggage.XLogSetup";
            r152 = 1;
            xlog.appenderOpen(1, 0, "", f137982b, str, 7);
        }
        long a27 = w0.a() - a26;
        long a28 = w0.a();
        com.tencent.luggage.wxa.tn.w.a(new a(xlog));
        com.tencent.luggage.wxa.yp.b.a(new b());
        com.tencent.luggage.wxa.wo.a.a(new c());
        com.tencent.luggage.wxa.ta.c.a(new d());
        com.tencent.luggage.wxa.m9.b.a(new e(xlog));
        com.tencent.luggage.wxa.k.f.a(new f());
        long a29 = w0.a() - a28;
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[r152] = bool;
        objArr[2] = Boolean.valueOf(r.a());
        objArr[3] = Long.valueOf(a17);
        objArr[4] = Long.valueOf(a19);
        objArr[5] = Long.valueOf(a27);
        objArr[6] = Long.valueOf(a29);
        com.tencent.luggage.wxa.tn.w.d(str2, String.format(locale, "|runProfiled|init done nameprefix:%s debug[%b] snapshot[%b], loadXlogSoCost[%d], setupXlogDirCost[%d], initializeXlogCost[%s], setLogImpCost[%d]", objArr));
        f137981a = r152;
    }

    public static File b() {
        File externalFilesDir = com.tencent.luggage.wxa.tn.z.c().getExternalFilesDir("");
        if (externalFilesDir != null) {
            Log.i("Luggage.XLogSetup", "safeGetExternalFilesDir, api get ok");
            return externalFilesDir;
        }
        try {
            File file = new File("/sdcard/Android/data/" + com.tencent.luggage.wxa.tn.z.h() + "/files/");
            file.mkdirs();
            Log.i("Luggage.XLogSetup", "safeGetExternalFilesDir, manual get ok");
            return file;
        } catch (Exception unused) {
            Log.e("Luggage.XLogSetup", "safeGetExternalFilesDir, manual get error");
            File file2 = new File("/sdcard/" + com.tencent.luggage.wxa.tn.z.h() + "/files/");
            file2.mkdirs();
            return file2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.ua.a {
        @Override // com.tencent.luggage.wxa.ua.a
        public void a(int i3, String str, String str2, Object... objArr) {
            if (i3 < a()) {
                return;
            }
            switch (i3) {
                case 2:
                    com.tencent.luggage.wxa.tn.w.g(str, str2, objArr);
                    return;
                case 3:
                    com.tencent.luggage.wxa.tn.w.a(str, str2, objArr);
                    return;
                case 4:
                    com.tencent.luggage.wxa.tn.w.d(str, str2, objArr);
                    return;
                case 5:
                    com.tencent.luggage.wxa.tn.w.h(str, str2, objArr);
                    return;
                case 6:
                    com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
                    return;
                case 7:
                    com.tencent.luggage.wxa.tn.w.b(str, str2, objArr);
                    return;
                default:
                    return;
            }
        }

        public int a() {
            int d16 = com.tencent.luggage.wxa.tn.w.d();
            if (d16 != 0) {
                if (d16 == 1) {
                    return 3;
                }
                if (d16 == 2) {
                    return 4;
                }
                if (d16 == 3) {
                    return 5;
                }
                if (d16 != 6) {
                    return 6;
                }
            }
            return 2;
        }
    }

    public static String a() {
        return StringUtils.join((Object[]) new String[]{"#client.version=" + Integer.toHexString(671103283), "#client.sdk=4.0.0", "#client.revision=ff21ec7a35922aa90e584b2bb63d1a39c25df3b8", "#client.process=" + com.tencent.luggage.wxa.tn.z.i(), "#client.buildTime=2025-04-27 19:07:38", "#client.hostAppId=" + s.d.f138074a.b(), "#client.buildNumber=143", "#xwalk.coreVersion=" + XWebSdk.getInstalledNewstVersion(com.tencent.luggage.wxa.tn.z.c())}, '\n');
    }

    public static String a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("process", com.tencent.luggage.wxa.tn.z.i());
            jSONObject.put(IProfileProtocolConst.KEY_COMPANY, Build.BRAND);
            jSONObject.put("uin", com.tencent.luggage.wxa.x7.f.f144620c.c());
            jSONObject.put("is_front", true);
            jSONObject.put("phone", com.tencent.luggage.wxa.t9.l.g());
            jSONObject.put("is_jni", com.tencent.luggage.wxa.s7.d.NATIVE.name().equals(str));
            jSONObject.put("cver", 603979777);
            jSONObject.put("c_time", currentTimeMillis / 1000);
            jSONObject.put("rev", "ff21ec7a35922aa90e584b2bb63d1a39c25df3b8");
            jSONObject.put("runtime", currentTimeMillis - f137984d);
            jSONObject.put("api_level", "android-" + Build.VERSION.SDK_INT);
            jSONObject.put("pipeline_num", 143);
            jSONObject.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.ENGLISH).format(new Date()));
            jSONObject.put(QAdLoginDefine$LoginStatus.IS_LOGIN, com.tencent.luggage.wxa.o3.l.f136139a.c());
            jSONObject.put("is_anr", com.tencent.luggage.wxa.s7.d.ANR.name().equals(str));
            jSONObject.put("client.sdkVersion", Integer.toHexString(603979777));
            jSONObject.put("client.wxVersion", Integer.toHexString(671103283));
            jSONObject.put("client.sdk", "4.0.0");
            jSONObject.put("client.buildTime", "2025-04-27 19:07:38");
            jSONObject.put("client.hostAppPkgName", com.tencent.luggage.wxa.tn.z.h());
            jSONObject.put("client.hostAppId", s.d.f138074a.b());
            jSONObject.put("xwalk.coreVersion", XWebSdk.getInstalledNewstVersion(com.tencent.luggage.wxa.tn.z.c()));
            jSONObject.put("stack", str2);
            return jSONObject.toString();
        } catch (JSONException e16) {
            throw new RuntimeException("build crash report content fail", e16);
        }
    }

    public static void a(int i3, String str, String str2, String str3) {
        Locale locale = Locale.ENGLISH;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, locale);
        if (!com.tencent.luggage.wxa.cp.x.d(f137983c)) {
            com.tencent.luggage.wxa.cp.x.m(f137983c);
        }
        String str4 = f137983c + simpleDateFormat.format(new Date()) + ".txt";
        if (!com.tencent.luggage.wxa.cp.x.d(str4)) {
            com.tencent.luggage.wxa.cp.x.a(str4);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("==================================================");
        sb5.append("\n");
        sb5.append(a());
        sb5.append('\n');
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", locale);
        sb5.append("time:");
        sb5.append(simpleDateFormat2.format(new Date()));
        sb5.append("\n");
        sb5.append("crashType:");
        sb5.append(i3);
        sb5.append("\n");
        sb5.append("errorType:");
        sb5.append(str);
        sb5.append("\n");
        sb5.append("errorMessage:");
        sb5.append(str2);
        sb5.append("\n");
        sb5.append("errorStack:");
        sb5.append(str3);
        sb5.append("\n");
        sb5.append("==================================================");
        sb5.append("\n");
        sb5.append("\n");
        String sb6 = sb5.toString();
        com.tencent.luggage.wxa.cp.x.a(str4, sb6.getBytes());
        com.tencent.luggage.wxa.tn.w.b("Luggage.XLogSetup", sb6);
        com.tencent.luggage.wxa.tn.w.c();
    }

    public static void a(String str, String str2, String str3) {
        String a16 = a(str, str2);
        if (w0.c(str3)) {
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.XLogSetup", "create crash info file");
        if (com.tencent.luggage.wxa.cp.x.d(str3)) {
            com.tencent.luggage.wxa.cp.x.c(str3);
        }
        if (com.tencent.luggage.wxa.cp.x.a(str3)) {
            com.tencent.luggage.wxa.cp.x.b(str3, a16.getBytes());
        } else {
            com.tencent.luggage.wxa.tn.w.b("Luggage.XLogSetup", "create file:%s fail", str3);
        }
    }
}
