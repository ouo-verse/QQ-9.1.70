package com.tencent.hlyyb.downloader.g.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static String f114694a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f114695b;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f114696d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f114697e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f114698f;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f114699h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Map f114700i;

        public a(Context context, String str, String str2, int i3, Map map) {
            this.f114696d = context;
            this.f114697e = str;
            this.f114698f = str2;
            this.f114699h = i3;
            this.f114700i = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, str2, Integer.valueOf(i3), map);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                k.n(this.f114696d, this.f114697e, this.f114698f, this.f114699h, this.f114700i);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public static int a(Context context) {
        int i3;
        if (f114695b != 0) {
            return f114695b;
        }
        PackageInfo c16 = c(context, "com.tencent.mobileqq");
        if (c16 != null) {
            i3 = c16.versionCode;
        } else {
            i3 = -1;
        }
        f114695b = i3;
        return i3;
    }

    public static int b(String str, String str2) {
        try {
            return k(str, str2);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static synchronized PackageInfo c(Context context, String str) {
        synchronized (k.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        if (packageManager != null) {
                            return InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
                        }
                    } catch (Throwable unused) {
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public static c d(Context context, d dVar) {
        try {
            c cVar = new c();
            if (context != null && dVar != null) {
                if (!dVar.f114663a) {
                    cVar.f114660a = false;
                    cVar.f114661b = 8;
                    return cVar;
                }
                if (dVar.f114665c <= 0) {
                    cVar.f114660a = false;
                    cVar.f114661b = 9;
                    return cVar;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0);
                int i3 = sharedPreferences.getInt("key_qddownloader_itt", 0);
                long j3 = sharedPreferences.getLong("key_qddownloader_pit", 0L);
                if (!i(j3)) {
                    i3 = 0;
                }
                cVar.f114662c = String.valueOf(i3);
                if (i3 >= dVar.f114665c) {
                    cVar.f114660a = false;
                    cVar.f114661b = 10;
                    return cVar;
                }
                if (Math.abs(System.currentTimeMillis() - j3) <= dVar.f114664b * 1000) {
                    cVar.f114660a = false;
                    cVar.f114661b = 11;
                    return cVar;
                }
                cVar.f114660a = true;
                cVar.f114661b = 0;
                return cVar;
            }
            cVar.f114660a = false;
            cVar.f114661b = 7;
            return cVar;
        } catch (Throwable unused) {
            c cVar2 = new c();
            cVar2.f114660a = true;
            cVar2.f114661b = 0;
            return cVar2;
        }
    }

    public static String e() {
        Object invoke;
        try {
            Method declaredMethod = QimeiSDK.class.getDeclaredMethod("getInstance", String.class);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, "0S200MNJT807V3GE");
        } catch (Throwable unused) {
        }
        if (invoke == null) {
            return "";
        }
        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getQimei", new Class[0]);
        declaredMethod2.setAccessible(true);
        Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
        if (invoke2 == null) {
            return "";
        }
        Method declaredMethod3 = invoke2.getClass().getDeclaredMethod("getQimei36", new Class[0]);
        declaredMethod3.setAccessible(true);
        Object invoke3 = declaredMethod3.invoke(invoke2, new Object[0]);
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        Method declaredMethod4 = invoke2.getClass().getDeclaredMethod("getQimei16", new Class[0]);
        declaredMethod4.setAccessible(true);
        Object invoke4 = declaredMethod4.invoke(invoke2, new Object[0]);
        if (invoke4 instanceof String) {
            return (String) invoke4;
        }
        return "";
    }

    public static String f(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            if (map.isEmpty()) {
                return "";
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    arrayList.add(key + ":" + value);
                }
            }
            if (arrayList.isEmpty()) {
                return "";
            }
            return TextUtils.join(";", arrayList);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void g(Context context, String str, int i3, Map<String, String> map) {
        try {
            r(context, "pull_start", str, i3, map);
        } catch (Throwable unused) {
        }
    }

    public static boolean i(long j3) {
        if (j3 <= 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j3));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(System.currentTimeMillis()));
        if (calendar.get(1) != calendar2.get(1) || calendar2.get(6) != calendar.get(6)) {
            return false;
        }
        return true;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String a16 = e.a();
        if (TextUtils.isEmpty(a16) || !str.contains(a16)) {
            return true;
        }
        return false;
    }

    public static int k(String str, String str2) {
        Class<?> cls = Class.forName(str);
        Field declaredField = cls.getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.getInt(cls);
    }

    public static String l(Context context) {
        String str;
        String str2 = f114694a;
        if (str2 != null) {
            return str2;
        }
        if (context == null) {
            return "";
        }
        try {
            str = e();
            try {
                if (!TextUtils.isEmpty(str)) {
                    f114694a = str;
                    q(context, str);
                    return str;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = p(context);
                if (!TextUtils.isEmpty(str)) {
                    f114694a = str;
                    return str;
                }
            }
        } catch (Throwable unused3) {
        }
        try {
            if (TextUtils.isEmpty(str)) {
                String uuid = UUID.randomUUID().toString();
                f114694a = uuid;
                q(context, uuid);
                return f114694a;
            }
        } catch (Throwable unused4) {
        }
        return "";
    }

    public static void m(Context context, String str, int i3, Map<String, String> map) {
        try {
            r(context, "skip_pull", str, i3, map);
        } catch (Throwable unused) {
        }
    }

    public static void n(Context context, String str, String str2, int i3, Map<String, String> map) {
        String str3;
        String str4;
        ApplicationInfo applicationInfo;
        if (context == null) {
            str3 = "";
        } else {
            try {
                str3 = context.getPackageName();
            } catch (Throwable unused) {
                str3 = "";
            }
        }
        try {
            try {
                if (context != null) {
                    try {
                        applicationInfo = context.getApplicationInfo();
                    } catch (Throwable unused2) {
                    }
                    if (applicationInfo != null) {
                        str4 = String.valueOf(applicationInfo.targetSdkVersion);
                        String l3 = l(context);
                        int s16 = s(context);
                        int a16 = a(context);
                        String f16 = f(map);
                        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://qappcenterv6.3g.qq.com/report/qd?data=" + str3 + "|" + str + "|" + l3 + "|-2|1|" + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + Build.VERSION.SDK_INT + "|" + str4 + "|false||" + s16 + "|" + a16 + "|-1|-1|" + str2 + "|" + i3 + "|" + f16 + ContainerUtils.FIELD_DELIMITER + "pid=" + g.f(g.c(com.tencent.hlyyb.downloader.h.a.c.a(context), 3))).openConnection();
                        httpsURLConnection.setConnectTimeout(3000);
                        httpsURLConnection.setReadTimeout(3000);
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.connect();
                        httpsURLConnection.getResponseCode();
                        return;
                    }
                }
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL("https://qappcenterv6.3g.qq.com/report/qd?data=" + str3 + "|" + str + "|" + l3 + "|-2|1|" + Build.BRAND + "|" + DeviceInfoMonitor.getModel() + "|" + Build.VERSION.SDK_INT + "|" + str4 + "|false||" + s16 + "|" + a16 + "|-1|-1|" + str2 + "|" + i3 + "|" + f16 + ContainerUtils.FIELD_DELIMITER + "pid=" + g.f(g.c(com.tencent.hlyyb.downloader.h.a.c.a(context), 3))).openConnection();
                httpsURLConnection2.setConnectTimeout(3000);
                httpsURLConnection2.setReadTimeout(3000);
                httpsURLConnection2.setUseCaches(false);
                httpsURLConnection2.connect();
                httpsURLConnection2.getResponseCode();
                return;
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
            String l36 = l(context);
            int s162 = s(context);
            int a162 = a(context);
            String f162 = f(map);
        } catch (Throwable unused3) {
            return;
        }
        str4 = "";
    }

    public static boolean o(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    PackageManager packageManager = context.getPackageManager();
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(SDKConst.SELF_PACKAGENAME, str));
                    List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(packageManager, intent, 0);
                    if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                        Iterator<ResolveInfo> it = queryIntentServices.iterator();
                        if (it.hasNext()) {
                            return it.next().serviceInfo.enabled;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String p(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0);
            if (sharedPreferences == null) {
                return "";
            }
            return sharedPreferences.getString("key_qddownloader_uid", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void q(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            if (TextUtils.isEmpty(str) || (sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0)) == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            edit.putString("key_qddownloader_uid", str);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void r(Context context, String str, String str2, int i3, Map<String, String> map) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a aVar = new a(context, str, str2, i3, map);
            Handler e16 = h.e();
            if (e16 != null) {
                e16.post(aVar);
                return;
            } else {
                new BaseThread(aVar).start();
                return;
            }
        }
        n(context, str, str2, i3, map);
    }

    public static int s(Context context) {
        int a16 = g.a(context);
        if (a16 <= 0) {
            return -1;
        }
        return a16;
    }

    public static boolean t(Context context) {
        return o(context, "com.live.sync.YYBLiveAuthService");
    }

    public static boolean u(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return o(context, "com.tencent.assistant.syscomponent.MediaRouteProviderService2");
        }
        return false;
    }

    public static int v(Context context) {
        int i3 = 0;
        if (context == null) {
            return 0;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("TMAssistantSDKSharedPreferenceTemp", 0);
            int i16 = sharedPreferences.getInt("key_qddownloader_itt", 0);
            if (!i(sharedPreferences.getLong("key_qddownloader_pit", 0L))) {
                i16 = 0;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            i3 = i16 + 1;
            edit.putInt("key_qddownloader_itt", i3);
            edit.putLong("key_qddownloader_pit", System.currentTimeMillis());
            edit.apply();
            return i3;
        } catch (Throwable unused) {
            return i3;
        }
    }
}
