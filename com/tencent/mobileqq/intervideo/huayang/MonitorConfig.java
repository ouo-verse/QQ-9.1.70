package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MonitorConfig {

    /* renamed from: i, reason: collision with root package name */
    public static Map<String, MonitorConfig> f238245i = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f238246a;

    /* renamed from: b, reason: collision with root package name */
    public int f238247b;

    /* renamed from: c, reason: collision with root package name */
    public int f238248c;

    /* renamed from: d, reason: collision with root package name */
    public int f238249d;

    /* renamed from: e, reason: collision with root package name */
    public int f238250e;

    /* renamed from: f, reason: collision with root package name */
    public int f238251f;

    /* renamed from: g, reason: collision with root package name */
    public int f238252g;

    /* renamed from: h, reason: collision with root package name */
    public int f238253h;

    public static void a(Context context, String str) {
        if (f238245i.get(str) != null) {
            return;
        }
        String string = context.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).getString("pre_monitor" + str, null);
        if (string != null) {
            b(str, string);
        }
    }

    private static void b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            MonitorConfig monitorConfig = new MonitorConfig();
            monitorConfig.f238246a = jSONObject.optInt("startupId");
            monitorConfig.f238247b = jSONObject.optInt("downloadSucId");
            monitorConfig.f238248c = jSONObject.optInt("downloadFailId");
            monitorConfig.f238249d = jSONObject.optInt("loadSucId");
            monitorConfig.f238250e = jSONObject.optInt("loadFailId");
            monitorConfig.f238251f = jSONObject.optInt("startSucId");
            monitorConfig.f238252g = jSONObject.optInt("firstUserId");
            monitorConfig.f238253h = jSONObject.optInt("exitId");
            f238245i.put(str, monitorConfig);
            if (QLog.isColorLevel()) {
                QLog.d("MonitorConfig", 2, str + monitorConfig);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("MonitorConfig", 2, "pareMonitorConfig exception :" + th5);
            }
        }
    }

    public static void c(final Context context, final String str) {
        if (f238245i.get(str) != null) {
            Monitor.b(String.valueOf(f238245i.get(str).f238246a));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MonitorConfig", 2, "\u6ca1\u6709\u627e\u5230\u5339\u914d\u7684monitor\u79bb\u7ebf\u914d\u7f6e\u6587\u4ef6\uff0c\u91cd\u65b0\u62c9\u53d6\u4e00\u6b21");
        }
        Monitor.b("3235982");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1
            @Override // java.lang.Runnable
            public void run() {
                MonitorConfig.a(context, str);
                if (MonitorConfig.f238245i.get(str) != null) {
                    Monitor.b(String.valueOf(MonitorConfig.f238245i.get(str).f238246a));
                } else {
                    Monitor.b("3235983");
                }
            }
        }, 1500L);
    }

    public static void d(Context context, String str, String str2) {
        if (f238245i.get(str) != null || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getApplicationContext().getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit().putString("pre_monitor" + str, str2).commit();
        b(str, str2);
    }
}
