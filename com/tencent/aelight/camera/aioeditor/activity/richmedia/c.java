package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.r;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static long f66425a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, r> f66426b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public static String f66427c = ".photo";

    /* renamed from: d, reason: collision with root package name */
    public static String f66428d = ".openCamera";

    /* renamed from: e, reason: collision with root package name */
    public static boolean f66429e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f66430f = true;

    /* renamed from: g, reason: collision with root package name */
    private static long f66431g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f66432h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static long f66433i = 0;

    public static long a(Intent intent) {
        return intent.getLongExtra("start_intent_time", 0L);
    }

    private static void b(String str, String str2, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str) && QLog.isColorLevel()) {
            QLog.d(IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, 2, str);
        }
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put("MANUFACTURER", Build.MANUFACTURER);
        hashMap2.put("MODEL", DeviceInfoMonitor.getModel());
        hashMap2.put("DEVICE_TYPE_NAME", com.tencent.mobileqq.camera.adapter.b.c().b());
        c(hashMap2, IPtvFilterUtil.OPEN_CUSTOM_CAMERA_TAG, str2);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, str2, true, 0L, 0L, hashMap2, null);
    }

    private static void c(Map<String, String> map, String str, String str2) {
        String str3 = "\u4e8b\u4ef6Code : " + str2 + "   \u4e0a\u62a5\u5185\u5bb9 ----------  \n";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str3 = (((str3 + entry.getKey()) + "   :   ") + entry.getValue()) + "\n";
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str3);
        }
    }

    public static void d(String str) {
        e(str, f66425a);
    }

    public static void e(String str, long j3) {
        if (QLog.isColorLevel()) {
            long currentTimeMillis = System.currentTimeMillis();
            QLog.d(f66427c, 2, str + ";" + (currentTimeMillis - j3));
            f66425a = currentTimeMillis;
        }
    }

    public static void f(Intent intent) {
        intent.putExtra("start_intent_time", f66425a);
    }

    public static void g() {
        b("capture photo send", StatisticCollector.CAPTURE_PHOTO_SEND, null);
    }

    public static void h() {
        b("custom photo send", StatisticCollector.CUSTOM_PHOTO_SEND, null);
    }

    public static void i() {
        b("photo taken by capture", StatisticCollector.PHOTO_TAKEN_BY_CAPTURE, null);
    }

    public static void j() {
        b("photo taken by custom", StatisticCollector.PHOTO_TAKEN_BY_CUSTOM, null);
    }

    public static void k() {
        b("system photo send", StatisticCollector.SYSTEM_PHOTO_SEND, null);
    }
}
