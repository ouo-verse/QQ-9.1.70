package com.qzone.app;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f44483a = false;

    /* renamed from: b, reason: collision with root package name */
    private static long f44484b;

    /* renamed from: c, reason: collision with root package name */
    private static long f44485c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f44486d;

    private static long a(int i3, int i16, int i17, int i18, int i19, int i26) {
        Calendar calendar = Calendar.getInstance();
        if (i3 > 0) {
            calendar.set(1, i3);
        }
        if (i16 > 0) {
            calendar.set(2, i16);
        }
        if (i17 > 0) {
            calendar.set(5, i17);
        }
        calendar.set(11, i18);
        calendar.set(12, i19);
        calendar.set(13, i26);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean b() {
        return c() && f44486d;
    }

    private static synchronized boolean c() {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!d(currentTimeMillis)) {
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_IMAGE_DECODING_RES_REPORT_SAMPLE, 100);
                long j3 = currentTimeMillis / 86400000;
                long longAccountUin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
                if (longAccountUin == 0) {
                    return false;
                }
                if (config == 0) {
                    f44483a = false;
                } else {
                    long j16 = config;
                    int i3 = (int) (j3 % j16);
                    f44483a = ((long) i3) == longAccountUin % j16;
                    if (com.qzone.proxy.feedcomponent.util.j.g()) {
                        com.qzone.proxy.feedcomponent.util.j.a("ImageDecodingReport", 4, "----\u91c7\u6837\u7684\u5c3e\u6570\uff1a " + i3);
                    }
                }
                f44485c = a(0, 0, 0, 0, 0, 0);
                f44484b = a(0, 0, 0, 24, 0, 0);
                String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
                if (!TextUtils.isEmpty(account) && account.length() > 2 && account.charAt(0) == account.charAt(1)) {
                    f44486d = true;
                }
            }
            return f44483a;
        }
    }

    private static boolean d(long j3) {
        long j16 = f44485c;
        if (j16 != 0) {
            long j17 = f44484b;
            if (j17 != 0 && j3 >= j16 && j3 < j17) {
                return true;
            }
        }
        return false;
    }

    public static void e(int i3) {
        if (c()) {
            if (com.qzone.proxy.feedcomponent.util.j.g()) {
                com.qzone.proxy.feedcomponent.util.j.a("ImageDecodingReport", 2, "----need to report animation drawable size.");
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("size", String.valueOf(i3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "qzoneAnimationDrawableSize", true, 0L, 0L, hashMap, "");
        }
    }

    public static void f(int i3, float f16, float f17) {
        if (c()) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("taskType", String.valueOf(i3));
            if (i3 == 1) {
                hashMap.put("decodeFrameRate_serial", String.valueOf(f16));
            } else if (i3 == 2) {
                hashMap.put("decodeFrameRate_parallel", String.valueOf(f16));
            }
            hashMap.put("maxFrameRate", String.valueOf(f17));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "qzoneGifDecodeFrameRate", true, 0L, 0L, hashMap, "");
        }
    }

    public static void g(String str, String str2, long j3, boolean z16, long j16, int i3) {
        if (c()) {
            if (com.qzone.proxy.feedcomponent.util.j.g()) {
                com.qzone.proxy.feedcomponent.util.j.a("ImageDecodingReport", 2, "----need to report image decoding result.");
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("image_type", str);
            hashMap.put("image_url", str2);
            hashMap.put("file_length", String.valueOf(j3));
            hashMap.put("param_FailCode", String.valueOf(i3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "qzoneImageDecodingRes", z16, j16, 0L, hashMap, "");
        }
    }
}
