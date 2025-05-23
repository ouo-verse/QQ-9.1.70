package com.tencent.hlyyb.common.c;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.av.so.ResInfo;
import com.tencent.common.BuildConfig;
import com.tencent.hlyyb.downloader.g.a.g;
import com.tencent.hlyyb.downloader.g.a.h;
import com.tencent.hlyyb.downloader.g.a.j;
import com.tencent.hlyyb.downloader.h.a.c;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f114352a;

    /* renamed from: b, reason: collision with root package name */
    public static long f114353b;

    /* renamed from: c, reason: collision with root package name */
    public static String f114354c;

    /* renamed from: d, reason: collision with root package name */
    public static String f114355d;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.common.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC5815a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f114356d;

        /* compiled from: P */
        /* renamed from: com.tencent.hlyyb.common.c.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC5816a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ JSONObject f114357d;

            public RunnableC5816a(JSONObject jSONObject) {
                this.f114357d = jSONObject;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RunnableC5815a.this, (Object) jSONObject);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    try {
                        a.q(RunnableC5815a.this.f114356d, this.f114357d);
                    } catch (Throwable unused) {
                    }
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }

        public RunnableC5815a(Context context) {
            this.f114356d = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (a.h()) {
                JSONObject p16 = a.p(this.f114356d);
                long j16 = 10000;
                if (p16 != null) {
                    j3 = p16.optLong("tdm", 10000L);
                } else {
                    j3 = 10000;
                }
                if (j3 > 0) {
                    j16 = j3;
                }
                h.a().postDelayed(new RunnableC5816a(p16), j16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f114359d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f114360e;

        public b(Context context, JSONObject jSONObject) {
            this.f114359d = context;
            this.f114360e = jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) jSONObject);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    a.n(this.f114359d, this.f114360e);
                } catch (Throwable unused) {
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public static String a(Context context, int i3) {
        int contentLength;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(b(context, context.getPackageName(), i3)).openConnection();
            httpsURLConnection.setConnectTimeout(3000);
            httpsURLConnection.setReadTimeout(3000);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.connect();
            if (httpsURLConnection.getResponseCode() == 200 && (contentLength = httpsURLConnection.getContentLength()) > 0) {
                byte[] bArr = new byte[contentLength];
                new DataInputStream(httpsURLConnection.getInputStream()).readFully(bArr);
                return new String(bArr);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String b(Context context, String str, int i3) {
        try {
            return "https://qappcenterv6.3g.qq.com/download/qd" + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + "pkg_name=" + str + "&model=" + f114355d + "&brand=" + f114354c + "&sdk_version_code=4&code_version=" + i3 + "&os_sdk_int=" + Build.VERSION.SDK_INT + "&pid=" + g.f(g.c(c.a(context), 3));
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            for (char c16 : str.toCharArray()) {
                if (c16 > ' ' && c16 != '/' && c16 != '_' && c16 != '&' && c16 != '|' && c16 != '-' && c16 != '.' && c16 != ':' && c16 != '$') {
                    sb5.append(c16);
                }
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void f(String str, String str2, String str3) {
        BufferedOutputStream bufferedOutputStream;
        byte[] decode;
        File file;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            decode = Base64.decode(str2, 0);
            file = new File(str);
            file.getParentFile().mkdirs();
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
            bufferedOutputStream = null;
        }
        if (!str3.equalsIgnoreCase(g.g(decode))) {
            return;
        }
        file.createNewFile();
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            try {
                bufferedOutputStream.write(decode);
            } catch (Throwable unused2) {
                if (bufferedOutputStream == null) {
                    return;
                }
                bufferedOutputStream.close();
            }
            bufferedOutputStream.close();
        } catch (Throwable unused3) {
        }
    }

    public static void g(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return;
        }
        try {
            if (jSONObject2.has("retCode")) {
                jSONObject.put("retCode", jSONObject2.optInt("retCode"));
            }
            if (jSONObject2.has("switchOn")) {
                jSONObject.put(ResInfo.RES_TYPE_SO, jSONObject2.optBoolean("switchOn"));
            }
            if (jSONObject2.has("pullInterval")) {
                jSONObject.put("pi", jSONObject2.optInt("pullInterval"));
            }
            if (jSONObject2.has("limitPerDay")) {
                jSONObject.put("lpd", jSONObject2.optInt("limitPerDay"));
            }
            if (jSONObject2.has("taskDelayMs")) {
                jSONObject.put("tdm", jSONObject2.optLong("taskDelayMs", 10000L));
            }
            int optInt = jSONObject2.optInt("codeVersionCode");
            String optString = jSONObject2.optString("code");
            jSONObject.put("cvc", optInt);
            jSONObject.put("code", optString);
            jSONObject.put("bbl", jSONObject2.optString("brandBlackList", "{\"a\":\"huawei|honor|xiaomi\",\"b\":\"\",\"c\":\"\"}"));
            jSONObject.put("mbl", jSONObject2.optString("modelBlackList", "PGT-AN00;KOZ-AL40"));
            jSONObject.put("aso", jSONObject2.optBoolean("aso", true));
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ boolean h() {
        return o();
    }

    public static String i(Context context) {
        String m3;
        try {
            if (!TextUtils.isEmpty(f114352a)) {
                return f114352a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                m3 = Application.getProcessName();
            } else {
                m3 = m(context);
            }
            f114352a = m3;
            return m3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void j() {
        try {
            if (TextUtils.isEmpty(f114355d)) {
                f114355d = DeviceInfoMonitor.getModel();
            }
            if (TextUtils.isEmpty(f114354c)) {
                f114354c = Build.BRAND;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static String m(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static synchronized void n(Context context, JSONObject jSONObject) {
        synchronized (a.class) {
            if (context == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f114353b) < MiniBoxNoticeInfo.MIN_5) {
                return;
            }
            f114353b = currentTimeMillis;
            j();
            String str = context.getFilesDir().getAbsolutePath() + "/TMAssistantSDK";
            String c16 = c(i(context));
            if (!TextUtils.isEmpty(c16)) {
                str = str + "/" + c16;
            }
            String str2 = str + "/qd/E0BDA8197";
            int i3 = 0;
            int optInt = jSONObject.optInt("cvc", 0);
            if (optInt != 0 && !l(str2)) {
                try {
                    jSONObject.put("cvc", 0);
                } catch (Throwable unused) {
                }
            } else {
                i3 = optInt;
            }
            String a16 = a(context, i3);
            String str3 = null;
            int i16 = -1;
            try {
                if (!TextUtils.isEmpty(a16)) {
                    JSONObject jSONObject2 = new JSONObject(a16);
                    if (jSONObject2.has("retCode")) {
                        i16 = jSONObject2.optInt("retCode");
                    }
                    if (jSONObject2.has("codeDigest")) {
                        str3 = jSONObject2.optString("codeDigest");
                    }
                    if (jSONObject2.has("autoDeleteEnabled")) {
                        g.h(context, jSONObject2.optBoolean("autoDeleteEnabled"));
                    }
                    g(jSONObject, jSONObject2);
                }
            } catch (Throwable unused2) {
            }
            if (!TextUtils.isEmpty(str3) && !"d41d8cd98f00b204e9800998ecf8427e".equalsIgnoreCase(str3)) {
                f(str2, jSONObject.optString("code"), str3);
                try {
                    try {
                        jSONObject.remove("code");
                    } catch (Throwable unused3) {
                    }
                } catch (Throwable unused4) {
                    jSONObject.put("code", "");
                }
                s(context, jSONObject);
                if (i16 == -17) {
                    com.tencent.hlyyb.downloader.h.a.b.a(context, 1000);
                    return;
                }
                try {
                    jSONObject.put("phoneBrand", f114354c);
                    jSONObject.put("phoneModel", f114355d);
                } catch (Throwable unused5) {
                }
                if (!TextUtils.isEmpty(str2)) {
                    c.c(context, jSONObject, str2, str3);
                }
                return;
            }
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused6) {
            }
            if ((i16 == -15 || i16 == -16) && TextUtils.isEmpty(jSONObject.optString("code"))) {
                try {
                    jSONObject.remove("code");
                } catch (Throwable unused7) {
                }
                s(context, jSONObject);
                j.b().g(context, jSONObject);
            }
        }
    }

    public static boolean o() {
        try {
            Field declaredField = BuildConfig.class.getDeclaredField("DEBUG");
            declaredField.setAccessible(true);
            if (!((Boolean) declaredField.get(null)).booleanValue()) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static JSONObject p(Context context) {
        if (context == null) {
            return new JSONObject();
        }
        try {
            String string = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0).getString("key_qddownloader_cs", "");
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void q(Context context, JSONObject jSONObject) {
        if (context == null) {
            return;
        }
        try {
            new BaseThread(new b(context, jSONObject)).start();
        } catch (Throwable unused) {
        }
    }

    public static void r(Context context) {
        h.a().post(new RunnableC5815a(context));
    }

    public static void s(Context context, JSONObject jSONObject) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0).edit();
            edit.putString("key_qddownloader_cs", jSONObject.toString());
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
